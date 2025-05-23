package com.tencent.luggage.wxa.wg;

import android.view.View;
import com.tencent.luggage.wxa.mg.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.ee.d {
    private static final int CTRL_INDEX = 87;
    public static final String NAME = "updateVideoPlayer";

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject) {
        k kVar;
        k kVar2 = new k(i3);
        w.d("MicroMsg.JsApiUpdateVideoPlayer", "%s onUpdateView, data: %s", kVar2, jSONObject);
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.h("MicroMsg.JsApiUpdateVideoPlayer", "%s view is not a instance of CoverViewContainer", kVar2);
            return false;
        }
        com.tencent.luggage.wxa.mg.a aVar = (com.tencent.luggage.wxa.mg.a) ((com.tencent.luggage.wxa.ye.b) view).a(com.tencent.luggage.wxa.mg.a.class);
        if (aVar == null) {
            w.b("MicroMsg.JsApiUpdateVideoPlayer", "%s view not AppBrandVideoView", kVar2);
            return false;
        }
        try {
            if (jSONObject.has("showDanmuBtn")) {
                aVar.setShowDanmakuBtn(jSONObject.getBoolean("showDanmuBtn"));
            }
            kVar = kVar2;
        } catch (JSONException e16) {
            kVar = kVar2;
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showDanmuBtn", e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("danmuList")) {
                aVar.setDanmakuItemList(jSONObject.getJSONArray("danmuList"));
            }
        } catch (JSONException e17) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "danmuList", e17.getLocalizedMessage());
        }
        String str = null;
        try {
            if (jSONObject.has("objectFit")) {
                str = jSONObject.getString("objectFit");
                aVar.setObjectFit(str);
            }
        } catch (JSONException e18) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "objectFit", e18.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoplay")) {
                aVar.setAutoPlay(jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e19) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "autoplay", e19.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showBasicControls")) {
                aVar.setIsShowBasicControls(jSONObject.getBoolean("showBasicControls"));
            }
        } catch (JSONException e26) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showBasicControls", e26.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(QAdVrReport.ElementID.AD_POSTER)) {
                aVar.b(jSONObject.getString(QAdVrReport.ElementID.AD_POSTER), str);
            }
        } catch (JSONException e27) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", QAdVrReport.ElementID.AD_POSTER, e27.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("direction")) {
                aVar.setFullScreenDirection(jSONObject.getInt("direction"));
            }
        } catch (Exception e28) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "direction", e28.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                aVar.setMute(jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e29) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "muted", e29.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("loop")) {
                aVar.setLoop(jSONObject.getBoolean("loop"));
            }
        } catch (JSONException e36) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "loop", e36.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("data")) {
                aVar.setCookieData(jSONObject.getString("data"));
            }
        } catch (JSONException e37) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "data", e37.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("pageGesture")) {
                aVar.setPageGesture(jSONObject.getBoolean("pageGesture"));
            }
        } catch (JSONException e38) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "pageGesture", e38.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("pageGestureInFullscreen")) {
                aVar.setPageGestureInFullscreen(jSONObject.getBoolean("pageGestureInFullscreen"));
            }
        } catch (JSONException e39) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "pageGestureInFullscreen", e39.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showControlProgress")) {
                aVar.setShowControlProgress(jSONObject.getBoolean("showControlProgress"));
            }
        } catch (JSONException e46) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showControlProgress", e46.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showProgress")) {
                aVar.setShowProgress(jSONObject.getBoolean("showProgress"));
            }
        } catch (JSONException e47) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showProgress", e47.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showProgressInControlMode")) {
                aVar.setShowProgressBarInControlMode(jSONObject.getBoolean("showProgressInControlMode"));
            }
        } catch (JSONException e48) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showProgressInControlMode", e48.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showFullScreenBtn")) {
                aVar.setShowFullScreenBtn(jSONObject.getBoolean("showFullScreenBtn"));
            }
        } catch (JSONException e49) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showFullScreenBtn", e49.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showPlayBtn")) {
                aVar.setShowPlayBtn(jSONObject.getBoolean("showPlayBtn"));
            }
        } catch (JSONException e56) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showPlayBtn", e56.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showCenterPlayBtn")) {
                aVar.setShowCenterPlayBtn(jSONObject.getBoolean("showCenterPlayBtn"));
            }
        } catch (JSONException e57) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showCenterPlayBtn", e57.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showPoster")) {
                aVar.setShowPoster(jSONObject.getBoolean("showPoster"));
            }
        } catch (JSONException e58) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showPoster", e58.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableProgressGesture")) {
                aVar.b(jSONObject.getBoolean("enableProgressGesture"));
            }
        } catch (JSONException e59) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "enableProgressGesture", e59.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("duration")) {
                aVar.setDuration(jSONObject.getInt("duration"));
            }
        } catch (JSONException e65) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "disableScroll", e65.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("hide") && jSONObject.getBoolean("hide")) {
                w.d("MicroMsg.JsApiUpdateVideoPlayer", "%s onUpdateView hide stop", kVar);
                aVar.v();
            }
        } catch (JSONException e66) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "hide", e66.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("initialTime")) {
                aVar.setInitialTime(jSONObject.getInt("initialTime"));
            }
        } catch (JSONException e67) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "initialTime", e67.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                if (!jSONObject.getBoolean("needEvent")) {
                    aVar.setCallback(null);
                } else if (!aVar.d()) {
                    aVar.setCallback(new com.tencent.luggage.wxa.vg.b(aVar, fVar));
                }
            }
        } catch (JSONException e68) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "needEvent", e68.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("showMuteBtn")) {
                aVar.setShowMuteBtn(jSONObject.getBoolean("showMuteBtn"));
            }
        } catch (JSONException e69) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "showMuteBtn", e69.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("title")) {
                aVar.setTitle(jSONObject.getString("title"));
            }
        } catch (JSONException e75) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "title", e75.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("playBtnPosition")) {
                aVar.setPlayBtnPosition(jSONObject.getString("playBtnPosition"));
            }
        } catch (JSONException e76) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "playBtnPosition", e76.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enablePlayGesture")) {
                aVar.setEnablePlayGesture(jSONObject.getBoolean("enablePlayGesture"));
            }
        } catch (JSONException e77) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "enablePlayGesture", e77.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfOpenNative")) {
                aVar.setAutoPauseIfOpenNative(jSONObject.getBoolean("autoPauseIfOpenNative"));
            }
        } catch (JSONException e78) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "autoPauseIfOpenNative", e78.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfNavigate")) {
                aVar.setAutoPauseIfNavigate(jSONObject.getBoolean("autoPauseIfNavigate"));
            }
        } catch (JSONException e79) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "autoPauseIfNavigate", e79.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("filePath")) {
                aVar.a(jSONObject.getString("filePath"), jSONObject.optBoolean("live"), jSONObject.optInt("duration"));
            }
            return true;
        } catch (JSONException e85) {
            w.d("MicroMsg.JsApiUpdateVideoPlayer", "onUpdateView param=%s exp=%s", "filePath", e85.getLocalizedMessage());
            return true;
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }
}
