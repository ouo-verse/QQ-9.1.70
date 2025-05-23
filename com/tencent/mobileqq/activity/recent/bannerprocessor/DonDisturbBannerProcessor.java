package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class DonDisturbBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185208d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69198);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f185208d = com.tencent.mobileqq.banner.d.f200260m;
        }
    }

    public DonDisturbBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (qBaseActivity.getAppRuntime() != null) {
            ((CardHandler) ((AppInterface) qBaseActivity.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).W4(0, "", "not_disturb_from_conversation");
            ReportController.o(qBaseActivity.getAppRuntime(), "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        PublicFragmentActivity.start(qBaseActivity, new Intent(), NotifyPushSettingFragment.class);
        ReportController.o(qBaseActivity.getAppRuntime(), "CliOper", "", "", "0X8009EBB", "0X8009EBB", 0, 1, "", "", "", "");
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 2, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return f185208d;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        return QUINoticeBarManager.l().h(baseActivity).e(R.string.frs).f(R.string.jw5, new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonDisturbBannerProcessor.g(QBaseActivity.this, view);
            }
        }).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonDisturbBannerProcessor.h(QBaseActivity.this, view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onBeforeAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        } else {
            BannerManager.l().K(f185208d, 0);
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
        if (baseActivity == null) {
            return;
        }
        if (FriendsStatusUtil.c(baseActivity)) {
            if (message == null) {
                return;
            }
            if (message.arg1 == 2) {
                aVar.f200243c.setVisibility(0);
                ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 2, 0, "", "", "", "");
                return;
            } else {
                aVar.f200243c.setVisibility(8);
                return;
            }
        }
        aVar.f200243c.setVisibility(8);
    }
}
