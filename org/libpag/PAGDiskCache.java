package org.libpag;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* loaded from: classes29.dex */
public class PAGDiskCache {
    static {
        org.extra.tools.a.b("pag");
    }

    private static String GetCacheDir() {
        File externalCacheDir;
        Context a16 = org.extra.tools.a.a();
        if (a16 == null) {
            return "";
        }
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            externalCacheDir = null;
        } else {
            externalCacheDir = a16.getExternalCacheDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = a16.getCacheDir();
        }
        if (externalCacheDir == null) {
            return "";
        }
        return externalCacheDir.getPath();
    }

    public static native long MaxDiskSize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native byte[] ReadFile(String str);

    public static native void RemoveAll();

    public static native void SetMaxDiskSize(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean WriteFile(String str, byte[] bArr);
}
