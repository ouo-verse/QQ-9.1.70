package com.tencent.gdtad.basics.motivevideo.report;

import com.tencent.gdtad.basics.motivevideo.data.GdtMvInnerClickAttaReportParams;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/gdtad/basics/motivevideo/report/c;", "", "", "videoDuration", "", "f", "rewardTimeS", "e", "d", "c", "", "clickButton", "currentVideoPosition", "b", "a", "Lcom/tencent/gdtad/basics/motivevideo/data/a;", "Lcom/tencent/gdtad/basics/motivevideo/data/a;", "mReportParams", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtMvInnerClickAttaReportParams mReportParams = new GdtMvInnerClickAttaReportParams.C1152a().a();

    public final void a(int clickButton) {
        HashMap hashMap = new HashMap();
        hashMap.put("opername", "qq");
        hashMap.put("module", "reward_ad");
        hashMap.put("action", "click");
        hashMap.put("event_code", "qq#reward_ad#click");
        hashMap.put("ext1", String.valueOf(clickButton));
        hashMap.put("ext2", String.valueOf(this.mReportParams.getIsRewarded()));
        hashMap.put("ext3", String.valueOf(this.mReportParams.getVideoDuration()));
        hashMap.put("ext4", String.valueOf(this.mReportParams.getIsEnded()));
        hashMap.put("ext6", String.valueOf(this.mReportParams.getVideoStartPlayTsClient()));
        hashMap.put("ext7", String.valueOf(this.mReportParams.getVideoEndPlayTsClient()));
        hashMap.put("ext8", String.valueOf(this.mReportParams.getVideoPlayDuration()));
        hashMap.put("ext9", String.valueOf(this.mReportParams.getRewardedCondition()));
        hashMap.put("ext10", String.valueOf(System.currentTimeMillis()));
        ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report(hashMap);
        QLog.d("GdtMvInnerClickReportHelper", 2, "report:", hashMap.toString());
    }

    public final void b(int clickButton, long currentVideoPosition) {
        this.mReportParams.m(currentVideoPosition);
        a(clickButton);
    }

    public final void c() {
        this.mReportParams.h(1);
        this.mReportParams.l(System.currentTimeMillis());
    }

    public final void d() {
        this.mReportParams.i(1);
    }

    public final void e(long rewardTimeS) {
        this.mReportParams.j(rewardTimeS);
    }

    public final void f(long videoDuration) {
        this.mReportParams.n(System.currentTimeMillis());
        this.mReportParams.k(videoDuration);
    }
}
