package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.widget.QQToast;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends bs {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return "QCircleARTHookController";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return "ART_HOOK";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(RFWApplication.getApplication(), "\u8bbe\u7f6e\u6210\u529f\uff0c\u91cd\u542f\u624bq\u540e\u751f\u6548", 0).show();
        }
        uq3.k.b().j("art_hook", z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void k() {
        super.k();
        p(0);
        uq3.k.b().j("art_hook", false);
    }
}
