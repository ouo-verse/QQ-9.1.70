package hx2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.AdConstants$PBServiceTag;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.model.QAdRewardPlayModel;
import com.tencent.tvideo.protocol.pb.AdExtraInfo;
import com.tencent.tvideo.protocol.pb.RewardAdPlayRequestInfo;
import com.tencent.tvideo.protocol.pb.RewardAdReportInfo;
import com.tencent.tvideo.protocol.pb.RewardAdReportType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lhx2/a;", "", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/model/QAdRewardPlayModel$b;", "listener", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/b;", "rewardAdPlayLoadInfo", "", "a", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f406569a = new a();

    a() {
    }

    public final void a(@Nullable QAdRewardPlayModel.b listener, @NotNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.b rewardAdPlayLoadInfo) {
        AdExtraInfo adExtraInfo;
        Intrinsics.checkNotNullParameter(rewardAdPlayLoadInfo, "rewardAdPlayLoadInfo");
        RewardAdPlayRequestInfo.a aVar = new RewardAdPlayRequestInfo.a();
        String mDataKey = rewardAdPlayLoadInfo.getMDataKey();
        if (mDataKey == null) {
            mDataKey = "";
        }
        RewardAdPlayRequestInfo.a d16 = aVar.c(mDataKey).d(new RewardAdReportInfo(0L, RewardAdReportType.REWARD_AD_REPORT_TYPE_UNLOCK));
        if (listener != null) {
            adExtraInfo = listener.c();
        } else {
            adExtraInfo = null;
        }
        new QAdRewardPlayModel(rewardAdPlayLoadInfo).h(listener, d16.a(adExtraInfo).e(c.f406571a.c()).build(), AdConstants$PBServiceTag.REWARD_NORMAL);
    }
}
