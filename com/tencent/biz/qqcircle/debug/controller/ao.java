package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ao extends com.tencent.qcircle.cooperation.config.debug.a {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return "QCircleExChangeVideoUrl";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f185483op);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        com.tencent.biz.qqcircle.launcher.c.G0(QCircleApplication.APP.getApplicationContext(), null);
    }
}
