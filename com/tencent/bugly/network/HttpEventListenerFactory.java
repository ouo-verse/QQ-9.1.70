package com.tencent.bugly.network;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: P */
/* loaded from: classes5.dex */
class HttpEventListenerFactory implements EventListener.Factory, ICallEnd {
    private HttpEventListener httpEventListener = null;
    private final AtomicBoolean isStart = new AtomicBoolean(false);
    private final HttpReportMetaCollector metaCollector;

    public HttpEventListenerFactory(HttpReportMetaCollector httpReportMetaCollector) {
        this.metaCollector = httpReportMetaCollector;
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        if (!this.isStart.get()) {
            return null;
        }
        if (this.httpEventListener == null) {
            synchronized (HttpEventListenerFactory.class) {
                if (this.httpEventListener == null) {
                    this.httpEventListener = new HttpEventListener(this.metaCollector);
                }
                this.httpEventListener.start();
            }
        }
        return this.httpEventListener;
    }

    @Override // com.tencent.bugly.network.ICallEnd
    public void onCallEnd(Call call, boolean z16, IOException iOException) {
        HttpEventListener httpEventListener = this.httpEventListener;
        if (httpEventListener != null) {
            if (z16) {
                httpEventListener.callFailed(call, iOException);
            } else {
                httpEventListener.callEnd(call);
            }
        }
    }

    public void start() {
        this.isStart.compareAndSet(false, true);
        HttpEventListener httpEventListener = this.httpEventListener;
        if (httpEventListener != null) {
            httpEventListener.start();
        }
    }

    public void stop() {
        this.isStart.compareAndSet(true, false);
        HttpEventListener httpEventListener = this.httpEventListener;
        if (httpEventListener != null) {
            httpEventListener.stop();
        }
    }
}
