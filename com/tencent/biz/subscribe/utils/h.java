package com.tencent.biz.subscribe.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {
    public static Object a(byte[] bArr) {
        Object obj = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            obj = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            return obj;
        } catch (Exception e16) {
            e16.printStackTrace();
            return obj;
        }
    }

    public static byte[] b(Object obj) {
        byte[] bArr = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            objectOutputStream.close();
            return bArr;
        } catch (Exception e16) {
            e16.printStackTrace();
            return bArr;
        }
    }
}
