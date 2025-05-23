package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import Wallet.AcsMsg;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderHelperApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.nt_msg_common$Msg;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x118.submsgtype0x118$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f implements a<com.tencent.imcore.message.af>, com.tencent.mobileqq.reminder.push.a {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void d(AppRuntime appRuntime, int i3, byte[] bArr) {
        IQQReminderDataService iQQReminderDataService = (IQQReminderDataService) appRuntime.getRuntimeService(IQQReminderDataService.class, "");
        if (!((ActivateFriendsManager) appRuntime.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).A(i3)) {
            submsgtype0x118$MsgBody submsgtype0x118_msgbody = new submsgtype0x118$MsgBody();
            try {
                submsgtype0x118_msgbody.mergeFrom(bArr);
                int i16 = submsgtype0x118_msgbody.uint32_push_type.get();
                if (i16 == 0) {
                    JSONObject jSONObject = new JSONObject(submsgtype0x118_msgbody.bytes_push_data.get().toStringUtf8());
                    String optString = jSONObject.optString("title");
                    if (QLog.isColorLevel()) {
                        QLog.d("SubType0x118", 2, "-----qq reminder-----title: " + optString + "---msgId: " + jSONObject.optString("msg_id") + "---notice_time: " + jSONObject.optLong("notice_time"));
                    }
                    AcsMsg acsMsg = new AcsMsg();
                    acsMsg.msg_id = jSONObject.optString("msg_id");
                    acsMsg.type = i16;
                    acsMsg.notice_time = jSONObject.optLong("notice_time");
                    acsMsg.title = optString;
                    acsMsg.content = jSONObject.optString("msg");
                    acsMsg.btn_text = jSONObject.getString("btn_text");
                    acsMsg.notice_time = jSONObject.getLong("notice_time");
                    int i17 = jSONObject.getInt("jump_type");
                    if (i17 != 0 && i17 != 1) {
                        if (i17 == 4) {
                            acsMsg.applet_jump_url = jSONObject.getString("jump_url");
                        } else {
                            QLog.e("SubType0x118", 1, "[notify][push] unknown jump type: " + i17);
                        }
                    } else {
                        acsMsg.jump_url = jSONObject.getString("jump_url");
                    }
                    acsMsg.banner_url = jSONObject.optString("banner_url");
                    acsMsg.banner_type = jSONObject.optInt("banner_type");
                    acsMsg.busi_id = jSONObject.optString("busi_id", "");
                    acsMsg.extend_field = jSONObject.optString("extend_field", "");
                    com.tencent.mobileqq.activity.activateFriend.y.c(appRuntime, "remindmessage_push", acsMsg.busi_id, acsMsg.msg_id, null, acsMsg.mn_reserved, com.tencent.mobileqq.activity.activateFriend.ai.a(acsMsg));
                    iQQReminderDataService.doNotifyByPush(acsMsg);
                    if (QLog.isColorLevel()) {
                        QLog.d("SubType0x118", 2, "do report: QQnotice.list.push");
                    }
                    ReportController.o(appRuntime, "P_CliOper", "QQnotice", "", "", "QQnotice.list.push", 0, 0, "", "", jSONObject.optString("msg_id"), "");
                    return;
                }
                QLog.e("SubType0x118", 1, "[notify][push] unknown push type: " + i16);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQReminder", 2, "parse push got error.", e16);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SubType0x118", 2, "receive same message, seq = " + i3);
        }
    }

    private static void e(AppRuntime appRuntime, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        d(appRuntime, msgInfo.shMsgSeq, msgType0x210.vProtobuf);
    }

    @Override // com.tencent.mobileqq.reminder.push.a
    public void a(int i3, long j3, long j16, boolean z16, @NonNull nt_msg_common$Msg nt_msg_common_msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), nt_msg_common_msg);
            return;
        }
        if (!((IQQReminderHelperApi) QRoute.api(IQQReminderHelperApi.class)).is0x118NtPushChannel()) {
            QLog.d("SubType0x118", 1, "Use old push channel, not decode!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("SubType0x118", 1, "processMsgBuf runtime null!");
            return;
        }
        long j17 = nt_msg_common_msg.content_head.msg_seq.get();
        byte[] byteArray = nt_msg_common_msg.body.msg_content.get().toByteArray();
        QLog.d("SubType0x118", 1, "Use NT push channel, decode NT data!");
        d(peekAppRuntime, (int) j17, byteArray);
    }

    @Override // com.tencent.mobileqq.reminder.push.a
    @NonNull
    public List<Long> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(280L);
        return arrayList;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        if (((IQQReminderHelperApi) QRoute.api(IQQReminderHelperApi.class)).is0x118NtPushChannel()) {
            QLog.d("SubType0x118", 1, "Use NT push channel, not decode!");
            return null;
        }
        e((QQAppInterface) afVar.d(), msgInfo, msgType0x210);
        return null;
    }
}
