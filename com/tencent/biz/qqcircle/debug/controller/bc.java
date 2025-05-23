package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bc extends bs {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84211d = QCircleDebugKey$SwitchStateKey.QCIRCLE_NEW_USER_CONTROLLER.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84211d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182453gi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        if (n()) {
            QCircleToast.o("\u5df2\u6253\u5f00\u65b0\u7528\u6237\u4f53\u9a8c\uff0c\u52a8\u6001\u9875\u548c\u6d88\u606f\u9875\u5165\u53e3\u53ef\u89e6\u53d1\u5f00\u5c4f\u52a8\u753b", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
