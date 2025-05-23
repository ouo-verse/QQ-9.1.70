package com.tencent.mobileqq.mini.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameConfig extends QRouteApi {
    boolean getScreenRecordEnabled();

    boolean isMiniGamePackageExceptionSwitchEnable();
}
