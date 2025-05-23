package com.tencent.luggage.wxa.lk;

import com.luggage.trace.ITrace;
import com.luggage.trace.ProfileInfo;
import com.luggage.trace.TraceLogic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements a, ITrace {

    /* renamed from: b, reason: collision with root package name */
    public static final h f133587b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ITrace f133588a = TraceLogic.INSTANCE.createTrace(1);

    static {
        h hVar = new h();
        f133587b = hVar;
        hVar.init();
        hVar.startTrace();
    }

    public ProfileInfo getProfileInfo() {
        return this.f133588a.getProfileInfo();
    }

    public void init() {
        this.f133588a.init();
    }

    public void initTraceBinding(long j3, long j16) {
        this.f133588a.initTraceBinding(j3, j16);
    }

    public boolean isTracing() {
        return this.f133588a.isTracing();
    }

    public void release() {
        this.f133588a.release();
    }

    public void startTrace() {
        this.f133588a.startTrace();
    }

    public void stopTrace(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.f133588a.stopTrace(filePath);
    }

    public void traceBegin(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133588a.traceBegin(category, name);
    }

    public int traceBegin2(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f133588a.traceBegin2(category, name);
    }

    public void traceEnd() {
        this.f133588a.traceEnd();
    }

    public void traceEnd2(int i3) {
        this.f133588a.traceEnd2(i3);
    }

    public void traceEvent(String category, String name, double d16) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133588a.traceEvent(category, name, d16);
    }

    public void traceFrame(String category, String name, double d16, double d17) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133588a.traceFrame(category, name, d16, d17);
    }

    public void traceInstant(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133588a.traceInstant(category, name);
    }

    public void traceMemoryUsage(long j3, long j16, double d16) {
        this.f133588a.traceMemoryUsage(j3, j16, d16);
    }

    public void traceScreenShotInfo(String data, double d16) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f133588a.traceScreenShotInfo(data, d16);
    }
}
