package gi1;

import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020(0'\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010 \u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b!\u0010\u0017R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017R\u0019\u0010&\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b#\u0010\u0017R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006\u00a2\u0006\f\n\u0004\b$\u0010)\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lgi1/d;", "Lgi1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "channelId", "b", "I", tl.h.F, "()I", "channelType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "channelName", "d", "guildId", "e", "j", "guildIcon", "f", "joinGuildSig", "traceId", "l", "roomId", "i", "k", "memberCount", "coverImageUrl", "", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "Ljava/util/List;", "getAvatarList", "()Ljava/util/List;", "avatarList", "<init>", "(JILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gi1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ChannelLiveCardItemData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long channelId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int channelType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String guildIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String joinGuildSig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String traceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String memberCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String coverImageUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarList;

    public ChannelLiveCardItemData(long j3, int i3, @NotNull String channelName, long j16, @Nullable String str, @NotNull String joinGuildSig, @NotNull String traceId, @NotNull String roomId, @NotNull String memberCount, @Nullable String str2, @NotNull List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarList) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(memberCount, "memberCount");
        Intrinsics.checkNotNullParameter(avatarList, "avatarList");
        this.channelId = j3;
        this.channelType = i3;
        this.channelName = channelName;
        this.guildId = j16;
        this.guildIcon = str;
        this.joinGuildSig = joinGuildSig;
        this.traceId = traceId;
        this.roomId = roomId;
        this.memberCount = memberCount;
        this.coverImageUrl = str2;
        this.avatarList = avatarList;
    }

    @Override // gi1.a
    /* renamed from: c, reason: from getter */
    public long getChannelId() {
        return this.channelId;
    }

    @Override // gi1.a
    /* renamed from: d, reason: from getter */
    public long getGuildId() {
        return this.guildId;
    }

    @Override // gi1.a
    @NotNull
    /* renamed from: e, reason: from getter */
    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelLiveCardItemData)) {
            return false;
        }
        ChannelLiveCardItemData channelLiveCardItemData = (ChannelLiveCardItemData) other;
        if (getChannelId() == channelLiveCardItemData.getChannelId() && getChannelType() == channelLiveCardItemData.getChannelType() && Intrinsics.areEqual(getChannelName(), channelLiveCardItemData.getChannelName()) && getGuildId() == channelLiveCardItemData.getGuildId() && Intrinsics.areEqual(getGuildIcon(), channelLiveCardItemData.getGuildIcon()) && Intrinsics.areEqual(getJoinGuildSig(), channelLiveCardItemData.getJoinGuildSig()) && Intrinsics.areEqual(getTraceId(), channelLiveCardItemData.getTraceId()) && Intrinsics.areEqual(this.roomId, channelLiveCardItemData.roomId) && Intrinsics.areEqual(this.memberCount, channelLiveCardItemData.memberCount) && Intrinsics.areEqual(this.coverImageUrl, channelLiveCardItemData.coverImageUrl) && Intrinsics.areEqual(this.avatarList, channelLiveCardItemData.avatarList)) {
            return true;
        }
        return false;
    }

    @Override // gi1.a
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTraceId() {
        return this.traceId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public String getChannelName() {
        return this.channelName;
    }

    /* renamed from: h, reason: from getter */
    public int getChannelType() {
        return this.channelType;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((((((androidx.fragment.app.a.a(getChannelId()) * 31) + getChannelType()) * 31) + getChannelName().hashCode()) * 31) + androidx.fragment.app.a.a(getGuildId())) * 31;
        int i3 = 0;
        if (getGuildIcon() == null) {
            hashCode = 0;
        } else {
            hashCode = getGuildIcon().hashCode();
        }
        int hashCode2 = (((((((((a16 + hashCode) * 31) + getJoinGuildSig().hashCode()) * 31) + getTraceId().hashCode()) * 31) + this.roomId.hashCode()) * 31) + this.memberCount.hashCode()) * 31;
        String str = this.coverImageUrl;
        if (str != null) {
            i3 = str.hashCode();
        }
        return ((hashCode2 + i3) * 31) + this.avatarList.hashCode();
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public String getGuildIcon() {
        return this.guildIcon;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getMemberCount() {
        return this.memberCount;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    @NotNull
    public String toString() {
        return "ChannelLiveCardItemData(channelId=" + getChannelId() + ", channelType=" + getChannelType() + ", channelName=" + getChannelName() + ", guildId=" + getGuildId() + ", guildIcon=" + getGuildIcon() + ", joinGuildSig=" + getJoinGuildSig() + ", traceId=" + getTraceId() + ", roomId=" + this.roomId + ", memberCount=" + this.memberCount + ", coverImageUrl=" + this.coverImageUrl + ", avatarList=" + this.avatarList + ")";
    }
}
