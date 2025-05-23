package com.tencent.mobileqq.guild.robot.components.share;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfo;
import com.tencent.mobileqq.guild.share.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.f;
import com.tencent.mobileqq.sharepanel.j;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/robot/components/share/c;", "", "", "channelOrActionId", "", "f", "", "b", "g", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "c", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/robot/components/share/b;", "Lcom/tencent/mobileqq/guild/robot/components/share/b;", "getOldActionSheet", "()Lcom/tencent/mobileqq/guild/robot/components/share/b;", "oldActionSheet", "Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfo;", "Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfo;", "e", "()Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfo;", "robotInfo", "Landroid/os/Bundle;", "d", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "customArkBundle", "Lcom/tencent/mobileqq/guild/share/g;", "Lcom/tencent/mobileqq/guild/share/g;", "getReportHelper", "()Lcom/tencent/mobileqq/guild/share/g;", "reportHelper", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/guild/robot/components/share/b;Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfo;Landroid/os/Bundle;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.robot.components.share.b oldActionSheet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotInfo robotInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle customArkBundle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g reportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/robot/components/share/c$b", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements n {
        b() {
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull m callback) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            callback.a(new RobotShareActionExecutor(c.this.getActivity(), new d(c.this.getRobotInfo()), c.this.getCustomArkBundle()).d());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/robot/components/share/c$c", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.robot.components.share.c$c, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7878c implements j {
        C7878c() {
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            c.this.f(channelId);
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            c.this.f(actionId);
        }
    }

    public c(@NotNull Activity activity, @NotNull com.tencent.mobileqq.guild.robot.components.share.b oldActionSheet, @NotNull RobotInfo robotInfo, @NotNull Bundle customArkBundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(oldActionSheet, "oldActionSheet");
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(customArkBundle, "customArkBundle");
        this.activity = activity;
        this.oldActionSheet = oldActionSheet;
        this.robotInfo = robotInfo;
        this.customArkBundle = customArkBundle;
        this.reportHelper = new g(activity, null, String.valueOf(robotInfo.e()), String.valueOf(robotInfo.b()), 2, null);
    }

    private final int b(String channelOrActionId) {
        return com.tencent.mobileqq.guild.share.util.e.f235124a.b(channelOrActionId, "scene_robot");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String channelOrActionId) {
        this.oldActionSheet.h(b(channelOrActionId));
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final Bundle getCustomArkBundle() {
        return this.customArkBundle;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final RobotInfo getRobotInfo() {
        return this.robotInfo;
    }

    public final void g() {
        Activity activity = this.activity;
        if (!(activity instanceof FragmentActivity)) {
            QLog.e("RobotShareActionSheetV2", 1, "showActionSheet(), context null or is not FragmentActivity");
            return;
        }
        com.tencent.mobileqq.guild.robot.components.share.b.g(activity);
        f createSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel((FragmentActivity) this.activity, "robot_card");
        createSharePanel.k0(new b());
        createSharePanel.t0(new C7878c());
        createSharePanel.d0(this.reportHelper.b());
        createSharePanel.show();
    }
}
