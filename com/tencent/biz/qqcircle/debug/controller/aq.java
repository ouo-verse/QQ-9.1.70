package com.tencent.biz.qqcircle.debug.controller;

import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class aq extends az {

    /* renamed from: d, reason: collision with root package name */
    private static final String f84202d = QCircleDebugKey$MultipleStateKey.QCIRCLE_FACE_GET_CONTROLLER.name();

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
        return f84202d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return "\u622a\u53d6\u5934\u50cf\u7b97\u6cd5";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 1;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.d
    protected void l(List<com.tencent.qcircle.cooperation.config.debug.b> list) {
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(String.valueOf(0), 0));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(String.valueOf(1), 1));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(String.valueOf(2), 2));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(String.valueOf(3), 3));
        list.add(new com.tencent.qcircle.cooperation.config.debug.b(String.valueOf(4), 4));
    }
}
