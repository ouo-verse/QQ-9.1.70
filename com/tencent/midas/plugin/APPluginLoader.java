package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.pay.tool.APMidasTools;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APPluginReportManager;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class APPluginLoader {
    private static final HashMap<String, DexClassLoader> sClassLoaderMap = new HashMap<>();
    private static DexClassLoader parentClassLoader = null;

    public static synchronized ClassLoader getClassLoader(String str, String str2) {
        DexClassLoader dexClassLoader;
        synchronized (APPluginLoader.class) {
            dexClassLoader = sClassLoaderMap.get(str + "_" + str2);
        }
        return dexClassLoader;
    }

    public static synchronized ClassLoader getOrCreateClassLoader(Context context, String str) throws Exception {
        DexClassLoader orCreateClassLoaderByPath;
        synchronized (APPluginLoader.class) {
            orCreateClassLoaderByPath = getOrCreateClassLoaderByPath(context, str, APPluginInstallerAndUpdater.getInstallPath(context, str).getCanonicalPath());
            APLog.d("APPluginStatic", "getClassLoader getOrCreateClassLoader midasClassLoader: " + orCreateClassLoaderByPath.hashCode());
        }
        return orCreateClassLoaderByPath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized DexClassLoader getOrCreateClassLoaderByPath(Context context, String str, String str2) throws Exception {
        DexClassLoader dexClassLoader;
        synchronized (APPluginLoader.class) {
            String mD5FromPath = APPluginUtils.getMD5FromPath(str2);
            String str3 = str + "_" + mD5FromPath;
            HashMap<String, DexClassLoader> hashMap = sClassLoaderMap;
            DexClassLoader dexClassLoader2 = hashMap.get(str3);
            APLog.d("APPluginStatic", "getOrCreateClassLoader apkFilePath: " + str2 + ", MD5: " + mD5FromPath + ", key: " + str3 + ", dexClassLoader: " + dexClassLoader2);
            if (dexClassLoader2 != null) {
                return dexClassLoader2;
            }
            try {
                if (!APPluginChecker.isPluginValid(str2, mD5FromPath)) {
                    APLog.e("APPluginStatic", "getOrCreateClassLoader isPluginValid false");
                    return null;
                }
                String canonicalPath = APPluginConfig.getOptimizedDexPath(context).getCanonicalPath();
                long currentTimeMillis = System.currentTimeMillis();
                APPluginUtils.extractLibs(str2, APPluginConfig.getLibPath(context).getCanonicalPath());
                APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_UNZIP_SO, currentTimeMillis);
                String canonicalPath2 = APPluginConfig.getLibPath(context).getCanonicalPath();
                if (parentClassLoader != null) {
                    dexClassLoader = new DexClassLoader(str2, canonicalPath, canonicalPath2, parentClassLoader);
                } else {
                    dexClassLoader = new DexClassLoader(str2, canonicalPath, canonicalPath2, context.getClassLoader());
                }
                APLog.d("APPluginStatic", "getOrCreateClassLoader new DexClassLoader cache: " + canonicalPath + " libDir: " + canonicalPath2);
                hashMap.put(str3, dexClassLoader);
                return dexClassLoader;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static synchronized void preCreateClassLoaderByPath(Context context) throws Exception {
        synchronized (APPluginLoader.class) {
            String str = "";
            String str2 = "";
            File pluginPath = APPluginConfig.getPluginPath(context);
            if (pluginPath != null) {
                File[] listFiles = pluginPath.listFiles();
                int i3 = 0;
                while (true) {
                    if (i3 >= listFiles.length) {
                        break;
                    }
                    File file = listFiles[i3];
                    if (file.getName().startsWith("MidasPay")) {
                        file.setReadOnly();
                        str = "MidasPay";
                        str2 = file.getCanonicalPath();
                        break;
                    }
                    i3++;
                }
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                getOrCreateClassLoaderByPath(context, str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void release() {
        sClassLoaderMap.clear();
    }

    public static void setParentClassLoader(DexClassLoader dexClassLoader) {
        parentClassLoader = dexClassLoader;
    }
}
