package com.tencent.kuikly.core.views;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/views/aj;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "text", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "inputLength", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.kuikly.core.views.aj, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class InputParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer inputLength;

    public InputParams(String text, Integer num) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.inputLength = num;
    }

    /* renamed from: a, reason: from getter */
    public final Integer getInputLength() {
        return this.inputLength;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        Integer num = this.inputLength;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "InputParams(text=" + this.text + ", inputLength=" + this.inputLength + ')';
    }

    public /* synthetic */ InputParams(String str, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : num);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputParams)) {
            return false;
        }
        InputParams inputParams = (InputParams) other;
        return Intrinsics.areEqual(this.text, inputParams.text) && Intrinsics.areEqual(this.inputLength, inputParams.inputLength);
    }
}
