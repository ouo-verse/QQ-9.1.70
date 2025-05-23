package com.tencent.mobileqq.logintempapi;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {""})
/* loaded from: classes15.dex */
public interface IPwdSetUtilApi extends QRouteApi {
    boolean checkHasNotSetPwd(Activity activity);
}
