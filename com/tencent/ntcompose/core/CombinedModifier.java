package com.tencent.ntcompose.core;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.ntcompose.core.i;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ7\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\bJ\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ntcompose/core/CombinedModifier;", "Lcom/tencent/ntcompose/core/i;", BdhLogUtil.LogTag.Tag_Req, "initial", "Lkotlin/Function2;", "Lcom/tencent/ntcompose/core/i$c;", QCircleDaTongConstant.ElementParamValue.OPERATION, "c", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "a", "", "other", "", "equals", "", "hashCode", "", "toString", "b", "Lcom/tencent/ntcompose/core/i;", "outer", "inner", "<init>", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/core/i;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CombinedModifier implements i {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final i outer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final i inner;

    public CombinedModifier(i outer, i inner) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.outer = outer;
        this.inner = inner;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.i
    public <R> R a(R initial, Function2<? super i.c, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return (R) this.outer.a(this.inner.a(initial, operation), operation);
    }

    @Override // com.tencent.ntcompose.core.i
    public i b(i iVar) {
        return i.b.a(this, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.i
    public <R> R c(R initial, Function2<? super R, ? super i.c, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return (R) this.inner.c(this.outer.c(initial, operation), operation);
    }

    public boolean equals(Object other) {
        if (other instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) other;
            if (Intrinsics.areEqual(this.outer, combinedModifier.outer) && Intrinsics.areEqual(this.inner, combinedModifier.inner)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.outer.hashCode() + (this.inner.hashCode() * 31);
    }

    public String toString() {
        return '[' + ((String) c("", new Function2<String, i.c, String>() { // from class: com.tencent.ntcompose.core.CombinedModifier$toString$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String acc, i.c element) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            }
        })) + ']';
    }
}
