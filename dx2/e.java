package dx2;

import com.squareup.wire.AnyMessage;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.tvideo.protocol.pb.RewardAdNewPlayRequest;
import com.tencent.tvideo.protocol.pb.RewardAdPlayRequestInfo;
import com.tencent.tvideo.protocol.pb.RewardAdPlayType;
import com.tencent.tvideo.protocol.pb.RewardAdQQVideoSceneInfo;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import pw2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Ldx2/e;", "Ldx2/d;", "Lcom/tencent/ams/xsad/rewarded/RewardedAdData;", "rewardAdData", "Lfx2/b;", "adLoadData", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;", "a", "adLoadInfo", "Lcom/tencent/tvideo/protocol/pb/RewardAdPlayRequestInfo;", "playRequestInfo", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewPlayRequest;", "b", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class e extends d {
    @Override // dx2.d, dx2.a
    @NotNull
    public com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b a(@Nullable RewardedAdData rewardAdData, @Nullable fx2.b adLoadData) {
        Object obj;
        int i3;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b a16 = super.a(rewardAdData, adLoadData);
        if (adLoadData != null) {
            obj = adLoadData.getMTransferData();
        } else {
            obj = null;
        }
        a16.m(obj);
        if (adLoadData instanceof fx2.c) {
            a16.n(((fx2.c) adLoadData).getMVideoInfo());
            ex2.a mSwitchAdInnerInfo = adLoadData.getMSwitchAdInnerInfo();
            int i16 = 0;
            if (mSwitchAdInnerInfo != null) {
                i3 = mSwitchAdInnerInfo.getProcess();
            } else {
                i3 = 0;
            }
            a16.h(i3);
            ex2.a mSwitchAdInnerInfo2 = adLoadData.getMSwitchAdInnerInfo();
            if (mSwitchAdInnerInfo2 != null) {
                i16 = mSwitchAdInnerInfo2.getTotal();
            }
            a16.g(i16);
        }
        return a16;
    }

    @Override // dx2.a
    @NotNull
    public RewardAdNewPlayRequest b(@Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b adLoadInfo, @Nullable RewardAdPlayRequestInfo playRequestInfo) {
        AnyMessage anyMessage;
        RewardAdSceneType rewardAdSceneType;
        String str = null;
        if (adLoadInfo != null) {
            RewardAdQQVideoSceneInfo build = new RewardAdQQVideoSceneInfo.a().d(adLoadInfo.getMVideoInfo()).a(adLoadInfo.getAdNum()).b(adLoadInfo.getAdPostIndex()).build();
            n.e("[RewardAd]QAdRewardPlayQQVideoGenerator", "makePlayRequest, sceneInfo = " + build);
            anyMessage = p.b(RewardAdQQVideoSceneInfo.class, build);
        } else {
            anyMessage = null;
        }
        RewardAdNewPlayRequest.a aVar = new RewardAdNewPlayRequest.a();
        if (adLoadInfo != null) {
            rewardAdSceneType = adLoadInfo.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        aVar.f(rewardAdSceneType);
        if (anyMessage != null) {
            aVar.e(anyMessage);
        }
        aVar.c(RewardAdPlayType.REWARD_AD_PLAY_TYPE_QQ_VIDEO);
        aVar.d(playRequestInfo);
        if (adLoadInfo != null) {
            str = adLoadInfo.getMPenetrateInfo();
        }
        aVar.b(str);
        RewardAdNewPlayRequest build2 = aVar.build();
        Intrinsics.checkNotNullExpressionValue(build2, "RewardAdNewPlayRequest.B\u2026teInfo)\n        }.build()");
        return build2;
    }
}
