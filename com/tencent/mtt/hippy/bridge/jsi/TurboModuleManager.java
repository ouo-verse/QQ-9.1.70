package com.tencent.mtt.hippy.bridge.jsi;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.HippyModuleManagerImpl;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TurboModuleManager {
    public static final String TAG = "TurboModuleManager";

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, HippyNativeModuleBase> f337094a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final HippyEngineContext f337095b;

    public TurboModuleManager(HippyEngineContext hippyEngineContext) {
        this.f337095b = hippyEngineContext;
    }

    public HippyNativeModuleBase get(String str) {
        LogUtils.d(TAG, "get " + str);
        HippyNativeModuleBase hippyNativeModuleBase = this.f337094a.get(str);
        if (hippyNativeModuleBase != null) {
            return hippyNativeModuleBase;
        }
        HippyNativeModuleInfo hippyNativeModuleInfo = ((HippyModuleManagerImpl) this.f337095b.getModuleManager()).getNativeModuleInfo().get(str);
        if (hippyNativeModuleInfo == null) {
            return null;
        }
        try {
            hippyNativeModuleInfo.initialize();
            HippyNativeModuleBase hippyNativeModuleInfo2 = hippyNativeModuleInfo.getInstance();
            this.f337094a.put(str, hippyNativeModuleInfo2);
            return hippyNativeModuleInfo2;
        } catch (Throwable th5) {
            LogUtils.e(TAG, th5.getMessage());
            return null;
        }
    }

    public native int install(long j3);

    public native void uninstall(long j3);
}
