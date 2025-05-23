package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQDynamicAvatarServiceImpl implements IQQDynamicAvatarService {
    static IPatchRedirector $redirector_;
    protected AppRuntime mApp;

    public QQDynamicAvatarServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService
    public boolean isNeed2UpdateSettingInfo(FaceInfo faceInfo, Setting setting, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, faceInfo, setting, Integer.valueOf(i3))).booleanValue();
        }
        return ((DynamicAvatarManager) this.mApp.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).v(faceInfo, setting, i3);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
