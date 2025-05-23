package com.tencent.mobileqq.app.api;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IScreenShotService extends QRouteApi {
    void logForDev(String str);

    IScreenShot newInstance(Context context, Window window);
}
