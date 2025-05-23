package com.tencent.ams.fusion.widget.animatorview.render;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TextureAnimatorRender extends BaseAnimatorRender<TextureView> implements ITextureAnimatorRender {
    static IPatchRedirector $redirector_;
    private Rect mInOutDirty;
    private Surface mSurface;

    public TextureAnimatorRender(TextureView textureView) {
        super(textureView);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) textureView);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.BaseAnimatorRender
    protected boolean isSurfaceValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Surface surface = this.mSurface;
        if (surface != null && surface.isValid()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.BaseAnimatorRender
    protected Canvas lockCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Canvas) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Surface surface = this.mSurface;
        if (surface == null) {
            return null;
        }
        return surface.lockCanvas(this.mInOutDirty);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.ITextureAnimatorView
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mSurface = new Surface(surfaceTexture);
            this.mInOutDirty = new Rect(0, 0, i3, i16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.render.BaseAnimatorRender
    protected void unlockCanvasAndPost(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Surface surface = this.mSurface;
        if (surface == null) {
            return;
        }
        surface.unlockCanvasAndPost(canvas);
    }
}
