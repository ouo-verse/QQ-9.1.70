package com.tencent.mobileqq.activity.selectmember.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IForwardApi extends QRouteApi {
    void startGameSdkCallback(Activity activity, boolean z16, String str, long j3, int i3, String str2);
}
