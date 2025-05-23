package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ay extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84208d = QCircleDebugKey$SwitchStateKey.QQCIRCLE_FORCE_LOCAL_ACTIVITY_MODE.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84208d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return "\u5f3a\u5236LocalActivity\u6a21\u5f0f";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        boolean z16;
        super.g(i3);
        uq3.k a16 = uq3.k.a();
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        a16.j("QCircleLocalActivityModeController", z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
