package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import friendlist.FriendInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpdateItem;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class FriendStatusProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public FriendStatusProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private static void a(QQAppInterface qQAppInterface, String str, ExtensionInfo extensionInfo, Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem) {
        String str2 = new String(oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray());
        if (QLog.isDebugVersion()) {
            QLog.d("IMCore.friend.DontDisturbFriendProces", 2, "updateDontDisturb, friend.uin=", str, " setTime=", str2);
        }
        FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(str, 13579, 19);
        updateFriendStatusItem.f(oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray());
        FriendsStatusUtil.h(qQAppInterface, updateFriendStatusItem, extensionInfo);
    }

    private static void b(QQAppInterface qQAppInterface, String str, ExtensionInfo extensionInfo, Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem, boolean z16, Map<String, Boolean> map) {
        byte[] bArr;
        boolean z17 = false;
        if (oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
            byte[] byteArray = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray();
            if (byteArray.length != 0 && byteArray[0] != 0) {
                z17 = true;
            }
        }
        if (!z16) {
            FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(str, ProfileContants.FIELD_HIDDEN_CHAT_SWITCH, 21);
            if (z17) {
                bArr = new byte[1];
            } else {
                bArr = null;
            }
            updateFriendStatusItem.e(bArr);
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 1, "updateHiddenChatSwitch Friend push");
            FriendsStatusUtil.h(qQAppInterface, updateFriendStatusItem, extensionInfo);
            return;
        }
        if (str != null) {
            map.put(str, Boolean.valueOf(z17));
        }
    }

    private static void c(QQAppInterface qQAppInterface, String str, ExtensionInfo extensionInfo, Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem) {
        byte[] byteArray = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray();
        FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(str, ReportPlugin.REPORT_EVENT_JS_EXCEPTION, 21);
        updateFriendStatusItem.f(byteArray);
        FriendsStatusUtil.h(qQAppInterface, updateFriendStatusItem, extensionInfo);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.DontDisturbFriendProces", 2, "updateNotificationSetting: invoked. inc update notification switch::preview & vibrate", " uinStr: ", str);
        }
    }

    private static void d(QQAppInterface qQAppInterface, String str, ExtensionInfo extensionInfo, Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem) {
        FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(str, 13580, 21);
        if (oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
            updateFriendStatusItem.f(oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray());
            FriendsStatusUtil.h(qQAppInterface, updateFriendStatusItem, extensionInfo);
        }
        QLog.d("IMCore.friend.DontDisturbFriendProces", 2, "updateRingId: invoked. UPDATE_SNS_TYPE_RING_ID uin:", str);
    }

    private static void e(QQAppInterface qQAppInterface, String str, ExtensionInfo extensionInfo, Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem) {
        FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(str, 13578, 18);
        if (!oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
            updateFriendStatusItem.e(null);
        } else {
            updateFriendStatusItem.e(oidb_0x5d0$SnsUpdateItem.bytes_value.get().toByteArray());
        }
        FriendsStatusUtil.h(qQAppInterface, updateFriendStatusItem, extensionInfo);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> list, com.tencent.mobileqq.friend.data.a aVar, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, aVar, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.DontDisturbFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        HashMap hashMap = new HashMap();
        for (Pair<ExtensionInfo, FriendInfo> pair : list) {
            ExtensionInfo extensionInfo = (ExtensionInfo) pair.first;
            Oidb_0x5d0$SnsUpateBuffer parseSnsUpdateBuffer = parseSnsUpdateBuffer(((FriendInfo) pair.second).vecRing);
            if (parseSnsUpdateBuffer != null && parseSnsUpdateBuffer.rpt_msg_sns_update_item.has()) {
                String valueOf = String.valueOf(parseSnsUpdateBuffer.uint64_uin.get());
                for (Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem : parseSnsUpdateBuffer.rpt_msg_sns_update_item.get()) {
                    int i3 = oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get();
                    if (i3 == 13580) {
                        d(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                    } else if (i3 == 13582) {
                        c(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                    } else if (i3 == 13578) {
                        e(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                    } else if (i3 == 13579) {
                        a(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                    } else if (i3 == 13581) {
                        b(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem, true, hashMap);
                    }
                }
            }
        }
        if (hashMap.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_HIDDEN_CHAT, 1, "friendHiddenList onBatchUpdateExtensionInfo: ", Integer.valueOf(hashMap.size()));
            }
            FriendsStatusUtil.b(hashMap, qQAppInterface, z16);
        } else if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "friendList size 0");
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateExtensionInfo(ExtensionInfo extensionInfo, FriendInfo friendInfo, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, extensionInfo, friendInfo, aVar);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.DontDisturbFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        Oidb_0x5d0$SnsUpateBuffer parseSnsUpdateBuffer = parseSnsUpdateBuffer(friendInfo.vecRing);
        if (parseSnsUpdateBuffer != null && parseSnsUpdateBuffer.rpt_msg_sns_update_item.has()) {
            String valueOf = String.valueOf(parseSnsUpdateBuffer.uint64_uin.get());
            for (Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem : parseSnsUpdateBuffer.rpt_msg_sns_update_item.get()) {
                int i3 = oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get();
                if (i3 == 13580) {
                    d(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                } else if (i3 == 13582) {
                    c(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                } else if (i3 == 13578) {
                    e(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                } else if (i3 == 13579) {
                    a(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem);
                } else if (i3 == 13581) {
                    b(qQAppInterface, valueOf, extensionInfo, oidb_0x5d0$SnsUpdateItem, false, null);
                }
            }
        }
    }
}
