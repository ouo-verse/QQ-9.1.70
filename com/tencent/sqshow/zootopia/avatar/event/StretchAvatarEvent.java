package com.tencent.sqshow.zootopia.avatar.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/event/StretchAvatarEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "targetState", "", "withAnim", "", "(IZ)V", "getTargetState", "()I", "getWithAnim", "()Z", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class StretchAvatarEvent extends SimpleBaseEvent {
    private final int targetState;
    private final boolean withAnim;

    public /* synthetic */ StretchAvatarEvent(int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? true : z16);
    }

    public final int getTargetState() {
        return this.targetState;
    }

    public final boolean getWithAnim() {
        return this.withAnim;
    }

    public StretchAvatarEvent(int i3, boolean z16) {
        this.targetState = i3;
        this.withAnim = z16;
    }
}
