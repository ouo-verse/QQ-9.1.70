package com.tencent.luggage.wxa.jg;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 231;
    public static final String NAME = "vibrateLong";

    public static void a(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            return;
        }
        vibrator.vibrate(400L);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
        if (dVar.getAppState() != com.tencent.luggage.wxa.qc.b.FOREGROUND) {
            dVar.a(i3, makeReturnJson("fail:not allowed in background"));
        } else {
            a(dVar.getContext());
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }
}
