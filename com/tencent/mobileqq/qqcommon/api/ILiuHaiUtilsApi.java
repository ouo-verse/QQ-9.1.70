package com.tencent.mobileqq.qqcommon.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ILiuHaiUtilsApi extends QRouteApi {
    int getNotchHeight();

    void initLiuHaiProperty(Activity activity);

    boolean isHasNotch();
}
