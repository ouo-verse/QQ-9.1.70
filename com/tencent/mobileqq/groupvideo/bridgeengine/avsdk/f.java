package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import com.tencent.avcore.jni.NtrtcVideoRenderTexture;
import com.tencent.avcore.jni.render.IGLRenderTexture;
import com.tencent.mobileqq.groupvideo.bridgeengine.IGLRenderTextureListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.SoLoadUtil;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f implements IGLRenderTexture {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final NtrtcVideoRenderTexture f213741a;

    /* renamed from: b, reason: collision with root package name */
    private IGLRenderTextureListener f213742b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            SoLoadUtil.m(MobileQQ.sMobileQQ, "xplatform", 0, false);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        NtrtcVideoRenderTexture ntrtcVideoRenderTexture = new NtrtcVideoRenderTexture(this);
        this.f213741a = ntrtcVideoRenderTexture;
        try {
            ntrtcVideoRenderTexture.init(tv.c.c(MobileQQ.sMobileQQ), new WeakReference(ntrtcVideoRenderTexture), 0L);
        } catch (Error | Exception e16) {
            e16.printStackTrace();
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.f213741a.canRender();
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f213741a.flush(z16);
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.f213741a.getCaptureFrameHeight();
    }

    public byte[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (byte[]) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f213741a.getCaptureFrameTexture();
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.f213741a.getCaptureFrameWidth();
    }

    public byte[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (byte[]) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f213741a.getFaceFeature();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.f213741a.getImgAngle();
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.f213741a.getImgHeight();
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f213741a.getImgWidth();
    }

    public NtrtcVideoRenderTexture j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (NtrtcVideoRenderTexture) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f213741a;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f213741a.onPause();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f213741a.onResume();
        }
    }

    public void m(IGLRenderTextureListener iGLRenderTextureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iGLRenderTextureListener);
        } else {
            this.f213742b = iGLRenderTextureListener;
        }
    }

    @Override // com.tencent.avcore.jni.render.IGLRenderTexture
    public void markForPerf(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        IGLRenderTextureListener iGLRenderTextureListener = this.f213742b;
        if (iGLRenderTextureListener != null) {
            iGLRenderTextureListener.markForPerf(i3);
        }
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.f213741a.updateCurFrame();
    }

    @Override // com.tencent.avcore.jni.render.IGLRenderTexture
    public void nativeFrameDataUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        IGLRenderTextureListener iGLRenderTextureListener = this.f213742b;
        if (iGLRenderTextureListener != null) {
            iGLRenderTextureListener.nativeFrameDataUpdate();
        }
    }

    public int o(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) iArr)).intValue();
        }
        return this.f213741a.uploadContent(iArr);
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onFaceFeatureUpdate(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr);
        } else {
            this.f213742b.onFaceFeatureUpdate(bArr);
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        IGLRenderTextureListener iGLRenderTextureListener = this.f213742b;
        if (iGLRenderTextureListener != null) {
            iGLRenderTextureListener.onRenderFlush();
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IGLRenderTextureListener iGLRenderTextureListener = this.f213742b;
        if (iGLRenderTextureListener != null) {
            iGLRenderTextureListener.onRenderFrame();
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderInfoNotify(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        IGLRenderTextureListener iGLRenderTextureListener = this.f213742b;
        if (iGLRenderTextureListener != null) {
            iGLRenderTextureListener.onRenderInfoNotify(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.avcore.jni.render.GLRenderListener
    public void onRenderReset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        IGLRenderTextureListener iGLRenderTextureListener = this.f213742b;
        if (iGLRenderTextureListener != null) {
            iGLRenderTextureListener.onRenderReset();
        }
    }
}
