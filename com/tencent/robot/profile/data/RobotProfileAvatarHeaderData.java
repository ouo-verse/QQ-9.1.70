package com.tencent.robot.profile.data;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobotMetricsInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotUsingLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobtoCreateInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u007f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010/\u001a\u00020,\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u0002000 \u0012\b\b\u0002\u00107\u001a\u00020\u0004\u00a2\u0006\u0004\b8\u00109J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010+\u001a\u0004\u0018\u00010'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u001e\u0010*R\u0017\u0010/\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b(\u0010.R\u001d\u00102\u001a\b\u0012\u0004\u0012\u0002000 8\u0006\u00a2\u0006\f\n\u0004\b1\u0010#\u001a\u0004\b\"\u0010%R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b\u001a\u00105\"\u0004\b1\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/robot/profile/data/f;", "Lcom/tencent/robot/profile/data/g;", "", "other", "", "equals", "", "toString", "", "hashCode", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "o", "robotUid", "j", "k", "name", "desc", "l", PhotoCategorySummaryInfo.AVATAR_URL, "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotUsingLabel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getLableList", "()Ljava/util/List;", "lableList", "Lcom/tencent/qqnt/kernel/nativeinterface/RobtoCreateInfo;", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/RobtoCreateInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobtoCreateInfo;", "robotCreateInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotMetricsInfo;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotMetricsInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotMetricsInfo;", "robotMetricsInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotLabel;", "p", "robotLabelList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z", "()Z", "(Z)V", "divideLineVisibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/qqnt/kernel/nativeinterface/RobtoCreateInfo;Lcom/tencent/qqnt/kernel/nativeinterface/RobotMetricsInfo;Ljava/util/List;Z)V", "r", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.f, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileAvatarHeaderData extends g {

    /* renamed from: r, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: g, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: h */
    @NotNull
    private final RobotProfileColor color;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    @NotNull
    private final String robotUid;

    /* renamed from: j, reason: from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: k, reason: from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: l, reason: from kotlin metadata and from toString */
    @NotNull
    private final String avatarUrl;

    /* renamed from: m, reason: from toString */
    @NotNull
    private final List<RobotUsingLabel> lableList;

    /* renamed from: n, reason: from toString */
    @Nullable
    private final RobtoCreateInfo robotCreateInfo;

    /* renamed from: o, reason: from kotlin metadata and from toString */
    @NotNull
    private final RobotMetricsInfo robotMetricsInfo;

    /* renamed from: p, reason: from kotlin metadata and from toString */
    @NotNull
    private final List<RobotLabel> robotLabelList;

    /* renamed from: q, reason: from toString */
    private boolean divideLineVisibility;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/profile/data/f$a;", "", "", "robotUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "Lcom/tencent/robot/profile/data/h;", "color", "", "divideLineVisibility", "Lcom/tencent/robot/profile/data/f;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.f$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RobotProfileAvatarHeaderData b(Companion companion, String str, String str2, GroupRobotProfile groupRobotProfile, RobotProfileColor robotProfileColor, boolean z16, int i3, Object obj) {
            if ((i3 & 16) != 0) {
                z16 = true;
            }
            return companion.a(str, str2, groupRobotProfile, robotProfileColor, z16);
        }

        @NotNull
        public final RobotProfileAvatarHeaderData a(@NotNull String robotUin, @NotNull String troopUin, @NotNull GroupRobotProfile robotProfile, @NotNull RobotProfileColor color, boolean divideLineVisibility) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            Intrinsics.checkNotNullParameter(color, "color");
            String str = robotProfile.robotData.robotUid;
            Intrinsics.checkNotNullExpressionValue(str, "robotProfile.robotData.robotUid");
            String str2 = robotProfile.robotData.name;
            Intrinsics.checkNotNullExpressionValue(str2, "robotProfile.robotData.name");
            String str3 = robotProfile.robotData.desc;
            Intrinsics.checkNotNullExpressionValue(str3, "robotProfile.robotData.desc");
            String str4 = robotProfile.robotData.robotAvatar;
            Intrinsics.checkNotNullExpressionValue(str4, "robotProfile.robotData.robotAvatar");
            ArrayList<RobotUsingLabel> arrayList = robotProfile.usingLabels;
            Intrinsics.checkNotNullExpressionValue(arrayList, "robotProfile.usingLabels");
            RobtoCreateInfo robtoCreateInfo = robotProfile.robotData.createInfo;
            RobotMetricsInfo robotMetricsInfo = robotProfile.robotMetricsInfo;
            Intrinsics.checkNotNullExpressionValue(robotMetricsInfo, "robotProfile.robotMetricsInfo");
            ArrayList<RobotLabel> arrayList2 = robotProfile.robotLabelList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "robotProfile.robotLabelList");
            return new RobotProfileAvatarHeaderData(robotUin, troopUin, color, str, str2, str3, str4, arrayList, robtoCreateInfo, robotMetricsInfo, arrayList2, divideLineVisibility);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileAvatarHeaderData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String robotUid, @NotNull String name, @NotNull String desc, @NotNull String avatarUrl, @NotNull List<RobotUsingLabel> lableList, @Nullable RobtoCreateInfo robtoCreateInfo, @NotNull RobotMetricsInfo robotMetricsInfo, @NotNull List<RobotLabel> robotLabelList, boolean z16) {
        super("ProfileAvatar", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(lableList, "lableList");
        Intrinsics.checkNotNullParameter(robotMetricsInfo, "robotMetricsInfo");
        Intrinsics.checkNotNullParameter(robotLabelList, "robotLabelList");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.robotUid = robotUid;
        this.name = name;
        this.desc = desc;
        this.avatarUrl = avatarUrl;
        this.lableList = lableList;
        this.robotCreateInfo = robtoCreateInfo;
        this.robotMetricsInfo = robotMetricsInfo;
        this.robotLabelList = robotLabelList;
        this.divideLineVisibility = z16;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: c, reason: from getter */
    public RobotProfileColor getColor() {
        return this.color;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: e, reason: from getter */
    public String getRobotUin() {
        return this.robotUin;
    }

    @Override // com.tencent.robot.profile.data.g
    public boolean equals(@Nullable Object other) {
        boolean z16;
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotProfileAvatarHeaderData) || !super.equals(other)) {
            return false;
        }
        RobotProfileAvatarHeaderData robotProfileAvatarHeaderData = (RobotProfileAvatarHeaderData) other;
        if (Intrinsics.areEqual(this.robotUid, robotProfileAvatarHeaderData.robotUid) && Intrinsics.areEqual(this.name, robotProfileAvatarHeaderData.name) && Intrinsics.areEqual(this.desc, robotProfileAvatarHeaderData.desc) && Intrinsics.areEqual(this.avatarUrl, robotProfileAvatarHeaderData.avatarUrl) && com.tencent.robot.profile.utils.a.B(this.lableList, robotProfileAvatarHeaderData.lableList)) {
            RobtoCreateInfo robtoCreateInfo = this.robotCreateInfo;
            if (robtoCreateInfo != null && com.tencent.robot.profile.utils.a.h(robtoCreateInfo, robotProfileAvatarHeaderData.robotCreateInfo)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && com.tencent.robot.profile.utils.a.f(this.robotMetricsInfo, robotProfileAvatarHeaderData.robotMetricsInfo) && com.tencent.robot.profile.utils.a.y(this.robotLabelList, robotProfileAvatarHeaderData.robotLabelList) && this.divideLineVisibility == robotProfileAvatarHeaderData.divideLineVisibility) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTroopUin() {
        return this.troopUin;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.robotUid.hashCode()) * 31) + this.name.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.lableList.hashCode()) * 31;
        RobtoCreateInfo robtoCreateInfo = this.robotCreateInfo;
        if (robtoCreateInfo == null) {
            hashCode = 0;
        } else {
            hashCode = robtoCreateInfo.hashCode();
        }
        int hashCode3 = (((((hashCode2 + hashCode) * 31) + this.robotMetricsInfo.hashCode()) * 31) + this.robotLabelList.hashCode()) * 31;
        boolean z16 = this.divideLineVisibility;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode3 + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getDivideLineVisibility() {
        return this.divideLineVisibility;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final RobtoCreateInfo getRobotCreateInfo() {
        return this.robotCreateInfo;
    }

    @NotNull
    public final List<RobotLabel> m() {
        return this.robotLabelList;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final RobotMetricsInfo getRobotMetricsInfo() {
        return this.robotMetricsInfo;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getRobotUid() {
        return this.robotUid;
    }

    public final void p(boolean z16) {
        this.divideLineVisibility = z16;
    }

    @NotNull
    public String toString() {
        return "RobotProfileAvatarHeaderData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", robotUid=" + this.robotUid + ", name=" + this.name + ", desc=" + this.desc + ", avatarUrl=" + this.avatarUrl + ", lableList=" + this.lableList + ", robotCreateInfo=" + this.robotCreateInfo + ", robotMetricsInfo=" + this.robotMetricsInfo + ", robotLabelList=" + this.robotLabelList + ", divideLineVisibility=" + this.divideLineVisibility + ")";
    }
}
