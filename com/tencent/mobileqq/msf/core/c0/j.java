package com.tencent.mobileqq.msf.core.c0;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.o;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_ = null;
    public static final String A = "param_uin";
    private static final String A0 = "param_NetworkOperator";
    static final String B = "param_src";
    private static final String B0 = "param_GatewayrIp";
    static final String C = "param_imei";
    private static final String C0 = "param_NetworkInfo";
    static final String D = "param_FailCode";
    private static final String D0 = "activeIpfamily";
    static final String E = "param_SsoServerIp";
    private static final String E0 = "param_appid";
    static final String F = "param_GatewayIp";
    public static final String F0 = "is_support_msf_wake_lock";
    static final String G = "param_NowLocalIp";
    public static final String G0 = "is_support_foreground_wake_lock";
    static final String H = "param_sendLocalIp";
    public static final String H0 = "param_action";
    static final String I = "param_Detail";
    public static final String I0 = "param_netType";
    static final String J = "param_tokenType";
    public static final String J0 = "param_conn_state";
    public static final String K = "param_reportTime";
    public static final String K0 = "isDeviceIdleMode";
    public static final String L = "param_sso_ability";
    public static final String L0 = "isPowerSaveMode";
    public static final String M = "param_elapse_time";
    public static final String M0 = "isInteractive";
    public static final String N = "param_standBy_mode";
    public static final String N0 = "is_support_network";
    static final String O = "param_LoginConnect";
    public static final String O0 = "param_network_info";
    static final String P = "param_LastConnCostTime";
    public static final String P0 = "is_foreground";
    static final String Q = "param_connectContinuanceTime";
    public static final String Q0 = "is_process_died";
    static final String R = "kMsfSupportIPFlag";
    public static final String R0 = "broadcast_times";
    static final int S = 0;
    public static final String S0 = "fork_process_times";
    static final int T = 1;
    public static final String T0 = "app_info";
    static final String U = "kMsfConnectedIPFlag";
    public static final String U0 = "msg_left";
    static final int V = 0;
    public static final String V0 = "sleep_by_ipc_block_time";
    static final int W = 1;
    public static final String W0 = "dispatch_queue_size";
    static final String X = "param_activeIpFamily";
    public static final String X0 = "has_dispatch";
    static final String Y = "IPv6_from_server";
    public static final String Y0 = "dispatch_cost";
    private static final String Z = "q_consume_time";
    public static final String Z0 = "dispatch_queue_wait_time";

    /* renamed from: a0, reason: collision with root package name */
    private static final String f247788a0 = "q_length";

    /* renamed from: a1, reason: collision with root package name */
    public static final String f247789a1 = "use_new_dispatch_method";

    /* renamed from: b0, reason: collision with root package name */
    public static final String f247790b0 = "single";

    /* renamed from: b1, reason: collision with root package name */
    public static final String f247791b1 = "msf_new_probe_enable";

    /* renamed from: c0, reason: collision with root package name */
    public static final String f247792c0 = "DUAL";

    /* renamed from: c1, reason: collision with root package name */
    static HashSet<String> f247793c1 = null;

    /* renamed from: d0, reason: collision with root package name */
    public static final String f247794d0 = "complex";

    /* renamed from: d1, reason: collision with root package name */
    private static LinkedBlockingQueue<RdmReq> f247795d1 = null;

    /* renamed from: e, reason: collision with root package name */
    static final String f247796e = "MSF.C.StatReport";

    /* renamed from: e0, reason: collision with root package name */
    public static final String f247797e0 = "param_conn_try_times";

    /* renamed from: e1, reason: collision with root package name */
    private static ConcurrentHashMap<Long, Long> f247798e1 = null;

    /* renamed from: f, reason: collision with root package name */
    public static final String f247799f = "1";

    /* renamed from: f0, reason: collision with root package name */
    public static final String f247800f0 = "param_complex_conn_switch";

    /* renamed from: f1, reason: collision with root package name */
    private static long f247801f1 = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final String f247802g = "0";

    /* renamed from: g0, reason: collision with root package name */
    public static final String f247803g0 = "param_open_conn_type";

    /* renamed from: g1, reason: collision with root package name */
    public static volatile boolean f247804g1 = false;

    /* renamed from: h, reason: collision with root package name */
    public static final String f247805h = "param_Reason";

    /* renamed from: h0, reason: collision with root package name */
    public static final String f247806h0 = "param_main_socketEngine_index";

    /* renamed from: h1, reason: collision with root package name */
    private static final int f247807h1 = 5000;

    /* renamed from: i, reason: collision with root package name */
    public static final String f247808i = "param_connecttrycount";

    /* renamed from: i0, reason: collision with root package name */
    public static final String f247809i0 = "param_conn_time";

    /* renamed from: i1, reason: collision with root package name */
    private static final Object f247810i1;

    /* renamed from: j, reason: collision with root package name */
    static final String f247811j = "param_sendTime";

    /* renamed from: j0, reason: collision with root package name */
    public static final String f247812j0 = "param_active_ipFamily";

    /* renamed from: j1, reason: collision with root package name */
    private static final Object f247813j1;

    /* renamed from: k, reason: collision with root package name */
    static final String f247814k = "param_connResult";

    /* renamed from: k0, reason: collision with root package name */
    public static final String f247815k0 = "|";

    /* renamed from: k1, reason: collision with root package name */
    static Thread f247816k1 = null;

    /* renamed from: l, reason: collision with root package name */
    static final String f247817l = "param_connFailReason";

    /* renamed from: l0, reason: collision with root package name */
    public static final String f247818l0 = "process_name";

    /* renamed from: m, reason: collision with root package name */
    static final String f247819m = "param_connNetType";

    /* renamed from: m0, reason: collision with root package name */
    public static final String f247820m0 = "is_callback_null";

    /* renamed from: n, reason: collision with root package name */
    static final String f247821n = "param_connOpenNetType";

    /* renamed from: n0, reason: collision with root package name */
    public static final String f247822n0 = "is_process_exist";

    /* renamed from: o, reason: collision with root package name */
    static final String f247823o = "param_connElapseTime";

    /* renamed from: o0, reason: collision with root package name */
    public static final String f247824o0 = "service_cmd";

    /* renamed from: p, reason: collision with root package name */
    static final String f247825p = "param_localIp";

    /* renamed from: p0, reason: collision with root package name */
    public static final String f247826p0 = "wup_length";

    /* renamed from: q, reason: collision with root package name */
    static final String f247827q = "param_NetworkStatus";

    /* renamed from: q0, reason: collision with root package name */
    public static final String f247828q0 = "key_uin";

    /* renamed from: r, reason: collision with root package name */
    static final String f247829r = "param_ssoInfo";

    /* renamed from: r0, reason: collision with root package name */
    public static final String f247830r0 = "exception_time";

    /* renamed from: s, reason: collision with root package name */
    static final String f247831s = "param_liveTime";

    /* renamed from: s0, reason: collision with root package name */
    public static final String f247832s0 = "key_exception";

    /* renamed from: t, reason: collision with root package name */
    static final String f247833t = "param_sendBytes";

    /* renamed from: t0, reason: collision with root package name */
    private static final String f247834t0 = "msf_crashcontrol";

    /* renamed from: u, reason: collision with root package name */
    static final String f247835u = "param_recvBytes";

    /* renamed from: u0, reason: collision with root package name */
    private static final String f247836u0 = "starttime";

    /* renamed from: v, reason: collision with root package name */
    static final String f247837v = "param_runStatus";

    /* renamed from: v0, reason: collision with root package name */
    private static final String f247838v0 = "crashcount";

    /* renamed from: w, reason: collision with root package name */
    static final String f247839w = "param_deepSleep";

    /* renamed from: w0, reason: collision with root package name */
    private static final String f247840w0 = "shouldStopMsf";

    /* renamed from: x, reason: collision with root package name */
    static final String f247841x = "param_runStatus_new";

    /* renamed from: x0, reason: collision with root package name */
    private static final String f247842x0 = "param_background_conn_alive_time";

    /* renamed from: y, reason: collision with root package name */
    static final String f247843y = "param_isDefaultList";

    /* renamed from: y0, reason: collision with root package name */
    private static final String f247844y0 = "param_is_main_sender";

    /* renamed from: z, reason: collision with root package name */
    static final String f247845z = "param_isConnected";

    /* renamed from: z0, reason: collision with root package name */
    private static final String f247846z0 = "param_is_gray_version";

    /* renamed from: a, reason: collision with root package name */
    MsfCore f247847a;

    /* renamed from: b, reason: collision with root package name */
    public e f247848b;

    /* renamed from: c, reason: collision with root package name */
    boolean f247849c;

    /* renamed from: d, reason: collision with root package name */
    boolean f247850d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                j.this.n();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f247852a;

        /* renamed from: b, reason: collision with root package name */
        long f247853b;

        /* renamed from: c, reason: collision with root package name */
        final long f247854c;

        /* renamed from: d, reason: collision with root package name */
        final long f247855d;

        b(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f247852a = 0L;
            this.f247853b = 0L;
            this.f247854c = 5000L;
            this.f247855d = 1000L;
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (true) {
                this.f247852a = SystemClock.elapsedRealtime();
                synchronized (j.f247810i1) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(j.f247796e, 2, "try wait to report");
                        }
                        j.f247810i1.wait(5000L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f247853b = elapsedRealtime;
                if (elapsedRealtime - this.f247852a > 6000) {
                    Iterator it = j.f247798e1.entrySet().iterator();
                    while (it.hasNext()) {
                        try {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (entry != null && this.f247853b - ((Long) entry.getKey()).longValue() > j.f247801f1) {
                                it.remove();
                            }
                        } catch (Exception e17) {
                            e17.printStackTrace();
                        }
                    }
                    j.f247798e1.put(Long.valueOf(this.f247852a), Long.valueOf(this.f247853b));
                    j.b(true);
                    if (QLog.isColorLevel()) {
                        QLog.d(j.f247796e, 2, "find deep sleep. currTime:" + this.f247853b + ", lastTime:" + this.f247852a + ", sleep:" + (this.f247853b - this.f247852a));
                    }
                } else {
                    j.b(false);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f247856a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f247857b;

        c(int i3, int i16) {
            this.f247856a = i3;
            this.f247857b = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, j.this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(j.C0, String.valueOf(this.f247856a));
            hashMap.put(j.X, String.valueOf(this.f247857b));
            hashMap.put(j.N0, String.valueOf(NetConnInfoCenter.isNetSupport()));
            NetworkInfo recentNetworkInfo = NetConnInfoCenter.getRecentNetworkInfo();
            if (recentNetworkInfo != null) {
                hashMap.put(j.O0, recentNetworkInfo.getDetailedState().toString());
            }
            hashMap.put(j.K, String.valueOf(System.currentTimeMillis()));
            j statReporter = MsfService.getCore().getStatReporter();
            if (statReporter != null) {
                statReporter.a(g.E3, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f247860a;

        /* renamed from: b, reason: collision with root package name */
        public long f247861b;

        /* renamed from: c, reason: collision with root package name */
        public long f247862c;

        /* renamed from: d, reason: collision with root package name */
        public long f247863d;

        /* renamed from: e, reason: collision with root package name */
        public long f247864e;

        /* renamed from: f, reason: collision with root package name */
        public long f247865f;

        /* renamed from: g, reason: collision with root package name */
        public long f247866g;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f247795d1 = new LinkedBlockingQueue<>(100);
        f247798e1 = new ConcurrentHashMap<>();
        f247801f1 = 3600000L;
        f247804g1 = false;
        f247810i1 = new Object();
        f247813j1 = new Object();
        f247816k1 = new b("MsfCheckDeepSleepThread");
    }

    public j(MsfCore msfCore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msfCore);
            return;
        }
        this.f247849c = false;
        this.f247850d = false;
        this.f247847a = msfCore;
        com.tencent.mobileqq.msf.core.c0.b.a().b();
        q.q().post(new a());
    }

    private static boolean e() {
        return Settings.System.getInt(BaseApplication.getContext().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    private static boolean f() {
        return !MsfSdkUtils.isTopActivity(BaseApplication.getContext());
    }

    private static boolean g() {
        return !MsfSdkUtils.isScreenOn(BaseApplication.getContext());
    }

    String d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "-1";
        }
        byte b16 = activeNetworkInfo.isAvailable() ? (byte) 1 : (byte) 0;
        byte b17 = (byte) (activeNetworkInfo.isConnected() ? 2 : 0);
        if (NetConnInfoCenter.isMobileNetworkInfo(activeNetworkInfo)) {
            r4 = ((TelephonyManager) BaseApplication.getContext().getSystemService("phone")).getDataState() == 2 ? (byte) 4 : (byte) 0;
        }
        return String.valueOf((int) ((byte) (b17 | b16 | r4)));
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            a(g.S, true, 0L, 0L, (Map<String, String>) new HashMap(), false, false);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(g.m3, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(g.n3, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            f247801f1 = com.tencent.mobileqq.msf.core.x.b.D();
            f247816k1.start();
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            SharedPreferences a16 = com.tencent.mobileqq.msf.core.b0.a.b().a(f247834t0, true);
            if (a16 != null && a16.getBoolean(f247840w0, false)) {
                a("actMsfStopMsf", true, 0L, 0L, (Map<String, String>) null, true, false);
                a16.edit().putBoolean(f247840w0, false).apply();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private String a(com.tencent.mobileqq.msf.core.d dVar) {
        if (dVar == null) {
            return "null EndpointKey";
        }
        return dVar.e() + QzoneWebViewOfflinePlugin.STR_DEVIDER + dVar.b() + ":" + dVar.d();
    }

    public static byte b(boolean z16, long j3, long j16) {
        byte b16 = g() ? (byte) 1 : (byte) 0;
        byte b17 = (byte) (f() ? 2 : 0);
        if (!z16 && j3 <= j16) {
            Iterator<Map.Entry<Long, Long>> it = f247798e1.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, Long> next = it.next();
                if (j3 < next.getValue().longValue() && j16 > next.getKey().longValue()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f247796e, 2, "find deep sleep. report time:[" + j3 + ", " + j16 + "], sleep time:[" + next.getKey() + ", " + next.getValue() + "]");
                    }
                    z16 = true;
                }
            }
        }
        return (byte) (((byte) (z16 ? 4 : 0)) | b16 | b17 | ((byte) (e() ? 8 : 0)));
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
            return;
        }
        int connectedIPFamily = this.f247847a.getConnectedIPFamily();
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
        HashMap hashMap = new HashMap();
        hashMap.put(D0, String.valueOf(activeNetIpFamily));
        com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
        String str = connectedIPFamily == 1 ? g.f247663a3 : connectedIPFamily == 2 ? g.f247668b3 : g.Z2;
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(str, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (com.tencent.mobileqq.msf.core.net.utils.e.a(0, com.tencent.mobileqq.msf.core.x.d.j0()) < 1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (com.tencent.mobileqq.msf.core.net.utils.e.a(0, com.tencent.mobileqq.msf.core.x.d.k0()) < 1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
            return;
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            z17 = false;
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) {
            }
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            }
            if (z17) {
                return;
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("key_uin", MsfCore.sCore.getAccountCenter().e());
                hashMap.put("key_time", String.valueOf(System.currentTimeMillis()));
                hashMap.put("key_is_main_conn", z16 ? "1" : "0");
                if (MsfService.getCore().getStatReporter() != null) {
                    MsfService.getCore().getStatReporter().a(g.w3, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e(f247796e, 1, "report null qimei error, ", th5);
                return;
            }
        }
        z17 = true;
        if (z17) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        HashMap<String, String> f247859a;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f247859a = null;
            }
        }

        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (this.f247859a == null) {
                this.f247859a = new HashMap<>();
            }
            this.f247859a.put(str, str2);
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            HashMap<String, String> hashMap = this.f247859a;
            if (hashMap != null) {
                hashMap.clear();
            }
        }

        public void a(String str, boolean z16, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
            } else if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(str, z16, j3, j16, (Map<String, String>) this.f247859a, false, false);
            }
        }

        public void a(String str, boolean z16, long j3, long j16, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            } else if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(str, z16, j3, j16, this.f247859a, z17, z18);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f247867a;

        /* renamed from: b, reason: collision with root package name */
        private int f247868b;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f247867a = 0;
                this.f247868b = 0;
            }
        }

        public boolean a(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
            }
            int i17 = this.f247867a;
            if (i17 == 0) {
                if (i3 >= 20) {
                    this.f247867a = i3;
                }
            } else if (i3 >= i17) {
                this.f247867a = i3;
                int i18 = this.f247868b + 1;
                this.f247868b = i18;
                if (i18 >= 20) {
                    return true;
                }
            } else {
                b();
            }
            return false;
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f247867a = 0;
                this.f247868b = 0;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f247868b : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
    }

    public static long a(boolean z16, long j3, long j16) {
        long longValue;
        long longValue2;
        long j17 = 0;
        if (!z16 || j3 >= j16) {
            return 0L;
        }
        for (Map.Entry<Long, Long> entry : f247798e1.entrySet()) {
            if (j3 >= entry.getKey().longValue() && j3 <= entry.getValue().longValue()) {
                if (j16 <= entry.getValue().longValue()) {
                    return j16 - j3;
                }
                j17 = (j17 + entry.getValue().longValue()) - j3;
            } else if (j3 < entry.getKey().longValue()) {
                if (j16 >= entry.getKey().longValue() && j16 <= entry.getValue().longValue()) {
                    longValue = j17 + j16;
                    longValue2 = entry.getKey().longValue();
                } else if (j16 > entry.getValue().longValue()) {
                    longValue = j17 + entry.getValue().longValue();
                    longValue2 = entry.getKey().longValue();
                }
                j17 = longValue - longValue2;
            }
        }
        return j17;
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, z16);
            return;
        }
        HashMap hashMap = new HashMap();
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(g.f247727o3, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    static void b(boolean z16) {
        while (!f247795d1.isEmpty()) {
            try {
                RdmReq take = f247795d1.take();
                if (take != null) {
                    Map<String, String> map = take.params;
                    if (map != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        try {
                            String str = map.get(K);
                            Objects.requireNonNull(str);
                            elapsedRealtime = Long.parseLong(str);
                        } catch (NumberFormatException e16) {
                            QLog.d(f247796e, 1, "reportRDMReal parse reportTime error, ", e16);
                        }
                        long j3 = elapsedRealtime - take.elapse;
                        byte b16 = b(z16, j3, elapsedRealtime);
                        map.put(f247837v, String.valueOf((int) b16));
                        map.put(f247839w, String.valueOf(a((b16 & 4) != 0, j3, elapsedRealtime)));
                        map.put(Z, String.valueOf(take.elapse));
                        map.remove(K);
                    }
                    a(take, map);
                    String mainAccount = MsfService.getCore().getMainAccount();
                    if (mainAccount == null) {
                        mainAccount = "0";
                    }
                    String str2 = mainAccount;
                    if (TextUtils.isEmpty(take.appKey)) {
                        BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(str2, take.eventName, take.isSucceed, map, take.isRealTime);
                    } else {
                        BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(take.appKey, str2, take.eventName, take.isSucceed, map, take.isRealTime);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f247796e, 2, "report RQD IMEI:" + o.e() + " " + take.toString());
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.w(f247796e, 2, "report RQD error " + e17, e17);
                }
            }
        }
        Object obj = f247813j1;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public static long a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        long j3 = 0;
        if (toServiceMsg != null && toServiceMsg.getWupBuffer() != null) {
            j3 = 0 + toServiceMsg.getWupBuffer().length;
        }
        return (fromServiceMsg == null || fromServiceMsg.getWupBuffer() == null) ? j3 : j3 + fromServiceMsg.getWupBuffer().length;
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_uin", this.f247847a.getMainAccount());
        hashMap.put("cnt_crash", String.valueOf(i3));
        a(g.D3, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
    }

    public void a(WifiInfo wifiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) wifiInfo);
            return;
        }
        if (NetworkMonitor.getBSSID(wifiInfo) == null || NetworkMonitor.getIpAddress(wifiInfo) == 0 || wifiInfo.getSupplicantState() != SupplicantState.COMPLETED) {
            byte b16 = (byte) (NetworkMonitor.getBSSID(wifiInfo) == null ? 1 : 0);
            byte b17 = (byte) (NetworkMonitor.getIpAddress(wifiInfo) == 0 ? 2 : 0);
            int i3 = wifiInfo.getSupplicantState() != SupplicantState.COMPLETED ? 4 : 0;
            HashMap hashMap = new HashMap();
            hashMap.put("param_FailCode", String.valueOf((((byte) i3) | b16 | b17) + 5000));
            a(g.B, false, 0L, 0L, (Map<String, String>) hashMap, true, false);
        }
    }

    public void a(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), str, str2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Q, (((("" + j3) + "|") + str) + "|") + str2);
        a(g.f247711l, false, j3, 0L, (Map<String, String>) hashMap, false, false);
    }

    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        try {
            String uin = toServiceMsg.getUin();
            if (TextUtils.isEmpty(uin)) {
                return;
            }
            String str = uin + "_" + String.valueOf(System.currentTimeMillis()) + "_" + n.b(toServiceMsg) + "_" + n.b(fromServiceMsg);
            HashMap hashMap = new HashMap();
            hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, str);
            a(g.M2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(boolean z16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Long.valueOf(j3), str);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ssolist", str);
        hashMap.put("SSOListToConnectEndTime", "" + j3);
        a(g.f247703j, z16, j3, 0L, (Map<String, String>) hashMap, true, false);
    }

    public void a(boolean z16, int i3, long j3, ArrayList<o.i> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("timeConnectTestServerDiff", String.valueOf(j3));
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            hashMap.put("SSOIP" + i16, arrayList.get(i16).f248894a);
            hashMap.put("ConnTestSsoResult" + i16, String.valueOf((int) arrayList.get(i16).f248895b));
            hashMap.put("errorDetail" + i16, arrayList.get(i16).f248896c);
        }
        hashMap.put("respcode", String.valueOf(i3));
        a(g.f247707k, z16, 0L, 0L, (Map<String, String>) hashMap, true, false);
    }

    public void b(String str) {
        j statReporter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
            return;
        }
        if ((!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) && (statReporter = MsfService.core.getStatReporter()) != null) {
            int i3 = Calendar.getInstance().get(11);
            if (i3 <= 8 || i3 >= 22) {
                HashMap hashMap = new HashMap();
                String mainAccount = MsfService.getCore().getMainAccount();
                if (mainAccount == null) {
                    mainAccount = "0";
                }
                hashMap.put("param_uin", mainAccount);
                hashMap.put(K, String.valueOf(System.currentTimeMillis() / 1000));
                hashMap.put("param_action", str);
                hashMap.put(I0, String.valueOf(NetConnInfoCenter.getActiveNetworkType()));
                try {
                    hashMap.put(J0, String.valueOf(MsfService.core.isConnected()));
                    PowerManager powerManager = (PowerManager) BaseApplication.getContext().getSystemService("power");
                    Method method = powerManager.getClass().getMethod(K0, new Class[0]);
                    method.setAccessible(true);
                    hashMap.put(K0, String.valueOf(((Boolean) method.invoke(powerManager, new Object[0])).booleanValue()));
                    Method method2 = powerManager.getClass().getMethod(L0, new Class[0]);
                    method2.setAccessible(true);
                    hashMap.put(L0, String.valueOf(((Boolean) method2.invoke(powerManager, new Object[0])).booleanValue()));
                    Method method3 = powerManager.getClass().getMethod(M0, new Class[0]);
                    method3.setAccessible(true);
                    hashMap.put(M0, String.valueOf(((Boolean) method3.invoke(powerManager, new Object[0])).booleanValue()));
                } catch (Exception e16) {
                    QLog.d(f247796e, 1, e16, new Object[0]);
                }
                statReporter.a(g.A0, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        }
    }

    public void a(boolean z16, long j3, long j16, long j17, long j18, boolean z17, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, int i3, String str, boolean z18) {
        String str2;
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Boolean.valueOf(z17), arrayList, Integer.valueOf(i3), str, Boolean.valueOf(z18));
            return;
        }
        if (NetConnInfoCenter.isWifiOrMobileConn() && arrayList.size() > 0) {
            String str5 = ((("" + BaseApplication.getContext().getAppId()) + "|1") + "|" + (com.tencent.mobileqq.msf.core.c.d(BaseApplication.getContext()) + "." + com.tencent.mobileqq.msf.core.c.c(BaseApplication.getContext()))) + "|" + arrayList.get(arrayList.size() - 1).f248724g;
            String f16 = com.tencent.mobileqq.msf.core.o.f();
            if (f16 != null && f16.length() >= 5) {
                str2 = (str5 + "|" + f16.substring(0, 3)) + ":" + f16.substring(3, 5);
            } else {
                str2 = (str5 + "|000") + ":00";
            }
            String h16 = com.tencent.mobileqq.msf.core.o.h();
            if (h16 != null) {
                str3 = str2 + ":" + h16;
            } else {
                str3 = str2 + ":000";
            }
            String str6 = ((((str3 + ":false") + "|" + j3) + "|" + j16) + "|" + j17) + "|" + z17;
            if (z16) {
                str4 = str6 + "|1";
            } else {
                str4 = str6 + "|" + i3;
            }
            Iterator<com.tencent.mobileqq.msf.core.net.b> it = arrayList.iterator();
            while (it.hasNext()) {
                str4 = str4 + "|" + it.next().a();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(O, str4);
            try {
                hashMap.put(StatisticCollector.DeviceInfo.TOTALMEMORY_TAG, MsfSdkUtils.getTotalMemory());
            } catch (Exception e16) {
                QLog.d(f247796e, 1, "getTotalMemoey error " + e16);
            }
            try {
                hashMap.put(StatisticCollector.DeviceInfo.RESOLUTION_TAG, MsfSdkUtils.getResolutionString(BaseApplication.getContext()));
            } catch (Exception e17) {
                QLog.d(f247796e, 1, "getResilution error " + e17);
            }
            try {
                hashMap.put(f247841x, String.valueOf((int) com.tencent.mobileqq.msf.core.net.o.R));
            } catch (Exception e18) {
                QLog.d(f247796e, 1, "get new status error " + e18.toString());
            }
            try {
                hashMap.put(P, String.valueOf(j18));
            } catch (Exception e19) {
                QLog.d(f247796e, 1, "get last conncost error " + e19.toString());
            }
            if (QLog.isColorLevel()) {
                QLog.d(f247796e, 2, "get report status " + ((String) hashMap.get(f247837v)));
                QLog.d(f247796e, 2, "get report new status " + String.valueOf((int) com.tencent.mobileqq.msf.core.net.o.R));
            }
            hashMap.put(X, NetConnInfoCenter.getActiveNetIpFamily(true) + "");
            hashMap.put("policy_id", TextUtils.isEmpty(str) ? "policy_default" : str);
            hashMap.put(Y, String.valueOf(z18));
            int connectedIPFamily = this.f247847a.getConnectedIPFamily();
            if (j17 != -1) {
                if (connectedIPFamily == 1) {
                    a(g.f247699i, z16, j3 + j17, 0L, (Map<String, String>) hashMap, false, false);
                    return;
                } else if (connectedIPFamily == 2) {
                    a(g.f247694h, z16, j3 + j17, 0L, (Map<String, String>) hashMap, false, false);
                    return;
                } else {
                    a(g.f247689g, z16, j3 + j17, 0L, (Map<String, String>) hashMap, false, false);
                    return;
                }
            }
            if (connectedIPFamily == 1) {
                a(g.f247699i, z16, j3, 0L, (Map<String, String>) hashMap, false, false);
            } else if (connectedIPFamily == 2) {
                a(g.f247694h, z16, j3, 0L, (Map<String, String>) hashMap, false, false);
            } else {
                a(g.f247689g, z16, j3, 0L, (Map<String, String>) hashMap, false, false);
            }
        }
    }

    public void a(boolean z16, boolean z17, boolean z18, long j3, int i3, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j3), Integer.valueOf(i3), arrayList, arrayList2);
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(f247797e0, String.valueOf(arrayList.size()));
            hashMap.put(f247800f0, String.valueOf(com.tencent.mobileqq.msf.core.b.f().g()));
            hashMap.put(f247803g0, z17 ? f247792c0 : z18 ? f247794d0 : "single");
            hashMap.put(f247806h0, String.valueOf(i3));
            hashMap.put(F, this.f247847a.getGatewayIp());
            StringBuilder sb5 = new StringBuilder();
            Iterator<com.tencent.mobileqq.msf.core.net.b> it = arrayList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append("|");
            }
            if (z17) {
                sb5.append(" $$ ");
                Iterator<com.tencent.mobileqq.msf.core.net.b> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    sb5.append(it5.next().toString());
                    sb5.append("|");
                }
            }
            String sb6 = sb5.toString();
            if (sb6.endsWith("|")) {
                sb6 = sb6.substring(0, sb6.length() - 1);
            }
            hashMap.put(f247814k, sb6);
            hashMap.put(f247809i0, String.valueOf(j3));
            hashMap.put(f247812j0, String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
            hashMap.put("param_uin", this.f247847a.getAccountCenter().e());
            a(g.f247684f, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
        } catch (Exception e16) {
            QLog.d(f247796e, 1, "reportMainOpenConnection failed", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2 A[LOOP:0: B:16:0x00a9->B:18:0x00b2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z16, boolean z17, boolean z18, long j3, ArrayList<com.tencent.mobileqq.msf.core.net.b> arrayList) {
        boolean z19;
        boolean z26;
        Iterator<com.tencent.mobileqq.msf.core.net.b> it;
        String sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(j3), arrayList);
            return;
        }
        HashMap hashMap = new HashMap();
        if (!z18 && arrayList.size() > 0) {
            hashMap.put(f247805h, String.valueOf(arrayList.get(arrayList.size() - 1).f248722e));
            if (arrayList.get(arrayList.size() - 1).f248722e == com.tencent.mobileqq.msf.core.net.q.f248935m) {
                z26 = false;
                z19 = true;
            } else if (arrayList.get(arrayList.size() - 1).f248722e == com.tencent.mobileqq.msf.core.net.q.f248931i) {
                z19 = false;
                z26 = true;
            }
            hashMap.put(F, this.f247847a.getGatewayIp());
            hashMap.put("param_FailCode", String.valueOf(arrayList.size()));
            StringBuilder sb6 = new StringBuilder();
            it = arrayList.iterator();
            while (it.hasNext()) {
                sb6.append(it.next().toString() + "|");
            }
            sb5 = sb6.toString();
            if (sb5.endsWith("|")) {
                sb5 = sb5.substring(0, sb5.length() - 1);
            }
            hashMap.put(f247814k, sb5);
            if (!z18) {
                hashMap.put(f247825p, com.tencent.mobileqq.msf.core.o.d());
                hashMap.put(f247827q, d());
            }
            if (!z16) {
                if (z17) {
                    a(g.f247664b, z18, j3, 0, (Map<String, String>) hashMap, true, false);
                    return;
                } else {
                    a(g.f247669c, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                    return;
                }
            }
            if (z17) {
                if (g()) {
                    a(g.f247715m, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                    return;
                } else {
                    a(g.f247674d, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                    return;
                }
            }
            if (g()) {
                if (z19) {
                    a(g.f247728p, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                    return;
                } else if (z26) {
                    a(g.f247738r, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                    return;
                } else {
                    a(g.f247719n, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                    return;
                }
            }
            if (z19) {
                a(g.f247723o, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                return;
            } else if (z26) {
                a(g.f247733q, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                return;
            } else {
                a(g.f247679e, z18, j3, 0, (Map<String, String>) hashMap, false, false);
                return;
            }
        }
        z19 = false;
        z26 = false;
        hashMap.put(F, this.f247847a.getGatewayIp());
        hashMap.put("param_FailCode", String.valueOf(arrayList.size()));
        StringBuilder sb62 = new StringBuilder();
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        sb5 = sb62.toString();
        if (sb5.endsWith("|")) {
        }
        hashMap.put(f247814k, sb5);
        if (!z18) {
        }
        if (!z16) {
        }
    }

    public void a(boolean z16, long j3, com.tencent.mobileqq.msf.core.d dVar, com.tencent.qphone.base.a aVar, int i3, long j16, long j17, long j18, String str, String str2, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Long.valueOf(j3), dVar, aVar, Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), str, str2, Boolean.valueOf(z17));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(f247821n, String.valueOf(i3));
        hashMap.put(f247829r, a(dVar));
        hashMap.put(f247831s, String.valueOf(j16));
        hashMap.put(f247833t, String.valueOf(j17));
        hashMap.put(f247835u, String.valueOf(j18));
        hashMap.put("param_FailCode", String.valueOf(aVar.ordinal() + g.Y1));
        hashMap.put(f247805h, aVar.toString());
        hashMap.put(Q, (((("" + j3) + "|") + str) + "|") + str2);
        try {
            hashMap.put("param_uin", MsfService.getCore().getAccountCenter().e());
            hashMap.put(f247844y0, String.valueOf(z17));
        } catch (Exception e16) {
            QLog.d(f247796e, 1, "[reportConnClose] get param error!", e16);
        }
        if (g()) {
            a(g.D, z16, j3, 0, (Map<String, String>) hashMap, false, false);
        } else {
            a(g.C, z16, j3, 0, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(long j3, int i3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16));
        } else if (NetConnInfoCenter.isWifiOrMobileConn()) {
            HashMap hashMap = new HashMap();
            hashMap.put("param_FailCode", String.valueOf(i3));
            a(g.G, false, j3, j16, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(boolean z16, String str, long j3, int i3, long j16, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), str2, str3);
            return;
        }
        if (NetConnInfoCenter.isWifiOrMobileConn()) {
            HashMap hashMap = new HashMap();
            hashMap.put("param_FailCode", String.valueOf(i3));
            hashMap.put(J, String.valueOf(str2));
            hashMap.put("param_uin", str);
            hashMap.put(B, str3);
            hashMap.put(C, com.tencent.mobileqq.msf.core.o.e());
            a(g.H, z16, j3, j16, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(boolean z16, long j3, int i3, long j16, boolean z17, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Boolean.valueOf(z17), Long.valueOf(j17));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("param_FailCode", String.valueOf(i3 + 3000));
        hashMap.put(E, MsfService.getCore().getNowUsedSsoAddress());
        hashMap.put(f247805h, String.valueOf(z17));
        hashMap.put(f247811j, String.valueOf(j17));
        a(g.J, z16, j3, j16, (Map<String, String>) hashMap, false, false);
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("param_FailCode", String.valueOf(4015));
        hashMap.put(f247805h, String.valueOf(z16));
        a(g.K, false, 0L, 0L, (Map<String, String>) hashMap, false, false);
    }

    public void a(String str, boolean z16, long j3, int i3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16));
            return;
        }
        if (NetConnInfoCenter.isWifiOrMobileConn()) {
            if (f247793c1 == null) {
                f247793c1 = new HashSet<>();
            }
            if (f247793c1.contains(str)) {
                return;
            }
            f247793c1.add(str);
            HashMap hashMap = new HashMap();
            hashMap.put("param_uin", str);
            hashMap.put("param_FailCode", String.valueOf(i3));
            a(g.L, z16, j3, j16, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(boolean z16, long j3, int i3, long j16, boolean z17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Boolean.valueOf(z17), str);
            return;
        }
        if (NetConnInfoCenter.isWifiOrMobileConn()) {
            HashMap hashMap = new HashMap();
            hashMap.put(f247805h, str);
            if (!z17) {
                hashMap.put("param_FailCode", String.valueOf(i3 + g.S0));
                if (g()) {
                    a(g.O, z16, j3, j16, (Map<String, String>) hashMap, false, false);
                    return;
                } else {
                    a(g.M, z16, j3, j16, (Map<String, String>) hashMap, false, false);
                    return;
                }
            }
            hashMap.put("param_FailCode", String.valueOf(i3 + g.T0));
            if (g()) {
                a(g.P, z16, j3, j16, (Map<String, String>) hashMap, false, false);
            } else {
                a(g.N, z16, j3, j16, (Map<String, String>) hashMap, false, false);
            }
        }
    }

    public void a(boolean z16, long j3, int i3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16));
            return;
        }
        if (NetConnInfoCenter.isWifiOrMobileConn()) {
            HashMap hashMap = new HashMap();
            hashMap.put("param_FailCode", String.valueOf(i3 + g.U0));
            if (g()) {
                a(g.R, z16, j3, j16, (Map<String, String>) hashMap, false, false);
            } else {
                a(g.Q, z16, j3, j16, (Map<String, String>) hashMap, false, false);
            }
        }
    }

    public void a(String str, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            a("", str, z16, j3, j16, map, z17, false, z18);
        } else {
            iPatchRedirector.redirect((short) 22, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), map, Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    public void a(String str, String str2, boolean z16, long j3, long j16, Map<String, String> map, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), map, Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        if (com.tencent.mobileqq.msf.core.x.b.f250191v.contains(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(f247796e, 2, str2 + " is not need report.");
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.msf.core.c0.b.a().a(str2)) {
            if (f247804g1) {
                f247804g1 = false;
                h();
            }
            a(map, j3, j16);
            try {
                RdmReq rdmReq = new RdmReq();
                rdmReq.eventName = str2;
                rdmReq.elapse = j3;
                rdmReq.size = j16;
                rdmReq.isSucceed = z16;
                rdmReq.isRealTime = z17;
                rdmReq.isMerge = z19;
                rdmReq.params = map;
                rdmReq.appKey = str;
                rdmReq.isImmediatelyUpload = z18;
                if (f247795d1.offer(rdmReq)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f247796e, 2, "wait queue is full, try notify to start report");
                }
                Object obj = f247810i1;
                synchronized (obj) {
                    obj.notifyAll();
                }
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    Object obj2 = f247813j1;
                    synchronized (obj2) {
                        try {
                            obj2.wait(5000L);
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                        if (!f247795d1.offer(rdmReq) && QLog.isColorLevel()) {
                            QLog.d(f247796e, 2, "offer fail finally");
                        }
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.w(f247796e, 2, "report RQD error " + e17, e17);
                }
            }
        }
    }

    private void a(Map<String, String> map, long j3, long j16) {
        if (map == null) {
            return;
        }
        try {
            map.put(E0, String.valueOf(BaseApplication.getContext().getAppId()));
            map.put(M, String.valueOf(j3));
            map.put(f247788a0, String.valueOf(j16));
            map.put(f247846z0, String.valueOf(BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()));
            map.put(A0, com.tencent.mobileqq.msf.core.o.i());
            map.put(F0, String.valueOf(com.tencent.mobileqq.msf.core.x.d.a1()));
            map.put(G0, String.valueOf(com.tencent.mobileqq.msf.core.x.d.b1()));
            map.put(P0, String.valueOf(com.tencent.mobileqq.msf.core.y.a.h().i()));
            int systemNetworkType = NetConnInfoCenter.getSystemNetworkType();
            map.put(C0, String.valueOf(systemNetworkType));
            if (map.containsKey(BaseConstants.RDM_NoChangeFailCode)) {
                map.remove(BaseConstants.RDM_NoChangeFailCode);
            } else if (systemNetworkType == 0) {
                map.put("param_FailCode", "900");
            }
            if (!map.containsKey(D0)) {
                map.put(D0, String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
            }
            if (!map.containsKey(K)) {
                map.put(K, String.valueOf(System.currentTimeMillis()));
            }
            if (!map.containsKey("param_uin")) {
                String mainAccount = MsfService.getCore().getMainAccount();
                if (mainAccount == null) {
                    mainAccount = "0";
                }
                map.put("param_uin", mainAccount);
            }
            map.put(N, String.valueOf(this.f247847a.getStandByModeManager() != null && this.f247847a.getStandByModeManager().i()));
            com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.getCore().getMsfNetService();
            if (msfNetService != null) {
                map.put(B0, msfNetService.g());
                map.put(R, this.f247847a.hasIPV6List() ? String.valueOf(1) : String.valueOf(0));
                map.put(U, this.f247847a.getConnectedIPFamily() == 2 ? String.valueOf(1) : String.valueOf(0));
                map.put(f247845z, String.valueOf(this.f247847a.isConnected()));
                map.put(L, String.valueOf(this.f247847a.isSupportNewSSO()));
                map.put(E, this.f247847a.getNowUsedSsoAddress());
            }
            map.put(f247789a1, String.valueOf(com.tencent.mobileqq.msf.core.x.m.k()));
            map.put(f247791b1, String.valueOf(com.tencent.mobileqq.msf.core.x.d.i0()));
        } catch (Exception e16) {
            QLog.e(f247796e, 1, "fillCommonParams error, ", e16);
        }
    }

    private static void a(RdmReq rdmReq, Map<String, String> map) {
        if (StatisticCollector.C2C_PICDOWN_STATISTIC_TAG.equalsIgnoreCase(rdmReq.eventName) || StatisticCollector.C2C_SMAILLPICDOWN_STATISTIC_TAG.equalsIgnoreCase(rdmReq.eventName) || StatisticCollector.TROOP_PIC_DOWNLOAD_STATISTIC_TAG.equalsIgnoreCase(rdmReq.eventName) || StatisticCollector.TROOP_SMAILLPIC_DOWNLOAD_STATISTIC_TAG.equalsIgnoreCase(rdmReq.eventName)) {
            map.put("param_msfcheck_result", String.valueOf(rdmReq.isSucceed));
            rdmReq.eventName = "check_" + rdmReq.eventName;
        }
    }

    public void a(String str, String str2, boolean z16, long j3, long j16, long j17, long j18, long j19, long j26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f247796e, 2, "reportCloseConnForAlarm type:" + str + ",isEffective:" + z16 + ",saveTime:" + j3);
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("param_reportType", str);
            hashMap.put("param_uin", str2);
            hashMap.put("param_saveCost", String.valueOf(j3));
            hashMap.put("param_isEffective", String.valueOf(z16));
            if (!z16) {
                hashMap.put("param_timeforten", String.valueOf(j16));
                hashMap.put("param_timeforsix", String.valueOf(j17));
                hashMap.put("param_timeforalarm", String.valueOf(j18));
                hashMap.put("param_timeforlastrecv", String.valueOf(j19));
                hashMap.put("param_timeforcloseconn", String.valueOf(j26));
            }
            a("dim.Msf.CloseConnForAlarm", false, j3, 0L, (Map<String, String>) hashMap, false, false);
        } catch (Exception e16) {
            QLog.d(f247796e, 1, "reportCloseConnForAlarm error!", e16);
        }
    }

    public void a(String str, String str2, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            a(str, str2, z16, j3, 0L, 0L, 0L, 0L, 0L);
        } else {
            iPatchRedirector.redirect((short) 25, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    public void a(String str, int i3, long j3, int i16, long j16, long j17, long j18, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Boolean.valueOf(z16));
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("pm_uin", MsfService.getCore().getAccountCenter().e());
            hashMap.put("pm_cmd", str);
            hashMap.put("pm_ssoseq", String.valueOf(i3));
            hashMap.put("pm_failcode", String.valueOf(i16));
            hashMap.put("pm_sendwupsize", String.valueOf(j16));
            hashMap.put("pm_recvwupsize", String.valueOf(j17));
            hashMap.put("pm_reqpacksize", String.valueOf(j18));
            hashMap.put("pm_senddataerror", String.valueOf(z16));
            hashMap.put("pm_imsi", com.tencent.mobileqq.msf.core.o.f());
            hashMap.put("pm_nettype", String.valueOf(NetConnInfoCenter.getSystemNetworkType()));
            int i17 = d.a.f392524g;
            d.a.f392524g = 0;
            hashMap.put("pm_reqCount", String.valueOf(i17));
            hashMap.put("param_FailCode", String.valueOf(i16));
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            a(g.D0, false, j3, j18, (Map<String, String>) hashMap, false, false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void a(boolean z16, long j3, long j16, long j17, long j18, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(K0, String.valueOf(z16));
        hashMap.put("takeTimes", String.valueOf(j3));
        hashMap.put(L0, String.valueOf(z17));
        hashMap.put(M0, String.valueOf(z18));
        hashMap.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        if (j16 > 0) {
            hashMap.put("alarmCost", String.valueOf(j16));
        }
        if (j17 > 0) {
            hashMap.put("screenOffCost", String.valueOf(j17));
            if (j18 > 0) {
                hashMap.put("connFailCost", String.valueOf(j18));
            }
        }
        a(g.f247756u2, true, j3, 0L, (Map<String, String>) hashMap, false, false);
    }

    public static void a(String str, boolean z16, int i3, String str2) {
        try {
            String libActualName = SoLoadCore.getLibActualName(str);
            HashMap hashMap = new HashMap();
            String str3 = "null";
            hashMap.put("libname", TextUtils.isEmpty(libActualName) ? "null" : libActualName);
            hashMap.put("isLoaded", String.valueOf(z16));
            hashMap.put(QzoneIPCModule.RESULT_CODE, String.valueOf(i3));
            if (str2 == null) {
                str2 = "null";
            }
            hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, str2);
            hashMap.put("qq", MsfCore.sCore.getAccountCenter().e());
            hashMap.put("lib_crc32", String.valueOf(com.tencent.mobileqq.msf.core.o.a(BaseApplication.getContext(), SoLoadCore.PATH_LIB + libActualName)));
            hashMap.put("libarm_crc32_64", String.valueOf(com.tencent.mobileqq.msf.core.o.a(BaseApplication.getContext(), "/lib/arm64-v8a/" + libActualName)));
            hashMap.put("assets_crc32_64", String.valueOf(com.tencent.mobileqq.msf.core.o.a(BaseApplication.getContext(), "/assets/lib/arm64-v8a/" + libActualName)));
            hashMap.put("txlib_crc32", String.valueOf(com.tencent.mobileqq.msf.core.o.a(BaseApplication.getContext(), SoLoadCore.PATH_TX_LIB + libActualName)));
            if (com.tencent.mobileqq.msf.core.o.e() != null) {
                str3 = com.tencent.mobileqq.msf.core.o.e();
            }
            hashMap.put("imei", str3);
            hashMap.put("platform", com.tencent.mobileqq.msf.core.c.h(BaseApplication.getContext()));
            hashMap.put("product", Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel());
            if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(g.B2, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        } catch (Exception e16) {
            QLog.e(f247796e, 1, "[reportMsfLoadSoError] ", e16);
        }
    }

    public static void a(int i3, boolean z16) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("key_uin", MsfService.getCore().getMainAccount());
            hashMap.put("key_appId", String.valueOf(i3));
            hashMap.put("key_switch", String.valueOf(z16));
            hashMap.put("key_time", String.valueOf(System.currentTimeMillis()));
            j statReporter = MsfService.getCore().getStatReporter();
            if (statReporter != null) {
                statReporter.a(g.B3, false, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        } catch (Exception e16) {
            QLog.e(f247796e, 1, "reportMsfGetAppIdError, ", e16);
        }
    }

    public void a(boolean z16, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Boolean.valueOf(z16), str, obj);
            return;
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || !com.tencent.mobileqq.msf.core.quicksend.b.e()) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("conned", String.valueOf(z16));
            hashMap.put("exception", str);
            String str2 = Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel() + "_" + Build.VERSION.SDK_INT;
            hashMap.put("product", str2);
            hashMap.put("netType", String.valueOf(NetConnInfoCenter.getActiveNetworkType()));
            hashMap.put("uin", MsfCore.sCore.getAccountCenter().e());
            hashMap.put("time", String.valueOf(System.currentTimeMillis()));
            NetworkInfo a16 = com.tencent.mobileqq.msf.core.net.m.a(BaseApplication.getContext(), (Network) obj);
            hashMap.put("netInfo", String.valueOf(a16 == null ? "null" : a16.toString()));
            hashMap.put("param_FailCode", str2);
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            a(g.E2, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, str, Long.valueOf(j3));
            return;
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            return;
        }
        try {
            String currentThreadStackString = MsfSdkUtils.getCurrentThreadStackString();
            QLog.w("MSF.C.NetConnTag.", 1, "reportWorkerThreadHeld statck=" + currentThreadStackString);
            HashMap hashMap = new HashMap();
            hashMap.put("uin", MsfCore.sCore.getAccountCenter().e());
            hashMap.put("time", MsfCore.sCore.getAccountCenter().e() + "_" + String.valueOf(System.currentTimeMillis()));
            hashMap.put("msg", str);
            hashMap.put("stack", MsfCore.sCore.getAccountCenter().e() + "_" + String.valueOf(System.currentTimeMillis()) + " " + currentThreadStackString);
            a(g.F2, true, j3, 0L, (Map<String, String>) hashMap, false, false);
            com.tencent.mobileqq.msf.sdk.report.a.a(new com.tencent.mobileqq.msf.sdk.report.b("MSF-Worker Held"), "MSFWorkerHeldCatchedException", "MSF Worker\u7ebf\u7a0b\u963b\u585e2\u5206\u949f");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Boolean.valueOf(z16), toServiceMsg, fromServiceMsg);
            return;
        }
        if (this.f247849c) {
            return;
        }
        this.f247849c = true;
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(MsfCore.sCore.getAccountCenter().e());
            sb5.append("_");
            sb5.append(String.valueOf(System.currentTimeMillis()));
            sb5.append("_");
            sb5.append(z16 ? toServiceMsg.getShortStringForLog() : fromServiceMsg.getShortStringForLog());
            String sb6 = sb5.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("uin", MsfCore.sCore.getAccountCenter().e());
            hashMap.put("time", String.valueOf(System.currentTimeMillis()));
            hashMap.put("msg", sb6);
            hashMap.put("from", fromServiceMsg != null ? fromServiceMsg.getStringForLog() : "null");
            hashMap.put("to", toServiceMsg != null ? toServiceMsg.getStringForLog() : "null");
            if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(g.J2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        if (this.f247850d) {
            return;
        }
        try {
            String e16 = MsfCore.sCore.getAccountCenter().e();
            if (TextUtils.isEmpty(e16)) {
                return;
            }
            String str2 = e16 + "_" + String.valueOf(System.currentTimeMillis());
            HashMap hashMap = new HashMap();
            hashMap.put("uin", MsfCore.sCore.getAccountCenter().e());
            hashMap.put("msg", str2);
            hashMap.put("sockImpl", str);
            hashMap.put("androidVer", String.valueOf(Build.VERSION.SDK_INT));
            a(g.L2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, str2, str3, str4);
            return;
        }
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() + "_" + str + "_" + str2 + " " + str3 + "_" + str4);
            HashMap hashMap = new HashMap();
            hashMap.put("uin", String.valueOf(str));
            hashMap.put("type", String.valueOf(str3));
            hashMap.put("msg", valueOf);
            hashMap.put("exception", String.valueOf(str4));
            hashMap.put("processName", String.valueOf(str2));
            a("msf_core_DeadObjectException", true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void a(long j3, long j16, int i3) {
        String str = i3 == 1 ? g.X2 : i3 == 2 ? g.Y2 : g.W2;
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
        HashMap hashMap = new HashMap();
        hashMap.put("packetLossRat", String.valueOf((((float) j3) * 0.75f) / ((float) j16)));
        hashMap.put(D0, String.valueOf(activeNetIpFamily));
        com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(str, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            a(j3, j16, this.f247847a.getConnectedIPFamily());
        } else {
            iPatchRedirector.redirect((short) 36, this, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public void a(boolean z16, long j3, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), Long.valueOf(j3), str, Integer.valueOf(i3));
            return;
        }
        String str2 = i3 == 1 ? g.f247693g3 : i3 == 2 ? g.f247698h3 : g.f247688f3;
        HashMap hashMap = new HashMap();
        hashMap.put("address", str);
        hashMap.put(BaseConstants.KEY_CONN_COST, String.valueOf(j3));
        com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
        hashMap.put("supportIpfamily", String.valueOf(NetConnInfoCenter.getActiveNetIpFamily(false)));
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(str2, z16, j3, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(boolean z16, long j3, boolean z17, long j16, boolean z18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Boolean.valueOf(z16), Long.valueOf(j3), Boolean.valueOf(z17), Long.valueOf(j16), Boolean.valueOf(z18), str);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("address", str);
        hashMap.put("dualCostV4", String.valueOf(j3));
        hashMap.put("succV4", String.valueOf(z17));
        hashMap.put("dualCostV6", String.valueOf(j16));
        hashMap.put("succV6", String.valueOf(z18));
        hashMap.put("succip", String.valueOf(str));
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(g.i3, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, j3);
            return;
        }
        int connectedIPFamily = this.f247847a.getConnectedIPFamily();
        String str = connectedIPFamily == 1 ? g.k3 : connectedIPFamily == 2 ? g.l3 : g.j3;
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
        if (MsfService.getCore().getStatReporter() != null) {
            MsfService.getCore().getStatReporter().a(str, true, j3, 0L, (Map<String, String>) hashMap, false, false);
        }
    }

    public void a(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("key_uin", MsfCore.sCore.getAccountCenter().e());
            hashMap.put("key_sendUin", str2);
            hashMap.put("key_time", String.valueOf(System.currentTimeMillis()));
            hashMap.put("key_cmd", str);
            hashMap.put("key_isBlockNoLoginSend", z16 ? "1" : "0");
            if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a(g.C3, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        } catch (Throwable th5) {
            QLog.e(f247796e, 1, "report block no login send error, ", th5);
        }
    }

    public void a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 47)) {
            q.s().post(new c(i3, i16));
        } else {
            iPatchRedirector.redirect((short) 47, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
