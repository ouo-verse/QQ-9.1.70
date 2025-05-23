package com.tencent.luggage.wxa.jg;

import android.content.Context;
import android.os.BatteryManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = 425;
    public static final String NAME = "getBatteryInfo";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetBatteryInfo", "JsApiGetBatteryInfo: start");
        if (dVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetBatteryInfo", "JsApiGetBatteryInfo no component");
            return makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e);
        }
        Context context = dVar.getContext();
        if (context == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetBatteryInfo", "JsApiGetBatteryInfo no context");
            return makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e);
        }
        BatteryManager a16 = a(context);
        if (a16 == null) {
            return makeReturnJson(com.tencent.luggage.wxa.af.e.f121309e);
        }
        int intProperty = SystemMethodProxy.getIntProperty(a16, 4);
        boolean isCharging = a16.isCharging();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetBatteryInfo", "BatteryInfo Api23 level = %d, isCharging = %b", Integer.valueOf(intProperty), Boolean.valueOf(isCharging));
        com.tencent.luggage.wxa.vk.c a17 = com.tencent.luggage.wxa.vk.a.INST.a();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetBatteryInfo", "BatterInfo Below21, level = %d, isCharging = %b", Integer.valueOf(a17.f143643b), Boolean.valueOf(a17.f143642a));
        boolean v3 = ((com.tencent.luggage.wxa.ic.u) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.ic.u.class)).v();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetBatteryInfo", "isLowPowerModeEnabled:%b", Boolean.valueOf(v3));
        HashMap hashMap = new HashMap();
        if (intProperty < 0) {
            intProperty = a17.f143643b;
        }
        hashMap.put("level", Integer.valueOf(intProperty));
        hashMap.put("isCharging", Boolean.valueOf(isCharging || a17.f143642a));
        hashMap.put("isLowPowerModeEnabled", Boolean.valueOf(v3));
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
    }

    public final BatteryManager a(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetBatteryInfo", "JsApiGetBatteryInfo no batteryManager");
            return null;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiGetBatteryInfo", "JsApiGetBatteryInfo: BatteryManager got!");
        return batteryManager;
    }
}
