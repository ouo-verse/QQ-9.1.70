package com.tencent.biz.qqcircle.comment.recpic;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u001a\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020!\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/b;", "", "", "f", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "b", "(J)V", QCircleWeakNetReporter.KEY_COST, "I", "getRecCount", "()I", "d", "(I)V", "recCount", "c", "getPicCount", "picCount", "", "D", "getThreshold", "()D", "e", "(D)V", "threshold", "", "Ljava/util/List;", "getCmtIds", "()Ljava/util/List;", "setCmtIds", "(Ljava/util/List;)V", "cmtIds", "<init>", "(JIIDLjava/util/List;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.b, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class CmtClusterBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long cost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int recCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int picCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private double threshold;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> cmtIds;

    public CmtClusterBean(long j3, int i3, int i16, double d16, @NotNull List<String> cmtIds) {
        Intrinsics.checkNotNullParameter(cmtIds, "cmtIds");
        this.cost = j3;
        this.recCount = i3;
        this.picCount = i16;
        this.threshold = d16;
        this.cmtIds = cmtIds;
    }

    /* renamed from: a, reason: from getter */
    public final long getCost() {
        return this.cost;
    }

    public final void b(long j3) {
        this.cost = j3;
    }

    public final void c(int i3) {
        this.picCount = i3;
    }

    public final void d(int i3) {
        this.recCount = i3;
    }

    public final void e(double d16) {
        this.threshold = d16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CmtClusterBean)) {
            return false;
        }
        CmtClusterBean cmtClusterBean = (CmtClusterBean) other;
        if (this.cost == cmtClusterBean.cost && this.recCount == cmtClusterBean.recCount && this.picCount == cmtClusterBean.picCount && Double.compare(this.threshold, cmtClusterBean.threshold) == 0 && Intrinsics.areEqual(this.cmtIds, cmtClusterBean.cmtIds)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QCircleWeakNetReporter.KEY_COST, this.cost);
        jSONObject.put("rec_count", this.recCount);
        jSONObject.put("pic_count", this.picCount);
        jSONObject.put("threshold", this.threshold);
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.cmtIds.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("cmt_ids", jSONArray);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026  })\n        }.toString()");
        return jSONObject2;
    }

    public int hashCode() {
        return (((((((androidx.fragment.app.a.a(this.cost) * 31) + this.recCount) * 31) + this.picCount) * 31) + a.a(this.threshold)) * 31) + this.cmtIds.hashCode();
    }

    @NotNull
    public String toString() {
        return "CmtClusterBean(cost=" + this.cost + ", recCount=" + this.recCount + ", picCount=" + this.picCount + ", threshold=" + this.threshold + ", cmtIds=" + this.cmtIds + ")";
    }
}
