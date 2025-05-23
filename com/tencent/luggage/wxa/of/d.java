package com.tencent.luggage.wxa.of;

import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.of.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 270;
    public static final String NAME = "operateDownloadTask";

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
        w.a("MicroMsg.JsApiOperateDownloadTask", "JsApiOperateDownloadTask");
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            w.b("MicroMsg.JsApiOperateDownloadTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("downloadTaskId");
        if (w0.c(optString)) {
            w.b("MicroMsg.JsApiOperateDownloadTask", "downloadTaskId is null");
            dVar.a(i3, makeReturnJson("fail:downloadTaskId is null or nil"));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (w0.c(optString2)) {
            w.b("MicroMsg.JsApiOperateDownloadTask", "operationType is null");
            dVar.a(i3, makeReturnJson("fail:operationType is null or nil"));
            return;
        }
        if (optString2.equals("abort")) {
            com.tencent.luggage.wxa.yi.b a16 = com.tencent.luggage.wxa.yi.c.b().a(dVar.getAppId());
            if (a16 == null) {
                dVar.a(i3, makeReturnJson("fail:no task"));
                w.f("MicroMsg.JsApiOperateDownloadTask", "download is null");
                return;
            }
            com.tencent.luggage.wxa.zi.b b16 = a16.b(optString);
            if (b16 == null) {
                dVar.a(i3, makeReturnJson("fail:no task"));
                w.h("MicroMsg.JsApiOperateDownloadTask", "downloadWorker is null %s", optString);
                return;
            }
            a16.a(b16);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            HashMap hashMap = new HashMap();
            hashMap.put("downloadTaskId", optString + "");
            hashMap.put("state", "fail");
            hashMap.put("errMsg", "abort");
            new a.b().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch(pVar);
            w.a("MicroMsg.JsApiOperateDownloadTask", "abortTask finish %s", optString);
            return;
        }
        dVar.a(i3, makeReturnJson("fail:unknown operationType"));
    }
}
