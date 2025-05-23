package com.tencent.mm.appbrand.commonjni;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes9.dex */
public class AppBrandCommonBindingJniParams {
    public static final int DEFAULT_WASM_OPT_STATE = -2;

    @Keep
    public String wasmCachePath;

    @Keep
    public int wasmOptState;

    @Keep
    public float gcFactor = 0.1f;

    @Keep
    public boolean enableInspector = false;

    @Keep
    public boolean useNativeJSRuntime = false;

    @Keep
    public boolean enableBindingJsContextInterface = false;
}
