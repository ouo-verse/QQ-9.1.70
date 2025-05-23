package com.tencent.luggage.wxa.lk;

import com.luggage.trace.ProfileInfo;
import com.tencent.luggage.wxa.tn.z;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final i f133589b = new i();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f133590a = f.f133585a;

    static {
        e.a(z.c());
    }

    public ProfileInfo getProfileInfo() {
        return this.f133590a.getProfileInfo();
    }

    public void init() {
        this.f133590a.init();
    }

    public void initTraceBinding(long j3, long j16) {
        this.f133590a.initTraceBinding(j3, j16);
    }

    public boolean isTracing() {
        return this.f133590a.isTracing();
    }

    public void release() {
        this.f133590a.release();
    }

    public void startTrace() {
        this.f133590a.startTrace();
    }

    public void stopTrace(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.f133590a.stopTrace(filePath);
    }

    public void traceBegin(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        e.a(name);
    }

    public int traceBegin2(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f133590a.traceBegin2(category, name);
    }

    public void traceEnd() {
        e.a();
    }

    public void traceEnd2(int i3) {
        this.f133590a.traceEnd2(i3);
    }

    public void traceEvent(String category, String name, double d16) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133590a.traceEvent(category, name, d16);
    }

    public void traceFrame(String category, String name, double d16, double d17) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133590a.traceFrame(category, name, d16, d17);
    }

    public void traceInstant(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        traceBegin(category, name);
        traceEnd();
    }

    public void traceMemoryUsage(long j3, long j16, double d16) {
        this.f133590a.traceMemoryUsage(j3, j16, d16);
    }

    public void traceScreenShotInfo(String data, double d16) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f133590a.traceScreenShotInfo(data, d16);
    }
}
