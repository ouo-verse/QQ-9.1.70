package com.tencent.luggage.wxa.nf;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 615;
    public static final String NAME = "checkNetworkAPIURL";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        boolean a16;
        int i16;
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data nil"));
            w.f("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
            return;
        }
        HashMap hashMap = new HashMap();
        String optString = jSONObject.optString(DTConstants.TAG.API, "");
        String optString2 = jSONObject.optString("url", "");
        if (!w0.c(optString) && !w0.c(optString2)) {
            com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
            if (optString.equalsIgnoreCase(Const.BUNDLE_KEY_REQUEST)) {
                a16 = q.a(aVar.f145801k, optString2, false);
            } else if (optString.equalsIgnoreCase("websocket")) {
                a16 = q.a(aVar.f145802l, optString2, aVar.J);
            } else if (optString.equalsIgnoreCase("downloadFile")) {
                a16 = q.a(aVar.C, optString2, false);
            } else if (optString.equalsIgnoreCase("uploadFile")) {
                a16 = q.a(aVar.f145803m, optString2, false);
            } else if (optString.equalsIgnoreCase(com.tencent.mobileqq.msf.core.quicksend.b.B)) {
                a16 = q.a(aVar.D, optString2, false);
            } else if (optString.equalsIgnoreCase(com.tencent.mobileqq.msf.core.quicksend.b.A)) {
                a16 = q.a(aVar.E, optString2, false);
            } else {
                w.h("MicroMsg.JsApiCheckNetworkAPIURL", "hy: unknown api: %s", optString);
                hashMap.put(AppConstants.Key.COLUMN_IS_VALID, Boolean.FALSE);
                dVar.a(i3, makeReturnJson("fail:unknow api", hashMap));
                return;
            }
            String str = (String) q.f(optString2).get("host");
            if (!w0.c(str)) {
                w.d("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", str);
                i16 = q.e(str);
            } else {
                i16 = 0;
            }
            w.d("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", Boolean.valueOf(a16), Integer.valueOf(i16), optString, optString2);
            if (a16) {
                hashMap.put("isInDomainList", Boolean.TRUE);
            } else {
                hashMap.put("isInDomainList", Boolean.FALSE);
            }
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        hashMap.put("isInLAN", Boolean.TRUE);
                        hashMap.put("isLocalHost", Boolean.FALSE);
                    }
                } else {
                    Boolean bool = Boolean.TRUE;
                    hashMap.put("isInLAN", bool);
                    hashMap.put("isLocalHost", bool);
                }
            } else {
                Boolean bool2 = Boolean.FALSE;
                hashMap.put("isInLAN", bool2);
                hashMap.put("isLocalHost", bool2);
            }
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            return;
        }
        w.h("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", optString, optString2);
        hashMap.put(AppConstants.Key.COLUMN_IS_VALID, Boolean.FALSE);
        dVar.a(i3, makeReturnJson("fail:api or url invalid", hashMap));
    }
}
