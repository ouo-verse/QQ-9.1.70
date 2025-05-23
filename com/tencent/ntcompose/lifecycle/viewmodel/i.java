package com.tencent.ntcompose.lifecycle.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0002\n\u0006B\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/i;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "Lkotlin/reflect/KClass;", "modelClass", "b", "(Lkotlin/reflect/KClass;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "", "key", "a", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "Lxo3/c;", "Lxo3/c;", "impl", "<init>", "(Lxo3/c;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f339335c = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final xo3.c impl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/i$a;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/k;", "owner", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "factory", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "extras", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i;", "b", "Lcom/tencent/ntcompose/lifecycle/viewmodel/j;", "store", "a", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.lifecycle.viewmodel.i$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a(j store, b factory, com.tencent.ntcompose.lifecycle.viewmodel.b extras) {
            Intrinsics.checkNotNullParameter(store, "store");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return new i(new xo3.c(store, factory, extras), null);
        }

        public final i b(k owner, b factory, com.tencent.ntcompose.lifecycle.viewmodel.b extras) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return new i(new xo3.c(owner.getViewModelStore(), factory, extras), null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "Lkotlin/reflect/KClass;", "modelClass", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "extras", "a", "(Lkotlin/reflect/KClass;Lcom/tencent/ntcompose/lifecycle/viewmodel/b;)Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        <T extends g> T a(KClass<T> modelClass, com.tencent.ntcompose.lifecycle.viewmodel.b extras);
    }

    public /* synthetic */ i(xo3.c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar);
    }

    public final <T extends g> T a(String key, KClass<T> modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return (T) this.impl.a(modelClass, key);
    }

    public final <T extends g> T b(KClass<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return (T) xo3.c.b(this.impl, modelClass, null, 2, null);
    }

    i(xo3.c cVar) {
        this.impl = cVar;
    }
}
