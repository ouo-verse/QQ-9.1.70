package com.tencent.mobileqq.troop.api.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopHandlerServiceImpl implements ITroopHandlerService {
    static IPatchRedirector $redirector_;
    protected AppRuntime mApp;

    public TroopHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerService
    public Bitmap getGroupFaceIcon(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16));
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            return ((ITroopAvatarService) appRuntime.getRuntimeService(ITroopAvatarService.class, "")).getGroupFaceIcon(str, z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerService
    public void handleMemberExit(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            ((com.tencent.mobileqq.troop.onlinepush.api.a) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER)).handleMemberExit(str, str2);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mApp = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopHandlerService
    public void updateGroupIcon(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            ((ITroopAvatarService) appRuntime.getRuntimeService(ITroopAvatarService.class, "")).updateGroupIcon(str, z16);
        }
    }
}
