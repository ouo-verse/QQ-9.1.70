package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class RenewalsBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final int f185265f;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.mobileqq.redtouch.h f185266d;

    /* renamed from: e, reason: collision with root package name */
    protected int f185267e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69231);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f185265f = com.tencent.mobileqq.banner.d.f200271x;
        }
    }

    public RenewalsBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185267e = f185265f;
        }
    }

    private void e() {
        if (BannerManager.l().g(this.f185267e) != 0) {
            BannerManager.l().O(this.f185267e, 0, null);
        }
    }

    private void f(com.tencent.mobileqq.redtouch.h hVar) {
        if (BannerManager.l().g(this.f185267e) != 0) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = hVar;
        BannerManager.l().O(this.f185267e, 2, obtain);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f185267e;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        View inflate = View.inflate(baseActivity, R.layout.bfa, null);
        inflate.setVisibility(8);
        return inflate;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().K(this.f185267e, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        int i3 = message.what;
        if (i3 == 2000) {
            f((com.tencent.mobileqq.redtouch.h) message.obj);
        } else if (i3 == 2001) {
            e();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof com.tencent.mobileqq.redtouch.h) {
                com.tencent.mobileqq.redtouch.h hVar = (com.tencent.mobileqq.redtouch.h) obj;
                this.f185266d = hVar;
                cooperation.vip.ad.v.k((BaseActivity) baseActivity, aVar.f200243c, hVar, BannerManager.l().f200217d);
                return;
            }
            return;
        }
        if (aVar.f200243c.getVisibility() == 8) {
            BannerManager.l().O(f185265f, 0, null);
            this.f185266d = null;
        } else {
            cooperation.vip.ad.v.n((BaseActivity) baseActivity, aVar.f200243c, this.f185266d, BannerManager.l().f200217d);
        }
    }
}
