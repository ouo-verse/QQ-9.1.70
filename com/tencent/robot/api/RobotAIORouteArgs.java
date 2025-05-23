package com.tencent.robot.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010 \u001a\u0004\b\u000e\u0010!R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u0019\u0010'\u001a\u0004\u0018\u00010$8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b\u0013\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/robot/api/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "robotUin", "c", h.F, "troopUin", "d", "e", "openSource", "g", "scene", "Z", "i", "()Z", "isOpenScaleAIO", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "bundle", "callbackData", "Lcom/tencent/robot/api/a;", "Lcom/tencent/robot/api/a;", "()Lcom/tencent/robot/api/a;", "callback", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/os/Bundle;Ljava/lang/String;Lcom/tencent/robot/api/a;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.api.c, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotAIORouteArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String robotUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String troopUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String openSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String scene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOpenScaleAIO;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Bundle bundle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String callbackData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final a callback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotAIORouteArgs(@NotNull Activity activity, @NotNull String robotUin, @Nullable String str, @NotNull String openSource, @NotNull String scene, boolean z16, @NotNull Bundle bundle) {
        this(activity, robotUin, str, openSource, scene, z16, bundle, null, null, MsgConstant.KRMFILETHUMBSIZE384, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(openSource, "openSource");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final a getCallback() {
        return this.callback;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCallbackData() {
        return this.callbackData;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getOpenSource() {
        return this.openSource;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotAIORouteArgs)) {
            return false;
        }
        RobotAIORouteArgs robotAIORouteArgs = (RobotAIORouteArgs) other;
        if (Intrinsics.areEqual(this.activity, robotAIORouteArgs.activity) && Intrinsics.areEqual(this.robotUin, robotAIORouteArgs.robotUin) && Intrinsics.areEqual(this.troopUin, robotAIORouteArgs.troopUin) && Intrinsics.areEqual(this.openSource, robotAIORouteArgs.openSource) && Intrinsics.areEqual(this.scene, robotAIORouteArgs.scene) && this.isOpenScaleAIO == robotAIORouteArgs.isOpenScaleAIO && Intrinsics.areEqual(this.bundle, robotAIORouteArgs.bundle) && Intrinsics.areEqual(this.callbackData, robotAIORouteArgs.callbackData) && Intrinsics.areEqual(this.callback, robotAIORouteArgs.callback)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getRobotUin() {
        return this.robotUin;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.activity.hashCode() * 31) + this.robotUin.hashCode()) * 31;
        String str = this.troopUin;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((((hashCode2 + hashCode) * 31) + this.openSource.hashCode()) * 31) + this.scene.hashCode()) * 31;
        boolean z16 = this.isOpenScaleAIO;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode4 = (((((hashCode3 + i16) * 31) + this.bundle.hashCode()) * 31) + this.callbackData.hashCode()) * 31;
        a aVar = this.callback;
        if (aVar != null) {
            i3 = aVar.hashCode();
        }
        return hashCode4 + i3;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsOpenScaleAIO() {
        return this.isOpenScaleAIO;
    }

    @NotNull
    public String toString() {
        return "RobotAIORouteArgs(activity=" + this.activity + ", robotUin=" + this.robotUin + ", troopUin=" + this.troopUin + ", openSource=" + this.openSource + ", scene=" + this.scene + ", isOpenScaleAIO=" + this.isOpenScaleAIO + ", bundle=" + this.bundle + ", callbackData=" + this.callbackData + ", callback=" + this.callback + ")";
    }

    @JvmOverloads
    public RobotAIORouteArgs(@NotNull Activity activity, @NotNull String robotUin, @Nullable String str, @NotNull String openSource, @NotNull String scene, boolean z16, @NotNull Bundle bundle, @NotNull String callbackData, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(openSource, "openSource");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(callbackData, "callbackData");
        this.activity = activity;
        this.robotUin = robotUin;
        this.troopUin = str;
        this.openSource = openSource;
        this.scene = scene;
        this.isOpenScaleAIO = z16;
        this.bundle = bundle;
        this.callbackData = callbackData;
        this.callback = aVar;
    }

    public /* synthetic */ RobotAIORouteArgs(Activity activity, String str, String str2, String str3, String str4, boolean z16, Bundle bundle, String str5, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? "14" : str3, (i3 & 16) != 0 ? "1000" : str4, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? new Bundle() : bundle, (i3 & 128) != 0 ? "" : str5, (i3 & 256) != 0 ? null : aVar);
    }
}
