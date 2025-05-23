package com.tencent.mobileqq.minigame.api.report;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameReport extends QRouteApi {
    void accountUpdateReport(AppRuntime appRuntime);

    void clickReportMiniGameFromLeba(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo);

    void exposeReportForHome();

    void exposeReportMiniGameFromLeba(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo);

    void reportStartup(String str, Map<String, String> map);

    void reportToBeacon(String str, Map<String, String> map);
}
