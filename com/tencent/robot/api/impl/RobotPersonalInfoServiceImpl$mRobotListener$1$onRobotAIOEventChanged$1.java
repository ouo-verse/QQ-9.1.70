package com.tencent.robot.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotAIOEvent;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeature;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "success", "", "robotFeature", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeature;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class RobotPersonalInfoServiceImpl$mRobotListener$1$onRobotAIOEventChanged$1 extends Lambda implements Function2<Boolean, RobotFeature, Unit> {
    final /* synthetic */ RobotAIOEvent $event;
    final /* synthetic */ RobotPersonalInfoServiceImpl this$0;
    final /* synthetic */ RobotPersonalInfoServiceImpl$mRobotListener$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotPersonalInfoServiceImpl$mRobotListener$1$onRobotAIOEventChanged$1(RobotPersonalInfoServiceImpl robotPersonalInfoServiceImpl, RobotAIOEvent robotAIOEvent, RobotPersonalInfoServiceImpl$mRobotListener$1 robotPersonalInfoServiceImpl$mRobotListener$1) {
        super(2);
        this.this$0 = robotPersonalInfoServiceImpl;
        this.$event = robotAIOEvent;
        this.this$1 = robotPersonalInfoServiceImpl$mRobotListener$1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotPersonalInfoServiceImpl this$0, RobotAIOEvent robotAIOEvent, RobotFeature robotFeature, RobotPersonalInfoServiceImpl$mRobotListener$1 this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        QLog.i("RobotPersonalInfoServiceImpl-RobotStory", 1, "onRobotAIOEventChanged \u8fdb\u5165\u6545\u4e8b\u96c6\u64cd\u4f5c---");
        String str = robotAIOEvent.uid;
        Intrinsics.checkNotNullExpressionValue(str, "event.uid");
        StoryBaseInfo storyBaseInfo = robotFeature.storyInfo;
        Intrinsics.checkNotNullExpressionValue(storyBaseInfo, "robotFeature.storyInfo");
        this$0.addToCache(str, storyBaseInfo);
        this$1.c(robotAIOEvent);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, RobotFeature robotFeature) {
        invoke(bool.booleanValue(), robotFeature);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16, @Nullable final RobotFeature robotFeature) {
        if (!z16 || robotFeature == null) {
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final RobotPersonalInfoServiceImpl robotPersonalInfoServiceImpl = this.this$0;
        final RobotAIOEvent robotAIOEvent = this.$event;
        final RobotPersonalInfoServiceImpl$mRobotListener$1 robotPersonalInfoServiceImpl$mRobotListener$1 = this.this$1;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.api.impl.l
            @Override // java.lang.Runnable
            public final void run() {
                RobotPersonalInfoServiceImpl$mRobotListener$1$onRobotAIOEventChanged$1.b(RobotPersonalInfoServiceImpl.this, robotAIOEvent, robotFeature, robotPersonalInfoServiceImpl$mRobotListener$1);
            }
        });
    }
}
