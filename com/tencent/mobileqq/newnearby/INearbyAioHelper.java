package com.tencent.mobileqq.newnearby;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyAioHelper extends QRouteApi {
    void notifyServerEnterSource(long j3, int i3);

    void openAioFromYQYL(long j3, int i3, String str, byte[] bArr);
}
