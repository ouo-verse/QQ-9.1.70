package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import androidx.annotation.Keep;
import com.tencent.avcore.jni.NtrtcVideoRenderTexture;
import com.tencent.mobileqq.groupvideo.bridgeengine.IGLRenderTextureListener;
import com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class QAvsdkRenderTexture implements IQAvsdkRenderTexture {
    static IPatchRedirector $redirector_;
    private final f mRenderTextureJniDelegate;

    public QAvsdkRenderTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRenderTextureJniDelegate = new f();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public boolean canRender() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.mRenderTextureJniDelegate.a();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public void flush(boolean z16) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mRenderTextureJniDelegate.b(z16);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public int getCaptureFrameHeight() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mRenderTextureJniDelegate.c();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public byte[] getCaptureFrameTexture() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (byte[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mRenderTextureJniDelegate.d();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public int getCaptureFrameWidth() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mRenderTextureJniDelegate.e();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public byte[] getFaceFeature() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (byte[]) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mRenderTextureJniDelegate.f();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public byte[] getFrameTexture() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (byte[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public int getImgAngle() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mRenderTextureJniDelegate.g();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public int getImgHeight() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mRenderTextureJniDelegate.h();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public int getImgWidth() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mRenderTextureJniDelegate.i();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public long getNativeContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.mRenderTextureJniDelegate.j().getNativeContext();
    }

    public NtrtcVideoRenderTexture getNtrtcVideoRenderTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (NtrtcVideoRenderTexture) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mRenderTextureJniDelegate.j();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public void init(int i3, Object obj, long j3) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), obj, Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public void onPause() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mRenderTextureJniDelegate.k();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public void onResume() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mRenderTextureJniDelegate.l();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public void setIGLRenderTextureListener(IGLRenderTextureListener iGLRenderTextureListener) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) iGLRenderTextureListener);
        } else {
            this.mRenderTextureJniDelegate.m(iGLRenderTextureListener);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public void unInit() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mRenderTextureJniDelegate.j().uninit();
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public boolean updateCurFrame() throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.mRenderTextureJniDelegate.n();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IQAvsdkRenderTexture
    public int uploadContent(int[] iArr) throws NoSuchMethodException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) iArr)).intValue();
        }
        return this.mRenderTextureJniDelegate.o(iArr);
    }
}
