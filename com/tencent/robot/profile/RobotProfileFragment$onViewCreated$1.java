package com.tencent.robot.profile;

import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.robot.aio.background.RobotAIOBackgroundContainer;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/robot/profile/RobotProfileFragment$onViewCreated$1", "Lcom/tencent/qqnt/kernel/listeneradapt/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "onRobotProfileChanged", "onRobotFriendListChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileFragment$onViewCreated$1 extends com.tencent.qqnt.kernel.listeneradapt.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RobotProfileFragment f367824a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotProfileFragment$onViewCreated$1(RobotProfileFragment robotProfileFragment) {
        this.f367824a = robotProfileFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotProfileFragment this$0) {
        RobotAIOBackgroundContainer robotAIOBackgroundContainer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        robotAIOBackgroundContainer = this$0.rootBg;
        if (robotAIOBackgroundContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootBg");
            robotAIOBackgroundContainer = null;
        }
        robotAIOBackgroundContainer.u();
    }

    @Override // com.tencent.qqnt.kernel.listeneradapt.a, com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public void onRobotFriendListChanged() {
        RobotProfileViewModel robotProfileViewModel = this.f367824a.viewModel;
        if (robotProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel = null;
        }
        robotProfileViewModel.G2();
    }

    @Override // com.tencent.qqnt.kernel.listeneradapt.a, com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public void onRobotProfileChanged(@Nullable final GroupRobotProfile robotProfile) {
        String str;
        RobotAIOBackgroundContainer robotAIOBackgroundContainer;
        RobotBaseInfo robotBaseInfo;
        RobotAIOBackgroundContainer robotAIOBackgroundContainer2 = null;
        if (robotProfile != null && (robotBaseInfo = robotProfile.robotData) != null) {
            str = Long.valueOf(robotBaseInfo.robotUin).toString();
        } else {
            str = null;
        }
        RobotProfileViewModel robotProfileViewModel = this.f367824a.viewModel;
        if (robotProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            robotProfileViewModel = null;
        }
        if (Intrinsics.areEqual(str, robotProfileViewModel.getRobotUin())) {
            RobotProfileViewModel robotProfileViewModel2 = this.f367824a.viewModel;
            if (robotProfileViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                robotProfileViewModel2 = null;
            }
            robotProfileViewModel2.H2(robotProfile);
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.profile.RobotProfileFragment$onViewCreated$1$onRobotProfileChanged$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.robot.profile.setting.b.f368096a.d(GroupRobotProfile.this);
                }
            });
            robotAIOBackgroundContainer = this.f367824a.rootBg;
            if (robotAIOBackgroundContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootBg");
            } else {
                robotAIOBackgroundContainer2 = robotAIOBackgroundContainer;
            }
            final RobotProfileFragment robotProfileFragment = this.f367824a;
            robotAIOBackgroundContainer2.post(new Runnable() { // from class: com.tencent.robot.profile.d
                @Override // java.lang.Runnable
                public final void run() {
                    RobotProfileFragment$onViewCreated$1.b(RobotProfileFragment.this);
                }
            });
        }
    }
}
