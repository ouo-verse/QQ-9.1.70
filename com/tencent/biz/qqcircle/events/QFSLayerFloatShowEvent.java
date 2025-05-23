package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFloatShowEvent extends SimpleBaseEvent {
    public static int EVENT_TYPE_AUTO_TRIGGER = 1;
    public static int EVENT_TYPE_LAYER_TOP_FLOAT_TRIGGER = 4;
    public static int EVENT_TYPE_SHARE_PANEL_TRIGGER = 3;
    public static int EVENT_TYPE_TOP_CLOSE_TRIGGER = 2;
    private final int mTriggerType;

    public QFSLayerFloatShowEvent(int i3) {
        this.mTriggerType = i3;
    }

    public String getEnterType() {
        int i3 = this.mTriggerType;
        if (i3 != EVENT_TYPE_AUTO_TRIGGER && i3 != EVENT_TYPE_TOP_CLOSE_TRIGGER) {
            if (i3 == EVENT_TYPE_LAYER_TOP_FLOAT_TRIGGER) {
                return "top_entrance";
            }
            return "share_layer_page";
        }
        return "auto_layer_page";
    }

    public int getTriggerType() {
        return this.mTriggerType;
    }
}
