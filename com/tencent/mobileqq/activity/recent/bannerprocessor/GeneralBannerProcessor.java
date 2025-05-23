package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.activity.recent.bannerprocessor.d;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class GeneralBannerProcessor extends BaseBannerProcessor implements com.tencent.mobileqq.banner.processor.b, com.tencent.mobileqq.banner.processor.d, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static final int f185218f;

    /* renamed from: d, reason: collision with root package name */
    public volatile d.c f185219d;

    /* renamed from: e, reason: collision with root package name */
    public volatile d.c f185220e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69205);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f185218f = com.tencent.mobileqq.banner.d.P;
        }
    }

    public GeneralBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.handler = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
        }
    }

    private void e(d.c cVar) {
        this.handler.removeMessages(1000);
        this.handler.sendMessageDelayed(this.handler.obtainMessage(1000, cVar), 900000L);
    }

    private void f(Message message) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "hideGeneralBanner: " + message);
        }
        Object obj = message.obj;
        if (!(obj instanceof d.c)) {
            return;
        }
        int i3 = ((d.c) obj).f185309a;
        if (!obj.equals(this.f185219d)) {
            return;
        }
        BannerManager.l().O(f185218f, 0, message);
    }

    private void g(d.c cVar) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "hideGeneralBannerInBInternal with: " + cVar);
        }
        Message obtainMessage = this.handler.obtainMessage(1000);
        obtainMessage.obj = cVar;
        this.handler.sendMessage(obtainMessage);
    }

    private void h(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "[notifyBannerIsOverride], type is " + i3 + " / " + i16);
        }
        if (i3 == f185218f && this.f185219d != null) {
            this.f185219d.f185313e.onOverride();
        }
    }

    private void i(int i3) {
        for (int i16 = BannerManager.f200206s; i16 < BannerManager.f200207t; i16++) {
            com.tencent.mobileqq.banner.a f16 = BannerManager.l().f(i16);
            if (f16 != null && f16.f200242b == 2) {
                if (i16 != i3) {
                    h(i16, i3);
                    f16.f200242b = 0;
                } else if (i16 == f185218f && this.f185219d != null && !this.f185220e.equals(this.f185219d)) {
                    h(i16, i3);
                }
            }
        }
    }

    private void j(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof d.c)) {
            return;
        }
        int i3 = ((d.c) obj).f185309a;
        this.f185220e = (d.c) obj;
        this.f185219d = this.f185220e;
        BannerManager.l().O(f185218f, 2, message);
        e((d.c) message.obj);
    }

    @Override // com.tencent.mobileqq.banner.processor.d
    public void b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (i3 >= BannerManager.f200206s && i3 < BannerManager.f200207t && i16 == 2) {
            i(i3);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
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
        return f185218f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1000 && i3 != 1134201) {
            if (i3 == 1134200) {
                j(message);
                return true;
            }
            return true;
        }
        f(message);
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
        return QUINoticeBarManager.l().h(baseActivity).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onBeforeAccountChanged(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "handleAccountChanged with: " + this.f185219d);
        }
        if (this.f185219d != null && this.f185219d.f185313e.isNeedAutoCloseWhenAccountChange()) {
            g(this.f185219d);
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
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    @SuppressLint({"ResourceType"})
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) != null && message != null) {
            d.c cVar = (d.c) message.obj;
            d16.setIcon(com.tencent.mobileqq.banner.b.b(cVar.f185311c)).setMsg(cVar.f185312d).c(new d.e(cVar, this.handler)).k(new d.ViewOnClickListenerC7199d(cVar, this.handler));
            ReportController.r(baseActivity.getAppRuntime(), "dc00898", "", "", BaseBannerProcessor.TVALUE_SHOW_READ, BaseBannerProcessor.TVALUE_SHOW_READ, 1, 0, "", "", "", "");
        }
    }
}
