package com.tencent.local_edit.andserver.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f119879a = new byte[0];

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static InputStream b() {
        return new ByteArrayInputStream(f119879a);
    }

    public static boolean c(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            file.delete();
        }
        return file.mkdirs();
    }

    public static boolean d(File file) {
        if (file.exists()) {
            e(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean e(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return true;
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        e(file2);
                    }
                }
                file.delete();
                return true;
            }
            return true;
        }
        return true;
    }

    public static byte[] f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String g(InputStream inputStream) throws IOException {
        return new String(f(inputStream));
    }

    public static String h(InputStream inputStream, Charset charset) throws IOException {
        return new String(f(inputStream), charset);
    }

    public static void i(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                outputStream.flush();
            } else {
                return;
            }
        }
    }

    public static void j(OutputStream outputStream, byte[] bArr) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
            outputStream.flush();
        }
    }
}
