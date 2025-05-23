package com.tencent.mobileqq.activity.recent.guidebanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewerGuideWebLaunchSuccessReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<NewerGuideBannerViewModel> f185590a;

    public NewerGuideWebLaunchSuccessReceiver(NewerGuideBannerViewModel newerGuideBannerViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) newerGuideBannerViewModel);
        } else {
            this.f185590a = new WeakReference<>(newerGuideBannerViewModel);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NewerGuideBannerViewModel newerGuideBannerViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewerGuideWebLaunchSuccessReceiver", 2, "onReceive");
        }
        if (intent != null && TextUtils.equals(intent.getAction(), "ACTION_NEWER_GUIDE_WEB_LAUNCH_SUCCESS") && (newerGuideBannerViewModel = this.f185590a.get()) != null) {
            ((INewerGuideHelper) QRoute.api(INewerGuideHelper.class)).notifyClickCloseBanner(newerGuideBannerViewModel);
            newerGuideBannerViewModel.n2();
        }
    }
}
