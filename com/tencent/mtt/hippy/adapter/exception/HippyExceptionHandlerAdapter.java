package com.tencent.mtt.hippy.adapter.exception;

import com.tencent.mtt.hippy.common.HippyJsException;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyExceptionHandlerAdapter {
    void handleBackgroundTracing(String str);

    void handleJsException(HippyJsException hippyJsException);

    void handleNativeException(Exception exc, boolean z16);
}
