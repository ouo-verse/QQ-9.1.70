package com.tencent.mobileqq.app.lifecycle;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IFragmentLifecycleCallback {
    void onCreate(Fragment fragment, @Nullable Bundle bundle);

    void onDestroy(Fragment fragment);

    void onHiddenChanged(Fragment fragment, boolean z16);

    void onPause(Fragment fragment);

    void onResume(Fragment fragment);

    void onStart(Fragment fragment);

    void onStop(Fragment fragment);
}
