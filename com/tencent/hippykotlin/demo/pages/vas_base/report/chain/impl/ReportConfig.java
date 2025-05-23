package com.tencent.hippykotlin.demo.pages.vas_base.report.chain.impl;

import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReport;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.ISample;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ReportConfig implements IReportConfig {
    public final Function0<Long> fetchTimestamp;
    public final boolean isSample;
    public final String serviceName;
    public final String setKey;
    public final Function1<Map<String, String>, Unit> vasCommonReportImpl;
    public final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public ReportConfig(String str, String str2, int i3, boolean z16, long j3, Function1<? super Map<String, String>, Unit> function1, Function0<Long> function0) {
        this.serviceName = str;
        this.setKey = str2;
        this.version = i3;
        this.isSample = z16;
        this.vasCommonReportImpl = function1;
        this.fetchTimestamp = function0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final IReport getReportImpl() {
        return new BeaconReport();
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final String key() {
        return this.setKey;
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final ISample sample() {
        return new ISample() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.chain.impl.ReportConfig$sample$1
            @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.ISample
            public final boolean isUseDefSample() {
                return ReportConfig.this.isSample;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final String serviceName() {
        return this.serviceName;
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final long timeOut() {
        return -1L;
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final long timestamp() {
        return this.fetchTimestamp.invoke().longValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final Function1<Map<String, String>, Unit> vasCommonReportImpl() {
        return this.vasCommonReportImpl;
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final int version() {
        return this.version;
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final void connectChain() {
    }

    /* JADX WARN: Incorrect return type in method signature: ()Ljava/util/List<Ljava/lang/Object;>; */
    @Override // com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces.IReportConfig
    public final void interceptor() {
    }
}
