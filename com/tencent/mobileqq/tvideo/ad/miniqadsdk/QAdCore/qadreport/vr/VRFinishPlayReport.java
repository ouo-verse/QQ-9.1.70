package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import java.util.Map;

/* loaded from: classes19.dex */
class VRFinishPlayReport extends BaseVRPlayReport {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VRFinishPlayReport(@NonNull f fVar, Map<String, ?> map) {
        super(fVar, map);
    }

    private int a() {
        f fVar = this.mPlayerEvent;
        int i3 = fVar.f304100a;
        if (i3 != 4) {
            if (i3 != 9) {
                return 1;
            }
            return 3;
        }
        if (fVar.f304106g) {
            return 4;
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.BaseVRPlayReport, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public String getReportKey() {
        return QAdVrReport.ReportEvent.EVENT_FINISH_PLAY;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.BaseVRPlayReport, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public Map<String, Object> getReportParams() {
        Map<String, Object> createCommonParams = createCommonParams();
        createCommonParams.put(QFS5507ReportHelper.JsonKey.END_TYPE, Integer.valueOf(a()));
        f fVar = this.mPlayerEvent;
        if (fVar != null) {
            createCommonParams.put("error_code", String.valueOf(fVar.f304102c));
        }
        return createCommonParams;
    }
}
