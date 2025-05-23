package com.tencent.robot.api.impl;

import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendRequest;
import com.tencent.qqnt.kernel.nativeinterface.RobotAddFriendResponse;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.robot.relation.api.IRobotRelationService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0016J\u001e\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/api/impl/RobotIdentityApiImpl;", "Lcom/tencent/robot/api/IRobotIdentityApi;", "", "userUin", "", "isRobotUin", "(Ljava/lang/Long;)Z", "", "uid", "Lkotlin/Function0;", "", "afterAddFriend", "checkAndAddFriend", "", "uinType", "isMatchRobotUinType", "(Ljava/lang/Integer;)Z", "chatType", "isMatchRobotChatType", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotIdentityApiImpl implements IRobotIdentityApi {

    @NotNull
    private static final String TAG = "RobotIdentityApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndAddFriend$lambda$0(Function0 afterAddFriend, int i3, String str, RobotAddFriendResponse robotAddFriendResponse) {
        Intrinsics.checkNotNullParameter(afterAddFriend, "$afterAddFriend");
        QLog.d(TAG, 1, "[addFriend] res=" + i3 + ", errMsg=" + str + ", robotUid=" + robotAddFriendResponse.robotUid);
        if (i3 == 0) {
            afterAddFriend.invoke();
        }
    }

    @Override // com.tencent.robot.api.IRobotIdentityApi
    public void checkAndAddFriend(@NotNull String uid, @NotNull final Function0<Unit> afterAddFriend) {
        boolean z16;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(afterAddFriend, "afterAddFriend");
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 != null) {
            z16 = Intrinsics.areEqual(b16.isBuddy(uid), Boolean.TRUE);
        } else {
            z16 = false;
        }
        if (z16) {
            afterAddFriend.invoke();
            return;
        }
        RobotAddFriendRequest robotAddFriendRequest = new RobotAddFriendRequest();
        robotAddFriendRequest.robotUid = uid;
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
            iRobotRelationService.addRobotFriend(valueOf, str, new IAddFriendCallback() { // from class: com.tencent.robot.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback
                public final void onResult(int i3, String str2, RobotAddFriendResponse robotAddFriendResponse) {
                    RobotIdentityApiImpl.checkAndAddFriend$lambda$0(Function0.this, i3, str2, robotAddFriendResponse);
                }
            });
        }
    }

    @Override // com.tencent.robot.api.IRobotIdentityApi
    public boolean isMatchRobotChatType(@Nullable Integer chatType) {
        if (chatType != null && chatType.intValue() == 1) {
            return true;
        }
        if (chatType != null && chatType.intValue() == 42) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.robot.api.IRobotIdentityApi
    public boolean isMatchRobotUinType(@Nullable Integer uinType) {
        if (uinType != null && uinType.intValue() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.robot.api.IRobotIdentityApi
    public boolean isRobotUin(@Nullable String userUin) {
        if (!(userUin == null || userUin.length() == 0)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ITroopRobotService iTroopRobotService = (ITroopRobotService) (peekAppRuntime != null ? peekAppRuntime.getRuntimeService(ITroopRobotService.class, "") : null);
            if (iTroopRobotService != null ? iTroopRobotService.isRobotUin(userUin) : false) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.robot.api.IRobotIdentityApi
    public boolean isRobotUin(@Nullable Long userUin) {
        if (userUin == null) {
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ITroopRobotService iTroopRobotService = (ITroopRobotService) (peekAppRuntime != null ? peekAppRuntime.getRuntimeService(ITroopRobotService.class, "") : null);
        return iTroopRobotService != null ? iTroopRobotService.isRobotUin(userUin.longValue()) : false;
    }
}
