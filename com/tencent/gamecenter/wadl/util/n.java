package com.tencent.gamecenter.wadl.util;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class n implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private int f107680d;

    public n(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i3 = this.f107680d;
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 & 65280) >> 8)};
    }

    public int b() {
        return this.f107680d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n) || this.f107680d != ((n) obj).b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f107680d;
    }

    public n(byte[] bArr, int i3) {
        this.f107680d = ((bArr[i3 + 1] << 8) & 65280) + (bArr[i3] & 255);
    }

    public n(int i3) {
        this.f107680d = i3;
    }
}
