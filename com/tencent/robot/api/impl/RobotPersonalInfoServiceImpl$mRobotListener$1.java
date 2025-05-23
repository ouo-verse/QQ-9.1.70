package com.tencent.robot.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.RobotAIOEvent;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.bk;
import com.tencent.robot.api.IRobotPersonalInfoService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/robot/api/impl/RobotPersonalInfoServiceImpl$mRobotListener$1", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotAIOEvent;", "event", "", "c", "onRobotAIOEventChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPersonalInfoServiceImpl$mRobotListener$1 implements IKernelRobotListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RobotPersonalInfoServiceImpl f367413a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RobotPersonalInfoServiceImpl$mRobotListener$1(RobotPersonalInfoServiceImpl robotPersonalInfoServiceImpl) {
        this.f367413a = robotPersonalInfoServiceImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(RobotAIOEvent event) {
        Map map;
        boolean z16;
        Map map2;
        map = this.f367413a.mRobotListenerMap;
        Collection collection = (Collection) map.get(event.uid);
        if (collection != null && !collection.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            map2 = this.f367413a.mRobotListenerMap;
            Object obj = map2.get(event.uid);
            Intrinsics.checkNotNull(obj);
            Iterator it = ((HashSet) obj).iterator();
            while (it.hasNext()) {
                ((IKernelRobotListener) it.next()).onRobotAIOEventChanged(event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RobotPersonalInfoServiceImpl$mRobotListener$1 this$0, RobotAIOEvent robotAIOEvent, RobotPersonalInfoServiceImpl this$1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        QLog.i("RobotPersonalInfoServiceImpl-RobotStory", 1, "onRobotAIOEventChanged \u9000\u51fa\u6545\u4e8b\u96c6\u64cd\u4f5c---");
        this$0.c(robotAIOEvent);
        String str = robotAIOEvent.uid;
        Intrinsics.checkNotNullExpressionValue(str, "event.uid");
        this$1.removeFromCache(str);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public void onRobotAIOEventChanged(@Nullable final RobotAIOEvent event) {
        Map map;
        String str;
        bk.a(this, event);
        map = this.f367413a.mRobotListenerMap;
        IRuntimeService iRuntimeService = null;
        if (event != null) {
            str = event.uid;
        } else {
            str = null;
        }
        QLog.i("RobotPersonalInfoServiceImpl-RobotStory", 1, "onRobotAIOEventChanged event = " + event + ", listener=" + map.get(str));
        if (event == null) {
            return;
        }
        int i3 = event.changeId;
        if (i3 == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iRuntimeService = peekAppRuntime.getRuntimeService(IRobotPersonalInfoService.class, "");
            }
            IRobotPersonalInfoService iRobotPersonalInfoService = (IRobotPersonalInfoService) iRuntimeService;
            if (iRobotPersonalInfoService != null) {
                String str2 = event.uid;
                Intrinsics.checkNotNullExpressionValue(str2, "event.uid");
                iRobotPersonalInfoService.getRobotPersonalInfoAsync(str2, new RobotPersonalInfoServiceImpl$mRobotListener$1$onRobotAIOEventChanged$1(this.f367413a, event, this));
                return;
            }
            return;
        }
        if (i3 == 2) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final RobotPersonalInfoServiceImpl robotPersonalInfoServiceImpl = this.f367413a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.robot.api.impl.k
                @Override // java.lang.Runnable
                public final void run() {
                    RobotPersonalInfoServiceImpl$mRobotListener$1.d(RobotPersonalInfoServiceImpl$mRobotListener$1.this, event, robotPersonalInfoServiceImpl);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotCoreInfoChanged(RobotCoreInfo robotCoreInfo) {
        bk.b(this, robotCoreInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotFeatureChanged(GroupRobotProfile groupRobotProfile) {
        bk.c(this, groupRobotProfile);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotFriendListChanged() {
        bk.d(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotListChanged() {
        bk.e(this);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotProfileChanged(GroupRobotProfile groupRobotProfile) {
        bk.f(this, groupRobotProfile);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
    public /* synthetic */ void onRobotTabListChanged(String str) {
        bk.g(this, str);
    }
}
