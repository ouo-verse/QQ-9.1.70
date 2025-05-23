package com.tencent.ams.fusion.widget.animatorview.render;

import android.graphics.Canvas;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OldSurfaceAnimatorRender extends OldBaseAnimatorRender<SurfaceView> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "OldSurfaceAnimatorRender";
    private final SurfaceHolder mHolder;

    public OldSurfaceAnimatorRender(SurfaceView surfaceView) {
        super(surfaceView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) surfaceView);
        } else {
            this.mHolder = surfaceView.getHolder();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.OldBaseAnimatorRender
    protected Canvas lockCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Canvas) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Canvas canvas = null;
        if (this.mHolder == null) {
            return null;
        }
        if (AnimatorConfig.isEnableHardware() && Build.VERSION.SDK_INT >= 26) {
            canvas = this.mHolder.lockHardwareCanvas();
        }
        if (canvas == null) {
            return this.mHolder.lockCanvas();
        }
        return canvas;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setEnableFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setFrameRateListener(IFrameRateListener iFrameRateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iFrameRateListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setShowFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.OldBaseAnimatorRender
    protected void unlockCanvasAndPost(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        SurfaceHolder surfaceHolder = this.mHolder;
        if (surfaceHolder == null) {
            return;
        }
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
}
