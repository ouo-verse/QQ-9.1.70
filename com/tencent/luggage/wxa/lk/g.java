package com.tencent.luggage.wxa.lk;

import com.luggage.trace.ITrace;
import com.luggage.trace.ProfileInfo;
import com.luggage.trace.TraceLogic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements a, ITrace {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ITrace f133586a = TraceLogic.createTrace$default(TraceLogic.INSTANCE, 0, 1, (Object) null);

    public g() {
        init();
    }

    public ProfileInfo getProfileInfo() {
        return this.f133586a.getProfileInfo();
    }

    public void init() {
        this.f133586a.init();
    }

    public void initTraceBinding(long j3, long j16) {
        this.f133586a.initTraceBinding(j3, j16);
    }

    public boolean isTracing() {
        return this.f133586a.isTracing();
    }

    public void release() {
        this.f133586a.release();
    }

    public void startTrace() {
        this.f133586a.startTrace();
    }

    public void stopTrace(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.f133586a.stopTrace(filePath);
    }

    public void traceBegin(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133586a.traceBegin(category, name);
    }

    public int traceBegin2(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f133586a.traceBegin2(category, name);
    }

    public void traceEnd() {
        this.f133586a.traceEnd();
    }

    public void traceEnd2(int i3) {
        this.f133586a.traceEnd2(i3);
    }

    public void traceEvent(String category, String name, double d16) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133586a.traceEvent(category, name, d16);
    }

    public void traceFrame(String category, String name, double d16, double d17) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133586a.traceFrame(category, name, d16, d17);
    }

    public void traceInstant(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133586a.traceInstant(category, name);
    }

    public void traceMemoryUsage(long j3, long j16, double d16) {
        this.f133586a.traceMemoryUsage(j3, j16, d16);
    }

    public void traceScreenShotInfo(String data, double d16) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f133586a.traceScreenShotInfo(data, d16);
    }
}
