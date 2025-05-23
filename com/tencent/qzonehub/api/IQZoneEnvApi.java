package com.tencent.qzonehub.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneEnvApi extends QRouteApi {
    void initImageEnv();

    boolean initImageEnv(Context context);

    boolean isInQZoneEnv();

    void onEnterQZoneEnv(boolean z16, boolean z17);

    void onLeaveQZoneEnv(boolean z16, boolean z17);
}
