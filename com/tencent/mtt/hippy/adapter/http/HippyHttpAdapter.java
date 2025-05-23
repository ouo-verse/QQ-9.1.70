package com.tencent.mtt.hippy.adapter.http;

import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyHttpAdapter {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface HttpTaskCallback {
        void onTaskFailed(HippyHttpRequest hippyHttpRequest, Throwable th5);

        void onTaskSuccess(HippyHttpRequest hippyHttpRequest, HippyHttpResponse hippyHttpResponse) throws Exception;
    }

    void destroyIfNeed();

    void fetch(HippyMap hippyMap, Promise promise, Map map);

    void getCookie(String str, Promise promise);

    void sendRequest(HippyHttpRequest hippyHttpRequest, HttpTaskCallback httpTaskCallback);

    void setCookie(String str, String str2, String str3);
}
