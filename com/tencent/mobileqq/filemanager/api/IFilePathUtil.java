package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFilePathUtil extends QRouteApi {
    String copyImageFileToMediaStorage(String str);

    boolean fileExistsAndNotEmpty(String str);

    String getRealPath(String str);

    String renameImageFileToMediaStorage(String str);
}
