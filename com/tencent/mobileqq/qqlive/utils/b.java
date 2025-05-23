package com.tencent.mobileqq.qqlive.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class b {
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

    public static byte[] b(InputStream inputStream, int i3) throws IOException {
        if (i3 <= 0) {
            return null;
        }
        byte[] bArr = new byte[i3];
        int i16 = 0;
        while (i16 < i3) {
            int read = inputStream.read(bArr, i16, i3 - i16);
            if (read <= 0) {
                break;
            }
            i16 += read;
        }
        return bArr;
    }

    public static long c(InputStream inputStream, int i3, boolean z16) throws IOException {
        if (i3 > 0 && i3 <= 8) {
            byte[] bArr = new byte[i3];
            if (inputStream.markSupported()) {
                inputStream.mark(i3);
            }
            int i16 = 0;
            int read = inputStream.read(bArr, 0, i3);
            if (read <= 0) {
                return -1L;
            }
            if (!z16) {
                i16 = read - 1;
            }
            int i17 = -1;
            if (!z16) {
                read = -1;
            }
            if (z16) {
                i17 = 1;
            }
            long j3 = 0;
            while (i16 != read) {
                j3 = (j3 << 8) | (bArr[i16] & 255);
                i16 += i17;
            }
            return j3;
        }
        throw new IllegalArgumentException("length must between 1 and 8.");
    }

    public static int d(InputStream inputStream, boolean z16) throws IOException {
        return (int) c(inputStream, 2, z16);
    }

    public static byte[] e(InputStream inputStream, boolean z16) throws IOException {
        int d16 = d(inputStream, z16);
        if (d16 <= 0) {
            return null;
        }
        return b(inputStream, d16);
    }
}
