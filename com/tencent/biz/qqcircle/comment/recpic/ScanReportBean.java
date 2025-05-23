package com.tencent.biz.qqcircle.comment.recpic;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050!\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR#\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/ao;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "b", "I", "getTotalScanCount", "()I", "totalScanCount", "c", "getUnsafeCount", "unsafeCount", "", "", "d", "Ljava/util/List;", "getUnsafeSimilarity", "()Ljava/util/List;", "unsafeSimilarity", "e", "getUnsafePromptIds", "unsafePromptIds", "", "f", "Ljava/util/Map;", "getFeedClusterMatchInfo", "()Ljava/util/Map;", "feedClusterMatchInfo", "<init>", "(JIILjava/util/List;Ljava/util/List;Ljava/util/Map;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.ao, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class ScanReportBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long cost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalScanCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int unsafeCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Double> unsafeSimilarity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> unsafePromptIds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, Integer> feedClusterMatchInfo;

    public ScanReportBean(long j3, int i3, int i16, @NotNull List<Double> unsafeSimilarity, @NotNull List<String> unsafePromptIds, @NotNull Map<String, Integer> feedClusterMatchInfo) {
        Intrinsics.checkNotNullParameter(unsafeSimilarity, "unsafeSimilarity");
        Intrinsics.checkNotNullParameter(unsafePromptIds, "unsafePromptIds");
        Intrinsics.checkNotNullParameter(feedClusterMatchInfo, "feedClusterMatchInfo");
        this.cost = j3;
        this.totalScanCount = i3;
        this.unsafeCount = i16;
        this.unsafeSimilarity = unsafeSimilarity;
        this.unsafePromptIds = unsafePromptIds;
        this.feedClusterMatchInfo = feedClusterMatchInfo;
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QCircleWeakNetReporter.KEY_COST, this.cost);
        jSONObject.put("total_scan_count", this.totalScanCount);
        jSONObject.put("unsafe_count", this.unsafeCount);
        JSONArray jSONArray = new JSONArray();
        Iterator<Double> it = this.unsafeSimilarity.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().doubleValue());
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("unsafe_similarity", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Iterator<String> it5 = this.unsafePromptIds.iterator();
        while (it5.hasNext()) {
            jSONArray2.mo162put(it5.next());
        }
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("unsafe_prompt_ids", jSONArray2);
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, Integer> entry : this.feedClusterMatchInfo.entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue().intValue());
        }
        Unit unit3 = Unit.INSTANCE;
        jSONObject.put("feed_cluster_match_info", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString()");
        return jSONObject3;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanReportBean)) {
            return false;
        }
        ScanReportBean scanReportBean = (ScanReportBean) other;
        if (this.cost == scanReportBean.cost && this.totalScanCount == scanReportBean.totalScanCount && this.unsafeCount == scanReportBean.unsafeCount && Intrinsics.areEqual(this.unsafeSimilarity, scanReportBean.unsafeSimilarity) && Intrinsics.areEqual(this.unsafePromptIds, scanReportBean.unsafePromptIds) && Intrinsics.areEqual(this.feedClusterMatchInfo, scanReportBean.feedClusterMatchInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((androidx.fragment.app.a.a(this.cost) * 31) + this.totalScanCount) * 31) + this.unsafeCount) * 31) + this.unsafeSimilarity.hashCode()) * 31) + this.unsafePromptIds.hashCode()) * 31) + this.feedClusterMatchInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ScanReportBean(cost=" + this.cost + ", totalScanCount=" + this.totalScanCount + ", unsafeCount=" + this.unsafeCount + ", unsafeSimilarity=" + this.unsafeSimilarity + ", unsafePromptIds=" + this.unsafePromptIds + ", feedClusterMatchInfo=" + this.feedClusterMatchInfo + ")";
    }
}
