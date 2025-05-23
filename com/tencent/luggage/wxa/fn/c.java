package com.tencent.luggage.wxa.fn;

import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f126263b = new c();

    /* renamed from: a, reason: collision with root package name */
    public byte[] f126264a;

    public c() {
        this(new byte[0]);
    }

    public static c a(byte[] bArr, int i3, int i16) {
        return new c(bArr, i3, i16);
    }

    public int b() {
        return this.f126264a.length;
    }

    public byte[] c() {
        byte[] bArr = this.f126264a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public String d() {
        byte[] bArr;
        int i3 = 0;
        while (true) {
            try {
                bArr = this.f126264a;
                if (i3 >= bArr.length || bArr[i3] == 0) {
                    break;
                }
                i3++;
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("UTF-8 not supported?");
            }
        }
        return new String(bArr, 0, i3, "UTF-8");
    }

    public c(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public static c a(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new c(bArr);
    }

    public String b(String str) {
        return new String(this.f126264a, str);
    }

    public c(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        this.f126264a = bArr2;
        System.arraycopy(bArr, i3, bArr2, 0, i16);
    }

    public static c a(String str, String str2) {
        c cVar = new c();
        cVar.f126264a = str.getBytes(str2);
        return cVar;
    }

    public static c a(String str) {
        try {
            return a(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("UTF-8 not supported?", e16);
        }
    }

    public c a(int i3) {
        byte[] bArr = new byte[i3];
        byte[] bArr2 = this.f126264a;
        if (bArr2.length >= i3) {
            System.arraycopy(bArr2, 0, bArr, 0, i3 - 1);
            this.f126264a = bArr;
        } else {
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            this.f126264a = bArr;
        }
        return this;
    }

    public byte[] a() {
        return this.f126264a;
    }
}
