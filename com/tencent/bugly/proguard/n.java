package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f98524a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f98525b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i3 = 0; i3 < 256; i3++) {
            bArr2[i3] = bArr[i3 >>> 4];
            bArr3[i3] = bArr[i3 & 15];
        }
        f98524a = bArr2;
        f98525b = bArr3;
    }

    public static boolean a(int i3, int i16) {
        return i3 == i16;
    }

    public static boolean a(long j3, long j16) {
        return j3 == j16;
    }

    public static boolean a(boolean z16, boolean z17) {
        return z16 == z17;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
