package com.tencent.mobileqq.zplan.report;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.zootopia.webview.f;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "D", "b", "()D", "usageMB", "", "J", "()J", "measureTimestampMs", "<init>", "(DJ)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.report.b, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class MemoryUsageEvent {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final double usageMB;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long measureTimestampMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/report/b$a;", "", "", "pid", "Landroid/os/Debug$MemoryInfo;", "a", "", "d", "", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.report.b$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Debug.MemoryInfo a(int pid) {
            if (Build.VERSION.SDK_INT > 28 && pid == Process.myPid()) {
                Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                Debug.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            return MemoryUtil.f258173a.p(pid);
        }

        public final double c() {
            double totalPss = b(MemoryUsageEvent.INSTANCE, 0, 1, null).getTotalPss() / 1024.0d;
            long currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
            if (currentTimeMillis > 5) {
                QLog.d("ZPlanMemoryUsageReport", 4, "\u83b7\u53d6Pss\u8017\u65f6: " + currentTimeMillis + " ms");
            }
            return totalPss;
        }

        public final long d() {
            return System.currentTimeMillis();
        }

        Companion() {
        }

        static /* synthetic */ Debug.MemoryInfo b(Companion companion, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = Process.myPid();
            }
            return companion.a(i3);
        }
    }

    public MemoryUsageEvent() {
        this(0.0d, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getMeasureTimestampMs() {
        return this.measureTimestampMs;
    }

    /* renamed from: b, reason: from getter */
    public final double getUsageMB() {
        return this.usageMB;
    }

    public int hashCode() {
        return (f.a(this.usageMB) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.measureTimestampMs);
    }

    public String toString() {
        return "MemoryUsageEvent(usageMB=" + this.usageMB + ", measureTimestampMs=" + this.measureTimestampMs + ")";
    }

    public MemoryUsageEvent(double d16, long j3) {
        this.usageMB = d16;
        this.measureTimestampMs = j3;
    }

    public /* synthetic */ MemoryUsageEvent(double d16, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? INSTANCE.c() : d16, (i3 & 2) != 0 ? INSTANCE.d() : j3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryUsageEvent)) {
            return false;
        }
        MemoryUsageEvent memoryUsageEvent = (MemoryUsageEvent) other;
        return Double.compare(this.usageMB, memoryUsageEvent.usageMB) == 0 && this.measureTimestampMs == memoryUsageEvent.measureTimestampMs;
    }
}
