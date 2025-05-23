package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import mqq.app.AppRuntime;
import sw4.d;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasQuickUpdateAdapter extends QRouteApi {
    void downloadItem(AppRuntime appRuntime, long j3, String str, String str2, CallBacker callBacker);

    String getFileMd5(String str);

    d getHttpDownloader();

    String getUpdateReportAppid();

    void onMusicThemeCleanCache();

    void onThemeComplete(String str, String str2, String str3, int i3, int i16);

    void onThemeProgress(String str, long j3, long j16);

    boolean patch(String str, String str2, String str3);
}
