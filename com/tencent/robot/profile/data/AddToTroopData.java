package com.tencent.robot.profile.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/profile/data/b;", "Lcom/tencent/robot/profile/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "robotUin", "d", "troopName", "e", "troopUin", "f", "Z", "()Z", "g", "(Z)V", "isInTroop", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AddToTroopData extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String troopName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String troopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isInTroop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddToTroopData(@NotNull String robotUin, @NotNull String troopName, @NotNull String troopUin, boolean z16) {
        super(AddToTroopItemType.ADD_ITEM, troopUin, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.robotUin = robotUin;
        this.troopName = troopName;
        this.troopUin = troopUin;
        this.isInTroop = z16;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTroopName() {
        return this.troopName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddToTroopData)) {
            return false;
        }
        AddToTroopData addToTroopData = (AddToTroopData) other;
        if (Intrinsics.areEqual(this.robotUin, addToTroopData.robotUin) && Intrinsics.areEqual(this.troopName, addToTroopData.troopName) && Intrinsics.areEqual(this.troopUin, addToTroopData.troopUin) && this.isInTroop == addToTroopData.isInTroop) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsInTroop() {
        return this.isInTroop;
    }

    public final void g(boolean z16) {
        this.isInTroop = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.robotUin.hashCode() * 31) + this.troopName.hashCode()) * 31) + this.troopUin.hashCode()) * 31;
        boolean z16 = this.isInTroop;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "AddToTroopData(robotUin=" + this.robotUin + ", troopName=" + this.troopName + ", troopUin=" + this.troopUin + ", isInTroop=" + this.isInTroop + ")";
    }
}
