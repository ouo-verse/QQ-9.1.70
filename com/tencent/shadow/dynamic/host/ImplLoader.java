package com.tencent.shadow.dynamic.host;

import com.tencent.shadow.core.common.InstalledApk;
import dalvik.system.DexClassLoader;

/* compiled from: P */
/* loaded from: classes25.dex */
abstract class ImplLoader {
    private static final String WHITE_LIST_CLASS_NAME = "com.tencent.shadow.dynamic.impl.WhiteList";
    private static final String WHITE_LIST_FIELD_NAME = "sWhiteList";

    private static String[] concatenate(String[] strArr, String[] strArr2) {
        int length = strArr.length;
        int length2 = strArr2.length;
        String[] strArr3 = new String[length + length2];
        System.arraycopy(strArr, 0, strArr3, 0, length);
        System.arraycopy(strArr2, 0, strArr3, length, length2);
        return strArr3;
    }

    abstract String[] getCustomWhiteList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] loadWhiteList(InstalledApk installedApk) {
        DexClassLoader dexClassLoader = new DexClassLoader(installedApk.apkFilePath, installedApk.oDexPath, installedApk.libraryPath, getClass().getClassLoader());
        String[] strArr = null;
        try {
            strArr = (String[]) dexClassLoader.loadClass(WHITE_LIST_CLASS_NAME).getDeclaredField(WHITE_LIST_FIELD_NAME).get(null);
        } catch (ClassNotFoundException unused) {
        } catch (IllegalAccessException e16) {
            throw new RuntimeException(e16);
        } catch (NoSuchFieldException e17) {
            throw new RuntimeException(e17);
        }
        if (strArr != null) {
            return concatenate(getCustomWhiteList(), strArr);
        }
        return getCustomWhiteList();
    }
}
