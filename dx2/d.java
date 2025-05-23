package dx2;

import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Ldx2/d;", "Ldx2/a;", "Lcom/tencent/ams/xsad/rewarded/RewardedAdData;", "rewardAdData", "Lfx2/b;", "adLoadData", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;", "a", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public class d implements a {
    @Override // dx2.a
    @NotNull
    public com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b a(@Nullable RewardedAdData rewardAdData, @Nullable fx2.b adLoadData) {
        RewardAdSceneType rewardAdSceneType;
        HashMap<String, String> hashMap;
        Map<String, Object> map;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b bVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b();
        Object obj = null;
        if (adLoadData != null) {
            rewardAdSceneType = adLoadData.getMSceneType();
        } else {
            rewardAdSceneType = null;
        }
        bVar.l(rewardAdSceneType);
        if (adLoadData != null) {
            hashMap = adLoadData.a();
        } else {
            hashMap = null;
        }
        bVar.i(hashMap);
        if (rewardAdData != null && (map = rewardAdData.f71702p) != null) {
            obj = map.get(QAdRewardDefine$SecurityData.PENETRATE_INFO);
        }
        if (obj instanceof String) {
            bVar.j((String) obj);
        }
        return bVar;
    }
}
