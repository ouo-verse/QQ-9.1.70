package com.tencent.shadow.dynamic.host;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DynamicRuntime {
    private static final String KEY_RUNTIME_APK = "KEY_RUNTIME_APK";
    private static final String KEY_RUNTIME_LIB = "KEY_RUNTIME_LIB";
    private static final String KEY_RUNTIME_ODEX = "KEY_RUNTIME_ODEX";
    private static final String SP_NAME = "ShadowRuntimeLoader";
    private static final Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class RuntimeClassLoader extends BaseDexClassLoader {
        private String apkPath;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        RuntimeClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, r3, str3, classLoader);
            File file;
            if (str2 == null) {
                file = null;
            } else {
                file = new File(str2);
            }
            this.apkPath = str;
        }
    }

    private static InstalledApk getLastRuntimeInfo(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(getSpName(context), 0);
        String string = sharedPreferences.getString(KEY_RUNTIME_APK, null);
        String string2 = sharedPreferences.getString(KEY_RUNTIME_ODEX, null);
        String string3 = sharedPreferences.getString(KEY_RUNTIME_LIB, null);
        if (string == null) {
            return null;
        }
        return new InstalledApk(string, string2, string3);
    }

    private static Field getParentField() {
        Object obj;
        ClassLoader classLoader = DynamicRuntime.class.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        for (Field field : ClassLoader.class.getDeclaredFields()) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                obj = field.get(classLoader);
                field.setAccessible(isAccessible);
            } catch (IllegalAccessException unused) {
            }
            if (obj == parent) {
                return field;
            }
        }
        return null;
    }

    private static String getProcessName(Context context) {
        if (context == null) {
            return "unknown";
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return getProcessName(Process.myPid());
    }

    private static RuntimeClassLoader getRuntimeClassLoader() {
        for (ClassLoader parent = DynamicRuntime.class.getClassLoader().getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof RuntimeClassLoader) {
                return (RuntimeClassLoader) parent;
            }
        }
        return null;
    }

    private static String getSpName(Context context) {
        return "ShadowRuntimeLoader_" + getProcessName(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void hackParentClassLoader(ClassLoader classLoader, ClassLoader classLoader2) throws Exception {
        Field parentField = getParentField();
        if (parentField != null) {
            parentField.setAccessible(true);
            parentField.set(classLoader, classLoader2);
            return;
        }
        throw new RuntimeException("\u5728ClassLoader.class\u4e2d\u6ca1\u627e\u5230\u7c7b\u578b\u4e3aClassLoader\u7684parent\u57df");
    }

    private static void hackParentToRuntime(InstalledApk installedApk, ClassLoader classLoader) throws Exception {
        hackParentClassLoader(classLoader, new RuntimeClassLoader(installedApk.apkFilePath, installedApk.oDexPath, installedApk.libraryPath, classLoader.getParent()));
    }

    public static boolean loadRuntime(InstalledApk installedApk) {
        ClassLoader classLoader = DynamicRuntime.class.getClassLoader();
        RuntimeClassLoader runtimeClassLoader = getRuntimeClassLoader();
        if (runtimeClassLoader != null) {
            String str = runtimeClassLoader.apkPath;
            Logger logger = mLogger;
            if (logger.isInfoEnabled()) {
                logger.info("last apkPath:" + str + " new apkPath:" + installedApk.apkFilePath);
            }
            if (TextUtils.equals(str, installedApk.apkFilePath)) {
                if (logger.isInfoEnabled()) {
                    logger.info("\u5df2\u7ecf\u52a0\u8f7d\u76f8\u540capkPath\u7684runtime\u4e86,\u4e0d\u9700\u8981\u52a0\u8f7d");
                    return false;
                }
                return false;
            }
            if (logger.isInfoEnabled()) {
                logger.info("\u52a0\u8f7d\u4e0d\u76f8\u540capkPath\u7684runtime\u4e86,\u5148\u6062\u590dclassLoader\u6811\u7ed3\u6784");
            }
            try {
                recoveryClassLoader();
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        try {
            hackParentToRuntime(installedApk, classLoader);
            return true;
        } catch (Exception e17) {
            throw new RuntimeException(e17);
        }
    }

    private static void recoveryClassLoader() throws Exception {
        ClassLoader classLoader = DynamicRuntime.class.getClassLoader();
        ClassLoader parent = classLoader.getParent();
        while (true) {
            ClassLoader classLoader2 = parent;
            ClassLoader classLoader3 = classLoader;
            classLoader = classLoader2;
            if (classLoader != null) {
                if (classLoader instanceof RuntimeClassLoader) {
                    hackParentClassLoader(classLoader3, classLoader.getParent());
                    return;
                }
                parent = classLoader.getParent();
            } else {
                return;
            }
        }
    }

    public static boolean recoveryRuntime(Context context) {
        InstalledApk lastRuntimeInfo = getLastRuntimeInfo(context);
        if (lastRuntimeInfo != null && new File(lastRuntimeInfo.apkFilePath).exists()) {
            if (lastRuntimeInfo.oDexPath != null && !new File(lastRuntimeInfo.oDexPath).exists()) {
                return false;
            }
            try {
                hackParentToRuntime(lastRuntimeInfo, DynamicRuntime.class.getClassLoader());
                return true;
            } catch (Exception e16) {
                Logger logger = mLogger;
                if (logger.isErrorEnabled()) {
                    logger.error("recoveryRuntime \u9519\u8bef", (Throwable) e16);
                }
                removeLastRuntimeInfo(context);
            }
        }
        return false;
    }

    @SuppressLint({"ApplySharedPref"})
    private static void removeLastRuntimeInfo(Context context) {
        context.getSharedPreferences(getSpName(context), 0).edit().remove(KEY_RUNTIME_APK).remove(KEY_RUNTIME_ODEX).remove(KEY_RUNTIME_LIB).commit();
    }

    @SuppressLint({"ApplySharedPref"})
    public static void saveLastRuntimeInfo(Context context, InstalledApk installedApk) {
        context.getSharedPreferences(getSpName(context), 0).edit().putString(KEY_RUNTIME_APK, installedApk.apkFilePath).putString(KEY_RUNTIME_ODEX, installedApk.oDexPath).putString(KEY_RUNTIME_LIB, installedApk.libraryPath).commit();
    }

    private static String getProcessName(int i3) {
        FileReader fileReader = null;
        try {
            try {
                FileReader fileReader2 = new FileReader("/proc/" + i3 + "/cmdline");
                try {
                    char[] cArr = new char[512];
                    fileReader2.read(cArr);
                    int i16 = 0;
                    while (i16 < 512 && cArr[i16] != 0) {
                        i16++;
                    }
                    String substring = new String(cArr).substring(0, i16);
                    try {
                        fileReader2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return substring;
                } catch (Exception e17) {
                    e = e17;
                    fileReader = fileReader2;
                    mLogger.error("get process name failed", (Throwable) e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return "unknown";
                } catch (Throwable th5) {
                    th = th5;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e26) {
            e = e26;
        }
    }
}
