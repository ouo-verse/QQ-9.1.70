package com.tencent.qzonehub.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneGuideBubbleHelperProxy extends QRouteApi {
    void setX(View view, float f16);
}
