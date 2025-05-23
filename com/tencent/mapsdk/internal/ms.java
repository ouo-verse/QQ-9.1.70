package com.tencent.mapsdk.internal;

import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ms implements mu {

    /* renamed from: g, reason: collision with root package name */
    private int f149335g = 0;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f149336h;

    ms(byte[] bArr) {
        this.f149336h = bArr;
    }

    private void a(byte[] bArr) {
        this.f149336h = bArr;
        this.f149335g = 0;
    }

    private int b() {
        return this.f149335g;
    }

    private byte c() {
        int i3;
        byte[] bArr = this.f149336h;
        if (bArr == null || (i3 = this.f149335g) >= bArr.length) {
            return (byte) 0;
        }
        this.f149335g = i3 + 1;
        return bArr[i3];
    }

    private boolean d() {
        return c() != 0;
    }

    private int e() {
        return (int) e(2);
    }

    private char f() {
        long j3 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            j3 |= (c() & 255) << (i3 * 8);
        }
        return (char) j3;
    }

    private int g() {
        return (int) e(4);
    }

    private long h() {
        return e(8);
    }

    private String i() {
        int e16 = (int) e(2);
        if (e16 == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < e16; i3++) {
            stringBuffer.append(f());
        }
        return stringBuffer.toString();
    }

    private String j() {
        int e16 = (int) e(2);
        if (e16 == 0) {
            return "";
        }
        byte[] bArr = new byte[e16];
        for (int i3 = 0; i3 < e16; i3++) {
            bArr[i3] = c();
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
            return "";
        }
    }

    private boolean k() {
        if (this.f149335g == this.f149336h.length - 1) {
            return true;
        }
        return false;
    }

    private void b(int i3) {
        this.f149335g -= i3;
    }

    private String d(int i3) {
        int i16 = i3 >> 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i17 = 0; i17 < i16; i17++) {
            stringBuffer.append(f());
        }
        return stringBuffer.toString();
    }

    private long e(int i3) {
        long j3 = 0;
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            j3 |= (c() & 255) << (i16 * 8);
        }
        return j3;
    }

    private byte[] a() {
        byte[] bArr = this.f149336h;
        int length = bArr.length;
        int i3 = this.f149335g;
        int i16 = length - i3;
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        return bArr2;
    }

    private byte[] c(int i3) {
        byte[] bArr = new byte[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            bArr[i16] = c();
        }
        return bArr;
    }

    private void a(int i3) {
        this.f149335g += i3;
    }
}
