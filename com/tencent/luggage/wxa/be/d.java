package com.tencent.luggage.wxa.be;

import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.m3;
import com.tencent.luggage.wxa.hn.n3;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.xweb.internal.ConstValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 204;
    public static final String NAME = "getUserAutoFillData";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f122469b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f122470c;

        public a(v vVar, int i3) {
            this.f122469b = vVar;
            this.f122470c = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object call(n3 n3Var) {
            String str;
            HashMap hashMap = new HashMap();
            if (n3Var == null) {
                w.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, null response");
                hashMap.put("ret", -99);
                this.f122469b.a(this.f122470c, d.this.makeReturnJson("fail: ErrMsg: cgi fail", hashMap));
                return null;
            }
            int i3 = n3Var.f128743d.f127731d;
            if (i3 != 0) {
                w.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(i3), n3Var.f128743d.f127732e);
                hashMap.put("ret", Integer.valueOf(n3Var.f128743d.f127731d));
                this.f122469b.a(this.f122470c, d.this.makeReturnJson("fail: ErrMsg:" + n3Var.f128743d.f127732e, hashMap));
                return null;
            }
            w.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData success");
            String str2 = "";
            if (TextUtils.isEmpty(n3Var.f128253e)) {
                str = "";
            } else {
                str = n3Var.f128253e;
            }
            if (!TextUtils.isEmpty(n3Var.f128255g)) {
                str2 = n3Var.f128255g;
            }
            int i16 = n3Var.f128254f;
            LinkedList linkedList = n3Var.f128256h;
            w.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData auth_info:%s, auth_status:%d", str2, Integer.valueOf(i16));
            w.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData user_info_json:%s", str);
            hashMap.put("userData", str);
            hashMap.put("authStatus", Integer.valueOf(i16));
            hashMap.put("authInfo", str2);
            if (linkedList != null && linkedList.size() > 0) {
                hashMap.put("authGroupList", new JSONArray((Collection) linkedList));
                w.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData authGroupList:%s", new JSONArray((Collection) linkedList).toString());
            }
            this.f122469b.a(this.f122470c, d.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData data is invalid");
            vVar.a(i3, makeReturnJson("fail:data is invalid"));
            return;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                linkedList.add(optJSONArray.optString(i16));
            }
        }
        if (linkedList.size() == 0) {
            w.b("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData fields is empty");
            vVar.a(i3, makeReturnJson("fail:fields is empty"));
            return;
        }
        String appId = vVar.getAppId();
        int optInt = jSONObject.optInt(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, 0);
        w.d("MicroMsg.JsApiGetUserAutoFillData", "getUserAutoFillData appId:%s, clientVersion:%s data:%s", appId, Integer.valueOf(optInt), jSONObject.toString());
        m3 m3Var = new m3();
        m3Var.f128137g = linkedList;
        m3Var.f128135e = appId;
        m3Var.f128136f = jSONObject.optBoolean("getAllInfo", false);
        m3Var.f128138h = 1;
        m3Var.f128139i = optInt;
        ((com.tencent.luggage.wxa.bj.c) vVar.b(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo", appId, m3Var, n3.class).b(new a(vVar, i3));
    }
}
