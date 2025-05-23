package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundlePreloadState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildWebBundleStateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "state", "Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundlePreloadState;", "timeCost", "", "(Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundlePreloadState;J)V", "getState", "()Lcom/tencent/mobileqq/guild/feed/webbundle/GuildWebBundlePreloadState;", "getTimeCost", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildWebBundleStateEvent extends SimpleBaseEvent {

    @NotNull
    private final GuildWebBundlePreloadState state;
    private final long timeCost;

    public GuildWebBundleStateEvent(@NotNull GuildWebBundlePreloadState state, long j3) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.timeCost = j3;
    }

    public static /* synthetic */ GuildWebBundleStateEvent copy$default(GuildWebBundleStateEvent guildWebBundleStateEvent, GuildWebBundlePreloadState guildWebBundlePreloadState, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            guildWebBundlePreloadState = guildWebBundleStateEvent.state;
        }
        if ((i3 & 2) != 0) {
            j3 = guildWebBundleStateEvent.timeCost;
        }
        return guildWebBundleStateEvent.copy(guildWebBundlePreloadState, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final GuildWebBundlePreloadState getState() {
        return this.state;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimeCost() {
        return this.timeCost;
    }

    @NotNull
    public final GuildWebBundleStateEvent copy(@NotNull GuildWebBundlePreloadState state, long timeCost) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new GuildWebBundleStateEvent(state, timeCost);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWebBundleStateEvent)) {
            return false;
        }
        GuildWebBundleStateEvent guildWebBundleStateEvent = (GuildWebBundleStateEvent) other;
        if (this.state == guildWebBundleStateEvent.state && this.timeCost == guildWebBundleStateEvent.timeCost) {
            return true;
        }
        return false;
    }

    @NotNull
    public final GuildWebBundlePreloadState getState() {
        return this.state;
    }

    public final long getTimeCost() {
        return this.timeCost;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + androidx.fragment.app.a.a(this.timeCost);
    }

    @NotNull
    public String toString() {
        return "GuildWebBundleStateEvent(state=" + this.state + ", timeCost=" + this.timeCost + ")";
    }
}
