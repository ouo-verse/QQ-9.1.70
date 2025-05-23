package com.tencent.qzonehub.api.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneZipCacheHelper extends QRouteApi {
    boolean checkAndDownLoadFileIfNeeded(AppInterface appInterface, String str, String str2, String str3, int i3, QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack);

    String getBasePath(String str, String str2);

    String[] getFileList(String str);

    String[] getFolderFileNameList(String str, String str2);

    String[] getFolderFileNameList(String str, String str2, String str3);

    void unzipFile(String str, String str2);
}
