package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpdateItem;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class QIMFriendProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public QIMFriendProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> list, long j3, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        for (Pair<Friends, FriendInfo> pair : list) {
            Friends friends = (Friends) pair.first;
            Oidb_0x5d0$SnsUpateBuffer parseSnsUpdateBuffer = parseSnsUpdateBuffer(((FriendInfo) pair.second).vecRing);
            if (parseSnsUpdateBuffer != null && parseSnsUpdateBuffer.rpt_msg_sns_update_item.has()) {
                for (Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem : parseSnsUpdateBuffer.rpt_msg_sns_update_item.get()) {
                    if (oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get() == 13824) {
                        byte[] byteArray = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray();
                        if (byteArray.length >= 1) {
                            i3 = byteArray[0] & 2;
                            if (i3 == 2) {
                                friends.friendType = 1;
                            }
                        } else {
                            i3 = 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("IMCore.friend.QIMFriendProcessor", 2, "updateQimFriend | friend.uin : " + friends.uin + " | friend.friendType : " + friends.friendType + " | itemType : " + i3);
                        }
                    }
                }
            }
        }
    }
}
