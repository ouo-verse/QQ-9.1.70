package com.google.android.vending.expansion.downloader.impl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class CustomIntentService extends Service {

    /* renamed from: d, reason: collision with root package name */
    private String f34536d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34537e;

    /* renamed from: f, reason: collision with root package name */
    private volatile a f34538f;

    /* renamed from: h, reason: collision with root package name */
    private volatile Looper f34539h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CustomIntentService.this.g((Intent) message.obj);
            if (CustomIntentService.this.h()) {
                Log.d("CustomIntentService", "stopSelf");
                CustomIntentService.this.stopSelf(message.arg1);
                Log.d("CustomIntentService", "afterStopSelf");
            }
        }
    }

    public CustomIntentService(String str) {
        this.f34536d = str;
    }

    protected abstract void g(Intent intent);

    protected abstract boolean h();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("IntentService[" + this.f34536d + "]");
        baseHandlerThread.start();
        this.f34539h = baseHandlerThread.getLooper();
        this.f34538f = new a(this.f34539h);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Thread thread = this.f34539h.getThread();
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        this.f34539h.quit();
        Log.d("CustomIntentService", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i3) {
        if (!this.f34538f.hasMessages(-10)) {
            Message obtainMessage = this.f34538f.obtainMessage();
            obtainMessage.arg1 = i3;
            obtainMessage.obj = intent;
            obtainMessage.what = -10;
            this.f34538f.sendMessage(obtainMessage);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        onStart(intent, i16);
        if (this.f34537e) {
            return 3;
        }
        return 2;
    }
}
