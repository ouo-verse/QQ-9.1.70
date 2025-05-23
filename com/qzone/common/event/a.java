package com.qzone.common.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final d f45859a;

    /* renamed from: b, reason: collision with root package name */
    private final int f45860b;

    /* renamed from: c, reason: collision with root package name */
    private final EventCenter f45861c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f45862d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(EventCenter eventCenter, Looper looper, int i3) {
        super(looper);
        this.f45861c = eventCenter;
        this.f45860b = i3;
        this.f45859a = new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar, Object obj) {
        c a16 = c.a(bVar, obj);
        synchronized (this) {
            this.f45859a.a(a16);
            if (!this.f45862d) {
                this.f45862d = true;
                sendMessage(obtainMessage());
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                c b16 = this.f45859a.b();
                if (b16 == null) {
                    synchronized (this) {
                        b16 = this.f45859a.b();
                        if (b16 == null) {
                            return;
                        }
                    }
                }
                this.f45861c.invokeObserver(b16);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f45860b);
            sendMessage(obtainMessage());
            this.f45862d = true;
        } finally {
            this.f45862d = false;
        }
    }
}
