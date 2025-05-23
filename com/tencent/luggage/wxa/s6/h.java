package com.tencent.luggage.wxa.s6;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.wxa.fd.t;
import com.tencent.luggage.wxa.k5.i;
import com.tencent.luggage.wxa.kj.u1;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.kj.x;
import com.tencent.luggage.wxa.l7.d;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.mo.a0;
import com.tencent.luggage.wxa.n5.b;
import com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaEnterWechatInvokeManager;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.e0;
import com.tencent.luggage.wxa.xd.j1;
import com.tencent.luggage.wxa.xd.y;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import org.joor.Reflect;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0007B\u0017\u0012\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\u0007\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0017J\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0002\u00a8\u0006 "}, d2 = {"Lcom/tencent/luggage/wxa/s6/h;", "Lcom/tencent/luggage/wxa/p5/e;", "Landroid/content/Context;", "context", "Lcom/tencent/luggage/wxa/ic/g;", "rt", "", "a", "Lorg/json/JSONObject;", DownloadInfo.spKey_Config, "Landroid/view/View;", "W0", "", "Lcom/tencent/luggage/wxa/ui/a;", "menuInfoList", "Ljava/lang/Runnable;", "onShow", "onDismiss", "", ExifInterface.LATITUDE_SOUTH, "", "E1", "", "menuItemId", "disable", "F1", "Ljava/lang/Class;", "Lcom/tencent/luggage/wxa/kj/x;", "rendererClass", "<init>", "(Ljava/lang/Class;)V", "D0", "luggage-standalone-open-runtime-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.p5.e {

    /* renamed from: D0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s6.h$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a() {
            return new h(com.tencent.luggage.wxa.s6.c.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function3 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.l7.d f140080b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.l7.d dVar) {
            super(3);
            this.f140080b = dVar;
        }

        public final void a(Context context, h hVar, String str) {
            String str2;
            String str3;
            WebView webView;
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 39, null, 0L, 0, 0, 60, null);
            com.tencent.luggage.wxa.c3.a aVar = new com.tencent.luggage.wxa.c3.a();
            h hVar2 = h.this;
            com.tencent.luggage.wxa.l7.d dVar = this.f140080b;
            aVar.g(hVar2.getRuntime().S().f125809b);
            aVar.b("");
            aVar.f(hVar2.B0());
            com.tencent.luggage.wxa.f3.a q16 = hVar2.q1();
            if (q16 != null && (webView = q16.getWebView()) != null) {
                str2 = webView.getUrl();
            } else {
                str2 = null;
            }
            aVar.h(str2);
            aVar.c(hVar2.getRuntime().S().f125810c);
            if (dVar.c().c("enable_share_with_share_ticket")) {
                str3 = "withShareTicket";
            } else {
                str3 = "common";
            }
            aVar.d(str3);
            aVar.a(dVar.c().c("enable_share_dynamic"));
            aVar.e("weixin");
            aVar.setContext(h.this.y0(), h.this.getComponentId()).dispatch();
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function3 {
        public c() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, h hVar, String str) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            if ((h.this.getRuntime().j0().e() & 32) <= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function3 {
        public d() {
            super(3);
        }

        public final void a(Context context, h hVar, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 41, null, 0L, 0, 0, 60, null);
            com.tencent.luggage.wxa.c3.b bVar = new com.tencent.luggage.wxa.c3.b();
            h hVar2 = h.this;
            bVar.c(hVar2.n0());
            bVar.b(hVar2.B0());
            bVar.setContext(h.this.y0(), h.this.getComponentId()).dispatch();
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends Lambda implements Function2 {
        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, h hVar) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            if ((h.this.getRuntime().j0().e() & 64) > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends Lambda implements Function3 {
        public f() {
            super(3);
        }

        public final void a(Context context, h hVar, String str) {
            String str2;
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 4, null, 0L, 0, 0, 60, null);
            String title = h.this.n0();
            if (w0.c(title)) {
                title = h.this.getRuntime().S().f125809b;
            }
            com.tencent.luggage.wxa.b7.a aVar = new com.tencent.luggage.wxa.b7.a();
            h hVar2 = h.this;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            aVar.d(title);
            String urlWithQuery = hVar2.B0();
            Intrinsics.checkNotNullExpressionValue(urlWithQuery, "urlWithQuery");
            aVar.c(urlWithQuery);
            com.tencent.luggage.wxa.f3.a q16 = hVar2.q1();
            if (q16 != null) {
                str2 = q16.getCurrentURL();
            } else {
                str2 = null;
            }
            aVar.e(str2);
            aVar.setContext(h.this.y0(), h.this.getComponentId()).dispatch();
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final g f140085a = new g();

        public g() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, h hVar, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s6.h$h, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6708h extends Lambda implements Function3 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.s6.h$h$a */
        /* loaded from: classes8.dex */
        public static final class a extends b.f {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f140087a;

            public a(h hVar) {
                this.f140087a = hVar;
            }

            @Override // com.tencent.luggage.wxa.n5.b.f
            public void a(int i3, String str, String str2, int i16, boolean z16) {
                com.tencent.luggage.wxa.s2.a.a(this.f140087a.getRuntime(), i16);
            }
        }

        public C6708h() {
            super(3);
        }

        public final void a(Context context, h hVar, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 30, null, 0L, 0, 0, 60, null);
            i.a aVar = com.tencent.luggage.wxa.k5.i.f131509a;
            h hVar2 = h.this;
            String appId = hVar2.getAppId();
            com.tencent.luggage.wxa.fd.i a16 = com.tencent.luggage.wxa.e5.b.a(h.this);
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
            aVar.a((v) hVar2, appId, ((com.tencent.luggage.wxa.j4.d) a16).G, com.tencent.luggage.wxa.e5.b.a(h.this).f125809b, false, (b.e) new a(h.this));
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i extends Lambda implements Function3 {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f140089a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h hVar) {
                super(0);
                this.f140089a = hVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                String trimIndent;
                trimIndent = StringsKt__IndentKt.trimIndent("\n                            {\n                                \"appId\": \"" + this.f140089a.getAppId() + "\",\n                                \"pageId\": \"" + this.f140089a.A0() + "\",\n                                \"appVersion\": " + this.f140089a.getRuntime().j0().b() + ",\n                                \"versionType\": " + this.f140089a.getRuntime().l0() + "\n                            }\n                        ");
                return trimIndent;
            }
        }

        public i() {
            super(3);
        }

        public final void a(Context context, h pageView, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pageView, "pageView");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 31, null, 0L, 0, 0, 60, null);
            WxaEnterWechatInvokeManager wxaEnterWechatInvokeManager = WxaEnterWechatInvokeManager.f140737a;
            String appId = pageView.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "pageView.appId");
            wxaEnterWechatInvokeManager.a(appId, pageView.getContext(), "sdk_openFeedback", new a(pageView));
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final j f140090a = new j();

        public j() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, h pageView, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pageView, "pageView");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k extends Lambda implements Function3 {
        public k() {
            super(3);
        }

        public final void a(Context context, h pageView, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pageView, "pageView");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 40, null, 0L, 0, 0, 60, null);
            com.tencent.luggage.wxa.gi.b.b(com.tencent.luggage.wxa.ik.a.class, pageView.getAppId());
            com.tencent.luggage.wxa.gi.b.a(com.tencent.luggage.wxa.ik.a.class, pageView.getAppId(), "Network:" + h0.e(z.c()));
            com.tencent.luggage.wxa.c5.e runtime = pageView.getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaRuntime");
            ((com.tencent.luggage.wxa.g7.d) runtime).a((com.tencent.luggage.wxa.fd.i) null, "MenuDelegate_Restart");
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final l f140092a = new l();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements e0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h f140093a;

            public a(h hVar) {
                this.f140093a = hVar;
            }

            @Override // com.tencent.luggage.wxa.xd.e0
            public void a(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                int i3 = 1;
                boolean z16 = false;
                w.d("Wxa.WxaPageView", "onReturnUrl %s", url);
                com.tencent.luggage.wxa.bk.q qVar = com.tencent.luggage.wxa.bk.q.f123029a;
                h hVar = this.f140093a;
                if (url.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    i3 = 2;
                }
                com.tencent.luggage.wxa.bk.q.a(qVar, hVar, 47, null, 0L, i3, 0, 44, null);
                j1.f144855a.a(y.MP_SHORT_LINK, this);
            }
        }

        public l() {
            super(3);
        }

        public final void a(Context context, h pageView, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pageView, "pageView");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            j1.a(j1.f144855a, y.MP_SHORT_LINK, 0L, new a(pageView), 2, null);
            com.tencent.luggage.wxa.xd.q qVar = new com.tencent.luggage.wxa.xd.q(true);
            int componentId = pageView.getComponentId();
            com.tencent.luggage.wxa.r4.d y06 = pageView.y0();
            Intrinsics.checkNotNullExpressionValue(y06, "pageView.service");
            qVar.a(componentId, y06);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.j4.g f140094a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f140095b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(com.tencent.luggage.wxa.j4.g gVar, int i3) {
            super(2);
            this.f140094a = gVar;
            this.f140095b = i3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, h pageview) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pageview, "pageview");
            boolean z17 = false;
            if (this.f140094a.a() == 0) {
                com.tencent.luggage.wxa.ui.a b16 = pageview.b(com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal());
                if (b16 != null && b16.d()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 || this.f140095b == 2) {
                    z17 = true;
                }
            }
            return Boolean.valueOf(z17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f140096a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(int i3) {
            super(3);
            this.f140096a = i3;
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, h hVar, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            boolean z16 = true;
            if (this.f140096a == 1) {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o extends com.tencent.luggage.wxa.wi.a {
        @Override // com.tencent.luggage.wxa.vi.b
        public boolean c(Context context, com.tencent.luggage.wxa.m4.b pageView, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageView, "pageView");
            return super.c(context, pageView, str) || com.tencent.luggage.wxa.q7.r.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class p extends Lambda implements Function3 {
        public p() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Context context, h hVar, String str) {
            boolean a16;
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(hVar, "<anonymous parameter 1>");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            if (com.tencent.luggage.wxa.q7.r.a()) {
                a16 = true;
            } else {
                a16 = t.a(h.this.getRuntime());
            }
            return Boolean.valueOf(a16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class q extends Lambda implements Function3 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vi.c f140099b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(com.tencent.luggage.wxa.vi.c cVar) {
            super(3);
            this.f140099b = cVar;
        }

        public final void a(Context context, h pageView, String str) {
            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(pageView, "pageView");
            Intrinsics.checkNotNullParameter(str, "<anonymous parameter 2>");
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 33, null, 0L, 0, 0, 60, null);
            this.f140099b.a(h.this.getContext(), pageView, h.this.getAppId(), z.c().getString(R.string.yy9) + '@' + z.i());
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            a((Context) obj, (h) obj2, (String) obj3);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, h.this, 22, null, 0L, 0, 0, 60, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Class<? extends x> rendererClass) {
        super(rendererClass);
        Intrinsics.checkNotNullParameter(rendererClass, "rendererClass");
        if (com.tencent.luggage.wxa.q7.r.f138048a.f()) {
            u1.setWebContentsDebuggingEnabled(true);
        }
    }

    public final boolean E1() {
        return getRuntime().S().l();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F1() {
        int i3;
        com.tencent.luggage.wxa.ui.a b16;
        int i16;
        com.tencent.luggage.wxa.lj.a a16;
        int i17;
        com.tencent.luggage.wxa.ui.a b17;
        int i18;
        com.tencent.luggage.wxa.ui.a b18 = b(com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal());
        if (b18 != null) {
            Intrinsics.checkNotNullExpressionValue(b18, "this.getMenuItem(MenuIte\u2026.ordinal) ?: return@run 0");
            if (b18 instanceof com.tencent.luggage.wxa.l7.d) {
                com.tencent.luggage.wxa.l7.d dVar = (com.tencent.luggage.wxa.l7.d) b18;
                Function3 f16 = dVar.f();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String appId = getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                if (((Boolean) f16.invoke(context, this, appId)).booleanValue()) {
                    Function2 g16 = dVar.g();
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    if (!((Boolean) g16.invoke(context2, this)).booleanValue()) {
                        i3 = 1;
                        b16 = b(com.tencent.luggage.wxa.ui.b.ShareToTimeLine.ordinal());
                        if (b16 != null) {
                            Intrinsics.checkNotNullExpressionValue(b16, "this.getMenuItem(MenuIte\u2026.ordinal) ?: return@run 0");
                            if (b16 instanceof com.tencent.luggage.wxa.l7.d) {
                                com.tencent.luggage.wxa.l7.d dVar2 = (com.tencent.luggage.wxa.l7.d) b16;
                                Function3 f17 = dVar2.f();
                                Context context3 = getContext();
                                Intrinsics.checkNotNullExpressionValue(context3, "context");
                                String appId2 = getAppId();
                                Intrinsics.checkNotNullExpressionValue(appId2, "appId");
                                if (((Boolean) f17.invoke(context3, this, appId2)).booleanValue()) {
                                    Function2 g17 = dVar2.g();
                                    Context context4 = getContext();
                                    Intrinsics.checkNotNullExpressionValue(context4, "context");
                                    if (!((Boolean) g17.invoke(context4, this)).booleanValue()) {
                                        i16 = 1;
                                        a16 = a.b.a(getRuntime());
                                        if (a16.b() == a.c.LBS.ordinal()) {
                                            i17 = 1;
                                        } else if (a16.b() == a.c.VOICE.ordinal()) {
                                            i17 = 2;
                                        } else {
                                            i17 = 0;
                                        }
                                        b17 = b(com.tencent.luggage.wxa.ui.b.CopyShortLink.ordinal());
                                        if (b17 != null) {
                                            Intrinsics.checkNotNullExpressionValue(b17, "this.getMenuItem(MenuIte\u2026.ordinal) ?: return@run 0");
                                            if (b17 instanceof com.tencent.luggage.wxa.l7.d) {
                                                com.tencent.luggage.wxa.l7.d dVar3 = (com.tencent.luggage.wxa.l7.d) b17;
                                                Function3 f18 = dVar3.f();
                                                Context context5 = getContext();
                                                Intrinsics.checkNotNullExpressionValue(context5, "context");
                                                String appId3 = getAppId();
                                                Intrinsics.checkNotNullExpressionValue(appId3, "appId");
                                                if (((Boolean) f18.invoke(context5, this, appId3)).booleanValue()) {
                                                    Function2 g18 = dVar3.g();
                                                    Context context6 = getContext();
                                                    Intrinsics.checkNotNullExpressionValue(context6, "context");
                                                    if (!((Boolean) g18.invoke(context6, this)).booleanValue()) {
                                                        i18 = 1;
                                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                                        String format = String.format("%d_%d_%d_%d_%d_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), -1, Integer.valueOf(i17), Integer.valueOf(i16), -1, Integer.valueOf(i18)}, 6));
                                                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                                                        com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, this, 28, format, 0L, 0, 0, 56, null);
                                                    }
                                                }
                                            }
                                            i18 = 2;
                                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                            String format2 = String.format("%d_%d_%d_%d_%d_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), -1, Integer.valueOf(i17), Integer.valueOf(i16), -1, Integer.valueOf(i18)}, 6));
                                            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                                            com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, this, 28, format2, 0L, 0, 0, 56, null);
                                        }
                                        i18 = 0;
                                        StringCompanionObject stringCompanionObject22 = StringCompanionObject.INSTANCE;
                                        String format22 = String.format("%d_%d_%d_%d_%d_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), -1, Integer.valueOf(i17), Integer.valueOf(i16), -1, Integer.valueOf(i18)}, 6));
                                        Intrinsics.checkNotNullExpressionValue(format22, "format(format, *args)");
                                        com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, this, 28, format22, 0L, 0, 0, 56, null);
                                    }
                                }
                            }
                        }
                        i16 = 0;
                        a16 = a.b.a(getRuntime());
                        if (a16.b() == a.c.LBS.ordinal()) {
                        }
                        b17 = b(com.tencent.luggage.wxa.ui.b.CopyShortLink.ordinal());
                        if (b17 != null) {
                        }
                        i18 = 0;
                        StringCompanionObject stringCompanionObject222 = StringCompanionObject.INSTANCE;
                        String format222 = String.format("%d_%d_%d_%d_%d_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), -1, Integer.valueOf(i17), Integer.valueOf(i16), -1, Integer.valueOf(i18)}, 6));
                        Intrinsics.checkNotNullExpressionValue(format222, "format(format, *args)");
                        com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, this, 28, format222, 0L, 0, 0, 56, null);
                    }
                }
            }
        }
        i3 = 0;
        b16 = b(com.tencent.luggage.wxa.ui.b.ShareToTimeLine.ordinal());
        if (b16 != null) {
        }
        i16 = 0;
        a16 = a.b.a(getRuntime());
        if (a16.b() == a.c.LBS.ordinal()) {
        }
        b17 = b(com.tencent.luggage.wxa.ui.b.CopyShortLink.ordinal());
        if (b17 != null) {
        }
        i18 = 0;
        StringCompanionObject stringCompanionObject2222 = StringCompanionObject.INSTANCE;
        String format2222 = String.format("%d_%d_%d_%d_%d_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), -1, Integer.valueOf(i17), Integer.valueOf(i16), -1, Integer.valueOf(i18)}, 6));
        Intrinsics.checkNotNullExpressionValue(format2222, "format(format, *args)");
        com.tencent.luggage.wxa.bk.q.a(com.tencent.luggage.wxa.bk.q.f123029a, this, 28, format2222, 0L, 0, 0, 56, null);
    }

    @Override // com.tencent.luggage.wxa.p5.e, com.tencent.luggage.wxa.kj.v
    public List S() {
        com.tencent.luggage.wxa.j4.g gVar;
        ArrayList arrayList = new ArrayList();
        d.a aVar = com.tencent.luggage.wxa.l7.d.f133104m;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.luggage.wxa.l7.d a16 = d.a.a(aVar, a0.e(context, R.string.f242417ui), R.drawable.m9f, false, ContextCompat.getColor(getContext(), R.color.ap8), com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal(), true, 4, null);
        a16.b(new b(a16));
        a16.a(new c());
        arrayList.add(a16);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        com.tencent.luggage.wxa.l7.d a17 = d.a.a(aVar, a0.e(context2, R.string.f242397ug), R.drawable.m9d, false, 0, com.tencent.luggage.wxa.ui.b.ShareToTimeLine.ordinal(), true, 4, null);
        a17.b(new d());
        a17.a(new e());
        arrayList.add(a17);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        com.tencent.luggage.wxa.l7.d a18 = d.a.a(aVar, a0.e(context3, R.string.f242427uj), R.drawable.m97, false, 0, com.tencent.luggage.wxa.ui.b.Fav.ordinal(), false, 4, null);
        a18.b(new f());
        a18.a(g.f140085a);
        arrayList.add(a18);
        arrayList.add(new com.tencent.luggage.wxa.ui.a(com.tencent.luggage.wxa.ui.b.ModifyCollection.ordinal(), new com.tencent.luggage.wxa.n7.a()));
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        com.tencent.luggage.wxa.l7.d a19 = d.a.a(aVar, a0.e(context4, R.string.f242407uh), R.drawable.m9e, false, 0, 0, false, 56, null);
        a19.b(new C6708h());
        arrayList.add(a19);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "context");
        com.tencent.luggage.wxa.l7.d a26 = d.a.a(aVar, a0.e(context5, R.string.f242377ue), R.drawable.m98, false, 0, 0, false, 56, null);
        a26.b(new i());
        arrayList.add(a26);
        Context context6 = getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        com.tencent.luggage.wxa.l7.d a27 = d.a.a(aVar, a0.e(context6, R.string.f167862e3), R.drawable.m8t, false, 0, 0, false, 56, null);
        a27.a(j.f140090a);
        a27.b(new k());
        arrayList.add(a27);
        com.tencent.luggage.wxa.c5.e runtime = getRuntime();
        if (runtime != null) {
            gVar = runtime.j0();
        } else {
            gVar = null;
        }
        Intrinsics.checkNotNull(gVar);
        int a28 = com.tencent.luggage.wxa.fd.a.a(com.tencent.luggage.wxa.fd.a.CopyShortLink, gVar, 0, 2, null);
        Context context7 = getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "context");
        com.tencent.luggage.wxa.l7.d a29 = d.a.a(aVar, a0.e(context7, R.string.f167832e0), R.drawable.m8s, false, 0, com.tencent.luggage.wxa.ui.b.CopyShortLink.ordinal(), false, 40, null);
        a29.b(l.f140092a);
        a29.a(new m(gVar, a28));
        a29.a(new n(a28));
        arrayList.add(a29);
        Context context8 = getContext();
        Intrinsics.checkNotNullExpressionValue(context8, "context");
        com.tencent.luggage.wxa.l7.d a36 = d.a.a(aVar, a0.e(context8, R.string.f242367ud), R.drawable.wxa_menu_enable_debug, false, 0, 0, false, 56, null);
        com.tencent.luggage.wxa.vi.c cVar = new com.tencent.luggage.wxa.vi.c();
        cVar.a(new o());
        if (E1()) {
            try {
                cVar.a((com.tencent.luggage.wxa.vi.b) Reflect.on("com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.SecondaryMenuDelegate_GameCpuProfiler").create().get());
            } catch (Exception unused) {
            }
        }
        if (com.tencent.luggage.wxa.q7.r.a()) {
            cVar.a(new com.tencent.luggage.wxa.m7.d());
            cVar.a(new com.tencent.luggage.wxa.m7.c());
            cVar.a(new com.tencent.luggage.wxa.m7.b());
            cVar.a(new com.tencent.luggage.wxa.m7.a());
        }
        a36.a(new p());
        a36.b(new q(cVar));
        arrayList.add(a36);
        return arrayList;
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public View W0() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.luggage.wxa.k7.c cVar = new com.tencent.luggage.wxa.k7.c(context);
        cVar.setPage(this);
        return cVar;
    }

    @Override // com.tencent.luggage.wxa.p5.e, com.tencent.luggage.wxa.m4.b, com.tencent.luggage.wxa.kj.v
    public void a(Context context, com.tencent.luggage.wxa.ic.g rt5) {
        super.a(context, rt5);
        com.tencent.luggage.wxa.c5.e runtime = getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaRuntime");
        a(new com.tencent.luggage.wxa.z6.c((com.tencent.luggage.wxa.g7.d) runtime, this));
        W().setCloseButtonClickListener(new r());
    }

    @Override // com.tencent.luggage.wxa.p5.e, com.tencent.luggage.wxa.xd.j
    public void a(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.a(config);
        com.tencent.luggage.wxa.s6.b.f140072a.a(config);
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void a(List menuInfoList, Runnable onShow, Runnable onDismiss) {
        Intrinsics.checkNotNullParameter(menuInfoList, "menuInfoList");
        com.tencent.luggage.wxa.s6.g gVar = com.tencent.luggage.wxa.s6.g.f140078a;
        List provideCustomActionItems = com.tencent.luggage.wxa.q7.v.f138193a.provideCustomActionItems(getAppId());
        if (provideCustomActionItems == null) {
            provideCustomActionItems = CollectionsKt__CollectionsKt.emptyList();
        }
        com.tencent.luggage.wxa.l7.e eVar = new com.tencent.luggage.wxa.l7.e(this, gVar.a(menuInfoList, provideCustomActionItems));
        eVar.d(onShow);
        eVar.c(onDismiss);
        eVar.f();
        com.tencent.luggage.wxa.p7.l a16 = com.tencent.luggage.wxa.p7.l.f137406b.a();
        String appId = getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        String str = getRuntime().S().G;
        Intrinsics.checkNotNullExpressionValue(str, "runtime.initConfig.username");
        a16.a(appId, str, getRuntime().l0());
        F1();
    }

    @Override // com.tencent.luggage.wxa.kj.v
    public void a(int menuItemId, boolean disable) {
        List<com.tencent.luggage.wxa.ui.a> l06;
        super.a(menuItemId, disable);
        if (com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal() != menuItemId || (l06 = l0()) == null) {
            return;
        }
        for (com.tencent.luggage.wxa.ui.a aVar : l06) {
            if (aVar instanceof com.tencent.luggage.wxa.l7.c) {
                com.tencent.luggage.wxa.l7.c cVar = (com.tencent.luggage.wxa.l7.c) aVar;
                if (cVar.l() == WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage) {
                    cVar.a(disable);
                }
            }
        }
    }
}
