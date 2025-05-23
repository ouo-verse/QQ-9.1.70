package com.tencent.mobileqq.datareportviewer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public String f203351c;

    /* renamed from: d, reason: collision with root package name */
    public d f203352d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f203353e;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c c(JSONObject jSONObject) {
        c cVar = new c();
        cVar.f203342a = jSONObject.optString("name");
        cVar.f203351c = jSONObject.optString("action");
        cVar.f203343b = jSONObject.optBoolean("isChecked", true);
        cVar.f203353e = jSONObject.optBoolean("isAddByUser");
        return cVar;
    }

    @Override // com.tencent.mobileqq.datareportviewer.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f203353e;
    }

    @Override // com.tencent.mobileqq.datareportviewer.a
    public JSONObject b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f203342a);
            jSONObject.put("action", this.f203351c);
            jSONObject.put("isChecked", this.f203343b);
            jSONObject.put("isAddByUser", this.f203353e);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        d dVar = this.f203352d;
        if (dVar == null) {
            return this.f203343b;
        }
        return dVar.f203343b;
    }
}
