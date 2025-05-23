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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class MultiVideoBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185233d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f185233d = com.tencent.mobileqq.banner.d.R;
        }
    }

    public MultiVideoBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        if (appRuntime == null) {
            if (QLog.isColorLevel()) {
                QLog.e("MultiVideoBar", 2, "app is null");
            }
        } else {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            int L = qQAppInterface.getAVNotifyCenter().L();
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "initMultiVideoBar-->SessionType=" + L);
            }
            boolean z16 = true;
            if (L != 1 && L != 2) {
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.activity.k.a(qQAppInterface, L, (BaseActivity) qBaseActivity);
            } else {
                com.tencent.mobileqq.activity.k.b(qQAppInterface, L, (BaseActivity) qBaseActivity);
            }
            ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_VIDEO, BaseBannerProcessor.TVALUE_CLICK_VIDEO, 1, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (qQAppInterface != null) {
            if (qQAppInterface.getAVNotifyCenter().J() > 0) {
                BannerManager.l().K(f185233d, 2);
                return;
            }
            if (qQAppInterface.isVideoChatting()) {
                int L = qQAppInterface.getAVNotifyCenter().L();
                if (L != 3 && L != 4) {
                    if (L == 1) {
                        BannerManager.l().K(f185233d, 2);
                        return;
                    } else {
                        if (L == 2) {
                            BannerManager.l().K(f185233d, 2);
                            return;
                        }
                        return;
                    }
                }
                if (qQAppInterface.getAVNotifyCenter().n() > 0) {
                    BannerManager.l().K(f185233d, 2);
                    return;
                } else {
                    BannerManager.l().K(f185233d, 0);
                    return;
                }
            }
            BannerManager.l().K(f185233d, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return f185233d;
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
        return QUINoticeBarManager.l().g(baseActivity).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiVideoBannerProcessor.f(QBaseActivity.this, view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            g();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
        } else if (message.what == 2000) {
            g();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            g();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.c b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (b16 = QUINoticeBarManager.l().b(aVar.f200243c)) == null) {
            return;
        }
        fw.a.c((QQAppInterface) baseActivity.getAppRuntime(), b16, message, baseActivity.isResume());
    }
}
