package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.t.m.g.l3;
import c.t.m.g.t3;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class TencentLogImpl implements TencentLog {
    private static boolean DEBUG = false;
    private static final String TAG = "TencentLogImpl";
    private final File mBackupDir;
    private Handler mHandler;
    private final Runnable mKiller;
    private boolean mPrepared;
    private HandlerThread mWorker;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class LogHandler extends Handler {
        private static final String TXWATCHDOG = "txwatchdog";
        private File mDest;

        private File makeSureDest() {
            File file = TencentLogImpl.this.mBackupDir;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, "txwatchdog");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            File file = this.mDest;
            if (file == null || !"txwatchdog".equals(file.getName())) {
                this.mDest = makeSureDest();
            }
            try {
                l3.a(t3.a(message.obj.toString().getBytes("GBK")), this.mDest);
                File file2 = TencentLogImpl.this.mBackupDir;
                File file3 = this.mDest;
                if (file2 != null && file3 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (file3.length() > 409600) {
                        file3.renameTo(new File(file2, TencentLog.PREFIX + currentTimeMillis));
                    }
                }
            } catch (IOException unused) {
                this.mDest = null;
            }
        }

        LogHandler(Looper looper) {
            super(looper);
            this.mDest = makeSureDest();
        }
    }

    public TencentLogImpl(Context context, @Nullable File file) {
        boolean z16;
        this.mBackupDir = file;
        if (file != null && (file.exists() || file.mkdirs())) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mPrepared = z16;
        if (z16) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("log_worker", 10);
            this.mWorker = baseHandlerThread;
            baseHandlerThread.start();
            this.mHandler = new LogHandler(this.mWorker.getLooper());
        }
        this.mKiller = new Runnable() { // from class: com.tencent.map.geolocation.internal.TencentLogImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (TencentLogImpl.this._isPrepared()) {
                    TencentLogImpl.this.mPrepared = false;
                    TencentLogImpl.this.mHandler.removeCallbacksAndMessages(null);
                    TencentLogImpl.this.mWorker.quit();
                }
            }
        };
        if (DEBUG) {
            Log.i(TAG, "log dir=" + file);
            if (!this.mPrepared) {
                Log.e(TAG, "init failed: mPrepared=" + this.mPrepared);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean _isPrepared() {
        if (this.mPrepared && this.mHandler != null) {
            return true;
        }
        return false;
    }

    public static boolean isDebugEnabled() {
        return DEBUG;
    }

    public static void setDebugEnabled(boolean z16) {
        DEBUG = z16;
    }

    @Override // com.tencent.map.geolocation.internal.TencentLog
    public String getDirString() {
        File file = this.mBackupDir;
        if (file != null) {
            return file.getName();
        }
        return null;
    }

    public boolean isPrepared() {
        return this.mPrepared;
    }

    @Override // com.tencent.map.geolocation.internal.TencentLog
    public void println(String str, int i3, @NonNull String str2) {
        if (_isPrepared()) {
            this.mHandler.obtainMessage(1, DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()) + ":" + str + ":" + str2 + "\n").sendToTarget();
        }
        if (DEBUG) {
            if (i3 == 4) {
                Log.i(str, str2);
            } else {
                Log.e(str, str2);
            }
        }
    }

    public void shutdown(long j3) {
        if (_isPrepared()) {
            this.mHandler.removeCallbacks(this.mKiller);
            this.mHandler.postDelayed(this.mKiller, j3);
        }
    }

    public boolean tryRestart() {
        if (_isPrepared()) {
            this.mHandler.removeCallbacks(this.mKiller);
            return true;
        }
        return false;
    }
}
