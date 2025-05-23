package com.tencent.luggage.wxa.cp;

import com.tencent.luggage.wxa.cp.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f123765a;

    /* renamed from: b, reason: collision with root package name */
    public final String f123766b;

    /* renamed from: c, reason: collision with root package name */
    public final long f123767c;

    /* renamed from: d, reason: collision with root package name */
    public final long f123768d;

    /* renamed from: e, reason: collision with root package name */
    public final long f123769e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f123770f;

    /* renamed from: g, reason: collision with root package name */
    public final k.a f123771g;

    public i(k.a aVar, String str, String str2, long j3, long j16, long j17, boolean z16) {
        this.f123771g = aVar;
        this.f123765a = str;
        this.f123766b = str2;
        this.f123767c = j3;
        this.f123768d = j16;
        this.f123769e = j17;
        this.f123770f = z16;
    }

    public boolean a(boolean z16) {
        return this.f123770f ? this.f123771g.b(this.f123765a, z16) : this.f123771g.b(this.f123765a);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(128);
        if (this.f123770f) {
            sb5.append("[DIR] ");
        }
        sb5.append(this.f123765a);
        sb5.append(" -> ");
        sb5.append(this.f123771g);
        return sb5.toString();
    }

    public boolean a() {
        return a(true);
    }
}
