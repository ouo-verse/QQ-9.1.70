package com.tencent.luggage.wxa.v3;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.opensdk.OpenSDKApiContentProvider;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.g6.a;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.r0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.v3.c;
import com.tencent.luggage.wxa.v3.f;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h extends com.tencent.luggage.wxa.xd.a implements LuggageActivityHelper.g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements f.c {
        @Override // com.tencent.luggage.wxa.v3.f.c
        public String a(BaseResp baseResp) {
            if (baseResp instanceof WXLaunchMiniProgram.Resp) {
                return h.b(j.a((WXLaunchMiniProgram.Resp) baseResp).f143115a);
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143072a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143073b;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3) {
            this.f143072a = dVar;
            this.f143073b = i3;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            String str;
            if (this.f143072a.isRunning()) {
                com.tencent.luggage.wxa.ml.m currentDialog = this.f143072a.getDialogContainer().getCurrentDialog();
                if (currentDialog instanceof o) {
                    currentDialog.dismiss();
                }
            }
            if (obj instanceof Exception) {
                str = "fail " + ((Exception) obj).getMessage();
            } else if (!(obj instanceof String)) {
                str = "fail";
            } else {
                str = (String) obj;
                if (!str.startsWith("fail")) {
                    str = "fail " + str;
                }
            }
            w.b("Luggage.OpenSDKBridgedJsApi", "invoke onInterrupt appId:%s, callbackId:%d, name:%s message:%s", this.f143072a.getAppId(), Integer.valueOf(this.f143073b), h.this.getName(), str);
            h hVar = h.this;
            hVar.a(this.f143072a, this.f143073b, hVar.makeReturnJson(str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143075a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143076b;

        public c(com.tencent.luggage.wxa.ic.d dVar, int i3) {
            this.f143075a = dVar;
            this.f143076b = i3;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                w.d("Luggage.OpenSDKBridgedJsApi", "result is empty, appId[%s] callbackId[%d]", this.f143075a.getAppId(), Integer.valueOf(this.f143076b));
                h hVar = h.this;
                hVar.a(this.f143075a, this.f143076b, hVar.makeReturnJson("fail:internal error"));
            } else {
                String b16 = h.this.b(str);
                w.d("Luggage.OpenSDKBridgedJsApi", "appId:%s callbackId:%d result:%s, processedResult:%s", this.f143075a.getAppId(), Integer.valueOf(this.f143076b), str, b16);
                h.this.a(this.f143075a, this.f143076b, b16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements LuggageActivityHelper.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143078a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143079b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f143080c;

        public d(com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
            this.f143078a = dVar;
            this.f143079b = i3;
            this.f143080c = str;
        }

        @Override // com.tencent.luggage.util.LuggageActivityHelper.d
        public void a(int i3, Intent intent) {
            this.f143078a.a(this.f143079b, this.f143080c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143082b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f143083c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements i {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143085a;

            public a(com.tencent.luggage.wxa.xo.b bVar) {
                this.f143085a = bVar;
            }

            @Override // com.tencent.luggage.wxa.v3.h.i
            public void a(String str) {
                if (w0.c(str)) {
                    w.b("Luggage.OpenSDKBridgedJsApi", "invokeByOpenSdk result is empty, name[%s] appId[%s] callbackId[%d]", h.this.getName(), e.this.f143082b.getAppId(), Integer.valueOf(e.this.f143083c));
                    this.f143085a.a("fail:internal error");
                } else {
                    this.f143085a.a(str);
                }
            }
        }

        public e(com.tencent.luggage.wxa.ic.d dVar, int i3) {
            this.f143082b = dVar;
            this.f143083c = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(String str) {
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            String a16 = h.a((com.tencent.luggage.wxa.xd.i) this.f143082b);
            req.userName = a16;
            if (w0.c(a16)) {
                w.b("Luggage.OpenSDKBridgedJsApi", "invoke fail, username is empty");
                com.tencent.luggage.wxa.xo.h.a().a("fail:internal error");
                return null;
            }
            req.miniprogramType = this.f143082b.getRuntime().l0();
            String c16 = h.this.c(str);
            req.extData = c16;
            req.path = "__wx__/open-api-redirecting-page";
            w.a("Luggage.OpenSDKBridgedJsApi", "params:%s", c16);
            h.a(this.f143083c, req, new a(com.tencent.luggage.wxa.xo.h.b()));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143087b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f143088c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f143089d;

        public f(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
            this.f143087b = dVar;
            this.f143088c = jSONObject;
            this.f143089d = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Void r46) {
            com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) h.this.c(this.f143087b, this.f143088c, this.f143089d));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements f.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f143091a;

        public g(i iVar) {
            this.f143091a = iVar;
        }

        @Override // com.tencent.luggage.wxa.v3.f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResp(WXLaunchMiniProgram.Resp resp) {
            j a16 = j.a(resp);
            if (a16 != null) {
                this.f143091a.a(a16.f143116b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.v3.h$h, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6819h implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143092b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f143093c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f143094d;

        public C6819h(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
            this.f143092b = dVar;
            this.f143093c = jSONObject;
            this.f143094d = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Void r46) {
            return h.a(c.C6818c.a(this.f143092b), h.this.getName(), this.f143093c, this.f143094d).toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface i {
        void a(String str);
    }

    static {
        com.tencent.luggage.wxa.v3.f.a(WXLaunchMiniProgram.Resp.class, new a());
    }

    public String b(String str) {
        return str;
    }

    public com.tencent.luggage.wxa.xo.d c(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        return com.tencent.luggage.wxa.xo.h.c().b(new C6819h(dVar, jSONObject, i3));
    }

    public boolean e() {
        return false;
    }

    public final com.tencent.luggage.wxa.xo.d b(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        return com.tencent.luggage.wxa.xo.h.c().c(new f(dVar, jSONObject, i3)).c(new e(dVar, i3));
    }

    public final String c(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.xo.d a16;
        w.d("Luggage.OpenSDKBridgedJsApi", "redirect jsapi %s call via open sdk, callbackId=%d", getName(), Integer.valueOf(i3));
        if (com.tencent.luggage.wxa.v3.g.a()) {
            m mVar = m.f143124a;
            if (mVar.c()) {
                com.tencent.luggage.wxa.v3.d dVar2 = new com.tencent.luggage.wxa.v3.d();
                dVar2.f143055a = c.C6818c.a(dVar);
                dVar2.f143056b = getName();
                dVar2.f143057c = jSONObject.toString();
                dVar2.f143058d = i3;
                dVar2.f143059e = 1;
                a16 = mVar.a(dVar2);
            } else {
                a16 = b(dVar, jSONObject, i3);
            }
        } else if (r0.f141703d) {
            a16 = q.a(dVar, this, jSONObject, i3);
        } else {
            w.b("Luggage.OpenSDKBridgedJsApi", "redirect jsapi %s call via open sdk, callbackId=%d, no invoker supported", getName(), Integer.valueOf(i3));
            dVar.a(i3, makeReturnJson("fail wechat not installed"));
            return;
        }
        a16.a(new c(dVar, i3)).a(com.tencent.luggage.wxa.yo.d.f146044a, new b(dVar, i3));
    }

    public static String b(int i3) {
        return "" + i3;
    }

    public static String b(Object obj) {
        if (obj instanceof com.tencent.luggage.wxa.v3.c) {
            return b(((com.tencent.luggage.wxa.v3.c) obj).a());
        }
        if (obj instanceof com.tencent.luggage.wxa.ic.l) {
            return "appservice";
        }
        if (obj instanceof v) {
            return "webview";
        }
        w.b("Luggage.OpenSDKBridgedJsApi", "invalid jsapi env type: %s", obj.getClass());
        return "appservice";
    }

    public final void a(com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
        Context context = dVar.getContext();
        if (e() && a.CC.c(context)) {
            Intent intent = new Intent();
            intent.setClass(dVar.getContext(), k.class);
            a.CC.a(dVar.getContext()).overridePendingTransition(0, 0);
            o21.a.a(dVar.getContext()).a(dVar.getContext(), intent, new d(dVar, i3, str));
            return;
        }
        dVar.a(i3, str);
    }

    public static void a(int i3, WXLaunchMiniProgram.Req req, i iVar) {
        w.a("Luggage.OpenSDKBridgedJsApi", "send mini program launch request: %s", req.path);
        com.tencent.luggage.wxa.v3.f.a(b(i3), req, new g(iVar));
    }

    public static String a(com.tencent.luggage.wxa.xd.i iVar) {
        if (!(iVar.getRuntime().S() instanceof com.tencent.luggage.wxa.j4.d)) {
            return "";
        }
        String str = ((com.tencent.luggage.wxa.j4.d) iVar.getRuntime().S()).G;
        return str.endsWith("@app") ? str.replace("@app", "") : str;
    }

    public static com.tencent.luggage.wxa.v3.i a(com.tencent.luggage.wxa.ic.d dVar, String str, JSONObject jSONObject, int i3) {
        return a(c.C6818c.a(dVar), str, jSONObject, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.tencent.luggage.wxa.v3.i a(com.tencent.luggage.wxa.v3.b bVar, String str, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.p5.f fVar;
        String str2;
        String str3;
        boolean z16 = bVar instanceof com.tencent.luggage.wxa.v3.c;
        if (z16) {
            OpenSDKApiContentProvider.a(((com.tencent.luggage.wxa.v3.c) bVar).a(), jSONObject);
        }
        if (z16) {
            fVar = (com.tencent.luggage.wxa.p5.f) ((com.tencent.luggage.wxa.v3.c) bVar).a().getRuntime();
        } else {
            fVar = bVar instanceof com.tencent.luggage.wxa.ic.d ? (com.tencent.luggage.wxa.p5.f) ((com.tencent.luggage.wxa.ic.d) bVar).getRuntime() : null;
        }
        String str4 = "";
        if (fVar != null) {
            String k3 = fVar.S().k();
            str3 = fVar.S().j();
            try {
                com.tencent.luggage.wxa.f3.a q16 = ((com.tencent.luggage.wxa.p5.e) fVar.Y().getCurrentPage().getCurrentPageView()).q1();
                if (q16 != null) {
                    str4 = q16.getCurrentURL();
                }
            } catch (NullPointerException unused) {
            }
            str2 = str4;
            str4 = k3;
        } else {
            str2 = "";
            str3 = str2;
        }
        return new com.tencent.luggage.wxa.v3.i().f(str).a(i3).i(str4).j(str3).e(bVar.getF140742c()).k(com.tencent.luggage.wxa.s3.f.c()).l(com.tencent.luggage.wxa.o3.l.f136139a.e()).m("Test").b(bVar.d()).g(bVar.j()).h(bVar.f()).c(1).c(str2).a(true).a(jSONObject.toString()).b(bVar.b()).d(b(bVar)).b(a(bVar));
    }

    public static boolean a(Object obj) {
        if (obj instanceof com.tencent.luggage.wxa.v3.c) {
            return a((Object) ((com.tencent.luggage.wxa.v3.c) obj).a());
        }
        if (obj instanceof com.tencent.luggage.wxa.ic.d) {
            com.tencent.luggage.wxa.ic.g runtime = ((com.tencent.luggage.wxa.ic.d) obj).getRuntime();
            if (runtime instanceof com.tencent.luggage.wxa.p5.f) {
                return ((com.tencent.luggage.wxa.p5.f) runtime).Q1();
            }
        }
        w.b("Luggage.OpenSDKBridgedJsApi", "invalid isGame type: %s", obj.getClass());
        return false;
    }
}
