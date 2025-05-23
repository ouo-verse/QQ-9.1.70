package com.tencent.mobileqq.nearby.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IOldBigDataChannelManager extends QRouteApi {
    public static final String FILE_SUFFIX = "_circle_svc";

    String getCircleSrvUrl();

    byte[] getSrvKey();

    byte[] getSrvSig();

    void init(AppInterface appInterface);

    void onDestroy();

    void onResponseException();

    void saveSrvParam(byte[] bArr, byte[] bArr2, String[] strArr);
}
