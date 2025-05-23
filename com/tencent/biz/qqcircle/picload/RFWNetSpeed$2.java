package com.tencent.biz.qqcircle.picload;

import android.net.TrafficStats;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
class RFWNetSpeed$2 implements Runnable {
    final /* synthetic */ a this$0;

    @Override // java.lang.Runnable
    public void run() {
        if (a.b(null)) {
            QLog.d("QCircleNetSpeed", 1, "QQ on back direct return");
            return;
        }
        a.a(null).postDelayed(a.c(null), 10000L);
        float totalRxBytes = (float) ((TrafficStats.getTotalRxBytes() - a.d(null)) / 1024);
        a.e(null, TrafficStats.getTotalRxBytes());
        float f16 = totalRxBytes / 9.0f;
        QLog.d("QCircleNetSpeed", 1, "qCircle net speed:" + f16 + "kb/s");
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("rate", String.valueOf(f16)));
        QCircleQualityReporter.reportImageQualityEvent(QCircleQualityReporter.KEY_EVENT_ID_IMAGE_DOWNLOAD_SPEED, "", "", "", 0, arrayList);
    }
}
