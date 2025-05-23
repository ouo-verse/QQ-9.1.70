package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class hv extends hy {

    /* renamed from: a, reason: collision with root package name */
    private fx f389379a;

    /* renamed from: b, reason: collision with root package name */
    private int f389380b;

    public hv(int i3) {
        this.f389379a = new fx(i3);
    }

    @Override // com.xiaomi.push.hy
    public int a(byte[] bArr, int i3, int i16) {
        byte[] d16 = this.f389379a.d();
        if (i16 > this.f389379a.a() - this.f389380b) {
            i16 = this.f389379a.a() - this.f389380b;
        }
        if (i16 > 0) {
            System.arraycopy(d16, this.f389380b, bArr, i3, i16);
            this.f389380b += i16;
        }
        return i16;
    }

    @Override // com.xiaomi.push.hy
    public void c(byte[] bArr, int i3, int i16) {
        this.f389379a.write(bArr, i3, i16);
    }

    public int h() {
        return this.f389379a.size();
    }
}
