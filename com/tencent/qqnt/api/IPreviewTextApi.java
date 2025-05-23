package com.tencent.qqnt.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IPreviewTextApi extends QRouteApi {
    Intent createTextPreviewIntent(Context context);

    boolean isPreviewTextAct(Context context);
}
