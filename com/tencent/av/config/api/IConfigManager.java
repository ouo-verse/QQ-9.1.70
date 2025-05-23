package com.tencent.av.config.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IConfigManager extends QRouteApi {
    IConfigParser getConfigParser(Context context);

    void onCreate(Context context);

    void onDestroy(Context context);
}
