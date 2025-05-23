package com.tencent.robot.profile.data;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\tB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/profile/data/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getDayColor", "()Ljava/lang/String;", "dayColor", "b", "getNightColor", "nightColor", "c", "getAvatarColor", "avatarColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.data.h, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotProfileColor {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dayColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String nightColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String avatarColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/profile/data/h$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "Lcom/tencent/robot/profile/data/h;", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.data.h$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RobotProfileColor a(@NotNull GroupRobotProfile robotProfile) {
            Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
            String k3 = com.tencent.robot.profile.utils.a.k(robotProfile, true);
            String r16 = com.tencent.robot.profile.utils.a.r(robotProfile, true);
            String str = robotProfile.avatarDominantColor;
            Intrinsics.checkNotNullExpressionValue(str, "robotProfile.avatarDominantColor");
            return new RobotProfileColor(k3, r16, str);
        }

        Companion() {
        }
    }

    public RobotProfileColor(@NotNull String dayColor, @NotNull String nightColor, @NotNull String avatarColor) {
        Intrinsics.checkNotNullParameter(dayColor, "dayColor");
        Intrinsics.checkNotNullParameter(nightColor, "nightColor");
        Intrinsics.checkNotNullParameter(avatarColor, "avatarColor");
        this.dayColor = dayColor;
        this.nightColor = nightColor;
        this.avatarColor = avatarColor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotProfileColor)) {
            return false;
        }
        RobotProfileColor robotProfileColor = (RobotProfileColor) other;
        if (Intrinsics.areEqual(this.dayColor, robotProfileColor.dayColor) && Intrinsics.areEqual(this.nightColor, robotProfileColor.nightColor) && Intrinsics.areEqual(this.avatarColor, robotProfileColor.avatarColor)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.dayColor.hashCode() * 31) + this.nightColor.hashCode()) * 31) + this.avatarColor.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotProfileColor(dayColor=" + this.dayColor + ", nightColor=" + this.nightColor + ", avatarColor=" + this.avatarColor + ")";
    }
}
