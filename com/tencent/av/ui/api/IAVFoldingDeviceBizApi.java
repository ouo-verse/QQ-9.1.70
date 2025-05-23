package com.tencent.av.ui.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface IAVFoldingDeviceBizApi extends QRouteApi {
    void changeDoubleFoldingRotation(int i3);

    void enableOrientation();

    int getPanelRotation();

    void handleVideoCountChangeLayout(boolean z16, boolean z17);

    void hideNavBarForOppoFindN();

    void init(Context context, boolean z16);

    boolean isInFoldingMode();

    boolean isInOpenState();

    void onCreateUI();

    void onDestroy();

    void onResume(boolean z16);

    void onStop();
}
