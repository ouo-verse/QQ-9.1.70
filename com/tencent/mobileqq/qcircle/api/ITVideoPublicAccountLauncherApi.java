package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface ITVideoPublicAccountLauncherApi extends QRouteApi {
    void launchTVideoPublicAccountDetailPage(Context context);

    void launchTVideoPublicAccountPage(BaseQQAppInterface baseQQAppInterface, Context context, String str);
}
