package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.login.bq;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class SetPwdBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final int f185270e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f185271d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f185270e = com.tencent.mobileqq.banner.d.f200265r;
        }
    }

    public SetPwdBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f185271d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f185271d) {
            this.f185271d = false;
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetPwdBannerProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        SetPwdBannerProcessor.this.f185271d = true;
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 1000L);
            QQAppInterface qQAppInterface = (QQAppInterface) qBaseActivity.getAppRuntime();
            bq.b(qQAppInterface.getCurrentAccountUin(), qBaseActivity, qQAppInterface);
            bq.e(qQAppInterface);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetPwdBannerProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        BannerManager.l().O(SetPwdBannerProcessor.f185270e, 0, null);
                    }
                }
            }, 1000L);
            ReportController.r(qBaseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_CLICK_COMMON, BaseBannerProcessor.TVALUE_CLICK_COMMON, 18, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void i() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetPwdBannerProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QBaseActivity baseActivity = SetPwdBannerProcessor.this.getBaseActivity();
                    if (baseActivity == null) {
                        return;
                    }
                    boolean o16 = BannerManager.l().o(SetPwdBannerProcessor.f185270e);
                    boolean d16 = bq.d((QQAppInterface) baseActivity.getAppRuntime());
                    boolean z17 = true;
                    if (d16 && !o16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (d16 || !o16) {
                        z17 = false;
                    }
                    ThreadManager.getUIHandler().post(new Runnable(z16, z17) { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f185272d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ boolean f185273e;

                        {
                            this.f185272d = z16;
                            this.f185273e = z17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass3.this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (this.f185272d) {
                                BannerManager.l().O(SetPwdBannerProcessor.f185270e, 2, null);
                            } else if (this.f185273e) {
                                BannerManager.l().O(SetPwdBannerProcessor.f185270e, 0, null);
                            }
                        }
                    });
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return f185270e;
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
        ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_COMMON, BaseBannerProcessor.TVALUE_SHOW_COMMON, 18, 0, "", "", "", "");
        return QUINoticeBarManager.l().h(baseActivity).e(R.string.hg5).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetPwdBannerProcessor.this.h(baseActivity, view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            i();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
        } else if (message.what == 3000) {
            i();
        }
    }
}
