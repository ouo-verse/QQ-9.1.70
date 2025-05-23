package com.tencent.luggage.wxa.h3;

import com.tencent.luggage.wxa.hn.o3;
import com.tencent.luggage.wxa.hn.p3;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.v3.h;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends h {
    private static final int CTRL_INDEX = 228;

    @NotNull
    public static final String NAME = "openWeRunSetting";

    /* renamed from: a, reason: collision with root package name */
    public static final C6253a f126848a = new C6253a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6253a {
        public C6253a() {
        }

        public /* synthetic */ C6253a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f126849b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f126850c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f126851d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f126852e;

        public b(l lVar, int i3, a aVar, JSONObject jSONObject) {
            this.f126849b = lVar;
            this.f126850c = i3;
            this.f126851d = aVar;
            this.f126852e = jSONObject;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0005, code lost:
        
            if (r4.f128397e == true) goto L7;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(p3 p3Var) {
            boolean z16;
            if (p3Var != null) {
                z16 = true;
            }
            z16 = false;
            if (!z16) {
                a.super.invoke((d) this.f126849b, this.f126852e, this.f126850c);
            } else {
                this.f126849b.a(this.f126850c, this.f126851d.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((p3) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f126853a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f126854b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f126855c;

        public c(l lVar, int i3, a aVar) {
            this.f126853a = lVar;
            this.f126854b = i3;
            this.f126855c = aVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof Throwable) {
                str = "fail " + ((Throwable) obj).getMessage();
            } else {
                w.b("Luggage.WxaStandalone.JsApiOpenWeRunSetting", "Unknown error %s", obj.getClass().getName());
                str = "fail:internal error";
            }
            this.f126853a.a(this.f126854b, this.f126855c.makeReturnJson(str));
        }
    }

    @Override // com.tencent.luggage.wxa.v3.h, com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.xo.d b16;
        com.tencent.luggage.wxa.xo.d c16;
        if (lVar == null) {
            return;
        }
        com.tencent.luggage.wxa.bj.c cVar = (com.tencent.luggage.wxa.bj.c) lVar.b(com.tencent.luggage.wxa.bj.c.class);
        if (((cVar == null || (b16 = cVar.b("/cgi-bin/mmoc-bin/hardware/getwerunuserstate", lVar.getAppId(), new o3(), p3.class)) == null || (c16 = b16.c(new b(lVar, i3, this, jSONObject))) == null) ? null : c16.a(new c(lVar, i3, this))) == null) {
            a(lVar, i3, this);
        }
    }

    public static final void a(l lVar, int i3, a aVar) {
        w.b("Luggage.WxaStandalone.JsApiOpenWeRunSetting", "null CgiService");
        lVar.a(i3, aVar.makeReturnJson("fail:internal error"));
    }
}
