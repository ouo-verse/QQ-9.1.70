package com.tencent.bugly.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.library.MonitorCallback;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.f;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.manager.e;
import com.tencent.rmonitor.metrics.looper.DropFrameMonitor;
import com.tencent.rmonitor.metrics.looper.g;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* loaded from: classes5.dex */
public class FPSCallbackWrapper implements Handler.Callback {
    private static final long FETCH_FPS_INTERVAL = 1000;
    static final int MAX_FETCH_MONITOR_COUNT = 3;
    static final int MSG_FETCH_FPS = 1;
    private static final String TAG = "RMonitor_MonitorCallback";
    private MonitorCallback monitorCallback = null;
    private Handler handler = null;
    private HandlerThread handlerThread = null;
    private long lastFrameTime = 0;
    private g buffer = null;
    private int tryInitCount = 0;
    private boolean isForeground = false;
    private final MyStateCallback stateCallback = new MyStateCallback(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class MyStateCallback extends f {
        private final FPSCallbackWrapper wrapper;

        public MyStateCallback(FPSCallbackWrapper fPSCallbackWrapper) {
            this.wrapper = fPSCallbackWrapper;
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onBackground() {
            this.wrapper.onBackground();
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onForeground() {
            this.wrapper.onForeground();
        }
    }

    private void cancelFetchData() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    private void createSubThread() {
        if (this.handler == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MonitorCallback");
            baseHandlerThread.start();
            Handler handler = new Handler(baseHandlerThread.getLooper(), this);
            this.handlerThread = baseHandlerThread;
            this.handler = handler;
            this.isForeground = LifecycleCallback.G.m();
            LifecycleCallback.r(this.stateCallback);
            Logger.f365497g.d(TAG, "set call back");
        }
    }

    private g fetchBuffer() {
        String str;
        g gVar = this.buffer;
        if (gVar != null) {
            return gVar;
        }
        this.tryInitCount++;
        DropFrameMonitor findDropFrameMonitor = findDropFrameMonitor();
        if (findDropFrameMonitor != null) {
            gVar = new g();
            findDropFrameMonitor.h(gVar);
        }
        this.buffer = gVar;
        Logger logger = Logger.f365497g;
        String[] strArr = new String[2];
        strArr[0] = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fetch monitor ");
        if (gVar != null) {
            str = "success";
        } else {
            str = "fail";
        }
        sb5.append(str);
        strArr[1] = sb5.toString();
        logger.d(strArr);
        if (this.tryInitCount >= 3) {
            releaseSubThread();
        }
        return gVar;
    }

    private DropFrameMonitor findDropFrameMonitor() {
        QAPMMonitorPlugin e16 = e.f365703f.e(BuglyMonitorName.FLUENCY_METRIC, false);
        if (e16 instanceof DropFrameMonitor) {
            return (DropFrameMonitor) e16;
        }
        return null;
    }

    private void releaseBuffer() {
        DropFrameMonitor findDropFrameMonitor;
        if (this.buffer != null && (findDropFrameMonitor = findDropFrameMonitor()) != null) {
            findDropFrameMonitor.h(null);
        }
        this.buffer = null;
        this.tryInitCount = 0;
    }

    private void releaseSubThread() {
        this.monitorCallback = null;
        cancelFetchData();
        this.handler = null;
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.handlerThread = null;
        LifecycleCallback.s(this.stateCallback);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return true;
        }
        MonitorCallback monitorCallback = this.monitorCallback;
        if (monitorCallback == null) {
            releaseSubThread();
        } else {
            g fetchBuffer = fetchBuffer();
            if (fetchBuffer != null) {
                long j3 = this.lastFrameTime;
                long c16 = fetchBuffer.c();
                this.lastFrameTime = c16;
                if (j3 != c16) {
                    monitorCallback.onEvent("fps", Float.valueOf(fetchBuffer.b()));
                }
            }
            if (this.isForeground) {
                tryFetchDataDelay();
            }
        }
        return true;
    }

    public void onBackground() {
        this.isForeground = false;
        cancelFetchData();
    }

    public void onForeground() {
        this.isForeground = true;
        tryFetchDataDelay();
    }

    public synchronized void setCallback(MonitorCallback monitorCallback) {
        if (monitorCallback == null) {
            releaseBuffer();
            releaseSubThread();
            Logger.f365497g.d(TAG, "release call back");
        } else {
            this.monitorCallback = monitorCallback;
            createSubThread();
            if (this.isForeground) {
                tryFetchDataDelay();
            }
        }
    }

    protected void tryFetchDataDelay() {
        Handler handler = this.handler;
        if (handler != null && !handler.hasMessages(1)) {
            handler.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
