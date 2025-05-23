package com.tencent.biz.richframework.video.timer;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoTimerManager {
    private static final long PERIOD = c.V0();
    private static volatile RFWVideoTimerManager sInstance;
    private final Handler mHandler = RFWThreadManager.createNewThreadHandler("QCircleVideoTimerManager", 0, new Handler.Callback() { // from class: com.tencent.biz.richframework.video.timer.RFWVideoTimerManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                RFWVideoTimerManager.this.handlerRegister((IRFWVideoTimerListener) message.obj);
                return false;
            }
            if (i3 == 2) {
                RFWVideoTimerManager.this.handlerUnRegister((IRFWVideoTimerListener) message.obj);
                return false;
            }
            if (i3 == 3) {
                RFWVideoTimerManager.this.handlerTimerCallBack();
                return false;
            }
            return false;
        }
    });
    private final CopyOnWriteArrayList<WeakReference<IRFWVideoTimerListener>> mWeakListeners = new CopyOnWriteArrayList<>();

    RFWVideoTimerManager() {
    }

    private void addTimerListener(IRFWVideoTimerListener iRFWVideoTimerListener) {
        if (iRFWVideoTimerListener == null) {
            QLog.d("RFWVideoTimerManager", 1, "[addTimerListener] listener should not be null.");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RFWVideoTimerManager", 4, "[addTimerListener] listener: " + iRFWVideoTimerListener);
        }
        this.mWeakListeners.add(new WeakReference<>(iRFWVideoTimerListener));
    }

    @Nullable
    private WeakReference<IRFWVideoTimerListener> findListenerForWeakObj(IRFWVideoTimerListener iRFWVideoTimerListener) {
        if (iRFWVideoTimerListener == null) {
            return null;
        }
        Iterator<WeakReference<IRFWVideoTimerListener>> it = this.mWeakListeners.iterator();
        while (it.hasNext()) {
            WeakReference<IRFWVideoTimerListener> next = it.next();
            if (next != null && next.get() == iRFWVideoTimerListener) {
                return next;
            }
        }
        return null;
    }

    public static RFWVideoTimerManager g() {
        if (sInstance == null) {
            synchronized (RFWVideoTimerManager.class) {
                if (sInstance == null) {
                    sInstance = new RFWVideoTimerManager();
                }
            }
        }
        return sInstance;
    }

    private void handlerNextTimer() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.mHandler.sendMessageDelayed(obtain, PERIOD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerRegister(IRFWVideoTimerListener iRFWVideoTimerListener) {
        if (iRFWVideoTimerListener == null) {
            return;
        }
        addTimerListener(iRFWVideoTimerListener);
        QLog.i("RFWVideoTimerManager", 1, "handlerRegister, listener size:" + this.mWeakListeners.size());
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
            Iterator<WeakReference<IRFWVideoTimerListener>> it = this.mWeakListeners.iterator();
            while (it.hasNext()) {
                WeakReference<IRFWVideoTimerListener> next = it.next();
                if (next != null && next.get() != null) {
                    next.get().onTimerCallback();
                }
            }
        } catch (Throwable th5) {
            QLog.d("RFWVideoTimerManager", 4, "error: ", th5);
        }
        handlerNextTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerUnRegister(IRFWVideoTimerListener iRFWVideoTimerListener) {
        if (iRFWVideoTimerListener == null) {
            return;
        }
        removeTimerListener(iRFWVideoTimerListener);
        QLog.i("RFWVideoTimerManager", 1, "[handlerUnRegister], listener size:" + this.mWeakListeners.size());
        if (this.mWeakListeners.size() == 0) {
            this.mHandler.removeMessages(3);
        }
    }

    private void removeTimerListener(IRFWVideoTimerListener iRFWVideoTimerListener) {
        WeakReference<IRFWVideoTimerListener> findListenerForWeakObj = findListenerForWeakObj(iRFWVideoTimerListener);
        if (findListenerForWeakObj == null) {
            return;
        }
        QLog.i("RFWVideoTimerManager", 1, "[removeTimerListener] listener: " + iRFWVideoTimerListener);
        this.mWeakListeners.remove(findListenerForWeakObj);
    }

    public void registerTimerListener(IRFWVideoTimerListener iRFWVideoTimerListener) {
        if (iRFWVideoTimerListener == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iRFWVideoTimerListener;
        this.mHandler.sendMessage(obtain);
        QLog.i("RFWVideoTimerManager", 4, "[registerTimerListener] listener: " + iRFWVideoTimerListener);
    }

    public void unRegisterTimerListener(IRFWVideoTimerListener iRFWVideoTimerListener) {
        if (iRFWVideoTimerListener == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = iRFWVideoTimerListener;
        this.mHandler.sendMessage(obtain);
    }
}
