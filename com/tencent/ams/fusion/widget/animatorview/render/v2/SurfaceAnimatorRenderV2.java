package com.tencent.ams.fusion.widget.animatorview.render.v2;

import android.graphics.Canvas;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SurfaceAnimatorRenderV2 extends BaseAnimatorRenderV2<SurfaceView> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SurfaceAnimatorRender";
    private final SurfaceHolder mHolder;

    public SurfaceAnimatorRenderV2(SurfaceView surfaceView) {
        super(surfaceView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) surfaceView);
        } else {
            this.mHolder = surfaceView.getHolder();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.v2.BaseAnimatorRenderV2
    protected boolean isSurfaceValid() {
        Surface surface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        SurfaceHolder surfaceHolder = this.mHolder;
        if (surfaceHolder != null && (surface = surfaceHolder.getSurface()) != null) {
            return surface.isValid();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.v2.BaseAnimatorRenderV2
    protected Canvas lockCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Canvas) iPatchRedirector.redirect((short) 3, (Object) this);
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

    @Override // com.tencent.ams.fusion.widget.animatorview.render.v2.BaseAnimatorRenderV2
    protected void unlockCanvasAndPost(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        SurfaceHolder surfaceHolder = this.mHolder;
        if (surfaceHolder != null && canvas != null) {
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
