package com.tencent.luggage.wxa.jg;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 534;
    public static final String NAME = "setVolume";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetVolume", "fail:component is null");
            return;
        }
        Context context = dVar.getContext();
        if (context == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetVolume", "fail:context is null");
            dVar.a(i3, makeReturnJson("fail:context is null"));
            return;
        }
        if (!(context instanceof Activity)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
            dVar.a(i3, makeReturnJson("fail:context is not Activity"));
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetVolume", "fail:manager is null");
            dVar.a(i3, makeReturnJson("fail:manager is null"));
            return;
        }
        int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int optInt = jSONObject.optInt("value", streamVolume);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", Integer.valueOf(optInt), Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
        if (optInt < 0) {
            streamMaxVolume = 0;
        } else if (optInt <= streamMaxVolume) {
            streamMaxVolume = optInt;
        }
        if (streamMaxVolume != streamVolume) {
            com.tencent.luggage.wxa.s9.a.a(audioManager, 3, streamMaxVolume, 0);
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } else {
            dVar.a(i3, makeReturnJson("fail:volume does not change"));
        }
    }
}
