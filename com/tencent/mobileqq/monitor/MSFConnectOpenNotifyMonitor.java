package com.tencent.mobileqq.monitor;

import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFConnectOpenNotifyMonitor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private e f247249a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f247250b;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Runnable {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MSFConnectOpenNotifyMonitor.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            j statReporter;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                if (MSFConnectOpenNotifyMonitor.this.f247249a == null || MSFConnectOpenNotifyMonitor.this.f247249a.f247256a != MsfService.getCore().getConnSeq() || (statReporter = MsfService.getCore().getStatReporter()) == null) {
                    return;
                }
                String packageName = BaseApplication.getContext().getPackageName();
                boolean isProcessExist = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), packageName);
                if (!MSFConnectOpenNotifyMonitor.this.f247249a.f247258c && isProcessExist) {
                    MSFConnectOpenNotifyMonitor.this.f247249a.f247263h = true;
                }
                com.tencent.mobileqq.msf.service.d a16 = com.tencent.mobileqq.msf.service.e.a(packageName);
                if (a16 != null && a16.d() != null) {
                    z16 = false;
                    if (MSFConnectOpenNotifyMonitor.this.f247249a.f247259d && !z16) {
                        MSFConnectOpenNotifyMonitor.this.f247249a.f247264i = true;
                    }
                    MSFConnectOpenNotifyMonitor.this.f247249a.f247265j = 1;
                    QLog.d("MSFConnectOpenNotifyMonitor", 1, "do report, connSeq:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247256a + ", triggerType:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247265j + ", isMainProcessExist:" + isProcessExist + ", isPullMainProcessSuccess:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247263h + ", isMainProcessCallBackNull:" + z16 + ", isNotifyRegisterMSFSuccess:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247264i + ", isForeground:" + com.tencent.mobileqq.msf.core.y.a.h().i());
                    MSFConnectOpenNotifyMonitor mSFConnectOpenNotifyMonitor = MSFConnectOpenNotifyMonitor.this;
                    mSFConnectOpenNotifyMonitor.k(statReporter, mSFConnectOpenNotifyMonitor.f247249a);
                    MSFConnectOpenNotifyMonitor.this.f247249a = null;
                }
                z16 = true;
                if (MSFConnectOpenNotifyMonitor.this.f247249a.f247259d) {
                    MSFConnectOpenNotifyMonitor.this.f247249a.f247264i = true;
                }
                MSFConnectOpenNotifyMonitor.this.f247249a.f247265j = 1;
                QLog.d("MSFConnectOpenNotifyMonitor", 1, "do report, connSeq:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247256a + ", triggerType:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247265j + ", isMainProcessExist:" + isProcessExist + ", isPullMainProcessSuccess:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247263h + ", isMainProcessCallBackNull:" + z16 + ", isNotifyRegisterMSFSuccess:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247264i + ", isForeground:" + com.tencent.mobileqq.msf.core.y.a.h().i());
                MSFConnectOpenNotifyMonitor mSFConnectOpenNotifyMonitor2 = MSFConnectOpenNotifyMonitor.this;
                mSFConnectOpenNotifyMonitor2.k(statReporter, mSFConnectOpenNotifyMonitor2.f247249a);
                MSFConnectOpenNotifyMonitor.this.f247249a = null;
            } catch (Exception e16) {
                QLog.d("MSFConnectOpenNotifyMonitor", 1, "run delay report error,", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f247252d;

        b(long j3) {
            this.f247252d = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MSFConnectOpenNotifyMonitor.this, Long.valueOf(j3));
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
            try {
                MSFConnectOpenNotifyMonitor.this.f247249a = new e(this.f247252d);
                MSFConnectOpenNotifyMonitor.this.f247249a.f247257b = System.currentTimeMillis();
                String packageName = BaseApplication.getContext().getPackageName();
                MSFConnectOpenNotifyMonitor.this.f247249a.f247258c = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), packageName);
                com.tencent.mobileqq.msf.service.d a16 = com.tencent.mobileqq.msf.service.e.a(packageName);
                e eVar = MSFConnectOpenNotifyMonitor.this.f247249a;
                if (a16 != null && a16.d() != null) {
                    z16 = false;
                    eVar.f247259d = z16;
                    MSFConnectOpenNotifyMonitor.this.f247249a.f247260e = com.tencent.mobileqq.msf.core.y.a.h().i();
                    QLog.d("MSFConnectOpenNotifyMonitor", 1, "onConnOpened, connSeq:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247256a + ", triggerType:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247265j + ", isMainProcessExist:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247258c + ", isMainProcessCallBackNull:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247259d + ", isForeground:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247260e);
                    q.q().removeCallbacks(MSFConnectOpenNotifyMonitor.this.f247250b);
                    q.q().postDelayed(MSFConnectOpenNotifyMonitor.this.f247250b, 5000L);
                }
                z16 = true;
                eVar.f247259d = z16;
                MSFConnectOpenNotifyMonitor.this.f247249a.f247260e = com.tencent.mobileqq.msf.core.y.a.h().i();
                QLog.d("MSFConnectOpenNotifyMonitor", 1, "onConnOpened, connSeq:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247256a + ", triggerType:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247265j + ", isMainProcessExist:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247258c + ", isMainProcessCallBackNull:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247259d + ", isForeground:" + MSFConnectOpenNotifyMonitor.this.f247249a.f247260e);
                q.q().removeCallbacks(MSFConnectOpenNotifyMonitor.this.f247250b);
                q.q().postDelayed(MSFConnectOpenNotifyMonitor.this.f247250b, 5000L);
            } catch (Exception e16) {
                QLog.d("MSFConnectOpenNotifyMonitor", 1, "run onConnOpened error,", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MSFConnectOpenNotifyMonitor.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("MSFConnectOpenNotifyMonitor", 1, "onRegProxySvcSend");
                MSFConnectOpenNotifyMonitor.this.f(2);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MSFConnectOpenNotifyMonitor.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.d("MSFConnectOpenNotifyMonitor", 1, "onRegProxySvcRsp");
                MSFConnectOpenNotifyMonitor.this.f(3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f247256a;

        /* renamed from: b, reason: collision with root package name */
        long f247257b;

        /* renamed from: c, reason: collision with root package name */
        boolean f247258c;

        /* renamed from: d, reason: collision with root package name */
        boolean f247259d;

        /* renamed from: e, reason: collision with root package name */
        boolean f247260e;

        /* renamed from: f, reason: collision with root package name */
        boolean f247261f;

        /* renamed from: g, reason: collision with root package name */
        long f247262g;

        /* renamed from: h, reason: collision with root package name */
        boolean f247263h;

        /* renamed from: i, reason: collision with root package name */
        boolean f247264i;

        /* renamed from: j, reason: collision with root package name */
        int f247265j;

        public e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
                return;
            }
            this.f247257b = 0L;
            this.f247258c = true;
            this.f247259d = false;
            this.f247260e = false;
            this.f247261f = false;
            this.f247262g = 0L;
            this.f247263h = false;
            this.f247264i = false;
            this.f247265j = 0;
            this.f247256a = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final MSFConnectOpenNotifyMonitor f247266a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19276);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247266a = new MSFConnectOpenNotifyMonitor(null);
            }
        }
    }

    /* synthetic */ MSFConnectOpenNotifyMonitor(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i3) {
        j statReporter;
        boolean z16;
        e eVar;
        try {
            e eVar2 = this.f247249a;
            if (eVar2 == null || eVar2.f247256a != MsfService.getCore().getConnSeq() || (statReporter = MsfService.getCore().getStatReporter()) == null) {
                return;
            }
            q.q().removeCallbacks(this.f247250b);
            e eVar3 = this.f247249a;
            eVar3.f247261f = true;
            eVar3.f247262g = System.currentTimeMillis() - this.f247249a.f247257b;
            String packageName = BaseApplication.getContext().getPackageName();
            boolean isProcessExist = MsfSdkUtils.isProcessExist(BaseApplication.getContext(), packageName);
            e eVar4 = this.f247249a;
            if (!eVar4.f247258c && isProcessExist) {
                eVar4.f247263h = true;
            }
            com.tencent.mobileqq.msf.service.d a16 = com.tencent.mobileqq.msf.service.e.a(packageName);
            if (a16 != null && a16.d() != null) {
                z16 = false;
                eVar = this.f247249a;
                if (eVar.f247259d && !z16) {
                    eVar.f247264i = true;
                }
                eVar.f247265j = i3;
                QLog.d("MSFConnectOpenNotifyMonitor", 1, "do report, connSeq:" + this.f247249a.f247256a + ", triggerType:" + this.f247249a.f247265j + ", isMainProcessExist:" + isProcessExist + ", isPullMainProcessSuccess:" + this.f247249a.f247263h + ", isMainProcessCallBackNull:" + z16 + ", isNotifyRegisterMSFSuccess:" + this.f247249a.f247264i + ", connOpenToProxyRegTime:" + this.f247249a.f247262g + ", isForeground:" + com.tencent.mobileqq.msf.core.y.a.h().i());
                k(statReporter, this.f247249a);
                this.f247249a = null;
            }
            z16 = true;
            eVar = this.f247249a;
            if (eVar.f247259d) {
                eVar.f247264i = true;
            }
            eVar.f247265j = i3;
            QLog.d("MSFConnectOpenNotifyMonitor", 1, "do report, connSeq:" + this.f247249a.f247256a + ", triggerType:" + this.f247249a.f247265j + ", isMainProcessExist:" + isProcessExist + ", isPullMainProcessSuccess:" + this.f247249a.f247263h + ", isMainProcessCallBackNull:" + z16 + ", isNotifyRegisterMSFSuccess:" + this.f247249a.f247264i + ", connOpenToProxyRegTime:" + this.f247249a.f247262g + ", isForeground:" + com.tencent.mobileqq.msf.core.y.a.h().i());
            k(statReporter, this.f247249a);
            this.f247249a = null;
        } catch (Exception e16) {
            QLog.d("MSFConnectOpenNotifyMonitor", 1, "run onRegProxySvcSend error,", e16);
        }
    }

    public static MSFConnectOpenNotifyMonitor g() {
        return f.f247266a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(j jVar, e eVar) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("param_connSeq", String.valueOf(eVar.f247256a));
            hashMap.put("param_connOpenTime", String.valueOf(eVar.f247257b));
            hashMap.put("param_isMainProcessExist", String.valueOf(eVar.f247258c));
            hashMap.put("param_isMainProcessCallBackNull", String.valueOf(eVar.f247259d));
            hashMap.put("param_isForeground", String.valueOf(eVar.f247260e));
            hashMap.put("param_isTriggerProxyReg", String.valueOf(eVar.f247261f));
            hashMap.put("param_connOpenToProxyRegTime", String.valueOf(eVar.f247262g));
            hashMap.put("param_isPullMainProcessSuccess", String.valueOf(eVar.f247263h));
            hashMap.put("param_isNotifyRegisterMsfSuccess", String.valueOf(eVar.f247264i));
            hashMap.put("param_triggerType", String.valueOf(eVar.f247265j));
            jVar.a(g.I3, false, 0L, 0L, (Map<String, String>) hashMap, true, false);
        } catch (Exception e16) {
            QLog.d("MSFConnectOpenNotifyMonitor", 1, "run reportMSFOpenNotifyMonitorEvent error,", e16);
        }
    }

    public void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            q.q().post(new b(j3));
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            q.q().post(new d());
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            q.q().post(new c());
        }
    }

    MSFConnectOpenNotifyMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f247250b = new a();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
