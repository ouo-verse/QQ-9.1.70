package com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class FilamentSceneMessageChannelModule extends Module {
    public final Map<String, Function1<Object, Object>> eventHandlerMap = new LinkedHashMap();
    public boolean hasRegisterNativeMessageHandler;

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "FilamentSceneMessageChannelModule";
    }

    public final void registerMessageHandler(String str, Function1<Object, ? extends Object> function1) {
        if (str.length() == 0) {
            KLog.INSTANCE.e("FilamentSceneMessageChannelModule", "eventName is empty");
            return;
        }
        if (!this.hasRegisterNativeMessageHandler) {
            syncToNativeMethod(true, "setOnMessageHandler", new Object[0], new FilamentSceneMessageChannelModule$registerNativeMessageHandler$1(this));
            this.hasRegisterNativeMessageHandler = true;
        }
        this.eventHandlerMap.put(str, function1);
    }

    public final void postMessage(String str, byte[] bArr, Function1<Object, Unit> function1) {
        asyncToNativeMethod("postMessageToFilamentScene", new Object[]{str, bArr}, function1);
    }
}
