package com.tencent.luggage.wxa.w;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f143905a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f143906b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143907c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f143908d;

    /* renamed from: e, reason: collision with root package name */
    public int f143909e;

    public n(int i3, int i16) {
        this.f143905a = i3;
        byte[] bArr = new byte[i16 + 3];
        this.f143908d = bArr;
        bArr[2] = 1;
    }

    public boolean a() {
        return this.f143907c;
    }

    public void b() {
        this.f143906b = false;
        this.f143907c = false;
    }

    public void a(byte[] bArr, int i3, int i16) {
        if (this.f143906b) {
            int i17 = i16 - i3;
            byte[] bArr2 = this.f143908d;
            int length = bArr2.length;
            int i18 = this.f143909e + i17;
            if (length < i18) {
                this.f143908d = Arrays.copyOf(bArr2, i18 * 2);
            }
            System.arraycopy(bArr, i3, this.f143908d, this.f143909e, i17);
            this.f143909e += i17;
        }
    }

    public void b(int i3) {
        com.tencent.luggage.wxa.n0.a.b(!this.f143906b);
        boolean z16 = i3 == this.f143905a;
        this.f143906b = z16;
        if (z16) {
            this.f143909e = 3;
            this.f143907c = false;
        }
    }

    public boolean a(int i3) {
        if (!this.f143906b) {
            return false;
        }
        this.f143909e -= i3;
        this.f143906b = false;
        this.f143907c = true;
        return true;
    }
}
