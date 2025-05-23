package com.tencent.gdtad.basics.adshake.animatorview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.render.IAnimatorRender;
import com.tencent.gdtad.basics.adshake.animatorview.render.TextureAnimatorRender;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TextureAnimatorView extends TextureView implements TextureView.SurfaceTextureListener, IAnimatorView {
    private static final int DEFAULT_FRAME_STEP = 16;
    private static final String TAG = "TextureAnimatorView";
    private final IAnimatorRender mRender;

    public TextureAnimatorView(Context context) {
        super(context);
        init();
        this.mRender = new TextureAnimatorRender(this);
    }

    private void init() {
        setSurfaceTextureListener(this);
        setOpaque(false);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        this.mRender.addLayer(animatorLayer);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void clearCanvas() {
        this.mRender.clearCanvas();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void clearLayers() {
        this.mRender.clearLayers();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public boolean isUserStarted() {
        return this.mRender.isUserStarted();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.mRender.renderCreate();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mRender.renderDestroy();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.mRender.renderChanged();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void pauseAnimation() {
        this.mRender.pauseAnimation();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        this.mRender.removeLayer(animatorLayer);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void resumeAnimation() {
        this.mRender.resumeAnimation();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.mRender.setAnimationListener(animatorListener);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void startAnimation() {
        this.mRender.startAnimation();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void stopAnimation() {
        this.mRender.stopAnimation();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void addLayer(int i3, AnimatorLayer animatorLayer) {
        this.mRender.addLayer(i3, animatorLayer);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void stopAnimation(boolean z16, boolean z17) {
        this.mRender.stopAnimation(z16, z17);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
