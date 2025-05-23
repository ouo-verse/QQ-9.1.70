package com.tencent.state.event;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0004J\r\u0010\n\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/event/Event;", "T", "", "content", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "<set-?>", "", "isHandled", "()Z", "getContent", "()Ljava/lang/Object;", "peekContent", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class Event<T> {
    private final T content;
    private boolean isHandled;

    public Event(T t16) {
        this.content = t16;
    }

    public final T getContent() {
        if (this.isHandled) {
            return null;
        }
        this.isHandled = true;
        return this.content;
    }

    /* renamed from: isHandled, reason: from getter */
    public final boolean getIsHandled() {
        return this.isHandled;
    }

    public final T peekContent() {
        return this.content;
    }
}
