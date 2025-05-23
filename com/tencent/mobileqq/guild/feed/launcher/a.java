package com.tencent.mobileqq.guild.feed.launcher;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a implements SimpleEventReceiver {
    abstract void a(SimpleBaseEvent simpleBaseEvent);

    abstract ArrayList<Class> b();

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class> getEventClass() {
        return b();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        a(simpleBaseEvent);
    }
}
