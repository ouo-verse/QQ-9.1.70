package com.tencent.mobileqq.profilecard.base.utils;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.profilecard.api.IProfileEditApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileEditUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ProfileEditUtils";

    public ProfileEditUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean openNewProfileEdit(Activity activity, AllInOne allInOne) {
        return openNewProfileEdit(activity, allInOne, null);
    }

    public static boolean shouldOpenNewProfileEdit() {
        return ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).shouldOpenNewProfileEdit();
    }

    public static boolean openNewProfileEdit(Activity activity, AllInOne allInOne, Bundle bundle) {
        if (!shouldOpenNewProfileEdit()) {
            return false;
        }
        QLog.i(TAG, 1, "go to new profile edit page");
        ((IProfileEditApi) QRoute.api(IProfileEditApi.class)).openProfileEdit(activity, allInOne, false, bundle);
        return true;
    }
}
