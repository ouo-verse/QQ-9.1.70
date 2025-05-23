package com.tencent.halley.common.d.b.b.b;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f113489a;

    /* renamed from: b, reason: collision with root package name */
    public int f113490b;

    /* renamed from: c, reason: collision with root package name */
    public long f113491c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final Object a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appid", com.tencent.halley.common.a.c());
            jSONObject2.put("url", this.f113489a);
            jSONObject2.put("needFeature", this.f113490b);
            jSONObject2.put("size", this.f113491c);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            jSONObject.put(DKConfiguration.Directory.RESOURCES, jSONArray);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }
}
