package dx2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.tvideo.protocol.pb.AdRequestContextInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateRequest;
import fx2.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\f"}, d2 = {"Ldx2/b;", "Lfx2/b;", "T", "", "Lcom/tencent/tvideo/protocol/pb/AdRequestContextInfo;", "requestInfo", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateRequest;", "a", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUnlockInfo;", QAdRewardDefine$VideoParams.UNLOCK_INFO, "", "b", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public interface b<T extends fx2.b> {
    @NotNull
    RewardAdNewUpdateRequest a(@NotNull AdRequestContextInfo requestInfo);

    boolean b(@Nullable RewardAdNewUnlockInfo unlockInfo);
}
