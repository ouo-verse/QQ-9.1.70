package com.tencent.xweb.pinus;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebCoreWrapper;

/* loaded from: classes27.dex */
public class PSCoreWrapper extends XWebCoreWrapper {
    public static final String BRIDGE_PACKAGE = "com.tencent.xweb.pinus";
    private static final String TAG = "PSCoreWrapper";
    private static PSCoreWrapper sInstance;

    public PSCoreWrapper() {
        sInstance = this;
    }

    @Nullable
    public static PSCoreWrapper getInstance() {
        return sInstance;
    }

    public static void handleRuntimeError(Exception exc) {
        x0.c(TAG, "This API is incompatible with the XWeb Pinus runtime library");
        x0.c(TAG, "stack trace: " + Log.getStackTraceString(exc));
    }

    @Override // com.tencent.xweb.XWebCoreWrapper
    public String getBridgePackageName() {
        return BRIDGE_PACKAGE;
    }

    @Override // com.tencent.xweb.XWebCoreWrapper
    public ClassLoader getWebViewCoreClassLoader() {
        return PinusStandAloneChannel.getInstance().getClassLoader();
    }

    @Override // com.tencent.xweb.XWebCoreWrapper, com.tencent.luggage.wxa.tq.d
    public boolean hasFeature(int i3) {
        return PinusStandAloneChannel.getInstance().hasFeature(i3);
    }

    @Override // com.tencent.xweb.XWebCoreWrapper, com.tencent.luggage.wxa.tq.d
    public boolean invokeNativeChannel(int i3, Object[] objArr) {
        return PinusStandAloneChannel.getInstance().invokeNativeChannel(i3, objArr);
    }

    @Override // com.tencent.xweb.XWebCoreWrapper, com.tencent.luggage.wxa.tq.d
    public Object invokeRuntimeChannel(int i3, Object[] objArr) {
        return PinusStandAloneChannel.getInstance().invokeRuntimeChannel(i3, objArr);
    }
}
