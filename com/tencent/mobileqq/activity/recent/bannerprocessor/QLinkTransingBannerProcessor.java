package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qlink.QQProxyForQlink;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class QLinkTransingBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185263d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f185263d = com.tencent.mobileqq.banner.d.S;
        }
    }

    public QLinkTransingBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((QQAppInterface) qBaseActivity.getAppRuntime()).getQQProxyForQlink().B("0X800474F", 1);
        QQProxyForQlink.P(qBaseActivity, 4, null);
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_VIDEO, BaseBannerProcessor.TVALUE_CLICK_VIDEO, 3, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return f185263d;
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
        return QUINoticeBarManager.l().h(baseActivity).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QLinkTransingBannerProcessor.f(QBaseActivity.this, view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        int i3 = 0;
        if (((QQAppInterface) baseActivity.getAppRuntime()).getQQProxyForQlink().m() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        BannerManager l3 = BannerManager.l();
        int i16 = f185263d;
        if (z16) {
            i3 = 2;
        }
        l3.K(i16, i3);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null) {
            return;
        }
        if (baseActivity.getAppRuntime() != null) {
            int m3 = ((QQAppInterface) baseActivity.getAppRuntime()).getQQProxyForQlink().m();
            if (m3 != 0) {
                d16.getView().setVisibility(0);
                int i3 = ((QQAppInterface) baseActivity.getAppRuntime()).getQQProxyForQlink().o().mMode;
                String qqStr = HardCodeUtil.qqStr(R.string.f171629jw1);
                if (1 == i3) {
                    qqStr = HardCodeUtil.qqStr(R.string.jwa);
                } else if (2 == i3) {
                    qqStr = HardCodeUtil.qqStr(R.string.f171628jw0);
                }
                d16.setMsg(baseActivity.getString(R.string.f5q) + qqStr + m3 + baseActivity.getString(R.string.f5r));
                ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_VIDEO, BaseBannerProcessor.TVALUE_SHOW_VIDEO, 3, 0, "", "", "", "");
                return;
            }
            d16.getView().setVisibility(8);
            return;
        }
        d16.getView().setVisibility(8);
    }
}
