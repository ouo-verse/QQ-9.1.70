package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class GameCenterBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185217d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69203);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f185217d = com.tencent.mobileqq.banner.d.I;
        }
    }

    public GameCenterBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("Q.recent.banner", 1, "checkBannerFromResume, app runtime is null");
            return;
        }
        IQQGameNoticeService iQQGameNoticeService = (IQQGameNoticeService) peekAppRuntime.getRuntimeService(IQQGameNoticeService.class, "");
        if (iQQGameNoticeService != null) {
            iQQGameNoticeService.checkBannerFromResume();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        } else {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return f185217d;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 3000) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent.banner", 2, "onDelayRefreshGameNotice");
            }
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("game_banner_check_subthread", true)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.recent.bannerprocessor.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameCenterBannerProcessor.f();
                    }
                }, 16, null, false);
            } else {
                f();
            }
        }
        return true;
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
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "initGameNoticeBar");
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.c47).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        BannerManager.l().K(f185217d, 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("Q.recent.banner", 1, "onAccountChanged, app runtime is null");
        } else {
            ((IGamePubAccountMsgService) peekAppRuntime.getRuntimeService(IGamePubAccountMsgService.class, "")).onAccountChange();
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
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "onDelayRefreshGameNotice");
        }
        this.handler.sendEmptyMessageDelayed(3000, 2000L);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IQQGameNoticeService iQQGameNoticeService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iQQGameNoticeService = (IQQGameNoticeService) peekAppRuntime.getRuntimeService(IQQGameNoticeService.class, "")) != null) {
            iQQGameNoticeService.updateGameCenterBar(aVar.f200243c, message);
        }
    }
}
