package com.tencent.gdtad.basics.adshake.animatorview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.gdtad.basics.adshake.animatorview.render.IAnimatorRender;
import com.tencent.gdtad.basics.adshake.animatorview.render.SurfaceAnimatorRender;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AnimatorView extends SurfaceView implements SurfaceHolder.Callback, IAnimatorView {
    private static final String TAG = "AnimatorView";
    private final IAnimatorRender mRender;

    public AnimatorView(Context context) {
        super(context);
        init();
        this.mRender = new SurfaceAnimatorRender(this);
    }

    private void init() {
        setZOrderOnTop(true);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-2);
        holder.addCallback(this);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void addLayer(AnimatorLayer animatorLayer) {
        this.mRender.addLayer(animatorLayer);
        animatorLayer.setCanvasView(this);
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

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void pauseAnimation() {
        QLog.d(TAG, 1, "pauseAnimation");
        this.mRender.pauseAnimation();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void removeLayer(AnimatorLayer animatorLayer) {
        this.mRender.removeLayer(animatorLayer);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void resumeAnimation() {
        QLog.d(TAG, 1, "resumeAnimation");
        this.mRender.resumeAnimation();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.mRender.setAnimationListener(animatorListener);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void startAnimation() {
        QLog.d(TAG, 1, QZoneJsConstants.ACTION_START_ANIMATION);
        this.mRender.startAnimation();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void stopAnimation() {
        QLog.d(TAG, 1, "stopAnimation");
        this.mRender.stopAnimation();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        QLog.d(TAG, 1, "surfaceChanged width:" + i16 + ", height:" + i17);
        this.mRender.renderChanged();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        QLog.d(TAG, 1, "surfaceCreated");
        this.mRender.renderCreate();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        QLog.d(TAG, 1, "surfaceDestroyed");
        this.mRender.renderDestroy();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void addLayer(int i3, AnimatorLayer animatorLayer) {
        this.mRender.addLayer(i3, animatorLayer);
        animatorLayer.setCanvasView(this);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.IAnimatorView
    public void stopAnimation(boolean z16, boolean z17) {
        QLog.d(TAG, 1, "stopAnimation clearCanvas:" + z16 + ", isUserStop:" + z17);
        this.mRender.stopAnimation(z16, z17);
    }
}
