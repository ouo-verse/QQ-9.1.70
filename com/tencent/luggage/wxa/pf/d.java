package com.tencent.luggage.wxa.pf;

import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.pf.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.yi.e;
import com.tencent.luggage.wxa.yi.f;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 243;
    public static final String NAME = "operateRequestTask";

    @Override // com.tencent.luggage.wxa.xd.o
    public boolean canHandleVarianceExecutable() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        invoke(dVar, jSONObject, i3, dVar.getJsRuntime());
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, p pVar) {
        boolean a16;
        w.a("MicroMsg.JsApiOperateRequestTask", "JsApiOperateRequestTask");
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            w.b("MicroMsg.JsApiOperateRequestTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("requestTaskId");
        if (w0.c(optString)) {
            w.b("MicroMsg.JsApiOperateRequestTask", "requestTaskId is null");
            dVar.a(i3, makeReturnJson("fail:requestTaskId is null or nil"));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (w0.c(optString2)) {
            w.b("MicroMsg.JsApiOperateRequestTask", "operationType is null");
            dVar.a(i3, makeReturnJson("fail:operationType is null or nil"));
            return;
        }
        if (optString2.equals("abort")) {
            com.tencent.luggage.wxa.yi.d a17 = f.b().a(dVar);
            if (a17 == null) {
                dVar.a(i3, makeReturnJson("fail:no task"));
                w.f("MicroMsg.JsApiOperateRequestTask", "request is null");
                return;
            }
            e b16 = a17.b(optString);
            if (b16 != null) {
                a17.a(b16);
                a16 = true;
            } else {
                a16 = a17.a(optString);
            }
            if (!a16) {
                dVar.a(i3, makeReturnJson("fail:no task"));
                w.h("MicroMsg.JsApiOperateRequestTask", "requestInfo is null requestTaskId:%s, appId:%s", optString, dVar.getAppId());
                return;
            }
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            HashMap hashMap = new HashMap();
            hashMap.put("requestTaskId", optString);
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new a.b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(pVar);
            w.d("MicroMsg.JsApiOperateRequestTask", "abortTask finish requestId:%s, appId:%s", optString, dVar.getAppId());
            return;
        }
        dVar.a(i3, makeReturnJson("fail:unknown operationType"));
    }
}
