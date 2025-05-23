package com.tencent.rdelivery.reshub.report;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/j;", "", "", "a", "b", "", "c", "toString", "hashCode", "other", "", "equals", "I", "getStartStatus", "()I", "startStatus", "getEndStatus", "endStatus", "Ljava/lang/String;", "getReportKeyPrefix", "()Ljava/lang/String;", "reportKeyPrefix", "<init>", "(IILjava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.rdelivery.reshub.report.j, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class StageReportInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int startStatus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int endStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String reportKeyPrefix;

    public StageReportInfo(int i3, int i16, @NotNull String reportKeyPrefix) {
        Intrinsics.checkParameterIsNotNull(reportKeyPrefix, "reportKeyPrefix");
        this.startStatus = i3;
        this.endStatus = i16;
        this.reportKeyPrefix = reportKeyPrefix;
    }

    /* renamed from: a, reason: from getter */
    public final int getStartStatus() {
        return this.startStatus;
    }

    /* renamed from: b, reason: from getter */
    public final int getEndStatus() {
        return this.endStatus;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getReportKeyPrefix() {
        return this.reportKeyPrefix;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof StageReportInfo) {
                StageReportInfo stageReportInfo = (StageReportInfo) other;
                if (this.startStatus != stageReportInfo.startStatus || this.endStatus != stageReportInfo.endStatus || !Intrinsics.areEqual(this.reportKeyPrefix, stageReportInfo.reportKeyPrefix)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16 = ((this.startStatus * 31) + this.endStatus) * 31;
        String str = this.reportKeyPrefix;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "StageReportInfo(startStatus=" + this.startStatus + ", endStatus=" + this.endStatus + ", reportKeyPrefix=" + this.reportKeyPrefix + ")";
    }
}
