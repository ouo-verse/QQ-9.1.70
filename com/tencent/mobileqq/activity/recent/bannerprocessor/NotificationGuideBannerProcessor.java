package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class NotificationGuideBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185237d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69217);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f185237d = com.tencent.mobileqq.banner.d.U;
        }
    }

    public NotificationGuideBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return f185237d;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        com.tencent.biz.qui.noticebar.d h16 = QUINoticeBarManager.l().h(baseActivity);
        com.tencent.mobileqq.chat.h.g((QQAppInterface) baseActivity.getAppRuntime()).i(BannerManager.l(), (BaseActivity) baseActivity, h16);
        return h16.getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            BannerManager.l().K(f185237d, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        QBaseActivity baseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            if (message.what != 3000 || (baseActivity = getBaseActivity()) == null) {
                return;
            }
            com.tencent.mobileqq.chat.h.g((QQAppInterface) baseActivity.getAppRuntime()).p(BannerManager.l(), message);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null) {
            return;
        }
        com.tencent.mobileqq.chat.h.g((QQAppInterface) baseActivity.getAppRuntime()).u(BannerManager.l(), d16);
    }
}
