package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.format.Formatter;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.f;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ServiceMsgWrapper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends p implements IMsfProxy {
    static IPatchRedirector $redirector_ = null;
    private static final String D = "MSF.D.Proxy";
    private static final int E = 20000;
    private static final int F = 10000;
    private static final int G = 2000;
    private static int H = 0;
    private static long I = -1;
    private static boolean J = false;
    private ConcurrentHashMap<Integer, ServiceMsgWrapper> A;

    @Nullable
    private IMsfServiceCallbacker B;
    protected volatile boolean C;

    /* renamed from: z, reason: collision with root package name */
    private ConcurrentHashMap<Integer, ServiceMsgWrapper> f250549z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.sdk.report.c.a().onServiceConnected();
            int registerMsfService = h.this.registerMsfService(false, true);
            if (com.tencent.mobileqq.msf.service.n.a(BaseApplication.processName)) {
                h.this.f250647n.registerServiceListener();
            }
            if (QLog.isColorLevel()) {
                QLog.d(h.D, 2, " registerMsfService result:" + registerMsfService);
            }
            h.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends IMsfServiceCallbacker.Stub {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean isBinderAlive() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            QLog.i(h.D, 1, "isBinderAlive");
            return super.isBinderAlive();
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onFirstPkgResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
            if (QLog.isColorLevel()) {
                QLog.d(h.D, 2, "receive first res package, , thread id = " + Thread.currentThread().getId() + ", ssoSeq = " + requestSsoSeq + ", index = " + i3 + ", length = " + fromServiceMsg.getWupBuffer().length + ", packageLength = " + i16 + ", totalLength = " + i17);
            }
            ServiceMsgWrapper serviceMsgWrapper = new ServiceMsgWrapper(toServiceMsg, fromServiceMsg, i17);
            serviceMsgWrapper.buildFromMsgWupBuffer(i3, fromServiceMsg.getWupBuffer());
            h.this.f250549z.put(Integer.valueOf(requestSsoSeq), serviceMsgWrapper);
            h.this.f250636c.postDelayed(new f(h.this.f250549z, requestSsoSeq), 20000L);
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onNextPkgResp(int i3, int i16, byte[] bArr) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 2;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
                return;
            }
            Integer valueOf = Integer.valueOf(i3);
            ServiceMsgWrapper serviceMsgWrapper = (ServiceMsgWrapper) h.this.f250549z.get(valueOf);
            if (QLog.isColorLevel() || serviceMsgWrapper == null) {
                if (serviceMsgWrapper == null) {
                    i17 = 1;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("receive next res package, , thread id = ");
                sb5.append(Thread.currentThread().getId());
                sb5.append(", ssoSeq = ");
                sb5.append(valueOf);
                sb5.append(", index = ");
                sb5.append(i16);
                sb5.append(", length = ");
                sb5.append(bArr.length);
                sb5.append(", resServiceMsgWrapper = null ");
                if (serviceMsgWrapper == null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d(h.D, i17, sb5.toString());
            }
            if (serviceMsgWrapper != null) {
                serviceMsgWrapper.buildFromMsgWupBuffer(i16, bArr);
                if (serviceMsgWrapper.isFinishTransported()) {
                    h.this.d(serviceMsgWrapper.getToServiceMsg(), serviceMsgWrapper.getFromServiceMsg());
                    com.tencent.mobileqq.msf.sdk.report.c.a().onReceiveResp(serviceMsgWrapper.getToServiceMsg(), serviceMsgWrapper.getFromServiceMsg());
                    h.this.f250549z.remove(valueOf);
                }
            }
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceiveFirstPkgPushResp(FromServiceMsg fromServiceMsg, int i3, int i16, int i17) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, fromServiceMsg, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            int requestSsoSeq = fromServiceMsg.getRequestSsoSeq();
            if (QLog.isColorLevel()) {
                QLog.d(h.D, 2, "receive first push package, , thread id = " + Thread.currentThread().getId() + ", ssoSeq = " + requestSsoSeq + ", index = " + i3 + ", length = " + fromServiceMsg.getWupBuffer().length + ", packageLength = " + i16 + ", totalLength = " + i17);
            }
            ServiceMsgWrapper serviceMsgWrapper = new ServiceMsgWrapper(null, fromServiceMsg, i17);
            serviceMsgWrapper.buildFromMsgWupBuffer(i3, fromServiceMsg.getWupBuffer());
            h.this.A.put(Integer.valueOf(requestSsoSeq), serviceMsgWrapper);
            h.this.f250636c.postDelayed(new f(h.this.A, requestSsoSeq), 20000L);
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceiveNextPkgPushResp(int i3, int i16, byte[] bArr) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i17 = 2;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), bArr);
                return;
            }
            Integer valueOf = Integer.valueOf(i3);
            ServiceMsgWrapper serviceMsgWrapper = (ServiceMsgWrapper) h.this.A.get(valueOf);
            if (QLog.isColorLevel() || serviceMsgWrapper == null) {
                if (serviceMsgWrapper == null) {
                    i17 = 1;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("receive next push package, , thread id = ");
                sb5.append(Thread.currentThread().getId());
                sb5.append(", ssoSeq = ");
                sb5.append(valueOf);
                sb5.append(", index = ");
                sb5.append(i16);
                sb5.append(", length = ");
                sb5.append(bArr.length);
                sb5.append(", resServiceMsgWrapper = null ");
                if (serviceMsgWrapper == null) {
                    z16 = true;
                }
                sb5.append(z16);
                QLog.d(h.D, i17, sb5.toString());
            }
            if (serviceMsgWrapper != null) {
                serviceMsgWrapper.buildFromMsgWupBuffer(i16, bArr);
                if (serviceMsgWrapper.isFinishTransported()) {
                    h.this.a(serviceMsgWrapper.getFromServiceMsg());
                    com.tencent.mobileqq.msf.sdk.report.c.a().onRecvServicePushResp(serviceMsgWrapper.getFromServiceMsg());
                    h.this.A.remove(valueOf);
                }
            }
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onReceivePushResp(FromServiceMsg fromServiceMsg) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                h.this.a(fromServiceMsg);
                com.tencent.mobileqq.msf.sdk.report.c.a().onRecvServicePushResp(fromServiceMsg);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) fromServiceMsg);
            }
        }

        @Override // com.tencent.qphone.base.remote.IMsfServiceCallbacker
        public void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                h.this.d(toServiceMsg, fromServiceMsg);
                com.tencent.mobileqq.msf.sdk.report.c.a().onReceiveResp(toServiceMsg, fromServiceMsg);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            }
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean pingBinder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            QLog.i(h.D, 1, "pingBinder");
            return super.pingBinder();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f250552a;

        c(ToServiceMsg toServiceMsg) {
            this.f250552a = toServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, (Object) toServiceMsg);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                h.this.sendMsg(this.f250552a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f250554a;

        d(ToServiceMsg toServiceMsg) {
            this.f250554a = toServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this, (Object) toServiceMsg);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                h.this.sendMsg(this.f250554a);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23446);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public h(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.C = false;
        this.f250549z = new ConcurrentHashMap<>();
        this.A = new ConcurrentHashMap<>();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Transport-Timeout-Checker", 5);
        baseHandlerThread.start();
        this.f250636c = new Handler(baseHandlerThread.getLooper());
    }

    public static String h() {
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            QLog.d(D, 1, "Property get avail memory:" + memoryInfo.availMem);
            return Formatter.formatFileSize(BaseApplication.getContext(), memoryInfo.availMem);
        } catch (Exception unused) {
            QLog.d(D, 1, "failed to get avail memory");
            return null;
        }
    }

    public static String i() {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            QLog.d(D, 1, "failed to get current process name");
            return null;
        }
    }

    public static String j() {
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            QLog.d(D, 1, "Property get low memory feature:" + memoryInfo.lowMemory);
            return String.valueOf(memoryInfo.lowMemory);
        } catch (Exception unused) {
            QLog.d(D, 1, "failed to get low memory feature");
            return null;
        }
    }

    public static String k() {
        try {
            boolean z16 = false;
            ActivityManager.RunningServiceInfo runningServiceInfo = null;
            int i3 = 0;
            for (ActivityManager.RunningServiceInfo runningServiceInfo2 : ((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningServices(256)) {
                i3++;
                if (runningServiceInfo2.process.trim().equals("com.tencent.mobileqq:MSF")) {
                    z16 = true;
                    runningServiceInfo = runningServiceInfo2;
                }
            }
            QLog.d(D, 1, "isMsfAlive:" + z16 + ", cur service process count:" + i3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("countService_");
            sb5.append(i3);
            sb5.append(":");
            if (z16 && runningServiceInfo != null) {
                sb5.append("alive_");
                sb5.append(z16);
                sb5.append(":");
                sb5.append("activeSince_");
                sb5.append(runningServiceInfo.activeSince);
                sb5.append(":");
                sb5.append("clientCount_");
                sb5.append(runningServiceInfo.clientCount);
                sb5.append(":");
                sb5.append("clientLabel_");
                sb5.append(runningServiceInfo.clientLabel);
                sb5.append(":");
                sb5.append("clientPkg_");
                sb5.append(runningServiceInfo.clientPackage);
                sb5.append(":");
                sb5.append("crashCount_");
                sb5.append(runningServiceInfo.crashCount);
                sb5.append(":");
                sb5.append("flags_");
                sb5.append(runningServiceInfo.flags);
                sb5.append(":");
                sb5.append("foreground_");
                sb5.append(runningServiceInfo.foreground);
                sb5.append(":");
                sb5.append("lastActivityTime_");
                sb5.append(runningServiceInfo.lastActivityTime);
                sb5.append(":");
                sb5.append("pid_");
                sb5.append(runningServiceInfo.pid);
                sb5.append(":");
                sb5.append("process_");
                sb5.append(runningServiceInfo.process);
                sb5.append(":");
                sb5.append("restarting_");
                sb5.append(runningServiceInfo.restarting);
                sb5.append(":");
                sb5.append("started_");
                sb5.append(runningServiceInfo.started);
                sb5.append(":");
                sb5.append("uid_");
                sb5.append(runningServiceInfo.uid);
            } else {
                sb5.append("alive_");
                sb5.append(z16);
            }
            return sb5.toString();
        } catch (Exception unused) {
            QLog.d(D, 1, "failed to getServiceState");
            return null;
        }
    }

    private void l() {
        H = 0;
        this.f250638e = -1L;
        I = -1L;
        J = false;
    }

    private void n() {
        synchronized (this.f250635b) {
            while (!p.f250628t.isEmpty()) {
                ToServiceMsg poll = p.f250628t.poll();
                if (poll != null) {
                    try {
                        e(poll);
                    } catch (Exception e16) {
                        if (poll.isNeedCallback()) {
                            b(poll, a(poll, poll.getServiceName() + "sendMsgToServiceFailed\uff0c" + e16));
                        }
                    }
                }
            }
            p.f250627s.set(true);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f250647n.postServiceTask(new a());
            l();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onServiceDisconnected();
        l();
        if (com.tencent.mobileqq.msf.service.n.a(BaseApplication.processName)) {
            this.f250647n.unregisterServiceListener();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    void e() {
        if (!com.tencent.mobileqq.msf.core.p.a()) {
            QLog.d(D, 1, "startBaseService no allow");
            return;
        }
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250647n.msfServiceName);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
            BaseApplication.getContext().startService(intent);
            QLog.d(D, 1, "MSF_Alive_Log start service finish");
        } catch (Exception e16) {
            QLog.d(D, 1, "MSF_Alive_Log " + e16, e16);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250647n.msfServiceName);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
            boolean stopService = BaseApplication.getContext().stopService(intent);
            QLog.d(D, 1, "stopService service finished " + stopService);
            return stopService;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            super.g();
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void init(MsfServiceSdk msfServiceSdk) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msfServiceSdk);
            return;
        }
        this.f250647n = msfServiceSdk;
        msfServiceSdk.msfServiceName = this.f250641h;
        if (this.f250644k != null) {
            if (this.f250642i) {
                this.f250636c.postDelayed(this.f250644k, 10000L);
            } else {
                this.f250636c.postDelayed(this.f250644k, 2000L);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void initMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            e();
            a();
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        while (!p.f250628t.isEmpty()) {
            ToServiceMsg poll = p.f250628t.poll();
            if (poll != null) {
                try {
                    e(poll);
                } catch (Exception e16) {
                    if (poll.isNeedCallback()) {
                        b(poll, a(poll, poll.getServiceName() + "sendMsgToServiceFailed\uff0c" + e16.toString()));
                    }
                }
            }
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (!com.tencent.mobileqq.msf.core.p.a()) {
            QLog.d(D, 1, "startBaseServiceConn no allow");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f250637d != -1 && currentTimeMillis - this.f250637d <= 10000) {
            try {
                long j3 = currentTimeMillis - this.f250638e;
                if (this.f250638e == -1 || j3 > 10000) {
                    int i3 = H;
                    if (i3 == 0) {
                        I = currentTimeMillis;
                    }
                    H = i3 + 1;
                    this.f250638e = currentTimeMillis;
                    if (H % 3 == 2) {
                        f();
                        g();
                        QLog.d(D, 1, "pullmsf to stop and unbind service above android 5");
                    }
                    Intent intent = new Intent("com.tencent.mobileqq.msf.startmsf");
                    intent.setPackage(BaseApplication.getContext().getPackageName());
                    BaseApplication.getContext().sendBroadcast(intent);
                    this.f250639f = 1;
                    QLog.d(D, 1, "start MsfService through Broadcast, " + H);
                }
                if (this.f250638e != -1 && j3 > this.f250639f * 2000) {
                    a();
                    this.f250639f++;
                    QLog.d(D, 1, "delay binding MSF Service");
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.d(D, 1, "start MsfService exception " + e16.toString());
                return;
            }
        }
        this.f250637d = currentTimeMillis;
        e();
        a();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public int registerMsfService(boolean z16, boolean z17) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
        }
        this.B = new b();
        ToServiceMsg toServiceMsg = new ToServiceMsg(this.f250647n.msfServiceName, "0", BaseConstants.CMD_REGISTERMSFSERVICE);
        toServiceMsg.setMsfCommand(MsfCommand.registerMsfService);
        MsfServiceSdk msfServiceSdk = this.f250647n;
        MsfServiceBindInfo msfServiceBindInfo = new MsfServiceBindInfo(msfServiceSdk.appid, msfServiceSdk.processName, msfServiceSdk.getBootBroadcastName(), this.B);
        toServiceMsg.getAttributes().put(MsfConstants.INTENT_BINDSERVICEINFO, msfServiceBindInfo);
        toServiceMsg.setNeedCallback(false);
        a(this.B);
        this.C = true;
        if (QLog.isColorLevel() && msfServiceBindInfo.getMsfServiceCallbacker() != null) {
            if (msfServiceBindInfo.getMsfServiceCallbacker() != null) {
                str = Integer.toHexString(msfServiceBindInfo.getMsfServiceCallbacker().hashCode());
            } else {
                str = "null";
            }
            QLog.d(D, 2, "registerMsfService processName=" + this.f250647n.processName + " callback=" + str);
        }
        if (z16) {
            if (z17) {
                this.f250636c.postAtFrontOfQueue(new c(toServiceMsg));
            } else {
                this.f250636c.post(new d(toServiceMsg));
            }
            return 0;
        }
        return sendMsg(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void registerProxyDone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (this.f250642i && this.f250643j && this.f250644k != null) {
            this.f250636c.removeCallbacks(this.f250644k);
            this.f250636c.post(this.f250644k);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p, com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public int sendMsg(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        if (d(toServiceMsg)) {
            a(toServiceMsg);
            return -1;
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onSendMsg(toServiceMsg, b());
        if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NEW_REGPRXYSVC_PBSYNCMSG)) {
            toServiceMsg.setMsfCommand(MsfCommand.msf_pbSyncMsg);
        }
        if (toServiceMsg.getAppSeq() < 0) {
            toServiceMsg.setAppSeq(MsfSdkUtils.getNextAppSeq());
        }
        return f(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public boolean serviceConnected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return b();
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void startMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void stopMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            f();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public int unRegisterMsfService(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) bool)).intValue();
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg(this.f250647n.msfServiceName, "0", BaseConstants.CMD_UNREGISTERMSFSERVICE);
        toServiceMsg.setMsfCommand(MsfCommand.unRegisterMsfService);
        toServiceMsg.extraData.putBoolean(MsfConstants.ATTRIBUTE_STOP_WAKE_PROCESS, bool.booleanValue());
        this.C = false;
        b(this.B);
        return sendMsg(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IMsfProxy
    public void unbindMsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            m();
            g();
        }
    }

    private int g(ToServiceMsg toServiceMsg) {
        boolean b16;
        try {
            synchronized (this.f250635b) {
                b16 = b();
            }
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(30000L);
            }
            if (toServiceMsg.isNeedCallback()) {
                c(toServiceMsg);
            }
            if (b16) {
                if (H > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = I;
                    if (-1 != j3 && currentTimeMillis < j3 + 120000) {
                        QLog.d(D, 1, "succ to pull msf service.");
                        a(toServiceMsg.getUin(), true);
                    }
                    l();
                }
                synchronized (this.f250635b) {
                    if (p.f250627s.get()) {
                        return e(toServiceMsg);
                    }
                    b(toServiceMsg);
                    return -1;
                }
            }
            com.tencent.mobileqq.msf.sdk.report.c.a().onReqServiceConn();
            synchronized (this.f250635b) {
                if (p.f250627s.get()) {
                    return e(toServiceMsg);
                }
                b(toServiceMsg);
                o();
                if (H <= 10 || System.currentTimeMillis() <= I + 60000 || J) {
                    return -1;
                }
                QLog.d(D, 1, "cannot pull msf service.");
                J = true;
                a(toServiceMsg.getUin(), false);
                return -1;
            }
        } catch (DeadObjectException e16) {
            synchronized (this.f250635b) {
                b(toServiceMsg);
                QLog.i(D, 1, "DeadObjectException", e16);
                return -1;
            }
        } catch (Exception e17) {
            if (this.f250634a == null) {
                synchronized (this.f250635b) {
                    b(toServiceMsg);
                    return -1;
                }
            }
            QLog.i(D, 1, e17.getMessage(), e17);
            e17.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "add fail queue req:" + toServiceMsg + " from:" + fromServiceMsg);
        }
        this.f250647n.addServiceRespMsg(new MsfMessagePair(toServiceMsg, fromServiceMsg));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg)).booleanValue();
        }
        int businessFailCode = fromServiceMsg.getBusinessFailCode();
        boolean booleanValue = fromServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_SAMEDEVICE) ? ((Boolean) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_SAMEDEVICE)).booleanValue() : false;
        if (businessFailCode == -2) {
            return true;
        }
        if (businessFailCode == 2001) {
            this.f250647n.errorHandler.onUserTokenExpired(toServiceMsg, fromServiceMsg, booleanValue);
        } else if (businessFailCode == 3003) {
            QLog.d(D, 1, "AppClone: old guid = " + util.buf_to_string(NetConnInfoCenter.GUID));
            com.tencent.qmethod.pandoraex.api.r.b();
            NetConnInfoCenter.GUID = WtloginHelper.updateGuid(BaseApplication.getContext());
            QLog.d(D, 1, "AppClone: new guid = " + util.buf_to_string(NetConnInfoCenter.GUID));
            fromServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_APP_CLONE, Boolean.TRUE);
            this.f250647n.errorHandler.onKicked(toServiceMsg, fromServiceMsg, true);
        } else if (businessFailCode == 2008) {
            this.f250647n.errorHandler.onGrayError(toServiceMsg, fromServiceMsg, booleanValue);
        } else {
            if (businessFailCode != 2009) {
                switch (businessFailCode) {
                    case 2011:
                        this.f250647n.errorHandler.onRecvServerTip(toServiceMsg, fromServiceMsg, booleanValue);
                        break;
                    case 2012:
                        this.f250647n.errorHandler.onKickedAndClearToken(toServiceMsg, fromServiceMsg, booleanValue);
                        break;
                    case 2013:
                        this.f250647n.errorHandler.onKicked(toServiceMsg, fromServiceMsg, booleanValue);
                        break;
                    case 2014:
                        this.f250647n.errorHandler.onInvalidSign(booleanValue);
                        break;
                    default:
                        z16 = false;
                        break;
                }
                if (z16) {
                    QLog.d(D, 1, "tokenExpired, failcode:", Integer.valueOf(businessFailCode), " fromServiceMsg:", Integer.valueOf(fromServiceMsg.hashCode()));
                }
                return z16;
            }
            this.f250647n.errorHandler.onServerSuspended(toServiceMsg, fromServiceMsg, booleanValue);
        }
        z16 = true;
        if (z16) {
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            b(toServiceMsg, fromServiceMsg);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        QLog.d(D, 1, "onReceiveResp, fromServiceMsg = " + fromServiceMsg.getServiceCmd() + ", ssoSeq = " + fromServiceMsg.getRequestSsoSeq() + ", length = " + fromServiceMsg.getWupBuffer().length);
        ToServiceMsg remove = p.f250629u.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
        Runnable remove2 = p.f250630v.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
        if (remove2 != null) {
            this.f250636c.removeCallbacks(remove2);
        }
        if (remove != null) {
            if (!"LongConn.OffPicUp".equalsIgnoreCase(remove.getServiceCmd()) && !"ImgStore.GroupPicUp".equalsIgnoreCase(remove.getServiceCmd())) {
                if (QLog.isColorLevel()) {
                    QLog.d(D, 2, " onResponse " + toServiceMsg.getRequestSsoSeq() + " " + fromServiceMsg);
                }
            } else {
                QLog.d(D, 1, "onReceiveResp." + remove.getStringForLog() + " isConnectedMsf:" + this.C);
            }
            if (c(toServiceMsg, fromServiceMsg)) {
                return;
            }
            if (this.C) {
                if (QLog.isColorLevel()) {
                    QLog.d(D, 2, "add queue req:" + toServiceMsg + " from:" + fromServiceMsg);
                }
                this.f250647n.addServiceRespMsg(new MsfMessagePair(toServiceMsg, fromServiceMsg));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, " close msfServiceConn. msg is droped." + toServiceMsg.getRequestSsoSeq() + " " + fromServiceMsg);
                return;
            }
            return;
        }
        if (!"LongConn.OffPicUp".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) && !"ImgStore.GroupPicUp".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, " found timeout resp to:" + toServiceMsg + " from:" + fromServiceMsg);
                return;
            }
            return;
        }
        QLog.d(D, 1, "onReceiveResp." + fromServiceMsg.getStringForLog() + " waiteTemp is null.");
        if (fromServiceMsg.isSuccess()) {
            HashMap hashMap = new HashMap();
            hashMap.put("appSeq", String.valueOf(fromServiceMsg.getAppSeq()));
            hashMap.put("ssoSeq", String.valueOf(fromServiceMsg.getRequestSsoSeq()));
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = "PicUpMsgErroCase1";
            rdmReq.isRealTime = true;
            rdmReq.params = hashMap;
            try {
                ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
                rdmReportMsg.setTimeout(30000L);
                MsfServiceSdk.get().sendMsg(rdmReportMsg);
            } catch (Exception e16) {
                QLog.d(D, 1, "onReceiveResp, send rdmReportMsg error", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    boolean a() {
        boolean z16 = false;
        if (!com.tencent.mobileqq.msf.core.p.a()) {
            QLog.d(D, 1, "bindBaseService no allow");
            return false;
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onBindStart();
        try {
            ComponentName componentName = new ComponentName(BaseApplication.getContext().getPackageName(), this.f250647n.msfServiceName);
            Intent intent = new Intent();
            intent.putExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
            intent.setComponent(componentName);
            z16 = BaseApplication.getContext().bindService(intent, this.f250649p, 1);
            QLog.d(D, 1, "threadID:" + Thread.currentThread().getId() + ", threadName: " + Thread.currentThread().getName() + " bind service finished " + z16);
        } catch (Exception e16) {
            QLog.d(D, 1, " " + e16, e16);
        }
        com.tencent.mobileqq.msf.sdk.report.c.a().onBindEnd(z16);
        return z16;
    }

    private int f(ToServiceMsg toServiceMsg) {
        boolean b16;
        try {
            synchronized (this.f250635b) {
                b16 = b();
            }
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(30000L);
            }
            if (toServiceMsg.isNeedCallback()) {
                c(toServiceMsg);
            }
            if (b16) {
                if (H > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = I;
                    if (-1 != j3 && currentTimeMillis < j3 + 120000) {
                        QLog.d(D, 1, "succ to pull msf service.");
                        a(toServiceMsg.getUin(), true);
                    }
                    l();
                }
                return e(toServiceMsg);
            }
            com.tencent.mobileqq.msf.sdk.report.c.a().onReqServiceConn();
            b(toServiceMsg);
            synchronized (this.f250635b) {
                o();
            }
            if (H <= 10 || System.currentTimeMillis() <= I + 60000 || J) {
                return -1;
            }
            QLog.d(D, 1, "cannot pull msf service.");
            J = true;
            a(toServiceMsg.getUin(), false);
            return -1;
        } catch (DeadObjectException e16) {
            b(toServiceMsg);
            QLog.i(D, 1, "DeadObjectException", e16);
            return -1;
        } catch (Exception e17) {
            if (this.f250634a == null) {
                b(toServiceMsg);
                return -1;
            }
            QLog.i(D, 1, e17.getMessage(), e17);
            e17.printStackTrace();
            return -1;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.p
    protected int e(ToServiceMsg toServiceMsg) throws RemoteException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        toServiceMsg.setAppId(this.f250647n.appid);
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_SENDTIME, Long.valueOf(System.currentTimeMillis()));
        toServiceMsg.getAttributes().put(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME, this.f250647n.processName);
        int e16 = super.e(toServiceMsg);
        if (QLog.isColorLevel() && com.tencent.mobileqq.msf.core.z.a.a(toServiceMsg)) {
            QLog.d(D, 2, " sendMsgToService " + toServiceMsg);
        }
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FromServiceMsg fromServiceMsg) {
        QLog.d(D, 1, "onRecvServicePushResp, fromServiceMsg cmd = " + fromServiceMsg.getServiceCmd() + ", ssoSeq = " + fromServiceMsg.getRequestSsoSeq() + ", length = " + fromServiceMsg.getWupBuffer().length);
        if (!c(null, fromServiceMsg)) {
            if (fromServiceMsg.getMsfCommand() == MsfCommand.pushSetConfig) {
                QLog.setUIN_REPORTLOG_LEVEL(((Integer) fromServiceMsg.getAttribute(fromServiceMsg.getServiceCmd())).intValue());
                NetConnInfoCenter.socketConnState = ((Integer) fromServiceMsg.getAttribute(BaseConstants.Attribute_SOCKET_CONNSTATE)).intValue();
                NetConnInfoCenter.servetTimeSecondInterv = ((Long) fromServiceMsg.getAttribute(BaseConstants.Attribute_SERVERTIME)).longValue();
                NetConnInfoCenter.GUID = (byte[]) fromServiceMsg.getAttribute(BaseConstants.Attribute_DEVICEGUID);
                NetConnInfoCenter.sAppTimeoutConfig = ((Integer) fromServiceMsg.getAttribute(BaseConstants.Attribute_RESP_APP_TIMEOUT)).intValue();
                NetConnInfoCenter.setGateWayIp((String) fromServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_GATEWAY_IP, ""));
                long longValue = ((Long) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SERVICE_INIT_TIME, 0L)).longValue();
                long longValue2 = ((Long) fromServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_SERVICE_READY_TIME, 0L)).longValue();
                NetConnInfoCenter.setMSFServiceInitTime(longValue);
                NetConnInfoCenter.setMSFServiceReadyTime(longValue2);
                if (fromServiceMsg.getServiceCmd() == null || !fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                    return;
                }
                com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247651c, fromServiceMsg.getWupBuffer(), 17);
                return;
            }
            if (this.C) {
                this.f250647n.addServicePushMsg(fromServiceMsg);
                return;
            }
            if (fromServiceMsg.getServiceCmd() != null && fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
                com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247651c, fromServiceMsg.getWupBuffer(), 16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, " close msfServiceConn. push msg is droped." + fromServiceMsg);
                return;
            }
            return;
        }
        if (fromServiceMsg.getBusinessFailCode() == -2) {
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, "receive service ipc test push, length = " + fromServiceMsg.getWupBuffer().length);
                return;
            }
            return;
        }
        if (fromServiceMsg.getServiceCmd() == null || !fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) {
            return;
        }
        com.tencent.mobileqq.msf.core.c0.f.a().a(f.a.f247651c, fromServiceMsg.getWupBuffer(), 15);
    }

    public static void a(SharedPreferences.Editor editor) {
        editor.putString("availMem", h());
        editor.putString("lowMem", j());
        try {
            editor.putString("time", new Date().toString());
        } catch (AssertionError unused) {
        }
        editor.putString("process", i());
        editor.putString("state", k());
    }

    public static void a(String str, boolean z16) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        com.tencent.mobileqq.msf.core.c0.j jVar;
        String lowerCase = (Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel()).toLowerCase();
        String i3 = i();
        boolean z17 = MsfServiceSdk.isUseNewProxy;
        boolean z18 = lowerCase != null && lowerCase.indexOf(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) >= 0;
        int i16 = (z17 || !z18) ? (z17 && z18) ? 2 : (z17 || z18) ? (!z17 || z18) ? 0 : 4 : 3 : 1;
        boolean isMainProcess = MsfSdkUtils.isMainProcess(i3);
        HashMap hashMap = new HashMap();
        hashMap.put("proxy", String.valueOf(z17));
        hashMap.put(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, String.valueOf(z18));
        hashMap.put("param_FailCode", String.valueOf(i16));
        hashMap.put("mainProcess", String.valueOf(isMainProcess));
        hashMap.put("sdkver", "android5.0+");
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(D, 2, "MTA is not initConfig or unsupported.");
            }
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("pull_msf_succ" + i3, 0).edit();
            edit.putString("uin", str);
            edit.putString("proxy", String.valueOf(z17));
            edit.putString(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, String.valueOf(z18));
            edit.putString("param_FailCode", String.valueOf(i16));
            edit.putString("mainProcess", String.valueOf(isMainProcess));
            edit.putString("sdkver", "android5.0+");
            a(edit);
            edit.commit();
            return;
        }
        MsfCore msfCore = MsfCore.sCore;
        if (msfCore == null || (jVar = msfCore.statReporter) == null) {
            str2 = "uin";
            str3 = "android5.0+";
            str4 = "sdkver";
            str5 = "param_FailCode";
            str6 = "mainProcess";
            str7 = "proxy";
        } else {
            str2 = "uin";
            str3 = "android5.0+";
            str4 = "sdkver";
            str5 = "param_FailCode";
            str6 = "mainProcess";
            str7 = "proxy";
            jVar.a("pullMsfReportQQ_V4", true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
        SharedPreferences.Editor edit2 = BaseApplication.getContext().getSharedPreferences("pull_msf" + i3, 0).edit();
        edit2.putString(str2, str);
        edit2.putString(str7, String.valueOf(z17));
        edit2.putString(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, String.valueOf(z18));
        edit2.putString(str5, String.valueOf(i16));
        edit2.putString(str6, String.valueOf(isMainProcess));
        edit2.putString(str4, str3);
        a(edit2);
        edit2.commit();
    }
}
