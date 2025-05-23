package com.tencent.robot.profile.data;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0017\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/profile/data/p;", "Lcom/tencent/robot/profile/data/g;", "", "other", "", "equals", "", "toString", "", "hashCode", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "name", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneInfo;", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneInfo;", "qZoneInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.p, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotQZoneInfoData extends g {

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
    private final String name;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GroupRobotQzoneInfo qZoneInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotQZoneInfoData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String name, @NotNull GroupRobotQzoneInfo qZoneInfo) {
        super("QZoneInfo", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(qZoneInfo, "qZoneInfo");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.name = name;
        this.qZoneInfo = qZoneInfo;
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
        if (!(other instanceof RobotQZoneInfoData) || !super.equals(other)) {
            return false;
        }
        RobotQZoneInfoData robotQZoneInfoData = (RobotQZoneInfoData) other;
        if (Intrinsics.areEqual(this.name, robotQZoneInfoData.name) && com.tencent.robot.profile.utils.a.c(this.qZoneInfo, robotQZoneInfoData.qZoneInfo)) {
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
    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.name.hashCode()) * 31) + this.qZoneInfo.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final GroupRobotQzoneInfo getQZoneInfo() {
        return this.qZoneInfo;
    }

    @NotNull
    public String toString() {
        return "RobotQZoneInfoData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", name=" + this.name + ", qZoneInfo=" + this.qZoneInfo + ")";
    }
}
