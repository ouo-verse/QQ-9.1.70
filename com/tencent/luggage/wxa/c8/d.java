package com.tencent.luggage.wxa.c8;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.live2.jsplugin.V2TXJSAdapterConstants;
import com.tencent.luggage.wxa.ff.j;
import com.tencent.luggage.wxa.tn.w;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f123409a = "MicroMsg.TXLiveParamUtil";

    @NonNull
    public static Bundle a(@NonNull JSONObject jSONObject) {
        Bundle a16 = j.a(jSONObject);
        try {
            if (jSONObject.has(c.f123370d0)) {
                a16.putString(c.f123370d0, jSONObject.getString(c.f123370d0));
            }
        } catch (JSONException e16) {
            w.d(f123409a, "convertLivePlayerParams param=%s exp=%s", c.f123370d0, e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY)) {
                a16.putBoolean(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY, jSONObject.getBoolean(V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY));
            }
        } catch (JSONException e17) {
            w.d(f123409a, "convertLivePlayerParams param=%s exp=%s", V2TXJSAdapterConstants.PLAYER_KEY_CAN_AUTO_PLAY, e17.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(V2TXJSAdapterConstants.IS_VOIP)) {
                a16.putBoolean(V2TXJSAdapterConstants.IS_VOIP, jSONObject.getBoolean(V2TXJSAdapterConstants.IS_VOIP));
            }
        } catch (JSONException e18) {
            w.d(f123409a, "convertLivePlayerParams param=%s exp=%s", V2TXJSAdapterConstants.IS_VOIP, e18.getLocalizedMessage());
        }
        return a16;
    }

    @NonNull
    public static Bundle b(@NonNull JSONObject jSONObject) {
        Bundle b16 = j.b(jSONObject);
        try {
            if (jSONObject.has(c.f123378k)) {
                b16.putBoolean(c.f123378k, jSONObject.getBoolean(c.f123378k));
            }
        } catch (JSONException e16) {
            w.d(f123409a, "convertLivePusherParams param=%s exp=%s", c.f123378k, e16.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(c.f123380l)) {
                b16.putFloat(c.f123380l, BigDecimal.valueOf(jSONObject.getDouble(c.f123380l)).floatValue());
            }
        } catch (JSONException e17) {
            w.d(f123409a, "convertLivePusherParams param=%s exp=%s", c.f123380l, e17.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(c.f123382m)) {
                b16.putFloat(c.f123382m, BigDecimal.valueOf(jSONObject.getDouble(c.f123382m)).floatValue());
            }
        } catch (JSONException e18) {
            w.d(f123409a, "convertLivePusherParams param=%s exp=%s", c.f123382m, e18.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(c.f123384n)) {
                b16.putFloat(c.f123384n, BigDecimal.valueOf(jSONObject.getDouble(c.f123384n)).floatValue());
            }
        } catch (JSONException e19) {
            w.d(f123409a, "convertLivePusherParams param=%s exp=%s", c.f123384n, e19.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(c.f123386o)) {
                b16.putFloat(c.f123386o, BigDecimal.valueOf(jSONObject.getDouble(c.f123386o)).floatValue());
            }
        } catch (JSONException e26) {
            w.d(f123409a, "convertLivePusherParams param=%s exp=%s", c.f123386o, e26.getLocalizedMessage());
        }
        try {
            if (jSONObject.has(V2TXJSAdapterConstants.IS_VOIP)) {
                b16.putBoolean(V2TXJSAdapterConstants.IS_VOIP, jSONObject.getBoolean(V2TXJSAdapterConstants.IS_VOIP));
            }
        } catch (JSONException e27) {
            w.d(f123409a, "convertLivePusherParams param=%s exp=%s", V2TXJSAdapterConstants.IS_VOIP, e27.getLocalizedMessage());
        }
        return b16;
    }
}
