package com.tencent.mobileqq.minigame.va.intercept.interceptor;

import com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.InterceptRequest;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ClickIntervalInterceptor extends BaseInterceptor {
    private static final String TAG = "MiniGameVAClickIntervalInterceptor";
    private static final ConcurrentHashMap<String, Long> lastInterceptTsMap = new ConcurrentHashMap<>();

    private boolean isFastClick(String str, long j3) {
        Long l3;
        ConcurrentHashMap<String, Long> concurrentHashMap = lastInterceptTsMap;
        return concurrentHashMap.containsKey(str) && (l3 = concurrentHashMap.get(str)) != null && System.currentTimeMillis() - l3.longValue() <= j3;
    }

    @Override // com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor
    public void handleIntercept(InterceptRequest interceptRequest) {
        if (isFastClick(interceptRequest.appId, interceptRequest.getGlobalConfig().getFastClickMinInterval())) {
            QLog.i(TAG, 1, "interceptLaunch isFastClick");
            MiniGameVAUtil.showDebugToast("\u70b9\u51fb\u8fc7\u5feb");
            return;
        }
        lastInterceptTsMap.put(interceptRequest.appId, Long.valueOf(System.currentTimeMillis()));
        BaseInterceptor baseInterceptor = this.nextInterceptor;
        if (baseInterceptor != null) {
            baseInterceptor.handleIntercept(interceptRequest);
        }
    }
}
