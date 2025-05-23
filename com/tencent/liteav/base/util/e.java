package com.tencent.liteav.base.util;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e {
    public static long a(File file, int i3) {
        long length;
        long j3 = 0;
        if (i3 <= 0) {
            return 0L;
        }
        try {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = a(file2, i3 - 1);
                } else {
                    length = file2.length();
                }
                j3 += length;
            }
        } catch (Exception e16) {
            LiteavLog.i("FileUtil", "getFolderSize exception " + e16.toString());
        }
        return j3;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
