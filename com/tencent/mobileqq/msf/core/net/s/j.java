package com.tencent.mobileqq.msf.core.net.s;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f249128a;

    /* renamed from: b, reason: collision with root package name */
    public long f249129b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f249130c;

    /* renamed from: d, reason: collision with root package name */
    public int f249131d;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static j a(String str) {
        try {
            String[] split = str.split("&#&");
            if (split.length != 3) {
                return null;
            }
            return new j(split[0], Long.parseLong(split[1]), Boolean.parseBoolean(split[2]), 0);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f249128a);
        stringBuffer.append("&#&");
        stringBuffer.append(this.f249129b);
        stringBuffer.append("&#&");
        stringBuffer.append(this.f249130c);
        stringBuffer.append("&#&");
        stringBuffer.append(this.f249131d);
        return stringBuffer.toString();
    }

    public j(String str, long j3, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.f249128a = str;
        this.f249129b = j3;
        this.f249130c = z16;
        this.f249131d = i3;
    }

    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JSONObject) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TPDownloadProxyEnum.USER_SSID, this.f249128a);
            jSONObject.put("time", this.f249129b);
            jSONObject.put("available", this.f249130c);
            return jSONObject;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static j a(JSONObject jSONObject) {
        try {
            return new j(jSONObject.getString(TPDownloadProxyEnum.USER_SSID), jSONObject.getLong("time"), jSONObject.getBoolean("available"), 0);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
