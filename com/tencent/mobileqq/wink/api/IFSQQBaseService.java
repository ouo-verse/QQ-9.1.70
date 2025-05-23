package com.tencent.mobileqq.wink.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IFSQQBaseService extends QRouteApi {
    Intent handleFSPublishHybirdActivityIntent(Context context, String str, Intent intent, int i3);
}
