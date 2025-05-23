package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyQQUpdate extends QRouteApi {
    void checkUpdate(String str, PackageUpdateListener packageUpdateListener);

    void loadOnlineBundle(String str, String str2, PackageUpdateListener packageUpdateListener);
}
