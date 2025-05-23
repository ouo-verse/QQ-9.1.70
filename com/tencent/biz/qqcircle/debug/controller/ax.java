package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ax extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84207b = QCircleDebugKey$MultipleStateKey.QCIRCLE_LBS_SERVER_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84207b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182403gd) + "\uff08" + g() + "\uff09";
    }

    public String g() {
        if (QCirclePluginGlobalInfo.j() != null) {
            return QCirclePluginGlobalInfo.j().district;
        }
        return "\u5f53\u524d\u6240\u5728\u5730";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        com.tencent.biz.qqcircle.launcher.c.U(QCircleApplication.APP.getApplicationContext());
    }
}
