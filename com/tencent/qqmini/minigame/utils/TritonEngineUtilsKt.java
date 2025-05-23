package com.tencent.qqmini.minigame.utils;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"valid", "", "Lcom/tencent/mobileqq/triton/TritonEngine;", "getValid", "(Lcom/tencent/mobileqq/triton/TritonEngine;)Z", "lib_minigame_internalRelease"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class TritonEngineUtilsKt {
    public static final boolean getValid(@Nullable TritonEngine tritonEngine) {
        if (tritonEngine != null && tritonEngine.getState() != EngineState.DESTROYED) {
            return true;
        }
        return false;
    }
}
