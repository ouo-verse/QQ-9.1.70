package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleColdBootServiceV2 extends QRouteApi {
    public static final int TYPE_ALL_PUSH_RED_DOT = 10000;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void onPrepared();
    }

    void doPrepare(a aVar);

    byte[] getPreloadReqByte(int i3);

    IPreloadTask getTask(int i3);

    void parsePreloadRspByte(String str, byte[] bArr, int i3);

    void release();
}
