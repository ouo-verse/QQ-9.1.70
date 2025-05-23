package com.tencent.mobileqq.qqlive.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLivePortalServer extends QRouteApi {
    public static final int JUMP_FROM_QQ_LIVE_MORE_LIVE = 22;

    void goToPortal(Activity activity, int i3, int i16);
}
