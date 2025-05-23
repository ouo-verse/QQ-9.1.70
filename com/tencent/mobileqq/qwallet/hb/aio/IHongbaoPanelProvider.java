package com.tencent.mobileqq.qwallet.hb.aio;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import l61.e;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IHongbaoPanelProvider extends QRouteApi {
    e<View> init(Object obj, boolean z16);
}
