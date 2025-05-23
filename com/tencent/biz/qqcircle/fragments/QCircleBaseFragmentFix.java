package com.tencent.biz.qqcircle.fragments;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QCircleBaseFragmentFix extends QCircleBaseFragment {
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class> getEventClass() {
        super.getEventClass();
        ArrayList<Class<? extends SimpleBaseEvent>> ph5 = ph();
        ArrayList<Class> arrayList = new ArrayList<>(ph5.size());
        arrayList.addAll(ph5);
        return arrayList;
    }

    public abstract ArrayList<Class<? extends SimpleBaseEvent>> ph();
}
