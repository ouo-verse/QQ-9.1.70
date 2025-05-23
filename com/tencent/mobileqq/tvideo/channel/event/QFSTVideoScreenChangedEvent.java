package com.tencent.mobileqq.tvideo.channel.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/tvideo/channel/event/QFSTVideoScreenChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "uiState", "", "(I)V", "getUiState", "()I", "setUiState", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class QFSTVideoScreenChangedEvent extends SimpleBaseEvent {
    private int uiState;

    public QFSTVideoScreenChangedEvent(int i3) {
        this.uiState = i3;
    }

    public final int getUiState() {
        return this.uiState;
    }

    public final void setUiState(int i3) {
        this.uiState = i3;
    }
}
