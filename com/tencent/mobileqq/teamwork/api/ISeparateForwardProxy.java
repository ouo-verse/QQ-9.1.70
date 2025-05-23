package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISeparateForwardProxy extends QRouteApi {
    void createSeparateForward(Activity activity, int i3);

    void forward(Object obj);

    void onCreate();

    void onDestroy();

    void onFowardActivityResult(Intent intent);
}
