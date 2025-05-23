package com.tencent.imcore.message;

import PushNotifyPack.C2CMsgReadedNotify;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.i;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ConversationInfoErrorReporter;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.zplan.model.ZPlanHeadEffectFlag;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$C2CTmpMsgHead;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgcomm.msg_comm$UinPairMsg;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes7.dex */
public class C2CMessageProcessorCallback implements i.e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f116384a;

    /* renamed from: b, reason: collision with root package name */
    public int f116385b;

    /* renamed from: c, reason: collision with root package name */
    public int f116386c;

    /* renamed from: d, reason: collision with root package name */
    public int f116387d;

    /* renamed from: e, reason: collision with root package name */
    public int f116388e;

    /* renamed from: f, reason: collision with root package name */
    public int f116389f;

    /* renamed from: g, reason: collision with root package name */
    public int f116390g;

    /* renamed from: h, reason: collision with root package name */
    public int f116391h;

    /* renamed from: i, reason: collision with root package name */
    public int f116392i;

    /* renamed from: j, reason: collision with root package name */
    public int f116393j;

    /* renamed from: k, reason: collision with root package name */
    HashSet<String> f116394k;

    /* renamed from: l, reason: collision with root package name */
    HashSet<String> f116395l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f116396m;

    public C2CMessageProcessorCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f116384a = 1;
        this.f116385b = 3;
        this.f116386c = 10;
        this.f116387d = 30;
        this.f116388e = 0;
        this.f116389f = 1;
        this.f116390g = 5;
        this.f116391h = 10;
        this.f116392i = 50;
        this.f116393j = 0;
        this.f116394k = null;
        this.f116395l = null;
        this.f116396m = false;
    }

    private void F(msg_comm$MsgHead msg_comm_msghead, MessageRecord messageRecord) {
        msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead = msg_comm_msghead.c2c_tmp_msg_head.get();
        if (msg_comm_c2ctmpmsghead != null && msg_comm_c2ctmpmsghead.lock_display.has() && msg_comm_c2ctmpmsghead.lock_display.get() == 1) {
            messageRecord.extLong |= 1;
            messageRecord.saveExtInfoToExtStr("lockDisplay", "true");
        }
    }

    private void G(msg_comm$MsgHead msg_comm_msghead, MessageRecord messageRecord) {
        msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead = msg_comm_msghead.c2c_tmp_msg_head.get();
        if (msg_comm_c2ctmpmsghead != null) {
            if (msg_comm_c2ctmpmsghead.business_name.has()) {
                messageRecord.saveExtInfoToExtStr("temp_conv_biz_name", msg_comm_c2ctmpmsghead.business_name.get().toStringUtf8());
            }
            if (msg_comm_c2ctmpmsghead.business_sub_content.has()) {
                messageRecord.saveExtInfoToExtStr("temp_conv_biz_content", msg_comm_c2ctmpmsghead.business_sub_content.get().toStringUtf8());
            }
        }
    }

    private void H(String str, int i3, msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo, AppInterface appInterface) {
        byte[] k06;
        if (i3 == 1024 && (k06 = ((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).k0(str)) != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + HexUtil.bytes2HexStr(k06) + ",length:" + k06.length);
            }
            uinPairReadInfo.crm_sig.set(ByteStringMicro.copyFrom(k06));
        }
    }

    private void I() {
        if (!this.f116396m) {
            String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
            String featureValue2 = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
            String[] split = featureValue.split("\\|");
            String[] split2 = featureValue2.split("\\|");
            if (split.length >= 6 && split2.length >= 6) {
                this.f116384a = Integer.parseInt(split[0]);
                this.f116385b = Integer.parseInt(split[1]);
                this.f116386c = Integer.parseInt(split[2]);
                this.f116387d = Integer.parseInt(split[3]);
                this.f116389f = Integer.parseInt(split2[0]);
                this.f116390g = Integer.parseInt(split2[1]);
                this.f116391h = Integer.parseInt(split2[2]);
                this.f116392i = Integer.parseInt(split2[3]);
                if (QLog.isDevelopLevel()) {
                    QLog.d(LogTag.NEARBY_RANK, 4, "DealOneWayMessageNotify,date:[" + this.f116384a + "|" + this.f116385b + "|" + this.f116386c + "|" + this.f116387d + "],LBS:[" + this.f116389f + "|" + this.f116390g + "|" + this.f116391h + "|" + this.f116392i + "]");
                }
            }
            this.f116396m = true;
        }
    }

    private void K(msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar, ArrayList<MessageRecord> arrayList, msg_comm$MsgHead msg_comm_msghead, int i3, long j3, long j16, int i16, long j17, int i17, int i18, int i19, ArrayList<MessageRecord> arrayList2, long j18, AppInterface appInterface) {
        int i26;
        boolean z16;
        if (TextUtils.equals(String.valueOf(j3), AppConstants.FILE_ASSISTANT_UIN)) {
            i26 = com.tencent.mobileqq.filemanager.fileassistant.util.h.b(msg_comm_msg);
            if (!com.tencent.mobileqq.filemanager.fileassistant.util.h.o()) {
                com.tencent.mobileqq.filemanager.fileassistant.util.g.e();
                com.tencent.mobileqq.filemanager.fileassistant.util.h.u();
                QLog.d("QFileAssistant", 1, "C2CMessageProcessorCallback, decodeAllMsg: receive push when switch closed");
            }
        } else {
            i26 = 0;
        }
        int i27 = i26;
        Iterator<MessageRecord> it = arrayList2.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            if (!i0(aVar, next, appInterface) && !N(aVar, i3, j3, j16, i16, appInterface)) {
                next.selfuin = String.valueOf(aVar.f286148c);
                next.frienduin = String.valueOf(aVar.f286338a);
                next.senderuin = String.valueOf(aVar.f286149d);
                next.time = aVar.f286150e;
                next.shmsgseq = i3;
                next.msgUid = j16;
                next.istroop = aVar.f286163r;
                next.longMsgId = i17;
                next.longMsgCount = i18;
                next.longMsgIndex = i19;
                Q(aVar, next, appInterface);
                if (next.msgtype == -2058) {
                    EmojiStickerManager.e(next, appInterface);
                }
                if (com.tencent.mobileqq.filemanager.fileassistant.util.h.k(next.frienduin)) {
                    com.tencent.mobileqq.filemanager.fileassistant.util.h.x(next, i27);
                }
                if (!V(aVar, i3, j3, j16, i16, next, appInterface)) {
                    F(msg_comm_msghead, next);
                    G(msg_comm_msghead, next);
                    if (aVar.f286163r == 0 && (next instanceof MessageForPic)) {
                        z16 = true;
                        ((MessageForPic) next).bEnableEnc = true;
                    } else {
                        z16 = true;
                    }
                    if (!M(aVar, msg_comm_msghead, j3, next, appInterface)) {
                        h0(aVar, next);
                        R(next);
                        next.vipBubbleID = aVar.f286151f;
                        next.vipBubbleDiyTextId = aVar.f286152g;
                        next.vipSubBubbleId = aVar.f286153h;
                        g0(msg_comm_msg, aVar, next);
                        T(msg_comm_msghead, j18, next);
                        P(next, appInterface);
                        if (next.msgtype == -7005) {
                            ((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).handleLimitChatC2CConfirmMsg(next, appInterface);
                        } else {
                            arrayList.add(next);
                            if (aVar.f286163r == 1036) {
                                com.tencent.mobileqq.service.message.p.I(j17, i3, j16, i16, appInterface);
                            }
                        }
                    }
                }
            }
        }
    }

    private void L(ArrayList<MessageRecord> arrayList, int i3, AppInterface appInterface) {
        if (i3 == 1008) {
            try {
                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
                if (iPublicAccountDataManager != null) {
                    iPublicAccountDataManager.decodeMessageRecord(arrayList, appInterface);
                }
            } catch (Exception e16) {
                QLog.e("Q.msg.C2CMessageProcessor", 1, "decodeC2CUinPublicAccountMsg get an Exception:" + e16.toString());
            }
        }
    }

    private boolean M(com.tencent.mobileqq.service.message.a aVar, msg_comm$MsgHead msg_comm_msghead, long j3, MessageRecord messageRecord, AppInterface appInterface) {
        if (aVar.f286163r == 1006) {
            if (msg_comm_msghead.from_nick.has()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(aVar.f286338a)), String.valueOf(aVar.f286338a));
                dVar.M();
                dVar.k0(msg_comm_msghead.from_nick.get());
                dVar.g0(System.currentTimeMillis());
                ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, "Q.msg.C2CMessageProcessor", (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
            }
            messageRecord.frienduin = com.tencent.mobileqq.utils.ac.V(appInterface, String.valueOf(aVar.f286338a));
            messageRecord.senderuin = com.tencent.mobileqq.utils.ac.V(appInterface, String.valueOf(j3));
            if (TextUtils.isEmpty(messageRecord.frienduin) && aVar.f286157l) {
                messageRecord.frienduin = String.valueOf(aVar.f286338a);
            }
            if (messageRecord.frienduin == null) {
                QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", Long.valueOf(aVar.f286338a), Long.valueOf(j3), Integer.valueOf(messageRecord.istroop), Integer.valueOf(messageRecord.msgtype)));
                return true;
            }
        }
        return false;
    }

    private boolean N(com.tencent.mobileqq.service.message.a aVar, int i3, long j3, long j16, int i16, AppInterface appInterface) {
        byte[] bArr;
        com.tencent.mobileqq.service.message.e eVar;
        if (ao.c(aVar.f286163r) == 1032) {
            if (appInterface != null && (eVar = (com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()) != null) {
                bArr = eVar.p0(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c));
            } else {
                bArr = null;
            }
            com.tencent.mobileqq.service.message.p.J(appInterface, j3, i3, j16, i16, bArr);
            if (aVar.f286163r == 1032) {
                if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.C2CMessageProcessor", 2, String.format("decodeMessage discard confess msg senderUin:%s msgSeq:%d msgType:%d", Long.toString(j3), Integer.valueOf(i3), Integer.valueOf(i16)));
                }
                return true;
            }
        }
        return false;
    }

    private boolean O(int i3, long j3, long j16, int i16, MessageForStructing messageForStructing, AppInterface appInterface) {
        return false;
    }

    private void P(MessageRecord messageRecord, AppInterface appInterface) {
        MessageForStructing messageForStructing;
        AbsStructMsg absStructMsg;
        if ((messageRecord instanceof MessageForStructing) && (absStructMsg = (messageForStructing = (MessageForStructing) messageRecord).structingMsg) != null && absStructMsg.mMsgServiceID == 76) {
            ((wx.a) appInterface.getManager(QQManagerFactory.NOW_LIVE_MANAGER)).i(messageForStructing);
        }
    }

    private void Q(com.tencent.mobileqq.service.message.a aVar, MessageRecord messageRecord, AppInterface appInterface) {
        IConversationFacade iConversationFacade = (IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "");
        if (1 == aVar.f286164s && ao.q(messageRecord.istroop) && ao.c(messageRecord.istroop) != 1032 && !iConversationFacade.isUinInRecentNotSubAccount(messageRecord.frienduin) && !iConversationFacade.isInMsgBox(messageRecord.frienduin, ao.c(messageRecord.istroop), ad.g(ao.c(messageRecord.istroop)))) {
            ad.S(messageRecord, true);
        } else {
            ad.S(messageRecord, false);
        }
    }

    private void R(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForPoke) {
            if (!messageRecord.isread && !messageRecord.isSend()) {
                ((MessageForPoke) messageRecord).isPlayed = false;
            }
            ((MessageForPoke) messageRecord).initMsg();
        }
    }

    private void S(msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar, ArrayList<MessageRecord> arrayList) {
        if (aVar.f286163r == 1008 && msg_comm_msg.msg_body.has()) {
            im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
            if (im_msg_body_msgbody.rich_text.has()) {
                im_msg_body$RichText im_msg_body_richtext = im_msg_body_msgbody.rich_text.get();
                if (im_msg_body_richtext.elems.has()) {
                    for (im_msg_body$Elem im_msg_body_elem : im_msg_body_richtext.elems.get()) {
                        if (im_msg_body_elem.pub_acc_info.has()) {
                            int i3 = im_msg_body_elem.pub_acc_info.uint32_is_inter_num.get();
                            String str = im_msg_body_elem.pub_acc_info.string_msg_template_id.get();
                            if (i3 != 0) {
                                Iterator<MessageRecord> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    it.next().saveExtInfoToExtStr("inter_num", String.valueOf(i3));
                                }
                            }
                            Iterator<MessageRecord> it5 = arrayList.iterator();
                            while (it5.hasNext()) {
                                it5.next().saveExtInfoToExtStr("msg_template_id", str);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    private void T(msg_comm$MsgHead msg_comm_msghead, long j3, MessageRecord messageRecord) {
        if (messageRecord.istroop == 1008) {
            try {
                if (msg_comm_msghead.public_account_group_send_flag.has()) {
                    messageRecord.saveExtInfoToExtStr("public_account_send_flag", String.valueOf(msg_comm_msghead.public_account_group_send_flag.get()));
                }
            } catch (Throwable th5) {
                QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", th5);
            }
            if (j3 != -1) {
                messageRecord.saveExtInfoToExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID, String.valueOf(j3));
            }
        }
    }

    private void U(int i3, ArrayList<MessageRecord> arrayList) {
        if (arrayList.size() == 0 && i3 > 1) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
            }
            MessageForText messageForText = (MessageForText) com.tencent.mobileqq.service.message.q.d(-1000);
            messageForText.msgtype = -1000;
            messageForText.f203106msg = "";
            arrayList.add(messageForText);
        }
    }

    private boolean V(com.tencent.mobileqq.service.message.a aVar, int i3, long j3, long j16, int i16, MessageRecord messageRecord, AppInterface appInterface) {
        if (ao.q(aVar.f286163r) && (messageRecord instanceof MessageForStructing)) {
            int a16 = com.tencent.mobileqq.app.message.i.a(messageRecord, 1);
            if (a16 > 0) {
                messageRecord.saveExtInfoToExtStr("nearby_gift_msg", "1|" + a16);
            }
            if (O(i3, j3, j16, i16, (MessageForStructing) messageRecord, appInterface)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private long W(String str, int i3, AppInterface appInterface) {
        if (i3 == 1006) {
            String m06 = com.tencent.mobileqq.utils.ac.m0(appInterface, str);
            if (TextUtils.isEmpty(m06)) {
                return -1L;
            }
            return Long.parseLong(m06);
        }
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        return Long.parseLong(str);
    }

    private long Y(msg_comm$Msg msg_comm_msg, long j3) {
        try {
            List<im_msg_body$Elem> list = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    im_msg_body$Elem im_msg_body_elem = list.get(i3);
                    if (im_msg_body_elem.elem_flags2.has() && im_msg_body_elem.elem_flags2.get().uint64_msg_id.has()) {
                        j3 = im_msg_body_elem.elem_flags2.get().uint64_msg_id.get();
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", th5);
        }
        return j3;
    }

    private static int Z(msg_comm$Msg msg_comm_msg) {
        int i3 = -1;
        try {
            List<im_msg_body$Elem> list = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
            if (list != null && list.size() > 0) {
                for (int i16 = 0; i16 < list.size(); i16++) {
                    im_msg_body$Elem im_msg_body_elem = list.get(i16);
                    if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
                        try {
                            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                            generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                            if (generalflags_resvattr.uint32_show_in_msg_list.has()) {
                                i3 = generalflags_resvattr.uint32_show_in_msg_list.get();
                                if (!QLog.isColorLevel()) {
                                    break;
                                }
                                QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster has uint32ShowInMsgList:" + i3);
                                break;
                            }
                            continue;
                        } catch (Exception e16) {
                            QLog.e("msgFold", 1, "prase ResvAttr error, ", e16);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", th5);
        }
        return i3;
    }

    private void a0(ArrayList<MessageRecord> arrayList, i iVar) {
        PAMessage b16;
        Iterator<MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            int i3 = next.msgtype;
            if ((i3 == -3006 || i3 == -5004) && (b16 = com.tencent.mobileqq.activity.aio.ap.b(next)) != null) {
                long j3 = b16.mMsgId;
                if (j3 > 0) {
                    ReportController.n(iVar.f116342a, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, next.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(j3), "", "", "");
                }
            }
            if (next.mQidianMasterUin != 0 && !TextUtils.isEmpty(next.mQidianTipText) && next.mIsShowQidianTips == 1) {
                ThreadManagerV2.executeOnSubThread(new Runnable(iVar, next) { // from class: com.tencent.imcore.message.C2CMessageProcessorCallback.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ i f116397d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ MessageRecord f116398e;

                    {
                        this.f116397d = iVar;
                        this.f116398e = next;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, C2CMessageProcessorCallback.this, iVar, next);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        AppInterface appInterface = this.f116397d.f116342a;
                        MessageRecord messageRecord = this.f116398e;
                        int i16 = messageRecord.istroop;
                        String str = messageRecord.frienduin;
                        String valueOf = String.valueOf(messageRecord.mQidianMasterUin);
                        String valueOf2 = String.valueOf(this.f116398e.mQidianTaskId);
                        MessageRecord messageRecord2 = this.f116398e;
                        com.tencent.qidian.util.b.a(appInterface, i16, str, valueOf, valueOf2, messageRecord2.mQidianTipText, messageRecord2.time);
                    }
                });
            }
        }
        x(arrayList, iVar);
    }

    private void b0(String str, AppInterface appInterface) {
        if (ad.w(str)) {
            com.tencent.mobileqq.dating.h.b(appInterface, 1, null);
        } else if (ao.A(str)) {
            com.tencent.mobileqq.dating.h.a(appInterface);
        } else {
            com.tencent.mobileqq.dating.h.b(appInterface, 2, null);
        }
    }

    private void c0(String str, int i3, long j3, i iVar) {
        AppInterface appInterface = iVar.f116342a;
        long W = W(str, i3, appInterface);
        if (W != -1) {
            iVar.w(X(str, i3, j3, W, appInterface));
        }
    }

    private void d0(String str, List<msg_comm$Msg> list, boolean z16, int i3) {
        if (!z16 && ConversationInfoErrorReporter.reportPublicaccoutTypeError(str, i3)) {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("reportPublicaccoutTypeError");
            sb5.append(" uin :");
            sb5.append(str);
            sb5.append(" type :");
            sb5.append(i3);
            if (list != null && list.size() > 0) {
                msg_comm$Msg msg_comm_msg = list.get(0);
                if (msg_comm_msg.msg_head.has()) {
                    msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
                    sb5.append(" msgType :");
                    sb5.append(msg_comm_msghead.msg_type.get());
                    sb5.append(" msgSeq :");
                    sb5.append(msg_comm_msghead.msg_seq.get());
                    sb5.append(" msgUid :");
                    sb5.append(msg_comm_msghead.msg_uid.get());
                    sb5.append(" msgTime :");
                    sb5.append(msg_comm_msghead.msg_time.get());
                    if (msg_comm_msghead.c2c_tmp_msg_head.has()) {
                        msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead = msg_comm_msghead.c2c_tmp_msg_head.get();
                        sb5.append(" serviceType :");
                        sb5.append(msg_comm_c2ctmpmsghead.service_type.get());
                        sb5.append(" c2cType :");
                        sb5.append(msg_comm_c2ctmpmsghead.c2c_type.get());
                    }
                }
            }
            QLog.e("Q.msg.C2CMessageProcessor", 1, sb5.toString());
        }
    }

    private static boolean e0(i.f fVar, MessageRecord messageRecord, boolean z16, MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg;
        int i3;
        boolean z17;
        if (messageForStructing != null && (absStructMsg = messageForStructing.structingMsg) != null && absStructMsg.mMsgServiceID == 128) {
            boolean z18 = false;
            try {
                i3 = Integer.parseInt(messageRecord.getExtInfoFromExtStr("key_message_extra_info_flag"));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                i3 = 0;
            }
            if ((i3 & 4) == 4) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                messageForStructing.setExtraFlag(32768);
                messageRecord.issend = 1;
                messageForStructing.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i3 & (-5)));
                fVar.f116687c = true;
                fVar.f116688d = messageForStructing.frienduin;
            }
            messageForStructing.isCheckNeedShowInListTypeMsg = true;
            int Z = Z(fVar.f116685a);
            if (Z == 1) {
                z18 = true;
            }
            messageForStructing.needNeedShowInList = z18;
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster isCheckNeedShowInListTypeMsg:" + messageForStructing.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + messageForStructing.needNeedShowInList + " uint32ShowInMsgList:" + Z);
            }
            return true;
        }
        return z16;
    }

    private void f0(String str, int i3, AppInterface appInterface) {
        Integer num = -1;
        ITempMsgBoxManager iTempMsgBoxManager = (ITempMsgBoxManager) appInterface.getRuntimeService(ITempMsgBoxManager.class, "");
        if (iTempMsgBoxManager.isBelongToMsgBox(str, i3)) {
            num = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getServiceIdMap().get(Integer.valueOf(i3));
        } else if (iTempMsgBoxManager.isBelongToFilterBox(str, i3)) {
            num = 10000;
        }
        if (num != null && num.intValue() >= 0) {
            ReportController.o(appInterface, "dc00898", "", "", "0X800B1C2", "0X800B1C2", num.intValue(), 0, "", "", "", "");
        }
    }

    private void g0(msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar, MessageRecord messageRecord) {
        int i3 = aVar.f286153h;
        if (i3 > 0) {
            messageRecord.saveExtInfoToExtStr(AppConstants.BubbleConfig.BUBBLE_SUB_ID, String.valueOf(i3));
        }
        int d16 = com.tencent.mobileqq.service.message.p.d(msg_comm_msg);
        if (d16 > 0) {
            messageRecord.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(d16));
        }
        int c16 = com.tencent.mobileqq.service.message.p.c(msg_comm_msg);
        if (c16 >= 0) {
            messageRecord.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(c16));
        }
        int b16 = com.tencent.mobileqq.service.message.p.b(msg_comm_msg);
        if (b16 >= 0) {
            messageRecord.saveExtInfoToExtStr("vip_face_id", String.valueOf(b16));
        }
    }

    private void h0(com.tencent.mobileqq.service.message.a aVar, MessageRecord messageRecord) {
        if (aVar.f286159n) {
            messageRecord.issend = 2;
            messageRecord.isread = true;
        } else {
            int i3 = messageRecord.msgtype;
            if (i3 != -2037 && i3 != -2009) {
                messageRecord.isread = aVar.f286154i;
            }
        }
        k0(aVar, messageRecord);
        l0(aVar, messageRecord);
    }

    private boolean i0(com.tencent.mobileqq.service.message.a aVar, MessageRecord messageRecord, AppInterface appInterface) {
        if (messageRecord == null) {
            return true;
        }
        long j3 = aVar.f286149d;
        if (j3 == AppConstants.OLD_KANDIAN_UIN_LONGVALUE || j3 == AppConstants.NEW_KANDIAN_UIN_LONGVALUE) {
            return true;
        }
        int i3 = aVar.f286163r;
        if ((i3 == 1025 || i3 == 1024) && messageRecord.msgtype == -1000 && messageRecord.f203106msg.startsWith("default:SigT=")) {
            return true;
        }
        return false;
    }

    private void j0(AppInterface appInterface) {
        ((com.tencent.mobileqq.app.message.n) ((BaseMessageHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_SYSTEM)).x0();
    }

    private void l0(com.tencent.mobileqq.service.message.a aVar, MessageRecord messageRecord) {
        if (!aVar.f286154i && TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("zplan_head_effect_msg_flag"))) {
            messageRecord.saveExtInfoToExtStr("zplan_head_effect_msg_flag", ZPlanHeadEffectFlag.NOT_READ.toString());
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void A(AppInterface appInterface, String str, C2CMsgReadedNotify c2CMsgReadedNotify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, appInterface, str, c2CMsgReadedNotify);
        } else {
            ed1.d.f(appInterface, str, c2CMsgReadedNotify);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void B(String str, long j3, int i3, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, Long.valueOf(j3), Integer.valueOf(i3), iVar);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void C(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) list);
        } else {
            BaseMessageHandlerUtils.blankMsgFilter(list);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void D(ArrayList<MessageRecord> arrayList, String str, boolean z16, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, arrayList, str, Boolean.valueOf(z16), iVar);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void E(ArrayList<MessageRecord> arrayList, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList, (Object) iVar);
        } else {
            ConfessMsgUtil.g(iVar.f116342a, arrayList);
        }
    }

    public void J(ArrayList<MessageRecord> arrayList, boolean z16, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        short s16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, arrayList, Boolean.valueOf(z16), iVar);
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            AppInterface d16 = iVar.d();
            if (UserguideActivity.G2(BaseApplicationImpl.getApplication(), d16.getCurrentAccountUin()) || !az.a(BaseApplicationImpl.getApplication().getApplicationContext(), d16)) {
                return;
            }
            Iterator<MessageRecord> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MessageRecord next = it.next();
                if (ao.q(next.istroop) && ao.B(next) && !ad.F(d16, next) && !next.isSend() && !next.isread) {
                    z17 = true;
                    break;
                }
            }
            if (z17) {
                Card r16 = ((FriendsManager) d16.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(d16.getCurrentAccountUin());
                if (r16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.C2CMessageProcessor", 2, "findFriendCardByUin card is null");
                    }
                } else {
                    s16 = r16.shGender;
                }
                boolean f16 = ((com.tencent.mobileqq.nearby.b) d16.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.MSGBOX, 2, "DealOneWayMessageNotify,gender:" + ((int) s16) + ",isGod:" + f16);
                }
                I();
            }
        }
    }

    public msg_svc$PbMsgReadedReportReq X(String str, int i3, long j3, long j16, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (msg_svc$PbMsgReadedReportReq) iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), appInterface);
        }
        msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
        if (i3 == 10007) {
            ed1.d.d(appInterface, msg_svc_pbmsgreadedreportreq, str, j3);
        } else if (i3 == 1046) {
            com.tencent.mobileqq.matchfriend.a.a(appInterface, msg_svc_pbmsgreadedreportreq, str, j3);
        } else {
            msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
            uinPairReadInfo.peer_uin.set(j16);
            uinPairReadInfo.last_read_time.set((int) j3);
            H(str, i3, uinPairReadInfo, appInterface);
            msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
            msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
            byte[] F0 = ((com.tencent.mobileqq.service.message.e) appInterface.getMsgCache()).F0();
            if (F0 != null) {
                msg_svc_pbc2creadedreportreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
            }
            msg_svc_pbmsgreadedreportreq.c2c_read_report.set(msg_svc_pbc2creadedreportreq);
        }
        return msg_svc_pbmsgreadedreportreq;
    }

    @Override // com.tencent.imcore.message.i.e
    public long a(AppInterface appInterface, long j3, long j16, long j17, msg_comm$UinPairMsg msg_comm_uinpairmsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), msg_comm_uinpairmsg)).longValue();
        }
        return MessageHandlerUtils.getPkgFriendUin(appInterface, j3, j16, msg_comm_uinpairmsg.peer_uin.get(), msg_comm_uinpairmsg);
    }

    @Override // com.tencent.imcore.message.i.e
    public String b(msg_comm$UinPairMsg msg_comm_uinpairmsg, AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, this, msg_comm_uinpairmsg, appInterface, Integer.valueOf(i3));
        }
        return ed1.d.b(msg_comm_uinpairmsg, appInterface, i3);
    }

    @Override // com.tencent.imcore.message.i.e
    public void c(String str, List<msg_comm$Msg> list, boolean z16, int i3, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, list, Boolean.valueOf(z16), Integer.valueOf(i3), iVar);
        } else {
            d0(str, list, z16, i3);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void d(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) appInterface, (Object) str);
        } else {
            com.tencent.mobileqq.service.message.c.b(appInterface, str);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void e(i iVar, ArrayList<MessageRecord> arrayList, long j3, long j16, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, iVar, arrayList, Long.valueOf(j3), Long.valueOf(j16), list, aVar);
        } else {
            new a(iVar, arrayList, j3, j16, list, aVar).f();
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public List<MessageRecord> f(String str, List<msg_comm$Msg> list, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, list, iVar);
        }
        return ((QQAppInterface) iVar.d()).getFileTransferHandler().O0(list, Long.valueOf(str).longValue(), true);
    }

    @Override // com.tencent.imcore.message.i.e
    public void g(String str, int i3, long j3, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), Long.valueOf(j3), iVar);
            return;
        }
        if (AppConstants.SYSTEM_MSG_UIN.equals(str)) {
            j0(iVar.f116342a);
        } else if (i3 == 1001 && (ao.w(str) || ao.A(str))) {
            b0(str, iVar.f116342a);
        } else {
            c0(str, i3, j3, iVar);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void h(String str, boolean z16, ArrayList<MessageRecord> arrayList, String str2, int i3, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16), arrayList, str2, Integer.valueOf(i3), iVar);
            return;
        }
        J(arrayList, z16, iVar);
        com.tencent.mobileqq.app.message.j.a(arrayList.get(0), iVar.f116342a);
        L(arrayList, i3, iVar.f116342a);
        f0(str2, i3, iVar.f116342a);
    }

    @Override // com.tencent.imcore.message.i.e
    public List<MessageRecord> i(String str, long j3, long j16, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (List) iPatchRedirector.redirect((short) 27, this, str, Long.valueOf(j3), Long.valueOf(j16), iVar);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.i.e
    public void j(ArrayList<MessageRecord> arrayList, i iVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, arrayList, iVar, str);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void k(msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.service.message.a aVar, long j3, ArrayList<MessageRecord> arrayList, msg_comm$MsgHead msg_comm_msghead, int i3, long j16, long j17, int i16, long j18, int i17, int i18, int i19, ArrayList<MessageRecord> arrayList2, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, msg_comm_msg, aVar, Long.valueOf(j3), arrayList, msg_comm_msghead, Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i16), Long.valueOf(j18), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), arrayList2, iVar);
            return;
        }
        AppInterface d16 = iVar.d();
        U(i18, arrayList2);
        K(msg_comm_msg, aVar, arrayList, msg_comm_msghead, i3, j16, j17, i16, j18, i17, i18, i19, arrayList2, Y(msg_comm_msg, -1L), d16);
        S(msg_comm_msg, aVar, arrayList);
        MsgAutoMonitorUtil.getInstance().addDecodeC2CMsgTime(System.currentTimeMillis() - j3);
        Iterator<MessageRecord> it = arrayList.iterator();
        int i26 = 0;
        int i27 = 0;
        while (it.hasNext()) {
            MessageRecord next = it.next();
            i27 = next.istroop;
            if (!next.isread) {
                i26++;
            }
        }
        com.tencent.mobileqq.statistics.d.a(0, 1, i27, i26);
    }

    protected void k0(com.tencent.mobileqq.service.message.a aVar, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) aVar, (Object) messageRecord);
            return;
        }
        if (messageRecord instanceof MessageForAniSticker) {
            MessageForAniSticker messageForAniSticker = (MessageForAniSticker) messageRecord;
            if (messageForAniSticker.isAniStickerRandom() && aVar.f286154i) {
                messageForAniSticker.setIsMsgRead(1);
            }
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public boolean l(MessageRecord messageRecord, i.f fVar, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, messageRecord, fVar, iVar)).booleanValue();
        }
        if (messageRecord instanceof MessageForStructing) {
            return e0(fVar, messageRecord, false, (MessageForStructing) messageRecord);
        }
        if (messageRecord.msgtype != -10000) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.imcore.message.i.e
    public String m(String str, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) iVar);
        }
        return ((IPhoneContactService) iVar.f116342a.getRuntimeService(IPhoneContactService.class, "")).getPhoneNumByUin(str);
    }

    @Override // com.tencent.imcore.message.i.e
    public void n(List<MessageRecord> list, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, list, toServiceMsg, fromServiceMsg);
        } else if (toServiceMsg.extraData.getBoolean(MessageHandlerConstants.KEY_FROM_PUSH_NOTIFY)) {
            com.tencent.mobileqq.statistics.tianjige.metrics.a.a(list, fromServiceMsg);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public long o(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        return SVIPHandlerConstants.mixedBubbleAndTextId(i3, i16);
    }

    @Override // com.tencent.imcore.message.i.e
    public long p(AppInterface appInterface, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17))).longValue();
        }
        return MessageHandlerUtils.getPkgFriendUin(appInterface, j3, j16, j17);
    }

    @Override // com.tencent.imcore.message.i.e
    public void q(int i3, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) iVar);
        } else {
            ((QQAppInterface) iVar.d()).userActiveStatus = i3;
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public int r(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this, (Object) iVar)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.imcore.message.i.e
    public void s(long j3, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), iVar);
        } else {
            ((FriendsManager) iVar.f116342a.getManager(QQManagerFactory.FRIENDS_MANAGER)).j(j3);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void t(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            com.tencent.mobileqq.app.message.j.c("actC2cDecodeCost", j3);
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public boolean u(MessageRecord messageRecord, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) messageRecord, (Object) iVar)).booleanValue();
        }
        if (!messageRecord.isSend() && !messageRecord.isread && ((!ao.B(messageRecord) || ad.F(iVar.f116342a, messageRecord)) && !FriendsStatusUtil.k(messageRecord.frienduin, iVar.f116342a) && AppletsFolderManager.r(messageRecord.frienduin) && ed1.d.g(messageRecord))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.i.e
    public void v(ArrayList<MessageRecord> arrayList, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList, (Object) iVar);
            return;
        }
        try {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPubAccMsg(arrayList);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        xx.b.INSTANCE.C(arrayList);
        a0(arrayList, iVar);
    }

    @Override // com.tencent.imcore.message.i.e
    public byte[] w(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (byte[]) iPatchRedirector.redirect((short) 26, (Object) this, (Object) iVar);
        }
        return new byte[0];
    }

    @Override // com.tencent.imcore.message.i.e
    public void x(List<MessageRecord> list, i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, (Object) iVar);
        } else {
            com.tencent.mobileqq.app.handler.c.b((ArrayList) list, true, iVar.d());
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void y(i iVar, msg_comm$UinPairMsg msg_comm_uinpairmsg, long j3, ArrayList<MessageRecord> arrayList, ArrayList<msg_comm$Msg> arrayList2, StringBuilder sb5, com.tencent.mobileqq.service.message.a aVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, iVar, msg_comm_uinpairmsg, Long.valueOf(j3), arrayList, arrayList2, sb5, aVar, Integer.valueOf(i3));
        } else {
            new q(iVar, msg_comm_uinpairmsg, j3, arrayList, arrayList2, sb5, aVar, i3).c();
        }
    }

    @Override // com.tencent.imcore.message.i.e
    public void z(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, i3);
            return;
        }
        ConversationInfoErrorReporter.reportTypeError(i3, "get Error pkgUinType: " + i3 + ", uin: " + str);
    }
}
