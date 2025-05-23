package com.tencent.mtt.hippy.adapter.monitor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.bridge.HippyCallNativeParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyEngineMonitorAdapter {
    public static final int ENGINE_LOAD_RESULE_TIMEOUT = 2;
    public static final int ENGINE_LOAD_RESULT_ERROR = 1;
    public static final int ENGINE_LOAD_RESULT_SUCCESS = 0;

    boolean needReportBridgeANR();

    void onCallNativeFinished(@NonNull String str, @NonNull HippyCallNativeParams hippyCallNativeParams);

    boolean onInterceptCallNative(@NonNull String str, @NonNull HippyCallNativeParams hippyCallNativeParams);

    boolean onInterceptPromiseCallback(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable Object obj);

    void reportBridgeANR(String str);

    void reportClickEvent(Object obj, boolean z16);

    void reportDoCallNatives(String str, String str2);

    void reportEngineLoadResult(int i3, int i16, List<HippyEngineMonitorEvent> list, Throwable th5);

    void reportEngineLoadStart();

    void reportGestureEventCallStack(String str, String str2);

    void reportModuleLoadComplete(HippyRootView hippyRootView, int i3, List<HippyEngineMonitorEvent> list);
}
