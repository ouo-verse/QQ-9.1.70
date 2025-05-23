package com.tencent.shadow.dynamic.host;

import android.text.TextUtils;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import dalvik.system.BaseDexClassLoader;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MultiDynamicContainer {
    private static final Logger mLogger = LoggerFactory.getLogger(MultiDynamicContainer.class);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class ContainerClassLoader extends BaseDexClassLoader {
        private String apkFilePath;
        private String containerKey;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ContainerClassLoader(String str, InstalledApk installedApk, ClassLoader classLoader) {
            super(r0, r1, installedApk.libraryPath, classLoader);
            File file;
            String str2 = installedApk.apkFilePath;
            if (installedApk.oDexPath != null) {
                file = new File(installedApk.oDexPath);
            } else {
                file = null;
            }
            this.containerKey = str;
            this.apkFilePath = installedApk.apkFilePath;
        }
    }

    private static ContainerClassLoader findContainerClassLoader(String str) {
        for (ClassLoader parent = MultiDynamicContainer.class.getClassLoader().getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ContainerClassLoader) {
                ContainerClassLoader containerClassLoader = (ContainerClassLoader) parent;
                if (TextUtils.equals(containerClassLoader.containerKey, str)) {
                    return containerClassLoader;
                }
            }
        }
        return null;
    }

    private static void hackContainerClassLoader(String str, InstalledApk installedApk) throws Exception {
        ClassLoader classLoader = MultiDynamicContainer.class.getClassLoader();
        DynamicRuntime.hackParentClassLoader(classLoader, new ContainerClassLoader(str, installedApk, classLoader.getParent()));
    }

    public static boolean loadContainerApk(String str, InstalledApk installedApk) {
        ContainerClassLoader findContainerClassLoader = findContainerClassLoader(str);
        if (findContainerClassLoader != null) {
            String str2 = findContainerClassLoader.apkFilePath;
            Logger logger = mLogger;
            if (logger.isInfoEnabled()) {
                logger.info("\u8be5containKey\u7684apk\u5df2\u7ecf\u52a0\u8f7d\u8fc7, containKey=" + str + ", last apkPath=" + str2 + ", new apkPath=" + installedApk.apkFilePath);
            }
            if (TextUtils.equals(str2, installedApk.apkFilePath)) {
                if (logger.isInfoEnabled()) {
                    logger.info("\u5df2\u7ecf\u52a0\u8f7d\u76f8\u540capkPath\u7684containerApk\u4e86,\u4e0d\u9700\u8981\u52a0\u8f7d");
                    return false;
                }
                return false;
            }
            if (logger.isInfoEnabled()) {
                logger.info("\u52a0\u8f7d\u4e0d\u76f8\u540capkPath\u7684containerApk\u4e86,\u5148\u5c06\u8001\u7684\u79fb\u9664");
            }
            try {
                removeContainerClassLoader(findContainerClassLoader);
            } catch (Exception e16) {
                mLogger.error("\u79fb\u9664\u8001\u7684containerApk\u5931\u8d25", (Throwable) e16);
                throw new RuntimeException(e16);
            }
        }
        try {
            hackContainerClassLoader(str, installedApk);
            Logger logger2 = mLogger;
            if (logger2.isInfoEnabled()) {
                logger2.info("containerApk\u63d2\u5165\u6210\u529f\uff0ccontainerKey=" + str + ", path=" + installedApk.apkFilePath);
                return true;
            }
            return true;
        } catch (Exception e17) {
            throw new RuntimeException(e17);
        }
    }

    private static void removeContainerClassLoader(ContainerClassLoader containerClassLoader) throws Exception {
        ClassLoader classLoader;
        ClassLoader classLoader2 = MultiDynamicContainer.class.getClassLoader();
        ClassLoader parent = classLoader2.getParent();
        while (true) {
            ClassLoader classLoader3 = parent;
            classLoader = classLoader2;
            classLoader2 = classLoader3;
            if (classLoader2 == null || classLoader2 == containerClassLoader) {
                break;
            } else {
                parent = classLoader2.getParent();
            }
        }
        if (classLoader2 == containerClassLoader) {
            DynamicRuntime.hackParentClassLoader(classLoader, containerClassLoader.getParent());
        }
    }
}
