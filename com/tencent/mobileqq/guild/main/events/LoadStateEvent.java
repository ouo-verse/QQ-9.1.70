package com.tencent.mobileqq.guild.main.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/main/events/LoadStateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "state", "Lcom/tencent/mobileqq/guild/main/events/LoadStateEvent$LoadState;", "(Lcom/tencent/mobileqq/guild/main/events/LoadStateEvent$LoadState;)V", "getState", "()Lcom/tencent/mobileqq/guild/main/events/LoadStateEvent$LoadState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "LoadState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final /* data */ class LoadStateEvent extends SimpleBaseEvent {

    @NotNull
    private final LoadState state;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/main/events/LoadStateEvent$LoadState;", "", "(Ljava/lang/String;I)V", "CHANNEL_LIST_VIEW_ITEM_READY", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum LoadState {
        CHANNEL_LIST_VIEW_ITEM_READY
    }

    public LoadStateEvent(@NotNull LoadState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
    }

    public static /* synthetic */ LoadStateEvent copy$default(LoadStateEvent loadStateEvent, LoadState loadState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            loadState = loadStateEvent.state;
        }
        return loadStateEvent.copy(loadState);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final LoadState getState() {
        return this.state;
    }

    @NotNull
    public final LoadStateEvent copy(@NotNull LoadState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new LoadStateEvent(state);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LoadStateEvent) && this.state == ((LoadStateEvent) other).state) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LoadState getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    @NotNull
    public String toString() {
        return "LoadStateEvent(state=" + this.state + ")";
    }
}
