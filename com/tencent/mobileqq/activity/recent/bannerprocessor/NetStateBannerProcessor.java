package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class NetStateBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185236d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f185236d = com.tencent.mobileqq.banner.d.f200249b;
        }
    }

    public NetStateBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            if (VersionUtils.isHoneycomb()) {
                baseActivity.startActivity(new Intent("android.settings.SETTINGS"));
            } else {
                baseActivity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            }
            ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 1, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int defaultTipsBarType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f185236d;
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
        return QUINoticeBarManager.l().k(baseActivity).e(R.string.ci8).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetStateBannerProcessor.this.f(view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        BannerManager l3 = BannerManager.l();
        int i3 = PCOnlineBannerProcessor.D;
        if (l3.n(i3)) {
            BannerManager.l().K(i3, 0);
            BannerManager.l().D(LoginDevicesBannerProcessor.f185224h, 2003);
            BannerManager.l().D(i3, 2004);
            BannerManager.l().D(i3, 2001);
            BannerManager.l().D(i3, 2000);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 1, 0, "", "", "", "");
        }
    }
}
