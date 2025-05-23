package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.msf.core.i0.c.a;
import com.tencent.mobileqq.msf.core.i0.d.b;
import com.tencent.mobileqq.msf.core.x.r;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class w extends com.tencent.mobileqq.msf.core.i0.c.a {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "WeakNetDetector";
    private static r.a B;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f250138r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f250139s;

    /* renamed from: t, reason: collision with root package name */
    private WeakReference<c> f250140t;

    /* renamed from: u, reason: collision with root package name */
    private WeakReference<b> f250141u;

    /* renamed from: v, reason: collision with root package name */
    private WeakReference<e> f250142v;

    /* renamed from: w, reason: collision with root package name */
    private WeakReference<d> f250143w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f250144x;

    /* renamed from: y, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.i0.d.b f250145y;

    /* renamed from: z, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.d.a f250146z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.mobileqq.msf.core.c0.j jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!w.this.f250144x && w.this.a() && !NetConnInfoCenter.isWifiConn()) {
                w.this.f250144x = true;
                HashMap hashMap = new HashMap();
                hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, String.valueOf(NetConnInfoCenter.getActiveNetworkType()));
                hashMap.put("reason", String.valueOf(w.this.f248481b.b()));
                MsfCore msfCore = MsfCore.sCore;
                if (msfCore != null && (jVar = msfCore.statReporter) != null) {
                    jVar.a(com.tencent.mobileqq.msf.core.c0.g.A2, false, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f250148a;

        /* renamed from: b, reason: collision with root package name */
        long f250149b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            } else {
                this.f250148a = 0L;
                this.f250149b = 0L;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            w wVar = w.this;
            if (wVar.f248481b.f248508a) {
                long j3 = this.f250149b;
                if (j3 > 0 && this.f250148a > 0) {
                    wVar.a(j3, System.currentTimeMillis() - this.f250148a, true);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f250151a;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            } else {
                this.f250151a = new AtomicBoolean(false);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = w.this.f248481b;
            if (aVar.f248510c > 0) {
                aVar.f248512e = System.currentTimeMillis() - w.this.f248481b.f248510c;
                if (QLog.isColorLevel()) {
                    QLog.d("WeakNetDetector", 2, "CheckConnTimer conn cost=" + w.this.f248481b.f248512e + " oldReason=" + Integer.toHexString(w.this.f248481b.b()));
                }
                w.this.a(1);
                w.this.j();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            B = com.tencent.mobileqq.msf.core.x.r.b();
        }
    }

    public w(com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f250138r = q.q();
        this.f250139s = true;
        this.f250140t = null;
        this.f250141u = null;
        this.f250142v = null;
        this.f250143w = null;
        this.f250144x = false;
        this.f250146z = aVar;
        this.f248481b.c();
        this.f250145y = new com.tencent.mobileqq.msf.core.i0.d.b();
    }

    private void g() {
        if (!b(16)) {
            WeakReference<d> weakReference = this.f250143w;
            if (weakReference == null || weakReference.get() == null) {
                synchronized (d.class) {
                    WeakReference<d> weakReference2 = this.f250143w;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        this.f250143w = new WeakReference<>(new d(this, null));
                    }
                }
            }
            if (this.f250143w.get().f250153a.compareAndSet(false, true)) {
                k();
                this.f250143w.get().f250154b = false;
                this.f250138r.postDelayed(this.f250143w.get(), B.f250433i);
                if (QLog.isColorLevel()) {
                    QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " startQuickSendCheck wifiConned=" + this.f248481b.f248508a);
                }
            }
        }
    }

    private void h() {
        if (this.f248481b.f248508a) {
            WeakReference<e> weakReference = this.f250142v;
            if (weakReference == null || weakReference.get() == null) {
                synchronized (e.class) {
                    WeakReference<e> weakReference2 = this.f250142v;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        this.f250142v = new WeakReference<>(new e(this, null));
                    }
                }
            }
            if (this.f250142v.get() != null) {
                l();
                this.f250142v.get().f250159c = false;
                this.f250138r.postDelayed(this.f250142v.get(), B.f250431g);
            }
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " startWeakNetworkSsoCheck wifiConned=" + this.f248481b.f248508a);
            }
        }
    }

    private void i() {
        j();
        k();
        l();
        WeakReference<b> weakReference = this.f250141u;
        if (weakReference != null && weakReference.get() != null) {
            this.f250138r.removeCallbacks(this.f250141u.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        WeakReference<c> weakReference = this.f250140t;
        if (weakReference != null && weakReference.get() != null) {
            this.f250138r.removeCallbacks(this.f250140t.get());
            this.f250140t.get().f250151a.set(false);
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " stopConnCheck");
            }
        }
    }

    private void k() {
        WeakReference<d> weakReference = this.f250143w;
        if (weakReference != null && weakReference.get() != null) {
            this.f250138r.removeCallbacks(this.f250143w.get());
            this.f250143w.get().f250154b = true;
            this.f250143w.get().f250153a.set(false);
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " stopQuickSendCheck");
            }
        }
    }

    private void l() {
        WeakReference<e> weakReference = this.f250142v;
        if (weakReference != null && weakReference.get() != null) {
            this.f250142v.get().f250159c = true;
            this.f250138r.removeCallbacks(this.f250142v.get());
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " stopWeakNetworkSsoCheck");
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, j3);
    }

    private void f() {
        if (b(1)) {
            return;
        }
        WeakReference<c> weakReference = this.f250140t;
        if (weakReference == null || weakReference.get() == null) {
            synchronized (c.class) {
                WeakReference<c> weakReference2 = this.f250140t;
                if (weakReference2 == null || weakReference2.get() == null) {
                    this.f250140t = new WeakReference<>(new c());
                }
            }
        }
        if (this.f250140t.get().f250151a.compareAndSet(false, true)) {
            this.f250138r.removeCallbacks(this.f250140t.get());
            this.f250138r.postDelayed(this.f250140t.get(), B.f250427c);
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " startConnCheck oldReason=" + Integer.toHexString(this.f248481b.b()));
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) toServiceMsg);
    }

    public boolean b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? a(this.f248481b.b(), i3) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) toServiceMsg);
        } else if (this.f248481b.f248508a && toServiceMsg != null) {
            if (toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249866x) == null) {
                toServiceMsg.getAttributes().put(com.tencent.mobileqq.msf.core.quicksend.b.f249866x, Long.valueOf(SystemClock.elapsedRealtime()));
            }
            g();
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void e(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg != null) {
            if (!toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET)) {
                toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET, Long.valueOf(System.currentTimeMillis()));
            }
            if (a()) {
                toServiceMsg.getAttributes().put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, Boolean.TRUE);
            }
        }
        if (!this.f248481b.f248508a || toServiceMsg == null) {
            return;
        }
        if (this.f250139s && toServiceMsg.isNeedCallback()) {
            this.f250145y.f248571b.f248575a++;
        }
        if (this.f248481b.f248531x == 0 && toServiceMsg.isNeedCallback() && toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET) != null) {
            this.f248481b.f248531x = toServiceMsg.getRequestSsoSeq();
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, "onSendFirst ssoSeq=" + this.f248481b.f248531x + " msf2net=" + System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public volatile AtomicBoolean f250153a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f250154b;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            } else {
                this.f250153a = new AtomicBoolean(false);
                this.f250154b = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f250154b) {
                return;
            }
            int size = w.this.f250146z.q().c().size();
            if (w.this.f250146z.q().c() != null && size > 0 && size < 100) {
                Collection<ToServiceMsg> values = w.this.f250146z.q().c().values();
                long j3 = 0;
                boolean z16 = false;
                if (values != null && values.size() > 0) {
                    Iterator<ToServiceMsg> it = values.iterator();
                    long j16 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            ToServiceMsg next = it.next();
                            if (next != null) {
                                j16 = SystemClock.elapsedRealtime() - ((Long) next.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249866x, 0L)).longValue();
                                if (j16 > w.B.f250433i) {
                                    j3 = j16;
                                    z16 = true;
                                    i3 = next.getRequestSsoSeq();
                                    break;
                                }
                            }
                        } else {
                            i3 = 0;
                            j3 = j16;
                            break;
                        }
                    }
                } else {
                    i3 = 0;
                }
                if (z16) {
                    w wVar = w.this;
                    wVar.f248481b.f248527t = j3;
                    wVar.a(16);
                    if (QLog.isColorLevel()) {
                        QLog.d("WeakNetDetector", 2, "weaknet quickSendCheck reason=" + Integer.toHexString(w.this.f248481b.b()) + " ssoSeq=" + i3 + " timeout=" + z16);
                    }
                }
                if (!w.this.b(16) && w.this.f250146z.q().c().size() > 0 && w.this.f250143w != null && w.this.f250143w.get() != null) {
                    w.this.f250138r.postDelayed((Runnable) w.this.f250143w.get(), w.B.f250433i);
                }
            }
        }

        /* synthetic */ d(w wVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) wVar, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, this, toServiceMsg, fromServiceMsg, dVar);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248510c == 0) {
            aVar.f248510c = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, "onConnPrepare type=" + NetConnInfoCenter.getSystemNetStateString() + " connStart=" + this.f248481b.f248510c);
            }
            f();
            HashMap hashMap = new HashMap();
            hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, "Prepare");
            com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void d(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (this.f250139s && toServiceMsg != null && !((Boolean) toServiceMsg.getAttribute(MsfConstants.ATTR_CHAT_MSG_SENT_FLAG, Boolean.FALSE)).booleanValue()) {
            toServiceMsg.getAttributes().put(MsfConstants.ATTR_CHAT_MSG_SENT_FLAG, Boolean.TRUE);
            this.f250145y.f248573d.f248575a++;
        }
        if ((BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) && !this.f250144x && a() && !NetConnInfoCenter.isWifiConn()) {
            this.f250138r.postDelayed(new a(), 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: e, reason: collision with root package name */
        static final short f250156e = 10;

        /* renamed from: a, reason: collision with root package name */
        final HashMap<String, Integer> f250157a;

        /* renamed from: b, reason: collision with root package name */
        StringBuilder f250158b;

        /* renamed from: c, reason: collision with root package name */
        boolean f250159c;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
                return;
            }
            this.f250157a = new HashMap<>(10);
            this.f250158b = null;
            this.f250159c = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:73:0x01cd, code lost:
        
            if (r9.f250160d.f250142v.get() != null) goto L63;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x01f3, code lost:
        
            r9.f250160d.f250138r.postDelayed((java.lang.Runnable) r9.f250160d.f250142v.get(), com.tencent.mobileqq.msf.core.w.B.f250431g);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x01f1, code lost:
        
            if (r9.f250160d.f250142v.get() != null) goto L63;
         */
        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Object attribute;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f250159c) {
                return;
            }
            try {
                t j3 = w.this.f250146z.r().j();
                if (j3.f250077b.size() >= w.B.f250429e) {
                    this.f250157a.clear();
                    short s16 = 0;
                    for (ToServiceMsg toServiceMsg : j3.f250077b.values()) {
                        if (toServiceMsg.isNeedCallback() && ((attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET)) != null || (attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)) != null || (attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)) != null || (attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_APP2MSF)) != null)) {
                            long longValue = ((Long) attribute).longValue();
                            if (longValue > 0 && System.currentTimeMillis() - longValue > w.B.f250431g) {
                                if (this.f250157a.size() >= 10) {
                                    break;
                                }
                                s16 = (short) (s16 + 1);
                                this.f250157a.put(toServiceMsg.getServiceCmd(), Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
                            }
                        }
                    }
                    if (s16 >= w.B.f250429e && w.B.f250430f <= 0) {
                        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = w.this.f248481b;
                        aVar.f248520m = s16;
                        aVar.f248521n = (short) this.f250157a.size();
                        w.this.a(4);
                        HashMap hashMap = new HashMap();
                        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_BN, String.valueOf((int) w.this.f248481b.f248520m));
                        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_BC, String.valueOf((int) w.this.f248481b.f248521n));
                        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder(512);
                            this.f250158b = sb5;
                            sb5.append("wakenet ssoCheck current:" + Integer.toHexString(w.this.f248481b.b()) + " sendQueue:" + j3.f250077b.size() + " detectQueue:" + j3.f250079d.size() + " waitQueue:" + j3.f250080e.size() + " delayWaitQueue:" + j3.f250081f.size() + " bnbc: \n");
                            for (String str : this.f250157a.keySet()) {
                                Integer num = this.f250157a.get(str);
                                StringBuilder sb6 = this.f250158b;
                                sb6.append(" ssoSeq:");
                                sb6.append(num);
                                sb6.append(" serviceCmd:");
                                sb6.append(str);
                                sb6.append("\n");
                            }
                            QLog.d("WeakNetDetector", 2, this.f250158b.toString());
                            this.f250158b = null;
                        }
                    }
                }
                if (w.this.f250142v != null) {
                }
            } catch (Throwable th5) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.e("WeakNetDetector", 1, th5.getMessage(), th5);
                    }
                    if (w.this.f250142v != null) {
                    }
                } catch (Throwable th6) {
                    if (w.this.f250142v != null && w.this.f250142v.get() != null) {
                        w.this.f250138r.postDelayed((Runnable) w.this.f250142v.get(), w.B.f250431g);
                    }
                    this.f250157a.clear();
                    throw th6;
                }
            }
            this.f250157a.clear();
        }

        /* synthetic */ e(w wVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) wVar, (Object) aVar);
        }
    }

    private boolean a(int i3, int i16) {
        return (i3 & i16) == i16;
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        this.f248481b.f248532y = 0;
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onScreenOff");
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248481b.b() > 0 : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007e, code lost:
    
        if (r4 <= r3.f248524q) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009f, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009d, code lost:
    
        if (64 == r7) goto L49;
     */
    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        int b16 = this.f248481b.b();
        if (1 == i3) {
            long j3 = this.f248481b.f248512e;
            b16 = (j3 <= 0 || j3 <= ((long) B.f250427c)) ? b16 & (-2) : b16 | 1;
        } else if (2 == i3) {
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
            b16 = aVar.f248515h - aVar.f248514g > ((long) B.f250428d) ? b16 | 2 : b16 & (-3);
        } else if (4 == i3) {
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
            short s16 = aVar2.f248520m;
            r.a aVar3 = B;
            b16 = (s16 < aVar3.f250429e || aVar2.f248521n < aVar3.f250430f) ? b16 & (-5) : b16 | 4;
        } else if (8 == i3) {
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar4 = this.f248481b;
            long j16 = aVar4.f248523p;
            if (j16 <= 0) {
                b16 &= -9;
            } else if (j16 >= aVar4.f248525r) {
                b16 |= 8;
            }
        } else if (16 == i3) {
            b16 = this.f248481b.f248527t > ((long) B.f250433i) ? b16 | 16 : b16 & (-17);
        }
        if (b16 != this.f248481b.b()) {
            a(this.f248481b.b(), b16, i3);
        }
        this.f248481b.a(b16);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void b(Socket socket, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) socket, i3);
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        aVar.f248508a = true;
        aVar.f248509b = false;
        aVar.f248526s = NetConnInfoCenter.getLastWifiSSID();
        this.f248481b.f248511d = System.currentTimeMillis();
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
        aVar2.f248512e = Math.min(aVar2.f248511d - aVar2.f248510c, i3);
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
        aVar3.f248510c = 0L;
        aVar3.f248531x = 0L;
        aVar3.f248519l = 0L;
        j();
        a(1);
        h();
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, "Wi-Fi");
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_COST, String.valueOf(this.f248481b.f248512e));
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onWifiConnected socket=" + socket + " connCost=" + this.f248481b.f248512e + " oldReason=" + String.valueOf(Integer.toHexString(this.f248481b.b())));
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.f250138r != null) {
            i();
        }
        this.f248481b = null;
        this.f250145y.f248572c = null;
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (i3 == 0 && i16 > 0) {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + " WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", Normal to Weaknet, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            a(true, i16);
            a.InterfaceC8083a interfaceC8083a = this.f248480a;
            if (interfaceC8083a != null) {
                interfaceC8083a.onNormalToWeakNet(i16);
            }
            this.f250145y.b();
            this.f250139s = true;
            i();
            this.f248481b.f248528u = SystemClock.elapsedRealtime();
            this.f248481b.f248530w = com.tencent.mobileqq.msf.core.i0.b.a();
        } else if (i3 > 0 && i16 == 0) {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + " WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", Weaknet to Normal, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            a(false, i3);
            a.InterfaceC8083a interfaceC8083a2 = this.f248480a;
            if (interfaceC8083a2 != null) {
                interfaceC8083a2.onWeakNetToNormal(i3);
            }
            this.f250139s = false;
            this.f248481b.f248529v = SystemClock.elapsedRealtime();
            this.f250145y.a(a(), this.f248481b);
            h();
        } else if (i3 > 0 && i16 > 0 && i3 != i16) {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + " WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", Weaknet to Weaknet, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            i();
        } else {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + "WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", unknow to unknow, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            i();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_REASON, Integer.toHexString(i16));
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (this.f248481b.f248508a) {
            WeakReference<b> weakReference = this.f250141u;
            if (weakReference == null || weakReference.get() == null) {
                synchronized (b.class) {
                    WeakReference<b> weakReference2 = this.f250141u;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        this.f250141u = new WeakReference<>(new b());
                    }
                }
            }
            b bVar = this.f250141u.get();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
            long requestSsoSeq = toServiceMsg.getRequestSsoSeq();
            aVar.f248513f = requestSsoSeq;
            bVar.f250149b = requestSsoSeq;
            b bVar2 = this.f250141u.get();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
            long currentTimeMillis = System.currentTimeMillis();
            aVar2.f248514g = currentTimeMillis;
            bVar2.f250148a = currentTimeMillis;
            QLog.d("WeakNetDetector", 1, "onPingSent ssoSeq=" + this.f248481b.f248513f + " pingSend=" + this.f248481b.f248514g);
            WeakReference<b> weakReference3 = this.f250141u;
            if (weakReference3 == null || weakReference3.get() == null) {
                return;
            }
            this.f250138r.removeCallbacks(this.f250141u.get());
            this.f250138r.postDelayed(this.f250141u.get(), 3001L);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(int i3, long j3, com.tencent.mobileqq.msf.core.net.q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Long.valueOf(j3), qVar);
            return;
        }
        this.f248481b.f248511d = System.currentTimeMillis();
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        aVar.f248512e = aVar.f248511d - aVar.f248510c;
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onConnFailed type=" + NetConnInfoCenter.getSystemNetStateString() + " connTotalCost=" + this.f248481b.f248512e + " connErrCost=" + j3 + " connError=" + qVar + " oldReason=" + String.valueOf(Integer.toHexString(this.f248481b.b())));
        }
        a(1);
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, "Open-Failed");
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(Socket socket, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) socket, i3);
            return;
        }
        this.f248481b.a();
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        aVar.f248509b = true;
        aVar.f248508a = false;
        this.f250139s = false;
        l();
        k();
        j();
        a(64);
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, com.tencent.mobileqq.msf.core.x.q.f250392x);
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_COST, String.valueOf(i3));
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onMobileConnected socket=" + socket + " connCost=" + i3);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onConnClose reason=");
            sb5.append(aVar);
            sb5.append(" conn=");
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
            sb5.append(aVar2.f248508a ? "wifi" : aVar2.f248509b ? DeviceType.DeviceCategory.MOBILE : "unknown");
            QLog.d("WeakNetDetector", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248508a) {
            if (aVar.f248513f == j3) {
                aVar.f248515h = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[");
                sb5.append(Thread.currentThread().getName());
                sb5.append("] onPingRecved ssoSeq=");
                sb5.append(j3);
                sb5.append(" pingSend=");
                sb5.append(this.f248481b.f248514g);
                sb5.append(" pingRecv=");
                sb5.append(this.f248481b.f248515h);
                sb5.append(" cost=");
                com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
                sb5.append(aVar2.f248515h - aVar2.f248514g);
                QLog.d("WeakNetDetector", 1, sb5.toString());
                WeakReference<b> weakReference = this.f250141u;
                if (weakReference != null && weakReference.get() != null) {
                    this.f250138r.removeCallbacks(this.f250141u.get());
                }
                a(2);
                HashMap hashMap = new HashMap();
                com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
                hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_PING_COST, String.valueOf(aVar3.f248515h - aVar3.f248514g));
                com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
                return;
            }
            QLog.w("WeakNetDetector", 1, "WARN: [" + Thread.currentThread().getName() + "] onPingRecved sendSsoSeq=" + this.f248481b.f248513f + " recvSsoSeq=" + j3 + " out of order");
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (toServiceMsg == null || fromServiceMsg == null || TextUtils.isEmpty(fromServiceMsg.getUin()) || "0".equals(fromServiceMsg.getUin()) || !BaseConstants.CMD_MSG_PBSENDMSG.equals(fromServiceMsg.getServiceCmd())) {
            return;
        }
        if (this.f250139s && fromServiceMsg.isSuccess()) {
            if (a()) {
                HashMap<String, Object> attributes = toServiceMsg.getAttributes();
                Boolean bool = Boolean.TRUE;
                attributes.put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
                fromServiceMsg.getAttributes().put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
            }
            long longValue = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET, 0L)).longValue();
            if (longValue > 0) {
                long currentTimeMillis = System.currentTimeMillis() - longValue;
                if (currentTimeMillis > 0) {
                    b.a aVar = this.f250145y.f248574e;
                    long j3 = aVar.f248576b;
                    int i16 = aVar.f248575a;
                    int i17 = i16 + 1;
                    long j16 = i17;
                    aVar.f248576b = ((j3 / j16) * i16) + (currentTimeMillis / j16);
                    aVar.f248575a = i17;
                }
            }
        }
        if (toServiceMsg.getAttributes().containsKey(MsfConstants.ATTR_WEAKNET_SENT_FLAG) || fromServiceMsg.getAttributes().containsKey(MsfConstants.ATTR_WEAKNET_SENT_FLAG)) {
            long longValue2 = ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET, 0L)).longValue();
            if (longValue2 > 0) {
                this.f250145y.a(fromServiceMsg, this.f248481b, z16, System.currentTimeMillis() - longValue2);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        Object attribute;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (this.f248481b.f248508a) {
            if (this.f250139s && toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess() && (attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET)) != null) {
                long currentTimeMillis = System.currentTimeMillis() - ((Long) attribute).longValue();
                if (currentTimeMillis > 0) {
                    b.a aVar = this.f250145y.f248572c;
                    long j3 = aVar.f248576b;
                    int i3 = aVar.f248575a;
                    int i16 = i3 + 1;
                    long j16 = i16;
                    aVar.f248576b = ((j3 / j16) * i3) + (currentTimeMillis / j16);
                    aVar.f248575a = i16;
                }
            }
            if (toServiceMsg == null || fromServiceMsg == null || !fromServiceMsg.isSuccess()) {
                return;
            }
            if (a()) {
                HashMap<String, Object> attributes = toServiceMsg.getAttributes();
                Boolean bool = Boolean.TRUE;
                attributes.put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
                fromServiceMsg.getAttributes().put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
            }
            if (this.f248481b.f248531x <= 0 || fromServiceMsg.getRequestSsoSeq() != this.f248481b.f248531x) {
                long j17 = this.f248481b.f248519l;
                if (j17 != 0) {
                    if (j17 <= 0 || !fromServiceMsg.isSuccess()) {
                        return;
                    }
                    Object attribute2 = fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF);
                    Object attribute3 = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET);
                    if (attribute2 == null || attribute3 == null) {
                        return;
                    }
                    long longValue = ((Long) attribute2).longValue() - ((Long) attribute3).longValue();
                    com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
                    long j18 = (long) ((aVar2.f248523p * 0.6d) + (longValue * 0.4d));
                    if (longValue <= 0 || j18 <= 0) {
                        return;
                    }
                    aVar2.f248523p = j18;
                    int b16 = aVar2.b();
                    a(8);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_RTT, String.valueOf(this.f248481b.f248523p));
                    a(hashMap);
                    com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
                    if (b16 != this.f248481b.b()) {
                        if (!a()) {
                            QLog.d("WeakNetDetector", 1, Thread.currentThread().getName() + " Restore Normal ssoSeq=" + fromServiceMsg.getRequestSsoSeq() + " serviceCmd=" + fromServiceMsg.getServiceCmd() + " RTTm=" + this.f248481b.f248523p);
                            return;
                        }
                        if (b(8)) {
                            QLog.d("WeakNetDetector", 1, Thread.currentThread().getName() + " Enter weaknet ssoSeq=" + fromServiceMsg.getRequestSsoSeq() + " serviceCmd=" + fromServiceMsg.getServiceCmd() + " RTTm=" + this.f248481b.f248523p);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            this.f248481b.f248519l = System.currentTimeMillis() - ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET, Long.valueOf(this.f248481b.f248511d))).longValue();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
            long j19 = aVar3.f248519l;
            if (j19 > 0) {
                long j26 = (long) ((aVar3.f248512e * 0.3d) + (j19 * 0.7d));
                aVar3.f248522o = j26;
                aVar3.f248523p = j19;
                aVar3.f248524q = Math.max(j26 * 2, B.f250435k);
                com.tencent.mobileqq.msf.core.i0.c.c.a aVar4 = this.f248481b;
                aVar4.f248525r = Math.max(aVar4.f248522o * 3, B.f250434j);
                com.tencent.mobileqq.msf.core.i0.c.c.a aVar5 = this.f248481b;
                long j27 = aVar5.f248524q;
                long j28 = B.f250434j;
                if (j27 > j28 || aVar5.f248525r < r4.f250435k) {
                    aVar5.f248524q = r4.f250435k;
                    aVar5.f248525r = j28;
                }
            }
            if (fromServiceMsg.getRequestSsoSeq() != this.f248481b.f248531x) {
                QLog.w("WeakNetDetector", 1, "WARN: firstSendSsoseq=" + this.f248481b.f248531x + " firstRecvSsoSeq=" + toServiceMsg.getRequestSsoSeq() + " out of order");
                this.f248481b.f248531x = (long) toServiceMsg.getRequestSsoSeq();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(BaseConstants.KEY_WEAK_NET_DEBUG_TRTT, String.valueOf(this.f248481b.f248522o));
            hashMap2.put(BaseConstants.KEY_WEAK_NET_DEBUG_UP_BOUND, String.valueOf(this.f248481b.f248524q));
            hashMap2.put(BaseConstants.KEY_WEAK_NET_DEBUG_DOWN_BOUND, String.valueOf(this.f248481b.f248525r));
            com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap2);
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("onRecvFirst ssoSeq=");
            sb5.append(this.f248481b.f248531x);
            sb5.append(" TC=");
            sb5.append(this.f248481b.f248512e);
            sb5.append(" pingCost=");
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar6 = this.f248481b;
            sb5.append(aVar6.f248515h - aVar6.f248514g);
            sb5.append(" TP=");
            sb5.append(this.f248481b.f248519l);
            sb5.append(" Trtt=");
            sb5.append(this.f248481b.f248522o);
            sb5.append(" Rttm=");
            sb5.append(this.f248481b.f248523p);
            sb5.append(" windows=(");
            sb5.append(this.f248481b.f248524q);
            sb5.append(",");
            sb5.append(this.f248481b.f248525r);
            sb5.append(")");
            QLog.d("WeakNetDetector", 1, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f248481b.f248532y = 1;
        } else {
            this.f248481b.f248532y = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onScreenOn mIsScreenOn=" + z16);
        }
    }
}
