package com.tencent.biz.richframework.monitor.local.fps;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWStackSampler {
    private volatile boolean mIsMonitor = false;
    private Map<Long, String> mStackTraceMap = new ConcurrentHashMap();
    private Handler mSubTaskHandler;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static final class SubThreadHandler extends Handler {
        private WeakReference<RFWStackSampler> mStackSamplerWeak;

        public SubThreadHandler(RFWStackSampler rFWStackSampler) {
            this.mStackSamplerWeak = new WeakReference<>(rFWStackSampler);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RFWStackSampler rFWStackSampler;
            super.handleMessage(message);
            WeakReference<RFWStackSampler> weakReference = this.mStackSamplerWeak;
            if (weakReference == null) {
                rFWStackSampler = null;
            } else {
                rFWStackSampler = weakReference.get();
            }
            if (rFWStackSampler != null) {
                rFWStackSampler.handleMessage(message);
            }
        }
    }

    public RFWStackSampler() {
        this.mSubTaskHandler = null;
        this.mSubTaskHandler = new SubThreadHandler(this);
    }

    private void doSample() {
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            sb5.append(stackTraceElement.toString());
            sb5.append("\n");
        }
        if (this.mStackTraceMap.size() == 100) {
            this.mStackTraceMap.remove(this.mStackTraceMap.keySet().iterator().next());
        }
        this.mStackTraceMap.put(Long.valueOf(System.nanoTime()), sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(Message message) {
        if (message == null) {
            RFWLog.d("FAM-RFWStackSampler", RFWLog.USR, "[handleMessage] message should not be null.");
        } else if (message.what == 5538) {
            startCollectFps();
        }
    }

    private void startCollectFps() {
        if (this.mIsMonitor || this.mSubTaskHandler == null) {
            return;
        }
        doSample();
        Message obtainMessage = this.mSubTaskHandler.obtainMessage();
        obtainMessage.what = 5538;
        this.mSubTaskHandler.sendMessageDelayed(obtainMessage, 52L);
    }

    public void start() {
        if (this.mSubTaskHandler == null) {
            return;
        }
        this.mIsMonitor = true;
        Message obtainMessage = this.mSubTaskHandler.obtainMessage();
        obtainMessage.what = 5538;
        this.mSubTaskHandler.sendMessage(obtainMessage);
    }

    public void stop() {
        this.mIsMonitor = false;
        this.mStackTraceMap.clear();
        this.mSubTaskHandler.removeMessages(5538);
    }
}
