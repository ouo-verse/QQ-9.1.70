package com.tencent.guild.aio.activity;

import com.tencent.aio.data.AIOContact;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/activity/GuildChatFragmentHiddenChangedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "aioContact", "Lcom/tencent/aio/data/AIOContact;", "hidden", "", "(Lcom/tencent/aio/data/AIOContact;Z)V", "getAioContact", "()Lcom/tencent/aio/data/AIOContact;", "getHidden", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class GuildChatFragmentHiddenChangedEvent extends SimpleBaseEvent {

    @NotNull
    private final AIOContact aioContact;
    private final boolean hidden;

    public GuildChatFragmentHiddenChangedEvent(@NotNull AIOContact aioContact, boolean z16) {
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        this.aioContact = aioContact;
        this.hidden = z16;
    }

    public static /* synthetic */ GuildChatFragmentHiddenChangedEvent copy$default(GuildChatFragmentHiddenChangedEvent guildChatFragmentHiddenChangedEvent, AIOContact aIOContact, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aIOContact = guildChatFragmentHiddenChangedEvent.aioContact;
        }
        if ((i3 & 2) != 0) {
            z16 = guildChatFragmentHiddenChangedEvent.hidden;
        }
        return guildChatFragmentHiddenChangedEvent.copy(aIOContact, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final AIOContact getAioContact() {
        return this.aioContact;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHidden() {
        return this.hidden;
    }

    @NotNull
    public final GuildChatFragmentHiddenChangedEvent copy(@NotNull AIOContact aioContact, boolean hidden) {
        Intrinsics.checkNotNullParameter(aioContact, "aioContact");
        return new GuildChatFragmentHiddenChangedEvent(aioContact, hidden);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildChatFragmentHiddenChangedEvent)) {
            return false;
        }
        GuildChatFragmentHiddenChangedEvent guildChatFragmentHiddenChangedEvent = (GuildChatFragmentHiddenChangedEvent) other;
        if (Intrinsics.areEqual(this.aioContact, guildChatFragmentHiddenChangedEvent.aioContact) && this.hidden == guildChatFragmentHiddenChangedEvent.hidden) {
            return true;
        }
        return false;
    }

    @NotNull
    public final AIOContact getAioContact() {
        return this.aioContact;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.aioContact.hashCode() * 31;
        boolean z16 = this.hidden;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "GuildChatFragmentHiddenChangedEvent(aioContact=" + this.aioContact + ", hidden=" + this.hidden + ")";
    }
}
