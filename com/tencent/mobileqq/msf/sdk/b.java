package com.tencent.mobileqq.msf.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.msf.sdk.q.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements INetInfoHandler, INetEventHandler {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: l, reason: collision with root package name */
    private static String f250505l = "MSF.D.AppNetInfoNewImpl";

    /* renamed from: m, reason: collision with root package name */
    public static final int f250506m = 254;

    /* renamed from: n, reason: collision with root package name */
    public static final int f250507n = 100;

    /* renamed from: o, reason: collision with root package name */
    public static final int f250508o = 10;

    /* renamed from: p, reason: collision with root package name */
    public static final String f250509p = "com.tencent.mobileqq.msf.bd.netchange";

    /* renamed from: q, reason: collision with root package name */
    public static final String f250510q = "com.tencent.mobileqq.msf.bd.weaknetchange";

    /* renamed from: r, reason: collision with root package name */
    private static final String f250511r = "is_weak_net";

    /* renamed from: s, reason: collision with root package name */
    private static final String f250512s = "weak_net_status_change_reason";

    /* renamed from: t, reason: collision with root package name */
    public static long f250513t;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.msf.sdk.q.a f250514a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f250515b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f250516c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f250517d;

    /* renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<INetInfoHandler> f250518e;

    /* renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<INetEventHandler> f250519f;

    /* renamed from: g, reason: collision with root package name */
    private CopyOnWriteArrayList<IWeakNetStatusHandler> f250520g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f250521h;

    /* renamed from: i, reason: collision with root package name */
    private AtomicBoolean f250522i;

    /* renamed from: j, reason: collision with root package name */
    private BroadcastReceiver f250523j;

    /* renamed from: k, reason: collision with root package name */
    private BroadcastReceiver f250524k;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.msf.sdk.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class RunnableC8104a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Intent f250526a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Context f250527b;

            RunnableC8104a(Intent intent, Context context) {
                this.f250526a = intent;
                this.f250527b = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, intent, context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkInfo networkInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QLog.d(b.f250505l, 1, "onReceive " + this.f250526a.getAction());
                    try {
                        if ("com.tencent.mobileqq.msf.bd.netchange".equals(this.f250526a.getAction())) {
                            try {
                                networkInfo = (NetworkInfo) this.f250526a.getParcelableExtra("networkInfo");
                            } catch (Exception e16) {
                                QLog.e(b.f250505l, 1, "get NetworkInfo by Intent error, ", e16);
                                networkInfo = null;
                            }
                            if (networkInfo == null) {
                                try {
                                    networkInfo = ((ConnectivityManager) this.f250527b.getSystemService("connectivity")).getActiveNetworkInfo();
                                } catch (Exception e17) {
                                    QLog.e(b.f250505l, 1, "get NetworkInfo by getActiveNetworkInfo error, ", e17);
                                }
                            }
                            b.this.a(networkInfo, false);
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        long id5 = Thread.currentThread().getId();
                        String name = Thread.currentThread().getName();
                        b.a(id5, name, th5);
                        QLog.e(b.f250505l, 1, name + "(" + id5 + ") handle netChange broadcast error,", th5);
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else {
                b.this.f250515b.post(new RunnableC8104a(intent, context));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.sdk.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8105b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.msf.sdk.b$b$a */
        /* loaded from: classes15.dex */
        class a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f250530a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Intent f250531b;

            a(Context context, Intent intent) {
                this.f250530a = context;
                this.f250531b = intent;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, C8105b.this, context, intent);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QLog.d(b.f250505l, 1, MsfSdkUtils.getProcessName(this.f250530a) + " onReceive " + this.f250531b.getAction());
                    try {
                        if ("com.tencent.mobileqq.msf.bd.weaknetchange".equals(this.f250531b.getAction())) {
                            boolean booleanExtra = this.f250531b.getBooleanExtra("is_weak_net", false);
                            int intExtra = this.f250531b.getIntExtra("weak_net_status_change_reason", 0);
                            if (booleanExtra) {
                                QLog.d(b.f250505l, 1, MsfSdkUtils.getProcessName(this.f250530a) + " onNormalToWeakNet, reason: " + intExtra);
                                b.this.onNormalToWeakNet(intExtra);
                            } else {
                                QLog.d(b.f250505l, 1, MsfSdkUtils.getProcessName(this.f250530a) + " onWeakNetToNormal, reason: " + intExtra);
                                b.this.onWeakNetToNormal(intExtra);
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        long id5 = Thread.currentThread().getId();
                        b.a(id5, Thread.currentThread().getName(), th5);
                        QLog.d(b.f250505l, 1, Thread.currentThread().getName() + "(" + id5 + ") handle weakNetChange error, ", th5);
                        return;
                    }
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        C8105b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else {
                b.this.f250517d.post(new a(context, intent));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class c extends a.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.d, com.tencent.mobileqq.msf.sdk.q.a.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            b.this.f250522i.set(true);
            if (QLog.isColorLevel()) {
                QLog.d(b.f250505l, 2, "startRefresh ");
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.q.a.d, com.tencent.mobileqq.msf.sdk.q.a.c
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            b.this.f250522i.set(false);
            if (QLog.isColorLevel()) {
                QLog.d(b.f250505l, 2, "refreshFinished ");
            }
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21031);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250518e = new CopyOnWriteArrayList<>();
        this.f250519f = new CopyOnWriteArrayList<>();
        this.f250520g = new CopyOnWriteArrayList<>();
        this.f250521h = new AtomicBoolean(false);
        this.f250522i = new AtomicBoolean(false);
        this.f250523j = new a();
        this.f250524k = new C8105b();
        com.tencent.mobileqq.msf.sdk.q.a aVar = new com.tencent.mobileqq.msf.sdk.q.a();
        this.f250514a = aVar;
        aVar.a((INetInfoHandler) this);
        this.f250514a.a((INetEventHandler) this);
        this.f250514a.a(new c(this, null));
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("AppNetHandlerThread");
        this.f250516c = baseHandlerThread;
        baseHandlerThread.start();
        Handler handler = new Handler(this.f250516c.getLooper());
        this.f250515b = handler;
        this.f250514a.a(handler);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.msf.bd.netchange");
        BaseApplication.getContext().registerReceiver(this.f250523j, intentFilter);
        this.f250517d = new Handler(this.f250516c.getLooper());
        BaseApplication.getContext().registerReceiver(this.f250524k, new IntentFilter("com.tencent.mobileqq.msf.bd.weaknetchange"));
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNormalToWeakNet(int i3) {
        Iterator<IWeakNetStatusHandler> it = this.f250520g.iterator();
        while (it.hasNext()) {
            IWeakNetStatusHandler next = it.next();
            if (next != null) {
                next.onNormalToWeakNet(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWeakNetToNormal(int i3) {
        Iterator<IWeakNetStatusHandler> it = this.f250520g.iterator();
        while (it.hasNext()) {
            IWeakNetStatusHandler next = it.next();
            if (next != null) {
                next.onWeakNetToNormal(i3);
            }
        }
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.f250514a.h();
    }

    public com.tencent.mobileqq.msf.sdk.q.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.msf.sdk.q.a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f250514a;
    }

    public NetworkInfo f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (NetworkInfo) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f250514a.j();
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        if (j()) {
            return this.f250514a.b();
        }
        if (h()) {
            return this.f250514a.i() + 10000;
        }
        return 0;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.f250514a.l();
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.f250514a.m();
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f250514a.n();
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f250521h.compareAndSet(false, true)) {
            this.f250522i.set(true);
            a((NetworkInfo) null, false);
        } else if ((!i() || (i() && f() == null)) && System.currentTimeMillis() - f250513t >= 5000 && this.f250522i.compareAndSet(false, true)) {
            f250513t = System.currentTimeMillis();
            a((NetworkInfo) null, true);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "release");
        }
        BaseApplication.getContext().unregisterReceiver(this.f250523j);
        this.f250514a.a((INetInfoHandler) null);
        this.f250514a.a((INetEventHandler) null);
        this.f250514a.a((a.c) null);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
    public void onNetChangeEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "onNetChangeEvent " + z16);
        }
        Iterator<INetEventHandler> it = this.f250519f.iterator();
        while (it.hasNext()) {
            INetEventHandler next = it.next();
            if (next != null) {
                next.onNetChangeEvent(z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "onNetMobile2None");
        }
        Iterator<INetInfoHandler> it = this.f250518e.iterator();
        while (it.hasNext()) {
            INetInfoHandler next = it.next();
            if (next != null) {
                next.onNetMobile2None();
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "onNetMobile2Wifi " + str);
        }
        Iterator<INetInfoHandler> it = this.f250518e.iterator();
        while (it.hasNext()) {
            INetInfoHandler next = it.next();
            if (next != null) {
                next.onNetMobile2Wifi(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "onNetNone2Mobile " + str);
        }
        Iterator<INetInfoHandler> it = this.f250518e.iterator();
        while (it.hasNext()) {
            INetInfoHandler next = it.next();
            if (next != null) {
                next.onNetNone2Mobile(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "onNetNone2Wifi " + str);
        }
        Iterator<INetInfoHandler> it = this.f250518e.iterator();
        while (it.hasNext()) {
            INetInfoHandler next = it.next();
            if (next != null) {
                next.onNetNone2Wifi(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "onNetWifi2Mobile " + str);
        }
        Iterator<INetInfoHandler> it = this.f250518e.iterator();
        while (it.hasNext()) {
            INetInfoHandler next = it.next();
            if (next != null) {
                next.onNetWifi2Mobile(str);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250505l, 2, "onNetWifi2None");
        }
        Iterator<INetInfoHandler> it = this.f250518e.iterator();
        while (it.hasNext()) {
            INetInfoHandler next = it.next();
            if (next != null) {
                next.onNetWifi2None();
            }
        }
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? this.f250514a.d() : (String) iPatchRedirector.redirect((short) 18, (Object) this);
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? this.f250514a.c() : ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
    }

    public void a(Context context, INetInfoHandler iNetInfoHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) iNetInfoHandler);
            return;
        }
        String str = f250505l;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerNetInfoHandler ");
        sb5.append(iNetInfoHandler == null ? "null" : Integer.toHexString(iNetInfoHandler.hashCode()));
        QLog.d(str, 1, sb5.toString());
        if (iNetInfoHandler != null) {
            this.f250518e.addIfAbsent(iNetInfoHandler);
        }
    }

    public void a(Context context, INetEventHandler iNetEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) iNetEventHandler);
            return;
        }
        String str = f250505l;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerNetEventHandler ");
        sb5.append(iNetEventHandler == null ? "null" : Integer.toHexString(iNetEventHandler.hashCode()));
        QLog.d(str, 1, sb5.toString());
        if (iNetEventHandler != null) {
            this.f250519f.addIfAbsent(iNetEventHandler);
        }
    }

    public void a(Context context, IWeakNetStatusHandler iWeakNetStatusHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) iWeakNetStatusHandler);
            return;
        }
        String str = f250505l;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerWeakNetStatusHandler: ");
        sb5.append(iWeakNetStatusHandler == null ? "null" : Integer.toHexString(iWeakNetStatusHandler.hashCode()));
        QLog.d(str, 1, sb5.toString());
        if (iWeakNetStatusHandler != null) {
            this.f250520g.addIfAbsent(iWeakNetStatusHandler);
        }
    }

    public boolean a(INetInfoHandler iNetInfoHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) iNetInfoHandler)).booleanValue();
        }
        if (iNetInfoHandler == null) {
            Exception exc = new Exception("unRegisterNetInfoHandler null");
            QLog.d(f250505l, 1, "unRegisterNetInfoHandler " + MsfSdkUtils.getStackTraceString(exc, 10));
        } else {
            QLog.d(f250505l, 1, "unRegisterNetInfoHandler " + Integer.toHexString(iNetInfoHandler.hashCode()));
        }
        if (iNetInfoHandler == null) {
            return false;
        }
        boolean remove = this.f250518e.remove(iNetInfoHandler);
        if (!remove) {
            QLog.d(f250505l, 1, "unRegisterNetInfoHandler failed memory leak: " + iNetInfoHandler);
            Exception exc2 = new Exception("unRegisterNetInfoHandler do not exist object");
            QLog.d(f250505l, 1, "unRegisterNetInfoHandler " + MsfSdkUtils.getStackTraceString(exc2));
        }
        return remove;
    }

    public boolean a(INetEventHandler iNetEventHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) iNetEventHandler)).booleanValue();
        }
        if (iNetEventHandler == null) {
            Exception exc = new Exception("unRegisterNetEventHandler null");
            QLog.d(f250505l, 1, "unRegisterNetEventHandler " + MsfSdkUtils.getStackTraceString(exc));
        } else {
            QLog.d(f250505l, 1, "unRegisterNetInfoHandler " + Integer.toHexString(iNetEventHandler.hashCode()));
        }
        if (iNetEventHandler != null) {
            return this.f250519f.remove(iNetEventHandler);
        }
        return false;
    }

    public boolean a(IWeakNetStatusHandler iWeakNetStatusHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) iWeakNetStatusHandler)).booleanValue();
        }
        if (iWeakNetStatusHandler == null) {
            Exception exc = new Exception("[unRegisterWeakNetStatusHandler] null");
            QLog.d(f250505l, 1, "[unRegisterWeakNetStatusHandler] " + MsfSdkUtils.getStackTraceString(exc));
            return false;
        }
        QLog.d(f250505l, 1, "[unRegisterWeakNetStatusHandler]: " + Integer.toHexString(iWeakNetStatusHandler.hashCode()));
        return this.f250520g.remove(iWeakNetStatusHandler);
    }

    public boolean a(NetworkInfo networkInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? this.f250514a.b(networkInfo) : ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) networkInfo)).booleanValue();
    }

    public void a(NetworkInfo networkInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, networkInfo, Boolean.valueOf(z16));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean i3 = i();
        boolean z17 = this.f250514a.j() == null;
        this.f250514a.a(BaseApplication.getContext(), networkInfo);
        if (z16) {
            NetworkInfo j3 = this.f250514a.j();
            if (j3 != null && j3.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                QLog.i(f250505l, 1, "checkNetEvent isNetSupport=" + i() + ", but net detailed state is CONNECTED");
                QLog.i(f250505l, 1, "checkNetEvent current netInfo: " + j3);
                HashMap hashMap = new HashMap();
                hashMap.put("processName", MsfServiceSdk.get().processName);
                hashMap.put("netType", String.valueOf(NetworkMonitor.getType(j3)));
                RdmReq rdmReq = new RdmReq();
                rdmReq.eventName = "CheckNetIsValid";
                rdmReq.elapse = System.currentTimeMillis() - currentTimeMillis;
                rdmReq.isSucceed = true;
                rdmReq.isRealTime = true;
                rdmReq.params = hashMap;
                try {
                    MsfServiceSdk.get().sendMsg(MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            if (i3 && z17) {
                String str = f250505l;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("WARN: checkNetEvent exception, isNetSupport=");
                sb5.append(i3);
                sb5.append(" sysNetType=");
                sb5.append(j3 == null ? "null" : Integer.valueOf(NetworkMonitor.getType(j3)));
                sb5.append(" android=");
                int i16 = Build.VERSION.SDK_INT;
                sb5.append(i16);
                sb5.append("_");
                String str2 = Build.VERSION.RELEASE;
                sb5.append(str2);
                sb5.append(" vendor=");
                String str3 = Build.MANUFACTURER;
                sb5.append(str3);
                sb5.append("_");
                String model = DeviceInfoMonitor.getModel();
                sb5.append(model);
                sb5.append(" connexp=true");
                QLog.i(str, 1, sb5.toString());
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sysNetworkInfo", String.valueOf(j3 != null ? Integer.valueOf(NetworkMonitor.getType(j3)) : "null"));
                hashMap2.put("android", String.valueOf(i16 + "_" + str2));
                hashMap2.put(DKConfiguration.Directory.VENDOR, String.valueOf(str3 + "_" + model));
                hashMap2.put("connexp", String.valueOf(true));
                RdmReq rdmReq2 = new RdmReq();
                rdmReq2.eventName = "CheckNetIsValid2";
                rdmReq2.elapse = System.currentTimeMillis() - currentTimeMillis;
                rdmReq2.isSucceed = true;
                rdmReq2.isRealTime = true;
                rdmReq2.params = hashMap2;
                try {
                    MsfServiceSdk.get().sendMsg(MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq2));
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    public static void a(long j3, String str, Throwable th5) {
        if (MsfSdkUtils.getProcessName(BaseApplication.getContext()).equals(BaseApplication.getContext().getPackageName() + ":MSF")) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(BaseConstants.KEY_THREAD_PID, String.valueOf(j3));
            hashMap.put(BaseConstants.KEY_THREAD_NAME, str);
            hashMap.put(BaseConstants.KEY_ERROR_THR, MsfSdkUtils.getStackTraceString(th5, 10));
            hashMap.put(BaseConstants.KEY_ERROR_TIME, String.valueOf(System.currentTimeMillis()));
            RdmReq rdmReq = new RdmReq();
            rdmReq.isSucceed = true;
            rdmReq.isRealTime = true;
            rdmReq.eventName = BaseConstants.EVENT_THREAD_ERROR;
            rdmReq.params = hashMap;
            MsfServiceSdk.get().sendMsg(MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq));
        } catch (Throwable th6) {
            QLog.e(f250505l, 1, "reportAppNetHandlerThreadError fail, ", th6);
        }
    }
}
