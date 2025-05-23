package com.tencent.mobileqq.wink.editdraft;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u0012\b\b\u0002\u0010 \u001a\u00020\u0015\u0012\b\b\u0002\u0010#\u001a\u00020\u0015\u0012\b\b\u0002\u0010&\u001a\u00020\u0015\u0012\b\b\u0002\u0010)\u001a\u00020\u0015\u00a2\u0006\u0004\b*\u0010+J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010 \u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u0017\u0010#\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u0017\u0010&\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u0017\u0010)\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/f;", "", "", "Lfeedcloud/FeedCloudCommon$Entry;", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "getRetCode", "()I", "retCode", "b", "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "c", "J", "getOriFileSize", "()J", "oriFileSize", "d", "getOriActualSize", "oriActualSize", "e", "getOriCount", "oriCount", "f", "getNewFileSize", "newFileSize", "g", "getNewActualSize", "newActualSize", h.F, "getNewCount", "newCount", "<init>", "(ILjava/lang/String;JJJJJJ)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editdraft.f, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkEditorDraftReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int retCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String businessName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long oriFileSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long oriActualSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long oriCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long newFileSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final long newActualSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final long newCount;

    public WinkEditorDraftReportData() {
        this(0, null, 0L, 0L, 0L, 0L, 0L, 0L, 255, null);
    }

    @NotNull
    public final List<FeedCloudCommon$Entry> a() {
        List<FeedCloudCommon$Entry> listOf;
        FeedCloudCommon$Entry newEntry = QCircleReportHelper.newEntry("ret_code", String.valueOf(this.retCode));
        Intrinsics.checkNotNullExpressionValue(newEntry, "newEntry(\n            QC\u2026      retCode.toString())");
        FeedCloudCommon$Entry newEntry2 = QCircleReportHelper.newEntry("ext1", String.valueOf(this.oriFileSize));
        Intrinsics.checkNotNullExpressionValue(newEntry2, "newEntry(QCirclePublishQ\u2026  oriFileSize.toString())");
        FeedCloudCommon$Entry newEntry3 = QCircleReportHelper.newEntry("ext2", String.valueOf(this.oriActualSize));
        Intrinsics.checkNotNullExpressionValue(newEntry3, "newEntry(QCirclePublishQ\u2026oriActualSize.toString())");
        FeedCloudCommon$Entry newEntry4 = QCircleReportHelper.newEntry("ext3", String.valueOf(this.oriCount));
        Intrinsics.checkNotNullExpressionValue(newEntry4, "newEntry(QCirclePublishQ\u2026XT3, oriCount.toString())");
        FeedCloudCommon$Entry newEntry5 = QCircleReportHelper.newEntry("ext4", String.valueOf(this.newFileSize));
        Intrinsics.checkNotNullExpressionValue(newEntry5, "newEntry(QCirclePublishQ\u2026  newFileSize.toString())");
        FeedCloudCommon$Entry newEntry6 = QCircleReportHelper.newEntry("ext5", String.valueOf(this.newActualSize));
        Intrinsics.checkNotNullExpressionValue(newEntry6, "newEntry(QCirclePublishQ\u2026newActualSize.toString())");
        FeedCloudCommon$Entry newEntry7 = QCircleReportHelper.newEntry("ext6", String.valueOf(this.newCount));
        Intrinsics.checkNotNullExpressionValue(newEntry7, "newEntry(QCirclePublishQ\u2026XT6, newCount.toString())");
        FeedCloudCommon$Entry newEntry8 = QCircleReportHelper.newEntry("desc", this.businessName);
        Intrinsics.checkNotNullExpressionValue(newEntry8, "newEntry(QCirclePublishQ\u2026orter.DESC, businessName)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FeedCloudCommon$Entry[]{newEntry, newEntry2, newEntry3, newEntry4, newEntry5, newEntry6, newEntry7, newEntry8});
        return listOf;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkEditorDraftReportData)) {
            return false;
        }
        WinkEditorDraftReportData winkEditorDraftReportData = (WinkEditorDraftReportData) other;
        if (this.retCode == winkEditorDraftReportData.retCode && Intrinsics.areEqual(this.businessName, winkEditorDraftReportData.businessName) && this.oriFileSize == winkEditorDraftReportData.oriFileSize && this.oriActualSize == winkEditorDraftReportData.oriActualSize && this.oriCount == winkEditorDraftReportData.oriCount && this.newFileSize == winkEditorDraftReportData.newFileSize && this.newActualSize == winkEditorDraftReportData.newActualSize && this.newCount == winkEditorDraftReportData.newCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.retCode * 31) + this.businessName.hashCode()) * 31) + androidx.fragment.app.a.a(this.oriFileSize)) * 31) + androidx.fragment.app.a.a(this.oriActualSize)) * 31) + androidx.fragment.app.a.a(this.oriCount)) * 31) + androidx.fragment.app.a.a(this.newFileSize)) * 31) + androidx.fragment.app.a.a(this.newActualSize)) * 31) + androidx.fragment.app.a.a(this.newCount);
    }

    @NotNull
    public String toString() {
        return "WinkEditorDraftReportData(retCode=" + this.retCode + ", businessName=" + this.businessName + ", oriFileSize=" + this.oriFileSize + ", oriActualSize=" + this.oriActualSize + ", oriCount=" + this.oriCount + ", newFileSize=" + this.newFileSize + ", newActualSize=" + this.newActualSize + ", newCount=" + this.newCount + ")";
    }

    public WinkEditorDraftReportData(int i3, @NotNull String businessName, long j3, long j16, long j17, long j18, long j19, long j26) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        this.retCode = i3;
        this.businessName = businessName;
        this.oriFileSize = j3;
        this.oriActualSize = j16;
        this.oriCount = j17;
        this.newFileSize = j18;
        this.newActualSize = j19;
        this.newCount = j26;
    }

    public /* synthetic */ WinkEditorDraftReportData(int i3, String str, long j3, long j16, long j17, long j18, long j19, long j26, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? 0L : j16, (i16 & 16) != 0 ? 0L : j17, (i16 & 32) != 0 ? 0L : j18, (i16 & 64) != 0 ? 0L : j19, (i16 & 128) == 0 ? j26 : 0L);
    }
}
