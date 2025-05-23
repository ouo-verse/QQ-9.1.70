package com.tencent.mobileqq.jump.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IJumpApi extends QRouteApi {
    void doJumpAction(Context context, String str);

    String getJumpActionQCircle();

    Class getJumpActivityClass();
}
