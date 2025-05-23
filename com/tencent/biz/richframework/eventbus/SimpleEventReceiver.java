package com.tencent.biz.richframework.eventbus;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface SimpleEventReceiver<T extends SimpleBaseEvent> {
    ArrayList<Class<T>> getEventClass();

    void onReceiveEvent(SimpleBaseEvent simpleBaseEvent);
}
