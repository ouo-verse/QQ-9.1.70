package com.tencent.mobileqq.winkpublish.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.QzoneModuleRecord;

/* compiled from: P */
/* loaded from: classes35.dex */
public class h {
    public static boolean a(String str) {
        return ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).checkIfNeedUpdate(str);
    }

    public static String b(String str) {
        return ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleFilePath(str);
    }

    public static String c(String str) {
        QzoneModuleRecord moduleRecord = ((IQzoneModuleManageApi) QRoute.api(IQzoneModuleManageApi.class)).getModuleRecord(str);
        if (moduleRecord == null) {
            return null;
        }
        return moduleRecord.mNewVersion.mUrl;
    }
}
