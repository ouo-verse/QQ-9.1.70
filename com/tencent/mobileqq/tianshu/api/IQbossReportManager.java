package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IQbossReportManager extends QRouteApi {
    void reportClick(String str, String str2);

    void reportClose(String str, String str2);

    void reportExpose(String str, String str2);

    void reportIntercept(String str, String str2);

    void reportSlide(String str, String str2, int i3);

    void reportUrlClick(String str, String str2);

    void sendErrorReport(int i3, int i16, int i17, String str);

    void sendReport(String str, String str2, int i3);
}
