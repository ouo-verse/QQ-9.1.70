package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class ThemeOverdueBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185275d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69238);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f185275d = com.tencent.mobileqq.banner.d.f200273z;
        }
    }

    public ThemeOverdueBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(int i3, int i16, String str, int i17, QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ThemeHandler.K2(i3, i16, str, i17, (BaseActivity) qBaseActivity);
        ReportController.o(null, "CliOper", "", "", "theme", "0X8007233", 0, 0, String.valueOf(i17), "", "", "");
        BannerManager.l().O(f185275d, 0, null);
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 15, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return f185275d;
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
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.h5_).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && baseActivity.getAppRuntime() != null && message != null && message.obj != null) {
            if (VasNormalToggle.VAS_BANNER_TIP_THEME_OLD_HIDE.isEnable(false)) {
                QLog.d("ThemeOverdueBannerProcessor", 1, "disable theme old banner");
                return;
            }
            com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.l().d(aVar.f200243c);
            if (d16 == null) {
                return;
            }
            Bundle bundle = (Bundle) message.obj;
            d16.setMsg(bundle.getString("expireMsg"));
            final int i3 = bundle.getInt("expireType", 4);
            final String string = bundle.getString("themeId");
            final int i16 = bundle.getInt("authResult");
            final int i17 = bundle.getInt("sSimpleOpen");
            ReportController.o(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(i3), "", "", "");
            ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 15, 0, "", "", "", "");
            d16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThemeOverdueBannerProcessor.f(i17, i16, string, i3, baseActivity, view);
                }
            });
        }
    }
}
