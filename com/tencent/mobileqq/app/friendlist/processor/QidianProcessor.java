package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class QidianProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public QidianProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.d("IMCore.friend.QidianProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        int size = list.size();
        Friends[] friendsArr = new Friends[size];
        for (int i3 = 0; i3 < size; i3++) {
            Pair<Friends, FriendInfo> pair = list.get(i3);
            Friends friends = (Friends) pair.first;
            friends.strMasterUin = ((FriendInfo) pair.second).strMasterUin;
            friendsArr[i3] = friends;
        }
        QidianManager.p0(qQAppInterface, friendsArr);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateFriendInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) friends, (Object) friendInfo);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.QidianProcessor", 1, "onUpdateFriendInfo| app is not QQAppInterface");
        } else {
            QidianManager.n0((QQAppInterface) appRuntime, friends);
        }
    }
}
