package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype21;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfessMsgUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f202124a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f202125b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.confess.ConfessMsgUtil$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f202132d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f202133e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f202134f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f202135h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f202136i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f202137m;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f202132d.getMessageFacade().P0(this.f202133e, this.f202134f, this.f202135h, this.f202136i, this.f202137m);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71325);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f202124a = false;
            f202125b = HardCodeUtil.qqStr(R.string.kz7);
        }
    }

    public static void a(QQAppInterface qQAppInterface, String str, String str2, int i3, int i16, ConfessInfo confessInfo) {
        long abs;
        boolean z16;
        boolean z17 = false;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i16);
            objArr[3] = aw.a(str2);
            if (confessInfo == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[4] = Boolean.valueOf(z16);
            QLog.i("ConfessMsgUtil", 2, String.format("addGrayTipsMessage frdUin:%s uinType:%d topicId:%d msg:%s confessInfo==null:%b", objArr));
        }
        if (confessInfo == null) {
            return;
        }
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, str, str2, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 655376, com.tencent.mobileqq.service.message.e.K0());
        gVar.f213683f = str2;
        List<ChatMessage> l16 = qQAppInterface.getMessageFacade().l1(str, i3);
        if (l16 != null && !l16.isEmpty()) {
            abs = l16.get(l16.size() - 1).shmsgseq;
        } else {
            abs = Math.abs(new Random().nextInt());
        }
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        messageForUniteGrayTip.isread = true;
        messageForUniteGrayTip.shmsgseq = abs;
        messageForUniteGrayTip.mNeedTimeStamp = true;
        messageForUniteGrayTip.updateUniteGrayTipMsgData(qQAppInterface);
        messageForUniteGrayTip.setConfessTopicId(i16);
        if (i3 == 1033) {
            z17 = true;
        }
        messageForUniteGrayTip.setSelfIsConfessor(z17);
        messageForUniteGrayTip.saveExtInfoToExtStr("ext_key_confess_info", confessInfo.toJsonStr());
        qQAppInterface.getMessageFacade().c(messageForUniteGrayTip, qQAppInterface.getCurrentAccountUin());
    }

    public static void b(QQAppInterface qQAppInterface, String str, int i3, int i16, ConfessInfo confessInfo) {
        int i17;
        long abs;
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i16);
            if (confessInfo == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            objArr[3] = Boolean.valueOf(z17);
            QLog.i("ConfessMsgUtil", 2, String.format("addShieldSucTipsMessage frdUin:%s uinType:%d topicId:%d confessInfo==null:%b", objArr));
        }
        if (confessInfo == null) {
            return;
        }
        ConfessConfig g16 = ((ConfessManager) qQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).g();
        if (g16 == null) {
            i17 = 24;
        } else {
            i17 = g16.f202077u;
        }
        String format = String.format(ConfessConfig.N, Integer.valueOf(i17));
        String qqStr = HardCodeUtil.qqStr(R.string.kz5);
        int indexOf = format.indexOf(qqStr);
        int length = indexOf + qqStr.length();
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, str, format, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 655369, com.tencent.mobileqq.service.message.e.K0());
        gVar.f213683f = format;
        Bundle bundle = new Bundle();
        bundle.putInt("key_action", 31);
        gVar.b(indexOf, length, bundle);
        List<ChatMessage> l16 = qQAppInterface.getMessageFacade().l1(str, i3);
        if (l16 != null && !l16.isEmpty()) {
            abs = l16.get(l16.size() - 1).shmsgseq;
        } else {
            abs = Math.abs(new Random().nextInt());
        }
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        messageForUniteGrayTip.isread = true;
        messageForUniteGrayTip.shmsgseq = abs;
        messageForUniteGrayTip.mNeedTimeStamp = true;
        messageForUniteGrayTip.updateUniteGrayTipMsgData(qQAppInterface);
        messageForUniteGrayTip.setConfessTopicId(i16);
        if (i3 == 1033) {
            z16 = true;
        } else {
            z16 = false;
        }
        messageForUniteGrayTip.setSelfIsConfessor(z16);
        messageForUniteGrayTip.saveExtInfoToExtStr("ext_key_confess_info", confessInfo.toJsonStr());
        qQAppInterface.getMessageFacade().c(messageForUniteGrayTip, qQAppInterface.getCurrentAccountUin());
    }

    public static void c(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str) {
        ConfessManager confessManager;
        if (qQAppInterface != null && messageRecord != null && !TextUtils.isEmpty(str) && (confessManager = (ConfessManager) qQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)) != null && confessManager.o(str)) {
            ConfessManager.a i3 = confessManager.i();
            if (i3 != null) {
                messageRecord.saveExtInfoToExtStr("ext_key_frd_chat_confess_info", i3.a());
                confessManager.p(i3.f202104h, i3.f202105i, i3.f202097a);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ConfessMsgUtil", 2, String.format("bindC2CFirstMsgConfessInfo ExtStr: %s", messageRecord.extStr));
            }
        }
    }

    public static void d(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str, int i3, int i16) {
        String str2;
        int i17;
        boolean z16;
        if (i16 > 0 && ao.c(i3) == 1032) {
            ConfessInfo a16 = ((ConfessManager) qQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).f().a(str, i3, i16);
            if (a16 != null) {
                messageRecord.saveExtInfoToExtStr("ext_key_confess_info", a16.toJsonStr());
                if (i3 == 1033) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                messageRecord.setSelfIsConfessor(z16);
                messageRecord.setConfessTopicId(i16);
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = Integer.valueOf(i16);
                if (a16 == null) {
                    str2 = "null";
                } else {
                    str2 = a16.confessorNick;
                }
                objArr[3] = str2;
                if (a16 == null) {
                    i17 = -1;
                } else {
                    i17 = a16.confessorSex;
                }
                objArr[4] = Integer.valueOf(i17);
                QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo friendUin:%s uinType:%d topicId:%d confessorNick:%s confessorSex:%d", objArr));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo return. frdUin:%s uinType:%d topicId:%d", str, Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    public static void e(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str) {
        ConfessManager confessManager;
        if (qQAppInterface != null && messageRecord != null && !TextUtils.isEmpty(str) && (confessManager = (ConfessManager) qQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)) != null && confessManager.n(str)) {
            ConfessManager.b j3 = confessManager.j();
            if (j3 != null) {
                messageRecord.saveExtInfoToExtStr("ext_key_group_chat_confess_info", j3.a());
                confessManager.q(str, j3.f202117h, j3.f202111b, j3.f202118i, j3.f202112c);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ConfessMsgUtil", 2, String.format("bindGroupFirstMsgConfessInfo ExtStr: %s", messageRecord.extStr));
            }
        }
    }

    public static boolean f(MessageRecord messageRecord) {
        if (messageRecord.getConfessTopicId() > 0 && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("ext_key_confess_info"))) {
            return true;
        }
        return false;
    }

    public static void g(AppInterface appInterface, List<MessageRecord> list) {
        if (QLog.isColorLevel()) {
            QLog.i("ConfessMsgUtil", 2, "checkInsertConfessCardMsg " + list.size());
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        for (MessageRecord messageRecord : list) {
            if (!messageRecord.isSend() && ao.c(messageRecord.istroop) == 1032 && s(messageRecord)) {
                ConfessInfo confessInfo = new ConfessInfo();
                confessInfo.parseFromJsonStr(messageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
                if (messageRecord.istroop == 1033 && !hashSet.contains(Integer.valueOf(messageRecord.getConfessTopicId()))) {
                    hashSet.add(Integer.valueOf(messageRecord.getConfessTopicId()));
                    List<MessageRecord> q16 = ((QQAppInterface) appInterface).getMessageProxy(messageRecord.istroop).q(messageRecord.frienduin, messageRecord.istroop, messageRecord.getConfessTopicId());
                    if (q16 != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= q16.size()) {
                                break;
                            }
                            if (q16.get(i3).getConfessTopicId() == messageRecord.getConfessTopicId()) {
                                z16 = true;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z16) {
                        String str = confessInfo.topic;
                        if (!TextUtils.isEmpty(str)) {
                            MessageForText B = q.B(appInterface, appInterface.getCurrentUin(), messageRecord.senderuin, null, messageRecord.istroop, (byte) 0, (byte) 0, (short) 0, str);
                            B.setConfessTopicId(messageRecord.getConfessTopicId());
                            B.setSelfIsConfessor(messageRecord.isSelfConfessor());
                            B.saveExtInfoToExtStr("ext_key_confess_info", messageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
                            B.time = messageRecord.time - 1;
                            arrayList.add(0, B);
                            if (QLog.isColorLevel()) {
                                QLog.i("ConfessMsgUtil", 2, String.format("checkInsertConfessCardMsg B:%s topic:%s", messageRecord.frienduin, str));
                            }
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            list.addAll(0, arrayList);
        }
    }

    public static void h(QQAppInterface qQAppInterface, boolean z16) {
        ConfessConfig.l(qQAppInterface, "redpoint_box_show", 0L);
        ConfessConfig.l(qQAppInterface, "redpoint_clear_time", com.tencent.mobileqq.service.message.e.K0());
    }

    public static void i(QQAppInterface qQAppInterface, boolean z16) {
        int i3;
        boolean z17;
        if (qQAppInterface == null) {
            return;
        }
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) qQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j3 = localRedTouchManager.j(10018);
        if (z16 && j3 != null) {
            j3.extMsgs = null;
        }
        localRedTouchManager.u(10018);
        d l3 = ((ConfessManager) qQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).l();
        if (l3 != null && (i3 = l3.f202178d) > 0) {
            if (i3 != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            l3.f202178d = 0;
            if (z16) {
                z17 |= l3.b();
                l3.f202181g = "";
                l3.f202183i = "";
                l3.f202182h = "";
                l3.f202180f = 0;
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.confess.ConfessMsgUtil.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        d.this.d();
                    }
                }
            }, 8, null, false);
            if (z17) {
                ((ConfessHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).G2(l3);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread toDelItem: %s, needUpdate: %s", Boolean.valueOf(z16), Boolean.valueOf(z17)));
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread no need to deal ! [toDelItem: %s]", Boolean.valueOf(z16)));
        }
    }

    public static void j(QQAppInterface qQAppInterface, RecentItemConfessMsg recentItemConfessMsg, boolean z16) {
        if (qQAppInterface != null && recentItemConfessMsg != null) {
            if (recentItemConfessMsg.mType == 1032 && TextUtils.equals(recentItemConfessMsg.mUin, AppConstants.CONFESS_FRD_REC_UIN)) {
                i(qQAppInterface, z16);
            } else {
                int S = qQAppInterface.getConversationFacade().S(recentItemConfessMsg.getRecentUserUin(), recentItemConfessMsg.getRecentUserType(), recentItemConfessMsg.mConfessInfo.topicId);
                if (z16) {
                    qQAppInterface.getMessageFacade().Y1(AppConstants.CONFESS_UIN, 1032, recentItemConfessMsg.getRecentUserUin(), qQAppInterface.getCurrentAccountUin(), recentItemConfessMsg.mType, recentItemConfessMsg.mConfessInfo.topicId);
                }
                if (S > 0) {
                    qQAppInterface.getMessageFacade().P0(recentItemConfessMsg.getRecentUserUin(), recentItemConfessMsg.getRecentUserType(), recentItemConfessMsg.mConfessInfo.topicId, true, false);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "clearConfessUnread");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [tencent.im.msg.im_msg_body$Elem] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v87 */
    /* JADX WARN: Type inference failed for: r3v93 */
    /* JADX WARN: Type inference failed for: r3v94 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(msg_comm$Msg msg_comm_msg, im_msg_body$Elem im_msg_body_elem, List<MessageRecord> list, AppInterface appInterface) {
        InvalidProtocolBufferMicroException invalidProtocolBufferMicroException;
        ?? r36;
        boolean z16;
        boolean z17;
        String str;
        String str2;
        int i3;
        String str3;
        String str4;
        long j3;
        int i16;
        String qqStr;
        int i17;
        long j16;
        int i18;
        int i19;
        int i26;
        int i27;
        long j17;
        ?? r26 = im_msg_body_elem;
        List<MessageRecord> list2 = list;
        if (r26 != 0 && list2 != null && appInterface != null && list.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem app:" + appInterface);
            }
            try {
                try {
                    try {
                        String str5 = "";
                        try {
                            try {
                                if (21 == r26.common_elem.uint32_service_type.get() && r26.common_elem.bytes_pb_elem.has() && r26.common_elem.uint32_business_type.get() == 1) {
                                    hummer_commelem$MsgElemInfo_servtype21 hummer_commelem_msgeleminfo_servtype21 = new hummer_commelem$MsgElemInfo_servtype21();
                                    hummer_commelem_msgeleminfo_servtype21.mergeFrom(r26.common_elem.bytes_pb_elem.get().toByteArray());
                                    if (hummer_commelem_msgeleminfo_servtype21.uint32_topic_id.has() && hummer_commelem_msgeleminfo_servtype21.uint64_confessor_uin.has() && hummer_commelem_msgeleminfo_servtype21.bytes_confessor_nick.has() && hummer_commelem_msgeleminfo_servtype21.uint32_confessor_sex.has()) {
                                        String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
                                        String str6 = list2.get(0).frienduin;
                                        int i28 = hummer_commelem_msgeleminfo_servtype21.uint32_topic_id.get();
                                        long j18 = hummer_commelem_msgeleminfo_servtype21.uint64_confessor_uin.get();
                                        String stringUtf8 = hummer_commelem_msgeleminfo_servtype21.bytes_confessor_nick.get().toStringUtf8();
                                        int i29 = hummer_commelem_msgeleminfo_servtype21.uint32_confessor_sex.get();
                                        if (hummer_commelem_msgeleminfo_servtype21.uint32_sysmsg_flag.has()) {
                                            i27 = hummer_commelem_msgeleminfo_servtype21.uint32_sysmsg_flag.get();
                                        } else {
                                            i27 = 0;
                                        }
                                        if (hummer_commelem_msgeleminfo_servtype21.bytes_topic.has()) {
                                            str5 = hummer_commelem_msgeleminfo_servtype21.bytes_topic.get().toStringUtf8();
                                        }
                                        boolean equals = Long.toString(j18).equals(account);
                                        if (hummer_commelem_msgeleminfo_servtype21.uint64_confess_time.has()) {
                                            j17 = hummer_commelem_msgeleminfo_servtype21.uint64_confess_time.get();
                                        } else {
                                            j17 = 0;
                                        }
                                        if (i27 == 1 && !equals && (list2.get(0) instanceof MessageForText)) {
                                            str5 = ((MessageForText) list2.get(0)).f203106msg;
                                        }
                                        if (i28 > 0 && j18 > 0 && !TextUtils.isEmpty(stringUtf8) && !TextUtils.isEmpty(str5)) {
                                            for (MessageRecord messageRecord : list) {
                                                int i36 = i27;
                                                messageRecord.saveExtInfoToExtStr("ext_key_confess_info", ConfessInfo.toJsonStr(i28, j18, i29, stringUtf8, i36, str5, j17));
                                                messageRecord.setConfessTopicId(i28);
                                                messageRecord.setSelfIsConfessor(equals);
                                                i27 = i36;
                                            }
                                            if (QLog.isColorLevel()) {
                                                Object[] objArr = new Object[4];
                                                objArr[0] = Long.toString(j18);
                                                objArr[1] = Integer.valueOf(i28);
                                                try {
                                                    objArr[2] = str6;
                                                    objArr[3] = str5;
                                                    QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confessorUin:%s topicId:%d frdUin:%s topic:%s", objArr));
                                                    return;
                                                } catch (InvalidProtocolBufferMicroException e16) {
                                                    invalidProtocolBufferMicroException = e16;
                                                    r36 = 2;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        if (QLog.isColorLevel()) {
                                            Object[] objArr2 = new Object[3];
                                            objArr2[0] = Long.toString(j18);
                                            objArr2[1] = Integer.valueOf(i28);
                                            if (stringUtf8 == null) {
                                                stringUtf8 = "null";
                                            }
                                            objArr2[2] = stringUtf8;
                                            QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem data err confessorUin:%s topicId:%d nick:%s", objArr2));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                try {
                                    if (21 == r26.common_elem.uint32_service_type.get() && r26.common_elem.bytes_pb_elem.has() && r26.common_elem.uint32_business_type.get() == 2) {
                                        hummer_commelem$MsgElemInfo_servtype21 hummer_commelem_msgeleminfo_servtype212 = new hummer_commelem$MsgElemInfo_servtype21();
                                        hummer_commelem_msgeleminfo_servtype212.mergeFrom(r26.common_elem.bytes_pb_elem.get().toByteArray());
                                        if (hummer_commelem_msgeleminfo_servtype212.c2c_confess_ctx.has()) {
                                            if (QLog.isColorLevel() && hummer_commelem_msgeleminfo_servtype212.c2c_confess_ctx.get().bytes_confess.has()) {
                                                try {
                                                    QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", hummer_commelem_msgeleminfo_servtype212.c2c_confess_ctx.get().bytes_confess.get().toStringUtf8()));
                                                } catch (InvalidProtocolBufferMicroException e17) {
                                                    invalidProtocolBufferMicroException = e17;
                                                    r36 = 2;
                                                }
                                            }
                                            String currentAccountUin = appInterface.getCurrentAccountUin();
                                            String valueOf = String.valueOf(msg_comm_msg.msg_head.get().from_uin.get());
                                            String valueOf2 = String.valueOf(msg_comm_msg.msg_head.get().to_uin.get());
                                            if (TextUtils.equals(currentAccountUin, valueOf)) {
                                                str5 = valueOf2;
                                            } else if (TextUtils.equals(currentAccountUin, valueOf2)) {
                                                str5 = valueOf;
                                            }
                                            hummer_commelem$MsgElemInfo_servtype21.C2CConfessContext c2CConfessContext = hummer_commelem_msgeleminfo_servtype212.c2c_confess_ctx.get();
                                            String valueOf3 = String.valueOf(c2CConfessContext.uint64_confess_to_uin.get());
                                            String valueOf4 = String.valueOf(c2CConfessContext.uint64_confessor_uin.get());
                                            int i37 = c2CConfessContext.uint32_topic_id.get();
                                            String valueOf5 = String.valueOf(c2CConfessContext.uint64_send_uin.get());
                                            if (!TextUtils.isEmpty(str5) && TextUtils.equals(valueOf, valueOf5) && TextUtils.equals(valueOf2, valueOf3)) {
                                                ConfessManager confessManager = (ConfessManager) appInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
                                                if (confessManager.d(str5, valueOf3, valueOf4, i37) == 1) {
                                                    ConfessManager.a aVar = new ConfessManager.a();
                                                    aVar.f202097a = i37;
                                                    aVar.f202098b = c2CConfessContext.uint32_bg_type.get();
                                                    aVar.f202104h = valueOf3;
                                                    aVar.f202105i = valueOf4;
                                                    aVar.f202106j = c2CConfessContext.bytes_confess.get().toStringUtf8();
                                                    aVar.f202107k = c2CConfessContext.bytes_confessor_nick.get().toStringUtf8();
                                                    aVar.f202103g = appInterface.getCurrentNickname();
                                                    if (c2CConfessContext.uint32_confessor_sex.has()) {
                                                        i17 = c2CConfessContext.uint32_confessor_sex.get();
                                                    } else {
                                                        i17 = 0;
                                                    }
                                                    aVar.f202099c = i17;
                                                    if (c2CConfessContext.uint64_confess_time.has()) {
                                                        j16 = c2CConfessContext.uint64_confess_time.get();
                                                    } else {
                                                        j16 = 0;
                                                    }
                                                    aVar.f202108l = j16;
                                                    if (c2CConfessContext.uint32_confess_num.has()) {
                                                        i18 = c2CConfessContext.uint32_confess_num.get();
                                                    } else {
                                                        i18 = 0;
                                                    }
                                                    aVar.f202100d = i18;
                                                    if (c2CConfessContext.uint32_biz_type.has()) {
                                                        i19 = c2CConfessContext.uint32_biz_type.get();
                                                    } else {
                                                        i19 = 0;
                                                    }
                                                    aVar.f202102f = i19;
                                                    if (c2CConfessContext.uint32_confess_to_sex.has()) {
                                                        i26 = c2CConfessContext.uint32_confess_to_sex.get();
                                                    } else {
                                                        i26 = 0;
                                                    }
                                                    aVar.f202101e = i26;
                                                    long j19 = msg_comm_msg.msg_head.get().msg_time.get() - 1;
                                                    long j26 = msg_comm_msg.msg_head.get().msg_seq.get() - 1;
                                                    confessManager.a(str5, aVar, j19, j26);
                                                    if (QLog.isColorLevel()) {
                                                        r26 = 2;
                                                        QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem strConfessorDesc:" + aVar.f202106j + " msgTime:" + j19 + " msgSeq:" + j26 + " nowTime" + com.tencent.mobileqq.service.message.e.K0());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (21 == r26.common_elem.uint32_service_type.get() && r26.common_elem.bytes_pb_elem.has() && r26.common_elem.uint32_business_type.get() == 4) {
                                        hummer_commelem$MsgElemInfo_servtype21 hummer_commelem_msgeleminfo_servtype213 = new hummer_commelem$MsgElemInfo_servtype21();
                                        hummer_commelem_msgeleminfo_servtype213.mergeFrom(r26.common_elem.bytes_pb_elem.get().toByteArray());
                                        if (hummer_commelem_msgeleminfo_servtype213.group_confess_ctx.has()) {
                                            if (QLog.isColorLevel() && hummer_commelem_msgeleminfo_servtype213.group_confess_ctx.get().bytes_topic.has()) {
                                                z16 = false;
                                                try {
                                                    QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", hummer_commelem_msgeleminfo_servtype213.group_confess_ctx.get().bytes_topic.get().toStringUtf8()));
                                                } catch (InvalidProtocolBufferMicroException e18) {
                                                    invalidProtocolBufferMicroException = e18;
                                                    r36 = 2;
                                                }
                                            } else {
                                                z16 = false;
                                            }
                                            if (msg_comm_msg.msg_head.has() && msg_comm_msg.msg_head.get().group_info.has() && msg_comm_msg.msg_head.get().group_info.get().group_code.has()) {
                                                str = String.valueOf(msg_comm_msg.msg_head.get().group_info.get().group_code.get());
                                                if (msg_comm_msg.msg_head.group_info.group_type.get() == 127) {
                                                    z17 = true;
                                                } else {
                                                    z17 = z16;
                                                }
                                            } else {
                                                z17 = z16;
                                                str = "";
                                            }
                                            if (!TextUtils.isEmpty(str)) {
                                                hummer_commelem$MsgElemInfo_servtype21.GroupConfessContext groupConfessContext = hummer_commelem_msgeleminfo_servtype213.group_confess_ctx.get();
                                                String valueOf6 = String.valueOf(groupConfessContext.uint64_send_uin.get());
                                                if (!TextUtils.equals(valueOf6, String.valueOf(msg_comm_msg.msg_head.get().from_uin.get()))) {
                                                    return;
                                                }
                                                String valueOf7 = String.valueOf(groupConfessContext.uint64_confess_to_uin.get());
                                                String valueOf8 = String.valueOf(groupConfessContext.uint64_confessor_uin.get());
                                                int i38 = groupConfessContext.uint32_topic_id.get();
                                                ConfessManager confessManager2 = (ConfessManager) appInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
                                                int c16 = confessManager2.c(str, valueOf7, valueOf6, valueOf8, i38);
                                                if (!z17 && c16 == 1) {
                                                    ConfessManager.b bVar = new ConfessManager.b();
                                                    bVar.f202110a = str;
                                                    bVar.f202112c = i38;
                                                    bVar.f202113d = i38 % 4;
                                                    bVar.f202117h = valueOf7;
                                                    bVar.f202118i = valueOf8;
                                                    if (!groupConfessContext.bytes_topic.has()) {
                                                        str2 = "";
                                                    } else {
                                                        str2 = groupConfessContext.bytes_topic.get().toStringUtf8();
                                                    }
                                                    bVar.f202119j = str2;
                                                    if (groupConfessContext.uint32_confessor_sex.has()) {
                                                        i3 = groupConfessContext.uint32_confessor_sex.get();
                                                    } else {
                                                        i3 = 0;
                                                    }
                                                    bVar.f202114e = i3;
                                                    if (!groupConfessContext.bytes_confessor_nick.has()) {
                                                        str3 = "";
                                                    } else {
                                                        str3 = groupConfessContext.bytes_confessor_nick.get().toStringUtf8();
                                                    }
                                                    if (TextUtils.isEmpty(str3)) {
                                                        if (bVar.f202114e == 1) {
                                                            qqStr = HardCodeUtil.qqStr(R.string.f171785kz3);
                                                        } else {
                                                            qqStr = HardCodeUtil.qqStr(R.string.kz6);
                                                        }
                                                        bVar.f202120k = qqStr;
                                                    } else {
                                                        bVar.f202120k = str3;
                                                    }
                                                    if (!groupConfessContext.bytes_confess_to_nick.has()) {
                                                        str4 = "";
                                                    } else {
                                                        str4 = groupConfessContext.bytes_confess_to_nick.get().toStringUtf8();
                                                    }
                                                    bVar.f202115f = str4;
                                                    if (groupConfessContext.uint64_confess_time.has()) {
                                                        j3 = groupConfessContext.uint64_confess_time.get();
                                                    } else {
                                                        j3 = 0;
                                                    }
                                                    bVar.f202121l = j3;
                                                    if (groupConfessContext.uint32_confess_to_nick_type.has()) {
                                                        i16 = groupConfessContext.uint32_confess_to_nick_type.get();
                                                    } else {
                                                        i16 = 0;
                                                    }
                                                    bVar.f202116g = i16;
                                                    bVar.f202111b = valueOf6;
                                                    long j27 = msg_comm_msg.msg_head.get().msg_time.get() - 1;
                                                    long j28 = msg_comm_msg.msg_head.get().msg_seq.get();
                                                    long j29 = -1;
                                                    List<ChatMessage> aIOList = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getAIOList(str, 1, -1L);
                                                    if (aIOList != null && !aIOList.isEmpty()) {
                                                        j29 = aIOList.get(aIOList.size() - 1).shmsgseq;
                                                    }
                                                    if (j28 < j29 - 5 && j29 >= 0) {
                                                        if (QLog.isColorLevel()) {
                                                            QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 in if lastseq:" + j29 + "  msgSeq:" + j28);
                                                        }
                                                        ThreadManager.getSubThreadHandler().postDelayed(new Runnable(str, bVar, j27, j28) { // from class: com.tencent.mobileqq.confess.ConfessMsgUtil.1
                                                            static IPatchRedirector $redirector_;

                                                            /* renamed from: e, reason: collision with root package name */
                                                            final /* synthetic */ String f202127e;

                                                            /* renamed from: f, reason: collision with root package name */
                                                            final /* synthetic */ ConfessManager.b f202128f;

                                                            /* renamed from: h, reason: collision with root package name */
                                                            final /* synthetic */ long f202129h;

                                                            /* renamed from: i, reason: collision with root package name */
                                                            final /* synthetic */ long f202130i;

                                                            {
                                                                this.f202127e = str;
                                                                this.f202128f = bVar;
                                                                this.f202129h = j27;
                                                                this.f202130i = j28;
                                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                                    iPatchRedirector.redirect((short) 1, this, ConfessManager.this, str, bVar, Long.valueOf(j27), Long.valueOf(j28));
                                                                }
                                                            }

                                                            @Override // java.lang.Runnable
                                                            public void run() {
                                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                                                    return;
                                                                }
                                                                ConfessManager confessManager3 = ConfessManager.this;
                                                                String str7 = this.f202127e;
                                                                ConfessManager.b bVar2 = this.f202128f;
                                                                long j36 = this.f202129h;
                                                                confessManager3.b(str7, bVar2, j36, j36, this.f202130i);
                                                                if (QLog.isColorLevel()) {
                                                                    QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.f202128f.f202119j + " msgTime:" + this.f202129h + " msgSeq:" + this.f202130i + " nowTime" + com.tencent.mobileqq.service.message.e.K0());
                                                                }
                                                            }
                                                        }, 250L);
                                                        return;
                                                    }
                                                    confessManager2.b(str, bVar, j27, j27, j28);
                                                    if (QLog.isColorLevel()) {
                                                        r26 = 2;
                                                        QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 2 strConfessorDesc:" + bVar.f202119j + " msgTime:" + j27 + " msgSeq:" + j28 + " nowTime" + com.tencent.mobileqq.service.message.e.K0());
                                                    } else {
                                                        return;
                                                    }
                                                } else {
                                                    if (msg_comm_msg.msg_head.has() && msg_comm_msg.msg_head.get().msg_seq.has()) {
                                                        confessManager2.e(str, valueOf7, valueOf6, valueOf8, i38, msg_comm_msg.msg_head.get().msg_seq.get());
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                    return;
                                } catch (InvalidProtocolBufferMicroException e19) {
                                    invalidProtocolBufferMicroException = e19;
                                    r36 = r26;
                                }
                            } catch (InvalidProtocolBufferMicroException e26) {
                                invalidProtocolBufferMicroException = e26;
                                r36 = 2;
                            }
                        } catch (InvalidProtocolBufferMicroException e27) {
                            e = e27;
                            invalidProtocolBufferMicroException = e;
                            r36 = list2;
                            if (!QLog.isColorLevel()) {
                            }
                        }
                    } catch (InvalidProtocolBufferMicroException e28) {
                        invalidProtocolBufferMicroException = e28;
                        r36 = 2;
                    }
                } catch (Exception e29) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ConfessMsgUtil", 2, e29.getMessage(), e29);
                        return;
                    }
                    return;
                }
            } catch (InvalidProtocolBufferMicroException e36) {
                e = e36;
                list2 = 2;
            }
            if (!QLog.isColorLevel()) {
                QLog.i("ConfessMsgUtil", r36, invalidProtocolBufferMicroException.getMessage(), invalidProtocolBufferMicroException);
            }
        }
    }

    public static void l(msg_comm$Msg msg_comm_msg, MessageRecord messageRecord, AppInterface appInterface) {
        Integer valueOf;
        if (messageRecord != null && appInterface != null) {
            List<im_msg_body$Elem> list = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<---decodePttConfessElem: elems: ");
                if (list == null) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(list.size());
                }
                sb5.append(valueOf);
                QLog.d("ConfessMsgUtil", 2, sb5.toString());
            }
            if (list != null && list.size() > 0) {
                for (im_msg_body$Elem im_msg_body_elem : list) {
                    if (im_msg_body_elem.common_elem.has() && 21 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(messageRecord);
                        k(msg_comm_msg, im_msg_body_elem, arrayList, appInterface);
                        return;
                    }
                }
            }
        }
    }

    public static void m(Context context, String str, int i3, int i16, String str2, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i3);
        intent.putExtra("uinname", str2);
        intent.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, i16);
        intent.putExtra(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 1);
        context.startActivity(intent);
    }

    public static MessageRecord n(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        int i3;
        if (messageRecord.isSelfConfessor()) {
            i3 = 1033;
        } else {
            i3 = 1034;
        }
        Message K = qQAppInterface.getMessageFacade().K(messageRecord.senderuin, i3, messageRecord.getConfessTopicId());
        if (K != null) {
            return qQAppInterface.getMessageFacade().P(messageRecord.senderuin, i3, K.uniseq);
        }
        return messageRecord;
    }

    public static int o(int i3, int i16) {
        if (i3 == 1033) {
            return (2097152 | (i16 << 3)) >>> 3;
        }
        if (i3 == 1034) {
            return i16;
        }
        return 0;
    }

    public static String p(QQAppInterface qQAppInterface, ConfessInfo confessInfo, String str) {
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        if (confessInfo.isSysMsg == 1 && !TextUtils.equals(confessInfo.confessorUinStr, currentAccountUin)) {
            return HardCodeUtil.qqStr(R.string.f171786kz4);
        }
        if (!TextUtils.equals(confessInfo.confessorUinStr, currentAccountUin)) {
            return confessInfo.confessorNick;
        }
        return ac.g(qQAppInterface, str, true);
    }

    public static void q(MessageRecord messageRecord) {
        if (messageRecord != null && messageRecord.istroop == 1032 && AppConstants.CONFESS_UIN.equals(messageRecord.frienduin)) {
            if (QLog.isColorLevel()) {
                QLog.i("ConfessMsgUtil", 2, String.format("invalidMsgOnDel senderUin:%s frdUin:%s", messageRecord.senderuin, messageRecord.frienduin));
            }
            messageRecord.saveExtInfoToExtStr("ext_key_confess_info", "");
        }
    }

    public static boolean r(QQAppInterface qQAppInterface, boolean z16) {
        String str;
        if (z16) {
            str = "red_unread_clear_flag";
        } else {
            str = "blue_unread_clear_flag";
        }
        boolean z17 = BaseApplicationImpl.getApplication().getSharedPreferences("confess_unread_file" + qQAppInterface.getCurrentAccountUin(), 0).getBoolean(str, false);
        if (QLog.isColorLevel()) {
            QLog.i("ConfessMsgUtil", 2, "isConfessBoxUnreadCleared:" + z17 + " isRed:" + z16);
        }
        return z17;
    }

    public static boolean s(MessageRecord messageRecord) {
        if (messageRecord == null || TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("ext_key_confess_info"))) {
            return false;
        }
        return true;
    }

    public static void t(QQAppInterface qQAppInterface, boolean z16, boolean z17) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i("ConfessMsgUtil", 2, "setClearConfessBoxUnreadFlag:" + z16 + " isRed:" + z17);
        }
        if (z17) {
            str = "red_unread_clear_flag";
        } else {
            str = "blue_unread_clear_flag";
        }
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("confess_unread_file" + qQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences.getBoolean(str, false) != z16) {
            sharedPreferences.edit().putBoolean(str, z16).apply();
        }
    }
}
