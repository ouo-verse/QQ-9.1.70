package com.tencent.pts.core.lite;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.jni.PTSLiteJniHandler;

/* loaded from: classes22.dex */
public class PTSLiteBridge {
    static IPatchRedirector $redirector_;
    private final String TAG;

    public PTSLiteBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "PTSLiteBridge";
        }
    }

    public void initAppLiteBundle(String str, PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) pTSAppInstance);
        } else {
            PTSLiteJniHandler.create(pTSAppInstance, str);
        }
    }

    public void setData(PTSItemData pTSItemData, PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSItemData, (Object) pTSAppInstance);
        } else if (pTSItemData != null && pTSAppInstance != null) {
            PTSLiteJniHandler.setData(pTSAppInstance, pTSItemData.getJSONData());
        }
    }

    public String updateData(String str, PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) pTSAppInstance);
        }
        if (str != null && pTSAppInstance != null) {
            return PTSLiteJniHandler.updateData(pTSAppInstance, str);
        }
        return "";
    }
}
