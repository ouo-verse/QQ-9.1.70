package com.tencent.mobileqq.zootopia.ueloading.report;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0019\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001\tBU\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\t\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001b\u0010\u001eR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b \u0010\u0019R\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u0016\u0010\u0019R\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/report/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "mapId", "", "b", "J", "g", "()J", VasPerfReportUtils.WHILE_COST_TOTAL, "f", "stepCost", "d", "Z", "i", "()Z", "isNewLoading", "e", "background", "Ljava/lang/String;", "()Ljava/lang/String;", "source", h.F, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "needDownloadCommonMod", "downloadCommonModSource", "<init>", "(IJJZZLjava/lang/String;ZZI)V", "j", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.ueloading.report.c, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class ZPlanUETechReportParams {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mapId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long totalCost;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long stepCost;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isNewLoading;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean background;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String source;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isDownloaded;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean needDownloadCommonMod;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int downloadCommonModSource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/report/c$a;", "", "", "mapId", "", VasPerfReportUtils.WHILE_COST_TOTAL, "stepCost", "", "isNewLoading", "background", "", "source", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "Lcom/tencent/mobileqq/zootopia/ueloading/report/c;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ueloading.report.c$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanUETechReportParams a(int mapId, long totalCost, long stepCost, boolean isNewLoading, boolean background, String source, boolean isDownloaded) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new ZPlanUETechReportParams(mapId, totalCost, stepCost, isNewLoading, background, source, isDownloaded, false, 0, MsgConstant.KRMFILETHUMBSIZE384, null);
        }

        Companion() {
        }
    }

    public ZPlanUETechReportParams(int i3, long j3, long j16, boolean z16, boolean z17, String source, boolean z18, boolean z19, int i16) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.mapId = i3;
        this.totalCost = j3;
        this.stepCost = j16;
        this.isNewLoading = z16;
        this.background = z17;
        this.source = source;
        this.isDownloaded = z18;
        this.needDownloadCommonMod = z19;
        this.downloadCommonModSource = i16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getBackground() {
        return this.background;
    }

    /* renamed from: b, reason: from getter */
    public final int getDownloadCommonModSource() {
        return this.downloadCommonModSource;
    }

    /* renamed from: c, reason: from getter */
    public final int getMapId() {
        return this.mapId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getNeedDownloadCommonMod() {
        return this.needDownloadCommonMod;
    }

    /* renamed from: e, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: f, reason: from getter */
    public final long getStepCost() {
        return this.stepCost;
    }

    /* renamed from: g, reason: from getter */
    public final long getTotalCost() {
        return this.totalCost;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsDownloaded() {
        return this.isDownloaded;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((this.mapId * 31) + com.tencent.mobileqq.vas.banner.c.a(this.totalCost)) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.stepCost)) * 31;
        boolean z16 = this.isNewLoading;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (a16 + i3) * 31;
        boolean z17 = this.background;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int hashCode = (((i16 + i17) * 31) + this.source.hashCode()) * 31;
        boolean z18 = this.isDownloaded;
        int i18 = z18;
        if (z18 != 0) {
            i18 = 1;
        }
        int i19 = (hashCode + i18) * 31;
        boolean z19 = this.needDownloadCommonMod;
        return ((i19 + (z19 ? 1 : z19 ? 1 : 0)) * 31) + this.downloadCommonModSource;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsNewLoading() {
        return this.isNewLoading;
    }

    public String toString() {
        return "ZPlanUETechReportParams(mapId=" + this.mapId + ", totalCost=" + this.totalCost + ", isNewLoading=" + this.isNewLoading + ", background=" + this.background + ", source='" + this.source + "')";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanUETechReportParams)) {
            return false;
        }
        ZPlanUETechReportParams zPlanUETechReportParams = (ZPlanUETechReportParams) other;
        return this.mapId == zPlanUETechReportParams.mapId && this.totalCost == zPlanUETechReportParams.totalCost && this.stepCost == zPlanUETechReportParams.stepCost && this.isNewLoading == zPlanUETechReportParams.isNewLoading && this.background == zPlanUETechReportParams.background && Intrinsics.areEqual(this.source, zPlanUETechReportParams.source) && this.isDownloaded == zPlanUETechReportParams.isDownloaded && this.needDownloadCommonMod == zPlanUETechReportParams.needDownloadCommonMod && this.downloadCommonModSource == zPlanUETechReportParams.downloadCommonModSource;
    }

    public /* synthetic */ ZPlanUETechReportParams(int i3, long j3, long j16, boolean z16, boolean z17, String str, boolean z18, boolean z19, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, j3, j16, z16, z17, str, (i17 & 64) != 0 ? true : z18, (i17 & 128) != 0 ? false : z19, (i17 & 256) != 0 ? 0 : i16);
    }
}
