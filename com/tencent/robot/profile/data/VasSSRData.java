package com.tencent.robot.profile.data;

import com.tencent.qqnt.kernel.nativeinterface.RobotEntranceCards;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0012\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/profile/data/r;", "Lcom/tencent/robot/profile/data/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "g", "troopUin", "Lcom/tencent/robot/profile/data/h;", tl.h.F, "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "i", "getName", "name", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotEntranceCards;", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotEntranceCards;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotEntranceCards;", "entranceCards", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/RobotEntranceCards;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.r, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class VasSSRData extends g {

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
    private final RobotEntranceCards entranceCards;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSSRData(@NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, @NotNull String name, @NotNull RobotEntranceCards entranceCards) {
        super("VasSSR", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(entranceCards, "entranceCards");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.name = name;
        this.entranceCards = entranceCards;
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
        if (!(other instanceof VasSSRData)) {
            return false;
        }
        VasSSRData vasSSRData = (VasSSRData) other;
        if (Intrinsics.areEqual(getRobotUin(), vasSSRData.getRobotUin()) && Intrinsics.areEqual(getTroopUin(), vasSSRData.getTroopUin()) && Intrinsics.areEqual(getColor(), vasSSRData.getColor()) && Intrinsics.areEqual(this.name, vasSSRData.name) && Intrinsics.areEqual(this.entranceCards, vasSSRData.entranceCards)) {
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
    public final RobotEntranceCards getEntranceCards() {
        return this.entranceCards;
    }

    public int hashCode() {
        return (((((((getRobotUin().hashCode() * 31) + getTroopUin().hashCode()) * 31) + getColor().hashCode()) * 31) + this.name.hashCode()) * 31) + this.entranceCards.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasSSRData(robotUin=" + getRobotUin() + ", troopUin=" + getTroopUin() + ", color=" + getColor() + ", name=" + this.name + ", entranceCards=" + this.entranceCards + ")";
    }
}
