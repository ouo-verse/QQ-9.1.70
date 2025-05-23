package com.tencent.qzonehub.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneJumpUrlApi extends QRouteApi {
    void handleUrl(Context context, String str);
}
