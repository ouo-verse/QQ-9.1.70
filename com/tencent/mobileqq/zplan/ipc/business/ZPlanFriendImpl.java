package com.tencent.mobileqq.zplan.ipc.business;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.mobileqq.zplan.ipc.business.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J>\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/ipc/business/ZPlanFriendImpl;", "Lcom/tencent/mobileqq/zplan/ipc/business/c;", "", "uin", "Lcom/tencent/mobileqq/zplan/ipc/business/c$a;", "izPlanFriendResult", "", IProfileProtocolConst.PARAM_IS_FRIEND, "", "accept", "openId", "appId", "", "sourceId", "subSourceId", QQFriendJsPlugin.API_ADD_FRIEND, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendImpl implements c {
    @Override // com.tencent.mobileqq.zplan.ipc.business.c
    public /* bridge */ /* synthetic */ void addFriend(Boolean bool, String str, String str2, String str3, int i3, int i16) {
        addFriend(bool.booleanValue(), str, str2, str3, i3, i16);
    }

    @Override // com.tencent.mobileqq.zplan.ipc.business.c
    public void isFriend(String uin, c.a izPlanFriendResult) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(izPlanFriendResult, "izPlanFriendResult");
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        izPlanFriendResult.a(iFriendsInfoService.isFriend(uid, "ZPlanFriendImpl"));
    }

    public void addFriend(boolean accept, String uin, String openId, String appId, int sourceId, int subSourceId) {
        Intent startAddFriend;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            return;
        }
        if (accept) {
            if (uin == null || uin.length() == 0) {
                QLog.d("ZPlanSameStyle", 1, "addFriend type is openid");
                startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(topActivity, 3, openId, appId, sourceId, subSourceId, null, null, null, "", null);
                Intrinsics.checkNotNullExpressionValue(startAddFriend, "{\n                QLog.d\u2026          )\n            }");
            } else {
                QLog.d("ZPlanSameStyle", 1, "addFriend type is uin");
                startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(topActivity, 1, uin, "", sourceId, subSourceId, null, null, null, "", null);
                Intrinsics.checkNotNullExpressionValue(startAddFriend, "{\n                QLog.d\u2026          )\n            }");
            }
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(topActivity, startAddFriend);
            return;
        }
        QLog.d("ZPlanSameStyle", 1, "addFriend error");
        ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).showRefuseAddFriendDialog(topActivity);
    }
}
