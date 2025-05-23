package com.tencent.mobileqq.vas.adv.reward.api;

import android.app.Activity;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tz2.b;
import tz2.c;
import tz2.d;
import uz2.VasRewardAdReportParams;
import uz2.VasRewardAdReqParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH&J4\u0010\u0015\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0014H&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0018H&J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0018H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/reward/api/IVasRewardAdApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "initDeviceInfo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/vas/adv/reward/data/VasRewardAdParams;", "requestAdParams", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "rewardCallback", "requestAd", "ensureDeviceInfoValid", "Luz2/b;", "Ltz2/c;", "callback", "", "adSequence", "", "rewardText", ark.APP_SPECIFIC_BIZSRC, "Ltz2/d;", "showRewardAd", "Luz2/a;", "param", "Ltz2/b;", "reportRewardAd", "reportH5RewardAdNew", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasRewardAdApi extends QRouteApi {
    void ensureDeviceInfoValid();

    void initDeviceInfo();

    void reportH5RewardAdNew(@NotNull VasRewardAdReportParams param, @NotNull b callback);

    void reportRewardAd(@NotNull VasRewardAdReportParams param, @NotNull b callback);

    void requestAd(@NotNull Activity activity, @NotNull VasRewardAdParams requestAdParams, @NotNull VasRewardAdCallback rewardCallback);

    void requestAd(@NotNull VasRewardAdReqParams requestAdParams, @NotNull c callback);

    void showRewardAd(@Nullable Activity activity, long adSequence, @Nullable String rewardText, @NotNull String bizSrc, @NotNull d callback);
}
