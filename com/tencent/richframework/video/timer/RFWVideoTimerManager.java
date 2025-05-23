package com.tencent.richframework.video.timer;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWVideoTimerManager {
    private static final long PERIOD = RFWConfig.getConfigValue("rfw_video_time_manager_period", 8L);
    private static volatile RFWVideoTimerManager sInstance;
    private final Handler mHandler = RFWThreadManager.createNewThreadHandler("RFWVideoTimerManager", 0, new Handler.Callback() { // from class: com.tencent.richframework.video.timer.RFWVideoTimerManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                RFWVideoTimerManager.this.handlerRegister((IPlayerTimerCallback) message.obj);
                return false;
            }
            if (i3 == 2) {
                RFWVideoTimerManager.this.handlerUnRegister((IPlayerTimerCallback) message.obj);
                return false;
            }
            if (i3 == 3) {
                RFWVideoTimerManager.this.handlerTimerCallBack();
                return false;
            }
            return false;
        }
    });
    private final CopyOnWriteArrayList<WeakReference<IPlayerTimerCallback>> mWeakListeners = new CopyOnWriteArrayList<>();

    RFWVideoTimerManager() {
    }

    private void addTimerListener(IPlayerTimerCallback iPlayerTimerCallback) {
        if (iPlayerTimerCallback == null) {
            RFWLog.d("RFWVideoTimerManager", RFWLog.USR, "[addTimerListener] listener should not be null.");
            return;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.i("RFWVideoTimerManager", RFWLog.DEV, "[addTimerListener] listener: " + iPlayerTimerCallback);
        }
        this.mWeakListeners.add(new WeakReference<>(iPlayerTimerCallback));
    }

    @Nullable
    private WeakReference<IPlayerTimerCallback> findListenerForWeakObj(IPlayerTimerCallback iPlayerTimerCallback) {
        if (iPlayerTimerCallback == null) {
            return null;
        }
        Iterator<WeakReference<IPlayerTimerCallback>> it = this.mWeakListeners.iterator();
        while (it.hasNext()) {
            WeakReference<IPlayerTimerCallback> next = it.next();
            if (next != null && next.get() == iPlayerTimerCallback) {
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
    public void handlerRegister(IPlayerTimerCallback iPlayerTimerCallback) {
        if (iPlayerTimerCallback == null) {
            return;
        }
        addTimerListener(iPlayerTimerCallback);
        RFWLog.i("RFWVideoTimerManager", RFWLog.USR, "handlerRegister, listener size:" + this.mWeakListeners.size());
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
            Iterator<WeakReference<IPlayerTimerCallback>> it = this.mWeakListeners.iterator();
            while (it.hasNext()) {
                WeakReference<IPlayerTimerCallback> next = it.next();
                if (next != null && next.get() != null) {
                    next.get().onTimerCallback();
                }
            }
        } catch (Throwable th5) {
            RFWLog.d("RFWVideoTimerManager", RFWLog.DEV, "error: ", th5);
        }
        handlerNextTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerUnRegister(IPlayerTimerCallback iPlayerTimerCallback) {
        if (iPlayerTimerCallback == null) {
            return;
        }
        removeTimerListener(iPlayerTimerCallback);
        RFWLog.i("RFWVideoTimerManager", RFWLog.USR, "[handlerUnRegister], listener size:" + this.mWeakListeners.size());
        if (this.mWeakListeners.size() == 0) {
            this.mHandler.removeMessages(3);
        }
    }

    private void removeTimerListener(IPlayerTimerCallback iPlayerTimerCallback) {
        WeakReference<IPlayerTimerCallback> findListenerForWeakObj = findListenerForWeakObj(iPlayerTimerCallback);
        if (findListenerForWeakObj == null) {
            return;
        }
        RFWLog.i("RFWVideoTimerManager", RFWLog.USR, "[removeTimerListener] listener: " + iPlayerTimerCallback);
        this.mWeakListeners.remove(findListenerForWeakObj);
    }

    public void registerTimerListener(IPlayerTimerCallback iPlayerTimerCallback) {
        if (iPlayerTimerCallback == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iPlayerTimerCallback;
        this.mHandler.sendMessage(obtain);
        RFWLog.i("RFWVideoTimerManager", RFWLog.DEV, "[registerTimerListener] listener: " + iPlayerTimerCallback);
    }

    public void unRegisterTimerListener(IPlayerTimerCallback iPlayerTimerCallback) {
        if (iPlayerTimerCallback == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = iPlayerTimerCallback;
        this.mHandler.sendMessage(obtain);
        RFWLog.i("RFWVideoTimerManager", RFWLog.USR, "[unRegisterTimerListener] listener: " + iPlayerTimerCallback);
    }
}
