package com.tencent.mobileqq.webview.injector;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import cooperation.qzone.QUA;

/* compiled from: P */
/* loaded from: classes35.dex */
public class i implements com.tencent.mobileqq.webview.swift.injector.l {
    @Override // com.tencent.mobileqq.webview.swift.injector.l
    public String a() {
        return new StringBuilder(1024).toString();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.l
    public String getQUA() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.l
    public boolean getStudyModeSwitch() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }
}
