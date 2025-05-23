package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMagazinePlayerViewCreater extends QRouteApi {
    d create(Context context, com.tencent.mobileqq.nearby.now.a aVar, AppInterface appInterface);
}
