package com.tencent.luggage.wxa.k6;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.MenuItem;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.ui.WxaSimpleWebViewActivity;
import com.tencent.luggage.wxa.g6.r;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.luggage.wxa.qk.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/luggage/wxa/k6/o;", "Lcom/tencent/luggage/wxa/g6/r;", "", "g", "", "b", "Landroid/content/res/Configuration;", "newConfig", "a", "i", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "finish", "Lcom/tencent/luggage/wxa/k6/p;", "Lcom/tencent/luggage/wxa/k6/p;", "webView", "c", "Landroid/content/res/Configuration;", "lastConfiguration", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "d", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class o extends r {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public p webView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Configuration lastConfiguration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Class<WxaSimpleWebViewActivity> ACTIVITY_CLASS = WxaSimpleWebViewActivity.class;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k6.o$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a(Companion companion, Context context, String str, Boolean bool, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                bool = Boolean.FALSE;
            }
            companion.a(context, str, bool);
        }

        public final void a(Context context, String url, Boolean bool) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            com.tencent.luggage.wxa.g6.p a16 = com.tencent.luggage.wxa.g6.p.f126564o.a(context);
            Intent putExtra = new Intent().setClass(z.c(), o.class).putExtra("KEY_URL", url).putExtra("KEY_ENABLE_JS_BRIDGE", bool != null ? bool.booleanValue() : false);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().setClass(\n     \u2026 enableJSBridge ?: false)");
            a16.a(context, putExtra);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        public final Void f131721a;

        /* renamed from: b, reason: collision with root package name */
        public final int f131722b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f131723c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f131724d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f131725a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(o oVar) {
                super(0);
                this.f131725a = oVar;
            }

            public final void a() {
                o oVar = this.f131725a;
                oVar.setActionBarColor(com.tencent.luggage.wxa.lo.o.b(oVar.getContext(), R.attr.f50485));
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public b(boolean z16, o oVar) {
            this.f131724d = oVar;
            this.f131723c = z16;
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* synthetic */ void a(WebView webView, String str) {
            y21.b.a(this, webView, str);
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* synthetic */ boolean b() {
            return y21.b.c(this);
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public int c() {
            return this.f131722b;
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public /* bridge */ /* synthetic */ String d() {
            return (String) h();
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public boolean f() {
            return this.f131723c;
        }

        public Void h() {
            return this.f131721a;
        }

        @Override // com.tencent.luggage.wxa.k6.h
        public void a(WebView webView, String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            com.tencent.luggage.wxa.rn.a.a(new a(this.f131724d));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements q {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f131727a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f131728b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f131729c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(o oVar, int i3, int i16) {
                super(0);
                this.f131727a = oVar;
                this.f131728b = i3;
                this.f131729c = i16;
            }

            public final void a() {
                this.f131727a.setActionBarColor(com.tencent.luggage.wxa.lo.m.a(this.f131728b, this.f131729c));
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public c() {
        }

        @Override // com.tencent.luggage.wxa.k6.q
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.k6.q
        public void a(int i3, int i16) {
            com.tencent.luggage.wxa.rn.a.a(new a(o.this, i3, i16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends g {
        public d() {
        }

        @Override // com.tencent.xweb.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            boolean z16;
            if (URLUtil.isValidUrl(str)) {
                p pVar = o.this.webView;
                p pVar2 = null;
                if (pVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    pVar = null;
                }
                if (!StringUtils.contains(str, pVar.getCurrentURL())) {
                    p pVar3 = o.this.webView;
                    if (pVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        pVar2 = pVar3;
                    }
                    if (!StringUtils.contains(str, pVar2.getCommitUrl())) {
                        return;
                    }
                }
                o.this.setTitle("");
                return;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !URLUtil.isAboutUrl(str)) {
                o.this.setTitle(str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements MenuItem.OnMenuItemClickListener {
        public e() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            o.this.i();
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void b() {
        String str;
        boolean z16;
        boolean z17;
        super.b();
        Intent intent = getIntent();
        p pVar = null;
        if (intent != null) {
            str = intent.getStringExtra("KEY_URL");
        } else {
            str = null;
        }
        int i3 = 1;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w.b("Luggage.WxaSimpleWebViewActivity", "onCreate invalid url");
            finish();
            return;
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            z17 = intent2.getBooleanExtra("KEY_ENABLE_JS_BRIDGE", false);
        } else {
            z17 = false;
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f122097d1);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        p pVar2 = new p(context, new b(z17, this));
        this.webView = pVar2;
        pVar2.setDelegate(new c());
        p pVar3 = this.webView;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar3 = null;
        }
        int i16 = getContext().getResources().getConfiguration().uiMode & 48;
        if (i16 != 16) {
            if (i16 != 32) {
                i3 = 0;
            } else {
                i3 = 2;
            }
        }
        pVar3.setDarkMode(i3);
        p pVar4 = this.webView;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar4 = null;
        }
        frameLayout.addView(pVar4, -1, -1);
        p pVar5 = this.webView;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar5 = null;
        }
        pVar5.getWebView().setWebChromeClient(new d());
        p pVar6 = this.webView;
        if (pVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            pVar = pVar6;
        }
        pVar.a(str);
        setBackBtn(new e());
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void finish() {
        super.finish();
        p pVar = this.webView;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar = null;
        }
        pVar.a();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public int g() {
        return R.layout.dr7;
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void i() {
        p pVar = this.webView;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar = null;
        }
        if (pVar.getWebView().canGoBack()) {
            p pVar3 = this.webView;
            if (pVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                pVar2 = pVar3;
            }
            pVar2.getWebView().goBack();
            return;
        }
        finish();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onDestroy() {
        super.onDestroy();
        p pVar = this.webView;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar = null;
        }
        pVar.a();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onPause() {
        super.onPause();
        p pVar = this.webView;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar = null;
        }
        pVar.getWebView().onPause();
        p pVar3 = this.webView;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            pVar2 = pVar3;
        }
        pVar2.getWebView().onHide();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void onResume() {
        super.onResume();
        p pVar = this.webView;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            pVar = null;
        }
        pVar.getWebView().onResume();
        p pVar3 = this.webView;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            pVar2 = pVar3;
        }
        pVar2.getWebView().onShow();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void a(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.a(newConfig);
        Configuration configuration = this.lastConfiguration;
        if (configuration != null) {
            a.C6650a c6650a = com.tencent.luggage.wxa.qk.a.f138929a;
            Intrinsics.checkNotNull(configuration);
            p pVar = null;
            if (c6650a.a(null, configuration, newConfig)) {
                p pVar2 = this.webView;
                if (pVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    pVar = pVar2;
                }
                int i3 = newConfig.uiMode & 48;
                pVar.setDarkMode(i3 != 16 ? i3 != 32 ? 0 : 2 : 1);
            }
        }
        this.lastConfiguration = new Configuration(newConfig);
    }
}
