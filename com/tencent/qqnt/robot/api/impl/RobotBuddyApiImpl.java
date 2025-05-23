package com.tencent.qqnt.robot.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener;
import com.tencent.qqnt.kernel.nativeinterface.RobotAIOEvent;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.bk;
import com.tencent.qqnt.robot.api.IRobotBuddyApi;
import com.tencent.robot.relation.api.IRobotRelationService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import u64.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/robot/api/impl/RobotBuddyApiImpl;", "Lcom/tencent/qqnt/robot/api/IRobotBuddyApi;", "", "robotUid", "", "robotUin", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddFriendCallback;", "callback", "", QQFriendJsPlugin.API_ADD_FRIEND, "Lkotlin/Function0;", "listener", "addRobotFriendShipChangedListener", "listenerID", "removeRobotFriendShipChangedListener", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotBuddyApiImpl implements IRobotBuddyApi {

    @NotNull
    private static final String TAG = "RobotBuddyApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/robot/api/impl/RobotBuddyApiImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRobotListener;", "", "onRobotFriendListChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements IKernelRobotListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f362075a;

        b(Function0<Unit> function0) {
            this.f362075a = function0;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public /* synthetic */ void onRobotAIOEventChanged(RobotAIOEvent robotAIOEvent) {
            bk.a(this, robotAIOEvent);
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
        public void onRobotFriendListChanged() {
            bk.d(this);
            this.f362075a.invoke();
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

    @Override // com.tencent.qqnt.robot.api.IRobotBuddyApi
    public void addFriend(@NotNull String robotUid, long robotUin, @NotNull IAddFriendCallback callback) {
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(robotUid, "robotUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        RobotAddFriendRequest robotAddFriendRequest = new RobotAddFriendRequest();
        robotAddFriendRequest.robotUid = robotUid;
        robotAddFriendRequest.robotUin = robotUin;
        QLog.d(TAG, 1, "[addFriend] req=" + robotAddFriendRequest);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            String valueOf = String.valueOf(robotAddFriendRequest.robotUin);
            String str = robotAddFriendRequest.robotUid;
            Intrinsics.checkNotNullExpressionValue(str, "robot.robotUid");
            iRobotRelationService.addRobotFriend(valueOf, str, callback);
        }
    }

    @Override // com.tencent.qqnt.robot.api.IRobotBuddyApi
    public long addRobotFriendShipChangedListener(@NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ac a16 = h.a();
        if (a16 != null) {
            return a16.addKernelRobotListener(new b(listener));
        }
        return Long.MIN_VALUE;
    }

    @Override // com.tencent.qqnt.robot.api.IRobotBuddyApi
    public void removeRobotFriendShipChangedListener(long listenerID) {
        ac a16 = h.a();
        if (a16 != null) {
            a16.removeKernelRobotListener(listenerID);
        }
    }
}
