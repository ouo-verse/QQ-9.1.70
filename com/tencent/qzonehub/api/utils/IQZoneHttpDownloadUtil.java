package com.tencent.qzonehub.api.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneHttpDownloadUtil extends QRouteApi {
    boolean download(AppRuntime appRuntime, String str, File file);

    String getFilterUrl(String str);
}
