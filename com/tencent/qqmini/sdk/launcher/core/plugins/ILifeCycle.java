package com.tencent.qqmini.sdk.launcher.core.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ILifeCycle {
    void onCreate(IMiniAppContext iMiniAppContext);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();
}
