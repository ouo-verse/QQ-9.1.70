package com.tencent.mobileqq.safe;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.identity.e;
import com.tencent.mobileqq.manager.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements e {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.e
    public void a(@NonNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.e
    public void b(@NonNull c cVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("anti_theft_url");
            String optString2 = jSONObject.optString("safe_protect_url");
            cVar.b(optString);
            cVar.c(optString2);
        } catch (JSONException e16) {
            QLog.d("LoginInfoSafeEntrance", 1, "onParsed JSONException : ", e16);
        }
    }
}
