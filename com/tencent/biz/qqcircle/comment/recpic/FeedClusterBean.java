package com.tencent.biz.qqcircle.comment.recpic;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/c;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getMainCate", "()Ljava/lang/String;", "mainCate", "b", "getSubCate", "subCate", "c", "getFeedId", "feedId", "d", "I", "getCount", "()I", "count", "", "e", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.c, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class FeedClusterBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String mainCate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String subCate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long cost;

    public FeedClusterBean(@NotNull String mainCate, @NotNull String subCate, @NotNull String feedId, int i3, long j3) {
        Intrinsics.checkNotNullParameter(mainCate, "mainCate");
        Intrinsics.checkNotNullParameter(subCate, "subCate");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.mainCate = mainCate;
        this.subCate = subCate;
        this.feedId = feedId;
        this.count = i3;
        this.cost = j3;
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("main_cate", this.mainCate);
        jSONObject.put("sub_cate", this.subCate);
        jSONObject.put("feed_id", this.feedId);
        jSONObject.put("count", this.count);
        jSONObject.put(QCircleWeakNetReporter.KEY_COST, this.cost);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ost)\n        }.toString()");
        return jSONObject2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedClusterBean)) {
            return false;
        }
        FeedClusterBean feedClusterBean = (FeedClusterBean) other;
        if (Intrinsics.areEqual(this.mainCate, feedClusterBean.mainCate) && Intrinsics.areEqual(this.subCate, feedClusterBean.subCate) && Intrinsics.areEqual(this.feedId, feedClusterBean.feedId) && this.count == feedClusterBean.count && this.cost == feedClusterBean.cost) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.mainCate.hashCode() * 31) + this.subCate.hashCode()) * 31) + this.feedId.hashCode()) * 31) + this.count) * 31) + androidx.fragment.app.a.a(this.cost);
    }

    @NotNull
    public String toString() {
        return "FeedClusterBean(mainCate=" + this.mainCate + ", subCate=" + this.subCate + ", feedId=" + this.feedId + ", count=" + this.count + ", cost=" + this.cost + ")";
    }
}
