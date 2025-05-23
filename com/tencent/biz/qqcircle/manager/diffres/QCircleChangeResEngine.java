package com.tencent.biz.qqcircle.manager.diffres;

import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCirclePlusFollowResPackage;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCirclePushButtonResPackage;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleRocketResPackage;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qcircle.cooperation.config.AccountChangeEvent;
import com.tencent.qphone.base.util.QLog;
import da0.b;
import da0.d;
import ea0.a;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public enum QCircleChangeResEngine implements SimpleEventReceiver {
    INSTANCE;

    private static final String TAG = QCircleChangeResEngine.class.getSimpleName();
    private final Map<Class, b> mChangeResManagerMap;

    QCircleChangeResEngine() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mChangeResManagerMap = concurrentHashMap;
        concurrentHashMap.put(QCircleRocketResPackage.class, new d(QCircleRocketResPackage.getDefaultResBean()));
        concurrentHashMap.put(QCirclePushButtonResPackage.class, new ea0.b(QCirclePushButtonResPackage.getDefaultResBean()));
        concurrentHashMap.put(QCirclePlusFollowResPackage.class, new a(QCirclePlusFollowResPackage.getDefaultResBean()));
    }

    private synchronized void reset() {
        for (b bVar : this.mChangeResManagerMap.values()) {
            if (bVar != null) {
                bVar.p();
                bVar.h();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(AccountChangeEvent.class);
        return arrayList;
    }

    public b getResManager(Class<? extends QCircleBaseResPackage> cls) {
        return this.mChangeResManagerMap.get(cls);
    }

    public synchronized void init() {
        QLog.d(TAG, 1, "init");
        SimpleEventBus.getInstance().registerReceiver(this);
        for (b bVar : this.mChangeResManagerMap.values()) {
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof AccountChangeEvent) {
            QLog.d(TAG, 1, "onReceiveEvent AccountChangeEvent");
            reset();
        }
    }

    public void onTurnPage() {
        for (b bVar : this.mChangeResManagerMap.values()) {
            if (bVar != null && bVar.f().contains(QCircleActionType.TURN_PAGE)) {
                bVar.n();
            }
        }
    }
}
