package com.tencent.qqprotect.sfcfg.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ISafeCheckUtilApi extends QRouteApi {
    int getFileMD5(String str, String str2, byte[] bArr);
}
