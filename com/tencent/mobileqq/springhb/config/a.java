package com.tencent.mobileqq.springhb.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f288989d;

    /* renamed from: e, reason: collision with root package name */
    public JSONObject f288990e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288989d = new JSONObject();
            this.f288990e = new JSONObject();
        }
    }

    public static a e(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        JSONObject jSONObject = new JSONObject(str);
        aVar.f288989d = g(jSONObject);
        aVar.f288990e = f(jSONObject);
        return aVar;
    }

    private static JSONObject f(JSONObject jSONObject) {
        return jSONObject.optJSONObject("GameCenterCommon");
    }

    private static JSONObject g(JSONObject jSONObject) {
        return jSONObject.optJSONObject("SpringHb2025Common");
    }

    public JSONObject a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JSONObject) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        JSONObject jSONObject = this.f288989d;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(str);
    }

    public long b(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str)).longValue();
        }
        if (i3 == 1) {
            JSONObject jSONObject = this.f288990e;
            if (jSONObject == null) {
                return -1L;
            }
            return jSONObject.optLong(str);
        }
        JSONObject jSONObject2 = this.f288989d;
        if (jSONObject2 == null) {
            return -1L;
        }
        return jSONObject2.optLong(str);
    }

    public boolean c(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        JSONObject jSONObject = this.f288989d;
        if (jSONObject == null) {
            return z16;
        }
        return jSONObject.optBoolean(str, z16);
    }

    public int d(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Integer.valueOf(i16))).intValue();
        }
        if (i3 == 1) {
            JSONObject jSONObject = this.f288990e;
            if (jSONObject == null) {
                return i16;
            }
            return jSONObject.optInt(str, i16);
        }
        JSONObject jSONObject2 = this.f288989d;
        if (jSONObject2 == null) {
            return i16;
        }
        return jSONObject2.optInt(str, i16);
    }

    public String toString() {
        String jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("SpringHbCommonConfBean{commonConfig=");
        JSONObject jSONObject2 = this.f288989d;
        if (jSONObject2 == null) {
            jSONObject = "null";
        } else {
            jSONObject = jSONObject2.toString();
        }
        sb5.append(jSONObject);
        sb5.append('}');
        return sb5.toString();
    }
}
