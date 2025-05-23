package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b2 extends PhoneStateListener {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f29501a;

    /* renamed from: b, reason: collision with root package name */
    public final n1 f29502b;

    /* renamed from: c, reason: collision with root package name */
    public CellLocation f29503c = null;

    /* renamed from: d, reason: collision with root package name */
    public SignalStrength f29504d = null;

    /* renamed from: e, reason: collision with root package name */
    public ServiceState f29505e = null;

    /* renamed from: f, reason: collision with root package name */
    public long f29506f;

    /* renamed from: g, reason: collision with root package name */
    public HandlerThread f29507g;

    /* renamed from: h, reason: collision with root package name */
    public Handler f29508h;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class b extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (!b2.this.f29501a) {
                return;
            }
            sendEmptyMessageDelayed(0, 30000L);
            b2.this.c(i3.b(b2.this.f29502b));
        }

        public b(Looper looper) {
            super(looper);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public n1 f29510a;

        /* renamed from: b, reason: collision with root package name */
        public t2 f29511b;

        public c(n1 n1Var) {
            this.f29510a = n1Var;
        }

        public void a(t2 t2Var) {
            this.f29511b = t2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            n1 n1Var = this.f29510a;
            t2 t2Var = this.f29511b;
            if (t2Var != null) {
                n1Var.a(t2Var);
            }
        }
    }

    public b2(n1 n1Var) {
        this.f29502b = n1Var;
    }

    public final void b() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("CellProvider");
        this.f29507g = baseHandlerThread;
        baseHandlerThread.start();
        b bVar = new b(this.f29507g.getLooper());
        this.f29508h = bVar;
        bVar.sendEmptyMessageDelayed(0, 3000L);
    }

    public final void c(CellLocation cellLocation) {
        onCellLocationChanged(cellLocation);
    }

    public final void d() {
        t2 a16 = t2.a(this.f29502b, this.f29503c, this.f29504d);
        synchronized (this) {
            if (this.f29508h != null && a16 != null) {
                c cVar = new c(this.f29502b);
                cVar.a(a16);
                this.f29508h.post(cVar);
            }
        }
    }

    public final void e() {
        if (!this.f29501a) {
            return;
        }
        ServiceState serviceState = this.f29505e;
        int i3 = -1;
        boolean z16 = true;
        int i16 = 0;
        if (serviceState != null) {
            if (serviceState.getState() == 0) {
                i3 = 1;
            } else if (this.f29505e.getState() == 1) {
                i3 = 0;
            }
        }
        TelephonyManager d16 = this.f29502b.d();
        boolean a16 = i3.a(this.f29502b.f29875a);
        if (d16 == null || d16.getSimState() != 5) {
            z16 = false;
        }
        if (!a16 && z16) {
            i16 = i3;
        }
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12003;
        message.arg2 = i16;
        this.f29502b.a(message);
    }

    public void f() {
        if (!this.f29501a) {
            return;
        }
        this.f29501a = false;
        a(0);
        synchronized (this) {
            Handler handler = this.f29508h;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f29508h = null;
            }
        }
        this.f29507g.quit();
        this.f29507g = null;
        a();
        this.f29506f = 0L;
        Log.i("TencentLocationSDK", "unregister system cell provider:" + Thread.currentThread().getName());
        o3.b("TxCellProvider", "shutdown: state=[shutdown]");
    }

    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation cellLocation) {
        super.onCellLocationChanged(cellLocation);
        try {
            if (a(cellLocation)) {
                this.f29503c = cellLocation;
                c();
            } else {
                o3.a("TxCellProvider", "onCellLocationChanged: illegal cell or same cell " + cellLocation);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        if (serviceState == null) {
            return;
        }
        try {
            ServiceState serviceState2 = this.f29505e;
            if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                this.f29505e = serviceState;
                e();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength == null) {
            return;
        }
        try {
            SignalStrength signalStrength2 = this.f29504d;
            int l3 = this.f29502b.a().l();
            if (signalStrength2 == null || i3.a(l3, signalStrength2, signalStrength)) {
                this.f29504d = signalStrength;
                c();
            }
        } catch (Throwable unused) {
        }
    }

    public final void c() {
        if (this.f29501a && this.f29503c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f29506f > 2000) {
                this.f29506f = currentTimeMillis;
                d();
            }
        }
    }

    public void a(Handler handler) {
        t2 a16;
        if (this.f29501a) {
            return;
        }
        this.f29501a = true;
        b();
        CellLocation b16 = i3.b(this.f29502b);
        if (a(b16) && (a16 = t2.a(this.f29502b, b16, null)) != null) {
            this.f29503c = b16;
            this.f29502b.a(a16);
        }
        a(273);
        o3.b("TxCellProvider", "startup: state=[start]");
    }

    public final boolean b(CellLocation cellLocation) {
        t2 a16 = t2.a(this.f29502b, cellLocation, null);
        if (a16 == null) {
            return true;
        }
        return i3.a(a16);
    }

    public final void a(int i3) {
        try {
            LocationMonitor.listen(this.f29502b.d(), this, i3);
        } catch (Exception e16) {
            o3.a("TxCellProvider", "listenCellState: failed! flags=" + i3, e16);
        }
    }

    public final void a() {
        this.f29503c = null;
        this.f29504d = null;
        this.f29505e = null;
    }

    public final boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (LocationMonitor.getCid(gsmCellLocation) == 0) {
                if (gsmCellLocation.getLac() == 0) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
        }
        return i3.a(cellLocation) >= 0 && !i3.a(this.f29503c, cellLocation) && b(cellLocation);
    }
}
