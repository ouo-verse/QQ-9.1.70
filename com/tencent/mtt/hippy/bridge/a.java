package com.tencent.mtt.hippy.bridge;

import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.common.Callback;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface a {
    void a();

    void a(int i3);

    void a(int i3, HippyBundleLoader hippyBundleLoader, HippyEngine.ModuleListener moduleListener, HippyRootView hippyRootView);

    void a(Callback<Boolean> callback);

    void a(Callback<Boolean> callback, boolean z16);

    void a(HippyJsException hippyJsException);

    void a(Object obj, HippyEngine.BridgeTransferType bridgeTransferType);

    void a(@NonNull String str);

    void a(String str, int i3, HippyMap hippyMap);

    void a(String str, String str2, Object obj, HippyEngine.BridgeTransferType bridgeTransferType);

    long b();

    void b(int i3);

    void c(int i3);
}
