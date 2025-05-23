package com.tencent.luggage.wxa.k6;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.luggage.wxa.ic.q0;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.g1;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements com.tencent.luggage.wxa.xd.d, LifecycleOwner {

    /* renamed from: l, reason: collision with root package name */
    public static final a f131634l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final WebView f131635a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f131636b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f131637c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f131638d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f131639e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k6.d f131640f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f131641g;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m6.c f131642h;

    /* renamed from: i, reason: collision with root package name */
    public final q0 f131643i;

    /* renamed from: j, reason: collision with root package name */
    public final LifecycleRegistry f131644j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m6.b f131645k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k6.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6364b extends k0 {

        @Deprecated
        @NotNull
        public static final String NAME = "onGetKeyboardHeight";

        /* renamed from: a, reason: collision with root package name */
        public static final a f131646a = new a(null);

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.k6.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends k0 {

        @Deprecated
        @NotNull
        public static final String NAME = "onPageStateChange";

        /* renamed from: a, reason: collision with root package name */
        public static final a f131647a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.o f131649b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131650c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f131651d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xd.o f131652a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f131653b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f131654c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f131655d;

            public a(com.tencent.luggage.wxa.xd.o oVar, b bVar, JSONObject jSONObject, int i3) {
                this.f131652a = oVar;
                this.f131653b = bVar;
                this.f131654c = jSONObject;
                this.f131655d = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.xd.o oVar = this.f131652a;
                Intrinsics.checkNotNull(oVar, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandAsyncJsApi<com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponent>");
                ((com.tencent.luggage.wxa.xd.a) oVar).invoke(this.f131653b, this.f131654c, this.f131655d);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.tencent.luggage.wxa.xd.o oVar, JSONObject jSONObject, int i3) {
            super(0);
            this.f131649b = oVar;
            this.f131650c = jSONObject;
            this.f131651d = i3;
        }

        public final void a() {
            b.this.l().a((Runnable) new a(this.f131649b, b.this, this.f131650c, this.f131651d));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function0 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f131657b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i3) {
            super(0);
            this.f131657b = i3;
        }

        public final void a() {
            b.this.a(this.f131657b, com.tencent.luggage.wxa.l6.a.f133053a.a());
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f131658a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.o f131659b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f131660c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f131661d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.tencent.luggage.wxa.tk.i iVar, com.tencent.luggage.wxa.xd.o oVar, b bVar, JSONObject jSONObject) {
            super(0);
            this.f131658a = iVar;
            this.f131659b = oVar;
            this.f131660c = bVar;
            this.f131661d = jSONObject;
        }

        public final void a() {
            com.tencent.luggage.wxa.tk.i iVar = this.f131658a;
            com.tencent.luggage.wxa.xd.o oVar = this.f131659b;
            Intrinsics.checkNotNull(oVar, "null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandSyncJsApi<com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponent>");
            iVar.f141499a = ((v) oVar).a(this.f131660c, this.f131661d);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f131662a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(com.tencent.luggage.wxa.tk.i iVar) {
            super(0);
            this.f131662a = iVar;
        }

        public final void a() {
            this.f131662a.f141499a = com.tencent.luggage.wxa.l6.a.f133053a.a();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final h f131663a = new h();

        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            return com.tencent.luggage.wxa.l6.k.f133084a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function0 {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 invoke() {
            b0 b0Var = new b0("HTMLWebViewComponentImpl#Async");
            b.this.m().set(true);
            return b0Var;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function0 {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.k6.e invoke() {
            return new com.tencent.luggage.wxa.k6.e(b.this.q());
        }
    }

    public b(WebView webView, com.tencent.luggage.wxa.m6.d urlCheckLogic) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(urlCheckLogic, "urlCheckLogic");
        this.f131635a = webView;
        this.f131636b = new b0(Looper.getMainLooper());
        this.f131637c = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(new i());
        this.f131638d = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new j());
        this.f131639e = lazy2;
        this.f131640f = new com.tencent.luggage.wxa.k6.d(this);
        lazy3 = LazyKt__LazyJVMKt.lazy(h.f131663a);
        this.f131641g = lazy3;
        this.f131642h = new com.tencent.luggage.wxa.m6.c(urlCheckLogic, this);
        this.f131643i = new q0();
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        this.f131644j = lifecycleRegistry;
        this.f131645k = new com.tencent.luggage.wxa.m6.b();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.xd.l a(Class cls) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ void b(Runnable runnable) {
        q41.a.b(this, runnable);
    }

    public abstract void b(String str);

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.xd.m c(Class clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return null;
    }

    public void e() {
        this.f131636b.a((Object) null);
        if (this.f131637c.get()) {
            l().a((Object) null);
            l().e();
        }
        this.f131640f.a();
        o().destroy();
        this.f131643i.a();
        this.f131644j.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public final void f() {
        a("sys:init", "{}");
    }

    public abstract String g();

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.dq.a getAsyncHandler() {
        return l();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public int getComponentId() {
        return hashCode();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public Context getContext() {
        Context context = this.f131635a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "webView.context");
        return context;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public r getDialogContainer() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.rc.r getFileSystem() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public d.c getInterceptor() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ g1 getInvokeCostManager() {
        return q41.a.d(this);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.ei.j getJsRuntime() {
        return o();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f131644j;
    }

    public abstract String h();

    public final Map j() {
        return (Map) this.f131641g.getValue();
    }

    public final com.tencent.luggage.wxa.m6.b k() {
        return this.f131645k;
    }

    public final com.tencent.luggage.wxa.dq.a l() {
        return (com.tencent.luggage.wxa.dq.a) this.f131638d.getValue();
    }

    public final AtomicBoolean m() {
        return this.f131637c;
    }

    public final com.tencent.luggage.wxa.ei.j o() {
        return (com.tencent.luggage.wxa.ei.j) this.f131639e.getValue();
    }

    public final com.tencent.luggage.wxa.m6.c p() {
        return this.f131642h;
    }

    public final WebView q() {
        return this.f131635a;
    }

    public void s() {
        a(new c().setData("active", Boolean.FALSE));
    }

    public void t() {
        a(new c().setData("active", Boolean.TRUE));
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public /* synthetic */ com.tencent.luggage.wxa.xd.o a(String str) {
        return q41.a.a(this, str);
    }

    public final String b(String apiName, String str, int i3) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        com.tencent.luggage.wxa.xd.o oVar = (com.tencent.luggage.wxa.xd.o) j().get(apiName);
        if (oVar == null) {
            return com.tencent.luggage.wxa.l6.a.f133053a.b();
        }
        if (oVar instanceof com.tencent.luggage.wxa.xd.a) {
            JSONObject c16 = c(str);
            if (c16 == null) {
                return com.tencent.luggage.wxa.l6.a.f133053a.d();
            }
            this.f131642h.a(oVar, c16, new d(oVar, c16, i3), new e(i3));
            return "";
        }
        if (oVar instanceof v) {
            JSONObject c17 = c(str);
            if (c17 == null) {
                return com.tencent.luggage.wxa.l6.a.f133053a.d();
            }
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            this.f131642h.a(oVar, c17, new f(iVar, oVar, this, c17), new g(iVar));
            return (String) iVar.f141499a;
        }
        return com.tencent.luggage.wxa.l6.a.f133053a.c();
    }

    public final JSONObject c(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void a(int i3, int i16) {
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean a(com.tencent.luggage.wxa.xd.m mVar) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean a(String str, com.tencent.luggage.wxa.ei.p pVar) {
        return true;
    }

    public final com.tencent.luggage.wxa.xo.d a(String url, com.tencent.luggage.wxa.fn.b request, Class clazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        com.tencent.luggage.wxa.h1.b b16 = b(com.tencent.luggage.wxa.bj.c.class);
        Intrinsics.checkNotNull(b16);
        com.tencent.luggage.wxa.xo.d a16 = ((com.tencent.luggage.wxa.bj.c) b16).b(url, getAppId(), request, clazz).a(this.f131643i);
        Intrinsics.checkNotNullExpressionValue(a16, "this.customize(ICgiServi\u2026cle(this.lifecycleKeeper)");
        return a16;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2) {
        a(str, str2, 0);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2, int i3) {
        this.f131640f.a(str, str2);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(k0 k0Var) {
        if (k0Var == null) {
            return;
        }
        a(k0Var.getName(), k0Var.getData());
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(String str, String str2, int[] iArr) {
        a(str, str2);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(k0 k0Var, int[] iArr) {
        if (k0Var == null) {
            return;
        }
        a(k0Var);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(int i3, String str) {
        this.f131640f.a(i3, str);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        com.tencent.luggage.wxa.zp.h.f146825d.a(runnable);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.h1.b b(Class cls) {
        return com.tencent.luggage.wxa.h1.e.a(cls);
    }

    public final void a(boolean z16, int i3) {
        a(new C6364b().setData("height", Integer.valueOf(i3)));
    }

    public WebResourceResponse a(WebView webView, WebResourceRequest req) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(req, "req");
        String uri = req.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "req.url.toString()");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(uri, "weixin://resourceid/", false, 2, null);
        if (startsWith$default) {
            w.d("Luggage.STANDALONE.HTMLWebViewComponent", "it is wechat resource " + uri + ", should intercept");
            try {
                String b16 = this.f131645k.b(uri);
                if (b16 == null) {
                    return null;
                }
                Bitmap a16 = com.tencent.luggage.wxa.tn.d.a(b16);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                com.tencent.luggage.wxa.tn.d.a(a16, com.tencent.luggage.wxa.tn.b.a(b16)).compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                return new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            } catch (Exception e16) {
                w.b("Luggage.STANDALONE.HTMLWebViewComponent", "get webview jssdk resource failed %s", e16.getMessage());
            }
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public void r() {
    }

    public void u() {
    }

    public WebResourceResponse a(WebView webView, WebResourceRequest req, Bundle bundle) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(req, "req");
        return a(webView, req);
    }
}
