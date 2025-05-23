package com.tencent.qzonehub.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IGifAntishakeApi extends QRouteApi {
    String getDhash(Bitmap bitmap);

    int getDistance(String str, String str2);
}
