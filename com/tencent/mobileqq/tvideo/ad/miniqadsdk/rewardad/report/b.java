package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adexposure.QAdStandardExposureReportInfo;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import kotlin.Metadata;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/b;", "", "Lcom/tencent/tvideo/protocol/pb/AdOrderItem;", "adOrderItem", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_EXPOSURE_TYPE, "exposureReportType", "", "encryData", "adxExposureType", "", "a", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f304304a = new b();

    b() {
    }

    public final void a(@Nullable AdOrderItem adOrderItem, int exposureType, int exposureReportType, @Nullable String encryData, int adxExposureType) {
        String str;
        n.a("[RewardAd]QAdRewardExposureReport", "[exposure] doExposureReport:" + exposureType + TokenParser.SP);
        QAdStandardExposureReportInfo G = QAdStandardExposureReportInfo.G(adOrderItem, exposureType, exposureReportType, encryData, -1L, adxExposureType);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[exposure] reportUrl = ");
        if (G == null || (str = G.q()) == null) {
            str = "";
        }
        sb5.append(str);
        n.e("[RewardAd]QAdRewardExposureReport", sb5.toString());
        if (G != null) {
            G.t(null);
        }
    }
}
