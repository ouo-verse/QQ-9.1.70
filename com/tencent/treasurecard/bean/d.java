package com.tencent.treasurecard.bean;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.treasurecard.FtConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f381167a;

    /* renamed from: b, reason: collision with root package name */
    String f381168b;

    /* renamed from: c, reason: collision with root package name */
    String f381169c;

    /* renamed from: d, reason: collision with root package name */
    int f381170d;

    /* renamed from: e, reason: collision with root package name */
    String f381171e;

    public d(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.f381170d = 0;
        this.f381171e = null;
        this.f381167a = str;
        this.f381168b = str2;
        this.f381169c = str3;
    }

    public JSONObject a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        JSONObject jSONObject = new JSONObject();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FtConstants.TC_SP_NAME, 4);
        try {
            jSONObject.put("orderUrl", this.f381167a);
            jSONObject.put("imageUrl", this.f381168b);
            jSONObject.put("message", this.f381169c);
            jSONObject.put("flowThreshold", sharedPreferences.getInt("flowThreshold", -1));
            jSONObject.put("flowThresholdText", sharedPreferences.getString("flowThresholdText", ""));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }
}
