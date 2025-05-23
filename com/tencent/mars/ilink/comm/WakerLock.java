package com.tencent.mars.ilink.comm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import com.tencent.mars.ilink.xlog.Log;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WakerLock {
    private static final String TAG = "MicroMsg.WakerLock";
    private Handler mHandler;
    private Runnable mReleaser = new Runnable() { // from class: com.tencent.mars.ilink.comm.WakerLock.1
        @Override // java.lang.Runnable
        public void run() {
            WakerLock.this.unLock();
        }
    };
    private PowerManager.WakeLock wakeLock;

    @SuppressLint({"InvalidWakeLockTag"})
    public WakerLock(Context context) {
        this.wakeLock = null;
        this.mHandler = null;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, TAG);
        this.wakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        this.mHandler = new Handler(context.getMainLooper());
    }

    public void finalize() throws Throwable {
        unLock();
    }

    public boolean isLocking() {
        try {
            return this.wakeLock.isHeld();
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void lock(long j3) {
        try {
            if (j3 == -1) {
                this.wakeLock.acquire();
                Log.w(TAG, "acquire wakelock without timeout, msg:");
            } else {
                this.wakeLock.acquire(j3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void unLock() {
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            if (this.wakeLock.isHeld()) {
                this.wakeLock.release();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void lock() {
        try {
            this.mHandler.removeCallbacks(this.mReleaser);
            lock(-1L);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
