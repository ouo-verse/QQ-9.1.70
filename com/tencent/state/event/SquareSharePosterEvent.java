package com.tencent.state.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/event/SquareSharePosterEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isShare", "", "(Z)V", "()Z", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class SquareSharePosterEvent extends SimpleBaseEvent {
    private final boolean isShare;

    public SquareSharePosterEvent() {
        this(false, 1, null);
    }

    /* renamed from: isShare, reason: from getter */
    public final boolean getIsShare() {
        return this.isShare;
    }

    public String toString() {
        return "SquareSharePosterEvent(isShare=" + this.isShare + ')';
    }

    public SquareSharePosterEvent(boolean z16) {
        this.isShare = z16;
    }

    public /* synthetic */ SquareSharePosterEvent(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
