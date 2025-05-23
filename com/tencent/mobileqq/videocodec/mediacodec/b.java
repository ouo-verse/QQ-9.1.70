package com.tencent.mobileqq.videocodec.mediacodec;

import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.a;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.c;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.h;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    private h f312528e0;

    /* renamed from: f0, reason: collision with root package name */
    private com.tencent.mobileqq.videocodec.mediacodec.recorder.b f312529f0;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.a
    public boolean c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean m3 = this.f312521d.m();
        com.tencent.mobileqq.videocodec.mediacodec.recorder.b bVar = this.f312529f0;
        if (bVar != null && !bVar.b()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoderWithAudio", 2, "startEncode,", Boolean.valueOf(m3), " ", Boolean.valueOf(z16));
        }
        if (!m3 || !z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.a
    public void g(DecodeConfig decodeConfig, c cVar, com.tencent.mobileqq.videocodec.mediacodec.recorder.c cVar2, a.InterfaceC8954a interfaceC8954a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, decodeConfig, cVar, cVar2, interfaceC8954a);
            return;
        }
        try {
            h hVar = new h(this, cVar.f312558c, cVar2);
            this.f312528e0 = hVar;
            cVar.f312575t = hVar;
            this.f312529f0 = new com.tencent.mobileqq.videocodec.mediacodec.recorder.b(decodeConfig, this.f312528e0);
        } catch (Exception e16) {
            QLog.e("Mp4ReEncoderWithAudio", 1, "startEncode,", e16);
        }
        super.g(decodeConfig, cVar, cVar2, interfaceC8954a);
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.a, com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener
    public void onDecodeFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDecodeFinish();
        try {
            com.tencent.mobileqq.videocodec.mediacodec.recorder.b bVar = this.f312529f0;
            if (bVar != null) {
                bVar.d();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.a, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceTexture);
            return;
        }
        super.onFrameAvailable(surfaceTexture);
        com.tencent.mobileqq.videocodec.mediacodec.recorder.b bVar = this.f312529f0;
        if (bVar != null) {
            bVar.c();
        }
    }
}
