package com.tencent.hlyyb.common.a;

import android.content.BroadcastReceiver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f114327a = true;

    /* renamed from: b, reason: collision with root package name */
    public static String f114328b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f114329c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f114330d = "";

    /* renamed from: e, reason: collision with root package name */
    public static volatile int f114331e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f114332f = false;

    /* renamed from: g, reason: collision with root package name */
    public static Map<String, InterfaceC5814a> f114333g;

    /* renamed from: h, reason: collision with root package name */
    public static BroadcastReceiver f114334h;

    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.common.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5814a {
        void a(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public final class c extends LinkedBlockingQueue<Runnable> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public g f114335a;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f114335a = null;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Runnable poll(long j3, TimeUnit timeUnit) {
            g gVar;
            Runnable runnable = (Runnable) super.poll(j3, timeUnit);
            if (runnable == null && (gVar = this.f114335a) != null) {
                gVar.a();
            }
            return runnable;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public final /* synthetic */ boolean offer(Object obj) {
            Runnable runnable = (Runnable) obj;
            g gVar = this.f114335a;
            if (gVar != null && gVar.getPoolSize() != this.f114335a.getMaximumPoolSize() && this.f114335a.e() >= this.f114335a.getPoolSize() && this.f114335a.getPoolSize() < this.f114335a.getMaximumPoolSize()) {
                return false;
            }
            return super.offer(runnable);
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
        public final int remainingCapacity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return super.remainingCapacity();
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
        public final /* synthetic */ Object take() {
            g gVar = this.f114335a;
            if (gVar != null && gVar.b()) {
                g gVar2 = this.f114335a;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                return poll(gVar2.getKeepAliveTime(timeUnit), timeUnit);
            }
            return (Runnable) super.take();
        }

        public c(int i3) {
            super(16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f114335a = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        public final void a(g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f114335a = gVar;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            }
        }

        public final boolean a(Runnable runnable, long j3, TimeUnit timeUnit) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3), timeUnit)).booleanValue();
            }
            if (this.f114335a.isShutdown()) {
                throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
            }
            return super.offer(runnable, j3, timeUnit);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public final class d extends BaseThread {
        static IPatchRedirector $redirector_;
        public final long C;

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Long) iPatchRedirector.redirect((short) 1, (Object) this)).longValue();
            }
            return this.C;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19306);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f114333g = new ConcurrentHashMap();
            f114334h = new b();
        }
    }

    public static void a() {
        com.tencent.hlyyb.common.a.g().post(new com.tencent.hlyyb.common.a.c());
    }

    public static synchronized String b() {
        StringBuilder sb5;
        String sb6;
        synchronized (a.class) {
            int i3 = f114331e;
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3 && i3 != 4) {
                    sb6 = "unknown";
                } else {
                    sb5 = new StringBuilder("apn_");
                    sb5.append(f114328b);
                }
            } else {
                sb5 = new StringBuilder("ssid_");
                sb5.append(f114329c);
                sb5.append(f114330d);
            }
            sb6 = sb5.toString();
        }
        return sb6;
    }

    public static synchronized void c() {
        String str;
        synchronized (a.class) {
            int i3 = f114331e;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.tencent.hlyyb.common.a.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    f114327a = true;
                    int type = NetworkMonitor.getType(activeNetworkInfo);
                    if (type == 1) {
                        f114331e = 1;
                        f114332f = false;
                        WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) com.tencent.hlyyb.common.a.a().getSystemService("wifi"));
                        f114329c = com.tencent.hlyyb.common.c.b.b(connectionInfo);
                        f114330d = com.tencent.hlyyb.common.c.b.a(connectionInfo);
                    } else {
                        String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                        if (netGetExInfo != null) {
                            f114328b = netGetExInfo.trim().toLowerCase();
                            if (type == 0) {
                                int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
                                if (subtype != 1 && subtype != 2 && subtype != 4) {
                                    if (subtype == 13) {
                                        f114331e = 4;
                                    } else {
                                        f114331e = 3;
                                    }
                                    f114332f = f114328b.contains("wap");
                                }
                                f114331e = 2;
                                f114332f = f114328b.contains("wap");
                            } else {
                                str = "unknown";
                            }
                        } else {
                            str = "unknown";
                        }
                        f114328b = str;
                        f114331e = 0;
                        f114332f = false;
                    }
                } else {
                    f114328b = "unknown";
                    f114331e = 0;
                    f114332f = false;
                    f114327a = false;
                }
                if (i3 != f114331e) {
                    synchronized (f114333g) {
                        for (InterfaceC5814a interfaceC5814a : f114333g.values()) {
                            if (interfaceC5814a != null) {
                                interfaceC5814a.a(f114331e, b());
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                    if (i3 != f114331e) {
                        synchronized (f114333g) {
                            for (InterfaceC5814a interfaceC5814a2 : f114333g.values()) {
                                if (interfaceC5814a2 != null) {
                                    interfaceC5814a2.a(f114331e, b());
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    if (i3 != f114331e) {
                        synchronized (f114333g) {
                            for (InterfaceC5814a interfaceC5814a3 : f114333g.values()) {
                                if (interfaceC5814a3 != null) {
                                    interfaceC5814a3.a(f114331e, b());
                                }
                            }
                        }
                    }
                    throw th6;
                }
            }
        }
    }

    public static boolean d() {
        try {
            PowerManager powerManager = (PowerManager) com.tencent.hlyyb.common.a.a().getSystemService("power");
            if (powerManager == null) {
                return false;
            }
            return ((Boolean) PowerManager.class.getDeclaredMethod(j.K0, new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean e() {
        if (f114331e != 2 && f114331e != 3 && f114331e != 4) {
            return false;
        }
        return true;
    }

    public static int f() {
        return f114331e;
    }

    public static boolean g() {
        return f114327a;
    }

    public static boolean h() {
        return f114332f;
    }

    public static void a(String str, InterfaceC5814a interfaceC5814a) {
        synchronized (f114333g) {
            f114333g.put(str, interfaceC5814a);
        }
    }
}
