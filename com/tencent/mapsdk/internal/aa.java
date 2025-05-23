package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class aa implements bc, op {

    /* renamed from: a, reason: collision with root package name */
    public static final int f147667a = 60;

    /* renamed from: m, reason: collision with root package name */
    private static final int f147668m = 200;

    /* renamed from: d, reason: collision with root package name */
    public a f147671d;

    /* renamed from: f, reason: collision with root package name */
    jq f147673f;

    /* renamed from: g, reason: collision with root package name */
    long f147674g;

    /* renamed from: h, reason: collision with root package name */
    boolean f147675h;

    /* renamed from: i, reason: collision with root package name */
    fs f147676i;

    /* renamed from: j, reason: collision with root package name */
    boolean f147677j;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<jn> f147669b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f147670c = new byte[0];

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<jn> f147678k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<jn> f147679l = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public int f147672e = 60;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends BaseThread {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<aa> f147680a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f147681b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f147682c;

        public a(aa aaVar) {
            super("tms-act");
            this.f147680a = new WeakReference<>(aaVar);
        }

        public final synchronized void a() {
            this.f147682c = true;
        }

        public final synchronized void b() {
            this.f147682c = false;
        }

        @Override // java.lang.Thread
        public final synchronized void destroy() {
            this.f147681b = false;
            interrupt();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            aa aaVar;
            while (this.f147681b && (aaVar = this.f147680a.get()) != null) {
                if (!this.f147682c) {
                    jq jqVar = aaVar.f147673f;
                    if (jqVar != null) {
                        jqVar.c(jn.G);
                    }
                    if (aaVar.f147675h && SystemClock.elapsedRealtime() - aaVar.f147674g > 50 && !aaVar.f147677j) {
                        aaVar.f147675h = false;
                        LogUtil.b(ky.f149101g, "notify onStable");
                        fs fsVar = aaVar.f147676i;
                        if (fsVar != null) {
                            fsVar.u();
                        }
                    }
                }
                try {
                    synchronized (this) {
                        wait(aaVar.c());
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread
        public final synchronized void start() {
            this.f147681b = true;
            super.start();
        }
    }

    public aa(jq jqVar) {
        this.f147673f = jqVar;
        jm.d(c());
    }

    private static /* synthetic */ boolean e(aa aaVar) {
        aaVar.f147675h = false;
        return false;
    }

    private void h() {
        a aVar = this.f147671d;
        if (aVar != null) {
            aVar.destroy();
        }
        a aVar2 = new a(this);
        this.f147671d = aVar2;
        aVar2.start();
    }

    private void i() {
        a aVar = this.f147671d;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    private void j() {
        this.f147672e = 60;
    }

    private int k() {
        return this.f147672e;
    }

    private void m() {
        jq jqVar = this.f147673f;
        if (jqVar != null) {
            jqVar.c(jn.G);
        }
    }

    public final void a() {
        a aVar = this.f147671d;
        if (aVar != null) {
            aVar.a();
        }
        e();
    }

    @Override // com.tencent.mapsdk.internal.op
    public final void d() {
    }

    public final boolean g() {
        boolean isEmpty;
        synchronized (this.f147670c) {
            if (this.f147669b.isEmpty()) {
                return false;
            }
            jn jnVar = this.f147669b.get(0);
            if (jnVar != null && jnVar.a(this.f147673f)) {
                synchronized (this.f147670c) {
                    this.f147669b.remove(jnVar);
                }
            }
            synchronized (this.f147670c) {
                isEmpty = this.f147669b.isEmpty();
            }
            if (isEmpty) {
                return false;
            }
            return true;
        }
    }

    public final void b() {
        a aVar = this.f147671d;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final long c() {
        long j3 = 1000 / this.f147672e;
        if (j3 == 0) {
            return 1L;
        }
        return j3;
    }

    public final void e() {
        synchronized (this.f147670c) {
            this.f147679l.clear();
            this.f147678k.clear();
            Iterator<jn> it = this.f147669b.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                jn next = it.next();
                if (next.D) {
                    this.f147678k.add(next);
                    z16 = true;
                } else {
                    this.f147679l.add(next);
                }
            }
            this.f147669b.clear();
            if (z16) {
                ArrayList<jn> arrayList = this.f147669b;
                this.f147669b = this.f147678k;
                this.f147678k = arrayList;
            }
            if (this.f147679l.size() > 0) {
                Iterator<jn> it5 = this.f147679l.iterator();
                while (it5.hasNext()) {
                    it5.next().b();
                }
            }
        }
    }

    public final boolean f() {
        boolean z16;
        synchronized (this.f147670c) {
            z16 = !this.f147669b.isEmpty();
        }
        return z16;
    }

    private void b(int i3) {
        synchronized (this.f147670c) {
            for (int size = this.f147669b.size() - 1; size >= 0; size--) {
                jn jnVar = this.f147669b.get(size);
                if (jnVar.f148935z == i3) {
                    this.f147669b.remove(size);
                    jnVar.b();
                }
            }
        }
    }

    public final void a(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.f147672e = i3;
    }

    private void a(fs fsVar) {
        this.f147676i = fsVar;
    }

    public final void a(jn jnVar) {
        synchronized (this.f147670c) {
            if (this.f147669b.size() > 200) {
                this.f147669b.clear();
            }
            this.f147669b.add(jnVar);
        }
    }

    private void a(double d16, double d17) {
        synchronized (this.f147670c) {
            while (!this.f147669b.isEmpty()) {
                ArrayList<jn> arrayList = this.f147669b;
                if (arrayList.get(arrayList.size() - 1).f148935z != 3) {
                    break;
                }
                ArrayList<jn> arrayList2 = this.f147669b;
                double[] dArr = arrayList2.remove(arrayList2.size() - 1).A;
                d16 += dArr[0];
                d17 += dArr[1];
            }
            a(new jn(3, new double[]{d16, d17}));
        }
    }

    @Override // com.tencent.mapsdk.internal.bc
    public final void a(v vVar) {
        this.f147675h = true;
        this.f147674g = SystemClock.elapsedRealtime();
    }

    private void a(boolean z16) {
        this.f147677j = z16;
    }

    private static /* synthetic */ void a(aa aaVar) {
        jq jqVar = aaVar.f147673f;
        if (jqVar != null) {
            jqVar.c(jn.G);
        }
    }

    private void l() {
    }
}
