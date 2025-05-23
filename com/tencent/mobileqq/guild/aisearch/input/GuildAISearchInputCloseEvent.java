package com.tencent.mobileqq.guild.aisearch.input;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/input/GuildAISearchInputCloseEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "isCloseActivity", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final /* data */ class GuildAISearchInputCloseEvent extends SimpleBaseEvent {
    private final boolean isCloseActivity;

    public GuildAISearchInputCloseEvent() {
        this(false, 1, null);
    }

    public static /* synthetic */ GuildAISearchInputCloseEvent copy$default(GuildAISearchInputCloseEvent guildAISearchInputCloseEvent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = guildAISearchInputCloseEvent.isCloseActivity;
        }
        return guildAISearchInputCloseEvent.copy(z16);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsCloseActivity() {
        return this.isCloseActivity;
    }

    @NotNull
    public final GuildAISearchInputCloseEvent copy(boolean isCloseActivity) {
        return new GuildAISearchInputCloseEvent(isCloseActivity);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof GuildAISearchInputCloseEvent) && this.isCloseActivity == ((GuildAISearchInputCloseEvent) other).isCloseActivity) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z16 = this.isCloseActivity;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public final boolean isCloseActivity() {
        return this.isCloseActivity;
    }

    @NotNull
    public String toString() {
        return "GuildAISearchInputCloseEvent(isCloseActivity=" + this.isCloseActivity + ")";
    }

    public /* synthetic */ GuildAISearchInputCloseEvent(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }

    public GuildAISearchInputCloseEvent(boolean z16) {
        this.isCloseActivity = z16;
    }
}
