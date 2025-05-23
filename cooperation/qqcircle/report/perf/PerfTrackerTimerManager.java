package cooperation.qqcircle.report.perf;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public class PerfTrackerTimerManager {
    private static final int MSG_PERIOD_TIMER = 3;
    private static final int MSG_REGISTER_TIMER = 1;
    private static final int MSG_UNREGISTER_TIMER = 2;
    private static final long PERIOD = 1000;
    private static final String TAG = "RFWVideoTimerManager";
    private static final int TRIGGER_TIMER_CANCEL_SIZE = 0;
    private static final int TRIGGER_TIMER_START_SIZE = 1;
    private static volatile PerfTrackerTimerManager sInstance;
    private final Handler mHandler = RFWThreadManager.createNewThreadHandler("QCircleVideoTimerManager", 0, new Handler.Callback() { // from class: cooperation.qqcircle.report.perf.PerfTrackerTimerManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                PerfTrackerTimerManager.this.handlerRegister((ITimerListener) message.obj);
                return false;
            }
            if (i3 == 2) {
                PerfTrackerTimerManager.this.handlerUnRegister((ITimerListener) message.obj);
                return false;
            }
            if (i3 == 3) {
                PerfTrackerTimerManager.this.handlerTimerCallBack();
                return false;
            }
            return false;
        }
    });
    private final CopyOnWriteArrayList<WeakReference<ITimerListener>> mWeakListeners = new CopyOnWriteArrayList<>();

    PerfTrackerTimerManager() {
    }

    private void addTimerListener(ITimerListener iTimerListener) {
        if (iTimerListener == null) {
            QLog.d(TAG, 1, "[addTimerListener] listener should not be null.");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 4, "[addTimerListener] listener: " + iTimerListener);
        }
        this.mWeakListeners.add(new WeakReference<>(iTimerListener));
    }

    @Nullable
    private WeakReference<ITimerListener> findListenerForWeakObj(ITimerListener iTimerListener) {
        if (iTimerListener == null) {
            return null;
        }
        Iterator<WeakReference<ITimerListener>> it = this.mWeakListeners.iterator();
        while (it.hasNext()) {
            WeakReference<ITimerListener> next = it.next();
            if (next != null && next.get() == iTimerListener) {
                return next;
            }
        }
        return null;
    }

    public static PerfTrackerTimerManager g() {
        if (sInstance == null) {
            synchronized (PerfTrackerTimerManager.class) {
                if (sInstance == null) {
                    sInstance = new PerfTrackerTimerManager();
                }
            }
        }
        return sInstance;
    }

    private void handlerNextTimer() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.mHandler.sendMessageDelayed(obtain, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerRegister(ITimerListener iTimerListener) {
        if (iTimerListener == null) {
            return;
        }
        addTimerListener(iTimerListener);
        QLog.i(TAG, 1, "handlerRegister, listener size:" + this.mWeakListeners.size());
        if (this.mWeakListeners.size() == 1) {
            handlerTimerCallBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerTimerCallBack() {
        if (this.mWeakListeners.size() <= 0) {
            return;
        }
        try {
            Iterator<WeakReference<ITimerListener>> it = this.mWeakListeners.iterator();
            while (it.hasNext()) {
                WeakReference<ITimerListener> next = it.next();
                if (next != null && next.get() != null) {
                    next.get().onTimerCallback();
                }
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 4, "error: ", th5);
        }
        handlerNextTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerUnRegister(ITimerListener iTimerListener) {
        if (iTimerListener == null) {
            return;
        }
        removeTimerListener(iTimerListener);
        QLog.i(TAG, 1, "[handlerUnRegister], listener size:" + this.mWeakListeners.size());
        if (this.mWeakListeners.size() == 0) {
            this.mHandler.removeMessages(3);
        }
    }

    private void removeTimerListener(ITimerListener iTimerListener) {
        WeakReference<ITimerListener> findListenerForWeakObj = findListenerForWeakObj(iTimerListener);
        if (findListenerForWeakObj == null) {
            return;
        }
        QLog.i(TAG, 1, "[removeTimerListener] listener: " + iTimerListener);
        this.mWeakListeners.remove(findListenerForWeakObj);
    }

    public void registerTimerListener(ITimerListener iTimerListener) {
        if (iTimerListener == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iTimerListener;
        this.mHandler.sendMessage(obtain);
        QLog.i(TAG, 4, "[registerTimerListener] listener: " + iTimerListener);
    }

    public void unRegisterTimerListener(ITimerListener iTimerListener) {
        if (iTimerListener == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = iTimerListener;
        this.mHandler.sendMessage(obtain);
        QLog.i(TAG, 1, "[unRegisterTimerListener] listener: " + iTimerListener);
    }
}
