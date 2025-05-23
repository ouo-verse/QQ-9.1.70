package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyImageUtil extends QRouteApi {
    String getImageLocalPath(String str);

    String getImageType(File file);

    String getUrlWithParams(String str);
}
