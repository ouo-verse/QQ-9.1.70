package com.tencent.mobileqq.profilecard.base.framework;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IComponentLifecycle {
    void onActivityResult(int i3, int i16, Intent intent);

    boolean onBackPressed();

    void onCreate(QBaseActivity qBaseActivity, Bundle bundle);

    void onDestroy();

    void onNewIntent(Intent intent);

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void onWindowFocusChanged(boolean z16);
}
