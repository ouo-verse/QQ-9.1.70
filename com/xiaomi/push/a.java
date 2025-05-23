package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f388122c = new a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f388123a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f388124b = 0;

    a(byte[] bArr) {
        this.f388123a = bArr;
    }

    public static a b(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    public static a c(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[i16];
        System.arraycopy(bArr, i3, bArr2, 0, i16);
        return new a(bArr2);
    }

    public int a() {
        return this.f388123a.length;
    }

    public byte[] d() {
        byte[] bArr = this.f388123a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f388123a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f388123a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i3 = this.f388124b;
        if (i3 == 0) {
            byte[] bArr = this.f388123a;
            int length = bArr.length;
            for (byte b16 : bArr) {
                length = (length * 31) + b16;
            }
            if (length == 0) {
                i3 = 1;
            } else {
                i3 = length;
            }
            this.f388124b = i3;
        }
        return i3;
    }
}
