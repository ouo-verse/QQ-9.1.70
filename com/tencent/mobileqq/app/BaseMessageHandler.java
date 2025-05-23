package com.tencent.mobileqq.app;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.DeviceInfo;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm$Msg;
import msf.msgsvc.msg_svc$PbSearchRoamMsgInCloudReq;
import msf.onlinepush.msg_onlinepush$PbPushMsg;
import tencent.im.oidb.searcher.oidb_c2c_searcher$Iterator;
import tencent.im.oidb.searcher.oidb_c2c_searcher$MsgKey;
import tencent.im.oidb.searcher.oidb_c2c_searcher$ReqBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseMessageHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    public static final int SEND_MESSAGE_TIMEOUT_MAX = 480000;
    public static final int SEND_MESSAGE_TIMEOUT_MAX_SECOND = 480;
    public static final String TAG = "MessageHandler";
    public RegisterProxyHandler mRegisterProxyHandler;
    protected final int maxRetryLimit;
    protected final int periodicalRetryLimit;
    protected Map<String, BaseMessageProcessor> processorMap;
    public final HashMap<String, List<msg_comm$Msg>> roamCache;
    private final int sendMessageNonPeriodicalRetryElapseTimeLimit;
    protected final HashMap<Long, SendMessageHandler> sendQueue;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseMessageHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.roamCache = new HashMap<>();
        this.sendQueue = new HashMap<>();
        this.maxRetryLimit = 9;
        this.periodicalRetryLimit = 3;
        this.sendMessageNonPeriodicalRetryElapseTimeLimit = RichMediaStrategy.NO_MSF_SUGGEST_RETRY;
        this.mRegisterProxyHandler = new RegisterProxyHandler(this);
        this.processorMap = new ConcurrentHashMap();
    }

    public static String[] getTimeConsume(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
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

    public static String getTimeoutReason(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            if (fromServiceMsg.getResultCode() == 1002 || fromServiceMsg.getResultCode() == 1013) {
                if (fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS) != null) {
                    return "timeout_reason_SERVER_NO_RESPONSE";
                }
                return (String) fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, String.valueOf(fromServiceMsg.getResultCode()));
            }
            return null;
        }
        return null;
    }

    public void actBExceptionReason01() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
        }
    }

    public boolean addToQueue(long j3, SendMessageHandler sendMessageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), sendMessageHandler)).booleanValue();
        }
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

    protected int addToQueueBySeq(SendMessageHandler sendMessageHandler) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) sendMessageHandler)).intValue();
        }
        do {
            i3 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i3 + 1;
        } while (!addToQueue(i3, sendMessageHandler));
        return i3;
    }

    public void delC2COnlinePushMsg(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            delOnlinePushMsg(j3, i3, i16, null, 1, com.tencent.mobileqq.utils.ah.r());
        } else {
            iPatchRedirector.redirect((short) 23, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void delDisOnlinePushMsg(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            delOnlinePushMsg(j3, i3, i16, null, -1, null);
        }
    }

    public void delOnlinePushMsg(long j3, int i3, int i16, msg_onlinepush$PbPushMsg msg_onlinepush_pbpushmsg, int i17, DeviceInfo deviceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), msg_onlinepush_pbpushmsg, Integer.valueOf(i17), deviceInfo);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_RESPPUSH);
        createToServiceMsg.extraData.putInt("svrip", i3);
        createToServiceMsg.extraData.putInt("seq", i16);
        createToServiceMsg.extraData.putLong("lUin", j3);
        if (i17 != -1) {
            createToServiceMsg.extraData.putInt("service_type", i17);
        }
        if (deviceInfo != null) {
            createToServiceMsg.extraData.putSerializable("deviceInfo", deviceInfo);
        }
        if (msg_onlinepush_pbpushmsg != null && msg_onlinepush_pbpushmsg.bytes_push_token.has()) {
            createToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[]) msg_onlinepush_pbpushmsg.bytes_push_token.get().toByteArray().clone());
        }
        createToServiceMsg.setNeedCallback(false);
        send(createToServiceMsg);
    }

    public void delTroopOnlinePushMsg(long j3, int i3, int i16, msg_onlinepush$PbPushMsg msg_onlinepush_pbpushmsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), msg_onlinepush_pbpushmsg);
        } else {
            delOnlinePushMsg(j3, i3, i16, msg_onlinepush_pbpushmsg, 1, com.tencent.mobileqq.utils.ah.r());
        }
    }

    public void deleteDiscussion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destroySendQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        synchronized (this.sendQueue) {
            for (Map.Entry<Long, SendMessageHandler> entry : this.sendQueue.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().h();
                }
            }
            this.sendQueue.clear();
        }
    }

    public void dispatchErrorToProcessor(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, toServiceMsg, fromServiceMsg);
        } else {
            getProcessor(ProcessorDispatcher.getProcessorKey(str)).r(ProcessorDispatcher.getProcessType(str), toServiceMsg, fromServiceMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchRespToProcessor(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, toServiceMsg, fromServiceMsg, obj);
        } else if (ProcessorDispatcher.getProcessorMap().containsKey(str)) {
            getProcessor(ProcessorDispatcher.getProcessorKey(str)).t(ProcessorDispatcher.getProcessType(str), toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void dispatchTimeoutToProcessor(String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, toServiceMsg, fromServiceMsg);
        } else {
            getProcessor(ProcessorDispatcher.getProcessorKey(str)).u(ProcessorDispatcher.getProcessType(str), toServiceMsg, fromServiceMsg);
        }
    }

    protected void dispatchToProcessor(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        for (BaseMessageProcessor baseMessageProcessor : this.processorMap.values()) {
            if (baseMessageProcessor != null) {
                baseMessageProcessor.p(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }

    public void doC2CUpdateWork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        }
    }

    public void doMsgProxyDiscussMsgResp_PB(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void doMsgProxyTroopMsgResp_PB(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void flushDiscussionAndTroopMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
        }
    }

    public AppInterface getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (AppInterface) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.appRuntime;
    }

    public void getC2CMessage(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    public void getC2CMessage_PB(byte b16, byte[] bArr, int i3, boolean z16, boolean z17, boolean z18, String str, int i16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Byte.valueOf(b16), bArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Integer.valueOf(i16), obj);
        }
    }

    public String getCurrentAIOUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (String) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return null;
    }

    public EntityManager getEM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (EntityManager) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return null;
    }

    public SendMessageHandler getHandlerFromQueue(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SendMessageHandler) iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
        return this.sendQueue.get(Long.valueOf(j3));
    }

    public Object getMessageHandleThreadSyncLock(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, i3);
        }
        return null;
    }

    public BaseMessageProcessor getProcessor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (BaseMessageProcessor) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        }
        return null;
    }

    public void getRoamMsgByTime(String str, long j3, long j16, long j17, short s16, long j18, int i3, byte[] bArr, int i16, boolean z16, int i17, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Short.valueOf(s16), Long.valueOf(j18), Integer.valueOf(i3), bArr, Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    public void handleError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    public boolean handleMsgNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return false;
    }

    public void handleRegPrxyCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        }
    }

    public boolean neadNotifyGroupMsgNotifycation(boolean z16, boolean z17, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 43, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list)).booleanValue();
    }

    public boolean needNotifyNotification(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, z16)).booleanValue();
        }
        return z16;
    }

    public void notifyBusiness(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        }
    }

    public void notifyCallBack(ToServiceMsg toServiceMsg, int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, toServiceMsg, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return BaseMessageObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
        } else {
            dispatchToProcessor(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void recordSendMessageRetryResult(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, j3)).booleanValue();
        }
        synchronized (this.sendQueue) {
            if (this.sendQueue.containsKey(Long.valueOf(j3))) {
                this.sendQueue.remove(Long.valueOf(j3));
                return true;
            }
            return false;
        }
    }

    public void removeSendMessageHandler(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeSendMessageHandler msgseq=" + j3);
        }
        SendMessageHandler handlerFromQueue = getHandlerFromQueue(j3);
        if (handlerFromQueue != null) {
            handlerFromQueue.h();
            removeFromQueue(j3);
        }
    }

    public void retryGetBuddyMsgCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        }
    }

    public boolean retrySendMessage(SendMessageHandler sendMessageHandler, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) sendMessageHandler, (Object) str)).booleanValue();
        }
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

    public void searchRoamMsgInCloud(int i3, List<String> list, String str, long j3, List<oidb_c2c_searcher$Iterator> list2, int i16, long j16) {
        msg_svc$PbSearchRoamMsgInCloudReq msg_svc_pbsearchroammsgincloudreq;
        int i17;
        msg_svc$PbSearchRoamMsgInCloudReq msg_svc_pbsearchroammsgincloudreq2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        int i19 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), list, str, Long.valueOf(j3), list2, Integer.valueOf(i16), Long.valueOf(j16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("PbMessageSvc.PbSearchRoamMsgInCloud");
        createToServiceMsg.setTimeout(5000L);
        createToServiceMsg.extraData.putString("keyword", str);
        createToServiceMsg.extraData.putLong("sequence", j3);
        createToServiceMsg.extraData.putInt("retryIndex", i16);
        createToServiceMsg.extraData.putInt("loadType", i3);
        msg_svc$PbSearchRoamMsgInCloudReq msg_svc_pbsearchroammsgincloudreq3 = new msg_svc$PbSearchRoamMsgInCloudReq();
        oidb_c2c_searcher$ReqBody oidb_c2c_searcher_reqbody = new oidb_c2c_searcher$ReqBody();
        oidb_c2c_searcher_reqbody.query.set(ByteStringMicro.copyFrom(str.getBytes()));
        oidb_c2c_searcher_reqbody.max_cnt.set(20);
        oidb_c2c_searcher_reqbody.type.set(1);
        ArrayList arrayList = new ArrayList();
        if (list2 == null) {
            if (list != null) {
                while (i18 < list.size()) {
                    oidb_c2c_searcher$Iterator oidb_c2c_searcher_iterator = new oidb_c2c_searcher$Iterator();
                    oidb_c2c_searcher$MsgKey oidb_c2c_searcher_msgkey = new oidb_c2c_searcher$MsgKey();
                    if (j16 != 0) {
                        oidb_c2c_searcher_msgkey.time.set(j16);
                        msg_svc_pbsearchroammsgincloudreq2 = msg_svc_pbsearchroammsgincloudreq3;
                    } else {
                        msg_svc_pbsearchroammsgincloudreq2 = msg_svc_pbsearchroammsgincloudreq3;
                        oidb_c2c_searcher_msgkey.time.set(NetConnInfoCenter.getServerTime());
                    }
                    oidb_c2c_searcher_iterator.key.set(oidb_c2c_searcher_msgkey);
                    oidb_c2c_searcher_iterator.uin.set(Long.parseLong(list.get(i18)));
                    arrayList.add(oidb_c2c_searcher_iterator);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "--->>searchRoamMsgInCloud friendUin: " + list.get(i18) + " beginTime: " + oidb_c2c_searcher_iterator.key.time.get() + ", searchkey: " + str + ",lastDatelineTime:" + j16);
                    }
                    i18++;
                    msg_svc_pbsearchroammsgincloudreq3 = msg_svc_pbsearchroammsgincloudreq2;
                    i19 = 2;
                }
            }
            msg_svc_pbsearchroammsgincloudreq = msg_svc_pbsearchroammsgincloudreq3;
            i17 = i19;
        } else {
            msg_svc_pbsearchroammsgincloudreq = msg_svc_pbsearchroammsgincloudreq3;
            if (QLog.isColorLevel()) {
                i17 = 2;
                QLog.d(TAG, 2, "--->>searchRoamMsgInCloud  beginTime: " + list2.get(0).key.time.get() + ", searchkey: " + str + ",retryIndex" + i16);
            } else {
                i17 = 2;
            }
            arrayList.addAll(list2);
        }
        if (arrayList.size() <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, i17, "--->>searchRoamMsgInCloud listSize 0: it should not happen, check why");
            }
        } else {
            oidb_c2c_searcher_reqbody.friends.set(arrayList);
            oidb_c2c_searcher_reqbody.set(oidb_c2c_searcher_reqbody);
            msg_svc$PbSearchRoamMsgInCloudReq msg_svc_pbsearchroammsgincloudreq4 = msg_svc_pbsearchroammsgincloudreq;
            msg_svc_pbsearchroammsgincloudreq4.serialize_reqbody.set(ByteStringMicro.copyFrom(oidb_c2c_searcher_reqbody.toByteArray()));
            createToServiceMsg.putWupBuffer(msg_svc_pbsearchroammsgincloudreq4.toByteArray());
            sendPbReq(createToServiceMsg);
        }
    }

    public void sendPBReqWithRemindSlowNetwork(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) toServiceMsg);
        }
    }

    public void sendWorkMessage(Message message, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, message, Boolean.valueOf(z16));
        }
    }

    public void setMsgGetting(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    public void setPAMsgGetting(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        }
    }

    public void startGetShareAppIDInfo(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) l3);
        }
    }

    public void updateGroupMsgContent(MessageRecord messageRecord, MessageRecord messageRecord2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) messageRecord, (Object) messageRecord2);
        }
    }

    public void updateGroupMsgSeqAndTime(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
    }

    public void updateLastRegisterProxyRespTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
        }
    }

    public void updateSendC2CMessageTimeByUniseq(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public void delC2COnlinePushMsg(long j3, ArrayList<DelMsgInfo> arrayList, int i3, int i16, msg_onlinepush$PbPushMsg msg_onlinepush_pbpushmsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Long.valueOf(j3), arrayList, Integer.valueOf(i3), Integer.valueOf(i16), msg_onlinepush_pbpushmsg);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_RESPPUSH);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        createToServiceMsg.extraData.putSerializable("delMsgInfos", arrayList);
        createToServiceMsg.extraData.putInt("svrip", i3);
        createToServiceMsg.extraData.putInt("seq", i16);
        createToServiceMsg.extraData.putLong("lUin", j3);
        if (msg_onlinepush_pbpushmsg != null && msg_onlinepush_pbpushmsg.bytes_push_token.has()) {
            createToServiceMsg.extraData.putByteArray("bytes_push_token", (byte[]) msg_onlinepush_pbpushmsg.bytes_push_token.get().toByteArray().clone());
        }
        createToServiceMsg.setNeedCallback(false);
        send(createToServiceMsg);
    }
}
