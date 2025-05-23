package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileSandboxPathUtilApi extends QRouteApi {
    String getMobileQQFileSavePath();

    String getSandboxPath(String str);
}
