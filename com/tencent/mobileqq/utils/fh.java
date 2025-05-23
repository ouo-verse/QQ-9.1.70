package com.tencent.mobileqq.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class fh {
    public static byte[] a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        byte[] bArr2 = null;
        try {
            try {
                bArr2 = new byte[dataInputStream.readInt() - 4];
                dataInputStream.read(bArr2);
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (Exception unused) {
                }
                return bArr2;
            } catch (Throwable th5) {
                try {
                    byteArrayInputStream.close();
                    dataInputStream.close();
                } catch (Exception unused2) {
                }
                throw th5;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                byteArrayInputStream.close();
                dataInputStream.close();
            } catch (Exception unused3) {
            }
            return bArr2;
        }
    }

    public static byte[] b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 4);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                dataOutputStream.writeInt(bArr.length + 4);
                dataOutputStream.write(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                    dataOutputStream.close();
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            }
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
                dataOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th5;
        }
    }
}
