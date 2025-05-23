package com.tencent.mobileqq.intervideo.now.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INowUtil extends QRouteApi {
    public static final String Now_PKG_NAME = "com.tencent.now";

    boolean checkNowApkExist(String str, String str2);

    boolean copyNowApkToCommonDir(String str, String str2, String str3);

    boolean delete(String str);

    String getCommonNowPath();

    boolean isExists(String str);

    boolean isH5Test();

    boolean renameTo(String str, String str2);
}
