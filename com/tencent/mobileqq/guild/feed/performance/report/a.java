package com.tencent.mobileqq.guild.feed.performance.report;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.utils.bl;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class a implements SimpleEventReceiver {
    abstract ArrayList<Class> a();

    abstract void b(SimpleBaseEvent simpleBaseEvent);

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        ArrayList<Class> a16 = a();
        if (!bl.b(a16)) {
            arrayList.addAll(a16);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        b(simpleBaseEvent);
    }
}
