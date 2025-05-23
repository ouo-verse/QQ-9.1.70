package com.tencent.mobileqq.loginregister.sms;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface b {
    public static final IPatchRedirector $redirector_ = null;

    void a(QBaseActivity qBaseActivity, int i3, int i16, Intent intent);

    boolean b(QBaseActivity qBaseActivity, c cVar);

    boolean c(QBaseActivity qBaseActivity, c cVar, String str);

    void d(QBaseActivity qBaseActivity, long j3, com.tencent.mobileqq.loginregister.callback.a aVar);

    void e(QBaseActivity qBaseActivity);

    boolean f(QBaseActivity qBaseActivity, boolean z16, long j3);

    boolean g(QBaseActivity qBaseActivity, c cVar);

    void h(QBaseActivity qBaseActivity, c cVar);

    void onActivityDestroy();

    void onActivityResume();
}
