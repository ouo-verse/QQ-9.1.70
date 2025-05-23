package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.controller;

import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateResponse;
import dx2.g;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes19.dex */
final class QAdRewardLoadManager$loadAd$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Integer f304205d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ RewardAdNewUpdateResponse f304206e;
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.d dVar;
        RewardedAd ad5;
        RewardedAd rewardedAd;
        Map<String, Object> map;
        RewardedAdData e16 = g.f395163a.e(this.f304205d, this.f304206e);
        if (e16 != null && (map = e16.f71702p) != null) {
            map.put(QAdRewardDefine$VideoParams.UNLOCK_INFO, this.f304206e.unlocked_info);
        }
        this.this$0.i();
        dVar = this.this$0.mSession;
        if (dVar != null && (ad5 = dVar.getAd()) != null) {
            rewardedAd = this.this$0.rewardAd;
            ad5.b(rewardedAd, e16);
        }
    }
}
