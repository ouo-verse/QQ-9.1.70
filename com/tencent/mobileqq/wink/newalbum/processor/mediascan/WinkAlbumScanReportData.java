package com.tencent.mobileqq.wink.newalbum.processor.mediascan;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b(\b\u0086\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000bBa\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0011\u0012\b\b\u0002\u0010*\u001a\u00020\u0011\u0012\b\b\u0002\u0010-\u001a\u00020\u0011\u0012\b\b\u0002\u00101\u001a\u00020\u0011\u0012\b\b\u0002\u00106\u001a\u00020\u000f\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0018\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010'\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\"\u0010*\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\"\u0010-\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\"\u00101\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\"\u00106\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u00102\u001a\u0004\b3\u00104\"\u0004\b.\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/mediascan/a;", "", "", "d", "", "e", "", "time", "c", BaseProfileQZoneComponent.KEY_IS_VIDEO, "b", "a", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "k", "j", "", "toString", "", "hashCode", "other", "equals", "J", "getLastReportTime", "()J", "lastReportTime", "I", "getTotalCount", "()I", "g", "(I)V", "totalCount", "getImageCount", "f", "imageCount", "getVideoCount", "i", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT, "getNewCount", "setNewCount", "newCount", "getIntervalDays", "setIntervalDays", "intervalDays", "getFilterImageCount", "setFilterImageCount", "filterImageCount", h.F, "getFilterVideoCount", "setFilterVideoCount", "filterVideoCount", "Ljava/lang/String;", "getTraceID", "()Ljava/lang/String;", "(Ljava/lang/String;)V", QCircleWeakNetReporter.KEY_TRACE_ID, "<init>", "(JIIIIIIILjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.newalbum.processor.mediascan.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkAlbumScanReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long lastReportTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int totalCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int imageCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int videoCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int newCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int intervalDays;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int filterImageCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int filterVideoCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String traceID;

    public WinkAlbumScanReportData() {
        this(0L, 0, 0, 0, 0, 0, 0, 0, null, 511, null);
    }

    private final boolean d() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.lastReportTime;
        if (currentTimeMillis - j3 >= 86400000) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("WinkAlbumScanReportData", 1, "needReport, ret:" + z16 + ", lastReportTime:" + j3);
        return z16;
    }

    private final void e() {
        ar.f326685a.p("key_wink_new_album_scan_last_report_time", System.currentTimeMillis());
    }

    @Nullable
    public final WinkAlbumScanReportData a() {
        if (!d()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.lastReportTime;
        this.intervalDays = (int) ((currentTimeMillis - j3) / 86400000);
        if (j3 == 0) {
            this.intervalDays = 0;
        }
        e();
        return this;
    }

    public final void b(boolean isVideo) {
        if (isVideo) {
            this.filterVideoCount++;
        } else {
            this.filterImageCount++;
        }
    }

    public final void c(long time) {
        long j3 = this.lastReportTime;
        if (time > j3 && j3 != 0) {
            this.newCount++;
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkAlbumScanReportData)) {
            return false;
        }
        WinkAlbumScanReportData winkAlbumScanReportData = (WinkAlbumScanReportData) other;
        if (this.lastReportTime == winkAlbumScanReportData.lastReportTime && this.totalCount == winkAlbumScanReportData.totalCount && this.imageCount == winkAlbumScanReportData.imageCount && this.videoCount == winkAlbumScanReportData.videoCount && this.newCount == winkAlbumScanReportData.newCount && this.intervalDays == winkAlbumScanReportData.intervalDays && this.filterImageCount == winkAlbumScanReportData.filterImageCount && this.filterVideoCount == winkAlbumScanReportData.filterVideoCount && Intrinsics.areEqual(this.traceID, winkAlbumScanReportData.traceID)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.imageCount = i3;
    }

    public final void g(int i3) {
        this.totalCount = i3;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceID = str;
    }

    public int hashCode() {
        return (((((((((((((((androidx.fragment.app.a.a(this.lastReportTime) * 31) + this.totalCount) * 31) + this.imageCount) * 31) + this.videoCount) * 31) + this.newCount) * 31) + this.intervalDays) * 31) + this.filterImageCount) * 31) + this.filterVideoCount) * 31) + this.traceID.hashCode();
    }

    public final void i(int i3) {
        this.videoCount = i3;
    }

    @NotNull
    public final WinkPublishQualityReportData j() {
        return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_ALBUM_FILTER_INFO").traceId(this.traceID).ext1(String.valueOf(this.filterImageCount)).ext2(String.valueOf(this.filterVideoCount)).getReportData();
    }

    @NotNull
    public final WinkPublishQualityReportData k() {
        return new WinkPublishQualityReportData.Builder().eventId("WE_E_CLIP_ALBUM_INFO").traceId(this.traceID).ext1(String.valueOf(this.totalCount)).ext2(String.valueOf(this.newCount)).ext3(String.valueOf(this.intervalDays)).ext4(String.valueOf(this.imageCount)).ext5(String.valueOf(this.videoCount)).getReportData();
    }

    @NotNull
    public String toString() {
        return "WinkAlbumScanReportData(lastReportTime=" + this.lastReportTime + ", totalCount=" + this.totalCount + ", imageCount=" + this.imageCount + ", videoCount=" + this.videoCount + ", newCount=" + this.newCount + ", intervalDays=" + this.intervalDays + ", filterImageCount=" + this.filterImageCount + ", filterVideoCount=" + this.filterVideoCount + ", traceID=" + this.traceID + ")";
    }

    public WinkAlbumScanReportData(long j3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, @NotNull String traceID) {
        Intrinsics.checkNotNullParameter(traceID, "traceID");
        this.lastReportTime = j3;
        this.totalCount = i3;
        this.imageCount = i16;
        this.videoCount = i17;
        this.newCount = i18;
        this.intervalDays = i19;
        this.filterImageCount = i26;
        this.filterVideoCount = i27;
        this.traceID = traceID;
    }

    public /* synthetic */ WinkAlbumScanReportData(long j3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, String str, int i28, DefaultConstructorMarker defaultConstructorMarker) {
        this((i28 & 1) != 0 ? ar.f326685a.f("key_wink_new_album_scan_last_report_time", 0L) : j3, (i28 & 2) != 0 ? 0 : i3, (i28 & 4) != 0 ? 0 : i16, (i28 & 8) != 0 ? 0 : i17, (i28 & 16) != 0 ? 0 : i18, (i28 & 32) != 0 ? 0 : i19, (i28 & 64) != 0 ? 0 : i26, (i28 & 128) == 0 ? i27 : 0, (i28 & 256) != 0 ? "" : str);
    }
}
