package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends b {
    private void b() {
        gb0.b.w();
        RFWLog.d("QCircleInitPlayerProcess", RFWLog.USR, "init player success");
    }

    @Override // com.tencent.qcircle.application.initprocess.b, com.tencent.qcircle.application.initprocess.a
    public void process() {
        super.process();
        b();
    }
}
