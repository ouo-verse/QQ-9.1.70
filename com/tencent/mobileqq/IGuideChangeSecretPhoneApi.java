package com.tencent.mobileqq;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {""})
/* loaded from: classes9.dex */
public interface IGuideChangeSecretPhoneApi extends QRouteApi {
    void sendReq(AppInterface appInterface);

    void showGuideDialog(AppRuntime appRuntime, Context context);
}
