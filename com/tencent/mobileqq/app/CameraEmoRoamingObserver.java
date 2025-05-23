package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CameraEmoRoamingObserver implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public CameraEmoRoamingObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void doOnAddEmoResult(int i3, CameraEmotionData cameraEmotionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) cameraEmotionData);
        }
    }

    protected void doOnDeleteEmoResult(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    protected void doOnGetEmoListResult(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    protected void onCameraEmoInsert() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    protected void onCameraEmoSend(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            onCameraEmoSend(z16, ((Integer) obj).intValue());
                            return;
                        }
                        return;
                    }
                    onCameraEmoInsert();
                    return;
                }
                doOnDeleteEmoResult(((Integer) obj).intValue());
                return;
            }
            doOnGetEmoListResult(((Integer) obj).intValue());
            return;
        }
        Object[] objArr = (Object[]) obj;
        doOnAddEmoResult(((Integer) objArr[0]).intValue(), (CameraEmotionData) objArr[1]);
    }
}
