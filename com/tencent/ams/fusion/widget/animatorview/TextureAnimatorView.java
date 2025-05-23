package com.tencent.ams.fusion.widget.animatorview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig;
import com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateListener;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.render.ITextureAnimatorRender;
import com.tencent.ams.fusion.widget.animatorview.render.TextureAnimatorRender;
import com.tencent.ams.fusion.widget.animatorview.render.v2.TextureAnimatorRenderV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TextureAnimatorView extends TextureView implements TextureView.SurfaceTextureListener, ITextureAnimatorView, IFrameRateConfig {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TextureAnimatorView";
    private final ITextureAnimatorRender mRender;

    public TextureAnimatorView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        init();
        if (AnimatorConfig.getRunRendererVersion() == 2) {
            this.mRender = new TextureAnimatorRenderV2(this);
            Logger.i(TAG, "run with OldSurfaceAnimatorRender");
        } else {
            this.mRender = new TextureAnimatorRender(this);
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
        setOpaque(false);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) animatorLayer);
        } else {
            this.mRender.addLayer(animatorLayer);
            animatorLayer.setCanvasView(this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.mRender.clearCanvas();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void clearLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mRender.clearLayers();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public List<AnimatorLayer> getLayerList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mRender.getLayerList();
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public boolean isUserStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mRender.isUserStarted();
    }

    @Override // android.view.TextureView.SurfaceTextureListener, com.tencent.ams.fusion.widget.animatorview.ITextureAnimatorView
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mRender.onSurfaceTextureAvailable(surfaceTexture, i3, i16);
            this.mRender.renderCreate();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        this.mRender.renderDestroy();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mRender.renderChanged();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceTexture);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void pauseAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mRender.pauseAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) animatorLayer);
        } else {
            this.mRender.removeLayer(animatorLayer);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void resumeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mRender.resumeAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) animatorListener);
        } else {
            this.mRender.setAnimationListener(animatorListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setEnableFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        } else {
            this.mRender.setEnableFrameRate(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setFrameRateListener(IFrameRateListener iFrameRateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) iFrameRateListener);
        } else {
            this.mRender.setFrameRateListener(iFrameRateListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.framerate.IFrameRateConfig
    public void setShowFrameRate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.mRender.setShowFrameRate(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void startAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mRender.startAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.mRender.stopAnimation();
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void stopAnimation(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.mRender.stopAnimation(z16, z17);
        } else {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.IAnimatorView
    public void addLayer(int i3, AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) animatorLayer);
        } else {
            this.mRender.addLayer(i3, animatorLayer);
            animatorLayer.setCanvasView(this);
        }
    }
}
