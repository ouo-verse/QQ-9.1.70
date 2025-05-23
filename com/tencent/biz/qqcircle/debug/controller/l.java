package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.util.QQToastUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class l extends com.tencent.qcircle.cooperation.config.debug.a {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return "QCircleDebugPublishTips2Controller";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182523gp);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        com.tencent.biz.qqcircle.f.C().edit().putBoolean(com.tencent.biz.qqcircle.f.f84424j, false).apply();
        QQToastUtil.showQQToastInUiThread(2, "\u5df2\u6e05\u7a7a");
    }
}
