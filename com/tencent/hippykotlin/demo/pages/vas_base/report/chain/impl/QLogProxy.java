package com.tencent.hippykotlin.demo.pages.vas_base.report.chain.impl;

import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.ILogProxy;
import com.tencent.kuikly.core.log.KLog;

/* loaded from: classes33.dex */
public final class QLogProxy implements ILogProxy {
    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.ILogProxy
    public final void e(String str) {
        KLog.INSTANCE.e("VasReportQLogProxy", str);
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.ILogProxy
    public final void i(String str) {
        KLog.INSTANCE.i("VasReportQLogProxy", str);
    }
}
