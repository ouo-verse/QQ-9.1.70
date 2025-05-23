package gi1;

import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010-\u001a\u00020)\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002000/\u00a2\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010!\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b%\u0010\u0017R\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b'\u0010\u0017R\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,R\u0017\u0010.\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b \u00102\u00a8\u00066"}, d2 = {"Lgi1/g;", "Lgi1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "channelId", "b", "I", "l", "()I", "channelType", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "channelName", "d", "guildId", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "guildIcon", "f", "joinGuildSig", "g", "traceId", tl.h.F, "i", "cardType", DomainData.DOMAIN_NAME, "sessionId", "getCoverImageUrl", "coverImageUrl", "Lgi1/h;", "k", "Lgi1/h;", "()Lgi1/h;", "channelStatusInfo", "bottomText", "", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView$a;", "Ljava/util/List;", "()Ljava/util/List;", "avatarList", "<init>", "(JILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lgi1/h;Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: gi1.g, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ChannelSmobaMediaCardItemData extends a {

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
    @Nullable
    private final String coverImageUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ChannelStatusInfo channelStatusInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String bottomText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarList;

    public /* synthetic */ ChannelSmobaMediaCardItemData(long j3, int i3, String str, long j16, String str2, String str3, String str4, int i16, String str5, String str6, ChannelStatusInfo channelStatusInfo, String str7, List list, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, str, j16, str2, str3, str4, (i17 & 128) != 0 ? 2 : i16, str5, str6, channelStatusInfo, str7, list);
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
        if (!(other instanceof ChannelSmobaMediaCardItemData)) {
            return false;
        }
        ChannelSmobaMediaCardItemData channelSmobaMediaCardItemData = (ChannelSmobaMediaCardItemData) other;
        if (getChannelId() == channelSmobaMediaCardItemData.getChannelId() && getChannelType() == channelSmobaMediaCardItemData.getChannelType() && Intrinsics.areEqual(getChannelName(), channelSmobaMediaCardItemData.getChannelName()) && getGuildId() == channelSmobaMediaCardItemData.getGuildId() && Intrinsics.areEqual(getGuildIcon(), channelSmobaMediaCardItemData.getGuildIcon()) && Intrinsics.areEqual(getJoinGuildSig(), channelSmobaMediaCardItemData.getJoinGuildSig()) && Intrinsics.areEqual(getTraceId(), channelSmobaMediaCardItemData.getTraceId()) && this.cardType == channelSmobaMediaCardItemData.cardType && Intrinsics.areEqual(this.sessionId, channelSmobaMediaCardItemData.sessionId) && Intrinsics.areEqual(this.coverImageUrl, channelSmobaMediaCardItemData.coverImageUrl) && Intrinsics.areEqual(this.channelStatusInfo, channelSmobaMediaCardItemData.channelStatusInfo) && Intrinsics.areEqual(this.bottomText, channelSmobaMediaCardItemData.bottomText) && Intrinsics.areEqual(this.avatarList, channelSmobaMediaCardItemData.avatarList)) {
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
    public final List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> g() {
        return this.avatarList;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getBottomText() {
        return this.bottomText;
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
        int hashCode2 = (((((((((a16 + hashCode) * 31) + getJoinGuildSig().hashCode()) * 31) + getTraceId().hashCode()) * 31) + this.cardType) * 31) + this.sessionId.hashCode()) * 31;
        String str = this.coverImageUrl;
        if (str != null) {
            i3 = str.hashCode();
        }
        return ((((((hashCode2 + i3) * 31) + this.channelStatusInfo.hashCode()) * 31) + this.bottomText.hashCode()) * 31) + this.avatarList.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public String getChannelName() {
        return this.channelName;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final ChannelStatusInfo getChannelStatusInfo() {
        return this.channelStatusInfo;
    }

    /* renamed from: l, reason: from getter */
    public int getChannelType() {
        return this.channelType;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public String getGuildIcon() {
        return this.guildIcon;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    public String toString() {
        return "ChannelSmobaMediaCardItemData(channelId=" + getChannelId() + ", channelType=" + getChannelType() + ", channelName=" + getChannelName() + ", guildId=" + getGuildId() + ", guildIcon=" + getGuildIcon() + ", joinGuildSig=" + getJoinGuildSig() + ", traceId=" + getTraceId() + ", cardType=" + this.cardType + ", sessionId=" + this.sessionId + ", coverImageUrl=" + this.coverImageUrl + ", channelStatusInfo=" + this.channelStatusInfo + ", bottomText=" + this.bottomText + ", avatarList=" + this.avatarList + ")";
    }

    public ChannelSmobaMediaCardItemData(long j3, int i3, @NotNull String channelName, long j16, @Nullable String str, @NotNull String joinGuildSig, @NotNull String traceId, int i16, @NotNull String sessionId, @Nullable String str2, @NotNull ChannelStatusInfo channelStatusInfo, @NotNull String bottomText, @NotNull List<GuildHomeActiveChannelMicAvatarView.AvatarInfo> avatarList) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(channelStatusInfo, "channelStatusInfo");
        Intrinsics.checkNotNullParameter(bottomText, "bottomText");
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
        this.coverImageUrl = str2;
        this.channelStatusInfo = channelStatusInfo;
        this.bottomText = bottomText;
        this.avatarList = avatarList;
    }
}
