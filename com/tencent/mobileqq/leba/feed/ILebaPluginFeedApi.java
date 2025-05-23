package com.tencent.mobileqq.leba.feed;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaPluginFeedApi extends QRouteApi {
    c getLebaPluginFeedController(Context context, AppRuntime appRuntime, QBaseActivity qBaseActivity);

    Set<Long> getLebaShowPluginPaths(AppRuntime appRuntime);

    boolean isNeedShowPluginInTab(AppRuntime appRuntime);

    boolean needShowRedDot(AppRuntime appRuntime, long j3, Set<Long> set);
}
