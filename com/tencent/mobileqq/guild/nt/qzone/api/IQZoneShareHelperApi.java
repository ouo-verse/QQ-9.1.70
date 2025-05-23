package com.tencent.mobileqq.guild.nt.qzone.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import hv1.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IQZoneShareHelperApi extends QRouteApi {
    void forwardToZone(Activity activity, a aVar);
}
