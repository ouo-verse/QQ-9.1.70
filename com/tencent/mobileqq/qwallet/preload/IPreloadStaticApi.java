package com.tencent.mobileqq.qwallet.preload;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPreloadStaticApi extends QRouteApi {
    void deleteRes(String str, boolean z16, int i3);

    String getConfigFromQQ(String str);

    String getFolderPathByMD5AndUrl(String str, String str2, int i3);

    IPreloadServiceAbs getInstance();

    String getRealMd5(String str, String str2, int i3);

    ResourceInfo getResInfoByUrl(String str, boolean z16, int i3);

    IPreloadService.PathResult getResPathSync(DownloadParam downloadParam);

    String getResourcePathByUrl(String str, int i3);

    String getUnzipFolderPath(String str);

    boolean isDiskEnoughToUnzip(String str);

    boolean isFileValid(ResourceInfo resourceInfo, DownloadParam downloadParam);

    boolean isFolderPathValid(String str);

    boolean unzipAtomically(String str, String str2);
}
