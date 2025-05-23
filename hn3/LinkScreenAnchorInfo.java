package hn3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\n\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lhn3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "roomId", "b", "e", "uin", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "nick", "avatar", "I", "()I", "liveType", "<init>", "(JJLjava/lang/String;Ljava/lang/String;I)V", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hn3.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class LinkScreenAnchorInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int liveType;

    public LinkScreenAnchorInfo(long j3, long j16, @NotNull String nick, @NotNull String avatar, int i3) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        this.roomId = j3;
        this.uin = j16;
        this.nick = nick;
        this.avatar = avatar;
        this.liveType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: b, reason: from getter */
    public final int getLiveType() {
        return this.liveType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: d, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: e, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkScreenAnchorInfo)) {
            return false;
        }
        LinkScreenAnchorInfo linkScreenAnchorInfo = (LinkScreenAnchorInfo) other;
        if (this.roomId == linkScreenAnchorInfo.roomId && this.uin == linkScreenAnchorInfo.uin && Intrinsics.areEqual(this.nick, linkScreenAnchorInfo.nick) && Intrinsics.areEqual(this.avatar, linkScreenAnchorInfo.avatar) && this.liveType == linkScreenAnchorInfo.liveType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((androidx.fragment.app.a.a(this.roomId) * 31) + androidx.fragment.app.a.a(this.uin)) * 31) + this.nick.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.liveType;
    }

    @NotNull
    public String toString() {
        return "LinkScreenAnchorInfo(roomId=" + this.roomId + ", uin=" + this.uin + ", nick=" + this.nick + ", avatar='" + this.avatar + "', liveType:" + this.liveType + ')';
    }
}
