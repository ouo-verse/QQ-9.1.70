package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderChats;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgType0x210;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$OneMemorialDayInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements n {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void d(IQQReminderRecordFacadeApi iQQReminderRecordFacadeApi, List<com.tencent.mobileqq.reminder.db.b> list, int i3) {
        if (list == null) {
            return;
        }
        for (com.tencent.mobileqq.reminder.db.b bVar : list) {
            if (iQQReminderRecordFacadeApi.checkIsForActivateFriends(bVar, new Function1() { // from class: com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Boolean e16;
                    e16 = c.e(obj);
                    return e16;
                }
            })) {
                SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = (SubMsgType0x76$MsgBody) ((com.tencent.mobileqq.reminder.db.c) bVar).getMsgBody();
                if (subMsgType0x76$MsgBody != null && subMsgType0x76$MsgBody.uint32_msg_type.get() != i3) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ActivateFriends.Processor", 2, "local data is error." + bVar);
                    }
                } else {
                    iQQReminderRecordFacadeApi.removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 0, bVar.getUniseq());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean e(Object obj) {
        return Boolean.valueOf(obj instanceof MessageForActivateFriends);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MessageForActivateFriends f(Integer num) {
        return (MessageForActivateFriends) q.d(num.intValue());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|2|3|(3:5|(1:7)(1:9)|8)|10|(1:12)(1:(1:52)(2:53|(1:55)(1:56)))|13|(3:17|(4:19|(4:21|22|23|24)(1:36)|25|26)|37)|38|39|(1:41)(1:50)|(1:43)(1:49)|44|45|46|47|(0)|37|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01b9, code lost:
    
        com.tencent.qphone.base.util.QLog.d("ActivateFriends", r7, "parse push got error.", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01ae, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01af, code lost:
    
        r7 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010a A[Catch: Exception -> 0x01ae, TryCatch #0 {Exception -> 0x01ae, blocks: (B:19:0x010a, B:21:0x0110, B:47:0x0105), top: B:46:0x0105 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(QQAppInterface qQAppInterface, byte[] bArr, long j3, long j16, int i3, int i16, int i17) {
        int i18;
        int i19;
        ActivateFriendsManager activateFriendsManager;
        com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> cVar;
        com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> cVar2;
        String str;
        String str2;
        String str3;
        com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> cVar3;
        boolean z16;
        ActivateFriendsManager activateFriendsManager2;
        int i26;
        Class cls;
        cm2.a aVar;
        int i27;
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(qQAppInterface);
        String str4 = AppConstants.ACTIVATE_FRIENDS_UIN;
        List<com.tencent.mobileqq.reminder.db.b> msgList = a16.getMsgList(str4, 0);
        SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = new SubMsgType0x76$MsgBody();
        try {
            subMsgType0x76$MsgBody.mergeFrom(bArr);
            i19 = subMsgType0x76$MsgBody.uint32_msg_type.get();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("receive push, msg type = ");
                sb5.append(i19);
                sb5.append(", local msg count = ");
                if (msgList != null) {
                    i27 = msgList.size();
                } else {
                    i27 = -1;
                }
                sb5.append(i27);
                QLog.d("ActivateFriends.Processor", 2, sb5.toString());
            }
            d(a16, msgList, i19);
            com.tencent.mobileqq.reminder.db.c cVar4 = (com.tencent.mobileqq.reminder.db.c) a16.createQQReminderRecordByType(-5003, new Function1() { // from class: com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    MessageForActivateFriends f16;
                    f16 = c.f((Integer) obj);
                    return f16;
                }
            });
            cVar4.setSelfuin(qQAppInterface.getCurrentAccountUin());
            cVar4.setFrienduin(str4);
            cVar4.setIstroop(9002);
            cVar4.setSenderuin("");
            cVar4.setTime(subMsgType0x76$MsgBody.uint32_push_time.get());
            activateFriendsManager = (ActivateFriendsManager) qQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
            if (i19 == 1) {
                cVar = i(qQAppInterface, subMsgType0x76$MsgBody, cVar4);
            } else if (i19 == 2) {
                cVar = h(qQAppInterface, subMsgType0x76$MsgBody, cVar4);
            } else if (i19 == 3) {
                cVar = j(qQAppInterface, subMsgType0x76$MsgBody, cVar4);
            } else {
                cVar = null;
            }
            cVar2 = cVar;
        } catch (Exception e16) {
            e = e16;
            i18 = 2;
        }
        if (i19 != 1 && i19 != 2) {
            z16 = true;
            activateFriendsManager2 = activateFriendsManager;
            i26 = i19;
            cls = IQQReminderChats.class;
            str3 = "";
            cVar3 = cVar2;
            aVar = a16;
            if (cVar3 != null) {
                if (QLog.isColorLevel()) {
                    i18 = 2;
                    try {
                        QLog.d("ActivateFriends", 2, "activiate_friends|rec msg  fromUin:" + j3 + " toUin:" + j16 + " seq:" + i3);
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                        }
                        return false;
                    }
                } else {
                    i18 = 2;
                }
                cVar3.saveExtInfoToExtStr("key_msg_ext_from_uin", String.valueOf(j3));
                cVar3.saveExtInfoToExtStr("key_msg_ext_to_uin", String.valueOf(j16));
                cVar3.saveExtInfoToExtStr("key_msg_ext_msg_seq", String.valueOf(i3));
                cVar3.saveExtInfoToExtStr("key_msg_ext_msg_type", String.valueOf(i16));
                cVar3.saveExtInfoToExtStr("key_msg_ext_msg_sub_type", String.valueOf(i17));
                ArrayList arrayList = new ArrayList();
                arrayList.add(cVar3);
                aVar.addMessage(arrayList, qQAppInterface.getCurrentAccountUin(), Boolean.valueOf(qQAppInterface.isBackgroundStop));
                activateFriendsManager2.B(i26);
                ((IQQReminderChats) QRoute.api(cls)).updateMessageList();
                ((IQQReminderChats) QRoute.api(cls)).reportDTMsgList("qq_imp", str3);
                return z16;
            }
            return false;
        }
        if (i19 == 1) {
            str = "0X8004E03";
        } else {
            str = "0X8004E04";
        }
        if (i19 == 1) {
            str2 = "0X8004E03";
        } else {
            str2 = "0X8004E04";
        }
        String str5 = str;
        String str6 = str2;
        str3 = "";
        cVar3 = cVar2;
        z16 = true;
        activateFriendsManager2 = activateFriendsManager;
        i26 = i19;
        cls = IQQReminderChats.class;
        aVar = a16;
        ReportController.o(qQAppInterface, "CliOper", "", "", str5, str6, activateFriendsManager.F, 0, "", "", "", "");
        if (cVar3 != null) {
        }
        return false;
    }

    @Nullable
    private static com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> h(QQAppInterface qQAppInterface, SubMsgType0x76$MsgBody subMsgType0x76$MsgBody, com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> cVar) {
        List<SubMsgType0x76$OneBirthdayFriend> list = subMsgType0x76$MsgBody.msg_birthday_notify.rpt_msg_one_friend.get();
        if (list.size() > 0) {
            cVar.setMsgBody(subMsgType0x76$MsgBody);
            cVar.setMsgData(subMsgType0x76$MsgBody.toByteArray());
            cVar.setMsg(ActivateFriendsManager.r(qQAppInterface.getApp(), subMsgType0x76$MsgBody));
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends", 2, "Birth friend list size = 0");
            }
            cVar = null;
        }
        HashSet hashSet = new HashSet();
        Iterator<SubMsgType0x76$OneBirthdayFriend> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(String.valueOf(it.next().uint64_uin.get()));
        }
        qQAppInterface.getMsgCache().K1(hashSet);
        return cVar;
    }

    @Nullable
    private static com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> i(QQAppInterface qQAppInterface, SubMsgType0x76$MsgBody subMsgType0x76$MsgBody, com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> cVar) {
        if (subMsgType0x76$MsgBody.msg_geographic_notify.rpt_msg_one_friend.get().size() > 0) {
            cVar.setMsg(ActivateFriendsManager.r(qQAppInterface.getApp(), subMsgType0x76$MsgBody));
            cVar.setMsgBody(subMsgType0x76$MsgBody);
            cVar.setMsgData(subMsgType0x76$MsgBody.toByteArray());
            return cVar;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends", 2, "Geo friend list size = 0");
        }
        return null;
    }

    @Nullable
    private static com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> j(QQAppInterface qQAppInterface, SubMsgType0x76$MsgBody subMsgType0x76$MsgBody, com.tencent.mobileqq.reminder.db.c<SubMsgType0x76$MsgBody> cVar) {
        List<SubMsgType0x76$OneMemorialDayInfo> list = subMsgType0x76$MsgBody.msg_memorialday_notify.rpt_anniversary_info.get();
        if (list.size() > 0) {
            SubMsgType0x76$OneMemorialDayInfo subMsgType0x76$OneMemorialDayInfo = list.get(0);
            cVar.setMsgBody(subMsgType0x76$MsgBody);
            cVar.setMsgData(subMsgType0x76$MsgBody.toByteArray());
            cVar.setMsg(ActivateFriendsManager.r(qQAppInterface.getApp(), subMsgType0x76$MsgBody));
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X8007AD4", "0X8007AD4", (int) subMsgType0x76$OneMemorialDayInfo.uint32_type.get(), 0, "", "", "", "");
            return cVar;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends", 2, "Memorial friend list size = 0");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.n
    public void c(msg_comm$MsgType0x210 msg_comm_msgtype0x210, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar, MessageHandler messageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg_comm_msgtype0x210, msg_comm_msg, list, aVar, messageHandler);
            return;
        }
        long j3 = msg_comm_msg.msg_head.to_uin.get();
        long j16 = msg_comm_msg.msg_head.from_uin.get();
        int i3 = msg_comm_msg.msg_head.msg_seq.get();
        long j17 = msg_comm_msg.msg_head.msg_uid.get();
        int i16 = msg_comm_msg.msg_head.msg_type.get();
        if (g(messageHandler.Q, msg_comm_msgtype0x210.msg_content.get().toByteArray(), j16, j3, i3, i16, msg_comm_msgtype0x210.sub_msg_type.get())) {
            messageHandler.a3().n("handleActivateFriendsPush2", true, 1, true, false);
        }
        p.I(j16, i3, j17, i16, messageHandler.getApp());
    }
}
