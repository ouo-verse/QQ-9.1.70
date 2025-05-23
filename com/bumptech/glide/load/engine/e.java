package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.DecodeJob;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class e<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final List<n.a<?>> f31652a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f31653b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.d f31654c;

    /* renamed from: d, reason: collision with root package name */
    private Object f31655d;

    /* renamed from: e, reason: collision with root package name */
    private int f31656e;

    /* renamed from: f, reason: collision with root package name */
    private int f31657f;

    /* renamed from: g, reason: collision with root package name */
    private Class<?> f31658g;

    /* renamed from: h, reason: collision with root package name */
    private DecodeJob.e f31659h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.e f31660i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Class<?>, com.bumptech.glide.load.h<?>> f31661j;

    /* renamed from: k, reason: collision with root package name */
    private Class<Transcode> f31662k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f31663l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f31664m;

    /* renamed from: n, reason: collision with root package name */
    private com.bumptech.glide.load.c f31665n;

    /* renamed from: o, reason: collision with root package name */
    private Priority f31666o;

    /* renamed from: p, reason: collision with root package name */
    private g f31667p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f31668q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f31669r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f31654c = null;
        this.f31655d = null;
        this.f31665n = null;
        this.f31658g = null;
        this.f31662k = null;
        this.f31660i = null;
        this.f31666o = null;
        this.f31661j = null;
        this.f31667p = null;
        this.f31652a.clear();
        this.f31663l = false;
        this.f31653b.clear();
        this.f31664m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r.b b() {
        return this.f31654c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.load.c> c() {
        if (!this.f31664m) {
            this.f31664m = true;
            this.f31653b.clear();
            List<n.a<?>> g16 = g();
            int size = g16.size();
            for (int i3 = 0; i3 < size; i3++) {
                n.a<?> aVar = g16.get(i3);
                if (!this.f31653b.contains(aVar.f435123a)) {
                    this.f31653b.add(aVar.f435123a);
                }
                for (int i16 = 0; i16 < aVar.f435124b.size(); i16++) {
                    if (!this.f31653b.contains(aVar.f435124b.get(i16))) {
                        this.f31653b.add(aVar.f435124b.get(i16));
                    }
                }
            }
        }
        return this.f31653b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s.a d() {
        return this.f31659h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g e() {
        return this.f31667p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f31657f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.a<?>> g() {
        if (!this.f31663l) {
            this.f31663l = true;
            this.f31652a.clear();
            List i3 = this.f31654c.i().i(this.f31655d);
            int size = i3.size();
            for (int i16 = 0; i16 < size; i16++) {
                n.a<?> a16 = ((t.n) i3.get(i16)).a(this.f31655d, this.f31656e, this.f31657f, this.f31660i);
                if (a16 != null) {
                    this.f31652a.add(a16);
                }
            }
        }
        return this.f31652a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> o<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f31654c.i().h(cls, this.f31658g, this.f31662k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f31655d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<t.n<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f31654c.i().i(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.e k() {
        return this.f31660i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority l() {
        return this.f31666o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f31654c.i().j(this.f31655d.getClass(), this.f31658g, this.f31662k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.g<Z> n(q<Z> qVar) {
        return this.f31654c.i().k(qVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.load.c o() {
        return this.f31665n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> com.bumptech.glide.load.a<X> p(X x16) throws Registry.NoSourceEncoderAvailableException {
        return this.f31654c.i().m(x16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> q() {
        return this.f31662k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> com.bumptech.glide.load.h<Z> r(Class<Z> cls) {
        com.bumptech.glide.load.h<Z> hVar = (com.bumptech.glide.load.h) this.f31661j.get(cls);
        if (hVar == null) {
            Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.h<?>>> it = this.f31661j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, com.bumptech.glide.load.h<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    hVar = (com.bumptech.glide.load.h) next.getValue();
                    break;
                }
            }
        }
        if (hVar == null) {
            if (this.f31661j.isEmpty() && this.f31668q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return v.l.c();
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f31656e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        if (h(cls) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.c cVar, int i3, int i16, g gVar, Class<?> cls, Class<R> cls2, Priority priority, com.bumptech.glide.load.e eVar, Map<Class<?>, com.bumptech.glide.load.h<?>> map, boolean z16, boolean z17, DecodeJob.e eVar2) {
        this.f31654c = dVar;
        this.f31655d = obj;
        this.f31665n = cVar;
        this.f31656e = i3;
        this.f31657f = i16;
        this.f31667p = gVar;
        this.f31658g = cls;
        this.f31659h = eVar2;
        this.f31662k = cls2;
        this.f31666o = priority;
        this.f31660i = eVar;
        this.f31661j = map;
        this.f31668q = z16;
        this.f31669r = z17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(q<?> qVar) {
        return this.f31654c.i().n(qVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f31669r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(com.bumptech.glide.load.c cVar) {
        List<n.a<?>> g16 = g();
        int size = g16.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (g16.get(i3).f435123a.equals(cVar)) {
                return true;
            }
        }
        return false;
    }
}
