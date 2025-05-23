package com.tencent.aekit.target.gl;

import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SurfaceTextureWrapper implements SurfaceTexture.OnFrameAvailableListener {
    static IPatchRedirector $redirector_;
    private volatile boolean hasImage;
    private int oesTextureId;

    /* renamed from: st, reason: collision with root package name */
    private SurfaceTexture f61812st;
    private Object syncObj;

    public SurfaceTextureWrapper(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.hasImage = false;
        this.syncObj = new Object();
        this.oesTextureId = i3;
    }

    public boolean awaitImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? awaitImage(0L) : ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
    }

    public int getOesTextureId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.oesTextureId;
    }

    public SurfaceTexture getSt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SurfaceTexture) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.f61812st == null) {
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.oesTextureId);
            this.f61812st = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
        }
        return this.f61812st;
    }

    public Object getSyncObj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.syncObj;
    }

    public boolean isHasImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.hasImage;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceTexture);
            return;
        }
        synchronized (this.syncObj) {
            this.hasImage = true;
            this.syncObj.notifyAll();
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        SurfaceTexture surfaceTexture = this.f61812st;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    public void setOesTextureId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.oesTextureId = i3;
        }
    }

    public boolean awaitImage(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, j3)).booleanValue();
        }
        if (!this.hasImage) {
            synchronized (this.syncObj) {
                try {
                    this.syncObj.wait(j3);
                } catch (InterruptedException unused) {
                }
            }
        }
        return this.hasImage;
    }
}
