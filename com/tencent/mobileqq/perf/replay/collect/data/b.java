package com.tencent.mobileqq.perf.replay.collect.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u00ab\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012$\b\u0002\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004`\u0018\u0012$\b\u0002\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004`\u0018\u0012$\b\u0002\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004`\u0018\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR3\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004`\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR3\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004`\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR3\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004`\u00188\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001c\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/perf/replay/collect/data/b;", "", "", "toString", "", "a", "D", "getMMaxCpu", "()D", "mMaxCpu", "b", "getMAvgCpu", "mAvgCpu", "c", "getMAvgFps", "mAvgFps", "d", "getMAvgThreadNum", "mAvgThreadNum", "e", "getMMaxThreadNum", "mMaxThreadNum", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "getTimeToCpu", "()Ljava/util/HashMap;", "timeToCpu", "g", "getTimeToFps", "timeToFps", h.F, "getTimeToThreadNum", "timeToThreadNum", "<init>", "(DDDDDLjava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final double mMaxCpu;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final double mAvgCpu;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final double mAvgFps;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final double mAvgThreadNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final double mMaxThreadNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Double> timeToCpu;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Double> timeToFps;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Double> timeToThreadNum;

    public b(double d16, double d17, double d18, double d19, double d26, @NotNull HashMap<Long, Double> timeToCpu, @NotNull HashMap<Long, Double> timeToFps, @NotNull HashMap<Long, Double> timeToThreadNum) {
        Intrinsics.checkNotNullParameter(timeToCpu, "timeToCpu");
        Intrinsics.checkNotNullParameter(timeToFps, "timeToFps");
        Intrinsics.checkNotNullParameter(timeToThreadNum, "timeToThreadNum");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18), Double.valueOf(d19), Double.valueOf(d26), timeToCpu, timeToFps, timeToThreadNum);
            return;
        }
        this.mMaxCpu = d16;
        this.mAvgCpu = d17;
        this.mAvgFps = d18;
        this.mAvgThreadNum = d19;
        this.mMaxThreadNum = d26;
        this.timeToCpu = timeToCpu;
        this.timeToFps = timeToFps;
        this.timeToThreadNum = timeToThreadNum;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "Performance(mMaxCpu=" + this.mMaxCpu + ", mAvgCpu=" + this.mAvgCpu + ", mAvgFps=" + this.mAvgFps + ", mAvgThreadNum=" + this.mAvgThreadNum + ", mMaxThreadNum=" + this.mMaxThreadNum + ')';
    }

    public /* synthetic */ b(double d16, double d17, double d18, double d19, double d26, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0d : d16, (i3 & 2) != 0 ? 0.0d : d17, (i3 & 4) != 0 ? 0.0d : d18, (i3 & 8) != 0 ? 0.0d : d19, (i3 & 16) != 0 ? 0.0d : d26, (i3 & 32) != 0 ? new HashMap() : hashMap, (i3 & 64) != 0 ? new HashMap() : hashMap2, (i3 & 128) != 0 ? new HashMap() : hashMap3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18), Double.valueOf(d19), Double.valueOf(d26), hashMap, hashMap2, hashMap3, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
