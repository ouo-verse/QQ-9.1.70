package com.tencent.av.camera.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICameraUtilsStaticApi extends QRouteApi {
    ICameraManagerApi getInstance(Context context);
}
