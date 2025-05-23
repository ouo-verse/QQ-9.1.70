package com.tencent.qzonehub.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneJumpPageApi extends QRouteApi {
    boolean isCallToProfileCard(Context context);

    boolean isNewQConciseFragment(Context context);

    void jumpToQQProfileCardIntent(long j3, int i3);
}
