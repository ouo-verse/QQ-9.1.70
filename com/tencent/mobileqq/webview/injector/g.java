package com.tencent.mobileqq.webview.injector;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
/* loaded from: classes35.dex */
public class g implements com.tencent.mobileqq.webview.swift.injector.j {
    @Override // com.tencent.mobileqq.webview.swift.injector.j
    public boolean a(QBaseActivity qBaseActivity) {
        return SystemBarActivityModule.getSystemBarComp(qBaseActivity) != null;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.j
    public void b(QBaseActivity qBaseActivity) {
        SystemBarActivityModule.setImmersiveStatus(qBaseActivity);
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(qBaseActivity);
        if (systemBarComp != null) {
            systemBarComp.init();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.j
    public void c(QBaseActivity qBaseActivity, int i3) {
        SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(i3);
        SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(i3);
    }
}
