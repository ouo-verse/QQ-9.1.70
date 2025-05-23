package com.tencent.mobileqq.app.handler;

import RegisterProxySvcPack.RegisterPushNotice;
import android.util.Pair;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import msf.registerproxy.register_proxy$GroupList;

/* loaded from: classes11.dex */
public class RegisterProxyHandler {
    static IPatchRedirector $redirector_ = null;
    public static int C2C_MESSAGE_HANDLE_THREAD_NUMBER = 0;
    public static int MAX_MESSAGE_HANDLE_THREAD_NUMBER = 0;
    private static final String TAG = "RegisterProxyHandler";
    public static boolean isRecvC2CEmptyPackage;
    public static boolean isUseNewRegisterProxy;
    public static boolean isUsedMessageHandleThread;
    public final AtomicBoolean allMsgThreadEndLock;
    public long currentRegisterProxyRandom;
    public int discussionNum;
    public String[] discussionUinForRegisterProxyReq;
    public boolean hasNewRegisterAllEnd;
    public boolean hasNewRegisterFirstEnd;
    public boolean hasNewRegisterFirstReceiveEnd;
    public boolean isPullCircleStop;
    private Callback mCallback;
    private boolean mIsFirstReported;
    private boolean mIsFirstStartup;
    private BaseMessageHandler mMessageHandler;
    private int mOptimizeFlag;
    public List<register_proxy$GroupList> mUpdatedSrvSeqTroopList;
    private Object messageHandleThreadLock;
    private MessageHandleThread[] msgThread;
    public HashMap<String, Boolean> prxyDiscussList;
    public HashMap<String, Boolean> prxyTroopList;
    public int recvDiscNum;
    public int recvTroopNum;
    public int regPrxyFailNum;
    public volatile Pair<RegisterPushNotice, Long> registerProxyEnd;
    public int registerProxyEndSeq;
    public int registerProxyEndSeqNumTroop;
    public ArrayList<MessageObject> respC2CMessageQueue;
    public ArrayList<MessageObject> respMessageQueue;
    public int troopNum;
    public String[] troopUinForRegisterProxyReq;

    /* loaded from: classes11.dex */
    public interface Callback {
        List<String> getDiscussList();

        void onInitMsgSendingInfo(MessageRecord messageRecord);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38583);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        MAX_MESSAGE_HANDLE_THREAD_NUMBER = 7;
        C2C_MESSAGE_HANDLE_THREAD_NUMBER = 2;
        isUseNewRegisterProxy = true;
        isUsedMessageHandleThread = true;
        isRecvC2CEmptyPackage = false;
    }

    public RegisterProxyHandler(BaseMessageHandler baseMessageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseMessageHandler);
            return;
        }
        this.msgThread = null;
        this.messageHandleThreadLock = new Object();
        this.respMessageQueue = null;
        this.respC2CMessageQueue = null;
        this.registerProxyEnd = null;
        this.troopUinForRegisterProxyReq = null;
        this.discussionUinForRegisterProxyReq = null;
        this.registerProxyEndSeq = 0;
        this.registerProxyEndSeqNumTroop = 0;
        this.isPullCircleStop = false;
        this.regPrxyFailNum = 0;
        this.hasNewRegisterFirstEnd = false;
        this.hasNewRegisterFirstReceiveEnd = false;
        this.hasNewRegisterAllEnd = false;
        this.allMsgThreadEndLock = new AtomicBoolean(false);
        this.troopNum = 0;
        this.discussionNum = 0;
        this.recvTroopNum = 0;
        this.recvDiscNum = 0;
        this.prxyTroopList = new HashMap<>();
        this.prxyDiscussList = new HashMap<>();
        this.currentRegisterProxyRandom = 0L;
        this.mOptimizeFlag = 0;
        this.mMessageHandler = baseMessageHandler;
    }

    public void addProxyMsgToQueue(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg, obj);
            return;
        }
        startRegisterProxyThread();
        MessageObject messageObject = new MessageObject(i3, toServiceMsg, fromServiceMsg, obj);
        if (i3 == 1) {
            synchronized (this.respC2CMessageQueue) {
                this.respC2CMessageQueue.add(messageObject);
                this.respC2CMessageQueue.notify();
            }
            return;
        }
        synchronized (this.respMessageQueue) {
            this.respMessageQueue.add(messageObject);
            this.respMessageQueue.notify();
        }
    }

    public void cleanRegisterProxyRandom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(BaseMessageHandler.TAG, 2, "[ReSendProxy] cleanRegisterProxyRandom");
        }
        this.currentRegisterProxyRandom = 0L;
        this.mOptimizeFlag = 0;
    }

    public void handleNewRegisterProxyMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    public boolean isAllRegisterProxyTroopResponseDone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if ((isAllTroopThreadDone() && isTroopQueueEmpty()) || !isUsedMessageHandleThread) {
            return true;
        }
        return false;
    }

    public boolean isAllTroopThreadDone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        synchronized (this.messageHandleThreadLock) {
            MessageHandleThread[] messageHandleThreadArr = this.msgThread;
            if (messageHandleThreadArr != null && messageHandleThreadArr.length > 1) {
                int i3 = 1;
                while (true) {
                    MessageHandleThread[] messageHandleThreadArr2 = this.msgThread;
                    if (i3 >= messageHandleThreadArr2.length) {
                        return true;
                    }
                    MessageHandleThread messageHandleThread = messageHandleThreadArr2[i3];
                    if (messageHandleThread != null && messageHandleThread.isDoing()) {
                        return false;
                    }
                    i3++;
                }
            }
            return true;
        }
    }

    public boolean isFirstGroupMsgFin() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.hasNewRegisterFirstEnd && !this.isPullCircleStop) {
            ArrayList<MessageObject> arrayList = this.respMessageQueue;
            if (arrayList == null) {
                return true;
            }
            synchronized (arrayList) {
                Iterator<MessageObject> it = this.respMessageQueue.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().isFirstMsg) {
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(BaseMessageHandler.TAG, 2, "hasFirstGroupMsg flag =" + z16);
            }
            if (!z16) {
                this.hasNewRegisterFirstEnd = false;
                return true;
            }
        }
        return false;
    }

    public boolean isTroopQueueEmpty() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        ArrayList<MessageObject> arrayList = this.respMessageQueue;
        if (arrayList == null) {
            return true;
        }
        try {
            synchronized (arrayList) {
                if (this.respMessageQueue.size() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            return z16;
        } catch (Exception unused) {
            return true;
        }
    }

    public void sendNewRegisterProxy(long j3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    public void sendRegisterProxy(int i3, boolean z16, long j3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17));
            return;
        }
        if (i3 != 5) {
            return;
        }
        cleanRegisterProxyRandom();
        int abs = Math.abs(new Random(System.currentTimeMillis()).nextInt());
        QLog.d(BaseMessageHandler.TAG, 1, "sendRegisterProxy , type = " + i3 + " , needEndPkg = " + z16 + " , registerProxyRandom = " + j3 + " , isGetPassword = " + z17);
        ToServiceMsg createToServiceMsg = this.mMessageHandler.createToServiceMsg(BaseConstants.CMD_REGPRXYSVC_INFOLOGIN);
        createToServiceMsg.extraData.putLong("requestOptional", 1L);
        if (z16) {
            createToServiceMsg.extraData.putInt("endSeq", abs);
        }
        if (j3 != 0) {
            QLog.d(BaseMessageHandler.TAG, 1, "[ReSendProxy] RegisterProxyRandom = " + j3);
            this.currentRegisterProxyRandom = j3;
            createToServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_REGPRXY_RANDOM_CODE, Long.valueOf(j3));
        }
        createToServiceMsg.extraData.putInt("type", i3);
        createToServiceMsg.extraData.putBoolean("isGetPassword", z17);
        this.mMessageHandler.send(createToServiceMsg);
    }

    public void setCallback(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            this.mCallback = callback;
        }
    }

    public void startRegisterProxyThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!isUsedMessageHandleThread) {
            return;
        }
        synchronized (this.messageHandleThreadLock) {
            if (this.msgThread == null) {
                this.respMessageQueue = new ArrayList<>(20);
                this.respC2CMessageQueue = new ArrayList<>(10);
                this.msgThread = new MessageHandleThread[MAX_MESSAGE_HANDLE_THREAD_NUMBER];
            }
            int i3 = 0;
            while (true) {
                MessageHandleThread[] messageHandleThreadArr = this.msgThread;
                if (i3 < messageHandleThreadArr.length) {
                    MessageHandleThread messageHandleThread = messageHandleThreadArr[i3];
                    if (messageHandleThread == null || messageHandleThread.isClose()) {
                        if (i3 < C2C_MESSAGE_HANDLE_THREAD_NUMBER) {
                            this.msgThread[i3] = new MessageHandleThread(this, this.mMessageHandler, this.respC2CMessageQueue);
                        } else {
                            this.msgThread[i3] = new MessageHandleThread(this, this.mMessageHandler, this.respMessageQueue);
                        }
                        this.msgThread[i3].setName("MessageHandleThread" + (i3 + 1));
                        this.msgThread[i3].setPriority(5);
                        this.msgThread[i3].start();
                    }
                    i3++;
                }
            }
        }
    }

    public void stopRegisterProxyThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.messageHandleThreadLock) {
            if (this.msgThread != null) {
                int i3 = 0;
                while (true) {
                    MessageHandleThread[] messageHandleThreadArr = this.msgThread;
                    if (i3 >= messageHandleThreadArr.length) {
                        break;
                    }
                    messageHandleThreadArr[i3].close();
                    i3++;
                }
                synchronized (this.respMessageQueue) {
                    this.respMessageQueue.notifyAll();
                }
            }
            this.respC2CMessageQueue = null;
            this.respMessageQueue = null;
            this.msgThread = null;
        }
    }

    protected void addProxyMsgToQueue(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), toServiceMsg, fromServiceMsg, obj, Boolean.valueOf(z16));
            return;
        }
        startRegisterProxyThread();
        MessageObject messageObject = new MessageObject(i3, toServiceMsg, fromServiceMsg, obj, z16);
        if (i3 == 1) {
            synchronized (this.respC2CMessageQueue) {
                this.respC2CMessageQueue.add(messageObject);
                this.respC2CMessageQueue.notify();
            }
            return;
        }
        synchronized (this.respMessageQueue) {
            this.respMessageQueue.add(messageObject);
            this.respMessageQueue.notify();
        }
    }
}
