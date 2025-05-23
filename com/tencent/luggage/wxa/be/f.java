package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.hn.k9;
import com.tencent.luggage.wxa.hn.l9;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.xweb.internal.ConstValue;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122506b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122507c;

        public a(v vVar, int i3) {
            this.f122506b = vVar;
            this.f122507c = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object call(l9 l9Var) {
            if (l9Var == null) {
                w.b("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, null response");
                this.f122506b.a(this.f122507c, f.this.makeReturnJson("fail:cgi fail"));
                return null;
            }
            int i3 = l9Var.f128743d.f127731d;
            if (i3 != 0) {
                w.b("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(i3), l9Var.f128743d.f127732e);
                this.f122506b.a(this.f122507c, f.this.makeReturnJson("fail:cgi fail"));
                return null;
            }
            w.d("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
            this.f122506b.a(this.f122507c, f.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            vVar.a(i3, makeReturnJson("fail:data is invalid"));
            return;
        }
        String optString = jSONObject.optString("dataList");
        String appId = vVar.getAppId();
        int optInt = jSONObject.optInt(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, 0);
        w.d("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, clientVersion:%s, dataList:%s", appId, Integer.valueOf(optInt), optString);
        k9 k9Var = new k9();
        k9Var.f128015e = appId;
        k9Var.f128016f = optString;
        k9Var.f128017g = 1;
        k9Var.f128018h = optInt;
        ((com.tencent.luggage.wxa.bj.c) vVar.b(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", appId, k9Var, l9.class).b(new a(vVar, i3));
    }
}
