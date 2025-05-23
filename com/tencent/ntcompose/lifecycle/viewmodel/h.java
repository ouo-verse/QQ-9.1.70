package com.tencent.ntcompose.lifecycle.viewmodel;

import com.tencent.ntcompose.lifecycle.viewmodel.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B.\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0002\b\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R+\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0002\b\u000b8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/h;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "", "Lkotlin/reflect/KClass;", "a", "Lkotlin/reflect/KClass;", "()Lkotlin/reflect/KClass;", "clazz", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "Lkotlin/ExtensionFunctionType;", "b", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "initializer", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h<T extends g> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final KClass<T> clazz;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function1<b, T> initializer;

    /* JADX WARN: Multi-variable type inference failed */
    public h(KClass<T> clazz, Function1<? super b, ? extends T> initializer) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
    }

    public final KClass<T> a() {
        return this.clazz;
    }

    public final Function1<b, T> b() {
        return this.initializer;
    }
}
