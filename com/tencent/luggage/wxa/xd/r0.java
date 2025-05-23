package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.hn.ae;
import com.tencent.luggage.wxa.hn.zd;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class r0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f144879b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f144880c;

        public a(d dVar, int i3) {
            this.f144879b = dVar;
            this.f144880c = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object call(ae aeVar) {
            if (aeVar == null) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
                this.f144879b.a(this.f144880c, r0.this.makeReturnJson("fail:cgi fail"));
                return null;
            }
            int i3 = aeVar.f128743d.f127731d;
            if (i3 != 0) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(i3), aeVar.f128743d.f127732e);
                this.f144879b.a(this.f144880c, r0.this.makeReturnJson("fail:cgi fail"));
                return null;
            }
            try {
                LinkedList linkedList = aeVar.f127300f;
                JSONArray jSONArray = new JSONArray();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    com.tencent.luggage.wxa.hn.s sVar = (com.tencent.luggage.wxa.hn.s) it.next();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("scope", sVar.f128643d);
                        jSONObject.put("state", sVar.f128645f);
                        jSONObject.put("desc", sVar.f128644e);
                        jSONArray.mo162put(jSONObject);
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetSetting", "parse json failed : %s", e16.getMessage());
                    }
                }
                String jSONArray2 = jSONArray.toString();
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiGetSetting", "authInfo %s", jSONArray);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("errMsg", "getSetting:ok");
                    jSONObject2.put("authSetting", new JSONArray(com.tencent.luggage.wxa.tn.w0.d(jSONArray2)));
                    this.f144879b.a(this.f144880c, jSONObject2.toString());
                    return null;
                } catch (JSONException e17) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiGetSetting", e17, "set json error!", new Object[0]);
                    this.f144879b.a(this.f144880c, r0.this.makeReturnJson("fail:resp invalid"));
                    return null;
                }
            } catch (Exception unused) {
                this.f144879b.a(this.f144880c, r0.this.makeReturnJson("fail:resp invalid"));
                return null;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        zd zdVar = new zd();
        String appId = dVar.getAppId();
        zdVar.f129153e = appId;
        zdVar.f129154f = com.tencent.luggage.wxa.fd.b0.f125700a.a(appId);
        ((com.tencent.luggage.wxa.bj.c) dVar.b(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", zdVar.f129153e, zdVar, ae.class).b(new a(dVar, i3));
    }
}
