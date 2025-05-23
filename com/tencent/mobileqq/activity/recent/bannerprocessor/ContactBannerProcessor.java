package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.CommonMMKVUtils;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class ContactBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final int f185204f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f185205d;

    /* renamed from: e, reason: collision with root package name */
    public od2.a f185206e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements od2.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ContactBannerProcessor.this);
            }
        }

        @Override // od2.a
        public void B7(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // od2.a
        public void L1(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else if ((i3 & 1) != 0) {
                ((BaseBannerProcessor) ContactBannerProcessor.this).handler.removeMessages(1000);
                ((BaseBannerProcessor) ContactBannerProcessor.this).handler.sendEmptyMessageDelayed(1000, 1000L);
            }
        }

        @Override // od2.a
        public void T2(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        @Override // od2.a
        public void Ug(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                ((BaseBannerProcessor) ContactBannerProcessor.this).handler.removeMessages(1000);
                ((BaseBannerProcessor) ContactBannerProcessor.this).handler.sendEmptyMessageDelayed(1000, 1000L);
            }
        }

        @Override // od2.a
        public void e7(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69197);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f185204f = com.tencent.mobileqq.banner.d.f200264q;
        }
    }

    public ContactBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185205d = false;
            this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intent intent = new Intent(qBaseActivity, (Class<?>) GuideBindPhoneActivity.class);
        intent.putExtra("fromKeyForContactBind", 4);
        qBaseActivity.startActivity(intent);
        CommonMMKVUtils.fromSpAdapter(AppConstants.Preferences.CONTACT_BIND_INFO + qBaseActivity.getAppRuntime().getAccount()).edit().putBoolean(AppConstants.Preferences.KEY_SHOW_CONTACT_BANNER, false).apply();
        BannerManager.l().K(f185204f, 0);
        this.handler.removeMessages(1000);
        ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 13, 0, "", "", "", "");
        ReportController.o(qBaseActivity.getAppRuntime(), "CliOper", "", "", "0X80053D9", "0X80053D9", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        this.f185205d = true;
        if (this.f185206e != null && appRuntime != null) {
            ((IPhoneContactService) appRuntime.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.f185206e);
            this.f185206e = null;
        }
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return f185204f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1000) {
            j(true);
        } else if (i3 == 2000) {
            j(message.getData().getBoolean("rightNow"));
        }
        return true;
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
        return QUINoticeBarManager.l().h(baseActivity).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactBannerProcessor.this.k(baseActivity, view);
            }
        }).e(R.string.f171489fc3).setIcon(R.drawable.qui_address_list_icon_secondary).getView();
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        BannerManager l3 = BannerManager.l();
        int i3 = f185204f;
        if (l3.f(i3) != null) {
            BannerManager.l().K(i3, 0);
        }
        this.handler.removeMessages(1000);
        if (z16) {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) baseActivity.getAppRuntime().getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null) {
                int bannerState = iPhoneContactService.getBannerState();
                if (bannerState == 0) {
                    this.handler.sendEmptyMessageDelayed(1000, 1000L);
                    return;
                }
                if (this.f185206e == null && !this.f185205d) {
                    a aVar = new a();
                    this.f185206e = aVar;
                    iPhoneContactService.addListener(aVar);
                }
                boolean z17 = CommonMMKVUtils.fromSpAdapter(AppConstants.Preferences.CONTACT_BIND_INFO + baseActivity.getAppRuntime().getAccount()).getBoolean(AppConstants.Preferences.KEY_SHOW_CONTACT_BANNER, true);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + bannerState + ", isFirstShow = " + z17);
                }
                if (bannerState == 1 && z17) {
                    if (BannerManager.l().f(i3) != null && BannerManager.l().f(i3).f200242b != 2) {
                        ReportController.o(baseActivity.getAppRuntime(), "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
                    }
                    BannerManager.l().K(i3, 2);
                    ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 13, 0, "", "", "", "");
                    return;
                }
                BannerManager.l().K(i3, 0);
                return;
            }
            return;
        }
        this.handler.removeMessages(1000);
        this.handler.sendEmptyMessageDelayed(1000, 1000L);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            j(false);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onBeforeAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        BannerManager.l().K(f185204f, 0);
        this.handler.removeMessages(1000);
        if (this.f185206e != null && appRuntime != null) {
            ((IPhoneContactService) appRuntime.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.f185206e);
            this.f185206e = null;
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
