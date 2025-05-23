package com.tencent.hippy.qq.api.impl;

import android.os.Handler;
import com.tencent.hippy.qq.api.IHippyThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyThreadImpl implements IHippyThread {
    private static final String HIPPY_COMMON_THREAD_NAME = "hippy_common";
    private static volatile bd sQQTaskHandler;

    private bd getQQTaskHandler() {
        if (sQQTaskHandler == null) {
            synchronized (HippyThreadImpl.class) {
                if (sQQTaskHandler == null) {
                    sQQTaskHandler = ThreadManagerV2.newHandlerRecycleThread(HIPPY_COMMON_THREAD_NAME, 0);
                }
            }
        }
        return sQQTaskHandler;
    }

    @Override // com.tencent.hippy.qq.api.IHippyThread
    public bc createQQHandler() {
        return getQQTaskHandler().b();
    }

    @Override // com.tencent.hippy.qq.api.IHippyThread
    public bc createQQHandler(Handler.Callback callback) {
        return getQQTaskHandler().a(callback);
    }
}
