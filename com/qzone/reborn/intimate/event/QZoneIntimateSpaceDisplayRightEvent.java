package com.qzone.reborn.intimate.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneIntimateSpaceDisplayRightEvent extends SimpleBaseEvent {
    private final int mSpaceDisplayRight;
    private final String mSpaceId;

    public QZoneIntimateSpaceDisplayRightEvent(String str, int i3) {
        this.mSpaceId = str;
        this.mSpaceDisplayRight = i3;
    }

    public int getSpaceDisplayRight() {
        return this.mSpaceDisplayRight;
    }

    public String getSpaceId() {
        return this.mSpaceId;
    }
}
