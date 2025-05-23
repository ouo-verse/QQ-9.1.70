package com.tencent.mobileqq;

import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface s {
    void a();

    void b();

    void c(AppRuntime appRuntime);

    void d(com.tencent.mobileqq.qqsettingme.a aVar);

    void f(QBaseActivity qBaseActivity, LifecycleOwner lifecycleOwner);

    void g(String str);

    void onClick(View view);

    void onConfigurationChanged();

    void onDestroy();

    void onPause();

    void onPostThemeChanged();

    void onResume();

    void onTouch(View view, MotionEvent motionEvent);

    void preload();

    void reset();
}
