package com.tencent.mobileqq.tvideo.channel.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/channel/event/QFSTVideoChannelClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "channelId", "", "getChannelId", "()I", "setChannelId", "(I)V", "fromTitle", "", "getFromTitle", "()Z", "setFromTitle", "(Z)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public class QFSTVideoChannelClickEvent extends SimpleBaseEvent {
    private int channelId;
    private boolean fromTitle;

    public final int getChannelId() {
        return this.channelId;
    }

    public final boolean getFromTitle() {
        return this.fromTitle;
    }

    public final void setChannelId(int i3) {
        this.channelId = i3;
    }

    public final void setFromTitle(boolean z16) {
        this.fromTitle = z16;
    }
}
