package dg1;

import fh1.AvatarInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u001a\u0010\u001b\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010%\u001a\u0004\b \u0010&\u00a8\u0006*"}, d2 = {"Ldg1/f;", "Ldg1/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "channelId", "b", "I", "e", "()I", "channelType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "channelName", "cardType", "f", "guildId", "g", "memberCount", "i", "coverImageUrl", h.F, "j", "streamUrl", "", "Lfh1/a;", "Ljava/util/List;", "()Ljava/util/List;", "avatarList", "<init>", "(JILjava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dg1.f, reason: from toString */
/* loaded from: classes12.dex */
public final /* data */ class ChannelScreenShareCardItemData extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long channelId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int channelType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int cardType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String memberCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String coverImageUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String streamUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<AvatarInfo> avatarList;

    public ChannelScreenShareCardItemData(long j3, int i3, @NotNull String channelName, int i16, long j16, @NotNull String memberCount, @Nullable String str, @Nullable String str2, @NotNull List<AvatarInfo> avatarList) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        Intrinsics.checkNotNullParameter(memberCount, "memberCount");
        Intrinsics.checkNotNullParameter(avatarList, "avatarList");
        this.channelId = j3;
        this.channelType = i3;
        this.channelName = channelName;
        this.cardType = i16;
        this.guildId = j16;
        this.memberCount = memberCount;
        this.coverImageUrl = str;
        this.streamUrl = str2;
        this.avatarList = avatarList;
    }

    @Override // dg1.b
    /* renamed from: b, reason: from getter */
    public int getCardType() {
        return this.cardType;
    }

    @Override // dg1.b
    /* renamed from: c, reason: from getter */
    public long getChannelId() {
        return this.channelId;
    }

    @Override // dg1.b
    @NotNull
    /* renamed from: d, reason: from getter */
    public String getChannelName() {
        return this.channelName;
    }

    @Override // dg1.b
    /* renamed from: e, reason: from getter */
    public int getChannelType() {
        return this.channelType;
    }

    @Override // dg1.b
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelScreenShareCardItemData)) {
            return false;
        }
        ChannelScreenShareCardItemData channelScreenShareCardItemData = (ChannelScreenShareCardItemData) other;
        if (getChannelId() == channelScreenShareCardItemData.getChannelId() && getChannelType() == channelScreenShareCardItemData.getChannelType() && Intrinsics.areEqual(getChannelName(), channelScreenShareCardItemData.getChannelName()) && getCardType() == channelScreenShareCardItemData.getCardType() && getGuildId() == channelScreenShareCardItemData.getGuildId() && Intrinsics.areEqual(getMemberCount(), channelScreenShareCardItemData.getMemberCount()) && Intrinsics.areEqual(this.coverImageUrl, channelScreenShareCardItemData.coverImageUrl) && Intrinsics.areEqual(this.streamUrl, channelScreenShareCardItemData.streamUrl) && Intrinsics.areEqual(this.avatarList, channelScreenShareCardItemData.avatarList)) {
            return true;
        }
        return false;
    }

    @Override // dg1.b
    /* renamed from: f, reason: from getter */
    public long getGuildId() {
        return this.guildId;
    }

    @Override // dg1.b
    @NotNull
    /* renamed from: g, reason: from getter */
    public String getMemberCount() {
        return this.memberCount;
    }

    @NotNull
    public final List<AvatarInfo> h() {
        return this.avatarList;
    }

    @Override // dg1.b
    public int hashCode() {
        int hashCode;
        int a16 = ((((((((((androidx.fragment.app.a.a(getChannelId()) * 31) + getChannelType()) * 31) + getChannelName().hashCode()) * 31) + getCardType()) * 31) + androidx.fragment.app.a.a(getGuildId())) * 31) + getMemberCount().hashCode()) * 31;
        String str = this.coverImageUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        String str2 = this.streamUrl;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i16 + i3) * 31) + this.avatarList.hashCode();
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getStreamUrl() {
        return this.streamUrl;
    }

    @NotNull
    public String toString() {
        return "ChannelScreenShareCardItemData(channelId=" + getChannelId() + ", channelType=" + getChannelType() + ", channelName=" + getChannelName() + ", cardType=" + getCardType() + ", guildId=" + getGuildId() + ", memberCount=" + getMemberCount() + ", coverImageUrl=" + this.coverImageUrl + ", streamUrl=" + this.streamUrl + ", avatarList=" + this.avatarList + ")";
    }
}
