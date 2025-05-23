package com.tencent.mobileqq.guild.profile.profilecard.joined.detail;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00b1\u0001\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020/\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u0002040/\u0012\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u0002060/\u00a2\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010%\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\t\u0010\u0014R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014R\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b*\u0010\fR\u0017\u0010.\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b-\u0010\fR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b0\u00102R\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002040/8\u0006\u00a2\u0006\f\n\u0004\b$\u00101\u001a\u0004\b(\u00102R\u001d\u00107\u001a\b\u0012\u0004\u0012\u0002060/8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b,\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/joined/detail/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "guildId", "b", "k", "joinGuildSig", "c", "I", "j", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "joinGuildFlag", "d", "g", "guildName", "e", tl.h.F, "guildProfile", "guildIconUrl", "guildCoverUrl", "Z", "i", "()Z", "hasMedal", "p", "isLeftItem", "channelStatus", "channelStatusText", "l", "friendJoinedNum", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "onlineNumberString", DomainData.DOMAIN_NAME, "getTopTagText", "topTagText", "", "o", "Ljava/util/List;", "()Ljava/util/List;", "wuJiTags", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfoList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendLabel;", "tagList", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.profile.profilecard.joined.detail.i, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildProfileJoinedData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String joinGuildSig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int joinGuildFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildProfile;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildIconUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildCoverUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasMedal;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isLeftItem;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int channelStatus;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelStatusText;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int friendJoinedNum;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String onlineNumberString;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String topTagText;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> wuJiTags;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProMedalInfo> medalInfoList;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProRecommendLabel> tagList;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildProfileJoinedData(@NotNull String guildId, @Nullable String str, int i3, @NotNull String guildName, @NotNull String guildProfile, @NotNull String guildIconUrl, @NotNull String guildCoverUrl, boolean z16, boolean z17, int i16, @NotNull String channelStatusText, int i17, @NotNull String onlineNumberString, @NotNull String topTagText, @NotNull List<String> wuJiTags, @NotNull List<? extends IGProMedalInfo> medalInfoList, @NotNull List<? extends IGProRecommendLabel> tagList) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(guildProfile, "guildProfile");
        Intrinsics.checkNotNullParameter(guildIconUrl, "guildIconUrl");
        Intrinsics.checkNotNullParameter(guildCoverUrl, "guildCoverUrl");
        Intrinsics.checkNotNullParameter(channelStatusText, "channelStatusText");
        Intrinsics.checkNotNullParameter(onlineNumberString, "onlineNumberString");
        Intrinsics.checkNotNullParameter(topTagText, "topTagText");
        Intrinsics.checkNotNullParameter(wuJiTags, "wuJiTags");
        Intrinsics.checkNotNullParameter(medalInfoList, "medalInfoList");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        this.guildId = guildId;
        this.joinGuildSig = str;
        this.joinGuildFlag = i3;
        this.guildName = guildName;
        this.guildProfile = guildProfile;
        this.guildIconUrl = guildIconUrl;
        this.guildCoverUrl = guildCoverUrl;
        this.hasMedal = z16;
        this.isLeftItem = z17;
        this.channelStatus = i16;
        this.channelStatusText = channelStatusText;
        this.friendJoinedNum = i17;
        this.onlineNumberString = onlineNumberString;
        this.topTagText = topTagText;
        this.wuJiTags = wuJiTags;
        this.medalInfoList = medalInfoList;
        this.tagList = tagList;
    }

    /* renamed from: a, reason: from getter */
    public final int getChannelStatus() {
        return this.channelStatus;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelStatusText() {
        return this.channelStatusText;
    }

    /* renamed from: c, reason: from getter */
    public final int getFriendJoinedNum() {
        return this.friendJoinedNum;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getGuildCoverUrl() {
        return this.guildCoverUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildIconUrl() {
        return this.guildIconUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildProfileJoinedData)) {
            return false;
        }
        GuildProfileJoinedData guildProfileJoinedData = (GuildProfileJoinedData) other;
        if (Intrinsics.areEqual(this.guildId, guildProfileJoinedData.guildId) && Intrinsics.areEqual(this.joinGuildSig, guildProfileJoinedData.joinGuildSig) && this.joinGuildFlag == guildProfileJoinedData.joinGuildFlag && Intrinsics.areEqual(this.guildName, guildProfileJoinedData.guildName) && Intrinsics.areEqual(this.guildProfile, guildProfileJoinedData.guildProfile) && Intrinsics.areEqual(this.guildIconUrl, guildProfileJoinedData.guildIconUrl) && Intrinsics.areEqual(this.guildCoverUrl, guildProfileJoinedData.guildCoverUrl) && this.hasMedal == guildProfileJoinedData.hasMedal && this.isLeftItem == guildProfileJoinedData.isLeftItem && this.channelStatus == guildProfileJoinedData.channelStatus && Intrinsics.areEqual(this.channelStatusText, guildProfileJoinedData.channelStatusText) && this.friendJoinedNum == guildProfileJoinedData.friendJoinedNum && Intrinsics.areEqual(this.onlineNumberString, guildProfileJoinedData.onlineNumberString) && Intrinsics.areEqual(this.topTagText, guildProfileJoinedData.topTagText) && Intrinsics.areEqual(this.wuJiTags, guildProfileJoinedData.wuJiTags) && Intrinsics.areEqual(this.medalInfoList, guildProfileJoinedData.medalInfoList) && Intrinsics.areEqual(this.tagList, guildProfileJoinedData.tagList)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getGuildProfile() {
        return this.guildProfile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.guildId.hashCode() * 31;
        String str = this.joinGuildSig;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((((((((((hashCode2 + hashCode) * 31) + this.joinGuildFlag) * 31) + this.guildName.hashCode()) * 31) + this.guildProfile.hashCode()) * 31) + this.guildIconUrl.hashCode()) * 31) + this.guildCoverUrl.hashCode()) * 31;
        boolean z16 = this.hasMedal;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode3 + i16) * 31;
        boolean z17 = this.isLeftItem;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((((((((((((((((i17 + i3) * 31) + this.channelStatus) * 31) + this.channelStatusText.hashCode()) * 31) + this.friendJoinedNum) * 31) + this.onlineNumberString.hashCode()) * 31) + this.topTagText.hashCode()) * 31) + this.wuJiTags.hashCode()) * 31) + this.medalInfoList.hashCode()) * 31) + this.tagList.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getHasMedal() {
        return this.hasMedal;
    }

    /* renamed from: j, reason: from getter */
    public final int getJoinGuildFlag() {
        return this.joinGuildFlag;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    @NotNull
    public final List<IGProMedalInfo> l() {
        return this.medalInfoList;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getOnlineNumberString() {
        return this.onlineNumberString;
    }

    @NotNull
    public final List<IGProRecommendLabel> n() {
        return this.tagList;
    }

    @NotNull
    public final List<String> o() {
        return this.wuJiTags;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsLeftItem() {
        return this.isLeftItem;
    }

    public final void q(int i3) {
        this.joinGuildFlag = i3;
    }

    @NotNull
    public String toString() {
        return "GuildProfileJoinedData(guildId=" + this.guildId + ", joinGuildSig=" + this.joinGuildSig + ", joinGuildFlag=" + this.joinGuildFlag + ", guildName=" + this.guildName + ", guildProfile=" + this.guildProfile + ", guildIconUrl=" + this.guildIconUrl + ", guildCoverUrl=" + this.guildCoverUrl + ", hasMedal=" + this.hasMedal + ", isLeftItem=" + this.isLeftItem + ", channelStatus=" + this.channelStatus + ", channelStatusText=" + this.channelStatusText + ", friendJoinedNum=" + this.friendJoinedNum + ", onlineNumberString=" + this.onlineNumberString + ", topTagText=" + this.topTagText + ", wuJiTags=" + this.wuJiTags + ", medalInfoList=" + this.medalInfoList + ", tagList=" + this.tagList + ")";
    }

    public /* synthetic */ GuildProfileJoinedData(String str, String str2, int i3, String str3, String str4, String str5, String str6, boolean z16, boolean z17, int i16, String str7, int i17, String str8, String str9, List list, List list2, List list3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, str3, str4, str5, str6, z16, z17, (i18 & 512) != 0 ? 0 : i16, (i18 & 1024) != 0 ? "" : str7, (i18 & 2048) != 0 ? 0 : i17, (i18 & 4096) != 0 ? "" : str8, (i18 & 8192) != 0 ? "" : str9, (i18 & 16384) != 0 ? new ArrayList() : list, list2, (i18 & 65536) != 0 ? new ArrayList() : list3);
    }
}
