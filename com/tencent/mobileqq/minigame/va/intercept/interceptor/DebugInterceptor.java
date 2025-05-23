package com.tencent.mobileqq.minigame.va.intercept.interceptor;

import com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.InterceptRequest;
import com.tencent.mobileqq.minigame.va.util.CommonUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DebugInterceptor extends BaseInterceptor {
    private static final String TAG = "MiniGameVADebugInterceptor";

    @Override // com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor
    public void handleIntercept(InterceptRequest interceptRequest) {
        if (!AppSetting.isPublicVersion() && CommonUtil.isLocalInterceptDisable()) {
            QLog.i(TAG, 1, "interceptLaunch local intercept is true, appId:" + interceptRequest.appId);
            interceptRequest.getCallback().onInterceptResult(false, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "debug switch no need Intercept");
        }
        BaseInterceptor baseInterceptor = this.nextInterceptor;
        if (baseInterceptor != null) {
            baseInterceptor.handleIntercept(interceptRequest);
        }
    }
}
