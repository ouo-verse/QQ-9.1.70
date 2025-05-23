package dx2;

import com.squareup.wire.AnyMessage;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.tvideo.protocol.pb.ADVideoInfo;
import com.tencent.tvideo.protocol.pb.AdRequestContextInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateRequest;
import com.tencent.tvideo.protocol.pb.RewardAdQQVideoSceneInfo;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import com.tencent.tvideo.protocol.pb.RewardAdUpdateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import pw2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Ldx2/f;", "Ldx2/b;", "Lfx2/b;", "Lcom/tencent/tvideo/protocol/pb/AdRequestContextInfo;", "requestInfo", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateRequest;", "a", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "", "b", "Lfx2/b;", "getMAdLoadInfo", "()Lfx2/b;", "setMAdLoadInfo", "(Lfx2/b;)V", "mAdLoadInfo", "<init>", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class f implements b<fx2.b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fx2.b mAdLoadInfo;

    public f(@Nullable fx2.b bVar) {
        this.mAdLoadInfo = bVar;
    }

    @Override // dx2.b
    @NotNull
    public RewardAdNewUpdateRequest a(@NotNull AdRequestContextInfo requestInfo) {
        String str;
        Intrinsics.checkNotNullParameter(requestInfo, "requestInfo");
        RewardAdQQVideoSceneInfo.a aVar = new RewardAdQQVideoSceneInfo.a();
        fx2.b bVar = this.mAdLoadInfo;
        RewardAdSceneType rewardAdSceneType = null;
        if (bVar instanceof fx2.c) {
            if (bVar != null) {
                aVar.d(((fx2.c) bVar).getMVideoInfo());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("makeUpdateLoadInfo, vid = ");
                ADVideoInfo aDVideoInfo = aVar.f383797a;
                if (aDVideoInfo != null) {
                    str = aDVideoInfo.vid;
                } else {
                    str = null;
                }
                sb5.append(str);
                sb5.append(", cid = ");
                sb5.append(aVar.f383797a.cid);
                n.e("[RewardAd]QAdRewardQQVideoUpdateGenerator", sb5.toString());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.video.RewardAdVideoLoadInfo");
            }
        }
        AnyMessage b16 = p.b(RewardAdQQVideoSceneInfo.class, aVar.build());
        RewardAdNewUpdateRequest.a aVar2 = new RewardAdNewUpdateRequest.a();
        fx2.b bVar2 = this.mAdLoadInfo;
        if (bVar2 != null) {
            rewardAdSceneType = bVar2.getMSceneType();
        }
        aVar2.d(rewardAdSceneType);
        aVar2.e(RewardAdUpdateType.REWARD_AD_UPDATE_TYPE_QQ_VIDEO);
        aVar2.b(requestInfo);
        aVar2.c(b16);
        RewardAdNewUpdateRequest build = aVar2.build();
        Intrinsics.checkNotNullExpressionValue(build, "RewardAdNewUpdateRequest\u2026o(data)\n        }.build()");
        return build;
    }

    @Override // dx2.b
    public boolean b(@Nullable RewardAdNewUnlockInfo unlockInfo) {
        return false;
    }
}
