package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FaceObserver implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public FaceObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onGetFaceInfo(boolean z16, FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), faceInfo);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        FaceInfo faceInfo = null;
        if (i3 == 0) {
            if (obj != null) {
                faceInfo = (FaceInfo) obj;
            }
            onUpdateStrangerHead(z16, faceInfo);
        } else if (i3 == 1) {
            if (obj != null) {
                faceInfo = (FaceInfo) obj;
            }
            onGetFaceInfo(z16, faceInfo);
        }
    }

    public void onUpdateStrangerHead(boolean z16, FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), faceInfo);
        }
    }
}
