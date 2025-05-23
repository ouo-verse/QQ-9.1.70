package com.tencent.biz.qqcircle.debug.controller;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class an extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84200d = QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLED_START_MONITOR_CONTROLLER.name();

    private void r(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QMMKV.from(RFWApplication.getApplication(), "common_mmkv_configurations").encodeBool(str, z16);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84200d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182323g6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        ka0.a.f("rmonitor_enable_in_debug", "enable_" + i3);
        if (i3 == 0) {
            r("sp_key_enabled_rmonitor", false);
        } else if (i3 == 1) {
            r("sp_key_enabled_rmonitor", true);
        } else {
            r("sp_key_enabled_rmonitor", false);
        }
        QLog.d(f84200d, 1, "[changeState] state: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
