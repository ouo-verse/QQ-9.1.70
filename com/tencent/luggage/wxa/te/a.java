package com.tencent.luggage.wxa.te;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.se.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.magicbrush.ui.g;
import com.tencent.mm.plugin.appbrand.extendplugin.AppBrandInvokeContext;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.k8.a implements g.b {

    /* renamed from: k, reason: collision with root package name */
    public static final C6753a f141255k = new C6753a(null);

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f141256a;

    /* renamed from: b, reason: collision with root package name */
    public v f141257b;

    /* renamed from: c, reason: collision with root package name */
    public int f141258c;

    /* renamed from: e, reason: collision with root package name */
    public g.c f141260e;

    /* renamed from: f, reason: collision with root package name */
    public Surface f141261f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.magicbrush.ui.g f141262g;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f141265j;

    /* renamed from: d, reason: collision with root package name */
    public final List f141259d = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public int f141263h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f141264i = -1;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.te.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6753a {
        public C6753a() {
        }

        public /* synthetic */ C6753a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z7.c f141267b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f141268c;

        public b(com.tencent.luggage.wxa.z7.c cVar, com.tencent.luggage.wxa.xd.d dVar) {
            this.f141267b = cVar;
            this.f141268c = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            com.tencent.luggage.wxa.z7.c cVar = this.f141267b;
            com.tencent.luggage.wxa.xd.d dVar = this.f141268c;
            synchronized (aVar) {
                o h16 = ((AppBrandInvokeContext) cVar).h();
                if (h16 instanceof com.tencent.luggage.wxa.ue.b) {
                    JSONObject g16 = ((AppBrandInvokeContext) cVar).g();
                    Intrinsics.checkNotNullExpressionValue(g16, "invokeContext.data");
                    o h17 = ((AppBrandInvokeContext) cVar).h();
                    Intrinsics.checkNotNullExpressionValue(h17, "invokeContext.jsApi");
                    aVar.a(dVar, g16, h17, ((AppBrandInvokeContext) cVar).f());
                } else if (h16 instanceof com.tencent.luggage.wxa.ue.d) {
                    JSONObject g17 = ((AppBrandInvokeContext) cVar).g();
                    Intrinsics.checkNotNullExpressionValue(g17, "invokeContext.data");
                    o h18 = ((AppBrandInvokeContext) cVar).h();
                    Intrinsics.checkNotNullExpressionValue(h18, "invokeContext.jsApi");
                    aVar.c(dVar, g17, h18, ((AppBrandInvokeContext) cVar).f());
                } else if (h16 instanceof com.tencent.luggage.wxa.ue.c) {
                    JSONObject g18 = ((AppBrandInvokeContext) cVar).g();
                    Intrinsics.checkNotNullExpressionValue(g18, "invokeContext.data");
                    o h19 = ((AppBrandInvokeContext) cVar).h();
                    Intrinsics.checkNotNullExpressionValue(h19, "invokeContext.jsApi");
                    aVar.b(dVar, g18, h19, ((AppBrandInvokeContext) cVar).f());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements g.c {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.xd.g.c
        public void onDestroy() {
            Surface surface = a.this.f141261f;
            v vVar = null;
            if (surface != null) {
                a aVar = a.this;
                try {
                    g.c cVar = aVar.f141260e;
                    if (cVar != null) {
                        cVar.a(surface, false);
                    }
                } catch (Exception e16) {
                    w.a("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", e16, "handle page.onDestroy", new Object[0]);
                }
                aVar.f141261f = null;
            }
            v vVar2 = a.this.f141257b;
            if (vVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("componentView");
            } else {
                vVar = vVar2;
            }
            vVar.b(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements g.f {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.magicbrush.b f141271b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f141272c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f141273d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o f141274e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.te.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6754a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.d f141275a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f141276b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ o f141277c;

            public RunnableC6754a(com.tencent.luggage.wxa.xd.d dVar, int i3, o oVar) {
                this.f141275a = dVar;
                this.f141276b = i3;
                this.f141277c = oVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f141275a.a(this.f141276b, this.f141277c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }

        public d(com.tencent.magicbrush.b bVar, com.tencent.luggage.wxa.xd.d dVar, int i3, o oVar) {
            this.f141271b = bVar;
            this.f141272c = dVar;
            this.f141273d = i3;
            this.f141274e = oVar;
        }

        @Override // com.tencent.magicbrush.ui.g.f
        public void a() {
            if (!a.this.f141265j) {
                this.f141271b.h().a(new RunnableC6754a(this.f141272c, this.f141273d, this.f141274e));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements g.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f141278a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f141279b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.magicbrush.b f141280c;

        public e(com.tencent.luggage.wxa.xd.d dVar, a aVar, com.tencent.magicbrush.b bVar) {
            this.f141278a = dVar;
            this.f141279b = aVar;
            this.f141280c = bVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public final void onForeground() {
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", com.tencent.mobileqq.msf.core.net.r.a.f248963o);
            a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
            String appId = ((v) this.f141278a).getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
            com.tencent.luggage.wxa.se.a a16 = bVar.a(appId);
            a aVar = this.f141279b;
            com.tencent.magicbrush.b bVar2 = this.f141280c;
            a16.c(aVar.f141258c);
            if (a16.b() == 1) {
                bVar2.m();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements g.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f141281a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f141282b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.magicbrush.b f141283c;

        public f(com.tencent.luggage.wxa.xd.d dVar, a aVar, com.tencent.magicbrush.b bVar) {
            this.f141281a = dVar;
            this.f141282b = aVar;
            this.f141283c = bVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public final void onBackground() {
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "background");
            if (((v) this.f141281a).getRuntime().t0()) {
                return;
            }
            a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
            String appId = ((v) this.f141281a).getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
            com.tencent.luggage.wxa.se.a a16 = bVar.a(appId);
            a aVar = this.f141282b;
            com.tencent.magicbrush.b bVar2 = this.f141283c;
            a16.a(aVar.f141258c);
            if (a16.b() == 0) {
                bVar2.l();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f141284a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f141285b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f141286c;

        public g(com.tencent.luggage.wxa.xd.d dVar, int i3, o oVar) {
            this.f141284a = dVar;
            this.f141285b = i3;
            this.f141286c = oVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f141284a.a(this.f141285b, this.f141286c.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
        }
    }

    @Override // com.tencent.magicbrush.ui.g.b
    public Object getSurface() {
        return g.b.a.a(this);
    }

    @Override // com.tencent.magicbrush.ui.g.b
    public View getThisView() {
        return null;
    }

    @Override // com.tencent.magicbrush.ui.g.b
    public g.h getViewType() {
        return g.h.f147525c;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public synchronized String handleJsApi(com.tencent.luggage.wxa.z7.c invokeContext) {
        AppBrandInvokeContext appBrandInvokeContext;
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        w.e("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handleJsApi " + invokeContext.c());
        if (invokeContext instanceof AppBrandInvokeContext) {
            appBrandInvokeContext = (AppBrandInvokeContext) invokeContext;
        } else {
            appBrandInvokeContext = null;
        }
        if (appBrandInvokeContext == null) {
            w.b("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "invokeContext type not supported");
            return null;
        }
        AppBrandInvokeContext appBrandInvokeContext2 = (AppBrandInvokeContext) invokeContext;
        if (appBrandInvokeContext2.h() instanceof com.tencent.luggage.wxa.ue.b) {
            this.f141265j = appBrandInvokeContext2.g().optBoolean("transparentBackground", false);
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "is2DCanvas: " + this.f141265j);
        }
        if (!this.f141256a && !this.f141265j) {
            this.f141259d.add(invokeContext);
            return null;
        }
        handleJsApiInternal(invokeContext);
        return null;
    }

    public final void handleJsApiInternal(com.tencent.luggage.wxa.z7.c cVar) {
        AppBrandInvokeContext appBrandInvokeContext;
        com.tencent.luggage.wxa.xd.d e16;
        if (cVar instanceof AppBrandInvokeContext) {
            appBrandInvokeContext = (AppBrandInvokeContext) cVar;
        } else {
            appBrandInvokeContext = null;
        }
        if (appBrandInvokeContext != null && (e16 = appBrandInvokeContext.e()) != null) {
            a(e16, new b(cVar, e16));
        }
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public synchronized void handlePluginDestroy() {
        g.c cVar;
        w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "plugin destroyed viewId: " + this.f141258c);
        super.handlePluginDestroy();
        Surface surface = this.f141261f;
        if (surface != null && (cVar = this.f141260e) != null) {
            cVar.a(surface, false);
        }
        this.f141261f = null;
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public void handlePluginReady(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        handlePluginReadyForGPUProcess(new Surface(surfaceTexture));
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public synchronized void handlePluginReadyForGPUProcess(Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        super.handlePluginReadyForGPUProcess(surface);
        w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "handlePluginReady mViewId:" + this.f141258c + " inited:" + this.f141256a + " id:" + this.f131781id);
        Surface surface2 = this.f141261f;
        if (surface2 != null) {
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "destroy previous surface " + surface2);
            g.c cVar = this.f141260e;
            if (cVar != null) {
                cVar.a(surface2, false);
            }
        }
        this.f141261f = surface;
        if (!this.f141256a && !this.f141265j) {
            a();
            this.f141256a = true;
        }
        d();
    }

    @Override // com.tencent.luggage.wxa.k8.a, com.tencent.luggage.wxa.k8.b
    public void handlePluginTouch(MotionEvent motionEvent) {
        com.tencent.magicbrush.ui.g gVar;
        if (motionEvent != null && (gVar = this.f141262g) != null) {
            gVar.onTouchEvent(motionEvent);
        }
    }

    @Override // com.tencent.luggage.wxa.k8.b
    public boolean isPluginReady(com.tencent.luggage.wxa.z7.c cVar) {
        return true;
    }

    @Override // com.tencent.magicbrush.ui.g.b
    public void setSurfaceListener(g.c cVar) {
        this.f141260e = cVar;
    }

    public final void d() {
        g.c cVar;
        w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surface[" + this.f141261f + "]: width:" + this.f141263h + ", height:" + this.f141264i + TokenParser.SP);
        Surface surface = this.f141261f;
        if (surface == null || (cVar = this.f141260e) == null) {
            return;
        }
        cVar.a(surface, this.f141263h, this.f141264i, false, this.f141265j);
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        v vVar = this.f141257b;
        if (vVar == null) {
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "componentView is nul, return");
            dVar.a(i3, oVar.makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e));
            return;
        }
        a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
        String appId = vVar.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "componentView.appId");
        bVar.a(appId).e(this.f141258c);
        dVar.a(i3, oVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }

    public final void c(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        g.c cVar;
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            int a16 = (int) com.tencent.luggage.wxa.tk.g.a(optJSONObject, "width", 0.0f);
            int a17 = (int) com.tencent.luggage.wxa.tk.g.a(optJSONObject, "height", 0.0f);
            if (a16 != this.f141263h || a17 != this.f141264i) {
                w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "update surface[" + this.f141261f + "] size to [" + a16 + ", " + a17 + ']');
                this.f141263h = a16;
                this.f141264i = a17;
                Surface surface = this.f141261f;
                if (surface != null && (cVar = this.f141260e) != null) {
                    cVar.a(surface, a16, a17);
                }
            }
        }
        dVar.a(i3, oVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }

    public final void a() {
        List list = this.f141259d;
        if (list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            handleJsApiInternal((com.tencent.luggage.wxa.z7.c) it.next());
        }
        list.clear();
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, o oVar, int i3) {
        if (dVar instanceof v) {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            this.f141263h = Math.max((int) com.tencent.luggage.wxa.tk.g.a(optJSONObject, "width", 0.0f), 1);
            this.f141264i = Math.max((int) com.tencent.luggage.wxa.tk.g.a(optJSONObject, "height", 0.0f), 1);
            v vVar = (v) dVar;
            vVar.a(new c());
            this.f141257b = vVar;
            l y06 = vVar.y0();
            com.tencent.luggage.wxa.r4.d dVar2 = y06 instanceof com.tencent.luggage.wxa.r4.d ? (com.tencent.luggage.wxa.r4.d) y06 : null;
            com.tencent.luggage.wxa.w1.c cVar = dVar2 != null ? (com.tencent.luggage.wxa.w1.c) dVar2.h(com.tencent.luggage.wxa.w1.c.class) : null;
            if (cVar == null) {
                w.f("JsApiInsertHTMLCanvasElement", "hy: webgl extension not exists!");
                return;
            }
            com.tencent.magicbrush.b n3 = cVar.n();
            if (n3 == null) {
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("scrollSupportedTouchEvent", false);
            this.f141258c = jSONObject.optInt("canvasId", 0);
            w.d("MicroMsg.AppBrand.SameLayer.AppBrandWebGLPluginHandler", "insert xweb webgl canvas viewId:" + this.f141258c + " scrollSupportedTouchEvent:" + optBoolean);
            Context c16 = z.c();
            Intrinsics.checkNotNullExpressionValue(c16, "getContext()");
            com.tencent.magicbrush.ui.g gVar = new com.tencent.magicbrush.ui.g(c16, this);
            gVar.setMagicBrush(n3);
            gVar.getPreparedListeners().a(new d(n3, dVar, i3, oVar));
            a.b bVar = com.tencent.luggage.wxa.se.a.f140284c;
            String appId = vVar.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "component.appId");
            bVar.a(appId).a(this.f141258c, gVar);
            if (optBoolean) {
                gVar.setEnableTouchEvent(false);
            }
            this.f141262g = gVar;
            vVar.b(new e(dVar, this, n3));
            if (vVar.M0()) {
                String appId2 = vVar.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId2, "component.appId");
                com.tencent.luggage.wxa.se.a a16 = bVar.a(appId2);
                a16.c(this.f141258c);
                if (a16.b() == 1) {
                    n3.m();
                }
            }
            vVar.a(new f(dVar, this, n3));
            d();
            if (this.f141265j) {
                n3.h().a(new g(dVar, i3, oVar));
            }
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, Runnable runnable) {
        com.tencent.luggage.wxa.dq.a asyncHandler = dVar.getAsyncHandler();
        if (Intrinsics.areEqual(asyncHandler != null ? asyncHandler.a() : null, Looper.myLooper())) {
            runnable.run();
            return;
        }
        com.tencent.luggage.wxa.dq.a asyncHandler2 = dVar.getAsyncHandler();
        if (asyncHandler2 != null) {
            asyncHandler2.a(runnable);
        }
    }
}
