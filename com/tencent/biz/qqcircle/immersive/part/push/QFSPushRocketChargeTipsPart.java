package com.tencent.biz.qqcircle.immersive.part.push;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QFSPushRocketChargeTipsEvent;
import com.tencent.mobileqq.qcircle.api.global.QFSPushConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes4.dex */
public class QFSPushRocketChargeTipsPart extends u implements SimpleEventReceiver {
    private long A9(long j3) {
        return j3 - ((TimeZone.getDefault().getRawOffset() + j3) % 86400000);
    }

    private void B9() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.push.QFSPushRocketChargeTipsPart.2
            @Override // java.lang.Runnable
            public void run() {
                if (QFSPushRocketChargeTipsPart.this.C9()) {
                    QFSPushRocketChargeTipsPart.this.E9();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C9() {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && QFSPushConfig.isNeedShowRocketChargeTipsWhenLogin()) {
            if (A9(System.currentTimeMillis()) - QFSPushConfig.getRocketChargeTipsLastShowTime(QCircleCommonUtil.getCurrentAccount() + "RocketChargeTipsLastShowTimeKey") >= 86400000) {
                QLog.d("QFSPushRocketChargeTipsPart", 1, "Rocket Charge Tips Should be showed");
                return true;
            }
        }
        return false;
    }

    private void D9() {
        QFSPushConfig.saveRocketChargeTipsLastShowTime(QCircleCommonUtil.getCurrentAccount() + "RocketChargeTipsLastShowTimeKey", A9(System.currentTimeMillis()));
        QLog.d("QFSPushRocketChargeTipsPart", 1, "Rocket Charge Tips Last Show Time Saved.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9() {
        getMainHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.push.QFSPushRocketChargeTipsPart.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleToast.o(QFSPushConfig.getRocketChargeTipsText(), 0);
            }
        });
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_TOAST);
        buildElementParams.put("xsj_toast_content", QFSPushConfig.getRocketChargeTipsText());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
        D9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPushRocketChargeTipsEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPushRocketChargeTipsPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NonNull Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPushRocketChargeTipsEvent) {
            B9();
        }
    }
}
