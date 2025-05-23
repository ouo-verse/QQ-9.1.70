package com.tencent.mobileqq.qqlive.api.xsj;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQFSFeedRequest extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface RequestResultCallback {
        void fail(int i3, String str);

        void success(byte[] bArr);
    }

    void requestFeed(long j3, RequestResultCallback requestResultCallback);
}
