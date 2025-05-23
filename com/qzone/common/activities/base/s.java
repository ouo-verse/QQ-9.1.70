package com.qzone.common.activities.base;

import android.content.Intent;
import com.qzone.app.QZoneFeedAlertService;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.report.lp.LpReportInfo_dc00420;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

/* compiled from: P */
@Named("BaseFeedFragmentPushImp")
/* loaded from: classes39.dex */
public class s implements d5.y {

    /* renamed from: a, reason: collision with root package name */
    private d5.u f45535a;

    /* renamed from: b, reason: collision with root package name */
    private d5.c f45536b;

    @Inject
    public s() {
    }

    @Inject
    @Named("BaseFragmentConfigImp")
    public void setConfig(d5.c cVar) {
        this.f45536b = cVar;
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45535a = uVar;
    }

    @Override // d5.y
    public void a(int i3) {
        Intent intent = this.f45535a.getIntent();
        if (intent == null) {
            return;
        }
        if (intent.getBooleanExtra("FromNotification", false)) {
            QZoneFeedAlertService.getInstance().setPushCount(1, 0);
            return;
        }
        int pushCount = QZoneFeedAlertService.getInstance().getPushCount(1);
        if (pushCount <= 0) {
            return;
        }
        LpReportInfo_dc00420.report(5, 0, "", "m=1&a=0&c=0", pushCount);
        if (QZLog.isColorLevel()) {
            QZLog.d("pushReport", 2, "EXPOSE: uin: " + this.f45536b.c() + ",pushId:" + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("actiontype", "5");
        hashMap.put("mergenum", String.valueOf(pushCount));
        hashMap.put("pushstatkey", "m=1&a=0&c=0");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f45536b.f(), StatisticCollector.QZONE_PUSH_DATA_REPORT, true, 0L, 0L, hashMap, null);
        QZoneFeedAlertService.getInstance().setPushCount(1, 0);
    }
}
