package com.tencent.common.danmaku.core;

import android.graphics.Canvas;
import com.tencent.common.danmaku.tool.f;
import com.tencent.common.danmaku.tool.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected int f99634a;

    /* renamed from: b, reason: collision with root package name */
    protected final TreeSet<com.tencent.common.danmaku.data.a> f99635b;

    /* renamed from: c, reason: collision with root package name */
    protected final List<com.tencent.common.danmaku.data.a> f99636c;

    /* renamed from: d, reason: collision with root package name */
    protected final com.tencent.common.danmaku.render.b f99637d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<com.tencent.common.danmaku.render.e> f99638e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.common.danmaku.inject.b f99639f;

    /* renamed from: g, reason: collision with root package name */
    protected b f99640g;

    /* renamed from: h, reason: collision with root package name */
    protected f f99641h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.common.danmaku.tool.c f99642i;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(com.tencent.common.danmaku.inject.b bVar, b bVar2, Comparator<com.tencent.common.danmaku.data.a> comparator, f fVar, com.tencent.common.danmaku.tool.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, bVar2, comparator, fVar, cVar);
            return;
        }
        this.f99639f = bVar;
        this.f99640g = bVar2;
        this.f99641h = fVar;
        this.f99642i = cVar;
        this.f99637d = new com.tencent.common.danmaku.render.b(bVar2);
        this.f99635b = new TreeSet<>(comparator);
        this.f99636c = new LinkedList();
        n();
    }

    private void f(Canvas canvas, com.tencent.common.danmaku.inject.b bVar, long j3) {
        ArrayList<com.tencent.common.danmaku.render.e> arrayList = this.f99638e;
        if (arrayList != null && canvas != null) {
            Iterator<com.tencent.common.danmaku.render.e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(canvas, bVar, j3);
            }
        }
    }

    public static a j(com.tencent.common.danmaku.inject.b bVar, b bVar2, Comparator<com.tencent.common.danmaku.data.a> comparator, f fVar, com.tencent.common.danmaku.tool.c cVar) {
        return bVar.e(bVar, bVar2, comparator, fVar, cVar);
    }

    public void a(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.f99635b.add(aVar);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f99636c.clear();
        }
    }

    public abstract void c();

    public final void d(Canvas canvas, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, Long.valueOf(j3));
        } else {
            l(canvas, j3);
            f(canvas, this.f99639f, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Canvas canvas, com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas, (Object) aVar);
            return;
        }
        this.f99637d.a(canvas, aVar, this.f99639f, this.f99639f.g(aVar));
        aVar.a();
    }

    public void g(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        aVar.l0(true);
        aVar.q0(true);
        float y16 = aVar.y();
        DanmakuMeasureManager.c(this.f99639f, aVar);
        aVar.o0((aVar.y() + aVar.F()) / (y16 + aVar.F()));
    }

    public List<com.tencent.common.danmaku.data.a> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f99636c;
    }

    public abstract void i();

    public abstract com.tencent.common.danmaku.data.a k(h hVar);

    public abstract void l(Canvas canvas, long j3);

    public abstract void m(com.tencent.common.danmaku.data.a aVar);

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public abstract void o(com.tencent.common.danmaku.data.a aVar);
}
