package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.tvideo.protocol.pb.AdActionField;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b {

    /* renamed from: e, reason: collision with root package name */
    private boolean f304139e;

    public e(@NonNull gw2.a aVar) {
        super(aVar);
    }

    private void n() {
        QAdVrReportParams qAdVrReportParams = this.f304027b;
        if (qAdVrReportParams == null) {
            return;
        }
        if (this.f304139e) {
            qAdVrReportParams.a(VRReportDefine$ReportKey.AD_SCREEN_STATUS, 1);
        } else {
            qAdVrReportParams.a(VRReportDefine$ReportKey.AD_SCREEN_STATUS, 0);
        }
    }

    private static boolean q(int i3) {
        if (i3 != 11 && i3 != 8 && i3 != 9 && i3 != 10 && i3 != 7 && i3 != 14) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    protected int a(int i3) {
        if (this.f304139e) {
            if (q(i3)) {
                return 6;
            }
            return 5;
        }
        if (q(i3)) {
            return 4;
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    protected int b(int i3) {
        return yw2.a.a(i3);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    public ew2.a e(int i3) {
        if (this.f304029d.get(Integer.valueOf(i3)) != null) {
            return this.f304029d.get(Integer.valueOf(i3));
        }
        return new ew2.a();
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.b
    public void l(QAdVrReportParams qAdVrReportParams) {
        super.l(qAdVrReportParams);
        n();
    }

    public Map<String, String> o(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ACTION_LAYER, String.valueOf(a(i3)));
        return hashMap;
    }

    public void p() {
        this.f304029d.clear();
        Map<Integer, ew2.a> map = this.f304029d;
        AdActionField adActionField = AdActionField.AD_ACTION_FIELD_POSTER;
        map.put(3, new ew2.a(adActionField, 1011, QAdVrReport.ElementID.AD_TITLE));
        this.f304029d.put(5, new ew2.a(adActionField, 1014, QAdVrReport.ElementID.AD_POSTER));
        this.f304029d.put(1, new ew2.a(adActionField, 1003, QAdVrReport.ElementID.AD_NAME));
        this.f304029d.put(2, new ew2.a(adActionField, 1011, QAdVrReport.ElementID.AD_TITLE));
        this.f304029d.put(4, new ew2.a(AdActionField.AD_ACTION_FIELD_ACTION_BTN, 1021, QAdVrReport.ElementID.AD_ACTION_BTN));
        this.f304029d.put(13, new ew2.a(adActionField, 1024, QAdVrReport.ElementID.AD_POSTER_RELATIVE));
        this.f304029d.put(6, new ew2.a(adActionField, 1002, QAdVrReport.ElementID.AD_HEAD));
        this.f304029d.put(1, new ew2.a(adActionField, 1003, QAdVrReport.ElementID.AD_NAME));
        this.f304029d.put(14, new ew2.a(adActionField, 1024, QAdVrReport.ElementID.AD_MASK));
        this.f304029d.put(7, new ew2.a(adActionField, 1031, QAdVrReport.ElementID.AD_HEAD));
        this.f304029d.put(8, new ew2.a(adActionField, 1030, QAdVrReport.ElementID.AD_TITLE));
        this.f304029d.put(9, new ew2.a(adActionField, 1041, QAdVrReport.ElementID.AD_NAME));
        this.f304029d.put(10, new ew2.a(adActionField, 1023, QAdVrReport.ElementID.AD_ACTION_BTN));
        this.f304029d.put(11, new ew2.a(adActionField, 1028, QAdVrReport.ElementID.AD_REPLAY));
        this.f304029d.put(12, new ew2.a(QAdVrReport.ElementID.AD_NEGATIVE_FEEDBACK_ENTRY));
        this.f304029d.put(16, new ew2.a(QAdVrReport.ElementID.AD_PLAY_ICON));
    }

    public void r(View view) {
        if (view == null) {
            return;
        }
        QAdVrReport.o(view, this.f304027b, this.f304028c, QAdVrReport.ElementID.AD_MASK);
    }

    public void s(boolean z16) {
        this.f304139e = z16;
        n();
    }
}
