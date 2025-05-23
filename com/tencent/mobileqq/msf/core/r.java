package com.tencent.mobileqq.msf.core;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.monitor.MSFConnectOpenNotifyMonitor;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.q.a;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.mobileqq.msf.nt.MsfConnOpen$MsfRenotifyConnOpen;

/* compiled from: P */
/* loaded from: classes15.dex */
public class r implements a.c {
    static IPatchRedirector $redirector_ = null;
    public static final int A = 100;

    /* renamed from: o, reason: collision with root package name */
    public static final String f249914o = "MSF.D.NetCenterNewImpl";

    /* renamed from: p, reason: collision with root package name */
    public static MsfCore f249915p = null;

    /* renamed from: q, reason: collision with root package name */
    private static final String f249916q = "servetTimeDiff";

    /* renamed from: r, reason: collision with root package name */
    public static final String f249917r = "recordSysTimeKey";

    /* renamed from: s, reason: collision with root package name */
    private static long f249918s = -1;

    /* renamed from: t, reason: collision with root package name */
    private static long f249919t = 0;

    /* renamed from: u, reason: collision with root package name */
    private static final String f249920u = "dozeWhiteList";

    /* renamed from: v, reason: collision with root package name */
    private static final String f249921v = "keyDozeLastTime";

    /* renamed from: w, reason: collision with root package name */
    private static final long f249922w = 86400000;

    /* renamed from: x, reason: collision with root package name */
    public static final int f249923x = 31;

    /* renamed from: y, reason: collision with root package name */
    private static final int f249924y = 5000;

    /* renamed from: z, reason: collision with root package name */
    private static final Runnable f249925z;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.msf.sdk.q.a f249926a;

    /* renamed from: b, reason: collision with root package name */
    private String f249927b;

    /* renamed from: c, reason: collision with root package name */
    private ThreadLocal<Boolean> f249928c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f249929d;

    /* renamed from: e, reason: collision with root package name */
    private ThreadLocal<Long> f249930e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f249931f;

    /* renamed from: g, reason: collision with root package name */
    private CopyOnWriteArrayList<h> f249932g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicBoolean f249933h;

    /* renamed from: i, reason: collision with root package name */
    private long f249934i;

    /* renamed from: j, reason: collision with root package name */
    private long f249935j;

    /* renamed from: k, reason: collision with root package name */
    private int f249936k;

    /* renamed from: l, reason: collision with root package name */
    private long f249937l;

    /* renamed from: m, reason: collision with root package name */
    int f249938m;

    /* renamed from: n, reason: collision with root package name */
    int f249939n;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), r.f249915p.getNextSeq(), "0", BaseConstants.CMD_RE_NOTIFY_CONN_OPENED);
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.setRequestSsoSeq(r.f249915p.getNextSeq());
            fromServiceMsg.setMsfCommand(MsfCommand.reNotifyConnOpened);
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_IS_TEST_ENV, Boolean.valueOf(com.tencent.mobileqq.msf.core.e0.k.c().d()));
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_IP_FAMILY, Integer.valueOf(r.f249915p.getConnectedIPFamily()));
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_CONNSEQ, Long.valueOf(r.f249915p.getConnSeq()));
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, Long.valueOf(r.f249915p.getServiceInitTime()));
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, Long.valueOf(r.f249915p.getServiceReadyTime()));
            com.tencent.mobileqq.msf.core.push.h pushManager = r.f249915p.getPushManager();
            if (pushManager != null && pushManager.r()) {
                fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
            }
            MsfConnOpen$MsfRenotifyConnOpen msfConnOpen$MsfRenotifyConnOpen = new MsfConnOpen$MsfRenotifyConnOpen();
            msfConnOpen$MsfRenotifyConnOpen.conn_seq.set(r.f249915p.getConnSeq());
            fromServiceMsg.putWupBuffer(MsfSdkUtils.addByteLen(msfConnOpen$MsfRenotifyConnOpen.toByteArray()));
            MsfSdkUtils.addFromMsgProcessName(MsfSdkUtils.getMainProcessName(), fromServiceMsg);
            MsfService.getCore().addRespToQuque(null, fromServiceMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.msf.core.d0.a.c().e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f249941a;

        c(Context context) {
            this.f249941a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this, (Object) context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                LocationMonitor.listen((TelephonyManager) this.f249941a.getSystemService("phone"), new i(r.this, null), 256);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.msf.core.push.h f249943a;

        d(com.tencent.mobileqq.msf.core.push.h hVar) {
            this.f249943a = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this, (Object) hVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d(r.f249914o, 1, "MSF_Alive_Log do register alarm by device ,interval = " + this.f249943a.n());
            com.tencent.mobileqq.msf.core.push.h hVar = this.f249943a;
            hVar.a(hVar.n());
            this.f249943a.f249748o = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f249945a;

        e(Context context) {
            this.f249945a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this, (Object) context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            g gVar = new g(r.this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            this.f249945a.registerReceiver(gVar, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final r f249947a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14797);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f249947a = new r(null);
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class g extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f249949a;

            a(Context context) {
                this.f249949a = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    r.this.a(this.f249949a);
                    r.this.L();
                }
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(r.f249914o, 2, "idleChaned receive broadcast intent == null return");
                    return;
                }
                return;
            }
            QLog.d(r.f249914o, 1, "idleChaned receive broadcast " + intent);
            if (intent.getAction() == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(r.f249914o, 2, "idleChaned receive broadcast intent.getAction() == null return");
                }
            } else if (intent.getAction().equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                q.s().post(new a(context));
            }
        }

        /* synthetic */ g(r rVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rVar, (Object) aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface h {
        void a();

        void a(int i3, int i16);

        void a(String str, int i3);

        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private class i extends PhoneStateListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) signalStrength);
                return;
            }
            super.onSignalStrengthsChanged(signalStrength);
            r.this.f249939n = signalStrength.getCdmaDbm();
            int gsmSignalStrength = signalStrength.getGsmSignalStrength();
            if (gsmSignalStrength == 99) {
                gsmSignalStrength = -3;
            }
            r.this.f249938m = gsmSignalStrength;
        }

        /* synthetic */ i(r rVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rVar, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24462);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f249925z = new a();
        }
    }

    /* synthetic */ r(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    private void E() {
        MsfCore msfCore;
        com.tencent.mobileqq.msf.core.g0.a aVar;
        if (z() && (msfCore = f249915p) != null && (aVar = msfCore.standbyModeManager) != null) {
            aVar.m();
        }
    }

    private void K() {
        if (this.f249926a.b() > 0 && this.f249933h.get()) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247805h, String.valueOf((System.currentTimeMillis() - this.f249934i) / 1000));
            hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247808i, String.valueOf(this.f249926a.b()));
            if (f249915p.getStatReporter() != null) {
                f249915p.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247771y, false, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void L() {
        byte b16;
        int i3;
        if (Math.random() <= 0.01d) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false) {
            try {
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(f249920u, 0);
                if (Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(f249921v, 0L)) >= 86400000) {
                    int i16 = Build.VERSION.SDK_INT;
                    boolean isIgnoringBatteryOptimizations = ((PowerManager) BaseApplication.getContext().getSystemService("power")).isIgnoringBatteryOptimizations(BaseApplication.getContext().getPackageName());
                    if (i16 >= 24) {
                        i3 = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getRestrictBackgroundStatus();
                    } else {
                        i3 = -1;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder(30);
                        sb5.append("report:");
                        sb5.append(", ");
                        sb5.append(isIgnoringBatteryOptimizations ? 1 : 0);
                        sb5.append(", ");
                        sb5.append(DeviceInfoMonitor.getModel());
                        sb5.append(", ");
                        sb5.append(Build.MANUFACTURER);
                        sb5.append(", ");
                        sb5.append(i3);
                        QLog.d(f249914o, 1, sb5.toString());
                    }
                    HashMap hashMap = new HashMap(10);
                    hashMap.put("osVersion", i16 + "");
                    hashMap.put("ignoreBat", String.valueOf(isIgnoringBatteryOptimizations ? 1 : 0));
                    hashMap.put("model", DeviceInfoMonitor.getModel());
                    hashMap.put("manufacture", Build.MANUFACTURER);
                    hashMap.put("restrictBgStatus", String.valueOf(i3));
                    com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
                    f249915p.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.O2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
                sharedPreferences.edit().putLong(f249921v, System.currentTimeMillis()).commit();
            } catch (Throwable th5) {
                QLog.d(f249914o, 1, "report doze whiteList exception ", th5);
            }
        }
    }

    private void M() {
        this.f249933h.set(false);
        this.f249934i = 0L;
    }

    private void N() {
        if (f249915p != null) {
            ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", BaseConstants.CMD_GETTIMENEW);
            toServiceMsg.setMsfCommand(MsfCommand.getServerTime);
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.setTimeout(30000L);
            toServiceMsg.setRequestSsoSeq(f249915p.getNextSeq());
            toServiceMsg.addAttribute(BaseConstants.Attribute_TAG_ISAPPMSG, Boolean.TRUE);
            toServiceMsg.putWupBuffer(MsfSdkUtils.convertInt2Bytes(4));
            f249915p.sendSsoMsg(toServiceMsg);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(f249914o, 4, "msfCore not inited. can not send checkServerTimeMsg.");
        }
    }

    private void j() {
        MsfCore msfCore = f249915p;
        if (msfCore != null && msfCore.getStatReporter() != null) {
            f249915p.getStatReporter().i();
        }
    }

    private void k() {
        K();
        j();
        MsfCore msfCore = f249915p;
        if (msfCore != null) {
            msfCore.setGatewayIp("");
            f249915p.setGatewayPort(0);
            com.tencent.mobileqq.msf.core.push.h hVar = f249915p.pushManager;
            if (hVar != null) {
                hVar.u();
            }
        }
    }

    public static r l() {
        return f.f249947a;
    }

    public boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.f249926a.m();
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.f249926a.n();
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!this.f249926a.n() && !this.f249926a.l()) {
            return false;
        }
        return true;
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        NetConnInfoCenter.socketConnState = 2;
        MsfCore msfCore = f249915p;
        if (msfCore == null) {
            QLog.d(f249914o, 1, "onConnOpened, return by msfCore null");
            return;
        }
        com.tencent.mobileqq.msf.core.push.h pushManager = msfCore.getPushManager();
        if (pushManager != null) {
            pushManager.t();
        }
        com.tencent.mobileqq.msf.core.push.b msfProbeManager = f249915p.getMsfProbeManager();
        if (msfProbeManager != null) {
            msfProbeManager.d();
        }
        if (com.tencent.mobileqq.msf.service.k.f250960i) {
            com.tencent.mobileqq.msf.service.k.a((Handler) null);
        }
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), f249915p.getNextSeq(), "0", BaseConstants.CMD_CONNOPENED);
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(f249915p.getNextSeq());
        fromServiceMsg.setMsfCommand(MsfCommand.onConnOpened);
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_IS_TEST_ENV, Boolean.valueOf(com.tencent.mobileqq.msf.core.e0.k.c().d()));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_IP_FAMILY, Integer.valueOf(f249915p.getConnectedIPFamily()));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_CONNOPEN_CONNSEQ, Long.valueOf(f249915p.getConnSeq()));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, Long.valueOf(f249915p.getServiceInitTime()));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, Long.valueOf(f249915p.getServiceReadyTime()));
        if (pushManager != null && pushManager.r()) {
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f249915p.addRespToQuque(null, fromServiceMsg);
        MSFConnectOpenNotifyMonitor.g().h(f249915p.getConnSeq());
        q.s().post(new b());
        if (com.tencent.mobileqq.msf.core.x.m.c()) {
            QLog.d(f249914o, 1, "post delay runnable of reNotifyConnOpened");
            q.s().postDelayed(f249925z, 5000L);
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        NetConnInfoCenter.socketConnState = 3;
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), f249915p.getNextSeq(), "0", BaseConstants.CMD_CONNALLFAILED);
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(f249915p.getNextSeq());
        fromServiceMsg.setMsfCommand(MsfCommand.onOepnConnAllFailed);
        com.tencent.mobileqq.msf.core.push.h pushManager = f249915p.getPushManager();
        if (pushManager != null && pushManager.r()) {
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f249915p.addRespToQuque(null, fromServiceMsg);
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        NetConnInfoCenter.socketConnState = 4;
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), f249915p.getNextSeq(), "0", BaseConstants.CMD_RECVFIRSTRESP);
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(fromServiceMsg.getAppSeq());
        fromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
        com.tencent.mobileqq.msf.core.push.h pushManager = f249915p.getPushManager();
        if (pushManager != null && pushManager.r()) {
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f249915p.addRespToQuque(null, fromServiceMsg);
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            MSFConnectOpenNotifyMonitor.g().i();
        }
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        MSFConnectOpenNotifyMonitor.g().j();
        if (com.tencent.mobileqq.msf.core.x.m.c()) {
            q.s().removeCallbacks(f249925z);
        }
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        MsfCore msfCore = f249915p;
        if (msfCore == null) {
            QLog.d(f249914o, 1, "onStartConnect, return by msfCore null");
            return;
        }
        com.tencent.mobileqq.msf.core.push.h pushManager = msfCore.getPushManager();
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), f249915p.getNextSeq(), "0", BaseConstants.CMD_START_CONNECT);
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(f249915p.getNextSeq());
        fromServiceMsg.setMsfCommand(MsfCommand.onStartConnect);
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, Long.valueOf(f249915p.getServiceInitTime()));
        fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, Long.valueOf(f249915p.getServiceReadyTime()));
        if (pushManager != null && pushManager.r()) {
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f249915p.addRespToQuque(null, fromServiceMsg);
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.f249934i = System.currentTimeMillis();
            this.f249933h.set(true);
        }
    }

    public boolean b(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar)).booleanValue();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("unRegisterNetworkIdentifyChangeListener ");
        sb5.append(hVar == null ? "null" : Integer.toHexString(hVar.hashCode()));
        QLog.d(f249914o, 1, sb5.toString());
        if (hVar == null) {
            return false;
        }
        return this.f249932g.remove(hVar);
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f249930e.set(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249914o, 2, "mobileConnected");
        }
        E();
        k();
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(f249914o, 2, "unknowDisConnected");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(f249914o, 2, "unknowConnected");
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f249929d.set(false);
        long longValue = this.f249930e.get().longValue();
        if (!this.f249931f && Math.abs(SystemClock.uptimeMillis() - this.f249930e.get().longValue()) > 120000) {
            this.f249931f = true;
            QLog.w(f249914o, 1, "checkConnInfo refresh held 2min!!! enter=" + longValue + " now=" + System.currentTimeMillis());
            MsfCore.sCore.statReporter.a("", 0L);
        }
    }

    public void h() {
        String config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = f249919t;
            if (0 != j3 && elapsedRealtime > j3 + com.tencent.mobileqq.msf.core.x.b.s()) {
                f249919t = elapsedRealtime;
                if (-1 == f249918s && MsfStore.getNativeConfigStore() != null && (config = MsfStore.getNativeConfigStore().getConfig(f249917r)) != null) {
                    try {
                        f249918s = Long.parseLong(config);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(f249914o, 2, "get lastCheckTime catch Exception " + e16);
                        }
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (-1 != f249918s) {
                    if (currentTimeMillis > r8 + com.tencent.mobileqq.msf.core.x.b.w() + (Math.random() * com.tencent.mobileqq.msf.core.x.b.v())) {
                        i();
                        return;
                    }
                    return;
                } else {
                    f249918s = currentTimeMillis;
                    if (MsfStore.getNativeConfigStore() != null) {
                        MsfStore.getNativeConfigStore().n_setConfig(f249917r, String.valueOf(f249918s));
                        return;
                    }
                    return;
                }
            }
            if (0 == f249919t) {
                f249919t = elapsedRealtime;
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d(f249914o, 2, "checkRecordTime catch Exception " + e17);
            }
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - this.f249937l;
        if (j3 > 0 && j3 <= com.tencent.mobileqq.msf.core.x.b.t()) {
            if (QLog.isColorLevel()) {
                QLog.d(f249914o, 2, "quit to checkTimeMsg too frequency.");
                return;
            }
            return;
        }
        if (this.f249936k < 10) {
            N();
            this.f249936k++;
            this.f249937l = elapsedRealtime;
        } else if (QLog.isColorLevel()) {
            QLog.d(f249914o, 2, "also send checkTimeMsg " + this.f249936k);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j16 = this.f249935j;
        if (j16 == 0 || elapsedRealtime - j16 > 600000) {
            this.f249935j = elapsedRealtime;
            this.f249936k = 0;
        }
        f249918s = currentTimeMillis;
        if (MsfStore.getNativeConfigStore() != null) {
            MsfStore.getNativeConfigStore().n_setConfig(f249917r, String.valueOf(currentTimeMillis));
        }
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.f249926a.b();
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Integer) iPatchRedirector.redirect((short) 50, (Object) this)).intValue();
        }
        return this.f249939n;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.f249926a.d();
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.f249926a.e();
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.f249938m;
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.f249926a.g();
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        return this.f249926a.i();
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.f249926a.k();
    }

    public NetworkInfo u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (NetworkInfo) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f249926a.j();
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (B()) {
            return 2;
        }
        if (z()) {
            return 1;
        }
        return 0;
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        if (B()) {
            return this.f249926a.b();
        }
        if (z()) {
            return this.f249926a.i() + 10000;
        }
        return 0;
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Integer) iPatchRedirector.redirect((short) 49, (Object) this)).intValue();
        }
        return 31;
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        NetConnInfoCenter.servetTimeSecondInterv = MsfService.getCore().getSharedPreferences(this.f249927b, 0).getLong(f249916q, 0L);
        QLog.d(f249914o, 1, "init server time, serverTimeSecondInterval:" + NetConnInfoCenter.servetTimeSecondInterv);
        c(BaseApplication.getContext());
        b(BaseApplication.getContext());
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.f249926a.l();
    }

    r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f249927b = "MSF.C.NetConnInfoCenter";
        this.f249928c = new ThreadLocal<>();
        this.f249929d = new AtomicBoolean(false);
        this.f249930e = new ThreadLocal<>();
        this.f249931f = false;
        this.f249932g = new CopyOnWriteArrayList<>();
        this.f249933h = new AtomicBoolean();
        this.f249934i = 0L;
        this.f249935j = 0L;
        this.f249936k = 0;
        this.f249937l = 0L;
        QLog.i(f249914o, 1, BaseApplication.processName + " create NetConnInfoCenterNewImpl instance");
        com.tencent.mobileqq.msf.sdk.q.a aVar = new com.tencent.mobileqq.msf.sdk.q.a();
        this.f249926a = aVar;
        aVar.a(this);
        this.f249926a.a(q.m());
        f249915p = MsfService.getCore();
    }

    public void a(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hVar);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("registerNetworkIdentifyChangeListener ");
        sb5.append(hVar == null ? "null" : Integer.toHexString(hVar.hashCode()));
        QLog.d(f249914o, 1, sb5.toString());
        if (hVar != null) {
            this.f249932g.add(hVar);
        }
    }

    public String c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) ? this.f249926a.c(z16) : (String) iPatchRedirector.redirect((short) 27, (Object) this, z16);
    }

    public void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 48)) {
            q.s().post(new c(context));
        } else {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str2 != null) {
            if (str == null || !str.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249914o, 2, "SSID changed, new ssid :  " + str2 + " old ssid: " + str);
                }
                Iterator<h> it = this.f249932g.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null) {
                        next.a(str, str2);
                    }
                }
            }
        }
    }

    public void a(Context context, NetworkInfo networkInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, networkInfo, Boolean.valueOf(z16));
            return;
        }
        this.f249928c.set(Boolean.valueOf(z16));
        if (this.f249929d.compareAndSet(false, true)) {
            this.f249926a.a(context, networkInfo);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249914o, 2, "wifiConnected");
        }
        a(this.f249926a.g(), i3);
        k();
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d(f249914o, 2, "mobileDisConnected");
        }
    }

    public String b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 38)) ? this.f249926a.b(z16) : (String) iPatchRedirector.redirect((short) 38, (Object) this, z16);
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f249914o, 2, "wifiDisConnected");
        }
        Iterator<h> it = this.f249932g.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                next.a();
            }
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
            return;
        }
        long j3 = i3;
        NetConnInfoCenter.servetTimeSecondInterv = j3;
        MsfService.getCore().getSharedPreferences(this.f249927b, 0).edit().putLong(f249916q, NetConnInfoCenter.servetTimeSecondInterv).apply();
        QLog.d(f249914o, 1, "set serverTime is " + f249915p.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + (j3 * 1000))));
        MsfCore.initAppProMsg("*", BaseApplication.getContext().getAppId());
    }

    @Override // com.tencent.mobileqq.msf.sdk.q.a.c
    public void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str2 != null) {
            if (str == null || !str.equals(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.d(f249914o, 2, "Mobile APN changed, load sso list new apn :  " + str2 + " old apn: " + str);
                }
                Iterator<h> it = this.f249932g.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null) {
                        next.b(str, str2);
                    }
                }
            }
        }
    }

    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) {
            q.s().post(new e(context));
        } else {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) context);
        }
    }

    private void a(String str, int i3) {
        MsfCore msfCore = f249915p;
        if (msfCore != null) {
            com.tencent.mobileqq.msf.core.g0.a aVar = msfCore.standbyModeManager;
            if (aVar != null) {
                aVar.n();
            }
            Iterator<h> it = this.f249932g.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.a(str, i3);
                }
            }
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        NetConnInfoCenter.socketConnState = 4;
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), f249915p.getNextSeq(), "0", BaseConstants.CMD_RECVFIRSTRESP);
        fromServiceMsg.setMsgSuccess();
        fromServiceMsg.setRequestSsoSeq(fromServiceMsg.getAppSeq());
        fromServiceMsg.setMsfCommand(MsfCommand.onReceFirstResp);
        fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_GATEWAY_IP, str);
        com.tencent.mobileqq.msf.core.push.h pushManager = f249915p.getPushManager();
        if (pushManager != null && pushManager.r()) {
            fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
        }
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        f249915p.addRespToQuque(null, fromServiceMsg);
    }

    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) aVar);
            return;
        }
        NetConnInfoCenter.socketConnState = 1;
        MsfCore msfCore = f249915p;
        if (msfCore != null) {
            try {
                com.tencent.mobileqq.msf.core.push.h pushManager = msfCore.getPushManager();
                if (pushManager != null) {
                    pushManager.a(aVar);
                }
                com.tencent.mobileqq.msf.core.push.b msfProbeManager = f249915p.getMsfProbeManager();
                if (msfProbeManager != null) {
                    msfProbeManager.a();
                }
                FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), f249915p.getNextSeq(), "0", BaseConstants.CMD_CONNCLOSED);
                fromServiceMsg.setMsgSuccess();
                fromServiceMsg.setMsfCommand(MsfCommand.onConnClosed);
                MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                f249915p.addRespToQuque(null, fromServiceMsg);
            } catch (Exception e16) {
                QLog.d(f249914o, 1, "", e16);
            }
        }
    }

    public int a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 42)) ? this.f249926a.a(z16) : ((Integer) iPatchRedirector.redirect((short) 42, (Object) this, z16)).intValue();
    }

    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null || toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_SERVER_TIME) == null) {
            return;
        }
        try {
            a(((Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_SERVER_TIME, Long.valueOf(NetConnInfoCenter.getServerTime()))).longValue());
        } catch (Exception e16) {
            QLog.d(f249914o, 1, "parse serverTime error", e16);
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, j3);
            return;
        }
        NetConnInfoCenter.servetTimeSecondInterv = j3 - (System.currentTimeMillis() / 1000);
        SharedPreferences.Editor edit = MsfService.getCore().getSharedPreferences(this.f249927b, 0).edit();
        edit.putLong(f249916q, NetConnInfoCenter.servetTimeSecondInterv);
        edit.apply();
        QLog.d(f249914o, 1, "set serverTime is " + f249915p.timeFormatter.format(Long.valueOf(System.currentTimeMillis() + (NetConnInfoCenter.servetTimeSecondInterv * 1000))));
        MsfCore.initAppProMsg("*", BaseApplication.getContext().getAppId());
    }

    @TargetApi(23)
    protected void a(Context context) {
        boolean z16;
        boolean z17;
        long j3;
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) context);
            return;
        }
        MsfCore msfCore = MsfCore.sCore;
        if (msfCore == null || msfCore.statReporter == null) {
            return;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        try {
            Method method = powerManager.getClass().getMethod(com.tencent.mobileqq.msf.core.c0.j.K0, new Class[0]);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(powerManager, new Object[0])).booleanValue();
            try {
                Method method2 = powerManager.getClass().getMethod(com.tencent.mobileqq.msf.core.c0.j.L0, new Class[0]);
                method2.setAccessible(true);
                boolean booleanValue2 = ((Boolean) method2.invoke(powerManager, new Object[0])).booleanValue();
                try {
                    Method method3 = powerManager.getClass().getMethod(com.tencent.mobileqq.msf.core.c0.j.M0, new Class[0]);
                    method3.setAccessible(true);
                    boolean booleanValue3 = ((Boolean) method3.invoke(powerManager, new Object[0])).booleanValue();
                    com.tencent.mobileqq.msf.core.c0.j jVar = f249915p.statReporter;
                    if (jVar.f247848b == null) {
                        jVar.f247848b = new j.e();
                    }
                    j.e eVar = f249915p.statReporter.f247848b;
                    eVar.f247860a = booleanValue;
                    if (booleanValue) {
                        eVar.f247861b = System.currentTimeMillis();
                        long currentTimeMillis = f249915p.statReporter.f247848b.f247862c > 0 ? System.currentTimeMillis() - f249915p.statReporter.f247848b.f247862c : 0L;
                        if (f249915p.statReporter.f247848b.f247864e > 0) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            j.e eVar2 = f249915p.statReporter.f247848b;
                            long j27 = eVar2.f247864e;
                            j26 = currentTimeMillis2 - j27;
                            long j28 = eVar2.f247865f;
                            j19 = j28 > 0 ? j28 - j27 : 0L;
                        } else {
                            j19 = 0;
                            j26 = 0;
                        }
                        com.tencent.mobileqq.msf.core.push.h hVar = f249915p.pushManager;
                        if (hVar != null) {
                            q.s().post(new d(hVar));
                        }
                        j18 = j19;
                        j3 = currentTimeMillis;
                        j17 = j26;
                        j16 = 0;
                    } else {
                        eVar.f247862c = System.currentTimeMillis();
                        j.e eVar3 = f249915p.statReporter.f247848b;
                        eVar3.f247864e = 0L;
                        eVar3.f247865f = 0L;
                        if (eVar3.f247861b > 0) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            MsfCore msfCore2 = f249915p;
                            j.e eVar4 = msfCore2.statReporter.f247848b;
                            j3 = currentTimeMillis3 - eVar4.f247861b;
                            j16 = eVar4.f247863d;
                            eVar4.f247863d = 0L;
                            com.tencent.mobileqq.msf.core.push.h hVar2 = msfCore2.pushManager;
                            if (hVar2 != null) {
                                hVar2.f249748o = 0L;
                            }
                        } else {
                            j3 = 0;
                            j16 = 0;
                        }
                        j17 = 0;
                        j18 = 0;
                    }
                    StringBuilder sb5 = new StringBuilder(128);
                    sb5.append("MSF_Alive_Log deviceIdleChanged: isDeviceIdleMode=");
                    sb5.append(booleanValue);
                    sb5.append(" takeTimes=");
                    sb5.append(j3);
                    sb5.append(" alarmCost=");
                    sb5.append(j16);
                    sb5.append(" connFailCost=");
                    sb5.append(j18);
                    sb5.append(" screenOffCost=");
                    sb5.append(j17);
                    sb5.append(" isPowerSaveMode=");
                    sb5.append(booleanValue2);
                    sb5.append(" isInteractive=");
                    sb5.append(booleanValue3);
                    QLog.d(f249914o, 1, sb5.toString());
                    if (j3 > 0) {
                        f249915p.statReporter.a(booleanValue, j3, j16, j17, j18, booleanValue2, booleanValue3);
                    }
                } catch (Exception e16) {
                    e = e16;
                    z16 = booleanValue;
                    z17 = booleanValue2;
                    e.printStackTrace();
                    QLog.d(f249914o, 1, e, new Object[0]);
                    f249915p.statReporter.a(z16, 0L, 0L, 0L, 0L, z17, false);
                }
            } catch (Exception e17) {
                e = e17;
                z17 = false;
                z16 = booleanValue;
            }
        } catch (Exception e18) {
            e = e18;
            z16 = false;
            z17 = false;
        }
    }
}
