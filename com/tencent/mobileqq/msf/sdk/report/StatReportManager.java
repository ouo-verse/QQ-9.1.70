package com.tencent.mobileqq.msf.sdk.report;

import android.os.SystemClock;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class StatReportManager {
    static IPatchRedirector $redirector_ = null;
    private static final String APPID_TAG = "param_ProductVersion";
    public static final String TAG = "StatReportManager";
    public static String sAccount = "1000";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c extends a {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: b, reason: collision with root package name */
        public static final String f250690b = "msf_core_DeadObjectException";

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static final c f250691a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17536);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f250691a = new c();
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static c b() {
            return a.f250691a;
        }

        public void a(String str, String str2, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4);
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis() + "_" + str + "_" + str4 + " " + str2 + "_" + str3);
            a("uin", String.valueOf(str));
            a("type", String.valueOf(str2));
            a("msg", valueOf);
            a("exception", String.valueOf(str3));
            a("processName", String.valueOf(str4));
            a("msf_core_DeadObjectException", true, 0L, 0L, true);
            a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class d extends a {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: g, reason: collision with root package name */
        private static final String f250692g = "EventMsfReceiverHeld";

        /* renamed from: h, reason: collision with root package name */
        public static final String f250693h = "msf.sdk.MsfReceiverHeld";

        /* renamed from: b, reason: collision with root package name */
        private boolean f250694b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f250695c;

        /* renamed from: d, reason: collision with root package name */
        private int f250696d;

        /* renamed from: e, reason: collision with root package name */
        private long f250697e;

        /* renamed from: f, reason: collision with root package name */
        private int f250698f;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        private static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static final d f250699a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28263);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f250699a = new d();
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f250694b = false;
            this.f250695c = false;
            this.f250696d = 0;
            this.f250697e = 0L;
            this.f250698f = 0;
        }

        public static d b() {
            return a.f250699a;
        }

        public void a(String str, String str2, int i3) {
            Object obj;
            j jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
                return;
            }
            int i16 = this.f250696d;
            if (i16 == 0) {
                if (i3 >= 10) {
                    this.f250697e = SystemClock.uptimeMillis();
                    this.f250696d = i3;
                    return;
                }
                return;
            }
            if (i16 > 0 && i3 > i16) {
                this.f250696d = i3;
                int i17 = this.f250698f + 1;
                this.f250698f = i17;
                if (this.f250697e > 0 && i17 >= 5 && Math.abs(SystemClock.uptimeMillis() - this.f250697e) > MiniBoxNoticeInfo.MIN_5 && !this.f250695c) {
                    this.f250695c = true;
                    String threadStackString = MsfSdkUtils.getThreadStackString("MSF-Receiver");
                    a();
                    a("queuesize", String.valueOf(i3));
                    a("time", "5");
                    a("uin", str2);
                    a("cmd", str);
                    if (MsfServiceSdk.get().getProxy() != null) {
                        obj = Boolean.valueOf(MsfServiceSdk.get().getProxy().serviceConnected());
                    } else {
                        obj = "false";
                    }
                    a("binder", String.valueOf(obj));
                    a("stack", threadStackString);
                    QLog.w(f250692g, 1, "MSF-Receiver held 5min " + BaseApplication.gMsfReceiverStarted);
                    com.tencent.mobileqq.msf.sdk.report.a.a(new com.tencent.mobileqq.msf.sdk.report.b("MSF-Receiver Held " + BaseApplication.gMsfReceiverStarted), "MSFReceiverHeldCatchedException", "MSF-Receiver\u7ebf\u7a0b\u5361\u4f4f5\u5206\u949f");
                    MsfCore msfCore = MsfCore.sCore;
                    if (msfCore != null && (jVar = msfCore.statReporter) != null) {
                        jVar.a(f250693h, true, SystemClock.elapsedRealtime() - this.f250697e, 0L, (Map<String, String>) new HashMap(), false, false);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 <= i16) {
                this.f250696d = 0;
                this.f250697e = 0L;
                this.f250698f = 0;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e extends a {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: f, reason: collision with root package name */
        private static final String f250700f = "pullServiceFail";

        /* renamed from: b, reason: collision with root package name */
        private boolean f250701b;

        /* renamed from: c, reason: collision with root package name */
        private long f250702c;

        /* renamed from: d, reason: collision with root package name */
        private short f250703d;

        /* renamed from: e, reason: collision with root package name */
        private long f250704e;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        private static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static final e f250705a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.VALUE.UIN_TYPE_KANDIAN_LOCKSCREEN_INTERACT_PUSH);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f250705a = new e();
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f250701b = false;
            this.f250702c = 0L;
            this.f250703d = (short) 0;
            this.f250704e = 0L;
        }

        public static e c() {
            return a.f250705a;
        }

        private void f() {
            if (!MsfServiceSdk.isUseNewProxy) {
                return;
            }
            h.a(StatReportManager.sAccount, false);
        }

        private void g() {
            if (!MsfServiceSdk.isUseNewProxy) {
                return;
            }
            if ((BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) && this.f250703d > 1 && this.f250702c > 0 && SystemClock.elapsedRealtime() - this.f250702c <= 120000) {
                h.a(StatReportManager.sAccount, true);
            }
        }

        private void h() {
            this.f250704e = 0L;
            this.f250702c = 0L;
            this.f250703d = (short) 0;
            this.f250701b = false;
        }

        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            short s16 = (short) (this.f250703d + 1);
            this.f250703d = s16;
            if (s16 > 10 && this.f250704e == 0 && this.f250702c > 0 && SystemClock.elapsedRealtime() > this.f250702c + 60000 && !this.f250701b) {
                this.f250704e = SystemClock.elapsedRealtime();
                this.f250701b = true;
                f();
                QLog.d(f250700f, 1, "cannot pull msf service.");
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f250702c == 0) {
                this.f250702c = SystemClock.elapsedRealtime();
            }
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                g();
                h();
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                h();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11311);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public StatReportManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17) {
        RdmReq rdmReq = new RdmReq();
        rdmReq.eventName = str2;
        rdmReq.elapse = j3;
        rdmReq.size = j16;
        rdmReq.isSucceed = z16;
        rdmReq.isRealTime = z17;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        } else {
            HashSet<String> hashSet = new HashSet();
            hashSet.addAll(hashMap.keySet());
            for (String str4 : hashSet) {
                if (hashMap.get(str4) == null) {
                    hashMap.put(str4, "");
                }
            }
        }
        hashMap.put("param_ProductVersion", "" + BaseApplication.getContext().getAppId());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "event report: " + str2 + " " + z16 + " time:" + j3 + " size:" + j16);
        }
        if (z16 && (!hashMap.containsKey("param_FailCode") || "".equals(hashMap.get("param_FailCode")))) {
            hashMap.put("param_FailCode", String.valueOf(0));
        }
        rdmReq.params = hashMap;
        try {
            ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
            rdmReportMsg.setTimeout(30000L);
            MsfServiceSdk.get().sendMsg(rdmReportMsg);
        } catch (Exception unused) {
        }
    }

    public static void reportMonitorSocketIllegalMonitorStateException(Throwable th5) {
        j jVar;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", MsfCore.sCore.getAccountCenter().e());
            hashMap.put("exception", th5.getMessage());
            MsfCore msfCore = MsfCore.sCore;
            if (msfCore != null && (jVar = msfCore.statReporter) != null) {
                jVar.a(g.K2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b extends a {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: d, reason: collision with root package name */
        public static final String f250686d = "msf.sdk.event_bindCost";

        /* renamed from: b, reason: collision with root package name */
        private long f250687b;

        /* renamed from: c, reason: collision with root package name */
        private short f250688c;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        private static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static final b f250689a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16356);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f250689a = new b();
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f250687b = 0L;
                this.f250688c = (short) 0;
            }
        }

        private void a(long j3) {
            a("proxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
            a(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
            a("count", String.valueOf((int) this.f250688c));
            a(f250686d, true, j3, 0L, true);
        }

        public static b c() {
            return a.f250689a;
        }

        public void b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
            } else if (this.f250687b == 0) {
                this.f250687b = j3;
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f250688c = (short) (this.f250688c + 1);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
                return;
            }
            if (this.f250687b > 0 && z16) {
                a(System.currentTimeMillis() - this.f250687b);
            }
            this.f250687b = 0L;
            this.f250688c = (short) 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        HashMap<String, String> f250685a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f250685a = null;
            }
        }

        public void a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (this.f250685a == null) {
                this.f250685a = new HashMap<>();
            }
            this.f250685a.put(str, str2);
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            HashMap<String, String> hashMap = this.f250685a;
            if (hashMap != null) {
                hashMap.clear();
            }
        }

        public void a(RdmReq rdmReq) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) rdmReq);
                return;
            }
            try {
                ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
                rdmReportMsg.setTimeout(30000L);
                MsfServiceSdk.get().sendMsg(rdmReportMsg);
            } catch (Exception unused) {
            }
        }

        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = str;
            rdmReq.isRealTime = true;
            rdmReq.params = this.f250685a;
            a(rdmReq);
        }

        public void a(String str, boolean z16, long j3, long j16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Boolean.valueOf(z17));
                return;
            }
            RdmReq rdmReq = new RdmReq();
            rdmReq.eventName = str;
            rdmReq.isSucceed = z16;
            rdmReq.elapse = j3;
            rdmReq.size = j16;
            rdmReq.isRealTime = z17;
            rdmReq.params = this.f250685a;
            a(rdmReq);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f extends a {
        static IPatchRedirector $redirector_ = null;

        /* renamed from: b, reason: collision with root package name */
        public static final String f250706b = "msf.sdk.event_sendToServiceCost";

        /* compiled from: P */
        /* loaded from: classes15.dex */
        private static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            private static final f f250707a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27414);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f250707a = new f();
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private void a(long j3) {
            a("proxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
            a(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
            a(f250706b, true, j3, 0L, true);
        }

        public static f b() {
            return a.f250707a;
        }

        public void a(ToServiceMsg toServiceMsg, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, toServiceMsg, Boolean.valueOf(z16));
            } else {
                if (z16 || MsfCommand.reportRdm.equals(toServiceMsg.getMsfCommand()) || BaseConstants.CMD_REPORTRDM.equals(toServiceMsg.getServiceCmd())) {
                    return;
                }
                toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_APP_SENDMSG, Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void a(ToServiceMsg toServiceMsg, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, i3);
                return;
            }
            if (toServiceMsg != null && i3 > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_SENDSUCCTIME, Long.valueOf(currentTimeMillis));
                long longValue = ((Long) toServiceMsg.getAttribute(MsfConstants.ATTRIBUTE_APP_SENDMSG, 0L)).longValue();
                if (longValue > 0) {
                    a(currentTimeMillis - longValue);
                }
            }
        }
    }
}
