package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.runtime.builtins.JSSharedArrayBuffer;
import com.tencent.mtt.hippy.runtime.builtins.wasm.WasmModule;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NativeAccess {
    NativeAccess() {
    }

    public static native JSSharedArrayBuffer getSharedArrayBufferFromId(int i3);

    public static native WasmModule getWasmModuleFromId(int i3);
}
