package com.tencent.biz.qqcircle.comment.recpic;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/d;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getHashId", "()Ljava/lang/String;", "hashId", "b", "I", "getPipeline", "()I", "pipeline", "c", "getCount", "count", "<init>", "(Ljava/lang/String;II)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.d, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class InputClusterBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String hashId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pipeline;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int count;

    public InputClusterBean(@NotNull String hashId, int i3, int i16) {
        Intrinsics.checkNotNullParameter(hashId, "hashId");
        this.hashId = hashId;
        this.pipeline = i3;
        this.count = i16;
    }

    @NotNull
    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("hash_id", this.hashId);
        jSONObject.put("pipeline", this.pipeline);
        jSONObject.put("count", this.count);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026unt)\n        }.toString()");
        return jSONObject2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputClusterBean)) {
            return false;
        }
        InputClusterBean inputClusterBean = (InputClusterBean) other;
        if (Intrinsics.areEqual(this.hashId, inputClusterBean.hashId) && this.pipeline == inputClusterBean.pipeline && this.count == inputClusterBean.count) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.hashId.hashCode() * 31) + this.pipeline) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        return "InputClusterBean(hashId=" + this.hashId + ", pipeline=" + this.pipeline + ", count=" + this.count + ")";
    }
}
