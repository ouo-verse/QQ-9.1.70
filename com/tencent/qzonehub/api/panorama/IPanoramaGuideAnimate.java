package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IPanoramaGuideAnimate extends QRouteApi {
    void addView(LinearLayout linearLayout, int i3);

    LinearLayout getPanoramaGuideAnimate(Context context);

    void setOnAnimateListener(LinearLayout linearLayout, OnAnimateListener onAnimateListener);
}
