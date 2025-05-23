package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class j2 {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f29786a;

    /* renamed from: c, reason: collision with root package name */
    public final n1 f29788c;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f29791f;

    /* renamed from: g, reason: collision with root package name */
    public c f29792g;

    /* renamed from: h, reason: collision with root package name */
    public d f29793h;

    /* renamed from: i, reason: collision with root package name */
    public Handler f29794i;

    /* renamed from: j, reason: collision with root package name */
    public SignalStrength f29795j;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f29787b = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    public t2 f29789d = null;

    /* renamed from: e, reason: collision with root package name */
    public ServiceState f29790e = null;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f29796k = false;

    /* renamed from: l, reason: collision with root package name */
    public w1 f29797l = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements w1 {

        /* compiled from: P */
        /* renamed from: c.t.m.g.j2$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0157a implements Runnable {
            public RunnableC0157a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j2.this.f29793h = new d();
            }
        }

        public a() {
        }

        @Override // c.t.m.g.w1
        public void a(int i3) {
            k3.a("CELL", "onAppActivityStatusChanged," + i3);
            if (i3 == 1 && j2.this.f29796k && j2.this.f29786a) {
                try {
                    o3.a("backgroundloc", "back to foreground ,new TxPhoneStateImpl again");
                    j2.this.f29792g.postDelayed(new RunnableC0157a(), 0L);
                } catch (Throwable th5) {
                    o3.a("TxNewCellProvider", th5.toString());
                }
                j2.this.f29796k = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j2.this.f29793h = new d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f29801a;

        public /* synthetic */ c(j2 j2Var, Looper looper, a aVar) {
            this(looper);
        }

        public void a() {
            this.f29801a = true;
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi", "MissingPermission"})
        public void handleMessage(Message message) {
            if (!j2.this.f29786a) {
                return;
            }
            List<NeighboringCellInfo> c16 = i3.c(j2.this.f29788c);
            t2 t2Var = j2.this.f29789d;
            if (t2Var != null) {
                t2Var.a(c16);
            }
            if (c16 != null && c16.size() != 0) {
                for (NeighboringCellInfo neighboringCellInfo : c16) {
                }
            }
            if ((t2Var == null || !t2Var.a(3000L)) && j2.this.f29788c.d() != null) {
                t2 a16 = t2.a(j2.this.f29788c, i3.a(j2.this.f29788c));
                if (a16 == null || !a16.g()) {
                    k3.a("CELL", "get from CellInfo failed");
                    a16 = t2.a(j2.this.f29788c, i3.b(j2.this.f29788c), j2.this.f29795j);
                    if (a16 == null || !a16.g()) {
                        k3.a("CELL", "get from cellLocation failed");
                    }
                }
                j2.this.a(a16, 2);
            }
            synchronized (j2.this.f29787b) {
                if (j2.this.f29792g != null && !this.f29801a) {
                    y0.a(j2.this.f29792g, 0, 30000L);
                }
            }
        }

        public c(Looper looper) {
            super(looper);
            this.f29801a = false;
            this.f29801a = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class d extends PhoneStateListener {
        public d() {
            a(1297);
            k3.a("CELL", "listen");
        }

        public final void a(int i3) {
            try {
                LocationMonitor.listen(j2.this.f29788c.d(), this, i3);
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        @SuppressLint({"NewApi"})
        public void onCellInfoChanged(List<CellInfo> list) {
            if (o1.b() != 2) {
                if (list != null) {
                    list.size();
                }
                j2.this.a(t2.a(j2.this.f29788c, list), 0);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (o1.b() != 2) {
                super.onCellLocationChanged(cellLocation);
                j2.this.a(t2.a(j2.this.f29788c, cellLocation, j2.this.f29795j), 1);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            if (serviceState != null) {
                try {
                    ServiceState serviceState2 = j2.this.f29790e;
                    if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                        j2.this.f29790e = serviceState;
                        j2.this.a();
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            j2.this.f29795j = signalStrength;
        }

        public void a() {
            a(0);
        }
    }

    public j2(n1 n1Var) {
        this.f29788c = n1Var;
        n1Var.a().a(this.f29797l);
    }

    public void b() {
        if (this.f29786a) {
            this.f29786a = false;
            synchronized (this.f29787b) {
                d dVar = this.f29793h;
                if (dVar != null) {
                    dVar.a();
                }
                c cVar = this.f29792g;
                if (cVar != null) {
                    cVar.a();
                    this.f29792g.removeCallbacksAndMessages(null);
                    this.f29792g = null;
                }
                HandlerThread handlerThread = this.f29791f;
                if (handlerThread != null) {
                    handlerThread.quit();
                    this.f29791f = null;
                }
                this.f29789d = null;
                this.f29790e = null;
                this.f29793h = null;
                this.f29795j = null;
                t2.a((t2) null, 0L);
            }
            k3.a("CELL", "stop");
        }
    }

    @SuppressLint({"NewApi"})
    public void a(Handler handler, boolean z16) {
        if (this.f29786a) {
            return;
        }
        a aVar = null;
        t2.a((t2) null, 0L);
        this.f29794i = handler;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("new_cell_provider");
        this.f29791f = baseHandlerThread;
        if (this.f29794i != null) {
            try {
                baseHandlerThread.start();
                this.f29792g = new c(this, this.f29791f.getLooper(), aVar);
            } catch (Throwable unused) {
                this.f29792g = new c(this, this.f29794i.getLooper(), aVar);
            }
            this.f29786a = true;
            if (!z16) {
                y0.b(this.f29792g, 0);
            }
            if (o1.b() == 1) {
                this.f29796k = false;
                o3.a("backgroundloc", "new TxPhoneStateImpl beacause app inter foreground");
                this.f29792g.postDelayed(new b(), 1000L);
            } else {
                o3.a("backgroundloc", "new TxPhoneStateImpl donot allow,beacause app inter background");
                this.f29796k = true;
            }
            k3.a("CELL", "start,isBack:" + this.f29796k);
        }
    }

    public final void a(t2 t2Var) {
        if (!this.f29786a || t2Var == null || this.f29788c == null) {
            return;
        }
        synchronized (this) {
            t2 t2Var2 = this.f29789d;
            if (t2Var2 != null) {
                t2Var.a(t2Var2.d());
            }
            this.f29789d = t2Var;
            this.f29788c.a(t2Var);
        }
    }

    public final void a(t2 t2Var, int i3) {
        List<String> list;
        List<String> list2;
        List<String> list3;
        if (this.f29789d == null && t2Var != null && t2Var.g()) {
            k3.a("CELL", "first get failed");
            a(t2Var);
            return;
        }
        t2 t2Var2 = this.f29789d;
        if (i3 == 0) {
            if (t2Var == null || !t2Var.g()) {
                return;
            }
            if (t2Var2 != null && (list = t2Var2.f30014m) != null && list.containsAll(t2Var.f30014m)) {
                k3.a("CELL", "cell not changed, " + i3);
                return;
            }
            a(t2Var);
            return;
        }
        if (i3 != 1) {
            if (i3 == 2 && t2Var != null && t2Var.g()) {
                if (t2Var2 != null && (list3 = t2Var2.f30014m) != null && list3.containsAll(t2Var.f30014m)) {
                    k3.a("CELL", "cell not changed, " + i3);
                    return;
                }
                a(t2Var);
                return;
            }
            return;
        }
        if (t2Var == null || !t2Var.g()) {
            return;
        }
        if (t2Var2 != null && (list2 = t2Var2.f30014m) != null && list2.contains(t2Var.b())) {
            k3.a("CELL", "cell not changed, " + i3);
            return;
        }
        a(t2Var);
    }

    public final void a() {
        if (this.f29786a) {
            ServiceState serviceState = this.f29790e;
            int i3 = -1;
            int i16 = 0;
            if (serviceState != null) {
                if (serviceState.getState() == 0) {
                    i3 = 1;
                } else if (this.f29790e.getState() == 1) {
                    i3 = 0;
                }
            }
            TelephonyManager d16 = this.f29788c.d();
            boolean a16 = i3.a(this.f29788c.f29875a);
            boolean z16 = d16 != null && d16.getSimState() == 5;
            if (!a16 && z16) {
                i16 = i3;
            }
            Message message = new Message();
            message.what = 12999;
            message.arg1 = 12003;
            message.arg2 = i16;
            this.f29788c.a(message);
        }
    }
}
