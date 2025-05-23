package com.tencent.luggage.wxa.a;

import com.tencent.luggage.wxa.a.b;
import com.tencent.luggage.wxa.a.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public b.r f120494a;

    /* renamed from: b, reason: collision with root package name */
    public f f120495b;

    /* renamed from: c, reason: collision with root package name */
    public String f120496c;

    /* renamed from: d, reason: collision with root package name */
    public h.c f120497d;

    /* renamed from: e, reason: collision with root package name */
    public String f120498e;

    /* renamed from: f, reason: collision with root package name */
    public h.c f120499f;

    public g() {
        this.f120494a = null;
        this.f120495b = null;
        this.f120496c = null;
        this.f120497d = null;
        this.f120498e = null;
        this.f120499f = null;
    }

    public boolean a() {
        b.r rVar = this.f120494a;
        return rVar != null && rVar.c() > 0;
    }

    public boolean b() {
        if (this.f120495b != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f120496c != null) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f120498e != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f120497d != null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f120499f != null) {
            return true;
        }
        return false;
    }

    public g a(float f16, float f17, float f18, float f19) {
        this.f120499f = new h.c(f16, f17, f18, f19);
        return this;
    }

    public g(g gVar) {
        this.f120494a = null;
        this.f120495b = null;
        this.f120496c = null;
        this.f120497d = null;
        this.f120498e = null;
        this.f120499f = null;
        if (gVar == null) {
            return;
        }
        this.f120494a = gVar.f120494a;
        this.f120495b = gVar.f120495b;
        this.f120497d = gVar.f120497d;
        this.f120498e = gVar.f120498e;
        this.f120499f = gVar.f120499f;
    }
}
