package com.tencent.mobileqq.config.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IAppSettingApi extends QRouteApi {
    String buildNum();

    boolean enableTalkBack();

    int getAppId();

    String getBranchName();

    String getPublishVersionString();

    String getReportVersionName();

    String getSubVersion();

    String getVersion();

    boolean isAllowLandscape();

    boolean isAllowLandscape(Context context);

    boolean isDebugVersion();

    boolean isGrayVersion();

    boolean isPublicVersion();

    boolean isSplitViewMode(Context context);

    boolean isUITest();
}
