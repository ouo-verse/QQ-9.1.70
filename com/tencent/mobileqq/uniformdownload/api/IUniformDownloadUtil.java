package com.tencent.mobileqq.uniformdownload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.uniformdownload.util.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IUniformDownloadUtil extends QRouteApi {
    String getApkName(String str);

    void getFileInfoOfUrlAsync(String str, a aVar);

    void installAPK(String str);

    int openApk(String str);
}
