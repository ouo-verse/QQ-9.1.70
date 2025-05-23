package hx2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.RewardVrReportData;
import com.tencent.qqlive.playerinterface.QAdVideoItem;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.RewardAdErrorType;
import com.tencent.tvideo.protocol.pb.RewardAdInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewPlayResponse;
import com.tencent.tvideo.protocol.pb.RewardAdNewUnlockInfo;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0016\u00a8\u0006\u001f"}, d2 = {"Lhx2/c;", "", "", "Lcom/tencent/qqlive/playerinterface/QAdVideoItem;", "videoItemList", "", h.F, "Lcom/tencent/tvideo/protocol/pb/RewardAdInfo;", "rewardAdInfo", "Lcom/tencent/tvideo/protocol/pb/AdOrderItem;", "a", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewUpdateResponse;", "response", "b", "", "c", "Lfx2/b;", "rewardAdLoadInfo", "Lfx2/a;", "e", "i", "d", "", "errorCode", "j", "Lcom/tencent/tvideo/protocol/pb/RewardAdNewPlayResponse;", "f", "clickArea", "g", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f406571a = new c();

    c() {
    }

    @Nullable
    public final AdOrderItem a(@Nullable RewardAdInfo rewardAdInfo) {
        if (rewardAdInfo != null) {
            return rewardAdInfo.order_item;
        }
        return null;
    }

    @Nullable
    public final AdOrderItem b(@Nullable RewardAdNewUpdateResponse response) {
        List<RewardAdInfo> list;
        Object orNull;
        if (response != null && (list = response.reward_info_list) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            RewardAdInfo rewardAdInfo = (RewardAdInfo) orNull;
            if (rewardAdInfo != null) {
                return rewardAdInfo.order_item;
            }
        }
        return null;
    }

    @Nullable
    public final String c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    @Nullable
    public final String d(@Nullable RewardAdNewUpdateResponse response) {
        RewardAdNewUnlockInfo rewardAdNewUnlockInfo;
        if (response != null && (rewardAdNewUnlockInfo = response.unlocked_info) != null) {
            return rewardAdNewUnlockInfo.unlock_tips;
        }
        return null;
    }

    @Nullable
    public final fx2.a e(@Nullable fx2.b rewardAdLoadInfo) {
        RewardVrReportData mVrReportData;
        if (rewardAdLoadInfo != null && (mVrReportData = rewardAdLoadInfo.getMVrReportData()) != null) {
            return mVrReportData.getMPointVrReport();
        }
        return null;
    }

    public final boolean f(@Nullable RewardAdNewPlayResponse response) {
        Integer num;
        RewardAdNewUnlockInfo rewardAdNewUnlockInfo;
        if (response != null && (rewardAdNewUnlockInfo = response.unlocked_info) != null) {
            num = Integer.valueOf(rewardAdNewUnlockInfo.lockStatus);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean g(int clickArea) {
        if (!b.f406570a.b() && (clickArea == 11 || clickArea == 10)) {
            return true;
        }
        return false;
    }

    public final boolean h(@Nullable List<QAdVideoItem> videoItemList) {
        boolean z16;
        String d16;
        boolean z17;
        if (videoItemList != null) {
            for (QAdVideoItem qAdVideoItem : videoItemList) {
                n.e("[RewardAd]QAdRewardDataHelper", "isPlayParamsValid, playerUrl = " + qAdVideoItem.c() + ", vid = " + qAdVideoItem.d() + ", duration = " + qAdVideoItem.a());
                String c16 = qAdVideoItem.c();
                if (c16 != null) {
                    if (c16.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && (d16 = qAdVideoItem.d()) != null) {
                        if (d16.length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17 && qAdVideoItem.a() > 0) {
                            return true;
                        }
                    }
                }
            }
        }
        n.e("[RewardAd]QAdRewardDataHelper", "params invalid");
        return false;
    }

    public final boolean i(@Nullable RewardAdNewUpdateResponse response) {
        RewardAdErrorType rewardAdErrorType;
        if (response != null) {
            rewardAdErrorType = response.error_type;
        } else {
            rewardAdErrorType = null;
        }
        if (rewardAdErrorType == RewardAdErrorType.REWARD_AD_ERROR_TYPE_FREQUENCY) {
            return true;
        }
        return false;
    }

    public final boolean j(int errorCode) {
        if (errorCode != -829 && errorCode != -823 && errorCode != -822) {
            return false;
        }
        return true;
    }
}
