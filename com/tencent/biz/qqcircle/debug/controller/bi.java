package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bi extends az {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84217d = QCircleDebugKey$MultipleStateKey.QCIRCLE_PUBLISHED_USER_CONTROLLER.name();

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
        return f84217d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182583gv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.d
    protected void l(List<com.tencent.qcircle.cooperation.config.debug.b> list) {
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182073fh), 0));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182493gm), 1));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182503gn), 2));
    }
}
