package com.tencent.mobileqq.soload.util;

import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static long b(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long c16 = c(fileInputStream2);
                    a(fileInputStream2);
                    return c16;
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    a(fileInputStream);
                    return -1L;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static long c(InputStream inputStream) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        int available = inputStream.available();
        byte[] bArr = new byte[8192];
        CRC32 crc32 = new CRC32();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            crc32.update(bArr, 0, read);
        }
        long value = crc32.getValue();
        if (QLog.isColorLevel()) {
            QLog.d(IOUtil.TAG, 2, "getCRC32Value fileTotalSize = " + available + " takeTime = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return value;
    }
}
