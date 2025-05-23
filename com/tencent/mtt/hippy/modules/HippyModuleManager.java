package com.tencent.mtt.hippy.modules;

import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.bridge.HippyCallNativeParams;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyModuleManager {
    void addModules(List<HippyAPIProvider> list);

    <T extends HippyNativeModuleBase> void addNativeModule(Class<T> cls, Provider<T> provider);

    void callNatives(HippyCallNativeParams hippyCallNativeParams);

    void destroy();

    <T extends HippyJavaScriptModule> T getJavaScriptModule(Class<T> cls);

    HippyNativeModuleInfo getModuleInfo(@NonNull String str);

    <T extends HippyNativeModuleBase> T getNativeModule(Class<T> cls);
}
