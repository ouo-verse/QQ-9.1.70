package com.tencent.mobileqq.mini.api;

import android.content.Context;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniPreloadProvider extends QRouteApi {
    void preloadView(Context context, RFWLayoutPreLoader rFWLayoutPreLoader);
}
