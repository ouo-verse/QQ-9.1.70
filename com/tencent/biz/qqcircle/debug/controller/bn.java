package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bn extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84228b = QCircleDebugKey$MultipleStateKey.QCIRCLE_REC_EXPT_ENV_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84228b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182613gy) + "\uff08" + g() + "\uff09";
    }

    public String g() {
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f182603gx);
        if (QCirclePluginGlobalInfo.k() != null) {
            return QCirclePluginGlobalInfo.k().exptName;
        }
        return a16;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        com.tencent.biz.qqcircle.launcher.c.t0(HostUIHelper.getInstance().getHostApplicationContext());
    }
}
