package com.tencent.richframework.gallery.anim;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.gallery.anim.TransitionAnimator;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$J&\u0010%\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010$2\b\u0010(\u001a\u0004\u0018\u00010$2\b\u0010)\u001a\u0004\u0018\u00010*R(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006,"}, d2 = {"Lcom/tencent/richframework/gallery/anim/TransitionManager;", "", "()V", "coverDrawable", "Landroid/graphics/drawable/Drawable;", "getCoverDrawable", "()Landroid/graphics/drawable/Drawable;", "setCoverDrawable", "(Landroid/graphics/drawable/Drawable;)V", "mAnimConfig", "Lcom/tencent/richframework/gallery/anim/TransitionAnimConfig;", "<set-?>", "Lcom/tencent/richframework/gallery/anim/TransitionInitData;", "transitionInitData", "getTransitionInitData", "()Lcom/tencent/richframework/gallery/anim/TransitionInitData;", "addImageView", "Landroid/widget/ImageView;", "containerLayout", "Landroid/widget/FrameLayout;", "initData", "doFadeCoverDismissAni", "", "fadeCoverTimeMs", "", "getAnimConfig", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/ViewGroup;", "coverView", "initCoverViewAndData", "startEnterAnim", "callback", "Lcom/tencent/richframework/gallery/anim/TransitionAnimator$OnAnimCallback;", "startExitAnim", "updateEndAnimRect", "imageEndRect", "Landroid/graphics/RectF;", "updateStartAnimData", "updateStartAnimRect", "layoutRect", "imageRect", "scaleType", "Landroid/widget/ImageView$ScaleType;", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class TransitionManager {
    private volatile TransitionAnimConfig mAnimConfig;

    @Nullable
    private volatile TransitionInitData transitionInitData;

    private final ImageView addImageView(FrameLayout containerLayout, TransitionInitData initData) {
        if (containerLayout != null && initData != null) {
            ImageView imageView = new ImageView(containerLayout.getContext());
            containerLayout.addView(imageView, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388659;
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundColor(initData.getBackgroundColor());
            return imageView;
        }
        RFWLog.e("TM-TransitionManager", RFWLog.USR, "initCoverViewForAnim  params error");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doFadeCoverDismissAni(int fadeCoverTimeMs) {
        if (this.mAnimConfig != null) {
            TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
            Intrinsics.checkNotNull(transitionAnimConfig);
            if (transitionAnimConfig.getImageView() != null) {
                TransitionAnimator transitionAnimator = TransitionAnimator.INSTANCE;
                TransitionAnimConfig transitionAnimConfig2 = this.mAnimConfig;
                Intrinsics.checkNotNull(transitionAnimConfig2);
                transitionAnimator.fadeCover(transitionAnimConfig2.getImageView(), fadeCoverTimeMs);
            }
        }
        TransitionAnimConfig transitionAnimConfig3 = this.mAnimConfig;
        Intrinsics.checkNotNull(transitionAnimConfig3);
        ViewGroup rootView = transitionAnimConfig3.getRootView();
        Intrinsics.checkNotNull(rootView);
        rootView.setVisibility(8);
    }

    private final TransitionAnimConfig getAnimConfig(ViewGroup rootView, ImageView coverView, TransitionInitData initData) {
        if (rootView != null && coverView != null && initData != null) {
            RectF layoutEndRect = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect);
            float width = layoutEndRect.width();
            RectF layoutEndRect2 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect2);
            float height = layoutEndRect2.height();
            RectF layoutStartRect = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect);
            float width2 = layoutStartRect.width();
            RectF layoutEndRect3 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect3);
            float width3 = width2 / layoutEndRect3.width();
            RectF layoutStartRect2 = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect2);
            float height2 = layoutStartRect2.height();
            RectF layoutEndRect4 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect4);
            float height3 = height2 / layoutEndRect4.height();
            RectF layoutStartRect3 = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect3);
            float width4 = layoutStartRect3.width();
            RectF layoutStartRect4 = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect4);
            float height4 = width4 / layoutStartRect4.height();
            RectF layoutEndRect5 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect5);
            float width5 = layoutEndRect5.width();
            RectF layoutEndRect6 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect6);
            float height5 = width5 / layoutEndRect6.height();
            RectF imageStartRect = initData.getImageStartRect();
            Intrinsics.checkNotNull(imageStartRect);
            float width6 = imageStartRect.width();
            RectF imageEndRect = initData.getImageEndRect();
            Intrinsics.checkNotNull(imageEndRect);
            float width7 = width6 / imageEndRect.width();
            RectF imageStartRect2 = initData.getImageStartRect();
            Intrinsics.checkNotNull(imageStartRect2);
            float height6 = imageStartRect2.height();
            RectF imageEndRect2 = initData.getImageEndRect();
            Intrinsics.checkNotNull(imageEndRect2);
            float height7 = height6 / imageEndRect2.height();
            RectF layoutStartRect5 = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect5);
            float f16 = layoutStartRect5.left;
            RectF layoutEndRect7 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect7);
            float f17 = f16 - (layoutEndRect7.left + (((1.0f - width3) * width) / 2.0f));
            float translationX = rootView.getTranslationX();
            RectF layoutStartRect6 = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect6);
            float f18 = layoutStartRect6.top;
            RectF layoutEndRect8 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect8);
            float f19 = f18 - (layoutEndRect8.top + (((1.0f - height3) * height) / 2.0f));
            float translationY = rootView.getTranslationY();
            RectF imageStartRect3 = initData.getImageStartRect();
            Intrinsics.checkNotNull(imageStartRect3);
            float f26 = imageStartRect3.left;
            RectF imageEndRect3 = initData.getImageEndRect();
            Intrinsics.checkNotNull(imageEndRect3);
            float f27 = imageEndRect3.left;
            RectF imageStartRect4 = initData.getImageStartRect();
            Intrinsics.checkNotNull(imageStartRect4);
            float f28 = imageStartRect4.top;
            RectF imageEndRect4 = initData.getImageEndRect();
            Intrinsics.checkNotNull(imageEndRect4);
            float f29 = imageEndRect4.top;
            int i3 = RFWLog.USR;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getAnimConfig | layoutStartWidth = ");
            RectF layoutStartRect7 = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect7);
            sb5.append(layoutStartRect7.width());
            sb5.append(" | layoutStartHeight = ");
            RectF layoutStartRect8 = initData.getLayoutStartRect();
            Intrinsics.checkNotNull(layoutStartRect8);
            sb5.append(layoutStartRect8.height());
            sb5.append(" | layoutEndWidth = ");
            RectF layoutEndRect9 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect9);
            sb5.append(layoutEndRect9.width());
            sb5.append(" | layoutEndHeight = ");
            RectF layoutEndRect10 = initData.getLayoutEndRect();
            Intrinsics.checkNotNull(layoutEndRect10);
            sb5.append(layoutEndRect10.height());
            sb5.append(" | imageStartWidth = ");
            RectF imageStartRect5 = initData.getImageStartRect();
            Intrinsics.checkNotNull(imageStartRect5);
            sb5.append(imageStartRect5.width());
            sb5.append(" | imageStartHeight = ");
            RectF imageStartRect6 = initData.getImageStartRect();
            Intrinsics.checkNotNull(imageStartRect6);
            sb5.append(imageStartRect6.height());
            sb5.append(" | imageEndWidth = ");
            RectF imageEndRect5 = initData.getImageEndRect();
            Intrinsics.checkNotNull(imageEndRect5);
            sb5.append(imageEndRect5.width());
            sb5.append(" | imageEndHeight = ");
            RectF imageEndRect6 = initData.getImageEndRect();
            Intrinsics.checkNotNull(imageEndRect6);
            sb5.append(imageEndRect6.height());
            sb5.append(" | layoutStartScaleX = ");
            sb5.append(width3);
            sb5.append(" | layoutEndScaleX = ");
            sb5.append(1.0f);
            sb5.append(" | layoutStartScaleY = ");
            sb5.append(height3);
            sb5.append(" | layoutEndScaleY = ");
            sb5.append(1.0f);
            sb5.append(" | layoutStartRatio = ");
            sb5.append(height4);
            sb5.append(" | layoutEndRatio = ");
            sb5.append(height5);
            sb5.append(" | startTranslationX = ");
            sb5.append(f17);
            sb5.append(" | endTranslationX = ");
            sb5.append(translationX);
            sb5.append(" | startTranslationY = ");
            sb5.append(f19);
            sb5.append(" | endTranslationY = ");
            sb5.append(translationY);
            RFWLog.d("TM-TransitionManager", i3, sb5.toString());
            return new TransitionAnimConfig().setRootView(rootView).setImageView(coverView).setValue(1, width3, 1.0f).setValue(2, height3, 1.0f).setValue(5, f17, translationX).setValue(6, f19, translationY).setValue(3, width7, 1.0f).setValue(4, height7, 1.0f).setValue(7, f26, f27).setValue(8, f28, f29);
        }
        return new TransitionAnimConfig();
    }

    private final void updateStartAnimData(ViewGroup rootView, TransitionInitData initData, ImageView coverView) {
        if (rootView != null && initData != null && coverView != null) {
            TransitionAnimator transitionAnimator = TransitionAnimator.INSTANCE;
            transitionAnimator.setTranslation(rootView, 0.0f, 0.0f);
            transitionAnimator.setTranslation(coverView, 0.0f, 0.0f);
            this.mAnimConfig = getAnimConfig(rootView, coverView, initData);
            if (initData.getStartScaleType() != ImageView.ScaleType.CENTER_CROP && initData.getStartScaleType() != ImageView.ScaleType.FIT_XY) {
                coverView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                coverView.setScaleType(initData.getStartScaleType());
            }
        }
    }

    @Nullable
    public final Drawable getCoverDrawable() {
        if (this.transitionInitData != null) {
            TransitionInitData transitionInitData = this.transitionInitData;
            Intrinsics.checkNotNull(transitionInitData);
            return transitionInitData.getMCoverDrawable();
        }
        return null;
    }

    @Nullable
    public final TransitionInitData getTransitionInitData() {
        return this.transitionInitData;
    }

    public final void initCoverViewAndData(@NotNull FrameLayout rootView, @NotNull TransitionInitData initData) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(initData, "initData");
        RFWLog.d("TM-TransitionManager", RFWLog.USR, "startEnterAnim  | initData = " + initData);
        this.transitionInitData = initData;
        ImageView addImageView = addImageView(rootView, initData);
        updateStartAnimData(rootView, initData, addImageView);
        if (addImageView != null && getCoverDrawable() != null) {
            addImageView.setImageDrawable(getCoverDrawable());
        }
        TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
        Intrinsics.checkNotNull(transitionAnimConfig);
        float startValue = transitionAnimConfig.getStartValue(5);
        TransitionAnimConfig transitionAnimConfig2 = this.mAnimConfig;
        Intrinsics.checkNotNull(transitionAnimConfig2);
        float startValue2 = transitionAnimConfig2.getStartValue(6);
        TransitionAnimator transitionAnimator = TransitionAnimator.INSTANCE;
        TransitionAnimConfig transitionAnimConfig3 = this.mAnimConfig;
        Intrinsics.checkNotNull(transitionAnimConfig3);
        transitionAnimator.setTranslation(transitionAnimConfig3.getImageView(), startValue, startValue2);
        TransitionAnimConfig transitionAnimConfig4 = this.mAnimConfig;
        Intrinsics.checkNotNull(transitionAnimConfig4);
        ImageView imageView = transitionAnimConfig4.getImageView();
        RectF imageStartRect = initData.getImageStartRect();
        Intrinsics.checkNotNull(imageStartRect);
        int width = (int) imageStartRect.width();
        RectF imageStartRect2 = initData.getImageStartRect();
        Intrinsics.checkNotNull(imageStartRect2);
        transitionAnimator.setViewLayoutParams(imageView, width, (int) imageStartRect2.height());
    }

    public final void setCoverDrawable(@Nullable final Drawable drawable) {
        if (drawable == null) {
            RFWLog.w("TM-TransitionManager", RFWLog.USR, "[setCoverDrawable]  coverDrawable == null");
            return;
        }
        if (this.transitionInitData != null) {
            TransitionInitData transitionInitData = this.transitionInitData;
            Intrinsics.checkNotNull(transitionInitData);
            transitionInitData.setCoverDrawable(drawable);
        }
        if (this.mAnimConfig != null) {
            TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
            Intrinsics.checkNotNull(transitionAnimConfig);
            if (transitionAnimConfig.getImageView() != null) {
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.richframework.gallery.anim.TransitionManager$coverDrawable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TransitionAnimConfig transitionAnimConfig2;
                        transitionAnimConfig2 = TransitionManager.this.mAnimConfig;
                        Intrinsics.checkNotNull(transitionAnimConfig2);
                        ImageView imageView = transitionAnimConfig2.getImageView();
                        Intrinsics.checkNotNull(imageView);
                        imageView.setImageDrawable(drawable);
                    }
                });
            }
        }
    }

    public final void startEnterAnim(@Nullable TransitionAnimator.OnAnimCallback callback) {
        if (this.transitionInitData != null && this.mAnimConfig != null) {
            TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
            Intrinsics.checkNotNull(transitionAnimConfig);
            if (transitionAnimConfig.getRootView() != null) {
                RFWLog.d("TM-TransitionManager", RFWLog.USR, "startEnterAnim  | initData = " + String.valueOf(this.transitionInitData));
                TransitionAnimator.INSTANCE.startAnim(this.mAnimConfig, this.transitionInitData, new TransitionManager$startEnterAnim$1(this, callback), false);
                return;
            }
        }
        RFWLog.d("TM-TransitionManager", RFWLog.USR, "[startEnterAnim]  params error");
    }

    public final void startExitAnim(@Nullable final TransitionAnimator.OnAnimCallback callback) {
        if (this.transitionInitData != null && this.mAnimConfig != null) {
            TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
            Intrinsics.checkNotNull(transitionAnimConfig);
            if (transitionAnimConfig.getRootView() != null) {
                RFWLog.d("TM-TransitionManager", RFWLog.USR, "startEnterAnim  | initData = " + String.valueOf(this.transitionInitData));
                TransitionAnimator.INSTANCE.startAnim(this.mAnimConfig, this.transitionInitData, new TransitionAnimator.OnAnimCallback() { // from class: com.tencent.richframework.gallery.anim.TransitionManager$startExitAnim$1
                    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                    public void onAnimaUpdate(float value) {
                        TransitionAnimator.OnAnimCallback onAnimCallback = callback;
                        if (onAnimCallback != null) {
                            onAnimCallback.onAnimaUpdate(value);
                        }
                    }

                    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                    public void onAnimationCancel() {
                        TransitionAnimator.OnAnimCallback onAnimCallback = callback;
                        if (onAnimCallback != null) {
                            onAnimCallback.onAnimationCancel();
                        }
                    }

                    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                    public void onAnimationEnd() {
                        TransitionManager.this.doFadeCoverDismissAni(0);
                        TransitionAnimator.OnAnimCallback onAnimCallback = callback;
                        if (onAnimCallback != null) {
                            onAnimCallback.onAnimationEnd();
                        }
                    }

                    @Override // com.tencent.richframework.gallery.anim.TransitionAnimator.OnAnimCallback
                    public void onAnimationStart() {
                        TransitionAnimConfig transitionAnimConfig2;
                        TransitionAnimConfig transitionAnimConfig3;
                        TransitionAnimConfig transitionAnimConfig4;
                        TransitionAnimConfig transitionAnimConfig5;
                        TransitionAnimConfig transitionAnimConfig6;
                        TransitionAnimConfig transitionAnimConfig7;
                        transitionAnimConfig2 = TransitionManager.this.mAnimConfig;
                        if (transitionAnimConfig2 != null) {
                            transitionAnimConfig3 = TransitionManager.this.mAnimConfig;
                            Intrinsics.checkNotNull(transitionAnimConfig3);
                            if (transitionAnimConfig3.getImageView() != null) {
                                transitionAnimConfig4 = TransitionManager.this.mAnimConfig;
                                Intrinsics.checkNotNull(transitionAnimConfig4);
                                ImageView imageView = transitionAnimConfig4.getImageView();
                                Intrinsics.checkNotNull(imageView);
                                if (imageView.animate() != null) {
                                    transitionAnimConfig7 = TransitionManager.this.mAnimConfig;
                                    Intrinsics.checkNotNull(transitionAnimConfig7);
                                    ImageView imageView2 = transitionAnimConfig7.getImageView();
                                    Intrinsics.checkNotNull(imageView2);
                                    imageView2.animate().cancel();
                                }
                                transitionAnimConfig5 = TransitionManager.this.mAnimConfig;
                                Intrinsics.checkNotNull(transitionAnimConfig5);
                                ImageView imageView3 = transitionAnimConfig5.getImageView();
                                Intrinsics.checkNotNull(imageView3);
                                imageView3.setVisibility(0);
                                transitionAnimConfig6 = TransitionManager.this.mAnimConfig;
                                Intrinsics.checkNotNull(transitionAnimConfig6);
                                ViewGroup rootView = transitionAnimConfig6.getRootView();
                                Intrinsics.checkNotNull(rootView);
                                rootView.setVisibility(0);
                            }
                        }
                        TransitionAnimator.OnAnimCallback onAnimCallback = callback;
                        if (onAnimCallback != null) {
                            onAnimCallback.onAnimationStart();
                        }
                    }
                }, true);
                return;
            }
        }
        RFWLog.d("TM-TransitionManager", RFWLog.USR, "[startExitAnim]  params error");
    }

    public final void updateEndAnimRect(@NotNull RectF imageEndRect) {
        ViewGroup rootView;
        TransitionAnimConfig transitionAnimConfig;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(imageEndRect, "imageEndRect");
        TransitionInitData transitionInitData = this.transitionInitData;
        if (transitionInitData != null) {
            transitionInitData.setImageEndRect(imageEndRect);
            TransitionAnimConfig transitionAnimConfig2 = this.mAnimConfig;
            if (transitionAnimConfig2 != null && (rootView = transitionAnimConfig2.getRootView()) != null && (transitionAnimConfig = this.mAnimConfig) != null && (imageView = transitionAnimConfig.getImageView()) != null) {
                this.mAnimConfig = getAnimConfig(rootView, imageView, transitionInitData);
            }
        }
    }

    public final void updateStartAnimRect(@Nullable RectF layoutRect, @Nullable RectF imageRect, @Nullable ImageView.ScaleType scaleType) {
        if (this.transitionInitData != null && layoutRect != null && imageRect != null) {
            TransitionInitData transitionInitData = this.transitionInitData;
            Intrinsics.checkNotNull(transitionInitData);
            transitionInitData.setLayoutStartRect(layoutRect);
            TransitionInitData transitionInitData2 = this.transitionInitData;
            Intrinsics.checkNotNull(transitionInitData2);
            transitionInitData2.setImageStartRect(imageRect);
            if (scaleType != null) {
                TransitionInitData transitionInitData3 = this.transitionInitData;
                Intrinsics.checkNotNull(transitionInitData3);
                transitionInitData3.setStartScaleType(scaleType);
            } else {
                TransitionInitData transitionInitData4 = this.transitionInitData;
                Intrinsics.checkNotNull(transitionInitData4);
                transitionInitData4.setStartScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            if (this.mAnimConfig != null) {
                TransitionAnimConfig transitionAnimConfig = this.mAnimConfig;
                Intrinsics.checkNotNull(transitionAnimConfig);
                ViewGroup rootView = transitionAnimConfig.getRootView();
                TransitionInitData transitionInitData5 = this.transitionInitData;
                TransitionAnimConfig transitionAnimConfig2 = this.mAnimConfig;
                Intrinsics.checkNotNull(transitionAnimConfig2);
                updateStartAnimData(rootView, transitionInitData5, transitionAnimConfig2.getImageView());
            }
            RFWLog.i("TM-TransitionManager", RFWLog.USR, "updateStartAnimRect  | layoutRect = " + layoutRect + " | imageRect = " + imageRect + " | scaleType = " + scaleType);
            TransitionAnimConfig transitionAnimConfig3 = this.mAnimConfig;
            Intrinsics.checkNotNull(transitionAnimConfig3);
            ViewGroup rootView2 = transitionAnimConfig3.getRootView();
            TransitionAnimConfig transitionAnimConfig4 = this.mAnimConfig;
            Intrinsics.checkNotNull(transitionAnimConfig4);
            this.mAnimConfig = getAnimConfig(rootView2, transitionAnimConfig4.getImageView(), this.transitionInitData);
        }
    }
}
