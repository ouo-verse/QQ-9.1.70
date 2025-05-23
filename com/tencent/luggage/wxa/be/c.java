package com.tencent.luggage.wxa.be;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.luggage.wxa.ce.a;
import com.tencent.luggage.wxa.hn.m9;
import com.tencent.luggage.wxa.hn.pb;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.y;
import com.tencent.luggage.wxa.uj.i;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.api.MiniConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f122398a = new a(null);

    @NotNull
    private static final String NAME = "getPhoneNumber";
    private static final int CTRL_INDEX = 209;

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
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final m9 f122399a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.hn.i f122400b;

        /* renamed from: c, reason: collision with root package name */
        public final String f122401c;

        /* renamed from: d, reason: collision with root package name */
        public final pb f122402d;

        public b(m9 m9Var, com.tencent.luggage.wxa.hn.i iVar, String applyWording, pb pbVar) {
            Intrinsics.checkNotNullParameter(applyWording, "applyWording");
            this.f122399a = m9Var;
            this.f122400b = iVar;
            this.f122401c = applyWording;
            this.f122402d = pbVar;
        }

        public final com.tencent.luggage.wxa.hn.i a() {
            return this.f122400b;
        }

        public final String b() {
            return this.f122401c;
        }

        public final pb c() {
            return this.f122402d;
        }

        public final m9 d() {
            return this.f122399a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f122399a, bVar.f122399a) && Intrinsics.areEqual(this.f122400b, bVar.f122400b) && Intrinsics.areEqual(this.f122401c, bVar.f122401c) && Intrinsics.areEqual(this.f122402d, bVar.f122402d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            m9 m9Var = this.f122399a;
            int i3 = 0;
            if (m9Var == null) {
                hashCode = 0;
            } else {
                hashCode = m9Var.hashCode();
            }
            int i16 = hashCode * 31;
            com.tencent.luggage.wxa.hn.i iVar = this.f122400b;
            if (iVar == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = iVar.hashCode();
            }
            int hashCode3 = (((i16 + hashCode2) * 31) + this.f122401c.hashCode()) * 31;
            pb pbVar = this.f122402d;
            if (pbVar != null) {
                i3 = pbVar.hashCode();
            }
            return hashCode3 + i3;
        }

        public String toString() {
            return "Info(scopeInfo=" + this.f122399a + ", alertPrivacyInfo=" + this.f122400b + ", applyWording=" + this.f122401c + ", privacyProtectInfo=" + this.f122402d + ')';
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.be.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6047c extends Lambda implements Function4 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122403a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f122404b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C6047c(com.tencent.luggage.wxa.xo.b bVar, List list) {
            super(4);
            this.f122403a = bVar;
            this.f122404b = list;
        }

        public final void a(boolean z16, String errMsg, List list, b bVar) {
            int i3;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getPhoneNumber isSuccess:");
            sb5.append(z16);
            sb5.append(", errMsg:");
            sb5.append(errMsg);
            sb5.append(", phoneItems:");
            boolean z17 = false;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            w.d("MicroMsg.JsApiGetPhoneNumberNew", sb5.toString());
            if (!z16) {
                com.tencent.luggage.wxa.xo.b bVar2 = this.f122403a;
                if (errMsg.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    errMsg = "network request fail";
                }
                bVar2.a(errMsg);
                return;
            }
            this.f122403a.a(com.tencent.luggage.wxa.ap.j.a(com.tencent.luggage.wxa.uj.l.f142509a.a(list, this.f122404b), bVar));
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            a(((Boolean) obj).booleanValue(), (String) obj2, (List) obj3, (b) obj4);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.i f122406c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ v f122407d;

        public d(com.tencent.luggage.wxa.ml.i iVar, v vVar) {
            this.f122406c = iVar;
            this.f122407d = vVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object call(Void r36) {
            return c.this.a(this.f122406c, this.f122407d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements com.tencent.luggage.wxa.uo.b {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List call(Object obj) {
            return c.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f122410c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f122411d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f122412e;

        public f(v vVar, String str, boolean z16) {
            this.f122410c = vVar;
            this.f122411d = str;
            this.f122412e = z16;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.ap.b call(List list) {
            c cVar = c.this;
            v vVar = this.f122410c;
            String apiName = this.f122411d;
            Intrinsics.checkNotNullExpressionValue(apiName, "apiName");
            boolean z16 = this.f122412e;
            com.tencent.luggage.wxa.uj.r rVar = com.tencent.luggage.wxa.uj.r.f142553a;
            String appId = this.f122410c.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
            return cVar.a(vVar, apiName, z16, list, rVar.a(appId));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f122414c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f122415d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f122416e;

        public g(v vVar, String str, boolean z16) {
            this.f122414c = vVar;
            this.f122415d = str;
            this.f122416e = z16;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.ap.b call(com.tencent.luggage.wxa.ap.b bVar) {
            c cVar = c.this;
            v vVar = this.f122414c;
            com.tencent.luggage.wxa.uj.r rVar = com.tencent.luggage.wxa.uj.r.f142553a;
            String appId = vVar.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
            com.tencent.luggage.wxa.uj.q a16 = rVar.a(appId);
            String apiName = this.f122415d;
            Intrinsics.checkNotNullExpressionValue(apiName, "apiName");
            return cVar.a(bVar, vVar, a16, apiName, this.f122416e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public static final h f122417b = new h();

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.ap.b call(com.tencent.luggage.wxa.ap.b bVar) {
            List list;
            com.tencent.luggage.wxa.uj.l lVar = com.tencent.luggage.wxa.uj.l.f142509a;
            if (bVar != null) {
                list = (List) bVar.b();
            } else {
                list = null;
            }
            lVar.a(list);
            return bVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122418b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f122419c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.i f122420d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v f122421a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(v vVar) {
                super(1);
                this.f122421a = vVar;
            }

            public final void a(boolean z16) {
                String appId = this.f122421a.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
                new com.tencent.luggage.wxa.be.g(appId, z16).a();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        public i(v vVar, c cVar, com.tencent.luggage.wxa.ml.i iVar) {
            this.f122418b = vVar;
            this.f122419c = cVar;
            this.f122420d = iVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o.a call(com.tencent.luggage.wxa.ap.b bVar) {
            com.tencent.luggage.wxa.ce.a a16 = a.C6105a.a(this.f122418b);
            c cVar = this.f122419c;
            v vVar = this.f122418b;
            com.tencent.luggage.wxa.ml.i iVar = this.f122420d;
            com.tencent.luggage.wxa.uj.r rVar = com.tencent.luggage.wxa.uj.r.f142553a;
            String appId = vVar.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
            return cVar.a(bVar, vVar, iVar, a16, rVar.a(appId), new a(this.f122418b));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f122422a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122423b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f122424c;

        public j(v vVar, int i3, c cVar) {
            this.f122422a = vVar;
            this.f122423b = i3;
            this.f122424c = cVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(o.a aVar) {
            com.tencent.luggage.wxa.uj.r rVar = com.tencent.luggage.wxa.uj.r.f142553a;
            String appId = this.f122422a.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
            com.tencent.luggage.wxa.uj.q a16 = rVar.a(appId);
            if (a16 != null) {
                a16.m();
            }
            String appId2 = this.f122422a.getAppId();
            if (appId2 != null) {
                rVar.e(appId2);
            }
            w.d("MicroMsg.JsApiGetPhoneNumberNew", "callResult: " + aVar.f144873b + TokenParser.SP + aVar.f144872a);
            this.f122422a.a(this.f122423b, this.f122424c.makeReturnJson(aVar.f144873b, aVar.f144872a));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f122425a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122426b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f122427c;

        public k(v vVar, int i3, c cVar) {
            this.f122425a = vVar;
            this.f122426b = i3;
            this.f122427c = cVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            com.tencent.luggage.wxa.uj.r rVar = com.tencent.luggage.wxa.uj.r.f142553a;
            String appId = this.f122425a.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
            com.tencent.luggage.wxa.uj.q a16 = rVar.a(appId);
            if (a16 != null) {
                a16.m();
            }
            String appId2 = this.f122425a.getAppId();
            if (appId2 != null) {
                rVar.e(appId2);
            }
            if (obj instanceof String) {
                w.b("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:" + obj);
                v vVar = this.f122425a;
                if (vVar != null) {
                    vVar.a(this.f122426b, this.f122427c.makeReturnJson("fail:" + obj));
                    return;
                }
                return;
            }
            if (obj instanceof Exception) {
                w.b("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail:{" + obj + ".message}");
                v vVar2 = this.f122425a;
                if (vVar2 != null) {
                    vVar2.a(this.f122426b, this.f122427c.makeReturnJson("fail:{" + obj + ".message}"));
                    return;
                }
                return;
            }
            w.b("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
            v vVar3 = this.f122425a;
            if (vVar3 != null) {
                vVar3.a(this.f122426b, this.f122427c.makeReturnJson("fail"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f122428a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.i f122429b;

        public l(v vVar, com.tencent.luggage.wxa.ml.i iVar) {
            this.f122428a = vVar;
            this.f122429b = iVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            com.tencent.luggage.wxa.ml.r dialogContainer;
            v vVar = this.f122428a;
            if (vVar != null && (dialogContainer = vVar.getDialogContainer()) != null) {
                dialogContainer.b(this.f122429b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122430a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122431b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f122432c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f122433d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122434e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function4 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122435a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.xo.b bVar) {
                super(4);
                this.f122435a = bVar;
            }

            public final void a(boolean z16, String errMsg, List list, b bVar) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                boolean z17 = false;
                if (!z16) {
                    com.tencent.luggage.wxa.xo.b bVar2 = this.f122435a;
                    if (errMsg.length() == 0) {
                        z17 = true;
                    }
                    if (z17) {
                        errMsg = "network request fail";
                    }
                    bVar2.a(errMsg);
                    return;
                }
                this.f122435a.a(com.tencent.luggage.wxa.ap.j.a(com.tencent.luggage.wxa.uj.l.f142509a.a(list, null), bVar));
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                a(((Boolean) obj).booleanValue(), (String) obj2, (List) obj3, (b) obj4);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(com.tencent.luggage.wxa.uj.q qVar, v vVar, String str, boolean z16, com.tencent.luggage.wxa.xo.b bVar) {
            super(1);
            this.f122430a = qVar;
            this.f122431b = vVar;
            this.f122432c = str;
            this.f122433d = z16;
            this.f122434e = bVar;
        }

        public final void a(int i3) {
            if (i3 == -1) {
                com.tencent.luggage.wxa.uj.q qVar = this.f122430a;
                if (qVar != null) {
                    qVar.b(1L);
                }
                com.tencent.luggage.wxa.uj.q qVar2 = this.f122430a;
                if (qVar2 != null) {
                    Long valueOf = Long.valueOf(qVar2.i());
                    Intrinsics.checkNotNull(valueOf);
                    qVar2.k(valueOf.longValue() + 1);
                }
                String appId = this.f122431b.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
                new com.tencent.luggage.wxa.uj.d(appId, this.f122432c, this.f122433d).a(new a(this.f122434e));
                return;
            }
            w.b("MicroMsg.JsApiGetPhoneNumberNew", "bind wechat phone number fail");
            com.tencent.luggage.wxa.uj.q qVar3 = this.f122430a;
            if (qVar3 != null) {
                qVar3.b(0L);
            }
            this.f122434e.a("user cancel");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class n extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122436a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122437b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f122438c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f122439d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(com.tencent.luggage.wxa.uj.q qVar, com.tencent.luggage.wxa.ce.a aVar, v vVar, b bVar) {
            super(0);
            this.f122436a = qVar;
            this.f122437b = aVar;
            this.f122438c = vVar;
            this.f122439d = bVar;
        }

        public final void a() {
            String str;
            com.tencent.luggage.wxa.hn.i a16;
            com.tencent.luggage.wxa.uj.q qVar = this.f122436a;
            if (qVar != null) {
                Long valueOf = Long.valueOf(qVar.d());
                Intrinsics.checkNotNull(valueOf);
                qVar.f(valueOf.longValue() + 1);
            }
            com.tencent.luggage.wxa.ce.a aVar = this.f122437b;
            v vVar = this.f122438c;
            b bVar = this.f122439d;
            if (bVar != null && (a16 = bVar.a()) != null) {
                str = a16.f127823e;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            aVar.a(vVar, str, (d0) this.f122438c.b(d0.class)).b(this.f122438c);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class o extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122440a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122441b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(com.tencent.luggage.wxa.uj.q qVar, com.tencent.luggage.wxa.xo.b bVar) {
            super(0);
            this.f122440a = qVar;
            this.f122441b = bVar;
        }

        public final void a() {
            com.tencent.luggage.wxa.uj.q qVar = this.f122440a;
            if (qVar != null) {
                Long valueOf = Long.valueOf(qVar.c());
                Intrinsics.checkNotNull(valueOf);
                qVar.e(valueOf.longValue() + 1);
            }
            this.f122441b.a("user deny");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class p extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122442a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122443b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(com.tencent.luggage.wxa.uj.q qVar, com.tencent.luggage.wxa.xo.b bVar) {
            super(0);
            this.f122442a = qVar;
            this.f122443b = bVar;
        }

        public final void a() {
            com.tencent.luggage.wxa.uj.q qVar = this.f122442a;
            if (qVar != null) {
                Long valueOf = Long.valueOf(qVar.a());
                Intrinsics.checkNotNull(valueOf);
                qVar.c(valueOf.longValue() + 1);
            }
            this.f122443b.a("user cancel");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class q extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f122444a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Function1 function1) {
            super(1);
            this.f122444a = function1;
        }

        public final void a(boolean z16) {
            this.f122444a.invoke(Boolean.valueOf(z16));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class r extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122445a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122446b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122447c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122448a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f122449b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.be.c$r$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class RunnableC6048a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122450a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ v f122451b;

                public RunnableC6048a(com.tencent.luggage.wxa.ce.a aVar, v vVar) {
                    this.f122450a = aVar;
                    this.f122451b = vVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.ce.a aVar = this.f122450a;
                    List a16 = com.tencent.luggage.wxa.uj.l.f142509a.a();
                    Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> }");
                    aVar.a((ArrayList) a16);
                    String appId = this.f122451b.getAppId();
                    if (appId != null) {
                        com.tencent.luggage.wxa.uj.r.f142553a.c(appId);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.ce.a aVar, v vVar) {
                super(2);
                this.f122448a = aVar;
                this.f122449b = vVar;
            }

            public final void a(Integer num, Intent intent) {
                com.tencent.luggage.wxa.tk.l.a(new RunnableC6048a(this.f122448a, this.f122449b));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Integer) obj, (Intent) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(com.tencent.luggage.wxa.uj.q qVar, v vVar, com.tencent.luggage.wxa.ce.a aVar) {
            super(0);
            this.f122445a = qVar;
            this.f122446b = vVar;
            this.f122447c = aVar;
        }

        public final void a() {
            com.tencent.luggage.wxa.uj.q qVar = this.f122445a;
            if (qVar != null) {
                Long valueOf = Long.valueOf(qVar.f());
                Intrinsics.checkNotNull(valueOf);
                qVar.h(valueOf.longValue() + 1);
            }
            String appId = this.f122446b.getAppId();
            if (appId != null) {
                com.tencent.luggage.wxa.uj.r.f142553a.d(appId);
            }
            Context context = this.f122446b.getContext();
            if (context != null) {
                v vVar = this.f122446b;
                com.tencent.luggage.wxa.ce.a aVar = this.f122447c;
                String appId2 = vVar.getAppId();
                if (appId2 != null) {
                    Intrinsics.checkNotNullExpressionValue(appId2, "appId");
                    com.tencent.luggage.wxa.uj.n.f142511a.b().a(context, appId2, new a(aVar, vVar));
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class s extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122452a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122453b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122454c;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function2 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122455a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f122456b;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.be.c$s$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class RunnableC6049a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122457a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ v f122458b;

                public RunnableC6049a(com.tencent.luggage.wxa.ce.a aVar, v vVar) {
                    this.f122457a = aVar;
                    this.f122458b = vVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.ce.a aVar = this.f122457a;
                    List a16 = com.tencent.luggage.wxa.uj.l.f142509a.a();
                    Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> }");
                    aVar.a((ArrayList) a16);
                    com.tencent.luggage.wxa.uj.r rVar = com.tencent.luggage.wxa.uj.r.f142553a;
                    String appId = this.f122458b.getAppId();
                    Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
                    rVar.c(appId);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(com.tencent.luggage.wxa.ce.a aVar, v vVar) {
                super(2);
                this.f122455a = aVar;
                this.f122456b = vVar;
            }

            public final void a(Integer num, Intent intent) {
                com.tencent.luggage.wxa.tk.l.a(new RunnableC6049a(this.f122455a, this.f122456b));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((Integer) obj, (Intent) obj2);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(com.tencent.luggage.wxa.uj.q qVar, v vVar, com.tencent.luggage.wxa.ce.a aVar) {
            super(0);
            this.f122452a = qVar;
            this.f122453b = vVar;
            this.f122454c = aVar;
        }

        public final void a() {
            com.tencent.luggage.wxa.uj.q qVar = this.f122452a;
            if (qVar != null) {
                Long valueOf = Long.valueOf(qVar.e());
                Intrinsics.checkNotNull(valueOf);
                qVar.g(valueOf.longValue() + 1);
            }
            String appId = this.f122453b.getAppId();
            if (appId != null) {
                com.tencent.luggage.wxa.uj.r.f142553a.d(appId);
            }
            Context context = this.f122453b.getContext();
            if (context != null) {
                v vVar = this.f122453b;
                com.tencent.luggage.wxa.ce.a aVar = this.f122454c;
                String appId2 = vVar.getAppId();
                if (appId2 != null) {
                    Intrinsics.checkNotNullExpressionValue(appId2, "appId");
                    com.tencent.luggage.wxa.uj.i b16 = com.tencent.luggage.wxa.uj.n.f142511a.b();
                    String B0 = vVar.B0();
                    if (B0 == null) {
                        B0 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(B0, "env.urlWithQuery ?: \"\"");
                    }
                    b16.a(context, appId2, B0, new a(aVar, vVar));
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class t extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122459a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ce.a f122460b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f122461c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f122462d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122463e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements i.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.uj.k f122464a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.uj.q f122465b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ v f122466c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122467d;

            public a(com.tencent.luggage.wxa.uj.k kVar, com.tencent.luggage.wxa.uj.q qVar, v vVar, com.tencent.luggage.wxa.xo.b bVar) {
                this.f122464a = kVar;
                this.f122465b = qVar;
                this.f122466c = vVar;
                this.f122467d = bVar;
            }

            @Override // com.tencent.luggage.wxa.uj.i.a
            public void a(boolean z16, Map result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (z16) {
                    if (this.f122464a.j()) {
                        com.tencent.luggage.wxa.uj.q qVar = this.f122465b;
                        if (qVar != null) {
                            Long valueOf = Long.valueOf(qVar.g());
                            Intrinsics.checkNotNull(valueOf);
                            qVar.i(valueOf.longValue() + 1);
                        }
                    } else {
                        com.tencent.luggage.wxa.uj.q qVar2 = this.f122465b;
                        if (qVar2 != null) {
                            Long valueOf2 = Long.valueOf(qVar2.h());
                            Intrinsics.checkNotNull(valueOf2);
                            qVar2.j(valueOf2.longValue() + 1);
                        }
                    }
                    com.tencent.luggage.wxa.uj.q qVar3 = this.f122465b;
                    String appId = this.f122466c.getAppId();
                    Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
                    qVar3.a(appId);
                    com.tencent.luggage.wxa.uj.q qVar4 = this.f122465b;
                    String a16 = y.a(y.a(this.f122464a.f()));
                    Intrinsics.checkNotNullExpressionValue(a16, "getMD5String(MD5Util.get\u2026String(phoneItem.mobile))");
                    qVar4.b(a16);
                    com.tencent.luggage.wxa.xo.b bVar = this.f122467d;
                    Object[] objArr = new Object[1];
                    o.a aVar = new o.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
                    HashMap hashMap = new HashMap();
                    String str = (String) result.get(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA);
                    String str2 = "";
                    if (str == null) {
                        str = "";
                    }
                    hashMap.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, str);
                    String str3 = (String) result.get("iv");
                    if (str3 == null) {
                        str3 = "";
                    }
                    hashMap.put("iv", str3);
                    String str4 = (String) result.get("cloud_id");
                    if (str4 != null) {
                        str2 = str4;
                    }
                    hashMap.put("cloud_id", str2);
                    aVar.a("data", result.get("data"));
                    aVar.a(hashMap);
                    Unit unit = Unit.INSTANCE;
                    objArr[0] = aVar;
                    bVar.a(objArr);
                    com.tencent.luggage.wxa.uj.l.f142509a.a(this.f122464a);
                    return;
                }
                this.f122467d.a(result.get("errMsg"));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(com.tencent.luggage.wxa.uj.q qVar, com.tencent.luggage.wxa.ce.a aVar, v vVar, b bVar, com.tencent.luggage.wxa.xo.b bVar2) {
            super(1);
            this.f122459a = qVar;
            this.f122460b = aVar;
            this.f122461c = vVar;
            this.f122462d = bVar;
            this.f122463e = bVar2;
        }

        public final void a(com.tencent.luggage.wxa.uj.k phoneItem) {
            String str;
            m9 d16;
            Intrinsics.checkNotNullParameter(phoneItem, "phoneItem");
            w.a("MicroMsg.JsApiGetPhoneNumberNew", "select phoneItem " + phoneItem);
            com.tencent.luggage.wxa.uj.q qVar = this.f122459a;
            com.tencent.luggage.wxa.ce.a aVar = this.f122460b;
            v vVar = this.f122461c;
            b bVar = this.f122462d;
            com.tencent.luggage.wxa.xo.b bVar2 = this.f122463e;
            if (qVar != null) {
                qVar.d(qVar.b() + 1);
            }
            if (phoneItem.g()) {
                a aVar2 = new a(phoneItem, qVar, vVar, bVar2);
                String appId = vVar.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
                com.tencent.luggage.wxa.rj.e a16 = aVar.a(vVar, appId, qVar, phoneItem, aVar2);
                if (a16 != null) {
                    a16.b(vVar);
                    return;
                }
                com.tencent.luggage.wxa.uj.i b16 = com.tencent.luggage.wxa.uj.n.f142511a.b();
                Context context = vVar.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "env.context");
                String appId2 = vVar.getAppId();
                Intrinsics.checkNotNullExpressionValue(appId2, "env.appId");
                if (bVar != null && (d16 = bVar.d()) != null) {
                    str = d16.f128171g;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "info?.scopeInfo?.ext_desc ?: \"\"");
                }
                b16.a(context, appId2, str, qVar, phoneItem, aVar2);
                return;
            }
            if (phoneItem.j()) {
                if (qVar != null) {
                    qVar.i(qVar.g() + 1);
                }
            } else if (qVar != null) {
                qVar.j(qVar.h() + 1);
            }
            String appId3 = vVar.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId3, "env.appId");
            qVar.a(appId3);
            String a17 = y.a(y.a(phoneItem.f()));
            Intrinsics.checkNotNullExpressionValue(a17, "getMD5String(MD5Util.get\u2026String(phoneItem.mobile))");
            qVar.b(a17);
            o.a aVar3 = new o.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
            HashMap hashMap = new HashMap();
            hashMap.put(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, phoneItem.d());
            hashMap.put("iv", phoneItem.e());
            hashMap.put("cloud_id", phoneItem.b());
            hashMap.put("data", phoneItem.c());
            aVar3.a(hashMap);
            Unit unit = Unit.INSTANCE;
            bVar2.a(aVar3);
            com.tencent.luggage.wxa.uj.l.f142509a.a(phoneItem);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.uj.k) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class u implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f122468a;

        public u(com.tencent.luggage.wxa.xo.b bVar) {
            this.f122468a = bVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f122468a.a("user cancel");
        }
    }

    public final List e() {
        return com.tencent.luggage.wxa.uj.l.f142509a.a();
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v env, JSONObject data, int i3) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(data, "data");
        if (env.getContext() != null && (env.getContext() instanceof Activity)) {
            w.d("MicroMsg.JsApiGetPhoneNumberNew", "getPhoneNumber data:%s", data.toString());
            env.getContext();
            com.tencent.luggage.wxa.uj.r rVar = com.tencent.luggage.wxa.uj.r.f142553a;
            String appId = env.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
            rVar.b(appId);
            String optString = data.optString("api_name", "webapi_getuserwxphone");
            boolean optBoolean = data.optBoolean("with_credentials", true);
            com.tencent.luggage.wxa.ml.i iVar = new com.tencent.luggage.wxa.ml.i(env.getContext());
            com.tencent.luggage.wxa.xo.h.c().b(new d(iVar, env)).c(new e()).c(new f(env, optString, optBoolean)).c(new g(env, optString, optBoolean)).c(h.f122417b).a(new i(env, this, iVar)).a(com.tencent.luggage.wxa.yo.d.f146045b, new j(env, i3, this)).a(new k(env, i3, this)).a(com.tencent.luggage.wxa.yo.d.f146044a, new l(env, iVar));
            return;
        }
        w.b("MicroMsg.JsApiGetPhoneNumberNew", "env is null, return");
        env.a(i3, makeReturnJson("fail"));
    }

    public final o.a a(com.tencent.luggage.wxa.ap.b bVar, v vVar, com.tencent.luggage.wxa.ml.i iVar, com.tencent.luggage.wxa.ce.a aVar, com.tencent.luggage.wxa.uj.q qVar, Function1 function1) {
        pb c16;
        boolean isBlank;
        String b16;
        m9 d16;
        String str;
        m9 d17;
        String str2;
        Collection collection = bVar != null ? (List) bVar.b() : null;
        b bVar2 = bVar != null ? (b) bVar.c() : null;
        com.tencent.luggage.wxa.xo.b b17 = com.tencent.luggage.wxa.xo.h.b();
        com.tencent.luggage.wxa.ml.r dialogContainer = vVar.getDialogContainer();
        if (dialogContainer != null) {
            dialogContainer.b(iVar);
        }
        String str3 = ((com.tencent.luggage.wxa.fd.q) vVar.a(com.tencent.luggage.wxa.fd.q.class)).f125955a;
        if (str3 == null) {
            str3 = "";
        }
        aVar.b(str3);
        String str4 = ((com.tencent.luggage.wxa.fd.q) vVar.a(com.tencent.luggage.wxa.fd.q.class)).f125957c;
        aVar.a(str4 != null ? str4 : "");
        if (bVar2 != null && (d17 = bVar2.d()) != null && (str2 = d17.f128173i) != null) {
            aVar.f(str2);
        }
        if (bVar2 != null && (d16 = bVar2.d()) != null && (str = d16.f128169e) != null) {
            aVar.e(str);
        }
        if (bVar2 != null && (b16 = bVar2.b()) != null) {
            aVar.d(b16);
        }
        aVar.c(new o(qVar, b17));
        aVar.e(new p(qVar, b17));
        aVar.a(new q(function1));
        aVar.d(new r(qVar, vVar, aVar));
        aVar.b(new s(qVar, vVar, aVar));
        aVar.b(new t(qVar, aVar, vVar, bVar2, b17));
        if (a(vVar, bVar2)) {
            aVar.b(true);
            aVar.a(new n(qVar, aVar, vVar, bVar2));
        } else {
            aVar.b(false);
        }
        ArrayList arrayList = collection instanceof ArrayList ? (ArrayList) collection : null;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        aVar.a(arrayList);
        if (bVar2 != null && (c16 = bVar2.c()) != null && c16.f128430d) {
            String str5 = c16.f128431e;
            Intrinsics.checkNotNullExpressionValue(str5, "privacyProtectInfo.wording");
            isBlank = StringsKt__StringsJVMKt.isBlank(str5);
            if (!isBlank) {
                String str6 = c16.f128431e;
                Intrinsics.checkNotNullExpressionValue(str6, "privacyProtectInfo.wording");
                aVar.c(str6);
                aVar.a((d0) vVar.b(d0.class));
            }
        }
        aVar.b(vVar);
        return new o.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new Object[0]);
    }

    public final com.tencent.luggage.wxa.ap.b a(com.tencent.luggage.wxa.ap.b bVar, v vVar, com.tencent.luggage.wxa.uj.q qVar, String str, boolean z16) {
        List list = bVar != null ? (List) bVar.b() : null;
        if (list == null || list.isEmpty() || a(list)) {
            w.b("MicroMsg.JsApiGetPhoneNumberNew", "phoneItems is null, tryToBindWechatPhoneNumber");
            if (qVar != null) {
                qVar.a(1L);
            }
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            Context context = vVar.getContext();
            if (context != null) {
                com.tencent.luggage.wxa.uj.n.f142511a.b().a(context, new m(qVar, vVar, str, z16, b16));
            }
        }
        return bVar;
    }

    public final boolean a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((com.tencent.luggage.wxa.uj.k) it.next()).j()) {
                return false;
            }
        }
        return true;
    }

    public final com.tencent.luggage.wxa.ap.b a(v vVar, String str, boolean z16, List list, com.tencent.luggage.wxa.uj.q qVar) {
        com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
        if (qVar != null) {
            qVar.k(qVar.i() + 1);
        }
        String appId = vVar.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "env.appId");
        new com.tencent.luggage.wxa.uj.d(appId, str, z16).a(new C6047c(b16, list));
        return null;
    }

    public final Object a(com.tencent.luggage.wxa.ml.i iVar, v vVar) {
        com.tencent.luggage.wxa.xo.b a16 = com.tencent.luggage.wxa.xo.h.a();
        iVar.setMessage(vVar.getContext().getString(R.string.z4a));
        iVar.setOnCancelListener(new u(a16));
        com.tencent.luggage.wxa.ml.r dialogContainer = vVar.getDialogContainer();
        if (dialogContainer != null) {
            dialogContainer.a(iVar);
        }
        return new Object();
    }

    public boolean a(v env, b bVar) {
        com.tencent.luggage.wxa.hn.i a16;
        Intrinsics.checkNotNullParameter(env, "env");
        return (bVar == null || (a16 = bVar.a()) == null || !a16.f127822d) ? false : true;
    }
}
