package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.hn.rb;
import com.tencent.luggage.wxa.hn.sb;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c1 extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 313;

    @Deprecated
    @NotNull
    public static final String NAME = "verifyPlugin";

    /* renamed from: a, reason: collision with root package name */
    public static final a f144740a = new a(null);

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f144741a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f144742b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f144743c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c1 f144744d;

        public b(String str, com.tencent.luggage.wxa.ic.l lVar, int i3, c1 c1Var) {
            this.f144741a = str;
            this.f144742b = lVar;
            this.f144743c = i3;
            this.f144744d = c1Var;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(sb sbVar) {
            if (sbVar == null) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.f144741a + " null response");
                this.f144742b.a(this.f144743c, this.f144744d.makeReturnJson("fail:internal error"));
                return;
            }
            if (sbVar.f128743d.f127731d != 0) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.f144741a + " cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(sbVar.f128743d.f127731d), sbVar.f128743d.f127732e);
                this.f144742b.a(this.f144743c, this.f144744d.makeReturnJson("fail cgi fail Ret=" + sbVar.f128743d.f127731d));
                return;
            }
            HashMap hashMap = new HashMap();
            try {
                com.tencent.luggage.wxa.tn.w.d("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.f144741a + " cgi ok, dataSize[" + sbVar.f128684e.length() + ']');
                hashMap.put("data", new JSONObject(sbVar.f128684e));
                this.f144742b.a(this.f144743c, this.f144744d.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", this.f144741a + " cgi ok but get exception[" + e16 + ']');
                this.f144742b.a(this.f144743c, this.f144744d.makeReturnJson("fail:internal error " + e16));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l service, JSONObject jSONObject, int i3) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (jSONObject != null && jSONObject.has("data")) {
            String str = "appId[" + service.getAppId() + "] callbackId[" + i3 + ']';
            rb rbVar = new rb();
            rbVar.f128613e = service.getAppId();
            rbVar.f128614f = jSONObject.optString("data");
            com.tencent.luggage.wxa.bj.c cVar = (com.tencent.luggage.wxa.bj.c) service.b(com.tencent.luggage.wxa.bj.c.class);
            if (cVar == null) {
                a(str, service, i3, this);
                return;
            } else {
                cVar.b("/cgi-bin/mmbiz-bin/wxaapp/verifyplugin", rbVar.f128613e, rbVar, sb.class).a(new b(str, service, i3, this));
                return;
            }
        }
        service.a(i3, makeReturnJson("fail:invalid data"));
    }

    public static final void a(String str, com.tencent.luggage.wxa.ic.l lVar, int i3, c1 c1Var) {
        com.tencent.luggage.wxa.tn.w.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", str + " NULL cgiService");
        lVar.a(i3, c1Var.makeReturnJson("fail:internal error"));
    }
}
