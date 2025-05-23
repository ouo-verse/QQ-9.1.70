package pp1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0017\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lpp1/i;", "Lpp1/g;", "other", "", "d", "c", "", "b", "toString", "", "hashCode", "", "equals", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "a", "channelId", "g", "title", "e", "coverUrl", "f", "getRoomName", "roomName", "roomId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: pp1.i, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildAVLiveActiveData extends g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String roomName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String roomId;

    public /* synthetic */ GuildAVLiveActiveData(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6);
    }

    @Override // pp1.g
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getChannelId() {
        return this.channelId;
    }

    @Override // pp1.g
    @NotNull
    public String b() {
        return "VActive " + getChannelId() + " " + this.title + " " + this.roomName;
    }

    @Override // pp1.g
    public boolean c(@NotNull g other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GuildAVLiveActiveData) && Intrinsics.areEqual(other, this)) {
            return true;
        }
        return false;
    }

    @Override // pp1.g
    public boolean d(@NotNull g other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GuildAVLiveActiveData) && Intrinsics.areEqual(other.getChannelId(), getChannelId())) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildAVLiveActiveData)) {
            return false;
        }
        GuildAVLiveActiveData guildAVLiveActiveData = (GuildAVLiveActiveData) other;
        if (Intrinsics.areEqual(this.guildId, guildAVLiveActiveData.guildId) && Intrinsics.areEqual(getChannelId(), guildAVLiveActiveData.getChannelId()) && Intrinsics.areEqual(this.title, guildAVLiveActiveData.title) && Intrinsics.areEqual(this.coverUrl, guildAVLiveActiveData.coverUrl) && Intrinsics.areEqual(this.roomName, guildAVLiveActiveData.roomName) && Intrinsics.areEqual(this.roomId, guildAVLiveActiveData.roomId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.guildId.hashCode() * 31) + getChannelId().hashCode()) * 31) + this.title.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.roomName.hashCode()) * 31) + this.roomId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildAVLiveActiveData(guildId=" + this.guildId + ", channelId=" + getChannelId() + ", title=" + this.title + ", coverUrl=" + this.coverUrl + ", roomName=" + this.roomName + ", roomId=" + this.roomId + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAVLiveActiveData(@NotNull String guildId, @NotNull String channelId, @NotNull String title, @NotNull String coverUrl, @NotNull String roomName, @NotNull String roomId) {
        super(channelId);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
        this.coverUrl = coverUrl;
        this.roomName = roomName;
        this.roomId = roomId;
    }
}
