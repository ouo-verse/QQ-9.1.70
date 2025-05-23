package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.PlayReportParams;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends QAdVRPlayReporter {
    public e(AdOrderItem adOrderItem) {
        super(adOrderItem);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.QAdVRPlayReporter
    protected void d(int i3, @NonNull f fVar) {
        PlayReportParams build = new PlayReportParams.Builder().setAdPlayReport(this.f304091e).setAdReportParams(this.f304090d).setAdReportKey(this.f304089c).setAdId(this.f304087a).setAdPos(this.f304088b).setPlayType(i3).setTimeOffset((int) fVar.f304101b).setFailReason(fVar.f304102c).build();
        n.a("QAdSpaUVPlayerEventReporter", "playReportState :" + i3);
        fw2.a D = fw2.a.D(build);
        if (D != null) {
            D.t(null);
        }
    }
}
