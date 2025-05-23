package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildScrollFollowInputEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "height", "", "targetHeightHint", "inputHeight", "(III)V", "getHeight", "()I", "getInputHeight", "getTargetHeightHint", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildScrollFollowInputEvent extends SimpleBaseEvent {
    private final int height;
    private final int inputHeight;
    private final int targetHeightHint;

    public GuildScrollFollowInputEvent(int i3, int i16, int i17) {
        this.height = i3;
        this.targetHeightHint = i16;
        this.inputHeight = i17;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getInputHeight() {
        return this.inputHeight;
    }

    public final int getTargetHeightHint() {
        return this.targetHeightHint;
    }
}
