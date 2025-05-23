package com.tencent.av.ui.notdisturb.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface IGaInviteFloatBarHelperApi extends QRouteApi {
    void showHalfScreen(long j3, Intent intent);
}
