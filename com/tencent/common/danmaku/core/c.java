package com.tencent.common.danmaku.core;

import com.tencent.common.danmaku.core.DanmakuManager;
import com.tencent.common.danmaku.tool.f;
import com.tencent.common.danmaku.tool.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<com.tencent.common.danmaku.data.a> f99645a;

    /* renamed from: b, reason: collision with root package name */
    private final g<com.tencent.common.danmaku.data.a> f99646b;

    /* renamed from: c, reason: collision with root package name */
    private final f f99647c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f99648d;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f99649e;

    /* renamed from: f, reason: collision with root package name */
    private int f99650f;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements g.b<com.tencent.common.danmaku.data.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.common.danmaku.tool.g.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(com.tencent.common.danmaku.data.a aVar, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, aVar, Long.valueOf(j3))).intValue();
            }
            if (aVar == null) {
                return -1;
            }
            long H = aVar.H() - j3;
            if (H == 0) {
                return 0;
            }
            if (H > 0) {
                return 1;
            }
            return -1;
        }
    }

    public c(f fVar, DanmakuManager.DanmakuComparator danmakuComparator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) danmakuComparator);
            return;
        }
        this.f99649e = -1L;
        this.f99650f = 3;
        this.f99647c = fVar;
        this.f99646b = new g<>(danmakuComparator, new a());
        this.f99645a = new LinkedList();
        this.f99648d = new AtomicBoolean(false);
    }

    private void f() {
        while (!this.f99648d.compareAndSet(false, true)) {
            com.tencent.common.danmaku.util.e.b("DanmakuDataSource", "lock is blocked");
            Thread.yield();
        }
    }

    private void i() {
        while (!this.f99648d.compareAndSet(true, false)) {
            com.tencent.common.danmaku.util.e.c("DanmakuDataSource", "update end is blocked! this can not happend!");
            Thread.yield();
        }
    }

    private void j(List<com.tencent.common.danmaku.data.a> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            com.tencent.common.danmaku.data.a aVar = list.get(size);
            if (aVar.H() <= this.f99649e) {
                aVar.c();
            }
        }
    }

    public void a(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        f();
        com.tencent.common.danmaku.util.e.e("DanmakuDataSource", "addLast: danmaku = ", aVar);
        this.f99646b.b(aVar);
        i();
    }

    public void b(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        f();
        com.tencent.common.danmaku.util.e.e("DanmakuDataSource", "addNow: danmaku = ", aVar);
        this.f99646b.a(aVar);
        i();
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.common.danmaku.util.e.g("DanmakuDataSource", "clear danmaku queue");
        f();
        this.f99646b.d();
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.tencent.common.danmaku.data.a> d() {
        f();
        this.f99646b.g(this.f99647c.a(), this.f99645a, this.f99650f);
        j(this.f99645a);
        i();
        return this.f99645a;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        List<com.tencent.common.danmaku.data.a> list = this.f99645a;
        if (list != null && list.size() > 0) {
            return true;
        }
        g<com.tencent.common.danmaku.data.a> gVar = this.f99646b;
        if (gVar != null && gVar.h() > 0) {
            return true;
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        f();
        com.tencent.common.danmaku.data.a f16 = this.f99646b.f();
        if (f16 == null) {
            this.f99649e = -1L;
        } else {
            this.f99649e = f16.H();
        }
        i();
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else if (i3 > 0) {
            this.f99650f = i3;
        }
    }
}
