package com.tencent.biz.qqcircle.debug.controller;

import cooperation.qzone.LocalMultiProcConfig;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class az extends com.tencent.qcircle.cooperation.config.debug.d {
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    protected void g(int i3) {
        LocalMultiProcConfig.putInt(d(), i3);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.d
    protected void k() {
        this.f342444b = q();
    }

    protected int q() {
        return LocalMultiProcConfig.getInt(d(), h());
    }
}
