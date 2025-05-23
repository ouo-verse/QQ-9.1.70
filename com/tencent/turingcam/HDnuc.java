package com.tencent.turingcam;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HDnuc {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j3;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
        }
    }
}
