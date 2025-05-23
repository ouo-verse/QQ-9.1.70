package os1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\tJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\u000bR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Los1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "b", "I", "getUnreadCount", "()I", "unreadCount", "c", "getUnreadType", "unreadType", "d", "getAvatarMeta", "avatarMeta", "e", "getTipStr", "tipStr", "f", "getFeedId", "feedId", "", "g", "J", "getReplyTinyId", "()J", "replyTinyId", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: os1.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class NoticeFeedMsgInfo {

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
    @NotNull
    private final String feedId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final long replyTinyId;

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoticeFeedMsgInfo)) {
            return false;
        }
        NoticeFeedMsgInfo noticeFeedMsgInfo = (NoticeFeedMsgInfo) other;
        if (Intrinsics.areEqual(this.guildId, noticeFeedMsgInfo.guildId) && this.unreadCount == noticeFeedMsgInfo.unreadCount && this.unreadType == noticeFeedMsgInfo.unreadType && Intrinsics.areEqual(this.avatarMeta, noticeFeedMsgInfo.avatarMeta) && Intrinsics.areEqual(this.tipStr, noticeFeedMsgInfo.tipStr) && Intrinsics.areEqual(this.feedId, noticeFeedMsgInfo.feedId) && this.replyTinyId == noticeFeedMsgInfo.replyTinyId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.guildId.hashCode() * 31) + this.unreadCount) * 31) + this.unreadType) * 31) + this.avatarMeta.hashCode()) * 31) + this.tipStr.hashCode()) * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.replyTinyId);
    }

    @NotNull
    public String toString() {
        return "NoticeFeedMsgInfo(guildId=" + this.guildId + ", unreadCount=" + this.unreadCount + ", unreadType=" + this.unreadType + ", avatarMeta=" + this.avatarMeta + ", tipStr=" + this.tipStr + ", feedId=" + this.feedId + ", replyTinyId=" + this.replyTinyId + ")";
    }
}
