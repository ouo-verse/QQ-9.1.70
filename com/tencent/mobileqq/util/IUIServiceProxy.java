package com.tencent.mobileqq.util;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IUIServiceProxy extends QRouteApi {
    DisplayMetrics getSystemDisplayMetric();

    boolean isLargeFont();

    boolean useQUIToken();
}
