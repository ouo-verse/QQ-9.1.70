package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFilterActionEvent extends SimpleBaseEvent {
    private int mContextHashCode;
    private List<String> mFilters;

    public QFSSearchFilterActionEvent(List<String> list, int i3) {
        this.mFilters = list;
        this.mContextHashCode = i3;
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public List<String> getFilters() {
        return this.mFilters;
    }
}
