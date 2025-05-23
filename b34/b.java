package b34;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.robot.titlebar.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.InputBox;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.aio.bottombar.model.RobotProfileExtKt;
import com.tencent.robot.profile.RobotProfileMsgIntent;
import java.util.HashSet;
import java.util.Set;
import k81.RobotModelProfileInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001\u0014\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lb34/b;", "Lcom/tencent/mobileqq/aio/robot/titlebar/m;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "r", "", "showEar", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "b34/b$b", h.F, "Lb34/b$b;", "mAction", "<init>", "()V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends m {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C0092b mAction = new C0092b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"b34/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: b34.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C0092b implements com.tencent.mvi.base.route.a {
        C0092b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof RobotProfileMsgIntent.OnRobotProfileUpdate) {
            s(((RobotProfileMsgIntent.OnRobotProfileUpdate) intent).getRobotProfile());
            return;
        }
        if (intent instanceof RobotProfileMsgIntent.OnRobotCoreInfoUpdated) {
            r(((RobotProfileMsgIntent.OnRobotCoreInfoUpdated) intent).getRobotCoreInfo());
        } else if (intent instanceof AIOTitleEvent.UpdateEarIconEvent) {
            q(((AIOTitleEvent.UpdateEarIconEvent) intent).a());
        } else if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            l(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
        }
    }

    private final void q(boolean showEar) {
        m(showEar);
    }

    private final void r(RobotCoreInfo robotCoreInfo) {
        String str;
        InputBox inputBox = robotCoreInfo.inputBox;
        if (inputBox != null) {
            str = RobotProfileExtKt.b(inputBox);
        } else {
            str = null;
        }
        QLog.i("RobotTopBarVM", 1, "handleRobotCoreInfoUpdated modelInfo: " + str);
        n(RobotProfileExtKt.i(robotCoreInfo));
    }

    private final void s(GroupRobotProfile robotProfile) {
        String str;
        InputBox inputBox;
        RobotModelProfileInfo robotModelProfileInfo = null;
        if (robotProfile != null && (inputBox = robotProfile.inputBox) != null) {
            str = RobotProfileExtKt.b(inputBox);
        } else {
            str = null;
        }
        QLog.i("RobotTopBarVM", 1, "handleRobotProfileUpdated modelInfo: " + str);
        if (robotProfile != null) {
            robotModelProfileInfo = RobotProfileExtKt.h(robotProfile);
        }
        n(robotModelProfileInfo);
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotProfileUpdate");
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotCoreInfoUpdated");
        hashSet.add("com.tencent.robot.profile.RobotProfileMsgIntent.OnRobotPersonalInfoUpdated");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateEarIconEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
    }
}
