package com.tencent.mobileqq.app.friendlist.receiver;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6$RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6$SnsUpateResult;
import tencent.im.oidb.cmd0xc83$RspBody;
import tencent.im.oidb.cmd0xc85$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    public e(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        boolean isSuccess = fromServiceMsg.isSuccess();
        cmd0xc85$RspBody cmd0xc85_rspbody = new cmd0xc85$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xc85_rspbody);
        if (parseOIDBPkg != 0) {
            isSuccess = false;
        }
        if (isSuccess && cmd0xc85_rspbody.uint32_result.has() && cmd0xc85_rspbody.uint32_result.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String string = toServiceMsg.extraData.getString("selfUin", "");
        String string2 = toServiceMsg.extraData.getString("frdUin", "");
        if (cmd0xc85_rspbody.uint32_recent_interaction_time.has()) {
            i3 = cmd0xc85_rspbody.uint32_recent_interaction_time.get();
        } else {
            i3 = 0;
        }
        long j3 = i3;
        if (i3 > 0) {
            j3 = ((86400 * i3) - 28800) * 1000;
        }
        if (j3 >= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z18 = z16 & z17;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z18);
            objArr[1] = Integer.valueOf(parseOIDBPkg);
            if (cmd0xc85_rspbody.uint32_result.has()) {
                i16 = cmd0xc85_rspbody.uint32_result.get();
            } else {
                i16 = -1;
            }
            objArr[2] = Integer.valueOf(i16);
            objArr[3] = Integer.valueOf(i3);
            QLog.i("IceBreak", 2, String.format("handleReqLastChatTime suc=%b oidb=%d result=%d ts=%d", objArr));
        }
        b(111, z18, new Object[]{string, string2, Long.valueOf(j3)});
    }

    private void g(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        int i16;
        boolean isSuccess = fromServiceMsg.isSuccess();
        cmd0xc83$RspBody cmd0xc83_rspbody = new cmd0xc83$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xc83_rspbody);
        if (parseOIDBPkg != 0) {
            isSuccess = false;
        }
        if (isSuccess && cmd0xc83_rspbody.uint32_result.has() && cmd0xc83_rspbody.uint32_result.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String string = toServiceMsg.extraData.getString("selfUin", "");
        String string2 = toServiceMsg.extraData.getString("frdUin", "");
        if (cmd0xc83_rspbody.uint32_retry_interval.has()) {
            i3 = cmd0xc83_rspbody.uint32_retry_interval.get();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z16);
            objArr[1] = Integer.valueOf(parseOIDBPkg);
            if (cmd0xc83_rspbody.uint32_result.has()) {
                i16 = cmd0xc83_rspbody.uint32_result.get();
            } else {
                i16 = -1;
            }
            objArr[2] = Integer.valueOf(i16);
            objArr[3] = Integer.valueOf(i3);
            QLog.i("FriendReactive", 2, String.format("handleReqRecheckInHotReactive suc=%b oidb=%d result=%d interval=%d", objArr));
        }
        b(110, z16, new Object[]{string, string2, Integer.valueOf(i3)});
    }

    private void h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "FriendListHandler.handleSetHiddenChatResp(). res=" + fromServiceMsg + ", data=" + obj);
        }
        String[] stringArray = toServiceMsg.extraData.getStringArray(FriendListHandler.PARAM_UINS);
        int[] intArray = toServiceMsg.extraData.getIntArray(FriendListHandler.PARAM_CHAT_TYPES);
        boolean[] booleanArray = toServiceMsg.extraData.getBooleanArray(FriendListHandler.PARAM_SWITCH_STATE);
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "parse oidb_sso.OIDBSSOPkg failed.");
                }
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "ssoPkg.uint32_result=" + i3);
                }
                if (i3 == 0) {
                    for (int i16 = 0; i16 < stringArray.length; i16++) {
                        String str = stringArray[i16];
                        boolean z17 = booleanArray[i16];
                        int i17 = intArray[i16];
                        FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(str, ProfileContants.FIELD_HIDDEN_CHAT_SWITCH, 21);
                        if (z17) {
                            updateFriendStatusItem.e(new byte[1]);
                        } else {
                            updateFriendStatusItem.e(null);
                        }
                        FriendsStatusUtil.h(this.f195646a, updateFriendStatusItem, null);
                    }
                    z16 = true;
                    b(121, z16, new Object[]{stringArray, booleanArray});
                }
            }
        }
        z16 = false;
        b(121, z16, new Object[]{stringArray, booleanArray});
    }

    private void i(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_MSG_NOTIFICATION, 2, "FriendListHandler.handleSetMessageNotificationSettingResp(). res=" + fromServiceMsg + ", data=" + obj);
        }
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.f195646a);
        int i3 = toServiceMsg.extraData.getInt("param_type");
        String[] stringArray = toServiceMsg.extraData.getStringArray(FriendListHandler.PARAM_UINS);
        boolean[] booleanArray = toServiceMsg.extraData.getBooleanArray(FriendListHandler.PARAM_SWITCH_STATE);
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "parse oidb_sso.OIDBSSOPkg failed.");
                }
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                int i16 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "ssoPkg.uint32_result=" + i16);
                }
                if (i16 == 0) {
                    for (int i17 = 0; i17 < stringArray.length; i17++) {
                        l3.T(stringArray[i17], i3, booleanArray[i17]);
                    }
                    z16 = true;
                    b(122, z16, new Object[]{stringArray, booleanArray, Integer.valueOf(i3)});
                }
            }
        }
        z16 = false;
        b(122, z16, new Object[]{stringArray, booleanArray, Integer.valueOf(i3)});
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"OidbSvc.0xc83".equals(str) && !"OidbSvc.0xc85".equals(str) && !"OidbSvc.0x5d6_21".equals(str) && !"OidbSvc.0x5d6_18".equals(str) && !"OidbSvc.0x5d6_19".equals(str)) {
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
        if ("OidbSvc.0xc83".equals(serviceCmd)) {
            g(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xc85".equals(serviceCmd)) {
            f(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x5d6_21".equals(serviceCmd)) {
            if (toServiceMsg.extraData.getInt("param_type") == 0) {
                h(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                i(toServiceMsg, fromServiceMsg, obj);
                return;
            }
        }
        if ("OidbSvc.0x5d6_18".equals(serviceCmd) || "OidbSvc.0x5d6_19".equals(serviceCmd)) {
            e(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        int i3 = toServiceMsg.extraData.getInt("param_type", -1);
        ArrayList parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList(FriendListHandler.PARAM_STATUS_ITEM_LIST);
        boolean z16 = toServiceMsg.extraData.getBoolean(FriendListHandler.PARAM_NOTIFY_PLUGIN, false);
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage serviceType=" + i3);
        }
        if (fromServiceMsg != null && obj != null && fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage parse oidb_sso.OIDBSSOPkg failed.");
                }
                FriendsStatusUtil.f(i3, false, parcelableArrayList, null, this.f195646a, z16);
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                int i16 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "ssoPkg.uint32_result=" + i16);
                }
                if (i16 == 0) {
                    oidb_0x5d6$RspBody oidb_0x5d6_rspbody = new oidb_0x5d6$RspBody();
                    try {
                        oidb_0x5d6_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                        List<oidb_0x5d6$SnsUpateResult> list = oidb_0x5d6_rspbody.rpt_msg_update_result.get();
                        if (list != null && !list.isEmpty()) {
                            FriendsStatusUtil.f(i3, true, parcelableArrayList, list, this.f195646a, z16);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage resultList null!");
                        }
                        FriendsStatusUtil.f(i3, false, parcelableArrayList, null, this.f195646a, z16);
                        return;
                    } catch (InvalidProtocolBufferMicroException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage res failed!");
                        }
                        FriendsStatusUtil.f(i3, false, parcelableArrayList, null, this.f195646a, z16);
                        e17.printStackTrace();
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage uint32_result failed!");
                }
                FriendsStatusUtil.f(i3, false, parcelableArrayList, null, this.f195646a, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage res failed!");
            }
            FriendsStatusUtil.f(i3, false, parcelableArrayList, null, this.f195646a, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 4, "handle0x5d6ResponsePackage req failed!");
        }
        FriendsStatusUtil.f(i3, false, parcelableArrayList, null, this.f195646a, z16);
    }
}
