package com.tencent.luggage.wxa.rb;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements Serializable {
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public boolean H;
    public String I;
    public int J;
    public String K;
    public String L;
    public boolean M;
    public String N;
    public String O;
    public String T;
    public String U;
    public String V;
    public boolean W;
    public boolean X;

    /* renamed from: a, reason: collision with root package name */
    public int f139439a;

    /* renamed from: b, reason: collision with root package name */
    public int f139440b;

    /* renamed from: c, reason: collision with root package name */
    public String f139441c;

    /* renamed from: d, reason: collision with root package name */
    public float f139442d;

    /* renamed from: e, reason: collision with root package name */
    public String f139443e;

    /* renamed from: f, reason: collision with root package name */
    public String f139444f;

    /* renamed from: g, reason: collision with root package name */
    public String f139445g;

    /* renamed from: h, reason: collision with root package name */
    public String f139446h;

    /* renamed from: i, reason: collision with root package name */
    public String f139447i;

    /* renamed from: j, reason: collision with root package name */
    public String f139448j;

    /* renamed from: k, reason: collision with root package name */
    public String f139449k;

    /* renamed from: l, reason: collision with root package name */
    public String f139450l;

    /* renamed from: m, reason: collision with root package name */
    public String f139451m;
    public double P = 1.0d;
    public float Q = 1.0f;
    public boolean R = false;
    public boolean S = true;
    public boolean Y = true;

    public boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return this.f139441c.equals(dVar.f139441c);
    }

    public boolean b(d dVar) {
        if (dVar == null || this.f139439a != dVar.f139439a || !a(dVar)) {
            return false;
        }
        return true;
    }

    public void c(d dVar) {
        this.f139443e = dVar.f139443e;
        this.f139444f = dVar.f139444f;
        this.f139445g = dVar.f139445g;
        this.f139446h = dVar.f139446h;
        this.f139450l = dVar.f139450l;
        this.f139451m = dVar.f139451m;
        this.C = dVar.C;
        this.D = dVar.D;
        this.G = dVar.G;
        this.E = dVar.E;
        this.J = dVar.J;
        this.L = dVar.L;
        this.P = dVar.P;
        this.Q = dVar.Q;
        this.D = dVar.D;
        this.V = dVar.U;
        this.V = dVar.V;
        this.I = dVar.I;
        this.K = dVar.K;
        this.O = dVar.O;
        this.N = dVar.N;
        this.M = dVar.M;
        this.W = dVar.W;
        this.X = dVar.X;
        this.Y = dVar.Y;
        this.R = dVar.R;
    }
}
