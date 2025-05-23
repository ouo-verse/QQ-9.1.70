package com.tencent.mobileqq.app.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.i;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        HashMap<String, String> hashMap = new HashMap<>();
        long j3 = 0;
        long j16 = fromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
        if (j16 == 10 || j16 == 34) {
            int i3 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
            String string = toServiceMsg.extraData.getString("uin");
            if (string == null) {
                string = "0";
            }
            String str = string;
            int i16 = toServiceMsg.extraData.getInt("send_msg_req_size", 0);
            hashMap.put("pm_peer_uin", str);
            hashMap.put("pm_route_type", String.valueOf(i3));
            hashMap.put("pm_req_size", String.valueOf(i16));
            hashMap.put("pm_srv_reply", String.valueOf(j16));
            if (i3 != 13 && i3 != 9) {
                long j17 = toServiceMsg.extraData.getLong("startTime", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j17 >= 1) {
                    j3 = currentTimeMillis - j17;
                }
                int i17 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE);
                int H = p.H(i3, qQAppInterface);
                hashMap.put("pm_msg_type", String.valueOf(i17));
                hashMap.put("pm_uin_type", String.valueOf(H));
            }
            long j18 = j3;
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), StatisticCollector.SEND_MSG_TOO_LARGE_ERROR_TAG, false, j18, i16, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, duration:%dms, peerUin:%s, replyCode:%d, routingType:%s, msgReqSize:%d", StatisticCollector.SEND_MSG_TOO_LARGE_ERROR_TAG, Long.valueOf(j18), str, Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16)));
            }
        }
    }

    public static void b(ToServiceMsg toServiceMsg, String str) {
        Bundle bundle = toServiceMsg.extraData;
        if (bundle != null && bundle.getInt(AppConstants.Key.COLUMN_MSG_TYPE) == -2007) {
            if (toServiceMsg.extraData.getInt("mediaType") == 2) {
                EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus(str, 7);
            } else {
                EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus(str, 6);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(MessageHandler messageHandler, String str, boolean z16, long j3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j16;
        long j17;
        long j18;
        SendMessageHandler handlerFromQueue;
        HashMap<String, String> hashMap = new HashMap<>();
        long resultCode = fromServiceMsg.getResultCode();
        long j19 = 0;
        long j26 = fromServiceMsg.extraData.getLong("ServerReplyCode", 0L);
        String str2 = "";
        if (j26 != 0 && j26 != 241) {
            hashMap.put("param_ServerReplyCode", fromServiceMsg.extraData.getLong("ServerReplyCode") + "");
            resultCode = 2900;
        }
        hashMap.put("param_FailCode", resultCode + "");
        long j27 = (long) toServiceMsg.extraData.getInt("retryIndex", 0);
        hashMap.put("param_retryIndex", Long.toString(j27));
        long j28 = toServiceMsg.extraData.getLong("startTime", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j28 < 1) {
            j16 = 0;
        } else {
            j16 = currentTimeMillis - j28;
        }
        if (toServiceMsg.extraData.containsKey("msgSeq") && (handlerFromQueue = messageHandler.getHandlerFromQueue(toServiceMsg.extraData.getLong("msgSeq"))) != null) {
            str2 = handlerFromQueue.toString();
            hashMap.put("param_retryInfo", str2);
            j16 = handlerFromQueue.b(currentTimeMillis);
        }
        long j29 = j16;
        String str3 = str2;
        String timeoutReason = BaseMessageHandler.getTimeoutReason(fromServiceMsg);
        if (timeoutReason != null) {
            hashMap.put(ReportConstant.KEY_REASON, timeoutReason);
        }
        if (fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) != null && fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF) != null) {
            long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
            if (longValue < 0) {
                longValue = 0;
            }
            if (longValue <= TTL.MAX_VALUE) {
                j17 = longValue;
                int i3 = toServiceMsg.extraData.getInt("msg_signal_sum");
                int i16 = toServiceMsg.extraData.getInt("msg_signal_count");
                boolean z17 = toServiceMsg.extraData.getBoolean("msg_signal_open");
                int i17 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE, -1);
                int i18 = toServiceMsg.extraData.getInt("msg_signal_net_type", -1);
                hashMap.put("pm_signal_sum", String.valueOf(i3));
                hashMap.put("pm_signal_count", String.valueOf(i16));
                hashMap.put("pm_signal_open", String.valueOf(z17));
                hashMap.put("pm_msgtype", String.valueOf(i17));
                hashMap.put("pm_nettype", String.valueOf(i18));
                hashMap.put("pm_msftime", String.valueOf(j17));
                int i19 = toServiceMsg.extraData.getInt("send_msg_req_size", 0);
                boolean z18 = toServiceMsg.extraData.getBoolean("isJuhuaExist");
                hashMap.put("pm_req_size", String.valueOf(i19));
                hashMap.put("isJuhuaExist", String.valueOf(z18));
                Boolean bool = Boolean.FALSE;
                boolean booleanValue = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool)).booleanValue();
                boolean booleanValue2 = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool)).booleanValue();
                boolean booleanValue3 = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool)).booleanValue();
                hashMap.put("isCrossOper", String.valueOf(booleanValue));
                hashMap.put("isSentByXG", String.valueOf(booleanValue2));
                hashMap.put("isWeaknet", String.valueOf(booleanValue3));
                j18 = fromServiceMsg.extraData.getLong(i.f286259b, 0L);
                int i26 = fromServiceMsg.extraData.getInt(i.f286258a, 0);
                if (j18 != 0) {
                    j19 = System.currentTimeMillis() - j18;
                }
                long j36 = j19;
                hashMap.put("pm_queueTime", String.valueOf(j36));
                hashMap.put("pm_respLen", String.valueOf(i26));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(messageHandler.Q.getCurrentAccountUin(), str, z16, j29, j3, hashMap, "");
                if (!QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, success:%s, duration:%dms, retryNum:%d, detail:%s, msgSignal [Sum:%d Count:%d, Open:%s msgType:%d netType:%d msfTime:%d reqSize:%d queueHandleTime:%d respWaitLen:%d]", str, Boolean.valueOf(z16), Long.valueOf(j29), Long.valueOf(j27), str3, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j17), Integer.valueOf(i19), Long.valueOf(j36), Integer.valueOf(i26)));
                    return;
                }
                return;
            }
        }
        j17 = 0;
        int i36 = toServiceMsg.extraData.getInt("msg_signal_sum");
        int i162 = toServiceMsg.extraData.getInt("msg_signal_count");
        boolean z172 = toServiceMsg.extraData.getBoolean("msg_signal_open");
        int i172 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE, -1);
        int i182 = toServiceMsg.extraData.getInt("msg_signal_net_type", -1);
        hashMap.put("pm_signal_sum", String.valueOf(i36));
        hashMap.put("pm_signal_count", String.valueOf(i162));
        hashMap.put("pm_signal_open", String.valueOf(z172));
        hashMap.put("pm_msgtype", String.valueOf(i172));
        hashMap.put("pm_nettype", String.valueOf(i182));
        hashMap.put("pm_msftime", String.valueOf(j17));
        int i192 = toServiceMsg.extraData.getInt("send_msg_req_size", 0);
        boolean z182 = toServiceMsg.extraData.getBoolean("isJuhuaExist");
        hashMap.put("pm_req_size", String.valueOf(i192));
        hashMap.put("isJuhuaExist", String.valueOf(z182));
        Boolean bool2 = Boolean.FALSE;
        boolean booleanValue4 = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_CONN_CROSSOPER, bool2)).booleanValue();
        boolean booleanValue22 = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_QUICK_SEND_BY_XG, bool2)).booleanValue();
        boolean booleanValue32 = ((Boolean) fromServiceMsg.getAttribute(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool2)).booleanValue();
        hashMap.put("isCrossOper", String.valueOf(booleanValue4));
        hashMap.put("isSentByXG", String.valueOf(booleanValue22));
        hashMap.put("isWeaknet", String.valueOf(booleanValue32));
        j18 = fromServiceMsg.extraData.getLong(i.f286259b, 0L);
        int i262 = fromServiceMsg.extraData.getInt(i.f286258a, 0);
        if (j18 != 0) {
        }
        long j362 = j19;
        hashMap.put("pm_queueTime", String.valueOf(j362));
        hashMap.put("pm_respLen", String.valueOf(i262));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(messageHandler.Q.getCurrentAccountUin(), str, z16, j29, j3, hashMap, "");
        if (!QLog.isColorLevel()) {
        }
    }

    public static void d(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        if (toServiceMsg == null || fromServiceMsg == null || toServiceMsg.extraData.getByte("binaryPic", (byte) 0).byteValue() == 1) {
            return;
        }
        c(messageHandler, StatisticCollector.C2C_TXT_STATISTIC_TAG, z16, toServiceMsg.extraData.getLong("msgsize", 0L), toServiceMsg, fromServiceMsg);
    }

    public static void e(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        int i3 = toServiceMsg.extraData.getInt("ROUNTING_TYPE");
        if (i3 == 1) {
            d(messageHandler, toServiceMsg, fromServiceMsg, z16);
            return;
        }
        if (i3 != 3 && i3 != 14 && i3 != 22) {
            if (i3 == 6) {
                j(messageHandler.Q, toServiceMsg, fromServiceMsg, z16);
                return;
            }
            return;
        }
        g(messageHandler.Q, toServiceMsg, fromServiceMsg, z16);
    }

    public static void f(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            toServiceMsg.extraData.getByte("cBodyType", (byte) -1).byteValue();
            if (toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE, -1) == -1000) {
                c(messageHandler, StatisticCollector.DISCUSSION_TXT_STATISTIC_TAG, z16, toServiceMsg.extraData.getLong("msgsize", 0L), toServiceMsg, fromServiceMsg);
            }
        }
    }

    public static void g(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", fromServiceMsg.getResultCode() + "");
            long j3 = 0;
            long j16 = toServiceMsg.extraData.getLong("msgsize", 0L);
            long j17 = toServiceMsg.extraData.getLong("startTime");
            long j18 = toServiceMsg.extraData.getInt("retryIndex", 0);
            if (j17 >= 1) {
                j3 = System.currentTimeMillis() - j17;
            }
            long j19 = j3;
            hashMap.put("param_retryIndex", Long.toString(j18));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.TROOP_SENDGRPTMP_STATISTIC_TAG, z16, j19, j16, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "TAG[" + StatisticCollector.TROOP_SENDGRPTMP_STATISTIC_TAG + "]  success[" + z16 + "] duration[" + j19 + "ms] retryNum[" + j18 + "]");
            }
        }
    }

    public static void h(QQAppInterface qQAppInterface, int i3, String str) {
        Integer num = -1;
        ITempMsgBoxManager iTempMsgBoxManager = (ITempMsgBoxManager) qQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
        if (iTempMsgBoxManager.isBelongToMsgBox(str, i3)) {
            num = ((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getServiceIdMap().get(Integer.valueOf(i3));
        } else if (iTempMsgBoxManager.isBelongToFilterBox(str, i3)) {
            num = 10000;
        }
        if (num != null && num.intValue() >= 0) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B1C3", "0X800B1C3", num.intValue(), 0, "", "", "", "");
        }
    }

    public static void i(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            int i3 = toServiceMsg.extraData.getInt(AppConstants.Key.COLUMN_MSG_TYPE, -1);
            long j3 = toServiceMsg.extraData.getLong("msgsize", 0L);
            if (i3 == -1000) {
                c(messageHandler, StatisticCollector.TROOP_TXT_STATISTIC_TAG, z16, j3, toServiceMsg, fromServiceMsg);
            }
        }
    }

    public static void j(QQAppInterface qQAppInterface, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", fromServiceMsg.getResultCode() + "");
            long j3 = 0;
            long j16 = toServiceMsg.extraData.getLong("msgsize", 0L);
            long j17 = toServiceMsg.extraData.getLong("startTime");
            long j18 = toServiceMsg.extraData.getInt("retryIndex", 0);
            if (j17 >= 1) {
                j3 = System.currentTimeMillis() - j17;
            }
            long j19 = j3;
            hashMap.put("param_retryIndex", Long.toString(j18));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.WPA_MSG_UPLOAD_STATISTIC_TAG, z16, j19, j16, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "TAG[" + StatisticCollector.WPA_MSG_UPLOAD_STATISTIC_TAG + "]  success[" + z16 + "] duration[" + j19 + "ms] retryNum[" + j18 + "]");
            }
        }
    }
}
