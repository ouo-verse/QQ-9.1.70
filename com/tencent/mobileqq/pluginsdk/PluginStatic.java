package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoDexClassLoader;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes16.dex */
public abstract class PluginStatic {
    static IPatchRedirector $redirector_ = null;
    static final String CONTAINER_PACKAGE_NAME = "com.tencent.mobileqq";
    public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";

    @Deprecated
    public static final String PARAM_CLEAR_TOP = "cleartop";
    public static final String PARAM_EXTRA_INFO = "pluginsdk_extraInfo";
    static final String PARAM_IS_IN_PLUGIN = "pluginsdk_IsPluginActivity";
    public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
    public static final String PARAM_LAUNCH_SERVICE = "pluginsdk_launchService";
    public static final String PARAM_PATH = "pluginsdk_pluginpath";
    public static final String PARAM_PLUGIN_GESTURELOCK = "param_plugin_gesturelock";
    public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
    public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
    public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
    public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
    public static final String PARAM_UIN = "pluginsdk_selfuin";
    public static final String PARAM_USE_QQ_RESOURCES = "userQqResources";
    public static final String PARAM_USE_SKIN_ENGINE = "useSkinEngine";
    public static final int USER_QQ_RESOURCES_BOTH = 2;
    public static final int USER_QQ_RESOURCES_NO = -1;
    public static final int USER_QQ_RESOURCES_YES = 1;
    static final ConcurrentHashMap<String, DexClassLoader> sClassLoaderMap;
    static final ConcurrentHashMap<String, Long> sClassLoaderStartTimeMap;
    private static ArrayList<WeakReference<IPluginActivity>> sInstances;
    private static final HashMap<String, IPluginLife> sLife;
    static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap;

    /* loaded from: classes16.dex */
    public interface IPluginLife {
        void onLoad();

        @Deprecated
        void onUnload();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14959);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sLife = new HashMap<>();
        sClassLoaderMap = new ConcurrentHashMap<>();
        sPackageInfoMap = new ConcurrentHashMap<>();
        sClassLoaderStartTimeMap = new ConcurrentHashMap<>();
        sInstances = new ArrayList<>();
    }

    public PluginStatic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void add(IPluginActivity iPluginActivity) {
        updateReference();
        synchronized (sInstances) {
            sInstances.add(new WeakReference<>(iPluginActivity));
        }
    }

    public static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i3 = 0;
        for (byte b16 : bArr) {
            int i16 = i3 + 1;
            cArr2[i3] = cArr[(b16 >>> 4) & 15];
            i3 = i16 + 1;
            cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        if (r5 != null) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String encodeFile(String str) {
        Throwable th5;
        FileInputStream fileInputStream;
        Exception e16;
        MessageDigest messageDigest;
        byte[] bArr;
        File file = new File(str);
        String str2 = "";
        if (file.exists() && file.isFile()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e17) {
                    fileInputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    throw th5;
                }
                try {
                    try {
                        bArr = new byte[16384];
                    } catch (OutOfMemoryError unused) {
                        bArr = new byte[4096];
                    }
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str2 = byteArrayToHex(messageDigest.digest());
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.e("plugin_tag", 2, "encode-Exception:" + QLog.getStackTraceString(e16));
                    }
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    return str2;
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th5;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, "encode-File does not exist or is not file");
            }
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<WeakReference<IPluginActivity>> getActivitys() {
        return sInstances;
    }

    public static synchronized ClassLoader getClassLoader(String str) {
        DexClassLoader dexClassLoader;
        synchronized (PluginStatic.class) {
            dexClassLoader = sClassLoaderMap.get(str);
        }
        return dexClassLoader;
    }

    public static synchronized ClassLoader getOrCreateClassLoader(Context context, String str) throws Exception {
        ClassLoader orCreateClassLoaderAsModule;
        synchronized (PluginStatic.class) {
            orCreateClassLoaderAsModule = getOrCreateClassLoaderAsModule(context, str, true);
        }
        return orCreateClassLoaderAsModule;
    }

    public static synchronized ClassLoader getOrCreateClassLoaderAsModule(Context context, String str, boolean z16) throws Exception {
        DexClassLoader dexClassLoader;
        synchronized (PluginStatic.class) {
            dexClassLoader = sClassLoaderMap.get(str);
            if (dexClassLoader == null) {
                dexClassLoader = getOrCreateClassLoaderByPath(context, str, PluginUtils.getInstalledPluginPath(context, str).getCanonicalPath(), z16);
            }
        }
        return dexClassLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized ClassLoader getOrCreateClassLoaderByPath(Context context, String str, String str2, boolean z16) throws Exception {
        String str3;
        DexClassLoader dexClassLoader;
        synchronized (PluginStatic.class) {
            DexClassLoader dexClassLoader2 = sClassLoaderMap.get(str);
            if (dexClassLoader2 == null) {
                IPluginAdapterProxy.getProxy().isBuiltinPluginAndUpToDay(str, PluginBaseInfoHelper.createFromFile(PluginUtils.getPluginCfgFile(PluginUtils.getPluginInstallDir(context), str), PluginBaseInfo.class));
                QLog.d("plugin_tag", 1, "getOrCreateClassLoader:" + str);
                long currentTimeMillis = System.currentTimeMillis();
                String canonicalPath = PluginUtils.getOptimizedDexPath(context).getCanonicalPath();
                String canonicalPath2 = PluginUtils.getPluginLibPath(context, str).getCanonicalPath();
                if (str2.endsWith(".so")) {
                    dexClassLoader = new SoDexClassLoader(str2, canonicalPath, canonicalPath2, context.getClassLoader());
                } else if (str.startsWith("qzone_live_video_plugin")) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ClassLoader orCreateClassLoader = getOrCreateClassLoader(context, "qzone_plugin.apk");
                    QLog.d("plugin_tag", 1, "get qzone classloader cost=" + (System.currentTimeMillis() - currentTimeMillis2));
                    dexClassLoader = new QZoneLiveClassLoader(str2, canonicalPath, canonicalPath2, orCreateClassLoader);
                } else if (str.startsWith("qzone_vertical_video_plugin")) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    ClassLoader orCreateClassLoader2 = getOrCreateClassLoader(context, "qzone_plugin.apk");
                    QLog.d("plugin_tag", 1, "get qzone classloader cost=" + (System.currentTimeMillis() - currentTimeMillis3));
                    dexClassLoader = new QZoneVerticalVideoClassLoader(str2, canonicalPath, canonicalPath2, orCreateClassLoader2);
                } else if (str.startsWith("qzone_weishi_feeds_plugin")) {
                    long currentTimeMillis4 = System.currentTimeMillis();
                    ClassLoader orCreateClassLoader3 = getOrCreateClassLoader(context, "qzone_plugin.apk");
                    QLog.d("plugin_tag", 1, "get qzone classloader cost=" + (System.currentTimeMillis() - currentTimeMillis4));
                    dexClassLoader = new QZoneWeishiFeedsClassLoader(str2, canonicalPath, canonicalPath2, orCreateClassLoader3);
                } else {
                    if (!new File(str2).exists()) {
                        QLog.d("plugin_tag", 1, "getOrCreateClassLoader notExist  " + str2);
                        return new DexClassLoader("", canonicalPath, canonicalPath2, context.getClassLoader());
                    }
                    if (PluginUtils.isOsNeedReleaseDex() && IPluginAdapterProxy.getProxy().isSupportMultiDex(str)) {
                        File multiDexSecondDex = PluginUtils.getMultiDexSecondDex(context, str);
                        if (multiDexSecondDex.exists()) {
                            str3 = str2 + File.pathSeparator + multiDexSecondDex.getAbsolutePath();
                            QLog.d("plugin_tag", 1, "multiDex dexsPath" + str3);
                            QLog.d("plugin_tag", 1, "dexsPath" + str3);
                            dexClassLoader = new DexClassLoader(str3, canonicalPath, canonicalPath2, context.getClassLoader());
                        }
                    }
                    str3 = str2;
                    QLog.d("plugin_tag", 1, "dexsPath" + str3);
                    dexClassLoader = new DexClassLoader(str3, canonicalPath, canonicalPath2, context.getClassLoader());
                }
                PackageInfo packageInfo = sPackageInfoMap.get(str2);
                if (packageInfo == null) {
                    try {
                        packageInfo = ApkFileParser.getPackageInfoWithException(context, str2, 129);
                    } catch (Throwable th5) {
                        DebugHelper.log("plugin_tag", "PluginStatic.getOrCreateClassLoaderByPath Get Package Info Failed!", th5);
                    }
                    if (packageInfo == null) {
                        DebugHelper.log("PluginStatic.getOrCreateClassLoaderByPath Get Package Info Failed! " + new File(str2).exists());
                    }
                    sPackageInfoMap.put(str2, packageInfo);
                }
                ConcurrentHashMap<String, Long> concurrentHashMap = sClassLoaderStartTimeMap;
                Long l3 = concurrentHashMap.get(str);
                if (l3 == null) {
                    l3 = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                    concurrentHashMap.put(str, l3);
                }
                sPackageInfoMap.put(str2, packageInfo);
                if (packageInfo != null) {
                    invokePluginLife(packageInfo, str, dexClassLoader);
                }
                QLog.w("plugin_tag", 1, "getOrCreateClassLoaderCost:" + str + " c:" + l3);
                if (z16) {
                    MobileQQ.sMobileQQ.loadModule(str);
                }
                sClassLoaderMap.put(str, dexClassLoader);
                dexClassLoader2 = dexClassLoader;
            }
            return dexClassLoader2;
        }
    }

    static void invokePluginLife(PackageInfo packageInfo, String str, ClassLoader classLoader) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        String string;
        try {
            HashMap<String, IPluginLife> hashMap = sLife;
            if (hashMap.get(str) == null && packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (bundle = applicationInfo.metaData) != null && (string = bundle.getString("PLUGIN_LIFE_CLASS")) != null) {
                IPluginLife iPluginLife = (IPluginLife) classLoader.loadClass(string).newInstance();
                hashMap.put(str, iPluginLife);
                iPluginLife.onLoad();
            }
        } catch (Throwable unused) {
        }
    }

    public static List<Boolean> isProcessesExist(Context context, List<String> list) {
        boolean z16;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (runningAppProcesses == null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    arrayList.add(Boolean.FALSE);
                }
                return arrayList;
            }
            for (String str : list) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (str.equalsIgnoreCase(it.next().processName)) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                arrayList.add(Boolean.valueOf(z16));
            }
            return arrayList;
        }
        return null;
    }

    private static boolean isSubFile(String str, File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        String canonicalPath2 = new File(str).getParentFile().getCanonicalPath();
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "path:" + str + "-> [" + canonicalPath2 + ", " + canonicalPath + "]");
        }
        return canonicalPath2.equals(canonicalPath);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidPluginIntent(Bundle bundle) {
        boolean isValidPluginPath;
        if (bundle != null) {
            try {
                String string = bundle.getString("pluginsdk_pluginLocation");
                if (!TextUtils.isEmpty(string) && !string.substring(0, string.lastIndexOf(".")).contains(".") && !TextUtils.isEmpty(bundle.getString("pluginsdk_pluginName"))) {
                    String string2 = bundle.getString("pluginsdk_pluginpath");
                    if (TextUtils.isEmpty(string2)) {
                        return false;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        isValidPluginPath = true;
                    } else {
                        isValidPluginPath = isValidPluginPath(string2);
                    }
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return isValidPluginPath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidPluginPath(String str) {
        try {
            if (str.contains("..")) {
                return false;
            }
            if (str.endsWith(".so")) {
                String parent = BaseApplication.getContext().getFilesDir().getParent();
                File file = new File(parent + SoLoadCore.PATH_TX_LIB);
                if (!isSubFile(str, new File(parent + SoLoadCore.PATH_LIB))) {
                    isSubFile(str, file);
                }
                return true;
            }
            if (!str.endsWith(".apk")) {
                return false;
            }
            return isSubFile(str, PluginUtils.getPluginInstallDir(BaseApplication.getContext()));
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void remove(IPluginActivity iPluginActivity) {
        updateReference();
        removeActivity(iPluginActivity);
    }

    private static boolean removeActivity(IPluginActivity iPluginActivity) {
        synchronized (sInstances) {
            for (int i3 = 0; i3 < sInstances.size(); i3++) {
                if (sInstances.get(i3).get() == iPluginActivity) {
                    sInstances.remove(i3);
                    return true;
                }
            }
            return false;
        }
    }

    public static synchronized ClassLoader removeClassLoader(String str) {
        DexClassLoader remove;
        synchronized (PluginStatic.class) {
            QLog.d("plugin_tag", 1, "removeClassLoader:" + str);
            remove = sClassLoaderMap.remove(str);
        }
        return remove;
    }

    static void updateReference() {
        synchronized (sInstances) {
            int i3 = 0;
            while (i3 < sInstances.size()) {
                if (sInstances.get(i3).get() == null) {
                    sInstances.remove(i3);
                    i3--;
                }
                i3++;
            }
        }
    }
}
