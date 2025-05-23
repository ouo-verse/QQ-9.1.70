package com.tencent.ntcompose.lifecycle.viewmodel;

import com.tencent.ntcompose.lifecycle.viewmodel.i;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\r\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n\"\u0006\u0012\u0002\b\u00030\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tR \u0010\r\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/d;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "Lkotlin/reflect/KClass;", "modelClass", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "extras", "a", "(Lkotlin/reflect/KClass;Lcom/tencent/ntcompose/lifecycle/viewmodel/b;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/h;", "[Lcom/tencent/ntcompose/lifecycle/viewmodel/h;", "initializers", "<init>", "([Lcom/tencent/ntcompose/lifecycle/viewmodel/h;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements i.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final h<?>[] initializers;

    public d(h<?>... initializers) {
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // com.tencent.ntcompose.lifecycle.viewmodel.i.b
    public <T extends g> T a(KClass<T> modelClass, b extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        xo3.d dVar = xo3.d.f448243a;
        h<?>[] hVarArr = this.initializers;
        return (T) dVar.b(modelClass, extras, (h[]) Arrays.copyOf(hVarArr, hVarArr.length));
    }
}
