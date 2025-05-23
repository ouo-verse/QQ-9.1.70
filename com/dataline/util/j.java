package com.dataline.util;

import com.tencent.mobileqq.config.IQCircleDynamicNameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j {
    public static boolean a() {
        try {
            return ((IQCircleDynamicNameApi) QRoute.api(IQCircleDynamicNameApi.class)).isDynamicIconExp();
        } catch (Throwable th5) {
            QLog.e("QCircleDynamicNameUtils", 2, "[isDynamicIconExp] ex: ", th5);
            return false;
        }
    }

    public static boolean b() {
        try {
            return ((IQCircleDynamicNameApi) QRoute.api(IQCircleDynamicNameApi.class)).isDynamicNewNameExp();
        } catch (Throwable th5) {
            QLog.e("QCircleDynamicNameUtils", 2, "[isDynamicNewNameExp] ex: ", th5);
            return false;
        }
    }

    public static String c() {
        try {
            return ((IQCircleDynamicNameApi) QRoute.api(IQCircleDynamicNameApi.class)).obtainExpDynamicIniUrl();
        } catch (Throwable th5) {
            QLog.e("QCircleDynamicNameUtils", 2, "[obtainExpDynamicIniUrl] ex: ", th5);
            return "";
        }
    }

    public static String d(String str) {
        try {
            return ((IQCircleDynamicNameApi) QRoute.api(IQCircleDynamicNameApi.class)).replaceToDynamicNameText(str);
        } catch (Throwable th5) {
            QLog.e("QCircleDynamicNameUtils", 2, "[replaceToDynamicNameText] ex: ", th5);
            return str;
        }
    }

    public static void e(boolean z16) {
        try {
            ((IQCircleDynamicNameApi) QRoute.api(IQCircleDynamicNameApi.class)).updateDynamicIconExp(z16);
        } catch (Throwable th5) {
            QLog.e("QCircleDynamicNameUtils", 2, "[updateDynamicIconExp] ex: ", th5);
        }
    }
}
