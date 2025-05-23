package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.theme.ThemeConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HandlerTimer {
    private final int HANDLER_TIMER_MAX_INDEX;
    private Handler mTimerHandler;
    private HashMap<Integer, Integer> mTimerIds;
    private OnTimerListener mTimerListener;
    private int mTimerRunIndex;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface OnTimerListener {
        boolean onTime(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class TimerHandler extends Handler {
        private final WeakReference<HandlerTimer> mWeakHandlerTimer;
        private final WeakReference<OnTimerListener> mWeakOnListener;

        public TimerHandler(Looper looper, HandlerTimer handlerTimer, OnTimerListener onTimerListener) {
            super(looper);
            this.mWeakHandlerTimer = new WeakReference<>(handlerTimer);
            this.mWeakOnListener = new WeakReference<>(onTimerListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnTimerListener onTimerListener;
            boolean z16 = false;
            try {
                HandlerTimer handlerTimer = this.mWeakHandlerTimer.get();
                if (handlerTimer != null && message != null) {
                    int i3 = message.what;
                    int i16 = message.arg1;
                    if (handlerTimer.hasTimerIds() && handlerTimer.getIndexByTimerId(i3) == i16) {
                        handlerTimer.removeTimerId(i3);
                        WeakReference<OnTimerListener> weakReference = this.mWeakOnListener;
                        if (weakReference != null && (onTimerListener = weakReference.get()) != null) {
                            z16 = onTimerListener.onTime(i3);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (!z16) {
                super.handleMessage(message);
            }
        }
    }

    public HandlerTimer(OnTimerListener onTimerListener) {
        this(Looper.getMainLooper(), onTimerListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getIndexByTimerId(int i3) {
        HashMap<Integer, Integer> hashMap = this.mTimerIds;
        if (hashMap != null) {
            return hashMap.get(Integer.valueOf(i3)).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasTimerIds() {
        HashMap<Integer, Integer> hashMap = this.mTimerIds;
        if (hashMap != null && hashMap.size() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTimerId(int i3) {
        HashMap<Integer, Integer> hashMap = this.mTimerIds;
        if (hashMap != null) {
            hashMap.remove(Integer.valueOf(i3));
        }
    }

    public boolean startTimer(int i3, int i16) {
        HashMap<Integer, Integer> hashMap = this.mTimerIds;
        if (hashMap != null && !hashMap.containsKey(Integer.valueOf(i3))) {
            int i17 = (this.mTimerRunIndex + 1) % ThemeConstants.ZIP_VERSION;
            this.mTimerRunIndex = i17;
            this.mTimerIds.put(Integer.valueOf(i3), Integer.valueOf(i17));
            Message obtain = Message.obtain(this.mTimerHandler);
            obtain.what = i3;
            obtain.arg1 = this.mTimerRunIndex;
            this.mTimerHandler.sendMessageDelayed(obtain, i16);
        }
        return true;
    }

    public void stopTimer(int i3) {
        HashMap<Integer, Integer> hashMap = this.mTimerIds;
        if (hashMap != null) {
            hashMap.remove(Integer.valueOf(i3));
        }
    }

    public HandlerTimer(Looper looper, OnTimerListener onTimerListener) {
        this.HANDLER_TIMER_MAX_INDEX = ThemeConstants.ZIP_VERSION;
        this.mTimerRunIndex = 0;
        this.mTimerListener = onTimerListener;
        this.mTimerHandler = new TimerHandler(looper, this, this.mTimerListener);
        this.mTimerIds = new HashMap<>();
    }
}
