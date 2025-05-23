package com.tencent.biz.richframework.network.delegate;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class VSBaseNetwork {
    public abstract String getAccountId();

    public abstract String getQUA();

    public boolean isValidLog(String str) {
        return true;
    }

    public boolean needReinitialize() {
        return false;
    }

    public abstract void onInit();

    public abstract void onRelease();

    public abstract void sendRequest(BaseRequest baseRequest, byte[] bArr, VSNetworkHelper.OnReceivedCall onReceivedCall);
}
