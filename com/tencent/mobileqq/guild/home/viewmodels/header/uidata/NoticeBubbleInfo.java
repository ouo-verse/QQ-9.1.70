package com.tencent.mobileqq.guild.home.viewmodels.header.uidata;

import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\u0003BK\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/g;", "", "", "a", "", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "I", "c", "()I", "unreadCount", "d", "unreadType", "getAvatarMeta", "avatarMeta", "e", "getTipStr", "tipStr", "", "f", "J", "getReplyTinyId", "()J", "replyTinyId", "g", "getType", "type", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;JI)V", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.g, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class NoticeBubbleInfo {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int unreadCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int unreadType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarMeta;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tipStr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long replyTinyId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/g$a;", "", "", "guildId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "interactiveNoticeMsgInfo", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/g;", "a", "", "DATONG_TYPE_DOT", "I", "DATONG_TYPE_GRAY", "DATONG_TYPE_RED", "UNREAD_TYPE_DOT", "UNREAD_TYPE_GRAY", "UNREAD_TYPE_RED", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.viewmodels.header.uidata.g$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NoticeBubbleInfo a(@NotNull String guildId, @Nullable GuildInteractiveNotificationItem interactiveNoticeMsgInfo) {
            int i3;
            int i16;
            String str;
            long j3;
            int i17;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (interactiveNoticeMsgInfo != null) {
                i3 = interactiveNoticeMsgInfo.count;
            } else {
                i3 = 0;
            }
            if (interactiveNoticeMsgInfo != null) {
                i16 = interactiveNoticeMsgInfo.unreadType;
            } else {
                i16 = 0;
            }
            String str2 = null;
            if (interactiveNoticeMsgInfo != null) {
                str = interactiveNoticeMsgInfo.avatarMeta;
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (interactiveNoticeMsgInfo != null) {
                str2 = interactiveNoticeMsgInfo.highLightStr;
            }
            if (str2 != null) {
                str3 = str2;
            }
            if (interactiveNoticeMsgInfo != null) {
                j3 = interactiveNoticeMsgInfo.replyTinyId;
            } else {
                j3 = 0;
            }
            if (interactiveNoticeMsgInfo != null) {
                i17 = interactiveNoticeMsgInfo.type;
            } else {
                i17 = 0;
            }
            return new NoticeBubbleInfo(guildId, i3, i16, str, str3, j3, i17);
        }

        Companion() {
        }
    }

    public NoticeBubbleInfo(@NotNull String guildId, int i3, int i16, @NotNull String avatarMeta, @NotNull String tipStr, long j3, int i17) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        Intrinsics.checkNotNullParameter(tipStr, "tipStr");
        this.guildId = guildId;
        this.unreadCount = i3;
        this.unreadType = i16;
        this.avatarMeta = avatarMeta;
        this.tipStr = tipStr;
        this.replyTinyId = j3;
        this.type = i17;
    }

    public final int a() {
        if (this.unreadCount == 0) {
            return 0;
        }
        int i3 = this.unreadType;
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            if (i3 != 4) {
                return 0;
            }
            return 1;
        }
        return 3;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* renamed from: d, reason: from getter */
    public final int getUnreadType() {
        return this.unreadType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoticeBubbleInfo)) {
            return false;
        }
        NoticeBubbleInfo noticeBubbleInfo = (NoticeBubbleInfo) other;
        if (Intrinsics.areEqual(this.guildId, noticeBubbleInfo.guildId) && this.unreadCount == noticeBubbleInfo.unreadCount && this.unreadType == noticeBubbleInfo.unreadType && Intrinsics.areEqual(this.avatarMeta, noticeBubbleInfo.avatarMeta) && Intrinsics.areEqual(this.tipStr, noticeBubbleInfo.tipStr) && this.replyTinyId == noticeBubbleInfo.replyTinyId && this.type == noticeBubbleInfo.type) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.guildId.hashCode() * 31) + this.unreadCount) * 31) + this.unreadType) * 31) + this.avatarMeta.hashCode()) * 31) + this.tipStr.hashCode()) * 31) + androidx.fragment.app.a.a(this.replyTinyId)) * 31) + this.type;
    }

    @NotNull
    public String toString() {
        return "NoticeBubbleInfo(guildId=" + this.guildId + ", unreadCount=" + this.unreadCount + ", unreadType=" + this.unreadType + ", avatarMeta=" + this.avatarMeta + ", tipStr=" + this.tipStr + ", replyTinyId=" + this.replyTinyId + ", type=" + this.type + ")";
    }

    public /* synthetic */ NoticeBubbleInfo(String str, int i3, int i16, String str2, String str3, long j3, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i18 & 2) != 0 ? 0 : i3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? "" : str2, (i18 & 16) == 0 ? str3 : "", (i18 & 32) != 0 ? 0L : j3, (i18 & 64) == 0 ? i17 : 0);
    }
}
