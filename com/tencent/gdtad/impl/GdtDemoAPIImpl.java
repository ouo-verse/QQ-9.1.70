package com.tencent.gdtad.impl;

import android.app.Activity;
import com.tencent.gdtad.IGdtDemoAPI;
import com.tencent.gdtad.api.hippy.GdtHippyDemoFragment;
import com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment;

/* loaded from: classes6.dex */
public final class GdtDemoAPIImpl implements IGdtDemoAPI {
    @Override // com.tencent.gdtad.IGdtDemoAPI
    public void startHippyDemoFragment(Activity activity) {
        GdtHippyDemoFragment.start(activity, GdtHippyDemoFragment.class);
    }

    @Override // com.tencent.gdtad.IGdtDemoAPI
    public void startMotiveVideoDemoFragment(Activity activity) {
        GdtDemoMvFragment.start(activity, GdtDemoMvFragment.class);
    }
}
