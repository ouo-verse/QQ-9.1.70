package com.tencent.luggage.wxa.u1;

import android.content.Context;
import android.os.Looper;
import android.widget.FrameLayout;
import com.tencent.luggage.wxa.h6.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.magicbrush.MBRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Context f142048a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.u1.d f142049b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.u1.a f142050c;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.magicbrush.b f142053f;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f142051d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Queue f142052e = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public f f142054g = new f(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = e.this.f142052e.iterator();
            while (it.hasNext()) {
                e.this.f142050c.a((String) it.next());
            }
            e.this.f142052e.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f142056a;

        public b(String str) {
            this.f142056a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f142050c != null) {
                e.this.f142050c.a(this.f142056a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public i f142058a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.magicbrush.b f142059b;

        /* renamed from: c, reason: collision with root package name */
        public FrameLayout f142060c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f142061d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f142062e;

        /* renamed from: f, reason: collision with root package name */
        public d f142063f = null;

        public c a(d dVar) {
            this.f142063f = dVar;
            return this;
        }

        public c b(boolean z16) {
            this.f142061d = z16;
            return this;
        }

        public c a(i iVar) {
            this.f142058a = iVar;
            return this;
        }

        public c a(com.tencent.magicbrush.b bVar) {
            this.f142059b = bVar;
            return this;
        }

        public c a(FrameLayout frameLayout) {
            this.f142060c = frameLayout;
            return this;
        }

        public c a(boolean z16) {
            this.f142062e = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(List list);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u1.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC6780e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public com.tencent.luggage.wxa.u1.d f142064a;

        /* renamed from: b, reason: collision with root package name */
        public f f142065b;

        public RunnableC6780e() {
        }

        public /* synthetic */ RunnableC6780e(a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            if (this.f142064a != null && (fVar = this.f142065b) != null) {
                fVar.release(this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends com.tencent.luggage.wxa.e2.b {
        public f() {
        }

        @Override // com.tencent.luggage.wxa.e2.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public RunnableC6780e a() {
            return new RunnableC6780e(null);
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public final void c() {
        this.f142051d = 2;
        this.f142054g.b();
        this.f142053f = null;
        if (this.f142050c != null) {
            this.f142050c.b();
            this.f142050c = null;
        }
        com.tencent.luggage.wxa.u1.d dVar = this.f142049b;
        if (dVar != null) {
            dVar.b();
            this.f142049b = null;
        }
    }

    public void a(c cVar) {
        this.f142053f = cVar.f142059b;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f142051d != 0) {
                return;
            }
            this.f142048a = cVar.f142060c.getContext();
            if (cVar.f142061d) {
                a(this.f142053f, cVar.f142063f);
            }
            if (cVar.f142062e) {
                a(cVar.f142058a, this.f142053f);
            }
            a(cVar.f142060c);
            synchronized (this.f142052e) {
                if (this.f142051d != 0) {
                    return;
                }
                this.f142051d = 1;
                if (cVar.f142062e) {
                    a();
                }
                return;
            }
        }
        throw new IllegalStateException("You can only init GameInspector in main thread.");
    }

    public void b() {
        c();
    }

    public final void a() {
        if (this.f142050c != null) {
            this.f142050c.a(new a());
        }
    }

    public void a(String str) {
        w.d("MicroMsg.GameInspector", "hy: on js logged : %s", str);
        synchronized (this.f142052e) {
            if (this.f142051d != 1) {
                this.f142052e.add(str);
            } else {
                if (this.f142050c == null) {
                    return;
                }
                this.f142050c.a(new b(str));
            }
        }
    }

    public void a(i iVar, com.tencent.magicbrush.b bVar) {
        this.f142050c = com.tencent.luggage.wxa.u1.a.a(bVar, this.f142048a, iVar);
    }

    public final void a(MBRuntime mBRuntime, d dVar) {
        com.tencent.luggage.wxa.u1.d dVar2 = new com.tencent.luggage.wxa.u1.d(this.f142048a);
        this.f142049b = dVar2;
        dVar2.a(dVar);
    }

    public final void a(FrameLayout frameLayout) {
        frameLayout.setClipChildren(false);
        float f16 = this.f142048a.getResources().getDisplayMetrics().density;
        if (this.f142050c != null) {
            frameLayout.addView(this.f142050c.e(), new FrameLayout.LayoutParams(-1, -1));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388693;
            layoutParams.bottomMargin = (int) (55.0f * f16);
            int i3 = (int) (15.0f * f16);
            layoutParams.rightMargin = i3;
            layoutParams.leftMargin = i3;
            frameLayout.addView(this.f142050c.c(), layoutParams);
        }
        if (this.f142049b != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = l.f126905a.a(this.f142048a);
            layoutParams2.leftMargin = (int) (f16 * 16.0f);
            frameLayout.addView(this.f142049b, layoutParams2);
        }
    }
}
