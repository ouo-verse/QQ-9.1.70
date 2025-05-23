package com.tencent.mobileqq.processor;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface b {
    void a();

    void b();

    void c(AppRuntime appRuntime);

    void d(com.tencent.mobileqq.qqsettingme.a aVar);

    void e();

    boolean f();

    void i(boolean z16);

    void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16);

    void k(AppRuntime appRuntime, QBaseActivity qBaseActivity, LifecycleOwner lifecycleOwner);

    void l(String str);

    void onClick(View view);

    void onConfigurationChanged();

    void onDestroy();

    void onPause();

    void onPostThemeChanged();

    void onResume();

    void preload();

    String w();
}
