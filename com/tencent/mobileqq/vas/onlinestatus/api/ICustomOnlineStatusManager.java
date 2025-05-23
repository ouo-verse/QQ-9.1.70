package com.tencent.mobileqq.vas.onlinestatus.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes20.dex */
public interface ICustomOnlineStatusManager extends QRouteApi {
    public static final int REQUEST_CODE_DEVICES = 299;

    boolean featureEnable();

    String getOwnerOnlineStatus();

    void openH5(Activity activity, String str);

    void registerChangeWeakListener(Runnable runnable);

    void removeChangeWeakCallBack();
}
