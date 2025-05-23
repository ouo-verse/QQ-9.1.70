package com.tencent.qzonehub.api.utils.impl;

import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qzonehub.api.utils.IQZoneHttpDownloadUtil;
import cooperation.qzone.util.QZoneHttpDownloadUtil;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QZoneHttpDownloadUtilImpl implements IQZoneHttpDownloadUtil {
    @Override // com.tencent.qzonehub.api.utils.IQZoneHttpDownloadUtil
    public boolean download(AppRuntime appRuntime, String str, File file) {
        return HttpDownloadUtil.download(appRuntime, str, file);
    }

    @Override // com.tencent.qzonehub.api.utils.IQZoneHttpDownloadUtil
    public String getFilterUrl(String str) {
        return QZoneHttpDownloadUtil.getFilterUrl(str);
    }
}
