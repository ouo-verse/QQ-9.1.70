package com.tencent.robot.relation.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.IAddFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRemoveFriendCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotAuthCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetRemoveRobotFromGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotUserPermissionType;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000fH&J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0011H&J,\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u0016H&J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0018H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/relation/api/IRobotRelationService;", "Lmqq/app/api/IRuntimeService;", "La54/a;", "observer", "", "addRelationObserver", "removeRelationObserver", "", "robotUin", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotUserPermissionType;", "permissionType", "Lcom/tencent/qqnt/kernel/nativeinterface/IRobotAuthCallback;", "callback", "authVerifyRobot", "robotUid", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddFriendCallback;", "addRobotFriend", "Lcom/tencent/qqnt/kernel/nativeinterface/IRemoveFriendCallback;", "removeRobotFriend", "troopUin", "", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/qqnt/kernel/nativeinterface/ISetAddRobotToGroupCallback;", "addRobotToTroop", "Lcom/tencent/qqnt/kernel/nativeinterface/ISetRemoveRobotFromGroupCallback;", "removeRobotFromGroup", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface IRobotRelationService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(IRobotRelationService iRobotRelationService, String str, String str2, Object obj, ISetAddRobotToGroupCallback iSetAddRobotToGroupCallback, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 4) != 0) {
                    obj = null;
                }
                iRobotRelationService.addRobotToTroop(str, str2, obj, iSetAddRobotToGroupCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRobotToTroop");
        }
    }

    void addRelationObserver(@NotNull a54.a observer);

    void addRobotFriend(@NotNull String robotUin, @NotNull String robotUid, @NotNull IAddFriendCallback callback);

    void addRobotToTroop(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData, @NotNull ISetAddRobotToGroupCallback callback);

    void authVerifyRobot(@NotNull String robotUin, @NotNull RobotUserPermissionType permissionType, @NotNull IRobotAuthCallback callback);

    void removeRelationObserver(@NotNull a54.a observer);

    void removeRobotFriend(@NotNull String robotUin, @NotNull String robotUid, @NotNull IRemoveFriendCallback callback);

    void removeRobotFromGroup(@NotNull String robotUin, @NotNull String troopUin, @NotNull ISetRemoveRobotFromGroupCallback callback);
}
