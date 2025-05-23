package com.tencent.qimei.z;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a<T> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            return new JSONObject(str).optString(str2);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
