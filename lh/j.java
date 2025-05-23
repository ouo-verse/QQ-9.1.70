package lh;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private List<f> f414577a;

    /* renamed from: b, reason: collision with root package name */
    private List<e> f414578b;

    /* renamed from: c, reason: collision with root package name */
    private List<c> f414579c;

    /* renamed from: d, reason: collision with root package name */
    private List<d> f414580d;

    /* renamed from: e, reason: collision with root package name */
    private List<g> f414581e;

    /* renamed from: f, reason: collision with root package name */
    private List<h> f414582f;

    /* renamed from: g, reason: collision with root package name */
    private List<b> f414583g;

    /* renamed from: h, reason: collision with root package name */
    private List<a> f414584h;

    public synchronized j a(a aVar) {
        if (aVar == null) {
            return this;
        }
        if (this.f414584h == null) {
            this.f414584h = new ArrayList();
        }
        this.f414584h.add(aVar);
        return this;
    }

    public synchronized j b(b bVar) {
        if (bVar == null) {
            return this;
        }
        if (this.f414583g == null) {
            this.f414583g = new ArrayList();
        }
        this.f414583g.add(bVar);
        return this;
    }

    public synchronized j c(c cVar) {
        if (cVar == null) {
            return this;
        }
        if (this.f414579c == null) {
            this.f414579c = new ArrayList();
        }
        this.f414579c.add(cVar);
        return this;
    }

    public synchronized j d(d dVar) {
        if (dVar == null) {
            return this;
        }
        if (this.f414580d == null) {
            this.f414580d = new ArrayList();
        }
        this.f414580d.add(dVar);
        return this;
    }

    public synchronized j e(e eVar) {
        if (eVar == null) {
            return this;
        }
        if (this.f414578b == null) {
            this.f414578b = new ArrayList();
        }
        this.f414578b.add(eVar);
        return this;
    }

    public synchronized j f(f fVar) {
        if (fVar == null) {
            return this;
        }
        if (this.f414577a == null) {
            this.f414577a = new ArrayList();
        }
        this.f414577a.add(fVar);
        return this;
    }

    public synchronized j g(g gVar) {
        if (gVar == null) {
            return this;
        }
        if (this.f414581e == null) {
            this.f414581e = new ArrayList();
        }
        this.f414581e.add(gVar);
        return this;
    }

    public synchronized j h(h hVar) {
        if (hVar == null) {
            return this;
        }
        if (this.f414582f == null) {
            this.f414582f = new ArrayList();
        }
        this.f414582f.add(hVar);
        return this;
    }

    public List<a> i() {
        return this.f414584h;
    }

    public List<b> j() {
        return this.f414583g;
    }

    public List<c> k() {
        return this.f414579c;
    }

    public List<d> l() {
        return this.f414580d;
    }

    public List<e> m() {
        return this.f414578b;
    }

    public List<f> n() {
        return this.f414577a;
    }

    public List<h> o() {
        return this.f414582f;
    }
}
