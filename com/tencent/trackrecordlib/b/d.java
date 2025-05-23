package com.tencent.trackrecordlib.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.trackrecordlib.enums.UiActionKey;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private UiActionKey f380945b;

    public d(UiActionKey uiActionKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uiActionKey);
        } else {
            this.f380945b = uiActionKey;
        }
    }

    @Override // com.tencent.trackrecordlib.b.a
    public JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        try {
            UiActionKey uiActionKey = this.f380945b;
            if (uiActionKey != null) {
                this.f380941a.put("code", uiActionKey.getSeq());
            }
            return this.f380941a;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
