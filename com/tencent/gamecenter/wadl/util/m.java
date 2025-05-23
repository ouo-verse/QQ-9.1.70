package com.tencent.gamecenter.wadl.util;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class m implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private long f107679d;

    public m(long j3) {
        this.f107679d = j3;
    }

    public byte[] a() {
        long j3 = this.f107679d;
        return new byte[]{(byte) (255 & j3), (byte) ((65280 & j3) >> 8), (byte) ((16711680 & j3) >> 16), (byte) ((j3 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f107679d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m) || this.f107679d != ((m) obj).b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) this.f107679d;
    }
}
