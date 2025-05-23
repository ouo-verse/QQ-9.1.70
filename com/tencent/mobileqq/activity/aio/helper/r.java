package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/r;", "Lcom/tencent/qqnt/aio/frame/b;", "", "peerId", "", "peerUin", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class r implements com.tencent.qqnt.aio.frame.b {
    @Override // com.tencent.qqnt.aio.frame.b
    public boolean a(@Nullable String peerId, long peerUin) {
        if (!com.tencent.mobileqq.activity.aio.drawer.a.c()) {
            QLog.d("C2CRightFrameSupportProcessor", 1, "createChatDrawer, dpc not support!");
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        if (((peerId == null || Intrinsics.areEqual(peerId, peekAppRuntime.getCurrentUid())) && Intrinsics.areEqual(String.valueOf(peerUin), peekAppRuntime.getCurrentUin())) || peerUin == AppConstants.BABY_Q_UIN_LONGVALUE) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        if (((ITroopRobotService) runtimeService).isRobotUin(peerUin)) {
            return false;
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(peerUin));
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (!iFriendsInfoService.isFriend(uid, "C2CRightFrameSupportProcessor")) {
            QLog.i("C2CRightFrameSupportProcessor", 2, "is not friend");
            return false;
        }
        if (FriendIntimateRelationshipHelper.m(peekAppRuntime.getCurrentUin())) {
            return true;
        }
        QLog.i("C2CRightFrameSupportProcessor", 2, "aio intimate is close");
        return false;
    }
}
