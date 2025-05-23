package dx2;

import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.tvideo.protocol.pb.RewardAdNewPlayRequest;
import com.tencent.tvideo.protocol.pb.RewardAdPlayRequestInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\r"}, d2 = {"Ldx2/a;", "", "Lcom/tencent/ams/xsad/rewarded/RewardedAdData;", "rewardAdData", "Lfx2/b;", "adLoadData", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;", "a", "adLoadInfo", "Lcom/tencent/tvideo/protocol/pb/RewardAdPlayRequestInfo;", "playRequestInfo", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewPlayRequest;", "b", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public interface a {
    @NotNull
    com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b a(@Nullable RewardedAdData rewardAdData, @Nullable fx2.b adLoadData);

    @NotNull
    RewardAdNewPlayRequest b(@Nullable com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b adLoadInfo, @Nullable RewardAdPlayRequestInfo playRequestInfo);
}
