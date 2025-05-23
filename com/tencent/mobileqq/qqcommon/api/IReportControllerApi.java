package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IReportControllerApi extends QRouteApi {
    void reportClickEvent(String str, String str2, int i3);

    void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9);

    void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

    void reportClickEventRuntime(String str, String str2, int i3);

    void reportClickEventRuntime(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9);

    void reportClickEventRuntime(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);

    void reportDeviceInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13);

    void reportDeviceInfoRuntime(String str, String str2, String str3, String str4, int i3, String str5);

    void reportDeviceInfoRuntime(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13);

    void reportDeviceInfoWithPerformance(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12);

    void reportDeviceInfoWithPerformanceRuntime(String str, String str2, String str3, String str4, int i3, String str5);

    void reportPushNotification(boolean z16, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13);

    void reportWith898(String str);
}
