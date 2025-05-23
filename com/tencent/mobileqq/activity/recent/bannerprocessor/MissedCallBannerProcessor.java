package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class MissedCallBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185230d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f185230d = com.tencent.mobileqq.banner.d.f200253f;
        }
    }

    public MissedCallBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return f185230d;
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
            QLog.d("Q.recent.banner", 2, "initMissedCallBar");
        }
        return QUINoticeBarManager.l().h(baseActivity).setIcon(R.drawable.f161729er0).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
        } else if (message.what == 2000) {
            e();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "updateMissedCallBar state: " + aVar.f200242b);
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        com.tencent.mobileqq.qcall.f fVar = (com.tencent.mobileqq.qcall.f) baseActivity.getAppRuntime().getManager(QQManagerFactory.RECENT_CALL_FACADE);
        if (fVar != null) {
            i3 = fVar.v();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        if (aVar.f200242b == 0) {
            if (aVar.f200243c.getVisibility() == 0) {
                aVar.f200243c.setVisibility(8);
                return;
            }
            return;
        }
        com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.l().d(aVar.f200243c);
        if (d16 == null) {
            return;
        }
        d16.setMsg(String.format(baseActivity.getString(R.string.fb6), Integer.valueOf(i3)));
        if (i3 <= 0) {
            BannerManager.l().O(f185230d, 0, message);
        }
    }
}
