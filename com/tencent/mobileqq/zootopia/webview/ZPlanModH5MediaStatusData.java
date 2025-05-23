package com.tencent.mobileqq.zootopia.webview;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zootopia/webview/ZPlanModH5MediaStatusData;", "Ljava/io/Serializable;", "status", "", "stopReason", "stopPlayPosition", "", "(IID)V", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "getStopPlayPosition", "()D", "getStopReason", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class ZPlanModH5MediaStatusData implements Serializable {
    private final int status;
    private final double stopPlayPosition;
    private final int stopReason;

    public ZPlanModH5MediaStatusData(int i3, int i16, double d16) {
        this.status = i3;
        this.stopReason = i16;
        this.stopPlayPosition = d16;
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStopReason() {
        return this.stopReason;
    }

    /* renamed from: component3, reason: from getter */
    public final double getStopPlayPosition() {
        return this.stopPlayPosition;
    }

    public final ZPlanModH5MediaStatusData copy(int status, int stopReason, double stopPlayPosition) {
        return new ZPlanModH5MediaStatusData(status, stopReason, stopPlayPosition);
    }

    public final int getStatus() {
        return this.status;
    }

    public final double getStopPlayPosition() {
        return this.stopPlayPosition;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public int hashCode() {
        return (((this.status * 31) + this.stopReason) * 31) + f.a(this.stopPlayPosition);
    }

    public String toString() {
        return "ZPlanModH5MediaStatusData(status=" + this.status + ", stopReason=" + this.stopReason + ", stopPlayPosition=" + this.stopPlayPosition + ")";
    }

    public static /* synthetic */ ZPlanModH5MediaStatusData copy$default(ZPlanModH5MediaStatusData zPlanModH5MediaStatusData, int i3, int i16, double d16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = zPlanModH5MediaStatusData.status;
        }
        if ((i17 & 2) != 0) {
            i16 = zPlanModH5MediaStatusData.stopReason;
        }
        if ((i17 & 4) != 0) {
            d16 = zPlanModH5MediaStatusData.stopPlayPosition;
        }
        return zPlanModH5MediaStatusData.copy(i3, i16, d16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanModH5MediaStatusData)) {
            return false;
        }
        ZPlanModH5MediaStatusData zPlanModH5MediaStatusData = (ZPlanModH5MediaStatusData) other;
        return this.status == zPlanModH5MediaStatusData.status && this.stopReason == zPlanModH5MediaStatusData.stopReason && Double.compare(this.stopPlayPosition, zPlanModH5MediaStatusData.stopPlayPosition) == 0;
    }
}
