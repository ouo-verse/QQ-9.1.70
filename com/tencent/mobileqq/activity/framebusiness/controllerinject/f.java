package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f implements a {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (QzoneFrame.class.getName().equals(str)) {
            return true;
        }
        Class<? extends Frame> lebaFrameClass = ((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass();
        if (lebaFrameClass != null && lebaFrameClass.getName().equals(str)) {
            return true;
        }
        return false;
    }
}
