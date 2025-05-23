package com.tencent.mobileqq.webview.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IOfflineApi;
import com.tencent.mobileqq.webview.api.IWebManagerService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WebManagerServiceImpl implements IWebManagerService {
    private static final String TAG = "WebManagerServiceImpl";

    @Override // com.tencent.mobileqq.webview.api.IWebManagerService
    public com.tencent.mobileqq.service.profile.a getOfflineCheckUpdateItemInterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return ((IOfflineApi) QRoute.api(IOfflineApi.class)).getCheckUpdateItemInterface(peekAppRuntime);
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        ((IOfflineApi) QRoute.api(IOfflineApi.class)).release();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
