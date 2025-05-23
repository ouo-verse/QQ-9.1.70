package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class NetNeedSignOnBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185235d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69215);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f185235d = com.tencent.mobileqq.banner.d.f200258k;
        }
    }

    public NetNeedSignOnBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(String str, QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "click move to url:" + str);
        }
        Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserDelegationActivity.class);
        intent.putExtra("injectrecommend", true);
        qBaseActivity.startActivity(intent.putExtra("url", str));
        ReportController.r(qBaseActivity.getAppRuntime(), "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
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
        return f185235d;
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
        return QUINoticeBarManager.l().k(baseActivity).e(R.string.f171138ci3).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.f f16;
        final String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (message != null && message.arg1 != 0) {
            final QBaseActivity baseActivity = getBaseActivity();
            if (baseActivity == null || (f16 = QUINoticeBarManager.l().f(aVar.f200243c)) == null) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                str = String.valueOf(obj);
            } else {
                str = "https://qq.com";
            }
            f16.c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NetNeedSignOnBannerProcessor.f(str, baseActivity, view);
                }
            });
            ReportController.r(baseActivity.getAppRuntime(), "CliOper", "", "", "0X8004028", "0X8004028", 0, 0, "", "", "", "");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "updateNetNeedSignOn return, msg == null || msg.arg1==HIDE");
        }
    }
}
