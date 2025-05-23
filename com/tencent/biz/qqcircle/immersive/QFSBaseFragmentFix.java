package com.tencent.biz.qqcircle.immersive;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSBaseFragmentFix extends QFSBaseFragment {
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> rh5 = rh();
        ArrayList<Class> eventClass = super.getEventClass();
        if (eventClass != null) {
            eventClass = new ArrayList<>(rh5.size());
        }
        eventClass.addAll(rh5);
        return eventClass;
    }

    public abstract ArrayList<Class<? extends SimpleBaseEvent>> rh();
}
