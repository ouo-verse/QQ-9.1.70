package com.tencent.mobileqq.guild.summary;

import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yt1.DraftInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b\u000e\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/summary/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "channelId", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "d", "()Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "setLastMessage", "(Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;)V", "lastMessage", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "e", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "setUnreadInfo", "(Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;)V", "unreadInfo", "Lyt1/a;", "Lyt1/a;", "()Lyt1/a;", "setDraftInfo", "(Lyt1/a;)V", "draftInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;Lyt1/a;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.summary.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildSummaryData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private LastMessage lastMessage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private UnreadInfo unreadInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private DraftInfo draftInfo;

    public GuildSummaryData(@NotNull String guildId, @NotNull String channelId, @Nullable LastMessage lastMessage, @Nullable UnreadInfo unreadInfo, @Nullable DraftInfo draftInfo) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.lastMessage = lastMessage;
        this.unreadInfo = unreadInfo;
        this.draftInfo = draftInfo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final DraftInfo getDraftInfo() {
        return this.draftInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final LastMessage getLastMessage() {
        return this.lastMessage;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final UnreadInfo getUnreadInfo() {
        return this.unreadInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildSummaryData)) {
            return false;
        }
        GuildSummaryData guildSummaryData = (GuildSummaryData) other;
        if (Intrinsics.areEqual(this.guildId, guildSummaryData.guildId) && Intrinsics.areEqual(this.channelId, guildSummaryData.channelId) && Intrinsics.areEqual(this.lastMessage, guildSummaryData.lastMessage) && Intrinsics.areEqual(this.unreadInfo, guildSummaryData.unreadInfo) && Intrinsics.areEqual(this.draftInfo, guildSummaryData.draftInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31;
        LastMessage lastMessage = this.lastMessage;
        int i3 = 0;
        if (lastMessage == null) {
            hashCode = 0;
        } else {
            hashCode = lastMessage.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        UnreadInfo unreadInfo = this.unreadInfo;
        if (unreadInfo == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = unreadInfo.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        DraftInfo draftInfo = this.draftInfo;
        if (draftInfo != null) {
            i3 = draftInfo.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "GuildSummaryData(guildId=" + this.guildId + ", channelId=" + this.channelId + ", lastMessage=" + this.lastMessage + ", unreadInfo=" + this.unreadInfo + ", draftInfo=" + this.draftInfo + ')';
    }
}
