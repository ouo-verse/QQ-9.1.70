package com.qzone.reborn.repair.utils;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00032\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/repair/utils/aa;", "", "", "c", "e", "g", "d", "i", "Lcom/airbnb/lottie/LottieAnimationView;", "a", "Lcom/airbnb/lottie/LottieAnimationView;", "getStarLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "starLottieView", "b", "getMaskLottieView", "maskLottieView", "<init>", "(Lcom/airbnb/lottie/LottieAnimationView;Lcom/airbnb/lottie/LottieAnimationView;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LottieAnimationView starLottieView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LottieAnimationView maskLottieView;

    public aa(LottieAnimationView starLottieView, LottieAnimationView maskLottieView) {
        Intrinsics.checkNotNullParameter(starLottieView, "starLottieView");
        Intrinsics.checkNotNullParameter(maskLottieView, "maskLottieView");
        this.starLottieView = starLottieView;
        this.maskLottieView = maskLottieView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Throwable th5) {
        QLog.i("QZonePhotoRepairingAnimateManger", 1, "mask anim fail " + th5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Throwable th5) {
        QLog.i("QZonePhotoRepairingAnimateManger", 1, "star anim fail " + th5);
    }

    public final void c() {
        this.maskLottieView.setVisibility(8);
        this.starLottieView.setVisibility(8);
        this.maskLottieView.setAnimationFromUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/lottie_mask.zip");
        this.starLottieView.setAnimationFromUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/lottie_star.zip");
    }

    public final void d() {
        QLog.i("QZonePhotoRepairingAnimateManger", 1, "[showFadeInAnimLottieView]");
        this.starLottieView.setVisibility(8);
        this.starLottieView.cancelAnimation();
        this.maskLottieView.setRepeatCount(0);
        this.maskLottieView.setMinAndMaxProgress(0.6f, 0.7f);
        this.maskLottieView.resumeAnimation();
    }

    public final void e() {
        QLog.i("QZonePhotoRepairingAnimateManger", 1, "[showMaskLottieView]");
        this.maskLottieView.setVisibility(0);
        this.maskLottieView.setMinAndMaxProgress(0.0f, 0.6f);
        this.maskLottieView.setRepeatCount(-1);
        if (!this.maskLottieView.isAnimating()) {
            this.maskLottieView.playAnimation();
        }
        this.maskLottieView.setFailureListener(new LottieListener() { // from class: com.qzone.reborn.repair.utils.z
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                aa.f((Throwable) obj);
            }
        });
    }

    public final void g() {
        QLog.i("QZonePhotoRepairingAnimateManger", 1, "[showStarLottieView]");
        this.starLottieView.setVisibility(0);
        this.starLottieView.setRepeatCount(-1);
        if (!this.starLottieView.isAnimating()) {
            this.starLottieView.playAnimation();
        }
        this.starLottieView.setFailureListener(new LottieListener() { // from class: com.qzone.reborn.repair.utils.y
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                aa.h((Throwable) obj);
            }
        });
    }

    public final void i() {
        QLog.i("QZonePhotoRepairingAnimateManger", 1, "[stopLottieView]");
        this.starLottieView.cancelAnimation();
        this.starLottieView.clearAnimation();
        this.starLottieView.removeAllAnimatorListeners();
        this.maskLottieView.cancelAnimation();
        this.maskLottieView.clearAnimation();
        this.maskLottieView.removeAllAnimatorListeners();
        LottieCompositionCache.getInstance().clear();
    }
}
