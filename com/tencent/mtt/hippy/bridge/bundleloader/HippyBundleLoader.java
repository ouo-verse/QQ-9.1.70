package com.tencent.mtt.hippy.bridge.bundleloader;

import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.mtt.hippy.bridge.NativeCallback;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyBundleLoader {
    boolean canUseCodeCache();

    String getBundleUniKey();

    String getCodeCacheTag();

    String getPath();

    String getRawPath();

    void load(HippyBridge hippyBridge, NativeCallback nativeCallback);
}
