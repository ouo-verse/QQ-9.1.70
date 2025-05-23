package com.tencent.luggage.wxa.s9;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f140194a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f140195b = 0;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f140196c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f140197d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f140198e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f140199f = false;

    /* renamed from: g, reason: collision with root package name */
    public Lock f140200g = null;

    public int a(int i3) {
        if (i3 <= 0) {
            return -1;
        }
        this.f140196c = new byte[i3];
        this.f140194a = i3;
        if (!this.f140199f) {
            return 0;
        }
        this.f140200g = new ReentrantLock();
        return 0;
    }

    public int b() {
        if (this.f140199f) {
            this.f140200g.lock();
        }
        int i3 = this.f140197d;
        int i16 = this.f140198e;
        if (i3 == i16) {
            return this.f140194a;
        }
        int i17 = this.f140194a;
        if ((i16 + 1) % i17 == i3) {
            return 0;
        }
        if (i3 < i16) {
            this.f140195b = i16 - i3;
        } else if (i3 > i16) {
            this.f140195b = (i16 + i17) - i3;
        }
        if (this.f140199f) {
            this.f140200g.unlock();
        }
        return this.f140194a - this.f140195b;
    }

    public int c() {
        if (this.f140199f) {
            this.f140200g.lock();
        }
        int i3 = this.f140197d;
        int i16 = this.f140198e;
        if (i3 == i16) {
            return 0;
        }
        if (i3 < i16) {
            this.f140195b = i16 - i3;
        } else if (i3 > i16) {
            this.f140195b = (i16 + this.f140194a) - i3;
        }
        if (this.f140199f) {
            this.f140200g.unlock();
        }
        return this.f140195b;
    }

    public int d() {
        return this.f140194a;
    }

    public int a() {
        this.f140194a = 0;
        this.f140195b = 0;
        this.f140197d = 0;
        this.f140198e = 0;
        this.f140196c = null;
        return 0;
    }

    public int a(byte[] bArr, int i3) {
        if (i3 <= 0 || i3 > c() || bArr == null || this.f140197d == this.f140198e) {
            return -1;
        }
        if (this.f140199f) {
            this.f140200g.lock();
        }
        int i16 = this.f140197d;
        if (i16 < this.f140198e) {
            System.arraycopy(this.f140196c, i16, bArr, 0, i3);
            this.f140197d += i3;
        } else {
            int i17 = this.f140194a - i16;
            if (i3 <= i17) {
                System.arraycopy(this.f140196c, i16, bArr, 0, i3);
                this.f140197d += i3;
            } else {
                System.arraycopy(this.f140196c, i16, bArr, 0, i17);
                byte[] bArr2 = this.f140196c;
                int i18 = this.f140194a - this.f140197d;
                System.arraycopy(bArr2, 0, bArr, i18, i3 - i18);
                this.f140197d = i3 - (this.f140194a - this.f140197d);
            }
        }
        if (this.f140199f) {
            this.f140200g.unlock();
        }
        return 0;
    }

    public int b(byte[] bArr, int i3) {
        if (i3 <= 0 || i3 > b() || (this.f140198e + i3) % this.f140194a == this.f140197d) {
            return -1;
        }
        if (this.f140199f) {
            this.f140200g.lock();
        }
        int i16 = this.f140197d;
        int i17 = this.f140198e;
        if (i16 < i17) {
            int i18 = this.f140194a - i17;
            if (i3 <= i18) {
                System.arraycopy(bArr, 0, this.f140196c, i17, i3);
                this.f140198e = (this.f140198e + i3) % this.f140194a;
            } else {
                System.arraycopy(bArr, 0, this.f140196c, i17, i18);
                int i19 = this.f140194a - this.f140198e;
                System.arraycopy(bArr, i19, this.f140196c, 0, i3 - i19);
                int i26 = this.f140194a;
                int i27 = i3 - (i26 - this.f140198e);
                this.f140198e = i27;
                this.f140198e = i27 % i26;
            }
        } else {
            System.arraycopy(bArr, 0, this.f140196c, i17, i3);
            this.f140198e = (this.f140198e + i3) % this.f140194a;
        }
        if (this.f140199f) {
            this.f140200g.unlock();
        }
        return 0;
    }
}
