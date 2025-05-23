package com.tencent.ams.fusion.widget.cny2025.flip;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.FrameLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.flip.FlipView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameAnimFlipView extends FlipView {
    static IPatchRedirector $redirector_ = null;
    protected static final long DURATION_ENTRANCE_ALPHA = 167;
    private static final long FLIP_ANIM_DURATION = 1625;
    private static final int FLIP_ANIM_SIZE_PX;
    private static final int MARGIN_BOTTOM_ARROW_PX;
    private static final int MARGIN_BOTTOM_FLIP_ANIM_PX;
    private static final String TAG = "FrameAnimFlipView";
    private int mDelayShowDuration;
    private Bitmap[] mFlipFrameIcons;
    private FrameLayer mFlipFrameLayer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class FlipFrameLayer extends FrameLayer {
        static IPatchRedirector $redirector_;

        public FlipFrameLayer(Bitmap[] bitmapArr) {
            super(bitmapArr);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitmapArr);
            } else {
                setAnimator(new FlipFrameProgressAnimator(this, 0.0f, 1.0f).setDuration(FrameAnimFlipView.FLIP_ANIM_DURATION).setRepeatCount(0));
            }
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.layer.FrameLayer
        protected int getCurrentIndex() {
            int round;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            Bitmap[] frameBitmaps = getFrameBitmaps();
            if (frameBitmaps == null || frameBitmaps.length == 0 || getAnimator() == null) {
                return 0;
            }
            float layerProgress = getLayerProgress();
            int length = frameBitmaps.length / 2;
            if (layerProgress < 0.0f || layerProgress > 1.0f) {
                return 0;
            }
            if (layerProgress <= 0.25f) {
                return Math.round((length * (0.25f - layerProgress)) / 0.25f);
            }
            double d16 = layerProgress;
            if (d16 > 0.25d && d16 <= 0.5d) {
                return Math.round((length * (layerProgress - 0.25f)) / 0.25f);
            }
            if (d16 > 0.5d && d16 <= 0.75d) {
                round = Math.round((length * (layerProgress - 0.5f)) / 0.25f);
            } else {
                round = Math.round((length * (1.0f - layerProgress)) / 0.25f);
            }
            return length + round;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class FlipFrameProgressAnimator extends ProgressAnimator {
        static IPatchRedirector $redirector_;
        private static TimeInterpolator step1;
        private static TimeInterpolator step2;
        private static TimeInterpolator step3;
        private static TimeInterpolator step4;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54513);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            try {
                step1 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
                step2 = new PathInterpolator(0.33f, 0.0f, 0.83f, 0.83f);
                step3 = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
                step4 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            } catch (Throwable unused) {
            }
        }

        public FlipFrameProgressAnimator(AnimatorLayer animatorLayer, float f16, float f17) {
            super(animatorLayer, f16, f17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        private float getInterpolationProgress(float f16, TimeInterpolator timeInterpolator) {
            if (timeInterpolator == null) {
                return f16;
            }
            return timeInterpolator.getInterpolation(f16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator
        public float computeProgress() {
            float f16;
            float interpolationProgress;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            float progress = getProgress();
            double d16 = progress;
            if (d16 <= 0.25d) {
                return getInterpolationProgress(progress / 0.25f, step1) * 0.25f;
            }
            if (d16 <= 0.5d) {
                return (getInterpolationProgress((progress - 0.25f) / 0.25f, step2) * 0.25f) + 0.25f;
            }
            if (d16 <= 0.75d) {
                f16 = 0.5f;
                interpolationProgress = getInterpolationProgress((progress - 0.5f) / 0.25f, step3);
            } else {
                f16 = 0.75f;
                interpolationProgress = getInterpolationProgress((progress - 0.75f) / 0.25f, step4);
            }
            return (interpolationProgress * 0.25f) + f16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        FLIP_ANIM_SIZE_PX = (int) Utils.dp2px(106.0f);
        MARGIN_BOTTOM_FLIP_ANIM_PX = (int) Utils.dp2px(118.0f);
        MARGIN_BOTTOM_ARROW_PX = (int) Utils.dp2px(171.0f);
    }

    public FrameAnimFlipView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private FrameLayer createFlipIcon() {
        FlipFrameLayer flipFrameLayer = new FlipFrameLayer(this.mFlipFrameIcons);
        int i3 = FLIP_ANIM_SIZE_PX;
        flipFrameLayer.setWidth(i3);
        flipFrameLayer.setHeight(i3);
        int height = (getHeight() - MARGIN_BOTTOM_FLIP_ANIM_PX) - (i3 / 2);
        flipFrameLayer.setCenterX((int) (getWidth() / 2.0f));
        flipFrameLayer.setCenterY(height);
        return flipFrameLayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleIconBitmaps(Bitmap[] bitmapArr) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap[] bitmapArr2 = new Bitmap[bitmapArr.length];
        for (int i3 = 0; i3 < bitmapArr.length; i3++) {
            Bitmap bitmap = bitmapArr[i3];
            int i16 = FLIP_ANIM_SIZE_PX;
            bitmapArr2[i3] = Utils.scaleBitmapSafe(bitmap, i16, i16);
        }
        Logger.i(TAG, "setIconBitmapArray scale icon finish, cost:" + (System.currentTimeMillis() - currentTimeMillis));
        this.mFlipFrameIcons = bitmapArr2;
        AnimatorView animatorView = this.mAnimatorView;
        if (animatorView != null) {
            animatorView.postOnAnimation(new Runnable(bitmapArr2) { // from class: com.tencent.ams.fusion.widget.cny2025.flip.FrameAnimFlipView.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bitmap[] val$scaledBitmaps;

                {
                    this.val$scaledBitmaps = bitmapArr2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FrameAnimFlipView.this, (Object) bitmapArr2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        FrameLayer frameLayer = FrameAnimFlipView.this.mFlipFrameLayer;
                        if (frameLayer != null) {
                            frameLayer.setFrameBitmaps(this.val$scaledBitmaps);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    private void setupLayersDelayShow() {
        this.mTitleTextLayer.postAlpha(0);
        this.mLeftArrowBgLayer.setAlphaFactor(0.0f);
        this.mRightArrowBgLayer.setAlphaFactor(0.0f);
        this.mLeftArrowFrontLayer.setAlphaFactor(0.0f);
        this.mRightArrowFrontLayer.setAlphaFactor(0.0f);
        this.mFlipFrameLayer.postAlpha(0);
        ProgressAnimator progressAnimator = new ProgressAnimator(this.mTitleTextLayer, 0.0f, 1.0f) { // from class: com.tencent.ams.fusion.widget.cny2025.flip.FrameAnimFlipView.4
            static IPatchRedirector $redirector_;

            {
                super(r6, r7, r8);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, FrameAnimFlipView.this, r6, Float.valueOf(r7), Float.valueOf(r8));
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator
            public float computeProgress() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
                }
                float computeProgress = super.computeProgress();
                Logger.d(FrameAnimFlipView.TAG, "delay progress: " + computeProgress);
                int i3 = (int) (255.0f * computeProgress);
                ((FlipView) FrameAnimFlipView.this).mTitleTextLayer.postAlpha(i3);
                FrameAnimFlipView.this.mFlipFrameLayer.postAlpha(i3);
                ((FlipView) FrameAnimFlipView.this).mLeftArrowBgLayer.setAlphaFactor(computeProgress);
                ((FlipView) FrameAnimFlipView.this).mRightArrowBgLayer.setAlphaFactor(computeProgress);
                ((FlipView) FrameAnimFlipView.this).mLeftArrowFrontLayer.setAlphaFactor(computeProgress);
                ((FlipView) FrameAnimFlipView.this).mRightArrowFrontLayer.setAlphaFactor(computeProgress);
                return computeProgress;
            }
        };
        progressAnimator.setPathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        progressAnimator.setStartDelay(this.mDelayShowDuration);
        progressAnimator.setDuration(DURATION_ENTRANCE_ALPHA);
        this.mTitleTextLayer.setAnimator(progressAnimator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float switchInteractProgressToAnimProgress(float f16) {
        if (f16 < 0.0f) {
            return 0.25f - ((f16 + 1.0f) * 0.25f);
        }
        return (f16 * 0.25f) + 0.5f;
    }

    @Override // com.tencent.ams.fusion.widget.flip.FlipView
    protected GroupLayer createGroupLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (GroupLayer) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        this.mBgShaderLayer = createBgShaderLayer();
        this.mTitleTextLayer = createTitleTextLayer();
        this.mSubtitleTextLayer = createSubTitleTextLayer();
        this.mLeftArrowBgLayer = createLeftArrow();
        this.mRightArrowBgLayer = createRightArrow();
        this.mLeftArrowFrontLayer = createLeftArrow();
        this.mRightArrowFrontLayer = createRightArrow();
        this.mLeftArrowBgLayer.postProgress(1.0f);
        this.mRightArrowBgLayer.postProgress(1.0f);
        this.mLeftArrowFrontLayer.postProgress(0.0f);
        this.mRightArrowFrontLayer.postProgress(0.0f);
        this.mFlipFrameLayer = createFlipIcon();
        if (this.mDelayShowDuration > 0) {
            setupLayersDelayShow();
        }
        return new GroupLayer(this.mBgShaderLayer, this.mTitleTextLayer, this.mSubtitleTextLayer, this.mLeftArrowBgLayer, this.mRightArrowBgLayer, this.mLeftArrowFrontLayer, this.mRightArrowFrontLayer, this.mFlipFrameLayer);
    }

    @Override // com.tencent.ams.fusion.widget.flip.FlipView
    protected int getArrowShapeLayerCenterY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return getHeight() - MARGIN_BOTTOM_ARROW_PX;
    }

    @Override // com.tencent.ams.fusion.widget.flip.FlipView
    protected int getLeftArrowShapeLayerCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return (int) (((getWidth() / 2.0f) - (FLIP_ANIM_SIZE_PX / 2)) - (this.WIDTH_ARROW_PX / 2));
    }

    @Override // com.tencent.ams.fusion.widget.flip.FlipView
    protected int getRightArrowShapeLayerCenterX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return (int) ((getWidth() / 2.0f) + (FLIP_ANIM_SIZE_PX / 2) + (this.WIDTH_ARROW_PX / 2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.flip.FlipView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        Logger.i(TAG, MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED);
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.mIsUserStarted && !this.mIsInteractFinished && this.mIsInteractStart) {
            Logger.i(TAG, "onSizeChanged: interact started");
            tryStopEntranceAnimation();
        }
    }

    @Override // com.tencent.ams.fusion.widget.flip.FlipView
    protected void postUpdateProgress(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mAnimatorView.postOnAnimation(new Runnable(f17) { // from class: com.tencent.ams.fusion.widget.cny2025.flip.FrameAnimFlipView.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ float val$progress;

                {
                    this.val$progress = f17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, FrameAnimFlipView.this, Float.valueOf(f17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.val$progress >= 0.0f) {
                        ((FlipView) FrameAnimFlipView.this).mRightArrowFrontLayer.postProgress(this.val$progress);
                        ((FlipView) FrameAnimFlipView.this).mLeftArrowFrontLayer.postProgress(0.0f);
                    } else {
                        ((FlipView) FrameAnimFlipView.this).mRightArrowFrontLayer.postProgress(0.0f);
                        ((FlipView) FrameAnimFlipView.this).mLeftArrowFrontLayer.postProgress(-this.val$progress);
                    }
                    FrameAnimFlipView.this.mFlipFrameLayer.postProgress(FrameAnimFlipView.this.switchInteractProgressToAnimProgress(this.val$progress));
                }
            });
        }
    }

    public void setDelayShowDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mDelayShowDuration = i3;
        }
    }

    public void setIconBitmapArray(Bitmap[] bitmapArr) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmapArr);
            return;
        }
        if (bitmapArr != null && bitmapArr.length > 0 && (bitmap = bitmapArr[0]) != null) {
            if (bitmap.getWidth() == FLIP_ANIM_SIZE_PX) {
                this.mFlipFrameIcons = bitmapArr;
            } else {
                Utils.runOnAsyncThread(new Runnable(bitmapArr) { // from class: com.tencent.ams.fusion.widget.cny2025.flip.FrameAnimFlipView.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Bitmap[] val$bitmapArray;

                    {
                        this.val$bitmapArray = bitmapArr;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameAnimFlipView.this, (Object) bitmapArr);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            FrameAnimFlipView.this.scaleIconBitmaps(this.val$bitmapArray);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
    }

    public void setIconPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Utils.runOnAsyncThread(new Runnable(str) { // from class: com.tencent.ams.fusion.widget.cny2025.flip.FrameAnimFlipView.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$path;

                {
                    this.val$path = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FrameAnimFlipView.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int length;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    Bitmap[] loadFrameIconBitmaps = Utils.loadFrameIconBitmaps(FrameAnimFlipView.this.getContext(), this.val$path, FrameAnimFlipView.FLIP_ANIM_SIZE_PX, FrameAnimFlipView.FLIP_ANIM_SIZE_PX);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("setIconPath load icon finish, size: ");
                    if (loadFrameIconBitmaps == null) {
                        length = 0;
                    } else {
                        length = loadFrameIconBitmaps.length;
                    }
                    sb5.append(length);
                    sb5.append(", cost:");
                    sb5.append(System.currentTimeMillis() - currentTimeMillis);
                    sb5.append(", path: ");
                    sb5.append(this.val$path);
                    Logger.i(FrameAnimFlipView.TAG, sb5.toString());
                    if (loadFrameIconBitmaps != null && loadFrameIconBitmaps.length != 0) {
                        FrameAnimFlipView.this.mFlipFrameIcons = loadFrameIconBitmaps;
                        if (((FlipView) FrameAnimFlipView.this).mAnimatorView != null) {
                            ((FlipView) FrameAnimFlipView.this).mAnimatorView.postOnAnimation(new Runnable(loadFrameIconBitmaps) { // from class: com.tencent.ams.fusion.widget.cny2025.flip.FrameAnimFlipView.3.1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ Bitmap[] val$bitmapArray;

                                {
                                    this.val$bitmapArray = loadFrameIconBitmaps;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) loadFrameIconBitmaps);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        FrameLayer frameLayer = FrameAnimFlipView.this.mFlipFrameLayer;
                                        if (frameLayer != null) {
                                            frameLayer.setFrameBitmaps(this.val$bitmapArray);
                                            return;
                                        }
                                        return;
                                    }
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    Logger.w(FrameAnimFlipView.TAG, "setIconPath failed: empty bitmap array, please check. path: " + this.val$path);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.fusion.widget.flip.FlipView
    public void tryStopEntranceAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.tryStopEntranceAnimation();
        FrameLayer frameLayer = this.mFlipFrameLayer;
        frameLayer.setAnimator(new KeepAnimator(frameLayer));
    }
}
