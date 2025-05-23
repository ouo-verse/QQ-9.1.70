package com.tencent.mobileqq.wxmini.impl.launcher;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\r\u0010\u001dR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u0018\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u0013\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wxmini/impl/launcher/r;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "wxaAppID", "b", "I", "getVersionType", "()I", "versionType", "", "c", "J", "getTimestamp", "()J", "timestamp", "d", "getCost", QCircleWeakNetReporter.KEY_COST, "e", "Z", "()Z", "isColdLaunch", "f", "isHitPreload", "g", "isHitPkgCache", "<init>", "(Ljava/lang/String;IJJZZZ)V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wxmini.impl.launcher.r, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class WxaPerformanceMetrics {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String wxaAppID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int versionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long timestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long cost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isColdLaunch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHitPreload;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHitPkgCache;

    public WxaPerformanceMetrics(String wxaAppID, int i3, long j3, long j16, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        this.wxaAppID = wxaAppID;
        this.versionType = i3;
        this.timestamp = j3;
        this.cost = j16;
        this.isColdLaunch = z16;
        this.isHitPreload = z17;
        this.isHitPkgCache = z18;
    }

    /* renamed from: a, reason: from getter */
    public final String getWxaAppID() {
        return this.wxaAppID;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsColdLaunch() {
        return this.isColdLaunch;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsHitPkgCache() {
        return this.isHitPkgCache;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsHitPreload() {
        return this.isHitPreload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.wxaAppID.hashCode() * 31) + this.versionType) * 31) + q.a(this.timestamp)) * 31) + q.a(this.cost)) * 31;
        boolean z16 = this.isColdLaunch;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.isHitPreload;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z18 = this.isHitPkgCache;
        return i18 + (z18 ? 1 : z18 ? 1 : 0);
    }

    public String toString() {
        return "WxaPerformanceMetrics(wxaAppID=" + this.wxaAppID + ", versionType=" + this.versionType + ", timestamp=" + this.timestamp + ", cost=" + this.cost + ", isColdLaunch=" + this.isColdLaunch + ", isHitPreload=" + this.isHitPreload + ", isHitPkgCache=" + this.isHitPkgCache + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WxaPerformanceMetrics)) {
            return false;
        }
        WxaPerformanceMetrics wxaPerformanceMetrics = (WxaPerformanceMetrics) other;
        return Intrinsics.areEqual(this.wxaAppID, wxaPerformanceMetrics.wxaAppID) && this.versionType == wxaPerformanceMetrics.versionType && this.timestamp == wxaPerformanceMetrics.timestamp && this.cost == wxaPerformanceMetrics.cost && this.isColdLaunch == wxaPerformanceMetrics.isColdLaunch && this.isHitPreload == wxaPerformanceMetrics.isHitPreload && this.isHitPkgCache == wxaPerformanceMetrics.isHitPkgCache;
    }
}
