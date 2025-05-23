package com.tencent.mobileqq.textpreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.m;
import com.tencent.mobileqq.vas.f;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qqnt.textpreview.inject.e;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c implements e {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        ECommerceDataReportUtil.h(MobileQQ.sMobileQQ.peekAppRuntime(), null, 1);
    }

    @Override // com.tencent.qqnt.textpreview.inject.e
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        if (!(activity instanceof QBaseActivity) || intent == null) {
            return;
        }
        ForwardUtils.V((QQAppInterface) ((QBaseActivity) activity).getAppRuntime(), intent, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        IWebProcessManagerService iWebProcessManagerService;
        if (!(activity instanceof QBaseActivity) || (iWebProcessManagerService = (IWebProcessManagerService) ((QBaseActivity) activity).getAppRuntime().getRuntimeService(IWebProcessManagerService.class, "")) == null) {
            return;
        }
        iWebProcessManagerService.startWebProcess(24, null);
    }

    @Override // com.tencent.qqnt.textpreview.inject.e
    public CharSequence c(String str, String str2, int i3, long j3, int i16) {
        CharSequence v3 = f.v(str, str2, 30, m.a(j3, i16), i3);
        l.G(v3);
        return v3;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
