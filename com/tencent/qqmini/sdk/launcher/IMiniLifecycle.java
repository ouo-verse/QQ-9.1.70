package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniLifecycle {
    void onAttachActivity(Activity activity, Bundle bundle, ViewGroup viewGroup);

    void onDetachActivity(Activity activity);

    void onIntentUpdate(Intent intent);

    void onMiniPause();

    void onMiniResume();

    void onMiniStart();

    void onMiniStop();
}
