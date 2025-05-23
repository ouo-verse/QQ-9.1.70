package com.tencent.mobileqq.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ISecUtilApi extends QRouteApi {
    String getFileMd5(String str);
}
