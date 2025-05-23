package com.tencent.luggage.wxa.ae;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.ae.h;
import com.tencent.luggage.wxa.hn.c5;
import com.tencent.luggage.wxa.hn.gf;
import com.tencent.luggage.wxa.hn.s5;
import com.tencent.luggage.wxa.hn.t5;
import com.tencent.luggage.wxa.hn.u5;
import com.tencent.luggage.wxa.hn.v5;
import com.tencent.luggage.wxa.ml.c;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f1;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n extends k implements h {

    @Deprecated
    public static final int CTRL_INDEX = 52;

    @Deprecated
    @NotNull
    public static final String NAME = "login";

    /* renamed from: a, reason: collision with root package name */
    public static final e f121156a = new e(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121170b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121171c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n f121172d;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3, n nVar) {
            this.f121170b = dVar;
            this.f121171c = i3;
            this.f121172d = nVar;
        }

        public final void a(Triple triple) {
            Integer num;
            c5 c5Var = (c5) triple.component1();
            String str = (String) triple.component2();
            String str2 = (String) triple.component3();
            if (c5Var != null) {
                num = Integer.valueOf(c5Var.f127384d);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                com.tencent.luggage.wxa.ic.d dVar = this.f121170b;
                int i3 = this.f121171c;
                n nVar = this.f121172d;
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                Unit unit = Unit.INSTANCE;
                dVar.a(i3, nVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                return;
            }
            if (num == null) {
                this.f121170b.a(this.f121171c, this.f121172d.makeReturnJson("fail invalid " + this.f121172d.b(str2) + " response"));
                return;
            }
            this.f121170b.a(this.f121171c, this.f121172d.makeReturnJson("fail " + this.f121172d.b(str2) + " response errcode=" + num + " errmsg=" + c5Var.f127385e));
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((Triple) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f121173a;

        public c(g gVar) {
            this.f121173a = gVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(Object obj) {
            g gVar = this.f121173a;
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f121174a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121175b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121176c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n f121177d;

        public d(g gVar, com.tencent.luggage.wxa.ic.d dVar, int i3, n nVar) {
            this.f121174a = gVar;
            this.f121175b = dVar;
            this.f121176c = i3;
            this.f121177d = nVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            g gVar = this.f121174a;
            if (gVar != null) {
                gVar.b();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onInterrupt, appId[");
            sb5.append(this.f121175b.getAppId());
            sb5.append("], callbackId[");
            sb5.append(this.f121176c);
            sb5.append("], e[");
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(']');
            w.d("Luggage.WXA.JsApiLoginLU", sb5.toString());
            if (obj instanceof h.c) {
                return;
            }
            if (obj instanceof h.a) {
                this.f121175b.a(this.f121176c, this.f121177d.makeReturnJson("fail " + ((h.a) obj).getMessage()));
                return;
            }
            if (obj instanceof Throwable) {
                this.f121175b.a(this.f121176c, this.f121177d.makeReturnJson("fail " + ((Throwable) obj).getMessage()));
                return;
            }
            if (obj == null) {
                this.f121175b.a(this.f121176c, this.f121177d.makeReturnJson("fail:internal error"));
                return;
            }
            this.f121175b.a(this.f121176c, this.f121177d.makeReturnJson("fail " + obj));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {
        public e() {
        }

        public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ Context a(com.tencent.luggage.wxa.xd.d dVar) {
        return h.CC.a(this, dVar);
    }

    public final String b(String str) {
        if (Intrinsics.areEqual(str, "/cgi-bin/mmbiz-bin/js-login")) {
            return "js-login";
        }
        if (Intrinsics.areEqual(str, "/cgi-bin/mmbiz-bin/js-login-confirm")) {
            return "js-login-confirm";
        }
        return str;
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ com.tencent.luggage.wxa.fn.c a(String str) {
        return h.CC.b(this, str);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ gf a(gf gfVar, com.tencent.luggage.wxa.xd.d dVar) {
        return h.CC.c(this, gfVar, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(Context context, Bitmap bitmap, String str, String str2, com.tencent.luggage.wxa.tj.d dVar) {
        h.CC.d(this, context, bitmap, str, str2, dVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121157b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121158c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n f121159d;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3, n nVar) {
            this.f121157b = dVar;
            this.f121158c = i3;
            this.f121159d = nVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Triple call(v5 v5Var) {
            Integer num;
            c5 c5Var;
            boolean z16;
            c5 c5Var2;
            String str = null;
            if (v5Var != null && (c5Var2 = v5Var.f128882e) != null) {
                num = Integer.valueOf(c5Var2.f127384d);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == -12000) {
                com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
                LinkedList linkedList = v5Var.f128884g;
                if (linkedList != null && !linkedList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    this.f121157b.a(this.f121158c, this.f121159d.makeReturnJson("fail:internal error scope empty"));
                } else {
                    com.tencent.luggage.wxa.zp.h.f146825d.a(new RunnableC5999a(this.f121157b, b16, this.f121159d, v5Var, this.f121158c));
                }
                return null;
            }
            if (v5Var != null) {
                c5Var = v5Var.f128882e;
            } else {
                c5Var = null;
            }
            if (v5Var != null) {
                str = v5Var.f128883f;
            }
            return new Triple(c5Var, str, "/cgi-bin/mmbiz-bin/js-login");
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ae.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC5999a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121160a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121161b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ n f121162c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ v5 f121163d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f121164e;

            public RunnableC5999a(com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.xo.b bVar, n nVar, v5 v5Var, int i3) {
                this.f121160a = dVar;
                this.f121161b = bVar;
                this.f121162c = nVar;
                this.f121163d = v5Var;
                this.f121164e = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!this.f121160a.isRunning()) {
                    this.f121161b.a(h.c.f121076a);
                    return;
                }
                C6000a c6000a = new C6000a(this.f121164e, this.f121162c, this.f121161b, this.f121160a);
                r dialogContainer = this.f121160a.getDialogContainer();
                Intrinsics.checkNotNull(dialogContainer);
                Context a16 = this.f121162c.a(this.f121160a);
                LinkedList a17 = k.a(this.f121163d.f128884g);
                v5 v5Var = this.f121163d;
                dialogContainer.a(new com.tencent.luggage.wxa.ml.c(a16, a17, v5Var.f128885h, v5Var.f128886i, c6000a));
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ae.n$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6000a implements c.d {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f121165a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ n f121166b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121167c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121168d;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.ae.n$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6001a implements com.tencent.luggage.wxa.uo.b {

                    /* renamed from: b, reason: collision with root package name */
                    public static final C6001a f121169b = new C6001a();

                    @Override // com.tencent.luggage.wxa.uo.b
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Triple call(t5 t5Var) {
                        c5 c5Var;
                        String str = null;
                        if (t5Var != null) {
                            c5Var = t5Var.f128730e;
                        } else {
                            c5Var = null;
                        }
                        if (t5Var != null) {
                            str = t5Var.f128731f;
                        }
                        return new Triple(c5Var, str, "/cgi-bin/mmbiz-bin/js-login-confirm");
                    }
                }

                public C6000a(int i3, n nVar, com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.ic.d dVar) {
                    this.f121165a = i3;
                    this.f121166b = nVar;
                    this.f121167c = bVar;
                    this.f121168d = dVar;
                }

                @Override // com.tencent.luggage.wxa.ml.c.d
                public void a(int i3, ArrayList arrayList) {
                    w.d("Luggage.WXA.JsApiLoginLU", "dialog onRecvMsg, resultCode[" + i3 + "], callbackId[" + this.f121165a + ']');
                    if (i3 != 1) {
                        if (i3 != 2) {
                            this.f121167c.a(new h.a("fail:auth canceled"));
                            return;
                        }
                        this.f121167c.a(new h.a("fail:auth denied"));
                        h.b bVar = h.f121074n;
                        com.tencent.luggage.wxa.ic.d dVar = this.f121168d;
                        bVar.a(dVar, "/cgi-bin/mmbiz-bin/js-login-confirm", a(dVar, arrayList, i3, this.f121166b), t5.class);
                        return;
                    }
                    n nVar = this.f121166b;
                    com.tencent.luggage.wxa.xo.b m3 = this.f121167c;
                    Intrinsics.checkNotNullExpressionValue(m3, "m");
                    h.b bVar2 = h.f121074n;
                    com.tencent.luggage.wxa.ic.d dVar2 = this.f121168d;
                    com.tencent.luggage.wxa.xo.d c16 = bVar2.a(dVar2, "/cgi-bin/mmbiz-bin/js-login-confirm", a(dVar2, arrayList, i3, this.f121166b), t5.class).c(C6001a.f121169b);
                    Intrinsics.checkNotNullExpressionValue(c16, "service.runCgi(CONFIRM_U\u2026                        }");
                    nVar.a(m3, c16);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
                public static final s5 a(com.tencent.luggage.wxa.ic.d dVar, ArrayList arrayList, int i3, n nVar) {
                    ?? emptyList;
                    s5 s5Var = new s5();
                    s5Var.f128660e = dVar.getAppId();
                    LinkedList linkedList = s5Var.f128661f;
                    ArrayList arrayList2 = arrayList;
                    if (arrayList == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        arrayList2 = emptyList;
                    }
                    linkedList.addAll(arrayList2);
                    s5Var.f128664i = i3;
                    s5Var.f128665j = dVar.getRuntime().l0();
                    s5Var.f128666k = nVar.a(new gf(), dVar);
                    return s5Var;
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(com.tencent.luggage.wxa.xd.i iVar, com.tencent.luggage.wxa.ml.m mVar) {
        h.CC.e(this, iVar, mVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.xo.d dVar) {
        h.CC.f(this, bVar, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.k, com.tencent.luggage.wxa.xd.b
    public void a(f1 invokeContext) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        JSONObject e16 = invokeContext.e();
        try {
            if (!e16.has("requestInQueue")) {
                e16.put("requestInQueue", false);
            }
        } catch (JSONException e17) {
            w.b("Luggage.WXA.JsApiLoginLU", "invoke put KEY_IN_QUEUE e=" + e17.getMessage());
        }
        super.a(invokeContext);
    }

    @Override // com.tencent.luggage.wxa.ae.k
    public void a(f1 invokeContext, g gVar) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        com.tencent.luggage.wxa.ic.d dVar = (com.tencent.luggage.wxa.ic.d) invokeContext.f();
        invokeContext.e();
        int d16 = invokeContext.d();
        h.b bVar = h.f121074n;
        u5 u5Var = new u5();
        u5Var.f128816e = dVar.getAppId();
        u5Var.f128821j = dVar.getRuntime().l0();
        u5Var.f128822k = a(new gf(), dVar);
        Unit unit = Unit.INSTANCE;
        bVar.a(dVar, "/cgi-bin/mmbiz-bin/js-login", u5Var, v5.class).c(new a(dVar, d16, this)).a(new b(dVar, d16, this)).a(new c(gVar)).a(new d(gVar, dVar, d16, this));
    }
}
