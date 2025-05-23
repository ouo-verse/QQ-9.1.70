package com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor;

import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.xweb.FileReaderX5;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UniqueRequestInterceptor implements IQWalletInterceptor {
    public final List<String> runningIdList = new ArrayList();

    public final String buildUniqueId(InterceptorData interceptorData) {
        return c.f117352a.g().getPageName() + '-' + interceptorData.service + '-' + interceptorData.method;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor.IQWalletInterceptor
    public final void onAfterSend(InterceptorData interceptorData) {
        if (interceptorData.isUniqueRequest) {
            this.runningIdList.remove(buildUniqueId(interceptorData));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor.IQWalletInterceptor
    public final Object onBeforeSend(InterceptorData interceptorData) {
        if (!interceptorData.isUniqueRequest) {
            return null;
        }
        String buildUniqueId = buildUniqueId(interceptorData);
        if (!this.runningIdList.contains(buildUniqueId)) {
            this.runningIdList.add(buildUniqueId);
            QWLog.INSTANCE.i("", "add unique request: " + buildUniqueId, false);
            return null;
        }
        QWLog.INSTANCE.i("", "ignored unique request: " + buildUniqueId, false);
        return new PbResponse(false, FileReaderX5.ERR_CODE_NOT_SUPPORT, "\u64cd\u4f5c\u8fc7\u4e8e\u9891\u7e41", null);
    }
}
