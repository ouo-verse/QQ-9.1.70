package com.tencent.mobileqq.activity.qqsettingme.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes10.dex */
public interface IThemeUtilApi extends QRouteApi {
    Bundle getCurrentThemeInfo();

    boolean isDartStatusBar(Context context, int i3);

    boolean isGoldenTheme();

    boolean isInNightMode(AppRuntime appRuntime);

    boolean isNowThemeIsDefault(AppRuntime appRuntime, boolean z16, String str);

    boolean isNowThemeIsNight(AppRuntime appRuntime, boolean z16, String str);
}
