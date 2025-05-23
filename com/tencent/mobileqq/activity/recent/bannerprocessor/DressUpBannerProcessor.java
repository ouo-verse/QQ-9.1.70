package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.TextTipsBar;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class DressUpBannerProcessor extends RenewalsBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final int f185209h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f185209h = com.tencent.mobileqq.banner.d.A;
        }
    }

    public DressUpBannerProcessor(QBaseActivity qBaseActivity) {
        super(qBaseActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185267e = f185209h;
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

    @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor, com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        TextTipsBar textTipsBar = new TextTipsBar(baseActivity);
        textTipsBar.setTipsText("");
        textTipsBar.setButtonText("");
        textTipsBar.setTipsIcon(ResourcesCompat.getDrawable(baseActivity.getResources(), R.drawable.qui_info_filled_feedback_normal, null));
        textTipsBar.z(true);
        textTipsBar.setVisibility(8);
        return textTipsBar;
    }

    @Override // com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor, com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
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
                cooperation.vip.ad.n.k((BaseActivity) baseActivity, aVar.f200243c, hVar, BannerManager.l().f200217d);
                return;
            }
            return;
        }
        if (aVar.f200243c.getVisibility() == 8) {
            BannerManager.l().O(RenewalsBannerProcessor.f185265f, 0, null);
            this.f185266d = null;
        }
    }
}
