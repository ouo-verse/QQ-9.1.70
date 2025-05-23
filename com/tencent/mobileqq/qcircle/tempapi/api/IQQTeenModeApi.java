package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQTeenModeApi extends QRouteApi {
    void jumpToTeenModePage(Context context);
}
