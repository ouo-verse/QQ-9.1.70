package com.tencent.biz.pubaccount.api;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountDetailTopGestureLayoutProxy extends QRouteApi {

    /* loaded from: classes4.dex */
    public interface a {
    }

    void addDisableView(View view);

    TopGestureLayout.OnGestureListener getOnFlingGesture();

    TopGestureLayout getTopGestureLayout();

    void init(Context context);

    boolean isInTwoFingerMode();

    void setDefaultDetector(GestureDetector gestureDetector);

    GestureDetector.OnGestureListener setOnFlingListener(Context context, a aVar);

    void setTopGestureDetector(GestureDetector gestureDetector);
}
