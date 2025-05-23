package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleAppMemoryApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface CallbackBack {
        void onResult(Object obj);
    }

    void dumpJava(CallbackBack callbackBack);

    void dumpNative(CallbackBack callbackBack);

    String getMemoryInfoJson();
}
