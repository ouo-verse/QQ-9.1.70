package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes19.dex */
public class OldEngineDPCProfile {
    static IPatchRedirector $redirector_;
    public static boolean hasGetDPC;
    private TimeoutParam timeoutParams;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38288);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            hasGetDPC = false;
        }
    }

    public OldEngineDPCProfile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.timeoutParams = new TimeoutParam();
        updateFromDPC(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.HttpTimeoutParam.name()));
        registerObserver();
    }

    private void registerObserver() {
        ((IDPCApi) QRoute.api(IDPCApi.class)).addObserver(new DPCObserver() { // from class: com.tencent.mobileqq.transfile.OldEngineDPCProfile.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OldEngineDPCProfile.this);
                }
            }

            @Override // com.tencent.mobileqq.dpc.DPCObserver
            public void onDpcPullFinished(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                } else if (z16) {
                    OldEngineDPCProfile.this.updateFromDPC(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.HttpTimeoutParam.name()));
                }
            }
        });
    }

    public TimeoutParam getTimeoutParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TimeoutParam) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.timeoutParams.m223clone();
    }

    public void updateFromDPC(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (str != null && !"".equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("RichMediaStrategy", 2, "OldEngine Timeout Params : " + str);
            }
            String[] split = str.split("\\|");
            if (split != null && split.length == 6) {
                try {
                    this.timeoutParams.connectTimeoutFor2G = Integer.valueOf(split[0]).intValue() * 1000;
                    this.timeoutParams.connectTimeoutFor3G = Integer.valueOf(split[1]).intValue() * 1000;
                    this.timeoutParams.connectTimeoutForWifi = Integer.valueOf(split[2]).intValue() * 1000;
                    this.timeoutParams.readTimeoutFor2G = Integer.valueOf(split[3]).intValue() * 1000;
                    this.timeoutParams.readTimeoutFor3G = Integer.valueOf(split[4]).intValue() * 1000;
                    this.timeoutParams.readTimeoutForWifi = Integer.valueOf(split[5]).intValue() * 1000;
                    hasGetDPC = true;
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
