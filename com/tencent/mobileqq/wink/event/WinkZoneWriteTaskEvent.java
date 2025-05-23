package com.tencent.mobileqq.wink.event;

import com.heytap.mcssdk.a.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/event/WinkZoneWriteTaskEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", a.f36094d, "I", "getTaskID", "()I", "<init>", "(I)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkZoneWriteTaskEvent extends SimpleBaseEvent {
    public static final int EVENT_PUBLISH_MOOD_SUCCESS = 2;
    public static final int EVENT_UPLOAD_PIC_SUCCESS = 11;
    private final int taskID;

    public WinkZoneWriteTaskEvent() {
        this(0, 1, null);
    }

    public final int getTaskID() {
        return this.taskID;
    }

    public /* synthetic */ WinkZoneWriteTaskEvent(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3);
    }

    public WinkZoneWriteTaskEvent(int i3) {
        this.taskID = i3;
    }
}
