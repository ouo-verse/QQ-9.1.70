package com.tencent.biz.qqcircle.comment.recpic;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/am;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "I", "getIndex", "()I", "index", "b", "getStrategy", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "", "c", UserInfo.SEX_FEMALE, "getSimilarity", "()F", "similarity", "<init>", "(IIF)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.am, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class RecPicReportInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int strategy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float similarity;

    public RecPicReportInfo(int i3, int i16, float f16) {
        this.index = i3;
        this.strategy = i16;
        this.similarity = f16;
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("index", this.index);
        jSONObject.put(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, this.strategy);
        jSONObject.put("similarity", Float.valueOf(this.similarity));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecPicReportInfo)) {
            return false;
        }
        RecPicReportInfo recPicReportInfo = (RecPicReportInfo) other;
        if (this.index == recPicReportInfo.index && this.strategy == recPicReportInfo.strategy && Float.compare(this.similarity, recPicReportInfo.similarity) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.index * 31) + this.strategy) * 31) + Float.floatToIntBits(this.similarity);
    }

    @NotNull
    public String toString() {
        return "RecPicReportInfo(index=" + this.index + ", strategy=" + this.strategy + ", similarity=" + this.similarity + ")";
    }
}
