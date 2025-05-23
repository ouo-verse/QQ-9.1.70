package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import Wallet.AcsMsg;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.activateFriend.ai;
import com.tencent.mobileqq.activity.activateFriend.y;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderChats;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderHelperApi;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import msf.msgcomm.nt_msg_common$Msg;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a$MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j implements n, com.tencent.mobileqq.reminder.push.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f286189a;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f286189a = "{\n        \"msg_id\":\"55ecbfd4d4ba6a744605361199cc7be7\",\n        \"ark_data\":{\n        \"app\":\"com.tencent.qqremind_anniversary\",\n        \"meta\":{\n        \"metaData\":{\n        \"friend_type\":\"1\",\n        \"friend_uin\":\"1\",\n        \"since_time\":0,\n        \"jump_url\":\"www.qq.com?token=xczczc\"\n        }\n        },\n        \"view\":\"1\"\n        }\n        }";
        }
    }

    private void f(QQAppInterface qQAppInterface, long j3, int i3, long j16, long j17, byte[] bArr) {
        IQQReminderDataService iQQReminderDataService = (IQQReminderDataService) qQAppInterface.getRuntimeService(IQQReminderDataService.class, "");
        boolean A = ((ActivateFriendsManager) qQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).A(i3);
        if (QLog.isColorLevel()) {
            QLog.d("ReminderDecoder", 1, "isPushMessageDuplicated: ", Boolean.valueOf(A));
        }
        if (!A) {
            submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = new submsgtype0x13a$MsgBody();
            try {
                submsgtype0x13a_msgbody.mergeFrom(bArr);
                int i16 = submsgtype0x13a_msgbody.uint32_push_type.get();
                if (i16 == 1) {
                    k(qQAppInterface, j17, iQQReminderDataService, submsgtype0x13a_msgbody, i16);
                } else if (i16 == 2) {
                    l(qQAppInterface, j3, i3, j16, i16, submsgtype0x13a_msgbody);
                } else {
                    QLog.e("ReminderDecoder", 1, "[notify][push] unknown push type: " + i16);
                }
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
            QLog.d("ReminderDecoder", 1, "receive same message, seq = ", Integer.valueOf(i3));
        }
    }

    private void g(QQAppInterface qQAppInterface, msg_comm$Msg msg_comm_msg, short s16, long j3, msg_comm$MsgType0x210 msg_comm_msgtype0x210) {
        f(qQAppInterface, msg_comm_msg.msg_head.from_uin.get(), s16, msg_comm_msg.msg_head.to_uin.get(), j3, msg_comm_msgtype0x210.msg_content.get().toByteArray());
    }

    private void h(QQAppInterface qQAppInterface) {
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(qQAppInterface);
        for (com.tencent.mobileqq.reminder.db.b bVar : a16.getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 0)) {
            if (a16.checkIsForReminder(bVar, new Function1() { // from class: com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Boolean i3;
                    i3 = j.i(obj);
                    return i3;
                }
            })) {
                qQAppInterface.getMessageFacade().T1(AppConstants.ACTIVATE_FRIENDS_UIN, 0, bVar.getUniseq());
            } else if (QLog.isColorLevel()) {
                QLog.e("ReminderDecoder", 2, "local data is error." + bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean i(Object obj) {
        return Boolean.valueOf(obj instanceof MessageForReminder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MessageForReminder j(Integer num) {
        return (MessageForReminder) q.d(num.intValue());
    }

    private void k(AppRuntime appRuntime, long j3, IQQReminderDataService iQQReminderDataService, submsgtype0x13a$MsgBody submsgtype0x13a_msgbody, int i3) throws JSONException {
        JSONObject jSONObject = new JSONObject(submsgtype0x13a_msgbody.bytes_push_data.get().toStringUtf8());
        if (QLog.isColorLevel()) {
            QLog.d("ReminderDecoder", 2, "[notify][push] multiple tskTriPushData: " + jSONObject);
        }
        AcsMsg acsMsg = new AcsMsg();
        acsMsg.msg_id = jSONObject.optString("msg_id");
        acsMsg.type = i3;
        acsMsg.title = jSONObject.getString("title");
        acsMsg.content = jSONObject.getString("msg");
        acsMsg.btn_text = jSONObject.getString("btn_text");
        acsMsg.notice_time = j3;
        acsMsg.sub_time = j3;
        int i16 = jSONObject.getInt("jump_type");
        if (i16 == 0) {
            acsMsg.jump_url = jSONObject.getString("jump_url");
        } else if (i16 == 4) {
            acsMsg.applet_jump_url = jSONObject.getString("jump_url");
        } else {
            QLog.e("ReminderDecoder", 1, "[notify][push] unknown jump type: " + i16);
        }
        acsMsg.banner_type = jSONObject.getInt("banner_type");
        acsMsg.banner_url = jSONObject.getString("banner_url");
        acsMsg.banner_type = jSONObject.getInt("banner_type");
        acsMsg.mn_appid = jSONObject.optInt("mn_appid", 0);
        acsMsg.mn_reserved = jSONObject.optString("mn_reserve", "");
        acsMsg.busi_id = jSONObject.optString("busi_id", "");
        acsMsg.extend_field = jSONObject.optString("extend_field", "");
        y.c(appRuntime, "remindmessage_push", acsMsg.busi_id, acsMsg.msg_id, null, acsMsg.mn_reserved, ai.a(acsMsg));
        iQQReminderDataService.doNotifyByPush(acsMsg);
    }

    private void l(QQAppInterface qQAppInterface, long j3, int i3, long j16, int i16, submsgtype0x13a$MsgBody submsgtype0x13a_msgbody) {
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(qQAppInterface);
        com.tencent.mobileqq.reminder.db.c cVar = (com.tencent.mobileqq.reminder.db.c) a16.createQQReminderRecordByType(-7090, new Function1() { // from class: com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MessageForReminder j17;
                j17 = j.j((Integer) obj);
                return j17;
            }
        });
        cVar.setSelfuin(qQAppInterface.getCurrentAccountUin());
        cVar.setFrienduin(AppConstants.ACTIVATE_FRIENDS_UIN);
        cVar.setIstroop(9002);
        cVar.setSelfuin("");
        cVar.setTime(submsgtype0x13a_msgbody.uint32_timestamp.get());
        cVar.setMsgBody(submsgtype0x13a_msgbody);
        cVar.setMsgData(submsgtype0x13a_msgbody.toByteArray());
        cVar.setMsg(submsgtype0x13a_msgbody.msg_system_notify.bytes_msg_summary.get().toStringUtf8());
        h(qQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends", 2, "activiate_friends|rec msg  fromUin:" + j3 + " toUin:" + j16 + " seq:" + i3);
        }
        cVar.saveExtInfoToExtStr("key_msg_ext_from_uin", String.valueOf(j3));
        cVar.saveExtInfoToExtStr("key_msg_ext_to_uin", String.valueOf(j16));
        cVar.saveExtInfoToExtStr("key_msg_ext_msg_seq", String.valueOf(i3));
        cVar.saveExtInfoToExtStr("key_msg_ext_msg_type", String.valueOf(i16));
        cVar.saveExtInfoToExtStr("key_msg_need_notify", String.valueOf(true));
        cVar.saveExtInfoToExtStr("key_msg_notify_summary", cVar.getMsg());
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        a16.addMessage(arrayList, qQAppInterface.getCurrentAccountUin(), Boolean.valueOf(qQAppInterface.isBackgroundStop));
        a16.handleReceivedMessage(1, true, true);
        ((IQQReminderChats) QRoute.api(IQQReminderChats.class)).updateMessageList();
        ((IQQReminderChats) QRoute.api(IQQReminderChats.class)).reportDTMsgList("qq_imp", "");
    }

    @Override // com.tencent.mobileqq.reminder.push.a
    public void a(int i3, long j3, long j16, boolean z16, @NonNull nt_msg_common$Msg nt_msg_common_msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16), nt_msg_common_msg);
            return;
        }
        if (!((IQQReminderHelperApi) QRoute.api(IQQReminderHelperApi.class)).is0x13aNtPushChannel()) {
            QLog.d("ReminderDecoder", 1, "Use old push channel, not decode!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            long j17 = nt_msg_common_msg.content_head.msg_seq.get();
            long j18 = nt_msg_common_msg.routing_head.from_uin.get();
            long j19 = nt_msg_common_msg.routing_head.to_uin.get();
            long j26 = nt_msg_common_msg.content_head.msg_time.get();
            byte[] byteArray = nt_msg_common_msg.body.msg_content.get().toByteArray();
            QLog.d("ReminderDecoder", 1, "Use NT push channel, decode NT data!");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            f(qQAppInterface, j18, (int) j17, j19, j26, byteArray);
            p.I(nt_msg_common_msg.routing_head.from_uin.get(), (int) nt_msg_common_msg.content_head.msg_seq.get(), nt_msg_common_msg.content_head.msg_uid.get(), (int) nt_msg_common_msg.content_head.msg_type.get(), qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.reminder.push.a
    @NonNull
    public List<Long> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(314L);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n
    public void c(msg_comm$MsgType0x210 msg_comm_msgtype0x210, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar, MessageHandler messageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg_comm_msgtype0x210, msg_comm_msg, list, aVar, messageHandler);
        } else if (((IQQReminderHelperApi) QRoute.api(IQQReminderHelperApi.class)).is0x13aNtPushChannel()) {
            QLog.d("ReminderDecoder", 1, "Use NT push channel, not decode!");
        } else {
            g(messageHandler.Q, msg_comm_msg, (short) msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_time.get(), msg_comm_msgtype0x210);
            p.I(msg_comm_msg.msg_head.from_uin.get(), msg_comm_msg.msg_head.msg_seq.get(), msg_comm_msg.msg_head.msg_uid.get(), msg_comm_msg.msg_head.msg_type.get(), messageHandler.getApp());
        }
    }
}
