package com.tencent.luggage.wxa.q5;

import android.os.Looper;
import com.tencent.luggage.wxa.ei.u;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.q5.a;
import com.tencent.luggage.wxa.q5.e;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements com.tencent.luggage.wxa.q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f f137833a;

    /* renamed from: b, reason: collision with root package name */
    public final f f137834b;

    /* renamed from: c, reason: collision with root package name */
    public h f137835c = h.NOT_PRELOAD;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f137836d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public final Queue f137837e = new ConcurrentLinkedQueue();

    /* renamed from: f, reason: collision with root package name */
    public final Queue f137838f = new ConcurrentLinkedQueue();

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f137839g = false;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f137840h = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f137841a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q5.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6618a implements e.c {
            public C6618a() {
            }

            @Override // com.tencent.luggage.wxa.q5.e.c
            public void a() {
                b.this.f();
            }

            @Override // com.tencent.luggage.wxa.q5.e.c
            public void b() {
                b.this.f();
            }
        }

        public a(g gVar) {
            this.f137841a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("Luggage.RuntimePreloader[applaunch]", "preInit start");
            c0.a(-2);
            if (this.f137841a.f137850b) {
                b.this.f();
                w.d("Luggage.RuntimePreloader[applaunch]", "init skyline");
            } else if (com.tencent.luggage.wxa.q5.e.e()) {
                b.this.f();
                w.d("Luggage.RuntimePreloader[applaunch]", "webview already init done");
            } else {
                com.tencent.luggage.wxa.q5.e.a(new C6618a());
                w.d("Luggage.RuntimePreloader[applaunch]", "misc preload done");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q5.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6619b implements Runnable {
        public RunnableC6619b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.g();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f137845a;

        public c(l lVar) {
            this.f137845a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            u uVar = (u) this.f137845a.getJsRuntime().a(u.class);
            if (uVar != null) {
                uVar.pause();
            }
            w.d("Luggage.RuntimePreloader[applaunch]", "preloadService done");
            synchronized (b.class) {
                b.this.f137839g = true;
                b.this.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    synchronized (b.class) {
                        if (b.this.f137837e.size() <= 0 && !WebView.isSys()) {
                            v vVar = (v) b.this.f137834b.create();
                            if (vVar instanceof com.tencent.luggage.wxa.m4.b) {
                                ((com.tencent.luggage.wxa.m4.b) vVar).a(com.tencent.luggage.wxa.dk.a.PreloadOnProcessCreated);
                            } else {
                                vVar.i1();
                            }
                            synchronized (b.class) {
                                b.this.f137837e.add(vVar);
                            }
                            w.d("Luggage.RuntimePreloader[applaunch]", "preloadPageView done");
                            synchronized (b.class) {
                                b.this.f137840h = true;
                                b.this.e();
                            }
                            return;
                        }
                        w.d("Luggage.RuntimePreloader[applaunch]", "preloadPageView, queue.size:%d, WebView.isSys:%b", Integer.valueOf(b.this.f137837e.size()), Boolean.valueOf(WebView.isSys()));
                        w.d("Luggage.RuntimePreloader[applaunch]", "preloadPageView done");
                        synchronized (b.class) {
                            b.this.f137840h = true;
                            b.this.e();
                        }
                    }
                } catch (Exception e16) {
                    w.b("Luggage.RuntimePreloader[applaunch]", "preload page e = %s", e16);
                    w.d("Luggage.RuntimePreloader[applaunch]", "preloadPageView done");
                    synchronized (b.class) {
                        b.this.f137840h = true;
                        b.this.e();
                    }
                }
            } catch (Throwable th5) {
                w.d("Luggage.RuntimePreloader[applaunch]", "preloadPageView done");
                synchronized (b.class) {
                    b.this.f137840h = true;
                    b.this.e();
                    throw th5;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f137848a;

        static {
            int[] iArr = new int[h.values().length];
            f137848a = iArr;
            try {
                iArr[h.PRELOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f137848a[h.PRELOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        Object create();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public boolean f137849a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f137850b;

        public String toString() {
            return "PreloadOptions{keepService=" + this.f137849a + ", skipWebView=" + this.f137850b + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum h {
        NOT_PRELOAD,
        PRELOADING,
        PRELOADED
    }

    public b(f fVar, f fVar2) {
        this.f137833a = fVar;
        this.f137834b = fVar2;
    }

    public final void f() {
        d dVar = new d();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            dVar.run();
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.a(dVar);
        }
    }

    public final void g() {
        try {
            synchronized (b.class) {
                if (this.f137838f.size() > 0) {
                    return;
                }
                l lVar = (l) this.f137833a.create();
                lVar.Z();
                com.tencent.luggage.wxa.zp.h.f146825d.a(new c(lVar));
                synchronized (b.class) {
                    this.f137838f.add(lVar);
                }
            }
        } catch (Exception e16) {
            w.b("Luggage.RuntimePreloader[applaunch]", "preload service e = %s", e16);
            synchronized (b.class) {
                this.f137839g = true;
                e();
            }
        }
    }

    public final void h() {
        LinkedList linkedList;
        LinkedList linkedList2;
        w.a("Luggage.RuntimePreloader[applaunch]", "reset");
        synchronized (b.class) {
            this.f137835c = h.NOT_PRELOAD;
            this.f137836d.clear();
            linkedList = new LinkedList(this.f137837e);
            this.f137837e.clear();
            linkedList2 = new LinkedList(this.f137838f);
            this.f137838f.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            try {
                ((v) it.next()).e();
            } catch (Exception unused) {
            }
        }
        Iterator it5 = linkedList2.iterator();
        while (it5.hasNext()) {
            try {
                ((l) it5.next()).e();
            } catch (Exception unused2) {
            }
        }
    }

    public final void i() {
        LinkedList linkedList;
        w.a("Luggage.RuntimePreloader[applaunch]", "reset page view");
        synchronized (b.class) {
            this.f137835c = h.NOT_PRELOAD;
            this.f137836d.clear();
            linkedList = new LinkedList(this.f137837e);
            this.f137837e.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            try {
                ((v) it.next()).e();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public boolean c() {
        synchronized (b.class) {
            int i3 = e.f137848a[this.f137835c.ordinal()];
            boolean z16 = false;
            if (i3 != 1) {
                return i3 != 2;
            }
            if (this.f137838f.isEmpty() && this.f137837e.isEmpty()) {
                z16 = true;
            }
            return z16;
        }
    }

    public void d() {
        w.d("Luggage.RuntimePreloader[applaunch]", "preInit finished, currentState=%s, callbacks.size=%d", this.f137835c, Integer.valueOf(this.f137836d.size()));
        this.f137835c = h.PRELOADED;
        LinkedList<a.InterfaceC6617a> linkedList = new LinkedList(this.f137836d);
        this.f137836d.clear();
        for (a.InterfaceC6617a interfaceC6617a : linkedList) {
            if (interfaceC6617a != null) {
                interfaceC6617a.onReady();
            }
        }
    }

    public final void e() {
        synchronized (b.class) {
            w.d("Luggage.RuntimePreloader[applaunch]", "notifyDoneIfAllReady, service:%b, page:%b", Boolean.valueOf(this.f137839g), Boolean.valueOf(this.f137840h));
            if (this.f137839g && this.f137840h) {
                d();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public void a(a.InterfaceC6617a interfaceC6617a, boolean z16, boolean z17) {
        g gVar = new g();
        gVar.f137849a = z17;
        a(interfaceC6617a, z16, gVar);
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public v b(String str) {
        v vVar;
        synchronized (b.class) {
            vVar = (v) this.f137837e.poll();
        }
        return vVar;
    }

    public void a(a.InterfaceC6617a interfaceC6617a, boolean z16, g gVar) {
        h hVar;
        h hVar2;
        synchronized (b.class) {
            w.d("Luggage.RuntimePreloader[applaunch]", "preload forcePreload:%b, currentState:%s options:%s", Boolean.valueOf(z16), this.f137835c, gVar);
            h hVar3 = this.f137835c;
            hVar = h.PRELOADED;
            if (hVar3 == hVar && z16) {
                if (gVar.f137849a) {
                    i();
                } else {
                    h();
                }
            }
            hVar2 = this.f137835c;
            if (hVar2 == h.NOT_PRELOAD || hVar2 == h.PRELOADING) {
                if (interfaceC6617a != null) {
                    this.f137836d.add(interfaceC6617a);
                }
                this.f137835c = h.PRELOADING;
                if (this.f137838f.isEmpty()) {
                    this.f137839g = false;
                }
                if (this.f137837e.isEmpty()) {
                    this.f137840h = false;
                }
            }
        }
        if (hVar2 == h.PRELOADING) {
            return;
        }
        if (hVar2 == hVar) {
            if (interfaceC6617a != null) {
                interfaceC6617a.onReady();
            }
        } else {
            w.d("Luggage.RuntimePreloader[applaunch]", "TRACE_ORDER:RuntimePreloader.java");
            com.tencent.luggage.wxa.zp.h.f146825d.b(new a(gVar), "_PreInitWebView");
            com.tencent.luggage.wxa.zp.h.f146825d.b(new RunnableC6619b(), "_PreloadService");
        }
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public final boolean b() {
        boolean z16;
        synchronized (b.class) {
            z16 = this.f137835c == h.PRELOADED;
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public boolean a(a.InterfaceC6617a interfaceC6617a) {
        synchronized (b.class) {
            w.d("Luggage.RuntimePreloader[applaunch]", "Checking shouldWaitPreloading.. mCurrentPreloadState is [%s] ", this.f137835c.name());
            if (this.f137835c != h.PRELOADING) {
                return false;
            }
            if (interfaceC6617a != null) {
                this.f137836d.add(interfaceC6617a);
            }
            return true;
        }
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public l a() {
        l lVar;
        synchronized (b.class) {
            lVar = (l) this.f137838f.peek();
        }
        return lVar;
    }

    @Override // com.tencent.luggage.wxa.q5.a
    public l a(String str) {
        h hVar;
        l lVar;
        synchronized (b.class) {
            hVar = this.f137835c;
            lVar = (l) this.f137838f.poll();
        }
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = hVar.name();
        objArr[2] = Integer.valueOf(lVar == null ? 0 : lVar.hashCode());
        w.d("Luggage.RuntimePreloader[applaunch]", "getServices appID:%s, state:%s, service:%d", objArr);
        if (hVar == h.NOT_PRELOAD) {
            w.d("Luggage.RuntimePreloader[applaunch]", "RuntimePreloader not preload, just return null");
            return null;
        }
        if (hVar != h.PRELOADING) {
            return lVar;
        }
        w.a("Luggage.RuntimePreloader[applaunch]", new IllegalStateException(), "RuntimePreloader is preloading when getServices, it need to wait! software fall in panic !", new Object[0]);
        return null;
    }
}
