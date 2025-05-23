package com.tencent.av.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IUIToolsTempApi extends QRouteApi {
    float dp2px(Context context, float f16);

    int uinType2AVRelationType(int i3);
}
