package com.tencent.luggage.wxa.v3;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import com.tencent.luggage.wxa.hn.yg;
import com.tencent.luggage.wxa.hn.zg;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.v3.f;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.smtt.sdk.TbsDownloader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f143124a = new m();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f143125a = new a();

        public static final com.tencent.luggage.wxa.fn.c a(String str) {
            if (str == null) {
                return null;
            }
            return com.tencent.luggage.wxa.fn.c.a(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.v3.d f143126a;

        /* renamed from: b, reason: collision with root package name */
        public Function1 f143127b;

        /* renamed from: c, reason: collision with root package name */
        public e0 f143128c;

        /* renamed from: d, reason: collision with root package name */
        public l f143129d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1 f143130a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f143131b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Function1 function1, b bVar) {
                super(1);
                this.f143130a = function1;
                this.f143131b = bVar;
            }

            public final void a(String str) {
                this.f143130a.invoke(str);
                this.f143131b.f143126a.f143055a.release();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((String) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v3.m$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6820b implements com.tencent.luggage.wxa.uo.b {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.v3.m$b$b$a */
            /* loaded from: classes8.dex */
            public static final class a extends Lambda implements Function0 {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b f143133a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(b bVar) {
                    super(0);
                    this.f143133a = bVar;
                }

                @Override // kotlin.jvm.functions.Function0
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Dialog invoke() {
                    Context f140743d = this.f143133a.f143126a.f143055a.getF140743d();
                    if (f140743d == null) {
                        f140743d = z.c();
                    }
                    WeUIProgresssDialog progressDialog = WeUIProgresssDialog.getProgressDialog(f140743d, z.c().getString(R.string.f172732r9), false, null);
                    Intrinsics.checkNotNullExpressionValue(progressDialog, "getProgressDialog(\n     \u2026                    null)");
                    return progressDialog;
                }
            }

            public C6820b() {
            }

            public final void a(Void r36) {
                b bVar = b.this;
                l lVar = new l(new a(bVar));
                lVar.show();
                bVar.f143129d = lVar;
            }

            @Override // com.tencent.luggage.wxa.uo.b
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                a((Void) obj);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c implements com.tencent.luggage.wxa.uo.b {
            public c() {
            }

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String call(Unit unit) {
                com.tencent.luggage.wxa.xo.d a16 = b.this.f143126a.a();
                if (a16 != null) {
                    com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) a16);
                    return "";
                }
                com.tencent.luggage.wxa.xo.h.a().a("fail:internal error");
                return "";
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements com.tencent.luggage.wxa.uo.b {
            public d() {
            }

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final zg call(String invokeArgs) {
                Intrinsics.checkNotNullParameter(invokeArgs, "invokeArgs");
                com.tencent.luggage.wxa.h1.b b16 = b.this.f143126a.f143055a.b(com.tencent.luggage.wxa.bj.c.class);
                Intrinsics.checkNotNull(b16);
                String f140742c = b.this.f143126a.f143055a.getF140742c();
                yg ygVar = new yg();
                b bVar = b.this;
                ygVar.f129103e = bVar.f143126a.f143056b;
                ygVar.f129104f = a.a(invokeArgs);
                ygVar.f129105g = bVar.f143126a.f143059e;
                Unit unit = Unit.INSTANCE;
                com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) ((com.tencent.luggage.wxa.bj.c) b16).b("/cgi-bin/mmbiz-bin/wxaruntime/getdeeplinkticket", f140742c, ygVar, zg.class));
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e implements com.tencent.luggage.wxa.uo.b {

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a implements e0.a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143137a;

                public a(com.tencent.luggage.wxa.xo.b bVar) {
                    this.f143137a = bVar;
                }

                @Override // com.tencent.luggage.wxa.tn.e0.a
                public final boolean a() {
                    this.f143137a.a(new TimeoutException());
                    return false;
                }
            }

            public e() {
            }

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String call(zg zgVar) {
                boolean z16;
                if (zgVar == null) {
                    com.tencent.luggage.wxa.xo.h.a().a("fail: get ticket failed");
                    return "";
                }
                String str = zgVar.f129160e;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                e0 e0Var = null;
                if (z16) {
                    b.this.a("GetDeepLinkTicket return EMPTY ticket");
                    com.tencent.luggage.wxa.xo.h.a().a(new Exception("empty ticket"));
                    return null;
                }
                com.tencent.luggage.wxa.xo.b a16 = com.tencent.luggage.wxa.xo.h.a();
                long millis = TimeUnit.SECONDS.toMillis(zgVar.f129161f);
                b.this.f143128c = new e0(Looper.getMainLooper(), (e0.a) new a(a16), false);
                e0 e0Var2 = b.this.f143128c;
                if (e0Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionExpireTimer");
                } else {
                    e0Var = e0Var2;
                }
                e0Var.a(millis, millis);
                String str2 = zgVar.f129160e;
                Intrinsics.checkNotNull(str2);
                return str2;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class f implements com.tencent.luggage.wxa.uo.b {

            /* compiled from: P */
            /* loaded from: classes8.dex */
            public static final class a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ b f143139a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143140b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.dn.a f143141c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f143142d;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.v3.m$b$f$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6821a extends Lambda implements Function1 {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143143a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C6821a(com.tencent.luggage.wxa.xo.b bVar) {
                        super(1);
                        this.f143143a = bVar;
                    }

                    public final void a(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.f143143a.a(it);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((String) obj);
                        return Unit.INSTANCE;
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.v3.m$b$f$a$b, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6822b extends Lambda implements Function1 {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ b f143144a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143145b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C6822b(b bVar, com.tencent.luggage.wxa.xo.b bVar2) {
                        super(1);
                        this.f143144a = bVar;
                        this.f143145b = bVar2;
                    }

                    public final void a(Object obj) {
                        this.f143144a.a("onResume, StepChecker onError " + obj);
                        this.f143145b.a(obj);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a(obj);
                        return Unit.INSTANCE;
                    }
                }

                public a(b bVar, com.tencent.luggage.wxa.xo.b bVar2, com.tencent.luggage.wxa.dn.a aVar, String str) {
                    this.f143139a = bVar;
                    this.f143140b = bVar2;
                    this.f143141c = aVar;
                    this.f143142d = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (!this.f143139a.f143126a.f143055a.h()) {
                        com.tencent.luggage.wxa.xo.b bVar = this.f143140b;
                        b bVar2 = this.f143139a;
                        bVar.a(b.a(bVar2, bVar2.f143126a, "switch to foreground by user manually", null, 2, null));
                    } else if (!this.f143141c.f124395a) {
                        this.f143139a.a();
                        com.tencent.luggage.wxa.v3.d dVar = this.f143139a.f143126a;
                        String ticket = this.f143142d;
                        Intrinsics.checkNotNullExpressionValue(ticket, "ticket");
                        new n(dVar, ticket, new C6821a(this.f143140b), new C6822b(this.f143139a, this.f143140b)).b();
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.v3.m$b$f$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6823b implements f.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.dn.a f143146a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f143147b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143148c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ String f143149d;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.v3.m$b$f$b$a */
                /* loaded from: classes8.dex */
                public static final class a extends Lambda implements Function1 {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143150a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public a(com.tencent.luggage.wxa.xo.b bVar) {
                        super(1);
                        this.f143150a = bVar;
                    }

                    public final void a(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        this.f143150a.a(it);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a((String) obj);
                        return Unit.INSTANCE;
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.v3.m$b$f$b$b, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6824b extends Lambda implements Function1 {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ b f143151a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143152b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C6824b(b bVar, com.tencent.luggage.wxa.xo.b bVar2) {
                        super(1);
                        this.f143151a = bVar;
                        this.f143152b = bVar2;
                    }

                    public final void a(Object obj) {
                        this.f143151a.a("on OpenSDKApiClient.Callback, StepChecker onError " + obj);
                        this.f143152b.a(obj);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        a(obj);
                        return Unit.INSTANCE;
                    }
                }

                public C6823b(com.tencent.luggage.wxa.dn.a aVar, b bVar, com.tencent.luggage.wxa.xo.b bVar2, String str) {
                    this.f143146a = aVar;
                    this.f143147b = bVar;
                    this.f143148c = bVar2;
                    this.f143149d = str;
                }

                @Override // com.tencent.luggage.wxa.v3.f.b
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void onResp(WXLaunchWxaRedirectingPage.Resp resp) {
                    this.f143146a.f124395a = true;
                    com.tencent.luggage.wxa.v3.e eVar = new com.tencent.luggage.wxa.v3.e();
                    eVar.a(this.f143147b.f143126a);
                    eVar.a(resp);
                    eVar.c();
                    if (!this.f143147b.f143126a.f143055a.h()) {
                        com.tencent.luggage.wxa.xo.b bVar = this.f143148c;
                        b bVar2 = this.f143147b;
                        bVar.a(b.a(bVar2, bVar2.f143126a, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, null, 2, null));
                        return;
                    }
                    if (resp.errCode == 0) {
                        com.tencent.luggage.wxa.v3.d dVar = this.f143147b.f143126a;
                        String ticket = this.f143149d;
                        Intrinsics.checkNotNullExpressionValue(ticket, "ticket");
                        new n(dVar, ticket, new a(this.f143148c), new C6824b(this.f143147b, this.f143148c)).b();
                        return;
                    }
                    this.f143147b.a("on OpenSDKApiClient.Callback, errCode:" + resp.errCode + ", errMsg:" + resp.errStr);
                    HashMap hashMap = new HashMap();
                    hashMap.put("sdkErrCode", Integer.valueOf(resp.errCode));
                    String str = resp.errStr;
                    Intrinsics.checkNotNullExpressionValue(str, "resp.errStr");
                    hashMap.put("sdkErrMsg", str);
                    com.tencent.luggage.wxa.xo.b bVar3 = this.f143148c;
                    b bVar4 = this.f143147b;
                    bVar3.a(bVar4.a(bVar4.f143126a, "fail", hashMap));
                }
            }

            public f() {
            }

            @Override // com.tencent.luggage.wxa.uo.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String call(String str) {
                com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
                com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
                WXLaunchWxaRedirectingPage.Req req = new WXLaunchWxaRedirectingPage.Req();
                b bVar = b.this;
                req.invokeTicket = str;
                req.callbackActivity = bVar.f143126a.f143055a.b();
                if (!com.tencent.luggage.wxa.v3.f.a(str, req, new C6823b(aVar, b.this, b16, str))) {
                    b16.a("fail: send openapi request failed");
                    return null;
                }
                b.this.f143126a.f143055a.a(new a(b.this, b16, aVar, str));
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class g implements e.c {
            public g() {
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public final void a(String str) {
                b.this.b();
                Function1 function1 = b.this.f143127b;
                if (function1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endCallback");
                    function1 = null;
                }
                function1.invoke(str);
                b.this.a();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class h implements e.a {
            public h() {
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public final void a(Object it) {
                String str;
                boolean startsWith$default;
                b.this.a("GetDeepLinkTicket interrupted by " + it);
                if (it instanceof TimeoutException) {
                    str = ((TimeoutException) it).getMessage();
                    if (str == null) {
                        str = "fail:timeout";
                    }
                } else if (it instanceof Exception) {
                    str = ((Exception) it).getMessage();
                    if (str == null) {
                        str = "";
                    }
                } else if (!(it instanceof String)) {
                    str = "fail";
                } else {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    str = (String) it;
                }
                Function1 function1 = null;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "fail", false, 2, null);
                if (!startsWith$default) {
                    str = "fail:" + str;
                }
                String str2 = str;
                b.this.b();
                Function1 function12 = b.this.f143127b;
                if (function12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endCallback");
                } else {
                    function1 = function12;
                }
                b bVar = b.this;
                function1.invoke(b.a(bVar, bVar.f143126a, str2, null, 2, null));
                b.this.a();
            }
        }

        public b(com.tencent.luggage.wxa.v3.d request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f143126a = request;
        }

        public final void b() {
            e0 e0Var = this.f143128c;
            if (e0Var != null) {
                e0Var.f();
            }
        }

        public final void a(String str) {
            w.b("Luggage.WXA.OpenSDKTicketTransferProtocol", "call{" + this.f143126a + "}, " + str);
        }

        public static /* synthetic */ String a(b bVar, com.tencent.luggage.wxa.v3.d dVar, String str, Map map, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                map = null;
            }
            return bVar.a(dVar, str, map);
        }

        public final String a(com.tencent.luggage.wxa.v3.d dVar, String str, Map map) {
            com.tencent.luggage.wxa.xd.o a16 = dVar.f143055a.a(dVar.f143056b);
            if (a16 != null) {
                String makeReturnJson = a16.makeReturnJson(str, (Map<String, ? extends Object>) map);
                Intrinsics.checkNotNullExpressionValue(makeReturnJson, "{\n                apiIns\u2026on, values)\n            }");
                return makeReturnJson;
            }
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.put("errMsg", dVar.f143056b + ':' + str);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n                JSONOb\u2026.toString()\n            }");
            return jSONObject2;
        }

        public final void a() {
            l lVar = this.f143129d;
            if (lVar != null) {
                lVar.dismiss();
            }
        }

        public final void a(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.f143127b = new a(block, this);
            com.tencent.luggage.wxa.xo.h.c().a(this.f143126a.f143055a).a(new C6820b()).c(new c()).c(new d()).c(new e()).b(new f()).a(new g()).a(new h());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f143155b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143156a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.xo.b bVar) {
                super(1);
                this.f143156a = bVar;
            }

            public final void a(String str) {
                this.f143156a.a(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((String) obj);
                return Unit.INSTANCE;
            }
        }

        public c(d dVar) {
            this.f143155b = dVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String call(Void r36) {
            new b(this.f143155b).a(new a(com.tencent.luggage.wxa.xo.h.b()));
            return null;
        }
    }

    public static final boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            return Boolean.parseBoolean((String) obj);
        }
        return false;
    }

    public final boolean a(String feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        try {
            Cursor query = ContactsMonitor.query(z.c().getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/checkIfSupportWxaSDKFeature"), null, null, new String[]{feature}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && query.getInt(query.getColumnIndex(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT)) > 0) {
                        CloseableKt.closeFinally(query, null);
                        return true;
                    }
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } catch (Throwable th5) {
            w.b("Luggage.WXA.OpenSDKTicketTransferProtocol", "checkIsWechatSupportFeatures(" + feature + ") check by provider failed by e:" + th5);
        }
        return false;
    }

    public final boolean c() {
        try {
            Cursor query = ContactsMonitor.query(z.c().getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/checkSupportWxaOpenAPI"), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && query.getInt(query.getColumnIndex(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT)) > 0) {
                        CloseableKt.closeFinally(query, null);
                        return true;
                    }
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } catch (Throwable th5) {
            w.b("Luggage.WXA.OpenSDKTicketTransferProtocol", "support() check by provider failed by e:" + th5);
        }
        try {
            return b(z.c().getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.get("com.tencent.mm.BuildInfo.OPEN_SDK_SUPPORT_WMPF_REDIRECTING_PAGE"));
        } catch (Throwable th6) {
            w.b("Luggage.WXA.OpenSDKTicketTransferProtocol", "support() check failed by e:" + th6);
            return false;
        }
    }

    public final int b() {
        try {
            return a(z.c().getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.get(TbsDownloader.TBS_METADATA));
        } catch (Throwable th5) {
            w.b("Luggage.WXA.OpenSDKTicketTransferProtocol", "getInstalledWechatApkClientVersion exception:" + th5);
            return 0;
        }
    }

    public final com.tencent.luggage.wxa.xo.d b(d dVar) {
        com.tencent.luggage.wxa.xo.d c16 = com.tencent.luggage.wxa.xo.h.c().c(new c(dVar));
        Intrinsics.checkNotNullExpressionValue(c16, "request: BridgedJsApiInv\u2026n@`$logic` null\n        }");
        return c16;
    }

    public final Triple a() {
        try {
            Cursor query = ContactsMonitor.query(z.c().getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/checkFacialRecognitionVerifyCapability"), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        Triple triple = new Triple(Integer.valueOf(query.getInt(query.getColumnIndex("errCode"))), query.getString(query.getColumnIndex("errMsg")), Integer.valueOf(query.getInt(query.getColumnIndex("libVersionCode"))));
                        CloseableKt.closeFinally(query, null);
                        return triple;
                    }
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } catch (Throwable th5) {
            w.b("Luggage.WXA.OpenSDKTicketTransferProtocol", "checkWechatFacialRecognitionVerifyCapability() check by provider failed by e:" + th5);
        }
        return null;
    }

    public static final int a(Object obj) {
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            return Integer.parseInt((String) obj);
        }
        return 0;
    }

    public com.tencent.luggage.wxa.xo.d a(d request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return b(request);
    }
}
