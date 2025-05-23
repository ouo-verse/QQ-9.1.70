package com.tencent.lbssearch.httpresponse;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class BaseObject extends JsonComposer {
    static IPatchRedirector $redirector_;
    public Exception exception;
    public String message;
    public String request_id;
    public int status;

    public BaseObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean isStatusOk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.status == 0) {
            return true;
        }
        return false;
    }
}
