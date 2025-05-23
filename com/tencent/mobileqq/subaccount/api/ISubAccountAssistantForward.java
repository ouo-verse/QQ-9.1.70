package com.tencent.mobileqq.subaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISubAccountAssistantForward extends QRouteApi {
    void doSomethingAfterSwitchAccount(AppRuntime appRuntime, Context context);

    void doSomethingAfterSwitchAccountSuccess(AppInterface appInterface, Context context);

    void doSomethingBeforeAddAccount(AppInterface appInterface, Context context);

    void forwardTo(AppInterface appInterface, Context context, String str);
}
