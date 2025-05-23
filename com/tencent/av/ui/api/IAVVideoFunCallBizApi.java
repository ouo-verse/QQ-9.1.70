package com.tencent.av.ui.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface IAVVideoFunCallBizApi extends QRouteApi {
    void addVipCallVideo(Activity activity);

    void onConnected();

    void onDestroy();

    void onPlayAnimate(int i3);
}
