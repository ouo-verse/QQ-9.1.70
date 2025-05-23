package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class bs extends com.tencent.qcircle.cooperation.config.debug.d {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        uq3.k.b().m(d(), i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public void k() {
        p(q());
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.d
    protected void l(List<com.tencent.qcircle.cooperation.config.debug.b> list) {
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f181803er), 0));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(com.tencent.biz.qqcircle.utils.h.a(R.string.f184123l1), 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int q() {
        return uq3.k.b().e(d(), h());
    }
}
