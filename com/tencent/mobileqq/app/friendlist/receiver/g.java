package com.tencent.mobileqq.app.friendlist.receiver;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.z;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.LastLoginInfo;
import friendlist.LastLoginPageInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends a {
    static IPatchRedirector $redirector_;

    public g(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(FromServiceMsg fromServiceMsg, GetLastLoginInfoResp getLastLoginInfoResp) {
        if (fromServiceMsg.isSuccess() && getLastLoginInfoResp != null && getLastLoginInfoResp.errorCode == 0) {
            LastLoginPageInfo lastLoginPageInfo = getLastLoginInfoResp.stPageInfo;
            ArrayList<LastLoginInfo> arrayList = getLastLoginInfoResp.vecLastLoginInfo;
            g(arrayList);
            long j3 = lastLoginPageInfo.dwCurrentReqIndex;
            long j16 = lastLoginPageInfo.dwTotalReqTimes;
            if (j3 == j16) {
                z.k(this.f195646a.getApp().getApplicationContext(), this.f195646a.getAccount(), getLastLoginInfoResp.iRefreshIntervalMin);
                this.f195647b.notifyUI(47, true, Boolean.TRUE);
                return;
            } else {
                if (j3 < j16) {
                    this.f195647b.notifyUI(47, true, Boolean.FALSE);
                    this.f195647b.getLastLoginInfo(lastLoginPageInfo.dwTotalReqTimes, lastLoginPageInfo.dwCurrentReqIndex, lastLoginPageInfo.dwCurrentReqUin);
                    return;
                }
                return;
            }
        }
        this.f195647b.notifyUI(47, false, Boolean.TRUE);
    }

    private void f(FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int i16;
        if (obj instanceof GetSimpleOnlineFriendInfoResp) {
            GetSimpleOnlineFriendInfoResp getSimpleOnlineFriendInfoResp = (GetSimpleOnlineFriendInfoResp) obj;
            if (getSimpleOnlineFriendInfoResp == null) {
                b(13, false, null);
                return;
            }
            if (getSimpleOnlineFriendInfoResp.result == 1) {
                b(13, false, null);
                return;
            }
            short s16 = getSimpleOnlineFriendInfoResp.shClickInterval;
            if (s16 > 30) {
                i3 = s16 * 1000;
            } else {
                i3 = 30000;
            }
            QQAppInterface.sGetOnlineFriendDelay = i3;
            byte b16 = getSimpleOnlineFriendInfoResp.intervalTimeMin;
            if (b16 > 3) {
                i16 = b16 * 60 * 1000;
            } else {
                i16 = 180000;
            }
            QQAppInterface.sNextGetOnlineFriendDelay = i16;
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "Next Get Online Friend Delay " + QQAppInterface.sNextGetOnlineFriendDelay);
            }
            this.f195647b.saveShowPcIconIfNeccessary(getSimpleOnlineFriendInfoResp.cShowPcIcon);
            if (getSimpleOnlineFriendInfoResp.vecFriendInfo.size() > 0) {
                ((FriendsManager) this.f195646a.getManager(QQManagerFactory.FRIENDS_MANAGER)).L0(getSimpleOnlineFriendInfoResp.vecFriendInfo);
                b(13, true, null);
            } else {
                b(13, false, null);
            }
        }
    }

    private void g(List<LastLoginInfo> list) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
        String str;
        boolean z16;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid;
        boolean z17;
        boolean z18;
        int i3;
        String str2 = "FriendListHandler.BaseHandlerReceiver";
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("saveLastLoginInfos begin ");
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, sb5.toString());
        }
        FriendsManager friendsManager = (FriendsManager) this.f195646a.getManager(QQManagerFactory.FRIENDS_MANAGER);
        List<Friends> z19 = friendsManager.z();
        ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> arrayList = new ArrayList<>();
        IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class);
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        if (list != null && z19 != null) {
            ArrayList arrayList2 = new ArrayList(z19.size());
            if (list.size() == 0) {
                for (Friends friends : z19) {
                    if (friends != null && (onlineStatusSimpleInfoWithUid = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(iRelationNTUinAndUidApi.getUidFromUin(friends.uin), "FriendListHandler.BaseHandlerReceiver")) != null) {
                        if (friends.lastLoginType != 0) {
                            friends.lastLoginType = 0L;
                            onlineStatusSimpleInfoWithUid.N0(0L);
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (friends.showLoginClient != 0) {
                            friends.showLoginClient = 0L;
                            onlineStatusSimpleInfoWithUid.M0(0L);
                            z18 = true;
                        } else {
                            z18 = z17;
                        }
                        if (z18) {
                            arrayList2.add(friends);
                            arrayList.add(onlineStatusSimpleInfoWithUid);
                        }
                    }
                }
            } else {
                for (LastLoginInfo lastLoginInfo : list) {
                    Friends v3 = friendsManager.v(String.valueOf(lastLoginInfo.dwFriendUin));
                    String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(String.valueOf(lastLoginInfo.dwFriendUin));
                    if (!TextUtils.isEmpty(uidFromUin)) {
                        cVar = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(uidFromUin, str2);
                    } else {
                        cVar = null;
                    }
                    if (v3 != null && cVar != null) {
                        long j3 = v3.showLoginClient;
                        long j16 = lastLoginInfo.dwClient;
                        if (j3 != j16) {
                            v3.showLoginClient = j16;
                            cVar.M0(j16);
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        long j17 = v3.lastLoginType;
                        str = str2;
                        long j18 = lastLoginInfo.dwLastLoginType;
                        if (j17 != j18) {
                            v3.lastLoginType = j18;
                            cVar.N0(j18);
                            z16 = true;
                        }
                        if (z16) {
                            arrayList2.add(v3);
                            arrayList.add(cVar);
                        }
                    } else {
                        str = str2;
                    }
                    str2 = str;
                }
            }
            Friends[] friendsArr = new Friends[arrayList2.size()];
            str2 = str2;
            iOnlineStatusInfoService.updateOnlineStatusSimpleInfo(arrayList, str2, (hx3.c<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a>) null);
        }
        if (QLog.isColorLevel()) {
            QLog.d(str2, 2, "saveLastLoginInfos ends ");
        }
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"friendlist.GetLastLoginInfoReq".equals(str) && !"friendlist.GetSimpleOnlineFriendInfoReq".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("friendlist.GetLastLoginInfoReq".equals(serviceCmd)) {
            e(fromServiceMsg, (GetLastLoginInfoResp) obj);
        } else if ("friendlist.GetSimpleOnlineFriendInfoReq".equals(serviceCmd)) {
            if (obj != null) {
                f(fromServiceMsg, obj);
            } else {
                b(13, false, null);
            }
        }
    }
}
