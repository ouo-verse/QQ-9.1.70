package com.tencent.mobileqq.guild.feed.util;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/au;", "", "", "percent", tl.h.F, "Lcom/airbnb/lottie/LottieAnimationView;", "view", "pathColor", "", "i", "color", DomainData.DOMAIN_NAME, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class au {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final au f223851a = new au();

    au() {
    }

    @JvmStatic
    public static final int h(int i3, int i16) {
        return (i3 & 16777215) | (((int) ((i16 / 100.0f) * 255)) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(LottieAnimationView lottieAnimationView, final ColorFilter colorFilter, final ColorFilter colorFeedBack, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(colorFilter, "$colorFilter");
        Intrinsics.checkNotNullParameter(colorFeedBack, "$colorFeedBack");
        for (KeyPath keyPath : lottieAnimationView.resolveKeyPath(new KeyPath("**"))) {
            if (keyPath.matches("\u201c\u56fe\u5c42 1\u201d\u8f6e\u5ed3", 0)) {
                lottieAnimationView.addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: com.tencent.mobileqq.guild.feed.util.ao
                    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                    public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                        ColorFilter k3;
                        k3 = au.k(colorFilter, lottieFrameInfo);
                        return k3;
                    }
                });
            } else if (keyPath.matches("\u201c\u56fe\u5c42 1\u201d\u8f6e\u5ed3 2", 0)) {
                lottieAnimationView.addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: com.tencent.mobileqq.guild.feed.util.ap
                    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                    public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                        ColorFilter l3;
                        l3 = au.l(colorFeedBack, lottieFrameInfo);
                        return l3;
                    }
                });
            } else {
                lottieAnimationView.addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: com.tencent.mobileqq.guild.feed.util.aq
                    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                    public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                        ColorFilter m3;
                        m3 = au.m(colorFilter, lottieFrameInfo);
                        return m3;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter k(ColorFilter colorFilter, LottieFrameInfo lottieFrameInfo) {
        Intrinsics.checkNotNullParameter(colorFilter, "$colorFilter");
        return colorFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter l(ColorFilter colorFeedBack, LottieFrameInfo lottieFrameInfo) {
        Intrinsics.checkNotNullParameter(colorFeedBack, "$colorFeedBack");
        return colorFeedBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter m(ColorFilter colorFilter, LottieFrameInfo lottieFrameInfo) {
        Intrinsics.checkNotNullParameter(colorFilter, "$colorFilter");
        return colorFilter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(int i3, LottieAnimationView lottieAnimationView, LottieComposition lottieComposition) {
        final LightingColorFilter lightingColorFilter = new LightingColorFilter(0, i3);
        final LightingColorFilter lightingColorFilter2 = new LightingColorFilter(0, lottieAnimationView.getResources().getColor(R.color.qui_common_feedback_error));
        for (KeyPath keyPath : lottieAnimationView.resolveKeyPath(new KeyPath("**"))) {
            if (keyPath.matches("\u5f62\u72b6\u56fe\u5c42 7", 0)) {
                lottieAnimationView.addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: com.tencent.mobileqq.guild.feed.util.as
                    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                    public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                        ColorFilter p16;
                        p16 = au.p(lightingColorFilter2, lottieFrameInfo);
                        return p16;
                    }
                });
            }
            if (keyPath.matches("\u5f62\u72b6\u56fe\u5c42 6", 0)) {
                lottieAnimationView.addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback() { // from class: com.tencent.mobileqq.guild.feed.util.at
                    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                    public final Object getValue(LottieFrameInfo lottieFrameInfo) {
                        ColorFilter q16;
                        q16 = au.q(lightingColorFilter, lottieFrameInfo);
                        return q16;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter p(ColorFilter colorFilterRed, LottieFrameInfo lottieFrameInfo) {
        Intrinsics.checkNotNullParameter(colorFilterRed, "$colorFilterRed");
        return colorFilterRed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorFilter q(ColorFilter colorFilter, LottieFrameInfo lottieFrameInfo) {
        Intrinsics.checkNotNullParameter(colorFilter, "$colorFilter");
        return colorFilter;
    }

    @SuppressLint({"RestrictedApi"})
    public final void i(@Nullable final LottieAnimationView view, int pathColor) {
        if (view == null) {
            QLog.e("GuildFeedThemeUtils", 1, "changeTargetLottiePath error for view is null");
            return;
        }
        final LightingColorFilter lightingColorFilter = new LightingColorFilter(0, pathColor);
        final LightingColorFilter lightingColorFilter2 = new LightingColorFilter(0, view.getContext().getResources().getColor(R.color.qui_common_feedback_error));
        view.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.tencent.mobileqq.guild.feed.util.an
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                au.j(LottieAnimationView.this, lightingColorFilter, lightingColorFilter2, lottieComposition);
            }
        });
    }

    @SuppressLint({"RestrictedApi"})
    public final void n(@Nullable final LottieAnimationView view, final int color) {
        if (view != null) {
            view.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.tencent.mobileqq.guild.feed.util.ar
                @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
                public final void onCompositionLoaded(LottieComposition lottieComposition) {
                    au.o(color, view, lottieComposition);
                }
            });
        }
    }
}
