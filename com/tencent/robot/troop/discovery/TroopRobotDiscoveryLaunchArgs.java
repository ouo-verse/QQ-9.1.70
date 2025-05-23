package com.tencent.robot.troop.discovery;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/troop/discovery/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/robot/troop/discovery/LaunchSourceType;", "Lcom/tencent/robot/troop/discovery/LaunchSourceType;", "()Lcom/tencent/robot/troop/discovery/LaunchSourceType;", "launchSourceType", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/robot/troop/discovery/LaunchSourceType;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.troop.discovery.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class TroopRobotDiscoveryLaunchArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LaunchSourceType launchSourceType;

    public TroopRobotDiscoveryLaunchArgs(@Nullable Context context, @Nullable String str, @NotNull LaunchSourceType launchSourceType) {
        Intrinsics.checkNotNullParameter(launchSourceType, "launchSourceType");
        this.context = context;
        this.troopUin = str;
        this.launchSourceType = launchSourceType;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final LaunchSourceType getLaunchSourceType() {
        return this.launchSourceType;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopRobotDiscoveryLaunchArgs)) {
            return false;
        }
        TroopRobotDiscoveryLaunchArgs troopRobotDiscoveryLaunchArgs = (TroopRobotDiscoveryLaunchArgs) other;
        if (Intrinsics.areEqual(this.context, troopRobotDiscoveryLaunchArgs.context) && Intrinsics.areEqual(this.troopUin, troopRobotDiscoveryLaunchArgs.troopUin) && this.launchSourceType == troopRobotDiscoveryLaunchArgs.launchSourceType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Context context = this.context;
        int i3 = 0;
        if (context == null) {
            hashCode = 0;
        } else {
            hashCode = context.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.troopUin;
        if (str != null) {
            i3 = str.hashCode();
        }
        return ((i16 + i3) * 31) + this.launchSourceType.hashCode();
    }

    @NotNull
    public String toString() {
        return "TroopRobotDiscoveryLaunchArgs(context=" + this.context + ", troopUin=" + this.troopUin + ", launchSourceType=" + this.launchSourceType + ")";
    }
}
