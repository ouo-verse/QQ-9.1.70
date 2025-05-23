package com.tencent.mobileqq.ark.temp.api;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IDisplayConfig extends QRouteApi {
    float getDisplayDensity();

    DisplayMetrics getDisplayMetrics();
}
