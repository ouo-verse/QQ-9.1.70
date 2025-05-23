package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import androidx.annotation.Keep;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture;
import com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkGraphicRenderMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class QavSdkGraphicRenderMgr implements IQavSdkGraphicRenderMgr {
    static IPatchRedirector $redirector_;

    public QavSdkGraphicRenderMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkGraphicRenderMgr
    public void clearGlRender2Native(String str) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            NtrtcVideoRender.getInstance().setGlRender(str, null);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkGraphicRenderMgr
    public void flushGlRender(String str) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            NtrtcVideoRender.getInstance().flushGlRender(str);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkGraphicRenderMgr
    public void setAccountUin(String str) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            NtrtcVideoRender.getInstance().setAccountUin(str);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQavSdkGraphicRenderMgr
    public void setGlRender2Native(String str, IQAvsdkRenderTexture iQAvsdkRenderTexture) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) iQAvsdkRenderTexture);
        } else if (iQAvsdkRenderTexture != null) {
            NtrtcVideoRender.getInstance().setGlRender(str, ((QAvsdkRenderTexture) iQAvsdkRenderTexture).getNtrtcVideoRenderTexture());
        } else {
            clearGlRender2Native(str);
        }
    }
}
