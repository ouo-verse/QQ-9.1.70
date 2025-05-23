package com.tencent.av.business.handler;

import android.annotation.SuppressLint;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f73286a = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.av.business.handler.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0737a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f73287a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f73288b;

        public C0737a(int i3, int i16) {
            this.f73287a = new byte[i3];
            this.f73288b = new byte[i16];
        }
    }

    a() {
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            cArr[i17] = charArray[i16 >>> 4];
            cArr[i17 + 1] = charArray[i16 & 15];
        }
        return new String(cArr);
    }

    private static int b(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    public static C0737a c(byte[] bArr) {
        int length = bArr.length;
        byte b16 = bArr[0];
        byte b17 = bArr[length - 1];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        QLog.d("AudioTrans runhw", 2, "rspBodyBytes = " + a(bArr));
        System.arraycopy(bArr, 1, bArr2, 0, 4);
        System.arraycopy(bArr, 5, bArr3, 0, 4);
        int b18 = b(bArr2);
        int b19 = b(bArr3);
        QLog.d("AudioTrans runhw", 2, "rspBytesLen = " + length + ", lengthOfHead = " + b18 + ", lengthOfBody = " + b19);
        C0737a c0737a = new C0737a(b18, b19);
        System.arraycopy(bArr, 9, c0737a.f73287a, 0, b18);
        System.arraycopy(bArr, b18 + 9, c0737a.f73288b, 0, b19);
        return c0737a;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] array = ByteBuffer.allocate(4).putInt(length).array();
        byte[] array2 = ByteBuffer.allocate(4).putInt(length2).array();
        int i3 = length + 9;
        int i16 = i3 + length2 + 1;
        byte[] bArr3 = new byte[i16];
        bArr3[0] = 40;
        System.arraycopy(array, 0, bArr3, 1, 4);
        System.arraycopy(array2, 0, bArr3, 5, 4);
        System.arraycopy(bArr, 0, bArr3, 9, length);
        System.arraycopy(bArr2, 0, bArr3, i3, length2);
        bArr3[i16 - 1] = 41;
        return bArr3;
    }

    @SuppressLint({"DefaultLocale"})
    public static String e(int i3) {
        return String.format("%d.%d.%d.%d", Integer.valueOf((i3 >> 24) & 255), Integer.valueOf((i3 >> 16) & 255), Integer.valueOf((i3 >> 8) & 255), Integer.valueOf(i3 & 255));
    }
}
