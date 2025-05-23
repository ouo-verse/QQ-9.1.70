package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import androidx.annotation.Keep;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.mobileqq.groupvideo.bridgeengine.IQAvSdkVideoFrame2GLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class QAvSdkVideoFrame2GLRender implements IQAvSdkVideoFrame2GLRender {
    static IPatchRedirector $redirector_;

    public QAvSdkVideoFrame2GLRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvSdkVideoFrame2GLRender
    public void sendVideoFrame2GLRender(String str, int i3, byte[] bArr, int i16, int i17, int i18, int i19, int i26, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Long.valueOf(j3));
        } else {
            NtrtcVideoRender.getInstance().sendDecodeFrame2GLRender(str, i3, bArr, i17, i18, i19);
        }
    }
}
