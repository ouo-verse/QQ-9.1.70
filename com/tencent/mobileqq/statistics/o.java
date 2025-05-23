package com.tencent.mobileqq.statistics;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.log.IObservableLog;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.IQimeiSDK;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qimei.strategy.terminal.ITerminalStrategy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f290062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IObservableLog {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qimei.log.IObservableLog
        public void onLog(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                QLog.d("Qqimei", 1, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements IAsyncQimeiListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f290063a;

        b(c cVar) {
            this.f290063a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // com.tencent.qimei.sdk.IAsyncQimeiListener
        public void onQimeiDispatch(Qimei qimei) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qimei);
            } else if (qimei == null) {
                this.f290063a.a("", "");
            } else {
                this.f290063a.a(qimei.getQimei16(), qimei.getQimei36());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void a(String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f290062a = new AtomicBoolean(false);
        }
    }

    private static String a() {
        return "0S200MNJT807V3GE";
    }

    public static String b() {
        Qimei qimei = QimeiSDK.getInstance(a()).getQimei();
        if (qimei == null) {
            return "";
        }
        return qimei.getQimei16();
    }

    public static String c() {
        Qimei qimei = QimeiSDK.getInstance(a()).getQimei();
        if (qimei == null) {
            return "";
        }
        return qimei.getQimei36();
    }

    public static void d(c cVar) {
        QimeiSDK.getInstance(a()).getQimei(new b(cVar));
    }

    public static void e(boolean z16) {
        boolean z17;
        long currentTimeMillis = System.currentTimeMillis();
        if (!PrivacyPolicyHelper.isUserAllow()) {
            z17 = false;
        } else {
            z17 = true;
        }
        AtomicBoolean atomicBoolean = f290062a;
        QLog.d("Qqimei", 1, "[initQimeiSdk] force: ", Boolean.valueOf(z16), ", allow: ", Boolean.valueOf(z17), ", init: ", Boolean.valueOf(atomicBoolean.get()));
        if ((!z16 && !z17) || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        IQimeiSDK qimeiSDK = QimeiSDK.getInstance(a());
        qimeiSDK.setChannelID(AppSetting.h()).setLogAble(f());
        ITerminalStrategy strategy = qimeiSDK.getStrategy();
        strategy.enableAndroidId(false).enableCid(z17).enableIMEI(false).enableIMSI(false).enableBuildModel(false).enableOAID(false).enableMAC(false).enableProcessInfo(false);
        if (z17) {
            l f16 = l.f(context);
            strategy.setAndroidId(f16.b()).setIMEI(f16.c()).setIMSI(f16.e()).setMAC(f16.g()).setOAID(f16.l()).setBuildModel(f16.i());
        }
        if (!Foreground.isCurrentProcessForeground()) {
            strategy.setUserAgreePrivacy(false);
        }
        qimeiSDK.init(context);
        qimeiSDK.setLogObserver(new a());
        QLog.d("Qqimei", 1, "[initQimeiSdk] init. process: ", MobileQQ.processName + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static boolean f() {
        return false;
    }

    public static void g(boolean z16) {
        QimeiSDK.getInstance(a()).getStrategy().setUserAgreePrivacy(z16);
    }
}
