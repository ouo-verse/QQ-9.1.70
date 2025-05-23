package com.tencent.mobileqq.guild.report;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020 \u0012\b\b\u0002\u0010(\u001a\u00020 \u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u0019\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b'\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/report/j;", "", "Lcom/tencent/mobileqq/guild/report/h;", "b", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", com.heytap.mcssdk.a.a.f36102l, "getName", "j", "name", "g", "i", "freesiaName", "d", "Z", "f", "()Z", "setForceReport", "(Z)V", "forceReport", "", "e", UserInfo.SEX_FEMALE, "()F", "setDefaultGraySampleRate", "(F)V", "defaultGraySampleRate", "setDefaultPublicSampleRate", "defaultPublicSampleRate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZFF)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.report.j, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ReportOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String freesiaName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean forceReport;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private float defaultGraySampleRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private float defaultPublicSampleRate;

    public ReportOption() {
        this(null, null, null, false, 0.0f, 0.0f, 63, null);
    }

    @NotNull
    public final IPerformanceReportTask a() {
        return ((IPerformanceReportApi) QRoute.api(IPerformanceReportApi.class)).newForceReportTask(this.name, this);
    }

    @NotNull
    public final h b() {
        return ((IPerformanceReportApi) QRoute.api(IPerformanceReportApi.class)).newReportClient(this.name, this);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: d, reason: from getter */
    public final float getDefaultGraySampleRate() {
        return this.defaultGraySampleRate;
    }

    /* renamed from: e, reason: from getter */
    public final float getDefaultPublicSampleRate() {
        return this.defaultPublicSampleRate;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportOption)) {
            return false;
        }
        ReportOption reportOption = (ReportOption) other;
        if (Intrinsics.areEqual(this.appKey, reportOption.appKey) && Intrinsics.areEqual(this.name, reportOption.name) && Intrinsics.areEqual(this.freesiaName, reportOption.freesiaName) && this.forceReport == reportOption.forceReport && Float.compare(this.defaultGraySampleRate, reportOption.defaultGraySampleRate) == 0 && Float.compare(this.defaultPublicSampleRate, reportOption.defaultPublicSampleRate) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getForceReport() {
        return this.forceReport;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getFreesiaName() {
        return this.freesiaName;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appKey = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.appKey.hashCode() * 31) + this.name.hashCode()) * 31) + this.freesiaName.hashCode()) * 31;
        boolean z16 = this.forceReport;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((hashCode + i3) * 31) + Float.floatToIntBits(this.defaultGraySampleRate)) * 31) + Float.floatToIntBits(this.defaultPublicSampleRate);
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.freesiaName = str;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @NotNull
    public String toString() {
        return "ReportOption(appKey=" + this.appKey + ", name=" + this.name + ", freesiaName=" + this.freesiaName + ", forceReport=" + this.forceReport + ", defaultGraySampleRate=" + this.defaultGraySampleRate + ", defaultPublicSampleRate=" + this.defaultPublicSampleRate + ")";
    }

    public ReportOption(@NotNull String appKey, @NotNull String name, @NotNull String freesiaName, boolean z16, float f16, float f17) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(freesiaName, "freesiaName");
        this.appKey = appKey;
        this.name = name;
        this.freesiaName = freesiaName;
        this.forceReport = z16;
        this.defaultGraySampleRate = f16;
        this.defaultPublicSampleRate = f17;
    }

    public /* synthetic */ ReportOption(String str, String str2, String str3, boolean z16, float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? str3 : "", (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? 0.0f : f16, (i3 & 32) != 0 ? 0.0f : f17);
    }
}
