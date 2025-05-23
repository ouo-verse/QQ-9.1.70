package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
/* loaded from: classes33.dex */
class TaskDistribution$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f239881d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f239882e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f239883f;

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        ReadinjoySPEventReport.f239770p.lock();
        try {
            try {
                UserOperationModule userOperationModule = UserOperationModule.getInstance();
                this.f239881d.addAll(ReadinjoySPEventReport.J().G(this.f239882e));
                String str3 = "KDreportPushEffectEvent info : eventId:" + Integer.toString(this.f239882e) + "; AttributeList:[";
                for (oidb_cmd0x80a.AttributeList attributeList : this.f239881d) {
                    str3 = str3 + "{ att_id:" + Integer.toString(attributeList.att_id.get()) + "; att_name:" + attributeList.att_name.get() + "; att_value:" + attributeList.att_value.get() + " },";
                }
                if (QLog.isColorLevel()) {
                    str2 = b.f239978a;
                    QLog.d(str2, 2, str3);
                }
                userOperationModule.request0x80aPushEffectEvent(this.f239882e, "", this.f239883f, this.f239881d, "OidbSvc.0xc22", 3106);
            } catch (Exception e16) {
                str = b.f239978a;
                QLog.e(str, 2, "reportPushEffectEvent", e16);
            }
        } finally {
            ReadinjoySPEventReport.f239770p.unlock();
        }
    }
}
