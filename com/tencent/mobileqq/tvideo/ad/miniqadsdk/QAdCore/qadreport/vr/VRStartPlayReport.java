package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f;
import java.util.Map;

/* loaded from: classes19.dex */
class VRStartPlayReport extends BaseVRPlayReport {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VRStartPlayReport(@NonNull f fVar, Map<String, ?> map) {
        super(fVar, map);
    }

    private int a() {
        int i3 = this.mPlayerEvent.f304100a;
        if (i3 != 3) {
            if (i3 != 8) {
                return 0;
            }
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.BaseVRPlayReport, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public String getReportKey() {
        return QAdVrReport.ReportEvent.EVENT_START_PLAY;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.BaseVRPlayReport, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public Map<String, Object> getReportParams() {
        Map<String, Object> createCommonParams = createCommonParams();
        createCommonParams.put("start_type", Integer.valueOf(a()));
        return createCommonParams;
    }
}
