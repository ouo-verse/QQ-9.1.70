package com.tencent.kuikly.core.module;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/module/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getAvgIncrement", "()I", "avgIncrement", "b", "getPeakIncrement", "peakIncrement", "c", "getAppPeak", "appPeak", "d", "getAppAvg", "appAvg", "<init>", "(IIII)V", "e", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.module.h, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class MemoryData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int avgIncrement;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int peakIncrement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int appPeak;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int appAvg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/module/h$a;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "jsonObject", "Lcom/tencent/kuikly/core/module/h;", "a", "", "KEY_APP_AVG", "Ljava/lang/String;", "KEY_APP_PEAK", "KEY_AVG_INCREMENT", "KEY_PEAK_INCREMENT", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.module.h$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final MemoryData a(com.tencent.kuikly.core.nvi.serialization.json.e jsonObject) {
            if (jsonObject != null) {
                return new MemoryData(jsonObject.j("avgIncrement"), jsonObject.j("peakIncrement"), jsonObject.j("appPeak"), jsonObject.j("appAvg"));
            }
            return null;
        }
    }

    public MemoryData(int i3, int i16, int i17, int i18) {
        this.avgIncrement = i3;
        this.peakIncrement = i16;
        this.appPeak = i17;
        this.appAvg = i18;
    }

    public int hashCode() {
        return (((((this.avgIncrement * 31) + this.peakIncrement) * 31) + this.appPeak) * 31) + this.appAvg;
    }

    public String toString() {
        return "MemoryData(avgIncrement=" + this.avgIncrement + ", peakIncrement=" + this.peakIncrement + ", appPeak=" + this.appPeak + ", appAvg=" + this.appAvg + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryData)) {
            return false;
        }
        MemoryData memoryData = (MemoryData) other;
        return this.avgIncrement == memoryData.avgIncrement && this.peakIncrement == memoryData.peakIncrement && this.appPeak == memoryData.appPeak && this.appAvg == memoryData.appAvg;
    }
}
