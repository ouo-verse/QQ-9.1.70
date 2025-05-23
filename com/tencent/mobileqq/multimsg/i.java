package com.tencent.mobileqq.multimsg;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.IMultiMsgRecordOp;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.mobileqq.utils.bt;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f251635a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f251636b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f251637c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f251638d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile Boolean f251639e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile Boolean f251640f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73187);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f251635a = true;
        f251636b = true;
        f251639e = null;
        f251640f = null;
    }

    public static void a(MessageRecord messageRecord, String str, MessageRecord messageRecord2) {
        q("step.fillExtraInfo.nickName = %s", str);
        if (messageRecord != null && messageRecord2 != null && !TextUtils.isEmpty(str)) {
            messageRecord.saveExtInfoToExtStr("outest_uin", messageRecord2.frienduin);
            messageRecord.saveExtInfoToExtStr("outest_uintype", String.valueOf(messageRecord2.istroop));
            messageRecord.saveExtInfoToExtStr("outest_uniseq", String.valueOf(messageRecord2.uniseq));
            messageRecord.saveExtInfoToExtStr("self_nickname", str);
        }
    }

    public static void b(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str, String str2, String str3) {
        if (!j(qQAppInterface)) {
            return;
        }
        if (n() && QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG.Nest", 2, "step.fillTransExtraInfo.friendFlag = " + str + "\uff0cfromAnnoId = " + str2 + ", fromFaceUrl = " + str3);
        }
        if (qQAppInterface != null && messageRecord != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            messageRecord.saveExtInfoToExtStr("friend_flag", str);
            messageRecord.saveExtInfoToExtStr("from_anno_id", str2);
            messageRecord.saveExtInfoToExtStr("from_face_url", str3);
        }
    }

    public static ArrayList<ChatMessage> c(QQAppInterface qQAppInterface, ArrayList<ChatMessage> arrayList) {
        if (qQAppInterface != null && arrayList != null && arrayList.size() != 0) {
            ArrayList<ChatMessage> arrayList2 = new ArrayList<>();
            Iterator<ChatMessage> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (o(qQAppInterface, next)) {
                    arrayList2.add(next);
                } else {
                    ChatMessage chatMessage = (ChatMessage) qQAppInterface.getMultiMessageProxy().c(next, h(qQAppInterface, next), false);
                    if (chatMessage.senderuin.equals(qQAppInterface.getCurrentAccountUin())) {
                        ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(chatMessage);
                    }
                    chatMessage.setStatus(1000);
                    chatMessage.msgData = chatMessage.f203106msg.getBytes();
                    arrayList2.add(chatMessage);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int e(ChatMessage chatMessage) {
        int i3;
        if (m(chatMessage)) {
            i3 = ((IMultiMsgRecordOp) chatMessage).getTSum();
        } else {
            i3 = 0;
        }
        return i3 + 1;
    }

    public static MessageRecord f(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord == null || qQAppInterface == null) {
            return null;
        }
        try {
            return qQAppInterface.getMessageFacade().P(messageRecord.getExtInfoFromExtStr("outest_uin"), Integer.parseInt(messageRecord.getExtInfoFromExtStr("outest_uintype")), Long.parseLong(messageRecord.getExtInfoFromExtStr("outest_uniseq")));
        } catch (Exception e16) {
            QLog.e("MultiMsg_TAG", 1, e16, new Object[0]);
            return null;
        }
    }

    public static String g(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForStructing) {
            AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
            if (absStructMsg == null) {
                return "";
            }
            return absStructMsg.mResid;
        }
        if (!(messageRecord instanceof MessageForArkApp)) {
            return "";
        }
        return ArkMsgUtils.optResIdFromMeta(((MessageForArkApp) messageRecord).ark_app_message);
    }

    public static String h(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        AbsStructMsg absStructMsg;
        if (qQAppInterface == null || messageRecord == null) {
            return null;
        }
        if ((messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null && absStructMsg.mMsgServiceID == 128) {
            return HardCodeUtil.qqStr(R.string.obx);
        }
        Message message = new Message();
        MessageRecord.copyMessageRecordBaseField(message, messageRecord);
        message.emoRecentMsg = null;
        message.fileType = -1;
        qQAppInterface.getMessageFacade().w(message);
        MsgSummary msgSummary = new MsgSummary();
        bt.b(qQAppInterface.getApp(), qQAppInterface, message, message.istroop, msgSummary, null, false, false);
        try {
            return msgSummary.d(qQAppInterface.getApp()).toString();
        } catch (Exception e16) {
            QLog.e("MultiMsg_TAG.Nest", 1, e16, new Object[0]);
            return null;
        }
    }

    public static boolean i() {
        Boolean bool = f251640f;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("qq_multi_msg_check_ip_enabled", true));
        f251640f = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean j(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.d("MultiMsg_TAG.Nest", 1, "get feature switch:enable_multi_msg_with_def_uin_switch is null, return true");
            return true;
        }
        if (f251637c == null) {
            f251637c = Boolean.valueOf(((IFeatureRuntimeService) appInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("enable_multi_msg_with_def_uin_switch"));
        }
        return f251637c.booleanValue();
    }

    public static boolean k() {
        Boolean bool = f251639e;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).isFeatureSwitchOn("qq_multi_msg_log_upgrade_enabled", true));
        f251639e = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean l() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("LONG_MSG_OPT");
    }

    public static boolean m(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForStructing) {
            AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
            if (absStructMsg == null || !"viewMultiMsg".equals(absStructMsg.mMsgAction)) {
                return false;
            }
            return true;
        }
        if (!(messageRecord instanceof MessageForArkApp)) {
            return false;
        }
        return ArkMsgUtils.isMultiMsg(((MessageForArkApp) messageRecord).ark_app_message);
    }

    public static boolean n() {
        return f251638d;
    }

    public static boolean o(QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        int i3;
        int cloudType;
        if (MessageForShortVideo.class.isInstance(chatMessage) && ((MessageForShortVideo) chatMessage).busiType == 2) {
            return false;
        }
        if ((MessageForLongTextMsg.class.isInstance(chatMessage) && (chatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2") || chatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) || !MessageForArkApp.isAllowedArkForward(false, chatMessage) || MessageForTroopConfess.class.isInstance(chatMessage) || (chatMessage instanceof MessageForFuDai) || ((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(chatMessage)) {
            return false;
        }
        if ((chatMessage instanceof MessageForPic) && ZhituManager.h0((MessageForPic) chatMessage)) {
            return false;
        }
        if (chatMessage instanceof MessageForWriteTogether) {
            return true;
        }
        switch (chatMessage.msgtype) {
            case MessageRecord.MSG_TYPE_ARK_SDK_SHARE /* -5017 */:
            case MessageRecord.MSG_TYPE_FLASH_CHAT /* -5013 */:
            case MessageRecord.MSG_TYPE_ARK_APP /* -5008 */:
            case MessageRecord.MSG_TYPE_QQSTORY_COMMENT /* -2052 */:
            case MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO /* -2022 */:
            case MessageRecord.MSG_TYPE_TROOP_OBJ_MSG /* -2017 */:
            case -2000:
            case MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT /* -1051 */:
            case MessageRecord.MSG_TYPE_REPLY_TEXT /* -1049 */:
            case MessageRecord.MSG_TYPE_LONG_TEXT /* -1037 */:
            case MessageRecord.MSG_TYPE_MIX /* -1035 */:
            case -1000:
                break;
            case MessageRecord.MSG_TYPE_ARK_BABYQ_REPLY /* -5016 */:
                ArrayList<ArkBabyqCardInfo> arrayList = ((MessageForArkBabyqReply) chatMessage).mArkBabyqReplyCardList;
                if (arrayList == null || arrayList.size() <= 0) {
                    return false;
                }
                break;
            case -3017:
                MessageForDLFile messageForDLFile = (MessageForDLFile) chatMessage;
                DataLineMsgRecord d16 = qQAppInterface.getMessageFacade().t1(messageForDLFile.deviceType).d(messageForDLFile.associatedId);
                if (d16 == null || !q.f(d16.path)) {
                    return false;
                }
                break;
            case MessageRecord.MSG_TYPE_STRUCT_MSG /* -2011 */:
                AbsStructMsg absStructMsg = ((MessageForStructing) chatMessage).structingMsg;
                if (absStructMsg == null || (i3 = absStructMsg.mMsgServiceID) == 107 || i3 == 82 || i3 == 128 || i3 == 104) {
                    return false;
                }
                if (absStructMsg.hasFlag(1) && i3 != 35) {
                    return false;
                }
                break;
            case -2005:
                if (!(chatMessage instanceof MessageForFile)) {
                    return false;
                }
                if (!chatMessage.isMultiMsg && ((cloudType = FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, (MessageForFile) chatMessage).getCloudType()) == 0 || cloudType == 11)) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public static void p(String str, Object... objArr) {
        if (k()) {
            QLog.d("MultiMsg_TAG.Nest", 1, String.format(str, objArr));
        }
    }

    public static void q(String str, Object... objArr) {
        if (f251635a && QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG.Nest", 4, String.format(str, objArr));
        }
    }

    public static void r(String str) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static String d(String str) {
        return str;
    }
}
