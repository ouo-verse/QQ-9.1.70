package com.tencent.biz.qqcircle.debug.controller;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import lb0.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cm extends bs {

    /* renamed from: d, reason: collision with root package name */
    public static final String f84258d = QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_CLARITY_INFO.name();

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84258d;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182133fn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        MutableLiveData globalData = w20.a.j().getGlobalData(b.a.class, "QFSClarityReportHelper");
        if (globalData != null) {
            w20.a.j().initOrUpdateGlobalState((w20.a) globalData.getValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }
}
