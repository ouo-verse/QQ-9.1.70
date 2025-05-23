package com.tencent.mobileqq.app.friendlist.processor;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class DiscussionProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public DiscussionProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        ArrayList arrayList;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.DiscussionProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        IFriendDataService iFriendDataService = (IFriendDataService) appRuntime.getRuntimeService(IFriendDataService.class, "all");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Pair<Friends, FriendInfo> pair : list) {
            Friends friends = (Friends) pair.first;
            Friends friend = iFriendDataService.getFriend(friends.uin);
            FriendInfo friendInfo = (FriendInfo) pair.second;
            if (friend != null && QQProfileItem.a(friends.name, friend.name)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendsManagerfriend", i16, "handleGetFriendList friend Name changed.oldName " + friend.name + ",newName " + friends.name + ",oldRemark " + friend.remark + ",newRemark =" + friends.remark);
                }
                arrayList = arrayList2;
                arrayList.add(new Pair(Long.valueOf(friendInfo.friendUin), friends.name));
            } else {
                arrayList = arrayList2;
            }
            if (friend != null && !TextUtils.isEmpty(friendInfo.nick) && !friendInfo.nick.equals(friendInfo.remark) && QQProfileItem.b(friends.remark, friend.remark)) {
                if (QLog.isColorLevel()) {
                    i3 = 2;
                    QLog.d("FriendsManagerfriend", 2, "handleGetFriendList friend remark changed.oldName " + friend.name + ",newName " + friends.name + ",oldRemark " + friend.remark + ",newRemark =" + friends.remark);
                } else {
                    i3 = 2;
                }
                arrayList3.add(new Pair(Long.valueOf(friendInfo.friendUin), friends.remark));
            } else {
                i3 = 2;
            }
            arrayList2 = arrayList;
            i16 = i3;
        }
        ArrayList arrayList4 = arrayList2;
        n nVar = (n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        if (arrayList4.size() > 0) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                Pair pair2 = (Pair) it.next();
                QQProfileItem.B(((Long) pair2.first).longValue(), (String) pair2.second, nVar);
            }
        }
        if (arrayList3.size() > 0) {
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                Pair pair3 = (Pair) it5.next();
                QQProfileItem.C(((Long) pair3.first).longValue(), (String) pair3.second, nVar);
            }
        }
    }
}
