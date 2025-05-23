package com.tencent.luggage.wxa.rj;

import com.tencent.luggage.wxa.fg.b;
import com.tencent.luggage.wxa.fg.c;
import com.tencent.luggage.wxa.nf.f;
import java.util.Collection;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m implements k {

    /* renamed from: c, reason: collision with root package name */
    public static final m f139810c = new m();

    /* renamed from: a, reason: collision with root package name */
    public Collection f139811a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public Collection f139812b = new HashSet();

    public m() {
        this.f139811a.add(b.C6216b.class);
        this.f139811a.add(c.b.class);
        this.f139811a.add(f.b.class);
        this.f139812b.add(com.tencent.luggage.wxa.se.f.class);
        this.f139812b.add(com.tencent.luggage.wxa.yf.c.class);
        this.f139812b.add(com.tencent.luggage.wxa.zd.j.class);
        this.f139812b.add(com.tencent.luggage.wxa.zd.l.class);
        this.f139812b.add(com.tencent.luggage.wxa.zd.k.class);
        this.f139812b.add(com.tencent.luggage.wxa.zd.g.class);
        this.f139812b.add(com.tencent.luggage.wxa.zd.h.class);
        this.f139812b.add(com.tencent.luggage.wxa.zd.j.class);
        this.f139812b.add(com.tencent.luggage.wxa.zd.m.class);
        this.f139812b.add(com.tencent.mm.plugin.appbrand.jsapi.audio.a.class);
    }

    @Override // com.tencent.luggage.wxa.rj.k
    public boolean a(com.tencent.luggage.wxa.xd.c cVar) {
        if (cVar == null) {
            return false;
        }
        return a(cVar.getClass());
    }

    @Override // com.tencent.luggage.wxa.rj.k
    public boolean a(Class cls) {
        if (cls == null) {
            return false;
        }
        return this.f139812b.contains(cls) || this.f139811a.contains(cls);
    }
}
