package com.tencent.mobileqq.matchfriend.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendDataUtilApiImpl implements IMatchFriendDataUtilApi {
    private static final String TAG = "MatchFriendDataUtilApiImpl";

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi
    public com.tencent.mobileqq.matchfriend.bean.b getMatchFriendUserSelfData() {
        com.tencent.mobileqq.matchfriend.bean.b bVar = new com.tencent.mobileqq.matchfriend.bean.b();
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        if (a16 instanceof userInfo$MiniInfo) {
            userInfo$MiniInfo userinfo_miniinfo = (userInfo$MiniInfo) a16;
            bVar.f244051a = userinfo_miniinfo.open_id.get();
            bVar.f244052b = userinfo_miniinfo.nick.get();
            bVar.f244053c = userinfo_miniinfo.avatar.get();
            bVar.f244054d = userinfo_miniinfo.constellation.get();
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi
    public List<ResultRecord> getMsgListUserData(boolean z16) {
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi
    public boolean isFromMatchFriend(int i3, int i16) {
        if (i3 == 3094) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi
    public String matchFriendAppName(AppRuntime appRuntime) {
        String matchFriendName = getMatchFriendName(appRuntime);
        return TextUtils.isEmpty(matchFriendName) ? "" : matchFriendName;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi
    public List<RecentUser> getForwardRecentList() {
        List<ResultRecord> msgListUserData = getMsgListUserData(true);
        ArrayList arrayList = new ArrayList();
        if (msgListUserData != null && !msgListUserData.isEmpty()) {
            for (ResultRecord resultRecord : msgListUserData) {
                RecentUser recentUser = new RecentUser(resultRecord.uin, resultRecord.uinType);
                recentUser.displayName = resultRecord.name;
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }

    private String getMatchFriendName(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return null;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        if (iFeatureRuntimeService.isFeatureSwitchEnable("qqstranger_app_name")) {
            return iFeatureRuntimeService.getString("qqstranger_app_name", "");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.IMatchFriendDataUtilApi
    public boolean getHeartbeatReportSwitch(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return false;
        }
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qqstranger_heartbeat_report_switch");
    }
}
