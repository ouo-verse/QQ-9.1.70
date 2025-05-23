package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static c f248630a = null;

    /* renamed from: b, reason: collision with root package name */
    private static d f248631b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f248632c = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f248633d = true;

    /* renamed from: e, reason: collision with root package name */
    private static e f248634e;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: d, reason: collision with root package name */
        private static final String f248638d = "SSOQueueMonitor";

        /* renamed from: e, reason: collision with root package name */
        public static final int f248639e = 30000;

        /* renamed from: a, reason: collision with root package name */
        private final Handler f248640a;

        /* renamed from: b, reason: collision with root package name */
        private StringBuilder f248641b;

        /* renamed from: c, reason: collision with root package name */
        private final t f248642c;

        /* synthetic */ c(t tVar, a aVar) {
            this(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tVar, (Object) aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                this.f248641b.setLength(0);
                StringBuilder sb5 = this.f248641b;
                sb5.append("#sendQueue:");
                sb5.append(this.f248642c.f250077b.size());
                sb5.append(" detectQueue:");
                sb5.append(this.f248642c.f250079d.size());
                sb5.append(" waitQueue:");
                sb5.append(this.f248642c.f250080e.size());
                sb5.append(" delayWaitQueue:");
                sb5.append(this.f248642c.f250081f.size());
                sb5.append(" msfMessagePairs:");
                sb5.append(MsfCore.sCore.msfMessagePairs.size());
                sb5.append("\n");
                if (QLog.isColorLevel()) {
                    QLog.d(f248638d, 2, this.f248641b.toString());
                    this.f248641b.setLength(0);
                }
                if (this.f248642c.f250077b.size() > 0) {
                    StringBuilder sb6 = this.f248641b;
                    sb6.append("  *sendQueue: ");
                    sb6.append("\n");
                    l.b(this.f248641b, this.f248642c.f250077b.values(), 2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f248638d, 2, this.f248641b.toString());
                    this.f248641b.setLength(0);
                }
                if (this.f248642c.f250079d.size() > 0) {
                    StringBuilder sb7 = this.f248641b;
                    sb7.append("  *detectSendQueue: ");
                    sb7.append("\n");
                    Collection<ArrayList<ToServiceMsg>> values = this.f248642c.f250079d.values();
                    if (values != null && values.size() > 0) {
                        for (ArrayList<ToServiceMsg> arrayList : values) {
                            if (arrayList instanceof Collection) {
                                l.b(this.f248641b, arrayList, 2);
                                this.f248641b.append("\n");
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(f248638d, 2, this.f248641b.toString());
                                this.f248641b.setLength(0);
                            }
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f248638d, 2, this.f248641b.toString());
                    this.f248641b.setLength(0);
                }
                if (this.f248642c.f250080e.size() > 0) {
                    StringBuilder sb8 = this.f248641b;
                    sb8.append("  *waitQueue: ");
                    sb8.append("\n");
                    l.b(this.f248641b, this.f248642c.f250080e, 2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f248638d, 2, this.f248641b.toString());
                    this.f248641b.setLength(0);
                }
                if (this.f248642c.f250081f.size() > 0) {
                    StringBuilder sb9 = this.f248641b;
                    sb9.append("  *delayWaitQueue: ");
                    sb9.append("\n");
                    l.b(this.f248641b, this.f248642c.f250081f, 2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f248638d, 2, this.f248641b.toString());
                    this.f248641b.setLength(0);
                }
                if (MsfCore.sCore.msfMessagePairs.size() > 0) {
                    StringBuilder sb10 = this.f248641b;
                    sb10.append("  *msfMessagePairs: ");
                    sb10.append("\n");
                    l.b(this.f248641b, MsfCore.sCore.msfMessagePairs, 2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f248638d, 2, this.f248641b.toString());
                    this.f248641b.setLength(0);
                }
                if (this.f248640a == null || l.f248630a == null) {
                }
            } catch (Throwable th5) {
                try {
                    QLog.d(f248638d, 2, th5.getMessage(), th5);
                } finally {
                    if (this.f248640a != null && l.f248630a != null) {
                        this.f248640a.postDelayed(l.f248630a, 30000L);
                    }
                }
            }
        }

        c(t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tVar);
                return;
            }
            this.f248642c = tVar;
            this.f248640a = q.q();
            StringBuilder sb5 = new StringBuilder(8096);
            this.f248641b = sb5;
            sb5.ensureCapacity(2048);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name */
        private static final String f248643a = "SocketReaderOldMonitor";

        /* renamed from: b, reason: collision with root package name */
        public static final int f248644b = 5000;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.mobileqq.msf.core.c0.j jVar;
            com.tencent.mobileqq.msf.core.c0.j jVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                int threadCounts = MsfSdkUtils.getThreadCounts("MsfCoreSocketReaderOld");
                if (threadCounts >= 5 && l.f248633d) {
                    boolean unused = l.f248633d = false;
                    QLog.d(f248643a, 1, "SocketReader\u591a\u7ebf\u7a0b\u5f02\u5e38 " + threadCounts);
                    HashMap hashMap = new HashMap();
                    hashMap.put("count", String.valueOf(threadCounts));
                    hashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().e()));
                    MsfCore msfCore = MsfCore.sCore;
                    if (msfCore != null && (jVar2 = msfCore.statReporter) != null) {
                        jVar2.a("msf.core.SocketReaderMultiThreadException", false, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                    com.tencent.mobileqq.msf.sdk.report.a.a(new com.tencent.mobileqq.msf.sdk.report.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader5\u591a\u7ebf\u7a0b\u5f02\u5e38");
                } else if (threadCounts >= 3 && l.f248632c) {
                    boolean unused2 = l.f248632c = false;
                    QLog.d(f248643a, 1, "SocketReader\u591a\u7ebf\u7a0b\u5f02\u5e38 " + threadCounts);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("count", String.valueOf(threadCounts));
                    hashMap2.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().e()));
                    MsfCore msfCore2 = MsfCore.sCore;
                    if (msfCore2 != null && (jVar = msfCore2.statReporter) != null) {
                        jVar.a("msf.core.SocketReaderMultiThreadException", false, 0L, 0L, (Map<String, String>) hashMap2, false, false);
                    }
                    com.tencent.mobileqq.msf.sdk.report.a.a(new com.tencent.mobileqq.msf.sdk.report.b("SocketReaderMultiThreadCatchedException"), "SocketReaderMultiThreadCatchedException", "SocketReader3\u591a\u7ebf\u7a0b\u5f02\u5e38");
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f248643a, 1, "SocketReader current " + threadCounts);
                }
            } catch (Exception e16) {
                boolean unused3 = l.f248632c = false;
                boolean unused4 = l.f248633d = false;
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e implements Runnable {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: f, reason: collision with root package name */
        private static final String f248645f = "WorkerThreadMonitor";

        /* renamed from: g, reason: collision with root package name */
        private static final long f248646g = 14400000;

        /* renamed from: h, reason: collision with root package name */
        private static final int f248647h = 1;

        /* renamed from: i, reason: collision with root package name */
        private static final int f248648i = 2;

        /* renamed from: j, reason: collision with root package name */
        private static final int f248649j = 3;

        /* renamed from: a, reason: collision with root package name */
        private final t f248650a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f248651b;

        /* renamed from: c, reason: collision with root package name */
        private final b f248652c;

        /* renamed from: d, reason: collision with root package name */
        private long f248653d;

        /* renamed from: e, reason: collision with root package name */
        private long f248654e;

        /* synthetic */ e(t tVar, a aVar) {
            this(tVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tVar, (Object) aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i3;
            String str2;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            try {
                try {
                    boolean a16 = this.f248652c.a(this.f248650a.f250080e.size());
                    long size = this.f248650a.f250080e.size();
                    String str3 = q.f249789d;
                    String str4 = "";
                    if (!a16 || this.f248651b) {
                        str = "";
                        i3 = 0;
                    } else {
                        this.f248651b = true;
                        this.f248652c.b();
                        QLog.d(f248645f, 1, "Kill MSF by sender queue increasing ,queue size", Long.valueOf(size));
                        str = q.f249789d;
                        i3 = 1;
                    }
                    this.f248653d = this.f248650a.i();
                    long abs = Math.abs(SystemClock.uptimeMillis() - this.f248653d);
                    long o16 = this.f248650a.o();
                    if (abs >= f248646g && !this.f248651b && o16 >= 100) {
                        this.f248651b = true;
                        QLog.d(f248645f, 1, "Kill MSF by not send data for one hour,interval = ", Long.valueOf(abs));
                        this.f248650a.y();
                        i3 = 2;
                    } else {
                        str3 = str;
                    }
                    this.f248654e = this.f248650a.f250076a.i().l();
                    long abs2 = Math.abs(SystemClock.uptimeMillis() - this.f248654e);
                    if (abs2 >= f248646g && !this.f248651b) {
                        this.f248651b = true;
                        QLog.d(f248645f, 1, "Kill MSF by not receive data for one hour,interval =", Long.valueOf(abs2));
                        str3 = q.f249790e;
                        i3 = 3;
                    }
                    QLog.d(f248645f, 1, "Kill MSF check result[ senderSize:", Long.valueOf(size), ",sendInterval:", Long.valueOf(abs), ",receiveInterval=", Long.valueOf(abs2), ",addCmdCount=", Long.valueOf(o16));
                    if (this.f248651b) {
                        if (com.tencent.mobileqq.msf.core.x.m.b()) {
                            str4 = MsfSdkUtils.getThreadStackString(str3);
                        }
                        String e16 = MsfCore.sCore.getAccountCenter().e();
                        HashMap hashMap = new HashMap();
                        hashMap.put(MosaicConstants$JsProperty.PROP_THREAD, str3);
                        hashMap.put("time", String.valueOf(System.currentTimeMillis()));
                        if (e16 == null) {
                            e16 = "0000";
                        }
                        hashMap.put("uin", e16);
                        if (!TextUtils.isEmpty(str4)) {
                            str2 = str4;
                        } else {
                            str2 = "null";
                        }
                        hashMap.put("stack", str2);
                        hashMap.put("killReason", String.valueOf(i3));
                        hashMap.put("senderSize", String.valueOf(size));
                        hashMap.put("sendInterval", String.valueOf(abs));
                        hashMap.put("receiveInterval", String.valueOf(abs2));
                        hashMap.put("addCmdCount", String.valueOf(o16));
                        com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
                        if (MsfService.getCore().getStatReporter() != null) {
                            MsfService.getCore().getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.N2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                        }
                        if (Math.random() <= 0.0010000000474974513d) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            com.tencent.mobileqq.msf.sdk.report.a.a(new com.tencent.mobileqq.msf.sdk.report.b(str3 + " QueueHeld"), str3 + "HeldCatchedException:" + str4, str4);
                        }
                        LockMethodProxy.sleep(10000L);
                        SystemMethodProxy.killProcess(Process.myPid());
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i(f248645f, 2, e17.getMessage(), e17);
                    }
                }
            } finally {
                l.b(this.f248650a);
            }
        }

        e(t tVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tVar);
                return;
            }
            this.f248651b = false;
            this.f248652c = new b(40);
            this.f248653d = 0L;
            this.f248654e = 0L;
            this.f248650a = tVar;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15355);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d() {
        if (f248632c || f248633d) {
            if (f248631b == null) {
                f248631b = new d();
            }
            Handler q16 = q.q();
            q16.removeCallbacks(f248631b);
            q16.postDelayed(f248631b, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb5, Collection collection, int i3) {
        MsfMessagePair msfMessagePair;
        if (collection == null || collection.size() <= 0 || sb5 == null) {
            return;
        }
        String str = i3 == 1 ? "  " : i3 == 2 ? "    " : i3 == 3 ? "      " : "";
        for (Object obj : collection) {
            if (obj instanceof ToServiceMsg) {
                ToServiceMsg toServiceMsg = (ToServiceMsg) obj;
                if (toServiceMsg != null) {
                    sb5.append(str);
                    sb5.append(toServiceMsg.getShortStringForLog());
                    sb5.append("\n");
                }
            } else if (obj instanceof FromServiceMsg) {
                FromServiceMsg fromServiceMsg = (FromServiceMsg) obj;
                if (fromServiceMsg != null) {
                    sb5.append(str);
                    sb5.append(fromServiceMsg.getShortStringForLog());
                    sb5.append("\n");
                }
            } else if ((obj instanceof MsfMessagePair) && (msfMessagePair = (MsfMessagePair) obj) != null) {
                if (msfMessagePair.toServiceMsg != null) {
                    sb5.append(str);
                    sb5.append(msfMessagePair.toServiceMsg.getShortStringForLog());
                    sb5.append("\n");
                }
                if (msfMessagePair.fromServiceMsg != null) {
                    sb5.append(str);
                    sb5.append(msfMessagePair.fromServiceMsg.getShortStringForLog());
                    sb5.append("\n");
                }
            }
        }
    }

    public static void a(t tVar) {
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion()) {
            return;
        }
        f248630a = new c(tVar, null);
        q.q().postDelayed(f248630a, 30000L);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f248635a;

        /* renamed from: b, reason: collision with root package name */
        private int f248636b;

        /* renamed from: c, reason: collision with root package name */
        private int f248637c;

        public b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
                return;
            }
            this.f248635a = 0;
            this.f248636b = 0;
            this.f248637c = i3;
        }

        public boolean a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            int i16 = this.f248635a;
            if (i16 == 0) {
                if (i3 < this.f248637c) {
                    return false;
                }
                this.f248635a = i3;
                return false;
            }
            if (i3 >= i16) {
                this.f248635a = i3;
                int i17 = this.f248636b + 1;
                this.f248636b = i17;
                return i17 >= 40;
            }
            b();
            return false;
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f248635a = 0;
                this.f248636b = 0;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f248636b : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
    }

    public static void b(t tVar) {
        if (f248634e == null) {
            f248634e = new e(tVar, null);
        }
        q.q().removeCallbacks(f248634e);
        q.q().postDelayed(f248634e, 60000L);
    }
}
