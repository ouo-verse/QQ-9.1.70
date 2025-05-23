package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider;
import com.tencent.mobileqq.app.pbsendhandler.IPbSendReqHandler;
import com.tencent.mobileqq.app.richtext.IRichTextAndMsgViaProvider;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$UinPairMsg;
import msf.msgsvc.msg_svc$C2C;
import msf.msgsvc.msg_svc$MultiMsgAssist;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import msf.msgsvc.msg_svc$RoutingHead;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$BlessingMessage;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MessageHandlerUtils extends BaseMessageHandlerUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Q.msg.MessageHandlerUtils";
    private static ArrayList<Integer> mRoutingType;
    private static Callback sCallback;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface Callback {
        void addBubbleInfo(AppInterface appInterface, MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq);

        long convertTinyToUin(long j3, msg_comm$UinPairMsg msg_comm_uinpairmsg, AppInterface appInterface);

        boolean getBabyQGuideMsgCookieFromAISpecialGuide(MessageRecord messageRecord, im_msg_body$GeneralFlags im_msg_body_generalflags);

        Object[] getRichTextAndMsgVia(MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3);

        String getTroopDisplayName(AppInterface appInterface, String str, String str2);

        boolean isMessageForFoldMsg(MessageRecord messageRecord);

        boolean isMsgSendSuc(MessageRecord messageRecord);

        void setMultiMsgFieldInfo(Object obj, msg_svc$MultiMsgAssist msg_svc_multimsgassist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class GetRichTextAndMsgVia {
        static IPatchRedirector $redirector_;
        private AppInterface app;
        private ArrayList<Integer> mMsgTypeList;

        /* renamed from: mr, reason: collision with root package name */
        private MessageRecord f194853mr;
        private int msgVia;
        private im_msg_body$RichText richText;

        public GetRichTextAndMsgVia(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appInterface, messageRecord, im_msg_body_richtext, Integer.valueOf(i3));
                return;
            }
            this.mMsgTypeList = new ArrayList<>(Arrays.asList(-1000, Integer.valueOf(MessageRecord.MSG_TYPE_REPLY_TEXT), Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_WANT_GIFT_MSG), -2000, -2002, -2007, Integer.valueOf(MessageRecord.MSG_TYPE_STICKER_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_VAS_APOLLO), Integer.valueOf(MessageRecord.MSG_TYPE_STRUCT_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_QQSTORY), Integer.valueOf(MessageRecord.MSG_TYPE_TRIBE_SHORT_VIDEO), Integer.valueOf(MessageRecord.MSG_TYPE_SHAKE_WINDOW), Integer.valueOf(MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO), Integer.valueOf(MessageRecord.MSG_TYPE_MEDIA_LIGHTVIDEO), Integer.valueOf(MessageRecord.MSG_TYPE_ARK_APP), Integer.valueOf(MessageRecord.MSG_TYPE_GUILD_GIFT), Integer.valueOf(MessageRecord.MSG_TYPE_FLASH_CHAT), Integer.valueOf(MessageRecord.MSG_TYPE_POKE_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_POKE_EMO_MSG), Integer.valueOf(MessageRecord.MSG_TYPE_STRUCT_LONG_TEXT), Integer.valueOf(MessageRecord.MSG_TYPE_AI_SPECIAL_GUIDE), Integer.valueOf(MessageRecord.MSG_TYPE_MIX), Integer.valueOf(MessageRecord.MSG_TYPE_TROOP_STORY), -7001, Integer.valueOf(MessageRecord.MSG_TYPE_ARK_BABYQ_REPLY), Integer.valueOf(MessageRecord.MSG_TYPE_ARK_SDK_SHARE), Integer.valueOf(MessageRecord.MSG_TYPE_LIMIT_CHAT_CONFIRM), -8018, Integer.valueOf(MessageRecord.MSG_TYPE_ZPLAN), Integer.valueOf(MessageRecord.MSG_TYPE_VIDEO_EMOTICON)));
            this.app = appInterface;
            this.f194853mr = messageRecord;
            this.richText = im_msg_body_richtext;
            this.msgVia = i3;
        }

        private void getRichTextFromOtherMsgType() {
            if (!this.mMsgTypeList.contains(Integer.valueOf(this.f194853mr.msgtype))) {
                this.richText = null;
            }
        }

        public int getMsgVia() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.msgVia;
        }

        public im_msg_body$RichText getRichText() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (im_msg_body$RichText) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.richText;
        }

        public GetRichTextAndMsgVia invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (GetRichTextAndMsgVia) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            Iterator<IRichTextAndMsgViaProvider> it = ((IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "")).getRegistry().s().iterator();
            while (it.hasNext()) {
                Object[] richTextAndMsgViaFromMessageRecord = it.next().getRichTextAndMsgViaFromMessageRecord(this.app, this.f194853mr, this.richText, this.msgVia);
                this.richText = (im_msg_body$RichText) richTextAndMsgViaFromMessageRecord[0];
                this.msgVia = ((Integer) richTextAndMsgViaFromMessageRecord[1]).intValue();
            }
            getRichTextFromOtherMsgType();
            return this;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            com.tencent.imcore.message.s.a();
            mRoutingType = new ArrayList<>(Arrays.asList(1, 3, 24, 14, 5, 6, 10, 11, 12, 23, 25, 26, 8, 16, 17, 18, 15, 19, 20, 22, 28, 27, 29, 31, 30, 32, 33, 34, 34, 35));
        }
    }

    public MessageHandlerUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean addBubbleDiyTextId(MessageRecord messageRecord, int i3, int i16, int i17, boolean z16, boolean z17, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        int i18;
        if (z16) {
            if ((i17 <= 0 || (i3 + i16 < i17 && i17 > 0)) && (i18 = messageRecord.vipBubbleDiyTextId) > 0) {
                im_msg_body_generalflags.uint32_bubble_diy_text_id.set(i18);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "add BubbleDiyTextId!");
                }
                return true;
            }
            return z17;
        }
        return z17;
    }

    public static long byteArrToLong(byte[] bArr) {
        if (bArr.length != 4) {
            return 0L;
        }
        return ((bArr[0] & 255) << 24) + ((bArr[1] & 255) << 16) + ((bArr[2] & 255) << 8) + (bArr[3] & 255);
    }

    private static boolean deduplicationC2CMsg(AppInterface appInterface, MessageRecord messageRecord, boolean z16, long j3, StringBuilder sb5, List<MessageRecord> list) {
        if (list != null && list.size() > 0) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                if (com.tencent.imcore.message.ad.b(it.next(), messageRecord, z16)) {
                    if (QLog.isColorLevel() && sb5 != null) {
                        sb5.append(" filterType: " + messageRecord.istroop);
                        QLog.w(TAG, 2, sb5.toString());
                    }
                    MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - j3);
                    return true;
                }
            }
        }
        if (((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).j1(messageRecord)) {
            return true;
        }
        return false;
    }

    private static boolean deduplicationKanDianMerge(MessageRecord messageRecord, long j3, StringBuilder sb5, List<MessageRecord> list) {
        if (list != null && list.size() > 0) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                if (com.tencent.imcore.message.ad.b(it.next(), messageRecord, true)) {
                    if (QLog.isColorLevel() && sb5 != null) {
                        sb5.append(" filterType: other");
                        QLog.w(TAG, 2, sb5.toString());
                    }
                    MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - j3);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean deduplicationMsg(AppInterface appInterface, MessageRecord messageRecord, boolean z16, long j3, StringBuilder sb5) {
        List<MessageRecord> msgList = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(messageRecord.frienduin, messageRecord.istroop);
        int i3 = messageRecord.istroop;
        if (i3 != 1 && i3 != 1026 && i3 != 3000) {
            if (com.tencent.imcore.message.ao.r(i3)) {
                if (deduplicationC2CMsg(appInterface, messageRecord, z16, j3, sb5, msgList)) {
                    return true;
                }
                return false;
            }
            if (messageRecord.istroop == 7220) {
                if (deduplicationKanDianMerge(messageRecord, j3, sb5, msgList)) {
                    return true;
                }
                return false;
            }
            if (deduplicationOtherMsg(messageRecord, j3, sb5, msgList)) {
                return true;
            }
            return false;
        }
        if (deduplicationTroopAndDiscussionMsg(appInterface, messageRecord, z16, j3, sb5, msgList)) {
            return true;
        }
        return false;
    }

    private static boolean deduplicationOtherMsg(MessageRecord messageRecord, long j3, StringBuilder sb5, List<MessageRecord> list) {
        if (list != null && list.size() > 0) {
            for (MessageRecord messageRecord2 : list) {
                if (messageRecord2.time == messageRecord.time && messageRecord2.f203106msg.equals(messageRecord.f203106msg)) {
                    if (QLog.isColorLevel() && sb5 != null) {
                        sb5.append(" filterType: other");
                        QLog.w(TAG, 2, sb5.toString());
                    }
                    MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - j3);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean deduplicationTroopAndDiscussionMsg(AppInterface appInterface, MessageRecord messageRecord, boolean z16, long j3, StringBuilder sb5, List<MessageRecord> list) {
        if (list != null && list.size() > 0) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                if (com.tencent.imcore.message.ad.e(it.next(), messageRecord, false, z16)) {
                    if (QLog.isColorLevel() && sb5 != null) {
                        sb5.append(" filterType: troop msg isNormalMsg=" + z16);
                        QLog.w(TAG, 2, sb5.toString());
                    }
                    MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - j3);
                    return true;
                }
            }
        }
        if (((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).j1(messageRecord)) {
            return true;
        }
        return false;
    }

    private static void fillingUinList(ArrayList<String> arrayList, msg_svc$MultiMsgAssist msg_svc_multimsgassist) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            msg_svc$RoutingHead msg_svc_routinghead = new msg_svc$RoutingHead();
            msg_svc$C2C msg_svc_c2c = new msg_svc$C2C();
            msg_svc_c2c.to_uin.set(Long.valueOf(next).longValue());
            msg_svc_routinghead.c2c.set(msg_svc_c2c);
            msg_svc_multimsgassist.repeated_routing.add(msg_svc_routinghead);
        }
    }

    public static im_msg_body$GeneralFlags getGeneralFlagElemFromMsg(AppInterface appInterface, MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
        im_msg_body$GeneralFlags im_msg_body_generalflags = new im_msg_body$GeneralFlags();
        generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
        boolean handleGeneralFlagAttrHolidayMsg = handleGeneralFlagAttrHolidayMsg(false, generalflags_resvattr, messageRecord.getExtInfoFromExtStr(com.tencent.mobileqq.service.message.i.f286260c));
        if (messageRecord.msgtype == -1052) {
            if (messageRecord.f203106msg == null || sCallback.getBabyQGuideMsgCookieFromAISpecialGuide(messageRecord, im_msg_body_generalflags)) {
                return null;
            }
            return im_msg_body_generalflags;
        }
        Iterator<IGeneralFlagProvider> it = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().j().iterator();
        boolean z16 = handleGeneralFlagAttrHolidayMsg;
        boolean z17 = false;
        while (it.hasNext()) {
            boolean[] generalFlagElemFromMsg = it.next().getGeneralFlagElemFromMsg(appInterface, z17, z16, messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
            z17 = generalFlagElemFromMsg[0];
            z16 = generalFlagElemFromMsg[1];
        }
        if (z16) {
            im_msg_body_generalflags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(generalflags_resvattr.toByteArray()));
            z17 = true;
        }
        if (!z17) {
            return null;
        }
        return im_msg_body_generalflags;
    }

    public static msg_svc$PbSendMsgReq getPbSendReqFromBlessMsg(AppInterface appInterface, MessageRecord messageRecord, ArrayList<String> arrayList, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        Object[] richTextAndMsgVia = sCallback.getRichTextAndMsgVia(messageRecord, null, 0);
        im_msg_body$RichText im_msg_body_richtext = (im_msg_body$RichText) richTextAndMsgVia[0];
        int intValue = ((Integer) richTextAndMsgVia[1]).intValue();
        int i3 = messageRecord.msgtype;
        if (i3 != -1000 && i3 != -2022 && i3 != -2000) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getPbSendReqFromBlessMsg, error msgtype, " + messageRecord.msgtype);
            }
            return null;
        }
        if (im_msg_body_richtext != null && im_msg_body_richtext.elems != null && arrayList != null && arrayList.size() != 0) {
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body$BlessingMessage im_msg_body_blessingmessage = new im_msg_body$BlessingMessage();
            im_msg_body_blessingmessage.uint32_msg_type.set(1);
            if (messageRecord.needUpdateMsgTag) {
                im_msg_body_blessingmessage.uint32_ex_flag.set(1);
            } else {
                im_msg_body_blessingmessage.uint32_ex_flag.set(0);
            }
            im_msg_body_elem.bless_msg.set(im_msg_body_blessingmessage);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
            im_msg_body_msgbody.rich_text.set(im_msg_body_richtext);
            msg_svc$MultiMsgAssist msg_svc_multimsgassist = new msg_svc$MultiMsgAssist();
            msg_svc_multimsgassist.msg_use.set(1);
            fillingUinList(arrayList, msg_svc_multimsgassist);
            sCallback.setMultiMsgFieldInfo(obj, msg_svc_multimsgassist);
            int e16 = com.tencent.mobileqq.service.message.s.e(messageRecord.msgUid);
            byte[] F0 = ((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).F0();
            msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq = new msg_svc$PbSendMsgReq();
            msg_svc_pbsendmsgreq.msg_body.set(im_msg_body_msgbody);
            msg_svc_pbsendmsgreq.msg_seq.set(((short) messageRecord.msgseq) & 65535);
            msg_svc_pbsendmsgreq.msg_rand.set(e16);
            msg_svc_pbsendmsgreq.msg_via.set(intValue);
            msg_svc_pbsendmsgreq.multi_msg_assist.set(msg_svc_multimsgassist);
            if (F0 != null) {
                msg_svc_pbsendmsgreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
            }
            sCallback.addBubbleInfo(appInterface, messageRecord, msg_svc_pbsendmsgreq);
            return msg_svc_pbsendmsgreq;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            if (im_msg_body_richtext == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            if (im_msg_body_richtext != null && im_msg_body_richtext.elems == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            objArr[1] = Boolean.valueOf(z17);
            if (arrayList == null) {
                z18 = true;
            } else {
                z18 = false;
            }
            objArr[2] = Boolean.valueOf(z18);
            if (arrayList != null && arrayList.size() == 0) {
                z19 = true;
            }
            objArr[3] = Boolean.valueOf(z19);
            QLog.d(TAG, 2, String.format("getPbSendReqFromBlessMsg, error: %s, %s, %s, %s", objArr));
        }
        return null;
    }

    public static msg_svc$PbSendMsgReq getPbSendReqFromMessage(AppInterface appInterface, MessageRecord messageRecord) {
        GetRichTextAndMsgVia invoke = new GetRichTextAndMsgVia(appInterface, messageRecord, null, 0).invoke();
        im_msg_body$RichText richText = invoke.getRichText();
        int msgVia = invoke.getMsgVia();
        if (richText == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgVia", 2, "send message, entrance: " + msgVia);
        }
        Iterator<IPbSendReqHandler> it = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().q().iterator();
        msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq = null;
        while (it.hasNext()) {
            msg_svc_pbsendmsgreq = it.next().handlePbSendMsg(appInterface, messageRecord, richText, msgVia, msg_svc_pbsendmsgreq);
        }
        dispatchCreatePbSendReqFromMessage(messageRecord, msg_svc_pbsendmsgreq, appInterface);
        return msg_svc_pbsendmsgreq;
    }

    public static long getPkgFriendUin(AppInterface appInterface, long j3, long j16, long j17, msg_comm$UinPairMsg msg_comm_uinpairmsg) {
        return sCallback.convertTinyToUin(getPkgFriendUin(appInterface, j3, j16, j17), msg_comm_uinpairmsg, appInterface);
    }

    public static String getTroopDisplayName(AppInterface appInterface, String str, String str2) {
        return sCallback.getTroopDisplayName(appInterface, str, str2);
    }

    private static boolean handleGeneralFlagAttrHolidayMsg(boolean z16, generalflags$ResvAttr generalflags_resvattr, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                generalflags_resvattr.uint32_holiday_flag.set(Integer.parseInt(str));
                return true;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getGeneralFlagElem, holiday_activie_flag.error: " + str);
                }
                return false;
            }
        }
        return z16;
    }

    public static boolean isALLFoldMsg(ArrayList<MessageRecord> arrayList) {
        if (arrayList == null) {
            return false;
        }
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            if (next.msgtype != -2006 || !sCallback.isMessageForFoldMsg(next)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isC2CRoutingType(int i3, AppInterface appInterface) {
        com.tencent.imcore.message.core.codec.d dVar = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getRegistry().t().get(Integer.valueOf(i3));
        if (dVar != null && dVar.b()) {
            return true;
        }
        return mRoutingType.contains(Integer.valueOf(i3));
    }

    public static boolean isMsgSendSuc(MessageRecord messageRecord) {
        return sCallback.isMsgSendSuc(messageRecord);
    }

    public static boolean isMsgSeqReady(MessageRecord messageRecord) {
        int i3 = messageRecord.istroop;
        if (i3 != 1 && i3 != 3000) {
            return isMsgSendSuc(messageRecord);
        }
        if (isMsgSendSuc(messageRecord) && messageRecord.extraflag == 0) {
            return true;
        }
        return false;
    }

    public static boolean msgFilter(AppInterface appInterface, MessageRecord messageRecord, boolean z16) {
        StringBuilder sb5;
        if (messageRecord != null && (messageRecord.f203106msg != null || messageRecord.msgData != null)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder(256);
                sb5.append("---------------msgFilter istroop: ");
                sb5.append(messageRecord.istroop);
                sb5.append(" uid: ");
                sb5.append(messageRecord.msgUid);
                sb5.append(" shmsgseq: ");
                sb5.append(messageRecord.shmsgseq);
                sb5.append(" friendUin: ");
                sb5.append(messageRecord.frienduin);
                sb5.append(" senderUin: ");
                sb5.append(messageRecord.senderuin);
                sb5.append(" msgType: ");
                sb5.append(messageRecord.msgtype);
                sb5.append(" time:");
                sb5.append(messageRecord.time);
                sb5.append(" msgContent: ");
                sb5.append(messageRecord.getLogColorContent());
                sb5.append(" isNormalMsg: ");
                sb5.append(z16);
            } else {
                sb5 = null;
            }
            if (deduplicationMsg(appInterface, messageRecord, z16, currentTimeMillis, sb5)) {
                return true;
            }
            if (QLog.isColorLevel() && sb5 != null) {
                QLog.d(TAG, 2, sb5.toString());
            }
            MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - currentTimeMillis);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "---------------msgFilter message [before filter] is null !");
        }
        return true;
    }

    public static boolean msgFilterForDatingSafetyTip(AppInterface appInterface, MessageRecord messageRecord) {
        StringBuilder sb5;
        int size;
        int i3;
        if (messageRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "---------------msgFilter message [before filter] is null !");
            }
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(256);
            sb5.append("---------------msgFilter istroop: ");
            sb5.append(messageRecord.istroop);
            sb5.append(" shmsgseq: ");
            sb5.append(messageRecord.shmsgseq);
            sb5.append(" friendUin: ");
            sb5.append(messageRecord.frienduin);
            sb5.append(" senderUin: ");
            sb5.append(messageRecord.senderuin);
            sb5.append(" msgType: ");
            sb5.append(messageRecord.msgtype);
            sb5.append(" time:");
            sb5.append(messageRecord.time);
            sb5.append(" msgContent: ");
            sb5.append(messageRecord.getLogColorContent());
        } else {
            sb5 = null;
        }
        List<MessageRecord> msgList = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(messageRecord.frienduin, messageRecord.istroop);
        if (msgList == null) {
            size = 0;
        } else {
            size = msgList.size();
        }
        if (size > 15) {
            i3 = size - 15;
        } else {
            i3 = 0;
        }
        while (i3 < size) {
            MessageRecord messageRecord2 = msgList.get(i3);
            if (messageRecord2 != null && messageRecord2.msgtype == messageRecord.msgtype && Utils.p(messageRecord2.f203106msg, messageRecord.f203106msg)) {
                if (QLog.isColorLevel() && sb5 != null) {
                    sb5.append(" filterType: other");
                    QLog.w(TAG, 2, sb5.toString());
                }
                MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - currentTimeMillis);
                return true;
            }
            i3++;
        }
        if (QLog.isColorLevel() && sb5 != null) {
            QLog.d(TAG, 2, sb5.toString());
        }
        MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - currentTimeMillis);
        return false;
    }

    public static void qLogColorFormate(String str, String str2, long j3, String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, "<" + str2 + j3);
            String str5 = j3 + "|" + str3 + "|" + str4;
            if (str2 != null) {
                QLog.d(str, 2, str2 + str5);
            }
        }
    }

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    public static long getPkgFriendUin(AppInterface appInterface, long j3, long j16, long j17) {
        long longAccountUin = appInterface.getLongAccountUin();
        if (j3 == longAccountUin) {
            return j16;
        }
        if (j16 == longAccountUin) {
            return j3;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "<---decodeC2CMessagePackage: neither fromUin nor toUin is selfUin.use peerUin instead.");
        }
        return j17;
    }

    public static boolean msgFilter(AppInterface appInterface, int i3, String str, String str2, long j3, long j16) {
        List<MessageRecord> msgList = ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).getMsgList(str, i3);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("------->msgFilter :msgIsTroop:");
            sb5.append(i3);
            sb5.append(",peerUin:");
            sb5.append(str);
            sb5.append(",list size:");
            sb5.append(msgList == null ? 0 : msgList.size());
            QLog.d(TAG, 2, sb5.toString());
        }
        if (msgList != null && msgList.size() > 0) {
            for (MessageRecord messageRecord : msgList) {
                if (Math.abs(messageRecord.time - j3) < 30 && messageRecord.shmsgseq == j16 && messageRecord.senderuin.equals(str2)) {
                    if (!QLog.isColorLevel()) {
                        return true;
                    }
                    QLog.d(TAG, 2, "------->msgFilter-duplicated msg.");
                    return true;
                }
            }
        }
        return false;
    }

    private static void dispatchCreatePbSendReqFromMessage(MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, AppInterface appInterface) {
    }
}
