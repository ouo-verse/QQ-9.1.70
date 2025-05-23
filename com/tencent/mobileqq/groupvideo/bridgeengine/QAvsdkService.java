package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.QAvSdkCamera;
import com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.QAvSdkVideoFrame2GLRender;
import com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.QAvsdkRenderTexture;
import com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.QavSdkGraphicRenderMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class QAvsdkService implements IQAvsdkService {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private final com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.c mGroupVideoQavSdk;
    private IQAvSdkCamera mIQAvSdkCamera;
    private IQAvSdkVideoFrame2GLRender mIQAvSdkVideoFrame2GLRender;
    private IQavSdkGraphicRenderMgr mIQavSdkGraphicRenderMgr;
    private IQavSdkMultiOperator mIQavSdkMultiOperator;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24541);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        TAG = com.tencent.mobileqq.groupvideo.config.a.a() + "QAvsdkService";
    }

    public QAvsdkService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mGroupVideoQavSdk = new com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.c();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public IQAvsdkRenderTexture create() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IQAvsdkRenderTexture) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new QAvsdkRenderTexture();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public IQavSdkMultiOperator getMultiOperator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IQavSdkMultiOperator) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mIQavSdkMultiOperator;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public IQAvSdkCamera getQAvSdkCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IQAvSdkCamera) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mIQAvSdkCamera;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public IQAvSdkVideoFrame2GLRender getQAvSdkVideoFrame2GLRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IQAvSdkVideoFrame2GLRender) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mIQAvSdkVideoFrame2GLRender;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public IQavSdkGraphicRenderMgr getQavSdkGraphicRenderMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IQavSdkGraphicRenderMgr) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mIQavSdkGraphicRenderMgr;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public void initQavSdk(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        String str = TAG;
        QLog.i(str, 1, "initQavSdk start id: " + j3 + " appId:" + i3);
        this.mGroupVideoQavSdk.d(j3);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initQavSdk end id: ");
        sb5.append(j3);
        QLog.i(str, 1, sb5.toString());
        this.mIQavSdkMultiOperator = new com.tencent.mobileqq.groupvideo.bridgeengine.avsdk.e(i3, "" + j3);
        this.mIQAvSdkCamera = new QAvSdkCamera();
        this.mIQavSdkGraphicRenderMgr = new QavSdkGraphicRenderMgr();
        this.mIQAvSdkVideoFrame2GLRender = new QAvSdkVideoFrame2GLRender();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public void registerObserver(IQavMultiObserverProxy iQavMultiObserverProxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iQavMultiObserverProxy);
        } else {
            this.mGroupVideoQavSdk.e(iQavMultiObserverProxy);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public void setAudioRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mGroupVideoQavSdk.f();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkService
    public void unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mGroupVideoQavSdk.g();
        }
    }
}
