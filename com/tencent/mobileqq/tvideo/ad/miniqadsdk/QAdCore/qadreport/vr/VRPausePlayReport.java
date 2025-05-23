package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f;
import java.util.Map;

/* loaded from: classes19.dex */
class VRPausePlayReport extends BaseVRPlayReport {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VRPausePlayReport(@NonNull f fVar, Map<String, ?> map) {
        super(fVar, map);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.BaseVRPlayReport, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public String getReportKey() {
        return QAdVrReport.ReportEvent.EVENT_PAUSE_PLAY;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.BaseVRPlayReport, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public Map<String, Object> getReportParams() {
        return createCommonParams();
    }
}
