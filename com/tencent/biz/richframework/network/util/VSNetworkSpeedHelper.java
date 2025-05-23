package com.tencent.biz.richframework.network.util;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.network.request.BaseRequest;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetworkSpeedHelper {
    private static final VSNetworkSpeedTest sNetworkSpeedTest = new VSNetworkSpeedTest();

    public static void collectNetWorkError(BaseRequest baseRequest) {
        sNetworkSpeedTest.collectNetWorkError(baseRequest.getCmdName());
    }

    public static void collectNetWorkSucceed(@NonNull BaseRequest baseRequest, long j3) {
        sNetworkSpeedTest.collectNetWorkSucceed(baseRequest.getCmdName(), j3);
    }

    public static VSNetworkSpeedTest getNetworkSpeedTest() {
        return sNetworkSpeedTest;
    }
}
