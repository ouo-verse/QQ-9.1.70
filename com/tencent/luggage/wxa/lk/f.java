package com.tencent.luggage.wxa.lk;

import com.luggage.trace.ProfileInfo;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final f f133585a = new f();

    public ProfileInfo getProfileInfo() {
        return null;
    }

    public boolean isTracing() {
        return false;
    }

    public void stopTrace(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
    }

    public void traceBegin(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public int traceBegin2(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        return -1;
    }

    public void traceEvent(String name, String category, double d16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
    }

    public void traceFrame(String name, String category, double d16, double d17) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
    }

    public void traceInstant(String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public void traceScreenShotInfo(String data, double d16) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void init() {
    }

    public void release() {
    }

    public void startTrace() {
    }

    public void traceEnd() {
    }

    public void traceEnd2(int i3) {
    }

    public void initTraceBinding(long j3, long j16) {
    }

    public void traceMemoryUsage(long j3, long j16, double d16) {
    }
}
