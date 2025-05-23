package com.tencent.mobileqq.zplan.share.report;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/report/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "pageId", "b", "eIdClose", "c", "eIdShareItem", "d", "evIdShareSuccess", "e", "keyExternalEntrance", "keyShareChannel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.share.report.f, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ShareReportCommonInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String pageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String eIdClose;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String eIdShareItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String evIdShareSuccess;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String keyExternalEntrance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String keyShareChannel;

    public ShareReportCommonInfo(String pageId, String eIdClose, String eIdShareItem, String evIdShareSuccess, String keyExternalEntrance, String keyShareChannel) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(eIdClose, "eIdClose");
        Intrinsics.checkNotNullParameter(eIdShareItem, "eIdShareItem");
        Intrinsics.checkNotNullParameter(evIdShareSuccess, "evIdShareSuccess");
        Intrinsics.checkNotNullParameter(keyExternalEntrance, "keyExternalEntrance");
        Intrinsics.checkNotNullParameter(keyShareChannel, "keyShareChannel");
        this.pageId = pageId;
        this.eIdClose = eIdClose;
        this.eIdShareItem = eIdShareItem;
        this.evIdShareSuccess = evIdShareSuccess;
        this.keyExternalEntrance = keyExternalEntrance;
        this.keyShareChannel = keyShareChannel;
    }

    /* renamed from: a, reason: from getter */
    public final String getEIdClose() {
        return this.eIdClose;
    }

    /* renamed from: b, reason: from getter */
    public final String getEIdShareItem() {
        return this.eIdShareItem;
    }

    /* renamed from: c, reason: from getter */
    public final String getEvIdShareSuccess() {
        return this.evIdShareSuccess;
    }

    /* renamed from: d, reason: from getter */
    public final String getKeyExternalEntrance() {
        return this.keyExternalEntrance;
    }

    /* renamed from: e, reason: from getter */
    public final String getKeyShareChannel() {
        return this.keyShareChannel;
    }

    /* renamed from: f, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    public int hashCode() {
        return (((((((((this.pageId.hashCode() * 31) + this.eIdClose.hashCode()) * 31) + this.eIdShareItem.hashCode()) * 31) + this.evIdShareSuccess.hashCode()) * 31) + this.keyExternalEntrance.hashCode()) * 31) + this.keyShareChannel.hashCode();
    }

    public String toString() {
        return "ShareReportCommonInfo(pageId=" + this.pageId + ", eIdClose=" + this.eIdClose + ", eIdShareItem=" + this.eIdShareItem + ", evIdShareSuccess=" + this.evIdShareSuccess + ", keyExternalEntrance=" + this.keyExternalEntrance + ", keyShareChannel=" + this.keyShareChannel + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShareReportCommonInfo)) {
            return false;
        }
        ShareReportCommonInfo shareReportCommonInfo = (ShareReportCommonInfo) other;
        return Intrinsics.areEqual(this.pageId, shareReportCommonInfo.pageId) && Intrinsics.areEqual(this.eIdClose, shareReportCommonInfo.eIdClose) && Intrinsics.areEqual(this.eIdShareItem, shareReportCommonInfo.eIdShareItem) && Intrinsics.areEqual(this.evIdShareSuccess, shareReportCommonInfo.evIdShareSuccess) && Intrinsics.areEqual(this.keyExternalEntrance, shareReportCommonInfo.keyExternalEntrance) && Intrinsics.areEqual(this.keyShareChannel, shareReportCommonInfo.keyShareChannel);
    }
}
