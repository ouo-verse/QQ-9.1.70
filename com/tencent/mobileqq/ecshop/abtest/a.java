package com.tencent.mobileqq.ecshop.abtest;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f203934a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f203935b;

    /* renamed from: c, reason: collision with root package name */
    public String f203936c;

    /* renamed from: d, reason: collision with root package name */
    public String f203937d;

    /* renamed from: e, reason: collision with root package name */
    public String f203938e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a b(JSONObject jSONObject) {
        a aVar = new a();
        aVar.f203934a = jSONObject.optString(ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_POLICY_ID);
        aVar.f203935b = jSONObject.optJSONObject("params");
        aVar.f203936c = jSONObject.optString("sGroupKey");
        aVar.f203937d = jSONObject.optString("sStrategyType");
        aVar.f203938e = jSONObject.optString("sExpKey");
        return aVar;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        JSONObject jSONObject = this.f203935b;
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return "";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ABTestInfo{sGrayPolicyId=" + this.f203934a + ", params=" + a() + ", sGroupKey=" + this.f203936c + ", sStrategyType=" + this.f203937d + ", sExpKey=" + this.f203938e + '}';
    }
}
