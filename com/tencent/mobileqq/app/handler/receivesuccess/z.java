package com.tencent.mobileqq.app.handler.receivesuccess;

import android.support.annotation.NonNull;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.util.DeprecatedMethodInvokeReport;
import java.util.Arrays;
import mqq.app.MainService;
import msf.msgsvc.msg_svc$PbSendMsgResp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class z {
    static IPatchRedirector $redirector_;

    public static void a(FromServiceMsg fromServiceMsg, MessageHandlerConstants.MsgSendCostParams msgSendCostParams) {
        Object attribute = fromServiceMsg.getAttribute(MainService.TO_SERVICE_MSG_AFTER_SENT);
        if (!(attribute instanceof ToServiceMsg)) {
            return;
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) attribute;
        msgSendCostParams.ipFamily = (String) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IP_FAMILY, "");
        msgSendCostParams.transChannel = (String) toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249868z, "");
        Boolean bool = Boolean.FALSE;
        msgSendCostParams.isWifi = ((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_IS_WIFI, bool)).booleanValue();
        msgSendCostParams.isp = (String) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_ISP, "");
        msgSendCostParams.isWeaknet = ((Boolean) toServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue();
    }

    @NonNull
    public static msg_svc$PbSendMsgResp b(Object obj) {
        String arrays;
        try {
            return new msg_svc$PbSendMsgResp().mergeFrom((byte[]) obj);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : invalid.", e16);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("<---handleSendC2CMessageResp_PB : data:");
                if (obj == null) {
                    arrays = "null";
                } else {
                    arrays = Arrays.toString((byte[]) obj);
                }
                sb5.append(arrays);
                QLog.e("Q.msg.MessageHandler", 2, sb5.toString());
            }
            return new msg_svc$PbSendMsgResp();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0153  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v4, types: [int] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        int i3;
        boolean z16;
        int i16;
        int i17;
        ?? r112;
        String str2;
        SendMessageHandler handlerFromQueue;
        int i18;
        int i19;
        int i26;
        long j3;
        MessageHandler messageHandler2;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB.");
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        String string = toServiceMsg.extraData.getString("uin");
        long j16 = toServiceMsg.extraData.getLong("uniseq");
        String string2 = toServiceMsg.extraData.getString(WadlProxyConsts.PARAM_FILENAME);
        long j17 = toServiceMsg.extraData.getLong("msgSeq");
        long j18 = toServiceMsg.extraData.getLong(WadlProxyConsts.PARAM_TIME_OUT);
        int i27 = toServiceMsg.extraData.getInt("retryIndex", 0);
        int i28 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
        int i29 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
        int H = com.tencent.mobileqq.service.message.p.H(i29, messageHandler.Q);
        if (H == 1024) {
            str = string2;
            H = toServiceMsg.extraData.getInt("uintype", H);
        } else {
            str = string2;
        }
        int i36 = H;
        boolean z17 = false;
        if (ao.c(i36) == 1032) {
            i3 = i27;
            z16 = false;
            i16 = toServiceMsg.extraData.getInt(ConfessInfo.KEY_CONFESS_TOPICID, 0);
        } else {
            i3 = i27;
            z16 = false;
            i16 = 0;
        }
        boolean z18 = toServiceMsg.extraData.getBoolean("RichNotify", z16);
        msg_svc$PbSendMsgResp b16 = b(obj);
        if (b16 != null && b16.result.has()) {
            r112 = z16;
            if (b16.result.get() != 0) {
                i17 = b16.result.get();
            }
            QLog.i("Q.msg.MessageHandler", 1, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + serviceCmd + "----replyCode:" + r112 + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + " peerUin:" + MsfSdkUtils.getShortUin(string) + " uniseq:" + j16 + " msgSeq:" + j17 + " msgType:" + i28 + " uinType:" + i36 + " routingType:" + i29);
            fromServiceMsg.extraData.putLong("ServerReplyCode", (long) r112);
            messageHandler.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
            if (string != null) {
                str2 = "null";
            } else {
                str2 = string;
            }
            DeprecatedMethodInvokeReport.d("Message", "SendMsgResp.handleSendC2CMessageResp_PB", DeprecatedMethodInvokeReport.b.a(i36, str2, i28, serviceCmd));
            handlerFromQueue = messageHandler.getHandlerFromQueue(j17);
            if (handlerFromQueue != null) {
                QLog.e("Q.msg.MessageHandler", 1, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + serviceCmd + ",no SendMessageHandler found.");
                com.tencent.mobileqq.activity.aio.forward.b.d().k(messageHandler.Q, j16);
                return;
            }
            boolean z19 = true;
            if (r112 != 255) {
                z19 = false;
            }
            if (z19 && messageHandler.retrySendMessage(handlerFromQueue, "server")) {
                return;
            }
            if (r112 != 0 && r112 != 241) {
                i18 = i28;
                i19 = i36;
                i26 = r112;
                j3 = j16;
                e g16 = new e(messageHandler, toServiceMsg, fromServiceMsg, string, j16, j17, j18, i3, i18, i29, i19, false, i16, z18, i26, b16, handlerFromQueue).g();
                if (g16.h()) {
                    return;
                }
                z17 = g16.i();
                messageHandler2 = messageHandler;
            } else {
                i18 = i28;
                i19 = i36;
                i26 = r112;
                j3 = j16;
                messageHandler2 = messageHandler;
                d(messageHandler2, toServiceMsg, fromServiceMsg, string, j3, str, j17, i3, i19, i16, z18, b16, handlerFromQueue);
            }
            ((com.tencent.mobileqq.multimsg.f) messageHandler2.Q.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).f(string, i19, j3, i26, System.currentTimeMillis() - toServiceMsg.extraData.getLong("startTime", 0L));
            ((IVideoReporter) QRoute.api(IVideoReporter.class)).reportVideoStructMsgSendSuc(messageHandler2.Q, i18, string, i19, j3);
            if (!z17) {
                com.tencent.mobileqq.activity.aio.forward.b.d().k(messageHandler2.Q, j3);
                return;
            }
            return;
        }
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : server did not return a valid result code, use 4 instead.");
        i17 = 4;
        r112 = i17;
        QLog.i("Q.msg.MessageHandler", 1, "<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:" + serviceCmd + "----replyCode:" + r112 + " ssoseq:" + fromServiceMsg.getRequestSsoSeq() + " appseq:" + fromServiceMsg.getAppSeq() + " peerUin:" + MsfSdkUtils.getShortUin(string) + " uniseq:" + j16 + " msgSeq:" + j17 + " msgType:" + i28 + " uinType:" + i36 + " routingType:" + i29);
        fromServiceMsg.extraData.putLong("ServerReplyCode", (long) r112);
        messageHandler.recordSendMessageRetryResult(toServiceMsg, fromServiceMsg);
        if (string != null) {
        }
        DeprecatedMethodInvokeReport.d("Message", "SendMsgResp.handleSendC2CMessageResp_PB", DeprecatedMethodInvokeReport.b.a(i36, str2, i28, serviceCmd));
        handlerFromQueue = messageHandler.getHandlerFromQueue(j17);
        if (handlerFromQueue != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01da  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, long j3, String str2, long j16, int i3, int i16, int i17, boolean z16, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, SendMessageHandler sendMessageHandler) {
        int i18;
        String str3;
        FromServiceMsg fromServiceMsg2;
        int i19;
        ?? r56;
        boolean z17;
        long j17;
        toServiceMsg.extraData.putBoolean("isJuhuaExist", com.tencent.mobileqq.service.message.e.r1(messageHandler.Q.getMsgCache().G1(str, i16, j3)));
        if (msg_svc_pbsendmsgresp.send_time.has()) {
            long j18 = msg_svc_pbsendmsgresp.send_time.get() & 4294967295L;
            i18 = 2;
            str3 = "Q.msg.MessageHandler";
            messageHandler.r5(str, i16, j3, j18, str2);
            if (QLog.isColorLevel()) {
                QLog.d(str3, 2, "<---handleSendC2CMessageResp_PB updateSendMsgTime: sendBuddyPb: respData.uSendTime:" + j18 + ",peerUin:" + str);
            }
        } else {
            i18 = 2;
            str3 = "Q.msg.MessageHandler";
        }
        if (msg_svc_pbsendmsgresp.trans_svr_info.has() && i16 == 10008) {
            messageHandler.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_SEND_RESULT_WITH_TRANSINFO, true, msg_svc_pbsendmsgresp.trans_svr_info.get());
        }
        MessageRecord w06 = messageHandler.Q.getMessageFacade().w0(str, i16, j3);
        messageHandler.Q3(msg_svc_pbsendmsgresp, str, w06, i16, j3);
        if (w06 != null && msg_svc_pbsendmsgresp.uint32_msg_info_flag.has()) {
            int i26 = msg_svc_pbsendmsgresp.uint32_msg_info_flag.get();
            if (QLog.isColorLevel()) {
                QLog.d(str3, i18, "C2CMessageSendFlag: " + i26);
            }
            w06.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i26));
            messageHandler.Q.getMessageFacade().a1(w06.frienduin, w06.istroop, w06.uniseq, AppConstants.Key.COLUMN_EXT_STR, w06.extStr);
        }
        if (w06 instanceof RecommendCommonMessage) {
            String str4 = (msg_svc_pbsendmsgresp.text_analysis_result.has() && msg_svc_pbsendmsgresp.text_analysis_result.get() == 1) ? "1" : "0";
            if (QLog.isColorLevel()) {
                QLog.d(str3, i18, "<---handleSendC2CMessageResp_PB text_analysis_result=" + str4);
            }
            w06.saveExtInfoToExtStr("ark_text_analysis_flag", str4);
        }
        long j19 = toServiceMsg.extraData.getLong("msg_request_time", 0L);
        if (j19 > 0 && i16 == 0) {
            fromServiceMsg2 = fromServiceMsg;
            if (fromServiceMsg2.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) != null && fromServiceMsg2.getAttribute(BaseConstants.TIMESTAMP_NET2MSF) != null) {
                long longValue = ((Long) fromServiceMsg2.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) fromServiceMsg2.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                if (longValue < 0) {
                    longValue = 0;
                }
                if (longValue <= TTL.MAX_VALUE) {
                    j17 = longValue;
                    MessageHandlerConstants.MsgSendCostParams msgSendCostParams = new MessageHandlerConstants.MsgSendCostParams();
                    msgSendCostParams.mMsgNetsendToNetrecv = j17;
                    long currentTimeMillis = System.currentTimeMillis();
                    msgSendCostParams.mMsgNotifyUiTime = currentTimeMillis;
                    msgSendCostParams.mMsgRequestToResponse = currentTimeMillis - j19;
                    msgSendCostParams.mMsgSendToRequest = toServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
                    msgSendCostParams.mUinType = 0;
                    Boolean bool = Boolean.FALSE;
                    msgSendCostParams.isCrossOper = ((Boolean) fromServiceMsg2.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool)).booleanValue();
                    msgSendCostParams.isSentByXG = ((Boolean) fromServiceMsg2.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool)).booleanValue();
                    msgSendCostParams.isWeaknet = ((Boolean) fromServiceMsg2.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue();
                    if (w06 != null) {
                        msgSendCostParams.msgType = w06.msgtype;
                    }
                    a(fromServiceMsg2, msgSendCostParams);
                    r56 = 1;
                    i19 = 2;
                    messageHandler.notifyUI(6003, true, new Object[]{str, j3 + "", msgSendCostParams});
                }
            }
            j17 = 0;
            MessageHandlerConstants.MsgSendCostParams msgSendCostParams2 = new MessageHandlerConstants.MsgSendCostParams();
            msgSendCostParams2.mMsgNetsendToNetrecv = j17;
            long currentTimeMillis2 = System.currentTimeMillis();
            msgSendCostParams2.mMsgNotifyUiTime = currentTimeMillis2;
            msgSendCostParams2.mMsgRequestToResponse = currentTimeMillis2 - j19;
            msgSendCostParams2.mMsgSendToRequest = toServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
            msgSendCostParams2.mUinType = 0;
            Boolean bool2 = Boolean.FALSE;
            msgSendCostParams2.isCrossOper = ((Boolean) fromServiceMsg2.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool2)).booleanValue();
            msgSendCostParams2.isSentByXG = ((Boolean) fromServiceMsg2.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool2)).booleanValue();
            msgSendCostParams2.isWeaknet = ((Boolean) fromServiceMsg2.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool2)).booleanValue();
            if (w06 != null) {
            }
            a(fromServiceMsg2, msgSendCostParams2);
            r56 = 1;
            i19 = 2;
            messageHandler.notifyUI(6003, true, new Object[]{str, j3 + "", msgSendCostParams2});
        } else {
            fromServiceMsg2 = fromServiceMsg;
            i19 = 2;
            r56 = 1;
            r56 = 1;
            if (ao.c(i16) == 1032) {
                messageHandler.notifyUI(MessageHandlerConstants.NOTIFY_TYPE_CONFESS_TMP, true, new Object[]{str, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17)});
            } else {
                messageHandler.notifyUI(6003, true, new String[]{str, j3 + ""});
            }
        }
        com.tencent.mobileqq.statistics.tianjige.tracers.a.b(toServiceMsg, fromServiceMsg);
        if (z16) {
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.retryCount = i3 + 1;
            Object[] objArr = new Object[i19];
            objArr[0] = Long.valueOf(j3);
            objArr[r56] = statictisInfo;
            messageHandler.notifyCallBack(toServiceMsg, 5006, r56, objArr);
            z17 = r56;
            messageHandler.R3(str, i16, j3, true);
        } else {
            z17 = r56;
        }
        com.tencent.mobileqq.app.handler.d.e(messageHandler, toServiceMsg, fromServiceMsg2, z17);
        messageHandler.removeSendMessageHandler(j16);
        if (i16 == 1025 || i16 == 1024) {
            ((QidianHandler) messageHandler.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).s3(str, sendMessageHandler.b(System.currentTimeMillis()));
        }
        messageHandler.q5(w06);
        com.tencent.mobileqq.app.handler.d.h(messageHandler.Q, i16, str);
    }

    public static void e(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (BaseConstants.CMD_MSG_PBSENDMSG.equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            int i3 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
            if (MessageHandlerUtils.isC2CRoutingType(i3, messageHandler.Q)) {
                com.tencent.mobileqq.statistics.tianjige.tracers.a.c(toServiceMsg, fromServiceMsg);
                c(messageHandler, toServiceMsg, fromServiceMsg, obj);
            } else if (i3 == 9) {
                messageHandler.a3().t(7002, toServiceMsg, fromServiceMsg, obj);
            } else if (i3 == 13) {
                messageHandler.a3().t(7003, toServiceMsg, fromServiceMsg, obj);
            } else if (i3 == 4) {
                com.tencent.mobileqq.statistics.tianjige.tracers.a.c(toServiceMsg, fromServiceMsg);
                messageHandler.V3(toServiceMsg, fromServiceMsg, obj);
            } else if (i3 == 2) {
                com.tencent.mobileqq.statistics.tianjige.tracers.a.c(toServiceMsg, fromServiceMsg);
                messageHandler.f4(toServiceMsg, fromServiceMsg, obj);
            }
            com.tencent.mobileqq.app.handler.d.b(toServiceMsg, "0");
        }
    }
}
