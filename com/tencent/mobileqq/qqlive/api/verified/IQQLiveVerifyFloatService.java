package com.tencent.mobileqq.qqlive.api.verified;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveVerifyFloatService extends QRouteApi {
    boolean checkFloatingBallPermission(Activity activity);

    void hideFloatingBall(Context context);

    void showFloatingBall(Activity activity);
}
