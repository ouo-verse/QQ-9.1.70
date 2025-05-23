package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static long a(String str, long j3) {
        byte[] bArr = new byte[8192];
        CRC32 crc32 = new CRC32();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            long j16 = j3;
            long j17 = 0;
            do {
                try {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    if (j16 < read) {
                        read = (int) j16;
                    }
                    crc32.update(bArr, 0, read);
                    j17 += read;
                    j16 = j3 - j17;
                } catch (IOException unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return 0L;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } while (j16 > 0);
            fileInputStream2.close();
            long value = crc32.getValue();
            try {
                fileInputStream2.close();
            } catch (IOException unused4) {
            }
            return value;
        } catch (IOException unused5) {
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
