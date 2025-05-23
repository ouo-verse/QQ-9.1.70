package com.tencent.mobileqq.loginregister;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IAccountBindingApi extends QRouteApi {
    void bindWechatIfNeed(QBaseActivity qBaseActivity, boolean z16);

    void startAccountBindFragment(Context context, Intent intent);
}
