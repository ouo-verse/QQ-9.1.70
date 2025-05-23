package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f297413d;

    /* renamed from: e, reason: collision with root package name */
    public int f297414e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f297415f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f297416g;

    public f(JSONObject jSONObject) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jSONObject);
            return;
        }
        this.f297415f = false;
        this.f297416g = false;
        f(jSONObject);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f297413d.length();
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.model.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public void f(JSONObject jSONObject) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSONObject);
            return;
        }
        this.f297410b = jSONObject;
        String optString = jSONObject.optString("text");
        this.f297413d = optString;
        this.f297414e = optString.length();
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        this.f297413d = str;
        try {
            this.f297410b.put("text", str);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f297415f = false;
        this.f297416g = false;
        this.f297413d = str;
        JSONObject jSONObject = new JSONObject();
        this.f297410b = jSONObject;
        try {
            jSONObject.put("type", "str");
            this.f297410b.put("text", str);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }
}
