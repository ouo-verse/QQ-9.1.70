package com.tencent.mobileqq.qqcommon.api;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IImmersiveUtilsApi extends QRouteApi {
    int getStatusBarHeight(Context context);

    boolean setStatusBarDarkMode(Window window, boolean z16);

    boolean setStatusTextColor(boolean z16, Window window);
}
