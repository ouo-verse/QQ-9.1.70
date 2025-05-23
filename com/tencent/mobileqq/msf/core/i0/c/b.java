package com.tencent.mobileqq.msf.core.i0.c;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.i0.c.a;
import com.tencent.mobileqq.msf.core.i0.d.b;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends com.tencent.mobileqq.msf.core.i0.c.a {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "WeakNetDetector";
    public static final int B = 10;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f248482r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f248483s;

    /* renamed from: t, reason: collision with root package name */
    private WeakReference<c> f248484t;

    /* renamed from: u, reason: collision with root package name */
    private WeakReference<RunnableC8084b> f248485u;

    /* renamed from: v, reason: collision with root package name */
    private WeakReference<d> f248486v;

    /* renamed from: w, reason: collision with root package name */
    private WeakReference<f> f248487w;

    /* renamed from: x, reason: collision with root package name */
    private WeakReference<e> f248488x;

    /* renamed from: y, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.i0.d.b f248489y;

    /* renamed from: z, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.f0.d.a f248490z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.i0.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC8084b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f248491a;

        /* renamed from: b, reason: collision with root package name */
        long f248492b;

        public RunnableC8084b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            } else {
                this.f248491a = 0L;
                this.f248492b = 0L;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = b.this;
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = bVar.f248481b;
            if (aVar.f248508a || aVar.f248509b) {
                long j3 = this.f248492b;
                if (j3 > 0 && this.f248491a > 0) {
                    bVar.a(j3, System.currentTimeMillis() - this.f248491a, true);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f248494a;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            } else {
                this.f248494a = new AtomicBoolean(false);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = b.this.f248481b;
            if (aVar.f248510c > 0) {
                aVar.f248512e = System.currentTimeMillis() - b.this.f248481b.f248510c;
                if (QLog.isColorLevel()) {
                    QLog.d("WeakNetDetector", 2, "CheckConnTimer conn cost=" + b.this.f248481b.f248512e + " oldReason=" + Integer.toHexString(b.this.f248481b.b()));
                }
                b.this.a(1);
                b.this.i();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f248496a;

        /* renamed from: b, reason: collision with root package name */
        long f248497b;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            } else {
                this.f248496a = 0L;
                this.f248497b = 0L;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b bVar = b.this;
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = bVar.f248481b;
            if (aVar.f248508a || aVar.f248509b) {
                long j3 = this.f248497b;
                if (j3 > 0 && this.f248496a > 0) {
                    bVar.a(j3);
                }
            }
        }
    }

    public b(com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f248482r = q.q();
        this.f248483s = true;
        this.f248484t = null;
        this.f248485u = null;
        this.f248486v = null;
        this.f248487w = null;
        this.f248488x = null;
        this.f248490z = aVar;
        this.f248489y = new com.tencent.mobileqq.msf.core.i0.d.b();
        this.f248481b.c();
    }

    private void f() {
        if (b(16)) {
            return;
        }
        WeakReference<e> weakReference = this.f248488x;
        if (weakReference == null || weakReference.get() == null) {
            synchronized (e.class) {
                WeakReference<e> weakReference2 = this.f248488x;
                if (weakReference2 == null || weakReference2.get() == null) {
                    this.f248488x = new WeakReference<>(new e(this, null));
                }
            }
        }
        WeakReference<e> weakReference3 = this.f248488x;
        if (weakReference3 == null || weakReference3.get() == null || !this.f248488x.get().f248500a.compareAndSet(false, true)) {
            return;
        }
        j();
        this.f248488x.get().f248501b = false;
        this.f248482r.postDelayed(this.f248488x.get(), com.tencent.mobileqq.msf.core.i0.a.v().q());
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " startQuickSendCheck");
        }
    }

    private void g() {
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248508a || aVar.f248509b) {
            WeakReference<f> weakReference = this.f248487w;
            if (weakReference == null || weakReference.get() == null) {
                synchronized (f.class) {
                    WeakReference<f> weakReference2 = this.f248487w;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        this.f248487w = new WeakReference<>(new f(this, null));
                    }
                }
            }
            if (this.f248487w.get() != null) {
                k();
                this.f248487w.get().f248506c = false;
                this.f248482r.postDelayed(this.f248487w.get(), com.tencent.mobileqq.msf.core.i0.a.v().n());
            }
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " startWeakNetworkSsoCheck");
            }
        }
    }

    private void h() {
        i();
        j();
        k();
        WeakReference<RunnableC8084b> weakReference = this.f248485u;
        if (weakReference != null && weakReference.get() != null) {
            this.f248482r.removeCallbacks(this.f248485u.get());
        }
        WeakReference<d> weakReference2 = this.f248486v;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.f248482r.removeCallbacks(this.f248486v.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        WeakReference<c> weakReference = this.f248484t;
        if (weakReference != null && weakReference.get() != null) {
            this.f248482r.removeCallbacks(this.f248484t.get());
            this.f248484t.get().f248494a.set(false);
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " stopConnCheck");
            }
        }
    }

    private void j() {
        WeakReference<e> weakReference = this.f248488x;
        if (weakReference != null && weakReference.get() != null) {
            this.f248482r.removeCallbacks(this.f248488x.get());
            this.f248488x.get().f248501b = true;
            this.f248488x.get().f248500a.set(false);
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " stopQuickSendCheck");
            }
        }
    }

    private void k() {
        WeakReference<f> weakReference = this.f248487w;
        if (weakReference != null && weakReference.get() != null) {
            this.f248487w.get().f248506c = true;
            this.f248482r.removeCallbacks(this.f248487w.get());
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " stopWeakNetworkSsoCheck");
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, this, toServiceMsg, fromServiceMsg, dVar);
    }

    private boolean a(int i3, int i16) {
        return (i3 & i16) == i16;
    }

    public boolean b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? a(this.f248481b.b(), i3) : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (com.tencent.mobileqq.msf.core.i0.a.v().h()) {
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
            if ((aVar.f248508a || aVar.f248509b) && toServiceMsg != null) {
                if (toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249866x) == null) {
                    toServiceMsg.getAttributes().put(com.tencent.mobileqq.msf.core.quicksend.b.f249866x, Long.valueOf(SystemClock.elapsedRealtime()));
                }
                f();
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void d(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!this.f248483s || toServiceMsg == null || ((Boolean) toServiceMsg.getAttribute(MsfConstants.ATTR_CHAT_MSG_SENT_FLAG, Boolean.FALSE)).booleanValue()) {
            return;
        }
        toServiceMsg.getAttributes().put(MsfConstants.ATTR_CHAT_MSG_SENT_FLAG, Boolean.TRUE);
        this.f248489y.f248573d.f248575a++;
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void e(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) toServiceMsg);
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
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if ((aVar.f248508a || aVar.f248509b) && toServiceMsg != null && this.f248483s && toServiceMsg.isNeedCallback()) {
            this.f248489y.f248571b.f248575a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: d, reason: collision with root package name */
        static final short f248499d = 100;

        /* renamed from: a, reason: collision with root package name */
        public volatile AtomicBoolean f248500a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f248501b;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            } else {
                this.f248500a = new AtomicBoolean(false);
                this.f248501b = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int size;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (!this.f248501b && b.this.f248490z.q().c() != null && (size = b.this.f248490z.q().c().size()) > 0 && size < 100) {
                Collection<ToServiceMsg> values = b.this.f248490z.q().c().values();
                long j3 = 0;
                boolean z16 = false;
                if (values.size() > 0) {
                    Iterator<ToServiceMsg> it = values.iterator();
                    long j16 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            ToServiceMsg next = it.next();
                            if (next != null) {
                                j16 = SystemClock.elapsedRealtime() - ((Long) next.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249866x, 0L)).longValue();
                                if (j16 > com.tencent.mobileqq.msf.core.i0.a.v().q()) {
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
                    b bVar = b.this;
                    bVar.f248481b.f248527t = j3;
                    bVar.a(16);
                    if (QLog.isColorLevel()) {
                        QLog.d("WeakNetDetector", 2, "weaknet quickSendCheck reason=" + Integer.toHexString(b.this.f248481b.b()) + " ssoSeq=" + i3 + " timeout=" + z16);
                    }
                }
                if (!b.this.b(16) && b.this.f248490z.q().c().size() > 0 && b.this.f248488x != null && b.this.f248488x.get() != null) {
                    b.this.f248482r.postDelayed((Runnable) b.this.f248488x.get(), com.tencent.mobileqq.msf.core.i0.a.v().q());
                }
            }
        }

        /* synthetic */ e(b bVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248510c == 0) {
            aVar.f248510c = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, "onConnPrepare type=" + NetConnInfoCenter.getSystemNetStateString() + " connStart=" + this.f248481b.f248510c);
            }
            e();
            HashMap hashMap = new HashMap();
            hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, "Prepare");
            com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class f implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: e, reason: collision with root package name */
        static final short f248503e = 10;

        /* renamed from: a, reason: collision with root package name */
        final HashMap<String, Integer> f248504a;

        /* renamed from: b, reason: collision with root package name */
        StringBuilder f248505b;

        /* renamed from: c, reason: collision with root package name */
        boolean f248506c;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                return;
            }
            this.f248504a = new HashMap<>(10);
            this.f248505b = null;
            this.f248506c = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:86:0x0277, code lost:
        
            if (r10.f248507d.f248487w.get() != null) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x029c, code lost:
        
            r10.f248507d.f248482r.postDelayed((java.lang.Runnable) r10.f248507d.f248487w.get(), com.tencent.mobileqq.msf.core.i0.a.v().n());
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x029a, code lost:
        
            if (r10.f248507d.f248487w.get() != null) goto L78;
         */
        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f248506c) {
                return;
            }
            try {
                t j3 = b.this.f248490z.r().j();
                if (j3.f250077b.size() >= com.tencent.mobileqq.msf.core.i0.a.v().d()) {
                    this.f248504a.clear();
                    short s16 = 0;
                    for (ToServiceMsg toServiceMsg : j3.f250077b.values()) {
                        Object f16 = b.this.f(toServiceMsg);
                        if (toServiceMsg.isNeedCallback() && (f16 instanceof Long)) {
                            long longValue = ((Long) f16).longValue();
                            if (longValue > 0 && !b.this.b(longValue) && System.currentTimeMillis() - longValue > com.tencent.mobileqq.msf.core.i0.a.v().n()) {
                                if (this.f248504a.size() >= 10) {
                                    break;
                                }
                                this.f248504a.put(toServiceMsg.getServiceCmd(), Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
                                s16 = (short) (s16 + 1);
                            }
                        }
                    }
                    com.tencent.mobileqq.msf.core.i0.c.c.a aVar = b.this.f248481b;
                    aVar.f248520m = s16;
                    aVar.f248521n = (short) this.f248504a.size();
                    int a16 = com.tencent.mobileqq.msf.core.i0.a.v().a();
                    if (a16 != 0) {
                        if (a16 != 1) {
                            if (a16 == 2) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("WeakNetDetector", 2, "[" + Thread.currentThread().getName() + "] onHitBNBC and checkWeakNetwork");
                                }
                                b.this.a(4);
                            }
                        } else if (b.this.f248481b.f248520m >= com.tencent.mobileqq.msf.core.i0.a.v().d() && b.this.f248481b.f248521n >= com.tencent.mobileqq.msf.core.i0.a.v().c()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("WeakNetDetector", 2, "[" + Thread.currentThread().getName() + "] onHitBNBC and sendFastNetDetect");
                            }
                            b.this.f248490z.r().s();
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("WeakNetDetector", 2, "[" + Thread.currentThread().getName() + "] onHitBNBC but close by strategy");
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder(512);
                        this.f248505b = sb5;
                        sb5.append("weakNet ssoCheck current:");
                        sb5.append(Integer.toHexString(b.this.f248481b.b()));
                        sb5.append(" sendQueue:");
                        sb5.append(j3.f250077b.size());
                        sb5.append(" detectQueue:");
                        sb5.append(j3.f250079d.size());
                        sb5.append(" waitQueue:");
                        sb5.append(j3.f250080e.size());
                        sb5.append(" delayWaitQueue:");
                        sb5.append(j3.f250081f.size());
                        sb5.append(" BN:");
                        sb5.append((int) b.this.f248481b.f248520m);
                        sb5.append(" BC:");
                        sb5.append((int) b.this.f248481b.f248521n);
                        sb5.append(" bnbc: \n");
                        for (String str : this.f248504a.keySet()) {
                            Integer num = this.f248504a.get(str);
                            StringBuilder sb6 = this.f248505b;
                            sb6.append(" ssoSeq:");
                            sb6.append(num);
                            sb6.append(" serviceCmd:");
                            sb6.append(str);
                            sb6.append("\n");
                        }
                        QLog.d("WeakNetDetector", 2, this.f248505b.toString());
                        this.f248505b = null;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_BN, String.valueOf((int) b.this.f248481b.f248520m));
                    hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_BC, String.valueOf((int) b.this.f248481b.f248521n));
                    com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
                }
                if (b.this.f248487w != null) {
                }
            } catch (Throwable th5) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.e("WeakNetDetector", 1, th5.getMessage(), th5);
                    }
                    if (b.this.f248487w != null) {
                    }
                } catch (Throwable th6) {
                    if (b.this.f248487w != null && b.this.f248487w.get() != null) {
                        b.this.f248482r.postDelayed((Runnable) b.this.f248487w.get(), com.tencent.mobileqq.msf.core.i0.a.v().n());
                    }
                    this.f248504a.clear();
                    throw th6;
                }
            }
            this.f248504a.clear();
        }

        /* synthetic */ f(b bVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public synchronized void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        int b16 = this.f248481b.b();
        if (1 == i3) {
            long j3 = this.f248481b.f248512e;
            b16 = (j3 <= 0 || j3 <= ((long) com.tencent.mobileqq.msf.core.i0.a.v().b())) ? b16 & (-2) : b16 | 1;
        } else if (2 == i3) {
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
            b16 = aVar.f248515h - aVar.f248514g > ((long) com.tencent.mobileqq.msf.core.i0.a.v().g()) ? b16 | 2 : b16 & (-3);
        } else if (4 == i3) {
            b16 = (this.f248481b.f248520m < com.tencent.mobileqq.msf.core.i0.a.v().d() || this.f248481b.f248521n < com.tencent.mobileqq.msf.core.i0.a.v().c()) ? b16 & (-5) : b16 | 4;
        } else if (8 == i3) {
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
            long j16 = aVar2.f248523p;
            if (j16 <= 0) {
                b16 &= -9;
            } else if (j16 >= aVar2.f248525r) {
                b16 |= 8;
            } else if (j16 <= aVar2.f248524q) {
                b16 = 0;
            }
        } else if (16 == i3) {
            b16 = this.f248481b.f248527t > ((long) com.tencent.mobileqq.msf.core.i0.a.v().q()) ? b16 | 16 : b16 & (-17);
        } else if (32 == i3) {
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
            long j17 = aVar3.f248518k - aVar3.f248517j;
            if (j17 > 0) {
                if (j17 > com.tencent.mobileqq.msf.core.i0.a.v().e()) {
                    b16 |= 32;
                } else if (j17 < com.tencent.mobileqq.msf.core.i0.a.v().f()) {
                    b16 &= -33;
                }
            }
        }
        if (b16 != this.f248481b.b()) {
            a(this.f248481b.b(), b16, i3);
        }
        this.f248481b.a(b16);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        this.f248481b.f248532y = 0;
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onScreenOff");
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        if (this.f248482r != null) {
            h();
        }
        this.f248481b = null;
        this.f248489y.f248572c = null;
    }

    private void e() {
        if (b(1)) {
            return;
        }
        WeakReference<c> weakReference = this.f248484t;
        if (weakReference == null || weakReference.get() == null) {
            synchronized (c.class) {
                WeakReference<c> weakReference2 = this.f248484t;
                if (weakReference2 == null || weakReference2.get() == null) {
                    this.f248484t = new WeakReference<>(new c());
                }
            }
        }
        if (this.f248484t.get().f248494a.compareAndSet(false, true)) {
            this.f248482r.removeCallbacks(this.f248484t.get());
            this.f248482r.postDelayed(this.f248484t.get(), com.tencent.mobileqq.msf.core.i0.a.v().b());
            if (QLog.isColorLevel()) {
                QLog.d("WeakNetDetector", 2, Thread.currentThread().getName() + " startConnCheck oldReason=" + Integer.toHexString(this.f248481b.b()));
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void b(Socket socket, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) socket, i3);
            return;
        }
        this.f248481b.a();
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        aVar.f248508a = true;
        aVar.f248509b = false;
        aVar.f248526s = NetConnInfoCenter.getLastWifiSSID();
        this.f248481b.f248511d = System.currentTimeMillis();
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
        aVar2.f248512e = Math.min(aVar2.f248511d - aVar2.f248510c, i3);
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
        aVar3.f248510c = 0L;
        aVar3.f248519l = 0L;
        i();
        a(1);
        g();
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, "Wi-Fi");
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_COST, String.valueOf(this.f248481b.f248512e));
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onWifiConnected socket= " + socket + " connCost=" + this.f248481b.f248512e + " oldReason=" + Integer.toHexString(this.f248481b.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object f(ToServiceMsg toServiceMsg) {
        Object attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET);
        if (attribute == null && (attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)) == null && (attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)) == null && (attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_APP2MSF)) == null) {
            return null;
        }
        return attribute;
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (i3 == 0 && i16 > 0) {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + " WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", Normal to Weaknet, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            a(true, i16);
            a.InterfaceC8083a interfaceC8083a = this.f248480a;
            if (interfaceC8083a != null) {
                interfaceC8083a.onNormalToWeakNet(i16);
            }
            this.f248489y.b();
            this.f248483s = true;
            h();
            this.f248481b.f248528u = SystemClock.elapsedRealtime();
            this.f248481b.f248530w = com.tencent.mobileqq.msf.core.i0.b.a();
        } else if (i3 > 0 && i16 == 0) {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + " WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", Weaknet to Normal, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            a(false, i3);
            a.InterfaceC8083a interfaceC8083a2 = this.f248480a;
            if (interfaceC8083a2 != null) {
                interfaceC8083a2.onWeakNetToNormal(i3);
            }
            this.f248483s = false;
            this.f248481b.f248529v = SystemClock.elapsedRealtime();
            this.f248489y.a(a(), this.f248481b);
            g();
        } else if (i3 > 0 && i16 > 0 && i3 != i16) {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + " WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", Weaknet to Weaknet, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            h();
        } else {
            QLog.i("WeakNetDetector", 1, Thread.currentThread().getName() + "WeaknetChanged " + com.tencent.mobileqq.msf.core.i0.b.a(i17) + ", unknow to unknow, reason:(" + Integer.toHexString(i3) + ", " + Integer.toHexString(i16) + ")");
            h();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_REASON, Integer.toHexString(i16));
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg);
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248508a || aVar.f248509b) {
            WeakReference<RunnableC8084b> weakReference = this.f248485u;
            if (weakReference == null || weakReference.get() == null) {
                synchronized (RunnableC8084b.class) {
                    WeakReference<RunnableC8084b> weakReference2 = this.f248485u;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        this.f248485u = new WeakReference<>(new RunnableC8084b());
                    }
                }
            }
            RunnableC8084b runnableC8084b = this.f248485u.get();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
            long requestSsoSeq = toServiceMsg.getRequestSsoSeq();
            aVar2.f248513f = requestSsoSeq;
            runnableC8084b.f248492b = requestSsoSeq;
            RunnableC8084b runnableC8084b2 = this.f248485u.get();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
            long currentTimeMillis = System.currentTimeMillis();
            aVar3.f248514g = currentTimeMillis;
            runnableC8084b2.f248491a = currentTimeMillis;
            QLog.d("WeakNetDetector", 1, "onPingSent ssoSeq=" + this.f248481b.f248513f + " pingSend=" + this.f248481b.f248514g);
            WeakReference<RunnableC8084b> weakReference3 = this.f248485u;
            if (weakReference3 == null || weakReference3.get() == null) {
                return;
            }
            this.f248482r.removeCallbacks(this.f248485u.get());
            this.f248482r.postDelayed(this.f248485u.get(), com.tencent.mobileqq.msf.core.i0.a.v().g() + 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(long j3) {
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        long j16 = aVar.f248517j;
        if (j16 > 0) {
            long j17 = aVar.f248518k;
            if (j17 > 0) {
                long j18 = j17 - j16;
                if (j18 > 0 && j18 < com.tencent.mobileqq.msf.core.i0.a.v().f()) {
                    com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
                    if (j3 < aVar2.f248517j && j3 < aVar2.f248518k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f248481b.b() > 0 : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(Socket socket, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) socket, i3);
            return;
        }
        this.f248481b.a();
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        aVar.f248509b = true;
        aVar.f248508a = false;
        aVar.f248511d = System.currentTimeMillis();
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
        aVar2.f248512e = Math.min(aVar2.f248511d - aVar2.f248510c, i3);
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
        aVar3.f248510c = 0L;
        aVar3.f248519l = 0L;
        i();
        a(1);
        g();
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, com.tencent.mobileqq.msf.core.x.q.f250392x);
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_COST, String.valueOf(this.f248481b.f248512e));
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onMobileConnected socket= " + socket + " connCost=" + this.f248481b.f248512e + " oldReason=" + Integer.toHexString(this.f248481b.b()));
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
            QLog.d("WeakNetDetector", 2, "onConnFailed type= " + NetConnInfoCenter.getSystemNetStateString() + ", connTotalCost= " + this.f248481b.f248512e + ", connErrCost= " + j3 + ", connError= " + qVar + ", oldReason= " + Integer.toHexString(this.f248481b.b()));
        }
        a(1);
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, "Open-Failed");
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
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
        HashMap hashMap = new HashMap();
        hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_CONN_STATE, "close");
        com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(long j3, long j16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248508a || aVar.f248509b) {
            if (aVar.f248513f == j3) {
                aVar.f248515h = System.currentTimeMillis();
                com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
                long j17 = aVar2.f248515h - aVar2.f248514g;
                a(j17, z16);
                WeakReference<RunnableC8084b> weakReference = this.f248485u;
                if (weakReference != null && weakReference.get() != null) {
                    this.f248482r.removeCallbacks(this.f248485u.get());
                }
                a(2);
                HashMap hashMap = new HashMap();
                hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_PING_COST, String.valueOf(j17));
                com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
                return;
            }
            a(j16, z16);
            QLog.w("WeakNetDetector", 1, "WARN: [" + Thread.currentThread().getName() + "] onPingRecved sendSsoSeq=" + this.f248481b.f248513f + " recvSsoSeq=" + j3 + " out of order");
        }
    }

    private void a(long j3, boolean z16) {
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248519l == 0) {
            if (!z16 && j3 > 0) {
                aVar.f248519l = j3;
            } else {
                aVar.f248519l = com.tencent.mobileqq.msf.core.i0.a.v().j();
            }
            float l3 = com.tencent.mobileqq.msf.core.i0.a.v().l();
            float i3 = com.tencent.mobileqq.msf.core.i0.a.v().i();
            int k3 = com.tencent.mobileqq.msf.core.i0.a.v().k();
            int j16 = com.tencent.mobileqq.msf.core.i0.a.v().j();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
            long j17 = aVar2.f248519l;
            long j18 = (long) ((aVar2.f248512e * 0.3d) + (j17 * 0.7d));
            aVar2.f248522o = j18;
            aVar2.f248523p = j17;
            long j19 = j16;
            aVar2.f248524q = Math.min(Math.max(i3 * j18, j16 / 2), j19);
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
            long j26 = k3;
            aVar3.f248525r = Math.min(Math.max(l3 * aVar3.f248522o, k3 / 2), j26);
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar4 = this.f248481b;
            if (aVar4.f248524q > j26 || aVar4.f248525r < j19) {
                aVar4.f248524q = j19;
                aVar4.f248525r = j26;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_TRTT, String.valueOf(this.f248481b.f248522o));
            hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_UP_BOUND, String.valueOf(this.f248481b.f248525r));
            hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_DOWN_BOUND, String.valueOf(this.f248481b.f248524q));
            com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleRttmWindow, pingSsoSeq=");
            sb5.append(this.f248481b.f248513f);
            sb5.append(" pingSend=");
            sb5.append(this.f248481b.f248514g);
            sb5.append(" pingRecv=");
            sb5.append(this.f248481b.f248515h);
            sb5.append(" pingCost=");
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar5 = this.f248481b;
            sb5.append(aVar5.f248515h - aVar5.f248514g);
            sb5.append(" TC=");
            sb5.append(this.f248481b.f248512e);
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
    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) toServiceMsg);
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248508a || aVar.f248509b) {
            WeakReference<d> weakReference = this.f248486v;
            if (weakReference == null || weakReference.get() == null) {
                synchronized (d.class) {
                    WeakReference<d> weakReference2 = this.f248486v;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        this.f248486v = new WeakReference<>(new d());
                    }
                }
            }
            d dVar = this.f248486v.get();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
            long requestSsoSeq = toServiceMsg.getRequestSsoSeq();
            aVar2.f248516i = requestSsoSeq;
            dVar.f248497b = requestSsoSeq;
            d dVar2 = this.f248486v.get();
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
            long currentTimeMillis = System.currentTimeMillis();
            aVar3.f248517j = currentTimeMillis;
            dVar2.f248496a = currentTimeMillis;
            QLog.d("WeakNetDetector", 1, "onHeartBeatSend ssoSeq=" + this.f248481b.f248516i + " heartBeatSend=" + this.f248481b.f248517j);
            WeakReference<d> weakReference3 = this.f248486v;
            if (weakReference3 == null || weakReference3.get() == null) {
                return;
            }
            this.f248482r.removeCallbacks(this.f248486v.get());
            this.f248482r.postDelayed(this.f248486v.get(), com.tencent.mobileqq.msf.core.i0.a.v().e() + 10);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
            return;
        }
        com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
        if (aVar.f248508a || aVar.f248509b) {
            if (aVar.f248516i == j3) {
                aVar.f248518k = System.currentTimeMillis();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[");
                sb5.append(Thread.currentThread().getName());
                sb5.append("] onHeartBeatReceived ssoSeq= ");
                sb5.append(j3);
                sb5.append(" heartBeatSend=");
                sb5.append(this.f248481b.f248517j);
                sb5.append(" heartBeatRecv=");
                sb5.append(this.f248481b.f248518k);
                sb5.append(" cost=");
                com.tencent.mobileqq.msf.core.i0.c.c.a aVar2 = this.f248481b;
                sb5.append(aVar2.f248518k - aVar2.f248517j);
                QLog.d("WeakNetDetector", 1, sb5.toString());
                WeakReference<d> weakReference = this.f248486v;
                if (weakReference != null && weakReference.get() != null) {
                    this.f248482r.removeCallbacks(this.f248486v.get());
                }
                a(32);
                HashMap hashMap = new HashMap();
                com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
                hashMap.put(BaseConstants.KEY_WEAK_NET_DEBUG_HB_COST, String.valueOf(aVar3.f248518k - aVar3.f248517j));
                com.tencent.mobileqq.msf.core.i0.c.a.a((Map<String, String>) hashMap);
                return;
            }
            QLog.w("WeakNetDetector", 1, "WARN: [" + Thread.currentThread().getName() + "] onHeartBeatReceived sendSsoSeq=" + this.f248481b.f248516i + " recvSsoSeq=" + j3 + " out of order");
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (toServiceMsg == null || fromServiceMsg == null || TextUtils.isEmpty(fromServiceMsg.getUin()) || "0".equals(fromServiceMsg.getUin()) || !BaseConstants.CMD_MSG_PBSENDMSG.equals(fromServiceMsg.getServiceCmd())) {
            return;
        }
        long longValue = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET) instanceof Long ? ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET)).longValue() : 0L;
        if (this.f248483s && fromServiceMsg.isSuccess()) {
            if (a()) {
                HashMap<String, Object> attributes = toServiceMsg.getAttributes();
                Boolean bool = Boolean.TRUE;
                attributes.put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
                fromServiceMsg.getAttributes().put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
            }
            if (longValue > 0) {
                long currentTimeMillis = System.currentTimeMillis() - longValue;
                if (currentTimeMillis > 0) {
                    b.a aVar = this.f248489y.f248574e;
                    long j3 = aVar.f248576b;
                    int i16 = aVar.f248575a;
                    int i17 = i16 + 1;
                    long j16 = i17;
                    aVar.f248576b = ((j3 / j16) * i16) + (currentTimeMillis / j16);
                    aVar.f248575a = i17;
                }
            }
        }
        if ((toServiceMsg.getAttributes().containsKey(MsfConstants.ATTR_WEAKNET_SENT_FLAG) || fromServiceMsg.getAttributes().containsKey(MsfConstants.ATTR_WEAKNET_SENT_FLAG)) && longValue > 0) {
            this.f248489y.a(fromServiceMsg, this.f248481b, z16, System.currentTimeMillis() - longValue);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            if (a()) {
                HashMap<String, Object> attributes = toServiceMsg.getAttributes();
                Boolean bool = Boolean.TRUE;
                attributes.put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
                fromServiceMsg.getAttributes().put(MsfConstants.ATTR_WEAKNET_SENT_FLAG, bool);
            }
            com.tencent.mobileqq.msf.core.i0.c.c.a aVar = this.f248481b;
            if (!aVar.f248508a && !aVar.f248509b) {
                QLog.d("WeakNetDetector", 1, "[onRecvRespPkg] error with not wifi or mobile connected");
                return;
            }
            if (this.f248483s) {
                Object attribute = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET);
                if (attribute instanceof Long) {
                    long currentTimeMillis = System.currentTimeMillis() - ((Long) attribute).longValue();
                    if (currentTimeMillis > 0) {
                        b.a aVar2 = this.f248489y.f248572c;
                        long j3 = aVar2.f248576b;
                        int i3 = aVar2.f248575a;
                        int i16 = i3 + 1;
                        long j16 = i16;
                        aVar2.f248576b = ((j3 / j16) * i3) + (currentTimeMillis / j16);
                        aVar2.f248575a = i16;
                    }
                }
            }
            if (this.f248481b.f248519l > 0) {
                Object attribute2 = fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF);
                Object attribute3 = toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET_FOR_WEAKNET);
                if ((attribute2 instanceof Long) && (attribute3 instanceof Long)) {
                    long longValue = ((Long) attribute2).longValue() - ((Long) attribute3).longValue();
                    if (com.tencent.mobileqq.msf.core.i0.a.v().p() && fromServiceMsg.getAttributes().containsKey(BaseConstants.DELTA_TIME_SERVER) && (fromServiceMsg.getAttribute(BaseConstants.DELTA_TIME_SERVER) instanceof Integer)) {
                        longValue -= ((Integer) fromServiceMsg.getAttribute(BaseConstants.DELTA_TIME_SERVER)).longValue();
                    }
                    com.tencent.mobileqq.msf.core.i0.c.c.a aVar3 = this.f248481b;
                    long j17 = (long) ((aVar3.f248523p * 0.6d) + (longValue * 0.4d));
                    if (longValue > 0 && j17 > 0) {
                        aVar3.f248523p = j17;
                        int b16 = aVar3.b();
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
                    QLog.d("WeakNetDetector", 1, "[onRecvRespPkg] error with rtt or rttm less than 0");
                    return;
                }
                QLog.d("WeakNetDetector", 1, "[onRecvRespPkg] error with net2msfObj or msf2netObj not Long ");
                return;
            }
            return;
        }
        QLog.d("WeakNetDetector", 1, "[onRecvRespPkg] error with null to or from");
    }

    @Override // com.tencent.mobileqq.msf.core.i0.c.a
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        this.f248481b.f248532y = z16 ? 1 : 0;
        if (QLog.isColorLevel()) {
            QLog.d("WeakNetDetector", 2, "onScreenOn mIsScreenOn=" + z16);
        }
    }
}
