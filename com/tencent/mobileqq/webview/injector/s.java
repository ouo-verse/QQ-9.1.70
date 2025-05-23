package com.tencent.mobileqq.webview.injector;

import android.app.Activity;
import android.graphics.Color;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.webviewplugin.aa;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.injector.x;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
public class s implements x {
    @Override // com.tencent.mobileqq.webview.swift.injector.x
    public int a(String str) {
        try {
            return Color.parseColor(QUIUtil.getCurrentTokenMap().get(str));
        } catch (Throwable th5) {
            QLog.w("IWebUI", 1, "getTokenColor: " + str + " ex:" + th5.getMessage(), th5);
            return -16777216;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.x
    public com.tencent.mobileqq.webviewplugin.n b(AppRuntime appRuntime, Activity activity) {
        if (((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).isGameQAUrl(activity)) {
            return new aa(appRuntime, activity);
        }
        return new Share(appRuntime, activity);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.x
    public void c(b.C8976b c8976b, long j3, com.tencent.mobileqq.webviewplugin.n nVar) {
        if (c8976b instanceof SwiftBrowserShareMenuHandler) {
            ((SwiftBrowserShareMenuHandler) c8976b).S((Share) nVar, j3);
        }
    }
}
