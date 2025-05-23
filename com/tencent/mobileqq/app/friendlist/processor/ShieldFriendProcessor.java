package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import friendlist.FriendInfo;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpateBuffer;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class ShieldFriendProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public ShieldFriendProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void a(Friends friends, FriendInfo friendInfo) {
        Oidb_0x5d0$SnsUpateBuffer parseSnsUpdateBuffer = parseSnsUpdateBuffer(friendInfo.vecRing);
        if (parseSnsUpdateBuffer != null && parseSnsUpdateBuffer.rpt_uin32_idlist.has()) {
            for (Integer num : parseSnsUpdateBuffer.rpt_uin32_idlist.get()) {
                if (num.intValue() == 4051) {
                    friends.setShieldFlag(true);
                } else if (num.intValue() == 4090) {
                    friends.setIsBlackFlag(1);
                } else if (num.intValue() == 4092) {
                    friends.setIsBlackedFlag(1);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        for (Pair<Friends, FriendInfo> pair : list) {
            a((Friends) pair.first, (FriendInfo) pair.second);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateFriendInfo(Friends friends, FriendInfo friendInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) friends, (Object) friendInfo);
        } else {
            a(friends, friendInfo);
        }
    }
}
