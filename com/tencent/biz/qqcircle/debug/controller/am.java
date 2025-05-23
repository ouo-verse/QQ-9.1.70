package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class am extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84199d = QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLED_EDGE_PRESSURE_TRAIN_TEST_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84199d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182303g4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        ka0.a.f("rerank_enable_pressure_train_test_in_debug", "enable_" + i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
