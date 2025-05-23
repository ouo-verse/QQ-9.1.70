package com.tencent.luggage.wxa.ic;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b0 extends com.tencent.luggage.wxa.lk.g {
    @Override // com.tencent.luggage.wxa.lk.g
    public void initTraceBinding(long j3, long j16) {
        super.initTraceBinding(j3, j16);
        com.tencent.luggage.wxa.lk.h.f133587b.initTraceBinding(j3, j16);
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public boolean isTracing() {
        return com.tencent.luggage.wxa.lk.h.f133587b.isTracing();
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public void release() {
        super.release();
        com.tencent.luggage.wxa.lk.h.f133587b.release();
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public void startTrace() {
        super.startTrace();
        com.tencent.luggage.wxa.lk.h.f133587b.startTrace();
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public void stopTrace(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        super.stopTrace(filePath);
        com.tencent.luggage.wxa.lk.h.f133587b.stopTrace(filePath);
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public void traceBegin(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        super.traceBegin(category, name);
        com.tencent.luggage.wxa.lk.h.f133587b.traceBegin(category, name);
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public void traceEnd() {
        super.traceEnd();
        com.tencent.luggage.wxa.lk.h.f133587b.traceEnd();
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public void traceEvent(String name, String category, double d16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        super.traceEvent(name, category, d16);
        com.tencent.luggage.wxa.lk.h.f133587b.traceEvent(name, category, d16);
    }

    @Override // com.tencent.luggage.wxa.lk.g
    public void traceInstant(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        super.traceInstant(category, name);
        com.tencent.luggage.wxa.lk.h.f133587b.traceInstant(category, name);
    }
}
