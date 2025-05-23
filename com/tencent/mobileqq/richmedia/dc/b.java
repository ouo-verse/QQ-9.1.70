package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    static String f281563c = "DataCollector";

    /* renamed from: d, reason: collision with root package name */
    private static HandlerThread f281564d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f281565a = true;

    /* renamed from: b, reason: collision with root package name */
    Handler f281566b = new a(f281564d.getLooper());

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b.this.a(message);
        }
    }

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Colloector-Tasker");
        f281564d = baseHandlerThread;
        baseHandlerThread.start();
    }

    public b(Context context) {
        f281563c = getClass().getSimpleName();
    }

    protected void a(Message message) {
    }
}
