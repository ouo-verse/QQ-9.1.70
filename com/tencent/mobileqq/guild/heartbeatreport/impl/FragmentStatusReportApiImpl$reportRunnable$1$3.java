package com.tencent.mobileqq.guild.heartbeatreport.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class FragmentStatusReportApiImpl$reportRunnable$1$3 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStatusReportApiImpl$reportRunnable$1$3(Object obj) {
        super(1, obj, FragmentStatusReportApiImpl.class, "postDelay", "postDelay(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
        invoke(l3.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j3) {
        ((FragmentStatusReportApiImpl) this.receiver).postDelay(j3);
    }
}
