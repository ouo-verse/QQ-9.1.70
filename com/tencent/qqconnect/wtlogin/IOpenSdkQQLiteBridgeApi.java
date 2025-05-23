package com.tencent.qqconnect.wtlogin;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import hp3.f;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IOpenSdkQQLiteBridgeApi extends QRouteApi {
    Object fetchQQLiteStatus(f fVar);

    void startPhotoListEdit(Activity activity);
}
