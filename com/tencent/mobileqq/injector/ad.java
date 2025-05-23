package com.tencent.mobileqq.injector;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqui.tempapi.IQQUITempApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ad implements com.tencent.mobileqq.inject.s {
    static IPatchRedirector $redirector_;

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.inject.s
    public void initUrlDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((IQQUITempApi) QRoute.api(IQQUITempApi.class)).initUrlDrawable();
        }
    }

    @Override // com.tencent.mobileqq.inject.s
    public void requestRecordAudioPermission(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, str, str2);
        } else {
            ((IQQUITempApi) QRoute.api(IQQUITempApi.class)).requestRecordAudioPermission(activity, str, str2);
        }
    }
}
