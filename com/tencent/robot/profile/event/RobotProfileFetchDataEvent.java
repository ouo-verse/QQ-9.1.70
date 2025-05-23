package com.tencent.robot.profile.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/profile/event/RobotProfileFetchDataEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "delay", "", "(J)V", "getDelay", "()J", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotProfileFetchDataEvent extends SimpleBaseEvent {
    private final long delay;

    public RobotProfileFetchDataEvent() {
        this(0L, 1, null);
    }

    public final long getDelay() {
        return this.delay;
    }

    public RobotProfileFetchDataEvent(long j3) {
        this.delay = j3;
    }

    public /* synthetic */ RobotProfileFetchDataEvent(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3);
    }
}
