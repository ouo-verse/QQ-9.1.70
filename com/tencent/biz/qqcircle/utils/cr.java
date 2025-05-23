package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class cr implements SimpleEventReceiver {
    protected abstract ArrayList<Class<? extends SimpleBaseEvent>> a();

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> a16 = a();
        ArrayList<Class> arrayList = new ArrayList<>(a16.size());
        arrayList.addAll(a16);
        return arrayList;
    }
}
