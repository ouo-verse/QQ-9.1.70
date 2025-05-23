package com.tencent.hippy.qq.app;

import com.tencent.mtt.hippy.HippyEngineContext;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface OnMainBundleLoadListener {
    void onDestroy(String str, HippyQQEngine hippyQQEngine);

    void onMainBundleLoadResult(int i3, String str, HippyEngineContext hippyEngineContext, int i16);

    void onStart();
}
