package com.tencent.luggage.wxa.zd;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 481;
    public static final String NAME = "setInnerAudioOption";

    /* renamed from: a, reason: collision with root package name */
    public static boolean f146555a = true;

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String appId = dVar.getAppId();
        w.d("MicroMsg.Audio.JsApiSetInnerAudioOption", "data:%s, appId:%s", jSONObject, appId);
        com.tencent.luggage.wxa.qb.a a16 = com.tencent.luggage.wxa.qb.c.a();
        if (a16 == null) {
            a16 = new com.tencent.luggage.wxa.qb.a();
        }
        if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(a16.f138563c) && !appId.equalsIgnoreCase(a16.f138563c)) {
            a16.a();
            w.d("MicroMsg.Audio.JsApiSetInnerAudioOption", "reset AudioContextParam");
        }
        a16.f138563c = appId;
        if (jSONObject.has("mixWithOther")) {
            boolean optBoolean = jSONObject.optBoolean("mixWithOther", true);
            if (f146555a) {
                a16.f138561a = optBoolean;
            }
        }
        if (jSONObject.has("speakerOn")) {
            a16.f138562b = jSONObject.optBoolean("speakerOn", true);
        }
        if (!a16.f138562b) {
            a16.f138561a = false;
        }
        com.tencent.luggage.wxa.qb.c.a(a16);
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
