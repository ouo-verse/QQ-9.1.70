package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes19.dex */
abstract class BaseVRPlayReport implements IVRPlayReport<String, Object> {
    private Map<String, ?> mAdOrderVRParams;
    f mPlayerEvent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseVRPlayReport(@NonNull f fVar, Map<String, ?> map) {
        this.mPlayerEvent = fVar;
        this.mAdOrderVRParams = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Map<String, Object> createCommonParams() {
        HashMap hashMap = new HashMap();
        Map<String, ?> map = this.mPlayerEvent.f304105f;
        if (map != null && map.size() > 0) {
            hashMap.putAll(this.mPlayerEvent.f304105f);
        }
        Map<String, ?> map2 = this.mAdOrderVRParams;
        if (map2 != null && map2.size() > 0) {
            hashMap.putAll(this.mAdOrderVRParams);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public abstract /* synthetic */ String getReportKey();

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport
    public abstract /* synthetic */ Map<String, Object> getReportParams();

    @NonNull
    public String toString() {
        return super.toString() + "@eventId=" + this.mPlayerEvent.f304100a;
    }
}
