package com.tencent.mobileqq.perf.thread.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public c f258136d;

    /* renamed from: e, reason: collision with root package name */
    public c f258137e;

    /* renamed from: f, reason: collision with root package name */
    public c f258138f;

    /* renamed from: h, reason: collision with root package name */
    public c f258139h;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        c cVar = new c();
        this.f258136d = cVar;
        this.f258137e = cVar;
        this.f258138f = cVar;
        this.f258139h = cVar;
    }

    public static d a(String str) {
        d dVar = new d();
        if (str != null && str.length() > 0) {
            QLog.d("[TM]ThreadConfigBean", 2, "[config] parse: invoked. ", " content: ", str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("official")) {
                    dVar.f258137e = c.a(jSONObject.getJSONObject("official"));
                }
                if (jSONObject.has("gray")) {
                    dVar.f258138f = c.a(jSONObject.getJSONObject("gray"));
                }
                if (jSONObject.has("develop")) {
                    dVar.f258139h = c.a(jSONObject.getJSONObject("develop"));
                }
            } catch (JSONException e16) {
                QLog.e("[TM]ThreadConfigBean", 1, e16, new Object[0]);
            }
        }
        return dVar;
    }
}
