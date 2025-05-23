package com.tencent.biz.richframework.animation.transition;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.transition.TransitionAnimator;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionManager {
    private TransitionAnimConfig mAnimConfig;
    private TransitionInitData mTransitionInitData;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnAnimEndListener {
        void onAnimCancel();

        void onAnimEnd();
    }

    private ImageView addImageView(FrameLayout frameLayout, TransitionInitData transitionInitData) {
        ImageView imageView;
        if (frameLayout != null && transitionInitData != null) {
            ImageView imageView2 = (ImageView) frameLayout.findViewById(R.id.f74313vx);
            if (imageView2 == null) {
                imageView = new ImageView(frameLayout.getContext());
            } else {
                imageView = imageView2;
            }
            if (imageView != imageView2) {
                frameLayout.addView(imageView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(transitionInitData.getBackgroundColor());
                imageView.setId(R.id.f74313vx);
            }
            return imageView;
        }
        QLog.e("TM-TransitionManager", 1, "initCoverViewForAnim  params error");
        return null;
    }

    private void adjustCoverViewScaleType() {
        TransitionAnimConfig transitionAnimConfig;
        float f16;
        float width;
        float max;
        float min;
        if (this.mTransitionInitData != null && (transitionAnimConfig = this.mAnimConfig) != null && transitionAnimConfig.getImageView() != null) {
            if (this.mTransitionInitData.getCoverDrawable() != null && this.mTransitionInitData.getCoverDrawable().getIntrinsicWidth() != 0 && this.mTransitionInitData.getCoverDrawable().getIntrinsicHeight() != 0) {
                float f17 = 0.0f;
                float f18 = 1.0f;
                if (this.mTransitionInitData.getStartScaleType() == ImageView.ScaleType.FIT_CENTER && this.mTransitionInitData.getEndScaleType() == ImageView.ScaleType.CENTER_CROP) {
                    this.mAnimConfig.getImageView().setScaleType(ImageView.ScaleType.FIT_CENTER);
                    width = this.mTransitionInitData.getImageEndRect().width() / this.mTransitionInitData.getCoverDrawable().getIntrinsicWidth();
                    f16 = this.mTransitionInitData.getImageEndRect().height() / this.mTransitionInitData.getCoverDrawable().getIntrinsicHeight();
                    if (f16 != 0.0f && width != 0.0f) {
                        max = Math.max(f16, width);
                        min = Math.min(f16, width);
                        f18 = max / min;
                    }
                    f17 = width;
                } else if (this.mTransitionInitData.getStartScaleType() == ImageView.ScaleType.CENTER_CROP && this.mTransitionInitData.getEndScaleType() == ImageView.ScaleType.FIT_CENTER) {
                    this.mAnimConfig.getImageView().setScaleType(ImageView.ScaleType.FIT_CENTER);
                    width = this.mTransitionInitData.getImageStartRect().width() / this.mTransitionInitData.getCoverDrawable().getIntrinsicWidth();
                    f16 = this.mTransitionInitData.getImageStartRect().height() / this.mTransitionInitData.getCoverDrawable().getIntrinsicHeight();
                    if (f16 != 0.0f && width != 0.0f) {
                        max = Math.max(f16, width);
                        min = Math.min(f16, width);
                        f18 = max / min;
                    }
                    f17 = width;
                } else {
                    f16 = 0.0f;
                }
                this.mAnimConfig.setScaleFactor(f18);
                QLog.i("TM-TransitionManager", 4, "adjustCoverViewWidthHeight  | scaleFactor = " + f18 + " | imageStartRect.width = " + this.mTransitionInitData.getImageStartRect().width() + " | imageStartRect.height = " + this.mTransitionInitData.getImageStartRect().height() + " | imageEndRect.width = " + this.mTransitionInitData.getImageEndRect().width() + " | imageEndRect.height = " + this.mTransitionInitData.getImageEndRect().height() + " | coverDrawable.getIntrinsicWidth = " + this.mTransitionInitData.getCoverDrawable().getIntrinsicWidth() + " | coverDrawable.getIntrinsicHeight = " + this.mTransitionInitData.getCoverDrawable().getIntrinsicHeight() + " | widthRatio = " + f17 + " | heightRatio = " + f16);
                return;
            }
            QLog.e("TM-TransitionManager", 1, "adjustCoverViewScaleType  coverDrawable params error");
            return;
        }
        QLog.e("TM-TransitionManager", 1, "adjustCoverViewScaleType  params error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFadeCoverDismissAni(int i3) {
        if (this.mAnimConfig == null) {
            return;
        }
        if (this.mTransitionInitData.fadeAniLayout()) {
            TransitionAnimator.fadeCover(this.mAnimConfig.getRootView(), i3, false);
        } else if (this.mAnimConfig.getImageView() != null) {
            TransitionAnimator.fadeCover(this.mAnimConfig.getImageView(), i3, true);
        }
    }

    private TransitionAnimConfig getAnimConfig(ViewGroup viewGroup, ImageView imageView, TransitionInitData transitionInitData) {
        if (viewGroup != null && imageView != null && transitionInitData != null) {
            float width = transitionInitData.getLayoutEndRect().width();
            float height = transitionInitData.getLayoutEndRect().height();
            float width2 = transitionInitData.getLayoutStartRect().width() / transitionInitData.getLayoutEndRect().width();
            float height2 = transitionInitData.getLayoutStartRect().height() / transitionInitData.getLayoutEndRect().height();
            float width3 = transitionInitData.getLayoutStartRect().width() / transitionInitData.getLayoutStartRect().height();
            float width4 = transitionInitData.getLayoutEndRect().width() / transitionInitData.getLayoutEndRect().height();
            float width5 = transitionInitData.getImageStartRect().width() / transitionInitData.getImageEndRect().width();
            float height3 = transitionInitData.getImageStartRect().height() / transitionInitData.getImageEndRect().height();
            float f16 = transitionInitData.getLayoutStartRect().left - (transitionInitData.getLayoutEndRect().left + (((1.0f - width2) * width) / 2.0f));
            float translationX = viewGroup.getTranslationX();
            float f17 = transitionInitData.getLayoutStartRect().top - (transitionInitData.getLayoutEndRect().top + (((1.0f - height2) * height) / 2.0f));
            float translationY = viewGroup.getTranslationY();
            QLog.d("TM-TransitionManager", 4, "getAnimConfig | layoutStartWidth = " + transitionInitData.getLayoutStartRect().width() + " | layoutStartHeight = " + transitionInitData.getLayoutStartRect().height() + " | layoutEndWidth = " + transitionInitData.getLayoutEndRect().width() + " | layoutEndHeight = " + transitionInitData.getLayoutEndRect().height() + " | imageStartWidth = " + transitionInitData.getImageStartRect().width() + " | imageStartHeight = " + transitionInitData.getImageStartRect().height() + " | imageEndWidth = " + transitionInitData.getImageEndRect().width() + " | imageEndHeight = " + transitionInitData.getImageEndRect().height() + " | layoutStartScaleX = " + width2 + " | layoutEndScaleX = 1.0 | layoutStartScaleY = " + height2 + " | layoutEndScaleY = 1.0 | layoutStartRatio = " + width3 + " | layoutEndRatio = " + width4 + " | startTranslationX = " + f16 + " | endTranslationX = " + translationX + " | startTranslationY = " + f17 + " | endTranslationY = " + translationY);
            return new TransitionAnimConfig().setRootView(viewGroup).setImageView(imageView).setValue(1, width2, 1.0f).setValue(2, height2, 1.0f).setValue(5, f16, translationX).setValue(6, f17, translationY).setValue(7, width3, width4).setValue(3, width5, 1.0f).setValue(4, height3, 1.0f);
        }
        return new TransitionAnimConfig();
    }

    private void updateStartAnimData(ViewGroup viewGroup, TransitionInitData transitionInitData, ImageView imageView) {
        if (viewGroup != null && transitionInitData != null && imageView != null) {
            TransitionAnimator.setTranslation(viewGroup, 0.0f, 0.0f);
            this.mAnimConfig = getAnimConfig(viewGroup, imageView, transitionInitData);
            imageView.setScaleType(transitionInitData.getEndScaleType());
            adjustCoverViewScaleType();
        }
    }

    public void dismissCoverView() {
        ImageView imageView;
        TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
        if (transitionAnimConfig != null && (imageView = transitionAnimConfig.getImageView()) != null) {
            imageView.setVisibility(8);
        }
    }

    public void dismissCoverViewAnim() {
        TransitionInitData transitionInitData = this.mTransitionInitData;
        if (transitionInitData == null) {
            QLog.d("TM-TransitionManager", 1, "dismissCoverView but mTransitionInitData is null");
        } else if (transitionInitData.getTransitionDelayTimeMs() == 0) {
            doFadeCoverDismissAni(this.mTransitionInitData.getEnterAnimFadeCoverTimeMs());
        } else {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.richframework.animation.transition.TransitionManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TransitionManager transitionManager = TransitionManager.this;
                    transitionManager.doFadeCoverDismissAni(transitionManager.mTransitionInitData.getEnterAnimFadeCoverTimeMs());
                }
            }, this.mTransitionInitData.getTransitionDelayTimeMs());
        }
    }

    public Drawable getCoverDrawable() {
        TransitionInitData transitionInitData = this.mTransitionInitData;
        if (transitionInitData != null) {
            return transitionInitData.getCoverDrawable();
        }
        return null;
    }

    public TransitionInitData getTransitionInitData() {
        return this.mTransitionInitData;
    }

    public void initCoverViewAndData(FrameLayout frameLayout, TransitionInitData transitionInitData) {
        float f16;
        if (frameLayout != null && transitionInitData != null) {
            QLog.d("TM-TransitionManager", 1, "initCoverViewAndData  | initData = " + transitionInitData.toString());
            this.mTransitionInitData = transitionInitData;
            ImageView addImageView = addImageView(frameLayout, transitionInitData);
            updateStartAnimData(frameLayout, transitionInitData, addImageView);
            if (addImageView != null && getCoverDrawable() != null) {
                addImageView.setImageDrawable(getCoverDrawable());
                TransitionAnimUtil.clearCacheDrawable();
            }
            float startValue = this.mAnimConfig.getStartValue(1);
            float startValue2 = this.mAnimConfig.getStartValue(2);
            TransitionAnimator.setScale(frameLayout, startValue, startValue2);
            TransitionAnimator.setTranslation(frameLayout, this.mAnimConfig.getStartValue(5), this.mAnimConfig.getStartValue(6));
            if (this.mTransitionInitData.getStartScaleType() == ImageView.ScaleType.CENTER_CROP && this.mTransitionInitData.getEndScaleType() == ImageView.ScaleType.FIT_CENTER) {
                f16 = this.mAnimConfig.getScaleFactor();
            } else {
                f16 = 1.0f;
            }
            TransitionAnimator.setViewLayoutParams(this.mAnimConfig.getImageView(), (int) transitionInitData.getImageStartRect().width(), (int) transitionInitData.getImageStartRect().height());
            TransitionAnimator.setScale(this.mAnimConfig.getImageView(), ((float) (1.0d / startValue)) * f16, ((float) (1.0d / startValue2)) * f16);
        }
    }

    public void setCoverDrawable(final Drawable drawable) {
        if (drawable == null) {
            QLog.w("TM-TransitionManager", 1, "[setCoverDrawable]  coverDrawable == null");
            return;
        }
        TransitionInitData transitionInitData = this.mTransitionInitData;
        if (transitionInitData != null) {
            transitionInitData.setCoverDrawable(drawable);
        }
        TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
        if (transitionAnimConfig != null && transitionAnimConfig.getImageView() != null) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.animation.transition.TransitionManager.4
                @Override // java.lang.Runnable
                public void run() {
                    TransitionManager.this.mAnimConfig.getImageView().setImageDrawable(drawable);
                }
            });
        }
    }

    public void startEnterAnim(OnAnimEndListener onAnimEndListener) {
        startEnterAnim(onAnimEndListener, true);
    }

    public void startExitAnim(final OnAnimEndListener onAnimEndListener) {
        TransitionAnimConfig transitionAnimConfig;
        if (FastClickUtils.isFastDoubleClick("TM-TransitionManager_startExitAnim", 500L)) {
            return;
        }
        if (this.mTransitionInitData != null && (transitionAnimConfig = this.mAnimConfig) != null && transitionAnimConfig.getRootView() != null) {
            QLog.d("TM-TransitionManager", 1, "startExitAnim  | initData = " + this.mTransitionInitData.toString());
            TransitionAnimator.startAnim(this.mAnimConfig, this.mTransitionInitData, new TransitionAnimator.OnAnimCallback() { // from class: com.tencent.biz.richframework.animation.transition.TransitionManager.3
                @Override // com.tencent.biz.richframework.animation.transition.TransitionAnimator.OnAnimCallback
                public void onAnimationCancel() {
                    QLog.d("TM-TransitionManager", 1, "[onAnimationCancel] cancel.");
                    OnAnimEndListener onAnimEndListener2 = onAnimEndListener;
                    if (onAnimEndListener2 != null) {
                        onAnimEndListener2.onAnimCancel();
                    }
                }

                @Override // com.tencent.biz.richframework.animation.transition.TransitionAnimator.OnAnimCallback
                public void onAnimationEnd() {
                    if (TransitionManager.this.mTransitionInitData.needDoFadeAniWhenExit()) {
                        TransitionManager transitionManager = TransitionManager.this;
                        transitionManager.doFadeCoverDismissAni(transitionManager.mTransitionInitData.getExitAnimFadeCoverTimeMs());
                    }
                    OnAnimEndListener onAnimEndListener2 = onAnimEndListener;
                    if (onAnimEndListener2 != null) {
                        onAnimEndListener2.onAnimEnd();
                    }
                    QLog.d("TM-TransitionManager", 1, "[onAnimationEnd]");
                }

                @Override // com.tencent.biz.richframework.animation.transition.TransitionAnimator.OnAnimCallback
                public void onAnimationStart() {
                    if (TransitionManager.this.mAnimConfig != null && TransitionManager.this.mAnimConfig.getImageView() != null) {
                        if (TransitionManager.this.mAnimConfig.getImageView().animate() != null) {
                            TransitionManager.this.mAnimConfig.getImageView().animate().cancel();
                        }
                        TransitionManager.this.mAnimConfig.getImageView().setVisibility(0);
                    }
                }
            }, true);
            return;
        }
        QLog.d("TM-TransitionManager", 1, "[startExitAnim]  params error");
    }

    public void updateStartAnimRect(RectF rectF, RectF rectF2, ImageView.ScaleType scaleType) {
        TransitionInitData transitionInitData = this.mTransitionInitData;
        if (transitionInitData != null && rectF != null && rectF2 != null) {
            transitionInitData.setLayoutStartRect(rectF);
            this.mTransitionInitData.setImageStartRect(rectF2);
            if (scaleType != null) {
                this.mTransitionInitData.setStartScaleType(scaleType);
            } else {
                this.mTransitionInitData.setStartScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
            if (transitionAnimConfig != null) {
                updateStartAnimData(transitionAnimConfig.getRootView(), this.mTransitionInitData, this.mAnimConfig.getImageView());
            }
            QLog.i("TM-TransitionManager", 4, "updateStartAnimRect  | layoutRect = " + rectF + " | imageRect = " + rectF2 + " | scaleType = " + scaleType);
        }
    }

    public void startEnterAnim(final OnAnimEndListener onAnimEndListener, final boolean z16) {
        TransitionAnimConfig transitionAnimConfig;
        if (this.mTransitionInitData != null && (transitionAnimConfig = this.mAnimConfig) != null && transitionAnimConfig.getRootView() != null) {
            QLog.d("TM-TransitionManager", 1, "startEnterAnim  | initData = " + this.mTransitionInitData.toString());
            TransitionAnimator.startAnim(this.mAnimConfig, this.mTransitionInitData, new TransitionAnimator.OnAnimCallback() { // from class: com.tencent.biz.richframework.animation.transition.TransitionManager.1
                @Override // com.tencent.biz.richframework.animation.transition.TransitionAnimator.OnAnimCallback
                public void onAnimationCancel() {
                    QLog.d("TM-TransitionManager", 1, "[onAnimationStart] animation cancel, onAnimEndListener: " + onAnimEndListener);
                    OnAnimEndListener onAnimEndListener2 = onAnimEndListener;
                    if (onAnimEndListener2 != null) {
                        onAnimEndListener2.onAnimCancel();
                    }
                }

                @Override // com.tencent.biz.richframework.animation.transition.TransitionAnimator.OnAnimCallback
                public void onAnimationEnd() {
                    QLog.d("TM-TransitionManager", 1, "[onAnimationEnd] animation end, onAnimEndListener: " + onAnimEndListener);
                    OnAnimEndListener onAnimEndListener2 = onAnimEndListener;
                    if (onAnimEndListener2 != null) {
                        onAnimEndListener2.onAnimEnd();
                    }
                    if (z16) {
                        TransitionManager.this.dismissCoverViewAnim();
                    }
                }

                @Override // com.tencent.biz.richframework.animation.transition.TransitionAnimator.OnAnimCallback
                public void onAnimationStart() {
                    QLog.d("TM-TransitionManager", 1, "[onAnimationStart] animation start.");
                }
            }, false);
            return;
        }
        QLog.d("TM-TransitionManager", 1, "[startEnterAnim]  params error");
    }
}
