package gi1;

import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0+\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010!\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b \u0010\u0013R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b#\u0010\u0017R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010\u0017R\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0019\u0010*\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b)\u0010\u0017R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006\u00a2\u0006\f\n\u0004\b#\u0010-\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lgi1/f;", "Lgi1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "channelId", "b", "I", "i", "()I", "channelType", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "channelName", "d", "guildId", "e", "k", "guildIcon", "f", "joinGuildSig", "g", "traceId", "cardType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "sessionId", "j", "l", "memberCount", "coverImageUrl", "getStreamUrl", "streamUrl", "", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "Ljava/util/List;", "getAvatarList", "()Ljava/util/List;", "avatarList", "<init>", "(JILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gi1.f, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ChannelScreenShareCardItemData extends a {

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
    private final int cardType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String sessionId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String memberCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String coverImageUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String streamUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarList;

    public /* synthetic */ ChannelScreenShareCardItemData(long j3, int i3, String str, long j16, String str2, String str3, String str4, int i16, String str5, String str6, String str7, String str8, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, str, j16, str2, str3, str4, (i17 & 128) != 0 ? 7 : i16, str5, str6, str7, str8, list);
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
        if (!(other instanceof ChannelScreenShareCardItemData)) {
            return false;
        }
        ChannelScreenShareCardItemData channelScreenShareCardItemData = (ChannelScreenShareCardItemData) other;
        if (getChannelId() == channelScreenShareCardItemData.getChannelId() && getChannelType() == channelScreenShareCardItemData.getChannelType() && Intrinsics.areEqual(getChannelName(), channelScreenShareCardItemData.getChannelName()) && getGuildId() == channelScreenShareCardItemData.getGuildId() && Intrinsics.areEqual(getGuildIcon(), channelScreenShareCardItemData.getGuildIcon()) && Intrinsics.areEqual(getJoinGuildSig(), channelScreenShareCardItemData.getJoinGuildSig()) && Intrinsics.areEqual(getTraceId(), channelScreenShareCardItemData.getTraceId()) && this.cardType == channelScreenShareCardItemData.cardType && Intrinsics.areEqual(this.sessionId, channelScreenShareCardItemData.sessionId) && Intrinsics.areEqual(this.memberCount, channelScreenShareCardItemData.memberCount) && Intrinsics.areEqual(this.coverImageUrl, channelScreenShareCardItemData.coverImageUrl) && Intrinsics.areEqual(this.streamUrl, channelScreenShareCardItemData.streamUrl) && Intrinsics.areEqual(this.avatarList, channelScreenShareCardItemData.avatarList)) {
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

    /* renamed from: g, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public String getChannelName() {
        return this.channelName;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int a16 = ((((((androidx.fragment.app.a.a(getChannelId()) * 31) + getChannelType()) * 31) + getChannelName().hashCode()) * 31) + androidx.fragment.app.a.a(getGuildId())) * 31;
        int i3 = 0;
        if (getGuildIcon() == null) {
            hashCode = 0;
        } else {
            hashCode = getGuildIcon().hashCode();
        }
        int hashCode3 = (((((((((((a16 + hashCode) * 31) + getJoinGuildSig().hashCode()) * 31) + getTraceId().hashCode()) * 31) + this.cardType) * 31) + this.sessionId.hashCode()) * 31) + this.memberCount.hashCode()) * 31;
        String str = this.coverImageUrl;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i16 = (hashCode3 + hashCode2) * 31;
        String str2 = this.streamUrl;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i16 + i3) * 31) + this.avatarList.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public int getChannelType() {
        return this.channelType;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public String getGuildIcon() {
        return this.guildIcon;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getMemberCount() {
        return this.memberCount;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public String toString() {
        return "ChannelScreenShareCardItemData(channelId=" + getChannelId() + ", channelType=" + getChannelType() + ", channelName=" + getChannelName() + ", guildId=" + getGuildId() + ", guildIcon=" + getGuildIcon() + ", joinGuildSig=" + getJoinGuildSig() + ", traceId=" + getTraceId() + ", cardType=" + this.cardType + ", sessionId=" + this.sessionId + ", memberCount=" + this.memberCount + ", coverImageUrl=" + this.coverImageUrl + ", streamUrl=" + this.streamUrl + ", avatarList=" + this.avatarList + ")";
    }

    public ChannelScreenShareCardItemData(long j3, int i3, @NotNull String channelName, long j16, @Nullable String str, @NotNull String joinGuildSig, @NotNull String traceId, int i16, @NotNull String sessionId, @NotNull String memberCount, @Nullable String str2, @Nullable String str3, @NotNull List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarList) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(memberCount, "memberCount");
        Intrinsics.checkNotNullParameter(avatarList, "avatarList");
        this.channelId = j3;
        this.channelType = i3;
        this.channelName = channelName;
        this.guildId = j16;
        this.guildIcon = str;
        this.joinGuildSig = joinGuildSig;
        this.traceId = traceId;
        this.cardType = i16;
        this.sessionId = sessionId;
        this.memberCount = memberCount;
        this.coverImageUrl = str2;
        this.streamUrl = str3;
        this.avatarList = avatarList;
    }
}
