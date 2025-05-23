package com.tencent.qqmini.sdk.launcher.core;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IRuntime {
    boolean onBackPress();

    void onLoadMiniAppInfo(MiniAppInfo miniAppInfo, boolean z16, String str);

    void onRuntimeAttachActivity(Activity activity, ViewGroup viewGroup);

    void onRuntimeDestroy();

    void onRuntimeDetachActivity(Activity activity);

    void onRuntimePause();

    void onRuntimeResume();

    void onRuntimeStart();

    void onRuntimeStop();
}
