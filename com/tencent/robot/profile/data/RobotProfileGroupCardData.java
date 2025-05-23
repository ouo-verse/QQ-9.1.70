package com.tencent.robot.profile.data;

import com.tencent.qqnt.kernel.nativeinterface.RobotGroupInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\"B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0012\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/profile/data/i;", "Lcom/tencent/robot/profile/data/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "robotCallName", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGroupInfo;", "j", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "groupList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Ljava/util/ArrayList;)V", "k", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.i, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileGroupCardData extends g {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
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
    private final String robotCallName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<RobotGroupInfo> groupList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/profile/data/i$a;", "", "", "robotUin", "troopUin", "Lcom/tencent/robot/profile/data/h;", "color", "robotCallName", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGroupInfo;", "groupList", "Lcom/tencent/robot/profile/data/i;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.i$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RobotProfileGroupCardData a(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String robotCallName, @NotNull ArrayList<RobotGroupInfo> groupList) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(robotCallName, "robotCallName");
            Intrinsics.checkNotNullParameter(groupList, "groupList");
            return new RobotProfileGroupCardData(robotUin, troopUin, color, robotCallName, groupList);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileGroupCardData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String robotCallName, @NotNull ArrayList<RobotGroupInfo> groupList) {
        super("GroupCard", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(robotCallName, "robotCallName");
        Intrinsics.checkNotNullParameter(groupList, "groupList");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.robotCallName = robotCallName;
        this.groupList = groupList;
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
        if (!(other instanceof RobotProfileGroupCardData)) {
            return false;
        }
        RobotProfileGroupCardData robotProfileGroupCardData = (RobotProfileGroupCardData) other;
        if (Intrinsics.areEqual(getRobotUin(), robotProfileGroupCardData.getRobotUin()) && Intrinsics.areEqual(getTroopUin(), robotProfileGroupCardData.getTroopUin()) && Intrinsics.areEqual(getColor(), robotProfileGroupCardData.getColor()) && Intrinsics.areEqual(this.robotCallName, robotProfileGroupCardData.robotCallName) && Intrinsics.areEqual(this.groupList, robotProfileGroupCardData.groupList)) {
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
    public final ArrayList<RobotGroupInfo> h() {
        return this.groupList;
    }

    public int hashCode() {
        return (((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.robotCallName.hashCode()) * 31) + this.groupList.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getRobotCallName() {
        return this.robotCallName;
    }

    @NotNull
    public String toString() {
        return "RobotProfileGroupCardData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", robotCallName=" + this.robotCallName + ", groupList=" + this.groupList + ")";
    }
}
