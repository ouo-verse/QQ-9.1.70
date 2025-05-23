package com.tencent.mobileqq.tianshu.api;

import NS_USER_ACTION_REPORT.ItemInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IMobileReportManager extends QRouteApi {
    String getNewDefaultReportInfo(String str, String str2);

    String getNewDefaultReportInfo(String str, String str2, String str3);

    String getNewReportInfo(BusinessInfoCheckUpdate.AppInfo appInfo);

    String getNewReportInfo(String str, BusinessInfoCheckUpdate.AppInfo appInfo);

    String getNewTraceDetail(String str, String str2, String str3, String str4);

    @NonNull
    String getStringQboos2H5(@Nullable String str, @Nullable String str2, @NonNull String str3);

    @Nullable
    String getStringReport2H5(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo);

    String getStringWithQbossTrace(String str, String str2);

    String getStringWithRedAppinfo(String str, BusinessInfoCheckUpdate.AppInfo appInfo);

    void qqSetingMeReport(int i3, int i16, String str);

    void reportAction(String str, String str2, String str3, int i3, int i16, long j3);

    void reportAction(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3);

    void reportAction(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16);

    void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, int i17, String str8, String str9, String str10);

    void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, int i17, String str8, String str9, String str10, String str11);

    void reportActionLive(String str, String str2, ItemInfo itemInfo);

    void reportActionLive(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3, String str6);

    void reportActionOfNotice(String str, String str2, String str3, int i3, String str4, String str5, int i16);

    void reportH5DomainClick(String str, String str2);

    void reportH5Trace(String str, int i3, long j3, String str2, int i16, String str3);

    void reportRedpoint(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo, int i3);

    void reportSchemaInfo(String str, String str2);
}
