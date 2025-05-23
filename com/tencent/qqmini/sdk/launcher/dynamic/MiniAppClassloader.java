package com.tencent.qqmini.sdk.launcher.dynamic;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import dalvik.system.PathClassLoader;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppClassloader extends PathClassLoader {
    private static final String TAG = "MiniAppClassloader";
    private ClassLoader originClassLoader;

    public MiniAppClassloader(String str, String str2, ClassLoader classLoader) {
        super(str, str2, classLoader.getParent());
        this.originClassLoader = classLoader;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            return super.findClass(str);
        } catch (ClassNotFoundException unused) {
            QMLog.w(TAG, "ClassNotFoundException, load class from old loader: " + str);
            return this.originClassLoader.loadClass(str);
        } catch (InternalError e16) {
            QMLog.w(TAG, "InternalError, load class from old loader: " + str, e16);
            return this.originClassLoader.loadClass(str);
        }
    }
}
