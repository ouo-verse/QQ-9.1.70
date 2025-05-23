package com.tencent.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.RichMediaUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class n implements IUtilApi {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.util.IUtilApi
    public void dispatchReport(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
        } else {
            com.tencent.mobileqq.utils.g.a(appInterface, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        }
    }

    @Override // com.tencent.util.IUtilApi
    public String getFeatureValueAioConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
    }

    @Override // com.tencent.util.IUtilApi
    public boolean isActiveReporting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return RichMediaUtil.isActiveReporting();
    }

    @Override // com.tencent.util.IUtilApi
    public void reportHttpsSniMethod(int i3, String str, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Integer.valueOf(i16), str2);
        } else {
            HttpDownloader.reportHttpsSniMethod(i3, str, i16, str2);
        }
    }
}
