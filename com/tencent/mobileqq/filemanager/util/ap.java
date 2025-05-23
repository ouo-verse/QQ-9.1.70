package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.filemanager.api.IQfileTimeUtils;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ap {
    public static String a(long j3) {
        return b().formatNewRefreshTime(j3);
    }

    public static IQfileTimeUtils b() {
        return (IQfileTimeUtils) QRoute.api(IQfileTimeUtils.class);
    }

    public static String c(long j3) {
        return b().getHistoryGroupByTime(j3);
    }
}
