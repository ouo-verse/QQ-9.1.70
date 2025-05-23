package com.tencent.luggage.wxa.n0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f135091a;

    /* renamed from: b, reason: collision with root package name */
    public int f135092b;

    /* renamed from: c, reason: collision with root package name */
    public int f135093c;

    /* renamed from: d, reason: collision with root package name */
    public int f135094d;

    public m(byte[] bArr, int i3, int i16) {
        a(bArr, i3, i16);
    }

    public void a(byte[] bArr, int i3, int i16) {
        this.f135091a = bArr;
        this.f135093c = i3;
        this.f135092b = i16;
        this.f135094d = 0;
        a();
    }

    public int b(int i3) {
        int i16;
        this.f135094d += i3;
        int i17 = 0;
        while (true) {
            i16 = this.f135094d;
            if (i16 <= 8) {
                break;
            }
            int i18 = i16 - 8;
            this.f135094d = i18;
            byte[] bArr = this.f135091a;
            int i19 = this.f135093c;
            i17 |= (bArr[i19] & 255) << i18;
            if (!c(i19 + 1)) {
                r3 = 1;
            }
            this.f135093c = i19 + r3;
        }
        byte[] bArr2 = this.f135091a;
        int i26 = this.f135093c;
        int i27 = ((-1) >>> (32 - i3)) & (i17 | ((bArr2[i26] & 255) >> (8 - i16)));
        if (i16 == 8) {
            this.f135094d = 0;
            this.f135093c = i26 + (c(i26 + 1) ? 2 : 1);
        }
        a();
        return i27;
    }

    public boolean c() {
        boolean z16 = (this.f135091a[this.f135093c] & (128 >> this.f135094d)) != 0;
        g();
        return z16;
    }

    public void d(int i3) {
        int i16 = this.f135093c;
        int i17 = i3 / 8;
        int i18 = i16 + i17;
        this.f135093c = i18;
        int i19 = this.f135094d + (i3 - (i17 * 8));
        this.f135094d = i19;
        if (i19 > 7) {
            this.f135093c = i18 + 1;
            this.f135094d = i19 - 8;
        }
        while (true) {
            i16++;
            if (i16 <= this.f135093c) {
                if (c(i16)) {
                    this.f135093c++;
                    i16 += 2;
                }
            } else {
                a();
                return;
            }
        }
    }

    public int e() {
        int i3;
        int d16 = d();
        if (d16 % 2 == 0) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        return i3 * ((d16 + 1) / 2);
    }

    public int f() {
        return d();
    }

    public void g() {
        int i3 = 1;
        int i16 = this.f135094d + 1;
        this.f135094d = i16;
        if (i16 == 8) {
            this.f135094d = 0;
            int i17 = this.f135093c;
            if (c(i17 + 1)) {
                i3 = 2;
            }
            this.f135093c = i17 + i3;
        }
        a();
    }

    public final boolean c(int i3) {
        if (2 <= i3 && i3 < this.f135092b) {
            byte[] bArr = this.f135091a;
            if (bArr[i3] == 3 && bArr[i3 - 2] == 0 && bArr[i3 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i3) {
        int i16 = this.f135093c;
        int i17 = i3 / 8;
        int i18 = i16 + i17;
        int i19 = (this.f135094d + i3) - (i17 * 8);
        if (i19 > 7) {
            i18++;
            i19 -= 8;
        }
        while (true) {
            i16++;
            if (i16 > i18 || i18 >= this.f135092b) {
                break;
            }
            if (c(i16)) {
                i18++;
                i16 += 2;
            }
        }
        int i26 = this.f135092b;
        if (i18 >= i26) {
            return i18 == i26 && i19 == 0;
        }
        return true;
    }

    public boolean b() {
        int i3 = this.f135093c;
        int i16 = this.f135094d;
        int i17 = 0;
        while (this.f135093c < this.f135092b && !c()) {
            i17++;
        }
        boolean z16 = this.f135093c == this.f135092b;
        this.f135093c = i3;
        this.f135094d = i16;
        return !z16 && a((i17 * 2) + 1);
    }

    public final int d() {
        int i3 = 0;
        while (!c()) {
            i3++;
        }
        return ((1 << i3) - 1) + (i3 > 0 ? b(i3) : 0);
    }

    public final void a() {
        int i3;
        int i16 = this.f135093c;
        a.b(i16 >= 0 && (i16 < (i3 = this.f135092b) || (i16 == i3 && this.f135094d == 0)));
    }
}
