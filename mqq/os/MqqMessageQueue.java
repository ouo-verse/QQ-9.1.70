package mqq.os;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MqqMessageQueue implements Handler.Callback, MessageQueue.IdleHandler {
    private static boolean DEBUG_QUEUE = false;
    private static final int MSG_HOOK = 1000;
    private static final int MSG_IDLE_TIMEOUT = 1001;
    private static final String TAG = "MqqMessage.Queue";
    private static HighFreqLogUtil sLogUtil = new HighFreqLogUtil(2);
    public static boolean sRemoveIdleTimeOutMsg = true;
    private static MqqMessageQueue sSubMainQueue;
    Handler mHandler;
    Printer mLogging;
    MqqMessage mMessages;
    long totalCost = 0;
    long msgCount = 0;
    private volatile boolean hookReqeusted = false;
    private volatile boolean idleHandlerAttached = false;

    MqqMessageQueue(Looper looper) {
        this.mHandler = new Handler(looper, this) { // from class: mqq.os.MqqMessageQueue.1
            @Override // android.os.Handler
            public String toString() {
                return "MessageQueueHandler";
            }
        };
        if (MqqInjectorManager.instance().isDebugVersion()) {
            setDetailLogging(true);
        }
    }

    private void cancelHookReq() {
        this.mHandler.removeMessages(1000);
        this.hookReqeusted = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean dequeue(boolean z16) {
        String str;
        boolean z17;
        if (DEBUG_QUEUE && QLog.isColorLevel()) {
            sLogUtil.dSafe(TAG, 2, System.currentTimeMillis() + " enter dequeue, idle = " + z16);
        }
        MqqMessage next = next();
        if (next != null) {
            str = next.toString();
        } else {
            str = "null";
        }
        if (next != null) {
            try {
                if (this.mLogging != null) {
                    StringBuilder sb5 = new StringBuilder(256);
                    sb5.append(">>>>> Dispatching to ");
                    sb5.append(next.target);
                    sb5.append(" ");
                    sb5.append(next.wrappedMsg.getCallback());
                    sb5.append(MsgSummary.STR_COLON);
                    sb5.append(next.wrappedMsg.what);
                    this.mLogging.println(sb5.toString());
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                next.target.dispatchMessage(next.wrappedMsg);
                this.totalCost += SystemClock.uptimeMillis() - uptimeMillis;
                this.msgCount++;
                if (this.mLogging != null) {
                    StringBuilder sb6 = new StringBuilder(256);
                    sb6.append("<<<<< Finished to ");
                    sb6.append(next.target);
                    sb6.append(" ");
                    sb6.append(next.wrappedMsg.getCallback());
                    this.mLogging.println(sb6.toString());
                }
            } catch (Throwable th5) {
                th = th5;
                z17 = false;
            }
            try {
                next.recycle();
            } catch (Throwable th6) {
                th = th6;
                z17 = true;
                if (next.wrappedMsg != null && z17) {
                    String str2 = "current message: " + next.wrappedMsg.toString();
                    QLog.e(TAG, 1, str2);
                    CrashReport.handleCatchException(Thread.currentThread(), th, "ExtraMessage: " + str2, null);
                } else {
                    throwException(th, next);
                }
                if (DEBUG_QUEUE) {
                    QLog.d(TAG, 2, "dequeue|", Long.valueOf(this.msgCount), "|", Long.valueOf(this.totalCost));
                }
                if (next == null) {
                }
            }
        }
        if (DEBUG_QUEUE && this.msgCount % 100 == 0 && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "dequeue|", Long.valueOf(this.msgCount), "|", Long.valueOf(this.totalCost));
        }
        if (next == null) {
            if (DEBUG_QUEUE && QLog.isColorLevel()) {
                sLogUtil.dSafe(TAG, 2, System.currentTimeMillis() + " dequeue, msg = " + str);
            }
            return true;
        }
        if (DEBUG_QUEUE && QLog.isColorLevel()) {
            sLogUtil.dSafe(TAG, 2, System.currentTimeMillis() + " dequeue, msg = null");
        }
        return false;
    }

    public static synchronized MqqMessageQueue getSubMainThreadQueue() {
        MqqMessageQueue mqqMessageQueue;
        synchronized (MqqMessageQueue.class) {
            if (sSubMainQueue == null) {
                sSubMainQueue = new MqqMessageQueue(Looper.getMainLooper());
            }
            mqqMessageQueue = sSubMainQueue;
        }
        return mqqMessageQueue;
    }

    private final void onQueueIdleTimeout() {
        if (dequeue(false)) {
            this.mHandler.sendEmptyMessage(1001);
        } else if (sRemoveIdleTimeOutMsg) {
            QLog.d(TAG, 1, "onQueueIdleTimeout,remove all MSG_IDLE_TIMEOUT");
            this.mHandler.removeMessages(1001);
        }
    }

    private void printDeletionLog(MqqMessage mqqMessage) {
        if (DEBUG_QUEUE && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeMsg: " + mqqMessage.toString());
        }
    }

    private void reqHookIdleHandler() {
        if (DEBUG_QUEUE && QLog.isColorLevel()) {
            sLogUtil.dSafe(TAG, 2, System.currentTimeMillis() + " reqHook, attached = " + this.idleHandlerAttached + ", requested = " + this.hookReqeusted);
        }
        if (!this.idleHandlerAttached && !this.hookReqeusted) {
            this.hookReqeusted = true;
            this.mHandler.sendEmptyMessage(1000);
        } else {
            this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
        }
    }

    private void throwException(final Throwable th5, final MqqMessage mqqMessage) {
        new BaseThread() { // from class: mqq.os.MqqMessageQueue.2
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                StringBuilder sb5 = new StringBuilder("queueIdle encounter business crash.\n ");
                if (mqqMessage != null) {
                    sb5.append("msg.target=");
                    sb5.append(mqqMessage.target);
                    sb5.append(", ");
                    sb5.append("targetHandle=");
                    IMqqMessageCallback iMqqMessageCallback = mqqMessage.target;
                    if (iMqqMessageCallback instanceof MqqHandler) {
                        sb5.append(((MqqHandler) iMqqMessageCallback).mCallback);
                    } else if (iMqqMessageCallback instanceof MqqInterceptHandler) {
                        sb5.append(((MqqInterceptHandler) iMqqMessageCallback).mParentHandler);
                    }
                    sb5.append(", ");
                    if (mqqMessage.wrappedMsg != null) {
                        sb5.append("wrappedCallback=");
                        sb5.append(mqqMessage.wrappedMsg.getCallback());
                        sb5.append(", ");
                        sb5.append("wrappedWhat=");
                        sb5.append(mqqMessage.wrappedMsg.what);
                        sb5.append("\n");
                    }
                }
                sb5.append(Log.getStackTraceString(th5));
                throw new RuntimeException(sb5.toString());
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enqueueMessage(MqqMessage mqqMessage, long j3) {
        if (DEBUG_QUEUE && QLog.isColorLevel()) {
            sLogUtil.dSafe(TAG, 2, System.currentTimeMillis() + " enqueueMessage: " + mqqMessage.toString());
        }
        synchronized (this) {
            mqqMessage.when = j3;
            MqqMessage mqqMessage2 = this.mMessages;
            if (mqqMessage2 != null && j3 != 0 && j3 >= mqqMessage2.when) {
                MqqMessage mqqMessage3 = null;
                while (mqqMessage2 != null && mqqMessage2.when <= j3) {
                    mqqMessage3 = mqqMessage2;
                    mqqMessage2 = mqqMessage2.next;
                }
                mqqMessage.next = mqqMessage3.next;
                mqqMessage3.next = mqqMessage;
                reqHookIdleHandler();
            }
            mqqMessage.next = mqqMessage2;
            this.mMessages = mqqMessage;
            reqHookIdleHandler();
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (DEBUG_QUEUE && QLog.isColorLevel()) {
            sLogUtil.dSafe(TAG, 2, System.currentTimeMillis() + "handleMessage, what = " + message.what + ", attached = " + this.idleHandlerAttached);
        }
        int i3 = message.what;
        if (i3 == 1000) {
            if (!this.idleHandlerAttached) {
                cancelHookReq();
                this.idleHandlerAttached = true;
                this.mHandler.getLooper().getQueue().addIdleHandler(this);
            }
            this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
        } else if (i3 == 1001) {
            onQueueIdleTimeout();
        }
        return true;
    }

    final MqqMessage next() {
        synchronized (this) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MqqMessage mqqMessage = this.mMessages;
            if (mqqMessage != null) {
                long j3 = mqqMessage.when;
                if (uptimeMillis >= j3) {
                    this.mMessages = mqqMessage.next;
                    mqqMessage.next = null;
                    return mqqMessage;
                }
                int min = (int) Math.min(j3 - uptimeMillis, TTL.MAX_VALUE);
                this.mHandler.removeMessages(1000);
                this.mHandler.sendEmptyMessageDelayed(1000, min);
            }
            return null;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        this.mHandler.removeMessages(1001);
        boolean dequeue = dequeue(true);
        if (dequeue) {
            this.mHandler.sendEmptyMessage(1000);
        } else {
            this.idleHandlerAttached = false;
        }
        return dequeue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCallbacksAndMessages(MqqHandler mqqHandler, Object obj) {
        synchronized (this) {
            MqqMessage mqqMessage = this.mMessages;
            while (mqqMessage != null && mqqMessage.target == mqqHandler && (obj == null || mqqMessage.wrappedMsg.obj == obj)) {
                MqqMessage mqqMessage2 = mqqMessage.next;
                this.mMessages = mqqMessage2;
                printDeletionLog(mqqMessage);
                mqqMessage.recycle();
                mqqMessage = mqqMessage2;
            }
            while (mqqMessage != null) {
                MqqMessage mqqMessage3 = mqqMessage.next;
                if (mqqMessage3 != null && mqqMessage3.target == mqqHandler && (obj == null || mqqMessage3.wrappedMsg.obj == obj)) {
                    MqqMessage mqqMessage4 = mqqMessage3.next;
                    printDeletionLog(mqqMessage3);
                    mqqMessage3.recycle();
                    mqqMessage.next = mqqMessage4;
                } else {
                    mqqMessage = mqqMessage3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void removeMessages(MqqHandler mqqHandler, Runnable runnable, Object obj) {
        if (runnable == null) {
            return;
        }
        synchronized (this) {
            MqqMessage mqqMessage = this.mMessages;
            while (mqqMessage != null && mqqMessage.target == mqqHandler && mqqMessage.wrappedMsg.getCallback() == runnable && (obj == null || mqqMessage.wrappedMsg.obj == obj)) {
                MqqMessage mqqMessage2 = mqqMessage.next;
                this.mMessages = mqqMessage2;
                printDeletionLog(mqqMessage);
                mqqMessage.recycle();
                mqqMessage = mqqMessage2;
            }
            while (mqqMessage != null) {
                MqqMessage mqqMessage3 = mqqMessage.next;
                if (mqqMessage3 != null && mqqMessage3.target == mqqHandler && mqqMessage3.wrappedMsg.getCallback() == runnable && (obj == null || mqqMessage3.wrappedMsg.obj == obj)) {
                    MqqMessage mqqMessage4 = mqqMessage3.next;
                    printDeletionLog(mqqMessage3);
                    mqqMessage3.recycle();
                    mqqMessage.next = mqqMessage4;
                } else {
                    mqqMessage = mqqMessage3;
                }
            }
        }
    }

    public void setDetailLogging(boolean z16) {
        DEBUG_QUEUE = z16;
        MqqMessage.DEBUG_MESSAGE = z16;
    }

    public void setMessageLogging(Printer printer) {
        this.mLogging = printer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeMessages(MqqHandler mqqHandler, int i3, Object obj, boolean z16) {
        synchronized (this) {
            MqqMessage mqqMessage = this.mMessages;
            boolean z17 = false;
            while (mqqMessage != null && mqqMessage.target == mqqHandler) {
                Message message = mqqMessage.wrappedMsg;
                if (message.what != i3 || (obj != null && message.obj != obj)) {
                    break;
                }
                if (!z16) {
                    return true;
                }
                MqqMessage mqqMessage2 = mqqMessage.next;
                this.mMessages = mqqMessage2;
                printDeletionLog(mqqMessage);
                mqqMessage.recycle();
                mqqMessage = mqqMessage2;
                z17 = true;
            }
            while (mqqMessage != null) {
                MqqMessage mqqMessage3 = mqqMessage.next;
                if (mqqMessage3 != null && mqqMessage3.target == mqqHandler) {
                    Message message2 = mqqMessage3.wrappedMsg;
                    if (message2.what == i3 && (obj == null || message2.obj == obj)) {
                        if (!z16) {
                            return true;
                        }
                        MqqMessage mqqMessage4 = mqqMessage3.next;
                        printDeletionLog(mqqMessage3);
                        mqqMessage3.recycle();
                        mqqMessage.next = mqqMessage4;
                        z17 = true;
                    }
                }
                mqqMessage = mqqMessage3;
            }
            return z17;
        }
    }
}
