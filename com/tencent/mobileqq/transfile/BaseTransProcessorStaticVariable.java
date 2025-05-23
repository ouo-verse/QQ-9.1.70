package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class BaseTransProcessorStaticVariable {
    static IPatchRedirector $redirector_;
    protected static OldEngineDPCProfile TIMEOUT_PROFILE;
    public static WeakNetLearner WEAK_NET_LEARNER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35606);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TIMEOUT_PROFILE = new OldEngineDPCProfile();
            WEAK_NET_LEARNER = new WeakNetLearner(BaseApplication.getContext(), new WeakNetCallback() { // from class: com.tencent.mobileqq.transfile.BaseTransProcessorStaticVariable.1
                static IPatchRedirector $redirector_;
                private StatisticCollector reportor;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    } else {
                        this.reportor = StatisticCollector.getInstance(BaseApplication.getContext());
                    }
                }

                @Override // com.tencent.mobileqq.highway.netprobe.WeakNetCallback
                public void onResultOverflow(HashMap<String, String> hashMap) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) hashMap);
                    } else {
                        this.reportor.collectPerformance(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), WeakNetLearner.REPORT_TAG_NAME, true, 0L, hashMap.size(), hashMap, "");
                    }
                }
            });
        }
    }

    public BaseTransProcessorStaticVariable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
