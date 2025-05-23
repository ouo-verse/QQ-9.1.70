package com.tencent.mobileqq.guild.setting.member.selector;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRoleManagementTag;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010!\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u0019\u0010)\u001a\u0004\u0018\u00010%8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\"\u0010\u000fR\u0019\u0010.\u001a\u0004\u0018\u00010+8\u0006\u00a2\u0006\f\n\u0004\b'\u0010,\u001a\u0004\b\u001a\u0010-R\u0019\u00100\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b/\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u0019\u00104\u001a\u0004\u0018\u0001018\u0006\u00a2\u0006\f\n\u0004\b\u0011\u00102\u001a\u0004\b/\u00103R\u0019\u00108\u001a\u0004\u0018\u0001058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u00106\u001a\u0004\b\u001d\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/s;", "Lcom/tencent/mobileqq/guild/setting/member/selector/a;", "newItem", "", "b", "", "toString", "", "hashCode", "", "other", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "l", "tinyId", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", MessageRoamJsPlugin.USERTYPE, "d", tl.h.F, "name", "e", "i", "nameColor", "f", "Z", DomainData.DOMAIN_NAME, "()Z", "isOnline", "g", "o", "isRobot", "", "[B", "j", "()[B", "plateData", "medalUrl", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "identityInfo", "k", "identityDes", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;", "managementTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IZZ[BLjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRoleManagementTag;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.member.selector.s, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MemberData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tinyId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int userType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int nameColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOnline;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRobot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final byte[] plateData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String medalUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProIdentityInfo identityInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String identityDes;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProGuildRoleInfo roleInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final IGProRoleManagementTag managementTag;

    public /* synthetic */ MemberData(String str, String str2, int i3, String str3, int i16, boolean z16, boolean z17, byte[] bArr, String str4, IGProIdentityInfo iGProIdentityInfo, String str5, IGProGuildRoleInfo iGProGuildRoleInfo, IGProRoleManagementTag iGProRoleManagementTag, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, str3, i16, z16, z17, (i17 & 128) != 0 ? null : bArr, (i17 & 256) != 0 ? null : str4, (i17 & 512) != 0 ? null : iGProIdentityInfo, (i17 & 1024) != 0 ? null : str5, (i17 & 2048) != 0 ? null : iGProGuildRoleInfo, (i17 & 4096) != 0 ? null : iGProRoleManagementTag);
    }

    @Override // com.tencent.mobileqq.guild.setting.member.selector.a
    public boolean b(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (newItem instanceof MemberData) {
            MemberData memberData = (MemberData) newItem;
            if (Intrinsics.areEqual(this.guildId, memberData.guildId) && Intrinsics.areEqual(this.tinyId, memberData.tinyId)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getIdentityDes() {
        return this.identityDes;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final IGProIdentityInfo getIdentityInfo() {
        return this.identityInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberData)) {
            return false;
        }
        MemberData memberData = (MemberData) other;
        if (Intrinsics.areEqual(this.guildId, memberData.guildId) && Intrinsics.areEqual(this.tinyId, memberData.tinyId) && this.userType == memberData.userType && Intrinsics.areEqual(this.name, memberData.name) && this.nameColor == memberData.nameColor && this.isOnline == memberData.isOnline && this.isRobot == memberData.isRobot && Intrinsics.areEqual(this.plateData, memberData.plateData) && Intrinsics.areEqual(this.medalUrl, memberData.medalUrl) && Intrinsics.areEqual(this.identityInfo, memberData.identityInfo) && Intrinsics.areEqual(this.identityDes, memberData.identityDes) && Intrinsics.areEqual(this.roleInfo, memberData.roleInfo) && Intrinsics.areEqual(this.managementTag, memberData.managementTag)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final IGProRoleManagementTag getManagementTag() {
        return this.managementTag;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getMedalUrl() {
        return this.medalUrl;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6 = ((((((((this.guildId.hashCode() * 31) + this.tinyId.hashCode()) * 31) + this.userType) * 31) + this.name.hashCode()) * 31) + this.nameColor) * 31;
        boolean z16 = this.isOnline;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode6 + i16) * 31;
        boolean z17 = this.isRobot;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        byte[] bArr = this.plateData;
        int i19 = 0;
        if (bArr == null) {
            hashCode = 0;
        } else {
            hashCode = Arrays.hashCode(bArr);
        }
        int i26 = (i18 + hashCode) * 31;
        String str = this.medalUrl;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i27 = (i26 + hashCode2) * 31;
        IGProIdentityInfo iGProIdentityInfo = this.identityInfo;
        if (iGProIdentityInfo == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = iGProIdentityInfo.hashCode();
        }
        int i28 = (i27 + hashCode3) * 31;
        String str2 = this.identityDes;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i29 = (i28 + hashCode4) * 31;
        IGProGuildRoleInfo iGProGuildRoleInfo = this.roleInfo;
        if (iGProGuildRoleInfo == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = iGProGuildRoleInfo.hashCode();
        }
        int i36 = (i29 + hashCode5) * 31;
        IGProRoleManagementTag iGProRoleManagementTag = this.managementTag;
        if (iGProRoleManagementTag != null) {
            i19 = iGProRoleManagementTag.hashCode();
        }
        return i36 + i19;
    }

    /* renamed from: i, reason: from getter */
    public final int getNameColor() {
        return this.nameColor;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final byte[] getPlateData() {
        return this.plateData;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final IGProGuildRoleInfo getRoleInfo() {
        return this.roleInfo;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getTinyId() {
        return this.tinyId;
    }

    /* renamed from: m, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsOnline() {
        return this.isOnline;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsRobot() {
        return this.isRobot;
    }

    @NotNull
    public String toString() {
        return "MemberData(guildId=" + this.guildId + ", tinyId=" + this.tinyId + ", userType=" + this.userType + ", name=" + this.name + ", nameColor=" + this.nameColor + ", isOnline=" + this.isOnline + ", isRobot=" + this.isRobot + ", plateData=" + Arrays.toString(this.plateData) + ", medalUrl=" + this.medalUrl + ", identityInfo=" + this.identityInfo + ", identityDes=" + this.identityDes + ", roleInfo=" + this.roleInfo + ", managementTag=" + this.managementTag + ")";
    }

    public MemberData(@NotNull String guildId, @NotNull String tinyId, int i3, @NotNull String name, int i16, boolean z16, boolean z17, @Nullable byte[] bArr, @Nullable String str, @Nullable IGProIdentityInfo iGProIdentityInfo, @Nullable String str2, @Nullable IGProGuildRoleInfo iGProGuildRoleInfo, @Nullable IGProRoleManagementTag iGProRoleManagementTag) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(name, "name");
        this.guildId = guildId;
        this.tinyId = tinyId;
        this.userType = i3;
        this.name = name;
        this.nameColor = i16;
        this.isOnline = z16;
        this.isRobot = z17;
        this.plateData = bArr;
        this.medalUrl = str;
        this.identityInfo = iGProIdentityInfo;
        this.identityDes = str2;
        this.roleInfo = iGProGuildRoleInfo;
        this.managementTag = iGProRoleManagementTag;
    }
}
