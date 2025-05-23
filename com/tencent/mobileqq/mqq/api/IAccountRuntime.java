package com.tencent.mobileqq.mqq.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IAccountRuntime extends QRouteApi {
    String getAccount();

    Context getApplicationContext();
}
