package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.api.IFilePathUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class l {
    public static String a(String str) {
        return c().copyImageFileToMediaStorage(str);
    }

    public static boolean b(String str) {
        return c().fileExistsAndNotEmpty(str);
    }

    private static IFilePathUtil c() {
        return (IFilePathUtil) QRoute.api(IFilePathUtil.class);
    }

    public static String d(String str) {
        return c().getRealPath(str);
    }
}
