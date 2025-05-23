package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AdSdkInit extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public AdSdkInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        SubscribeAdDeviceInfoHelper.e().f(2);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.AdSdkInit.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AdSdkInit.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestPublicAccountAd(1, "");
                    ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100435");
                }
            }
        }, 128, null, false, 1000L);
        return 7;
    }
}
