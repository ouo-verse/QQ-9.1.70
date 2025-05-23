package com.tencent.luggage.wxa.ff;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.tn.w;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f126115a = "TXLiveParamUtil";

    @NonNull
    public static Bundle a(@NonNull JSONObject jSONObject) {
        String str;
        Log.i("TXLivePlayerJSAdapter", "LivePlayer params:" + jSONObject);
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("playUrl")) {
                bundle.putString("playUrl", jSONObject.getString("playUrl"));
            }
            str = "maxCache";
        } catch (JSONException e16) {
            str = "maxCache";
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "playUrl", e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e17) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "mode", e17.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoplay")) {
                bundle.putBoolean("autoplay", jSONObject.getBoolean("autoplay"));
            }
        } catch (JSONException e18) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "autoplay", e18.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e19) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "muted", e19.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muteAudio")) {
                bundle.putBoolean("muteAudio", jSONObject.getBoolean("muteAudio"));
            }
        } catch (JSONException e26) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "muteAudio", e26.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muteVideo")) {
                bundle.putBoolean("muteVideo", jSONObject.getBoolean("muteVideo"));
            }
        } catch (JSONException e27) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "muteVideo", e27.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e28) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "orientation", e28.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("objectFit")) {
                bundle.putString("objectFit", jSONObject.getString("objectFit"));
            }
        } catch (JSONException e29) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "objectFit", e29.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minCache")) {
                bundle.putFloat("minCache", BigDecimal.valueOf(jSONObject.getDouble("minCache")).floatValue());
            }
        } catch (JSONException e36) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "minCache", e36.getLocalizedMessage());
        }
        String str2 = str;
        try {
            if (jSONObject.has(str2)) {
                bundle.putFloat(str2, BigDecimal.valueOf(jSONObject.getDouble(str2)).floatValue());
            }
        } catch (JSONException e37) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", str2, e37.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableRecvMessage")) {
                bundle.putBoolean("enableRecvMessage", jSONObject.getBoolean("enableRecvMessage"));
            }
        } catch (JSONException e38) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "enableRecvMessage", e38.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needAudioVolume")) {
                bundle.putBoolean("needAudioVolume", jSONObject.getBoolean("needAudioVolume"));
            }
        } catch (JSONException e39) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "needAudioVolume", e39.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e46) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "debug", e46.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("soundMode")) {
                bundle.putString("soundMode", jSONObject.getString("soundMode"));
            }
        } catch (JSONException e47) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "soundMode", e47.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needEvent")) {
                bundle.putBoolean("needEvent", jSONObject.getBoolean("needEvent"));
            }
        } catch (JSONException e48) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "needEvent", e48.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfNavigate")) {
                bundle.putBoolean("autoPauseIfNavigate", jSONObject.getBoolean("autoPauseIfNavigate"));
            }
        } catch (JSONException e49) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "autoPauseIfNavigate", e49.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autoPauseIfOpenNative")) {
                bundle.putBoolean("autoPauseIfOpenNative", jSONObject.getBoolean("autoPauseIfOpenNative"));
            }
        } catch (JSONException e56) {
            w.d(f126115a, "convertLivePlayerParams param=%s exp=%s", "autoPauseIfOpenNative", e56.getLocalizedMessage());
        }
        return bundle;
    }

    @NonNull
    public static Bundle b(@NonNull JSONObject jSONObject) {
        String str;
        Log.i("TXLivePusherJSAdapter", "LivePusher params:" + jSONObject);
        Bundle bundle = new Bundle();
        try {
            if (jSONObject.has("pushUrl")) {
                bundle.putString("pushUrl", jSONObject.getString("pushUrl"));
            }
            str = "enableEarMonitor";
        } catch (JSONException e16) {
            str = "enableEarMonitor";
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "pushUrl", e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mode")) {
                bundle.putInt("mode", jSONObject.getInt("mode"));
            }
        } catch (JSONException e17) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "mode", e17.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("autopush")) {
                bundle.putBoolean("autopush", jSONObject.getBoolean("autopush"));
            }
        } catch (JSONException e18) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "autopush", e18.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("audioQuality")) {
                bundle.putString("audioQuality", jSONObject.getString("audioQuality"));
            }
        } catch (JSONException e19) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "audioQuality", e19.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("muted")) {
                bundle.putBoolean("muted", jSONObject.getBoolean("muted"));
            }
        } catch (JSONException e26) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "muted", e26.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableCamera")) {
                bundle.putBoolean("enableCamera", jSONObject.getBoolean("enableCamera"));
            }
        } catch (JSONException e27) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "enableCamera", e27.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableMic")) {
                bundle.putBoolean("enableMic", jSONObject.getBoolean("enableMic"));
            }
        } catch (JSONException e28) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "enableMic", e28.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableAGC")) {
                bundle.putBoolean("enableAGC", jSONObject.getBoolean("enableAGC"));
            }
        } catch (JSONException e29) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "enableAGC", e29.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("enableANS")) {
                bundle.putBoolean("enableANS", jSONObject.getBoolean("enableANS"));
            }
        } catch (JSONException e36) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "enableANS", e36.getLocalizedMessage());
        }
        String str2 = str;
        try {
            if (jSONObject.has(str2)) {
                bundle.putBoolean(str2, jSONObject.getBoolean(str2));
            }
        } catch (JSONException e37) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", str2, e37.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("audioVolumeType")) {
                bundle.putString("audioVolumeType", jSONObject.getString("audioVolumeType"));
            }
        } catch (JSONException e38) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "audioVolumeType", e38.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("audioReverbType")) {
                bundle.putInt("audioReverbType", jSONObject.getInt("audioReverbType"));
            }
        } catch (JSONException e39) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "audioReverbType", e39.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("videoWidth")) {
                bundle.putInt("videoWidth", jSONObject.getInt("videoWidth"));
            }
        } catch (JSONException e46) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "videoWidth", e46.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("videoHeight")) {
                bundle.putInt("videoHeight", jSONObject.getInt("videoHeight"));
            }
        } catch (JSONException e47) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "videoHeight", e47.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("focusMode")) {
                bundle.putInt("focusMode", jSONObject.getInt("focusMode"));
            }
        } catch (JSONException e48) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "focusMode", e48.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("orientation")) {
                bundle.putString("orientation", jSONObject.getString("orientation"));
            }
        } catch (JSONException e49) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "orientation", e49.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("beauty")) {
                bundle.putInt("beauty", jSONObject.getInt("beauty"));
            }
        } catch (JSONException e56) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "beauty", e56.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(V2TXJSAdapterConstants.PUSHER_KEY_BEAUTY_STYLE)) {
                bundle.putString(V2TXJSAdapterConstants.PUSHER_KEY_BEAUTY_STYLE, jSONObject.getString(V2TXJSAdapterConstants.PUSHER_KEY_BEAUTY_STYLE));
            }
        } catch (JSONException e57) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", V2TXJSAdapterConstants.PUSHER_KEY_BEAUTY_STYLE, e57.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE)) {
                bundle.putString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, jSONObject.getString(V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE));
            }
        } catch (JSONException e58) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", V2TXJSAdapterConstants.PUSHER_KEY_FILTER_IMAGE, e58.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("whiteness")) {
                bundle.putInt("whiteness", jSONObject.getInt("whiteness"));
            }
        } catch (JSONException e59) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "whiteness", e59.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("aspect")) {
                bundle.putInt("aspect", jSONObject.getInt("aspect"));
            }
        } catch (JSONException e65) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "aspect", e65.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("minBitrate")) {
                bundle.putInt("minBitrate", jSONObject.getInt("minBitrate"));
            }
        } catch (JSONException e66) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "minBitrate", e66.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("maxBitrate")) {
                bundle.putInt("maxBitrate", jSONObject.getInt("maxBitrate"));
            }
        } catch (JSONException e67) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "maxBitrate", e67.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("zoom")) {
                bundle.putBoolean("zoom", jSONObject.getBoolean("zoom"));
            }
        } catch (JSONException e68) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "zoom", e68.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("debug")) {
                bundle.putBoolean("debug", jSONObject.getBoolean("debug"));
            }
        } catch (JSONException e69) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "debug", e69.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("mirror")) {
                bundle.putBoolean("mirror", jSONObject.getBoolean("mirror"));
            }
        } catch (JSONException e75) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "mirror", e75.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("remoteMirror")) {
                bundle.putBoolean("remoteMirror", jSONObject.getBoolean("remoteMirror"));
            }
        } catch (JSONException e76) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "remoteMirror", e76.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("localMirror")) {
                bundle.putString("localMirror", jSONObject.getString("localMirror"));
            }
        } catch (JSONException e77) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "localMirror", e77.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkLeft")) {
                bundle.putFloat("watermarkLeft", BigDecimal.valueOf(jSONObject.getDouble("watermarkLeft")).floatValue());
            }
        } catch (JSONException e78) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "watermarkLeft", e78.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkTop")) {
                bundle.putFloat("watermarkTop", BigDecimal.valueOf(jSONObject.getDouble("watermarkTop")).floatValue());
            }
        } catch (JSONException e79) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "watermarkTop", e79.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("watermarkWidth")) {
                bundle.putFloat("watermarkWidth", BigDecimal.valueOf(jSONObject.getDouble("watermarkWidth")).floatValue());
            }
        } catch (JSONException e85) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "watermarkWidth", e85.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("devicePosition")) {
                bundle.putString("devicePosition", jSONObject.getString("devicePosition"));
            }
        } catch (JSONException e86) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "devicePosition", e86.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needBGMEvent")) {
                bundle.putBoolean("needBGMEvent", jSONObject.getBoolean("needBGMEvent"));
            }
        } catch (JSONException e87) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "needBGMEvent", e87.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("needAudioVolume")) {
                bundle.putBoolean("needAudioVolume", jSONObject.getBoolean("needAudioVolume"));
            }
        } catch (JSONException e88) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "needAudioVolume", e88.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(V2TXJSAdapterConstants.PUSHER_KEY_VOICE_CHANGER_TYPE)) {
                bundle.putInt(V2TXJSAdapterConstants.PUSHER_KEY_VOICE_CHANGER_TYPE, jSONObject.getInt(V2TXJSAdapterConstants.PUSHER_KEY_VOICE_CHANGER_TYPE));
            }
        } catch (JSONException e89) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", V2TXJSAdapterConstants.PUSHER_KEY_VOICE_CHANGER_TYPE, e89.getLocalizedMessage());
        }
        try {
            if (jSONObject.has("fps")) {
                bundle.putInt("fps", jSONObject.getInt("fps"));
            }
        } catch (JSONException e95) {
            w.d(f126115a, "convertLivePusherParams param=%s exp=%s", "fps", e95.getLocalizedMessage());
        }
        return bundle;
    }
}
