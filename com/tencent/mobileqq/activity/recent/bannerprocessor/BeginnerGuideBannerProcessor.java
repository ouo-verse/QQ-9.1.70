package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_8410;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class BeginnerGuideBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final int f185201d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69192);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f185201d = com.tencent.mobileqq.banner.d.V;
        }
    }

    public BeginnerGuideBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return f185201d;
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
        QLog.d("Q.recent.banner.BeginnerGuideBannerProcessor", 1, "initBanner banner = " + aVar);
        return new NewerGuideBannerView(baseActivity);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().K(f185201d, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onMessage(Message message, long j3, boolean z16) {
        Conversation conversation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, message, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && message.what == 3000) {
            BannerManager l3 = BannerManager.l();
            int i3 = f185201d;
            if (!l3.o(i3)) {
                return;
            }
            BannerManager.l().O(i3, 0, message);
            FrameHelperActivity ji5 = FrameHelperActivity.ji((BaseActivity) baseActivity);
            if (ji5 != null && (conversation = (Conversation) ji5.getFrame(Conversation.class)) != null) {
                conversation.refreshRecentList(0L);
            }
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (message != null && aVar != null) {
            View view = aVar.f200243c;
            if (view instanceof NewerGuideBannerView) {
                Object obj = message.obj;
                if (obj instanceof oidb_0x59f$Guidelines_8410) {
                    oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410 = (oidb_0x59f$Guidelines_8410) obj;
                    ((NewerGuideBannerView) view).p(oidb_0x59f_guidelines_8410);
                    QLog.d("Q.recent.banner.BeginnerGuideBannerProcessor", 1, "updateBanner  | bannerId = " + oidb_0x59f_guidelines_8410.uint32_banner_id.get() + " | bannerState" + oidb_0x59f_guidelines_8410.uint32_banner_status.get());
                }
            }
        }
    }
}
