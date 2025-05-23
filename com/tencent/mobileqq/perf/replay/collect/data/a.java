package com.tencent.mobileqq.perf.replay.collect.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u00dd\u0001\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012\u0012\b\b\u0002\u0010!\u001a\u00020\u0012\u0012\b\b\u0002\u0010$\u001a\u00020\u0012\u0012\b\b\u0002\u0010'\u001a\u00020\u0012\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\n\u0012$\b\u0002\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012`0\u0012$\b\u0002\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012`0\u0012$\b\u0002\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012`0\u00a2\u0006\u0004\b6\u00107R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010$\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\"\u0010'\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b&\u0010\u0018R\"\u0010*\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b)\u0010\u0018R\"\u0010.\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\f\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R3\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012`08\u0006\u00a2\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b%\u00102R3\u00104\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012`08\u0006\u00a2\u0006\f\n\u0004\b\u0015\u00101\u001a\u0004\b(\u00102R3\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120/j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012`08\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b+\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/perf/replay/collect/data/a;", "", "", "a", "J", "f", "()J", "setSampleInterval", "(J)V", "sampleInterval", "", "b", "I", "e", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "restLoopCount", "", "c", "D", "l", "()D", "t", "(D)V", "totalFps", "d", "k", ReportConstant.COSTREPORT_PREFIX, "totalCpu", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "maxCpu", "o", "minCpu", "g", "r", "threadNum", h.F, DomainData.DOMAIN_NAME, "maxThreadNum", "i", "p", "minThreadNum", "j", "getThreadNumCount", "setThreadNumCount", "threadNumCount", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "timeToCpu", "timeToFps", "timeToThreadNum", "<init>", "(JIDDDDDDDILjava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long sampleInterval;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int restLoopCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private double totalFps;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private double totalCpu;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private double maxCpu;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private double minCpu;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private double threadNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private double maxThreadNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private double minThreadNum;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int threadNumCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Double> timeToCpu;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Double> timeToFps;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Double> timeToThreadNum;

    public a() {
        this(0L, 0, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, null, null, null, InitSkin.DRAWABLE_COUNT, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, (Object) this);
    }

    public final double a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Double) iPatchRedirector.redirect((short) 11, (Object) this)).doubleValue();
        }
        return this.maxCpu;
    }

    public final double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Double) iPatchRedirector.redirect((short) 17, (Object) this)).doubleValue();
        }
        return this.maxThreadNum;
    }

    public final double c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Double) iPatchRedirector.redirect((short) 13, (Object) this)).doubleValue();
        }
        return this.minCpu;
    }

    public final double d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Double) iPatchRedirector.redirect((short) 19, (Object) this)).doubleValue();
        }
        return this.minThreadNum;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.restLoopCount;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.sampleInterval;
    }

    public final double g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Double) iPatchRedirector.redirect((short) 15, (Object) this)).doubleValue();
        }
        return this.threadNum;
    }

    @NotNull
    public final HashMap<Long, Double> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (HashMap) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.timeToCpu;
    }

    @NotNull
    public final HashMap<Long, Double> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (HashMap) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.timeToFps;
    }

    @NotNull
    public final HashMap<Long, Double> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (HashMap) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.timeToThreadNum;
    }

    public final double k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Double) iPatchRedirector.redirect((short) 9, (Object) this)).doubleValue();
        }
        return this.totalCpu;
    }

    public final double l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Double) iPatchRedirector.redirect((short) 7, (Object) this)).doubleValue();
        }
        return this.totalFps;
    }

    public final void m(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Double.valueOf(d16));
        } else {
            this.maxCpu = d16;
        }
    }

    public final void n(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Double.valueOf(d16));
        } else {
            this.maxThreadNum = d16;
        }
    }

    public final void o(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Double.valueOf(d16));
        } else {
            this.minCpu = d16;
        }
    }

    public final void p(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Double.valueOf(d16));
        } else {
            this.minThreadNum = d16;
        }
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.restLoopCount = i3;
        }
    }

    public final void r(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Double.valueOf(d16));
        } else {
            this.threadNum = d16;
        }
    }

    public final void s(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Double.valueOf(d16));
        } else {
            this.totalCpu = d16;
        }
    }

    public final void t(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Double.valueOf(d16));
        } else {
            this.totalFps = d16;
        }
    }

    public a(long j3, int i3, double d16, double d17, double d18, double d19, double d26, double d27, double d28, int i16, @NotNull HashMap<Long, Double> timeToCpu, @NotNull HashMap<Long, Double> timeToFps, @NotNull HashMap<Long, Double> timeToThreadNum) {
        Intrinsics.checkNotNullParameter(timeToCpu, "timeToCpu");
        Intrinsics.checkNotNullParameter(timeToFps, "timeToFps");
        Intrinsics.checkNotNullParameter(timeToThreadNum, "timeToThreadNum");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18), Double.valueOf(d19), Double.valueOf(d26), Double.valueOf(d27), Double.valueOf(d28), Integer.valueOf(i16), timeToCpu, timeToFps, timeToThreadNum);
            return;
        }
        this.sampleInterval = j3;
        this.restLoopCount = i3;
        this.totalFps = d16;
        this.totalCpu = d17;
        this.maxCpu = d18;
        this.minCpu = d19;
        this.threadNum = d26;
        this.maxThreadNum = d27;
        this.minThreadNum = d28;
        this.threadNumCount = i16;
        this.timeToCpu = timeToCpu;
        this.timeToFps = timeToFps;
        this.timeToThreadNum = timeToThreadNum;
    }

    public /* synthetic */ a(long j3, int i3, double d16, double d17, double d18, double d19, double d26, double d27, double d28, int i16, HashMap hashMap, HashMap hashMap2, HashMap hashMap3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 500L : j3, (i17 & 2) != 0 ? 10 : i3, (i17 & 4) != 0 ? 0.0d : d16, (i17 & 8) != 0 ? 0.0d : d17, (i17 & 16) != 0 ? 0.0d : d18, (i17 & 32) != 0 ? Double.MAX_VALUE : d19, (i17 & 64) != 0 ? 0.0d : d26, (i17 & 128) != 0 ? 0.0d : d27, (i17 & 256) != 0 ? Double.MAX_VALUE : d28, (i17 & 512) != 0 ? 0 : i16, (i17 & 1024) != 0 ? new HashMap() : hashMap, (i17 & 2048) != 0 ? new HashMap() : hashMap2, (i17 & 4096) != 0 ? new HashMap() : hashMap3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Double.valueOf(d16), Double.valueOf(d17), Double.valueOf(d18), Double.valueOf(d19), Double.valueOf(d26), Double.valueOf(d27), Double.valueOf(d28), Integer.valueOf(i16), hashMap, hashMap2, hashMap3, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
