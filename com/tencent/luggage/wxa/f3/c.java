package com.tencent.luggage.wxa.f3;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.kj.o0;
import com.tencent.luggage.wxa.mj.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mobileqq.R;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.ee.b {
    public static final int CTRL_INDEX = 298;
    public static final String NAME = "insertHTMLWebView";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.m4.b f125255a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f3.a f125256b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.f3.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6190a implements com.tencent.luggage.wxa.kl.a {
            public C6190a() {
            }

            @Override // com.tencent.luggage.wxa.kl.a
            public void a(View view) {
                if (ViewCompat.isAttachedToWindow(a.this.f125256b)) {
                    a.this.f125256b.getWebView().getView().scrollTo(a.this.f125256b.getWebView().getWebScrollX(), 0);
                }
            }
        }

        public a(com.tencent.luggage.wxa.m4.b bVar, com.tencent.luggage.wxa.f3.a aVar) {
            this.f125255a = bVar;
            this.f125256b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = (g) this.f125255a.f(g.class);
            if (gVar != null) {
                gVar.a(true);
                gVar.b(false);
            } else if (this.f125255a.b() && !this.f125255a.getRuntime().Q1()) {
                gVar.a(true);
            }
            if (!this.f125255a.getRuntime().Q1()) {
                this.f125255a.n1();
                this.f125255a.W().a(new C6190a());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f3.a f125259a;

        public b(com.tencent.luggage.wxa.f3.a aVar) {
            this.f125259a = aVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.a
        public boolean a() {
            return this.f125259a.e();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f3.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6191c implements g.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f3.a f125261a;

        public C6191c(com.tencent.luggage.wxa.f3.a aVar) {
            this.f125261a = aVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.d
        public void onForeground() {
            this.f125261a.g();
            c.b(this.f125261a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements g.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.f3.a f125263a;

        public d(com.tencent.luggage.wxa.f3.a aVar) {
            this.f125263a = aVar;
        }

        @Override // com.tencent.luggage.wxa.xd.g.b
        public void onBackground() {
            this.f125263a.f();
        }
    }

    @Override // com.tencent.luggage.wxa.ee.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public View inflateView(com.tencent.luggage.wxa.m4.b bVar, JSONObject jSONObject) {
        if (bVar.a(getIndependent(jSONObject)).a(com.tencent.luggage.wxa.f3.a.class) != null) {
            return null;
        }
        if (!WebView.hasInited()) {
            XWebSdk.initWebviewCore(z.c(), WebView.sDefaultWebViewKind, "appbrand", null);
        }
        com.tencent.luggage.wxa.f3.a aVar = new com.tencent.luggage.wxa.f3.a(bVar.getContext(), bVar.getRuntime(), bVar);
        bVar.e(new a(bVar, aVar));
        aVar.setId(R.id.srk);
        aVar.setBackgroundColor(a(bVar, jSONObject));
        bVar.a(new b(aVar));
        bVar.b(new C6191c(aVar));
        bVar.a(new d(aVar));
        return aVar;
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("htmlId");
    }

    public final int a(com.tencent.luggage.wxa.m4.b bVar, JSONObject jSONObject) {
        try {
            if (jSONObject.has("backgroundColor")) {
                return com.tencent.luggage.wxa.tk.g.b(jSONObject.getString("backgroundColor"));
            }
        } catch (Exception unused) {
        }
        if (bVar.getRuntime().Q1()) {
            return 0;
        }
        if (bVar.getRuntime().E().l()) {
            return ContextCompat.getColor(bVar.getContext(), R.color.aqp);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.ee.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onInsertView(com.tencent.luggage.wxa.m4.b bVar, int i3, View view, JSONObject jSONObject) {
        ((com.tencent.luggage.wxa.f3.a) view).setViewId(i3);
        String optString = jSONObject.optString("src");
        w.d("MicroMsg.AppBrand.JsApiInsertHTMLWebView", "onInsertView appId[%s] viewId[%d] viewHash[%d] src[%s]", bVar.getAppId(), Integer.valueOf(i3), Integer.valueOf(view.hashCode()), optString);
        b((com.tencent.luggage.wxa.f3.a) view);
        if (bVar.getRuntime().Q1()) {
            ((com.tencent.luggage.wxa.lh.a) view).a(optString);
        }
    }

    public static void b(com.tencent.luggage.wxa.f3.a aVar) {
        try {
            o0 D0 = aVar.getPageView().D0();
            if (D0 != null) {
                D0.getWrapperView().setFocusable(false);
                D0.getWrapperView().setFocusableInTouchMode(false);
                D0.getContentView().setFocusable(false);
                D0.getContentView().setFocusableInTouchMode(false);
                if (D0.getWrapperView() instanceof ViewGroup) {
                    ((ViewGroup) D0.getWrapperView()).setDescendantFocusability(393216);
                }
            }
        } catch (Throwable unused) {
        }
        try {
            View view = aVar.getWebView().getView();
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            aVar.requestFocus();
        } catch (Throwable unused2) {
        }
    }
}
