package com.tencent.halley.common.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(File file) {
        b bVar = new b();
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1048576];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            bVar.a(bArr, read);
                        }
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        d.c("halley-downloader-CrcUtil_qqq", "!!!calculateCrc64 error", e);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (bVar.getValue() == 0) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e17) {
                                d.c("halley-downloader-CrcUtil_qqq", "!!calculateCrc64 close is error", e17);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (Exception e19) {
            d.c("halley-downloader-CrcUtil_qqq", "!!calculateCrc64 close is error", e19);
        }
        return bVar.getValue() == 0 ? i.a(bVar.getValue()) : "";
    }

    public static String a(String str, String str2, String str3) {
        try {
            String a16 = a(new File(str2, str3));
            d.e("halley-downloader-CrcUtil_qqq", "checkCalculateCrc64 realCrc64= " + a16 + ", dstValue= " + str);
            if (TextUtils.isEmpty(a16) || a16.equals(str)) {
                return null;
            }
            return "inner error, crc is not equal: dstValue is " + str + ", but realValue is " + a16;
        } catch (Exception e16) {
            d.c("halley-downloader-CrcUtil_qqq", "checkCalculateCrc64 error", e16);
            return null;
        }
    }
}
