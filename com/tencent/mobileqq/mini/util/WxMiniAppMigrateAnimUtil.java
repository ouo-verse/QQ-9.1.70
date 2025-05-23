package com.tencent.mobileqq.mini.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.mini.util.WxMiniAppMigrateAnimUtil;
import com.tencent.mobileqq.quibadge.QUIBadge;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/mini/util/WxMiniAppMigrateAnimUtil;", "", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class WxMiniAppMigrateAnimUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MiniAppIconAnimUtil";
    private static boolean mIsOpenMiniAppScanningLight;
    private static View mScanningLightLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0007J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/mini/util/WxMiniAppMigrateAnimUtil$Companion;", "", "()V", "TAG", "", "mIsOpenMiniAppScanningLight", "", "mScanningLightLayout", "Landroid/view/View;", "isOpenMiniAppScanningLight", "postEndIconAnim", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "frameLayout", "Landroid/widget/FrameLayout;", "removeMiniAppScanningLight", "setOpenMiniAppScanningLight", "startIconAnim", "option", "Lcom/tencent/libra/request/Option;", "startScan", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void postEndIconAnim(View rootView, final FrameLayout frameLayout) {
            rootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.util.c
                @Override // java.lang.Runnable
                public final void run() {
                    WxMiniAppMigrateAnimUtil.Companion.postEndIconAnim$lambda$3(frameLayout);
                }
            }, 600L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void startScan(View rootView, Option option, FrameLayout frameLayout) {
            WxMiniAppMigrateAnimUtil.mScanningLightLayout = LayoutInflater.from(rootView.getContext()).inflate(R.layout.dje, (ViewGroup) null);
            View view = WxMiniAppMigrateAnimUtil.mScanningLightLayout;
            Intrinsics.checkNotNull(view);
            ScanningLightView scanningLightView = (ScanningLightView) view.findViewById(R.id.rl5);
            scanningLightView.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
            scanningLightView.setLightColorRes(R.color.qui_common_fill_light_secondary);
            scanningLightView.setImageBitmap(AnimUtil.toRoundBitmap(option.getResultBitMap()));
            frameLayout.addView(WxMiniAppMigrateAnimUtil.mScanningLightLayout, frameLayout.getChildCount() - 1, new FrameLayout.LayoutParams(-1, -1));
        }

        public final boolean isOpenMiniAppScanningLight() {
            return WxMiniAppMigrateAnimUtil.mIsOpenMiniAppScanningLight;
        }

        @JvmStatic
        public final void removeMiniAppScanningLight() {
            if (WxMiniAppMigrateAnimUtil.mScanningLightLayout != null) {
                View view = WxMiniAppMigrateAnimUtil.mScanningLightLayout;
                Intrinsics.checkNotNull(view);
                if (view.getParent() instanceof ViewGroup) {
                    View view2 = WxMiniAppMigrateAnimUtil.mScanningLightLayout;
                    Intrinsics.checkNotNull(view2);
                    ViewParent parent = view2.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(WxMiniAppMigrateAnimUtil.mScanningLightLayout);
                    WxMiniAppMigrateAnimUtil.mScanningLightLayout = null;
                }
            }
        }

        public final void setOpenMiniAppScanningLight(boolean isOpenMiniAppScanningLight) {
            WxMiniAppMigrateAnimUtil.mIsOpenMiniAppScanningLight = isOpenMiniAppScanningLight;
        }

        @JvmStatic
        public final void startIconAnim(final View rootView, final Option option) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(option, "option");
            final FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.rgn);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.1f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(frameLayout, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.1f);
            QUIBadge qUIBadge = (QUIBadge) rootView.findViewById(R.id.rlz);
            if (qUIBadge != null) {
                qUIBadge.setVisibility(0);
                qUIBadge.setAlpha(0.0f);
                qUIBadge.setRedText("NEW");
            } else {
                qUIBadge = null;
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(qUIBadge, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500L);
            animatorSet.playTogether(ofFloat2, ofFloat, ofFloat3);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.mini.util.WxMiniAppMigrateAnimUtil$Companion$startIconAnim$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    super.onAnimationCancel(animation);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    WxMiniAppMigrateAnimUtil.Companion companion = WxMiniAppMigrateAnimUtil.INSTANCE;
                    View view = rootView;
                    Option option2 = option;
                    FrameLayout frameLayout2 = frameLayout;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "frameLayout");
                    companion.startScan(view, option2, frameLayout2);
                    companion.postEndIconAnim(rootView, frameLayout);
                }
            });
            animatorSet.start();
            setOpenMiniAppScanningLight(false);
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void postEndIconAnim$lambda$3(FrameLayout frameLayout) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, BasicAnimation.KeyPath.SCALE_X, 1.1f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(frameLayout, BasicAnimation.KeyPath.SCALE_Y, 1.1f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(500L);
            animatorSet.playTogether(ofFloat2, ofFloat);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mobileqq.mini.util.WxMiniAppMigrateAnimUtil$Companion$postEndIconAnim$1$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    WxMiniAppMigrateAnimUtil.INSTANCE.removeMiniAppScanningLight();
                }
            });
            animatorSet.start();
        }
    }

    @JvmStatic
    public static final void removeMiniAppScanningLight() {
        INSTANCE.removeMiniAppScanningLight();
    }

    @JvmStatic
    public static final void startIconAnim(View view, Option option) {
        INSTANCE.startIconAnim(view, option);
    }
}
