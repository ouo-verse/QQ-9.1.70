package com.tencent.luggage.wxa.be;

import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.r1;
import com.tencent.luggage.wxa.hn.s1;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.xweb.internal.ConstValue;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.be.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6046a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122394b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122395c;

        public C6046a(v vVar, int i3) {
            this.f122394b = vVar;
            this.f122395c = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object call(s1 s1Var) {
            if (s1Var == null) {
                w.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, null response");
                this.f122394b.a(this.f122395c, a.this.makeReturnJson("fail:cgi fail"));
                return null;
            }
            int i3 = s1Var.f128743d.f127731d;
            if (i3 != 0) {
                w.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(i3), s1Var.f128743d.f127732e);
                this.f122394b.a(this.f122395c, a.this.makeReturnJson("fail:cgi fail"));
                return null;
            }
            w.d("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
            this.f122394b.a(this.f122395c, a.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            vVar.a(i3, makeReturnJson("fail:data is invalid"));
            return;
        }
        String optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            w.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            vVar.a(i3, makeReturnJson("fail:groupKey is invalid"));
            return;
        }
        String appId = vVar.getAppId();
        int optInt2 = jSONObject.optInt(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, 0);
        w.d("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, clientVersion:%s, groupId:%d, groupKey:%s", appId, Integer.valueOf(optInt2), Integer.valueOf(optInt), optString);
        r1 r1Var = new r1();
        r1Var.f128552f = optString;
        r1Var.f128551e = appId;
        r1Var.f128553g = optInt;
        r1Var.f128554h = 1;
        r1Var.f128556j = optInt2;
        ((com.tencent.luggage.wxa.bj.c) vVar.b(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", appId, r1Var, s1.class).b(new C6046a(vVar, i3));
    }
}
