package com.tencent.luggage.wxa.v;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import java.io.EOFException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: l, reason: collision with root package name */
    public static final int f142872l = v.b("OggS");

    /* renamed from: a, reason: collision with root package name */
    public int f142873a;

    /* renamed from: b, reason: collision with root package name */
    public int f142874b;

    /* renamed from: c, reason: collision with root package name */
    public long f142875c;

    /* renamed from: d, reason: collision with root package name */
    public long f142876d;

    /* renamed from: e, reason: collision with root package name */
    public long f142877e;

    /* renamed from: f, reason: collision with root package name */
    public long f142878f;

    /* renamed from: g, reason: collision with root package name */
    public int f142879g;

    /* renamed from: h, reason: collision with root package name */
    public int f142880h;

    /* renamed from: i, reason: collision with root package name */
    public int f142881i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f142882j = new int[255];

    /* renamed from: k, reason: collision with root package name */
    public final l f142883k = new l(255);

    public void a() {
        this.f142873a = 0;
        this.f142874b = 0;
        this.f142875c = 0L;
        this.f142876d = 0L;
        this.f142877e = 0L;
        this.f142878f = 0L;
        this.f142879g = 0;
        this.f142880h = 0;
        this.f142881i = 0;
    }

    public boolean a(com.tencent.luggage.wxa.q.e eVar, boolean z16) {
        this.f142883k.y();
        a();
        if (!(eVar.getLength() == -1 || eVar.getLength() - eVar.b() >= 27) || !eVar.a(this.f142883k.f135088a, 0, 27, true)) {
            if (z16) {
                return false;
            }
            throw new EOFException();
        }
        if (this.f142883k.s() != f142872l) {
            if (z16) {
                return false;
            }
            throw new o("expected OggS capture pattern at begin of page");
        }
        int q16 = this.f142883k.q();
        this.f142873a = q16;
        if (q16 != 0) {
            if (z16) {
                return false;
            }
            throw new o("unsupported bit stream revision");
        }
        this.f142874b = this.f142883k.q();
        this.f142875c = this.f142883k.i();
        this.f142876d = this.f142883k.j();
        this.f142877e = this.f142883k.j();
        this.f142878f = this.f142883k.j();
        int q17 = this.f142883k.q();
        this.f142879g = q17;
        this.f142880h = q17 + 27;
        this.f142883k.y();
        eVar.b(this.f142883k.f135088a, 0, this.f142879g);
        for (int i3 = 0; i3 < this.f142879g; i3++) {
            this.f142882j[i3] = this.f142883k.q();
            this.f142881i += this.f142882j[i3];
        }
        return true;
    }
}
