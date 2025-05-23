package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class UpgradeBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final int f185277e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f185278d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f185277e = com.tencent.mobileqq.banner.d.f200262o;
        }
    }

    public UpgradeBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185278d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        BannerManager.l().A(-1, null);
        if (com.tencent.mobileqq.upgrade.k.i().k() == 4) {
            com.tencent.mobileqq.upgrade.activity.q.b("0X8004DA4", Integer.parseInt(com.tencent.mobileqq.upgrade.k.n()), "1");
            com.tencent.mobileqq.upgrade.k.m().h();
        } else {
            com.tencent.mobileqq.upgrade.activity.q.b("0X8004DA3", Integer.parseInt(com.tencent.mobileqq.upgrade.k.n()), "1");
            UpgradeDetailActivity.Y2(qBaseActivity, com.tencent.mobileqq.upgrade.k.i().j(), true, true, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (com.tencent.mobileqq.upgrade.k.i().k() == 4) {
            str = "0X8004DA4";
        } else {
            str = "0X8004DA3";
        }
        com.tencent.mobileqq.upgrade.activity.q.b(str, Integer.parseInt(com.tencent.mobileqq.upgrade.k.n()), "0");
        BannerManager.l().O(f185277e, 0, null);
        com.tencent.mobileqq.upgrade.banner.b.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return f185277e;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        this.f185278d = QQTheme.isNowThemeIsNight();
        return com.tencent.mobileqq.upgrade.banner.b.c().e(R.string.iat).f(R.string.f237477h6, new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpgradeBannerProcessor.g(QBaseActivity.this, view);
            }
        }).k(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UpgradeBannerProcessor.h(view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().K(f185277e, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
        } else if (message.what == 3000) {
            BannerManager.l().O(f185277e, 2, message);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        aVar.f200243c.setVisibility(0);
        com.tencent.biz.qui.noticebar.e e16 = QUINoticeBarManager.l().e(aVar.f200243c);
        if (e16 == null) {
            QLog.d("UpgradeController_InstallBanner", 1, "updateBanner, IQUINoticeBarVas cast fail");
            return;
        }
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (message != null || isNowThemeIsNight != this.f185278d) {
            this.f185278d = isNowThemeIsNight;
            com.tencent.mobileqq.upgrade.banner.b.l(e16, null);
        }
    }
}
