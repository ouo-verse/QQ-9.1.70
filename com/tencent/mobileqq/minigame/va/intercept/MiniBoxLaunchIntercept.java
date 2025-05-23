package com.tencent.mobileqq.minigame.va.intercept;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniBoxLaunchIntercept {
    private static final String TAG = "MiniGameVAMiniBoxLaunchIntercept";
    private IInterceptorChainBuilder interceptorChainBuilder;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface IInterceptorChainBuilder {
        BaseInterceptor buildInterceptorChain();
    }

    public MiniBoxLaunchIntercept(IInterceptorChainBuilder iInterceptorChainBuilder) {
        this.interceptorChainBuilder = iInterceptorChainBuilder;
    }

    public void launch(InterceptRequest interceptRequest) {
        BaseInterceptor buildInterceptorChain;
        IInterceptorChainBuilder iInterceptorChainBuilder = this.interceptorChainBuilder;
        if (iInterceptorChainBuilder == null || (buildInterceptorChain = iInterceptorChainBuilder.buildInterceptorChain()) == null) {
            return;
        }
        QLog.i(TAG, 1, "launchIntercept start");
        buildInterceptorChain.handleIntercept(interceptRequest);
    }
}
