package com.tencent.luggage.wxa.jg;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 230;
    public static final String NAME = "vibrateShort";

    public static int a(int i3) {
        if (i3 == 1) {
            return 128;
        }
        if (i3 != 2) {
            return i3 != 3 ? -1 : 255;
        }
        return 192;
    }

    public static void b(Vibrator vibrator, long j3, int i3) {
        VibrationEffect createOneShot;
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiVibrateShort", "vibrateSupportAmplitude");
        int a16 = a(i3);
        if (-1 != a16) {
            createOneShot = VibrationEffect.createOneShot(j3, a16);
            vibrator.vibrate(createOneShot);
        } else {
            vibrator.vibrate(j3);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
        if (dVar.getAppState() != com.tencent.luggage.wxa.qc.b.FOREGROUND) {
            dVar.a(i3, makeReturnJson("fail:not allowed in background"));
            return;
        }
        int a16 = a(jSONObject);
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiVibrateShort", "vibrationIntensity: " + a16);
        try {
            Vibrator vibrator = (Vibrator) dVar.getContext().getSystemService("vibrator");
            if (vibrator == null) {
                dVar.a(i3, makeReturnJson("fail: vibrate is not support"));
            } else {
                dVar.a(i3, makeReturnJson(a(vibrator, 15L, a16)));
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", e16.getMessage());
            dVar.a(i3, makeReturnJson("fail: system internal error"));
        }
    }

    public static int a(JSONObject jSONObject) {
        char c16 = '\uffff';
        if (jSONObject == null || !jSONObject.has("style")) {
            return -1;
        }
        String optString = jSONObject.optString("style");
        if (w0.c(optString)) {
            return -2;
        }
        optString.hashCode();
        switch (optString.hashCode()) {
            case -1078030475:
                if (optString.equals("medium")) {
                    c16 = 0;
                    break;
                }
                break;
            case 99152071:
                if (optString.equals("heavy")) {
                    c16 = 1;
                    break;
                }
                break;
            case 102970646:
                if (optString.equals(MiniAppConst.MENU_STYLE_LIGHT)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 1;
            default:
                return -2;
        }
    }

    public static String a(Vibrator vibrator, long j3, int i3) {
        boolean hasAmplitudeControl;
        if (-2 == i3) {
            vibrator.vibrate(j3);
            return "fail: style is illegal";
        }
        if (-1 == i3) {
            vibrator.vibrate(j3);
            return FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hasAmplitudeControl = vibrator.hasAmplitudeControl();
            if (hasAmplitudeControl) {
                b(vibrator, j3, i3);
                return FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
        }
        vibrator.vibrate(j3);
        return "fail: style is not support";
    }
}
