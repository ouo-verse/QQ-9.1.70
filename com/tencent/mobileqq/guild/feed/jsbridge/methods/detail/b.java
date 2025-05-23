package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
abstract class b extends c implements SimpleEventReceiver {
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class> getEventClass() {
        ArrayList<Class> p16 = p();
        if (p16 == null) {
            return new ArrayList<>();
        }
        return p16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    @CallSuper
    public void m() {
        bl.c().d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "tag: " + k() + " ,onReceiveEvent-> ", simpleBaseEvent);
        q(simpleBaseEvent);
    }

    protected abstract ArrayList<Class> p();

    protected abstract void q(SimpleBaseEvent simpleBaseEvent);
}
