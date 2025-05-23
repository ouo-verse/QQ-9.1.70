package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.manager.g;
import com.tencent.mobileqq.onlinestatus.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
@Deprecated
/* loaded from: classes11.dex */
public class OnlineStatusProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public OnlineStatusProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        g gVar;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            QLog.e("IMCore.friend.OnlineStatusFriendProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        HashMap hashMap = new HashMap();
        IFriendDataService iFriendDataService = (IFriendDataService) this.mApp.getRuntimeService(IFriendDataService.class, "all");
        ArrayList arrayList = new ArrayList(list.size());
        boolean z17 = false;
        for (Pair<Friends, FriendInfo> pair : list) {
            Friends friends = (Friends) pair.first;
            arrayList.add(friends);
            FriendInfo friendInfo = (FriendInfo) pair.second;
            friends.uExtOnlineStatus = friendInfo.uExtOnlineStatus;
            friends.iBatteryStatus = friendInfo.iBatteryStatus;
            k.F(friends, friendInfo.vecMusicInfo, "GetFriendList");
            Friends friend = iFriendDataService.getFriend(friends.uin);
            bs.w0(friends, friendInfo.vecExtOnlineBusinessInfo, "GetFriendList", friend);
            byte[] bArr = friendInfo.vecExtInfo;
            if (friend != null) {
                j16 = friend.onlineStatusUpdateTime;
            } else {
                j16 = 0;
            }
            bs.x0(friends, bArr, j16, hashMap);
            if (friends.uExtOnlineStatus == 1080 && !SimpleUIUtil.getSimpleUISwitch()) {
                z17 = true;
            }
        }
        bs.H0(hashMap);
        if (z17) {
            ((IOnlineStatusService) this.mApp.getRuntimeService(IOnlineStatusService.class, "")).getOlympicMedalEventReq(false, false);
        }
        if (z16 && (gVar = (g) ((IOnlineStatusManagerService) this.mApp.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(g.class)) != null) {
            gVar.v();
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateFriendInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) friends, (Object) friendInfo);
        } else {
            friends.uExtOnlineStatus = friendInfo.uExtOnlineStatus;
            friends.iBatteryStatus = friendInfo.iBatteryStatus;
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateSelfInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) friends, (Object) friendInfo);
            return;
        }
        friends.iBatteryStatus = friendInfo.iBatteryStatus;
        friends.uExtOnlineStatus = friendInfo.uExtOnlineStatus;
        k.F(friends, friendInfo.vecMusicInfo, "GetFriendList(self)");
        bs.v0(friends, friendInfo.vecExtOnlineBusinessInfo, "GetFriendList(self)");
        bs.x0(friends, friendInfo.vecExtInfo, 0L, null);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.OnlineStatusFriendProcessor", 2, "handleGetFriendList selfUin=" + friends.uin + ", cSpecialFlag=" + ((int) friends.cSpecialFlag), " battery:", Integer.valueOf(friendInfo.iBatteryStatus), " extOnline:", Long.valueOf(friendInfo.uExtOnlineStatus));
        }
    }
}
