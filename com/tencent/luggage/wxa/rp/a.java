package com.tencent.luggage.wxa.rp;

import android.os.CancellationSignal;
import com.tencent.luggage.wxa.np.e;
import com.tencent.luggage.wxa.xp.f;
import com.tencent.luggage.wxa.xp.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public CancellationSignal f139905a = null;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6696a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f139906a;

        public RunnableC6696a(boolean z16) {
            this.f139906a = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d("Soter.SoterBiometricCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
            a.this.f139905a.cancel();
            if (this.f139906a) {
                a.this.c();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f139905a.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.e("Soter.SoterBiometricCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", 350L);
            a.this.c();
        }
    }

    public a() {
        d();
    }

    public final void c() {
        f.c().d();
    }

    public void d() {
        this.f139905a = new CancellationSignal();
    }

    public boolean a() {
        return a(true);
    }

    public CancellationSignal b() {
        return this.f139905a;
    }

    public boolean a(boolean z16) {
        e.d("Soter.SoterBiometricCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z16));
        if (!this.f139905a.isCanceled()) {
            g.a().b(new b());
            g.a().a(new c(), 350L);
            return true;
        }
        e.c("Soter.SoterBiometricCanceller", "soter: cancellation signal already expired.", new Object[0]);
        return false;
    }
}
