package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.qqbanner.manager.VasADBannerManager;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class VasADBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.f, com.tencent.mobileqq.banner.processor.b, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final int f185279h;

    /* renamed from: d, reason: collision with root package name */
    private cooperation.vip.ad.j f185280d;

    /* renamed from: e, reason: collision with root package name */
    private VasADBannerManager f185281e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185282f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69241);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f185279h = com.tencent.mobileqq.banner.d.f200268u;
        }
    }

    public VasADBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185282f = false;
            this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
    }

    private void g(Message message) {
        QLog.d("VasADBannerProcessor", 1, "handleData");
        if (this.f185282f) {
            return;
        }
        if (this.f185280d == null) {
            this.f185280d = new cooperation.vip.ad.j((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
        Object obj = message.obj;
        if (obj instanceof Map) {
            Map<Integer, TianShuAccess.RspEntry> map = (Map) obj;
            cooperation.vip.ad.j jVar = this.f185280d;
            if (jVar != null) {
                jVar.f(map);
            }
        }
    }

    private void h() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        f();
        ((QQAppInterface) baseActivity.getAppRuntime()).getHandler(Conversation.class).sendEmptyMessage(1080);
    }

    private void i(Message message) {
        QBaseActivity baseActivity;
        Object obj = message.obj;
        if (obj == null) {
            if (j()) {
                BannerManager.l().O(f185279h, 2, message);
                return;
            } else {
                BannerManager.l().O(f185279h, 0, null);
                return;
            }
        }
        if (!(obj instanceof View[]) || (baseActivity = getBaseActivity()) == null) {
            return;
        }
        MqqHandler handler = ((QQAppInterface) baseActivity.getAppRuntime()).getHandler(Conversation.class);
        Message obtain = Message.obtain(message);
        obtain.what = 1081;
        handler.sendMessage(obtain);
    }

    private void k() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        j15.a g16 = cooperation.vip.qqbanner.manager.a.e().g(qQAppInterface.getAccount());
        if (g16 instanceof j15.b) {
            cooperation.vip.qqbanner.manager.a.e().k(qQAppInterface, g16);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.f
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        VasADBannerManager vasADBannerManager = this.f185281e;
        if (vasADBannerManager != null) {
            vasADBannerManager.G(z16);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        this.handler.removeCallbacksAndMessages(null);
        cooperation.vip.ad.j jVar = this.f185280d;
        if (jVar != null) {
            jVar.i();
        }
        this.f185282f = true;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return super.defaultTipsBarType();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        BannerManager l3 = BannerManager.l();
        int i3 = f185279h;
        com.tencent.mobileqq.banner.a f16 = l3.f(i3);
        if (f16 != null && f16.f200243c != null && f16.f200244d) {
            BannerManager.l().O(i3, 0, null);
            AppRuntime appRuntime = baseActivity.getAppRuntime();
            if (appRuntime != null) {
                BannerManager.l().r(appRuntime, f16.f200241a);
            }
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        BannerManager.l().O(f185279h, 0, null);
        VasADBannerManager vasADBannerManager = this.f185281e;
        if (vasADBannerManager != null) {
            vasADBannerManager.F();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return f185279h;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 2000) {
            if (i3 != 2001) {
                if (i3 != 3000) {
                    if (i3 != 3001) {
                        if (i3 != 3003) {
                            if (i3 == 3004) {
                                g(message);
                                return true;
                            }
                            return true;
                        }
                        k();
                        return true;
                    }
                    h();
                    return true;
                }
                i(message);
                return true;
            }
            VasADBannerManager vasADBannerManager = this.f185281e;
            if (vasADBannerManager != null) {
                vasADBannerManager.D();
                return true;
            }
            return true;
        }
        f();
        return true;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        VasADBannerManager vasADBannerManager = this.f185281e;
        if (vasADBannerManager != null) {
            return vasADBannerManager.A();
        }
        return null;
    }

    public boolean j() {
        VasADBannerManager f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (!(baseActivity instanceof BaseActivity) || (f16 = VasADBannerManager.f((BaseActivity) baseActivity, BannerManager.l())) == null) {
            return false;
        }
        VasADBannerManager vasADBannerManager = this.f185281e;
        if (vasADBannerManager == null || !vasADBannerManager.getClass().isInstance(f16) || !f16.getClass().isInstance(this.f185281e)) {
            this.f185281e = f16;
            e();
        }
        VasADBannerManager vasADBannerManager2 = this.f185281e;
        if (vasADBannerManager2 == null) {
            return false;
        }
        boolean C = vasADBannerManager2.C();
        QLog.i("VasADBannerProcessor", 1, "isNeedShowVasADBanner: " + C);
        return C;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        BannerManager.l().K(f185279h, 0);
        VasADBannerManager vasADBannerManager = this.f185281e;
        if (vasADBannerManager != null) {
            vasADBannerManager.c();
        }
        if (this.f185280d != null) {
            this.f185280d.h((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime());
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        VasADBannerManager vasADBannerManager = this.f185281e;
        if (vasADBannerManager != null) {
            vasADBannerManager.E();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        VasADBannerManager vasADBannerManager = this.f185281e;
        if (vasADBannerManager != null) {
            vasADBannerManager.onResume();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && message != null) {
            VasADBannerManager vasADBannerManager = this.f185281e;
            if (vasADBannerManager != null) {
                vasADBannerManager.N();
            }
            ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 11, 0, "", "", "", "");
        }
    }
}
