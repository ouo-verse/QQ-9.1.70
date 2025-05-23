package com.tencent.open.agent.auth.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.api.ProcessConstant;

@QAPI(process = {ProcessConstant.OPEN_SDK})
/* loaded from: classes22.dex */
public interface IOpenAuthPageOperation extends QRouteApi {
    void onClickAuthBtn(Activity activity);

    void onClickCancelBtn(Activity activity);
}
