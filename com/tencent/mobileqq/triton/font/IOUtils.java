package com.tencent.mobileqq.triton.font;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class IOUtils {
    private static int DEFAULT_BUFFER = 4096;
    private static int EOF = -1;

    IOUtils() {
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > TTL.MAX_VALUE) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copyLarge(inputStream, outputStream, new byte[DEFAULT_BUFFER]);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j3 = 0;
        while (true) {
            int i3 = EOF;
            int read = inputStream.read(bArr);
            if (i3 == read) {
                return j3;
            }
            outputStream.write(bArr, 0, read);
            j3 += read;
        }
    }
}
