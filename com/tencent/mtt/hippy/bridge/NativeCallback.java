package com.tencent.mtt.hippy.bridge;

import android.os.Handler;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class NativeCallback {
    private String mAction;
    private final Handler mHandler;
    private Message mMsg;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f337017a;

        /* renamed from: b, reason: collision with root package name */
        private final NativeCallback f337018b;

        /* renamed from: c, reason: collision with root package name */
        private final Message f337019c;

        /* renamed from: d, reason: collision with root package name */
        private final String f337020d;

        /* renamed from: e, reason: collision with root package name */
        private final String f337021e;

        public a(NativeCallback nativeCallback, long j3, Message message, String str, String str2) {
            this.f337017a = j3;
            this.f337018b = nativeCallback;
            this.f337019c = message;
            this.f337020d = str;
            this.f337021e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f337018b.Call(this.f337017a, this.f337019c, this.f337020d, this.f337021e);
        }
    }

    public NativeCallback(Handler handler) {
        this.mMsg = null;
        this.mAction = null;
        this.mHandler = handler;
    }

    public abstract void Call(long j3, Message message, String str, String str2);

    public void Callback(long j3, String str) {
        if (this.mHandler != null) {
            this.mHandler.post(new a(this, j3, this.mMsg, this.mAction, str));
        }
    }

    public NativeCallback(Handler handler, Message message, String str) {
        this.mHandler = handler;
        this.mMsg = message;
        this.mAction = str;
    }
}
