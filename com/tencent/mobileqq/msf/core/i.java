package com.tencent.mobileqq.msf.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_ = null;
    public static final int A = 2;
    public static final int B = 3;
    public static final int C = 4;
    public static final int D = 5;
    public static final int E = 6;

    /* renamed from: n, reason: collision with root package name */
    private static final String f248429n = "LightTcpSender";

    /* renamed from: o, reason: collision with root package name */
    public static final int f248430o = 1;

    /* renamed from: p, reason: collision with root package name */
    public static final int f248431p = 2;

    /* renamed from: q, reason: collision with root package name */
    public static final int f248432q = 3;

    /* renamed from: r, reason: collision with root package name */
    public static final String f248433r = "send_mode";

    /* renamed from: s, reason: collision with root package name */
    public static final int f248434s = 0;

    /* renamed from: t, reason: collision with root package name */
    public static final int f248435t = 1;

    /* renamed from: u, reason: collision with root package name */
    public static final String f248436u = "unknown";

    /* renamed from: v, reason: collision with root package name */
    public static final String f248437v = "pcactive";

    /* renamed from: w, reason: collision with root package name */
    public static final String f248438w = "quicksend";

    /* renamed from: x, reason: collision with root package name */
    public static final int f248439x = 0;

    /* renamed from: y, reason: collision with root package name */
    public static final int f248440y = -1;

    /* renamed from: z, reason: collision with root package name */
    public static final int f248441z = 1;

    /* renamed from: a, reason: collision with root package name */
    private Context f248442a;

    /* renamed from: b, reason: collision with root package name */
    private MsfCore f248443b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.msf.core.f0.d.a f248444c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f248445d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.msf.core.net.c f248446e;

    /* renamed from: f, reason: collision with root package name */
    Network f248447f;

    /* renamed from: g, reason: collision with root package name */
    boolean f248448g;

    /* renamed from: h, reason: collision with root package name */
    private int f248449h;

    /* renamed from: i, reason: collision with root package name */
    private int f248450i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f248451j;

    /* renamed from: k, reason: collision with root package name */
    boolean f248452k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedBlockingQueue<ToServiceMsg> f248453l;

    /* renamed from: m, reason: collision with root package name */
    private final a f248454m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends m.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.m.a
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.m.a
        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                i.this.f248447f = null;
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.m.a, android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                i.this.f248451j = false;
                i iVar = i.this;
                iVar.f248447f = network;
                iVar.f248445d.removeMessages(1);
                i.this.f248445d.sendMessageAtFrontOfQueue(i.this.f248445d.obtainMessage(2));
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
        }

        @Override // com.tencent.mobileqq.msf.core.net.m.a, android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) network, (Object) networkCapabilities);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.m.a, android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) network, (Object) linkProperties);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.m.a, android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) network, i3);
            }
        }

        @Override // com.tencent.mobileqq.msf.core.net.m.a, android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) network);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        public b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    if (i.this.f248451j) {
                        if (QLog.isColorLevel()) {
                            QLog.d(i.f248429n, 2, "Network is exit " + i.this.f248447f);
                            return;
                        }
                        return;
                    }
                    if (!i.this.d()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(i.f248429n, 2, "Network is closed " + i.this.f248447f);
                            return;
                        }
                        return;
                    }
                    while (!i.this.f248451j && i.this.f248453l.size() > 0) {
                        ToServiceMsg poll = i.this.f248453l.poll();
                        if (poll != null) {
                            com.tencent.mobileqq.msf.core.quicksend.d dVar = new com.tencent.mobileqq.msf.core.quicksend.d();
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            dVar.f249902b = elapsedRealtime;
                            dVar.f249910j = elapsedRealtime;
                            dVar.f249907g = elapsedRealtime;
                            String d16 = i.this.d(poll);
                            if (poll.getAttributes().containsKey("connIDC") && poll.getAttributes().get("connIDC") != null) {
                                str = (String) poll.getAttributes().get("connIDC");
                                if (QLog.isColorLevel()) {
                                    QLog.d(i.f248429n, 2, "sleectConnect ssoSeq:" + poll.getRequestSsoSeq() + " connIDC: " + str);
                                }
                            } else {
                                str = "";
                            }
                            if (i.this.c() || i.this.a(poll, dVar, d16, str)) {
                                i.this.a(dVar, poll);
                                if (!i.this.c()) {
                                    i.this.f248446e.a();
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            }
            try {
                try {
                    i.this.f248453l.clear();
                    i.this.f248446e.a();
                    i.this.f248446e.d();
                } catch (Exception e16) {
                    QLog.i(i.f248429n, 1, e16.getMessage(), e16);
                    e16.printStackTrace();
                }
            } finally {
                com.tencent.mobileqq.msf.core.net.m.c(i.this.f248442a);
            }
        }
    }

    public i(MsfCore msfCore, Context context, com.tencent.mobileqq.msf.core.f0.d.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msfCore, context, aVar);
            return;
        }
        this.f248445d = null;
        this.f248447f = null;
        this.f248448g = true;
        this.f248449h = 10000;
        this.f248450i = 30000;
        this.f248451j = false;
        this.f248452k = false;
        this.f248453l = new LinkedBlockingQueue<>(100);
        a aVar2 = new a();
        this.f248454m = aVar2;
        this.f248442a = context;
        this.f248443b = msfCore;
        this.f248444c = aVar;
        boolean z16 = new Random().nextInt(100) % 2 == 0 && com.tencent.mobileqq.msf.core.x.b.f1();
        this.f248452k = z16;
        if (!z16) {
            this.f248446e = new com.tencent.mobileqq.msf.core.net.h();
        } else {
            this.f248446e = new com.tencent.mobileqq.msf.core.net.g();
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(q.f249792g);
        baseHandlerThread.start();
        this.f248445d = new b(baseHandlerThread.getLooper());
        com.tencent.mobileqq.msf.core.net.m.a(aVar2);
    }

    public boolean e(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        if (!this.f248453l.contains(toServiceMsg)) {
            if (this.f248453l.offer(toServiceMsg)) {
                this.f248451j = false;
                this.f248445d.removeMessages(1);
                this.f248445d.sendEmptyMessage(2);
                if (QLog.isColorLevel()) {
                    QLog.i(f248429n, 2, "sendMsg size=" + this.f248453l.size());
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i(f248429n, 2, "sendMsg Queue Full size=" + this.f248453l.size());
                }
                return false;
            }
        }
        return true;
    }

    private byte b() {
        int networkType;
        Network network = this.f248447f;
        if (network == null) {
            return (byte) 0;
        }
        try {
            if (!com.tencent.mobileqq.msf.core.net.m.a(this.f248442a, network, 0)) {
                return com.tencent.mobileqq.msf.core.net.m.a(this.f248442a, network, 0) ? (byte) 1 : (byte) 0;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f248442a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return (byte) 0;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo != null) {
                networkType = NetworkMonitor.getSubtype(networkInfo);
            } else {
                networkType = NetworkMonitor.getNetworkType((TelephonyManager) BaseApplication.getContext().getSystemService("phone"));
            }
            int c16 = com.tencent.mobileqq.msf.sdk.m.c(networkType);
            if (c16 != 20) {
                c16 += 100;
            }
            if (c16 > 254) {
                if (QLog.isColorLevel()) {
                    QLog.d(f248429n, 2, "error,netWorkType is 254");
                }
                c16 = 254;
            }
            return (byte) c16;
        } catch (Exception e16) {
            e16.printStackTrace();
            return (byte) 0;
        }
    }

    public void c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) toServiceMsg);
            return;
        }
        this.f248453l.remove(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i(f248429n, 2, "removeMsg size=" + this.f248453l.size());
        }
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? com.tencent.mobileqq.msf.core.net.m.a(this.f248442a, this.f248447f, 0) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(ToServiceMsg toServiceMsg) {
        return (toServiceMsg == null || !toServiceMsg.isQuickSendEnable() || QuickSendStrategy.getStragegyArgs(toServiceMsg.getQuickSendStrategy()) == null) ? "unknown" : "quicksend";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return this.f248446e.c();
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.f248451j = true;
        this.f248445d.removeMessages(1);
        this.f248445d.sendEmptyMessageDelayed(1, i3);
        if (QLog.isColorLevel()) {
            QLog.i(f248429n, 2, "closeMobileNetwork");
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f248451j = false;
        this.f248445d.removeMessages(1);
        if (QLog.isColorLevel()) {
            QLog.i(f248429n, 2, "cancelToCloseMobilework");
        }
    }

    private boolean b(ToServiceMsg toServiceMsg, com.tencent.mobileqq.msf.core.quicksend.d dVar, String str, String str2) {
        CopyOnWriteArrayList<d> a16;
        if (NetConnInfoCenter.isWifiConn()) {
            if (this.f248446e.b()) {
                a16 = this.f248444c.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250390v, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
            } else {
                a16 = this.f248444c.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250389u, com.tencent.mobileqq.msf.core.x.q.f250391w, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
                CopyOnWriteArrayList<d> a17 = this.f248444c.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250389u, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
                if (this.f248448g && a17 != null && a17.size() > 0) {
                    a16 = a17;
                }
            }
        } else {
            a16 = this.f248446e.b() ? this.f248444c.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250390v, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true) : this.f248444c.s().a(q.c.a(com.tencent.mobileqq.msf.core.x.q.f250389u, com.tencent.mobileqq.msf.core.x.q.f250392x, com.tencent.mobileqq.msf.core.x.q.f250393y), true);
        }
        if (!TextUtils.isEmpty(str2)) {
            a16 = a(a16, str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f248429n, 2, "selectAndConnect sortedList: " + a16);
        }
        if (a16 != null) {
            Iterator<d> it = a16.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                d next = it.next();
                int f16 = next.f();
                this.f248449h = f16;
                this.f248446e.a(f16);
                this.f248446e.a(this.f248447f);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                boolean a18 = this.f248446e.a(next.b(), next.d(), str, dVar);
                dVar.f249911k++;
                dVar.f249910j = SystemClock.elapsedRealtime() - elapsedRealtime;
                dVar.f249909i = a18;
                if (!a18) {
                    if (QLog.isColorLevel()) {
                        QLog.i(f248429n, 2, "connect " + next.toString() + " fail");
                    }
                    z16 = a18;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i(f248429n, 2, "connect " + next.toString() + " ok");
                    }
                    return true;
                }
            }
            if (!z16) {
                dVar.f249907g = SystemClock.elapsedRealtime() - dVar.f249907g;
                a(toServiceMsg, (FromServiceMsg) null, 2, "selectAndConnect ssoseq:" + toServiceMsg.getRequestSsoSeq() + ", connect all failed", dVar);
            }
            return false;
        }
        QLog.w(f248429n, 1, "selectAndConnect ssolist is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0d73  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0e43  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0e52  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0e80  */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [int] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27, types: [int] */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v52 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.tencent.mobileqq.msf.core.quicksend.d dVar, ToServiceMsg toServiceMsg) {
        Object obj;
        Object obj2;
        int i3;
        int i16;
        ?? r56;
        int i17;
        Object obj3;
        int i18;
        int i19;
        Object obj4;
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
        Object obj16;
        Object obj17;
        Object obj18;
        String str;
        Object obj19;
        Object obj20;
        Object obj21;
        int i26;
        Object obj22;
        boolean z16;
        Object obj23;
        Object obj24;
        Object obj25;
        Object obj26;
        Object obj27;
        Object obj28;
        Object obj29;
        Object obj30;
        boolean z17;
        Object obj31;
        Object obj32;
        Object obj33;
        Object obj34;
        Object obj35;
        Object obj36;
        Object obj37;
        Object obj38;
        Object obj39;
        Object obj40;
        Object obj41;
        int i27;
        int i28;
        String str2;
        Object obj42;
        Object obj43;
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
        i iVar;
        ?? r46;
        Object obj55;
        Object obj56;
        Object obj57;
        Object obj58;
        Object obj59;
        ?? r47;
        byte[] a16;
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
        Object obj74;
        Object obj75;
        Object obj76;
        int i29;
        Object obj77;
        Object obj78;
        Object obj79;
        Object obj80;
        Object obj81;
        Object obj82;
        int i36;
        Object obj83;
        int i37;
        Object obj84;
        Object obj85;
        Object obj86;
        Object obj87;
        Object obj88;
        Object obj89;
        Object obj90;
        StringBuilder sb5;
        Object obj91;
        Object obj92;
        Object obj93;
        Object obj94;
        Object obj95;
        Object obj96;
        Object obj97;
        int i38;
        StringBuilder sb6;
        int i39;
        Object obj98;
        Object obj99;
        Object obj100;
        Object obj101;
        Object obj102;
        Object obj103;
        Object obj104;
        Object obj105;
        int i46;
        int i47;
        Object obj106;
        boolean z18;
        Integer num;
        Integer num2;
        if (toServiceMsg != null) {
            int requestSsoSeq = toServiceMsg.getRequestSsoSeq();
            int intValue = (!toServiceMsg.getAttributes().containsKey(com.tencent.mobileqq.msf.core.quicksend.b.f249865w) || (num2 = (Integer) toServiceMsg.getAttributes().get(com.tencent.mobileqq.msf.core.quicksend.b.f249865w)) == null) ? 0 : num2.intValue();
            if (!toServiceMsg.getAttributes().containsKey("retryIndex") || (num = (Integer) toServiceMsg.getAttributes().get("retryIndex")) == null) {
                obj106 = "connCount";
                i16 = intValue;
                z18 = false;
                i17 = -1;
            } else {
                i17 = num.intValue();
                obj106 = "connCount";
                i16 = intValue;
                z18 = false;
            }
            obj = "isConnSucc";
            i3 = requestSsoSeq;
            r56 = z18;
            obj2 = obj106;
        } else {
            obj = "isConnSucc";
            obj2 = "connCount";
            i3 = 0;
            i16 = 0;
            r56 = 0;
            i17 = -1;
        }
        dVar.f249901a = r56;
        dVar.f249912l = this.f248448g;
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (this.f248448g) {
            obj3 = "sendCosttime";
            toServiceMsg.getAttributes().put(com.tencent.mobileqq.msf.core.quicksend.b.f249867y, Integer.valueOf(((Integer) toServiceMsg.getAttribute(com.tencent.mobileqq.msf.core.quicksend.b.f249867y, Integer.valueOf((int) r56))).intValue() + 1));
        } else {
            obj3 = "sendCosttime";
        }
        if (QLog.isColorLevel()) {
            QLog.d(f248429n, 1, "trySendMsg cmd:" + serviceCmd + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " resendIndex:" + i16 + " usexg:" + (this.f248448g ? 1 : 0) + " quic:" + (this.f248452k ? 1 : 0) + " netType:" + NetConnInfoCenter.getActiveNetworkType());
        } else {
            QLog.d(f248429n, 1, "trySendMsg cmd=" + com.tencent.mobileqq.msf.core.z.a.a(serviceCmd) + " ssoSeq:" + toServiceMsg.getRequestSsoSeq() + " resendIndex:" + i16 + " usexg:" + (this.f248448g ? 1 : 0) + " quic:" + (this.f248452k ? 1 : 0) + " netType:" + NetConnInfoCenter.getActiveNetworkType());
        }
        this.f248444c.f().r(toServiceMsg);
        try {
            a16 = a(toServiceMsg);
        } catch (Throwable th5) {
            th = th5;
            i18 = i3;
            i19 = i16;
            obj4 = "connFailReason";
            obj5 = "PARAM_failCode";
            obj6 = "sendUseQuic";
            obj7 = "sendUseXG";
            obj8 = "msgReIndex";
            obj9 = "reIndex";
            obj10 = "sendExcpt";
            obj11 = "connCosttime";
            obj12 = "datalen";
            obj13 = "0";
            obj14 = "isHttp";
            obj15 = "cmd";
            obj16 = "account";
            obj17 = "costtime";
            obj18 = "isSucc";
            str = "";
            obj19 = obj;
            obj20 = obj2;
            obj21 = "sendFailReason";
            i26 = i17;
            obj22 = obj3;
            z16 = false;
        }
        try {
            try {
                try {
                    if (a16 == null) {
                        try {
                            Object obj107 = obj3;
                            int i48 = i3;
                            Object obj108 = obj;
                            int i49 = i16;
                            z16 = false;
                            Object obj109 = obj2;
                            try {
                                a(toServiceMsg, (FromServiceMsg) null, 1, "sendData ssoseq:" + i3 + ", send buffer is empty", dVar);
                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                if (this.f248443b.statReporter != null && this.f248444c.q() != null && this.f248444c.q().d(toServiceMsg)) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("isSucc", Boolean.toString(dVar.f249901a));
                                    hashMap.put("costtime", Long.toString(dVar.f249902b));
                                    hashMap.put("account", dVar.f249903c);
                                    hashMap.put("cmd", dVar.f249904d);
                                    hashMap.put("isHttp", "0");
                                    hashMap.put("datalen", Integer.toString(dVar.f249905e));
                                    hashMap.put("sendFailReason", Integer.toString(dVar.f249906f));
                                    hashMap.put(obj107, Long.toString(dVar.f249907g));
                                    hashMap.put(obj108, Boolean.toString(dVar.f249909i));
                                    hashMap.put("connCosttime", Long.toString(dVar.f249910j));
                                    hashMap.put(obj109, Integer.toString(dVar.f249911k));
                                    hashMap.put("connFailReason", dVar.f249913m);
                                    hashMap.put("sendExcpt", dVar.f249908h);
                                    hashMap.put("reIndex", "" + i49);
                                    hashMap.put("msgReIndex", "" + i17);
                                    hashMap.put("sendUseXG", String.valueOf(this.f248448g));
                                    hashMap.put("sendUseQuic", String.valueOf(this.f248452k));
                                    if (!dVar.f249901a) {
                                        i47 = 0;
                                    } else if (this.f248448g) {
                                        i47 = 4;
                                    } else {
                                        i47 = this.f248452k ? 6 : 2;
                                    }
                                    hashMap.put("PARAM_failCode", String.valueOf(i47));
                                    hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                                    this.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap, false, false);
                                }
                                return false;
                            } catch (Throwable th6) {
                                th = th6;
                                obj19 = obj108;
                                obj4 = "connFailReason";
                                obj7 = "sendUseXG";
                                obj8 = "msgReIndex";
                                obj9 = "reIndex";
                                obj10 = "sendExcpt";
                                obj6 = "sendUseQuic";
                                obj5 = "PARAM_failCode";
                                i26 = i17;
                                obj21 = "sendFailReason";
                                obj22 = obj107;
                                i18 = i48;
                                i19 = i49;
                                str = "";
                                obj18 = "isSucc";
                                obj17 = "costtime";
                                obj16 = "account";
                                obj15 = "cmd";
                                obj14 = "isHttp";
                                obj13 = "0";
                                obj12 = "datalen";
                                obj11 = "connCosttime";
                                obj20 = obj109;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            int i56 = i16;
                            z16 = false;
                            i18 = i3;
                            obj4 = "connFailReason";
                            obj7 = "sendUseXG";
                            obj8 = "msgReIndex";
                            obj9 = "reIndex";
                            obj10 = "sendExcpt";
                            obj12 = "datalen";
                            obj13 = "0";
                            obj14 = "isHttp";
                            obj15 = "cmd";
                            obj16 = "account";
                            obj17 = "costtime";
                            obj18 = "isSucc";
                            str = "";
                            obj19 = obj;
                            obj20 = obj2;
                            obj21 = "sendFailReason";
                            i26 = i17;
                            obj22 = obj3;
                            i19 = i56;
                            obj11 = "connCosttime";
                            obj6 = "sendUseQuic";
                            obj5 = "PARAM_failCode";
                        }
                    } else {
                        int i57 = i3;
                        int i58 = i16;
                        Object obj110 = obj;
                        Object obj111 = obj2;
                        int i59 = i17;
                        Object obj112 = obj3;
                        z16 = false;
                        try {
                            String d16 = d(toServiceMsg);
                            try {
                                dVar.f249903c = toServiceMsg.getUin();
                                dVar.f249904d = toServiceMsg.getServiceCmd();
                                dVar.f249905e = a16.length;
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                byte[] a17 = this.f248446e.a(toServiceMsg, a16, d16, dVar);
                                if (a17 == null) {
                                    try {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("sendData ssoseq:");
                                        try {
                                            sb7.append(i57);
                                            sb7.append(", recv data failed");
                                            Object obj113 = "cmd";
                                            Object obj114 = "isSucc";
                                            try {
                                                a(toServiceMsg, (FromServiceMsg) null, 3, sb7.toString(), dVar);
                                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                if (this.f248443b.statReporter != null && this.f248444c.q() != null && this.f248444c.q().d(toServiceMsg)) {
                                                    HashMap hashMap2 = new HashMap();
                                                    hashMap2.put(obj114, Boolean.toString(dVar.f249901a));
                                                    hashMap2.put("costtime", Long.toString(dVar.f249902b));
                                                    hashMap2.put("account", dVar.f249903c);
                                                    hashMap2.put(obj113, dVar.f249904d);
                                                    hashMap2.put("isHttp", "0");
                                                    hashMap2.put("datalen", Integer.toString(dVar.f249905e));
                                                    hashMap2.put("sendFailReason", Integer.toString(dVar.f249906f));
                                                    hashMap2.put(obj112, Long.toString(dVar.f249907g));
                                                    hashMap2.put(obj110, Boolean.toString(dVar.f249909i));
                                                    hashMap2.put("connCosttime", Long.toString(dVar.f249910j));
                                                    hashMap2.put(obj111, Integer.toString(dVar.f249911k));
                                                    hashMap2.put("connFailReason", dVar.f249913m);
                                                    hashMap2.put("sendExcpt", dVar.f249908h);
                                                    hashMap2.put("reIndex", "" + i58);
                                                    hashMap2.put("msgReIndex", "" + i59);
                                                    hashMap2.put("sendUseXG", String.valueOf(this.f248448g));
                                                    hashMap2.put("sendUseQuic", String.valueOf(this.f248452k));
                                                    if (!dVar.f249901a) {
                                                        i46 = 0;
                                                    } else if (this.f248448g) {
                                                        i46 = 4;
                                                    } else {
                                                        i46 = this.f248452k ? 6 : 2;
                                                    }
                                                    hashMap2.put("PARAM_failCode", String.valueOf(i46));
                                                    hashMap2.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                    this.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap2, false, false);
                                                }
                                                return false;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                obj40 = obj110;
                                                obj29 = "connFailReason";
                                                obj27 = "reIndex";
                                                obj28 = "sendExcpt";
                                                z17 = false;
                                                obj25 = "sendUseXG";
                                                obj26 = "msgReIndex";
                                                i19 = i58;
                                                i26 = i59;
                                                str = "";
                                                obj37 = "datalen";
                                                obj38 = "sendFailReason";
                                                obj39 = obj112;
                                                obj41 = "connCosttime";
                                                obj30 = obj111;
                                                obj24 = "sendUseQuic";
                                                obj23 = "PARAM_failCode";
                                                obj32 = "0";
                                                i18 = i57;
                                                obj35 = "isHttp";
                                                obj36 = "account";
                                                obj31 = "costtime";
                                                obj34 = obj113;
                                                obj33 = obj114;
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            obj98 = "sendUseXG";
                                            obj99 = "msgReIndex";
                                            obj100 = "cmd";
                                            obj101 = "isSucc";
                                            i18 = i57;
                                            obj102 = obj110;
                                            obj103 = "connFailReason";
                                            obj104 = "reIndex";
                                            obj105 = "sendExcpt";
                                            z17 = false;
                                            obj35 = "isHttp";
                                            obj32 = "0";
                                            i19 = i58;
                                            i26 = i59;
                                            str = "";
                                            obj37 = "datalen";
                                            obj41 = "connCosttime";
                                            obj30 = obj111;
                                            obj24 = "sendUseQuic";
                                            obj23 = "PARAM_failCode";
                                            obj26 = obj99;
                                            obj25 = obj98;
                                            obj36 = "account";
                                            obj31 = "costtime";
                                            obj38 = "sendFailReason";
                                            obj39 = obj112;
                                            obj40 = obj102;
                                            obj34 = obj100;
                                            obj33 = obj101;
                                            obj29 = obj103;
                                            obj28 = obj105;
                                            obj27 = obj104;
                                            i27 = i19;
                                            StringBuilder sb8 = new StringBuilder();
                                            obj55 = obj41;
                                            sb8.append("sendData ssoseq:");
                                            int i65 = i18;
                                            sb8.append(i65);
                                            sb8.append(", exception");
                                            obj56 = obj40;
                                            obj57 = obj39;
                                            obj58 = obj38;
                                            obj59 = obj37;
                                            a(toServiceMsg, (FromServiceMsg) null, -1, sb8.toString(), dVar);
                                            th.printStackTrace();
                                            QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i65 + " exception, ", th);
                                            dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                            if (this.f248443b.statReporter != null) {
                                            }
                                            if (z17) {
                                            }
                                            return z16;
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        obj98 = "sendUseXG";
                                        obj99 = "msgReIndex";
                                        obj100 = "cmd";
                                        obj101 = "isSucc";
                                        obj102 = obj110;
                                        obj103 = "connFailReason";
                                        obj104 = "reIndex";
                                        obj105 = "sendExcpt";
                                        z17 = false;
                                        i18 = i57;
                                    }
                                } else {
                                    i19 = i58;
                                    Object obj115 = "cmd";
                                    Object obj116 = "isSucc";
                                    try {
                                        try {
                                            dVar.f249907g = SystemClock.elapsedRealtime() - elapsedRealtime;
                                            FromServiceMsg nativeParseData = CodecWarpper.nativeParseData(a17);
                                            if (nativeParseData != null) {
                                                try {
                                                    FromServiceMsg a18 = a(nativeParseData);
                                                    if (a18 == null) {
                                                        try {
                                                            StringBuilder sb9 = new StringBuilder();
                                                            sb9.append("sendData ssoseq:");
                                                            try {
                                                                sb9.append(i57);
                                                                sb9.append(", recv data failed");
                                                                Object obj117 = "0";
                                                                Object obj118 = "costtime";
                                                                try {
                                                                    a(toServiceMsg, (FromServiceMsg) null, 5, sb9.toString(), dVar);
                                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                    if (this.f248443b.statReporter != null && this.f248444c.q() != null && this.f248444c.q().d(toServiceMsg)) {
                                                                        HashMap hashMap3 = new HashMap();
                                                                        hashMap3.put(obj116, Boolean.toString(dVar.f249901a));
                                                                        hashMap3.put(obj118, Long.toString(dVar.f249902b));
                                                                        hashMap3.put("account", dVar.f249903c);
                                                                        hashMap3.put(obj115, dVar.f249904d);
                                                                        hashMap3.put("isHttp", obj117);
                                                                        hashMap3.put("datalen", Integer.toString(dVar.f249905e));
                                                                        hashMap3.put("sendFailReason", Integer.toString(dVar.f249906f));
                                                                        hashMap3.put(obj112, Long.toString(dVar.f249907g));
                                                                        hashMap3.put(obj110, Boolean.toString(dVar.f249909i));
                                                                        hashMap3.put("connCosttime", Long.toString(dVar.f249910j));
                                                                        hashMap3.put(obj111, Integer.toString(dVar.f249911k));
                                                                        hashMap3.put("connFailReason", dVar.f249913m);
                                                                        hashMap3.put("sendExcpt", dVar.f249908h);
                                                                        hashMap3.put("reIndex", "" + i19);
                                                                        hashMap3.put("msgReIndex", "" + i59);
                                                                        hashMap3.put("sendUseXG", String.valueOf(this.f248448g));
                                                                        hashMap3.put("sendUseQuic", String.valueOf(this.f248452k));
                                                                        if (!dVar.f249901a) {
                                                                            i38 = 0;
                                                                        } else if (this.f248448g) {
                                                                            i38 = 4;
                                                                        } else {
                                                                            i38 = this.f248452k ? 6 : 2;
                                                                        }
                                                                        hashMap3.put("PARAM_failCode", String.valueOf(i38));
                                                                        hashMap3.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                                        this.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap3, false, false);
                                                                    }
                                                                    return false;
                                                                } catch (Throwable th11) {
                                                                    th = th11;
                                                                    obj19 = obj110;
                                                                    obj4 = "connFailReason";
                                                                    obj10 = "sendExcpt";
                                                                    obj9 = "reIndex";
                                                                    i26 = i59;
                                                                    str = "";
                                                                    obj21 = "sendFailReason";
                                                                    obj22 = obj112;
                                                                    obj11 = "connCosttime";
                                                                    obj20 = obj111;
                                                                    obj8 = "msgReIndex";
                                                                    obj7 = "sendUseXG";
                                                                    obj6 = "sendUseQuic";
                                                                    obj5 = "PARAM_failCode";
                                                                    i19 = i19;
                                                                    i18 = i57;
                                                                    obj12 = "datalen";
                                                                    obj14 = "isHttp";
                                                                    obj16 = "account";
                                                                    obj15 = obj115;
                                                                    obj18 = obj116;
                                                                    obj13 = obj117;
                                                                    obj17 = obj118;
                                                                }
                                                            } catch (Throwable th12) {
                                                                th = th12;
                                                                obj91 = "reIndex";
                                                                obj92 = "sendExcpt";
                                                                obj93 = "0";
                                                                obj94 = "costtime";
                                                                i18 = i57;
                                                                obj95 = obj110;
                                                                obj96 = "connFailReason";
                                                                z17 = false;
                                                                i19 = i19;
                                                                obj97 = "datalen";
                                                                i26 = i59;
                                                                str = "";
                                                                obj41 = "connCosttime";
                                                                obj30 = obj111;
                                                                obj26 = "msgReIndex";
                                                                obj25 = "sendUseXG";
                                                                obj24 = "sendUseQuic";
                                                                obj23 = "PARAM_failCode";
                                                                obj28 = obj92;
                                                                obj27 = obj91;
                                                                obj35 = "isHttp";
                                                                obj36 = "account";
                                                                obj38 = "sendFailReason";
                                                                obj39 = obj112;
                                                                obj40 = obj95;
                                                                obj37 = obj97;
                                                                obj34 = obj115;
                                                                obj33 = obj116;
                                                                obj32 = obj93;
                                                                obj31 = obj94;
                                                                obj29 = obj96;
                                                                i27 = i19;
                                                                StringBuilder sb82 = new StringBuilder();
                                                                obj55 = obj41;
                                                                sb82.append("sendData ssoseq:");
                                                                int i652 = i18;
                                                                sb82.append(i652);
                                                                sb82.append(", exception");
                                                                obj56 = obj40;
                                                                obj57 = obj39;
                                                                obj58 = obj38;
                                                                obj59 = obj37;
                                                                a(toServiceMsg, (FromServiceMsg) null, -1, sb82.toString(), dVar);
                                                                th.printStackTrace();
                                                                QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i652 + " exception, ", th);
                                                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                if (this.f248443b.statReporter != null) {
                                                                }
                                                                if (z17) {
                                                                }
                                                                return z16;
                                                            }
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                            obj91 = "reIndex";
                                                            obj92 = "sendExcpt";
                                                            obj93 = "0";
                                                            obj94 = "costtime";
                                                            obj95 = obj110;
                                                            obj96 = "connFailReason";
                                                            z17 = false;
                                                            i19 = i19;
                                                            obj97 = "datalen";
                                                            i18 = i57;
                                                        }
                                                    } else {
                                                        i19 = i19;
                                                        Object obj119 = "0";
                                                        Object obj120 = "costtime";
                                                        try {
                                                            a18.setRequestSsoSeq(a18.getAppSeq());
                                                            try {
                                                                a18.getAttributes().put(MsfConstants.ATTR_QUICK_SEND_BY_XG, Boolean.valueOf(this.f248448g));
                                                                a18.setAppSeq(toServiceMsg.getAppSeq());
                                                                a18.setMsfCommand(toServiceMsg.getMsfCommand());
                                                                a18.setAppId(toServiceMsg.getAppId());
                                                                a18.setRequestSsoSeq(toServiceMsg.getRequestSsoSeq());
                                                                toServiceMsg.getAttributes().put(MsfConstants.ATTR_QUICK_SEND_BY_XG, Boolean.valueOf(this.f248448g));
                                                                z17 = this.f248444c.q().a(toServiceMsg, a18, i19);
                                                                if (z17) {
                                                                    i29 = i19;
                                                                    obj77 = "isHttp";
                                                                    obj78 = obj110;
                                                                    obj79 = "connFailReason";
                                                                    obj80 = "sendFailReason";
                                                                    obj81 = obj112;
                                                                    obj82 = "datalen";
                                                                    i36 = i57;
                                                                    obj83 = "account";
                                                                } else {
                                                                    try {
                                                                        sb5 = new StringBuilder();
                                                                        sb5.append("sendData ssoseq:");
                                                                    } catch (Throwable th14) {
                                                                        th = th14;
                                                                        obj84 = "account";
                                                                        obj85 = "isHttp";
                                                                        obj86 = "connFailReason";
                                                                        obj87 = obj110;
                                                                        obj88 = "sendFailReason";
                                                                        obj89 = obj112;
                                                                        obj90 = "datalen";
                                                                        i18 = i57;
                                                                    }
                                                                    try {
                                                                        sb5.append(i57);
                                                                        sb5.append(", recv new ssolist");
                                                                        i36 = i57;
                                                                        obj81 = obj112;
                                                                        obj79 = "connFailReason";
                                                                        obj80 = "sendFailReason";
                                                                        i29 = i19;
                                                                        obj82 = "datalen";
                                                                        obj77 = "isHttp";
                                                                        obj78 = obj110;
                                                                        obj83 = "account";
                                                                        try {
                                                                            a(toServiceMsg, (FromServiceMsg) null, 6, sb5.toString(), dVar);
                                                                            obj83 = obj83;
                                                                            obj80 = obj80;
                                                                            obj79 = obj79;
                                                                            obj78 = obj78;
                                                                            obj81 = obj81;
                                                                            obj82 = obj82;
                                                                            obj77 = obj77;
                                                                        } catch (Throwable th15) {
                                                                            th = th15;
                                                                            obj38 = obj80;
                                                                            obj29 = obj79;
                                                                            obj40 = obj78;
                                                                            i26 = i59;
                                                                            str = "";
                                                                            obj41 = "connCosttime";
                                                                            obj30 = obj111;
                                                                            obj28 = "sendExcpt";
                                                                            obj27 = "reIndex";
                                                                            obj26 = "msgReIndex";
                                                                            obj25 = "sendUseXG";
                                                                            obj24 = "sendUseQuic";
                                                                            obj23 = "PARAM_failCode";
                                                                            i18 = i36;
                                                                            obj39 = obj81;
                                                                            i19 = i29;
                                                                            obj37 = obj82;
                                                                            obj35 = obj77;
                                                                            obj36 = obj83;
                                                                            obj34 = obj115;
                                                                            obj33 = obj116;
                                                                            obj32 = obj119;
                                                                            obj31 = obj120;
                                                                        }
                                                                    } catch (Throwable th16) {
                                                                        th = th16;
                                                                        obj84 = "account";
                                                                        i18 = i57;
                                                                        obj85 = "isHttp";
                                                                        obj86 = "connFailReason";
                                                                        obj87 = obj110;
                                                                        obj88 = "sendFailReason";
                                                                        obj89 = obj112;
                                                                        obj90 = "datalen";
                                                                        i26 = i59;
                                                                        str = "";
                                                                        obj41 = "connCosttime";
                                                                        obj30 = obj111;
                                                                        obj28 = "sendExcpt";
                                                                        obj27 = "reIndex";
                                                                        obj26 = "msgReIndex";
                                                                        obj25 = "sendUseXG";
                                                                        obj24 = "sendUseQuic";
                                                                        obj23 = "PARAM_failCode";
                                                                        obj40 = obj87;
                                                                        obj39 = obj89;
                                                                        obj38 = obj88;
                                                                        obj37 = obj90;
                                                                        obj36 = obj84;
                                                                        obj35 = obj85;
                                                                        obj34 = obj115;
                                                                        obj33 = obj116;
                                                                        obj32 = obj119;
                                                                        obj31 = obj120;
                                                                        obj29 = obj86;
                                                                        i27 = i19;
                                                                        StringBuilder sb822 = new StringBuilder();
                                                                        obj55 = obj41;
                                                                        sb822.append("sendData ssoseq:");
                                                                        int i6522 = i18;
                                                                        sb822.append(i6522);
                                                                        sb822.append(", exception");
                                                                        obj56 = obj40;
                                                                        obj57 = obj39;
                                                                        obj58 = obj38;
                                                                        obj59 = obj37;
                                                                        a(toServiceMsg, (FromServiceMsg) null, -1, sb822.toString(), dVar);
                                                                        th.printStackTrace();
                                                                        QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i6522 + " exception, ", th);
                                                                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                        if (this.f248443b.statReporter != null) {
                                                                        }
                                                                        if (z17) {
                                                                        }
                                                                        return z16;
                                                                    }
                                                                }
                                                                dVar.f249901a = true;
                                                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                                if (this.f248443b.statReporter != null && this.f248444c.q() != null && this.f248444c.q().d(toServiceMsg)) {
                                                                    HashMap hashMap4 = new HashMap();
                                                                    hashMap4.put(obj116, Boolean.toString(dVar.f249901a));
                                                                    hashMap4.put(obj120, Long.toString(dVar.f249902b));
                                                                    hashMap4.put(obj83, dVar.f249903c);
                                                                    hashMap4.put(obj115, dVar.f249904d);
                                                                    hashMap4.put(obj77, obj119);
                                                                    hashMap4.put(obj82, Integer.toString(dVar.f249905e));
                                                                    hashMap4.put(obj80, Integer.toString(dVar.f249906f));
                                                                    hashMap4.put(obj81, Long.toString(dVar.f249907g));
                                                                    hashMap4.put(obj78, Boolean.toString(dVar.f249909i));
                                                                    hashMap4.put("connCosttime", Long.toString(dVar.f249910j));
                                                                    hashMap4.put(obj111, Integer.toString(dVar.f249911k));
                                                                    hashMap4.put(obj79, dVar.f249913m);
                                                                    hashMap4.put("sendExcpt", dVar.f249908h);
                                                                    hashMap4.put("reIndex", "" + i29);
                                                                    hashMap4.put("msgReIndex", "" + i59);
                                                                    hashMap4.put("sendUseXG", String.valueOf(this.f248448g));
                                                                    hashMap4.put("sendUseQuic", String.valueOf(this.f248452k));
                                                                    if (!dVar.f249901a) {
                                                                        i37 = 0;
                                                                    } else if (this.f248448g) {
                                                                        i37 = 4;
                                                                    } else {
                                                                        i37 = this.f248452k ? 6 : 2;
                                                                    }
                                                                    hashMap4.put("PARAM_failCode", String.valueOf(i37));
                                                                    hashMap4.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                                    this.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap4, false, false);
                                                                }
                                                                if (!z17) {
                                                                    return true;
                                                                }
                                                                this.f248444c.f().j(toServiceMsg, null, dVar);
                                                                return true;
                                                            } catch (Throwable th17) {
                                                                th = th17;
                                                                obj40 = obj110;
                                                                obj36 = "account";
                                                                obj35 = "isHttp";
                                                                z17 = false;
                                                                obj38 = "sendFailReason";
                                                                obj39 = obj112;
                                                                obj37 = "datalen";
                                                                i18 = i57;
                                                                i26 = i59;
                                                                str = "";
                                                                obj41 = "connCosttime";
                                                                obj30 = obj111;
                                                                obj28 = "sendExcpt";
                                                                obj27 = "reIndex";
                                                                obj26 = "msgReIndex";
                                                                obj25 = "sendUseXG";
                                                                obj24 = "sendUseQuic";
                                                                obj23 = "PARAM_failCode";
                                                                obj29 = "connFailReason";
                                                                obj34 = obj115;
                                                                obj33 = obj116;
                                                                obj32 = obj119;
                                                                obj31 = obj120;
                                                            }
                                                        } catch (Throwable th18) {
                                                            th = th18;
                                                            obj40 = obj110;
                                                            obj36 = "account";
                                                            obj37 = "datalen";
                                                            z17 = false;
                                                            obj39 = obj112;
                                                            i18 = i57;
                                                            i26 = i59;
                                                            str = "";
                                                            obj41 = "connCosttime";
                                                            obj30 = obj111;
                                                            obj28 = "sendExcpt";
                                                            obj27 = "reIndex";
                                                            obj26 = "msgReIndex";
                                                            obj25 = "sendUseXG";
                                                            obj24 = "sendUseQuic";
                                                            obj23 = "PARAM_failCode";
                                                            obj29 = "connFailReason";
                                                            obj35 = "isHttp";
                                                            obj38 = "sendFailReason";
                                                            obj34 = obj115;
                                                            obj33 = obj116;
                                                            obj32 = obj119;
                                                            obj31 = obj120;
                                                        }
                                                    }
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    obj32 = "0";
                                                    obj31 = "costtime";
                                                    obj40 = obj110;
                                                    obj36 = "account";
                                                    obj35 = "isHttp";
                                                    z17 = false;
                                                    i19 = i19;
                                                    obj37 = "datalen";
                                                    i18 = i57;
                                                    i26 = i59;
                                                    str = "";
                                                    obj38 = "sendFailReason";
                                                    obj39 = obj112;
                                                    obj41 = "connCosttime";
                                                    obj30 = obj111;
                                                    obj26 = "msgReIndex";
                                                    obj25 = "sendUseXG";
                                                    obj24 = "sendUseQuic";
                                                    obj23 = "PARAM_failCode";
                                                    obj29 = "connFailReason";
                                                    obj28 = "sendExcpt";
                                                    obj27 = "reIndex";
                                                    obj34 = obj115;
                                                    obj33 = obj116;
                                                }
                                            } else {
                                                i19 = i19;
                                                Object obj121 = "connCosttime";
                                                Object obj122 = "0";
                                                Object obj123 = "costtime";
                                                Object obj124 = obj110;
                                                Object obj125 = "account";
                                                Object obj126 = obj112;
                                                try {
                                                    sb6 = new StringBuilder();
                                                } catch (Throwable th20) {
                                                    th = th20;
                                                }
                                                try {
                                                    sb6.append("sendData ssoseq:");
                                                    try {
                                                        sb6.append(i57);
                                                    } catch (Throwable th21) {
                                                        th = th21;
                                                        i18 = i57;
                                                    }
                                                } catch (Throwable th22) {
                                                    th = th22;
                                                    i19 = i19;
                                                    i18 = i57;
                                                    i26 = i59;
                                                    str = "";
                                                    obj20 = obj111;
                                                    obj4 = "connFailReason";
                                                    obj10 = "sendExcpt";
                                                    obj9 = "reIndex";
                                                    obj8 = "msgReIndex";
                                                    obj7 = "sendUseXG";
                                                    obj6 = "sendUseQuic";
                                                    obj5 = "PARAM_failCode";
                                                    obj12 = "datalen";
                                                    obj21 = "sendFailReason";
                                                    obj14 = "isHttp";
                                                    obj11 = obj121;
                                                    obj19 = obj124;
                                                    obj22 = obj126;
                                                    obj16 = obj125;
                                                    obj15 = obj115;
                                                    obj18 = obj116;
                                                    obj13 = obj122;
                                                    obj17 = obj123;
                                                    z17 = z16;
                                                    obj41 = obj11;
                                                    obj40 = obj19;
                                                    obj39 = obj22;
                                                    obj38 = obj21;
                                                    obj37 = obj12;
                                                    obj36 = obj16;
                                                    obj35 = obj14;
                                                    obj34 = obj15;
                                                    obj33 = obj18;
                                                    obj32 = obj13;
                                                    obj31 = obj17;
                                                    obj30 = obj20;
                                                    obj29 = obj4;
                                                    obj28 = obj10;
                                                    obj27 = obj9;
                                                    obj26 = obj8;
                                                    obj25 = obj7;
                                                    obj24 = obj6;
                                                    obj23 = obj5;
                                                    i27 = i19;
                                                    StringBuilder sb8222 = new StringBuilder();
                                                    obj55 = obj41;
                                                    sb8222.append("sendData ssoseq:");
                                                    int i65222 = i18;
                                                    sb8222.append(i65222);
                                                    sb8222.append(", exception");
                                                    obj56 = obj40;
                                                    obj57 = obj39;
                                                    obj58 = obj38;
                                                    obj59 = obj37;
                                                    a(toServiceMsg, (FromServiceMsg) null, -1, sb8222.toString(), dVar);
                                                    th.printStackTrace();
                                                    QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i65222 + " exception, ", th);
                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                    if (this.f248443b.statReporter != null) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    return z16;
                                                }
                                                try {
                                                    sb6.append(", parse data failed");
                                                    i18 = i57;
                                                    Object obj127 = "isHttp";
                                                    try {
                                                        a(toServiceMsg, (FromServiceMsg) null, 4, sb6.toString(), dVar);
                                                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                        if (this.f248443b.statReporter != null && this.f248444c.q() != null && this.f248444c.q().d(toServiceMsg)) {
                                                            HashMap hashMap5 = new HashMap();
                                                            hashMap5.put(obj116, Boolean.toString(dVar.f249901a));
                                                            hashMap5.put(obj123, Long.toString(dVar.f249902b));
                                                            hashMap5.put(obj125, dVar.f249903c);
                                                            hashMap5.put(obj115, dVar.f249904d);
                                                            hashMap5.put(obj127, obj122);
                                                            hashMap5.put("datalen", Integer.toString(dVar.f249905e));
                                                            hashMap5.put("sendFailReason", Integer.toString(dVar.f249906f));
                                                            hashMap5.put(obj126, Long.toString(dVar.f249907g));
                                                            hashMap5.put(obj124, Boolean.toString(dVar.f249909i));
                                                            hashMap5.put(obj121, Long.toString(dVar.f249910j));
                                                            hashMap5.put(obj111, Integer.toString(dVar.f249911k));
                                                            hashMap5.put("connFailReason", dVar.f249913m);
                                                            hashMap5.put("sendExcpt", dVar.f249908h);
                                                            hashMap5.put("reIndex", "" + i19);
                                                            hashMap5.put("msgReIndex", "" + i59);
                                                            hashMap5.put("sendUseXG", String.valueOf(this.f248448g));
                                                            hashMap5.put("sendUseQuic", String.valueOf(this.f248452k));
                                                            if (!dVar.f249901a) {
                                                                i39 = 0;
                                                            } else if (this.f248448g) {
                                                                i39 = 4;
                                                            } else {
                                                                i39 = this.f248452k ? 6 : 2;
                                                            }
                                                            hashMap5.put("PARAM_failCode", String.valueOf(i39));
                                                            hashMap5.put(BaseConstants.RDM_NoChangeFailCode, "");
                                                            this.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap5, false, false);
                                                        }
                                                        return false;
                                                    } catch (Throwable th23) {
                                                        th = th23;
                                                        obj21 = "sendFailReason";
                                                        i26 = i59;
                                                        str = "";
                                                        obj20 = obj111;
                                                        obj4 = "connFailReason";
                                                        obj10 = "sendExcpt";
                                                        obj9 = "reIndex";
                                                        obj8 = "msgReIndex";
                                                        obj7 = "sendUseXG";
                                                        obj6 = "sendUseQuic";
                                                        obj5 = "PARAM_failCode";
                                                        i19 = i19;
                                                        obj11 = obj121;
                                                        obj19 = obj124;
                                                        obj22 = obj126;
                                                        obj12 = "datalen";
                                                        obj16 = obj125;
                                                        obj14 = obj127;
                                                        obj15 = obj115;
                                                        obj18 = obj116;
                                                        obj13 = obj122;
                                                        obj17 = obj123;
                                                    }
                                                } catch (Throwable th24) {
                                                    th = th24;
                                                    i18 = i57;
                                                    i19 = i19;
                                                    i26 = i59;
                                                    str = "";
                                                    obj20 = obj111;
                                                    obj4 = "connFailReason";
                                                    obj10 = "sendExcpt";
                                                    obj9 = "reIndex";
                                                    obj8 = "msgReIndex";
                                                    obj7 = "sendUseXG";
                                                    obj6 = "sendUseQuic";
                                                    obj5 = "PARAM_failCode";
                                                    obj12 = "datalen";
                                                    obj21 = "sendFailReason";
                                                    obj14 = "isHttp";
                                                    obj11 = obj121;
                                                    obj19 = obj124;
                                                    obj22 = obj126;
                                                    obj16 = obj125;
                                                    obj15 = obj115;
                                                    obj18 = obj116;
                                                    obj13 = obj122;
                                                    obj17 = obj123;
                                                    z17 = z16;
                                                    obj41 = obj11;
                                                    obj40 = obj19;
                                                    obj39 = obj22;
                                                    obj38 = obj21;
                                                    obj37 = obj12;
                                                    obj36 = obj16;
                                                    obj35 = obj14;
                                                    obj34 = obj15;
                                                    obj33 = obj18;
                                                    obj32 = obj13;
                                                    obj31 = obj17;
                                                    obj30 = obj20;
                                                    obj29 = obj4;
                                                    obj28 = obj10;
                                                    obj27 = obj9;
                                                    obj26 = obj8;
                                                    obj25 = obj7;
                                                    obj24 = obj6;
                                                    obj23 = obj5;
                                                    i27 = i19;
                                                    StringBuilder sb82222 = new StringBuilder();
                                                    obj55 = obj41;
                                                    sb82222.append("sendData ssoseq:");
                                                    int i652222 = i18;
                                                    sb82222.append(i652222);
                                                    sb82222.append(", exception");
                                                    obj56 = obj40;
                                                    obj57 = obj39;
                                                    obj58 = obj38;
                                                    obj59 = obj37;
                                                    a(toServiceMsg, (FromServiceMsg) null, -1, sb82222.toString(), dVar);
                                                    th.printStackTrace();
                                                    QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i652222 + " exception, ", th);
                                                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                                    if (this.f248443b.statReporter != null) {
                                                    }
                                                    if (z17) {
                                                    }
                                                    return z16;
                                                }
                                            }
                                        } catch (Throwable th25) {
                                            th = th25;
                                            obj4 = "connFailReason";
                                            obj9 = "reIndex";
                                            obj10 = "sendExcpt";
                                            i19 = i19;
                                            i18 = i57;
                                            i26 = i59;
                                            str = "";
                                            obj11 = "connCosttime";
                                            obj20 = obj111;
                                            obj8 = "msgReIndex";
                                            obj7 = "sendUseXG";
                                            obj6 = "sendUseQuic";
                                            obj5 = "PARAM_failCode";
                                            obj13 = "0";
                                            obj14 = "isHttp";
                                            obj17 = "costtime";
                                            obj19 = obj110;
                                            obj12 = "datalen";
                                            obj22 = obj112;
                                            obj16 = "account";
                                            obj21 = "sendFailReason";
                                            obj15 = obj115;
                                            obj18 = obj116;
                                        }
                                    } catch (Throwable th26) {
                                        th = th26;
                                        obj4 = "connFailReason";
                                        obj9 = "reIndex";
                                        obj10 = "sendExcpt";
                                        i18 = i57;
                                        i26 = i59;
                                        str = "";
                                        obj20 = obj111;
                                        obj8 = "msgReIndex";
                                        obj7 = "sendUseXG";
                                        obj6 = "sendUseQuic";
                                        obj5 = "PARAM_failCode";
                                        obj13 = "0";
                                        obj14 = "isHttp";
                                        obj17 = "costtime";
                                        obj19 = obj110;
                                        obj22 = obj112;
                                        obj12 = "datalen";
                                        obj16 = "account";
                                        obj21 = "sendFailReason";
                                        obj11 = "connCosttime";
                                        obj15 = obj115;
                                        obj18 = obj116;
                                    }
                                }
                            } catch (Throwable th27) {
                                th = th27;
                                obj60 = "connFailReason";
                                obj61 = "sendUseXG";
                                obj62 = "msgReIndex";
                                obj63 = "reIndex";
                                obj64 = "sendExcpt";
                                i18 = i57;
                                obj69 = "isHttp";
                                obj65 = "0";
                                i19 = i58;
                                i26 = i59;
                                str = "";
                                obj76 = "connCosttime";
                                obj66 = obj111;
                                obj67 = "sendUseQuic";
                                obj68 = "PARAM_failCode";
                                obj70 = "cmd";
                                obj71 = "costtime";
                                obj72 = "isSucc";
                                obj73 = obj110;
                                obj74 = "datalen";
                                obj75 = "sendFailReason";
                                obj16 = "account";
                                obj22 = obj112;
                                obj11 = obj76;
                                obj19 = obj73;
                                obj21 = obj75;
                                obj12 = obj74;
                                obj14 = obj69;
                                obj15 = obj70;
                                obj18 = obj72;
                                obj13 = obj65;
                                obj17 = obj71;
                                obj20 = obj66;
                                obj4 = obj60;
                                obj10 = obj64;
                                obj9 = obj63;
                                obj8 = obj62;
                                obj7 = obj61;
                                obj6 = obj67;
                                obj5 = obj68;
                                z17 = z16;
                                obj41 = obj11;
                                obj40 = obj19;
                                obj39 = obj22;
                                obj38 = obj21;
                                obj37 = obj12;
                                obj36 = obj16;
                                obj35 = obj14;
                                obj34 = obj15;
                                obj33 = obj18;
                                obj32 = obj13;
                                obj31 = obj17;
                                obj30 = obj20;
                                obj29 = obj4;
                                obj28 = obj10;
                                obj27 = obj9;
                                obj26 = obj8;
                                obj25 = obj7;
                                obj24 = obj6;
                                obj23 = obj5;
                                i27 = i19;
                                StringBuilder sb822222 = new StringBuilder();
                                obj55 = obj41;
                                sb822222.append("sendData ssoseq:");
                                int i6522222 = i18;
                                sb822222.append(i6522222);
                                sb822222.append(", exception");
                                obj56 = obj40;
                                obj57 = obj39;
                                obj58 = obj38;
                                obj59 = obj37;
                                a(toServiceMsg, (FromServiceMsg) null, -1, sb822222.toString(), dVar);
                                th.printStackTrace();
                                QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i6522222 + " exception, ", th);
                                dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                                if (this.f248443b.statReporter != null) {
                                }
                                if (z17) {
                                }
                                return z16;
                            }
                        } catch (Throwable th28) {
                            th = th28;
                            obj60 = "connFailReason";
                            obj61 = "sendUseXG";
                            obj62 = "msgReIndex";
                            obj63 = "reIndex";
                            obj64 = "sendExcpt";
                            i18 = i57;
                            obj65 = "0";
                            i19 = i58;
                            i26 = i59;
                            str = "";
                            obj66 = obj111;
                            obj67 = "sendUseQuic";
                            obj68 = "PARAM_failCode";
                            obj69 = "isHttp";
                            obj70 = "cmd";
                            obj71 = "costtime";
                            obj72 = "isSucc";
                            obj73 = obj110;
                            obj74 = "datalen";
                            obj75 = "sendFailReason";
                            obj76 = "connCosttime";
                        }
                        i27 = i19;
                        StringBuilder sb8222222 = new StringBuilder();
                        obj55 = obj41;
                        sb8222222.append("sendData ssoseq:");
                        int i65222222 = i18;
                        sb8222222.append(i65222222);
                        sb8222222.append(", exception");
                        obj56 = obj40;
                        obj57 = obj39;
                        obj58 = obj38;
                        obj59 = obj37;
                        a(toServiceMsg, (FromServiceMsg) null, -1, sb8222222.toString(), dVar);
                        th.printStackTrace();
                        QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i65222222 + " exception, ", th);
                        dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                        if (this.f248443b.statReporter != null && this.f248444c.q() != null && this.f248444c.q().d(toServiceMsg)) {
                            HashMap hashMap6 = new HashMap();
                            hashMap6.put(obj33, Boolean.toString(dVar.f249901a));
                            hashMap6.put(obj31, Long.toString(dVar.f249902b));
                            hashMap6.put(obj36, dVar.f249903c);
                            hashMap6.put(obj34, dVar.f249904d);
                            hashMap6.put(obj35, obj32);
                            hashMap6.put(obj59, Integer.toString(dVar.f249905e));
                            hashMap6.put(obj58, Integer.toString(dVar.f249906f));
                            hashMap6.put(obj57, Long.toString(dVar.f249907g));
                            hashMap6.put(obj56, Boolean.toString(dVar.f249909i));
                            hashMap6.put(obj55, Long.toString(dVar.f249910j));
                            hashMap6.put(obj30, Integer.toString(dVar.f249911k));
                            hashMap6.put(obj29, dVar.f249913m);
                            hashMap6.put(obj28, dVar.f249908h);
                            StringBuilder sb10 = new StringBuilder();
                            String str3 = str;
                            sb10.append(str3);
                            sb10.append(i27);
                            hashMap6.put(obj27, sb10.toString());
                            hashMap6.put(obj26, str3 + i26);
                            hashMap6.put(obj25, String.valueOf(this.f248448g));
                            hashMap6.put(obj24, String.valueOf(this.f248452k));
                            if (dVar.f249901a) {
                                r47 = z16;
                            } else if (this.f248448g) {
                                r47 = 4;
                            } else {
                                r47 = this.f248452k ? 6 : 2;
                            }
                            hashMap6.put(obj23, String.valueOf((int) r47));
                            hashMap6.put(BaseConstants.RDM_NoChangeFailCode, str3);
                            this.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap6, false, false);
                        }
                        if (z17) {
                            this.f248444c.f().j(toServiceMsg, null, dVar);
                        }
                        return z16;
                    }
                    a(toServiceMsg, (FromServiceMsg) null, -1, sb8222222.toString(), dVar);
                    th.printStackTrace();
                    QLog.d(f248429n, 1, "LightSender doSendData ssoseq:" + i65222222 + " exception, ", th);
                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                    if (this.f248443b.statReporter != null) {
                        HashMap hashMap62 = new HashMap();
                        hashMap62.put(obj33, Boolean.toString(dVar.f249901a));
                        hashMap62.put(obj31, Long.toString(dVar.f249902b));
                        hashMap62.put(obj36, dVar.f249903c);
                        hashMap62.put(obj34, dVar.f249904d);
                        hashMap62.put(obj35, obj32);
                        hashMap62.put(obj59, Integer.toString(dVar.f249905e));
                        hashMap62.put(obj58, Integer.toString(dVar.f249906f));
                        hashMap62.put(obj57, Long.toString(dVar.f249907g));
                        hashMap62.put(obj56, Boolean.toString(dVar.f249909i));
                        hashMap62.put(obj55, Long.toString(dVar.f249910j));
                        hashMap62.put(obj30, Integer.toString(dVar.f249911k));
                        hashMap62.put(obj29, dVar.f249913m);
                        hashMap62.put(obj28, dVar.f249908h);
                        StringBuilder sb102 = new StringBuilder();
                        String str32 = str;
                        sb102.append(str32);
                        sb102.append(i27);
                        hashMap62.put(obj27, sb102.toString());
                        hashMap62.put(obj26, str32 + i26);
                        hashMap62.put(obj25, String.valueOf(this.f248448g));
                        hashMap62.put(obj24, String.valueOf(this.f248452k));
                        if (dVar.f249901a) {
                        }
                        hashMap62.put(obj23, String.valueOf((int) r47));
                        hashMap62.put(BaseConstants.RDM_NoChangeFailCode, str32);
                        this.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap62, false, false);
                    }
                    if (z17) {
                    }
                    return z16;
                } catch (Throwable th29) {
                    th = th29;
                    i28 = i26;
                    str2 = str;
                    obj42 = obj30;
                    obj43 = obj29;
                    obj44 = obj28;
                    obj45 = obj27;
                    obj46 = obj26;
                    obj47 = obj25;
                    obj48 = obj24;
                    obj49 = obj23;
                    i27 = i27;
                    obj50 = obj55;
                    obj52 = obj56;
                    obj54 = obj57;
                    obj53 = obj58;
                    obj51 = obj59;
                    Throwable th30 = th;
                    Object obj128 = obj42;
                    dVar.f249902b = SystemClock.elapsedRealtime() - dVar.f249902b;
                    if (this.f248443b.statReporter == null || this.f248444c.q() == null || !this.f248444c.q().d(toServiceMsg)) {
                        iVar = this;
                    } else {
                        HashMap hashMap7 = new HashMap();
                        hashMap7.put(obj33, Boolean.toString(dVar.f249901a));
                        hashMap7.put(obj31, Long.toString(dVar.f249902b));
                        hashMap7.put(obj36, dVar.f249903c);
                        hashMap7.put(obj34, dVar.f249904d);
                        hashMap7.put(obj35, obj32);
                        hashMap7.put(obj51, Integer.toString(dVar.f249905e));
                        hashMap7.put(obj53, Integer.toString(dVar.f249906f));
                        hashMap7.put(obj54, Long.toString(dVar.f249907g));
                        hashMap7.put(obj52, Boolean.toString(dVar.f249909i));
                        hashMap7.put(obj50, Long.toString(dVar.f249910j));
                        hashMap7.put(obj128, Integer.toString(dVar.f249911k));
                        hashMap7.put(obj43, dVar.f249913m);
                        hashMap7.put(obj44, dVar.f249908h);
                        StringBuilder sb11 = new StringBuilder();
                        String str4 = str2;
                        sb11.append(str4);
                        sb11.append(i27);
                        hashMap7.put(obj45, sb11.toString());
                        hashMap7.put(obj46, str4 + i28);
                        iVar = this;
                        hashMap7.put(obj47, String.valueOf(iVar.f248448g));
                        hashMap7.put(obj48, String.valueOf(iVar.f248452k));
                        if (!dVar.f249901a) {
                            r46 = z16;
                        } else if (iVar.f248448g) {
                            r46 = 4;
                        } else {
                            r46 = iVar.f248452k ? 6 : 2;
                        }
                        hashMap7.put(obj49, String.valueOf((int) r46));
                        hashMap7.put(BaseConstants.RDM_NoChangeFailCode, str4);
                        iVar.f248443b.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.I0, dVar.f249901a, dVar.f249902b, 0L, (Map<String, String>) hashMap7, false, false);
                    }
                    if (z17) {
                        iVar.f248444c.f().j(toServiceMsg, null, dVar);
                        throw th30;
                    }
                    throw th30;
                }
                sb8222222.append("sendData ssoseq:");
                int i652222222 = i18;
                sb8222222.append(i652222222);
                sb8222222.append(", exception");
                obj56 = obj40;
                obj57 = obj39;
                obj58 = obj38;
                obj59 = obj37;
            } catch (Throwable th31) {
                th = th31;
                obj51 = obj37;
                obj50 = obj55;
                i28 = i26;
                str2 = str;
                obj42 = obj30;
                obj43 = obj29;
                obj44 = obj28;
                obj45 = obj27;
                obj46 = obj26;
                obj47 = obj25;
                obj48 = obj24;
                obj49 = obj23;
                Object obj129 = obj38;
                obj52 = obj40;
                obj53 = obj129;
                obj54 = obj39;
            }
            StringBuilder sb82222222 = new StringBuilder();
            obj55 = obj41;
        } catch (Throwable th32) {
            th = th32;
            i28 = i26;
            str2 = str;
            obj42 = obj30;
            obj43 = obj29;
            obj44 = obj28;
            obj45 = obj27;
            obj46 = obj26;
            obj47 = obj25;
            obj48 = obj24;
            obj49 = obj23;
            Object obj130 = obj37;
            obj50 = obj41;
            obj51 = obj130;
            Object obj131 = obj38;
            obj52 = obj40;
            obj53 = obj131;
            obj54 = obj39;
        }
        z17 = z16;
        obj41 = obj11;
        obj40 = obj19;
        obj39 = obj22;
        obj38 = obj21;
        obj37 = obj12;
        obj36 = obj16;
        obj35 = obj14;
        obj34 = obj15;
        obj33 = obj18;
        obj32 = obj13;
        obj31 = obj17;
        obj30 = obj20;
        obj29 = obj4;
        obj28 = obj10;
        obj27 = obj9;
        obj26 = obj8;
        obj25 = obj7;
        obj24 = obj6;
        obj23 = obj5;
        i27 = i19;
    }

    public boolean b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f248453l.contains(toServiceMsg) : ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) toServiceMsg)).booleanValue();
    }

    private byte[] a(ToServiceMsg toServiceMsg) {
        byte[] bArr;
        byte[] bArr2;
        if (toServiceMsg == null) {
            return null;
        }
        try {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (toServiceMsg.getWupBuffer() != null) {
                byte b16 = b();
                byte activeNetIpFamily = (byte) NetConnInfoCenter.getActiveNetIpFamily(false);
                int intValue = toServiceMsg.getAttributes().containsKey("send_mode") ? ((Integer) toServiceMsg.getAttributes().get("send_mode")).intValue() : 0;
                try {
                    bArr2 = t.a(toServiceMsg, serviceCmd, activeNetIpFamily, b16);
                } catch (Exception e16) {
                    QLog.d(f248429n, 1, "", e16);
                    bArr2 = null;
                }
                if (intValue == 1) {
                    if (591 == CodecWarpper.getSharedObjectVersion()) {
                        bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), b16, toServiceMsg.getWupBuffer(), true);
                    } else {
                        if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                            bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), b16, activeNetIpFamily, bArr2, null, toServiceMsg.getWupBuffer(), true);
                        }
                        bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), b16, bArr2, null, toServiceMsg.getWupBuffer(), true);
                    }
                } else if (591 == CodecWarpper.getSharedObjectVersion()) {
                    bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), b16, toServiceMsg.getWupBuffer(), true);
                } else {
                    if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                        bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), b16, activeNetIpFamily, bArr2, null, toServiceMsg.getWupBuffer(), true);
                    }
                    bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), b16, bArr2, null, toServiceMsg.getWupBuffer(), true);
                }
            } else {
                bArr = new byte[0];
            }
            return bArr;
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d(f248429n, 1, "LightSender get packet fail ssoseq: " + toServiceMsg.getRequestSsoSeq(), th5);
            return null;
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
                    QLog.d(f248429n, 1, "LightSender uncompress data failed", th5);
                }
            }
            return null;
        }
        return fromServiceMsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(ToServiceMsg toServiceMsg, com.tencent.mobileqq.msf.core.quicksend.d dVar, String str, String str2) {
        try {
        } finally {
            return false;
        }
        if (!c() && !b(toServiceMsg, dVar, str, str2)) {
            return false;
        }
        if (c()) {
            return true;
        }
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

    private void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, String str, com.tencent.mobileqq.msf.core.quicksend.d dVar) {
        dVar.f249906f = i3;
        if (fromServiceMsg == null) {
            FromServiceMsg a16 = o.a(toServiceMsg);
            if (a16 != null) {
                a16.setBusinessFail(i3, str);
                this.f248444c.q().a(toServiceMsg, a16);
            }
        } else {
            this.f248444c.q().a(toServiceMsg, fromServiceMsg);
        }
        this.f248444c.f().j(toServiceMsg, fromServiceMsg, dVar);
    }
}
