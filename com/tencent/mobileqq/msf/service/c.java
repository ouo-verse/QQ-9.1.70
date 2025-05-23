package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.msf.core.SharedPreUtils;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends BaseThread {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: g, reason: collision with root package name */
    private static final String f250819g = "MSF.S.AppProcessManager";

    /* renamed from: h, reason: collision with root package name */
    private static final int f250820h = 4;

    /* renamed from: i, reason: collision with root package name */
    private static final int f250821i = 4;

    /* renamed from: j, reason: collision with root package name */
    private static final long f250822j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static final long[] f250823k;

    /* renamed from: l, reason: collision with root package name */
    private static final String f250824l = "sleep_by_ipc_block_time";

    /* renamed from: m, reason: collision with root package name */
    private static final String f250825m = "AppInfo";

    /* renamed from: n, reason: collision with root package name */
    private static final int f250826n = 10;

    /* renamed from: o, reason: collision with root package name */
    private static final int f250827o = 10;

    /* renamed from: a, reason: collision with root package name */
    private long f250828a;

    /* renamed from: b, reason: collision with root package name */
    volatile Object f250829b;

    /* renamed from: c, reason: collision with root package name */
    volatile boolean f250830c;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f250831d;

    /* renamed from: e, reason: collision with root package name */
    int f250832e;

    /* renamed from: f, reason: collision with root package name */
    boolean f250833f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f250834a;

        a(d dVar) {
            this.f250834a = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) dVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            FromServiceMsg fromServiceMsg;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
            if (statReporter != null && (fromServiceMsg = (dVar = this.f250834a).f250846a) != null && dVar.f250847b != null) {
                try {
                    if (fromServiceMsg.getServiceCmd().equals("MessageSvc.PushNotify")) {
                        statReporter.a(com.tencent.mobileqq.msf.core.c0.g.P0, false, 0L, 0L, (Map<String, String>) null, false, false);
                    }
                    HashMap hashMap = new HashMap();
                    c.b((HashMap<String, String>) hashMap);
                    boolean z17 = true;
                    if (this.f250834a.f250847b != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    hashMap.put(c.f250825m, String.valueOf(z16));
                    hashMap.put("param_uin", this.f250834a.f250846a.getUin());
                    hashMap.put("process_name", this.f250834a.f250848c);
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247822n0, String.valueOf(MsfSdkUtils.isProcessExist(BaseApplication.getContext(), this.f250834a.f250847b.b())));
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247824o0, this.f250834a.f250846a.getServiceCmd());
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247826p0, String.valueOf(this.f250834a.f250846a.getWupBuffer().length));
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.W0, String.valueOf(this.f250834a.f250847b.f250874j.size()));
                    com.tencent.mobileqq.msf.service.d dVar2 = this.f250834a.f250847b;
                    if (dVar2 != null && dVar2.d() != null) {
                        z17 = false;
                    }
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247820m0, String.valueOf(z17));
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.X0, String.valueOf(this.f250834a.f250850e));
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.Y0, String.valueOf(this.f250834a.f250851f));
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.Z0, String.valueOf(this.f250834a.f250852g));
                    d dVar3 = this.f250834a;
                    if (dVar3.f250853h instanceof DeadObjectException) {
                        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247830r0, String.valueOf(dVar3.f250854i));
                        hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247832s0, this.f250834a.f250853h.getMessage());
                    }
                    statReporter.a(com.tencent.mobileqq.msf.core.c0.g.F3, false, 0L, 0L, (Map<String, String>) hashMap, false, false);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.msf.service.d f250836a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f250837b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f250838c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FromServiceMsg f250839d;

        b(com.tencent.mobileqq.msf.service.d dVar, String str, long j3, FromServiceMsg fromServiceMsg) {
            this.f250836a = dVar;
            this.f250837b = str;
            this.f250838c = j3;
            this.f250839d = fromServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, dVar, str, Long.valueOf(j3), fromServiceMsg);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
            if (statReporter == null) {
                return;
            }
            try {
                HashMap hashMap = new HashMap();
                c.b((HashMap<String, String>) hashMap);
                if (this.f250836a != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, String.valueOf(z16));
                hashMap.put("process_name", this.f250837b);
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.S0, String.valueOf(this.f250838c));
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.Q0, String.valueOf(MsfSdkUtils.isProcessExist(BaseApplication.getContext(), this.f250837b)));
                hashMap.put("sleep_by_ipc_block_time", String.valueOf(c.this.f250828a));
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247824o0, this.f250839d.getServiceCmd());
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247826p0, String.valueOf(this.f250839d.getWupBuffer().length));
                com.tencent.mobileqq.msf.service.d dVar = this.f250836a;
                if (dVar != null && dVar.d() != null) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247820m0, String.valueOf(z17));
                com.tencent.mobileqq.msf.service.d dVar2 = this.f250836a;
                if (dVar2 != null) {
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.W0, String.valueOf(dVar2.f250874j.size()));
                }
                if (this.f250838c < com.tencent.mobileqq.msf.core.x.b.B0()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                statReporter.a(com.tencent.mobileqq.msf.core.c0.g.G3, z18, 0L, 0L, (Map<String, String>) hashMap, true, false);
            } catch (Exception e16) {
                QLog.e(c.f250819g, 1, "reportMSFForkProcessEvent exception", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.service.c$c, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC8109c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f250841a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.msf.service.d f250842b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f250843c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FromServiceMsg f250844d;

        RunnableC8109c(String str, com.tencent.mobileqq.msf.service.d dVar, int i3, FromServiceMsg fromServiceMsg) {
            this.f250841a = str;
            this.f250842b = dVar;
            this.f250843c = i3;
            this.f250844d = fromServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, str, dVar, Integer.valueOf(i3), fromServiceMsg);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
            if (statReporter == null) {
                return;
            }
            try {
                boolean isProcessExist = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), this.f250841a);
                HashMap hashMap = new HashMap();
                c.b((HashMap<String, String>) hashMap);
                if (this.f250842b != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, String.valueOf(z16));
                hashMap.put("process_name", this.f250841a);
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.R0, String.valueOf(this.f250843c));
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247824o0, this.f250844d.getServiceCmd());
                hashMap.put(com.tencent.mobileqq.msf.core.c0.j.Q0, String.valueOf(isProcessExist));
                statReporter.a(com.tencent.mobileqq.msf.core.c0.g.H3, false, 0L, 0L, (Map<String, String>) hashMap, true, false);
            } catch (Exception e16) {
                QLog.e(c.f250819g, 1, "reportMSFForkProcess exception", e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        FromServiceMsg f250846a;

        /* renamed from: b, reason: collision with root package name */
        com.tencent.mobileqq.msf.service.d f250847b;

        /* renamed from: c, reason: collision with root package name */
        String f250848c;

        /* renamed from: d, reason: collision with root package name */
        boolean f250849d;

        /* renamed from: e, reason: collision with root package name */
        boolean f250850e;

        /* renamed from: f, reason: collision with root package name */
        long f250851f;

        /* renamed from: g, reason: collision with root package name */
        long f250852g;

        /* renamed from: h, reason: collision with root package name */
        Exception f250853h;

        /* renamed from: i, reason: collision with root package name */
        long f250854i;

        public d(FromServiceMsg fromServiceMsg, com.tencent.mobileqq.msf.service.d dVar, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, fromServiceMsg, dVar, str);
                return;
            }
            this.f250849d = false;
            this.f250850e = false;
            this.f250851f = 0L;
            this.f250852g = 0L;
            this.f250854i = 0L;
            this.f250846a = fromServiceMsg;
            this.f250847b = dVar;
            this.f250848c = str;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14060);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250823k = new long[]{20, 60, 100};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f250829b = new Object();
        this.f250830c = false;
        this.f250831d = true;
        this.f250832e = 0;
        this.f250833f = false;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0431 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02b2  */
    /* JADX WARN: Type inference failed for: r5v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(String str, com.tencent.mobileqq.msf.service.d dVar) {
        boolean z16;
        boolean z17;
        int i3;
        MsfMessagePair peek;
        FromServiceMsg fromServiceMsg;
        boolean z18;
        IMsfServiceCallbacker iMsfServiceCallbacker;
        boolean z19;
        long j3;
        boolean Y0;
        ?? r56;
        boolean z26;
        boolean z27;
        c cVar;
        boolean z28;
        boolean z29;
        c cVar2 = this;
        boolean z36 = false;
        int i16 = 0;
        while (!dVar.f250874j.isEmpty()) {
            int i17 = i16 + 1;
            if (i17 > 10 || (peek = dVar.f250874j.peek()) == null || (fromServiceMsg = peek.fromServiceMsg) == null) {
                z16 = z36;
                z17 = true;
                i3 = i17;
            } else {
                IMsfServiceCallbacker d16 = dVar.d();
                boolean z37 = d16 == null ? true : z36;
                boolean z38 = (TextUtils.isEmpty(dVar.a()) || fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP) == null) ? z36 : true;
                d dVar2 = new d(fromServiceMsg, dVar, str);
                QLog.d(f250819g, 1, "tryDispatchMsg to process:" + str + ", IMsfServiceCallbacker:" + d16 + ", needBoot:" + z38 + ", msgCount:" + i17 + ", queueSize:" + dVar.f250874j.size() + ", fromServiceMsg:" + fromServiceMsg.getShortStringForLog());
                if (z37) {
                    boolean c16 = cVar2.c(fromServiceMsg.getServiceCmd(), dVar);
                    boolean a16 = cVar2.a(fromServiceMsg.getMsfCommand(), dVar);
                    if (c16 || a16) {
                        boolean isProcessExist = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), str);
                        if (c16) {
                            dVar.f250865a = z36;
                            dVar.f250867c = z36;
                            z38 = (!z38 || isProcessExist) ? z36 : true;
                            if (z38 || !isProcessExist) {
                                z27 = z36;
                                z29 = true;
                                QLog.d(f250819g, 1, str + "'s callBack is null; " + fromServiceMsg.getServiceCmd() + " is cared: " + z29 + ", needBoot: " + z38 + "\uff0cneedNotifyRegister:" + z27);
                                iMsfServiceCallbacker = d16;
                                z19 = z29;
                                z26 = z38;
                                r56 = 1;
                                i3 = i17;
                            }
                        } else if (a16 && isProcessExist) {
                            dVar.f250865a = z36;
                            dVar.f250867c = z36;
                            z38 = z36;
                        }
                        z27 = true;
                        z29 = z27;
                        QLog.d(f250819g, 1, str + "'s callBack is null; " + fromServiceMsg.getServiceCmd() + " is cared: " + z29 + ", needBoot: " + z38 + "\uff0cneedNotifyRegister:" + z27);
                        iMsfServiceCallbacker = d16;
                        z19 = z29;
                        z26 = z38;
                        r56 = 1;
                        i3 = i17;
                    }
                    z27 = z36;
                    z29 = z27;
                    QLog.d(f250819g, 1, str + "'s callBack is null; " + fromServiceMsg.getServiceCmd() + " is cared: " + z29 + ", needBoot: " + z38 + "\uff0cneedNotifyRegister:" + z27);
                    iMsfServiceCallbacker = d16;
                    z19 = z29;
                    z26 = z38;
                    r56 = 1;
                    i3 = i17;
                } else {
                    if (!dVar.f250867c || fromServiceMsg.getMsfCommand() == MsfCommand.setMsfConnStatus) {
                        z18 = true;
                        i3 = i17;
                    } else {
                        i3 = i17;
                        if (SystemClock.elapsedRealtime() - dVar.f250866b < 2000) {
                            z16 = z36;
                            z17 = true;
                        } else {
                            dVar.f250867c = z36;
                            z18 = true;
                            QLog.d(f250819g, 1, "half close timeout " + str + " isAppConnected " + dVar.f250865a);
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        cVar2.a(peek, str, currentTimeMillis);
                        cVar2.a(peek, d16, str);
                        dVar2.f250850e = z18;
                        iMsfServiceCallbacker = d16;
                        z19 = z37;
                    } catch (DeadObjectException e16) {
                        e = e16;
                        iMsfServiceCallbacker = d16;
                    } catch (Throwable th5) {
                        th = th5;
                        iMsfServiceCallbacker = d16;
                        z19 = z37;
                    }
                    try {
                        try {
                            dVar2.f250851f = System.currentTimeMillis() - currentTimeMillis;
                            if (peek.toServiceMsg == null) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("SendToApp PUSH process:");
                                sb5.append(str);
                                sb5.append(" fromServiceMsg: ");
                                sb5.append(fromServiceMsg.getShortStringForLog());
                                sb5.append(" cost = ");
                                j3 = currentTimeMillis;
                                try {
                                    sb5.append(dVar2.f250851f);
                                    sb5.append(" needBoot=");
                                    sb5.append(z38);
                                    sb5.append(" from.len = ");
                                    sb5.append(fromServiceMsg.getWupBuffer().length);
                                    sb5.append(", queueSize = ");
                                    sb5.append(dVar.f250874j.size());
                                    QLog.i(f250819g, 1, sb5.toString());
                                } catch (DeadObjectException e17) {
                                    e = e17;
                                    dVar2.f250854i = System.currentTimeMillis();
                                    dVar2.f250853h = e;
                                    dVar.a(e, fromServiceMsg.getServiceCmd());
                                    Y0 = com.tencent.mobileqq.msf.core.x.d.Y0();
                                    if (!Y0) {
                                    }
                                    r56 = 1;
                                    QLog.w(f250819g, 1, "DeadObjectException process=" + str + " cost=" + (System.currentTimeMillis() - j3) + ", isBinderConnectOptEnable = " + Y0, e);
                                    z19 = true;
                                    z26 = z38;
                                    z27 = false;
                                    if (z19) {
                                    }
                                    if (dVar2.f250849d) {
                                    }
                                    z36 = z28;
                                    cVar2 = cVar;
                                    i16 = i3;
                                }
                            } else {
                                QLog.i(f250819g, 1, "SendToApp process:" + str + " fromServiceMsg: " + fromServiceMsg.getShortStringForLog() + " cost =" + dVar2.f250851f + " needBoot=" + z38 + " to.len = " + peek.toServiceMsg.getWupBuffer().length + " from.len = " + fromServiceMsg.getWupBuffer().length + ", queueSize = " + dVar.f250874j.size());
                            }
                        } catch (DeadObjectException e18) {
                            e = e18;
                            j3 = currentTimeMillis;
                            dVar2.f250854i = System.currentTimeMillis();
                            dVar2.f250853h = e;
                            dVar.a(e, fromServiceMsg.getServiceCmd());
                            Y0 = com.tencent.mobileqq.msf.core.x.d.Y0();
                            if (!Y0) {
                                dVar.a(iMsfServiceCallbacker);
                            }
                            r56 = 1;
                            QLog.w(f250819g, 1, "DeadObjectException process=" + str + " cost=" + (System.currentTimeMillis() - j3) + ", isBinderConnectOptEnable = " + Y0, e);
                            z19 = true;
                            z26 = z38;
                            z27 = false;
                            if (z19) {
                            }
                            if (dVar2.f250849d) {
                            }
                            z36 = z28;
                            cVar2 = cVar;
                            i16 = i3;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        QLog.w(f250819g, 1, th.getMessage(), th);
                        z26 = z38;
                        z27 = false;
                        r56 = 1;
                        if (z19) {
                        }
                        if (dVar2.f250849d) {
                        }
                        z36 = z28;
                        cVar2 = cVar;
                        i16 = i3;
                    }
                    z26 = z38;
                    z27 = false;
                    r56 = 1;
                }
                if (z19) {
                    dVar.f250874j.poll();
                    dVar2.f250849d = r56;
                    if (z26) {
                        QLog.d(f250819g, (int) r56, "tryStartProcess");
                        dVar.a(3, fromServiceMsg);
                    }
                    cVar = this;
                    z28 = false;
                } else {
                    QLog.d(f250819g, 1, str + " callback:" + iMsfServiceCallbacker + " and dispatchMsg fail, need boot:" + z26 + ", from:" + fromServiceMsg.getShortStringForLog());
                    if (z26) {
                        dVar.a(0, fromServiceMsg);
                        dVar.f250868d++;
                        a(peek.fromServiceMsg, dVar, str, dVar.f250868d);
                        if (dVar.f250868d <= com.tencent.mobileqq.msf.core.x.b.B0()) {
                            return false;
                        }
                        MsfMessagePair poll = dVar.f250874j.poll();
                        dVar2.f250849d = true;
                        QLog.d(f250819g, 1, "dispatchMsg boot too many times:" + dVar.f250868d + ", maxTime:" + com.tencent.mobileqq.msf.core.x.b.B0() + ", MsgType:" + poll.fromServiceMsg.getShortStringForLog() + ", ProcName:" + str + ", MsgLeft:" + dVar.f250874j.size());
                        dVar.f250868d = 0L;
                        return false;
                    }
                    if (z27) {
                        try {
                            int i18 = dVar.f250871g.get();
                            if (i18 > 10) {
                                MsfMessagePair poll2 = dVar.f250874j.poll();
                                dVar2.f250849d = true;
                                QLog.d(f250819g, 1, "dispatchMsg broadcast notify register MSF too many times:" + i18 + ", maxTime:10, Msg:" + poll2.fromServiceMsg.getShortStringForLog() + ", ProcName:" + str + ", MsgLeft:" + dVar.f250874j.size());
                                z28 = false;
                                try {
                                    dVar.f250871g.set(0);
                                } catch (Exception e19) {
                                    e = e19;
                                    cVar = this;
                                }
                            } else if (dVar.a(fromServiceMsg.getServiceCmd())) {
                                cVar = this;
                                try {
                                    cVar.a(peek.fromServiceMsg, dVar, str, i18);
                                    return false;
                                } catch (Exception e26) {
                                    e = e26;
                                    z28 = false;
                                    QLog.d(f250819g, 1, "needBoot:" + z26, e);
                                    if (dVar2.f250849d) {
                                    }
                                    z36 = z28;
                                    cVar2 = cVar;
                                    i16 = i3;
                                }
                            }
                            return false;
                        } catch (Exception e27) {
                            e = e27;
                            cVar = this;
                        }
                    } else {
                        cVar = this;
                        z28 = false;
                        try {
                            dVar.f250874j.poll();
                            dVar2.f250849d = true;
                        } catch (Exception e28) {
                            e = e28;
                        }
                    }
                    QLog.d(f250819g, 1, "needBoot:" + z26, e);
                }
                if (dVar2.f250849d) {
                    long longValue = ((Long) dVar2.f250846a.getAttribute(BaseConstants.TIMESTAMP_NET2MSF, 0L)).longValue();
                    if (longValue > 0) {
                        dVar2.f250852g = System.currentTimeMillis() - longValue;
                    }
                    cVar.a(dVar2);
                }
                z36 = z28;
                cVar2 = cVar;
                i16 = i3;
            }
            i16 = i3;
        }
        z16 = z36;
        z17 = true;
        return i16 > 10 ? z17 : z16;
    }

    private void c(MsfMessagePair msfMessagePair) {
        if ((!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || com.tencent.mobileqq.msf.core.x.d.b()) && !a(msfMessagePair.fromServiceMsg.getServiceCmd())) {
            QLog.d(f250819g, 1, "sleep " + this.f250828a + " ms by IPC block");
            try {
                LockMethodProxy.sleep(this.f250828a);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250819g, 2, "sleepByIPCBlock throws ex: ", e16);
                }
            }
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        while (true) {
            e.f250888f.f250996h = false;
            while (this.f250831d) {
                this.f250831d = false;
                this.f250832e = 0;
                for (String str : e.f250885c.keySet()) {
                    com.tencent.mobileqq.msf.service.d dVar = e.f250885c.get(str);
                    if (dVar != null) {
                        if (this.f250833f) {
                            if (b(str, dVar)) {
                                this.f250831d = true;
                            }
                        } else if (a(str, dVar)) {
                            this.f250831d = true;
                        }
                        this.f250832e += dVar.f250874j.size();
                    }
                }
            }
            this.f250830c = true;
            synchronized (this.f250829b) {
                if (this.f250830c) {
                    try {
                        if (this.f250832e == 0) {
                            this.f250829b.wait(61440L);
                        } else {
                            this.f250829b.wait(600L);
                        }
                        this.f250831d = true;
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
    }

    private void a() {
        this.f250833f = com.tencent.mobileqq.msf.core.x.m.k();
        QLog.d(f250819g, 1, "isUseNewDispatchMethod = " + this.f250833f);
        SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(SharedPreUtils.a.f247309a, 0);
        long j3 = sharedPreferences.getLong("sleep_by_ipc_block_time", 0L);
        this.f250828a = j3;
        if (j3 == 0) {
            long[] jArr = f250823k;
            int length = jArr.length;
            int nextInt = new Random().nextInt(length);
            if (nextInt < 0 || nextInt >= length) {
                nextInt = length - 1;
            }
            this.f250828a = jArr[nextInt];
            sharedPreferences.edit().putLong("sleep_by_ipc_block_time", this.f250828a).apply();
            if (QLog.isColorLevel()) {
                QLog.d(f250819g, 2, "init, mSleepByIPCBlockTime = " + this.f250828a);
            }
        }
    }

    private boolean c(String str, com.tencent.mobileqq.msf.service.d dVar) {
        if (TextUtils.isEmpty(dVar.a())) {
            return false;
        }
        if (com.tencent.mobileqq.msf.core.x.o.x().b().contains(str)) {
            return true;
        }
        Iterator<String> it = com.tencent.mobileqq.msf.core.x.o.x().b().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(str) && str.startsWith(next)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0288  */
    /* JADX WARN: Type inference failed for: r3v15, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [int] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str, com.tencent.mobileqq.msf.service.d dVar) {
        boolean z16;
        boolean z17;
        int i3;
        MsfMessagePair peek;
        FromServiceMsg fromServiceMsg;
        FromServiceMsg fromServiceMsg2;
        boolean z18;
        boolean z19;
        int i16;
        long j3;
        ?? r36;
        boolean z26;
        boolean z27;
        c cVar;
        c cVar2 = this;
        boolean z28 = false;
        int i17 = 0;
        while (!dVar.f250874j.isEmpty()) {
            int i18 = i17 + 1;
            if (i18 > 10 || (peek = dVar.f250874j.peek()) == null || (fromServiceMsg = peek.fromServiceMsg) == null) {
                z16 = z28;
                z17 = true;
                i3 = i18;
            } else {
                IMsfServiceCallbacker d16 = dVar.d();
                boolean z29 = d16 == null ? true : z28;
                boolean z36 = (TextUtils.isEmpty(dVar.a()) || fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP) == null) ? z28 : true;
                d dVar2 = new d(fromServiceMsg, dVar, str);
                QLog.d(f250819g, 1, "tryDispatchMsg to process:" + str + ", IMsfServiceCallbacker:" + d16 + ", needBoot:" + z36 + ", msgCount:" + i18 + ", queueSize:" + dVar.f250874j.size() + ", fromServiceMsg:" + fromServiceMsg.getShortStringForLog());
                if (z29) {
                    String serviceCmd = fromServiceMsg.getServiceCmd();
                    String[] strArr = BaseConstants.CMD_NeedBootPushCmdHeads;
                    int length = strArr.length;
                    ?? r65 = z28;
                    while (true) {
                        if (r65 >= length) {
                            z26 = z28;
                            break;
                        }
                        String str2 = strArr[r65];
                        if (serviceCmd != null && serviceCmd.startsWith(str2)) {
                            dVar.f250865a = z28;
                            dVar.f250867c = z28;
                            z26 = true;
                            break;
                        }
                        r65++;
                    }
                    QLog.d(f250819g, 1, str + "'s callBack is null; " + fromServiceMsg.getServiceCmd() + " is cared: " + z26 + ", needBoot: " + z36);
                    fromServiceMsg2 = fromServiceMsg;
                    i16 = i18;
                    r36 = 1;
                } else {
                    if (!dVar.f250867c || fromServiceMsg.getMsfCommand() == MsfCommand.setMsfConnStatus) {
                        fromServiceMsg2 = fromServiceMsg;
                        z18 = true;
                    } else {
                        fromServiceMsg2 = fromServiceMsg;
                        if (SystemClock.elapsedRealtime() - dVar.f250866b < 2000) {
                            z16 = z28;
                            i3 = i18;
                            z17 = true;
                        } else {
                            dVar.f250867c = z28;
                            z18 = true;
                            QLog.d(f250819g, 1, "half close timeout " + str + " isAppConnected " + dVar.f250865a);
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        cVar2.a(peek, str, currentTimeMillis);
                        cVar2.a(peek, d16, str);
                        dVar2.f250850e = z18;
                        dVar2.f250851f = System.currentTimeMillis() - currentTimeMillis;
                        z19 = z29;
                        i16 = i18;
                        if (peek.toServiceMsg == null) {
                            try {
                                try {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("SendToApp PUSH process:");
                                    sb5.append(str);
                                    sb5.append(" fromServiceMsg: ");
                                    sb5.append(fromServiceMsg2.getShortStringForLog());
                                    sb5.append(" cost = ");
                                    j3 = currentTimeMillis;
                                    try {
                                        sb5.append(dVar2.f250851f);
                                        sb5.append(" needBoot=");
                                        sb5.append(z36);
                                        sb5.append(" from.len = ");
                                        sb5.append(fromServiceMsg2.getWupBuffer().length);
                                        sb5.append(", queueSize = ");
                                        sb5.append(dVar.f250874j.size());
                                        QLog.i(f250819g, 1, sb5.toString());
                                    } catch (DeadObjectException e16) {
                                        e = e16;
                                        dVar2.f250853h = e;
                                        dVar2.f250854i = System.currentTimeMillis();
                                        dVar.a(e, fromServiceMsg2.getServiceCmd());
                                        boolean Y0 = com.tencent.mobileqq.msf.core.x.d.Y0();
                                        if (!Y0) {
                                            dVar.a(d16);
                                        }
                                        r36 = 1;
                                        QLog.w(f250819g, 1, "DeadObjectException process=" + str + " cost=" + (System.currentTimeMillis() - j3) + ", isBinderConnectOptEnable = " + Y0, e);
                                        z26 = true;
                                        if (!z26) {
                                        }
                                        if (dVar2.f250849d) {
                                        }
                                        z28 = z27;
                                        cVar2 = cVar;
                                        i17 = i16;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    QLog.w(f250819g, 1, th.getMessage(), th);
                                    z26 = z19;
                                    r36 = 1;
                                    if (!z26) {
                                    }
                                    if (dVar2.f250849d) {
                                    }
                                    z28 = z27;
                                    cVar2 = cVar;
                                    i17 = i16;
                                }
                            } catch (DeadObjectException e17) {
                                e = e17;
                                j3 = currentTimeMillis;
                            }
                        } else {
                            QLog.i(f250819g, 1, "SendToApp process:" + str + " fromServiceMsg: " + fromServiceMsg2.getShortStringForLog() + " cos t =" + dVar2.f250851f + " needBoot=" + z36 + " to.len = " + peek.toServiceMsg.getWupBuffer().length + " from.len = " + fromServiceMsg2.getWupBuffer().length + ", queueSize = " + dVar.f250874j.size());
                        }
                    } catch (DeadObjectException e18) {
                        e = e18;
                        j3 = currentTimeMillis;
                        i16 = i18;
                    } catch (Throwable th6) {
                        th = th6;
                        z19 = z29;
                        i16 = i18;
                    }
                    z26 = z19;
                    r36 = 1;
                }
                if (!z26) {
                    dVar.f250874j.poll();
                    dVar2.f250849d = r36;
                    if (z36) {
                        QLog.d(f250819g, (int) r36, "tryStartProcess");
                        dVar.a(3, fromServiceMsg2);
                    }
                    z27 = false;
                } else {
                    QLog.d(f250819g, 1, str + " callback:" + d16 + " and dispatchMsg fail, need boot:" + z36 + ", from:" + fromServiceMsg2.getShortStringForLog());
                    if (z36) {
                        try {
                            dVar.a(0, fromServiceMsg2);
                            try {
                                dVar.f250868d++;
                                a(peek.fromServiceMsg, dVar, str, dVar.f250868d);
                                if (dVar.f250868d <= com.tencent.mobileqq.msf.core.x.b.B0()) {
                                    return false;
                                }
                                MsfMessagePair poll = dVar.f250874j.poll();
                                dVar2.f250849d = true;
                                QLog.d(f250819g, 1, "dispatchMsg boot too many times:" + dVar.f250868d + ", maxTime:" + com.tencent.mobileqq.msf.core.x.b.B0() + ", MsgType:" + poll.fromServiceMsg.toString() + " ProcName:" + str + ", MsgLeft:" + dVar.f250874j.size());
                                dVar.f250868d = 0L;
                                return false;
                            } catch (Exception e19) {
                                e = e19;
                                z27 = false;
                            }
                        } catch (Exception e26) {
                            e = e26;
                            z27 = false;
                        }
                    } else {
                        z27 = false;
                        try {
                            dVar.f250874j.poll();
                            dVar2.f250849d = true;
                        } catch (Exception e27) {
                            e = e27;
                        }
                    }
                    QLog.d(f250819g, 1, "needBoot:" + z36, e);
                }
                if (dVar2.f250849d) {
                    long longValue = ((Long) dVar2.f250846a.getAttribute(BaseConstants.TIMESTAMP_NET2MSF, 0L)).longValue();
                    if (longValue > 0) {
                        dVar2.f250852g = System.currentTimeMillis() - longValue;
                    }
                    cVar = this;
                    cVar.a(dVar2);
                } else {
                    cVar = this;
                }
                z28 = z27;
                cVar2 = cVar;
                i17 = i16;
            }
            i17 = i3;
        }
        z16 = z28;
        z17 = true;
        return i17 > 10 ? z17 : z16;
    }

    private boolean b(MsfMessagePair msfMessagePair) {
        return (msfMessagePair.fromServiceMsg.getRequestSsoSeq() == -1 || a(msfMessagePair.fromServiceMsg.getServiceCmd())) ? false : true;
    }

    private void a(MsfMessagePair msfMessagePair, IMsfServiceCallbacker iMsfServiceCallbacker, String str) throws Throwable {
        if (iMsfServiceCallbacker == null) {
            if (QLog.isColorLevel()) {
                QLog.i(f250819g, 2, "IMsfServiceCallback is null");
            }
        } else {
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !com.tencent.mobileqq.msf.core.x.d.a()) {
                a(msfMessagePair, iMsfServiceCallbacker);
                return;
            }
            int length = msfMessagePair.fromServiceMsg.getWupBuffer().length;
            int c16 = h.d().c();
            if (b(msfMessagePair) && length > c16) {
                a(msfMessagePair, c16, length, iMsfServiceCallbacker);
            } else {
                b(msfMessagePair, c16, length, iMsfServiceCallbacker);
            }
            if (com.tencent.mobileqq.msf.core.net.utils.e.a(0, 2000000000) < 1) {
                i.a().b();
            }
        }
    }

    private void b(MsfMessagePair msfMessagePair, int i3, int i16, IMsfServiceCallbacker iMsfServiceCallbacker) throws Exception {
        int i17 = 0;
        while (i17 < 4) {
            try {
                a(msfMessagePair, iMsfServiceCallbacker);
                if (i17 > 0) {
                    i.a().a(true, "", a(msfMessagePair), i16, msfMessagePair.fromServiceMsg.getServiceCmd(), this.f250828a);
                    return;
                }
                return;
            } catch (DeadObjectException e16) {
                throw e16;
            } catch (RemoteException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250819g, 2, "try asyncTransport fail with e = " + e17.getClass().getSimpleName() + ", msg = " + e17.getMessage() + ", ssoSeq = " + msfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + msfMessagePair.fromServiceMsg.getServiceCmd() + ", time = " + i17 + ", packageLength = " + i3);
                }
                i17++;
                if (i17 == 4) {
                    if (b(msfMessagePair)) {
                        a(msfMessagePair, i3 / 2, i16, iMsfServiceCallbacker);
                        return;
                    }
                    throw e17;
                }
                if (i17 >= 2) {
                    c(msfMessagePair);
                }
            }
        }
    }

    private boolean a(String str) {
        return TextUtils.equals(BaseConstants.CMD_PUSHSETCONFIG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MsfMessagePair msfMessagePair, IMsfServiceCallbacker iMsfServiceCallbacker) throws RemoteException {
        ToServiceMsg toServiceMsg = msfMessagePair.toServiceMsg;
        if (toServiceMsg == null) {
            iMsfServiceCallbacker.onReceivePushResp(msfMessagePair.fromServiceMsg);
        } else {
            iMsfServiceCallbacker.onResponse(toServiceMsg, msfMessagePair.fromServiceMsg);
        }
    }

    private void a(MsfMessagePair msfMessagePair, int i3, int i16, IMsfServiceCallbacker iMsfServiceCallbacker) throws Exception {
        try {
            byte[] wupBuffer = msfMessagePair.fromServiceMsg.getWupBuffer();
            byte[] bArr = null;
            int i17 = i3;
            int i18 = 0;
            int i19 = 0;
            while (i18 < i16) {
                int i26 = i18 + i17 <= i16 ? i17 : i16 - i18;
                if (bArr == null || bArr.length != i26) {
                    bArr = new byte[i26];
                }
                byte[] bArr2 = bArr;
                System.arraycopy(wupBuffer, i18, bArr2, 0, i26);
                msfMessagePair.fromServiceMsg.putWupBuffer(bArr2);
                if (a(msfMessagePair, i18, i17, i16, i19, iMsfServiceCallbacker)) {
                    i18 += i26;
                } else {
                    i17 /= 2;
                    i19++;
                }
                bArr = bArr2;
            }
            i.a().a(true, "", a(msfMessagePair), i16, msfMessagePair.fromServiceMsg.getServiceCmd(), this.f250828a);
        } catch (OutOfMemoryError e16) {
            QLog.e(f250819g, 1, "transportToAppProcess throw oom, cmd = " + msfMessagePair.fromServiceMsg.getServiceCmd(), e16);
            i.a().a(false, e16.getClass().getSimpleName(), a(msfMessagePair), i16, msfMessagePair.fromServiceMsg.getServiceCmd(), this.f250828a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(HashMap<String, String> hashMap) {
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            hashMap.put("availMem", String.valueOf(memoryInfo.availMem));
            hashMap.put(HippyReporter.RemoveEngineReason.LOW_MEMORY, String.valueOf(memoryInfo.lowMemory));
        } catch (Exception e16) {
            QLog.e(f250819g, 1, "getSystemStatus exception", e16);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (this.f250829b) {
            this.f250831d = true;
            this.f250830c = false;
            this.f250829b.notify();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(MsfMessagePair msfMessagePair, int i3, int i16, int i17, int i18, IMsfServiceCallbacker iMsfServiceCallbacker) throws Exception {
        c cVar;
        int i19;
        int i26;
        c cVar2 = this;
        int i27 = 0;
        while (i27 < 4) {
            try {
                try {
                    if (QLog.isColorLevel()) {
                        try {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("send package, index = ");
                            sb5.append(i3);
                            sb5.append(", ssoSeq = ");
                            sb5.append(msfMessagePair.fromServiceMsg.getRequestSsoSeq());
                            sb5.append(", cmd = ");
                            sb5.append(msfMessagePair.fromServiceMsg.getServiceCmd());
                            sb5.append(", divideTryTime = ");
                            sb5.append(i18);
                            sb5.append(", packageLength = ");
                            sb5.append(i16);
                            QLog.d(f250819g, 2, sb5.toString());
                        } catch (RemoteException e16) {
                            e = e16;
                            i19 = i27;
                            if (QLog.isColorLevel()) {
                                i26 = 2;
                            } else {
                                i26 = 2;
                                QLog.d(f250819g, 2, "try syncTransport fail with e = " + e.getClass().getSimpleName() + ", msg" + e.getMessage() + ", ssoSeq = " + msfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + msfMessagePair.fromServiceMsg.getServiceCmd() + ", time = " + i19 + ", divideTryTime = " + i18 + ", packageLength = " + i16);
                            }
                            i27 = i19 + 1;
                            if (i27 != 4) {
                                if (i18 < 4) {
                                    return false;
                                }
                                i.a().a(false, e.getClass().getSimpleName(), a(msfMessagePair), i17, msfMessagePair.fromServiceMsg.getServiceCmd(), this.f250828a);
                                throw e;
                            }
                            if (i27 >= i26) {
                                c(msfMessagePair);
                            }
                            cVar2 = this;
                        }
                    }
                    i19 = i27;
                    try {
                        a(msfMessagePair, i3, i16, i17, iMsfServiceCallbacker);
                        return true;
                    } catch (DeadObjectException e17) {
                        e = e17;
                        cVar = this;
                        i.a().a(false, e.getClass().getSimpleName(), a(msfMessagePair), i17, msfMessagePair.fromServiceMsg.getServiceCmd(), cVar.f250828a);
                        throw e;
                    } catch (RemoteException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                        }
                        i27 = i19 + 1;
                        if (i27 != 4) {
                        }
                    }
                } catch (DeadObjectException e19) {
                    e = e19;
                    cVar = cVar2;
                }
            } catch (RemoteException e26) {
                e = e26;
            }
        }
        return false;
    }

    private void a(MsfMessagePair msfMessagePair, int i3, int i16, int i17, IMsfServiceCallbacker iMsfServiceCallbacker) throws RemoteException {
        ToServiceMsg toServiceMsg = msfMessagePair.toServiceMsg;
        if (toServiceMsg == null) {
            if (i3 == 0) {
                iMsfServiceCallbacker.onReceiveFirstPkgPushResp(msfMessagePair.fromServiceMsg, i3, i16, i17);
                return;
            } else {
                iMsfServiceCallbacker.onReceiveNextPkgPushResp(msfMessagePair.fromServiceMsg.getRequestSsoSeq(), i3, msfMessagePair.fromServiceMsg.getWupBuffer());
                return;
            }
        }
        if (i3 == 0) {
            iMsfServiceCallbacker.onFirstPkgResp(toServiceMsg, msfMessagePair.fromServiceMsg, i3, i16, i17);
        } else {
            iMsfServiceCallbacker.onNextPkgResp(msfMessagePair.fromServiceMsg.getRequestSsoSeq(), i3, msfMessagePair.fromServiceMsg.getWupBuffer());
        }
    }

    private void a(d dVar) {
        q.q().post(new a(dVar));
    }

    private void a(FromServiceMsg fromServiceMsg, com.tencent.mobileqq.msf.service.d dVar, String str, long j3) {
        q.q().post(new b(dVar, str, j3, fromServiceMsg));
    }

    private void a(FromServiceMsg fromServiceMsg, com.tencent.mobileqq.msf.service.d dVar, String str, int i3) {
        q.q().post(new RunnableC8109c(str, dVar, i3, fromServiceMsg));
    }

    private void a(MsfMessagePair msfMessagePair, String str, long j3) {
        if (msfMessagePair.toServiceMsg == null) {
            FromServiceMsg fromServiceMsg = msfMessagePair.fromServiceMsg;
            if (str != null && str.endsWith(MsfConstants.PROCESS_VIDEO) && fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c") && fromServiceMsg.getAttribute("msf_timestamp") == null) {
                fromServiceMsg.addAttribute("msf_timestamp", Long.valueOf(j3));
            }
        }
    }

    private boolean a(MsfCommand msfCommand, com.tencent.mobileqq.msf.service.d dVar) {
        if (dVar.f250869e) {
            return com.tencent.mobileqq.msf.core.x.o.x().a().contains(msfCommand);
        }
        return false;
    }

    private int a(MsfMessagePair msfMessagePair) {
        ToServiceMsg toServiceMsg = msfMessagePair.toServiceMsg;
        if (toServiceMsg != null) {
            return toServiceMsg.getWupBuffer().length;
        }
        return 0;
    }
}
