package com.tencent.hippykotlin.demo.pages.vas_base.report.chain.interfaces;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IReportConfig {
    void connectChain();

    IReport getReportImpl();

    /* JADX WARN: Incorrect return type in method signature: ()Ljava/util/List<Ljava/lang/Object;>; */
    void interceptor();

    String key();

    ISample sample();

    String serviceName();

    long timeOut();

    long timestamp();

    Function1<Map<String, String>, Unit> vasCommonReportImpl();

    int version();
}
