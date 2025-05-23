package com.tencent.trackrecordlib.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.enums.UiActionScreenRotation;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private UiActionScreenRotation f380949b;

    public g(UiActionScreenRotation uiActionScreenRotation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uiActionScreenRotation);
        } else {
            this.f380949b = uiActionScreenRotation;
        }
    }

    @Override // com.tencent.trackrecordlib.b.a
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            UiActionScreenRotation uiActionScreenRotation = this.f380949b;
            if (uiActionScreenRotation != null) {
                this.f380941a.put("orention", uiActionScreenRotation.getSeq());
            }
            return this.f380941a;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
