package com.tencent.mobileqq.activity.richmedia;

import com.tencent.av.camera.QavCameraUsage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    public static boolean a() {
        return QavCameraUsage.a(BaseApplication.getContext());
    }

    public static void b(String str, String str2) {
        c(str, str2, "");
    }

    public static void c(String str, String str2, String str3) {
        d(str, str2, str3, "", "", "");
    }

    public static void d(String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(null, "dc00898", str, "", str2, str2, 0, 0, str3, str4, str5, str6);
    }
}
