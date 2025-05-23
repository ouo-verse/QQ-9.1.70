package com.tencent.mobileqq.qqlive.trtc.video.videoprocess;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame;
import com.tencent.trtc.TRTCCloudDef;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b extends QQLiveVideoBaseFrame {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private TRTCCloudDef.TRTCVideoFrame f273420a;

    public b(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tRTCVideoFrame);
        } else {
            this.f273420a = tRTCVideoFrame;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = this.f273420a;
        if (tRTCVideoFrame != null) {
            return tRTCVideoFrame.height;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame
    public int getTextureId() {
        TRTCCloudDef.TRTCTexture tRTCTexture;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = this.f273420a;
        if (tRTCVideoFrame != null && (tRTCTexture = tRTCVideoFrame.texture) != null) {
            return tRTCTexture.textureId;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame
    public int getVideoFrameType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = this.f273420a;
        if (tRTCVideoFrame != null) {
            return tRTCVideoFrame.width;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.data.trtc.QQLiveVideoBaseFrame
    public void setTextureId(int i3) {
        TRTCCloudDef.TRTCTexture tRTCTexture;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = this.f273420a;
        if (tRTCVideoFrame != null && (tRTCTexture = tRTCVideoFrame.texture) != null) {
            tRTCTexture.textureId = i3;
        }
    }
}
