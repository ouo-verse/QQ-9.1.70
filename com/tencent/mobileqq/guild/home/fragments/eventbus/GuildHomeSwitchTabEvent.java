package com.tencent.mobileqq.guild.home.fragments.eventbus;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/eventbus/GuildHomeSwitchTabEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "switchMainTab", "", "categoryId", "", "channelId", "", "(ZJLjava/lang/String;)V", "getCategoryId", "()J", "getChannelId", "()Ljava/lang/String;", "getSwitchMainTab", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeSwitchTabEvent extends SimpleBaseEvent {
    private final long categoryId;

    @NotNull
    private final String channelId;
    private final boolean switchMainTab;

    public /* synthetic */ GuildHomeSwitchTabEvent(boolean z16, long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, j3, (i3 & 4) != 0 ? "" : str);
    }

    public static /* synthetic */ GuildHomeSwitchTabEvent copy$default(GuildHomeSwitchTabEvent guildHomeSwitchTabEvent, boolean z16, long j3, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = guildHomeSwitchTabEvent.switchMainTab;
        }
        if ((i3 & 2) != 0) {
            j3 = guildHomeSwitchTabEvent.categoryId;
        }
        if ((i3 & 4) != 0) {
            str = guildHomeSwitchTabEvent.channelId;
        }
        return guildHomeSwitchTabEvent.copy(z16, j3, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSwitchMainTab() {
        return this.switchMainTab;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final GuildHomeSwitchTabEvent copy(boolean switchMainTab, long categoryId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return new GuildHomeSwitchTabEvent(switchMainTab, categoryId, channelId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeSwitchTabEvent)) {
            return false;
        }
        GuildHomeSwitchTabEvent guildHomeSwitchTabEvent = (GuildHomeSwitchTabEvent) other;
        if (this.switchMainTab == guildHomeSwitchTabEvent.switchMainTab && this.categoryId == guildHomeSwitchTabEvent.categoryId && Intrinsics.areEqual(this.channelId, guildHomeSwitchTabEvent.channelId)) {
            return true;
        }
        return false;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    public final boolean getSwitchMainTab() {
        return this.switchMainTab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.switchMainTab;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + a.a(this.categoryId)) * 31) + this.channelId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildHomeSwitchTabEvent(switchMainTab=" + this.switchMainTab + ", categoryId=" + this.categoryId + ", channelId=" + this.channelId + ")";
    }

    public GuildHomeSwitchTabEvent(boolean z16, long j3, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.switchMainTab = z16;
        this.categoryId = j3;
        this.channelId = channelId;
    }
}
