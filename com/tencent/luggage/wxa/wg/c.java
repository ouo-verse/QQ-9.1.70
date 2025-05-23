package com.tencent.luggage.wxa.wg;

import android.view.View;
import com.tencent.luggage.wxa.mg.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 114;
    public static final String NAME = "operateVideoPlayer";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        char c16;
        k kVar = new k(i3);
        w.d("MicroMsg.JsApiOperateVideoPlayer", "%s onOperateView, data: %s", kVar, jSONObject);
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h("MicroMsg.JsApiOperateVideoPlayer", "%s view is not a instance of CoverViewContainer", kVar);
            return false;
        }
        com.tencent.luggage.wxa.mg.a aVar = (com.tencent.luggage.wxa.mg.a) ((com.tencent.luggage.wxa.ye.b) view).a(com.tencent.luggage.wxa.mg.a.class);
        if (aVar == null) {
            w.b("MicroMsg.JsApiOperateVideoPlayer", "%s view not AppBrandVideoView", kVar);
            return false;
        }
        String optString = jSONObject.optString("type");
        w.d("MicroMsg.JsApiOperateVideoPlayer", "%s onOperateView operateType=%s", kVar, optString);
        optString.hashCode();
        int i16 = -1;
        switch (optString.hashCode()) {
            case -802181223:
                if (optString.equals("exitFullScreen")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1222225:
                if (optString.equals("sendDanmu")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3443508:
                if (optString.equals("play")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3526264:
                if (optString.equals(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3540994:
                if (optString.equals("stop")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 106440182:
                if (optString.equals("pause")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 458133450:
                if (optString.equals("requestFullScreen")) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1355420059:
                if (optString.equals("playbackRate")) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                aVar.a(false, -1);
                return true;
            case 1:
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    if (optJSONArray.length() == 1) {
                        aVar.a(optJSONArray.optString(0, ""), "");
                    } else {
                        aVar.a(optJSONArray.optString(0, ""), optJSONArray.optString(1, ""));
                    }
                    return true;
                }
                w.h("MicroMsg.JsApiOperateVideoPlayer", "%s onOperateView dataArr nil", kVar);
                return false;
            case 2:
                aVar.t();
                return true;
            case 3:
                JSONArray optJSONArray2 = jSONObject.optJSONArray("data");
                if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                    double optDouble = optJSONArray2.optDouble(0, -1.0d);
                    if (optDouble < 0.0d) {
                        w.d("MicroMsg.JsApiOperateVideoPlayer", "%s pos invalid %s", kVar, Double.valueOf(optDouble));
                        return false;
                    }
                    aVar.a(optDouble);
                    return true;
                }
                w.h("MicroMsg.JsApiOperateVideoPlayer", "%s onOperateView dataArr nil", kVar);
                return false;
            case 4:
                aVar.v();
                return true;
            case 5:
                aVar.p();
                return true;
            case 6:
                JSONArray optJSONArray3 = jSONObject.optJSONArray("data");
                if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                    i16 = optJSONArray3.optInt(0, -1);
                } else {
                    w.h("MicroMsg.JsApiOperateVideoPlayer", "%s onOperateView directionArr nil", kVar);
                }
                aVar.a(true, i16);
                return true;
            case 7:
                JSONArray optJSONArray4 = jSONObject.optJSONArray("data");
                if (optJSONArray4 != null && optJSONArray4.length() != 0) {
                    double optDouble2 = optJSONArray4.optDouble(0, -1.0d);
                    if (optDouble2 < 0.0d) {
                        w.d("MicroMsg.JsApiOperateVideoPlayer", "%s rate invalid %f", kVar, Double.valueOf(optDouble2));
                        return false;
                    }
                    aVar.a((float) optDouble2);
                    return true;
                }
                w.h("MicroMsg.JsApiOperateVideoPlayer", "%s onOperateView dataArr nil", kVar);
                return false;
            default:
                w.h("MicroMsg.JsApiOperateVideoPlayer", "%s onOperateView operateType not supported: %s", kVar, optString);
                return false;
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }
}
