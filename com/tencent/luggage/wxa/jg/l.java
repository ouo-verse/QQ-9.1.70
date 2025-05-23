package com.tencent.luggage.wxa.jg;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.WindowManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 232;
    public static final String NAME = "getScreenBrightness";

    /* renamed from: a, reason: collision with root package name */
    public static Function1 f131112a;

    public static float a(Context context) {
        Function1 function1 = f131112a;
        if (function1 != null) {
            try {
                return ((Float) function1.invoke(context)).floatValue();
            } catch (UnsupportedOperationException unused) {
            }
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness") / e();
        } catch (Settings.SettingNotFoundException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e16.getMessage());
            return 0.0f;
        } catch (IllegalArgumentException e17) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent IllegalArgumentException: %s", e17.getMessage());
            return 0.0f;
        } catch (Exception e18) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetScreenBrightness", "getSystemBrightnessPercent err %s", e18.getMessage());
            return 0.0f;
        }
    }

    public static int e() {
        try {
            Resources system = Resources.getSystem();
            int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
            if (identifier != 0) {
                return system.getInteger(identifier);
            }
        } catch (Exception unused) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetScreenBrightness", "get max brightness fail, fallback to 255");
        }
        return 255;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
        Context context = dVar.getContext();
        if (context == null) {
            dVar.a(i3, makeReturnJson("fail"));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
            return;
        }
        if (!(context instanceof Activity)) {
            dVar.a(i3, makeReturnJson("fail"));
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetScreenBrightness", "context is not Activity, invoke fail!");
            return;
        }
        WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
        float f16 = attributes.screenBrightness;
        if (f16 < 0.0f) {
            f16 = a(context);
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness %f/%f", Float.valueOf(f16), Float.valueOf(attributes.screenBrightness));
        HashMap hashMap = new HashMap();
        hashMap.put("value", Float.valueOf(f16));
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
