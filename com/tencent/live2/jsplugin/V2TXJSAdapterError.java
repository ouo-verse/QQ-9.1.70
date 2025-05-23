package com.tencent.live2.jsplugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TXJSAdapterError {
    static IPatchRedirector $redirector_;
    public int errorCode;
    public String errorInfo;
    public Map<String, Object> resultMap;

    public V2TXJSAdapterError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.errorCode = 0;
        this.errorInfo = "Success";
        this.resultMap = null;
    }

    public V2TXJSAdapterError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        this.resultMap = null;
        this.errorCode = i3;
        this.errorInfo = str;
    }

    public V2TXJSAdapterError(int i3, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) map);
            return;
        }
        this.errorInfo = "Success";
        this.errorCode = i3;
        this.resultMap = map;
    }
}
