package com.tencent.mobileqq.perf.thread.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public b f258135a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        QLog.d("[TM]ThreadConfig", 2, "[config] parse: invoked. ", " cfgJson: ", jSONObject.toString());
        try {
            if (jSONObject.has("threadBlockConfig")) {
                cVar.f258135a = b.b(jSONObject.getJSONObject("threadBlockConfig"));
            }
        } catch (JSONException e16) {
            QLog.e("[TM]ThreadConfig", 1, e16, new Object[0]);
        }
        return cVar;
    }
}
