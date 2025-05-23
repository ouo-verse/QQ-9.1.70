package com.tencent.biz.pubaccount.weishi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    public static byte[] d(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                c(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                return byteArray;
            } catch (IOException e16) {
                x.f("GZipUtil", "decompress(), IOIOException: " + e16.getMessage());
                throw e16;
            }
        } finally {
            b(byteArrayOutputStream);
            a(byteArrayInputStream);
        }
    }

    public static void c(InputStream inputStream, OutputStream outputStream) throws IOException {
        GZIPInputStream gZIPInputStream = null;
        try {
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream2.read(bArr, 0, 1024);
                        if (read != -1) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            a(gZIPInputStream2);
                            return;
                        }
                    }
                } catch (IOException e16) {
                    e = e16;
                    x.f("GZipUtil", "decompress(), IOIOException: " + e.getMessage());
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    gZIPInputStream = gZIPInputStream2;
                    a(gZIPInputStream);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                x.f("GZipUtil", "closeQuietly(), InputStream IOIOException: " + e16.getMessage());
            }
        }
    }

    private static void b(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e16) {
                x.f("GZipUtil", "closeQuietly(), OutputStream IOIOException: " + e16.getMessage());
            }
        }
    }
}
