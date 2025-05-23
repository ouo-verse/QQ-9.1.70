package com.tencent.luggage.wxa.op;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.luggage.wxa.np.h;
import com.tencent.luggage.wxa.np.j;
import com.tencent.luggage.wxa.np.k;
import com.tencent.luggage.wxa.pp.a;
import com.tencent.soter.core.sotercore.SoterCoreTreble;
import java.security.Signature;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.op.b implements com.tencent.luggage.wxa.np.b {

    /* renamed from: l, reason: collision with root package name */
    public static com.tencent.luggage.wxa.pp.a f137061l = null;

    /* renamed from: m, reason: collision with root package name */
    public static int f137062m = 0;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f137063n = false;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f137064o = false;

    /* renamed from: p, reason: collision with root package name */
    public static final Object f137065p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public static f f137066q = new f();

    /* renamed from: r, reason: collision with root package name */
    public static int f137067r = 0;

    /* renamed from: b, reason: collision with root package name */
    public Context f137068b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f137069c = true;

    /* renamed from: d, reason: collision with root package name */
    public int f137070d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f137071e = 3;

    /* renamed from: f, reason: collision with root package name */
    public long f137072f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f137073g = false;

    /* renamed from: h, reason: collision with root package name */
    public Handler f137074h = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    public IBinder.DeathRecipient f137075i = new a();

    /* renamed from: j, reason: collision with root package name */
    public ServiceConnection f137076j = new b();

    /* renamed from: k, reason: collision with root package name */
    public Runnable f137077k = new e();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements IBinder.DeathRecipient {
        public a() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: binder died", new Object[0]);
            com.tencent.luggage.wxa.pp.a aVar = d.f137061l;
            if (aVar != null && aVar.asBinder() != null) {
                d.f137061l.asBinder().unlinkToDeath(d.this.f137075i, 0);
                d.f137061l = null;
                d.b(d.this);
                synchronized (d.f137065p) {
                    int unused = d.f137062m = 0;
                    d.this.p();
                    d.this.o();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: binding died", new Object[0]);
            int unused = d.f137062m = 0;
            d.f137061l = null;
            if (d.c(d.this.f137071e) > 30) {
                com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: rest fib, now is delay %dS", Long.valueOf(d.c(d.this.f137071e)));
                d.this.f137071e = 3;
                d.this.f137074h.removeCallbacks(d.this.f137077k);
            }
            d.this.p();
            d.this.o();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: onServiceConnected", new Object[0]);
            synchronized (d.f137065p) {
                int unused = d.f137062m = 2;
            }
            d.this.f137071e = 3;
            d.this.f137074h.removeCallbacks(d.this.f137077k);
            try {
                iBinder.linkToDeath(d.this.f137075i, 0);
                d.f137061l = a.AbstractBinderC6612a.a(iBinder);
            } catch (RemoteException e16) {
                com.tencent.luggage.wxa.np.e.b(SoterCoreTreble.TAG, "soter: Binding deathRecipient is error - RemoteException" + e16.toString(), new Object[0]);
                com.tencent.luggage.wxa.np.f.a(101, "SoterService interface: ISoterService.Stub.asInterface.", e16);
            }
            d.b(d.this);
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: Binding is done - Service connected", new Object[0]);
            long elapsedRealtime = SystemClock.elapsedRealtime() - d.this.f137072f;
            if (elapsedRealtime > 3000) {
                com.tencent.luggage.wxa.np.f.a(105, "bind SoterService out time: " + elapsedRealtime);
            }
            d.f137066q.a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (d.f137065p) {
                com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: unBinding is done - Service disconnected", new Object[0]);
                int unused = d.f137062m = 0;
                d.f137061l = null;
                if (d.c(d.this.f137071e) > 30) {
                    com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: rest fib, now is delay %dS", Long.valueOf(d.c(d.this.f137071e)));
                    d.this.f137071e = 3;
                    d.this.f137074h.removeCallbacks(d.this.f137077k);
                }
                d.b(d.this);
                d.this.o();
                d.f137066q.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.op.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6565d implements Runnable {
        public RunnableC6565d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l();
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: initSoter binding", new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f137069c && d.f137064o) {
                d.f(d.this);
                if (d.f137062m != 2) {
                    com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: retryFunc bindservice no response: %d delay: %d", Integer.valueOf(d.this.f137071e), Long.valueOf(d.c(d.this.f137071e)));
                    d.this.a(true);
                    return;
                } else {
                    com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: retryFunc stop, CONNECTED", new Object[0]);
                    return;
                }
            }
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: retryFunc stop, canRetry:%b isInitializeSuccessed:%b", Boolean.valueOf(d.this.f137069c), Boolean.valueOf(d.f137064o));
        }
    }

    public static long c(long j3) {
        long j16 = 0;
        if (j3 < 0) {
            return -1L;
        }
        if (j3 == 0) {
            return 0L;
        }
        long j17 = 1;
        if (j3 == 1 || j3 == 2) {
            return 1L;
        }
        int i3 = 3;
        long j18 = 1;
        while (i3 <= j3) {
            j16 = j17 + j18;
            i3++;
            j17 = j18;
            j18 = j16;
        }
        return j16;
    }

    public static /* synthetic */ int f(d dVar) {
        int i3 = dVar.f137071e;
        dVar.f137071e = i3 + 1;
        return i3;
    }

    public static boolean n() {
        return f137063n;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public void a(com.tencent.luggage.wxa.op.e eVar) {
    }

    @Override // com.tencent.luggage.wxa.op.b
    public Signature b(String str) {
        return null;
    }

    public void k() {
        a(false);
    }

    public void l() {
        com.tencent.luggage.wxa.pp.a aVar;
        try {
            if (f137062m == 2 && (aVar = f137061l) != null && aVar.asBinder() != null && f137061l.asBinder().isBinderAlive() && f137061l.asBinder().pingBinder()) {
                com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "no need rebind", new Object[0]);
            }
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: bindServiceIfNeeded try to bind", new Object[0]);
            k();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: bindServiceIfNeeded fail: ");
        }
    }

    public final boolean m() {
        if (f137061l != null) {
            return false;
        }
        com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
        return true;
    }

    public final void o() {
        if (!this.f137069c) {
            return;
        }
        this.f137070d++;
        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f137072f) / 1000;
        long c16 = c(this.f137070d);
        long j3 = c16 - elapsedRealtime;
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "fib: %s, rebind delay: %sS", Long.valueOf(c16), Long.valueOf(j3));
        if (j3 <= 0) {
            k();
        } else {
            this.f137074h.postDelayed(new c(), j3 * 1000);
        }
    }

    public void p() {
        if (this.f137073g) {
            try {
                try {
                    this.f137068b.unbindService(this.f137076j);
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "");
                }
            } finally {
                this.f137073g = false;
            }
        }
    }

    public static /* synthetic */ com.tencent.luggage.wxa.op.e b(d dVar) {
        dVar.getClass();
        return null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean d() {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: isAppGlobalSecureKeyValid in", new Object[0]);
        return c() && b() != null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean e() {
        if (!j.a()) {
            return true;
        }
        com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: the device has already triggered OOM. mark as not support", new Object[0]);
        return false;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h f() {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: removeAppGlobalSecureKey in", new Object[0]);
        if (!e()) {
            return new h(5);
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return new h(5);
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return new h(5);
        }
        try {
            if (f137061l.a(f137067r) == 0) {
                return new h(0);
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: removeAppGlobalSecureKey fail: ");
        }
        return new h(5);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean c() {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: hasAppGlobalSecureKey in", new Object[0]);
        if (!e()) {
            return false;
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return false;
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return false;
        }
        try {
            return f137061l.b(f137067r);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: hasAppGlobalSecureKey fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: hasAskAlready.", e16);
            return false;
        }
    }

    public final void b(boolean z16) {
        long c16 = c(this.f137071e);
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: scheduleTimeoutTask isCycle:%b noResponseCount:%d checkDelay:%d ", Boolean.valueOf(z16), Integer.valueOf(this.f137071e), Long.valueOf(c16));
        if (z16 || this.f137071e <= 3) {
            this.f137074h.postDelayed(this.f137077k, c16 * 1000);
        }
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean d(String str) {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: hasAuthKey in", new Object[0]);
        if (!e()) {
            return false;
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return false;
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return false;
        }
        try {
            return f137061l.a(f137067r, str);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: hasAuthKey fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: hasAuthKey.", e16);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean a(Context context) {
        this.f137068b = context;
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: initSoter in", new Object[0]);
        f137063n = true;
        f137066q.a(3000L, new RunnableC6565d());
        f137063n = false;
        if (f137062m == 2) {
            com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: initSoter finish", new Object[0]);
            f137064o = true;
            return true;
        }
        f137062m = 0;
        com.tencent.luggage.wxa.np.e.b(SoterCoreTreble.TAG, "soter: initSoter error", new Object[0]);
        com.tencent.luggage.wxa.np.f.a(102, "bind SoterService fail: DISCONNECT");
        return false;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public k b() {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: getAppGlobalSecureKeyModel in", new Object[0]);
        if (!e()) {
            return null;
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return null;
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            byte[] bArr = f137061l.c(f137067r).f137729b;
            if (bArr != null && bArr.length > 0) {
                return com.tencent.luggage.wxa.op.b.a(bArr);
            }
            com.tencent.luggage.wxa.np.e.b(SoterCoreTreble.TAG, "soter: soter: key can not be retrieved", new Object[0]);
            com.tencent.luggage.wxa.np.f.a(102, "SoterService aidl: getAppSecureKey. Result.exportData is null");
            return null;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: getAppGlobalSecureKeyModel fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: getAppSecureKey.", e16);
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.op.b
    public k c(String str) {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: getAuthKeyModel in", new Object[0]);
        if (!e()) {
            return null;
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return null;
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            byte[] bArr = f137061l.d(f137067r, str).f137729b;
            if (bArr != null && bArr.length > 0) {
                return com.tencent.luggage.wxa.op.b.a(bArr);
            }
            com.tencent.luggage.wxa.np.e.b(SoterCoreTreble.TAG, "soter: key can not be retrieved", new Object[0]);
            com.tencent.luggage.wxa.np.f.a(102, "SoterService aidl: getAuthKey. Result.exportData is null");
            return null;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: getAuthKeyModel fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: getAuthKey.", e16);
            return null;
        }
    }

    public final void a(boolean z16) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.soter.soterserver.ISoterService");
        intent.setPackage("com.tencent.soter.soterserver");
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.b(SoterCoreTreble.TAG, "soter: bindService context is null ", new Object[0]);
            return;
        }
        f137062m = 1;
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: bindService binding is start ", new Object[0]);
        this.f137072f = SystemClock.elapsedRealtime();
        this.f137073g = this.f137068b.bindService(intent, this.f137076j, 1);
        b(z16);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h b(String str, boolean z16) {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: removeAuthKey in", new Object[0]);
        if (!e()) {
            return new h(7);
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return new h(7);
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return new h(7);
        }
        try {
            if (f137061l.b(f137067r, str) == 0) {
                if (z16) {
                    if (f137061l.a(f137067r) == 0) {
                        return new h(0);
                    }
                    return new h(5);
                }
                return new h(0);
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: removeAuthKey fail: ");
        }
        return new h(7);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h a() {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: generateAppSecureKey in", new Object[0]);
        if (!e()) {
            return new h(4);
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return new h(4);
        }
        l();
        if (m()) {
            return new h(4);
        }
        try {
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: generateAppSecureKey fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: generateAppSecureKey.", e16);
        }
        if (f137061l.d(f137067r) == 0) {
            return new h(0);
        }
        com.tencent.luggage.wxa.np.f.a(102, "SoterService aidl: generateAppSecureKey. Return is not 0");
        return new h(4);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public h a(String str) {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: generateAuthKey in", new Object[0]);
        if (!e()) {
            return new h(6);
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return new h(6);
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return new h(6);
        }
        try {
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: generateAuthKey fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: generateAuthKey.", e16);
        }
        if (f137061l.c(f137067r, str) == 0) {
            return new h(0);
        }
        com.tencent.luggage.wxa.np.f.a(102, "SoterService aidl: generateAuthKey. Return is not 0");
        return new h(6);
    }

    @Override // com.tencent.luggage.wxa.op.b
    public boolean a(String str, boolean z16) {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: isAuthKeyValid in", new Object[0]);
        return d(str) && c(str) != null;
    }

    @Override // com.tencent.luggage.wxa.op.b
    public com.tencent.luggage.wxa.pp.c a(String str, String str2) {
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: initSigh in", new Object[0]);
        if (!e()) {
            return null;
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return null;
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        try {
            return f137061l.a(f137067r, str, str2);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: initSigh fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: initSigh.", e16);
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.op.b
    public byte[] a(long j3) {
        com.tencent.luggage.wxa.pp.d a16;
        com.tencent.luggage.wxa.np.e.c(SoterCoreTreble.TAG, "soter: finishSign in", new Object[0]);
        if (!e()) {
            return null;
        }
        if (this.f137068b == null) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: context is null", new Object[0]);
            return null;
        }
        l();
        if (m()) {
            com.tencent.luggage.wxa.np.e.e(SoterCoreTreble.TAG, "soter: soter service not found", new Object[0]);
            return null;
        }
        byte[] bArr = new byte[0];
        try {
            a16 = f137061l.a(j3);
            bArr = a16.f137734b;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a(SoterCoreTreble.TAG, e16, "soter: finishSign fail: ");
            com.tencent.luggage.wxa.np.f.a(101, "SoterService aidl: finishSign.", e16);
        }
        if (a16.f137733a == 0) {
            return bArr;
        }
        com.tencent.luggage.wxa.np.f.a(102, "SoterService aidl: finishSign. Result.resultCode is not 0");
        throw new Exception("finishSign error");
    }
}
