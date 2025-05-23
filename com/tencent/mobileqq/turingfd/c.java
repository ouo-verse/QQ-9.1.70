package com.tencent.mobileqq.turingfd;

import android.content.Context;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import com.tencent.turingfd.sdk.xq.ITuringDeviceInfoProvider;
import com.tencent.turingfd.sdk.xq.ITuringPkgProvider;
import com.tencent.turingfd.sdk.xq.ITuringPrivacyPolicy;
import com.tencent.turingfd.sdk.xq.PhoneResp;
import com.tencent.turingfd.sdk.xq.RiskDetectResp;
import com.tencent.turingfd.sdk.xq.TuringIDService;
import com.tencent.turingfd.sdk.xq.TuringPhoneService;
import com.tencent.turingfd.sdk.xq.TuringRiskService;
import com.tencent.turingfd.sdk.xq.TuringSDK;
import com.tencent.util.AbiUtil;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static c f303441b;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f303442c;

    /* renamed from: a, reason: collision with root package name */
    private Context f303443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements ITuringPkgProvider {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.ITuringPkgProvider
        public List<String> getPkgs() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements ITuringDeviceInfoProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.turingfd.a f303445a;

        b(com.tencent.mobileqq.turingfd.a aVar) {
            this.f303445a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) aVar);
            }
        }

        @Override // com.tencent.turingfd.sdk.xq.ITuringDeviceInfoProvider
        public String getAndroidId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f303445a.d();
        }

        @Override // com.tencent.turingfd.sdk.xq.ITuringDeviceInfoProvider
        public String getImei() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f303445a.e();
        }

        @Override // com.tencent.turingfd.sdk.xq.ITuringDeviceInfoProvider
        public String getImsi() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f303445a.f();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43986);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f303442c = new AtomicBoolean(false);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f303443a = BaseApplication.getContext();
        }
    }

    public static c a() {
        if (f303441b == null) {
            synchronized (c.class) {
                if (f303441b == null) {
                    f303441b = new c();
                }
            }
        }
        return f303441b;
    }

    public PhoneResp b(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PhoneResp) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), str);
        }
        e();
        return TuringPhoneService.reqPhoneToken(z16, str);
    }

    public ITuringDID c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ITuringDID) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        if (!f303442c.get()) {
            e();
        }
        if (z16) {
            return TuringIDService.getTuringDIDCached(BaseApplication.getContext());
        }
        return TuringIDService.getTuringDID(BaseApplication.getContext());
    }

    public String d(boolean z16) {
        ITuringDID turingDID;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        if (z16) {
            turingDID = TuringIDService.getTuringDIDCached(BaseApplication.getContext());
        } else {
            turingDID = TuringIDService.getTuringDID(BaseApplication.getContext());
        }
        return turingDID.getOpenIdTicket();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            f(false);
        }
    }

    public void f(boolean z16) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (f303442c.compareAndSet(false, true) && AbiUtil.isArm()) {
            if (z16 && 1 == MobileQQ.sProcessId) {
                appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            } else {
                appInterface = null;
            }
            com.tencent.mobileqq.turingfd.a g16 = com.tencent.mobileqq.turingfd.a.g(this.f303443a, appInterface, z16);
            HashMap hashMap = new HashMap();
            hashMap.put(11, g16.i());
            hashMap.put(12, g16.h());
            int init = TuringSDK.createConf(this.f303443a, new ITuringPrivacyPolicy() { // from class: com.tencent.mobileqq.turingfd.b
                @Override // com.tencent.turingfd.sdk.xq.ITuringPrivacyPolicy, com.tencent.turingfd.sdk.xq.LeoMinor
                public final boolean userAgreement() {
                    return PrivacyPolicyHelper.isUserAllow();
                }
            }).appid("1109803375").clientMetaDataMap(hashMap).turingDeviceInfoProvider(new b(g16)).turingPkgProvider(new a()).build().init();
            QLog.i("TuringSdkInitHelper", 1, "init turingfd :" + Log.getStackTraceString(new Throwable()));
            if (init == 0) {
                QLog.i("TuringSdkInitHelper", 1, "turing init success, " + TuringSDK.getVersionInfo());
                return;
            }
            QLog.i("TuringSdkInitHelper", 1, "turing init failed, error: " + init);
        }
    }

    public String g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        if (f303442c.get() && z16) {
            RiskDetectResp reqRiskDetectV2 = TuringRiskService.reqRiskDetectV2(this.f303443a);
            if (reqRiskDetectV2.getErrorCode() == 0) {
                QLog.i("TuringSdkInitHelper", 1, "turing risk detect success, deviceToken: " + reqRiskDetectV2.getDeviceToken());
                return reqRiskDetectV2.getDeviceToken();
            }
            QLog.i("TuringSdkInitHelper", 1, "turing risk detect error: " + reqRiskDetectV2.getErrorCode());
        }
        return "";
    }
}
