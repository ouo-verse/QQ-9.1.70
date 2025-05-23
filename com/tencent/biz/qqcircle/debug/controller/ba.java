package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ba extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84209b = QCircleDebugKey$MultipleStateKey.QCIRCLE_MSF_SERVER_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84209b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182413ge) + "\uff08" + g() + "\uff09";
    }

    public String g() {
        return RFWCommonConfig.getCurrentMsfServerName();
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        com.tencent.biz.qqcircle.launcher.c.r(HostUIHelper.getInstance().getHostApplicationContext());
    }
}
