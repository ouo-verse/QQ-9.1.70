package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.os.Environment;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class w0 {
    public static boolean a(Context context, boolean z16) {
        return a(context, context.getExternalCacheDir(), z16);
    }

    public static boolean b(Context context, boolean z16) {
        return a(context, Environment.getExternalStorageDirectory(), z16);
    }

    public static boolean a(Context context, File file, boolean z16) {
        if (file == null) {
            p0.a(context, "\u8bf7\u786e\u8ba4\u5e94\u7528\u6743\u9650\uff0c\u5728\u6743\u9650\u7ba1\u7406\u6253\u5f00\u5e94\u7528\u7684\u8bfb\u5199\u5b58\u50a8\u6743\u9650", z16);
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            String str = file.getPath() + File.separator + "apkxwebtest";
            try {
                File[] listFiles2 = new File(str).listFiles();
                if (listFiles2 != null && listFiles2.length != 0) {
                    for (int i3 = 0; i3 < listFiles2.length; i3++) {
                        if (listFiles2[i3].getName().endsWith(".zip")) {
                            return a(context, listFiles2[i3].getAbsolutePath(), listFiles2[i3].getName(), z16);
                        }
                    }
                    p0.a(context, "apkxwebtest\u76ee\u5f55\u4e0b\u6ca1\u6709.zip\u6587\u4ef6\uff0c\u8bf7\u5148\u6309\u6b65\u9aa4\u5c06\u5185\u6838\u5305\u4f20\u5165\u5230\u624b\u673a\u5185\u90e8\u5b58\u50a8\u4e2d", z16);
                    return false;
                }
                p0.a(context, "\u76ee\u5f55(" + str + ")\u4e0b\u6ca1\u6709\u6587\u4ef6\uff0c\u8bf7\u786e\u8ba4\u5e94\u7528\u6743\u9650\uff0c\u5728\u6743\u9650\u7ba1\u7406\u6253\u5f00\u5e94\u7528\u7684\u8bfb\u5199\u5b58\u50a8\u6743\u9650", z16);
                return false;
            } catch (Exception unused) {
                p0.a(context, "\u6ca1\u6709\u627e\u5230\u76ee\u5f55(" + str + ")\uff0c\u8bf7\u786e\u8ba4\u5e94\u7528\u6743\u9650\uff0c\u5728\u6743\u9650\u7ba1\u7406\u6253\u5f00\u5e94\u7528\u7684\u8bfb\u5199\u5b58\u50a8\u6743\u9650", z16);
                return false;
            }
        }
        p0.a(context, "\u8bf7\u786e\u8ba4\u5e94\u7528\u6743\u9650\uff0c\u518d\u786e\u8ba4\u6307\u5b9a\u76ee\u5f55\u4e0b\u5b58\u5728\u6587\u4ef6", z16);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v17, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2, boolean z16) {
        ?? r102;
        FileInputStream fileInputStream;
        boolean z17;
        Integer b16;
        x0.d("XWebLocalPackageInstaller", "loadPackageFromFile, filePath:" + str + ", fileName:" + str2);
        com.tencent.luggage.wxa.yq.e eVar = new com.tencent.luggage.wxa.yq.e(str, str2);
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(u0.i(eVar.f146073h));
            if (file.exists()) {
                file.delete();
            }
            fileInputStream = new FileInputStream(str);
            try {
                r102 = new FileOutputStream(file.getAbsolutePath());
            } catch (IOException e16) {
                e = e16;
            } catch (Throwable th5) {
                th = th5;
                w.a(fileInputStream);
                w.a(fileInputStream2);
                throw th;
            }
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    r102.write(bArr, 0, read);
                }
                r102.flush();
                w.a(fileInputStream);
                w.a((Closeable) r102);
                z17 = true;
            } catch (IOException e17) {
                fileInputStream2 = r102;
                e = e17;
                try {
                    x0.a("XWebLocalPackageInstaller", "loadPackageFromFile, copy package fail, error", e);
                    w.a(fileInputStream);
                    w.a(fileInputStream2);
                    z17 = false;
                    if (z17) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r102 = fileInputStream2;
                    fileInputStream2 = fileInputStream;
                    fileInputStream = fileInputStream2;
                    fileInputStream2 = r102;
                    w.a(fileInputStream);
                    w.a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                fileInputStream2 = r102;
                w.a(fileInputStream);
                w.a(fileInputStream2);
                throw th;
            }
        } catch (IOException e18) {
            e = e18;
            fileInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            r102 = 0;
            fileInputStream = fileInputStream2;
            fileInputStream2 = r102;
            w.a(fileInputStream);
            w.a(fileInputStream2);
            throw th;
        }
        if (z17) {
            p0.a(context, "\u5b89\u88c5\u5931\u8d25\uff0c\u5185\u6838\u6587\u4ef6\u62f7\u8d1d\u5931\u8d25", z16);
            return false;
        }
        try {
            new com.tencent.luggage.wxa.yq.q();
            b16 = com.tencent.luggage.wxa.yq.q.b(eVar);
        } catch (Exception e19) {
            p0.a(context, "\u5b89\u88c5\u5931\u8d25\uff0c\u5931\u8d25\u539f\u56e0\u770b\u65e5\u5fd7", z16);
            x0.a("XWebLocalPackageInstaller", "loadPackageFromFile, handle files fail, error", e19);
        }
        if (b16.intValue() == 0) {
            p0.a(context, "\u5b89\u88c5\u5185\u6838\u5305" + str2 + "\u6210\u529f", z16);
            return true;
        }
        p0.a(context, "\u5b89\u88c5\u5185\u6838\u5305" + str2 + "\u5931\u8d25\uff0c\u9519\u8bef\u7801=" + b16, z16);
        return false;
    }
}
