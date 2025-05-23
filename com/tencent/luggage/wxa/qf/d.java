package com.tencent.luggage.wxa.qf;

import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.qf.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.yi.o;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 273;
    public static final String NAME = "operateUploadTask";

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
        w.a("MicroMsg.JsApiOperateUploadTask", "JsApiOperateUploadTask");
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            w.b("MicroMsg.JsApiOperateUploadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("uploadTaskId");
        if (w0.c(optString)) {
            w.b("MicroMsg.JsApiOperateUploadTask", "uploadTaskId is null");
            dVar.a(i3, makeReturnJson("fail:uploadTaskId is null or nil"));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (w0.c(optString2)) {
            w.b("MicroMsg.JsApiOperateUploadTask", "operationType is null");
            dVar.a(i3, makeReturnJson("fail:operationType is null or nil"));
            return;
        }
        if (optString2.equals("abort")) {
            o a16 = com.tencent.luggage.wxa.yi.p.b().a(dVar.getAppId());
            if (a16 == null) {
                w.d("MicroMsg.JsApiOperateUploadTask", "upload is null");
                dVar.a(i3, makeReturnJson("fail:no task"));
                return;
            }
            com.tencent.luggage.wxa.aj.a a17 = a16.a(optString);
            if (a17 == null) {
                w.d("MicroMsg.JsApiOperateUploadTask", "uploadWorker is null %s", optString);
                dVar.a(i3, makeReturnJson("fail:no task"));
                return;
            }
            a16.a(a17);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            HashMap hashMap = new HashMap();
            hashMap.put("uploadTaskId", optString + "");
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new a.b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(pVar);
            w.a("MicroMsg.JsApiOperateUploadTask", "abortTask finish %s", optString);
            return;
        }
        dVar.a(i3, makeReturnJson("fail:unknown operationType"));
    }
}
