package com.tencent.mobileqq.msf.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_ = null;
    public static final int A = 0;
    public static final int B = 1;

    /* renamed from: j, reason: collision with root package name */
    private static final String f248358j = "LightSender";

    /* renamed from: k, reason: collision with root package name */
    public static final String f248359k = "send_mode";

    /* renamed from: l, reason: collision with root package name */
    public static final int f248360l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static final int f248361m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static final String f248362n = "HttpTimeCost";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248363o = "unknown";

    /* renamed from: p, reason: collision with root package name */
    public static final String f248364p = "pcactive";

    /* renamed from: q, reason: collision with root package name */
    public static final String f248365q = "quicksend";

    /* renamed from: r, reason: collision with root package name */
    public static final int f248366r = 0;

    /* renamed from: s, reason: collision with root package name */
    public static final int f248367s = -1;

    /* renamed from: t, reason: collision with root package name */
    public static final int f248368t = 1;

    /* renamed from: u, reason: collision with root package name */
    public static final int f248369u = 2;

    /* renamed from: v, reason: collision with root package name */
    public static final int f248370v = 3;

    /* renamed from: w, reason: collision with root package name */
    public static final int f248371w = 4;

    /* renamed from: x, reason: collision with root package name */
    public static final int f248372x = 5;

    /* renamed from: y, reason: collision with root package name */
    public static final int f248373y = 6;

    /* renamed from: z, reason: collision with root package name */
    public static final String f248374z = "light_sender_type";

    /* renamed from: a, reason: collision with root package name */
    private MsfCore f248375a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.f0.d.a f248376b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f248377c;

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentLinkedQueue<ToServiceMsg> f248378d;

    /* renamed from: e, reason: collision with root package name */
    private long f248379e;

    /* renamed from: f, reason: collision with root package name */
    private ThreadPoolExecutor f248380f;

    /* renamed from: g, reason: collision with root package name */
    private int f248381g;

    /* renamed from: h, reason: collision with root package name */
    private int f248382h;

    /* renamed from: i, reason: collision with root package name */
    private int f248383i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class a implements ThreadFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f248384d;

        /* renamed from: a, reason: collision with root package name */
        private final ThreadGroup f248385a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f248386b;

        /* renamed from: c, reason: collision with root package name */
        private final String f248387c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21014);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f248384d = new AtomicInteger(1);
            }
        }

        a(String str) {
            ThreadGroup threadGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f248386b = new AtomicInteger(1);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f248385a = threadGroup;
            this.f248387c = str + "-pool-" + f248384d.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Thread) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
            }
            BaseThread baseThread = new BaseThread(this.f248385a, runnable, this.f248387c + this.f248386b.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            if (baseThread.getPriority() != 5) {
                baseThread.setPriority(5);
            }
            return baseThread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ToServiceMsg f248388a;

        b(ToServiceMsg toServiceMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, (Object) toServiceMsg);
            } else {
                this.f248388a = toServiceMsg;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    if (h.this.f248375a != null && h.this.f248375a.mMsfMonitorCallback != null) {
                        h.this.f248375a.mMsfMonitorCallback.handleStart(3);
                    }
                    String name = Thread.currentThread().getName();
                    int activeCount = h.this.f248380f.getActiveCount();
                    if (QLog.isColorLevel()) {
                        QLog.d("LightSender", 2, "threadName: " + name + " threadPoolAccount: " + activeCount);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.d("LightSender", 1, "LightSender sendTask exception,", e16);
                    if (h.this.f248375a == null || h.this.f248375a.mMsfMonitorCallback == null) {
                        return;
                    }
                }
                if (this.f248388a == null) {
                    if (h.this.f248375a != null && h.this.f248375a.mMsfMonitorCallback != null) {
                        h.this.f248375a.mMsfMonitorCallback.handleEnd(3);
                        return;
                    }
                    return;
                }
                h.this.f248378d.add(this.f248388a);
                h.this.f248376b.f().r(this.f248388a);
                h.this.b(this.f248388a);
                h.this.d(this.f248388a);
                if (h.this.f248375a == null || h.this.f248375a.mMsfMonitorCallback == null) {
                    return;
                }
                h.this.f248375a.mMsfMonitorCallback.handleEnd(3);
            } catch (Throwable th5) {
                if (h.this.f248375a != null && h.this.f248375a.mMsfMonitorCallback != null) {
                    h.this.f248375a.mMsfMonitorCallback.handleEnd(3);
                }
                throw th5;
            }
        }
    }

    public h(MsfCore msfCore, com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) aVar);
            return;
        }
        this.f248377c = new LinkedBlockingQueue<>();
        this.f248378d = new ConcurrentLinkedQueue<>();
        this.f248379e = 0L;
        this.f248381g = com.tencent.mobileqq.msf.core.x.b.J();
        this.f248382h = com.tencent.mobileqq.msf.core.x.b.J();
        this.f248383i = 60;
        this.f248375a = msfCore;
        this.f248376b = aVar;
        CodecWarpper.nativeSetKsid(msfCore.getAccountCenter().d());
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(this.f248381g, this.f248382h, this.f248383i, TimeUnit.SECONDS, this.f248377c, new a("LightSender"));
        this.f248380f = baseThreadPoolExecutor;
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private String e(ToServiceMsg toServiceMsg) {
        if (toServiceMsg != null && toServiceMsg.isQuickSendEnable() && QuickSendStrategy.getStragegyArgs(toServiceMsg.getQuickSendStrategy()) != null) {
            return "quicksend";
        }
        return "unknown";
    }

    public synchronized boolean f(ToServiceMsg toServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        if (toServiceMsg == null) {
            return false;
        }
        if (toServiceMsg.getAttributes().containsKey(f248374z)) {
            i3 = ((Integer) toServiceMsg.getAttribute(f248374z, 0)).intValue();
        } else {
            i3 = 0;
        }
        if (i3 == 1 && a()) {
            if (QLog.isColorLevel()) {
                QLog.d("LightSender", 2, "LightSender busy returns, cmd:" + toServiceMsg.getServiceCmd() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq());
            }
            return false;
        }
        a(toServiceMsg);
        return true;
    }

    private boolean a() {
        return this.f248377c.size() + this.f248380f.getActiveCount() >= this.f248382h;
    }

    private byte[] c(ToServiceMsg toServiceMsg) {
        byte[] bArr;
        byte[] bArr2;
        if (toServiceMsg == null) {
            return null;
        }
        try {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (toServiceMsg.getWupBuffer() != null) {
                byte d16 = com.tencent.mobileqq.msf.core.net.k.d();
                if (d16 == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = this.f248379e;
                    if (j3 == 0 || currentTimeMillis - j3 > 60000) {
                        this.f248379e = currentTimeMillis;
                        try {
                            NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
                        } catch (Throwable th5) {
                            QLog.d("LightSender", 1, "checkConnInfo " + th5);
                        }
                    }
                }
                byte activeNetIpFamily = (byte) NetConnInfoCenter.getActiveNetIpFamily(false);
                int intValue = toServiceMsg.getAttributes().containsKey("send_mode") ? ((Integer) toServiceMsg.getAttributes().get("send_mode")).intValue() : 0;
                try {
                    bArr2 = t.a(toServiceMsg, serviceCmd, activeNetIpFamily, d16);
                } catch (Exception e16) {
                    QLog.d("LightSender", 1, "", e16);
                    bArr2 = null;
                }
                if (intValue == 1) {
                    if (591 == CodecWarpper.getSharedObjectVersion()) {
                        bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, toServiceMsg.getWupBuffer(), true);
                    } else {
                        if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                            bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, activeNetIpFamily, bArr2, null, toServiceMsg.getWupBuffer(), true);
                        }
                        bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, bArr2, null, toServiceMsg.getWupBuffer(), true);
                    }
                } else if (591 == CodecWarpper.getSharedObjectVersion()) {
                    bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, toServiceMsg.getWupBuffer(), true);
                } else {
                    if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                        bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, activeNetIpFamily, bArr2, null, toServiceMsg.getWupBuffer(), true);
                    }
                    bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, bArr2, null, toServiceMsg.getWupBuffer(), true);
                }
            } else {
                bArr = new byte[0];
            }
            return bArr;
        } catch (Throwable th6) {
            th6.printStackTrace();
            QLog.d("LightSender", 1, "LightSender get packet fail ssoseq: " + toServiceMsg.getRequestSsoSeq(), th6);
            return null;
        }
    }

    public boolean b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? a(toServiceMsg, false, null) : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg)).booleanValue();
    }

    public void d(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Iterator<ToServiceMsg> it = this.f248378d.iterator();
        while (it.hasNext()) {
            if (toServiceMsg.getRequestSsoSeq() == it.next().getRequestSsoSeq()) {
                it.remove();
                return;
            }
        }
    }

    private void a(ToServiceMsg toServiceMsg) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("LightSender", 2, "LightSender, addSendQueue cmd:" + toServiceMsg.getServiceCmd() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq());
            }
            this.f248380f.submit(new b(toServiceMsg));
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("LightSender", 1, "submit task failed, cmd:" + toServiceMsg.getServiceCmd() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq(), e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0a8c  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0bc4  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0bf8  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0ad2  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0fd5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x10a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x10d5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x11fc  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x1230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(ToServiceMsg toServiceMsg, boolean z16, Object obj) {
        Object obj2;
        int i3;
        int i16;
        int i17;
        com.tencent.mobileqq.msf.core.net.c gVar;
        Object obj3;
        Object obj4;
        boolean z17;
        int i18;
        int i19;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        String str;
        Object obj16;
        boolean z18;
        Object obj17;
        Object obj18;
        com.tencent.mobileqq.msf.core.net.c cVar;
        Object obj19;
        Object obj20;
        int i26;
        int i27;
        int i28;
        Object obj21;
        Object obj22;
        Object obj23;
        Object obj24;
        Object obj25;
        Object obj26;
        Object obj27;
        int i29;
        Object obj28;
        Object obj29;
        Object obj30;
        Object obj31;
        Object obj32;
        Object obj33;
        Object obj34;
        Object obj35;
        Object obj36;
        Object obj37;
        boolean z19;
        Object obj38;
        Object obj39;
        Object obj40;
        Object obj41;
        Object obj42;
        Object obj43;
        boolean z26;
        Object obj44;
        Object obj45;
        Object obj46;
        Object obj47;
        Object obj48;
        Object obj49;
        Object obj50;
        Object obj51;
        Object obj52;
        Object obj53;
        Object obj54;
        int i36;
        Object obj55;
        Object obj56;
        int i37;
        int i38;
        String str2;
        Object obj57;
        Object obj58;
        Object obj59;
        Object obj60;
        Object obj61;
        Object obj62;
        Object obj63;
        Object obj64;
        Object obj65;
        Object obj66;
        Object obj67;
        Object obj68;
        Object obj69;
        Object obj70;
        Object obj71;
        Object obj72;
        Object obj73;
        String e16;
        Object obj74;
        Object obj75;
        Object obj76;
        Object obj77;
        Object obj78;
        Object obj79;
        Object obj80;
        Object obj81;
        Object obj82;
        Object obj83;
        Object obj84;
        Object obj85;
        Object obj86;
        String str3;
        int i39;
        boolean z27;
        Object obj87;
        Object obj88;
        Object obj89;
        Object obj90;
        Object obj91;
        boolean a16;
        Object obj92;
        Object obj93;
        Object obj94;
        Object obj95;
        Object obj96;
        Object obj97;
        Object obj98;
        Object obj99;
        Object obj100;
        Object obj101;
        Object obj102;
        Object obj103;
        Object obj104;
        Object obj105;
        Object obj106;
        Object obj107;
        Object obj108;
        Object obj109;
        Object obj110;
        Object obj111;
        Object obj112;
        Object obj113;
        Object obj114;
        Object obj115;
        Object obj116;
        Object obj117;
        Object obj118;
        TreeMap treeMap;
        Object obj119;
        boolean z28;
        int i46;
        Object obj120;
        Object obj121;
        Object obj122;
        Object obj123;
        Object obj124;
        int i47;
        boolean z29;
        StringBuilder sb5;
        Object obj125;
        StringBuilder sb6;
        Object obj126;
        Object obj127;
        Object obj128;
        Object obj129;
        Object obj130;
        Object obj131;
        Object obj132;
        Object obj133;
        Object obj134;
        Object obj135;
        Object obj136;
        StringBuilder sb7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, toServiceMsg, Boolean.valueOf(z16), obj)).booleanValue();
        }
        if (toServiceMsg != null) {
            int requestSsoSeq = toServiceMsg.getRequestSsoSeq();
            int intValue = toServiceMsg.getAttributes().containsKey(com.tencent.mobileqq.msf.core.quicksend.b.f249865w) ? ((Integer) toServiceMsg.getAttributes().get(com.tencent.mobileqq.msf.core.quicksend.b.f249865w)).intValue() : 0;
            if (toServiceMsg.getAttributes().containsKey("retryIndex")) {
                i3 = ((Integer) toServiceMsg.getAttributes().get("retryIndex")).intValue();
                i17 = requestSsoSeq;
                i16 = intValue;
            } else {
                i16 = intValue;
                i17 = requestSsoSeq;
                i3 = -1;
            }
            obj2 = "sendUseXG";
        } else {
            obj2 = "sendUseXG";
            i3 = -1;
            i16 = 0;
            i17 = 0;
        }
        com.tencent.mobileqq.msf.core.quicksend.d dVar = new com.tencent.mobileqq.msf.core.quicksend.d();
        dVar.f249902b = SystemClock.elapsedRealtime();
        dVar.f249901a = false;
        dVar.f249912l = z16;
        int i48 = (new Random().nextInt(100) % 2 == 0 && com.tencent.mobileqq.msf.core.x.b.f1()) ? 1 : 0;
        if (i48 == 0) {
            gVar = new com.tencent.mobileqq.msf.core.net.h();
        } else {
            gVar = new com.tencent.mobileqq.msf.core.net.g();
        }
        com.tencent.mobileqq.msf.core.net.c cVar2 = gVar;
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (z16) {
            z17 = false;
            obj3 = "isConnSucc";
            obj4 = "connCosttime";
            toServiceMsg.getAttributes().put(com.tencent.mobileqq.msf.core.quicksend.b.f249867y, Integer.valueOf(((Integer) toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249867y, 0)).intValue() + 1));
        } else {
            obj3 = "isConnSucc";
            obj4 = "connCosttime";
            z17 = false;
        }
        if (!QLog.isColorLevel() && !QLog.isDevelopLevel()) {
            QLog.d("LightSender_MSF.C.NetConnTag.", 1, "trySendMsg cmd=" + com.tencent.mobileqq.msf.core.z.a.a(serviceCmd) + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " resendIndex:" + i16 + " usexg:" + (z16 ? 1 : 0) + " quic:" + i48 + " netType:" + NetConnInfoCenter.getActiveNetworkType());
        } else {
            QLog.d("LightSender_MSF.C.NetConnTag.", 1, "trySendMsg cmd:" + serviceCmd + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " resendIndex:" + i16 + " usexg:" + (z16 ? 1 : 0) + " quic:" + i48 + " netType:" + NetConnInfoCenter.getActiveNetworkType());
        }
        try {
            byte[] c16 = c(toServiceMsg);
            if (c16 == null) {
                try {
                    boolean z36 = i48;
                    int i49 = i16;
                    z18 = z17;
                    int i56 = i3;
                    int i57 = i17;
                    i26 = 5;
                    Object obj137 = obj3;
                    Object obj138 = obj4;
                    try {
                        a(toServiceMsg, null, 1, "sendData ssoseq:" + i17 + ", send buffer is empty", dVar);
                        cVar2.a();
                        cVar2.d();
                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                        if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("isSucc", Boolean.toString(dVar.f249901a));
                            hashMap.put("costtime", Long.toString(dVar.f249902b));
                            hashMap.put("account", dVar.f249903c);
                            hashMap.put("cmd", dVar.f249904d);
                            hashMap.put("isHttp", "1");
                            hashMap.put("datalen", Integer.toString(dVar.f249905e));
                            hashMap.put("sendFailReason", Integer.toString(dVar.f249906f));
                            hashMap.put("sendCosttime", Long.toString(dVar.f249907g));
                            hashMap.put(obj137, Boolean.toString(dVar.f249909i));
                            hashMap.put(obj138, Long.toString(dVar.f249910j));
                            hashMap.put("connCount", Integer.toString(dVar.f249911k));
                            hashMap.put("connFailReason", dVar.f249913m);
                            hashMap.put("sendExcpt", dVar.f249908h);
                            hashMap.put("reIndex", "" + i49);
                            hashMap.put("msgReIndex", "" + i56);
                            hashMap.put(obj2, String.valueOf(z16));
                            hashMap.put("sendUseQuic", String.valueOf(z36));
                            hashMap.put("PARAM_failCode", String.valueOf(z16 ? 3 : z36 != 0 ? 5 : 1));
                            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                            this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap, false, false);
                        }
                        return z18;
                    } catch (Throwable th5) {
                        th = th5;
                        obj43 = "connCount";
                        obj51 = "sendFailReason";
                        obj53 = obj137;
                        i28 = i49;
                        obj41 = "sendExcpt";
                        obj42 = "connFailReason";
                        z19 = z18 ? 1 : 0;
                        obj39 = "msgReIndex";
                        obj38 = obj2;
                        i19 = i57;
                        cVar = cVar2;
                        obj54 = obj138;
                        obj45 = "1";
                        obj50 = "datalen";
                        i18 = i56;
                        str = "";
                        obj48 = "isSucc";
                        obj44 = "costtime";
                        obj46 = "account";
                        obj47 = "cmd";
                        obj49 = "isHttp";
                        obj52 = "sendCosttime";
                        obj40 = "reIndex";
                        z26 = z36;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    z18 = z17;
                    i26 = 5;
                    int i58 = i16;
                    z26 = i48;
                    i18 = i3;
                    i19 = i17;
                    obj43 = "connCount";
                    obj52 = "sendCosttime";
                    obj51 = "sendFailReason";
                    obj41 = "sendExcpt";
                    obj42 = "connFailReason";
                    obj46 = "account";
                    obj44 = "costtime";
                    obj48 = "isSucc";
                    str = "";
                    z19 = z18 ? 1 : 0;
                    obj38 = obj2;
                    cVar = cVar2;
                    obj50 = "datalen";
                    obj40 = "reIndex";
                    obj39 = "msgReIndex";
                    obj49 = "isHttp";
                    obj47 = "cmd";
                    obj53 = obj3;
                    obj54 = obj4;
                    obj45 = "1";
                    i28 = i58;
                }
            } else {
                int i59 = i3;
                int i65 = i17;
                z18 = z17;
                Object obj139 = obj2;
                i26 = 5;
                int i66 = i16;
                boolean z37 = i48;
                try {
                    e16 = e(toServiceMsg);
                    try {
                        dVar.f249903c = toServiceMsg.getUin();
                        dVar.f249904d = toServiceMsg.getServiceCmd();
                        dVar.f249905e = c16.length;
                    } catch (Throwable th7) {
                        th = th7;
                        obj74 = "account";
                        obj75 = "connCount";
                        obj76 = "sendCosttime";
                        i28 = i66;
                        obj77 = "sendExcpt";
                        obj78 = "connFailReason";
                        i19 = i65;
                        cVar = cVar2;
                        obj79 = "1";
                        i18 = i59;
                        str = "";
                        obj80 = "reIndex";
                        obj81 = "msgReIndex";
                        obj82 = obj139;
                        obj83 = "isHttp";
                        obj84 = "isSucc";
                        obj85 = "datalen";
                        obj86 = obj4;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    obj30 = "account";
                    obj27 = "connCount";
                    obj36 = "sendCosttime";
                    obj25 = "sendExcpt";
                    obj26 = "connFailReason";
                    i19 = i65;
                    cVar = cVar2;
                    i18 = i59;
                    str = "";
                    obj24 = "reIndex";
                    obj23 = "msgReIndex";
                    obj22 = obj139;
                    obj33 = "isHttp";
                    obj32 = "isSucc";
                    obj34 = "datalen";
                    obj37 = obj4;
                    obj28 = "costtime";
                    obj35 = "sendFailReason";
                    obj31 = "cmd";
                    obj21 = obj3;
                    obj29 = "1";
                    i28 = i66;
                    i29 = z37;
                }
                try {
                    dVar.f249907g = SystemClock.elapsedRealtime();
                    try {
                        if (toServiceMsg.getAttributes().containsKey("connIDC")) {
                            try {
                                if (toServiceMsg.getAttributes().get("connIDC") != null) {
                                    str3 = (String) toServiceMsg.getAttributes().get("connIDC");
                                    if (i66 != 1) {
                                        z27 = true;
                                        i39 = i66;
                                    } else {
                                        i39 = i66;
                                        z27 = z18 ? 1 : 0;
                                    }
                                    obj87 = "1";
                                    obj88 = "cmd";
                                    obj89 = "account";
                                    obj90 = "costtime";
                                    obj91 = "isSucc";
                                    a16 = a(cVar2, e16, i65, dVar, str3, z27);
                                    dVar.f249909i = a16;
                                    if (a16) {
                                        try {
                                            sb7 = new StringBuilder();
                                            sb7.append("sendData ssoseq:");
                                        } catch (Throwable th9) {
                                            th = th9;
                                            obj134 = "sendExcpt";
                                            obj135 = "connFailReason";
                                            i28 = i39;
                                            obj136 = "sendFailReason";
                                            z19 = z18 ? 1 : 0;
                                            i19 = i65;
                                        }
                                        try {
                                            sb7.append(i65);
                                            sb7.append(", connect failed");
                                            a(toServiceMsg, null, 2, sb7.toString(), dVar);
                                            cVar2.a();
                                            cVar2.d();
                                            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                            if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                                                HashMap hashMap2 = new HashMap();
                                                hashMap2.put(obj91, Boolean.toString(dVar.f249901a));
                                                hashMap2.put(obj90, Long.toString(dVar.f249902b));
                                                hashMap2.put(obj89, dVar.f249903c);
                                                hashMap2.put(obj88, dVar.f249904d);
                                                hashMap2.put("isHttp", obj87);
                                                hashMap2.put("datalen", Integer.toString(dVar.f249905e));
                                                hashMap2.put("sendFailReason", Integer.toString(dVar.f249906f));
                                                hashMap2.put("sendCosttime", Long.toString(dVar.f249907g));
                                                hashMap2.put(obj3, Boolean.toString(dVar.f249909i));
                                                hashMap2.put(obj4, Long.toString(dVar.f249910j));
                                                hashMap2.put("connCount", Integer.toString(dVar.f249911k));
                                                hashMap2.put("connFailReason", dVar.f249913m);
                                                hashMap2.put("sendExcpt", dVar.f249908h);
                                                hashMap2.put("reIndex", "" + i39);
                                                hashMap2.put("msgReIndex", "" + i59);
                                                hashMap2.put(obj139, String.valueOf(z16));
                                                hashMap2.put("sendUseQuic", String.valueOf(z37));
                                                hashMap2.put("PARAM_failCode", String.valueOf(z16 ? 3 : z37 != 0 ? 5 : 1));
                                                hashMap2.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap2, false, false);
                                            }
                                            return z18;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            i19 = i65;
                                            obj134 = "sendExcpt";
                                            obj135 = "connFailReason";
                                            i28 = i39;
                                            obj136 = "sendFailReason";
                                            z19 = z18 ? 1 : 0;
                                            cVar = cVar2;
                                            obj53 = obj3;
                                            obj54 = obj4;
                                            obj50 = "datalen";
                                            obj49 = "isHttp";
                                            obj52 = "sendCosttime";
                                            i18 = i59;
                                            str = "";
                                            obj40 = "reIndex";
                                            obj39 = "msgReIndex";
                                            obj38 = obj139;
                                            obj43 = "connCount";
                                            obj51 = obj136;
                                            obj48 = obj91;
                                            obj47 = obj88;
                                            obj46 = obj89;
                                            obj45 = obj87;
                                            obj44 = obj90;
                                            z26 = z37;
                                            obj42 = obj135;
                                            obj41 = obj134;
                                            i36 = i28;
                                            StringBuilder sb8 = new StringBuilder();
                                            obj69 = obj54;
                                            sb8.append("sendData ssoseq:");
                                            int i67 = i19;
                                            sb8.append(i67);
                                            sb8.append(", exception");
                                            obj70 = obj53;
                                            obj71 = obj52;
                                            obj72 = obj51;
                                            obj73 = obj50;
                                            a(toServiceMsg, null, -1, sb8.toString(), dVar);
                                            th.printStackTrace();
                                            QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i67 + " exception, ", th);
                                            cVar.a();
                                            cVar.d();
                                            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                            if (this.f248375a.statReporter != null) {
                                                HashMap hashMap3 = new HashMap();
                                                hashMap3.put(obj48, Boolean.toString(dVar.f249901a));
                                                hashMap3.put(obj44, Long.toString(dVar.f249902b));
                                                hashMap3.put(obj46, dVar.f249903c);
                                                hashMap3.put(obj47, dVar.f249904d);
                                                hashMap3.put(obj49, obj45);
                                                hashMap3.put(obj73, Integer.toString(dVar.f249905e));
                                                hashMap3.put(obj72, Integer.toString(dVar.f249906f));
                                                hashMap3.put(obj71, Long.toString(dVar.f249907g));
                                                hashMap3.put(obj70, Boolean.toString(dVar.f249909i));
                                                hashMap3.put(obj69, Long.toString(dVar.f249910j));
                                                hashMap3.put(obj43, Integer.toString(dVar.f249911k));
                                                hashMap3.put(obj42, dVar.f249913m);
                                                hashMap3.put(obj41, dVar.f249908h);
                                                StringBuilder sb9 = new StringBuilder();
                                                String str4 = str;
                                                sb9.append(str4);
                                                sb9.append(i36);
                                                hashMap3.put(obj40, sb9.toString());
                                                hashMap3.put(obj39, str4 + i18);
                                                hashMap3.put(obj38, String.valueOf(z16));
                                                hashMap3.put("sendUseQuic", String.valueOf(z26));
                                                hashMap3.put("PARAM_failCode", String.valueOf(z16 ? 3 : z26 != 0 ? i26 : 1));
                                                hashMap3.put(BaseConstants.RDM_NoChangeFailCode, str4);
                                                this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap3, false, false);
                                            }
                                            if (z19) {
                                            }
                                            return z18;
                                        }
                                    }
                                    i28 = i39;
                                    Object obj140 = obj3;
                                    Object obj141 = obj4;
                                    try {
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        try {
                                            byte[] a17 = cVar2.a(toServiceMsg, c16, e16, dVar);
                                            if (a17 == null) {
                                                try {
                                                    cVar = cVar2;
                                                    Object obj142 = "isHttp";
                                                    try {
                                                        a(toServiceMsg, null, 3, "sendData ssoseq:" + i65 + ", recv data failed", dVar);
                                                        cVar.a();
                                                        cVar.d();
                                                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                        if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                                                            HashMap hashMap4 = new HashMap();
                                                            hashMap4.put(obj91, Boolean.toString(dVar.f249901a));
                                                            hashMap4.put(obj90, Long.toString(dVar.f249902b));
                                                            hashMap4.put(obj89, dVar.f249903c);
                                                            hashMap4.put(obj88, dVar.f249904d);
                                                            hashMap4.put(obj142, obj87);
                                                            hashMap4.put("datalen", Integer.toString(dVar.f249905e));
                                                            hashMap4.put("sendFailReason", Integer.toString(dVar.f249906f));
                                                            hashMap4.put("sendCosttime", Long.toString(dVar.f249907g));
                                                            hashMap4.put(obj140, Boolean.toString(dVar.f249909i));
                                                            hashMap4.put(obj141, Long.toString(dVar.f249910j));
                                                            hashMap4.put("connCount", Integer.toString(dVar.f249911k));
                                                            hashMap4.put("connFailReason", dVar.f249913m);
                                                            hashMap4.put("sendExcpt", dVar.f249908h);
                                                            hashMap4.put("reIndex", "" + i28);
                                                            hashMap4.put("msgReIndex", "" + i59);
                                                            hashMap4.put(obj139, String.valueOf(z16));
                                                            hashMap4.put("sendUseQuic", String.valueOf(z37));
                                                            hashMap4.put("PARAM_failCode", String.valueOf(z16 ? 3 : z37 != 0 ? 5 : 1));
                                                            hashMap4.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                            this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap4, false, false);
                                                        }
                                                        return z18;
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        z19 = z18 ? 1 : 0;
                                                        i19 = i65;
                                                        obj52 = "sendCosttime";
                                                        i18 = i59;
                                                        str = "";
                                                        obj54 = obj141;
                                                        obj43 = "connCount";
                                                        obj42 = "connFailReason";
                                                        obj41 = "sendExcpt";
                                                        obj40 = "reIndex";
                                                        obj39 = "msgReIndex";
                                                        obj38 = obj139;
                                                        i28 = i28;
                                                        obj53 = obj140;
                                                        obj51 = "sendFailReason";
                                                        obj50 = "datalen";
                                                        obj49 = obj142;
                                                        obj48 = obj91;
                                                        obj47 = obj88;
                                                        obj46 = obj89;
                                                        obj45 = obj87;
                                                        obj44 = obj90;
                                                        z26 = z37;
                                                    }
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    cVar = cVar2;
                                                    obj49 = "isHttp";
                                                    obj52 = "sendCosttime";
                                                    obj50 = "datalen";
                                                    i28 = i28;
                                                    obj51 = "sendFailReason";
                                                    z19 = z18 ? 1 : 0;
                                                    i19 = i65;
                                                    i18 = i59;
                                                    str = "";
                                                    obj43 = "connCount";
                                                    obj42 = "connFailReason";
                                                    obj41 = "sendExcpt";
                                                    obj40 = "reIndex";
                                                    obj39 = "msgReIndex";
                                                    obj38 = obj139;
                                                    obj53 = obj140;
                                                    obj54 = obj141;
                                                    obj48 = obj91;
                                                    obj47 = obj88;
                                                    obj46 = obj89;
                                                    obj45 = obj87;
                                                    obj44 = obj90;
                                                    z26 = z37;
                                                }
                                            } else {
                                                cVar = cVar2;
                                                i28 = i28;
                                                Object obj143 = "sendCosttime";
                                                Object obj144 = "isHttp";
                                                Object obj145 = obj140;
                                                Object obj146 = "datalen";
                                                Object obj147 = "sendFailReason";
                                                Object obj148 = obj141;
                                                try {
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    i19 = i65;
                                                    obj103 = obj148;
                                                }
                                                try {
                                                    dVar.f249907g = SystemClock.elapsedRealtime() - elapsedRealtime;
                                                    FromServiceMsg nativeParseData = CodecWarpper.nativeParseData(a17);
                                                    if (nativeParseData != null) {
                                                        try {
                                                            FromServiceMsg a18 = a(nativeParseData);
                                                            if (a18 == null) {
                                                                try {
                                                                    sb6 = new StringBuilder();
                                                                    sb6.append("sendData ssoseq:");
                                                                } catch (Throwable th14) {
                                                                    th = th14;
                                                                    z19 = z18 ? 1 : 0;
                                                                    i19 = i65;
                                                                }
                                                                try {
                                                                    sb6.append(i65);
                                                                    sb6.append(", recv data failed");
                                                                    try {
                                                                        a(toServiceMsg, null, 5, sb6.toString(), dVar);
                                                                        cVar.a();
                                                                        cVar.d();
                                                                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                        if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                                                                            HashMap hashMap5 = new HashMap();
                                                                            hashMap5.put(obj91, Boolean.toString(dVar.f249901a));
                                                                            hashMap5.put(obj90, Long.toString(dVar.f249902b));
                                                                            hashMap5.put(obj89, dVar.f249903c);
                                                                            hashMap5.put(obj88, dVar.f249904d);
                                                                            hashMap5.put(obj144, obj87);
                                                                            hashMap5.put(obj146, Integer.toString(dVar.f249905e));
                                                                            hashMap5.put(obj147, Integer.toString(dVar.f249906f));
                                                                            hashMap5.put(obj143, Long.toString(dVar.f249907g));
                                                                            hashMap5.put(obj145, Boolean.toString(dVar.f249909i));
                                                                            hashMap5.put(obj148, Long.toString(dVar.f249910j));
                                                                            hashMap5.put("connCount", Integer.toString(dVar.f249911k));
                                                                            hashMap5.put("connFailReason", dVar.f249913m);
                                                                            hashMap5.put("sendExcpt", dVar.f249908h);
                                                                            hashMap5.put("reIndex", "" + i28);
                                                                            hashMap5.put("msgReIndex", "" + i59);
                                                                            hashMap5.put(obj139, String.valueOf(z16));
                                                                            hashMap5.put("sendUseQuic", String.valueOf(z37));
                                                                            hashMap5.put("PARAM_failCode", String.valueOf(z16 ? 3 : z37 != 0 ? 5 : 1));
                                                                            hashMap5.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                                            this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap5, false, false);
                                                                        }
                                                                        return z18;
                                                                    } catch (Throwable th15) {
                                                                        th = th15;
                                                                        z19 = z18 ? 1 : 0;
                                                                        i18 = i59;
                                                                        str = "";
                                                                        obj43 = "connCount";
                                                                        obj42 = "connFailReason";
                                                                        obj41 = "sendExcpt";
                                                                        obj40 = "reIndex";
                                                                        obj39 = "msgReIndex";
                                                                        obj38 = obj139;
                                                                        i28 = i28;
                                                                        i19 = i65;
                                                                        obj54 = obj148;
                                                                        obj53 = obj145;
                                                                        obj52 = obj143;
                                                                        obj51 = obj147;
                                                                        obj50 = obj146;
                                                                        obj49 = obj144;
                                                                        obj48 = obj91;
                                                                        obj47 = obj88;
                                                                        obj46 = obj89;
                                                                        obj45 = obj87;
                                                                        obj44 = obj90;
                                                                        z26 = z37;
                                                                    }
                                                                } catch (Throwable th16) {
                                                                    th = th16;
                                                                    i19 = i65;
                                                                    z19 = z18 ? 1 : 0;
                                                                    obj54 = obj148;
                                                                    i28 = i28;
                                                                    i18 = i59;
                                                                    str = "";
                                                                    obj43 = "connCount";
                                                                    obj42 = "connFailReason";
                                                                    obj41 = "sendExcpt";
                                                                    obj40 = "reIndex";
                                                                    obj39 = "msgReIndex";
                                                                    obj38 = obj139;
                                                                    obj53 = obj145;
                                                                    obj52 = obj143;
                                                                    obj51 = obj147;
                                                                    obj50 = obj146;
                                                                    obj49 = obj144;
                                                                    obj48 = obj91;
                                                                    obj47 = obj88;
                                                                    obj46 = obj89;
                                                                    obj45 = obj87;
                                                                    obj44 = obj90;
                                                                    z26 = z37;
                                                                    i36 = i28;
                                                                    StringBuilder sb82 = new StringBuilder();
                                                                    obj69 = obj54;
                                                                    sb82.append("sendData ssoseq:");
                                                                    int i672 = i19;
                                                                    sb82.append(i672);
                                                                    sb82.append(", exception");
                                                                    obj70 = obj53;
                                                                    obj71 = obj52;
                                                                    obj72 = obj51;
                                                                    obj73 = obj50;
                                                                    a(toServiceMsg, null, -1, sb82.toString(), dVar);
                                                                    th.printStackTrace();
                                                                    QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i672 + " exception, ", th);
                                                                    cVar.a();
                                                                    cVar.d();
                                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                    if (this.f248375a.statReporter != null) {
                                                                    }
                                                                    if (z19) {
                                                                    }
                                                                    return z18;
                                                                }
                                                            } else {
                                                                i28 = i28;
                                                                try {
                                                                    a18.setRequestSsoSeq(a18.getAppSeq());
                                                                    try {
                                                                        a18.getAttributes().put(MsfConstants.ATTR_QUICK_SEND_BY_XG, Boolean.valueOf(z16));
                                                                        a18.setAppSeq(toServiceMsg.getAppSeq());
                                                                        a18.setMsfCommand(toServiceMsg.getMsfCommand());
                                                                        a18.setAppId(toServiceMsg.getAppId());
                                                                        a18.setRequestSsoSeq(toServiceMsg.getRequestSsoSeq());
                                                                        toServiceMsg.getAttributes().put(MsfConstants.ATTR_QUICK_SEND_BY_XG, Boolean.valueOf(z16));
                                                                    } catch (Throwable th17) {
                                                                        th = th17;
                                                                    }
                                                                } catch (Throwable th18) {
                                                                    th = th18;
                                                                    obj104 = obj145;
                                                                    obj105 = obj143;
                                                                    z19 = z18 ? 1 : 0;
                                                                    i19 = i65;
                                                                    i18 = i59;
                                                                    str = "";
                                                                    obj106 = "connCount";
                                                                    obj107 = "connFailReason";
                                                                    obj108 = "sendExcpt";
                                                                    obj109 = "reIndex";
                                                                    obj110 = "msgReIndex";
                                                                    obj111 = obj139;
                                                                    obj52 = obj105;
                                                                    obj53 = obj104;
                                                                    obj54 = obj148;
                                                                    obj51 = obj147;
                                                                    obj50 = obj146;
                                                                    obj49 = obj144;
                                                                    obj48 = obj91;
                                                                    obj47 = obj88;
                                                                    obj46 = obj89;
                                                                    obj45 = obj87;
                                                                    obj44 = obj90;
                                                                    z26 = z37;
                                                                    obj43 = obj106;
                                                                    obj42 = obj107;
                                                                    obj41 = obj108;
                                                                    obj40 = obj109;
                                                                    obj39 = obj110;
                                                                    obj38 = obj111;
                                                                    i36 = i28;
                                                                    StringBuilder sb822 = new StringBuilder();
                                                                    obj69 = obj54;
                                                                    sb822.append("sendData ssoseq:");
                                                                    int i6722 = i19;
                                                                    sb822.append(i6722);
                                                                    sb822.append(", exception");
                                                                    obj70 = obj53;
                                                                    obj71 = obj52;
                                                                    obj72 = obj51;
                                                                    obj73 = obj50;
                                                                    a(toServiceMsg, null, -1, sb822.toString(), dVar);
                                                                    th.printStackTrace();
                                                                    QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i6722 + " exception, ", th);
                                                                    cVar.a();
                                                                    cVar.d();
                                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                    if (this.f248375a.statReporter != null) {
                                                                    }
                                                                    if (z19) {
                                                                    }
                                                                    return z18;
                                                                }
                                                                try {
                                                                    if (com.tencent.mobileqq.msf.core.net.u.b.i.a().b(toServiceMsg)) {
                                                                        try {
                                                                            MsfService.core.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247737q3, true, 0L, 0L, (Map<String, String>) new TreeMap(), false, false);
                                                                            if (QLog.isDebugVersion()) {
                                                                                QLog.d("[ReportBeacon]", 1, "HttpSucc.");
                                                                            }
                                                                            treeMap = new TreeMap();
                                                                            obj119 = obj147;
                                                                        } catch (Throwable th19) {
                                                                            th = th19;
                                                                            z19 = z18 ? 1 : 0;
                                                                            obj113 = obj147;
                                                                            obj112 = obj146;
                                                                            obj114 = obj145;
                                                                            obj115 = obj148;
                                                                            obj116 = obj143;
                                                                            i19 = i65;
                                                                            obj118 = obj113;
                                                                            obj117 = obj112;
                                                                            i18 = i59;
                                                                            str = "";
                                                                            obj43 = "connCount";
                                                                            obj42 = "connFailReason";
                                                                            obj41 = "sendExcpt";
                                                                            obj40 = "reIndex";
                                                                            obj39 = "msgReIndex";
                                                                            obj38 = obj139;
                                                                            obj54 = obj115;
                                                                            obj53 = obj114;
                                                                            obj52 = obj116;
                                                                            obj51 = obj118;
                                                                            obj50 = obj117;
                                                                            obj49 = obj144;
                                                                            obj48 = obj91;
                                                                            obj47 = obj88;
                                                                            obj46 = obj89;
                                                                            obj45 = obj87;
                                                                            obj44 = obj90;
                                                                            z26 = z37;
                                                                            i36 = i28;
                                                                            StringBuilder sb8222 = new StringBuilder();
                                                                            obj69 = obj54;
                                                                            sb8222.append("sendData ssoseq:");
                                                                            int i67222 = i19;
                                                                            sb8222.append(i67222);
                                                                            sb8222.append(", exception");
                                                                            obj70 = obj53;
                                                                            obj71 = obj52;
                                                                            obj72 = obj51;
                                                                            obj73 = obj50;
                                                                            a(toServiceMsg, null, -1, sb8222.toString(), dVar);
                                                                            th.printStackTrace();
                                                                            QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i67222 + " exception, ", th);
                                                                            cVar.a();
                                                                            cVar.d();
                                                                            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                            if (this.f248375a.statReporter != null) {
                                                                            }
                                                                            if (z19) {
                                                                            }
                                                                            return z18;
                                                                        }
                                                                        try {
                                                                            treeMap.put(f248362n, String.valueOf(dVar.f249907g));
                                                                            MsfService.core.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247742r3, false, 0L, 0L, (Map<String, String>) treeMap, false, false);
                                                                            obj125 = obj119;
                                                                            if (QLog.isDebugVersion()) {
                                                                                Object[] objArr = new Object[2];
                                                                                objArr[z18 ? 1 : 0] = "HttpTime: ";
                                                                                z28 = true;
                                                                                objArr[1] = Long.valueOf(dVar.f249907g);
                                                                                QLog.d("[ReportBeacon]", 1, objArr);
                                                                                obj119 = obj119;
                                                                                z19 = this.f248376b.q().a(toServiceMsg, a18, i28);
                                                                                if (z19) {
                                                                                    try {
                                                                                        sb5 = new StringBuilder();
                                                                                        sb5.append("sendData ssoseq:");
                                                                                    } catch (Throwable th20) {
                                                                                        th = th20;
                                                                                        obj113 = obj119;
                                                                                        obj112 = obj146;
                                                                                        obj114 = obj145;
                                                                                        obj115 = obj148;
                                                                                        obj116 = obj143;
                                                                                        i19 = i65;
                                                                                        obj118 = obj113;
                                                                                        obj117 = obj112;
                                                                                        i18 = i59;
                                                                                        str = "";
                                                                                        obj43 = "connCount";
                                                                                        obj42 = "connFailReason";
                                                                                        obj41 = "sendExcpt";
                                                                                        obj40 = "reIndex";
                                                                                        obj39 = "msgReIndex";
                                                                                        obj38 = obj139;
                                                                                        obj54 = obj115;
                                                                                        obj53 = obj114;
                                                                                        obj52 = obj116;
                                                                                        obj51 = obj118;
                                                                                        obj50 = obj117;
                                                                                        obj49 = obj144;
                                                                                        obj48 = obj91;
                                                                                        obj47 = obj88;
                                                                                        obj46 = obj89;
                                                                                        obj45 = obj87;
                                                                                        obj44 = obj90;
                                                                                        z26 = z37;
                                                                                        i36 = i28;
                                                                                        StringBuilder sb82222 = new StringBuilder();
                                                                                        obj69 = obj54;
                                                                                        sb82222.append("sendData ssoseq:");
                                                                                        int i672222 = i19;
                                                                                        sb82222.append(i672222);
                                                                                        sb82222.append(", exception");
                                                                                        obj70 = obj53;
                                                                                        obj71 = obj52;
                                                                                        obj72 = obj51;
                                                                                        obj73 = obj50;
                                                                                        a(toServiceMsg, null, -1, sb82222.toString(), dVar);
                                                                                        th.printStackTrace();
                                                                                        QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i672222 + " exception, ", th);
                                                                                        cVar.a();
                                                                                        cVar.d();
                                                                                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                                        if (this.f248375a.statReporter != null) {
                                                                                        }
                                                                                        if (z19) {
                                                                                        }
                                                                                        return z18;
                                                                                    }
                                                                                    try {
                                                                                        sb5.append(i65);
                                                                                        sb5.append(", recv new ssolist");
                                                                                        i46 = i28;
                                                                                        i47 = i65;
                                                                                        obj123 = obj148;
                                                                                        obj122 = obj145;
                                                                                        obj124 = obj143;
                                                                                        obj121 = obj119;
                                                                                        obj120 = obj146;
                                                                                        try {
                                                                                            a(toServiceMsg, null, 6, sb5.toString(), dVar);
                                                                                            z29 = 1;
                                                                                            obj123 = obj123;
                                                                                            obj122 = obj122;
                                                                                            obj124 = obj124;
                                                                                            obj121 = obj121;
                                                                                            obj120 = obj120;
                                                                                        } catch (Throwable th21) {
                                                                                            th = th21;
                                                                                            i18 = i59;
                                                                                            str = "";
                                                                                            obj43 = "connCount";
                                                                                            obj42 = "connFailReason";
                                                                                            obj41 = "sendExcpt";
                                                                                            obj40 = "reIndex";
                                                                                            obj39 = "msgReIndex";
                                                                                            obj38 = obj139;
                                                                                            i28 = i46;
                                                                                            i19 = i47;
                                                                                            obj54 = obj123;
                                                                                            obj53 = obj122;
                                                                                            obj52 = obj124;
                                                                                            obj51 = obj121;
                                                                                            obj50 = obj120;
                                                                                            obj49 = obj144;
                                                                                            obj48 = obj91;
                                                                                            obj47 = obj88;
                                                                                            obj46 = obj89;
                                                                                            obj45 = obj87;
                                                                                            obj44 = obj90;
                                                                                            z26 = z37;
                                                                                        }
                                                                                    } catch (Throwable th22) {
                                                                                        th = th22;
                                                                                        i19 = i65;
                                                                                        obj118 = obj119;
                                                                                        obj114 = obj145;
                                                                                        obj115 = obj148;
                                                                                        obj116 = obj143;
                                                                                        obj117 = obj146;
                                                                                        i18 = i59;
                                                                                        str = "";
                                                                                        obj43 = "connCount";
                                                                                        obj42 = "connFailReason";
                                                                                        obj41 = "sendExcpt";
                                                                                        obj40 = "reIndex";
                                                                                        obj39 = "msgReIndex";
                                                                                        obj38 = obj139;
                                                                                        obj54 = obj115;
                                                                                        obj53 = obj114;
                                                                                        obj52 = obj116;
                                                                                        obj51 = obj118;
                                                                                        obj50 = obj117;
                                                                                        obj49 = obj144;
                                                                                        obj48 = obj91;
                                                                                        obj47 = obj88;
                                                                                        obj46 = obj89;
                                                                                        obj45 = obj87;
                                                                                        obj44 = obj90;
                                                                                        z26 = z37;
                                                                                        i36 = i28;
                                                                                        StringBuilder sb822222 = new StringBuilder();
                                                                                        obj69 = obj54;
                                                                                        sb822222.append("sendData ssoseq:");
                                                                                        int i6722222 = i19;
                                                                                        sb822222.append(i6722222);
                                                                                        sb822222.append(", exception");
                                                                                        obj70 = obj53;
                                                                                        obj71 = obj52;
                                                                                        obj72 = obj51;
                                                                                        obj73 = obj50;
                                                                                        a(toServiceMsg, null, -1, sb822222.toString(), dVar);
                                                                                        th.printStackTrace();
                                                                                        QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i6722222 + " exception, ", th);
                                                                                        cVar.a();
                                                                                        cVar.d();
                                                                                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                                        if (this.f248375a.statReporter != null) {
                                                                                        }
                                                                                        if (z19) {
                                                                                        }
                                                                                        return z18;
                                                                                    }
                                                                                } else {
                                                                                    i46 = i28;
                                                                                    obj120 = obj146;
                                                                                    obj121 = obj119;
                                                                                    obj122 = obj145;
                                                                                    obj123 = obj148;
                                                                                    obj124 = obj143;
                                                                                    i47 = i65;
                                                                                    z29 = z28;
                                                                                }
                                                                                dVar.f249901a = z29;
                                                                                cVar.a();
                                                                                cVar.d();
                                                                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                                if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                                                                                    HashMap hashMap6 = new HashMap();
                                                                                    hashMap6.put(obj91, Boolean.toString(dVar.f249901a));
                                                                                    hashMap6.put(obj90, Long.toString(dVar.f249902b));
                                                                                    hashMap6.put(obj89, dVar.f249903c);
                                                                                    hashMap6.put(obj88, dVar.f249904d);
                                                                                    hashMap6.put(obj144, obj87);
                                                                                    hashMap6.put(obj120, Integer.toString(dVar.f249905e));
                                                                                    hashMap6.put(obj121, Integer.toString(dVar.f249906f));
                                                                                    hashMap6.put(obj124, Long.toString(dVar.f249907g));
                                                                                    hashMap6.put(obj122, Boolean.toString(dVar.f249909i));
                                                                                    hashMap6.put(obj123, Long.toString(dVar.f249910j));
                                                                                    hashMap6.put("connCount", Integer.toString(dVar.f249911k));
                                                                                    hashMap6.put("connFailReason", dVar.f249913m);
                                                                                    hashMap6.put("sendExcpt", dVar.f249908h);
                                                                                    hashMap6.put("reIndex", "" + i46);
                                                                                    hashMap6.put("msgReIndex", "" + i59);
                                                                                    hashMap6.put(obj139, String.valueOf(z16));
                                                                                    hashMap6.put("sendUseQuic", String.valueOf(z37));
                                                                                    hashMap6.put("PARAM_failCode", String.valueOf(z16 ? 3 : z37 != 0 ? 5 : z29));
                                                                                    hashMap6.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                                                    this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap6, false, false);
                                                                                }
                                                                                if (z19) {
                                                                                    this.f248376b.f().j(toServiceMsg, null, dVar);
                                                                                }
                                                                                return z29;
                                                                            }
                                                                        } catch (Throwable th23) {
                                                                            th = th23;
                                                                            obj147 = obj119;
                                                                            z19 = z18 ? 1 : 0;
                                                                            obj113 = obj147;
                                                                            obj112 = obj146;
                                                                            obj114 = obj145;
                                                                            obj115 = obj148;
                                                                            obj116 = obj143;
                                                                            i19 = i65;
                                                                            obj118 = obj113;
                                                                            obj117 = obj112;
                                                                            i18 = i59;
                                                                            str = "";
                                                                            obj43 = "connCount";
                                                                            obj42 = "connFailReason";
                                                                            obj41 = "sendExcpt";
                                                                            obj40 = "reIndex";
                                                                            obj39 = "msgReIndex";
                                                                            obj38 = obj139;
                                                                            obj54 = obj115;
                                                                            obj53 = obj114;
                                                                            obj52 = obj116;
                                                                            obj51 = obj118;
                                                                            obj50 = obj117;
                                                                            obj49 = obj144;
                                                                            obj48 = obj91;
                                                                            obj47 = obj88;
                                                                            obj46 = obj89;
                                                                            obj45 = obj87;
                                                                            obj44 = obj90;
                                                                            z26 = z37;
                                                                            i36 = i28;
                                                                            StringBuilder sb8222222 = new StringBuilder();
                                                                            obj69 = obj54;
                                                                            sb8222222.append("sendData ssoseq:");
                                                                            int i67222222 = i19;
                                                                            sb8222222.append(i67222222);
                                                                            sb8222222.append(", exception");
                                                                            obj70 = obj53;
                                                                            obj71 = obj52;
                                                                            obj72 = obj51;
                                                                            obj73 = obj50;
                                                                            a(toServiceMsg, null, -1, sb8222222.toString(), dVar);
                                                                            th.printStackTrace();
                                                                            QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i67222222 + " exception, ", th);
                                                                            cVar.a();
                                                                            cVar.d();
                                                                            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                            if (this.f248375a.statReporter != null) {
                                                                            }
                                                                            if (z19) {
                                                                            }
                                                                            return z18;
                                                                        }
                                                                    } else {
                                                                        obj125 = obj147;
                                                                    }
                                                                    z19 = this.f248376b.q().a(toServiceMsg, a18, i28);
                                                                    if (z19) {
                                                                    }
                                                                    dVar.f249901a = z29;
                                                                    cVar.a();
                                                                    cVar.d();
                                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                    if (this.f248375a.statReporter != null) {
                                                                        HashMap hashMap62 = new HashMap();
                                                                        hashMap62.put(obj91, Boolean.toString(dVar.f249901a));
                                                                        hashMap62.put(obj90, Long.toString(dVar.f249902b));
                                                                        hashMap62.put(obj89, dVar.f249903c);
                                                                        hashMap62.put(obj88, dVar.f249904d);
                                                                        hashMap62.put(obj144, obj87);
                                                                        hashMap62.put(obj120, Integer.toString(dVar.f249905e));
                                                                        hashMap62.put(obj121, Integer.toString(dVar.f249906f));
                                                                        hashMap62.put(obj124, Long.toString(dVar.f249907g));
                                                                        hashMap62.put(obj122, Boolean.toString(dVar.f249909i));
                                                                        hashMap62.put(obj123, Long.toString(dVar.f249910j));
                                                                        hashMap62.put("connCount", Integer.toString(dVar.f249911k));
                                                                        hashMap62.put("connFailReason", dVar.f249913m);
                                                                        hashMap62.put("sendExcpt", dVar.f249908h);
                                                                        hashMap62.put("reIndex", "" + i46);
                                                                        hashMap62.put("msgReIndex", "" + i59);
                                                                        hashMap62.put(obj139, String.valueOf(z16));
                                                                        hashMap62.put("sendUseQuic", String.valueOf(z37));
                                                                        hashMap62.put("PARAM_failCode", String.valueOf(z16 ? 3 : z37 != 0 ? 5 : z29));
                                                                        hashMap62.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                                        this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap62, false, false);
                                                                    }
                                                                    if (z19) {
                                                                    }
                                                                    return z29;
                                                                } catch (Throwable th24) {
                                                                    th = th24;
                                                                    obj146 = obj146;
                                                                    obj147 = obj119;
                                                                    z19 = z18 ? 1 : 0;
                                                                    obj113 = obj147;
                                                                    obj112 = obj146;
                                                                    obj114 = obj145;
                                                                    obj115 = obj148;
                                                                    obj116 = obj143;
                                                                    i19 = i65;
                                                                    obj118 = obj113;
                                                                    obj117 = obj112;
                                                                    i18 = i59;
                                                                    str = "";
                                                                    obj43 = "connCount";
                                                                    obj42 = "connFailReason";
                                                                    obj41 = "sendExcpt";
                                                                    obj40 = "reIndex";
                                                                    obj39 = "msgReIndex";
                                                                    obj38 = obj139;
                                                                    obj54 = obj115;
                                                                    obj53 = obj114;
                                                                    obj52 = obj116;
                                                                    obj51 = obj118;
                                                                    obj50 = obj117;
                                                                    obj49 = obj144;
                                                                    obj48 = obj91;
                                                                    obj47 = obj88;
                                                                    obj46 = obj89;
                                                                    obj45 = obj87;
                                                                    obj44 = obj90;
                                                                    z26 = z37;
                                                                    i36 = i28;
                                                                    StringBuilder sb82222222 = new StringBuilder();
                                                                    obj69 = obj54;
                                                                    sb82222222.append("sendData ssoseq:");
                                                                    int i672222222 = i19;
                                                                    sb82222222.append(i672222222);
                                                                    sb82222222.append(", exception");
                                                                    obj70 = obj53;
                                                                    obj71 = obj52;
                                                                    obj72 = obj51;
                                                                    obj73 = obj50;
                                                                    a(toServiceMsg, null, -1, sb82222222.toString(), dVar);
                                                                    th.printStackTrace();
                                                                    QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i672222222 + " exception, ", th);
                                                                    cVar.a();
                                                                    cVar.d();
                                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                    if (this.f248375a.statReporter != null) {
                                                                    }
                                                                    if (z19) {
                                                                    }
                                                                    return z18;
                                                                }
                                                                z28 = true;
                                                                obj119 = obj125;
                                                            }
                                                        } catch (Throwable th25) {
                                                            th = th25;
                                                            obj104 = obj145;
                                                            obj105 = obj143;
                                                            z19 = z18 ? 1 : 0;
                                                            i19 = i65;
                                                            i28 = i28;
                                                            i18 = i59;
                                                            str = "";
                                                            obj106 = "connCount";
                                                            obj107 = "connFailReason";
                                                            obj108 = "sendExcpt";
                                                            obj109 = "reIndex";
                                                            obj110 = "msgReIndex";
                                                            obj111 = obj139;
                                                        }
                                                    } else {
                                                        i28 = i28;
                                                        try {
                                                            StringBuilder sb10 = new StringBuilder();
                                                            sb10.append("sendData ssoseq:");
                                                            try {
                                                                sb10.append(i65);
                                                                sb10.append(", parse data failed");
                                                                i19 = i65;
                                                            } catch (Throwable th26) {
                                                                th = th26;
                                                                i19 = i65;
                                                                obj126 = obj146;
                                                                obj133 = obj147;
                                                                i18 = i59;
                                                                str = "";
                                                                obj127 = "connCount";
                                                                obj128 = "connFailReason";
                                                                obj129 = "sendExcpt";
                                                                obj130 = "reIndex";
                                                                obj131 = "msgReIndex";
                                                                obj132 = obj139;
                                                                obj36 = obj143;
                                                                obj21 = obj145;
                                                                obj37 = obj148;
                                                                obj35 = obj133;
                                                                obj34 = obj126;
                                                                obj33 = obj144;
                                                                obj32 = obj91;
                                                                obj31 = obj88;
                                                                obj30 = obj89;
                                                                obj29 = obj87;
                                                                obj28 = obj90;
                                                                i29 = z37;
                                                                obj27 = obj127;
                                                                obj26 = obj128;
                                                                obj25 = obj129;
                                                                obj24 = obj130;
                                                                obj23 = obj131;
                                                                obj22 = obj132;
                                                                z19 = z18 ? 1 : 0;
                                                                obj54 = obj37;
                                                                obj53 = obj21;
                                                                obj52 = obj36;
                                                                obj51 = obj35;
                                                                obj50 = obj34;
                                                                obj49 = obj33;
                                                                obj48 = obj32;
                                                                obj47 = obj31;
                                                                obj46 = obj30;
                                                                obj45 = obj29;
                                                                obj44 = obj28;
                                                                z26 = i29;
                                                                obj43 = obj27;
                                                                obj42 = obj26;
                                                                obj41 = obj25;
                                                                obj40 = obj24;
                                                                obj39 = obj23;
                                                                obj38 = obj22;
                                                                i36 = i28;
                                                                StringBuilder sb822222222 = new StringBuilder();
                                                                obj69 = obj54;
                                                                sb822222222.append("sendData ssoseq:");
                                                                int i6722222222 = i19;
                                                                sb822222222.append(i6722222222);
                                                                sb822222222.append(", exception");
                                                                obj70 = obj53;
                                                                obj71 = obj52;
                                                                obj72 = obj51;
                                                                obj73 = obj50;
                                                                a(toServiceMsg, null, -1, sb822222222.toString(), dVar);
                                                                th.printStackTrace();
                                                                QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i6722222222 + " exception, ", th);
                                                                cVar.a();
                                                                cVar.d();
                                                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                if (this.f248375a.statReporter != null) {
                                                                }
                                                                if (z19) {
                                                                }
                                                                return z18;
                                                            }
                                                            try {
                                                                a(toServiceMsg, null, 4, sb10.toString(), dVar);
                                                                cVar.a();
                                                                cVar.d();
                                                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                                                                    HashMap hashMap7 = new HashMap();
                                                                    hashMap7.put(obj91, Boolean.toString(dVar.f249901a));
                                                                    hashMap7.put(obj90, Long.toString(dVar.f249902b));
                                                                    hashMap7.put(obj89, dVar.f249903c);
                                                                    hashMap7.put(obj88, dVar.f249904d);
                                                                    hashMap7.put(obj144, obj87);
                                                                    hashMap7.put(obj146, Integer.toString(dVar.f249905e));
                                                                    hashMap7.put(obj147, Integer.toString(dVar.f249906f));
                                                                    hashMap7.put(obj143, Long.toString(dVar.f249907g));
                                                                    hashMap7.put(obj145, Boolean.toString(dVar.f249909i));
                                                                    hashMap7.put(obj148, Long.toString(dVar.f249910j));
                                                                    hashMap7.put("connCount", Integer.toString(dVar.f249911k));
                                                                    hashMap7.put("connFailReason", dVar.f249913m);
                                                                    hashMap7.put("sendExcpt", dVar.f249908h);
                                                                    hashMap7.put("reIndex", "" + i28);
                                                                    hashMap7.put("msgReIndex", "" + i59);
                                                                    hashMap7.put(obj139, String.valueOf(z16));
                                                                    hashMap7.put("sendUseQuic", String.valueOf(z37));
                                                                    hashMap7.put("PARAM_failCode", String.valueOf(z16 ? 3 : z37 != 0 ? 5 : 1));
                                                                    hashMap7.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                                    this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap7, false, false);
                                                                }
                                                                return z18;
                                                            } catch (Throwable th27) {
                                                                th = th27;
                                                                i18 = i59;
                                                                str = "";
                                                                obj37 = obj148;
                                                                obj27 = "connCount";
                                                                obj26 = "connFailReason";
                                                                obj25 = "sendExcpt";
                                                                obj24 = "reIndex";
                                                                obj23 = "msgReIndex";
                                                                obj22 = obj139;
                                                                obj21 = obj145;
                                                                obj36 = obj143;
                                                                obj35 = obj147;
                                                                obj34 = obj146;
                                                                i28 = i28;
                                                                obj33 = obj144;
                                                                obj32 = obj91;
                                                                obj31 = obj88;
                                                                obj30 = obj89;
                                                                obj29 = obj87;
                                                                obj28 = obj90;
                                                                i29 = z37;
                                                                z19 = z18 ? 1 : 0;
                                                                obj54 = obj37;
                                                                obj53 = obj21;
                                                                obj52 = obj36;
                                                                obj51 = obj35;
                                                                obj50 = obj34;
                                                                obj49 = obj33;
                                                                obj48 = obj32;
                                                                obj47 = obj31;
                                                                obj46 = obj30;
                                                                obj45 = obj29;
                                                                obj44 = obj28;
                                                                z26 = i29;
                                                                obj43 = obj27;
                                                                obj42 = obj26;
                                                                obj41 = obj25;
                                                                obj40 = obj24;
                                                                obj39 = obj23;
                                                                obj38 = obj22;
                                                                i36 = i28;
                                                                StringBuilder sb8222222222 = new StringBuilder();
                                                                obj69 = obj54;
                                                                sb8222222222.append("sendData ssoseq:");
                                                                int i67222222222 = i19;
                                                                sb8222222222.append(i67222222222);
                                                                sb8222222222.append(", exception");
                                                                obj70 = obj53;
                                                                obj71 = obj52;
                                                                obj72 = obj51;
                                                                obj73 = obj50;
                                                                a(toServiceMsg, null, -1, sb8222222222.toString(), dVar);
                                                                th.printStackTrace();
                                                                QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i67222222222 + " exception, ", th);
                                                                cVar.a();
                                                                cVar.d();
                                                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                if (this.f248375a.statReporter != null) {
                                                                }
                                                                if (z19) {
                                                                }
                                                                return z18;
                                                            }
                                                        } catch (Throwable th28) {
                                                            th = th28;
                                                            obj126 = obj146;
                                                            i19 = i65;
                                                            i18 = i59;
                                                            str = "";
                                                            obj127 = "connCount";
                                                            obj128 = "connFailReason";
                                                            obj129 = "sendExcpt";
                                                            obj130 = "reIndex";
                                                            obj131 = "msgReIndex";
                                                            obj132 = obj139;
                                                            obj133 = obj147;
                                                        }
                                                    }
                                                } catch (Throwable th29) {
                                                    th = th29;
                                                    i19 = i65;
                                                    obj103 = obj148;
                                                    i28 = i28;
                                                    i18 = i59;
                                                    str = "";
                                                    obj27 = "connCount";
                                                    obj26 = "connFailReason";
                                                    obj25 = "sendExcpt";
                                                    obj24 = "reIndex";
                                                    obj23 = "msgReIndex";
                                                    obj22 = obj139;
                                                    obj37 = obj103;
                                                    obj21 = obj145;
                                                    obj36 = obj143;
                                                    obj35 = obj147;
                                                    obj34 = obj146;
                                                    obj33 = obj144;
                                                    obj32 = obj91;
                                                    obj31 = obj88;
                                                    obj30 = obj89;
                                                    obj29 = obj87;
                                                    obj28 = obj90;
                                                    i29 = z37;
                                                    z19 = z18 ? 1 : 0;
                                                    obj54 = obj37;
                                                    obj53 = obj21;
                                                    obj52 = obj36;
                                                    obj51 = obj35;
                                                    obj50 = obj34;
                                                    obj49 = obj33;
                                                    obj48 = obj32;
                                                    obj47 = obj31;
                                                    obj46 = obj30;
                                                    obj45 = obj29;
                                                    obj44 = obj28;
                                                    z26 = i29;
                                                    obj43 = obj27;
                                                    obj42 = obj26;
                                                    obj41 = obj25;
                                                    obj40 = obj24;
                                                    obj39 = obj23;
                                                    obj38 = obj22;
                                                    i36 = i28;
                                                    StringBuilder sb82222222222 = new StringBuilder();
                                                    obj69 = obj54;
                                                    sb82222222222.append("sendData ssoseq:");
                                                    int i672222222222 = i19;
                                                    sb82222222222.append(i672222222222);
                                                    sb82222222222.append(", exception");
                                                    obj70 = obj53;
                                                    obj71 = obj52;
                                                    obj72 = obj51;
                                                    obj73 = obj50;
                                                    a(toServiceMsg, null, -1, sb82222222222.toString(), dVar);
                                                    th.printStackTrace();
                                                    QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i672222222222 + " exception, ", th);
                                                    cVar.a();
                                                    cVar.d();
                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                    if (this.f248375a.statReporter != null) {
                                                    }
                                                    if (z19) {
                                                    }
                                                    return z18;
                                                }
                                            }
                                        } catch (Throwable th30) {
                                            th = th30;
                                            cVar = cVar2;
                                            i19 = i65;
                                            i28 = i28;
                                            i18 = i59;
                                            str = "";
                                            obj92 = "connCount";
                                            obj93 = "connFailReason";
                                            obj94 = "sendExcpt";
                                            obj95 = "reIndex";
                                            obj96 = "msgReIndex";
                                            obj97 = obj139;
                                            obj101 = "sendCosttime";
                                            obj98 = "isHttp";
                                            obj102 = obj140;
                                            obj99 = "datalen";
                                            obj100 = "sendFailReason";
                                            obj37 = obj141;
                                            obj21 = obj102;
                                            obj36 = obj101;
                                            obj35 = obj100;
                                            obj34 = obj99;
                                            obj33 = obj98;
                                            obj32 = obj91;
                                            obj31 = obj88;
                                            obj30 = obj89;
                                            obj29 = obj87;
                                            obj28 = obj90;
                                            i29 = z37;
                                            obj27 = obj92;
                                            obj26 = obj93;
                                            obj25 = obj94;
                                            obj24 = obj95;
                                            obj23 = obj96;
                                            obj22 = obj97;
                                            z19 = z18 ? 1 : 0;
                                            obj54 = obj37;
                                            obj53 = obj21;
                                            obj52 = obj36;
                                            obj51 = obj35;
                                            obj50 = obj34;
                                            obj49 = obj33;
                                            obj48 = obj32;
                                            obj47 = obj31;
                                            obj46 = obj30;
                                            obj45 = obj29;
                                            obj44 = obj28;
                                            z26 = i29;
                                            obj43 = obj27;
                                            obj42 = obj26;
                                            obj41 = obj25;
                                            obj40 = obj24;
                                            obj39 = obj23;
                                            obj38 = obj22;
                                            i36 = i28;
                                            StringBuilder sb822222222222 = new StringBuilder();
                                            obj69 = obj54;
                                            sb822222222222.append("sendData ssoseq:");
                                            int i6722222222222 = i19;
                                            sb822222222222.append(i6722222222222);
                                            sb822222222222.append(", exception");
                                            obj70 = obj53;
                                            obj71 = obj52;
                                            obj72 = obj51;
                                            obj73 = obj50;
                                            a(toServiceMsg, null, -1, sb822222222222.toString(), dVar);
                                            th.printStackTrace();
                                            QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i6722222222222 + " exception, ", th);
                                            cVar.a();
                                            cVar.d();
                                            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                            if (this.f248375a.statReporter != null) {
                                            }
                                            if (z19) {
                                            }
                                            return z18;
                                        }
                                    } catch (Throwable th31) {
                                        th = th31;
                                        i19 = i65;
                                        cVar = cVar2;
                                        i18 = i59;
                                        str = "";
                                        obj92 = "connCount";
                                        obj93 = "connFailReason";
                                        obj94 = "sendExcpt";
                                        obj95 = "reIndex";
                                        obj96 = "msgReIndex";
                                        obj97 = obj139;
                                        obj98 = "isHttp";
                                        obj99 = "datalen";
                                        obj100 = "sendFailReason";
                                        obj101 = "sendCosttime";
                                        obj102 = obj140;
                                    }
                                }
                            } catch (Throwable th32) {
                                th = th32;
                                obj46 = "account";
                                obj43 = "connCount";
                                obj52 = "sendCosttime";
                                i28 = i66;
                                obj41 = "sendExcpt";
                                obj42 = "connFailReason";
                                z19 = z18 ? 1 : 0;
                                i19 = i65;
                                cVar = cVar2;
                                obj54 = obj4;
                                obj45 = "1";
                                obj49 = "isHttp";
                                i18 = i59;
                                str = "";
                                obj40 = "reIndex";
                                obj39 = "msgReIndex";
                                obj38 = obj139;
                                obj48 = "isSucc";
                                obj50 = "datalen";
                                obj44 = "costtime";
                                obj51 = "sendFailReason";
                                obj47 = "cmd";
                                obj53 = obj3;
                                z26 = z37;
                            }
                        }
                        a16 = a(cVar2, e16, i65, dVar, str3, z27);
                        dVar.f249909i = a16;
                        if (a16) {
                        }
                    } catch (Throwable th33) {
                        th = th33;
                        obj25 = "sendExcpt";
                        obj26 = "connFailReason";
                        i28 = i39;
                        obj35 = "sendFailReason";
                        i19 = i65;
                        cVar = cVar2;
                        obj21 = obj3;
                        obj37 = obj4;
                        obj34 = "datalen";
                        obj33 = "isHttp";
                        obj36 = "sendCosttime";
                        i18 = i59;
                        str = "";
                        obj24 = "reIndex";
                        obj23 = "msgReIndex";
                        obj22 = obj139;
                        obj27 = "connCount";
                        obj32 = obj91;
                        obj31 = obj88;
                        obj30 = obj89;
                        obj29 = obj87;
                        obj28 = obj90;
                        i29 = z37;
                    }
                    str3 = "";
                    if (i66 != 1) {
                    }
                    obj87 = "1";
                    obj88 = "cmd";
                    obj89 = "account";
                    obj90 = "costtime";
                    obj91 = "isSucc";
                } catch (Throwable th34) {
                    th = th34;
                    obj74 = "account";
                    obj75 = "connCount";
                    obj76 = "sendCosttime";
                    i28 = i66;
                    obj77 = "sendExcpt";
                    obj78 = "connFailReason";
                    i19 = i65;
                    cVar = cVar2;
                    obj86 = obj4;
                    obj79 = "1";
                    obj83 = "isHttp";
                    i18 = i59;
                    str = "";
                    obj80 = "reIndex";
                    obj81 = "msgReIndex";
                    obj82 = obj139;
                    obj84 = "isSucc";
                    obj85 = "datalen";
                    obj14 = "costtime";
                    obj16 = "sendFailReason";
                    obj12 = "cmd";
                    obj20 = obj86;
                    obj10 = obj76;
                    obj19 = obj85;
                    obj11 = obj83;
                    obj15 = obj84;
                    obj13 = obj74;
                    obj18 = obj79;
                    i27 = z37;
                    obj5 = obj75;
                    obj9 = obj78;
                    obj8 = obj77;
                    obj7 = obj80;
                    obj6 = obj81;
                    obj17 = obj82;
                    obj21 = obj3;
                    obj37 = obj20;
                    obj36 = obj10;
                    obj35 = obj16;
                    obj34 = obj19;
                    obj33 = obj11;
                    obj32 = obj15;
                    obj31 = obj12;
                    obj30 = obj13;
                    obj29 = obj18;
                    obj28 = obj14;
                    i29 = i27;
                    obj27 = obj5;
                    obj26 = obj9;
                    obj25 = obj8;
                    obj24 = obj7;
                    obj23 = obj6;
                    obj22 = obj17;
                    z19 = z18 ? 1 : 0;
                    obj54 = obj37;
                    obj53 = obj21;
                    obj52 = obj36;
                    obj51 = obj35;
                    obj50 = obj34;
                    obj49 = obj33;
                    obj48 = obj32;
                    obj47 = obj31;
                    obj46 = obj30;
                    obj45 = obj29;
                    obj44 = obj28;
                    z26 = i29;
                    obj43 = obj27;
                    obj42 = obj26;
                    obj41 = obj25;
                    obj40 = obj24;
                    obj39 = obj23;
                    obj38 = obj22;
                    i36 = i28;
                    StringBuilder sb8222222222222 = new StringBuilder();
                    obj69 = obj54;
                    sb8222222222222.append("sendData ssoseq:");
                    int i67222222222222 = i19;
                    sb8222222222222.append(i67222222222222);
                    sb8222222222222.append(", exception");
                    obj70 = obj53;
                    obj71 = obj52;
                    obj72 = obj51;
                    obj73 = obj50;
                    a(toServiceMsg, null, -1, sb8222222222222.toString(), dVar);
                    th.printStackTrace();
                    QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i67222222222222 + " exception, ", th);
                    cVar.a();
                    cVar.d();
                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                    if (this.f248375a.statReporter != null) {
                    }
                    if (z19) {
                    }
                    return z18;
                }
            }
        } catch (Throwable th35) {
            th = th35;
            i18 = i3;
            i19 = i17;
            obj5 = "connCount";
            obj6 = "msgReIndex";
            obj7 = "reIndex";
            obj8 = "sendExcpt";
            obj9 = "connFailReason";
            obj10 = "sendCosttime";
            obj11 = "isHttp";
            obj12 = "cmd";
            obj13 = "account";
            obj14 = "costtime";
            obj15 = "isSucc";
            str = "";
            obj16 = "sendFailReason";
            z18 = z17;
            obj17 = obj2;
            obj18 = "1";
            cVar = cVar2;
            obj19 = "datalen";
            obj20 = obj4;
            i26 = 5;
            i27 = i48;
            i28 = i16;
        }
        i36 = i28;
        try {
            StringBuilder sb82222222222222 = new StringBuilder();
            obj69 = obj54;
        } catch (Throwable th36) {
            th = th36;
            obj55 = obj54;
            obj56 = obj50;
            i37 = i36;
        }
        try {
            sb82222222222222.append("sendData ssoseq:");
            int i672222222222222 = i19;
            sb82222222222222.append(i672222222222222);
            sb82222222222222.append(", exception");
            obj70 = obj53;
            obj71 = obj52;
            obj72 = obj51;
            obj73 = obj50;
        } catch (Throwable th37) {
            th = th37;
            obj56 = obj50;
            i37 = i36;
            obj55 = obj69;
            i38 = i18;
            str2 = str;
            obj57 = obj42;
            obj58 = obj41;
            obj59 = obj40;
            obj60 = obj39;
            obj61 = obj38;
            obj62 = obj53;
            obj63 = obj43;
            Object obj149 = obj51;
            obj64 = obj52;
            obj65 = obj149;
            obj67 = obj55;
            obj66 = obj56;
            cVar.a();
            cVar.d();
            Throwable th38 = th;
            obj68 = obj67;
            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
            if (this.f248375a.statReporter != null) {
                HashMap hashMap8 = new HashMap();
                hashMap8.put(obj48, Boolean.toString(dVar.f249901a));
                hashMap8.put(obj44, Long.toString(dVar.f249902b));
                hashMap8.put(obj46, dVar.f249903c);
                hashMap8.put(obj47, dVar.f249904d);
                hashMap8.put(obj49, obj45);
                hashMap8.put(obj66, Integer.toString(dVar.f249905e));
                hashMap8.put(obj65, Integer.toString(dVar.f249906f));
                hashMap8.put(obj64, Long.toString(dVar.f249907g));
                hashMap8.put(obj62, Boolean.toString(dVar.f249909i));
                hashMap8.put(obj68, Long.toString(dVar.f249910j));
                hashMap8.put(obj63, Integer.toString(dVar.f249911k));
                hashMap8.put(obj57, dVar.f249913m);
                hashMap8.put(obj58, dVar.f249908h);
                StringBuilder sb11 = new StringBuilder();
                String str5 = str2;
                sb11.append(str5);
                sb11.append(i37);
                hashMap8.put(obj59, sb11.toString());
                hashMap8.put(obj60, str5 + i38);
                hashMap8.put(obj61, String.valueOf(z16));
                hashMap8.put("sendUseQuic", String.valueOf(z26));
                hashMap8.put("PARAM_failCode", String.valueOf(z16 ? 3 : z26 != 0 ? i26 : 1));
                hashMap8.put(BaseConstants.RDM_NoChangeFailCode, str5);
                this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap8, false, false);
            }
            if (!z19) {
            }
        }
        try {
            a(toServiceMsg, null, -1, sb82222222222222.toString(), dVar);
            th.printStackTrace();
            QLog.d("LightSender", 1, "LightSender doSendData ssoseq:" + i672222222222222 + " exception, ", th);
            cVar.a();
            cVar.d();
            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
            if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                HashMap hashMap32 = new HashMap();
                hashMap32.put(obj48, Boolean.toString(dVar.f249901a));
                hashMap32.put(obj44, Long.toString(dVar.f249902b));
                hashMap32.put(obj46, dVar.f249903c);
                hashMap32.put(obj47, dVar.f249904d);
                hashMap32.put(obj49, obj45);
                hashMap32.put(obj73, Integer.toString(dVar.f249905e));
                hashMap32.put(obj72, Integer.toString(dVar.f249906f));
                hashMap32.put(obj71, Long.toString(dVar.f249907g));
                hashMap32.put(obj70, Boolean.toString(dVar.f249909i));
                hashMap32.put(obj69, Long.toString(dVar.f249910j));
                hashMap32.put(obj43, Integer.toString(dVar.f249911k));
                hashMap32.put(obj42, dVar.f249913m);
                hashMap32.put(obj41, dVar.f249908h);
                StringBuilder sb92 = new StringBuilder();
                String str42 = str;
                sb92.append(str42);
                sb92.append(i36);
                hashMap32.put(obj40, sb92.toString());
                hashMap32.put(obj39, str42 + i18);
                hashMap32.put(obj38, String.valueOf(z16));
                hashMap32.put("sendUseQuic", String.valueOf(z26));
                hashMap32.put("PARAM_failCode", String.valueOf(z16 ? 3 : z26 != 0 ? i26 : 1));
                hashMap32.put(BaseConstants.RDM_NoChangeFailCode, str42);
                this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap32, false, false);
            }
            if (z19) {
                this.f248376b.f().j(toServiceMsg, null, dVar);
            }
            return z18;
        } catch (Throwable th39) {
            th = th39;
            i38 = i18;
            str2 = str;
            obj63 = obj43;
            obj57 = obj42;
            obj58 = obj41;
            obj59 = obj40;
            obj60 = obj39;
            obj61 = obj38;
            i37 = i36;
            obj67 = obj69;
            obj62 = obj70;
            obj64 = obj71;
            obj65 = obj72;
            obj66 = obj73;
            cVar.a();
            cVar.d();
            Throwable th382 = th;
            obj68 = obj67;
            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
            if (this.f248375a.statReporter != null && this.f248376b.q() != null && this.f248376b.q().d(toServiceMsg)) {
                HashMap hashMap82 = new HashMap();
                hashMap82.put(obj48, Boolean.toString(dVar.f249901a));
                hashMap82.put(obj44, Long.toString(dVar.f249902b));
                hashMap82.put(obj46, dVar.f249903c);
                hashMap82.put(obj47, dVar.f249904d);
                hashMap82.put(obj49, obj45);
                hashMap82.put(obj66, Integer.toString(dVar.f249905e));
                hashMap82.put(obj65, Integer.toString(dVar.f249906f));
                hashMap82.put(obj64, Long.toString(dVar.f249907g));
                hashMap82.put(obj62, Boolean.toString(dVar.f249909i));
                hashMap82.put(obj68, Long.toString(dVar.f249910j));
                hashMap82.put(obj63, Integer.toString(dVar.f249911k));
                hashMap82.put(obj57, dVar.f249913m);
                hashMap82.put(obj58, dVar.f249908h);
                StringBuilder sb112 = new StringBuilder();
                String str52 = str2;
                sb112.append(str52);
                sb112.append(i37);
                hashMap82.put(obj59, sb112.toString());
                hashMap82.put(obj60, str52 + i38);
                hashMap82.put(obj61, String.valueOf(z16));
                hashMap82.put("sendUseQuic", String.valueOf(z26));
                hashMap82.put("PARAM_failCode", String.valueOf(z16 ? 3 : z26 != 0 ? i26 : 1));
                hashMap82.put(BaseConstants.RDM_NoChangeFailCode, str52);
                this.f248375a.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap82, false, false);
            }
            if (!z19) {
                this.f248376b.f().j(toServiceMsg, null, dVar);
                throw th382;
            }
            throw th382;
        }
    }

    private FromServiceMsg a(FromServiceMsg fromServiceMsg) {
        if ((fromServiceMsg.getFlag() & 1) != 0) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            if (wupBuffer.length > 4) {
                try {
                    int i3 = ((wupBuffer[0] & 255) << 24) | 0 | ((wupBuffer[1] & 255) << 16) | ((wupBuffer[2] & 255) << 8) | (wupBuffer[3] & 255);
                    byte[] bArr = new byte[i3];
                    System.arraycopy(wupBuffer, 4, bArr, 0, i3 - 4);
                    byte[] b16 = com.tencent.qphone.base.util.g.b(bArr);
                    byte[] bArr2 = new byte[b16.length + 4];
                    bArr2[0] = (byte) (((b16.length + 4) >> 24) & 255);
                    bArr2[1] = (byte) (((b16.length + 4) >> 16) & 255);
                    bArr2[2] = (byte) (((b16.length + 4) >> 8) & 255);
                    bArr2[3] = (byte) ((b16.length + 4) & 255);
                    System.arraycopy(b16, 0, bArr2, 4, b16.length);
                    fromServiceMsg.putWupBuffer(bArr2);
                } catch (Throwable th5) {
                    QLog.d("LightSender", 1, "LightSender uncompress data failed", th5);
                }
            }
            return null;
        }
        return fromServiceMsg;
    }

    private void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, String str, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        dVar.f249906f = i3;
        if (fromServiceMsg == null) {
            FromServiceMsg a16 = o.a(toServiceMsg);
            if (a16 != null) {
                a16.setBusinessFail(i3, str);
                this.f248376b.q().a(toServiceMsg, a16);
            }
        } else {
            this.f248376b.q().a(toServiceMsg, fromServiceMsg);
        }
        this.f248376b.f().j(toServiceMsg, fromServiceMsg, dVar);
    }

    private boolean a(com.tencent.mobileqq.msf.core.net.c cVar, String str, int i3, com.tencent.mobileqq.msf.core.quicksend.d dVar, String str2, boolean z16) {
        CopyOnWriteArrayList<d> a16;
        if (NetConnInfoCenter.isWifiConn()) {
            if (cVar.b()) {
                a16 = this.f248376b.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250390v, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
            } else {
                a16 = this.f248376b.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250389u, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
                CopyOnWriteArrayList<d> a17 = this.f248376b.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250389u, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
                if (dVar.f249912l && a17 != null && a17.size() > 0) {
                    a16 = a17;
                }
            }
        } else {
            a16 = cVar.b() ? this.f248376b.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250390v, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true) : this.f248376b.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250389u, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
        }
        if (z16) {
            a16 = a(a16, str2);
        }
        if (a16 != null) {
            Iterator<d> it = a16.iterator();
            while (it.hasNext()) {
                d next = it.next();
                cVar.a(next.f());
                long elapsedRealtime = SystemClock.elapsedRealtime();
                boolean a18 = cVar.a(next.b(), next.d(), str, dVar);
                dVar.f249911k++;
                if (a18) {
                    dVar.f249910j = SystemClock.elapsedRealtime() - elapsedRealtime;
                    return true;
                }
            }
            QLog.d("LightSender", 1, "LightSender connect all fail ssoseq:" + i3);
            return false;
        }
        QLog.d("LightSender", 1, "LightSender ssolist is empty ssoseq:" + i3);
        return false;
    }

    private CopyOnWriteArrayList<d> a(CopyOnWriteArrayList<d> copyOnWriteArrayList, String str) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0 || TextUtils.isEmpty(str)) {
            return copyOnWriteArrayList;
        }
        CopyOnWriteArrayList<d> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        Iterator<d> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next != null && str.equals(next.f247936m)) {
                copyOnWriteArrayList2.add(0, next);
            } else {
                copyOnWriteArrayList2.add(next);
            }
        }
        return copyOnWriteArrayList2;
    }
}
