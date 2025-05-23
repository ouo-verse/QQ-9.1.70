package com.tencent.mobileqq.weiyun.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeiyunSaveTipsHelper extends QRouteApi {
    void showTopTips(AppInterface appInterface, Activity activity, int i3);

    void startWeiyunDisk(AppInterface appInterface, Activity activity, Context context);
}
