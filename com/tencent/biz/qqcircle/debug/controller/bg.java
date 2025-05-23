package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bg extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84215b = QCircleDebugKey$MultipleStateKey.QCIRCLE_PAGE_SCROLL_SETTING_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84215b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182483gl);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        com.tencent.biz.qqcircle.launcher.c.Y(QCircleApplication.APP.getApplicationContext());
    }
}
