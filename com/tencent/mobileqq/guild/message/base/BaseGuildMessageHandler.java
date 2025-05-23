package com.tencent.mobileqq.guild.message.base;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class BaseGuildMessageHandler extends BusinessHandler {
    protected static final int MAX_RETRY_LIMIT = 9;
    protected static final int PERIODICAL_RETRY_LIMIT = 3;
    public static final int SEND_MESSAGE_TIMEOUT_MAX = 480000;
    public static final int SEND_MESSAGE_TIMEOUT_MAX_SECOND = 480;
    public static final String TAG = "BaseGuildMessageHandler";
    private final int sendMessageNonPeriodicalRetryElapseTimeLimit;
    protected final HashMap<Long, SendMessageHandler> sendQueue;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        ToServiceMsg a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseGuildMessageHandler(AppInterface appInterface) {
        super(appInterface);
        this.sendQueue = new HashMap<>();
        this.sendMessageNonPeriodicalRetryElapseTimeLimit = RichMediaStrategy.NO_MSF_SUGGEST_RETRY;
    }

    static String[] getTimeConsume(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3;
        if (toServiceMsg != null && fromServiceMsg != null) {
            String[] strArr = new String[7];
            long j16 = toServiceMsg.extraData.getLong("startTime", 0L);
            long j17 = fromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
            long j18 = fromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
            long j19 = fromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
            long j26 = fromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
            long j27 = fromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
            long j28 = fromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            strArr[1] = String.valueOf(currentTimeMillis - j16);
            strArr[2] = String.valueOf(j26 - j19);
            strArr[3] = String.valueOf(j19 - j16);
            strArr[4] = String.valueOf(currentTimeMillis - j26);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handler");
            if (j17 != 0) {
                sb5.append("|");
                sb5.append(String.valueOf(j17 - j16));
                sb5.append("|app");
                j16 = j17;
            }
            if (j18 != 0) {
                sb5.append("|");
                sb5.append(String.valueOf(j18 - j16));
                sb5.append("|msf");
            } else {
                j18 = j16;
            }
            if (j19 != 0) {
                sb5.append("|");
                sb5.append(String.valueOf(j19 - j18));
                sb5.append("|net");
            }
            strArr[5] = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("net");
            if (j27 != 0) {
                sb6.append("|");
                sb6.append(String.valueOf(j27 - j26));
                sb6.append("|msf");
                j3 = j28;
                j26 = j27;
            } else {
                j3 = j28;
            }
            if (j3 != 0) {
                sb6.append("|");
                sb6.append(String.valueOf(j3 - j26));
                sb6.append("|app");
                j26 = j3;
            }
            sb6.append("|");
            sb6.append(String.valueOf(currentTimeMillis - j26));
            sb6.append("|handler");
            strArr[6] = sb6.toString();
            strArr[0] = "{total:" + strArr[1] + "," + TransReport.rep_net_type + strArr[2] + ",send:" + strArr[3] + ",recv:" + strArr[4] + ",sendDetail:" + strArr[5] + ",recvDetail:" + strArr[6] + "}";
            return strArr;
        }
        return null;
    }

    private boolean notRetry(boolean z16, boolean z17, boolean z18, a aVar, long j3) {
        if (!z16) {
            ToServiceMsg a16 = aVar.a();
            if (a16 == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "processRequest cmd=" + a16.getServiceCmd() + ",reqSeq=" + j3);
            }
            sendRequest(a16, j3, z17, z18);
            return true;
        }
        return false;
    }

    private void prepareRetryRunnable(final boolean z16, final boolean z17, final a aVar, final long j3, final long j16, SendMessageHandler sendMessageHandler) {
        for (int i3 = 0; i3 < 9; i3++) {
            sendMessageHandler.d(new SendMessageHandler.SendMessageRunnable() { // from class: com.tencent.mobileqq.guild.message.base.BaseGuildMessageHandler.1
                @Override // com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable, java.lang.Runnable
                public void run() {
                    ToServiceMsg a16 = aVar.a();
                    if (a16 == null) {
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(BaseGuildMessageHandler.TAG, 2, "prepareRetryRunnable cmd=" + a16.getServiceCmd() + ",reqSeq=" + j3 + " timeout: " + this.f307281e + " retryIndex:" + this.D);
                    }
                    a16.extraData.putLong(WadlProxyConsts.PARAM_TIME_OUT, this.f307281e);
                    a16.extraData.putLong("startTime", j16);
                    a16.extraData.putInt("retryIndex", this.D);
                    a16.setTimeout(this.f307281e);
                    BaseGuildMessageHandler.this.sendRequest(a16, j3, z16, z17);
                }
            });
        }
    }

    private void scheduleRetry(SendMessageHandler sendMessageHandler) {
        long j3;
        for (int i3 = 0; i3 < 3; i3++) {
            int i16 = 3 - i3;
            if (i3 == 0) {
                j3 = 480000;
            } else {
                j3 = ((i16 * 480000) / 3) - (i3 * 2000);
            }
            sendMessageHandler.f((480000 * i3) / 3, j3, "period");
        }
    }

    public boolean addToQueue(long j3, SendMessageHandler sendMessageHandler) {
        synchronized (this.sendQueue) {
            if (!this.sendQueue.containsKey(Long.valueOf(j3))) {
                this.sendQueue.put(Long.valueOf(j3), sendMessageHandler);
                sendMessageHandler.f307277e = j3;
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "sendQueue alread has msgSeq[" + j3 + "]");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destroySendQueue() {
        synchronized (this.sendQueue) {
            for (Map.Entry<Long, SendMessageHandler> entry : this.sendQueue.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().h();
                }
            }
            this.sendQueue.clear();
        }
    }

    public SendMessageHandler getHandlerFromQueue(long j3) {
        return this.sendQueue.get(Long.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.mobileqq.guild.message.n.class;
    }

    public void processRequest(boolean z16, boolean z17, boolean z18, long j3, a aVar) {
        if (j3 == 0) {
            int i3 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i3 + 1;
            j3 = i3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (notRetry(z16, z17, z18, aVar, j3)) {
            return;
        }
        SendMessageHandler sendMessageHandler = new SendMessageHandler();
        addToQueue(j3, sendMessageHandler);
        prepareRetryRunnable(z17, z18, aVar, j3, currentTimeMillis, sendMessageHandler);
        scheduleRetry(sendMessageHandler);
    }

    public void recordSendMessageRetryResult(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            if (!toServiceMsg.extraData.containsKey("msgSeq")) {
                QLog.e(TAG, 1, "no msgSeq");
                return;
            }
            long j3 = toServiceMsg.extraData.getLong("msgSeq");
            int i3 = toServiceMsg.extraData.getInt("retryIndex", 0);
            long resultCode = fromServiceMsg.getResultCode();
            long j16 = fromServiceMsg.extraData.getLong("ServerReplyCode", Long.MAX_VALUE);
            SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
            if (handlerFromQueue != null) {
                String[] timeConsume = getTimeConsume(toServiceMsg, fromServiceMsg);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "<---TimeConsume---> cmd[" + toServiceMsg.getServiceCmd() + "] seq[" + j3 + "] retryIndex[" + i3 + "] " + timeConsume[0] + "");
                }
                handlerFromQueue.e(i3, resultCode, j16, timeConsume);
                return;
            }
            QLog.e(TAG, 1, "can not found handler");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "req or resp is null");
        }
    }

    protected boolean removeFromQueue(long j3) {
        synchronized (this.sendQueue) {
            if (this.sendQueue.containsKey(Long.valueOf(j3))) {
                this.sendQueue.remove(Long.valueOf(j3));
                return true;
            }
            return false;
        }
    }

    public void removeSendMessageHandler(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeSendMessageHandler msgseq=" + j3);
        }
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            handlerFromQueue.h();
            removeFromQueue(j3);
        }
    }

    public boolean retrySendMessage(SendMessageHandler sendMessageHandler, String str) {
        boolean z16;
        long b16 = sendMessageHandler.b(System.currentTimeMillis());
        if (b16 < 450000) {
            long j3 = (480000 - b16) - 5000;
            z16 = sendMessageHandler.f(0L, j3, str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "<<<---retrySendMessage scheduleSuccess[" + z16 + "] msgSeq[" + sendMessageHandler.f307277e + "] timeout[" + j3 + "] reason[" + str + "]");
            }
        } else {
            z16 = false;
        }
        if (!z16 && sendMessageHandler.c()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "<<<---retrySendMessage No unfinished retry attampt.");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<<<---retrySendMessage Wait SendMessage Retry");
            return true;
        }
        return true;
    }

    protected void sendRequest(ToServiceMsg toServiceMsg, long j3, boolean z16, boolean z17) {
        toServiceMsg.extraData.putLong("msgSeq", j3);
        if (z16) {
            if (z17) {
                toServiceMsg.setNeedRemindSlowNetwork(true);
            }
            sendPbReq(toServiceMsg);
            return;
        }
        send(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
