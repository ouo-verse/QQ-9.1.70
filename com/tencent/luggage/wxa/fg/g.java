package com.tencent.luggage.wxa.fg;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.h0;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    public static final Map f126155h = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f126158c;

    /* renamed from: e, reason: collision with root package name */
    public h0.a f126160e;

    /* renamed from: f, reason: collision with root package name */
    public h0.a f126161f;

    /* renamed from: g, reason: collision with root package name */
    public h0.a f126162g;

    /* renamed from: a, reason: collision with root package name */
    public boolean f126156a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f126157b = "";

    /* renamed from: d, reason: collision with root package name */
    public final f f126159d = new f();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public int f126163a = 0;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f126164b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f126165c;

        public a(ViewTreeObserver viewTreeObserver, b bVar) {
            this.f126164b = viewTreeObserver;
            this.f126165c = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3 = this.f126163a + 1;
            this.f126163a = i3;
            if (i3 < 2) {
                return;
            }
            if (this.f126164b.isAlive()) {
                this.f126164b.removeOnGlobalLayoutListener(this);
            }
            this.f126165c.a("onGlobalLayout");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f126167a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h0.a f126168b;

        public b(h0.a aVar) {
            this.f126168b = aVar;
        }

        public void a(String str) {
            if (!this.f126167a.getAndSet(true)) {
                w.g("MicroMsg.OrientationConfigListenerHelper", "dispatch (%s), appId:%s, orientation:%s", str, g.this.f126157b, this.f126168b);
                g.this.b(this.f126168b);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a("timeout");
        }
    }

    public g() {
        h0.a aVar = h0.a.NONE;
        this.f126160e = aVar;
        this.f126161f = aVar;
        this.f126162g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar.getContext() != null) {
            h0.a a16 = a(dVar.getContext().getResources().getConfiguration());
            this.f126161f = a16;
            b(a16);
        }
    }

    public static void d(com.tencent.luggage.wxa.xd.d dVar) {
        g a16 = a(dVar.getAppId(), false);
        if (a16 != null) {
            a16.a();
        }
    }

    public final void c(final com.tencent.luggage.wxa.xd.d dVar) {
        this.f126157b = dVar.getAppId();
        this.f126158c = dVar;
        this.f126156a = true;
        this.f126159d.setContext(dVar);
        com.tencent.luggage.wxa.zp.h.f146825d.a(new Runnable() { // from class: com.tencent.luggage.wxa.fg.k
            @Override // java.lang.Runnable
            public final void run() {
                g.this.b(dVar);
            }
        });
        w.d("MicroMsg.OrientationConfigListenerHelper", "startListen appId:%s", this.f126157b);
    }

    public static g a(String str, boolean z16) {
        com.tencent.luggage.wxa.er.a.a(TextUtils.isEmpty(str));
        Map map = f126155h;
        synchronized (map) {
            g gVar = (g) map.get(str);
            if (gVar == null) {
                if (!z16) {
                    return null;
                }
                gVar = new g();
                gVar.f126157b = str;
                map.put(str, gVar);
            }
            return gVar;
        }
    }

    public final void b(Configuration configuration) {
        this.f126161f = a(configuration);
        w.d("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppId:%s, mEnable:%b, mOrientation:%s, mConfiguration:%s", this.f126157b, Boolean.valueOf(this.f126156a), this.f126160e, this.f126161f);
        if (this.f126156a) {
            c(this.f126161f);
        }
    }

    public final void c(h0.a aVar) {
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        com.tencent.luggage.wxa.xd.d dVar = this.f126158c;
        if (dVar == null) {
            return;
        }
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(dVar.getContext());
        if (a16 != null && (window = a16.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            b bVar = new b(aVar);
            viewTreeObserver.addOnGlobalLayoutListener(new a(viewTreeObserver, bVar));
            com.tencent.luggage.wxa.zp.h.f146825d.c(bVar, 100L);
            return;
        }
        b(aVar);
    }

    public final synchronized void b(h0.a aVar) {
        if (aVar == this.f126162g) {
            w.f("MicroMsg.OrientationConfigListenerHelper", "hy: unexpected redundant orientation fired");
        } else {
            this.f126162g = aVar;
            this.f126159d.a(aVar);
        }
    }

    public static void a(String str) {
        g gVar;
        com.tencent.luggage.wxa.er.a.a(TextUtils.isEmpty(str));
        Map map = f126155h;
        synchronized (map) {
            gVar = (g) map.remove(str);
        }
        if (gVar != null) {
            gVar.a();
        }
    }

    public static g a(com.tencent.luggage.wxa.xd.d dVar) {
        g a16 = a(dVar.getAppId(), true);
        Objects.requireNonNull(a16);
        a16.c(dVar);
        return a16;
    }

    public final void a() {
        w.d("MicroMsg.OrientationConfigListenerHelper", "stopListen appId:%s", this.f126157b);
        this.f126157b = "";
        this.f126158c = null;
        this.f126156a = false;
        this.f126161f = h0.a.NONE;
    }

    public static void a(String str, Configuration configuration) {
        g a16 = a(str, true);
        Objects.requireNonNull(a16);
        a16.b(configuration);
    }

    public final h0.a a(Configuration configuration) {
        int i3 = configuration.orientation;
        if (i3 == 2) {
            h0.a aVar = this.f126160e;
            h0.a aVar2 = h0.a.REVERSE_LANDSCAPE;
            return aVar == aVar2 ? aVar2 : h0.a.LANDSCAPE;
        }
        if (i3 == 1) {
            return h0.a.PORTRAIT;
        }
        return h0.a.NONE;
    }

    public void a(h0.a aVar) {
        this.f126160e = aVar;
        if (this.f126156a) {
            h0.a aVar2 = this.f126161f;
            h0.a aVar3 = h0.a.LANDSCAPE;
            if (aVar2 == aVar3 || aVar2 == h0.a.REVERSE_LANDSCAPE) {
                if (aVar == h0.a.REVERSE_LANDSCAPE || aVar == aVar3) {
                    c(aVar);
                    w.d("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + this.f126157b + "; mOrientation:" + aVar.name());
                }
            }
        }
    }
}
