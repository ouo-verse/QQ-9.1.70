package com.tencent.mobileqq.tvideo.danmaku.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tvideo/danmaku/event/TVideoBarrageSwitchEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "eventStatus", "", "(I)V", "getEventStatus", "()I", "setEventStatus", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TVideoBarrageSwitchEvent extends SimpleBaseEvent {
    private int eventStatus;

    public TVideoBarrageSwitchEvent(int i3) {
        this.eventStatus = i3;
    }

    public final int getEventStatus() {
        return this.eventStatus;
    }

    public final void setEventStatus(int i3) {
        this.eventStatus = i3;
    }
}
