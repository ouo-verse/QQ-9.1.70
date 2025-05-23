package com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lfx2/a;", "a", "Lfx2/a;", "c", "()Lfx2/a;", "setMPointVrReport", "(Lfx2/a;)V", "mPointVrReport", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "d", "(Ljava/util/Map;)V", "mPageVrParams", "setMExtraParams", "mExtraParams", "<init>", "(Lfx2/a;Ljava/util/Map;Ljava/util/Map;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.data.c, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class RewardVrReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private fx2.a mPointVrReport;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Map<String, Object> mPageVrParams;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Map<String, String> mExtraParams;

    public RewardVrReportData() {
        this(null, null, null, 7, null);
    }

    @Nullable
    public final Map<String, String> a() {
        return this.mExtraParams;
    }

    @Nullable
    public final Map<String, Object> b() {
        return this.mPageVrParams;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final fx2.a getMPointVrReport() {
        return this.mPointVrReport;
    }

    public final void d(@Nullable Map<String, Object> map) {
        this.mPageVrParams = map;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RewardVrReportData) {
                RewardVrReportData rewardVrReportData = (RewardVrReportData) other;
                if (!Intrinsics.areEqual(this.mPointVrReport, rewardVrReportData.mPointVrReport) || !Intrinsics.areEqual(this.mPageVrParams, rewardVrReportData.mPageVrParams) || !Intrinsics.areEqual(this.mExtraParams, rewardVrReportData.mExtraParams)) {
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
        int i16;
        fx2.a aVar = this.mPointVrReport;
        int i17 = 0;
        if (aVar != null) {
            i3 = aVar.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        Map<String, Object> map = this.mPageVrParams;
        if (map != null) {
            i16 = map.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        Map<String, String> map2 = this.mExtraParams;
        if (map2 != null) {
            i17 = map2.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "RewardVrReportData(mPointVrReport=" + this.mPointVrReport + ", mPageVrParams=" + this.mPageVrParams + ", mExtraParams=" + this.mExtraParams + ")";
    }

    public RewardVrReportData(@Nullable fx2.a aVar, @Nullable Map<String, Object> map, @Nullable Map<String, String> map2) {
        this.mPointVrReport = aVar;
        this.mPageVrParams = map;
        this.mExtraParams = map2;
    }

    public /* synthetic */ RewardVrReportData(fx2.a aVar, Map map, Map map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : aVar, (i3 & 2) != 0 ? null : map, (i3 & 4) != 0 ? null : map2);
    }
}
