package com.tencent.liteav.base.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class r extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private int f119046a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f119047b;

    /* renamed from: c, reason: collision with root package name */
    private final a f119048c;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void onTimeout();
    }

    public r(Looper looper, a aVar) {
        super(looper);
        this.f119047b = false;
        this.f119048c = aVar;
    }

    public final synchronized void a(int i3) {
        a();
        this.f119046a = i3;
        this.f119047b = true;
        sendEmptyMessageDelayed(0, 0L);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        synchronized (this) {
            if (!this.f119047b) {
                return;
            }
            removeMessages(0);
            sendEmptyMessageDelayed(0, this.f119046a);
            a aVar = this.f119048c;
            if (aVar != null) {
                aVar.onTimeout();
            }
        }
    }

    public final synchronized void a() {
        while (hasMessages(0)) {
            removeMessages(0);
        }
        this.f119047b = false;
    }
}
