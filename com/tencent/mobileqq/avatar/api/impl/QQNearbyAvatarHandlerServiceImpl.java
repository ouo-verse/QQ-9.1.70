package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceHandler;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQNearbyAvatarHandlerServiceImpl implements IQQNearbyAvatarHandlerService {
    static IPatchRedirector $redirector_;
    AppInterface mApp;
    FaceHandler mNearbyAvatarHandler;

    public QQNearbyAvatarHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerService
    public void getStrangerFaceInfo(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) faceInfo);
            return;
        }
        if (this.mNearbyAvatarHandler == null) {
            initNearbyAvatarHandler();
        }
        FaceHandler faceHandler = this.mNearbyAvatarHandler;
        if (faceHandler != null) {
            faceHandler.G2(faceInfo);
        }
    }

    void initNearbyAvatarHandler() {
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            this.mNearbyAvatarHandler = (FaceHandler) appInterface.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else if (appRuntime instanceof AppInterface) {
            this.mApp = (AppInterface) appRuntime;
            initNearbyAvatarHandler();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
