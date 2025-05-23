package com.qzone.module.feedcomponent.util;

import android.os.Handler;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlarmTask implements Runnable {
    public static final int TRIGGER_TIME = 1000;
    private OnAlarmListener mAlarmListener;
    public MotionEvent mEvent;
    private Handler mHandler = new Handler();
    private long mTriggerTime;
    private boolean needCallback;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnAlarmListener {
        void onAlarm(AlarmTask alarmTask);
    }

    public void setAlarmListener(OnAlarmListener onAlarmListener) {
        this.mAlarmListener = onAlarmListener;
    }

    public void setTriggerTime(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = j3 + currentTimeMillis;
        this.mTriggerTime = j16;
        if (this.needCallback) {
            return;
        }
        this.mHandler.postDelayed(this, j16 - currentTimeMillis);
        this.needCallback = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.needCallback = false;
        if (this.mTriggerTime != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.mTriggerTime;
            if (j3 > currentTimeMillis) {
                this.mHandler.postDelayed(this, Math.max(0L, j3 - currentTimeMillis));
                this.needCallback = true;
            } else {
                OnAlarmListener onAlarmListener = this.mAlarmListener;
                if (onAlarmListener != null) {
                    onAlarmListener.onAlarm(this);
                }
            }
        }
    }

    public void cancelAlarm() {
        this.mTriggerTime = 0L;
    }
}
