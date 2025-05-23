package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITranslucentActivityProxy extends QRouteApi {
    SharedPreferences getSharedPreferences(String str, int i3);

    void startPlugin(Intent intent, Activity activity);
}
