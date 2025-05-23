package cooperation.qzone.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Printer;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BaseHandler extends Handler {
    private static final String TAG = "BaseHandler";
    private static final long Time_Lv1 = 20;
    private static final long Time_Lv2 = 100;
    private static final long Time_Lv3 = 500;
    static volatile boolean isBusy;
    private Handler.Callback mCallbackEx;
    static ThreadLocal<Integer> InitalPriority = new ThreadLocal<Integer>() { // from class: cooperation.qzone.thread.BaseHandler.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Integer initialValue() {
            return -100;
        }
    };
    static ThreadLocal<Boolean> isRegulated = new ThreadLocal<Boolean>() { // from class: cooperation.qzone.thread.BaseHandler.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    static AtomicInteger regulalteCount = new AtomicInteger(0);
    static Runnable regultorPriority = new Runnable() { // from class: cooperation.qzone.thread.BaseHandler.4
        @Override // java.lang.Runnable
        public void run() {
            int i3;
            try {
                Long valueOf = Long.valueOf(Thread.currentThread().getId());
                int threadPriority = Process.getThreadPriority(Process.myTid());
                BaseHandler.InitalPriority.set(Integer.valueOf(threadPriority));
                BaseHandler.isRegulated.set(Boolean.TRUE);
                if (BaseHandler.setThreadPrioriry(BaseHandler.getRegulatePriority(Thread.currentThread().getName()))) {
                    i3 = BaseHandler.regulalteCount.incrementAndGet();
                } else {
                    i3 = BaseHandler.regulalteCount.get();
                }
                QLog.i(BaseHandler.TAG, 1, "regultorPriority ThreadName:" + Thread.currentThread().getName() + "(" + valueOf + ") currentPriority: " + threadPriority + ",changed:" + Process.getThreadPriority(Process.myTid()) + " regulated:" + i3);
            } catch (Exception e16) {
                QLog.w(BaseHandler.TAG, 1, "", e16);
            }
        }
    };
    static Runnable resetPriority = new Runnable() { // from class: cooperation.qzone.thread.BaseHandler.5
        @Override // java.lang.Runnable
        public void run() {
            int i3;
            try {
                int intValue = BaseHandler.InitalPriority.get().intValue();
                int threadPriority = Process.getThreadPriority(Process.myTid());
                long id5 = Thread.currentThread().getId();
                BaseHandler.isRegulated.set(Boolean.FALSE);
                BaseHandler.InitalPriority.remove();
                BaseHandler.setThreadPrioriry(intValue);
                if (BaseHandler.setThreadPrioriry(intValue)) {
                    i3 = BaseHandler.regulalteCount.decrementAndGet();
                } else {
                    i3 = BaseHandler.regulalteCount.get();
                }
                Looper myLooper = Looper.myLooper();
                if (myLooper != null) {
                    myLooper.setMessageLogging(null);
                }
                QLog.i(BaseHandler.TAG, 1, "resetPriority ThreadName:" + Thread.currentThread().getName() + "(" + id5 + ") currentPriority: " + threadPriority + ",changed:" + Process.getThreadPriority(Process.myTid()) + " regulated:" + i3);
            } catch (Exception e16) {
                QLog.w(BaseHandler.TAG, 1, "", e16);
            }
        }
    };

    public BaseHandler() {
    }

    private void checkBusyState() {
        if (isBusy && !isRegulated.get().booleanValue()) {
            regultorPriority.run();
        } else if (!isBusy && isRegulated.get().booleanValue()) {
            resetPriority.run();
        }
    }

    static /* bridge */ /* synthetic */ boolean d() {
        return needRegulated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterWord() {
        checkBusyState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBeforWork() {
        checkBusyState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getRegulatePriority(String str) {
        if (QzoneHandlerThreadFactory.BusinessThread.equals(str)) {
            return -1;
        }
        return 10;
    }

    public static void markBusyState() {
        QLog.i(TAG, 2, "markBusyState");
        isBusy = true;
    }

    private static boolean needRegulated() {
        boolean z16;
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_THREAD_REGULATED_ENABEL, 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Looper.getMainLooper() != Looper.myLooper()) {
            return true;
        }
        return false;
    }

    private void printDispatchInfo(long j3, Message message) {
        String str;
        String str2 = " Message What:";
        try {
            str2 = " Message What:" + message.what;
            if (message.getCallback() != null) {
                str = str2 + " Runnable-" + message.getCallback().getClass().toString();
            } else if (this.mCallbackEx != null) {
                str = str2 + " Callback-" + this.mCallbackEx.getClass().toString();
            } else {
                str = str2 + " handleMessage-" + getClass().toString();
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "printDispatchInfo", e16);
            str = str2;
        }
        String str3 = "DispatchMessage-" + Thread.currentThread().getName() + ":";
        if (j3 > 500) {
            QLog.e(TAG, 1, str3 + j3 + "ms " + str);
            return;
        }
        if (j3 > 100) {
            QLog.w(TAG, 1, str3 + j3 + "ms " + str);
            return;
        }
        if (j3 > 20) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, str3 + j3 + "ms " + str);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, str3 + j3 + "ms " + str);
        }
    }

    private void printSendInfo(long j3, Message message) {
        String str;
        String str2 = " Message What:";
        try {
            str2 = " Message What:" + message.what;
            if (message.getCallback() != null) {
                str = str2 + " Runnable-" + message.getCallback().getClass().toString();
            } else if (this.mCallbackEx != null) {
                str = str2 + " Callback-" + this.mCallbackEx.getClass().toString();
            } else {
                str = str2 + " handleMessage-" + getClass().toString();
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "printSendInfo", e16);
            str = str2;
        }
        String str3 = " SendMessage-" + Thread.currentThread().getName() + ":";
        if (j3 > 500) {
            QLog.e(TAG, 1, str3 + j3 + "ms " + str);
            return;
        }
        if (j3 > 100) {
            QLog.w(TAG, 1, str3 + j3 + "ms " + str);
            return;
        }
        if (j3 > 20) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, str3 + j3 + "ms " + str);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, str3 + j3 + "ms " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean setThreadPrioriry(int i3) {
        if (i3 >= -19 && i3 <= 19) {
            Process.setThreadPriority(i3);
            QLog.i(TAG, 1, "setThreadPrioriry priority :" + i3);
            return true;
        }
        QLog.w(TAG, 1, "setThreadPrioriry priority \u975e\u6cd5:" + i3);
        return false;
    }

    public static void unMarkBusyState() {
        QLog.i(TAG, 2, "unMarkBusyState");
        isBusy = false;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    public Handler.Callback getCallbackEx() {
        return this.mCallbackEx;
    }

    @Override // android.os.Handler
    public boolean sendMessageAtTime(Message message, long j3) {
        return super.sendMessageAtTime(message, j3);
    }

    public BaseHandler(Looper looper) {
        super(looper);
        if (looper == null || Looper.getMainLooper() == looper) {
            return;
        }
        looper.setMessageLogging(new Printer() { // from class: cooperation.qzone.thread.BaseHandler.1
            @Override // android.util.Printer
            public void println(String str) {
                if (!BaseHandler.isBusy && !BaseHandler.isRegulated.get().booleanValue()) {
                    return;
                }
                if (!BaseHandler.d()) {
                    Looper.myLooper().setMessageLogging(null);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(BaseHandler.TAG, 2, str);
                }
                if (str != null && str.contains(">>>>> Dispatching to")) {
                    BaseHandler.this.doBeforWork();
                }
                if (str != null && str.contains("<<<<< Finished to")) {
                    BaseHandler.this.doAfterWord();
                }
            }
        });
    }

    public BaseHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.mCallbackEx = callback;
    }
}
