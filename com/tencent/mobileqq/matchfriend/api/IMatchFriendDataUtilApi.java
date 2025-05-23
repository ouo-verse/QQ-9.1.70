package com.tencent.mobileqq.matchfriend.api;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendDataUtilApi extends QRouteApi {
    List<RecentUser> getForwardRecentList();

    boolean getHeartbeatReportSwitch(AppRuntime appRuntime);

    com.tencent.mobileqq.matchfriend.bean.b getMatchFriendUserSelfData();

    List<ResultRecord> getMsgListUserData(boolean z16);

    boolean isFromMatchFriend(int i3, int i16);

    String matchFriendAppName(AppRuntime appRuntime);
}
