package com.tencent.robot.profile.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/profile/data/q;", "Lcom/tencent/robot/profile/data/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "robotUin", "d", "troopName", "e", "troopUin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.q, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class ShareToTroopData extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String troopName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String troopUin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareToTroopData(@NotNull String robotUin, @NotNull String troopName, @NotNull String troopUin) {
        super(AddToTroopItemType.SHARE_ITEM, troopUin, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.robotUin = robotUin;
        this.troopName = troopName;
        this.troopUin = troopUin;
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
        if (!(other instanceof ShareToTroopData)) {
            return false;
        }
        ShareToTroopData shareToTroopData = (ShareToTroopData) other;
        if (Intrinsics.areEqual(this.robotUin, shareToTroopData.robotUin) && Intrinsics.areEqual(this.troopName, shareToTroopData.troopName) && Intrinsics.areEqual(this.troopUin, shareToTroopData.troopUin)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.robotUin.hashCode() * 31) + this.troopName.hashCode()) * 31) + this.troopUin.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShareToTroopData(robotUin=" + this.robotUin + ", troopName=" + this.troopName + ", troopUin=" + this.troopUin + ")";
    }
}
