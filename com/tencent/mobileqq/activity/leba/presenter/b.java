package com.tencent.mobileqq.activity.leba.presenter;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.qzone.reborn.api.IQZoneFriendFeedxApi;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.QzoneFragmentImpl;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QBaseActivity f183348a;

    /* renamed from: b, reason: collision with root package name */
    private Fragment f183349b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d() {
        if (((IQZoneFriendFeedxApi) QRoute.api(IQZoneFriendFeedxApi.class)).shouldRefresh()) {
            e();
        }
    }

    private void e() {
        if (!(this.f183349b instanceof QzoneFragmentImpl)) {
            return;
        }
        QLog.d("QZoneRedPointPresenter", 1, "[forceRefreshFriendFeed] force refresh friend feed list...");
        ((QzoneFragmentImpl) this.f183349b).forceRefresh();
    }

    private void f(boolean z16) {
        QBaseActivity qBaseActivity = this.f183348a;
        if (!(qBaseActivity instanceof SplashActivity)) {
            QLog.d("QZoneRedPointPresenter", 1, "[notifyRedPointChange] activity not is base activity.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_selected_key", z16);
        AppRuntime appRuntime = ((SplashActivity) qBaseActivity).getAppRuntime();
        if (appRuntime == null) {
            QLog.d("QZoneRedPointPresenter", 1, "[notifyRedPointChange] runtime should not is null.");
            return;
        }
        try {
            appRuntime.notifyObservers(QZoneObserver.class, 1999, true, bundle);
        } catch (Exception e16) {
            QLog.d("QZoneRedPointPresenter", 1, "[notifyRedPointChange] exec fail: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.leba.presenter.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QLog.i("QZoneRedPointPresenter", 1, "[onSelectedQZoneTab] switch join of qzone...");
        f(true);
        d();
    }

    @Override // com.tencent.mobileqq.activity.leba.presenter.a
    public void b(QBaseActivity qBaseActivity, Fragment fragment, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qBaseActivity, fragment, view);
        } else {
            this.f183348a = qBaseActivity;
            this.f183349b = fragment;
        }
    }

    @Override // com.tencent.mobileqq.activity.leba.presenter.a
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("QZoneRedPointPresenter", 1, "[onUnSelectedQZoneTab] switch out of qzone...");
        f(false);
        ((IQZoneFriendFeedxApi) QRoute.api(IQZoneFriendFeedxApi.class)).saveLeaveTime(Long.valueOf(System.currentTimeMillis()));
    }
}
