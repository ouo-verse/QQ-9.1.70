package com.tencent.rfw.barrage.core;

import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import tz3.i;
import vz3.h;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f365019a;

    /* renamed from: b, reason: collision with root package name */
    protected final TreeSet<com.tencent.rfw.barrage.data.a> f365020b;

    /* renamed from: c, reason: collision with root package name */
    protected final List<com.tencent.rfw.barrage.data.a> f365021c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    protected final uz3.d f365022d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<uz3.c> f365023e;

    /* renamed from: f, reason: collision with root package name */
    protected i f365024f;

    /* renamed from: g, reason: collision with root package name */
    protected f f365025g;

    /* renamed from: h, reason: collision with root package name */
    protected vz3.c f365026h;

    /* renamed from: i, reason: collision with root package name */
    protected vz3.a f365027i;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(i iVar, f fVar, Comparator<com.tencent.rfw.barrage.data.a> comparator, vz3.c cVar, vz3.a aVar) {
        this.f365024f = iVar;
        this.f365025g = fVar;
        this.f365026h = cVar;
        this.f365027i = aVar;
        this.f365022d = new uz3.d(fVar, i());
        this.f365020b = new TreeSet<>(comparator);
        m();
    }

    private void f(Canvas canvas, i iVar, long j3) {
        ArrayList<uz3.c> arrayList = this.f365023e;
        if (arrayList == null || canvas == null) {
            return;
        }
        Iterator<uz3.c> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(canvas, iVar, j3);
        }
    }

    public void a(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f365020b.add(aVar);
    }

    public void b() {
        List<com.tencent.rfw.barrage.data.a> list = this.f365021c;
        if (list == null) {
            return;
        }
        list.clear();
    }

    public abstract void c();

    public final void d(Canvas canvas, long j3) {
        l(canvas, j3);
        f(canvas, this.f365024f, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Canvas canvas, com.tencent.rfw.barrage.data.a aVar) {
        if (canvas == null || aVar == null) {
            return;
        }
        uz3.f e16 = this.f365024f.e(aVar);
        uz3.d dVar = this.f365022d;
        if (dVar != null) {
            dVar.a(canvas, aVar, this.f365024f, e16);
        }
        aVar.a();
    }

    public void g(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.p0(true);
        aVar.w0(true);
        float y16 = aVar.y();
        e.c(this.f365024f, aVar);
        aVar.s0((aVar.y() + aVar.F()) / (y16 + aVar.F()));
    }

    public List<com.tencent.rfw.barrage.data.a> h() {
        return this.f365021c;
    }

    public abstract boolean i();

    public abstract void j();

    public abstract com.tencent.rfw.barrage.data.a k(h hVar);

    public abstract void l(Canvas canvas, long j3);

    public abstract void m();
}
