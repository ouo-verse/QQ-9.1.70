package com.tencent.mapsdk.internal;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class mr implements mu {
    private static byte a(InputStream inputStream) throws IOException {
        return (byte) inputStream.read();
    }

    private static boolean b(InputStream inputStream) throws IOException {
        if (((byte) inputStream.read()) == 0) {
            return false;
        }
        return true;
    }

    private static int c(InputStream inputStream) throws IOException {
        return (int) a(2, inputStream);
    }

    private static char d(InputStream inputStream) throws IOException {
        long j3 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            j3 |= (((byte) inputStream.read()) & 255) << (i3 * 8);
        }
        return (char) j3;
    }

    private static int e(InputStream inputStream) throws IOException {
        return (int) a(4, inputStream);
    }

    private static long f(InputStream inputStream) throws IOException {
        return a(8, inputStream);
    }

    private static String g(InputStream inputStream) throws IOException {
        int a16 = (int) a(2, inputStream);
        byte[] bArr = new byte[a16];
        int i3 = 0;
        while (i3 < a16) {
            i3 += inputStream.read(bArr, i3, a16 - i3);
        }
        return new String(bArr);
    }

    private static byte[] a(InputStream inputStream, int i3) throws IOException {
        byte[] bArr = new byte[i3];
        int i16 = 0;
        while (i16 < i3) {
            i16 += inputStream.read(bArr, i16, i3 - i16);
        }
        return bArr;
    }

    private static long a(int i3, InputStream inputStream) throws IOException {
        long j3 = 0;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            j3 |= (((byte) inputStream.read()) & 255) << (i16 * 8);
        }
        return j3;
    }
}
