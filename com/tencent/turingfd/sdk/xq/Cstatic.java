package com.tencent.turingfd.sdk.xq;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.static, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cstatic {
    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    deflaterOutputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                return byteArray;
            } catch (Exception unused) {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
                return null;
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                    deflaterOutputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                throw th5;
            }
        } catch (IOException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inflaterInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                } catch (Exception unused) {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th5) {
                    try {
                        byteArrayInputStream.close();
                        inflaterInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    throw th5;
                }
            } catch (IOException e17) {
                e17.printStackTrace();
                return null;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayInputStream.close();
            inflaterInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e18) {
            e18.printStackTrace();
        }
        return byteArray;
    }
}
