package com.tencent.qphone.base.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class g {
    public static byte[] a(byte[] bArr) {
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    while (!deflater.finished()) {
                        byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    throw th5;
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                byteArrayOutputStream.close();
            }
        } catch (IOException e18) {
            e18.printStackTrace();
        }
        deflater.end();
        return bArr;
    }

    public static byte[] b(byte[] bArr) throws Exception {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            try {
                byte[] bArr2 = new byte[1024];
                while (!inflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    inflater.end();
                    return byteArray;
                } catch (IOException e16) {
                    throw new Exception(e16.toString());
                }
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                    throw th5;
                } catch (IOException e17) {
                    throw new Exception(e17.toString());
                }
            }
        } catch (Exception e18) {
            throw new Exception(e18.toString());
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) throws Exception {
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream);
        try {
            try {
                deflaterOutputStream.write(bArr, 0, bArr.length);
                deflaterOutputStream.finish();
                deflaterOutputStream.flush();
            } catch (IOException e16) {
                throw new Exception(e16.toString());
            }
        } finally {
            deflaterOutputStream.close();
        }
    }

    public static byte[] a(InputStream inputStream) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream);
        int i3 = 1024;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                i3 = inflaterInputStream.read(bArr, 0, i3);
                if (i3 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
