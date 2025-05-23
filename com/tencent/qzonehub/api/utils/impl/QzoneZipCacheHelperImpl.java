package com.tencent.qzonehub.api.utils.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneZipCacheHelperImpl implements IQzoneZipCacheHelper {
    @Override // com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper
    public boolean checkAndDownLoadFileIfNeeded(AppInterface appInterface, String str, String str2, String str3, int i3, QzoneZipCacheHelperCallBack qzoneZipCacheHelperCallBack) {
        return QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(appInterface, str, str2, str3, i3, qzoneZipCacheHelperCallBack);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper
    public String getBasePath(String str, String str2) {
        return QzoneZipCacheHelper.getBasePath(str, str2);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper
    public String[] getFileList(String str) {
        return QzoneZipCacheHelper.getFileList(str);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper
    public String[] getFolderFileNameList(String str, String str2) {
        return QzoneZipCacheHelper.getFolderFileNameList(str, str2);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper
    public void unzipFile(String str, String str2) {
        QzoneZipCacheHelper.unzipFile(str, str2);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper
    public String[] getFolderFileNameList(String str, String str2, String str3) {
        return QzoneZipCacheHelper.getFolderFileNameList(str, str2, str3);
    }
}
