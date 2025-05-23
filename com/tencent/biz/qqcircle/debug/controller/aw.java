package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class aw extends az {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84206d = QCircleDebugKey$SwitchStateKey.QCIRCLE_IMAGE_EDIT_MODE_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.d, com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 9999;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84206d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182093fj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.d
    protected void l(List<com.tencent.qcircle.cooperation.config.debug.b> list) {
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182083fi), 0));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182103fk), 1));
    }
}
