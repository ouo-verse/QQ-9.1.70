package com.tencent.biz.qqcircle.debug.controller;

import android.content.SharedPreferences;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.util.QQToastUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p extends com.tencent.qcircle.cooperation.config.debug.a {
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
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182563gt);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        SharedPreferences C = com.tencent.biz.qqcircle.f.C();
        C.edit().putString(com.tencent.biz.qqcircle.f.f84430p, "").apply();
        C.edit().putInt(com.tencent.biz.qqcircle.f.f84431q, 0).apply();
        QQToastUtil.showQQToastInUiThread(2, "\u5df2\u6e05\u7a7a");
    }
}
