package com.tencent.robot.profile.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.GroupTraceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\fB%\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020\u001b\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0006J\t\u0010\r\u001a\u00020\nH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/robot/profile/setting/c;", "", "Landroid/os/Bundle;", "bundle", "", "i", "", "g", "f", tl.h.F, "", "b", "a", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setRobotUin", "(Ljava/lang/String;)V", "robotUin", "e", "setTroopUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "j", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;)V", "profile", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.profile.setting.c, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotSettingData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String robotUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private GroupRobotProfile profile;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/profile/setting/c$a;", "", "", "robotUin", "troopUin", "Landroid/content/Intent;", "a", "KEY_PERMISSIONS_FRAGMENT_EXIT", "Ljava/lang/String;", "KEY_ROBOT_UIN", "KEY_TROOP_UIN", "", "PERMISSIONS_FRAGMENT_REQUEST_EXIT", "I", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.setting.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull String robotUin, @NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.putExtra("key_robot_uin", robotUin);
            intent.putExtra("key_troop_uin", troopUin);
            return intent;
        }

        Companion() {
        }
    }

    public RobotSettingData() {
        this(null, null, null, 7, null);
    }

    public final boolean a() {
        return this.profile.robotData.allowedAddGroup;
    }

    @NotNull
    public final String b() {
        boolean z16;
        String l3;
        GroupTraceInfo groupTraceInfo = this.profile.traceInfo;
        if (groupTraceInfo != null) {
            Long valueOf = Long.valueOf(groupTraceInfo.addOperatorUin);
            if (valueOf.longValue() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                valueOf = null;
            }
            if (valueOf != null && (l3 = valueOf.toString()) != null) {
                return l3;
            }
        }
        return "";
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GroupRobotProfile getProfile() {
        return this.profile;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
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
        if (!(other instanceof RobotSettingData)) {
            return false;
        }
        RobotSettingData robotSettingData = (RobotSettingData) other;
        if (Intrinsics.areEqual(this.robotUin, robotSettingData.robotUin) && Intrinsics.areEqual(this.troopUin, robotSettingData.troopUin) && Intrinsics.areEqual(this.profile, robotSettingData.profile)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        boolean z16;
        if (this.troopUin.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !Intrinsics.areEqual(this.troopUin, "0")) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (f() && this.profile.robotMembership >= 0) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopOwnerOrAdmin(peekAppRuntime, this.troopUin, peekAppRuntime.getCurrentUin());
        }
        return false;
    }

    public int hashCode() {
        return (((this.robotUin.hashCode() * 31) + this.troopUin.hashCode()) * 31) + this.profile.hashCode();
    }

    public final void i(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("key_robot_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(KEY_ROBOT_UIN, \"\")");
        this.robotUin = string;
        String string2 = bundle.getString("key_troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(KEY_TROOP_UIN, \"\")");
        this.troopUin = string2;
    }

    public final void j(@NotNull GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<set-?>");
        this.profile = groupRobotProfile;
    }

    @NotNull
    public String toString() {
        return "RobotSettingData(robotUin=" + this.robotUin + ", troopUin=" + this.troopUin + ", profile=" + this.profile + ")";
    }

    public RobotSettingData(@NotNull String robotUin, @NotNull String troopUin, @NotNull GroupRobotProfile profile) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.profile = profile;
    }

    public /* synthetic */ RobotSettingData(String str, String str2, GroupRobotProfile groupRobotProfile, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? new GroupRobotProfile() : groupRobotProfile);
    }
}
