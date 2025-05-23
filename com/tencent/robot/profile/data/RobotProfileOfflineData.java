package com.tencent.robot.profile.data;

import com.tencent.qqnt.kernel.nativeinterface.RobotStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\b\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u0012\u0010\u001eR\u0017\u0010!\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b\u0017\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/profile/data/l;", "Lcom/tencent/robot/profile/data/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "Z", "j", "()Z", "isOffline", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotStatus;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotStatus;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotStatus;", "robotStatus", "k", "isEmpty", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;ZLcom/tencent/qqnt/kernel/nativeinterface/RobotStatus;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.l, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileOfflineData extends g {

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
    private final boolean isOffline;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RobotStatus robotStatus;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEmpty;

    public /* synthetic */ RobotProfileOfflineData(String str, String str2, RobotProfileColor robotProfileColor, boolean z16, RobotStatus robotStatus, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, robotProfileColor, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? RobotStatus.KDEFAULT : robotStatus, (i3 & 32) != 0 ? false : z17);
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
        if (!(other instanceof RobotProfileOfflineData)) {
            return false;
        }
        RobotProfileOfflineData robotProfileOfflineData = (RobotProfileOfflineData) other;
        if (Intrinsics.areEqual(getRobotUin(), robotProfileOfflineData.getRobotUin()) && Intrinsics.areEqual(getTroopUin(), robotProfileOfflineData.getTroopUin()) && Intrinsics.areEqual(getColor(), robotProfileOfflineData.getColor()) && this.isOffline == robotProfileOfflineData.isOffline && this.robotStatus == robotProfileOfflineData.robotStatus && this.isEmpty == robotProfileOfflineData.isEmpty) {
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
    public final RobotStatus getRobotStatus() {
        return this.robotStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31;
        boolean z16 = this.isOffline;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode2 = (((hashCode + i16) * 31) + this.robotStatus.hashCode()) * 31;
        boolean z17 = this.isEmpty;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode2 + i3;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsOffline() {
        return this.isOffline;
    }

    @NotNull
    public String toString() {
        return "RobotProfileOfflineData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", isOffline=" + this.isOffline + ", robotStatus=" + this.robotStatus + ", isEmpty=" + this.isEmpty + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotProfileOfflineData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, boolean z16, @NotNull RobotStatus robotStatus, boolean z17) {
        super("Offline", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(robotStatus, "robotStatus");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.isOffline = z16;
        this.robotStatus = robotStatus;
        this.isEmpty = z17;
    }
}
