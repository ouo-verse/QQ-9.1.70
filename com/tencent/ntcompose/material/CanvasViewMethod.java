package com.tencent.ntcompose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012-\b\u0002\u0010\u0019\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010j\u0004\u0018\u0001`\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR<\u0010\u0019\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0010j\u0004\u0018\u0001`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\t\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ntcompose/material/g;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "methodName", "c", "params", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/kuikly/core/module/CallbackFn;", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.ntcompose.material.g, reason: from toString */
/* loaded from: classes34.dex */
public final class CanvasViewMethod {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String MethodName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String Params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> callback;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasViewMethod(String methodName, String str, Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        this.MethodName = methodName;
        this.Params = str;
        this.callback = function1;
    }

    public final Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> a() {
        return this.callback;
    }

    /* renamed from: b, reason: from getter */
    public final String getMethodName() {
        return this.MethodName;
    }

    /* renamed from: c, reason: from getter */
    public final String getParams() {
        return this.Params;
    }

    public int hashCode() {
        int hashCode = this.MethodName.hashCode() * 31;
        String str = this.Params;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1 = this.callback;
        return hashCode2 + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return "CanvasViewMethod(MethodName=" + this.MethodName + ", Params=" + this.Params + "\n)";
    }

    public /* synthetic */ CanvasViewMethod(String str, String str2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : function1);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CanvasViewMethod)) {
            return false;
        }
        CanvasViewMethod canvasViewMethod = (CanvasViewMethod) other;
        return Intrinsics.areEqual(this.MethodName, canvasViewMethod.MethodName) && Intrinsics.areEqual(this.Params, canvasViewMethod.Params) && Intrinsics.areEqual(this.callback, canvasViewMethod.callback);
    }
}
