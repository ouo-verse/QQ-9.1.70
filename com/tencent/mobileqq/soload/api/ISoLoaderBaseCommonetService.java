package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISoLoaderBaseCommonetService extends QRouteApi {
    void addReportItem(long j3, String str, String str2, String str3, int i3, String str4);

    void endReport(long j3, String str, String str2, int i3, String str3);

    int getFileExistStatusInMainProcess(String str);

    String getResFolderPathSync(String str, String str2);

    void getResPathAsync(String str, String str2, String str3, boolean z16, OnSoGetPathListener onSoGetPathListener);

    String getResPathSync(String str, String str2, String str3);

    boolean getResPathSyncWithUnZip(String str, String str2, String str3, boolean z16, long j3, long j16, String str4, int i3);

    void singleReport(String str, String str2, String str3, String str4, String str5, int i3, String str6);

    long startReport(String str, String str2, String str3, String str4, String str5, int i3, String str6);
}
