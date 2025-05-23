package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLiveStatusChangedEvent extends SimpleBaseEvent {
    private final List<String> mFinishLiveUins;

    public QFSLiveStatusChangedEvent(List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.mFinishLiveUins = arrayList;
        arrayList.addAll(list);
    }

    public List<String> getFinishLiveUins() {
        return this.mFinishLiveUins;
    }
}
