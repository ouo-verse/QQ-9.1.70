package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import android.util.Log;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import gi1.ChannelStatusInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/h;", "", "", "isPlay", "", "d", "Lgi1/h;", "channelStatusInfo", "animateEnable", "a", "c", "b", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "channelStatusText", "Lgi1/h;", "<init>", "(Lcom/airbnb/lottie/LottieAnimationView;Landroid/widget/TextView;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LottieAnimationView lottieAnimationView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView channelStatusText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ChannelStatusInfo channelStatusInfo;

    public h(@NotNull LottieAnimationView lottieAnimationView, @NotNull TextView channelStatusText) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        Intrinsics.checkNotNullParameter(channelStatusText, "channelStatusText");
        this.lottieAnimationView = lottieAnimationView;
        this.channelStatusText = channelStatusText;
    }

    private final void d(boolean isPlay) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("StatusWrapper", "updateChannelLottieAnim: isPlay=" + isPlay);
        }
        if (isPlay) {
            this.lottieAnimationView.playAnimation();
        } else if (this.lottieAnimationView.isAnimating()) {
            this.lottieAnimationView.cancelAnimation();
        }
    }

    public final void a(@NotNull ChannelStatusInfo channelStatusInfo, boolean animateEnable) {
        Intrinsics.checkNotNullParameter(channelStatusInfo, "channelStatusInfo");
        this.channelStatusInfo = channelStatusInfo;
        this.channelStatusText.setText(channelStatusInfo.getStatusText());
        if (channelStatusInfo.getIsAnimation()) {
            LottieAnimationView lottieAnimationView = this.lottieAnimationView;
            lottieAnimationView.setAnimation(lottieAnimationView.getContext().getString(channelStatusInfo.getIconResource()));
            d(animateEnable);
        } else {
            this.lottieAnimationView.setImageResource(channelStatusInfo.getIconResource());
            d(false);
        }
    }

    public final void b() {
        ChannelStatusInfo channelStatusInfo = this.channelStatusInfo;
        boolean z16 = false;
        if (channelStatusInfo != null && channelStatusInfo.getIsAnimation()) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        d(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.getIsAnimation() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        boolean z16;
        ChannelStatusInfo channelStatusInfo = this.channelStatusInfo;
        if (channelStatusInfo != null) {
            z16 = true;
        }
        z16 = false;
        if (!z16) {
            return;
        }
        d(false);
    }
}
