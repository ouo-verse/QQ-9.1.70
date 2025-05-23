package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import androidx.annotation.Keep;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.mobileqq.groupvideo.bridgeengine.IQAvSdkCamera;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class QAvSdkCamera implements IQAvSdkCamera {
    static IPatchRedirector $redirector_;

    public QAvSdkCamera() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvSdkCamera
    public void sendCameraFrame(byte[] bArr, int i3, int i16, int i17, int i18, int i19, long j3, boolean z16, float[] fArr, byte[] bArr2, int i26, int i27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Long.valueOf(j3), Boolean.valueOf(z16), fArr, bArr2, Integer.valueOf(i26), Integer.valueOf(i27));
        } else {
            NtrtcVideoRender.getInstance().sendCameraFrame(bArr, i3, i16, i17, i18, i19, j3, z16, fArr, bArr2, i26, i27, 0);
        }
    }
}
