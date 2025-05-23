package com.qzone.module.personalitycomponent.coverWidget;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0013\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/module/personalitycomponent/coverWidget/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "appid", "c", "g", "pageId", "e", "adId", "d", tl.h.F, MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.qzone.module.personalitycomponent.coverWidget.m, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class ReportInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String appid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String pageId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String adId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String traceInfo;

    public ReportInfo() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAppid() {
        return this.appid;
    }

    /* renamed from: c, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    /* renamed from: d, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adId = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appid = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageId = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceInfo = str;
    }

    public int hashCode() {
        return (((((this.appid.hashCode() * 31) + this.pageId.hashCode()) * 31) + this.adId.hashCode()) * 31) + this.traceInfo.hashCode();
    }

    public String toString() {
        return "ReportInfo(appid=" + this.appid + ", pageId=" + this.pageId + ", adId=" + this.adId + ", traceInfo=" + this.traceInfo + ")";
    }

    public ReportInfo(String appid, String pageId, String adId, String traceInfo) {
        Intrinsics.checkNotNullParameter(appid, "appid");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        this.appid = appid;
        this.pageId = pageId;
        this.adId = adId;
        this.traceInfo = traceInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportInfo)) {
            return false;
        }
        ReportInfo reportInfo = (ReportInfo) other;
        return Intrinsics.areEqual(this.appid, reportInfo.appid) && Intrinsics.areEqual(this.pageId, reportInfo.pageId) && Intrinsics.areEqual(this.adId, reportInfo.adId) && Intrinsics.areEqual(this.traceInfo, reportInfo.traceInfo);
    }

    public /* synthetic */ ReportInfo(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4);
    }
}
