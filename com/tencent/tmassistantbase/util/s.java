package com.tencent.tmassistantbase.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes26.dex */
public class s {
    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Inflater inflater = new Inflater();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    byte[] bArr2 = new byte[1024];
                    inflater.setInput(bArr);
                    while (!inflater.finished()) {
                        byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                    }
                    inflater.end();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused) {
                    }
                } catch (DataFormatException e16) {
                    e = e16;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    e.printStackTrace();
                    inflater.end();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    byteArrayOutputStream = byteArrayOutputStream2;
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    inflater.end();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (DataFormatException e17) {
            e = e17;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Deflater deflater = new Deflater();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            deflater.setLevel(9);
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th6) {
            th = th6;
            deflater.end();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            throw th;
        }
    }
}
