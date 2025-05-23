package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller;

import android.app.Activity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.IQAdRewardMgrListener;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u000fB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J/\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\r\"\u0004\u0018\u00010\u0001H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/controller/c;", "", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/IQAdRewardMgrListener;", "Lfx2/b;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/a;", "adLoadInfo", "", "d", "e", "listener", "f", "", "adPlayStatus", "", "params", "a", "(I[Ljava/lang/Object;)V", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "", "specialId", "c", "", "b", "Ljava/lang/String;", "mCurrSpecialId", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/IQAdRewardMgrListener;", "mRewardListener", "Landroid/app/Activity;", "Landroid/app/Activity;", "mContext", "<init>", "(Landroid/app/Activity;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class c implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mCurrSpecialId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private IQAdRewardMgrListener mRewardListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Activity mContext;

    public c(@NotNull Activity mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    private final void d(fx2.b adLoadInfo) {
        n.e("[RewardAd]QAdRewardManager", "loadAMSRewardAd , before");
        QAdRewardController qAdRewardController = new QAdRewardController(this.mContext);
        this.mCurrSpecialId = String.valueOf(qAdRewardController.hashCode());
        qAdRewardController.M(adLoadInfo, this);
        n.e("[RewardAd]QAdRewardManager", "loadAMSRewardAd , after  ->  mQAdRewardController = " + this.mCurrSpecialId);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a
    public void a(int adPlayStatus, @NotNull Object... params) {
        boolean z16;
        Intrinsics.checkNotNullParameter(params, "params");
        n.e("[RewardAd]QAdRewardManager", "onEvent, adPlayStatus = " + adPlayStatus);
        if (adPlayStatus == 6) {
            if (params.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Object obj = params[0];
                if (obj instanceof RewardAdNewUnlockInfo) {
                    if (obj != null) {
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo");
                }
            }
        }
        IQAdRewardMgrListener iQAdRewardMgrListener = this.mRewardListener;
        if (iQAdRewardMgrListener != null) {
            iQAdRewardMgrListener.a(adPlayStatus, Arrays.copyOf(params, params.length));
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a
    public boolean b() {
        return false;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.a
    public void c(@Nullable RewardAdNewUnlockInfo unlockInfo, @NotNull String specialId) {
        Intrinsics.checkNotNullParameter(specialId, "specialId");
        if (unlockInfo != null && unlockInfo.lockStatus == 1) {
            n.e("[RewardAd]QAdRewardManager", "onUpdatePointInfo, specialId = " + specialId + " , unlock success");
            d.INSTANCE.a().d(specialId);
        }
    }

    public void e(@NotNull fx2.b adLoadInfo) {
        Intrinsics.checkNotNullParameter(adLoadInfo, "adLoadInfo");
        n.e("[RewardAd]QAdRewardManager", "loadRewardAd , startLoad");
        d(adLoadInfo);
    }

    public void f(@NotNull IQAdRewardMgrListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mRewardListener = listener;
    }
}
