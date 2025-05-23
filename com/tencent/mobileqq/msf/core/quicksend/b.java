package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.e0.f;
import com.tencent.mobileqq.msf.core.e0.h;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.u.a;
import com.tencent.mobileqq.msf.core.net.u.b.i;
import com.tencent.mobileqq.msf.core.v;
import com.tencent.mobileqq.msf.core.x.b;
import com.tencent.mobileqq.msf.core.x.e;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.RichMediaConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements com.tencent.mobileqq.msf.core.y.d, com.tencent.mobileqq.msf.core.y.c {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "tcp";
    public static final String B = "udp";
    public static final String C = "http";
    public static final String D = "failed";
    public static final Object E;
    public static final String F = "attr_is_msg_recv_reported";
    public static final Object G;
    public static final String H = "attr_is_msg_send_reported";
    public static final Object I;
    public static final int J = 3;
    public static final long K = 2000;
    private static final long L = 120000;
    private static final long M = 15000;
    private static long N = 0;

    /* renamed from: p, reason: collision with root package name */
    private static final String f249858p = "MSF.C.QuickSendManager";

    /* renamed from: q, reason: collision with root package name */
    public static final String f249859q = "key_beacon_weaknet_recv_report";

    /* renamed from: r, reason: collision with root package name */
    public static final String f249860r = "key_beacon_weaknet_send_report";

    /* renamed from: s, reason: collision with root package name */
    public static final String f249861s = "key_report_channel";

    /* renamed from: t, reason: collision with root package name */
    public static final String f249862t = "key_report_cmd";

    /* renamed from: u, reason: collision with root package name */
    public static final Object f249863u;

    /* renamed from: v, reason: collision with root package name */
    public static final String f249864v = "attr_quick_send";

    /* renamed from: w, reason: collision with root package name */
    public static final String f249865w = "attr_quick_send_resend_time";

    /* renamed from: x, reason: collision with root package name */
    public static final String f249866x = "attr_quick_send_time";

    /* renamed from: y, reason: collision with root package name */
    public static final String f249867y = "attr_quick_xg_send_resend_time";

    /* renamed from: z, reason: collision with root package name */
    public static final String f249868z = "attr_recv_by_channel";

    /* renamed from: a, reason: collision with root package name */
    private MsfCore f249869a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.net.u.a f249870b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.f0.d.a f249871c;

    /* renamed from: d, reason: collision with root package name */
    private final int f249872d;

    /* renamed from: e, reason: collision with root package name */
    private HashSet<String> f249873e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Integer, ToServiceMsg> f249874f;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<Long, AtomicBoolean> f249875g;

    /* renamed from: h, reason: collision with root package name */
    private long f249876h;

    /* renamed from: i, reason: collision with root package name */
    private volatile Handler f249877i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.mobileqq.msf.core.quicksend.c f249878j;

    /* renamed from: k, reason: collision with root package name */
    private f f249879k;

    /* renamed from: l, reason: collision with root package name */
    private long f249880l;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f249881m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f249882n;

    /* renamed from: o, reason: collision with root package name */
    Handler f249883o;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements b.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.x.b.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b.this.d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 1) {
                int i3 = message.arg1;
                b bVar = b.this;
                bVar.k((ToServiceMsg) bVar.f249874f.get(Integer.valueOf(i3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private ToServiceMsg f249887a;

        public d(ToServiceMsg toServiceMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) toServiceMsg);
            } else {
                this.f249887a = toServiceMsg;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f249887a == null) {
                QLog.d(b.f249858p, 1, "req null, return.");
                return;
            }
            try {
                if (b.this.f249871c.q() != null && b.this.f249871c.q().d(this.f249887a)) {
                    b.this.f249871c.q().f249878j.b(this.f249887a);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            b.this.b(this.f249887a);
            com.tencent.mobileqq.msf.core.quicksend.a stragegyArgs = QuickSendStrategy.getStragegyArgs(this.f249887a.getQuickSendStrategy());
            if (e.o().k() && stragegyArgs != null && stragegyArgs.f249857d) {
                b.this.c(e.o().l());
            }
            if (e.o().b()) {
                if (this.f249887a.getServiceCmd().equals(BaseConstants.CMD_MSG_PBSENDMSG) || this.f249887a.getServiceCmd().equals("MsgProxy.SendMsg")) {
                    d.c.b(this.f249887a);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19569);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f249863u = new Object();
        E = new Object();
        G = new Object();
        I = new Object();
    }

    public b(MsfCore msfCore, com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore, (Object) aVar);
            return;
        }
        this.f249872d = 1;
        this.f249873e = new HashSet<>();
        this.f249874f = new ConcurrentHashMap<>();
        this.f249875g = new ConcurrentHashMap<>();
        this.f249876h = 0L;
        this.f249878j = new com.tencent.mobileqq.msf.core.quicksend.c();
        this.f249879k = new f();
        this.f249880l = 0L;
        this.f249881m = new AtomicBoolean(true);
        this.f249882n = false;
        this.f249883o = new c();
        this.f249869a = msfCore;
        this.f249871c = aVar;
        this.f249870b = com.tencent.mobileqq.msf.core.net.u.a.a(this);
        this.f249874f.clear();
        com.tencent.mobileqq.msf.core.y.a.h().a((com.tencent.mobileqq.msf.core.y.d) this);
        com.tencent.mobileqq.msf.core.y.a.h().a((com.tencent.mobileqq.msf.core.y.c) this);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MsfCoreHttpTimeoutChecker", 5);
        baseHandlerThread.start();
        this.f249877i = new Handler(baseHandlerThread.getLooper());
        d();
        com.tencent.mobileqq.msf.core.x.b bVar = msfCore.configManager;
        if (bVar != null) {
            bVar.a(new a());
        }
        int a16 = com.tencent.mobileqq.msf.core.net.utils.e.a(0, 10);
        if (a16 < 1 || BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            this.f249882n = true;
        }
        a(h.a());
        QLog.d(f249858p, 1, "[shouldReportWeakNet] ", Boolean.valueOf(this.f249882n), ". result: ", Integer.valueOf(a16));
    }

    public static boolean e() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ToServiceMsg toServiceMsg) {
        this.f249870b.a(toServiceMsg, new C8097b());
    }

    private boolean j(ToServiceMsg toServiceMsg) {
        int i3;
        if (TextUtils.isEmpty(toServiceMsg.getServiceCmd())) {
            QLog.d(f249858p, 1, "tryResendMsg fail, cmd is null ");
            return false;
        }
        if (!toServiceMsg.isNeedCallback()) {
            QLog.d(f249858p, 1, "tryResendMsg fail, request don't need callback ");
            return false;
        }
        if (this.f249873e.contains(toServiceMsg.getServiceCmd())) {
            QLog.d(f249858p, 1, "tryResendMsg fail, refuse quick send cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " by blacklist");
            return false;
        }
        if (toServiceMsg.isQuickSendEnable() && QuickSendStrategy.getStragegyArgs(toServiceMsg.getQuickSendStrategy()) != null) {
            if (!this.f249874f.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
                QLog.d(f249858p, 1, "tryResendMsg fail, sendQueue don't contain msg, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq());
                return false;
            }
            if (toServiceMsg.getAttributes().containsKey(f249865w)) {
                i3 = ((Integer) toServiceMsg.getAttributes().get(f249865w)).intValue();
            } else {
                i3 = 0;
            }
            com.tencent.mobileqq.msf.core.quicksend.a stragegyArgs = QuickSendStrategy.getStragegyArgs(toServiceMsg.getQuickSendStrategy());
            if (i3 >= 0 && i3 <= stragegyArgs.f249856c) {
                int i16 = i3 + 1;
                toServiceMsg.getAttributes().put(f249865w, Integer.valueOf(i16));
                long j3 = stragegyArgs.f249855b;
                if (i3 < e.o().n()) {
                    j3 = e.o().m();
                }
                if (e.o().b() && i3 == 0 && (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_MSG_PBSENDMSG) || toServiceMsg.getServiceCmd().equals("MsgProxy.SendMsg"))) {
                    j3 = stragegyArgs.f249854a - 1000;
                }
                g();
                Message obtainMessage = this.f249883o.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.arg1 = toServiceMsg.getRequestSsoSeq();
                this.f249883o.sendMessageDelayed(obtainMessage, j3);
                if (QLog.isColorLevel()) {
                    QLog.d(f249858p, 2, "tryResendMsg cmd:" + toServiceMsg.getServiceCmd() + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " resendIndex: " + i16 + " delayed: " + stragegyArgs.f249855b);
                }
                return true;
            }
            QLog.d(f249858p, 1, "tryResendMsg fail, msg has resend " + i3 + " times, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + i3);
            return false;
        }
        QLog.d(f249858p, 1, "tryResendMsg fail, refuse quick send cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ToServiceMsg toServiceMsg) {
        if (toServiceMsg == null) {
            return;
        }
        if (!j(toServiceMsg)) {
            g(toServiceMsg);
            return;
        }
        this.f249871c.n().f(toServiceMsg);
        if (this.f249871c.o() != null && e() && this.f249869a.isWeakNet()) {
            this.f249871c.o().e(toServiceMsg);
        }
        if (i.a().b(toServiceMsg)) {
            MsfService.core.getStatReporter().a(g.f247732p3, true, 0L, 0L, (Map<String, String>) new TreeMap(), false, false);
            if (QLog.isDebugVersion()) {
                QLog.d("[ReportBeacon]", 1, "HttpSend.");
            }
        }
    }

    public Map<Integer, ToServiceMsg> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f249874f : (Map) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String[] s06 = com.tencent.mobileqq.msf.core.x.b.s0();
        if (s06 == null) {
            return;
        }
        for (String str : s06) {
            this.f249873e.add(str);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (com.tencent.mobileqq.msf.core.y.a.h().e()) {
            i();
        }
    }

    public synchronized void g(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg != null) {
            f(toServiceMsg);
            if (this.f249874f.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
                this.f249874f.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
            }
            if (this.f249871c.o() != null) {
                this.f249871c.o().c(toServiceMsg);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.c
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            this.f249881m.set(false);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else if (e() && com.tencent.mobileqq.msf.core.x.b.W0()) {
            a(30000);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.y.d
    public void onScreenOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (e() && com.tencent.mobileqq.msf.core.x.b.W0()) {
            a();
        }
        if (MsfSdkUtils.isScreenOn()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - N >= 15000) {
                N = uptimeMillis;
                try {
                    c(2000L);
                } catch (Throwable th5) {
                    QLog.d(f249858p, 1, th5.toString(), th5);
                }
            }
        }
    }

    private void h(ToServiceMsg toServiceMsg) {
        if (this.f249882n && toServiceMsg != null) {
            synchronized (I) {
                if (toServiceMsg.getAttributes().containsKey(H)) {
                    return;
                }
                toServiceMsg.addAttribute(H, Boolean.TRUE);
                HashMap hashMap = new HashMap();
                hashMap.put(f249862t, toServiceMsg.getServiceCmd());
                h.a(hashMap);
                MsfCore.sCore.statReporter.a(f249859q, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                QLog.d(f249858p, 1, "[reportWeakNetSend] msg: ", toServiceMsg.getStringForLog(), ", udp: ", hashMap.get(h.f247972f), ", subConn: ", hashMap.get(h.f247973g));
            }
        }
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
            return;
        }
        com.tencent.mobileqq.msf.core.e0.i r16 = this.f249871c.r();
        if (r16 == null) {
            return;
        }
        if (!b(j3)) {
            QLog.d(f249858p, 1, "quick heart beat has sending, timeout = " + j3 + ", so return.");
            return;
        }
        if (this.f249869a.isConnected()) {
            QLog.d(f249858p, 1, "sendQuickHeartBeat, timeout = " + j3);
            a(j3, true);
            ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", BaseConstants.CMD_HEARTBEATPING);
            toServiceMsg.setMsfCommand(MsfCommand._msf_QuickHeartBeat);
            toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.putWupBuffer(new byte[]{0, 0, 0, 4});
            toServiceMsg.setTimeout(j3);
            toServiceMsg.getAttributes().put("quickSendDetectTime", Long.valueOf(SystemClock.elapsedRealtime()));
            r16.j().g(toServiceMsg);
            return;
        }
        a(j3, false);
    }

    public boolean e(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        if (toServiceMsg == null) {
            return false;
        }
        return this.f249874f.contains(toServiceMsg) || (this.f249871c.o() != null && this.f249871c.o().b(toServiceMsg));
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z16 = elapsedRealtime - this.f249880l > 120000 && this.f249881m.compareAndSet(false, true);
        if (z16) {
            c(2000L);
            this.f249880l = elapsedRealtime;
        }
        QLog.d(f249858p, 1, "[sendQuickHeartbeatIfNeed] need: ", Boolean.valueOf(z16));
    }

    public void a(com.tencent.mobileqq.msf.core.e0.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f249879k.a(dVar);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        }
    }

    public com.tencent.mobileqq.msf.core.f0.d.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f249871c : (com.tencent.mobileqq.msf.core.f0.d.a) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public void f(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null || !toServiceMsg.getAttributes().containsKey(MsfConstants.ATTRIBUTE_MSGTIMEOUT_CALLBACKER)) {
            return;
        }
        QLog.d(f249858p, 1, "remove timoutchecker for msg");
        this.f249877i.removeCallbacks((Runnable) toServiceMsg.getAttributes().get(MsfConstants.ATTRIBUTE_MSGTIMEOUT_CALLBACKER));
        toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_MSGTIMEOUT_CALLBACKER);
    }

    public boolean a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3) {
        boolean containsKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, Integer.valueOf(i3))).booleanValue();
        }
        if (toServiceMsg == null && fromServiceMsg == null) {
            QLog.d(f249858p, 1, "handleHttpSsoResp msg is empty");
            return false;
        }
        if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_PUSHREQ)) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(fromServiceMsg.getWupBuffer());
            fromServiceMsg.getUin();
            this.f249871c.s().a((com.tencent.msf.service.protocol.serverconfig.f) uniPacket.getByClass("PushReq", new com.tencent.msf.service.protocol.serverconfig.f()));
            return false;
        }
        if (toServiceMsg == null) {
            return false;
        }
        synchronized (f249863u) {
            containsKey = toServiceMsg.getAttributes().containsKey(f249864v);
        }
        if (!containsKey) {
            return false;
        }
        synchronized (E) {
            if (toServiceMsg.getAttribute(f249868z) == null) {
                toServiceMsg.addAttribute(f249868z, "http");
            }
        }
        b(toServiceMsg, fromServiceMsg, i3);
        return true;
    }

    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (TextUtils.isEmpty(toServiceMsg.getServiceCmd())) {
            QLog.d(f249858p, 1, "addQuickSendQueue fail, cmd is null ");
            return;
        }
        if (!toServiceMsg.isNeedCallback()) {
            QLog.d(f249858p, 1, "addQuickSendQueue fail, request don't need callback ");
            return;
        }
        if (this.f249873e.contains(toServiceMsg.getServiceCmd())) {
            QLog.d(f249858p, 1, "addQuickSendQueue fail, refuse quick send cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " by blacklist");
            return;
        }
        if (toServiceMsg.isQuickSendEnable() && QuickSendStrategy.getStragegyArgs(toServiceMsg.getQuickSendStrategy()) != null) {
            if (this.f249874f.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
                QLog.d(f249858p, 1, "addQuickSendQueue fail, msg has quick send, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq());
                return;
            }
            if (com.tencent.mobileqq.msf.core.d0.a.c().a(toServiceMsg.getServiceCmd()) && !com.tencent.mobileqq.msf.core.d0.a.c().b()) {
                QLog.d(f249858p, 1, "addQuickSendQueue fail, refuse quick send cmd, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq() + "by FEKit-SDK not init");
                return;
            }
            synchronized (f249863u) {
                toServiceMsg.getAttributes().put(f249864v, Boolean.TRUE);
            }
            toServiceMsg.getAttributes().put(com.tencent.mobileqq.msf.core.h.f248374z, 1);
            toServiceMsg.getAttributes().put(f249865w, 0);
            toServiceMsg.addAttribute(f249866x, Long.valueOf(SystemClock.elapsedRealtime()));
            this.f249874f.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), toServiceMsg);
            k(toServiceMsg);
            i(toServiceMsg);
            h(toServiceMsg);
            return;
        }
        QLog.d(f249858p, 1, "addQuickSendQueue fail, refuse quick send cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " by quickSendStrategy error");
    }

    public boolean d(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        if (toServiceMsg == null) {
            return false;
        }
        if (c(toServiceMsg)) {
            toServiceMsg.setQuickSend(true, 1);
        }
        return (this.f249873e.contains(toServiceMsg.getServiceCmd()) || !toServiceMsg.isQuickSendEnable() || QuickSendStrategy.getStragegyArgs(toServiceMsg.getQuickSendStrategy()) == null) ? false : true;
    }

    public static void g() {
        if (e() && com.tencent.mobileqq.msf.core.x.b.W0() && MsfService.getCore().isWeakNet()) {
            NetConnInfoCenter.checkConnInfo();
            if (NetConnInfoCenter.isMobileConn()) {
                return;
            }
            m.b(BaseApplication.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.quicksend.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8097b implements a.InterfaceC8092a {
        static IPatchRedirector $redirector_;

        C8097b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.u.a.InterfaceC8092a
        public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
            boolean containsKey;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
                return;
            }
            QLog.d("MsfQuickUdpClient", 1, "[onMessageReceived] ", com.tencent.mobileqq.msf.core.z.a.a(fromServiceMsg));
            if (fromServiceMsg != null) {
                if (toServiceMsg != null) {
                    synchronized (b.f249863u) {
                        containsKey = toServiceMsg.getAttributes().containsKey(b.f249864v);
                    }
                    if (containsKey) {
                        synchronized (b.E) {
                            if (toServiceMsg.getAttribute(b.f249868z) == null) {
                                toServiceMsg.addAttribute(b.f249868z, b.B);
                            }
                        }
                    }
                }
                b.this.b(toServiceMsg, fromServiceMsg, -1);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.u.a.InterfaceC8092a
        public void a(ToServiceMsg toServiceMsg, Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) exc);
                return;
            }
            QLog.d("MsfQuickUdpClient", 1, "[onMessageFailure] ", toServiceMsg, ", error: ", exc);
            if (b.this.e(toServiceMsg)) {
                b.this.i(toServiceMsg);
                QLog.d("MsfQuickUdpClient", 1, "[onMessageFailure] resend msg: ", toServiceMsg);
            }
        }
    }

    public boolean c(ToServiceMsg toServiceMsg) {
        com.tencent.mobileqq.msf.core.quicksend.a stragegyArgs;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        if (toServiceMsg == null) {
            return false;
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if ((BaseConstants.CMD_MSG_PBSENDMSG.equals(serviceCmd) || "MsgProxy.SendMsg".equals(serviceCmd) || "ImgStore.GroupPicUp".equals(serviceCmd) || RichMediaConstants.CMD_LONGCONN_GROUPPIC_DOWN.equals(serviceCmd) || "LongConn.OffPicUp".equals(serviceCmd) || RichMediaConstants.CMD_LONGCONN_OFFPIC_DOWN.equals(serviceCmd)) && (stragegyArgs = QuickSendStrategy.getStragegyArgs(1)) != null) {
            if (stragegyArgs.f249854a < toServiceMsg.getTimeout()) {
                return !BaseConstants.CMD_MSG_PBSENDMSG.equals(toServiceMsg.getServiceCmd()) || toServiceMsg.getAttributes().containsKey("normal_msg");
            }
            QLog.d(f249858p, 1, "no try quicksend request ssoseq: " + toServiceMsg.getRequestSsoSeq() + " by timeout error");
        }
        return false;
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean containsKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg == null && fromServiceMsg == null) {
            QLog.d(f249858p, 1, "handleHttpSsoFailResp msg is empty");
            return;
        }
        synchronized (f249863u) {
            containsKey = toServiceMsg.getAttributes().containsKey(f249864v);
        }
        if (containsKey) {
            b(toServiceMsg, fromServiceMsg, -1);
        }
    }

    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, toServiceMsg, fromServiceMsg, Integer.valueOf(i3));
            return;
        }
        if (toServiceMsg == null) {
            QLog.d(f249858p, 1, "onRecvResp toMsg is null");
            return;
        }
        if (fromServiceMsg != null) {
            fromServiceMsg.addAttribute(BaseConstants.TIMESTAMP_NET2MSF, Long.valueOf(System.currentTimeMillis()));
            c(toServiceMsg, fromServiceMsg);
        }
        if (fromServiceMsg == null) {
            QLog.d(f249858p, 1, "onRecvResp quicksend fail, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " fromMsg is null");
        } else if (!fromServiceMsg.isSuccess()) {
            QLog.d(f249858p, 1, "onRecvResp quicksend fail, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " code: " + fromServiceMsg.getBusinessFailCode() + " failmsg: " + fromServiceMsg.getBusinessFailMsg());
            if (fromServiceMsg.getBusinessFailCode() == 2901) {
                g(toServiceMsg);
            }
        } else {
            if (this.f249874f.containsKey(Integer.valueOf(toServiceMsg.getRequestSsoSeq()))) {
                QLog.d(f249858p, 1, "onRecvResp quicksend succ, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq());
            } else {
                QLog.d(f249858p, 1, "onRecvResp quicksend succ occurred 2901, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq());
            }
            try {
                v.a(toServiceMsg, fromServiceMsg, true);
                this.f249871c.f().k(toServiceMsg, fromServiceMsg, true, 0);
                if (e.o().b()) {
                    d.c.d(toServiceMsg, fromServiceMsg, i3 == 1);
                }
                if (d(toServiceMsg)) {
                    this.f249878j.b(toServiceMsg, fromServiceMsg);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            g(toServiceMsg);
            fromServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_SEND_BY_QUICKHTTP, Boolean.TRUE);
            fromServiceMsg.setAppId(toServiceMsg.getAppId());
            fromServiceMsg.setAppSeq(toServiceMsg.getAppSeq());
            fromServiceMsg.setMsfCommand(toServiceMsg.getMsfCommand());
            this.f249869a.addRespToQuque(toServiceMsg, fromServiceMsg);
        }
        j jVar = this.f249869a.statReporter;
        if (jVar != null) {
            jVar.a("EvtQuickSend", fromServiceMsg != null && fromServiceMsg.isSuccess(), 0L, 0L, (Map<String, String>) new HashMap(), true, false);
        }
    }

    public boolean a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, j3)).booleanValue();
        }
        AtomicBoolean atomicBoolean = this.f249875g.get(Long.valueOf(j3));
        if (atomicBoolean == null) {
            atomicBoolean = new AtomicBoolean();
            this.f249875g.put(Long.valueOf(j3), atomicBoolean);
        }
        return atomicBoolean.get();
    }

    private void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean containsKey;
        if (toServiceMsg == null || fromServiceMsg == null) {
            return;
        }
        synchronized (f249863u) {
            containsKey = toServiceMsg.getAttributes().containsKey(f249864v);
        }
        if (containsKey) {
            int resultCode = fromServiceMsg.getResultCode();
            if (resultCode == 1000 || resultCode == 1002) {
                synchronized (G) {
                    if (toServiceMsg.getAttributes().containsKey(F)) {
                        return;
                    }
                    toServiceMsg.addAttribute(F, Boolean.TRUE);
                    Object attribute = toServiceMsg.getAttribute(f249868z);
                    String str = attribute instanceof String ? (String) attribute : "failed";
                    if ("http".equals(str) || B.equals(str)) {
                        this.f249879k.a(toServiceMsg, fromServiceMsg);
                    }
                    if (this.f249882n) {
                        String serviceCmd = toServiceMsg.getServiceCmd();
                        long elapsedRealtime = toServiceMsg.getAttributes().containsKey(f249866x) ? SystemClock.elapsedRealtime() - ((Long) toServiceMsg.getAttribute(f249866x)).longValue() : -1L;
                        HashMap hashMap = new HashMap();
                        hashMap.put(f249861s, str);
                        hashMap.put(f249862t, serviceCmd);
                        h.a(hashMap);
                        MsfCore.sCore.statReporter.a(f249860r, fromServiceMsg.getBusinessFailCode() == 1000, elapsedRealtime, 0L, (Map<String, String>) hashMap, false, false);
                        Object[] objArr = new Object[12];
                        objArr[0] = "[reportWeakNetRecv] channel: ";
                        objArr[1] = str;
                        objArr[2] = ", cost: ";
                        objArr[3] = Long.valueOf(elapsedRealtime);
                        objArr[4] = ", succ: ";
                        objArr[5] = Boolean.valueOf(fromServiceMsg.getBusinessFailCode() == 1000);
                        objArr[6] = ", msg: ";
                        objArr[7] = toServiceMsg.getStringForLog();
                        objArr[8] = ", udp: ";
                        objArr[9] = hashMap.get(h.f247972f);
                        objArr[10] = ", subConn: ";
                        objArr[11] = hashMap.get(h.f247973g);
                        QLog.d(f249858p, 1, objArr);
                    }
                }
            }
        }
    }

    private void a(@Nullable ToServiceMsg toServiceMsg, boolean z16) {
        if (toServiceMsg == null) {
            return;
        }
        a(toServiceMsg.getTimeout(), z16);
    }

    private void a(long j3, boolean z16) {
        AtomicBoolean atomicBoolean = this.f249875g.get(Long.valueOf(j3));
        if (atomicBoolean == null) {
            this.f249875g.put(Long.valueOf(j3), new AtomicBoolean(z16));
        } else {
            atomicBoolean.set(z16);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, toServiceMsg, fromServiceMsg, Boolean.valueOf(z16));
            return;
        }
        long j3 = 0;
        if (toServiceMsg != null && toServiceMsg.getAttributes().containsKey("quickSendDetectTime")) {
            long longValue = ((Long) toServiceMsg.getAttributes().get("quickSendDetectTime")).longValue();
            if (longValue > 0) {
                j3 = SystemClock.elapsedRealtime() - longValue;
            }
        }
        if (fromServiceMsg.getBusinessFailCode() == 1002) {
            if (QLog.isColorLevel()) {
                QLog.d(f249858p, 2, "handleQuickHeartbeat wait " + toServiceMsg + " timeout.");
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249858p, 2, "new conn has created, stop quick detectind");
                }
                a(toServiceMsg, false);
            } else if (!this.f249869a.isConnected()) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249858p, 2, "conn is also closed, stop quick detecting");
                }
                a(toServiceMsg, false);
                i3 = 1;
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime > this.f249876h + e.o().j()) {
                    this.f249876h = elapsedRealtime;
                    try {
                        try {
                            QLog.d(f249858p, 1, "handleQuickHeartbeat disconn: " + System.currentTimeMillis() + " mLastDetectDisconnTime:" + elapsedRealtime + " closeConn closeByNetDetectFailedNew");
                            this.f249869a.closeConn(com.tencent.qphone.base.a.closeByNetDetectFailedNew);
                            if (toServiceMsg != null) {
                                try {
                                    if (toServiceMsg.getTimeout() == 2000 && this.f249869a.getStatReporter() != null) {
                                        this.f249869a.getStatReporter().j();
                                    }
                                } catch (Exception e16) {
                                    e = e16;
                                    i3 = 2;
                                    QLog.d(f249858p, 1, "handleQuickHeartbeat disconn error", e);
                                    a(toServiceMsg, false);
                                    if (this.f249869a.statReporter == null) {
                                    }
                                }
                            }
                            a(toServiceMsg, false);
                            i3 = 2;
                        } catch (Exception e17) {
                            e = e17;
                            i3 = 0;
                        }
                    } catch (Throwable th5) {
                        a(toServiceMsg, false);
                        throw th5;
                    }
                } else {
                    a(toServiceMsg, false);
                    QLog.d(f249858p, 1, "handleQuickHeartbeat stop disconn by too frequency.");
                    i3 = 0;
                }
            }
        } else {
            QLog.d(f249858p, 1, "recv Quick heart resp.now conn is alive.");
            a(toServiceMsg, false);
            i3 = 0;
            z17 = true;
        }
        if (this.f249869a.statReporter == null) {
            HashMap hashMap = new HashMap();
            if (this.f249869a.getAccountCenter() != null) {
                hashMap.put("account", this.f249869a.getAccountCenter().e());
            } else {
                hashMap.put("account", com.tencent.mobileqq.msf.core.e0.i.i());
            }
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, "" + i3);
            hashMap.put("timeout", String.valueOf(toServiceMsg != null ? toServiceMsg.getTimeout() : -1L));
            boolean z18 = z17;
            long j16 = j3;
            this.f249869a.statReporter.a(g.K0, z18, j16, 0L, (Map<String, String>) hashMap, true, false);
            this.f249869a.statReporter.a(g.J0, z18, j16, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg.isQuickSendEnable()) {
            QLog.d(f249858p, 1, "onRecvNormalResp, cmd: " + toServiceMsg.getServiceCmd() + " ssoSeq: " + toServiceMsg.getRequestSsoSeq());
            g(toServiceMsg);
        }
        synchronized (E) {
            if (toServiceMsg.getAttribute(f249868z) == null) {
                toServiceMsg.addAttribute(f249868z, A);
            }
        }
        c(toServiceMsg, fromServiceMsg);
    }

    private boolean b(long j3) {
        AtomicBoolean atomicBoolean;
        for (Long l3 : this.f249875g.keySet()) {
            if (l3.longValue() < j3 && (atomicBoolean = this.f249875g.get(l3)) != null && atomicBoolean.get()) {
                return false;
            }
        }
        return !a(j3);
    }

    public boolean b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? this.f249874f.contains(Integer.valueOf(i3)) : ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, i3)).booleanValue();
    }

    public void a(ToServiceMsg toServiceMsg) {
        com.tencent.mobileqq.msf.core.quicksend.a stragegyArgs;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null || (stragegyArgs = QuickSendStrategy.getStragegyArgs(toServiceMsg.getQuickSendStrategy())) == null || stragegyArgs.f249854a < 1000) {
            return;
        }
        d dVar = new d(toServiceMsg);
        if (e.o().b()) {
            this.f249877i.postDelayed(dVar, 1000L);
        } else {
            this.f249877i.postDelayed(dVar, stragegyArgs.f249854a);
        }
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_MSGTIMEOUT_CALLBACKER, dVar);
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else if (this.f249871c.o() != null && com.tencent.mobileqq.msf.core.x.b.W0() && this.f249871c.o().d()) {
            this.f249871c.o().a(i3);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else if (this.f249871c.o() != null && com.tencent.mobileqq.msf.core.x.b.W0() && this.f249871c.o().d()) {
            this.f249871c.o().a();
        }
    }
}
