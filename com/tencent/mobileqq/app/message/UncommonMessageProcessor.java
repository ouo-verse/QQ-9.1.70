package com.tencent.mobileqq.app.message;

import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import msf.msgsvc.msg_svc$PbC2CMsgWithDrawReq;
import msf.msgsvc.msg_svc$PbC2CMsgWithDrawResp;
import msf.msgsvc.msg_svc$PbDelRoamMsgReq;
import msf.msgsvc.msg_svc$PbDelRoamMsgResp;
import msf.msgsvc.msg_svc$PbGroupMsgWithDrawReq;
import msf.msgsvc.msg_svc$PbGroupMsgWithDrawResp;
import msf.msgsvc.msg_svc$PbMsgWithDrawReq;
import msf.msgsvc.msg_svc$PbMsgWithDrawResp;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import msf.msgsvc.msg_svc$PbSendMsgResp;
import msf.msgsvc.msg_svc$RoutingHead;
import msg.blessing_helper.blessing_helper$msg;
import tencent.im.msgrevoke.msgrevoke_userdef$MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef$UinTypeUserDef;

/* loaded from: classes11.dex */
public class UncommonMessageProcessor extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    private EmojiStickerManager.d f195873v;

    /* renamed from: w, reason: collision with root package name */
    private final int f195874w;

    /* renamed from: x, reason: collision with root package name */
    private final int f195875x;

    /* renamed from: y, reason: collision with root package name */
    private final int f195876y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements BaseMessageProcessor.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MessageRecord f195877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ msg_svc$PbSendMsgReq f195878b;

        a(MessageRecord messageRecord, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq) {
            this.f195877a = messageRecord;
            this.f195878b = msg_svc_pbsendmsgreq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UncommonMessageProcessor.this, messageRecord, msg_svc_pbsendmsgreq);
            }
        }

        @Override // com.tencent.imcore.message.BaseMessageProcessor.c
        public ToServiceMsg a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ToServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ToServiceMsg createToServiceMsg = ((BaseMessageProcessor) UncommonMessageProcessor.this).f116343b.createToServiceMsg("MessageSvc.PbMultiMsgSend");
            createToServiceMsg.extraData.putLong("uniseq", this.f195877a.uniseq);
            createToServiceMsg.extraData.putInt(AppConstants.Key.COLUMN_MSG_TYPE, this.f195877a.msgtype);
            createToServiceMsg.extraData.putLong("key_msg_info_time_start", currentTimeMillis);
            createToServiceMsg.putWupBuffer(this.f195878b.toByteArray());
            createToServiceMsg.setTimeout(15000L);
            createToServiceMsg.setEnableFastResend(true);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.UncommonMessageProcessor", 2, "sendBlessMsg,  mr_uniseq:" + this.f195877a.uniseq + " msgSeq:" + this.f195877a.msgseq + " mr_shMsgseq:" + this.f195877a.shmsgseq + " mr_msgUid:" + this.f195877a.msgUid + " random:" + s.e(this.f195877a.msgUid));
            }
            return createToServiceMsg;
        }
    }

    public UncommonMessageProcessor(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
            return;
        }
        this.f195874w = 12;
        this.f195875x = 6;
        this.f195876y = 1080000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(MessageRecord messageRecord, long j3, long j16, int i3) {
        FileManagerEntity E;
        long currentTimeMillis = System.currentTimeMillis();
        int i16 = messageRecord.istroop;
        int g16 = s.g(messageRecord.msgUid);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><S>--->deleteMsgFromServerInner : uinType:" + messageRecord.istroop + " peerUin:" + messageRecord.frienduin + " msgType:" + messageRecord.msgtype + " uniseq:" + messageRecord.uniseq + " reqSeq:" + j3 + " msgSeq:" + messageRecord.shmsgseq + " random:" + g16 + " msgTime:" + messageRecord.time + " msgUid:" + messageRecord.msgUid + " mr.longMsgCount:" + messageRecord.longMsgCount + " longMsgIndex:" + messageRecord.longMsgIndex + " longMsgId:" + messageRecord.longMsgId);
        }
        if (messageRecord.frienduin == null) {
            QLog.d("Q.msg.UncommonMessageProcessor", 1, "deleteMsgFromServerInner error, istroop:", Integer.valueOf(messageRecord.istroop), " msgtype:", Integer.valueOf(messageRecord.msgtype));
            return;
        }
        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("PbMessageSvc.PbDelOneRoamMsg");
        createToServiceMsg.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, j16);
        createToServiceMsg.extraData.putLong("startTime", currentTimeMillis);
        createToServiceMsg.extraData.putInt("retryIndex", i3);
        createToServiceMsg.extraData.putInt("uintype", i16);
        createToServiceMsg.extraData.putString("peeruin", messageRecord.frienduin);
        createToServiceMsg.extraData.putLong("uniseq", messageRecord.uniseq);
        createToServiceMsg.extraData.putLong("seq", messageRecord.shmsgseq);
        createToServiceMsg.extraData.putLong("msgSeq", j3);
        msg_svc$PbDelRoamMsgReq msg_svc_pbdelroammsgreq = new msg_svc$PbDelRoamMsgReq();
        if (i16 != 0 && i16 != 1000 && i16 != 1004) {
            if (i16 == 1) {
                msg_svc$PbDelRoamMsgReq.GrpMsg grpMsg = new msg_svc$PbDelRoamMsgReq.GrpMsg();
                grpMsg.group_code.set(Long.valueOf(messageRecord.frienduin).longValue());
                grpMsg.msg_seq.set(Long.valueOf(messageRecord.shmsgseq).longValue());
                if ((messageRecord instanceof MessageForReplyText) && ((MessageForReplyText) messageRecord).isBarrageMsg) {
                    grpMsg.uint32_resv_flag.set(1);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.UncommonMessageProcessor", 2, "delete single msg, isBarrageMsg");
                    }
                }
                msg_svc_pbdelroammsgreq.grp_msg.set(grpMsg);
            } else if (i16 == 3000) {
                msg_svc$PbDelRoamMsgReq.DisMsg disMsg = new msg_svc$PbDelRoamMsgReq.DisMsg();
                disMsg.discuss_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
                disMsg.msg_seq.set(messageRecord.shmsgseq);
                msg_svc_pbdelroammsgreq.dis_msg.set(disMsg);
            }
        } else {
            createToServiceMsg.extraData.putInt("msgrandom", g16);
            String currentAccountUin = this.f116342a.getCurrentAccountUin();
            msg_svc$PbDelRoamMsgReq.C2CMsg c2CMsg = new msg_svc$PbDelRoamMsgReq.C2CMsg();
            c2CMsg.peer_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
            c2CMsg.from_uin.set(Long.valueOf(currentAccountUin).longValue());
            c2CMsg.msg_time.set((int) messageRecord.time);
            c2CMsg.msg_seq.set(((short) messageRecord.shmsgseq) & 65535);
            c2CMsg.msg_random.set(g16);
            msg_svc_pbdelroammsgreq.c2c_msg.set(c2CMsg);
            if (messageRecord.msgtype == -2005 && (E = ((QQAppInterface) this.f116342a).getFileManagerDataCenter().E(messageRecord.uniseq, messageRecord.frienduin, 0)) != null && E.nOLfileSessionId != 0) {
                c2CMsg.msg_time.set((int) E.msgTime);
                c2CMsg.msg_seq.set(((short) E.msgSeq) & (-1));
                c2CMsg.msg_random.set(s.g(E.msgUid));
            }
        }
        createToServiceMsg.putWupBuffer(msg_svc_pbdelroammsgreq.toByteArray());
        createToServiceMsg.setTimeout(j16);
        createToServiceMsg.setEnableFastResend(true);
        this.f116343b.sendPBReqWithRemindSlowNetwork(createToServiceMsg);
    }

    private void G(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3 = toServiceMsg.extraData.getLong("seq");
        long j16 = toServiceMsg.extraData.getLong("uniseq");
        long j17 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        int i3 = toServiceMsg.extraData.getInt("uintype");
        int i16 = toServiceMsg.extraData.getInt("msgrandom");
        String string = toServiceMsg.extraData.getString("peeruin");
        long j18 = toServiceMsg.extraData.getLong("msgSeq");
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><E><---handleDeleteMsgError : uinType :" + i3 + " uin:" + string + " seq:" + j3 + " uniseq:" + j16 + " random:" + i16 + " timeOut:" + j17 + " reqSeq:" + j18);
        }
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j18);
        if (handlerFromQueue != null) {
            if (fromServiceMsg.getResultCode() == 2901 && this.f116343b.retrySendMessage(handlerFromQueue, "msf")) {
                return;
            }
            if (1080000 == j17 || handlerFromQueue.c()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMsgError : Failed at last.");
                }
                this.f116343b.removeSendMessageHandler(j18);
            }
        }
    }

    private void H(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        msg_svc$PbDelRoamMsgResp msg_svc_pbdelroammsgresp;
        long j3 = toServiceMsg.extraData.getLong("seq");
        long j16 = toServiceMsg.extraData.getLong("uniseq");
        int i3 = toServiceMsg.extraData.getInt("uintype");
        int i16 = toServiceMsg.extraData.getInt("msgrandom");
        String string = toServiceMsg.extraData.getString("peeruin");
        long j17 = toServiceMsg.extraData.getLong("msgSeq");
        long f16 = s.f(i16);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><R><---handleDeleteMsgResp : uinType :" + i3 + " uin:" + string + " seq:" + j3 + " uniseq:" + j16 + " msgUid:" + f16 + " random:" + i16 + " reqSeq:" + j17);
        }
        try {
            msg_svc_pbdelroammsgresp = new msg_svc$PbDelRoamMsgResp().mergeFrom((byte[]) obj);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMsgResp : ParseFrom PbDelRoamMsgResp Error.");
            }
            msg_svc_pbdelroammsgresp = null;
        }
        this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j17);
        if (handlerFromQueue == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><R><---handleSendC2CMessageResp_PB : ---cmd:" + fromServiceMsg.getServiceCmd() + ",no SendMessageHandler found.");
                return;
            }
            return;
        }
        if (msg_svc_pbdelroammsgresp != null && msg_svc_pbdelroammsgresp.result.has()) {
            int i17 = msg_svc_pbdelroammsgresp.result.get();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.UncommonMessageProcessor", 2, "<DELMSG><R><---handleDeleteMsgResp : result :" + i17);
            }
            if (i17 != 17 && i17 != -102 && i17 != 255) {
                this.f116343b.removeSendMessageHandler(j17);
            } else {
                this.f116343b.retrySendMessage(handlerFromQueue, "server");
            }
        }
    }

    private void I(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        int i3 = toServiceMsg.extraData.getInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ");
        if (i3 == 1) {
            ArrayList<? extends Parcelable> parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("key_msg_info_revoke");
            String str = ((RevokeMsgInfo) parcelableArrayList.get(0)).f281288f;
            int i16 = ((RevokeMsgInfo) parcelableArrayList.get(0)).f281286d;
            long j16 = ((RevokeMsgInfo) parcelableArrayList.get(0)).f281291m;
            long j17 = ((RevokeMsgInfo) parcelableArrayList.get(0)).f281287e;
            long j18 = ((RevokeMsgInfo) parcelableArrayList.get(0)).C;
            int resultCode = fromServiceMsg.getResultCode();
            if (resultCode == 2901) {
                j3 = j17;
                long timeout = toServiceMsg.getTimeout() - (System.currentTimeMillis() - toServiceMsg.extraData.getLong("key_msg_info_time_start", 0L));
                if (QLog.isColorLevel()) {
                    QLog.d("revokeMsg", 2, "handleRevokeMsgError, 2901 error, resend timeout: " + timeout);
                }
                if (timeout > 0) {
                    ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("PbMessageSvc.PbMsgWithDraw");
                    createToServiceMsg.setTimeout(timeout);
                    createToServiceMsg.putWupBuffer(toServiceMsg.getWupBuffer());
                    createToServiceMsg.extraData.putLong("key_msg_info_time_start", System.currentTimeMillis());
                    createToServiceMsg.extraData.putParcelableArrayList("key_msg_info_revoke", parcelableArrayList);
                    createToServiceMsg.extraData.putInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ", 1);
                    createToServiceMsg.setEnableFastResend(true);
                    this.f116343b.sendPBReqWithRemindSlowNetwork(createToServiceMsg);
                    return;
                }
            } else {
                j3 = j17;
            }
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, String.format("handleRevokeMsgError,frienduin %s, istroop %s, msgUid %s, time %s, shmsgseq %s", str, Integer.valueOf(i16), Long.valueOf(j16), Long.valueOf(j18), Long.valueOf(j3)));
            }
            P(str, i16, BaseMessageProcessor.f116328h, resultCode);
            return;
        }
        if (i3 == 2) {
            long j19 = toServiceMsg.extraData.getLong("msgSeq");
            long j26 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
            this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
            SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j19);
            if (handlerFromQueue != null) {
                if (fromServiceMsg.getResultCode() == 2901 && this.f116343b.retrySendMessage(handlerFromQueue, "msf")) {
                    return;
                }
                if (1080000 == j26 || handlerFromQueue.c()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleMultiDeleteMsgError : Failed at last.");
                    }
                    this.f116343b.removeSendMessageHandler(j19);
                }
            }
        }
    }

    private void J(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        List<msg_svc$PbGroupMsgWithDrawResp> list;
        boolean z16;
        int i3;
        List<msg_svc$PbGroupMsgWithDrawResp.MessageResult> list2;
        String str;
        List<msg_svc$PbC2CMsgWithDrawResp> list3;
        String str2;
        char c16;
        List<msg_svc$PbGroupMsgWithDrawResp> list4;
        boolean z17;
        boolean z18;
        int i16 = toServiceMsg.extraData.getInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ");
        if (i16 == 2) {
            long j3 = toServiceMsg.extraData.getLong("msgSeq");
            try {
                msg_svc$PbMsgWithDrawResp mergeFrom = new msg_svc$PbMsgWithDrawResp().mergeFrom((byte[]) obj);
                if (mergeFrom.c2c_with_draw.has()) {
                    List<msg_svc$PbC2CMsgWithDrawResp> list5 = mergeFrom.c2c_with_draw.get();
                    if (list5 != null && !list5.isEmpty()) {
                        z17 = true;
                        for (msg_svc$PbC2CMsgWithDrawResp msg_svc_pbc2cmsgwithdrawresp : list5) {
                            int i17 = msg_svc_pbc2cmsgwithdrawresp.result.get();
                            SendMessageHandler handlerFromQueue = this.f116343b.getHandlerFromQueue(j3);
                            this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
                            if (i17 == 255) {
                                this.f116343b.retrySendMessage(handlerFromQueue, "server");
                                z17 = false;
                            }
                            String str3 = msg_svc_pbc2cmsgwithdrawresp.errmsg.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("revokeMsg", 2, String.format("handleDeleteMultiMsgResp,result: %s, errorMsg: %s", Integer.valueOf(i17), str3));
                            }
                        }
                        z18 = z17;
                    }
                    z18 = true;
                } else {
                    if (mergeFrom.group_with_draw.has() && (list4 = mergeFrom.group_with_draw.get()) != null && !list4.isEmpty()) {
                        z17 = true;
                        for (msg_svc$PbGroupMsgWithDrawResp msg_svc_pbgroupmsgwithdrawresp : list4) {
                            int i18 = msg_svc_pbgroupmsgwithdrawresp.result.get();
                            this.f116343b.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
                            SendMessageHandler handlerFromQueue2 = this.f116343b.getHandlerFromQueue(j3);
                            if (i18 == 255) {
                                this.f116343b.retrySendMessage(handlerFromQueue2, "server");
                                z17 = false;
                            }
                            String str4 = msg_svc_pbgroupmsgwithdrawresp.errmsg.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("revokeMsg", 2, String.format("handleDeleteMultiMsgResp,result: %s, errorMsg: %s", Integer.valueOf(i18), str4));
                            }
                        }
                        z18 = z17;
                    }
                    z18 = true;
                }
                if (z18) {
                    this.f116343b.removeSendMessageHandler(j3);
                    return;
                }
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMultiMsgResp : ParseFrom PbMsgWithDrawResp Error.");
                }
                this.f116343b.removeSendMessageHandler(j3);
                return;
            }
        }
        if (i16 == 1) {
            ArrayList<RevokeMsgInfo> parcelableArrayList = toServiceMsg.extraData.getParcelableArrayList("key_msg_info_revoke");
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                int i19 = parcelableArrayList.get(0).f281286d;
                if (QLog.isColorLevel()) {
                    Iterator<RevokeMsgInfo> it = parcelableArrayList.iterator();
                    while (it.hasNext()) {
                        QLog.d("revokeMsg", 2, "handleRevokeMsgResp," + it.next().toString());
                    }
                }
                try {
                    msg_svc$PbMsgWithDrawResp mergeFrom2 = new msg_svc$PbMsgWithDrawResp().mergeFrom((byte[]) obj);
                    String str5 = null;
                    if (mergeFrom2.c2c_with_draw.has() && (list3 = mergeFrom2.c2c_with_draw.get()) != null && !list3.isEmpty() && list3.get(0).uint32_sub_cmd.get() == 1) {
                        msg_svc$PbC2CMsgWithDrawResp msg_svc_pbc2cmsgwithdrawresp2 = list3.get(0);
                        if (msg_svc_pbc2cmsgwithdrawresp2.msg_wording_info.has()) {
                            T(parcelableArrayList, msg_svc_pbc2cmsgwithdrawresp2.msg_wording_info.int32_item_id.get(), msg_svc_pbc2cmsgwithdrawresp2.msg_wording_info.string_item_name.get());
                        }
                        for (msg_svc$PbC2CMsgWithDrawResp msg_svc_pbc2cmsgwithdrawresp3 : list3) {
                            int i26 = msg_svc_pbc2cmsgwithdrawresp3.result.get();
                            if (i26 >= 0 && i26 <= 1000) {
                                ((QQAppInterface) this.f116342a).getMessageFacade().a2(parcelableArrayList);
                                str2 = str5;
                                c16 = 0;
                            } else {
                                str2 = msg_svc_pbc2cmsgwithdrawresp3.errmsg.get();
                                c16 = 0;
                                P(parcelableArrayList.get(0).f281288f, i19, BaseMessageProcessor.f116327g, i26);
                            }
                            if (QLog.isColorLevel()) {
                                Object[] objArr = new Object[2];
                                objArr[c16] = Integer.valueOf(i26);
                                objArr[1] = str2;
                                QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp,result: %s, errorMsg: %s", objArr));
                            }
                            str5 = str2;
                        }
                        return;
                    }
                    if (mergeFrom2.group_with_draw.has() && (list = mergeFrom2.group_with_draw.get()) != null && !list.isEmpty() && list.get(0).uint32_sub_cmd.get() == 1) {
                        msg_svc$PbGroupMsgWithDrawResp msg_svc_pbgroupmsgwithdrawresp2 = list.get(0);
                        if (msg_svc_pbgroupmsgwithdrawresp2.msg_wording_info.has()) {
                            T(parcelableArrayList, msg_svc_pbgroupmsgwithdrawresp2.msg_wording_info.int32_item_id.get(), msg_svc_pbgroupmsgwithdrawresp2.msg_wording_info.string_item_name.get());
                        }
                        for (msg_svc$PbGroupMsgWithDrawResp msg_svc_pbgroupmsgwithdrawresp3 : list) {
                            int i27 = msg_svc_pbgroupmsgwithdrawresp3.result.get();
                            if (i27 != 0 && i27 != 1002 && i27 != 1004 && i27 != 1006) {
                                if (msg_svc_pbgroupmsgwithdrawresp3.failed_msg_list.has() && (list2 = msg_svc_pbgroupmsgwithdrawresp3.failed_msg_list.get()) != null && !list2.isEmpty()) {
                                    int i28 = 0;
                                    i3 = 0;
                                    for (msg_svc$PbGroupMsgWithDrawResp.MessageResult messageResult : list2) {
                                        int i29 = messageResult.uint32_result.get();
                                        int i36 = messageResult.uint32_msg_seq.get();
                                        try {
                                            str = messageResult.bytes_err_msg.get().toStringUtf8();
                                        } catch (Exception unused2) {
                                            str = "";
                                        }
                                        if (i29 == 4) {
                                            i28++;
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp, more failInfo, shmsgseq: %s, result: %s, errorMsg: %s", Integer.valueOf(i36), Integer.valueOf(i29), str));
                                        }
                                        i3 = i29;
                                    }
                                    if (i28 == list2.size()) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                } else {
                                    z16 = false;
                                    i3 = 0;
                                }
                                if (z16) {
                                    ((QQAppInterface) this.f116342a).getMessageFacade().a2(parcelableArrayList);
                                } else {
                                    String str6 = msg_svc_pbgroupmsgwithdrawresp3.errmsg.get();
                                    P(parcelableArrayList.get(0).f281288f, i19, BaseMessageProcessor.f116327g, i3);
                                    str5 = str6;
                                }
                            } else {
                                ((QQAppInterface) this.f116342a).getMessageFacade().a2(parcelableArrayList);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp,result: %s, errorMsg: %s", Integer.valueOf(i27), str5));
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception unused3) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleRevokeMsgResp : ParseFrom PbMsgWithDrawResp Error.");
                    }
                    P(parcelableArrayList.get(0).f281288f, i19, BaseMessageProcessor.f116327g, BaseMessageProcessor.f116338r);
                    return;
                }
            }
            P(" ", 0, BaseMessageProcessor.f116327g, BaseMessageProcessor.f116337q);
        }
    }

    private void K(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        long j3 = toServiceMsg.extraData.getLong("uniseq");
        long j16 = toServiceMsg.extraData.getLong("msgSeq");
        int i3 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        boolean z16 = toServiceMsg.extraData.getBoolean(com.tencent.mobileqq.service.message.i.f286265h);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageError: ---cmd:" + serviceCmd + " uniseq:" + j3 + " msgSeq:" + j16 + " msgType:" + i3 + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + " isRedBagVideo:" + z16);
        }
        int resultCode = fromServiceMsg.getResultCode();
        long j17 = 0;
        if (resultCode == 2901) {
            long timeout = toServiceMsg.getTimeout() - (System.currentTimeMillis() - toServiceMsg.extraData.getLong("key_msg_info_time_start", 0L));
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.UncommonMessageProcessor", 2, "handleSendBlessMessageError, 2901 error, resend timeout: " + timeout);
                j17 = 0;
            }
            if (timeout > j17) {
                ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("MessageSvc.PbMultiMsgSend");
                createToServiceMsg.extraData.putLong("uniseq", j3);
                createToServiceMsg.extraData.putInt(AppConstants.Key.COLUMN_MSG_TYPE, i3);
                createToServiceMsg.extraData.putLong("key_msg_info_time_start", System.currentTimeMillis());
                createToServiceMsg.setTimeout(timeout);
                createToServiceMsg.putWupBuffer(toServiceMsg.getWupBuffer());
                createToServiceMsg.setEnableFastResend(true);
                this.f116343b.sendPBReqWithRemindSlowNetwork(createToServiceMsg);
                return;
            }
        }
        this.f116343b.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_MSG, false, new Object[]{Integer.valueOf(resultCode), 0L, Boolean.FALSE});
    }

    private void L(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp;
        String arrays;
        int i3;
        boolean z16;
        UncommonMessageProcessor uncommonMessageProcessor;
        long j3 = toServiceMsg.extraData.getLong("uniseq");
        long j16 = toServiceMsg.extraData.getLong("msgSeq");
        int i16 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        boolean z17 = toServiceMsg.extraData.getBoolean(com.tencent.mobileqq.service.message.i.f286265h);
        try {
            msg_svc_pbsendmsgresp = new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageResp : invalid.", e16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<---handleSendBlessMessageResp : data:");
                if (obj == null) {
                    arrays = "null";
                } else {
                    arrays = Arrays.toString((byte[]) obj);
                }
                sb5.append(arrays);
                QLog.e("Q.msg.UncommonMessageProcessor", 2, sb5.toString());
            }
            msg_svc_pbsendmsgresp = new msg_svc$PbSendMsgResp();
        }
        if (msg_svc_pbsendmsgresp != null && msg_svc_pbsendmsgresp.result.has()) {
            if (msg_svc_pbsendmsgresp.result.get() != 0) {
                i3 = msg_svc_pbsendmsgresp.result.get();
            } else {
                i3 = 0;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageResp : server did not return a valid result code, use 4 instead.");
            }
            i3 = 4;
        }
        long j17 = 0;
        if (i3 != 0 && i3 != 241) {
            if (i3 == 67) {
                j17 = msg_svc_pbsendmsgresp.uint32_svrbusy_wait_time.get();
            }
            uncommonMessageProcessor = this;
            z16 = false;
        } else {
            z16 = true;
            uncommonMessageProcessor = this;
        }
        uncommonMessageProcessor.f116343b.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_MSG, z16, new Object[]{Integer.valueOf(i3), Long.valueOf(j17), Boolean.valueOf(z17)});
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("<---handleSendBlessMessageResp : ----replyCode: %d isSuc: %s uniseq: %d msgSeq: %d msgType: %d waitTime: %d ssoseq: %d  appseq: %d isRedBagVideo:%s", Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Long.valueOf(j17), Integer.valueOf(fromServiceMsg.getRequestSsoSeq()), Integer.valueOf(fromServiceMsg.getAppSeq()), Boolean.valueOf(z17)));
        }
    }

    private void M(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3 = toServiceMsg.extraData.getLong("bless_sendreq_time");
        this.f116343b.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK, false, new Object[]{0});
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckError, time: %d", Long.valueOf(j3)));
        }
    }

    private void N(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        long j3 = toServiceMsg.extraData.getLong("bless_sendreq_time");
        try {
            i3 = new blessing_helper$msg().mergeFrom((byte[]) obj).result.get();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckResp, parse data error", new Object[0]));
            }
            i3 = -1;
        }
        BaseMessageHandler baseMessageHandler = this.f116343b;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        baseMessageHandler.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK, z16, new Object[]{Integer.valueOf(i3)});
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckResp, time: %d, result: %d", Long.valueOf(j3), Integer.valueOf(i3)));
        }
    }

    public static void R(String str, int i3, int i16, int i17) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pm_uin", str);
        hashMap.put("pm_uinType", String.valueOf(i3));
        hashMap.put("pm_errorType", String.valueOf(i16));
        hashMap.put("pm_errorSubType", String.valueOf(i17));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), StatisticCollector.REVOKE_MSG_ERROR_TAG, false, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("Statistics TAG:%s, uin:%s, uinType:%d, errorType:%d, errorSubType:%d", StatisticCollector.REVOKE_MSG_ERROR_TAG, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)));
        }
    }

    private void T(ArrayList<RevokeMsgInfo> arrayList, int i3, String str) {
        Iterator<RevokeMsgInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            RevokeMsgInfo next = it.next();
            next.L = i3;
            next.M = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x047c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ToServiceMsg C(List<MessageRecord> list, int i3) {
        int i16;
        String str;
        long j3;
        msg_svc$PbC2CMsgWithDrawReq msg_svc_pbc2cmsgwithdrawreq;
        String str2;
        String str3;
        msg_svc$PbGroupMsgWithDrawReq msg_svc_pbgroupmsgwithdrawreq;
        int i17;
        Iterator<MessageRecord> it;
        int i18;
        String str4;
        int i19 = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list, i19);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        MessageRecord messageRecord = list.get(0);
        if (i19 == 1 && !messageRecord.isSend()) {
            AppInterface appInterface = this.f116342a;
            if (!TroopUtils.A((QQAppInterface) appInterface, messageRecord, appInterface.getCurrentAccountUin())) {
                QLog.e("revokeMsg", 1, "buildRevokeOrDeleteMultiMsgReq error, msg not send");
                P(messageRecord.frienduin, messageRecord.istroop, BaseMessageProcessor.f116330j, BaseMessageProcessor.f116339s);
                return null;
            }
        }
        boolean isLongMsg = messageRecord.isLongMsg();
        int i26 = messageRecord.istroop;
        if (i26 == 1000) {
            i16 = 1;
        } else if (i26 == 1004) {
            i16 = 2;
        } else {
            i16 = 0;
        }
        if (i19 == 1) {
            str = "sendRevokeMsgReq";
        } else if (i19 == 2) {
            str = "sendDeleteMultiMsgReq";
        } else {
            str = "";
        }
        String str5 = str;
        ArrayList arrayList2 = new ArrayList();
        String str6 = "Q.msg.UncommonMessageProcessor";
        if (i26 != 0) {
            if (i26 != 1) {
                if (i26 != 1000 && i26 != 1004) {
                    if (i26 != 3000) {
                        j3 = currentTimeMillis;
                        msg_svc_pbc2cmsgwithdrawreq = null;
                        msg_svc_pbgroupmsgwithdrawreq = null;
                        msg_svc$PbMsgWithDrawReq msg_svc_pbmsgwithdrawreq = new msg_svc$PbMsgWithDrawReq();
                        if (msg_svc_pbc2cmsgwithdrawreq != null) {
                            msg_svc_pbmsgwithdrawreq.c2c_with_draw.add(msg_svc_pbc2cmsgwithdrawreq);
                        }
                        if (msg_svc_pbgroupmsgwithdrawreq != null) {
                            msg_svc_pbmsgwithdrawreq.group_with_draw.add(msg_svc_pbgroupmsgwithdrawreq);
                        }
                        ToServiceMsg createToServiceMsg = this.f116343b.createToServiceMsg("PbMessageSvc.PbMsgWithDraw");
                        createToServiceMsg.putWupBuffer(msg_svc_pbmsgwithdrawreq.toByteArray());
                        createToServiceMsg.extraData.putLong("key_msg_info_time_start", j3);
                        createToServiceMsg.extraData.putParcelableArrayList("key_msg_info_revoke", arrayList);
                        createToServiceMsg.extraData.putInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ", i3);
                        createToServiceMsg.setEnableFastResend(true);
                        return createToServiceMsg;
                    }
                }
            }
            msg_svc_pbgroupmsgwithdrawreq = new msg_svc$PbGroupMsgWithDrawReq();
            for (Iterator<MessageRecord> it5 = list.iterator(); it5.hasNext(); it5 = it) {
                MessageRecord next = it5.next();
                boolean z16 = isLongMsg;
                int i27 = ((int) next.shmsgseq) & (-1);
                long j16 = currentTimeMillis;
                int g16 = s.g(next.msgUid);
                msg_svc$PbGroupMsgWithDrawReq.MessageInfo messageInfo = new msg_svc$PbGroupMsgWithDrawReq.MessageInfo();
                messageInfo.uint32_msg_seq.set(i27);
                messageInfo.uint32_msg_random.set(g16);
                if (next.msgtype == -2005) {
                    it = it5;
                    FileManagerEntity E = ((QQAppInterface) this.f116342a).getFileManagerDataCenter().E(next.uniseq, next.frienduin, next.istroop);
                    if (E != null && !TextUtils.isEmpty(E.Uuid)) {
                        arrayList2.add(E.Uuid);
                    }
                    i18 = 1;
                    messageInfo.uint32_msg_type.set(1);
                } else {
                    it = it5;
                    i18 = 1;
                }
                if ((next instanceof MessageForReplyText) && ((MessageForReplyText) next).isBarrageMsg) {
                    messageInfo.uint32_resv_flag.set(i18);
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[2];
                        if (i19 == i18) {
                            str4 = "revoke";
                        } else {
                            str4 = "delete";
                        }
                        objArr[0] = str4;
                        objArr[i18] = " msg, isBarrageMsg";
                        QLog.d("Q.msg.UncommonMessageProcessor", 2, objArr);
                    }
                }
                msg_svc_pbgroupmsgwithdrawreq.msg_list.add(messageInfo);
                RevokeMsgInfo revokeMsgInfo = new RevokeMsgInfo(next);
                revokeMsgInfo.I = 0;
                revokeMsgInfo.f281289h = this.f116342a.getCurrentAccountUin();
                if (i26 == 1) {
                    if (!TextUtils.equals(this.f116342a.getCurrentAccountUin(), next.senderuin)) {
                        AppInterface appInterface2 = this.f116342a;
                        if (TroopUtils.B((QQAppInterface) appInterface2, next.frienduin, appInterface2.getCurrentAccountUin())) {
                            revokeMsgInfo.I = 2;
                        } else {
                            ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
                            AppInterface appInterface3 = this.f116342a;
                            if (iTroopUtilsApi.isTroopAdmin(appInterface3, next.frienduin, appInterface3.getCurrentAccountUin())) {
                                revokeMsgInfo.I = 1;
                            }
                        }
                    }
                    revokeMsgInfo.J = com.tencent.biz.anonymous.a.m(next) ? 1 : 0;
                }
                arrayList.add(revokeMsgInfo);
                if (QLog.isColorLevel()) {
                    QLog.d("revokeMsg", 2, String.format(str5 + ",istroop %s, frienduin %s, shmsgseq %s", Integer.valueOf(next.istroop), next.frienduin, Long.valueOf(next.shmsgseq)));
                }
                isLongMsg = z16;
                currentTimeMillis = j16;
            }
            j3 = currentTimeMillis;
            boolean z17 = isLongMsg;
            msg_svc_pbgroupmsgwithdrawreq.uint32_sub_cmd.set(i19);
            if (i26 == 1) {
                i17 = 0;
                msg_svc_pbgroupmsgwithdrawreq.uint32_group_type.set(0);
            } else {
                i17 = 0;
                if (i26 == 3000) {
                    msg_svc_pbgroupmsgwithdrawreq.uint32_group_type.set(1);
                }
            }
            msg_svc_pbgroupmsgwithdrawreq.uint64_group_code.set(Long.valueOf(list.get(i17).frienduin).longValue());
            msgrevoke_userdef$MsgInfoUserDef msgrevoke_userdef_msginfouserdef = new msgrevoke_userdef$MsgInfoUserDef();
            if (arrayList2.size() > 0) {
                msgrevoke_userdef_msginfouserdef.str_file_uuid.addAll(arrayList2);
            }
            if (i19 == 1) {
                if (!z17) {
                    msgrevoke_userdef_msginfouserdef.uint32_long_message_flag.set(0);
                } else {
                    msgrevoke_userdef_msginfouserdef.uint32_long_message_flag.set(1);
                    for (MessageRecord messageRecord2 : list) {
                        int i28 = ((int) messageRecord2.shmsgseq) & (-1);
                        msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef msgInfoDef = new msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef();
                        msgInfoDef.uint32_msg_seq.set(i28);
                        msgInfoDef.long_msg_id.set(messageRecord2.longMsgId);
                        msgInfoDef.long_msg_num.set(messageRecord2.longMsgCount);
                        msgInfoDef.long_msg_index.set(messageRecord2.longMsgIndex);
                        msgrevoke_userdef_msginfouserdef.long_msg_info.add(msgInfoDef);
                    }
                }
            } else if (i19 == 2) {
                for (MessageRecord messageRecord3 : list) {
                    int i29 = ((int) messageRecord3.shmsgseq) & (-1);
                    msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef msgInfoDef2 = new msgrevoke_userdef$MsgInfoUserDef.MsgInfoDef();
                    msgInfoDef2.uint32_msg_seq.set(i29);
                    if (messageRecord3.isLongMsg()) {
                        msgInfoDef2.long_msg_id.set(messageRecord3.longMsgId);
                        msgInfoDef2.long_msg_num.set(messageRecord3.longMsgCount);
                        msgInfoDef2.long_msg_index.set(messageRecord3.longMsgIndex);
                    }
                    msgrevoke_userdef_msginfouserdef.long_msg_info.add(msgInfoDef2);
                }
            }
            msg_svc_pbgroupmsgwithdrawreq.bytes_userdef.set(ByteStringMicro.copyFrom(msgrevoke_userdef_msginfouserdef.toByteArray()));
            msg_svc_pbc2cmsgwithdrawreq = null;
            msg_svc$PbMsgWithDrawReq msg_svc_pbmsgwithdrawreq2 = new msg_svc$PbMsgWithDrawReq();
            if (msg_svc_pbc2cmsgwithdrawreq != null) {
            }
            if (msg_svc_pbgroupmsgwithdrawreq != null) {
            }
            ToServiceMsg createToServiceMsg2 = this.f116343b.createToServiceMsg("PbMessageSvc.PbMsgWithDraw");
            createToServiceMsg2.putWupBuffer(msg_svc_pbmsgwithdrawreq2.toByteArray());
            createToServiceMsg2.extraData.putLong("key_msg_info_time_start", j3);
            createToServiceMsg2.extraData.putParcelableArrayList("key_msg_info_revoke", arrayList);
            createToServiceMsg2.extraData.putInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ", i3);
            createToServiceMsg2.setEnableFastResend(true);
            return createToServiceMsg2;
        }
        j3 = currentTimeMillis;
        msg_svc$PbC2CMsgWithDrawReq msg_svc_pbc2cmsgwithdrawreq2 = new msg_svc$PbC2CMsgWithDrawReq();
        msg_svc_pbc2cmsgwithdrawreq2.uint32_sub_cmd.set(i19);
        Iterator<MessageRecord> it6 = list.iterator();
        while (it6.hasNext()) {
            MessageRecord next2 = it6.next();
            int i36 = ((short) next2.shmsgseq) & 65535;
            String str7 = str6;
            int g17 = s.g(next2.msgUid);
            msg_svc$PbC2CMsgWithDrawReq.MsgInfo msgInfo = new msg_svc$PbC2CMsgWithDrawReq.MsgInfo();
            Iterator<MessageRecord> it7 = it6;
            if (i19 == 1 && i26 == 0) {
                str2 = next2.senderuin;
            } else {
                str2 = next2.selfuin;
            }
            int i37 = i26;
            try {
                msgInfo.uint64_from_uin.set(Long.valueOf(str2).longValue());
                str3 = str7;
                try {
                    msgInfo.uint64_to_uin.set(Long.valueOf(next2.frienduin).longValue());
                    msgInfo.uint32_msg_seq.set(i36);
                    msgInfo.uint64_msg_uid.set(next2.msgUid);
                    msgInfo.uint64_msg_time.set(next2.time);
                    msgInfo.uint32_msg_random.set(g17);
                    if (next2.isLongMsg()) {
                        msgInfo.uint32_div_seq.set(next2.longMsgId);
                        msgInfo.uint32_pkg_num.set(next2.longMsgCount);
                        msgInfo.uint32_pkg_index.set(next2.longMsgIndex);
                    }
                    if (next2.msgtype == -2005) {
                        FileManagerEntity E2 = ((QQAppInterface) this.f116342a).getFileManagerDataCenter().E(next2.uniseq, next2.frienduin, next2.istroop);
                        if (E2 != null && !TextUtils.isEmpty(E2.Uuid)) {
                            arrayList2.add(E2.Uuid);
                        }
                        msgInfo.uint32_msg_type.set(1);
                    }
                    msg_svc$RoutingHead msg_svc_routinghead = new msg_svc$RoutingHead();
                    if (com.tencent.mobileqq.service.message.p.L((QQAppInterface) this.f116342a, next2, msg_svc_routinghead)) {
                        msgInfo.routing_head.set(msg_svc_routinghead);
                    }
                    msg_svc_pbc2cmsgwithdrawreq2.msg_info.add(msgInfo);
                    RevokeMsgInfo revokeMsgInfo2 = new RevokeMsgInfo(next2);
                    revokeMsgInfo2.f281289h = this.f116342a.getCurrentAccountUin();
                    arrayList.add(revokeMsgInfo2);
                    if (QLog.isColorLevel()) {
                        QLog.d("revokeMsg", 2, String.format(str5 + ",istroop %s, frienduin %s, shmsgseq %s, time %s, random %s, uid %s", Integer.valueOf(next2.istroop), next2.frienduin, Long.valueOf(next2.shmsgseq), Long.valueOf(next2.time), Integer.valueOf(g17), Long.valueOf(next2.msgUid)));
                    }
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(str3, 1, "build revoke request error", e);
                    i19 = i3;
                    str6 = str3;
                    it6 = it7;
                    i26 = i37;
                }
            } catch (Exception e17) {
                e = e17;
                str3 = str7;
            }
            i19 = i3;
            str6 = str3;
            it6 = it7;
            i26 = i37;
        }
        String str8 = str6;
        if (isLongMsg) {
            msg_svc_pbc2cmsgwithdrawreq2.uint32_long_message_flag.set(1);
        } else {
            msg_svc_pbc2cmsgwithdrawreq2.uint32_long_message_flag.set(0);
        }
        msgrevoke_userdef$UinTypeUserDef msgrevoke_userdef_uintypeuserdef = new msgrevoke_userdef$UinTypeUserDef();
        msgrevoke_userdef_uintypeuserdef.uint32_from_uin_type.set(i16);
        if (arrayList2.size() > 0) {
            msgrevoke_userdef_uintypeuserdef.str_file_uuid.addAll(arrayList2);
        }
        if (i16 == 1 || i16 == 2) {
            try {
                msgrevoke_userdef_uintypeuserdef.uint64_from_group_code.set(Long.valueOf(list.get(0).senderuin).longValue());
            } catch (Exception e18) {
                QLog.e(str8, 1, " convert exception:", e18);
            }
        }
        msg_svc_pbc2cmsgwithdrawreq2.bytes_reserved.set(ByteStringMicro.copyFrom(msgrevoke_userdef_uintypeuserdef.toByteArray()));
        msg_svc_pbc2cmsgwithdrawreq = msg_svc_pbc2cmsgwithdrawreq2;
        msg_svc_pbgroupmsgwithdrawreq = null;
        msg_svc$PbMsgWithDrawReq msg_svc_pbmsgwithdrawreq22 = new msg_svc$PbMsgWithDrawReq();
        if (msg_svc_pbc2cmsgwithdrawreq != null) {
        }
        if (msg_svc_pbgroupmsgwithdrawreq != null) {
        }
        ToServiceMsg createToServiceMsg22 = this.f116343b.createToServiceMsg("PbMessageSvc.PbMsgWithDraw");
        createToServiceMsg22.putWupBuffer(msg_svc_pbmsgwithdrawreq22.toByteArray());
        createToServiceMsg22.extraData.putLong("key_msg_info_time_start", j3);
        createToServiceMsg22.extraData.putParcelableArrayList("key_msg_info_revoke", arrayList);
        createToServiceMsg22.extraData.putInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ", i3);
        createToServiceMsg22.setEnableFastResend(true);
        return createToServiceMsg22;
    }

    public void D(MessageRecord messageRecord) {
        String str;
        int i3;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord != null && ((i3 = messageRecord.istroop) == 0 || i3 == 1 || i3 == 3000 || i3 == 1000 || i3 == 1004)) {
            if (!ad.B(messageRecord) && ao.C(messageRecord.msgtype)) {
                ArrayList arrayList = new ArrayList();
                if (messageRecord instanceof MessageForLongMsg) {
                    if (QLog.isColorLevel()) {
                        QLog.w("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : is long msg, sent from local, find the prepare slice to del.");
                    }
                    arrayList.addAll(((MessageForLongMsg) messageRecord).longMsgFragmentList);
                } else {
                    arrayList.add(messageRecord);
                }
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    MessageRecord messageRecord2 = (MessageRecord) arrayList.get(i16);
                    if (messageRecord2.isSendFromLocal()) {
                        int i17 = messageRecord.extraflag;
                        if (i17 == 32772) {
                            if (messageRecord.istroop == 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : delete a sending C2C msg, waitting for the response to complete.");
                                }
                                ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).Q(messageRecord);
                                return;
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.d("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : delete a sending group/dics msg, waitting for the push to complete.");
                                    return;
                                }
                                return;
                            }
                        }
                        if (i17 == 32768) {
                            return;
                        }
                    }
                    int i18 = MobileQQServiceBase.seq;
                    MobileQQServiceBase.seq = i18 + 1;
                    long j16 = i18;
                    SendMessageHandler sendMessageHandler = new SendMessageHandler();
                    this.f116343b.addToQueue(j16, sendMessageHandler);
                    for (int i19 = 0; i19 < 12; i19++) {
                        sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable(messageRecord2, j16) { // from class: com.tencent.mobileqq.app.message.UncommonMessageProcessor.3
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ MessageRecord G;
                            final /* synthetic */ long H;

                            {
                                this.G = messageRecord2;
                                this.H = j16;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, UncommonMessageProcessor.this, messageRecord2, Long.valueOf(j16));
                                }
                            }

                            @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                    UncommonMessageProcessor.this.E(this.G, this.H, this.f307281e, this.D);
                                } else {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                            }
                        });
                    }
                    int i26 = 0;
                    while (i26 < 6) {
                        int i27 = 6 - i26;
                        if (i26 == 0) {
                            j3 = 1080000;
                        } else {
                            j3 = ((i27 * 1080000) / 6) - (i26 * 2000);
                        }
                        sendMessageHandler.f((1080000 * i26) / 6, j3, "period");
                        i26++;
                        sendMessageHandler = sendMessageHandler;
                    }
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("<DELMSG><S>--->deleteMsgFromServerInner:");
            if (messageRecord == null) {
                str = "mr is Null.";
            } else {
                str = " isTroop:" + messageRecord.istroop;
            }
            sb5.append(str);
            QLog.d("Q.msg.UncommonMessageProcessor", 2, sb5.toString());
        }
    }

    public void F(List<MessageRecord> list) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
            return;
        }
        int i3 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i3 + 1;
        long j16 = i3;
        SendMessageHandler sendMessageHandler = new SendMessageHandler();
        this.f116343b.addToQueue(j16, sendMessageHandler);
        ToServiceMsg C = C(list, 2);
        if (C == null) {
            return;
        }
        C.extraData.putLong("msgSeq", j16);
        for (int i16 = 0; i16 < 12; i16++) {
            sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable(C) { // from class: com.tencent.mobileqq.app.message.UncommonMessageProcessor.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ToServiceMsg G;

                {
                    this.G = C;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UncommonMessageProcessor.this, (Object) C);
                    }
                }

                @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    this.G.setTimeout(this.f307281e);
                    this.G.extraData.putInt("retryIndex", this.D);
                    this.G.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, this.f307281e);
                    ((BaseMessageProcessor) UncommonMessageProcessor.this).f116343b.sendPBReqWithRemindSlowNetwork(this.G);
                }
            });
        }
        for (int i17 = 0; i17 < 6; i17++) {
            int i18 = 6 - i17;
            if (i17 == 0) {
                j3 = 1080000;
            } else {
                j3 = ((i18 * 1080000) / 6) - (i17 * 2000);
            }
            sendMessageHandler.f((1080000 * i17) / 6, j3, "period");
        }
    }

    public void O(List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, Boolean.valueOf(z16));
        } else {
            this.f116343b.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_MSG_REVOKE_RSP, true, new Object[]{list, Boolean.valueOf(z16), Boolean.TRUE});
        }
    }

    public void P(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).s1()) {
            EmojiStickerManager.d dVar = this.f195873v;
            if (dVar != null) {
                dVar.onResult(false);
            }
            this.f116343b.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_MSG_REVOKE_RSP, false, null);
            R(str, i3, i16, i17);
        }
    }

    public void Q(List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, list, Boolean.valueOf(z16));
            return;
        }
        EmojiStickerManager.d dVar = this.f195873v;
        if (dVar != null) {
            dVar.onResult(true);
        }
        this.f116343b.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_MSG_REVOKE_RSP, true, new Object[]{list, Boolean.valueOf(z16), Boolean.FALSE});
    }

    public void S(MessageRecord messageRecord, ArrayList<String> arrayList, ChatActivityFacade.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, messageRecord, arrayList, aVar);
            return;
        }
        msg_svc$PbSendMsgReq pbSendReqFromBlessMsg = MessageHandlerUtils.getPbSendReqFromBlessMsg(this.f116342a, messageRecord, arrayList, aVar);
        if (pbSendReqFromBlessMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.UncommonMessageProcessor", 2, "sendBlessMsg error, msgReq is null!");
            }
            this.f116343b.notifyBusiness(MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_MSG, false, new Object[]{0, 0L, Boolean.FALSE});
            return;
        }
        s(false, true, true, 0L, new a(messageRecord, pbSendReqFromBlessMsg));
    }

    public void U(EmojiStickerManager.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
        } else {
            this.f195873v = dVar;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void r(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
            return;
        }
        switch (i3) {
            case 8001:
                K(toServiceMsg, fromServiceMsg);
                return;
            case 8002:
                I(toServiceMsg, fromServiceMsg);
                return;
            case 8003:
                G(toServiceMsg, fromServiceMsg);
                return;
            case 8004:
                M(toServiceMsg, fromServiceMsg);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void t(int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) objArr);
            return;
        }
        switch (i3) {
            case 8001:
                if (objArr != null && objArr.length == 3) {
                    L((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            case 8002:
                if (objArr != null && objArr.length == 3) {
                    J((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            case 8003:
                if (objArr != null && objArr.length == 3) {
                    H((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            case 8004:
                if (objArr != null && objArr.length == 3) {
                    N((ToServiceMsg) objArr[0], (FromServiceMsg) objArr[1], objArr[2]);
                    return;
                } else {
                    f(getClass().getName(), i3);
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    public void u(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg);
            return;
        }
        switch (i3) {
            case 8001:
                K(toServiceMsg, fromServiceMsg);
                return;
            case 8002:
                I(toServiceMsg, fromServiceMsg);
                return;
            case 8003:
                G(toServiceMsg, fromServiceMsg);
                return;
            case 8004:
                M(toServiceMsg, fromServiceMsg);
                return;
            default:
                return;
        }
    }
}
