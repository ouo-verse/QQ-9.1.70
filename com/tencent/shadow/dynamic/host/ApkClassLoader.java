package com.tencent.shadow.dynamic.host;

import com.tencent.shadow.core.common.InstalledApk;
import dalvik.system.DexClassLoader;

/* compiled from: P */
/* loaded from: classes25.dex */
class ApkClassLoader extends DexClassLoader {
    private ClassLoader mGrandParent;
    private final String[] mInterfacePackageNames;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApkClassLoader(InstalledApk installedApk, ClassLoader classLoader, String[] strArr, int i3) {
        super(installedApk.apkFilePath, installedApk.oDexPath, installedApk.libraryPath, classLoader);
        for (int i16 = 0; i16 < i3; i16++) {
            classLoader = classLoader.getParent();
        }
        this.mGrandParent = classLoader;
        this.mInterfacePackageNames = strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T getInterface(Class<T> cls, String str) throws Exception {
        try {
            return cls.cast(loadClass(str).newInstance());
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException e16) {
            throw new Exception(e16);
        }
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        boolean z17 = false;
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
        } else {
            str2 = "";
        }
        String[] strArr = this.mInterfacePackageNames;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (str2.equals(strArr[i3])) {
                z17 = true;
                break;
            }
            i3++;
        }
        if (z17) {
            return super.loadClass(str, z16);
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
                e = null;
            } catch (ClassNotFoundException e16) {
                e = e16;
            }
            if (findLoadedClass == null) {
                try {
                    return this.mGrandParent.loadClass(str);
                } catch (ClassNotFoundException e17) {
                    e17.addSuppressed(e);
                    throw e17;
                }
            }
            return findLoadedClass;
        }
        return findLoadedClass;
    }
}
