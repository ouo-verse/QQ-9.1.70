package com.tencent.mobileqq.msf.core.net;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.core.v;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import d.a;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class n {
    static IPatchRedirector $redirector_ = null;
    public static final int O = -100;
    public static final int P = -200;
    public static final int Q = -1;
    public static final int R = 0;
    public static final int S = 1;
    public static final int T = 2;
    public static final int U = 3;
    public static final String V = "conSucc";
    private static final int W = 30000;
    private static final int X = 2048;
    public static final int Y = 10000;
    private static int Z;

    /* renamed from: a0, reason: collision with root package name */
    public static ArrayList<String> f248797a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final Set<com.tencent.qphone.base.a> f248798b0;
    private long A;
    private long B;
    private long C;
    private final AtomicLong D;
    private final AtomicLong E;
    private final ReentrantLock F;
    private Runnable G;
    private final MsfCore H;
    private final com.tencent.mobileqq.msf.core.f0.d.a I;
    private final t J;
    private final int K;
    private final List<c> L;
    private final Object M;
    private final AtomicInteger N;

    /* renamed from: a, reason: collision with root package name */
    protected InetSocketAddress f248799a;

    /* renamed from: b, reason: collision with root package name */
    private String f248800b;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.mobileqq.msf.core.d f248801c;

    /* renamed from: d, reason: collision with root package name */
    private i f248802d;

    /* renamed from: e, reason: collision with root package name */
    private int f248803e;

    /* renamed from: f, reason: collision with root package name */
    OutputStream f248804f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.mobileqq.msf.core.net.e f248805g;

    /* renamed from: h, reason: collision with root package name */
    d f248806h;

    /* renamed from: i, reason: collision with root package name */
    MsfSocketInputBuffer f248807i;

    /* renamed from: j, reason: collision with root package name */
    public String f248808j;

    /* renamed from: k, reason: collision with root package name */
    public int f248809k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f248810l;

    /* renamed from: m, reason: collision with root package name */
    private long f248811m;

    /* renamed from: n, reason: collision with root package name */
    private int f248812n;

    /* renamed from: o, reason: collision with root package name */
    private int f248813o;

    /* renamed from: p, reason: collision with root package name */
    private int f248814p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.qphone.base.a f248815q;

    /* renamed from: r, reason: collision with root package name */
    private int f248816r;

    /* renamed from: s, reason: collision with root package name */
    public int f248817s;

    /* renamed from: t, reason: collision with root package name */
    public int f248818t;

    /* renamed from: u, reason: collision with root package name */
    private final AtomicInteger f248819u;

    /* renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f248820v;

    /* renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f248821w;

    /* renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f248822x;

    /* renamed from: y, reason: collision with root package name */
    private final AtomicBoolean f248823y;

    /* renamed from: z, reason: collision with root package name */
    private ToServiceMsg f248824z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends HashSet<com.tencent.qphone.base.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            add(com.tencent.qphone.base.a.closeByNetDetectFailed);
            add(com.tencent.qphone.base.a.closeByNetDetectFailedNew);
            add(com.tencent.qphone.base.a.continueWaitRspTimeout);
            add(com.tencent.qphone.base.a.closeBySSOPingTimeout);
            add(com.tencent.qphone.base.a.closeBySSOPingError);
            add(com.tencent.qphone.base.a.readError);
            add(com.tencent.qphone.base.a.writeError);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qphone.base.a f248825a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f248826b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f248827c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f248828d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f248829e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f248830f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f248831g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f248832h;

        b(com.tencent.qphone.base.a aVar, long j3, int i3, int i16, int i17, int i18, int i19, boolean z16) {
            this.f248825a = aVar;
            this.f248826b = j3;
            this.f248827c = i3;
            this.f248828d = i16;
            this.f248829e = i17;
            this.f248830f = i18;
            this.f248831g = i19;
            this.f248832h = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, n.this, aVar, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (n.this.H.statReporter != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("reason", "" + this.f248825a);
                hashMap.put("useTime", "" + this.f248826b);
                hashMap.put("lastNet", "" + this.f248827c);
                hashMap.put("curNet", "" + this.f248828d);
                hashMap.put("wifiSt", "" + this.f248829e);
                hashMap.put("cdmaSt", "" + this.f248830f);
                hashMap.put("gsmSt", "" + this.f248831g);
                hashMap.put("isMain", "" + this.f248832h);
                hashMap.put("xgSwitch", "" + n.Z);
                n.this.H.statReporter.a("NetConnTime", true, this.f248826b, 0L, (Map<String, String>) hashMap, true, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static abstract class d extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        volatile AtomicBoolean f248834a;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f248834a = new AtomicBoolean(true);
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e extends d {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: j, reason: collision with root package name */
        static final String f248835j = "SocketReaderNew";

        /* renamed from: k, reason: collision with root package name */
        private static final int f248836k = 500;

        /* renamed from: b, reason: collision with root package name */
        final Object f248837b;

        /* renamed from: c, reason: collision with root package name */
        boolean f248838c;

        /* renamed from: d, reason: collision with root package name */
        long f248839d;

        /* renamed from: e, reason: collision with root package name */
        boolean f248840e;

        /* renamed from: f, reason: collision with root package name */
        long f248841f;

        /* renamed from: g, reason: collision with root package name */
        long f248842g;

        /* renamed from: h, reason: collision with root package name */
        long f248843h;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
                return;
            }
            this.f248837b = new Object();
            this.f248838c = false;
            this.f248839d = 0L;
            this.f248840e = false;
            this.f248841f = 0L;
            this.f248842g = 0L;
            this.f248843h = 0L;
        }

        private void b() {
            if (!QLog.isColorLevel()) {
                return;
            }
            if (this.f248843h != 0 && SystemClock.uptimeMillis() - this.f248843h < 500) {
                return;
            }
            this.f248843h = SystemClock.uptimeMillis();
            QLog.d(f248835j + n.this.J.p(), 2, "SocketReader(" + this.f248839d + ") check remainRecvBuffSize: " + n.this.p() + ", ReceiveBufferSize: " + n.this.o());
        }

        @Override // com.tencent.mobileqq.msf.core.net.n.d
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            synchronized (this.f248837b) {
                this.f248837b.notifyAll();
                this.f248838c = true;
            }
            QLog.i(f248835j + n.this.J.p(), 1, "SocketReader(" + this.f248839d + ") onConnOpened");
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x017e, code lost:
        
            if (r15.f248844i.H.mMsfMonitorCallback != null) goto L80;
         */
        @Override // com.tencent.mobileqq.msf.core.net.n.d, com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            com.tencent.mobileqq.msf.core.c0.j jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f248839d = Thread.currentThread().getId();
            QLog.i(f248835j + n.this.J.p(), 1, "SocketReader(" + this.f248839d + ") initialized");
            while (true) {
                try {
                    QLog.i(f248835j + n.this.J.p(), 1, "SocketReader(" + this.f248839d + ") continue");
                    this.f248843h = 0L;
                    while (true) {
                        if (!this.f248834a.get()) {
                            break;
                        }
                        if (n.this.f248807i.isDataAvailable(30000)) {
                            if (n.this.H != null && n.this.H.mMsfMonitorCallback != null) {
                                n.this.H.mMsfMonitorCallback.handleStart(2);
                            }
                            n nVar = n.this;
                            nVar.f248805g.a(nVar.f248807i, nVar.K);
                            n.this.E.addAndGet(n.this.f248807i.getBufferlen());
                            n.this.f248807i.reset();
                            n.this.C = SystemClock.uptimeMillis();
                        } else {
                            b();
                            n.this.C = SystemClock.uptimeMillis();
                            if (!this.f248834a.get()) {
                                QLog.d(f248835j + n.this.J.p(), 1, "read error and continue...");
                                if (n.this.H != null && n.this.H.mMsfMonitorCallback != null) {
                                    n.this.H.mMsfMonitorCallback.handleEnd(2);
                                }
                            }
                        }
                        if (n.this.H != null && n.this.H.mMsfMonitorCallback != null) {
                            n.this.H.mMsfMonitorCallback.handleEnd(2);
                        }
                    }
                    n.this.J.h();
                    if (n.this.H != null) {
                    }
                } catch (Throwable th5) {
                    try {
                        this.f248834a.set(false);
                        n.this.J.h();
                        n.this.a(com.tencent.qphone.base.a.readError);
                        QLog.e(f248835j + n.this.J.p(), 1, "socketEngine: " + n.this.K, "socket hashCode: " + n.this.v(), "SocketReader(" + this.f248839d + ") error", th5);
                        try {
                            long j3 = this.f248842g;
                            if (j3 > 0) {
                                long j16 = this.f248841f;
                                if (j16 > 0 && j3 - j16 < 50 && SystemClock.elapsedRealtime() - this.f248842g < 50) {
                                    if (!this.f248840e) {
                                        this.f248840e = true;
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().e()));
                                        hashMap.put("exception", String.valueOf(th5.getMessage()));
                                        MsfCore msfCore = MsfCore.sCore;
                                        if (msfCore != null && (jVar = msfCore.statReporter) != null) {
                                            jVar.a("msf.core.SocketReaderBreak", false, this.f248842g - this.f248841f, 0L, (Map<String, String>) hashMap, true, false);
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                    n.this.J.h();
                                    if (n.this.H != null) {
                                        n.this.H.mMsfMonitorCallback.handleEnd(2);
                                    }
                                }
                            }
                            if (this.f248841f == 0) {
                                this.f248841f = SystemClock.elapsedRealtime();
                            } else if (this.f248842g == 0) {
                                this.f248842g = SystemClock.elapsedRealtime();
                            } else {
                                this.f248842g = 0L;
                                this.f248841f = 0L;
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    } finally {
                        n.this.J.h();
                        if (n.this.H != null && n.this.H.mMsfMonitorCallback != null) {
                            n.this.H.mMsfMonitorCallback.handleEnd(2);
                        }
                    }
                }
                QLog.i(f248835j + n.this.J.p(), 1, "SocketReader(" + this.f248839d + ") wait");
                try {
                    synchronized (this.f248837b) {
                        if (!this.f248838c) {
                            if (n.this.H != null && n.this.H.mMsfMonitorCallback != null) {
                                n.this.H.mMsfMonitorCallback.handleEnd(2);
                            }
                            this.f248837b.wait(30000L);
                            if (n.this.H != null && n.this.H.mMsfMonitorCallback != null) {
                                n.this.H.mMsfMonitorCallback.handleStart(2);
                            }
                        }
                        this.f248838c = false;
                    }
                    this.f248834a.set(true);
                } catch (Exception e17) {
                    QLog.d(f248835j + n.this.J.p(), 1, "waitObj interrupted", e17);
                    e17.printStackTrace();
                }
            }
            n.this.J.h();
            if (n.this.H != null && n.this.H.mMsfMonitorCallback != null) {
                n.this.H.mMsfMonitorCallback.handleEnd(2);
            }
            QLog.i(f248835j + n.this.J.p(), 1, "SocketReader(" + this.f248839d + ") exit");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f248797a0 = new ArrayList<>();
            f248798b0 = new a();
        }
    }

    public n(MsfCore msfCore, com.tencent.mobileqq.msf.core.f0.d.a aVar, t tVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msfCore, aVar, tVar, Integer.valueOf(i3));
            return;
        }
        this.f248800b = "";
        this.f248803e = -1;
        this.f248804f = null;
        this.f248806h = null;
        this.f248807i = null;
        this.f248808j = "";
        this.f248809k = 0;
        this.f248810l = true;
        this.f248811m = 0L;
        this.f248812n = NetConnInfoCenter.getWifiStrength();
        this.f248813o = NetConnInfoCenter.getCdmaStrength();
        this.f248814p = NetConnInfoCenter.getGsmStrength();
        this.f248815q = null;
        this.f248816r = 0;
        this.f248817s = 0;
        this.f248818t = 0;
        this.f248819u = new AtomicInteger();
        this.f248820v = new AtomicBoolean();
        this.f248821w = new AtomicBoolean();
        this.f248822x = new AtomicBoolean(false);
        this.f248823y = new AtomicBoolean();
        this.A = 0L;
        this.B = 0L;
        this.C = SystemClock.uptimeMillis();
        this.D = new AtomicLong();
        this.E = new AtomicLong();
        this.F = new ReentrantLock();
        this.L = new ArrayList();
        this.M = new Object();
        this.N = new AtomicInteger(0);
        this.I = aVar;
        this.H = msfCore;
        this.J = tVar;
        this.K = i3;
    }

    private void y() {
        com.tencent.mobileqq.msf.core.push.h hVar;
        ToServiceMsg toServiceMsg;
        MsfCore msfCore = this.H;
        if (msfCore != null && (hVar = msfCore.pushManager) != null && (toServiceMsg = hVar.f249736c0) != null) {
            msfCore.sendSsoMsg(toServiceMsg);
            this.H.pushManager.f249736c0 = null;
        }
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.K;
    }

    public int f() {
        com.tencent.mobileqq.msf.core.d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        if (this.f248820v.get() && (dVar = this.f248801c) != null) {
            return dVar.c();
        }
        return 0;
    }

    public com.tencent.mobileqq.msf.core.d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.msf.core.d) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f248801c;
    }

    public com.tencent.mobileqq.msf.core.d h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.msf.core.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f248801c;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f248800b;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f248820v.get();
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f248823y.get();
    }

    public long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
        }
        return this.C;
    }

    public long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this)).longValue();
        }
        i iVar = this.f248802d;
        if (iVar != null) {
            return iVar.a();
        }
        return 0L;
    }

    public long n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.A;
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        try {
            return this.f248802d.getReceiveBufferSize();
        } catch (Throwable th5) {
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "getRecvBuffSize error, ", th5);
            return -1;
        }
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        int i3 = this.f248803e;
        if (i3 != -1) {
            try {
                return CodecWarpper.getSocketRemainRecvBuffSize(i3);
            } catch (Throwable th5) {
                QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "getRemainRecvBuffSize error, ", th5);
            }
        }
        return -1;
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int i3 = this.f248803e;
        if (i3 != -1) {
            try {
                return CodecWarpper.getSocketRemainSendBuffSize(i3);
            } catch (Throwable th5) {
                QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "getRemainSendBuffSize error, ", th5);
            }
        }
        return -1;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        try {
            return this.f248802d.getSendBufferSize();
        } catch (Throwable th5) {
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "getSendBuffSize error, ", th5);
            return -1;
        }
    }

    public long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Long) iPatchRedirector.redirect((short) 32, (Object) this)).longValue();
        }
        return this.D.get();
    }

    public InetSocketAddress t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InetSocketAddress) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f248799a;
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248803e;
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        i iVar = this.f248802d;
        if (iVar == null) {
            return 0;
        }
        return iVar.hashCode();
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        try {
            ToServiceMsg signalMsg = MsfMsgUtil.getSignalMsg();
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "msgSignal seq: " + signalMsg.getRequestSsoSeq());
            a(BaseApplication.getContext().getAppId(), 0, signalMsg.getRequestSsoSeq(), signalMsg.getUin(), signalMsg.getServiceCmd(), "", signalMsg.getMsfCommand(), signalMsg.getWupBuffer(), signalMsg);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "send MsgSignal pkg fail, exception ", e16);
        }
    }

    public ToServiceMsg x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        ToServiceMsg toServiceMsg = this.f248824z;
        if (toServiceMsg != null) {
            this.J.d(toServiceMsg.getRequestSsoSeq());
            this.J.i(this.f248824z);
        }
        return this.f248824z;
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.f248823y.set(z16);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
    }

    public int c() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        synchronized (this.M) {
            i3 = this.N.get();
        }
        return i3;
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? this.B : ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
            return;
        }
        synchronized (this.M) {
            this.N.set(i3);
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        this.f248800b = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<c> it = b().iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }

    private boolean c(com.tencent.qphone.base.a aVar) {
        return f248798b0.contains(aVar);
    }

    public void b(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) cVar);
            return;
        }
        synchronized (this.L) {
            this.L.remove(cVar);
        }
    }

    private List<c> b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.L) {
            if (this.L.size() > 0) {
                arrayList.addAll(this.L);
            }
        }
        return arrayList;
    }

    public void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) cVar);
            return;
        }
        synchronized (this.L) {
            if (cVar != null) {
                if (!this.L.contains(cVar)) {
                    this.L.add(cVar);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:29|30|(3:31|32|33)|(7:34|35|(2:441|442)|37|38|(5:429|430|431|432|433)(3:40|41|42)|43)|(21:44|45|(3:47|48|49)|301|302|303|304|305|(3:307|308|309)|314|315|316|317|318|319|320|321|(2:410|411)|323|(1:325)|326)|(15:331|332|333|334|335|(3:382|383|(3:385|386|(1:388)))|337|338|339|(3:361|362|(8:364|365|(2:372|373)|367|342|(4:344|345|346|347)|348|(10:350|(1:352)(1:354)|353|93|94|95|(3:97|(1:99)(1:102)|100)|103|104|(9:106|(1:110)|111|(1:113)|114|115|116|117|(10:119|120|121|(1:123)|124|(3:126|(1:151)(1:130)|131)(1:152)|132|(1:150)(1:136)|137|(6:139|140|141|(1:143)|144|145)(1:149))(1:156))(1:(1:165)(2:163|164)))(11:355|(1:357)(1:360)|358|359|173|94|95|(0)|103|104|(0)(0))))|341|342|(0)|348|(0)(0))|409|332|333|334|335|(0)|337|338|339|(0)|341|342|(0)|348|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(23:27|28|29|30|(3:31|32|33)|(7:34|35|(2:441|442)|37|38|(5:429|430|431|432|433)(3:40|41|42)|43)|(21:44|45|(3:47|48|49)|301|302|303|304|305|(3:307|308|309)|314|315|316|317|318|319|320|321|(2:410|411)|323|(1:325)|326)|(15:331|332|333|334|335|(3:382|383|(3:385|386|(1:388)))|337|338|339|(3:361|362|(8:364|365|(2:372|373)|367|342|(4:344|345|346|347)|348|(10:350|(1:352)(1:354)|353|93|94|95|(3:97|(1:99)(1:102)|100)|103|104|(9:106|(1:110)|111|(1:113)|114|115|116|117|(10:119|120|121|(1:123)|124|(3:126|(1:151)(1:130)|131)(1:152)|132|(1:150)(1:136)|137|(6:139|140|141|(1:143)|144|145)(1:149))(1:156))(1:(1:165)(2:163|164)))(11:355|(1:357)(1:360)|358|359|173|94|95|(0)|103|104|(0)(0))))|341|342|(0)|348|(0)(0))|409|332|333|334|335|(0)|337|338|339|(0)|341|342|(0)|348|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0632, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0633, code lost:
    
        r15 = ", isProxyIp:";
        r32 = r2;
        r35 = ", localSocket=";
        r3 = "openConn at server=";
        r1 = ", socketHashCode:";
        r14 = ":";
        r13 = ", localSocket:";
        r5 = "openConn at server:";
        r2 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0656, code lost:
    
        r19 = "MSF.C.NetConnTag.";
        r12 = "fail, failReason:";
        r10 = ", result: ";
        r9 = ", socketEngineId:";
        r28 = r10;
        r29 = com.tencent.mobileqq.msf.core.net.n.V;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0645, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0646, code lost:
    
        r15 = ", isProxyIp:";
        r32 = r2;
        r2 = ", protocol:";
        r35 = ", localSocket=";
        r3 = "openConn at server=";
        r1 = ", socketHashCode:";
        r14 = ":";
        r13 = ", localSocket:";
        r5 = "openConn at server:";
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0ac8 A[Catch: InterruptedException -> 0x0e96, TryCatch #12 {InterruptedException -> 0x0e96, blocks: (B:25:0x0107, B:27:0x0117, B:76:0x08cd, B:81:0x08d9, B:87:0x08e7, B:89:0x08fa, B:92:0x0989, B:93:0x09a4, B:104:0x0ac4, B:106:0x0ac8, B:108:0x0ace, B:110:0x0ad6, B:111:0x0ae5, B:113:0x0aee, B:114:0x0af2, B:117:0x0b0e, B:119:0x0b19, B:137:0x0c10, B:141:0x0c41, B:143:0x0c49, B:144:0x0c5a, B:148:0x0c23, B:155:0x0bf1, B:161:0x0c67, B:163:0x0c6f, B:167:0x0aa6, B:168:0x0946, B:169:0x09ad, B:172:0x0a5c, B:173:0x0a7a, B:174:0x0a1d, B:237:0x0ce7, B:242:0x0cf7, B:243:0x0d07, B:245:0x0d1b, B:248:0x0da8, B:255:0x0e91, B:250:0x0d65, B:251:0x0dc7, B:254:0x0e72, B:256:0x0e33, B:342:0x048b, B:347:0x0497, B:348:0x049d, B:350:0x04af, B:353:0x0542, B:354:0x0501, B:355:0x0560, B:358:0x0611, B:360:0x05d2, B:121:0x0b3f, B:123:0x0b47, B:124:0x0b76, B:126:0x0b82, B:128:0x0b8c, B:130:0x0b93, B:131:0x0b9b, B:132:0x0bbb, B:134:0x0bc1, B:136:0x0bc5, B:150:0x0bd2, B:151:0x0b97, B:152:0x0b9f, B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94, B:140:0x0c14), top: B:24:0x0107, inners: #1, #19, #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0c65  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x09ad A[Catch: InterruptedException -> 0x0e96, TryCatch #12 {InterruptedException -> 0x0e96, blocks: (B:25:0x0107, B:27:0x0117, B:76:0x08cd, B:81:0x08d9, B:87:0x08e7, B:89:0x08fa, B:92:0x0989, B:93:0x09a4, B:104:0x0ac4, B:106:0x0ac8, B:108:0x0ace, B:110:0x0ad6, B:111:0x0ae5, B:113:0x0aee, B:114:0x0af2, B:117:0x0b0e, B:119:0x0b19, B:137:0x0c10, B:141:0x0c41, B:143:0x0c49, B:144:0x0c5a, B:148:0x0c23, B:155:0x0bf1, B:161:0x0c67, B:163:0x0c6f, B:167:0x0aa6, B:168:0x0946, B:169:0x09ad, B:172:0x0a5c, B:173:0x0a7a, B:174:0x0a1d, B:237:0x0ce7, B:242:0x0cf7, B:243:0x0d07, B:245:0x0d1b, B:248:0x0da8, B:255:0x0e91, B:250:0x0d65, B:251:0x0dc7, B:254:0x0e72, B:256:0x0e33, B:342:0x048b, B:347:0x0497, B:348:0x049d, B:350:0x04af, B:353:0x0542, B:354:0x0501, B:355:0x0560, B:358:0x0611, B:360:0x05d2, B:121:0x0b3f, B:123:0x0b47, B:124:0x0b76, B:126:0x0b82, B:128:0x0b8c, B:130:0x0b93, B:131:0x0b9b, B:132:0x0bbb, B:134:0x0bc1, B:136:0x0bc5, B:150:0x0bd2, B:151:0x0b97, B:152:0x0b9f, B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94, B:140:0x0c14), top: B:24:0x0107, inners: #1, #19, #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x07a4 A[Catch: all -> 0x0c82, TRY_ENTER, TRY_LEAVE, TryCatch #21 {all -> 0x0c82, blocks: (B:70:0x076f, B:175:0x07a4, B:180:0x07b8, B:184:0x07c9, B:189:0x07e1, B:193:0x07f2, B:197:0x0803, B:201:0x0814, B:232:0x08c1), top: B:69:0x076f }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0cf2  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0d1b A[Catch: InterruptedException -> 0x0e96, TryCatch #12 {InterruptedException -> 0x0e96, blocks: (B:25:0x0107, B:27:0x0117, B:76:0x08cd, B:81:0x08d9, B:87:0x08e7, B:89:0x08fa, B:92:0x0989, B:93:0x09a4, B:104:0x0ac4, B:106:0x0ac8, B:108:0x0ace, B:110:0x0ad6, B:111:0x0ae5, B:113:0x0aee, B:114:0x0af2, B:117:0x0b0e, B:119:0x0b19, B:137:0x0c10, B:141:0x0c41, B:143:0x0c49, B:144:0x0c5a, B:148:0x0c23, B:155:0x0bf1, B:161:0x0c67, B:163:0x0c6f, B:167:0x0aa6, B:168:0x0946, B:169:0x09ad, B:172:0x0a5c, B:173:0x0a7a, B:174:0x0a1d, B:237:0x0ce7, B:242:0x0cf7, B:243:0x0d07, B:245:0x0d1b, B:248:0x0da8, B:255:0x0e91, B:250:0x0d65, B:251:0x0dc7, B:254:0x0e72, B:256:0x0e33, B:342:0x048b, B:347:0x0497, B:348:0x049d, B:350:0x04af, B:353:0x0542, B:354:0x0501, B:355:0x0560, B:358:0x0611, B:360:0x05d2, B:121:0x0b3f, B:123:0x0b47, B:124:0x0b76, B:126:0x0b82, B:128:0x0b8c, B:130:0x0b93, B:131:0x0b9b, B:132:0x0bbb, B:134:0x0bc1, B:136:0x0bc5, B:150:0x0bd2, B:151:0x0b97, B:152:0x0b9f, B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94, B:140:0x0c14), top: B:24:0x0107, inners: #1, #19, #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0dc7 A[Catch: InterruptedException -> 0x0e96, TryCatch #12 {InterruptedException -> 0x0e96, blocks: (B:25:0x0107, B:27:0x0117, B:76:0x08cd, B:81:0x08d9, B:87:0x08e7, B:89:0x08fa, B:92:0x0989, B:93:0x09a4, B:104:0x0ac4, B:106:0x0ac8, B:108:0x0ace, B:110:0x0ad6, B:111:0x0ae5, B:113:0x0aee, B:114:0x0af2, B:117:0x0b0e, B:119:0x0b19, B:137:0x0c10, B:141:0x0c41, B:143:0x0c49, B:144:0x0c5a, B:148:0x0c23, B:155:0x0bf1, B:161:0x0c67, B:163:0x0c6f, B:167:0x0aa6, B:168:0x0946, B:169:0x09ad, B:172:0x0a5c, B:173:0x0a7a, B:174:0x0a1d, B:237:0x0ce7, B:242:0x0cf7, B:243:0x0d07, B:245:0x0d1b, B:248:0x0da8, B:255:0x0e91, B:250:0x0d65, B:251:0x0dc7, B:254:0x0e72, B:256:0x0e33, B:342:0x048b, B:347:0x0497, B:348:0x049d, B:350:0x04af, B:353:0x0542, B:354:0x0501, B:355:0x0560, B:358:0x0611, B:360:0x05d2, B:121:0x0b3f, B:123:0x0b47, B:124:0x0b76, B:126:0x0b82, B:128:0x0b8c, B:130:0x0b93, B:131:0x0b9b, B:132:0x0bbb, B:134:0x0bc1, B:136:0x0bc5, B:150:0x0bd2, B:151:0x0b97, B:152:0x0b9f, B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94, B:140:0x0c14), top: B:24:0x0107, inners: #1, #19, #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0d05  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x06f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04af A[Catch: InterruptedException -> 0x0e96, TryCatch #12 {InterruptedException -> 0x0e96, blocks: (B:25:0x0107, B:27:0x0117, B:76:0x08cd, B:81:0x08d9, B:87:0x08e7, B:89:0x08fa, B:92:0x0989, B:93:0x09a4, B:104:0x0ac4, B:106:0x0ac8, B:108:0x0ace, B:110:0x0ad6, B:111:0x0ae5, B:113:0x0aee, B:114:0x0af2, B:117:0x0b0e, B:119:0x0b19, B:137:0x0c10, B:141:0x0c41, B:143:0x0c49, B:144:0x0c5a, B:148:0x0c23, B:155:0x0bf1, B:161:0x0c67, B:163:0x0c6f, B:167:0x0aa6, B:168:0x0946, B:169:0x09ad, B:172:0x0a5c, B:173:0x0a7a, B:174:0x0a1d, B:237:0x0ce7, B:242:0x0cf7, B:243:0x0d07, B:245:0x0d1b, B:248:0x0da8, B:255:0x0e91, B:250:0x0d65, B:251:0x0dc7, B:254:0x0e72, B:256:0x0e33, B:342:0x048b, B:347:0x0497, B:348:0x049d, B:350:0x04af, B:353:0x0542, B:354:0x0501, B:355:0x0560, B:358:0x0611, B:360:0x05d2, B:121:0x0b3f, B:123:0x0b47, B:124:0x0b76, B:126:0x0b82, B:128:0x0b8c, B:130:0x0b93, B:131:0x0b9b, B:132:0x0bbb, B:134:0x0bc1, B:136:0x0bc5, B:150:0x0bd2, B:151:0x0b97, B:152:0x0b9f, B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94, B:140:0x0c14), top: B:24:0x0107, inners: #1, #19, #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0560 A[Catch: InterruptedException -> 0x0e96, TryCatch #12 {InterruptedException -> 0x0e96, blocks: (B:25:0x0107, B:27:0x0117, B:76:0x08cd, B:81:0x08d9, B:87:0x08e7, B:89:0x08fa, B:92:0x0989, B:93:0x09a4, B:104:0x0ac4, B:106:0x0ac8, B:108:0x0ace, B:110:0x0ad6, B:111:0x0ae5, B:113:0x0aee, B:114:0x0af2, B:117:0x0b0e, B:119:0x0b19, B:137:0x0c10, B:141:0x0c41, B:143:0x0c49, B:144:0x0c5a, B:148:0x0c23, B:155:0x0bf1, B:161:0x0c67, B:163:0x0c6f, B:167:0x0aa6, B:168:0x0946, B:169:0x09ad, B:172:0x0a5c, B:173:0x0a7a, B:174:0x0a1d, B:237:0x0ce7, B:242:0x0cf7, B:243:0x0d07, B:245:0x0d1b, B:248:0x0da8, B:255:0x0e91, B:250:0x0d65, B:251:0x0dc7, B:254:0x0e72, B:256:0x0e33, B:342:0x048b, B:347:0x0497, B:348:0x049d, B:350:0x04af, B:353:0x0542, B:354:0x0501, B:355:0x0560, B:358:0x0611, B:360:0x05d2, B:121:0x0b3f, B:123:0x0b47, B:124:0x0b76, B:126:0x0b82, B:128:0x0b8c, B:130:0x0b93, B:131:0x0b9b, B:132:0x0bbb, B:134:0x0bc1, B:136:0x0bc5, B:150:0x0bd2, B:151:0x0b97, B:152:0x0b9f, B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94, B:140:0x0c14), top: B:24:0x0107, inners: #1, #19, #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0436 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x03c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0775 A[Catch: all -> 0x078e, TRY_ENTER, TRY_LEAVE, TryCatch #28 {all -> 0x078e, blocks: (B:73:0x0775, B:178:0x07ae, B:183:0x07c2, B:187:0x07d3, B:192:0x07eb, B:196:0x07fc, B:200:0x080d, B:204:0x081e, B:207:0x0829, B:209:0x0832, B:210:0x083a, B:212:0x0844, B:213:0x084c, B:215:0x0856, B:216:0x085e, B:218:0x0868, B:219:0x0870, B:221:0x087a, B:222:0x0882, B:224:0x088c, B:225:0x0894, B:227:0x089e, B:228:0x08a6, B:230:0x08b4), top: B:71:0x0773 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x08fa A[Catch: InterruptedException -> 0x0e96, TryCatch #12 {InterruptedException -> 0x0e96, blocks: (B:25:0x0107, B:27:0x0117, B:76:0x08cd, B:81:0x08d9, B:87:0x08e7, B:89:0x08fa, B:92:0x0989, B:93:0x09a4, B:104:0x0ac4, B:106:0x0ac8, B:108:0x0ace, B:110:0x0ad6, B:111:0x0ae5, B:113:0x0aee, B:114:0x0af2, B:117:0x0b0e, B:119:0x0b19, B:137:0x0c10, B:141:0x0c41, B:143:0x0c49, B:144:0x0c5a, B:148:0x0c23, B:155:0x0bf1, B:161:0x0c67, B:163:0x0c6f, B:167:0x0aa6, B:168:0x0946, B:169:0x09ad, B:172:0x0a5c, B:173:0x0a7a, B:174:0x0a1d, B:237:0x0ce7, B:242:0x0cf7, B:243:0x0d07, B:245:0x0d1b, B:248:0x0da8, B:255:0x0e91, B:250:0x0d65, B:251:0x0dc7, B:254:0x0e72, B:256:0x0e33, B:342:0x048b, B:347:0x0497, B:348:0x049d, B:350:0x04af, B:353:0x0542, B:354:0x0501, B:355:0x0560, B:358:0x0611, B:360:0x05d2, B:121:0x0b3f, B:123:0x0b47, B:124:0x0b76, B:126:0x0b82, B:128:0x0b8c, B:130:0x0b93, B:131:0x0b9b, B:132:0x0bbb, B:134:0x0bc1, B:136:0x0bc5, B:150:0x0bd2, B:151:0x0b97, B:152:0x0b9f, B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94, B:140:0x0c14), top: B:24:0x0107, inners: #1, #19, #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0a85 A[Catch: Exception -> 0x0aa6, TryCatch #19 {Exception -> 0x0aa6, blocks: (B:95:0x0a7d, B:97:0x0a85, B:100:0x0a94), top: B:94:0x0a7d, outer: #12 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.tencent.mobileqq.msf.core.d dVar, com.tencent.mobileqq.msf.core.net.e eVar, com.tencent.mobileqq.msf.core.net.b bVar) {
        InterruptedException interruptedException;
        boolean z16;
        long j3;
        q qVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        Throwable th5;
        String str14;
        q qVar2;
        int i3;
        String str15;
        String str16;
        String str17;
        q qVar3;
        i iVar;
        com.tencent.mobileqq.msf.core.d dVar2;
        String str18;
        String str19;
        String str20;
        String str21;
        com.tencent.mobileqq.msf.core.d dVar3;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        Throwable th6;
        String str27;
        String str28;
        q qVar4;
        String str29;
        q qVar5;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String lowerCase;
        String str35;
        String str36;
        q qVar6;
        String str37;
        q qVar7;
        String str38;
        String sb5;
        StringBuilder sb6;
        long currentTimeMillis;
        long j16;
        o oVar;
        d dVar4;
        String str39;
        j.e eVar2;
        q qVar8;
        String str40;
        String str41;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, dVar, eVar, bVar);
            return;
        }
        if ((this.f248821w.get() || !this.f248820v.get()) && this.f248821w.get()) {
            this.f248821w.set(false);
            a(com.tencent.qphone.base.a.closeLastOpened);
        }
        if (com.tencent.mobileqq.msf.core.x.m.j() && this.f248822x.get()) {
            this.f248822x.set(false);
            if (!this.J.f250076a.n()) {
                bVar.f248721d = false;
                bVar.f248722e = q.f248948z;
                bVar.f248718a = 0L;
                QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "stop loopConnIpList for Dual conn end, connId:" + this.K + ", ipFamily:" + dVar.c());
                return;
            }
        }
        if (this.f248824z != null) {
            x();
            this.J.a(this.G);
        }
        this.f248801c = dVar;
        this.f248805g = eVar;
        this.J.f250087l = dVar.k();
        q qVar9 = q.f248924b;
        this.A = 0L;
        try {
            if (!this.F.tryLock(3000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long currentTimeMillis2 = System.currentTimeMillis();
            this.B = System.currentTimeMillis();
            try {
                a.c.a().c(false, dVar);
                try {
                    qVar = qVar9;
                } catch (Throwable th7) {
                    th = th7;
                    j3 = elapsedRealtime;
                    qVar = qVar9;
                }
                try {
                    this.f248799a = new InetSocketAddress(dVar.b(), dVar.d());
                    if (this.J.p()) {
                        try {
                            this.I.f().d();
                        } catch (Throwable th8) {
                            th = th8;
                            j3 = elapsedRealtime;
                            str = "";
                            str2 = ", protocol:";
                            str3 = ", localSocket=";
                            str4 = "openConn at server=";
                            str5 = "fail, failReason:";
                            str6 = ", result: ";
                            str7 = ", localSocket:";
                            str8 = "openConn at server:";
                            th5 = th;
                            str9 = ", isProxyIp:";
                            str10 = ", socketHashCode:";
                            str11 = "MSF.C.NetConnTag.";
                            str12 = ", socketEngineId:";
                            str13 = ":";
                            try {
                                str33 = str10;
                                str34 = str2;
                                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                                try {
                                    this.B = currentTimeMillis3;
                                    str21 = str4;
                                } catch (Throwable th9) {
                                    th = th9;
                                    str21 = str4;
                                }
                            } catch (Throwable th10) {
                                str21 = str4;
                                dVar3 = dVar;
                                str22 = str3;
                                str23 = str2;
                                str24 = str8;
                                str25 = str11;
                                String str42 = str12;
                                String str43 = str10;
                                str26 = ", connElapseTime:";
                                th6 = th10;
                                str27 = str42;
                                str28 = str43;
                                qVar4 = qVar;
                                str29 = str;
                            }
                            try {
                                str27 = str12;
                                try {
                                    this.J.f250076a.f248869s += currentTimeMillis3;
                                    if (this.H.getStatReporter() != null) {
                                    }
                                    str19 = str11;
                                    try {
                                        lowerCase = th5.toString().toLowerCase();
                                    } catch (Throwable th11) {
                                        th = th11;
                                        dVar3 = dVar;
                                        str26 = ", connElapseTime:";
                                        str23 = str34;
                                        str22 = str3;
                                        String str44 = str8;
                                        str25 = str19;
                                        str24 = str44;
                                        th6 = th;
                                        qVar4 = qVar;
                                        str29 = str;
                                        str28 = str33;
                                        String str45 = str23;
                                        this.F.unlock();
                                        qVar5 = q.f248925c;
                                        if (qVar4 == qVar5) {
                                        }
                                        bVar.f248722e = qVar4;
                                        bVar.f248723f = str29;
                                        String str46 = str5;
                                        bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                        if (!QLog.isColorLevel()) {
                                        }
                                    }
                                    try {
                                        try {
                                            if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                                            }
                                            qVar6 = qVar;
                                            str36 = str37;
                                            this.F.unlock();
                                            qVar7 = q.f248925c;
                                            if (qVar6 != qVar7) {
                                            }
                                            bVar.f248722e = qVar6;
                                            bVar.f248723f = str36;
                                            String str47 = str36;
                                            bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                            if (QLog.isColorLevel()) {
                                            }
                                        } catch (Throwable th12) {
                                            th6 = th12;
                                            str29 = lowerCase;
                                            dVar3 = dVar;
                                            str26 = ", connElapseTime:";
                                            qVar4 = qVar;
                                            str23 = str34;
                                            str28 = str33;
                                            str22 = str3;
                                            String str48 = str8;
                                            str25 = str19;
                                            str24 = str48;
                                            String str452 = str23;
                                            this.F.unlock();
                                            qVar5 = q.f248925c;
                                            if (qVar4 == qVar5) {
                                            }
                                            bVar.f248722e = qVar4;
                                            bVar.f248723f = str29;
                                            String str462 = str5;
                                            bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                            if (!QLog.isColorLevel()) {
                                            }
                                        }
                                    } catch (Throwable th13) {
                                        dVar3 = dVar;
                                        str26 = ", connElapseTime:";
                                        str23 = str34;
                                        str22 = str3;
                                        String str49 = str8;
                                        str25 = str19;
                                        str24 = str49;
                                        str29 = lowerCase;
                                        th6 = th13;
                                        qVar4 = qVar;
                                        str28 = str33;
                                        String str4522 = str23;
                                        this.F.unlock();
                                        qVar5 = q.f248925c;
                                        if (qVar4 == qVar5) {
                                        }
                                        bVar.f248722e = qVar4;
                                        bVar.f248723f = str29;
                                        String str4622 = str5;
                                        bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                        if (!QLog.isColorLevel()) {
                                        }
                                    }
                                } catch (Throwable th14) {
                                    th = th14;
                                    dVar3 = dVar;
                                    str24 = str8;
                                    str25 = str11;
                                    str26 = ", connElapseTime:";
                                    str23 = str34;
                                    str22 = str3;
                                }
                            } catch (Throwable th15) {
                                th = th15;
                                dVar3 = dVar;
                                str24 = str8;
                                str26 = ", connElapseTime:";
                                str25 = str11;
                                str23 = str34;
                                str22 = str3;
                                th6 = th;
                                str27 = str12;
                                qVar4 = qVar;
                                str29 = str;
                                str28 = str33;
                                String str45222 = str23;
                                this.F.unlock();
                                qVar5 = q.f248925c;
                                if (qVar4 == qVar5) {
                                    str30 = ", cross:";
                                    try {
                                        bVar.f248721d = false;
                                        bVar.f248728k++;
                                    } catch (InterruptedException e16) {
                                        interruptedException = e16;
                                        z16 = false;
                                        bVar.f248721d = z16;
                                        bVar.f248728k++;
                                        bVar.f248722e = q.f248928f;
                                        bVar.f248723f = interruptedException.toString();
                                        bVar.f248718a = 0L;
                                    }
                                } else {
                                    str30 = ", cross:";
                                }
                                bVar.f248722e = qVar4;
                                bVar.f248723f = str29;
                                String str46222 = str5;
                                bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                if (!QLog.isColorLevel()) {
                                    String str50 = str25 + this.J.p();
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(str24);
                                    sb7.append(this.f248799a.toString());
                                    sb7.append(str7);
                                    sb7.append(this.f248802d.getLocalAddress().getHostAddress());
                                    sb7.append(str13);
                                    sb7.append(this.f248802d.getLocalPort());
                                    sb7.append(str6);
                                    if (qVar4 == qVar5) {
                                        str32 = "success";
                                    } else {
                                        str32 = str46222 + str29 + str26 + bVar.f248718a + str9 + dVar3.f247934k + str30 + k.a(dVar) + str45222 + dVar.e() + str27 + this.K;
                                    }
                                    sb7.append(str32);
                                    sb7.append(str28);
                                    sb7.append(Integer.toHexString(this.f248802d.hashCode()));
                                    QLog.d(str50, 2, sb7.toString());
                                    throw th6;
                                }
                                String str51 = str30;
                                String str52 = str25 + this.J.p();
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append(str21);
                                sb8.append(com.tencent.mobileqq.msf.core.z.a.a(this.f248799a.toString()));
                                sb8.append(str22);
                                sb8.append(com.tencent.mobileqq.msf.core.z.a.a(this.f248802d.getLocalAddress().getHostAddress() + str13 + this.f248802d.getLocalPort()));
                                sb8.append(str6);
                                if (qVar4 == qVar5) {
                                    str31 = "success";
                                } else {
                                    str31 = str46222 + str29 + str26 + bVar.f248718a + str9 + dVar3.f247934k + str51 + k.a(dVar) + str45222 + dVar.e() + str27 + this.K;
                                }
                                sb8.append(str31);
                                sb8.append(str28);
                                sb8.append(Integer.toHexString(this.f248802d.hashCode()));
                                QLog.d(str52, 1, sb8.toString());
                                throw th6;
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        try {
                            sb6 = new StringBuilder();
                            sb6.append("MSF.C.NetConnTag.");
                            str = "";
                        } catch (Throwable th16) {
                            th = th16;
                            str = "";
                        }
                        try {
                            sb6.append(this.J.p());
                            QLog.d(sb6.toString(), 2, "tryOpenConn at server=" + this.f248799a.toString() + " with netType:" + NetConnInfoCenter.getActiveNetworkType() + ", isProxyIp:" + dVar.f247934k + ", cross:" + k.a(dVar) + ", protocol:" + dVar.e() + ", socketEngineId:" + this.K);
                        } catch (Throwable th17) {
                            th = th17;
                            j3 = elapsedRealtime;
                            str2 = ", protocol:";
                            str3 = ", localSocket=";
                            str4 = "openConn at server=";
                            str5 = "fail, failReason:";
                            str6 = ", result: ";
                            str7 = ", localSocket:";
                            str8 = "openConn at server:";
                            th5 = th;
                            str9 = ", isProxyIp:";
                            str10 = ", socketHashCode:";
                            str11 = "MSF.C.NetConnTag.";
                            str12 = ", socketEngineId:";
                            str13 = ":";
                            str33 = str10;
                            str34 = str2;
                            long currentTimeMillis32 = System.currentTimeMillis() - currentTimeMillis2;
                            this.B = currentTimeMillis32;
                            str21 = str4;
                            str27 = str12;
                            this.J.f250076a.f248869s += currentTimeMillis32;
                            if (this.H.getStatReporter() != null) {
                            }
                            str19 = str11;
                            lowerCase = th5.toString().toLowerCase();
                            if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                            }
                            qVar6 = qVar;
                            str36 = str37;
                            this.F.unlock();
                            qVar7 = q.f248925c;
                            if (qVar6 != qVar7) {
                            }
                            bVar.f248722e = qVar6;
                            bVar.f248723f = str36;
                            String str472 = str36;
                            bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        str = "";
                        try {
                            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "tryOpenConn at server=" + com.tencent.mobileqq.msf.core.z.a.a(this.f248799a.toString()) + " with netType:" + NetConnInfoCenter.getActiveNetworkType() + ", isProxyIp:" + dVar.f247934k + ", cross:" + k.a(dVar) + ", protocol:" + dVar.e() + ", socketEngineId:" + this.K);
                        } catch (Throwable th18) {
                            th = th18;
                            j3 = elapsedRealtime;
                            str2 = ", protocol:";
                            str3 = ", localSocket=";
                            str4 = "openConn at server=";
                            str5 = "fail, failReason:";
                            str6 = ", result: ";
                            str7 = ", localSocket:";
                            str8 = "openConn at server:";
                            str9 = ", isProxyIp:";
                            str10 = ", socketHashCode:";
                            str11 = "MSF.C.NetConnTag.";
                            str12 = ", socketEngineId:";
                            str13 = ":";
                            th5 = th;
                            str33 = str10;
                            str34 = str2;
                            long currentTimeMillis322 = System.currentTimeMillis() - currentTimeMillis2;
                            this.B = currentTimeMillis322;
                            str21 = str4;
                            str27 = str12;
                            this.J.f250076a.f248869s += currentTimeMillis322;
                            if (this.H.getStatReporter() != null) {
                            }
                            str19 = str11;
                            lowerCase = th5.toString().toLowerCase();
                            if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                            }
                            qVar6 = qVar;
                            str36 = str37;
                            this.F.unlock();
                            qVar7 = q.f248925c;
                            if (qVar6 != qVar7) {
                            }
                            bVar.f248722e = qVar6;
                            bVar.f248723f = str36;
                            String str4722 = str36;
                            bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    }
                    currentTimeMillis = System.currentTimeMillis();
                } catch (Throwable th19) {
                    th = th19;
                    j3 = elapsedRealtime;
                    str = "";
                    str2 = ", protocol:";
                    str3 = ", localSocket=";
                    str4 = "openConn at server=";
                    str5 = "fail, failReason:";
                    str6 = ", result: ";
                    str7 = ", localSocket:";
                    str8 = "openConn at server:";
                    str9 = ", isProxyIp:";
                    str10 = ", socketHashCode:";
                    str11 = "MSF.C.NetConnTag.";
                    str12 = ", socketEngineId:";
                    str13 = ":";
                    th5 = th;
                    str33 = str10;
                    str34 = str2;
                    long currentTimeMillis3222 = System.currentTimeMillis() - currentTimeMillis2;
                    this.B = currentTimeMillis3222;
                    str21 = str4;
                    str27 = str12;
                    this.J.f250076a.f248869s += currentTimeMillis3222;
                    if (this.H.getStatReporter() != null) {
                    }
                    str19 = str11;
                    lowerCase = th5.toString().toLowerCase();
                    if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                    }
                    qVar6 = qVar;
                    str36 = str37;
                    this.F.unlock();
                    qVar7 = q.f248925c;
                    if (qVar6 != qVar7) {
                    }
                    bVar.f248722e = qVar6;
                    bVar.f248723f = str36;
                    String str47222 = str36;
                    bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                    if (QLog.isColorLevel()) {
                    }
                }
                try {
                    i iVar2 = new i();
                    this.f248802d = iVar2;
                    iVar2.setSoTimeout(10000);
                    this.f248802d.setTcpNoDelay(true);
                    this.f248802d.setKeepAlive(true);
                    this.f248803e = this.f248802d.b();
                    MsfMonitorCallback msfMonitorCallback = this.H.mMsfMonitorCallback;
                    if (msfMonitorCallback != null) {
                        try {
                            msfMonitorCallback.handleEnd(1);
                        } catch (Throwable th20) {
                            th = th20;
                            j3 = elapsedRealtime;
                            currentTimeMillis2 = currentTimeMillis;
                            str2 = ", protocol:";
                            str3 = ", localSocket=";
                            str4 = "openConn at server=";
                            str5 = "fail, failReason:";
                            str6 = ", result: ";
                            str7 = ", localSocket:";
                            str8 = "openConn at server:";
                            th5 = th;
                            str9 = ", isProxyIp:";
                            str10 = ", socketHashCode:";
                            str11 = "MSF.C.NetConnTag.";
                            str12 = ", socketEngineId:";
                            str13 = ":";
                            str33 = str10;
                            str34 = str2;
                            long currentTimeMillis32222 = System.currentTimeMillis() - currentTimeMillis2;
                            this.B = currentTimeMillis32222;
                            str21 = str4;
                            str27 = str12;
                            this.J.f250076a.f248869s += currentTimeMillis32222;
                            if (this.H.getStatReporter() != null) {
                            }
                            str19 = str11;
                            lowerCase = th5.toString().toLowerCase();
                            if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                            }
                            qVar6 = qVar;
                            str36 = str37;
                            this.F.unlock();
                            qVar7 = q.f248925c;
                            if (qVar6 != qVar7) {
                            }
                            bVar.f248722e = qVar6;
                            bVar.f248723f = str36;
                            String str472222 = str36;
                            bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    }
                    b(2);
                    try {
                        this.f248802d.connect(this.f248799a, dVar.f());
                        MsfMonitorCallback msfMonitorCallback2 = this.H.mMsfMonitorCallback;
                        if (msfMonitorCallback2 != null) {
                            try {
                                msfMonitorCallback2.handleStart(1);
                            } catch (Throwable th21) {
                                j3 = elapsedRealtime;
                                currentTimeMillis2 = currentTimeMillis;
                                str2 = ", protocol:";
                                str3 = ", localSocket=";
                                str4 = "openConn at server=";
                                str5 = "fail, failReason:";
                                str6 = ", result: ";
                                str13 = ":";
                                str7 = ", localSocket:";
                                str8 = "openConn at server:";
                                th5 = th21;
                                str9 = ", isProxyIp:";
                                str10 = ", socketHashCode:";
                                str11 = "MSF.C.NetConnTag.";
                                str12 = ", socketEngineId:";
                                str33 = str10;
                                str34 = str2;
                                long currentTimeMillis322222 = System.currentTimeMillis() - currentTimeMillis2;
                                this.B = currentTimeMillis322222;
                                str21 = str4;
                                str27 = str12;
                                this.J.f250076a.f248869s += currentTimeMillis322222;
                                if (this.H.getStatReporter() != null) {
                                }
                                str19 = str11;
                                lowerCase = th5.toString().toLowerCase();
                                if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                                }
                                qVar6 = qVar;
                                str36 = str37;
                                this.F.unlock();
                                qVar7 = q.f248925c;
                                if (qVar6 != qVar7) {
                                }
                                bVar.f248722e = qVar6;
                                bVar.f248723f = str36;
                                String str4722222 = str36;
                                bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                if (QLog.isColorLevel()) {
                                }
                            }
                        }
                        int i16 = this.f248816r;
                        int activeNetworkType = NetConnInfoCenter.getActiveNetworkType();
                        this.f248817s = activeNetworkType;
                        this.f248816r = activeNetworkType;
                        this.f248818t = dVar.c();
                        a(i16);
                        bVar.f248721d = true;
                        bVar.f248727j++;
                        try {
                            long currentTimeMillis4 = System.currentTimeMillis();
                            this.A = currentTimeMillis4;
                            j16 = currentTimeMillis4 - currentTimeMillis;
                            this.B = j16;
                            oVar = this.J.f250076a;
                            currentTimeMillis2 = currentTimeMillis;
                        } catch (Throwable th22) {
                            th = th22;
                            str9 = ", isProxyIp:";
                            j3 = elapsedRealtime;
                            str2 = ", protocol:";
                            currentTimeMillis2 = currentTimeMillis;
                        }
                    } catch (Throwable th23) {
                        th = th23;
                        j3 = elapsedRealtime;
                        currentTimeMillis2 = currentTimeMillis;
                        str2 = ", protocol:";
                        str3 = ", localSocket=";
                        str4 = "openConn at server=";
                        str5 = "fail, failReason:";
                        str6 = ", result: ";
                        str13 = ":";
                        str7 = ", localSocket:";
                        str8 = "openConn at server:";
                        str9 = ", isProxyIp:";
                        str10 = ", socketHashCode:";
                    }
                    try {
                        oVar.f248869s += j16;
                        oVar.a(this.K, true);
                        if (this.B < 0) {
                            try {
                                this.B = 0L;
                            } catch (Throwable th24) {
                                th = th24;
                                str9 = ", isProxyIp:";
                                j3 = elapsedRealtime;
                                str2 = ", protocol:";
                                str3 = ", localSocket=";
                                str4 = "openConn at server=";
                                str10 = ", socketHashCode:";
                                str5 = "fail, failReason:";
                                str6 = ", result: ";
                                str13 = ":";
                                str7 = ", localSocket:";
                                str8 = "openConn at server:";
                                th5 = th;
                                str11 = "MSF.C.NetConnTag.";
                                str12 = ", socketEngineId:";
                                str33 = str10;
                                str34 = str2;
                                long currentTimeMillis3222222 = System.currentTimeMillis() - currentTimeMillis2;
                                this.B = currentTimeMillis3222222;
                                str21 = str4;
                                str27 = str12;
                                this.J.f250076a.f248869s += currentTimeMillis3222222;
                                if (this.H.getStatReporter() != null) {
                                }
                                str19 = str11;
                                lowerCase = th5.toString().toLowerCase();
                                if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                                }
                                qVar6 = qVar;
                                str36 = str37;
                                this.F.unlock();
                                qVar7 = q.f248925c;
                                if (qVar6 != qVar7) {
                                }
                                bVar.f248722e = qVar6;
                                bVar.f248723f = str36;
                                String str47222222 = str36;
                                bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                if (QLog.isColorLevel()) {
                                }
                            }
                        }
                        t.f250070b0 = this.A;
                        this.D.set(0L);
                        this.E.set(0L);
                        OutputStream outputStream = this.f248802d.getOutputStream();
                        this.f248804f = outputStream;
                        if (!f248797a0.contains(outputStream.toString())) {
                            f248797a0.add(this.f248804f.toString());
                        }
                        this.f248807i = new MsfSocketInputBuffer(this.f248802d, 2048, "US-ASCII", -1);
                        dVar4 = this.f248806h;
                    } catch (Throwable th25) {
                        th = th25;
                        str9 = ", isProxyIp:";
                        j3 = elapsedRealtime;
                        str2 = ", protocol:";
                        str3 = ", localSocket=";
                        str4 = "openConn at server=";
                        str10 = ", socketHashCode:";
                        str5 = "fail, failReason:";
                        str6 = ", result: ";
                        str13 = ":";
                        str7 = ", localSocket:";
                        str8 = "openConn at server:";
                        str11 = "MSF.C.NetConnTag.";
                        str12 = ", socketEngineId:";
                        th5 = th;
                        str33 = str10;
                        str34 = str2;
                        long currentTimeMillis32222222 = System.currentTimeMillis() - currentTimeMillis2;
                        this.B = currentTimeMillis32222222;
                        str21 = str4;
                        str27 = str12;
                        this.J.f250076a.f248869s += currentTimeMillis32222222;
                        if (this.H.getStatReporter() != null) {
                        }
                        str19 = str11;
                        lowerCase = th5.toString().toLowerCase();
                        if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                        }
                        qVar6 = qVar;
                        str36 = str37;
                        this.F.unlock();
                        qVar7 = q.f248925c;
                        if (qVar6 != qVar7) {
                        }
                        bVar.f248722e = qVar6;
                        bVar.f248723f = str36;
                        String str472222222 = str36;
                        bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                        if (QLog.isColorLevel()) {
                        }
                    }
                } catch (Throwable th26) {
                    th = th26;
                    j3 = elapsedRealtime;
                    currentTimeMillis2 = currentTimeMillis;
                    str2 = ", protocol:";
                    str3 = ", localSocket=";
                    str4 = "openConn at server=";
                    str5 = "fail, failReason:";
                    str6 = ", result: ";
                    str7 = ", localSocket:";
                    str8 = "openConn at server:";
                    str9 = ", isProxyIp:";
                    str10 = ", socketHashCode:";
                    str11 = "MSF.C.NetConnTag.";
                    str12 = ", socketEngineId:";
                    str13 = ":";
                    th5 = th;
                    str33 = str10;
                    str34 = str2;
                    long currentTimeMillis322222222 = System.currentTimeMillis() - currentTimeMillis2;
                    this.B = currentTimeMillis322222222;
                    str21 = str4;
                    str27 = str12;
                    this.J.f250076a.f248869s += currentTimeMillis322222222;
                    if (this.H.getStatReporter() != null) {
                    }
                    str19 = str11;
                    lowerCase = th5.toString().toLowerCase();
                    if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                    }
                    qVar6 = qVar;
                    str36 = str37;
                    this.F.unlock();
                    qVar7 = q.f248925c;
                    if (qVar6 != qVar7) {
                    }
                    bVar.f248722e = qVar6;
                    bVar.f248723f = str36;
                    String str4722222222 = str36;
                    bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                    if (QLog.isColorLevel()) {
                    }
                }
                if (dVar4 != null && dVar4.isAlive()) {
                    this.f248806h.a();
                    this.f248820v.set(true);
                    qVar2 = q.f248925c;
                    t.f(this.J.p());
                    this.J.b(dVar.n());
                    this.J.a(this.f248802d.getLocalSocketAddress() + "|" + this.f248802d.getLocalPort());
                    this.J.f(k.d());
                    dVar.m();
                    this.f248819u.set(0);
                    if (com.tencent.mobileqq.msf.core.e0.i.f248005l) {
                        try {
                            if (com.tencent.mobileqq.msf.core.net.r.f.f()) {
                                try {
                                    QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "socket adaptor connect");
                                    com.tencent.mobileqq.msf.core.net.r.f fVar = this.J.f250097v;
                                    if (fVar != null) {
                                        fVar.b().a(this.f248802d);
                                    }
                                } catch (Exception e17) {
                                    str39 = ", protocol:";
                                    try {
                                        QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "adaptor open failed", e17);
                                    } catch (Throwable th27) {
                                        th = th27;
                                        str9 = ", isProxyIp:";
                                        j3 = elapsedRealtime;
                                        qVar = qVar2;
                                        str = V;
                                        str3 = ", localSocket=";
                                        str4 = "openConn at server=";
                                        str10 = ", socketHashCode:";
                                        str5 = "fail, failReason:";
                                        str6 = ", result: ";
                                        str13 = ":";
                                        str7 = ", localSocket:";
                                        str8 = "openConn at server:";
                                        str2 = str39;
                                        th5 = th;
                                        str11 = "MSF.C.NetConnTag.";
                                        str12 = ", socketEngineId:";
                                        str33 = str10;
                                        str34 = str2;
                                        long currentTimeMillis3222222222 = System.currentTimeMillis() - currentTimeMillis2;
                                        this.B = currentTimeMillis3222222222;
                                        str21 = str4;
                                        str27 = str12;
                                        this.J.f250076a.f248869s += currentTimeMillis3222222222;
                                        if (this.H.getStatReporter() != null) {
                                        }
                                        str19 = str11;
                                        lowerCase = th5.toString().toLowerCase();
                                        if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                                        }
                                        qVar6 = qVar;
                                        str36 = str37;
                                        this.F.unlock();
                                        qVar7 = q.f248925c;
                                        if (qVar6 != qVar7) {
                                        }
                                        bVar.f248722e = qVar6;
                                        bVar.f248723f = str36;
                                        String str47222222222 = str36;
                                        bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                        if (QLog.isColorLevel()) {
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th28) {
                            th = th28;
                            str9 = ", isProxyIp:";
                            j3 = elapsedRealtime;
                            str2 = ", protocol:";
                            qVar = qVar2;
                            str = V;
                            str3 = ", localSocket=";
                            str4 = "openConn at server=";
                            str10 = ", socketHashCode:";
                            str5 = "fail, failReason:";
                            str6 = ", result: ";
                            str13 = ":";
                            str7 = ", localSocket:";
                            str8 = "openConn at server:";
                            th5 = th;
                            str11 = "MSF.C.NetConnTag.";
                            str12 = ", socketEngineId:";
                            str33 = str10;
                            str34 = str2;
                            long currentTimeMillis32222222222 = System.currentTimeMillis() - currentTimeMillis2;
                            this.B = currentTimeMillis32222222222;
                            str21 = str4;
                            str27 = str12;
                            this.J.f250076a.f248869s += currentTimeMillis32222222222;
                            if (this.H.getStatReporter() != null) {
                                try {
                                    j.e eVar3 = this.H.statReporter.f247848b;
                                    if (eVar3 != null) {
                                        if (eVar3.f247864e > 0 && eVar3.f247865f == 0) {
                                            eVar3.f247865f = System.currentTimeMillis();
                                        }
                                        j.e eVar4 = this.H.statReporter.f247848b;
                                        if (eVar4.f247866g == 0) {
                                            eVar4.f247866g = System.currentTimeMillis();
                                            StringBuilder sb9 = new StringBuilder();
                                            str19 = str11;
                                            try {
                                                sb9.append(str19);
                                                sb9.append(this.J.p());
                                                QLog.d(sb9.toString(), 1, "MSF_Alive_Log set netWorkFailTime =", Long.valueOf(System.currentTimeMillis()));
                                                lowerCase = th5.toString().toLowerCase();
                                                if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                                                    qVar = q.f248935m;
                                                    str37 = qVar.toString();
                                                    bVar.f248725h = com.tencent.mobileqq.msf.core.x.b.C();
                                                } else {
                                                    if (lowerCase.indexOf("illegal") > -1) {
                                                        qVar = q.f248929g;
                                                        str35 = qVar.toString();
                                                    } else if (lowerCase.indexOf("route to host") > -1) {
                                                        qVar = q.f248939q;
                                                        str35 = qVar.toString();
                                                    } else if (lowerCase.indexOf("unreachable") > -1) {
                                                        qVar = q.f248935m;
                                                        str37 = qVar.toString();
                                                        bVar.f248725h = com.tencent.mobileqq.msf.core.x.b.C();
                                                    } else if (lowerCase.indexOf(QCircleDaTongConstant.ElementParamValue.PERMISSION) > -1) {
                                                        qVar = q.f248931i;
                                                        str35 = qVar.toString();
                                                    } else if (lowerCase.indexOf("refused") > -1) {
                                                        qVar = q.f248941s;
                                                        str35 = qVar.toString();
                                                    } else if (lowerCase.indexOf("reset") > -1) {
                                                        qVar = q.f248940r;
                                                        str35 = qVar.toString();
                                                    } else {
                                                        if (lowerCase.indexOf("timeoutexception") <= -1 && lowerCase.indexOf(") after") <= -1) {
                                                            if (lowerCase.indexOf("unknownhost") > -1) {
                                                                qVar = q.f248938p;
                                                                str35 = qVar.toString();
                                                            } else if (lowerCase.indexOf("unresolved") > -1) {
                                                                qVar = q.f248937o;
                                                                str35 = qVar.toString();
                                                            } else if (lowerCase.indexOf("enotsock") > -1) {
                                                                qVar = q.f248930h;
                                                                str35 = qVar.toString();
                                                            } else if (lowerCase.indexOf("enobufs") > -1) {
                                                                qVar = q.f248934l;
                                                                str35 = qVar.toString();
                                                            } else if (lowerCase.indexOf("ebadf") > -1) {
                                                                qVar = q.f248932j;
                                                                str35 = qVar.toString();
                                                            } else if (lowerCase.indexOf(QCircleDaTongConstant.ElementParamValue.OPERATION) > -1) {
                                                                qVar = q.f248942t;
                                                                str35 = qVar.toString();
                                                            } else if (lowerCase.indexOf(HippyReporter.RemoveEngineReason.INVALID) > -1) {
                                                                qVar = q.f248936n;
                                                                str35 = qVar.toString();
                                                            } else {
                                                                qVar = q.f248943u;
                                                                String stackTraceString = MsfSdkUtils.getStackTraceString(th5);
                                                                if (stackTraceString.length() > 200) {
                                                                    str35 = stackTraceString.substring(0, 200);
                                                                } else {
                                                                    str36 = stackTraceString;
                                                                    qVar6 = qVar;
                                                                    this.F.unlock();
                                                                    qVar7 = q.f248925c;
                                                                    if (qVar6 != qVar7) {
                                                                        try {
                                                                            bVar.f248721d = false;
                                                                            bVar.f248728k++;
                                                                        } catch (InterruptedException e18) {
                                                                            interruptedException = e18;
                                                                            z16 = false;
                                                                            bVar.f248721d = z16;
                                                                            bVar.f248728k++;
                                                                            bVar.f248722e = q.f248928f;
                                                                            bVar.f248723f = interruptedException.toString();
                                                                            bVar.f248718a = 0L;
                                                                        }
                                                                    }
                                                                    bVar.f248722e = qVar6;
                                                                    bVar.f248723f = str36;
                                                                    String str472222222222 = str36;
                                                                    bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                                                    if (QLog.isColorLevel()) {
                                                                        str18 = str19 + this.J.p();
                                                                        StringBuilder sb10 = new StringBuilder();
                                                                        sb10.append(str8);
                                                                        sb10.append(this.f248799a.toString());
                                                                        sb10.append(str7);
                                                                        sb10.append(this.f248802d.getLocalAddress().getHostAddress());
                                                                        sb10.append(str13);
                                                                        sb10.append(this.f248802d.getLocalPort());
                                                                        sb10.append(str6);
                                                                        if (qVar6 == qVar7) {
                                                                            dVar2 = dVar;
                                                                            sb5 = "success";
                                                                        } else {
                                                                            StringBuilder sb11 = new StringBuilder();
                                                                            sb11.append(str5);
                                                                            sb11.append(str472222222222);
                                                                            sb11.append(", connElapseTime:");
                                                                            sb11.append(bVar.f248718a);
                                                                            sb11.append(str9);
                                                                            dVar2 = dVar;
                                                                            sb11.append(dVar2.f247934k);
                                                                            sb11.append(", cross:");
                                                                            sb11.append(k.a(dVar));
                                                                            sb11.append(str34);
                                                                            sb11.append(dVar.e());
                                                                            sb11.append(str27);
                                                                            sb11.append(this.K);
                                                                            sb5 = sb11.toString();
                                                                        }
                                                                        sb10.append(sb5);
                                                                        sb10.append(str33);
                                                                        sb10.append(Integer.toHexString(this.f248802d.hashCode()));
                                                                        qVar2 = qVar6;
                                                                        str20 = sb10.toString();
                                                                        QLog.d(str18, 2, str20);
                                                                        str14 = str19;
                                                                        try {
                                                                            if (this.H.getStatReporter() != null) {
                                                                            }
                                                                            str17 = str14;
                                                                        } catch (Exception unused) {
                                                                            StringBuilder sb12 = new StringBuilder();
                                                                            str17 = str14;
                                                                            sb12.append(str17);
                                                                            sb12.append(this.J.p());
                                                                            QLog.d(sb12.toString(), 1, "reportConnEvent fail!");
                                                                        }
                                                                        qVar3 = q.f248925c;
                                                                        if (qVar2 != qVar3) {
                                                                        }
                                                                    } else {
                                                                        StringBuilder sb13 = new StringBuilder();
                                                                        sb13.append(str19);
                                                                        str14 = str19;
                                                                        sb13.append(this.J.p());
                                                                        String sb14 = sb13.toString();
                                                                        StringBuilder sb15 = new StringBuilder();
                                                                        sb15.append(str21);
                                                                        sb15.append(com.tencent.mobileqq.msf.core.z.a.a(this.f248799a.toString()));
                                                                        sb15.append(str3);
                                                                        sb15.append(com.tencent.mobileqq.msf.core.z.a.a(this.f248802d.getLocalAddress().getHostAddress() + str13 + this.f248802d.getLocalPort()));
                                                                        sb15.append(str6);
                                                                        if (qVar6 == qVar7) {
                                                                            str38 = "success";
                                                                        } else {
                                                                            str38 = str5 + str472222222222 + ", connElapseTime:" + bVar.f248718a + str9 + dVar.f247934k + ", cross:" + k.a(dVar) + str34 + dVar.e() + str27 + this.K;
                                                                        }
                                                                        sb15.append(str38);
                                                                        sb15.append(str33);
                                                                        sb15.append(Integer.toHexString(this.f248802d.hashCode()));
                                                                        qVar2 = qVar6;
                                                                        str16 = sb15.toString();
                                                                        i3 = 1;
                                                                        str15 = sb14;
                                                                        QLog.d(str15, i3, str16);
                                                                        if (this.H.getStatReporter() != null) {
                                                                        }
                                                                        str17 = str14;
                                                                        qVar3 = q.f248925c;
                                                                        if (qVar2 != qVar3) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        qVar = q.f248942t;
                                                        str35 = qVar.toString();
                                                    }
                                                    str37 = str35;
                                                }
                                                qVar6 = qVar;
                                                str36 = str37;
                                                this.F.unlock();
                                                qVar7 = q.f248925c;
                                                if (qVar6 != qVar7) {
                                                }
                                                bVar.f248722e = qVar6;
                                                bVar.f248723f = str36;
                                                String str4722222222222 = str36;
                                                bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                                if (QLog.isColorLevel()) {
                                                }
                                            } catch (Throwable th29) {
                                                th6 = th29;
                                                dVar3 = dVar;
                                                str26 = ", connElapseTime:";
                                                qVar4 = qVar;
                                                str29 = str;
                                                str23 = str34;
                                                str28 = str33;
                                                str22 = str3;
                                                String str482 = str8;
                                                str25 = str19;
                                                str24 = str482;
                                                String str452222 = str23;
                                                this.F.unlock();
                                                qVar5 = q.f248925c;
                                                if (qVar4 == qVar5) {
                                                }
                                                bVar.f248722e = qVar4;
                                                bVar.f248723f = str29;
                                                String str462222 = str5;
                                                bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                                if (!QLog.isColorLevel()) {
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th30) {
                                    th6 = th30;
                                    dVar3 = dVar;
                                    str24 = str8;
                                    str25 = str11;
                                    str26 = ", connElapseTime:";
                                    qVar4 = qVar;
                                    str29 = str;
                                    str23 = str34;
                                    str28 = str33;
                                    str22 = str3;
                                    String str4522222 = str23;
                                    this.F.unlock();
                                    qVar5 = q.f248925c;
                                    if (qVar4 == qVar5) {
                                    }
                                    bVar.f248722e = qVar4;
                                    bVar.f248723f = str29;
                                    String str4622222 = str5;
                                    bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                    if (!QLog.isColorLevel()) {
                                    }
                                }
                            }
                            str19 = str11;
                            lowerCase = th5.toString().toLowerCase();
                            if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                            }
                            qVar6 = qVar;
                            str36 = str37;
                            this.F.unlock();
                            qVar7 = q.f248925c;
                            if (qVar6 != qVar7) {
                            }
                            bVar.f248722e = qVar6;
                            bVar.f248723f = str36;
                            String str47222222222222 = str36;
                            bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    }
                    str39 = ", protocol:";
                    if (this.H.getStatReporter() != null) {
                        try {
                            eVar2 = this.H.statReporter.f247848b;
                        } catch (Throwable th31) {
                            th = th31;
                            j3 = elapsedRealtime;
                            str9 = ", isProxyIp:";
                        }
                        if (eVar2 != null) {
                            str9 = ", isProxyIp:";
                            j3 = elapsedRealtime;
                            if (eVar2.f247864e > 0) {
                                try {
                                    eVar2.f247865f = 0L;
                                } catch (Throwable th32) {
                                    th = th32;
                                    qVar = qVar2;
                                    str = V;
                                    str3 = ", localSocket=";
                                    str4 = "openConn at server=";
                                    str10 = ", socketHashCode:";
                                    str5 = "fail, failReason:";
                                    str6 = ", result: ";
                                    str13 = ":";
                                    str7 = ", localSocket:";
                                    str8 = "openConn at server:";
                                    str2 = str39;
                                    th5 = th;
                                    str11 = "MSF.C.NetConnTag.";
                                    str12 = ", socketEngineId:";
                                    str33 = str10;
                                    str34 = str2;
                                    long currentTimeMillis322222222222 = System.currentTimeMillis() - currentTimeMillis2;
                                    this.B = currentTimeMillis322222222222;
                                    str21 = str4;
                                    str27 = str12;
                                    this.J.f250076a.f248869s += currentTimeMillis322222222222;
                                    if (this.H.getStatReporter() != null) {
                                    }
                                    str19 = str11;
                                    lowerCase = th5.toString().toLowerCase();
                                    if (NetConnInfoCenter.getSystemNetworkType() != 0) {
                                    }
                                    qVar6 = qVar;
                                    str36 = str37;
                                    this.F.unlock();
                                    qVar7 = q.f248925c;
                                    if (qVar6 != qVar7) {
                                    }
                                    bVar.f248722e = qVar6;
                                    bVar.f248723f = str36;
                                    String str472222222222222 = str36;
                                    bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                                    if (QLog.isColorLevel()) {
                                    }
                                }
                            }
                            eVar2.f247866g = 0L;
                            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "MSF_Alive_Log set netWorkFailTime 0");
                            this.F.unlock();
                            qVar8 = q.f248925c;
                            if (qVar2 != qVar8) {
                                z16 = false;
                                try {
                                    bVar.f248721d = false;
                                    bVar.f248728k++;
                                } catch (InterruptedException e19) {
                                    interruptedException = e19;
                                    bVar.f248721d = z16;
                                    bVar.f248728k++;
                                    bVar.f248722e = q.f248928f;
                                    bVar.f248723f = interruptedException.toString();
                                    bVar.f248718a = 0L;
                                }
                            }
                            bVar.f248722e = qVar2;
                            bVar.f248723f = V;
                            bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                            if (QLog.isColorLevel()) {
                                String str53 = "MSF.C.NetConnTag." + this.J.p();
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append("openConn at server:");
                                sb16.append(this.f248799a.toString());
                                sb16.append(", localSocket:");
                                sb16.append(this.f248802d.getLocalAddress().getHostAddress());
                                str13 = ":";
                                sb16.append(str13);
                                sb16.append(this.f248802d.getLocalPort());
                                sb16.append(", result: ");
                                if (qVar2 == qVar8) {
                                    str41 = "success";
                                } else {
                                    str41 = "fail, failReason:" + V + ", connElapseTime:" + bVar.f248718a + str9 + dVar.f247934k + ", cross:" + k.a(dVar) + str39 + dVar.e() + ", socketEngineId:" + this.K;
                                }
                                sb16.append(str41);
                                sb16.append(", socketHashCode:");
                                sb16.append(Integer.toHexString(this.f248802d.hashCode()));
                                str20 = sb16.toString();
                                str18 = str53;
                                dVar2 = dVar;
                                str19 = "MSF.C.NetConnTag.";
                                QLog.d(str18, 2, str20);
                                str14 = str19;
                                if (this.H.getStatReporter() != null) {
                                    this.H.getStatReporter().a(qVar2 == q.f248925c, this.B, dVar.b(), f());
                                }
                                str17 = str14;
                                qVar3 = q.f248925c;
                                if (qVar2 != qVar3) {
                                    if (k.a(dVar) && this.J.p()) {
                                        a.c.a().b(true);
                                        a.c.a().d();
                                    }
                                    NetConnInfoCenter.checkConnInfo();
                                    if (!NetConnInfoCenter.isNetSupport()) {
                                        NetConnInfoCenter.setNetSupport(true);
                                    }
                                    this.J.e(NetConnInfoCenter.getSystemNetworkType());
                                    this.J.b((byte[]) null);
                                    this.J.v();
                                    z16 = false;
                                    this.J.f250088m.set(0);
                                    this.J.f250089n.clear();
                                    if (this.f248802d != null) {
                                        this.H.nowSocketConnAdd = this.f248802d.getLocalAddress().getHostAddress() + str13 + this.f248802d.getLocalPort();
                                        try {
                                            if (this.J.p()) {
                                                this.I.f().l(this.f248802d, this.J.l(), (int) this.B);
                                                com.tencent.mobileqq.msf.core.i0.d.a.b().a(this.J.m(), this.f248803e, this.J.l(), f(), this.B);
                                            }
                                            this.f248823y.set(false);
                                            if (com.tencent.mobileqq.msf.core.x.b.C0()) {
                                                if (this.J.f250076a.n() && f() == 1) {
                                                    a(true);
                                                } else {
                                                    a(false);
                                                }
                                                y();
                                            } else {
                                                QLog.d(str17 + this.J.p(), 1, "no send ssoping pkg");
                                            }
                                            if (com.tencent.mobileqq.msf.core.x.b.z() && (iVar = this.f248802d) != null) {
                                                this.G = this.J.b(iVar.hashCode());
                                            } else {
                                                QLog.d(str17 + this.J.p(), 1, "conn fase detect unavailable");
                                            }
                                        } catch (Exception e26) {
                                            e26.printStackTrace();
                                            QLog.d(str17 + this.J.p(), 1, "conn succ detect error,", e26);
                                        }
                                        if (this.f248802d != null) {
                                            try {
                                                com.tencent.mobileqq.msf.core.push.g.f249690s = com.tencent.qphone.base.util.e.a(this.f248799a.toString());
                                            } catch (Exception unused2) {
                                                com.tencent.mobileqq.msf.core.push.g.f249690s = -1L;
                                                QLog.e(str17 + this.J.p(), 1, "get newip error!");
                                            }
                                            if (this.J.p()) {
                                                d.d.b(dVar.b(), dVar.d(), this.J.l());
                                            }
                                            this.J.r();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                if (qVar2 == qVar3 || !this.J.p()) {
                                    return;
                                }
                                this.I.f().e(this.J.l(), this.B, qVar2);
                                return;
                            }
                            str13 = ":";
                            String str54 = str39;
                            String str55 = "MSF.C.NetConnTag." + this.J.p();
                            StringBuilder sb17 = new StringBuilder();
                            sb17.append("openConn at server=");
                            sb17.append(com.tencent.mobileqq.msf.core.z.a.a(this.f248799a.toString()));
                            sb17.append(", localSocket=");
                            sb17.append(com.tencent.mobileqq.msf.core.z.a.a(this.f248802d.getLocalAddress().getHostAddress() + str13 + this.f248802d.getLocalPort()));
                            sb17.append(", result: ");
                            if (qVar2 == qVar8) {
                                str40 = "success";
                            } else {
                                str40 = "fail, failReason:" + V + ", connElapseTime:" + bVar.f248718a + str9 + dVar.f247934k + ", cross:" + k.a(dVar) + str54 + dVar.e() + ", socketEngineId:" + this.K;
                            }
                            sb17.append(str40);
                            sb17.append(", socketHashCode:");
                            sb17.append(Integer.toHexString(this.f248802d.hashCode()));
                            str16 = sb17.toString();
                            str15 = str55;
                            str14 = "MSF.C.NetConnTag.";
                            i3 = 1;
                            QLog.d(str15, i3, str16);
                            if (this.H.getStatReporter() != null) {
                            }
                            str17 = str14;
                            qVar3 = q.f248925c;
                            if (qVar2 != qVar3) {
                            }
                        }
                    }
                    str9 = ", isProxyIp:";
                    j3 = elapsedRealtime;
                    this.F.unlock();
                    qVar8 = q.f248925c;
                    if (qVar2 != qVar8) {
                    }
                    bVar.f248722e = qVar2;
                    bVar.f248723f = V;
                    bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                    if (QLog.isColorLevel()) {
                    }
                }
                e eVar5 = new e();
                this.f248806h = eVar5;
                eVar5.setName(com.tencent.mobileqq.msf.core.q.f249790e);
                this.f248806h.start();
                this.f248820v.set(true);
                qVar2 = q.f248925c;
                t.f(this.J.p());
                this.J.b(dVar.n());
                this.J.a(this.f248802d.getLocalSocketAddress() + "|" + this.f248802d.getLocalPort());
                this.J.f(k.d());
                dVar.m();
                this.f248819u.set(0);
                if (com.tencent.mobileqq.msf.core.e0.i.f248005l) {
                }
                str39 = ", protocol:";
                if (this.H.getStatReporter() != null) {
                }
                str9 = ", isProxyIp:";
                j3 = elapsedRealtime;
                this.F.unlock();
                qVar8 = q.f248925c;
                if (qVar2 != qVar8) {
                }
                bVar.f248722e = qVar2;
                bVar.f248723f = V;
                bVar.f248718a = SystemClock.elapsedRealtime() - j3;
                if (QLog.isColorLevel()) {
                }
            } catch (InterruptedException e27) {
                interruptedException = e27;
                z16 = false;
            }
        } catch (InterruptedException e28) {
            interruptedException = e28;
            z16 = false;
            bVar.f248721d = z16;
            bVar.f248728k++;
            bVar.f248722e = q.f248928f;
            bVar.f248723f = interruptedException.toString();
            bVar.f248718a = 0L;
        }
    }

    public void b(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) aVar);
            return;
        }
        if (this.f248817s == 1) {
            int activeNetworkType = NetConnInfoCenter.getActiveNetworkType();
            if (activeNetworkType == 2 || activeNetworkType == 3) {
                a(aVar);
            }
        }
    }

    private void a(int i3) {
        this.f248810l = false;
        com.tencent.qphone.base.a aVar = this.f248815q;
        if (aVar == null || !c(aVar) || this.f248811m == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.f248811m;
        QLog.d("ReportWeakNetConnTime", 1, "reconnected, use " + uptimeMillis + " ms. LastConnectedNetType: " + i3 + ", reason: " + this.f248815q);
        a(uptimeMillis, this.f248815q, i3, this.f248817s, this.f248812n, this.f248813o, this.f248814p, this.J.p());
        this.f248811m = 0L;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:87|(2:89|(16:91|92|93|(4:95|96|97|(1:99))(1:133)|100|101|102|103|104|105|(1:113)|114|(1:126)(1:118)|119|(1:121)(1:125)|122))|137|92|93|(0)(0)|100|101|102|103|104|105|(4:107|109|111|113)|114|(1:116)|126|119|(0)(0)|122) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:36|37|(18:39|40|(1:43)|44|(2:46|(3:50|51|(1:53)))(1:184)|57|(1:59)(1:183)|60|(3:62|(1:64)|65)|66|67|68|69|(14:139|140|141|142|(1:144)|145|146|(1:148)|150|(2:167|168)|152|(5:157|158|159|160|161)|154|155)(7:71|(1:73)|74|(1:78)|79|(1:81)|83)|84|(1:138)(19:87|(2:89|(16:91|92|93|(4:95|96|97|(1:99))(1:133)|100|101|102|103|104|105|(1:113)|114|(1:126)(1:118)|119|(1:121)(1:125)|122))|137|92|93|(0)(0)|100|101|102|103|104|105|(4:107|109|111|113)|114|(1:116)|126|119|(0)(0)|122)|123|124)|185|40|(1:43)|44|(0)(0)|57|(0)(0)|60|(0)|66|67|68|69|(0)(0)|84|(0)|138|123|124) */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03b6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03b7, code lost:
    
        r3 = new java.lang.StringBuilder();
        r4 = r28;
        r3.append(r4);
        r3.append(r29.J.p());
        r6 = 1;
        com.tencent.qphone.base.util.QLog.d(r3.toString(), 1, "codec onConnClose exception " + r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x038b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x038c, code lost:
    
        r2 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0244, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x02ae, code lost:
    
        com.tencent.qphone.base.util.QLog.d("MSF.C.NetConnTag." + r29.J.p(), 1, "closeConn Throwable " + r0, r0);
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x02ac, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x02ad, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0246 A[Catch: all -> 0x02ac, TRY_ENTER, TryCatch #5 {all -> 0x02ac, blocks: (B:68:0x01bb, B:71:0x0246, B:73:0x024a, B:74:0x024f, B:76:0x0275, B:78:0x0279, B:79:0x0299, B:81:0x02a3), top: B:67:0x01bb }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0362  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.tencent.qphone.base.a aVar) {
        boolean z16;
        TimeUnit timeUnit;
        TimeUnit timeUnit2;
        int i3;
        String str;
        String str2;
        String str3;
        com.tencent.qphone.base.a aVar2;
        com.tencent.mobileqq.msf.core.d dVar;
        ReentrantLock reentrantLock;
        boolean z17;
        j.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) aVar);
            return;
        }
        this.f248817s = 0;
        this.f248818t = 0;
        t tVar = this.J;
        tVar.f250086k = false;
        tVar.f250087l = false;
        this.J.f250085j = 0L;
        InetSocketAddress inetSocketAddress = this.f248799a;
        if (inetSocketAddress != null && com.tencent.mobileqq.msf.core.push.g.f249691t) {
            try {
                try {
                    com.tencent.mobileqq.msf.core.push.g.f249689r = com.tencent.qphone.base.util.e.a(inetSocketAddress.toString());
                } finally {
                    com.tencent.mobileqq.msf.core.push.g.f249691t = false;
                }
            } catch (Exception unused) {
                com.tencent.mobileqq.msf.core.push.g.f249689r = -1L;
                QLog.e("MSF.C.NetConnTag." + this.J.p(), 1, "get oldip error!");
            }
        }
        com.tencent.mobileqq.msf.core.c0.j jVar = MsfCore.sCore.statReporter;
        if (jVar != null && (eVar = jVar.f247848b) != null && eVar.f247866g == 0) {
            eVar.f247866g = System.currentTimeMillis();
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "MSF_Alive_Log : close conn set netWorkFailTime:", Long.valueOf(System.currentTimeMillis()));
        }
        if (this.f248824z != null) {
            x();
            this.J.a(this.G);
        }
        i iVar = this.f248802d;
        if (iVar == null) {
            QLog.e("MSF.C.NetConnTag." + this.J.p(), 1, "closeSocket for reason:" + aVar + " with socket null, socketEngineId:" + this.K);
            b(0);
            return;
        }
        try {
        } catch (Throwable th5) {
            QLog.e("MSF.C.NetConnTag.", 1, "[closeConn] ", th5);
        }
        if (iVar.isConnected()) {
            z16 = true;
            if (!this.f248810l && z16) {
                this.f248810l = true;
                this.f248811m = SystemClock.uptimeMillis();
                this.f248815q = aVar;
                this.f248812n = NetConnInfoCenter.getWifiStrength();
                this.f248813o = NetConnInfoCenter.getCdmaStrength();
                this.f248814p = NetConnInfoCenter.getGsmStrength();
            }
            if (!com.tencent.mobileqq.msf.core.x.b.d()) {
                if (com.tencent.mobileqq.msf.core.e0.i.f248005l && com.tencent.mobileqq.msf.core.net.r.f.f()) {
                    try {
                        QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "socket adaptor disconnect");
                        com.tencent.mobileqq.msf.core.net.r.f fVar = this.J.f250097v;
                        if (fVar != null) {
                            fVar.b().a();
                        }
                    } catch (Exception e16) {
                        QLog.d(com.tencent.mobileqq.msf.core.net.r.a.f248949a + this.J.p(), 1, "adaptor disconnect failed", e16);
                    }
                }
            } else {
                com.tencent.mobileqq.msf.core.e0.i.f248005l = false;
            }
            InetSocketAddress inetSocketAddress2 = this.f248799a;
            String inetSocketAddress3 = inetSocketAddress2 != null ? "" : inetSocketAddress2.toString();
            if (this.J.p()) {
                d.d.a();
                this.I.f().g(aVar);
                a.b.c().b(aVar);
                if (com.tencent.mobileqq.msf.core.x.e.o().b()) {
                    d.c.a();
                }
                com.tencent.mobileqq.msf.core.i0.d.a.b().c();
            }
            reentrantLock = this.F;
            timeUnit = TimeUnit.MILLISECONDS;
            if (!reentrantLock.tryLock(3000L, timeUnit)) {
                try {
                    this.f248819u.set(0);
                    this.J.b((byte[]) null);
                    z17 = this.f248820v.get();
                } catch (Throwable th6) {
                    th = th6;
                }
                try {
                    d dVar2 = this.f248806h;
                    if (dVar2 != null) {
                        dVar2.f248834a.set(false);
                    }
                    try {
                        if (this.f248802d.getInputStream() != null) {
                            this.f248802d.getInputStream().close();
                        }
                    } catch (Throwable unused2) {
                    }
                    OutputStream outputStream = this.f248804f;
                    if (outputStream != null) {
                        try {
                            f248797a0.remove(outputStream.toString());
                            this.f248804f.close();
                        } catch (Exception unused3) {
                        }
                    }
                    i iVar2 = this.f248802d;
                    if (iVar2 != null) {
                        try {
                            iVar2.close();
                            try {
                                v.a(aVar);
                                this.H.getStandByModeManager().k();
                                com.tencent.mobileqq.msf.core.i0.d.a.b().a(aVar);
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                            f248797a0.clear();
                        } catch (Throwable unused4) {
                        }
                    }
                    this.f248802d = null;
                    this.f248803e = -1;
                    this.f248820v.set(false);
                    this.f248805g = null;
                    this.F.unlock();
                    timeUnit2 = z17;
                } catch (Throwable th8) {
                    th = th8;
                    this.F.unlock();
                    throw th;
                }
            } else {
                d dVar3 = this.f248806h;
                if (dVar3 != null) {
                    dVar3.f248834a.set(false);
                }
                QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "can not get lock for closeConn.");
                this.f248821w.set(true);
                if (com.tencent.mobileqq.msf.core.x.m.j() && aVar == com.tencent.qphone.base.a.closeByPeerWinConnection) {
                    QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "closeByPeerWinConnection fail for closeConn, set Socket to stop loopConnIpList");
                    this.f248822x.set(true);
                }
                if (this.f248819u.addAndGet(1) == 10) {
                    SystemMethodProxy.killProcess(Process.myPid());
                }
                timeUnit2 = 1;
            }
            if (!this.f248821w.get() || timeUnit2 == null) {
                i3 = 0;
            } else {
                if (this.A > 0) {
                    long currentTimeMillis = System.currentTimeMillis() - this.A;
                    this.A = 0L;
                    String bytes2HexStr = HexUtil.bytes2HexStr(this.J.j());
                    String currentAPN = NetConnInfoCenter.getCurrentAPN();
                    this.J.f250076a.r();
                    this.J.f250076a.f248870t = 0L;
                    if (this.H.getStatReporter() != null) {
                        str = inetSocketAddress3;
                        str2 = "";
                        str3 = "MSF.C.NetConnTag.";
                        this.H.getStatReporter().a(false, currentTimeMillis / 1000, this.f248801c, aVar, this.J.n(), currentTimeMillis, this.D.get(), this.E.get(), bytes2HexStr, currentAPN, this.J.p());
                        dVar = this.f248801c;
                        if (dVar == null) {
                            aVar2 = aVar;
                            try {
                                if (dVar.a(aVar2)) {
                                    this.I.s().a(this.f248801c);
                                }
                            } catch (Exception e17) {
                                e = e17;
                                e.printStackTrace();
                                this.f248801c = null;
                                this.H.nowSocketConnAdd = null;
                                this.D.set(0L);
                                this.E.set(0L);
                                a(str2);
                                CodecWarpper.nativeOnConnClose(this.J.p());
                                String str4 = str3;
                                int i16 = 1;
                                int j3 = this.J.f250076a.j();
                                if (this.J.p()) {
                                }
                                o oVar = this.J.f250076a;
                                if (oVar == null) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                i3 = 0;
                                b(i3);
                            }
                        } else {
                            aVar2 = aVar;
                        }
                        this.J.b(":");
                        this.J.a("0");
                        this.f248801c = null;
                        this.H.nowSocketConnAdd = null;
                        this.D.set(0L);
                        this.E.set(0L);
                        a(str2);
                        CodecWarpper.nativeOnConnClose(this.J.p());
                        String str42 = str3;
                        int i162 = 1;
                        int j36 = this.J.f250076a.j();
                        if (this.J.p() && this.K == j36 && aVar2 != com.tencent.qphone.base.a.closeByComplexConnFailed && aVar2 != com.tencent.qphone.base.a.closeByComplexConnReset) {
                            NetConnInfoCenter.onConnClosed(aVar);
                        }
                        o oVar2 = this.J.f250076a;
                        boolean z18 = (oVar2 == null && oVar2.j() == e()) ? i162 : 0;
                        if (QLog.isColorLevel()) {
                            QLog.d(str42 + this.J.p(), 2, "closeSocket success server:" + str + ", socketEngineId:" + this.K + ", isMainSocketEngine:" + z18 + " by " + aVar2);
                        } else {
                            QLog.d(str42 + this.J.p(), i162, "closeSocket success server=" + com.tencent.mobileqq.msf.core.z.a.a(str) + ", socketEngineId:" + this.K + ", isMainSocketEngine:" + z18 + " by " + aVar2);
                        }
                        i3 = 0;
                    }
                }
                str = inetSocketAddress3;
                str2 = "";
                str3 = "MSF.C.NetConnTag.";
                dVar = this.f248801c;
                if (dVar == null) {
                }
                this.J.b(":");
                this.J.a("0");
                this.f248801c = null;
                this.H.nowSocketConnAdd = null;
                this.D.set(0L);
                this.E.set(0L);
                a(str2);
                CodecWarpper.nativeOnConnClose(this.J.p());
                String str422 = str3;
                int i1622 = 1;
                int j362 = this.J.f250076a.j();
                if (this.J.p()) {
                    NetConnInfoCenter.onConnClosed(aVar);
                }
                o oVar22 = this.J.f250076a;
                if (oVar22 == null) {
                }
                if (QLog.isColorLevel()) {
                }
                i3 = 0;
            }
            b(i3);
        }
        z16 = false;
        if (!this.f248810l) {
            this.f248810l = true;
            this.f248811m = SystemClock.uptimeMillis();
            this.f248815q = aVar;
            this.f248812n = NetConnInfoCenter.getWifiStrength();
            this.f248813o = NetConnInfoCenter.getCdmaStrength();
            this.f248814p = NetConnInfoCenter.getGsmStrength();
        }
        if (!com.tencent.mobileqq.msf.core.x.b.d()) {
        }
        InetSocketAddress inetSocketAddress22 = this.f248799a;
        if (inetSocketAddress22 != null) {
        }
        if (this.J.p()) {
        }
        reentrantLock = this.F;
        timeUnit = TimeUnit.MILLISECONDS;
        if (!reentrantLock.tryLock(3000L, timeUnit)) {
        }
        if (this.f248821w.get()) {
        }
        i3 = 0;
        b(i3);
    }

    public int a(int i3, int i16, int i17, String str, String str2, String str3, MsfCommand msfCommand, byte[] bArr, ToServiceMsg toServiceMsg) throws IOException {
        com.tencent.mobileqq.msf.core.net.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, str2, str3, msfCommand, bArr, toServiceMsg)).intValue();
        }
        if (this.f248821w.get() || !this.f248820v.get() || (eVar = this.f248805g) == null) {
            return -100;
        }
        if (msfCommand != MsfCommand.openConn) {
            byte[] a16 = eVar.a(this.f248801c, str, str2, bArr);
            if (str2.equals(BaseConstants.CMD_SSO_LOGIN_MERGE) && !this.J.f250087l) {
                ArrayList<Integer> remove = this.J.f250078c.remove(Integer.valueOf(i17));
                QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "NetChanged devide merge package, " + Arrays.toString(remove.toArray()) + " resend.");
                Iterator<Integer> it = remove.iterator();
                while (it.hasNext()) {
                    this.H.sendSsoMsg(this.J.d(it.next().intValue()));
                }
                return -200;
            }
            if (com.tencent.mobileqq.msf.core.e0.i.f248005l && com.tencent.mobileqq.msf.core.net.r.f.f()) {
                QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "send data in socket adaptor way");
                try {
                    com.tencent.mobileqq.msf.core.net.r.f fVar = this.J.f250097v;
                    if (fVar != null) {
                        fVar.b().a(a16, this.f248802d, i17);
                    }
                } catch (Exception e16) {
                    QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "", e16);
                }
            } else {
                this.f248804f.write(a16);
                this.f248804f.flush();
            }
            this.D.addAndGet(a16.length);
            StringBuilder sb5 = new StringBuilder();
            if (QLog.isColorLevel()) {
                String str4 = "MSF.C.NetConnTag." + this.J.p();
                sb5.append("netSend appid:");
                sb5.append(i3);
                sb5.append(" appSeq:");
                sb5.append(i16);
                sb5.append(" ssoSeq:");
                sb5.append(i17);
                sb5.append(" uin:");
                sb5.append(MsfSdkUtils.getShortUin(str));
                sb5.append(" cmd:");
                sb5.append(str2);
                sb5.append(" len:");
                sb5.append(bArr.length);
                sb5.append(" ver:");
                sb5.append(toServiceMsg.getSSOVersion());
                sb5.append(" remainSendBuffLen:");
                sb5.append(q());
                sb5.append(" SendBuffLen:");
                sb5.append(r());
                sb5.append(" socketFd:");
                sb5.append(u());
                sb5.append(" socketEngineID: ");
                sb5.append(this.K);
                sb5.append(" socket: ");
                sb5.append(v());
                QLog.d(str4, 2, sb5.toString());
            } else {
                String str5 = "MSF.C.NetConnTag." + this.J.p();
                sb5.append("netSend appid:");
                sb5.append(i3);
                sb5.append(" appSeq:");
                sb5.append(i16);
                sb5.append(" ssoSeq:");
                sb5.append(i17);
                sb5.append(" uin:");
                sb5.append(MsfSdkUtils.getShortUin(str));
                sb5.append(" cmd=");
                sb5.append(com.tencent.mobileqq.msf.core.z.a.a(str2));
                sb5.append(" len:");
                sb5.append(bArr.length);
                sb5.append(" ver:");
                sb5.append(toServiceMsg.getSSOVersion());
                sb5.append(" socketEngineID: ");
                sb5.append(this.K);
                sb5.append(" socket: ");
                sb5.append(v());
                QLog.d(str5, 1, sb5.toString());
            }
        }
        return bArr.length;
    }

    private void a(boolean z16) {
        String str = ProcessConstant.MSF;
        try {
            ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", ProcessConstant.MSF);
            toServiceMsg.setRequestSsoSeq(this.H.getNextSeq());
            toServiceMsg.setMsfCommand(MsfCommand.msf_ssoping);
            long D0 = com.tencent.mobileqq.msf.core.x.b.D0();
            if (D0 > 10000) {
                toServiceMsg.setTimeout(D0);
            } else {
                toServiceMsg.setTimeout(10000L);
            }
            if (z16) {
                str = "GWv4";
            }
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "ssoping cmd:" + str + " seq: " + toServiceMsg.getRequestSsoSeq() + " timeout: " + toServiceMsg.getTimeout());
            int length = str.getBytes().length + 13 + 1 + 0 + 4;
            byte length2 = (byte) (str.getBytes().length + 1);
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.putInt(length).putInt(20140601).putInt(0).put(length2).put(str.getBytes()).put((byte) 5).putInt(0);
            toServiceMsg.putWupBuffer(allocate.array());
            this.f248824z = toServiceMsg;
            this.J.c(toServiceMsg);
            toServiceMsg.getAttributes().put(BaseConstants.TIMESTAMP_MSF2NET, Long.valueOf(SystemClock.elapsedRealtime()));
            if (a(BaseApplication.getContext().getAppId(), 0, toServiceMsg.getRequestSsoSeq(), toServiceMsg.getUin(), toServiceMsg.getServiceCmd(), "", toServiceMsg.getMsfCommand(), toServiceMsg.getWupBuffer(), toServiceMsg) > 0) {
                if (this.J.p()) {
                    this.I.f().m(toServiceMsg);
                    return;
                }
                return;
            }
            this.J.d(toServiceMsg.getRequestSsoSeq());
            this.J.i(toServiceMsg);
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "send SSOPing pkg fail");
            a(com.tencent.qphone.base.a.closeBySSOPingError);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("MSF.C.NetConnTag." + this.J.p(), 1, "send SSOPing pkg fail, exception ", e16);
        }
    }

    private void a(long j3, com.tencent.qphone.base.a aVar, int i3, int i16, int i17, int i18, int i19, boolean z16) {
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || com.tencent.mobileqq.msf.core.net.utils.e.a(0, 100) < 1) {
            com.tencent.mobileqq.msf.core.q.s().post(new b(aVar, j3, i3, i16, i17, i18, i19, z16));
        }
    }
}
