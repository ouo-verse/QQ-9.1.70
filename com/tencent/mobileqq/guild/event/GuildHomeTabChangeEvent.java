package com.tencent.mobileqq.guild.event;

import androidx.fragment.app.a;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00c6\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/event/GuildHomeTabChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "guildId", "", "currentTabCategoryId", "", "currentTabType", "", "index", "isFromClick", "", "(Ljava/lang/String;JIIZ)V", "getCurrentTabCategoryId", "()J", "getCurrentTabType", "()I", "getGuildId", "()Ljava/lang/String;", "getIndex", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeTabChangeEvent extends SimpleBaseEvent {
    private final long currentTabCategoryId;
    private final int currentTabType;

    @NotNull
    private final String guildId;
    private final int index;
    private final boolean isFromClick;

    public GuildHomeTabChangeEvent(@NotNull String guildId, long j3, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.currentTabCategoryId = j3;
        this.currentTabType = i3;
        this.index = i16;
        this.isFromClick = z16;
    }

    public static /* synthetic */ GuildHomeTabChangeEvent copy$default(GuildHomeTabChangeEvent guildHomeTabChangeEvent, String str, long j3, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = guildHomeTabChangeEvent.guildId;
        }
        if ((i17 & 2) != 0) {
            j3 = guildHomeTabChangeEvent.currentTabCategoryId;
        }
        long j16 = j3;
        if ((i17 & 4) != 0) {
            i3 = guildHomeTabChangeEvent.currentTabType;
        }
        int i18 = i3;
        if ((i17 & 8) != 0) {
            i16 = guildHomeTabChangeEvent.index;
        }
        int i19 = i16;
        if ((i17 & 16) != 0) {
            z16 = guildHomeTabChangeEvent.isFromClick;
        }
        return guildHomeTabChangeEvent.copy(str, j16, i18, i19, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCurrentTabCategoryId() {
        return this.currentTabCategoryId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCurrentTabType() {
        return this.currentTabType;
    }

    /* renamed from: component4, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsFromClick() {
        return this.isFromClick;
    }

    @NotNull
    public final GuildHomeTabChangeEvent copy(@NotNull String guildId, long currentTabCategoryId, int currentTabType, int index, boolean isFromClick) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return new GuildHomeTabChangeEvent(guildId, currentTabCategoryId, currentTabType, index, isFromClick);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeTabChangeEvent)) {
            return false;
        }
        GuildHomeTabChangeEvent guildHomeTabChangeEvent = (GuildHomeTabChangeEvent) other;
        if (Intrinsics.areEqual(this.guildId, guildHomeTabChangeEvent.guildId) && this.currentTabCategoryId == guildHomeTabChangeEvent.currentTabCategoryId && this.currentTabType == guildHomeTabChangeEvent.currentTabType && this.index == guildHomeTabChangeEvent.index && this.isFromClick == guildHomeTabChangeEvent.isFromClick) {
            return true;
        }
        return false;
    }

    public final long getCurrentTabCategoryId() {
        return this.currentTabCategoryId;
    }

    public final int getCurrentTabType() {
        return this.currentTabType;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final int getIndex() {
        return this.index;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.guildId.hashCode() * 31) + a.a(this.currentTabCategoryId)) * 31) + this.currentTabType) * 31) + this.index) * 31;
        boolean z16 = this.isFromClick;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public final boolean isFromClick() {
        return this.isFromClick;
    }

    @NotNull
    public String toString() {
        return "GuildHomeTabChangeEvent(guildId=" + this.guildId + ", currentTabCategoryId=" + this.currentTabCategoryId + ", currentTabType=" + this.currentTabType + ", index=" + this.index + ", isFromClick=" + this.isFromClick + ')';
    }
}
