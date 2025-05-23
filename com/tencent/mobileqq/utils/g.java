package com.tencent.mobileqq.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class g {
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static void a(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        if (appInterface instanceof QQAppInterface) {
            ReportController.o(appInterface, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        } else if (appInterface instanceof OlympicToolAppInterface) {
            ReportController.o(null, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        } else if (appInterface instanceof INearbyAppInterface) {
            ((INearbyAppInterface) appInterface).nearbyReportClickEvent(str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        }
    }
}
