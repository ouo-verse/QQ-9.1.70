package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.a;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0004R\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/player/RewardAdPlayerLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "c", "Lcom/tencent/qqlive/playerinterface/IQAdPlayerView;", "b", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/QAdCore/player/a;", "qAdPlayerViewCallback", "setPlayerCallback", "", "width", "height", "setVideoWidthAndHeight", "d", "Lcom/tencent/qqlive/playerinterface/IQAdPlayerView;", "mQAdPlayerView", "<init>", "(Landroid/content/Context;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class RewardAdPlayerLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private IQAdPlayerView mQAdPlayerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardAdPlayerLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        c(context);
    }

    public static final /* synthetic */ IQAdPlayerView a(RewardAdPlayerLayout rewardAdPlayerLayout) {
        IQAdPlayerView iQAdPlayerView = rewardAdPlayerLayout.mQAdPlayerView;
        if (iQAdPlayerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQAdPlayerView");
        }
        return iQAdPlayerView;
    }

    private final void c(Context context) {
        IQAdPlayerView c16 = b.c(context, 2);
        Intrinsics.checkNotNullExpressionValue(c16, "QAdPlayerUtils.createQAd\u2026rAdSource.AD_TYPE_REWARD)");
        this.mQAdPlayerView = c16;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        IQAdPlayerView iQAdPlayerView = this.mQAdPlayerView;
        if (iQAdPlayerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQAdPlayerView");
        }
        addView(iQAdPlayerView.getPlayerView(), layoutParams);
    }

    @NotNull
    public final IQAdPlayerView b() {
        IQAdPlayerView iQAdPlayerView = this.mQAdPlayerView;
        if (iQAdPlayerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQAdPlayerView");
        }
        return iQAdPlayerView;
    }

    public final void d() {
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.player.RewardAdPlayerLayout$readyRender$1
            @Override // java.lang.Runnable
            public final void run() {
                RewardAdPlayerLayout.this.setBackgroundColor(-16777216);
                RewardAdPlayerLayout.a(RewardAdPlayerLayout.this).setOpaqueInfo(true);
                RewardAdPlayerLayout.a(RewardAdPlayerLayout.this).getPlayerView().requestFocus();
            }
        });
    }

    public final void setPlayerCallback(@Nullable a qAdPlayerViewCallback) {
        IQAdPlayerView iQAdPlayerView = this.mQAdPlayerView;
        if (iQAdPlayerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQAdPlayerView");
        }
        iQAdPlayerView.setPlayerCallback(qAdPlayerViewCallback);
    }

    public final void setVideoWidthAndHeight(int width, int height) {
        IQAdPlayerView iQAdPlayerView = this.mQAdPlayerView;
        if (iQAdPlayerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQAdPlayerView");
        }
        iQAdPlayerView.setVideoWidthAndHeight(width, height);
    }
}
