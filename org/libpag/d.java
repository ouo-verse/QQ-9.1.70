package org.libpag;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes29.dex */
class d extends Handler {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final b f423785a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f423786b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f423787c = false;

        public a(b bVar) {
            this.f423785a = bVar;
        }

        public boolean a(Handler handler, long j3) {
            if (!handler.post(this)) {
                return false;
            }
            synchronized (this) {
                if (j3 > 0) {
                    long uptimeMillis = SystemClock.uptimeMillis() + j3;
                    while (!this.f423786b) {
                        long uptimeMillis2 = uptimeMillis - SystemClock.uptimeMillis();
                        if (uptimeMillis2 <= 0) {
                            this.f423787c = true;
                            return false;
                        }
                        try {
                            wait(uptimeMillis2);
                        } catch (InterruptedException unused) {
                        }
                    }
                } else {
                    while (!this.f423786b) {
                        try {
                            LockMethodProxy.wait(this);
                        } catch (InterruptedException unused2) {
                        }
                    }
                }
                return true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f423785a.run();
                synchronized (this) {
                    this.f423786b = true;
                    notifyAll();
                    this.f423785a.a(this.f423787c);
                }
            } catch (Throwable th5) {
                synchronized (this) {
                    this.f423786b = true;
                    notifyAll();
                    this.f423785a.a(this.f423787c);
                    throw th5;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    interface b extends Runnable {
        void a(boolean z16);
    }

    public d(Looper looper) {
        super(looper);
    }

    public final boolean a(b bVar, long j3) {
        if (bVar != null) {
            if (j3 >= 0) {
                if (Looper.myLooper() == getLooper()) {
                    bVar.run();
                    return true;
                }
                return new a(bVar).a(this, j3);
            }
            throw new IllegalArgumentException("timeout must be non-negative");
        }
        throw new IllegalArgumentException("runnable must not be null");
    }
}
