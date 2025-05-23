package com.tencent.hippy.qq.adapter;

import android.util.Log;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQExceptionHandler implements HippyExceptionHandlerAdapter {
    @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
    public void handleJsException(HippyJsException hippyJsException) {
        Log.e("hippyerror", hippyJsException.getMessage() + hippyJsException.getStack());
    }

    @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
    public void handleBackgroundTracing(String str) {
    }

    @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
    public void handleNativeException(Exception exc, boolean z16) {
    }
}
