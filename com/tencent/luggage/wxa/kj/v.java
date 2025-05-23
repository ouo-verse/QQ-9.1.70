package com.tencent.luggage.wxa.kj;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.luggage.wxa.fd.b;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.wj.d;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v extends com.tencent.luggage.wxa.kj.d implements com.tencent.luggage.wxa.xd.f, o1 {

    /* renamed from: x0, reason: collision with root package name */
    public static final int f132447x0 = 2131363095;
    public final int I;
    public com.tencent.luggage.wxa.kj.x J;
    public final Class K;
    public volatile com.tencent.luggage.wxa.ic.g L;
    public String M;
    public String N;
    public ViewGroup O;
    public com.tencent.luggage.wxa.kl.d P;
    public com.tencent.luggage.wxa.kl.b Q;
    public FrameLayout R;
    public c0 S;
    public r0 T;
    public o0 U;
    public com.tencent.luggage.wxa.fi.a V;
    public com.tencent.luggage.wxa.kj.c W;
    public volatile boolean X;
    public volatile boolean Y;
    public volatile boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f132448a0;

    /* renamed from: b0, reason: collision with root package name */
    public i.b f132449b0;

    /* renamed from: c0, reason: collision with root package name */
    public com.tencent.luggage.wxa.wj.d f132450c0;

    /* renamed from: d0, reason: collision with root package name */
    public List f132451d0;

    /* renamed from: e0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.am.a f132452e0;

    /* renamed from: f0, reason: collision with root package name */
    public com.tencent.luggage.wxa.kj.n f132453f0;

    /* renamed from: g0, reason: collision with root package name */
    public i1 f132454g0;

    /* renamed from: h0, reason: collision with root package name */
    public com.tencent.luggage.wxa.wj.c f132455h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f132456i0;

    /* renamed from: j0, reason: collision with root package name */
    public final LinkedList f132457j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f132458k0;

    /* renamed from: l0, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ml.p f132459l0;

    /* renamed from: m0, reason: collision with root package name */
    public com.tencent.luggage.wxa.nk.c f132460m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f132461n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean[] f132462o0;

    /* renamed from: p0, reason: collision with root package name */
    public final Object f132463p0;

    /* renamed from: q0, reason: collision with root package name */
    public int[] f132464q0;

    /* renamed from: r0, reason: collision with root package name */
    public int[] f132465r0;

    /* renamed from: s0, reason: collision with root package name */
    public Integer f132466s0;

    /* renamed from: t0, reason: collision with root package name */
    public n1 f132467t0;

    /* renamed from: u0, reason: collision with root package name */
    public final AtomicBoolean f132468u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f132469v0;

    /* renamed from: w0, reason: collision with root package name */
    public volatile LifecycleOwner f132470w0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.kj.o {

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Runnable f132471h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Runnable f132472i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v vVar, List list, boolean z16, Runnable runnable, Runnable runnable2) {
            super(vVar, list, z16);
            this.f132471h = runnable;
            this.f132472i = runnable2;
            d(runnable);
            c(runnable2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class a0 extends RelativeLayout implements com.tencent.luggage.wxa.hp.a {
        public a0(Context context) {
            super(context);
        }

        @Override // com.tencent.luggage.wxa.hp.a
        public boolean a(Canvas canvas) {
            Bitmap w06 = v.this.w0();
            if (w06 != null) {
                canvas.drawBitmap(w06, 0.0f, v.this.R.getTop(), (Paint) null);
            }
            if (v.this.Q != null && !v.this.Q.k()) {
                v.this.P.draw(canvas);
                return true;
            }
            return true;
        }

        @Override // android.view.View
        public boolean post(Runnable runnable) {
            if (runnable == null) {
                return false;
            }
            if (v.this.a(this, runnable)) {
                return true;
            }
            return super.post(runnable);
        }

        @Override // android.view.View
        public boolean postDelayed(Runnable runnable, long j3) {
            if (runnable == null) {
                return false;
            }
            if (v.this.a(this, runnable, j3)) {
                return true;
            }
            return super.postDelayed(runnable, j3);
        }

        @Override // android.view.View
        public void setBackgroundColor(int i3) {
            super.setBackgroundColor(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.wj.d.a
        public ViewGroup a(View view) {
            return v.this.S.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends com.tencent.luggage.wxa.wj.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.wj.b
        public void i() {
            v.this.Y0();
        }

        @Override // com.tencent.luggage.wxa.wj.b
        public void j() {
            v.this.l1();
            v.this.Z0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends h0 {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.kj.h0
        public com.tencent.luggage.wxa.xd.f a() {
            return v.this;
        }

        @Override // com.tencent.luggage.wxa.kj.h0
        public com.tencent.luggage.wxa.xd.d b() {
            return v.this.y0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!v.this.isRunning()) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageView", "onInitReady but not running, return, appId[%s] url[%s]", v.this.getAppId(), v.this.A0());
                return;
            }
            v.this.getRuntime().N().a(v.this.f132459l0);
            if (v.this.v0() != null) {
                v.this.v0().p();
            }
            v.this.g1();
            v.this.J();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.f(false);
            v.this.W().setFullscreenMode(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.f(true);
            v.this.W().setFullscreenMode(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double f132481a;

        public h(double d16) {
            this.f132481a = d16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.W().setBackgroundAlpha(this.f132481a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f132483a;

        public i(int i3) {
            this.f132483a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.W().setBackgroundColor(this.f132483a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132485a;

        public j(String str) {
            this.f132485a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.W().setMainTitle(this.f132485a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements com.tencent.luggage.wxa.ml.p {
        public k() {
        }

        @Override // com.tencent.luggage.wxa.ml.p
        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                v.this.c(false);
            } else {
                v.this.c(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132488a;

        public l(String str) {
            this.f132488a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.W().setForegroundStyle(this.f132488a);
            v.this.k(this.f132488a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f132490a;

        public m(int i3) {
            this.f132490a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.W().setForegroundColor(this.f132490a);
            v.this.k(i.b.a(this.f132490a).name());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f132492a;

        public n(boolean z16) {
            this.f132492a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.W() == null) {
                return;
            }
            v.this.W().setLoadingIconVisibility(this.f132492a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o extends AnimatorListenerAdapter {
        public o() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            v.this.f132457j0.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v.this.f132457j0.remove(animator);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v.this.P == null) {
                return;
            }
            v.this.P.m();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f132496a;

        public q(String str) {
            this.f132496a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            if (v.this.P != null) {
                com.tencent.luggage.wxa.kl.d dVar = v.this.P;
                if (i.b.a(this.f132496a) == i.b.BLACK) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                dVar.setStatusBarForegroundStyle(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class r {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f132498a;

        static {
            int[] iArr = new int[k1.values().length];
            f132498a = iArr;
            try {
                iArr[k1.REDIRECT_TO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f132498a[k1.RE_LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f132498a[k1.AUTO_RE_LAUNCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f132498a[k1.NAVIGATE_BACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f132498a[k1.REWRITE_ROUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f132498a[k1.DISMISS_PIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f132498a[k1.RELOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class s implements LifecycleOwner {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f132499a = new LifecycleRegistry(this);

        public s() {
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.f132499a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class t implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f132501a;

        public t(Context context) {
            this.f132501a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public View invoke() {
            View a16 = v.this.v0().a(LayoutInflater.from(this.f132501a));
            if (a16 == null) {
                return new FrameLayout(this.f132501a);
            }
            if (!(a16 instanceof FrameLayout)) {
                FrameLayout frameLayout = new FrameLayout(this.f132501a);
                frameLayout.addView(a16, new ViewGroup.LayoutParams(-1, -1));
                return frameLayout;
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class u implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f132503a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f132504b;

        public u(Context context, View view) {
            this.f132503a = context;
            this.f132504b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.O = new a0(this.f132503a);
            v vVar = v.this;
            View a16 = vVar.a(vVar.O);
            RelativeLayout.LayoutParams a17 = v.this.v0().a(this.f132504b, a16);
            if (a16 != null) {
                v.this.O.addView(this.f132504b, v.this.O.getChildCount() - 1, a17);
            } else {
                v.this.O.addView(this.f132504b, a17);
            }
            v.this.v0().a(this.f132504b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kj.v$v, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6395v implements Runnable {
        public RunnableC6395v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.G0();
            v.this.P.a(v.this.getContext());
            v.this.O.addView(v.this.P, -1, new ViewGroup.LayoutParams(-1, -2));
            v.this.v0().a(v.this.Q);
            if (v.this.Q.getParent() == v.this.P) {
            } else {
                throw new IllegalAccessError("You should not modify actionbar's view hierarchy");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!v.this.U0()) {
                v.this.L.Y().a(v.this.f132453f0, "scene_actionbar_back");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class x implements View.OnClickListener {
        public x() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.S0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class y implements com.tencent.luggage.wxa.kl.a {
        public y() {
        }

        @Override // com.tencent.luggage.wxa.kl.a
        public void a(View view) {
            v.this.U.z();
            com.tencent.luggage.wxa.kj.l.a(v.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class z implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f132510a = true;

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f132511b = new a();

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f132512c = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                z.this.f132510a = false;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                z.this.f132510a = true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!v.this.isRunning()) {
                    return;
                }
                List l06 = v.this.l0();
                if (l06 != null && l06.size() > 0) {
                    z zVar = z.this;
                    v.this.a(l06, zVar.f132511b, z.this.f132512c);
                } else {
                    com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageView", "showPageActionSheet appId[%s], url[%s], empty list skip", v.this.getAppId(), v.this.A0());
                }
            }
        }

        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            if (!this.f132510a) {
                return;
            }
            boolean a16 = com.tencent.luggage.wxa.h6.h.a(v.this.getContext());
            v vVar = v.this;
            c cVar = new c();
            if (a16) {
                i3 = 100;
            } else {
                i3 = 0;
            }
            vVar.a(cVar, i3);
        }
    }

    public v(Class cls) {
        this.I = R.id.sql;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f132448a0 = false;
        this.f132449b0 = null;
        this.f132452e0 = new com.tencent.luggage.wxa.am.a(this);
        this.f132454g0 = null;
        this.f132455h0 = new WindowAndroidActivityImpl();
        this.f132456i0 = false;
        this.f132457j0 = new LinkedList();
        this.f132458k0 = -1;
        this.f132459l0 = new k();
        this.f132460m0 = null;
        this.f132463p0 = new byte[0];
        this.f132464q0 = new int[0];
        this.f132465r0 = new int[0];
        this.f132466s0 = null;
        this.f132468u0 = new AtomicBoolean(false);
        this.f132469v0 = false;
        this.K = cls;
    }

    private void U() {
        this.Y = true;
        if (v0() != null) {
            com.tencent.luggage.wxa.mj.h hVar = (com.tencent.luggage.wxa.mj.h) v0().a(com.tencent.luggage.wxa.mj.h.class);
            if (hVar != null) {
                hVar.i();
                return;
            }
            throw new IllegalAccessError(String.format(Locale.US, "Renderer[%s] impl not supports preload", v0().getClass().getName()));
        }
    }

    private void V() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageView", "AppBrandPageViewProfile| dispatchStart");
        if (v0() != null) {
            v0().m();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public final boolean A() {
        if (v0() != null) {
            com.tencent.luggage.wxa.mj.h hVar = (com.tencent.luggage.wxa.mj.h) v0().a(com.tencent.luggage.wxa.mj.h.class);
            if (hVar != null && hVar.k()) {
                return true;
            }
            return false;
        }
        if (getRuntime() == null) {
            return true;
        }
        return false;
    }

    public final String A0() {
        synchronized (this.f132463p0) {
            if (d0() >= 1) {
                m1 a16 = this.f132467t0.a();
                Objects.requireNonNull(a16);
                return a16.c();
            }
            return this.M;
        }
    }

    public final String B0() {
        synchronized (this.f132463p0) {
            if (d0() >= 1) {
                m1 a16 = this.f132467t0.a();
                Objects.requireNonNull(a16);
                return a16.d();
            }
            return this.N;
        }
    }

    public final String C0() {
        com.tencent.luggage.wxa.mj.e eVar = (com.tencent.luggage.wxa.mj.e) f(com.tencent.luggage.wxa.mj.e.class);
        if (eVar != null) {
            return eVar.getRequestedOrientation();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.ic.d
    public com.tencent.luggage.wxa.wj.c D() {
        return this.f132455h0;
    }

    public final o0 D0() {
        return this.U;
    }

    public void E0() {
        com.tencent.luggage.wxa.kj.c cVar = this.W;
        if (cVar != null) {
            if (cVar.f132085d) {
                this.Q.setNavHidden(true);
            }
            h1();
        }
    }

    public void F0() {
        a(new g());
    }

    public final void G0() {
        h1 h1Var = h1.ACTION_BAR;
        com.tencent.luggage.wxa.kl.b bVar = (com.tencent.luggage.wxa.kl.b) a(h1Var).b(getContext(), com.tencent.luggage.wxa.kl.b.class);
        this.Q = bVar;
        bVar.getActionView().setId(this.I);
        this.Q.setBackButtonClickListener(new w());
        this.Q.setCloseButtonClickListener(new x());
        this.Q.a(new y());
        this.Q.setOptionButtonClickListener(new z());
        com.tencent.luggage.wxa.kl.d dVar = (com.tencent.luggage.wxa.kl.d) a(h1Var).b(getContext(), com.tencent.luggage.wxa.kl.d.class);
        this.P = dVar;
        dVar.setWindowAndroid(D());
        this.P.setId(f132447x0);
        this.P.setActuallyVisible(false);
        this.P.setDeferStatusBarHeightChange(false);
        this.P.addView(this.Q, new ViewGroup.LayoutParams(-1, -2));
        a((g.b) this.P);
        b((g.d) this.Q);
        a((g.b) this.Q);
    }

    public final void H0() {
        if (v0() != null) {
            Context F = getRuntime().F();
            View view = (View) com.tencent.luggage.wxa.e5.g.a("AppBrandPageViewProfile| onCreateView", new t(F));
            com.tencent.luggage.wxa.e5.g.a("AppBrandPageViewProfile| onViewCreated", new u(F, view));
            com.tencent.luggage.wxa.e5.g.a("AppBrandPageViewProfile| initActionBar", new RunnableC6395v());
            this.R = (FrameLayout) view;
            this.T = v0().g();
            this.S = v0().getCustomViewContainer();
        }
    }

    public final boolean I0() {
        return this.f132469v0;
    }

    public final boolean J0() {
        return this.f132456i0;
    }

    public boolean K0() {
        return this.f132448a0;
    }

    public boolean L0() {
        return false;
    }

    public boolean M0() {
        return this.Z;
    }

    public boolean N0() {
        if (W() != null && W().j()) {
            return true;
        }
        return false;
    }

    public boolean O0() {
        return false;
    }

    public boolean P0() {
        if (v0() != null) {
            return v0().b();
        }
        return false;
    }

    public final boolean Q0() {
        boolean z16;
        if (this.f132462o0 == null) {
            if (v0() != null && v0().d()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f132462o0 = new boolean[]{z16};
        }
        return this.f132462o0[0];
    }

    public final void R0() {
        this.f132456i0 = true;
    }

    public List S() {
        return Collections.emptyList();
    }

    public void S0() {
        com.tencent.luggage.wxa.ic.e.a(getAppId(), e.d.CLOSE);
        this.L.o();
    }

    public void T() {
        com.tencent.luggage.wxa.fi.a aVar = this.V;
        if (aVar != null) {
            aVar.c();
            this.V = null;
        }
    }

    public boolean U0() {
        com.tencent.luggage.wxa.kj.x v06 = v0();
        if (this.f132450c0.c()) {
            if (v06 != null) {
                v06.a("onRequestExitFullscreen", "", 0);
            }
            return true;
        }
        if (v06 != null && v06.e()) {
            return true;
        }
        return E();
    }

    public final void V0() {
        this.Z = false;
        if (v0() != null) {
            v0().h();
        }
        d1();
        G();
        a(Lifecycle.Event.ON_PAUSE);
        a(Lifecycle.Event.ON_STOP);
    }

    public final com.tencent.luggage.wxa.kl.b W() {
        return this.Q;
    }

    public View W0() {
        return null;
    }

    public final com.tencent.luggage.wxa.kl.d X() {
        return this.P;
    }

    public final void X0() {
        e1();
        if (v0() != null) {
            v0().a();
        }
        H();
        a(Lifecycle.Event.ON_DESTROY);
    }

    public final i.b Y() {
        return this.f132449b0;
    }

    public View Z() {
        return null;
    }

    public View a(ViewGroup viewGroup) {
        return null;
    }

    public final Activity a0() {
        if (D() instanceof WindowAndroidActivityImpl) {
            return ((WindowAndroidActivityImpl) D()).j();
        }
        return com.tencent.luggage.wxa.bo.a.a(getContext());
    }

    public final void a1() {
        a(getRuntime().n0());
        this.Z = true;
        if (v0() != null) {
            v0().o();
        }
        f1();
        I();
        j1();
        a(Lifecycle.Event.ON_START);
        a(Lifecycle.Event.ON_RESUME);
    }

    public final com.tencent.luggage.wxa.kj.n b0() {
        return this.f132453f0;
    }

    public final void b1() {
        this.P.setActuallyVisible(true);
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public String c() {
        return "AppBrandPageView";
    }

    public final int c0() {
        int i3;
        boolean z16;
        try {
            synchronized (this.f132463p0) {
                try {
                    if (this.f132467t0 == null) {
                        try {
                            i3 = getComponentId();
                        } catch (Throwable th5) {
                            th = th5;
                            z16 = true;
                            th = th;
                            i3 = 0;
                            while (true) {
                                try {
                                    try {
                                        break;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        if (z16) {
                                            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageView", "getCurrentPageId but null == mRenderPageContexts, componentId:%d", Integer.valueOf(i3));
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                            }
                            throw th;
                        }
                        try {
                            int componentId = getComponentId();
                            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageView", "getCurrentPageId but null == mRenderPageContexts, componentId:%d", Integer.valueOf(i3));
                            return componentId;
                        } catch (Throwable th8) {
                            th = th8;
                            z16 = true;
                            while (true) {
                                break;
                                break;
                            }
                            throw th;
                        }
                    }
                    try {
                        i3 = getComponentId();
                        try {
                            m1 a16 = this.f132467t0.a();
                            Objects.requireNonNull(a16);
                            return a16.a();
                        } catch (Throwable th9) {
                            th = th9;
                            z16 = false;
                            while (true) {
                                break;
                                break;
                            }
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        z16 = false;
                        th = th;
                        i3 = 0;
                        while (true) {
                            break;
                            break;
                        }
                        throw th;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    i3 = 0;
                    z16 = false;
                }
            }
        } catch (Throwable th12) {
            th = th12;
            i3 = 0;
            z16 = false;
        }
    }

    public void c1() {
        o0 o0Var = this.U;
        if (o0Var != null) {
            o0Var.destroy();
        }
        if (getCustomViewContainer() != null) {
            getCustomViewContainer().j();
        }
        if (W() != null) {
            W().destroy();
        }
        ViewGroup viewGroup = this.O;
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
        }
        com.tencent.luggage.wxa.kl.d dVar = this.P;
        if (dVar != null) {
            dVar.setActuallyVisible(false);
            this.P.removeAllViewsInLayout();
        }
        FrameLayout frameLayout = this.R;
        if (frameLayout != null) {
            frameLayout.removeAllViewsInLayout();
        }
        u0().a(true);
        if (getRuntime() != null) {
            getRuntime().N().b(this.f132459l0);
        }
        this.U = null;
        c0 c0Var = this.S;
        if (c0Var != null) {
            c0Var.d();
        }
        this.S = null;
        this.O = null;
        this.P = null;
        this.R = null;
        this.Q = null;
        this.W = null;
        T();
    }

    public final int d0() {
        int size;
        synchronized (this.f132463p0) {
            n1 n1Var = this.f132467t0;
            if (n1Var == null) {
                size = 0;
            } else {
                size = n1Var.size();
            }
        }
        return size;
    }

    public final long e0() {
        long b16;
        synchronized (this.f132463p0) {
            Objects.requireNonNull(this.f132467t0);
            m1 a16 = this.f132467t0.a();
            Objects.requireNonNull(a16);
            b16 = a16.b();
        }
        return b16;
    }

    public void e1() {
        this.X = false;
    }

    public void f(String str) {
    }

    @Override // com.tencent.luggage.wxa.xd.f
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final c0 getCustomViewContainer() {
        return this.S;
    }

    public void finalize() {
        super.finalize();
        this.L = null;
    }

    public final i1 g0() {
        return this.f132454g0;
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public final int getComponentId() {
        int i3;
        synchronized (this.f132463p0) {
            int[] iArr = this.f132465r0;
            if (iArr == null || iArr.length <= 0) {
                Integer num = this.f132466s0;
                if (num != null) {
                    this.f132465r0 = new int[]{num.intValue()};
                } else {
                    this.f132465r0 = new int[]{Objects.hash(Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()))};
                }
                int[] iArr2 = this.f132464q0;
                if (iArr2 == null || iArr2.length <= 0) {
                    this.f132464q0 = new int[]{this.f132465r0[0]};
                }
            }
            i3 = this.f132465r0[0];
        }
        return i3;
    }

    @Override // com.tencent.luggage.wxa.kj.d, com.tencent.luggage.wxa.xd.f
    public final View getContentView() {
        return this.O;
    }

    @Override // com.tencent.luggage.wxa.xd.i
    public com.tencent.luggage.wxa.ic.g getRuntime() {
        return this.L;
    }

    public final com.tencent.luggage.wxa.wj.d h0() {
        com.tencent.luggage.wxa.wj.d dVar = this.f132450c0;
        if (dVar != null) {
            return dVar;
        }
        if (D() == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageView", "getFullscreenImpl NULL windowAndroid, appId[%s] url[%s]", getAppId(), A0());
            return null;
        }
        com.tencent.luggage.wxa.wj.d createFullscreenHandler = D().createFullscreenHandler(new b());
        this.f132450c0 = createFullscreenHandler;
        createFullscreenHandler.a(new c());
        return this.f132450c0;
    }

    public void h1() {
        com.tencent.luggage.wxa.kj.c cVar = this.W;
        if (cVar != null) {
            cVar.f132084c = true;
        }
    }

    public void i(boolean z16) {
    }

    public final c0 i0() {
        return getRuntime().R();
    }

    public final void i1() {
        r();
        U();
    }

    @Override // com.tencent.luggage.wxa.ic.d, com.tencent.luggage.wxa.xd.d
    public boolean isRunning() {
        if (this.X && super.isRunning()) {
            return true;
        }
        return false;
    }

    public final ViewGroup j0() {
        return m0().getContainer();
    }

    public final void j1() {
        com.tencent.luggage.wxa.uk.j0 a16 = com.tencent.luggage.wxa.uk.j0.a(this);
        if (a16 == null) {
            return;
        }
        a16.a(m1());
    }

    public com.tencent.luggage.wxa.ol.t0 k0() {
        if (getContext() instanceof com.tencent.luggage.wxa.ol.t0) {
            return (com.tencent.luggage.wxa.ol.t0) getContext();
        }
        return null;
    }

    public final void k1() {
        synchronized (this.f132463p0) {
            this.f132465r0 = new int[0];
            getComponentId();
        }
    }

    public final boolean l(String str) {
        com.tencent.luggage.wxa.k0.d.a(v0().a(com.tencent.luggage.wxa.mj.b.class));
        return false;
    }

    public final List l0() {
        if (this.f132451d0 == null) {
            this.f132451d0 = S();
        }
        return this.f132451d0;
    }

    public void l1() {
        e(new p());
    }

    public final r0 m0() {
        return this.T;
    }

    public final boolean m1() {
        b.e r06 = r0();
        if (r06 != null && "hidden".equals(r06.f125698r)) {
            return true;
        }
        return false;
    }

    public String n0() {
        CharSequence mainTitle;
        com.tencent.luggage.wxa.kl.b W = W();
        if (W == null) {
            mainTitle = null;
        } else {
            mainTitle = W.getMainTitle();
        }
        if (mainTitle != null) {
            return mainTitle.toString();
        }
        return "";
    }

    public void n1() {
        a(new f());
    }

    public final String o0() {
        return com.tencent.luggage.wxa.h6.o.b(this.f132461n0);
    }

    public final boolean o1() {
        com.tencent.luggage.wxa.k0.d.a(v0().a(com.tencent.luggage.wxa.mj.b.class));
        return false;
    }

    public final int p0() {
        int i3;
        synchronized (this.f132463p0) {
            getComponentId();
            i3 = this.f132464q0[0];
        }
        return i3;
    }

    public final boolean p1() {
        com.tencent.luggage.wxa.mj.e eVar = (com.tencent.luggage.wxa.mj.e) f(com.tencent.luggage.wxa.mj.e.class);
        if (eVar != null && eVar.a()) {
            return true;
        }
        return false;
    }

    public final FrameLayout q0() {
        return this.R;
    }

    public final b.e r0() {
        com.tencent.luggage.wxa.fd.b E;
        com.tencent.luggage.wxa.ic.g runtime = getRuntime();
        if (runtime == null || (E = runtime.E()) == null) {
            return null;
        }
        return E.a(A0());
    }

    public String s0() {
        return r0().f125694n;
    }

    public final com.tencent.luggage.wxa.kj.p t0() {
        com.tencent.luggage.wxa.kj.n nVar = this.f132453f0;
        if (nVar != null) {
            return nVar.getPageContainer();
        }
        if (getRuntime() != null) {
            return getRuntime().Y();
        }
        return null;
    }

    public com.tencent.luggage.wxa.am.a u0() {
        return this.f132452e0;
    }

    public final com.tencent.luggage.wxa.kj.x v0() {
        Class cls = this.K;
        if (cls == null) {
            return null;
        }
        com.tencent.luggage.wxa.kj.x xVar = this.J;
        if (xVar != null) {
            return xVar;
        }
        com.tencent.luggage.wxa.kj.x a16 = t1.a(this, cls);
        this.J = a16;
        return a16;
    }

    public Bitmap w0() {
        return h(false);
    }

    public int x0() {
        return 0;
    }

    public com.tencent.luggage.wxa.ic.l y0() {
        if (getRuntime() == null) {
            return null;
        }
        return getRuntime().h0();
    }

    @Override // com.tencent.luggage.wxa.xd.j
    public final boolean z() {
        if (v0() != null) {
            com.tencent.luggage.wxa.mj.h hVar = (com.tencent.luggage.wxa.mj.h) v0().a(com.tencent.luggage.wxa.mj.h.class);
            if (hVar != null && hVar.l()) {
                return true;
            }
            return false;
        }
        return this.Y;
    }

    public com.tencent.luggage.wxa.fi.a z0() {
        Context F;
        if (this.V != null) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageView", "return keyBoardComponentView(AppBrandKeyBoardComponentView)");
            return this.V;
        }
        if (getRuntime() == null) {
            F = getContext();
        } else {
            F = getRuntime().F();
        }
        this.V = new com.tencent.luggage.wxa.fi.a(F, this);
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandPageView", "make new keyBoardComponentView(AppBrandKeyBoardComponentView)");
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(String str, com.tencent.luggage.wxa.ei.p pVar) {
        if (pVar != null && pVar != getJsRuntime() && (y0() == null || pVar != y0().getJsRuntime())) {
            if ((pVar instanceof o0) && ((o0) pVar).getPageView() == this && getJsRuntime() == null) {
                return false;
            }
            String format = String.format(Locale.ENGLISH, "checkIsActivatedForEval, weired with worker(%s), appId:%s, api:%s", pVar, getAppId(), str);
            if (b()) {
                com.tencent.luggage.wxa.er.a.a(format);
            } else {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrandPageView", format);
            }
        }
        return true;
    }

    public void N() {
        com.tencent.luggage.wxa.kj.c cVar = this.W;
        if (cVar == null) {
            return;
        }
        this.Q.setNavResetStyleListener(cVar);
        this.Q.setNavHidden(false);
        if (this.W.f132084c) {
            E0();
        }
    }

    public final boolean O() {
        if (this.f132458k0 == -1) {
            this.f132458k0 = x0();
        }
        return this.f132458k0 > 0;
    }

    public void P() {
        if (this.f132457j0.size() > 0) {
            Iterator it = new LinkedList(this.f132457j0).iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).cancel();
            }
        }
    }

    public com.tencent.luggage.wxa.kj.c Q() {
        com.tencent.luggage.wxa.er.a.b(com.tencent.luggage.wxa.tn.c0.b());
        return new com.tencent.luggage.wxa.kj.c(this);
    }

    @Override // com.tencent.luggage.wxa.xd.e
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public final o0 j() {
        o0 a16 = a(getContext());
        this.U = a16;
        return a16;
    }

    public boolean a(View view, Runnable runnable) {
        return false;
    }

    public void d(int i3) {
        if (!this.f132469v0 && (this.P.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.P.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i3) {
                marginLayoutParams.bottomMargin = i3;
                this.P.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public final void e() {
        super.e();
        c1();
        L();
        P();
        com.tencent.luggage.wxa.ic.g gVar = this.L;
        if (gVar != null) {
            if (gVar.Y() != null) {
                gVar.Y().H.b(e0());
            }
            gVar.c0().a(new c.InterfaceC6640c() { // from class: b31.v
                @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
                public final void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
                    com.tencent.luggage.wxa.kj.v.this.a(str, bVar);
                }
            });
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public final Map g() {
        if (v0() != null) {
            return v0().q();
        }
        return null;
    }

    public final void h(String str) {
        if (MiniAppConst.MENU_STYLE_DARK.equalsIgnoreCase(str)) {
            this.f132449b0 = i.b.BLACK;
        } else {
            this.f132449b0 = i.b.WHITE;
        }
    }

    public void k(boolean z16) {
        boolean[] zArr = this.f132462o0;
        if (zArr == null || zArr[0] != z16) {
            this.f132462o0 = new boolean[]{z16};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer c(int i3) {
        Integer valueOf;
        synchronized (this.f132463p0) {
            int min = Math.min(d0() - 1, Math.max(i3, 0));
            for (int i16 = 0; i16 < min; i16++) {
                n1 n1Var = this.f132467t0;
                Objects.requireNonNull(n1Var);
                n1Var.pop();
            }
            valueOf = Integer.valueOf(min);
        }
        return valueOf;
    }

    public boolean a(View view, Runnable runnable, long j3) {
        return false;
    }

    public void f(int i3) {
        a(new m(i3));
    }

    public final void i(String str) {
        a(new l(str));
    }

    public void j(String str) {
        a(new j(str));
    }

    public void f(boolean z16) {
        this.f132469v0 = z16;
        ViewGroup.LayoutParams layoutParams = this.P.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.R.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(10);
            if (z16) {
                ((RelativeLayout.LayoutParams) layoutParams2).removeRule(3);
            } else {
                ((RelativeLayout.LayoutParams) layoutParams2).addRule(3, f132447x0);
            }
            this.O.requestLayout();
            this.Q.setFullscreenMode(this.f132469v0);
            return;
        }
        if (b()) {
            throw new IllegalStateException("ActionBarContainer and Renderer's PageArea should be in RelativeLayout");
        }
    }

    @Override // com.tencent.luggage.wxa.xd.f
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public c0 a(boolean z16) {
        if (z16) {
            return i0();
        }
        return getCustomViewContainer();
    }

    public void j(boolean z16) {
        a(new n(z16));
    }

    public void k(String str) {
        e(new q(str));
    }

    public Bitmap h(boolean z16) {
        if (D0() == null) {
            return null;
        }
        Bitmap a16 = q1.a(D0().getWrapperView());
        if (a16 != null && !z16) {
            q1.b(j0(), new Canvas(a16));
        }
        return a16;
    }

    public void g(String str) {
        this.M = com.tencent.luggage.wxa.h6.o.b(str);
        this.N = str;
    }

    public void a(com.tencent.luggage.wxa.wj.c cVar) {
        this.f132455h0 = cVar;
        if (cVar != null) {
            if (X() != null) {
                X().setWindowAndroid(cVar);
            }
            if (v0() != null) {
                v0().a(cVar);
            }
            com.tencent.luggage.wxa.wj.d dVar = this.f132450c0;
            if (dVar != null) {
                dVar.c();
                this.f132450c0 = null;
                h0();
            }
        }
    }

    public final void c(String str, String str2) {
        com.tencent.luggage.wxa.mj.g gVar;
        if (v0() == null || (gVar = (com.tencent.luggage.wxa.mj.g) v0().a(com.tencent.luggage.wxa.mj.g.class)) == null) {
            return;
        }
        gVar.a(str, str2);
    }

    public void d(boolean z16) {
        com.tencent.luggage.wxa.mj.g gVar;
        if (v0() == null || (gVar = (com.tencent.luggage.wxa.mj.g) v0().a(com.tencent.luggage.wxa.mj.g.class)) == null) {
            return;
        }
        gVar.a(z16);
    }

    public void b(Context context) {
        com.tencent.luggage.wxa.kl.d dVar = this.P;
        if (dVar != null) {
            dVar.a(context);
        }
        com.tencent.luggage.wxa.kl.b bVar = this.Q;
        if (bVar == null || !(bVar.getContext() instanceof MutableContextWrapper)) {
            return;
        }
        ((MutableContextWrapper) this.Q.getContext()).setBaseContext(context);
    }

    public final void e(String str) {
        com.tencent.luggage.wxa.kj.p t06 = t0();
        if (t06 != null) {
            t06.H.d(e0());
        }
        boolean andSet = this.f132468u0.getAndSet(true);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageView", "onInitReady appId:%s, url:%s, reason:%s, called:%b", getAppId(), A0(), str, Boolean.valueOf(andSet));
        if (andSet) {
            return;
        }
        a(new e());
    }

    @Override // com.tencent.luggage.wxa.xd.f
    public boolean d() {
        return ArrayUtils.contains(new e.b[]{e.b.LANDSCAPE_SENSOR, e.b.LANDSCAPE_LOCKED, e.b.LANDSCAPE_LEFT, e.b.LANDSCAPE_RIGHT}, D().getOrientationHandler().a());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035 A[Catch: all -> 0x0057, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000d, B:10:0x0011, B:13:0x0021, B:16:0x0027, B:17:0x0032, B:18:0x0055, B:22:0x002d, B:23:0x0035, B:26:0x003b, B:29:0x0041, B:32:0x0047, B:34:0x004b, B:36:0x0052, B:38:0x0015), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(k1 k1Var) {
        boolean z16;
        n1 n1Var;
        synchronized (this.f132463p0) {
            boolean z17 = false;
            if (k1.SWITCH_TAB != k1Var && ((k1.APP_LAUNCH != k1Var && k1.RE_LAUNCH != k1Var && k1.AUTO_RE_LAUNCH != k1Var) || !(b0() instanceof com.tencent.luggage.wxa.kj.g))) {
                z16 = false;
                n1Var = this.f132467t0;
                if (n1Var != null) {
                    this.f132467t0 = z16 ? new e1(this) : new r1(this);
                } else {
                    if (k1.REWRITE_ROUTE == k1Var || ((z16 && (n1Var instanceof e1)) || ((!z16 && (n1Var instanceof r1)) || (!z16 && (n1Var instanceof e1) && n1Var.size() >= 1)))) {
                        z17 = true;
                    }
                    com.tencent.luggage.wxa.er.a.b(z17);
                }
            }
            z16 = true;
            n1Var = this.f132467t0;
            if (n1Var != null) {
            }
        }
    }

    public void e(int i3) {
        a(new i(i3));
    }

    public final Object f(Class cls) {
        if (v0() != null) {
            return v0().a(cls);
        }
        return null;
    }

    public final void e(boolean z16) {
        com.tencent.luggage.wxa.mj.g gVar;
        if (v0() == null || (gVar = (com.tencent.luggage.wxa.mj.g) v0().a(com.tencent.luggage.wxa.mj.g.class)) == null) {
            return;
        }
        gVar.b(z16);
    }

    public void a(Context context, com.tencent.luggage.wxa.ic.g gVar) {
        this.L = gVar;
        this.X = true;
        this.W = Q();
        this.f132470w0 = new s();
        a(gVar.n0());
        a(gVar.J());
        super.p();
        a(new d.a() { // from class: b31.y
            @Override // com.tencent.luggage.wxa.xd.d.a
            public final boolean a(String str, com.tencent.luggage.wxa.ei.p pVar) {
                boolean b16;
                b16 = com.tencent.luggage.wxa.kj.v.this.b(str, pVar);
                return b16;
            }
        });
        H0();
        gVar.I().b(this);
        V();
    }

    public void T0() {
    }

    public void Y0() {
    }

    public void Z0() {
    }

    public void b(final boolean z16, final i.a.EnumC6399a enumC6399a) {
        a(new Runnable() { // from class: b31.x
            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.kj.v.this.a(z16, enumC6399a);
            }
        });
    }

    public void d1() {
    }

    public void f1() {
    }

    public void g1() {
    }

    public v() {
        this(null);
    }

    public com.tencent.luggage.wxa.ui.a b(int i3) {
        for (com.tencent.luggage.wxa.ui.a aVar : l0()) {
            if (aVar != null && aVar.b() == i3) {
                return aVar;
            }
        }
        return null;
    }

    public void a(boolean z16, Map map, k1 k1Var, JSONObject jSONObject) {
        int c06;
        int componentId;
        if (!z16) {
            if (Q0()) {
                map.put("notFound", Boolean.TRUE);
            }
            if (k1.REWRITE_ROUTE == k1Var) {
                map.put("originalWebviewId", Integer.valueOf(p0()));
            }
            com.tencent.luggage.wxa.kj.x v06 = v0();
            if (v06 != null) {
                v06.a(map, k1Var);
            }
        }
        if (o1()) {
            synchronized (this.f132463p0) {
                c06 = c0();
                componentId = getComponentId();
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("pageId", c06);
                jSONObject.put("windowId", componentId);
                jSONObject.put("isNewEngineHomePage", c06 == componentId);
            } catch (JSONException e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageView", "dispatchRouteImpl, event:%s, type:%s, put viewId for customRoute, get exception:%s", e16);
            }
            map.put("singlePageData", jSONObject);
        }
    }

    public void a(com.tencent.luggage.wxa.kj.n nVar) {
        this.f132453f0 = nVar;
    }

    public final void a(i1 i1Var) {
        this.f132454g0 = i1Var;
    }

    public i1 a(h1 h1Var) {
        return g0();
    }

    public void a(List list, Runnable runnable, Runnable runnable2) {
        new a(this, new LinkedList(list), false, runnable, runnable2).f();
    }

    public final o0 a(Context context) {
        if (v0() != null) {
            return v0().a(context);
        }
        return new j0(context, new b0(this));
    }

    public final boolean a(long j3, String str) {
        if (!o1() && !l(str)) {
            if (!Q0()) {
                com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageView", "rewriteRoute condition mismatch, appId:%s, currentURL:%s, rewrittenURL:%s", getAppId(), A0(), str);
                return false;
            }
            k1();
            int p06 = p0();
            int componentId = getComponentId();
            a("webviewIdChanged", String.format(Locale.ENGLISH, "{webviewId: %d}", Integer.valueOf(componentId)), 0);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageView", "rewriteRoute --START-- appId:%s, url[%s]->[%s], componentId[%d]->[%d]", getAppId(), A0(), str, Integer.valueOf(p06), Integer.valueOf(componentId));
            k(false);
            b0().a(j3, str);
            com.tencent.luggage.wxa.kj.n b06 = b0();
            k1 k1Var = k1.REWRITE_ROUTE;
            b06.a(j3, k1Var, (p.m0) null);
            b0().a(j3, k1Var);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandPageView", "rewriteRoute --END-- appId:%s, rewrittenURL:%s, rewrittenComponentId:%d", getAppId(), str, Integer.valueOf(getComponentId()));
            return true;
        }
        throw new UnsupportedOperationException();
    }

    public boolean a(long j3, String str, k1 k1Var) {
        boolean z16;
        synchronized (this.f132463p0) {
            b(k1Var);
            Objects.requireNonNull(this.f132467t0);
            if (this.f132461n0 == null) {
                this.f132461n0 = com.tencent.luggage.wxa.tn.w0.d(str);
                z16 = true;
                for (m1 m1Var : this.f132467t0) {
                    if (StringUtils.equals(m1Var.d(), str) && m1Var.a() == getComponentId()) {
                        z16 = false;
                    }
                }
                if (z16) {
                    com.tencent.luggage.wxa.er.a.b(this.f132467t0.isEmpty());
                }
            } else {
                this.f132467t0.clear();
                z16 = true;
            }
            if (z16) {
                if (o1()) {
                    a(j3, str, k1Var, (JSONObject) null, false);
                } else {
                    this.f132467t0.a(new m1(str, getComponentId(), j3));
                }
            }
        }
        g(str);
        this.U.setXWebKeyboardImpl(new d());
        if (v0() != null) {
            return v0().a(str, k1Var);
        }
        a(k1Var);
        if (C().d(this.M)) {
            return true;
        }
        f(str);
        e("onPageScriptNotFound");
        return false;
    }

    public final boolean a(int i3) {
        synchronized (this.f132463p0) {
            n1 n1Var = this.f132467t0;
            if (n1Var == null) {
                return false;
            }
            Iterator it = n1Var.iterator();
            while (it.hasNext()) {
                if (i3 == ((m1) it.next()).a()) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean a(final long j3, final String str, final k1 k1Var, JSONObject jSONObject, boolean z16) {
        boolean z17;
        com.tencent.luggage.wxa.er.a.b(o1());
        try {
            z17 = ((Boolean) new Callable() { // from class: b31.u
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean a16;
                    a16 = com.tencent.luggage.wxa.kj.v.this.a(k1Var, str, j3);
                    return a16;
                }
            }.call()).booleanValue();
        } catch (Exception unused) {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        com.tencent.luggage.wxa.k0.d.a(v0().a(com.tencent.luggage.wxa.mj.b.class));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean a(k1 k1Var, String str, long j3) {
        synchronized (this.f132463p0) {
            b(k1Var);
            k1 k1Var2 = k1.SWITCH_TAB;
            if (k1Var2 == k1Var && ((e1) this.f132467t0).a(str)) {
                return Boolean.TRUE;
            }
            int componentId = this.f132467t0.isEmpty() ? getComponentId() : Objects.hash(Integer.valueOf(super.hashCode()), Long.valueOf(System.currentTimeMillis()));
            if (k1Var2 == k1Var && ((e1) this.f132467t0).a(str, componentId, j3)) {
                return Boolean.TRUE;
            }
            int[] iArr = r.f132498a;
            int i3 = iArr[k1Var.ordinal()];
            if (i3 == 1) {
                this.f132467t0.pop();
            } else if (i3 == 2 || i3 == 3) {
                this.f132467t0.clear();
            }
            int i16 = iArr[k1Var.ordinal()];
            if (i16 != 4 && i16 != 5 && i16 != 6 && i16 != 7) {
                this.f132467t0.a(new m1(str, componentId, j3));
                return Boolean.TRUE;
            }
            throw new UnsupportedOperationException("Unsupported openType:" + k1Var.name());
        }
    }

    public final int a(long j3, final int i3, boolean z16) {
        int i16;
        com.tencent.luggage.wxa.er.a.b(o1());
        try {
            i16 = ((Integer) new Callable() { // from class: b31.w
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Integer c16;
                    c16 = com.tencent.luggage.wxa.kj.v.this.c(i3);
                    return c16;
                }
            }.call()).intValue();
        } catch (Exception unused) {
            i16 = 0;
        }
        if (i16 <= 0) {
            return i16;
        }
        com.tencent.luggage.wxa.k0.d.a(v0().a(com.tencent.luggage.wxa.mj.b.class));
        throw null;
    }

    public void a(k1 k1Var) {
        b.e r06 = r0();
        Objects.requireNonNull(r06);
        a(k1Var, r06);
    }

    public void a(k1 k1Var, b.e eVar) {
        f(eVar.a());
        j(eVar.f125681a);
        a(1.0d);
        e(a(eVar));
        i(eVar.f125682b);
        e(eVar.f125691k);
        c(eVar.f125693m, eVar.f125688h);
        b(!eVar.f125687g, i.a.EnumC6399a.PageConfig);
        if (J0()) {
            W().setNavHidden(true);
        }
    }

    public final int a(b.e eVar) {
        try {
            return com.tencent.luggage.wxa.tk.g.b(eVar.f125685e);
        } catch (Exception unused) {
            return com.tencent.luggage.wxa.tk.g.a(eVar.f125688h, -1);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2, int[] iArr) {
        if (this.L != null && this.L.h0() != null) {
            if (v0() == null || !v0().a(str, str2, iArr)) {
                this.L.h0().a(str, str2, getComponentId());
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandPageView", "publish runtime destroyed, event %s", str);
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public final void a(String str, String str2, int i3) {
        if (v0() == null) {
            super.a(str, str2, i3);
        } else {
            if (v0().a(str, str2, i3)) {
                return;
            }
            super.a(str, str2, i3);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public final void a(int i3, String str) {
        if (v0() == null || !v0().a(i3, str)) {
            super.a(i3, str, (com.tencent.luggage.wxa.ei.p) null);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public final void a(int i3, String str, com.tencent.luggage.wxa.ei.p pVar) {
        if (pVar != getJsRuntime() && pVar != null) {
            super.a(i3, str, pVar);
        } else {
            a(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
        if (com.tencent.luggage.wxa.qc.b.DESTROYED == bVar) {
            this.L = null;
        }
    }

    @Override // com.tencent.luggage.wxa.kj.o1
    public void a(m1 m1Var) {
        com.tencent.luggage.wxa.ic.g gVar = this.L;
        if (gVar == null || gVar.Y() == null) {
            return;
        }
        gVar.Y().H.b(m1Var.b());
    }

    public void a(Configuration configuration) {
        if (v0() != null) {
            v0().a(configuration);
        }
    }

    public void a(double d16) {
        a(new h(d16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z16, i.a.EnumC6399a enumC6399a) {
        if (W() == null) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandPageView", "setNavigationBarCapsule visible(%b) but null == getActionBar()", Boolean.valueOf(z16));
        } else {
            W().a(z16, enumC6399a);
        }
    }

    public void a(Animator... animatorArr) {
        for (Animator animator : animatorArr) {
            this.f132457j0.add(animator);
            animator.addListener(new o());
        }
    }

    public void a(int i3, boolean z16) {
        for (com.tencent.luggage.wxa.ui.a aVar : l0()) {
            if (aVar != null && aVar.b() == i3) {
                aVar.a(z16);
                return;
            }
        }
    }

    public final void a(Lifecycle.Event event) {
        if (Lifecycle.Event.ON_DESTROY != event || this.f132470w0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            ((LifecycleRegistry) this.f132470w0.getLifecycle()).handleLifecycleEvent(event);
        }
    }
}
