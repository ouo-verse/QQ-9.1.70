package com.tencent.luggage.wxa.nh;

import android.text.TextUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f135822a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f135823b = "";

    /* renamed from: c, reason: collision with root package name */
    public Integer f135824c = null;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f135825d = null;

    /* renamed from: e, reason: collision with root package name */
    public Integer f135826e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f135827f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f135828g = false;

    public boolean a() {
        if (!TextUtils.isEmpty(this.f135822a) && !this.f135822a.equals(BaseConstants.UNKNOWN_SSID_STRING) && !TextUtils.isEmpty(this.f135823b) && !this.f135823b.equals(GlobalUtil.DEFAULT_MAC_ADDRESS)) {
            return true;
        }
        return false;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.f135822a);
        jSONObject.put("BSSID", this.f135823b);
        Boolean bool = this.f135825d;
        if (bool != null) {
            jSONObject.put(ClientCookie.SECURE_ATTR, bool);
        }
        Integer num = this.f135824c;
        if (num != null) {
            jSONObject.put("signalStrength", num);
        }
        Integer num2 = this.f135826e;
        if (num2 != null) {
            jSONObject.put("frequency", num2);
        }
        return jSONObject;
    }

    public String toString() {
        return "WiFiItem{mSsid='" + this.f135822a + "', mBssid='" + this.f135823b + "', mSignalStrength=" + this.f135824c + ", mSecurity=" + this.f135825d + ", frequency=" + this.f135826e + '}';
    }
}
