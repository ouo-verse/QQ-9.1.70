package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IPanoramaLoadingLayout extends QRouteApi {
    public static final int ANIMATION_TIME = 300;

    RelativeLayout getPanoramaLoadingLayout(Context context);

    boolean isPanoramaLoading();

    void onRecycled(RelativeLayout relativeLayout);

    void setPanoramaLoading(boolean z16);

    void showLoading(RelativeLayout relativeLayout, boolean z16, boolean z17);

    void startRotateAnimate(RelativeLayout relativeLayout);

    void stopRotateAnimate(RelativeLayout relativeLayout);
}
