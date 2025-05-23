package com.tencent.thumbplayer.utils.timer;

import android.os.Handler;
import android.os.Message;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes26.dex */
public class TPVideoTimerManager {
    private static final int MSG_PERIOD_TIMER = 3;
    private static final int MSG_REGISTER_TIMER = 1;
    private static final int MSG_UNREGISTER_TIMER = 2;
    private static final long PERIOD = 500;
    private static final String TAG = "TPVideoTimerManager";
    private static final int TRIGGER_TIMER_CANCEL_SIZE = 0;
    private static final int TRIGGER_TIMER_START_SIZE = 1;
    private static volatile TPVideoTimerManager sInstance;
    private final Handler mHandler = new Handler(TPThreadPool.getInstance().obtainHandleThread(TAG).getLooper(), new Handler.Callback() { // from class: com.tencent.thumbplayer.utils.timer.TPVideoTimerManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                TPVideoTimerManager.this.handlerRegister((ITPVideoTimerListener) message.obj);
                return false;
            }
            if (i3 == 2) {
                TPVideoTimerManager.this.handlerUnRegister((ITPVideoTimerListener) message.obj);
                return false;
            }
            if (i3 == 3) {
                TPVideoTimerManager.this.handlerTimerCallBack();
                return false;
            }
            return false;
        }
    });
    private final CopyOnWriteArrayList<WeakReference<ITPVideoTimerListener>> mWeakListeners = new CopyOnWriteArrayList<>();

    TPVideoTimerManager() {
    }

    private void addTimerListener(ITPVideoTimerListener iTPVideoTimerListener) {
        if (iTPVideoTimerListener == null) {
            TPLogUtil.d(TAG, "[addTimerListener] listener should not be null.");
            return;
        }
        Iterator<WeakReference<ITPVideoTimerListener>> it = this.mWeakListeners.iterator();
        while (it.hasNext()) {
            if (iTPVideoTimerListener == it.next().get()) {
                TPLogUtil.i(TAG, "[addTimerListener] duplicate: ");
                return;
            }
        }
        TPLogUtil.i(TAG, "[addTimerListener] listener: " + iTPVideoTimerListener);
        this.mWeakListeners.add(new WeakReference<>(iTPVideoTimerListener));
    }

    private WeakReference<ITPVideoTimerListener> findListenerForWeakObj(ITPVideoTimerListener iTPVideoTimerListener) {
        if (iTPVideoTimerListener == null) {
            return null;
        }
        Iterator<WeakReference<ITPVideoTimerListener>> it = this.mWeakListeners.iterator();
        while (it.hasNext()) {
            WeakReference<ITPVideoTimerListener> next = it.next();
            if (next != null && next.get() == iTPVideoTimerListener) {
                return next;
            }
        }
        return null;
    }

    public static TPVideoTimerManager g() {
        if (sInstance == null) {
            synchronized (TPVideoTimerManager.class) {
                if (sInstance == null) {
                    sInstance = new TPVideoTimerManager();
                }
            }
        }
        return sInstance;
    }

    private void handlerNextTimer() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.mHandler.sendMessageDelayed(obtain, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerRegister(ITPVideoTimerListener iTPVideoTimerListener) {
        if (iTPVideoTimerListener == null) {
            return;
        }
        addTimerListener(iTPVideoTimerListener);
        TPLogUtil.i(TAG, "handlerRegister, listener size:" + this.mWeakListeners.size());
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
            Iterator<WeakReference<ITPVideoTimerListener>> it = this.mWeakListeners.iterator();
            while (it.hasNext()) {
                WeakReference<ITPVideoTimerListener> next = it.next();
                if (next != null && next.get() != null) {
                    next.get().onTimerCallback();
                }
            }
        } catch (Throwable th5) {
            TPLogUtil.d(TAG, th5.toString());
        }
        handlerNextTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerUnRegister(ITPVideoTimerListener iTPVideoTimerListener) {
        if (iTPVideoTimerListener == null) {
            return;
        }
        removeTimerListener(iTPVideoTimerListener);
        TPLogUtil.i(TAG, "[handlerUnRegister], listener size:" + this.mWeakListeners.size());
        if (this.mWeakListeners.size() == 0) {
            this.mHandler.removeMessages(3);
        }
    }

    private void removeTimerListener(ITPVideoTimerListener iTPVideoTimerListener) {
        WeakReference<ITPVideoTimerListener> findListenerForWeakObj = findListenerForWeakObj(iTPVideoTimerListener);
        if (findListenerForWeakObj == null) {
            return;
        }
        TPLogUtil.i(TAG, "[removeTimerListener] listener: " + iTPVideoTimerListener);
        this.mWeakListeners.remove(findListenerForWeakObj);
    }

    public void registerTimerListener(ITPVideoTimerListener iTPVideoTimerListener) {
        if (iTPVideoTimerListener == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iTPVideoTimerListener;
        this.mHandler.sendMessage(obtain);
        TPLogUtil.i(TAG, "[registerTimerListener] listener: " + iTPVideoTimerListener);
    }

    public void unRegisterTimerListener(ITPVideoTimerListener iTPVideoTimerListener) {
        if (iTPVideoTimerListener == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = iTPVideoTimerListener;
        this.mHandler.sendMessage(obtain);
    }
}
