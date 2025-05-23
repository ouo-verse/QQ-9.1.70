package ea0;

import com.tencent.biz.qqcircle.beans.QCirclePushEffectTipInfo;
import com.tencent.biz.qqcircle.manager.diffres.QCircleChangeResEngine;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseWnsConfigResPackage;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleRocketResPackage;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCirclePushEffectUpdateEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import da0.d;
import java.util.ArrayList;
import qqcircle.QQCircleEnvHub$UserInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b<T extends QCircleBaseWnsConfigResPackage> extends d implements SimpleEventReceiver {
    private QCirclePushEffectTipInfo K;

    public b(QCircleBaseWnsConfigResPackage qCircleBaseWnsConfigResPackage) {
        super(qCircleBaseWnsConfigResPackage);
    }

    private void A(long j3, long j16) {
        s(j3, j16);
        QCircleChangeResEngine.INSTANCE.getResManager(QCircleRocketResPackage.class).s(j3, j16);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePushEffectUpdateEvent.class);
        return arrayList;
    }

    @Override // da0.d, da0.b
    public synchronized void h() {
        super.h();
        QLog.d(this.f393297d, 1, "QCircleRefreshPushEffect QCircleDiffPushEffectManager init");
        SimpleEventBus.getInstance().registerReceiver(this);
        QQCircleEnvHub$UserInfo userInfo = QCircleHostGlobalInfo.getUserInfo();
        if (userInfo == null) {
            QLog.d(this.f393297d, 1, "QCircleRefreshPushEffect QCircleDiffPushEffectManager init userInfo == null");
        } else {
            A(userInfo.pushEffectStartTime.get(), userInfo.pushEffectEndTime.get());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePushEffectUpdateEvent) {
            QCirclePushEffectUpdateEvent qCirclePushEffectUpdateEvent = (QCirclePushEffectUpdateEvent) simpleBaseEvent;
            long startTime = qCirclePushEffectUpdateEvent.getStartTime();
            long endTime = qCirclePushEffectUpdateEvent.getEndTime();
            QLog.d(this.f393297d, 1, "QCircleRefreshPushEffect onReceive QCirclePushEffectUpdateEvent");
            A(startTime, endTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da0.d
    public void w() {
        super.w();
    }

    public QCirclePushEffectTipInfo z() {
        return this.K;
    }
}
