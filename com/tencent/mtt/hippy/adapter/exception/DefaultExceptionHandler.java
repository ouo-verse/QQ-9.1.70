package com.tencent.mtt.hippy.adapter.exception;

import com.tencent.mtt.hippy.common.HippyJsException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultExceptionHandler implements HippyExceptionHandlerAdapter {
    @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
    public void handleNativeException(Exception exc, boolean z16) {
        if (exc != null) {
            exc.printStackTrace();
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
    public void handleBackgroundTracing(String str) {
    }

    @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
    public void handleJsException(HippyJsException hippyJsException) {
    }
}
