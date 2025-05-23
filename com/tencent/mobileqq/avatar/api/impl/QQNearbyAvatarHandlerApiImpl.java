package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.app.face.FaceHandler;
import com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQNearbyAvatarHandlerApiImpl implements IQQNearbyAvatarHandlerApi {
    static IPatchRedirector $redirector_;

    public QQNearbyAvatarHandlerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerApi
    public String getClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return FaceHandler.class.getName();
    }
}
