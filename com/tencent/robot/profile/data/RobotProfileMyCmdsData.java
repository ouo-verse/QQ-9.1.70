package com.tencent.robot.profile.data;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B=\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u00a2\u0006\u0004\b$\u0010%J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0012\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/profile/data/j;", "Lcom/tencent/robot/profile/data/g;", "", "other", "", "equals", "", "toString", "", "hashCode", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "j", "robotName", "Lcom/tencent/robot/profile/data/d;", "Lcom/tencent/robot/profile/data/d;", "()Lcom/tencent/robot/profile/data/d;", "relationShip", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeatureInfo;", "k", "Ljava/util/List;", "()Ljava/util/List;", "cmdList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Lcom/tencent/robot/profile/data/d;Ljava/util/List;)V", "l", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.j, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileMyCmdsData extends g {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileColor color;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final d relationShip;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<RobotFeatureInfo> cmdList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/profile/data/j$a;", "", "", "robotUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "Lcom/tencent/robot/profile/data/h;", "color", "Lcom/tencent/robot/profile/data/d;", "relationShip", "Lcom/tencent/robot/profile/data/j;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.j$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RobotProfileMyCmdsData a(@NotNull String robotUin, @NotNull String troopUin, @NotNull GroupRobotProfile robotProfile, @NotNull RobotProfileColor color, @NotNull d relationShip) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(relationShip, "relationShip");
            String str = robotProfile.robotData.name;
            Intrinsics.checkNotNullExpressionValue(str, "robotProfile.robotData.name");
            ArrayList<RobotFeatureInfo> arrayList = robotProfile.commands;
            Intrinsics.checkNotNullExpressionValue(arrayList, "robotProfile.commands");
            return new RobotProfileMyCmdsData(robotUin, troopUin, color, str, relationShip, arrayList);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileMyCmdsData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String robotName, @NotNull d relationShip, @NotNull List<RobotFeatureInfo> cmdList) {
        super("MyCmds", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(relationShip, "relationShip");
        Intrinsics.checkNotNullParameter(cmdList, "cmdList");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.robotName = robotName;
        this.relationShip = relationShip;
        this.cmdList = cmdList;
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotProfileMyCmdsData) || !super.equals(other)) {
            return false;
        }
        RobotProfileMyCmdsData robotProfileMyCmdsData = (RobotProfileMyCmdsData) other;
        if (Intrinsics.areEqual(this.robotName, robotProfileMyCmdsData.robotName) && Intrinsics.areEqual(this.relationShip, robotProfileMyCmdsData.relationShip) && com.tencent.robot.profile.utils.a.x(this.cmdList, robotProfileMyCmdsData.cmdList)) {
            return true;
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
    public final List<RobotFeatureInfo> h() {
        return this.cmdList;
    }

    public int hashCode() {
        return (((((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.robotName.hashCode()) * 31) + this.relationShip.hashCode()) * 31) + this.cmdList.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final d getRelationShip() {
        return this.relationShip;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getRobotName() {
        return this.robotName;
    }

    @NotNull
    public String toString() {
        return "RobotProfileMyCmdsData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", robotName=" + this.robotName + ", relationShip=" + this.relationShip + ", cmdList=" + this.cmdList + ")";
    }
}
