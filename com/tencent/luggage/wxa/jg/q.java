package com.tencent.luggage.wxa.jg;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 535;
    public static final String NAME = "getVolume";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetVolume", "component is null");
            return;
        }
        Context context = dVar.getContext();
        if (context == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetVolume", "fail:context is null");
            dVar.a(i3, makeReturnJson("fail:context is null"));
            return;
        }
        if (!(context instanceof Activity)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
            dVar.a(i3, makeReturnJson("fail:context is not Activity"));
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetVolume", "fail:manager is null");
            dVar.a(i3, makeReturnJson("fail:manager is null"));
            return;
        }
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
        HashMap hashMap = new HashMap();
        hashMap.put("currentVolume", Integer.valueOf(streamVolume));
        hashMap.put("maxVolume", Integer.valueOf(streamMaxVolume));
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
