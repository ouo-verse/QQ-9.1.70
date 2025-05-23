package com.tencent.luggage.wxa.oe;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.luggage.wxa.oe.p;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public final Context f136353b;

    /* renamed from: c, reason: collision with root package name */
    public l f136354c;

    /* renamed from: d, reason: collision with root package name */
    public Map f136355d;

    /* renamed from: h, reason: collision with root package name */
    public List f136359h;

    /* renamed from: j, reason: collision with root package name */
    public BroadcastReceiver f136361j;

    /* renamed from: o, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.ne.j f136366o;

    /* renamed from: a, reason: collision with root package name */
    public final String f136352a = "MicroMsg.Ble.BleScanWorker#" + hashCode();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f136356e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f136357f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public final Handler f136358g = new Handler();

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f136360i = new a();

    /* renamed from: k, reason: collision with root package name */
    public volatile e f136362k = null;

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f136363l = new b();

    /* renamed from: m, reason: collision with root package name */
    public int f136364m = -1;

    /* renamed from: n, reason: collision with root package name */
    public volatile j f136365n = g.f136403a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            if (!c.this.f136356e.get()) {
                return;
            }
            synchronized (c.this) {
                arrayList = new ArrayList(c.this.f136359h);
                c.this.f136359h.clear();
            }
            com.tencent.luggage.wxa.ne.j jVar = c.this.f136366o;
            if (jVar != null && arrayList.size() > 0) {
                jVar.a(arrayList);
            }
            c.this.f136358g.postDelayed(c.this.f136360i, com.tencent.luggage.wxa.je.a.a().f130960a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d(c.this.f136352a, "run#mScanWorkaroundTask");
            e eVar = c.this.f136362k;
            if (c.this.f136356e.get() && eVar != null) {
                w.d(c.this.f136352a, "run#mScanWorkaroundTask, stopBleScan");
                if (com.tencent.luggage.wxa.ne.k.f135745e.f135767a == c.this.e().f135767a) {
                    synchronized (c.this) {
                        w.d(c.this.f136352a, "run#mScanWorkaroundTask, startBleScanLocked");
                        c.this.a(eVar.a());
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.oe.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6547c extends l {
        public C6547c() {
        }

        @Override // com.tencent.luggage.wxa.oe.l
        public void a(List list) {
        }

        @Override // com.tencent.luggage.wxa.oe.l
        public void a(int i3, o oVar) {
            if (oVar == null || oVar.a() == null) {
                com.tencent.luggage.wxa.pe.a.b(c.this.f136352a, "[onScanResult]result is null, err", new Object[0]);
                return;
            }
            if (!c.this.f136357f.get()) {
                com.tencent.luggage.wxa.pe.a.b(c.this.f136352a, "[onScanResult]not init, err", new Object[0]);
                return;
            }
            synchronized (c.this) {
                if (c.this.f136355d == null) {
                    com.tencent.luggage.wxa.pe.a.d(c.this.f136352a, "[onScanResult]may be close, err", new Object[0]);
                    return;
                }
                c.this.f136365n.a(i3, oVar);
                String address = oVar.a().getAddress();
                boolean z16 = !c.this.f136355d.containsKey(address) || com.tencent.luggage.wxa.je.a.a().f130961b;
                com.tencent.luggage.wxa.ne.d dVar = new com.tencent.luggage.wxa.ne.d(oVar);
                c.this.f136355d.put(address, dVar);
                if (z16) {
                    if (com.tencent.luggage.wxa.je.a.a().f130960a <= 0) {
                        com.tencent.luggage.wxa.ne.j jVar = c.this.f136366o;
                        if (jVar != null) {
                            jVar.a(dVar);
                            return;
                        }
                        return;
                    }
                    synchronized (c.this) {
                        if (c.this.f136359h != null) {
                            c.this.f136359h.add(dVar);
                        }
                    }
                }
            }
        }

        @Override // com.tencent.luggage.wxa.oe.l
        public void a(int i3) {
            com.tencent.luggage.wxa.pe.a.b(c.this.f136352a, "[onScanResult]onScanFailed, errorCode:%d", Integer.valueOf(i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                w.d(c.this.f136352a, "Receive intent failed");
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                int state = defaultAdapter.getState();
                w.a(c.this.f136352a, "state:%d", Integer.valueOf(state));
                if (state != 12 && state != 11) {
                    if (state == 10 || state == 13) {
                        com.tencent.luggage.wxa.pe.a.c(c.this.f136352a, "bluetooth is disable, stop scan", new Object[0]);
                        c.this.f136356e.set(false);
                        c.this.e();
                    }
                }
            }
        }
    }

    public c(Context context) {
        this.f136353b = context;
    }

    public synchronized void b() {
        com.tencent.luggage.wxa.pe.a.c(this.f136352a, "init", new Object[0]);
        this.f136357f.set(true);
        this.f136365n = new com.tencent.luggage.wxa.oe.b(this.f136352a);
        this.f136355d = new HashMap();
        this.f136359h = new ArrayList();
        this.f136354c = new C6547c();
        c();
    }

    public final synchronized void c() {
        if (this.f136353b == null) {
            w.f(this.f136352a, "initBroadcaseListener, context is null");
            return;
        }
        if (this.f136361j == null) {
            w.d(this.f136352a, "bluetoothStateListener init");
            this.f136361j = new d();
            this.f136353b.registerReceiver(this.f136361j, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public boolean d() {
        return this.f136356e.get();
    }

    public synchronized com.tencent.luggage.wxa.ne.k e() {
        if (this.f136357f.get() && this.f136354c != null) {
            if (!d()) {
                com.tencent.luggage.wxa.pe.a.d(this.f136352a, "not scan", new Object[0]);
                return com.tencent.luggage.wxa.ne.k.f135745e;
            }
            BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
            if (e16 != null && com.tencent.luggage.wxa.pe.c.a()) {
                com.tencent.luggage.wxa.pe.a.d(this.f136352a, "stopBleScan, stopScan", new Object[0]);
                this.f136356e.set(false);
                com.tencent.luggage.wxa.oe.d.a(e16, this.f136354c);
                if (com.tencent.luggage.wxa.je.a.a().f130969j) {
                    com.tencent.luggage.wxa.oe.a.a().c(this.f136364m);
                    this.f136364m = -1;
                    this.f136358g.removeCallbacks(this.f136363l);
                }
                return com.tencent.luggage.wxa.ne.k.f135745e;
            }
            com.tencent.luggage.wxa.pe.a.b(this.f136352a, "BluetoothAdapter is null, err", new Object[0]);
            return com.tencent.luggage.wxa.ne.k.f135749i;
        }
        return com.tencent.luggage.wxa.ne.k.f135748h;
    }

    public synchronized void f() {
        Context context;
        com.tencent.luggage.wxa.pe.a.c(this.f136352a, "uninit", new Object[0]);
        e();
        this.f136357f.set(false);
        this.f136365n = g.f136403a;
        Map map = this.f136355d;
        if (map != null) {
            map.clear();
        }
        List list = this.f136359h;
        if (list != null) {
            list.clear();
        }
        if ((Build.VERSION.SDK_INT < 31 || ((context = this.f136353b) != null && com.tencent.luggage.wxa.h6.k.a(context, QQPermissionConstants.Permission.BLUETOOTH_SCAN))) && com.tencent.luggage.wxa.pe.c.e() != null && com.tencent.luggage.wxa.pe.c.e().isDiscovering()) {
            com.tencent.luggage.wxa.pe.c.e().cancelDiscovery();
        }
        g();
        this.f136354c = null;
    }

    public final synchronized void g() {
        if (this.f136361j != null && this.f136353b != null) {
            w.d(this.f136352a, "bluetoothStateListener uninit");
            this.f136353b.unregisterReceiver(this.f136361j);
            this.f136361j = null;
        }
    }

    public static p a(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1078030475:
                if (str.equals("medium")) {
                    c16 = 0;
                    break;
                }
                break;
            case 107348:
                if (str.equals(HippyImageInfo.QUALITY_LOW)) {
                    c16 = 1;
                    break;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return new p.b().a(1).a();
            case 1:
                return new p.b().a(0).a();
            case 2:
                return new p.b().a(2).a();
            default:
                return a("medium");
        }
    }

    public void a(com.tencent.luggage.wxa.ne.j jVar) {
        this.f136366o = jVar;
    }

    public final void a(e eVar) {
        if (this.f136357f.get() && this.f136354c != null) {
            if (this.f136356e.get()) {
                com.tencent.luggage.wxa.pe.a.d(this.f136352a, "already scan", new Object[0]);
                eVar.f136372a.a(com.tencent.luggage.wxa.ne.k.f135745e);
                return;
            }
            BluetoothAdapter e16 = com.tencent.luggage.wxa.pe.c.e();
            if (e16 != null && com.tencent.luggage.wxa.pe.c.a()) {
                if (com.tencent.luggage.wxa.je.a.a().f130969j && com.tencent.luggage.wxa.oe.a.a().X()) {
                    com.tencent.luggage.wxa.pe.a.d(this.f136352a, "startBleScanLocked, isScanningTooFrequently", new Object[0]);
                    eVar.f136372a.a(new com.tencent.luggage.wxa.ne.k(10008, "fail:system error, scanning too frequently", com.tencent.luggage.wxa.af.b.f121231d));
                    return;
                }
                int i3 = Build.VERSION.SDK_INT;
                boolean c16 = com.tencent.luggage.wxa.pe.c.c();
                com.tencent.luggage.wxa.pe.a.c(this.f136352a, "checkLocationPermission :%b", Boolean.valueOf(c16));
                com.tencent.luggage.wxa.pe.a.c(this.f136352a, "checkGpsEnable:%b", Boolean.valueOf(com.tencent.luggage.wxa.pe.c.b()));
                if (!c16) {
                    eVar.f136372a.a(com.tencent.luggage.wxa.ne.k.f135764x);
                    return;
                }
                this.f136356e.set(true);
                List list = eVar.f136373b;
                if (list != null && list.size() == 0) {
                    com.tencent.luggage.wxa.pe.a.d(this.f136352a, "scanFilterCompats size:%d", Integer.valueOf(eVar.f136373b.size()));
                    eVar.f136373b = null;
                }
                boolean a16 = com.tencent.luggage.wxa.oe.d.a(e16, eVar.f136373b, a(com.tencent.luggage.wxa.je.a.a().f130966g), this.f136354c);
                com.tencent.luggage.wxa.pe.a.c(this.f136352a, "startBleScan isOk:%b", Boolean.valueOf(a16));
                if (a16) {
                    a(eVar.f136374c);
                    if (com.tencent.luggage.wxa.je.a.a().f130960a > 0) {
                        this.f136358g.postDelayed(this.f136360i, com.tencent.luggage.wxa.je.a.a().f130960a);
                    }
                    if (com.tencent.luggage.wxa.je.a.a().f130969j) {
                        this.f136364m = com.tencent.luggage.wxa.oe.a.a().U();
                        if (i3 >= 24) {
                            this.f136358g.postDelayed(this.f136363l, 1800000L);
                        }
                    }
                    eVar.f136372a.a(com.tencent.luggage.wxa.ne.k.f135745e);
                    return;
                }
                eVar.f136372a.a(com.tencent.luggage.wxa.ne.k.f135754n);
                return;
            }
            com.tencent.luggage.wxa.pe.a.b(this.f136352a, "BluetoothAdapter is null, err", new Object[0]);
            eVar.f136372a.a(com.tencent.luggage.wxa.ne.k.f135749i);
            return;
        }
        eVar.f136372a.a(com.tencent.luggage.wxa.ne.k.f135754n);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e {

        /* renamed from: d, reason: collision with root package name */
        public static final com.tencent.luggage.wxa.ne.b f136371d = new a();

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.ne.b f136372a;

        /* renamed from: b, reason: collision with root package name */
        public List f136373b;

        /* renamed from: c, reason: collision with root package name */
        public final com.tencent.luggage.wxa.ne.j f136374c;

        public e(com.tencent.luggage.wxa.ne.b bVar, List list, com.tencent.luggage.wxa.ne.j jVar) {
            this.f136372a = bVar;
            this.f136373b = list;
            this.f136374c = jVar;
        }

        public e a() {
            com.tencent.luggage.wxa.ne.b bVar = f136371d;
            if (bVar == this.f136372a) {
                return this;
            }
            return new e(bVar, this.f136373b, this.f136374c);
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements com.tencent.luggage.wxa.ne.b {
            @Override // com.tencent.luggage.wxa.ne.b
            public void a(com.tencent.luggage.wxa.ne.k kVar) {
            }
        }
    }

    public synchronized void a(com.tencent.luggage.wxa.ne.b bVar, List list, com.tencent.luggage.wxa.ne.j jVar) {
        e eVar = new e(bVar, list, jVar);
        this.f136362k = eVar;
        a(eVar);
    }

    public synchronized List a() {
        if (this.f136355d == null) {
            return new ArrayList();
        }
        return new ArrayList(this.f136355d.values());
    }
}
