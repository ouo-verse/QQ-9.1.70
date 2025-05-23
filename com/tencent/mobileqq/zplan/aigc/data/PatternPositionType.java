package com.tencent.mobileqq.zplan.aigc.data;

import com.tencent.mobileqq.zplan.aigc.render.ModelStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getIndex", "()I", "index", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "c", "getPositionType", "positionType", "Lcom/tencent/mobileqq/zplan/aigc/render/ModelStyle;", "d", "Lcom/tencent/mobileqq/zplan/aigc/render/ModelStyle;", "getData", "()Lcom/tencent/mobileqq/zplan/aigc/render/ModelStyle;", "data", "<init>", "(ILjava/lang/String;ILcom/tencent/mobileqq/zplan/aigc/render/ModelStyle;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.m, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class PatternPositionType {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int positionType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ModelStyle data;

    public PatternPositionType(int i3, String text, int i16, ModelStyle modelStyle) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.index = i3;
        this.text = text;
        this.positionType = i16;
        this.data = modelStyle;
    }

    /* renamed from: a, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode = ((((this.index * 31) + this.text.hashCode()) * 31) + this.positionType) * 31;
        ModelStyle modelStyle = this.data;
        return hashCode + (modelStyle == null ? 0 : modelStyle.hashCode());
    }

    public String toString() {
        return "PatternPositionType(index=" + this.index + ", text=" + this.text + ", positionType=" + this.positionType + ", data=" + this.data + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatternPositionType)) {
            return false;
        }
        PatternPositionType patternPositionType = (PatternPositionType) other;
        return this.index == patternPositionType.index && Intrinsics.areEqual(this.text, patternPositionType.text) && this.positionType == patternPositionType.positionType && Intrinsics.areEqual(this.data, patternPositionType.data);
    }
}
