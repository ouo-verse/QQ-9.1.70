package com.tencent.mobileqq.qrscan.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.m;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQRJumpApi extends QRouteApi {
    public static final String ACTION_FINISH_SCAN_TORCH_ACTIVITY = "com.tencent.mobileqq.action_finish_scan_torch_activity";

    void displayQRCard(AppRuntime appRuntime, Activity activity, String str, int i3);

    Class<?> getDispatchScanResultActivityCls();

    Class<?> getScannerActivityCls();

    Class<?> getScannerJumpParser();

    int handleResult(AppRuntime appRuntime, Activity activity, m mVar, String str, Bundle bundle);

    void startQRJumpActivity(Context context, String str, String str2, boolean z16);
}
