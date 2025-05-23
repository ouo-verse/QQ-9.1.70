package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes.dex */
class t {

    /* renamed from: a, reason: collision with root package name */
    private boolean f31769a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f31770b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((q) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(q<?> qVar, boolean z16) {
        if (!this.f31769a && !z16) {
            this.f31769a = true;
            qVar.recycle();
            this.f31769a = false;
        }
        this.f31770b.obtainMessage(1, qVar).sendToTarget();
    }
}
