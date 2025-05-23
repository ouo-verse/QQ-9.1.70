package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bb extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84210d = QCircleDebugKey$SwitchStateKey.QCIRCLE_NEW_PUBLISH_LAYER_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84210d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182313g5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 2;
    }

    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    protected void l(List<com.tencent.qcircle.cooperation.config.debug.b> list) {
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182063fg), 0));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182283g2), 1));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f182443gh), 2));
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public boolean n() {
        if (!m() && this.f342445c.get(this.f342444b).b() == 1) {
            return true;
        }
        return false;
    }
}
