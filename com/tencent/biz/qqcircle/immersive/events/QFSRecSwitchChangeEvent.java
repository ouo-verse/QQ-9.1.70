package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import uq3.c;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRecSwitchChangeEvent extends SimpleBaseEvent {
    private final boolean mRecSwitchOpen;

    public QFSRecSwitchChangeEvent(boolean z16) {
        this.mRecSwitchOpen = z16;
        QLog.d("QFSRecSwitchChangeEvent", 1, "QFSRecSwitchChangeEvent isSwitchOpen\uff1a" + z16);
        k.a().j("sp_key_personal_recommend_switch_open", z16);
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.events.QFSRecSwitchChangeEvent.1
            @Override // java.lang.Runnable
            public void run() {
                ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).preloadTabInfo();
            }
        }, c.i3());
    }

    public boolean isSwitchOpen() {
        return this.mRecSwitchOpen;
    }
}
