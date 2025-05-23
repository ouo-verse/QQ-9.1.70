package com.tencent.open.api;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import zp3.d;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IOpenSdkCommonChannelJumpActionMgr extends QRouteApi {
    d buildHelper(QBaseActivity qBaseActivity, Intent intent);

    Class getParserClass();

    boolean handleCommonChannelJumpAction(QBaseActivity qBaseActivity, Intent intent);

    boolean isCommonChannelHandleSwitchOn();

    boolean isCommonChannelJumpAction(Object obj);
}
