package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class MobileUnityBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185231d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69211);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f185231d = com.tencent.mobileqq.banner.d.f200254g;
        }
    }

    public MobileUnityBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(QBaseActivity qBaseActivity, com.tencent.mobileqq.activity.contact.phonecontact.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (qBaseActivity != null) {
            ReportController.o(qBaseActivity.getAppRuntime(), "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
            if (URLUtil.isValidUrl(aVar.f181294a)) {
                Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("url", aVar.f181294a);
                intent.putExtra(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
                qBaseActivity.startActivity(intent);
            } else {
                Intent intent2 = new Intent(qBaseActivity, (Class<?>) PhoneUnityBindInfoActivity.class);
                intent2.putExtra("kSrouce", 0);
                qBaseActivity.startActivity(intent2);
            }
            ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 5, 0, "", "", "", "");
        }
        BannerManager.l().K(f185231d, 0);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f185231d;
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
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.f161818f22).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().K(f185231d, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        final QBaseActivity baseActivity;
        com.tencent.biz.qui.noticebar.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (message == null || !(message.obj instanceof com.tencent.mobileqq.activity.contact.phonecontact.a) || (baseActivity = getBaseActivity()) == null || (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) == null) {
            return;
        }
        ReportController.o(baseActivity.getAppRuntime(), "CliOper", "", "", "0X8005B72", "0X8005B72", 0, 0, "", "", "", "");
        final com.tencent.mobileqq.activity.contact.phonecontact.a aVar2 = (com.tencent.mobileqq.activity.contact.phonecontact.a) message.obj;
        ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 5, 0, "", "", "", "");
        d16.setMsg(aVar2.f181295b).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileUnityBannerProcessor.f(QBaseActivity.this, aVar2, view);
            }
        });
    }
}
