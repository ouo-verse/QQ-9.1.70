package com.tencent.robot.adelie.kuikly.module;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "robotProfile", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AdelieKuiklyBaseModule$handleShareRobot$1 extends Lambda implements Function1<GroupRobotProfile, Unit> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ AdelieKuiklyBaseModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieKuiklyBaseModule$handleShareRobot$1(AdelieKuiklyBaseModule adelieKuiklyBaseModule, Function1<Object, Unit> function1) {
        super(1);
        this.this$0 = adelieKuiklyBaseModule;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieKuiklyBaseModule this$0, GroupRobotProfile robotProfile, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotProfile, "$robotProfile");
        this$0.O(robotProfile);
        if (function1 != null) {
            r.e(function1, null, 1, null);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GroupRobotProfile groupRobotProfile) {
        invoke2(groupRobotProfile);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final GroupRobotProfile robotProfile) {
        boolean L;
        boolean M;
        Resources resources;
        Intrinsics.checkNotNullParameter(robotProfile, "robotProfile");
        L = this.this$0.L(robotProfile);
        if (!L) {
            M = this.this$0.M(robotProfile);
            if (M) {
                QLog.e("AdelieKuiklyBaseModule", 1, "robot status invalid, " + robotProfile.robotData);
                Function1<Object, Unit> function1 = this.$callback;
                if (function1 != null) {
                    Context context = this.this$0.getContext();
                    r.b(function1, "robot status invalid", (context == null || (resources = context.getResources()) == null) ? null : resources.getString(R.string.f223416g6));
                }
                Function1<Object, Unit> function12 = this.$callback;
                if (function12 != null) {
                    r.c(function12, "robot status invalid", null, 2, null);
                    return;
                }
                return;
            }
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final AdelieKuiklyBaseModule adelieKuiklyBaseModule = this.this$0;
            final Function1<Object, Unit> function13 = this.$callback;
            rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.robot.adelie.kuikly.module.g
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieKuiklyBaseModule$handleShareRobot$1.b(AdelieKuiklyBaseModule.this, robotProfile, function13);
                }
            });
            return;
        }
        QLog.e("AdelieKuiklyBaseModule", 1, "robot profile invalid, " + robotProfile.robotData + ", " + robotProfile.jumpUrl);
        Function1<Object, Unit> function14 = this.$callback;
        if (function14 != null) {
            r.c(function14, "robotProfile invalid", null, 2, null);
        }
    }
}
