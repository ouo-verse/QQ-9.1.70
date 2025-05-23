package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarHandlerServiceImpl implements IQQAvatarHandlerService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "IQQAvatarHandlerServiceImpl";
    AppInterface mApp;
    AvatarHandler mAvatarHandler;

    public QQAvatarHandlerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public boolean checkOutsideDynamicAvatarEnable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getApolloHead(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.K2(str);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public String getChoosedIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            return avatarHandler.P2();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public String getChoosedStrangerGroupIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            return avatarHandler.Q2();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getCustomHead(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.S2(str);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getMobileQQHead(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.U2(str);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getQCallHead(String str, int i3, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Byte.valueOf(b16), Byte.valueOf(b17));
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.W2(str, i3, b16, b17);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getStrangerHead(String str, int i3, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Byte.valueOf(b16), Byte.valueOf(b17));
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.d3(str, i3, b16, b17);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getTroopHead(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.e3(str);
        }
    }

    void initAvatarHandler() {
        this.mAvatarHandler = (AvatarHandler) this.mApp.getBusinessHandler(QQAvatarHandlerApiImpl.MESSAGE_HANDLER);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void notifySyncQQHead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.s3();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = (AppInterface) appRuntime;
            initAvatarHandler();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void sendBroadCastHeadChanged(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) str);
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.y3(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getApolloHead(String str, byte b16, byte b17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Byte.valueOf(b16), Byte.valueOf(b17), Integer.valueOf(i3));
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.L2(str, b16, b17, i3);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getCustomHead(String str, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.T2(str, b16, b17);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getMobileQQHead(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Byte.valueOf(b16));
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.V2(str, b16);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getTroopHead(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Byte.valueOf(b16));
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.f3(str, b16);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService
    public void getCustomHead(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) faceInfo);
            return;
        }
        if (this.mAvatarHandler == null) {
            initAvatarHandler();
        }
        AvatarHandler avatarHandler = this.mAvatarHandler;
        if (avatarHandler != null) {
            avatarHandler.R2(faceInfo);
        }
    }
}
