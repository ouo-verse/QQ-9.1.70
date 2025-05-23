package com.tencent.mobileqq.msf.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.report.StatReportManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class p {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: q, reason: collision with root package name */
    private static final String f250625q = "MSF.D.RemoteServiceProxy";

    /* renamed from: r, reason: collision with root package name */
    public static final int f250626r = 2;

    /* renamed from: s, reason: collision with root package name */
    protected static AtomicBoolean f250627s = null;

    /* renamed from: t, reason: collision with root package name */
    protected static ConcurrentLinkedQueue<ToServiceMsg> f250628t = null;

    /* renamed from: u, reason: collision with root package name */
    protected static ConcurrentHashMap<Integer, ToServiceMsg> f250629u = null;

    /* renamed from: v, reason: collision with root package name */
    protected static ConcurrentHashMap<Integer, Runnable> f250630v = null;

    /* renamed from: w, reason: collision with root package name */
    protected static ConcurrentLinkedQueue<ToServiceMsg> f250631w = null;

    /* renamed from: x, reason: collision with root package name */
    protected static final HashSet<String> f250632x;

    /* renamed from: y, reason: collision with root package name */
    static final String f250633y = "appTimeoutReq";

    /* renamed from: a, reason: collision with root package name */
    protected volatile IBaseService f250634a;

    /* renamed from: b, reason: collision with root package name */
    protected final Object f250635b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile Handler f250636c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile long f250637d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile long f250638e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile int f250639f;

    /* renamed from: g, reason: collision with root package name */
    AtomicInteger f250640g;

    /* renamed from: h, reason: collision with root package name */
    String f250641h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f250642i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f250643j;

    /* renamed from: k, reason: collision with root package name */
    protected c f250644k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f250645l;

    /* renamed from: m, reason: collision with root package name */
    private volatile long f250646m;

    /* renamed from: n, reason: collision with root package name */
    protected MsfServiceSdk f250647n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private IBinder.DeathRecipient f250648o;

    /* renamed from: p, reason: collision with root package name */
    protected ServiceConnection f250649p;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements ServiceConnection {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.msf.sdk.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class RunnableC8106a implements Runnable {
            static IPatchRedirector $redirector_;

            RunnableC8106a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    p pVar = p.this;
                    pVar.onProcessViewableChanged(pVar.f250645l, p.this.f250646m, BaseApplication.processName);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) componentName);
                return;
            }
            try {
                MsfServiceSdk msfServiceSdk = p.this.f250647n;
                if (msfServiceSdk != null) {
                    str = msfServiceSdk.processName;
                } else {
                    str = "sdk_null";
                }
                QLog.d(p.f250625q, 1, "onBindingDied: name = ", componentName, ", process = ", str);
            } catch (Throwable th5) {
                QLog.e(p.f250625q, 1, "log onBindingDied throw t", th5);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            QLog.d(p.f250625q, 1, "onServiceConnected service:" + componentName);
            p.this.f250634a = IBaseService.Stub.asInterface(iBinder);
            p.this.c();
            p.this.f250647n.postServiceTask(new RunnableC8106a());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                return;
            }
            QLog.d(p.f250625q, 1, " onServiceDisconnected " + componentName);
            p.this.f250634a = null;
            p.f250627s.set(false);
            p.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements IBinder.DeathRecipient {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MsfCore msfCore = MsfCore.sCore;
            if (msfCore != null && msfCore.getAccountCenter() != null) {
                str = MsfCore.sCore.getAccountCenter().e();
            } else {
                str = "";
            }
            HashMap hashMap = new HashMap();
            MsfServiceSdk msfServiceSdk = p.this.f250647n;
            if (msfServiceSdk != null) {
                str2 = msfServiceSdk.processName;
            } else {
                str2 = "sdk_null";
            }
            String str3 = str2;
            hashMap.put("process", str3);
            hashMap.put("isUseNewProxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
            hashMap.put("account_uin", str);
            StatReportManager.collectPerformance(str, "msf_binder_died_c", true, 0L, 0L, hashMap, null, true);
            BaseApplication.getContext().getMSFInterfaceAdapter().beaconReport(str, "msf_binder_died", false, hashMap, true);
            QLog.i(p.f250625q, 1, "binderDied, process = " + str3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    protected class c implements Runnable {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(p.f250625q, 2, "delay send queueSize: " + p.f250631w.size());
            }
            p.this.f250643j = false;
            if (p.f250631w.size() > 0) {
                while (!p.f250631w.isEmpty()) {
                    p.this.sendMsg(p.f250631w.poll());
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(p.f250625q, 2, "delay send finished queueSize: " + p.f250631w.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private ToServiceMsg f250654a;

        public d(ToServiceMsg toServiceMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this, (Object) toServiceMsg);
            } else {
                this.f250654a = toServiceMsg;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ToServiceMsg remove;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if ("LongConn.OffPicUp".equalsIgnoreCase(this.f250654a.getServiceCmd()) || "ImgStore.GroupPicUp".equalsIgnoreCase(this.f250654a.getServiceCmd())) {
                QLog.d(p.f250625q, 1, "enter MonitorTaskWrapper.run(), appseq is " + this.f250654a.getAppSeq());
            }
            ToServiceMsg toServiceMsg = p.f250629u.get(Integer.valueOf(this.f250654a.getAppSeq()));
            if (toServiceMsg != null && toServiceMsg.getAttribute(p.f250633y, -1) == this.f250654a.getAttribute(p.f250633y, -2) && (remove = p.f250629u.remove(Integer.valueOf(this.f250654a.getAppSeq()))) != null) {
                QLog.d(p.f250625q, 1, "found timeout req, ", com.tencent.mobileqq.msf.core.z.a.b(remove));
                if (com.tencent.mobileqq.msf.core.x.m.f()) {
                    QLog.d(p.f250625q, 1, "try remove msg in toSendQueue, isRemoved:" + p.f250628t.remove(remove));
                }
                p.this.a(this.f250654a, p.this.a(this.f250654a, this.f250654a.getServiceName() + " timeout"));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_LOOP_PLAY_START);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f250627s = new AtomicBoolean(false);
        f250628t = new ConcurrentLinkedQueue<>();
        f250629u = new ConcurrentHashMap<>();
        f250630v = new ConcurrentHashMap<>();
        f250631w = new ConcurrentLinkedQueue<>();
        f250632x = new HashSet<>(3);
    }

    public p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f250635b = new Object();
        this.f250637d = -1L;
        this.f250638e = -1L;
        this.f250639f = -1;
        this.f250640g = new AtomicInteger();
        this.f250642i = false;
        this.f250643j = false;
        this.f250644k = null;
        this.f250645l = false;
        this.f250649p = new a();
        this.f250641h = str;
        if (BaseApplication.processName == null) {
            BaseApplication.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
        }
        if (MsfSdkUtils.isMainProcess(BaseApplication.processName)) {
            this.f250642i = true;
            this.f250643j = true;
            HashSet<String> hashSet = f250632x;
            hashSet.add(MsfCommand.reportRdm.name());
            hashSet.add(MsfCommand.reportSocket.name());
            hashSet.add(BaseConstants.CMD_REPORTRDM);
        }
        this.f250644k = new c();
    }

    protected abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) toServiceMsg);
            return;
        }
        toServiceMsg.addAttribute(f250633y, Integer.valueOf(this.f250640g.incrementAndGet()));
        f250629u.put(Integer.valueOf(toServiceMsg.getAppSeq()), toServiceMsg);
        d dVar = new d(toServiceMsg);
        f250630v.put(Integer.valueOf(toServiceMsg.getAppSeq()), dVar);
        if (!"LongConn.OffPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd()) && !"ImgStore.GroupPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
            if (BaseConstants.CMD_LOGIN_AUTH.equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                this.f250636c.postDelayed(dVar, toServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig);
                QLog.d(f250625q, 1, "login timer start, appSeq: " + toServiceMsg.getAppSeq() + ", delayMillis: " + (toServiceMsg.getTimeout() + NetConnInfoCenter.sAppTimeoutConfig));
                return;
            }
            this.f250636c.postDelayed(dVar, toServiceMsg.getTimeout() + 2000);
            return;
        }
        this.f250636c.postDelayed(dVar, toServiceMsg.getTimeout() + 20000);
        QLog.d(f250625q, 1, "PicUpMsg timer start, appSeq: " + toServiceMsg.getAppSeq() + ", delayMillis: " + (toServiceMsg.getTimeout() + 20000));
    }

    protected abstract void d();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg)).booleanValue();
        }
        if (this.f250642i && this.f250643j && toServiceMsg != null) {
            HashSet<String> hashSet = f250632x;
            if (hashSet.contains(toServiceMsg.getMsfCommand()) || hashSet.contains(toServiceMsg.getServiceCmd())) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(ToServiceMsg toServiceMsg) throws RemoteException, NullPointerException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg)).intValue();
        }
        try {
            int sendToServiceMsg = this.f250634a.sendToServiceMsg(toServiceMsg);
            if (toServiceMsg != null && BaseConstants.CMD_NT_REGPRXYSVC_INFOSYNC.equals(toServiceMsg.getServiceCmd())) {
                MsfServiceSdk.get().getMSFMsgPushHandlerUtil().handleSendRegisterProxyReq();
            }
            com.tencent.mobileqq.msf.sdk.report.c.a().onSendToService(toServiceMsg, sendToServiceMsg);
            return sendToServiceMsg;
        } catch (RemoteException e16) {
            throw e16;
        } catch (NullPointerException e17) {
            throw e17;
        }
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext(), this.f250641h);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            boolean stopService = BaseApplication.getContext().stopService(intent);
            if (QLog.isColorLevel()) {
                QLog.d(f250625q, 2, " stopService " + this.f250641h + " service finished " + stopService);
            }
            return stopService;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        try {
            BaseApplication.getContext().unbindService(this.f250649p);
            this.f250634a = null;
            f250627s.set(false);
            QLog.d(f250625q, 1, "unbindService service finished");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public int getMsfConnectedIPFamily() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        try {
            return this.f250634a.getMsfConnectedIPFamily();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final int getMsfConnectedNetType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        try {
            return this.f250634a.getMsfConnectedNetType();
        } catch (RemoteException unused) {
            return 0;
        }
    }

    public int onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        IBaseService iBaseService = this.f250634a;
        if (iBaseService != null) {
            try {
                iBaseService.onApplicationBackground();
                return 0;
            } catch (Exception e16) {
                QLog.e(f250625q, 1, "onApplicationBackground error, ", e16);
                return 0;
            }
        }
        return 0;
    }

    public int onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        IBaseService iBaseService = this.f250634a;
        if (iBaseService != null) {
            try {
                iBaseService.onApplicationForeground();
                return 0;
            } catch (Exception e16) {
                QLog.e(f250625q, 1, "onApplicationForeground error, ", e16);
                return 0;
            }
        }
        return 0;
    }

    public final int onKillProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        IBaseService iBaseService = this.f250634a;
        if (iBaseService != null) {
            try {
                iBaseService.onKillProcess();
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return 0;
    }

    public int onProcessViewableChanged(boolean z16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3), str)).intValue();
        }
        IBaseService iBaseService = this.f250634a;
        this.f250645l = z16;
        this.f250646m = j3;
        if (iBaseService != null) {
            try {
                QLog.d(f250625q, 1, "onProcessViewableChanged, visiable = ", Boolean.valueOf(z16), ", time = ", Long.valueOf(j3), ", processName = ", str);
                iBaseService.onProcessViewableChanged(z16, this.f250646m, str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public abstract int sendMsg(ToServiceMsg toServiceMsg);

    /* JADX INFO: Access modifiers changed from: protected */
    public FromServiceMsg a(ToServiceMsg toServiceMsg, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (FromServiceMsg) iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg, (Object) str);
        }
        FromServiceMsg a16 = com.tencent.mobileqq.msf.core.o.a(toServiceMsg);
        a16.setBusinessFail(1013, str);
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f250634a != null : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
    }

    protected void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        try {
            toServiceMsg.getActionListener().onRecvFromMsg(fromServiceMsg);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onRespToApp(toServiceMsg, fromServiceMsg);
    }

    protected void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            b(toServiceMsg, fromServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    boolean a() {
        boolean z16 = false;
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250641h);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            z16 = BaseApplication.getContext().bindService(intent, this.f250649p, 1);
            if (QLog.isColorLevel()) {
                QLog.d(f250625q, 2, " bind " + this.f250641h + " service finished " + z16);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (f250628t.add(toServiceMsg)) {
            return;
        }
        QLog.i(f250625q, 1, "addMsgToSendQueue fail, size = " + f250628t.size() + ", msg = " + toServiceMsg.getShortStringForLog());
    }

    void e() {
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250641h);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            BaseApplication.getContext().startService(intent);
            if (QLog.isColorLevel()) {
                QLog.d(f250625q, 2, " start service finish");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(@Nullable IMsfServiceCallbacker iMsfServiceCallbacker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) iMsfServiceCallbacker);
            return;
        }
        if (iMsfServiceCallbacker != null) {
            try {
                if (this.f250648o != null) {
                    iMsfServiceCallbacker.asBinder().unlinkToDeath(this.f250648o, 0);
                    QLog.d(f250625q, 1, "unlinkToDeath");
                }
            } catch (Throwable th5) {
                QLog.e(f250625q, 1, "unlinkToDeath fail.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            f250631w.add(toServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) toServiceMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@Nullable IMsfServiceCallbacker iMsfServiceCallbacker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) iMsfServiceCallbacker);
            return;
        }
        try {
            if (this.f250648o == null) {
                this.f250648o = new b();
            }
            if (iMsfServiceCallbacker != null) {
                iMsfServiceCallbacker.asBinder().linkToDeath(this.f250648o, 0);
                QLog.d(f250625q, 1, "linkToDeath");
            }
        } catch (Throwable th5) {
            QLog.e(f250625q, 1, "linkToDeath fail.", th5);
        }
    }
}
