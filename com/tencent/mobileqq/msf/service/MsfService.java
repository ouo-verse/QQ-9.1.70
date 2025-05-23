package com.tencent.mobileqq.msf.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfService extends Service {
    static IPatchRedirector $redirector_ = null;
    public static final int DELAY_MILLIS = 10000;
    public static final int MSF_ALIVE_UPLOAD_MESSAGE = 10500;
    public static MsfCore core = null;
    private static String fromProcessName = null;
    public static volatile boolean inited = false;
    static HashSet<Integer> invalidUids = null;
    static HashSet<Integer> passedUids = null;
    public static volatile boolean sIsCreatedByAutoBoot = false;
    public static long serviceInitStart = 0;
    public static final String tag = "MSF.S.MsfService";
    private final IBaseService.Stub binder;
    public Handler mUIHandler;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfService.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 10500) {
                k.a(MsfService.this.mUIHandler);
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b extends IBaseService.Stub {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfService.this);
            }
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int getMsfConnectedIPFamily() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            try {
                return MsfService.core.getConnectedIPFamily();
            } catch (Exception e16) {
                QLog.w(MsfService.tag, 1, "service getMsfConnectedIPFamily error ", e16);
                return 0;
            }
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int getMsfConnectedNetType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            try {
                return MsfService.core.getConnectedNetType();
            } catch (Exception e16) {
                QLog.w(MsfService.tag, 1, "service getMsfConnectedNetType error ", e16);
                return 0;
            }
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            try {
                com.tencent.mobileqq.msf.core.y.a.h().k();
                return 0;
            } catch (Exception e16) {
                QLog.e(MsfService.tag, 1, "onApplicationBackground exception:", e16);
                return 0;
            }
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            try {
                com.tencent.mobileqq.msf.core.y.a.h().l();
                return 0;
            } catch (Exception e16) {
                QLog.e(MsfService.tag, 1, "onApplicationForeground exception:", e16);
                return 0;
            }
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onKillProcess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            SystemMethodProxy.killProcess(Process.myPid());
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int onProcessViewableChanged(boolean z16, long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Long.valueOf(j3), str)).intValue();
            }
            try {
                com.tencent.mobileqq.msf.core.y.a.h().a(z16, j3, str);
            } catch (Exception e16) {
                QLog.w(MsfService.tag, 1, "service onProcessViewableChanged error ", e16);
            }
            return 0;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public FromServiceMsg sendSyncToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FromServiceMsg) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
            }
            return null;
        }

        @Override // com.tencent.qphone.base.remote.IBaseService
        public int sendToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg)).intValue();
            }
            if (toServiceMsg == null) {
                if (QLog.isColorLevel()) {
                    QLog.w(MsfService.tag, 2, "sendToServiceMsg toServiceMsg null!");
                }
                return -1;
            }
            int nextSeq = MsfService.getCore().getNextSeq();
            if (toServiceMsg.getRequestSsoSeq() == -1) {
                toServiceMsg.setRequestSsoSeq(nextSeq);
            }
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(30000L);
            }
            if (com.tencent.mobileqq.msf.core.z.a.a(toServiceMsg)) {
                QLog.d(MsfService.tag, 1, "MsfService# receive from " + n.b(toServiceMsg) + ", MSG: " + com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
            }
            try {
                int callingUid = Binder.getCallingUid();
                toServiceMsg.addAttribute(BaseConstants.Attribute_TAG_ISAPPMSG, Boolean.TRUE);
                if (toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SYNC_SYNCUSER)) {
                    MsfService msfService = MsfService.this;
                    msfService.handleAccountSyncRequest(msfService, toServiceMsg, callingUid);
                } else if (MsfService.isSamePackage(MsfService.this, callingUid, toServiceMsg.getServiceCmd())) {
                    MsfService.getCore().getMsfServiceReqHandler().a(MsfService.this, toServiceMsg, callingUid);
                } else {
                    return -2;
                }
            } catch (Exception e16) {
                QLog.w(MsfService.tag, 1, "service handle msg error ", e16);
            }
            return nextSeq;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements Runnable {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfService.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                j.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfService.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.mobileqq.msf.service.b.d(MsfService.this);
                g.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class e extends BaseThread {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsfService.this);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.core.getStatReporter();
            MsfService.this.tryPrintMemoryInfo();
            MsfService.this.tryReportMSFControl(statReporter);
            try {
                LockMethodProxy.sleep(5000L);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            j.b();
            j.c();
            if (MsfService.this.isNeedReportStartWay()) {
                try {
                    LockMethodProxy.sleep(3000L);
                } catch (InterruptedException e17) {
                    e17.printStackTrace();
                }
                MsfService.this.reportMSFStartWay(statReporter);
                j.a(statReporter, false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23386);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        core = new MsfCore();
        inited = false;
        passedUids = new HashSet<>();
        invalidUids = new HashSet<>();
        sIsCreatedByAutoBoot = false;
        serviceInitStart = 0L;
        fromProcessName = "null";
    }

    public MsfService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mUIHandler = new a(Looper.getMainLooper());
            this.binder = new b();
        }
    }

    private void checkAppClone() {
        q.s().postDelayed(new d(), 10000L);
    }

    public static MsfCore getCore() {
        return core;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedReportStartWay() {
        boolean z16 = false;
        try {
            long parseLong = Long.parseLong(getCore().getAccountCenter().e());
            if (parseLong > 0 && (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || (parseLong / 1000) % 1000 < 5)) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "needReportStartWay=" + z16 + " " + parseLong);
            }
        } catch (Throwable th5) {
            QLog.e(tag, 1, "isNeedReportStartWay error!", th5);
        }
        return z16;
    }

    public static boolean isSamePackage(Context context, int i3, String str) {
        boolean z16;
        if (invalidUids.contains(Integer.valueOf(i3))) {
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "MSF_Alive_Log found invalid uid call " + i3);
            }
            return false;
        }
        if (!passedUids.contains(Integer.valueOf(i3))) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            String packageName = context.getPackageName();
            int length = packagesForUid.length;
            int i16 = 0;
            while (true) {
                if (i16 < length) {
                    if (packagesForUid[i16].equals(packageName)) {
                        if (QLog.isColorLevel()) {
                            QLog.d(tag, 2, "MSF_Alive_Log found accountSyncRequest from the same packeName application,");
                        }
                        passedUids.add(Integer.valueOf(i3));
                        z16 = false;
                    } else {
                        i16++;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                invalidUids.add(Integer.valueOf(i3));
                String str2 = "";
                for (String str3 : packagesForUid) {
                    str2 = str2 + " " + str3 + ";";
                }
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "MSF_Alive_Log found invalid uid call " + str2);
                }
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.tencent.mobileqq.msf.core.c0.j.f247805h, str2);
                    hashMap.put("method", str);
                    if (core.getStatReporter() != null) {
                        core.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247776z, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, "send invaild call error " + e16, e16);
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportMSFStartWay(com.tencent.mobileqq.msf.core.c0.j jVar) {
        int i3;
        String str;
        boolean z16;
        try {
            HashMap hashMap = new HashMap();
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (QLog.isColorLevel()) {
                        QLog.d(tag, 2, "process info: " + runningAppProcessInfo.processName + " " + runningAppProcessInfo.pid + " " + runningAppProcessInfo.uid);
                    }
                    if (MsfSdkUtils.isMainProcess(runningAppProcessInfo.processName)) {
                        i3 = runningAppProcessInfo.pid;
                        break;
                    }
                }
            }
            i3 = Integer.MAX_VALUE;
            hashMap.put("DEVICE", Build.DEVICE);
            hashMap.put("PRODUCT", Build.PRODUCT);
            hashMap.put("MANUFACTURER", Build.MANUFACTURER);
            hashMap.put("MODEL", DeviceInfoMonitor.getModel());
            hashMap.put("RELEASE", Build.VERSION.RELEASE);
            hashMap.put("FROM", fromProcessName);
            if (myPid < i3) {
                str = "Daemon";
            } else {
                str = "QQ";
            }
            hashMap.put("WAY", str);
            if (jVar != null) {
                if (QLog.isColorLevel()) {
                    for (String str2 : hashMap.keySet()) {
                        QLog.d(tag, 2, "upload map: " + str2 + ":" + ((String) hashMap.get(str2)));
                    }
                }
                if (myPid < i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                jVar.a("msfstartway", z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(tag, 2, "upload start way fail: RDM NULL!");
            }
        } catch (Exception e16) {
            QLog.d(tag, 1, "reportMSFStartWay error, ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryPrintMemoryInfo() {
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            try {
                com.tencent.mobileqq.msf.sdk.utils.a.c();
                com.tencent.mobileqq.msf.sdk.utils.a.b();
            } catch (Throwable th5) {
                QLog.e(tag, 1, "getMemoryInfo Error!", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReportMSFControl(com.tencent.mobileqq.msf.core.c0.j jVar) {
        SharedPreferences sharedPreferences = getCore().getSharedPreferences("crashcontrol", 4);
        int i3 = sharedPreferences.getInt("countRecvKillMsf", 0);
        if (i3 > 0) {
            if (jVar != null) {
                for (int i16 = 0; i16 < i3; i16++) {
                    jVar.a("countRecvKillMsf", true, 0L, 0L, (Map<String, String>) null, false, false);
                }
            }
            sharedPreferences.edit().putInt("countRecvKillMsf", 0).apply();
        }
        int i17 = sharedPreferences.getInt("countMsfRealExit", 0);
        if (i17 > 0) {
            if (jVar != null) {
                for (int i18 = 0; i18 < i17; i18++) {
                    jVar.a("countMsfRealExit", true, 0L, 0L, (Map<String, String>) null, false, false);
                }
            }
            sharedPreferences.edit().putInt("countMsfRealExit", 0).apply();
        }
    }

    protected void handleAccountSyncRequest(Context context, ToServiceMsg toServiceMsg, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, toServiceMsg, Integer.valueOf(i3));
            return;
        }
        if (toServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "handleAccountSyncRequest toServiceMsg null!");
            }
        } else if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SYNC_SYNCUSER)) {
            try {
                core.handleAccountSyncRequest(context, toServiceMsg, i3);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(tag, 2, "handleAccountSyncRequestReport error " + e16, e16);
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        String str = null;
        try {
            str = intent.getStringExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME);
            fromProcessName = str;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        QLog.d(tag, 1, "MSF_Alive_Log serivce onBind by :" + str);
        if (com.tencent.mobileqq.msf.core.x.b.a1()) {
            com.tencent.mobileqq.msf.core.x.b.a(false);
        }
        j.a(intent, 1);
        k.a(this.mUIHandler);
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onCreate();
        QLog.d(tag, 1, "MSF_Alive_Log serivce onCreate");
        serviceInit(this, sIsCreatedByAutoBoot);
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "MSF_Alive_Log serivce onCreate... autoBoot[" + sIsCreatedByAutoBoot + "]");
        }
        sIsCreatedByAutoBoot = false;
        q.s().postDelayed(new c(), 10000L);
        checkAppClone();
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d(tag, 1, "MSF_Alive_Log serivce onDestroy");
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            j.e();
        }
        try {
            BaseApplication.getContext().unregisterReceiver(core.getNetFlowStore());
        } catch (Exception e16) {
            QLog.d(tag, 1, "unregisterReceiver failed. " + e16, e16);
        }
        try {
            com.tencent.mobileqq.msf.core.stepcount.f.c().b();
        } catch (Exception e17) {
            QLog.d(tag, 1, "unregisterReceiver failed. " + e17, e17);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        String stringExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME);
            } catch (RuntimeException e16) {
                QLog.d(tag, 1, "getStringExtra error, ", e16);
            }
            QLog.d(tag, 1, "MSF_Alive_Log serivce onStart: ", stringExtra);
            j.a(intent, 2);
            k.a(this.mUIHandler);
            super.onStartCommand(intent, i3, i16);
            f.c().b(stringExtra);
            return 1;
        }
        stringExtra = null;
        QLog.d(tag, 1, "MSF_Alive_Log serivce onStart: ", stringExtra);
        j.a(intent, 2);
        k.a(this.mUIHandler);
        super.onStartCommand(intent, i3, i16);
        f.c().b(stringExtra);
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent)).booleanValue();
        }
        try {
            QLog.d(tag, 1, "MSF_Alive_Log service onUnbind by :" + intent.getStringExtra(MsfConstants.ATTRIBUTE_SENDERPROCESSNAME));
        } catch (RuntimeException e16) {
            QLog.e(tag, 1, "MSF_Alive_Log service onUnbind error, ", e16);
        }
        return super.onUnbind(intent);
    }

    public synchronized void serviceInit(Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, Boolean.valueOf(z16));
            return;
        }
        QLog.d(tag, 1, "MSF_Alive_Log serviceInit inited = " + inited + " boot = " + z16 + " gray = " + BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() + " public = " + BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion());
        if (!inited) {
            serviceInitStart = SystemClock.elapsedRealtime();
            if (com.tencent.mobileqq.msf.core.x.m.d()) {
                core.newServiceInit(context, z16);
            } else {
                core.init(context, z16);
            }
            inited = true;
            new e().start();
            QLog.d(tag, 1, "MSF_Alive_Log ServiceInitCost: " + (SystemClock.elapsedRealtime() - serviceInitStart));
        }
    }
}
