package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.smtt.utils.n;
import com.tencent.util.AbiUtil;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DexLoader {
    private static final String TAG = "TBSDexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
    private static String appCustomizedVersionName = null;
    static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;
    private static final String CHROMIUM_PREFIX = "org.chromium";
    private static final String ANDROIDX_PREFIX = "androidx";
    private static final String TAF_PREFIX = "com.taf";
    private static final String CHROMIUM_J_N = "J.N";
    private static String[] mPrivatePrefix = {CHROMIUM_PREFIX, ANDROIDX_PREFIX, TAF_PREFIX, CHROMIUM_J_N};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        @Override // java.lang.ClassLoader
        protected Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
            ClassLoader parent;
            if (str != null) {
                String[] strArr = DexLoader.mPrivatePrefix;
                int length = strArr.length;
                boolean z17 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (str.startsWith(strArr[i3])) {
                        z17 = true;
                        break;
                    }
                    i3++;
                }
                if (!z17) {
                    return super.loadClass(str, z16);
                }
                Class<?> findLoadedClass = findLoadedClass(str);
                if (findLoadedClass == null) {
                    try {
                        findLoadedClass = findClass(str);
                    } catch (ClassNotFoundException unused) {
                    }
                    if (findLoadedClass == null && (parent = getParent()) != null) {
                        return parent.loadClass(str);
                    }
                    return findLoadedClass;
                }
                return findLoadedClass;
            }
            return super.loadClass(str, z16);
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    private static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        tryDeleteDexOatBeforeLoad(context, str);
        new File(str).setReadOnly();
        if (shouldUseTbsCorePrivateClassLoader(str)) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                str = getPrivateDexFilePath(str, applicationInfo.targetSdkVersion);
            }
            Log.i(TAG, "[privateLoader] start load dex");
            tryDeleteDexOatBeforeLoad(context, str);
            TbsCorePrivateClassLoader tbsCorePrivateClassLoader = new TbsCorePrivateClassLoader(str, str2, str3, classLoader);
            Log.i(TAG, "[privateLoader] finish load dex");
            return tbsCorePrivateClassLoader;
        }
        if (Build.VERSION.SDK_INT <= 25 && mUseSpeedyClassLoader) {
            Log.d("dexloader", "async odex...DexClassLoaderProvider.createDexClassLoader");
            try {
                return DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context);
            } catch (Throwable unused) {
                return new DexClassLoader(str, str2, str3, classLoader);
            }
        }
        Log.i(TAG, "[standardLoader] start load dex");
        DexClassLoader dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
        Log.i(TAG, "[standardLoader] finish load dex");
        return dexClassLoader;
    }

    public static void delete(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                delete(file2);
            }
            file.delete();
        }
    }

    public static String getFileNameNoEx(String str) {
        int lastIndexOf;
        if (str != null && str.length() > 0 && (lastIndexOf = str.lastIndexOf(46)) > -1 && lastIndexOf < str.length()) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String getPrivateDexFilePath(String str, int i3) {
        BufferedReader bufferedReader;
        if (Build.VERSION.SDK_INT >= 29 && i3 >= 29 && str != null) {
            Log.i(TAG, "using private classloader and os-ver up to 29.");
            File file = new File(str);
            File file2 = new File(file.getParent(), file.getName().replace(".", ""));
            if (!file2.exists()) {
                InputStreamReader inputStreamReader = null;
                try {
                    InputStreamReader inputStreamReader2 = new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "ln -s " + str + " " + file2.getAbsolutePath()).getInputStream());
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2);
                        do {
                            try {
                            } catch (Throwable th5) {
                                th = th5;
                                inputStreamReader = inputStreamReader2;
                                try {
                                    Log.w("[TBS]", "create PrivateDex failed : " + th);
                                    return str;
                                } finally {
                                    closeStream(bufferedReader);
                                    closeStream(inputStreamReader);
                                }
                            }
                        } while (bufferedReader.readLine() != null);
                        closeStream(bufferedReader);
                        closeStream(inputStreamReader2);
                        if (!file2.exists()) {
                            Log.w("[TBS]", "PrivateDex not exist, after ln -s " + str);
                            return str;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedReader = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    bufferedReader = null;
                }
            }
            return file2.getAbsolutePath();
        }
        return str;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Log.d(TAG, "initTbsSettings - " + map);
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                Object obj2 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj2).booleanValue();
                }
                Object obj3 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj3).booleanValue();
                }
                Object obj4 = map.get(TbsCoreSettings.TBS_SETTINGS_PRIVATE_CLASS_LIST);
                if (obj4 instanceof String) {
                    mPrivatePrefix = ((String) obj4).split(";");
                    Log.i(TAG, "PrivateClassPrefix: " + ((String) obj4));
                }
                Object obj5 = map.get(TbsCoreSettings.TBS_APP_VERSION_NAME_CUSTOMIZED);
                if (obj5 instanceof String) {
                    appCustomizedVersionName = (String) obj5;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        if (!mUseTbsCorePrivateClassLoader) {
            return false;
        }
        if (!str.contains(TBS_FUSION_DEX) && !str.contains(TBS_WEBVIEW_DEX)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:3|(4:4|5|(1:9)|10)|(4:17|(1:22)|19|20)|23|25|26|(3:48|49|(2:51|(5:53|32|(0)|19|20)))|28|29|30|31|32|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x023c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0247, code lost:
    
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x023a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0241, code lost:
    
        r13 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0244, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0245, code lost:
    
        r20 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x023e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x023f, code lost:
    
        r20 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x025b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void tryDeleteDexOatBeforeLoad(Context context, String str) {
        n nVar;
        int i3;
        String string;
        String string2;
        int i16;
        String str2;
        String str3;
        n nVar2;
        if (Build.VERSION.SDK_INT >= 29) {
            String str4 = str + "_code";
            String str5 = str + ThemeConstants.THEME_DIY_BG_NAME_SUFFIX;
            String str6 = str + "_display";
            SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_oat_status", 0);
            File file = new File(str);
            File file2 = new File(context.getDir("tbs", 0), "core_private");
            try {
                i3 = sharedPreferences.getInt(str4, -1);
                string = sharedPreferences.getString(str5, "");
                string2 = sharedPreferences.getString(str6, "");
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
                i16 = packageInfo.versionCode;
                str2 = packageInfo.versionName;
                String str7 = appCustomizedVersionName;
                if (str7 != null && !"".equals(str7)) {
                    str2 = appCustomizedVersionName;
                }
                str3 = Build.DISPLAY;
                Log.i(TAG, "createDexClassLoader,old VerisonCode=" + string + ";newVersionCode=" + i16 + "oldVersionName" + string + ";newVersionName+" + str2 + "oldDisplay" + string2 + ";newDisplay=" + str3);
            } catch (Exception e16) {
                e = e16;
                nVar = null;
            } catch (Throwable th5) {
                th = th5;
                nVar = null;
            }
            if (i16 == i3 && str2.equals(string) && str3.equals(string2)) {
                nVar = null;
                if (nVar == null) {
                    return;
                }
                nVar.e();
            }
            Log.i(TAG, "version updated! clear oat file");
            n nVar3 = new n(file2, file.getName() + "_loading.lock");
            nVar3.b();
            int i17 = sharedPreferences.getInt(str4, -1);
            String string3 = sharedPreferences.getString(str5, "");
            String string4 = sharedPreferences.getString(str6, "");
            if (i16 == i17) {
                try {
                } catch (Exception e17) {
                    e = e17;
                    nVar = nVar3;
                    try {
                        e.printStackTrace();
                        if (nVar == null) {
                        }
                        nVar.e();
                    } catch (Throwable th6) {
                        th = th6;
                        if (nVar != null) {
                            nVar.e();
                        }
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    nVar = nVar3;
                    if (nVar != null) {
                    }
                    throw th;
                }
                if (str2.equals(string3)) {
                    if (str3.equals(string4)) {
                        nVar2 = nVar3;
                        nVar = nVar2;
                        if (nVar == null) {
                        }
                        nVar.e();
                    }
                }
            }
            File file3 = new File(file.getParent(), "oat");
            String fileNameNoEx = getFileNameNoEx(file.getName());
            File file4 = new File(file3, file.getName() + ".prof");
            File file5 = new File(file3, file.getName() + ".cur.prof");
            File file6 = new File(file3, AbiUtil.ARM);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fileNameNoEx);
            nVar2 = nVar3;
            sb5.append(".odex");
            File file7 = new File(file6, sb5.toString());
            File file8 = new File(file6, fileNameNoEx + ".vdex");
            File file9 = new File(file3, ResourceAttributes.HostArchValues.ARM64);
            File file10 = new File(file9, fileNameNoEx + ".odex");
            File file11 = new File(file9, fileNameNoEx + ".vdex");
            delete(file4);
            delete(file5);
            delete(file7);
            delete(file8);
            delete(file10);
            delete(file11);
            Log.i(TAG, "clear file:" + file4 + file5 + file7 + file8 + file10 + file11);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str5, str2);
            edit.putInt(str4, i16);
            edit.putString(str6, str3);
            edit.apply();
            nVar = nVar2;
            if (nVar == null) {
            }
            nVar.e();
        }
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object getStaticField(String str, String str2) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable th5) {
            Log.e(getClass().getSimpleName(), "'" + str + "' get field '" + str2 + "' failed", th5);
            return null;
        }
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable th5) {
            Log.e(getClass().getSimpleName(), "'" + str + "' invoke method '" + str2 + "' failed", th5);
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th5) {
            if (str2 != null && str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                Log.e(getClass().getSimpleName(), "'" + str + "' invoke static method '" + str2 + "' failed", th5);
                return th5;
            }
            Log.i(getClass().getSimpleName(), "'" + str + "' invoke static method '" + str2 + "' failed", th5);
            return null;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable th5) {
            Log.e(getClass().getSimpleName(), "loadClass '" + str + "' failed", th5);
            return null;
        }
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable th5) {
            Log.e(getClass().getSimpleName(), "create " + str + " instance failed", th5);
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable th5) {
            Log.e(getClass().getSimpleName(), "'" + str + "' set field '" + str2 + "' failed", th5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.ClassLoader] */
    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        initTbsSettings(map);
        DexClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        DexClassLoader classLoader = callingClassLoader == 0 ? context.getClassLoader() : callingClassLoader;
        Log.d("dexloader", "Set base classLoader for DexClassLoader: " + classLoader);
        DexClassLoader dexClassLoader = classLoader;
        for (String str3 : strArr) {
            dexClassLoader = createDexClassLoader(str3, str2, str, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th5) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                Log.e(getClass().getSimpleName(), "'newInstance " + str + " failed", th5);
                return th5;
            }
            Log.e(getClass().getSimpleName(), "create '" + str + "' instance failed", th5);
            return null;
        }
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this((String) null, context, strArr, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.ClassLoader] */
    public DexLoader(Context context, String[] strArr, String str, String str2) {
        ?? classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        str3 = TextUtils.isEmpty(str2) ? str3 : str3 + File.pathSeparator + str2;
        DexClassLoader dexClassLoader = classLoader;
        for (String str4 : strArr) {
            dexClassLoader = createDexClassLoader(str4, str, str3, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        DexClassLoader classLoader = dexLoader.getClassLoader();
        for (String str2 : strArr) {
            classLoader = createDexClassLoader(str2, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }
}
