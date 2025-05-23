package com.tencent.luggage.wxa.e7;

import android.app.Application;
import com.tencent.luggage.wxa.n3.i;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.p3.g;
import com.tencent.luggage.wxa.tj.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.v3.c;
import com.tencent.luggage.wxa.v3.f;
import com.tencent.luggage.wxa.v3.h;
import com.tencent.luggage.wxa.v3.m;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.net.URLEncoder;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f124576a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tj.c f124577b = c.f124580a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.e7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6158a implements h.i {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.tj.e f124578a;

        /* renamed from: b, reason: collision with root package name */
        public final b f124579b;

        public C6158a(com.tencent.luggage.wxa.tj.e context, b bVar) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f124578a = context;
            this.f124579b = bVar;
        }

        @Override // com.tencent.luggage.wxa.v3.h.i
        public void a(String str) {
            boolean z16;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.f124578a.d().a(this.f124578a.c(), str);
            }
            b bVar = this.f124579b;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void a(Object obj);

        void a(String str);

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.tj.c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f124580a = new c();

        @Override // com.tencent.luggage.wxa.tj.c
        public final boolean a(com.tencent.luggage.wxa.tj.e eVar, b.j jVar, com.tencent.luggage.wxa.bj.a aVar) {
            return a.f124576a.a(eVar, new C6159a(eVar, jVar), aVar);
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e7.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6159a implements b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.tj.e f124581a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b.j f124582b;

            public C6159a(com.tencent.luggage.wxa.tj.e eVar, b.j jVar) {
                this.f124581a = eVar;
                this.f124582b = jVar;
            }

            @Override // com.tencent.luggage.wxa.e7.a.b
            public void a(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                com.tencent.luggage.wxa.tj.e eVar = this.f124581a;
                Intrinsics.checkNotNull(eVar);
                eVar.d().a(this.f124581a.c(), message);
                b.j jVar = this.f124582b;
                if (jVar != null) {
                    jVar.onCancel();
                }
            }

            @Override // com.tencent.luggage.wxa.e7.a.b
            public void b() {
                b.j jVar = this.f124582b;
                if (jVar != null) {
                    jVar.a();
                }
            }

            @Override // com.tencent.luggage.wxa.e7.a.b
            public void a() {
                b.j jVar = this.f124582b;
                if (jVar != null) {
                    jVar.onCancel();
                }
            }

            @Override // com.tencent.luggage.wxa.e7.a.b
            public void a(Object obj) {
                b.j jVar = this.f124582b;
                if (jVar != null) {
                    jVar.onCancel();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.v3.d f124583a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f124584b;

        public d(com.tencent.luggage.wxa.v3.d dVar, b bVar) {
            this.f124583a = dVar;
            this.f124584b = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(String str) {
            boolean contains;
            contains = ArraysKt___ArraysKt.contains(new Integer[]{3, 1}, Integer.valueOf(this.f124583a.f143059e));
            if (contains) {
                if (!(str == null || str.length() == 0)) {
                    b bVar = this.f124584b;
                    if (bVar != null) {
                        bVar.a(str);
                        return;
                    }
                    return;
                }
                b bVar2 = this.f124584b;
                if (bVar2 != null) {
                    bVar2.a((Object) "fail invalid result");
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, str)) {
                b bVar3 = this.f124584b;
                if (bVar3 != null) {
                    bVar3.b();
                    return;
                }
                return;
            }
            b bVar4 = this.f124584b;
            if (bVar4 != null) {
                bVar4.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tj.e f124585a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f124586b;

        public e(com.tencent.luggage.wxa.tj.e eVar, b bVar) {
            this.f124585a = eVar;
            this.f124586b = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            w.b("Luggage.STANDALONE.JsAuthTransferLogic", "handleCgiTransferActionIfNeed, interrupted by " + obj + ", context:" + this.f124585a);
            b bVar = this.f124586b;
            if (bVar != null) {
                bVar.a(obj);
            }
        }
    }

    public final void a(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        com.tencent.luggage.wxa.tj.b.a(f124577b);
    }

    public final boolean a(com.tencent.luggage.wxa.tj.e eVar, b bVar, Object obj) {
        if ((obj instanceof i) && eVar != null) {
            i iVar = (i) obj;
            if (iVar.a().f129029e != null) {
                m mVar = m.f143124a;
                if (mVar.c()) {
                    com.tencent.luggage.wxa.v3.d dVar = new com.tencent.luggage.wxa.v3.d();
                    dVar.f143055a = c.C6818c.a(eVar.d());
                    dVar.f143056b = eVar.a();
                    dVar.f143057c = eVar.b();
                    dVar.f143058d = eVar.c();
                    String b16 = eVar.b();
                    dVar.f143059e = ((b16 == null || b16.length() == 0) || iVar.a().f129029e.f127783d != 2) ? iVar.a().f129029e.f127783d : 3;
                    mVar.a(dVar).a(new d(dVar, bVar)).a(new e(eVar, bVar));
                } else if (!f.c()) {
                    com.tencent.luggage.wxa.d7.a.f124128a.a(eVar.d(), R.string.zvu);
                } else if (g.a() == 3) {
                    com.tencent.luggage.wxa.d7.a.f124128a.a(eVar.d(), R.string.zvt);
                } else {
                    WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                    req.userName = h.a((com.tencent.luggage.wxa.xd.i) eVar.d());
                    req.miniprogramType = eVar.d().getRuntime().l0();
                    req.path = "__wx__/open-api-redirecting-page";
                    req.extData = URLEncoder.encode(f124576a.a(eVar, 3).toString());
                    h.a(eVar.c(), req, new C6158a(eVar, bVar));
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0015 A[Catch: JSONException -> 0x001f, TRY_LEAVE, TryCatch #0 {JSONException -> 0x001f, blocks: (B:3:0x0002, B:5:0x0008, B:18:0x0015), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.tencent.luggage.wxa.v3.i a(com.tencent.luggage.wxa.tj.e eVar, int i3) {
        JSONObject jSONObject;
        String b16;
        boolean z16;
        try {
            b16 = eVar.b();
        } catch (JSONException unused) {
            w.f("Luggage.STANDALONE.JsAuthTransferLogic", "makeOpenSdkTransferParams json parse failed");
        }
        if (b16 != null && b16.length() != 0) {
            z16 = false;
            if (!z16) {
                jSONObject = null;
                com.tencent.luggage.wxa.v3.i d16 = new com.tencent.luggage.wxa.v3.i().f(eVar.a()).a(eVar.c()).e(eVar.d().getAppId()).k(com.tencent.luggage.wxa.s3.f.c()).l(l.f136139a.e()).m("Test").c(1).a(true).a(jSONObject != null ? jSONObject.toString() : null).b(eVar.d().getContext().getClass().getName()).d(h.b(eVar.d()));
                Intrinsics.checkNotNullExpressionValue(d16, "Req()\n            .name(\u2026i.jsapiType(context.env))");
                return d16;
            }
            jSONObject = new JSONObject(eVar.b());
            com.tencent.luggage.wxa.v3.i d162 = new com.tencent.luggage.wxa.v3.i().f(eVar.a()).a(eVar.c()).e(eVar.d().getAppId()).k(com.tencent.luggage.wxa.s3.f.c()).l(l.f136139a.e()).m("Test").c(1).a(true).a(jSONObject != null ? jSONObject.toString() : null).b(eVar.d().getContext().getClass().getName()).d(h.b(eVar.d()));
            Intrinsics.checkNotNullExpressionValue(d162, "Req()\n            .name(\u2026i.jsapiType(context.env))");
            return d162;
        }
        z16 = true;
        if (!z16) {
        }
    }
}
