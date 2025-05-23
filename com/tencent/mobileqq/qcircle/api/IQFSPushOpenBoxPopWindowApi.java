package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.global.QFSPushOpenBoxInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQFSPushOpenBoxPopWindowApi extends QRouteApi {
    void showPushOpenBoxWindow(Context context, QFSPushOpenBoxInfo qFSPushOpenBoxInfo, View.OnClickListener onClickListener, View view);
}
