package com.tencent.mobileqq.guild.feed.publish.publishV2.impl;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0001BP\u0012&\b\u0002\u0010\u001b\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018\u0012\u001c\b\u0002\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\t0\u0018\u00f8\u0001\u0002\u00a2\u0006\u0004\b!\u0010\"J&\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u0012J#\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00152\u0006\u0010\u0004\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R5\u0010\u001b\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00188\u0002X\u0082\u0004\u00f8\u0001\u0002\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR(\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\t0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR(\u0010 \u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00150\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001f\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/impl/AsyncDataMemoryStorage;", "", "K", "V", "key", "Lkotlin/Result;", "f", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "", "g", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "refresh", "a", "(Ljava/lang/Object;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "predicate", "e", "Lkotlinx/coroutines/flow/MutableStateFlow;", "c", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/jvm/functions/Function2;", "_get", "b", "_set", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class AsyncDataMemoryStorage<K, V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<K, Continuation<? super V>, Object> _get;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<K, V, Unit> _set;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<K, MutableStateFlow<V>> cache;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@"}, d2 = {"", "K", "V", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.publish.publishV2.impl.AsyncDataMemoryStorage$1", f = "AsyncDataMemoryStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.AsyncDataMemoryStorage$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<K, Continuation, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation continuation) {
            return invoke2((AnonymousClass1) obj, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull K k3, @Nullable Continuation continuation) {
            return ((AnonymousClass1) create(k3, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public AsyncDataMemoryStorage() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Object b(AsyncDataMemoryStorage asyncDataMemoryStorage, Object obj, boolean z16, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return asyncDataMemoryStorage.a(obj, z16, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(@NotNull K k3, boolean z16, @NotNull Continuation<? super V> continuation) {
        AsyncDataMemoryStorage$get$1 asyncDataMemoryStorage$get$1;
        Object coroutine_suspended;
        int i3;
        AsyncDataMemoryStorage<K, V> asyncDataMemoryStorage;
        Object obj;
        MutableStateFlow mutableStateFlow;
        if (continuation instanceof AsyncDataMemoryStorage$get$1) {
            asyncDataMemoryStorage$get$1 = (AsyncDataMemoryStorage$get$1) continuation;
            int i16 = asyncDataMemoryStorage$get$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                asyncDataMemoryStorage$get$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = asyncDataMemoryStorage$get$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = asyncDataMemoryStorage$get$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            mutableStateFlow = (MutableStateFlow) asyncDataMemoryStorage$get$1.L$1;
                            obj = asyncDataMemoryStorage$get$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            mutableStateFlow.setValue(obj2);
                            obj2 = obj;
                            return ((MutableStateFlow) obj2).getValue();
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z16 = asyncDataMemoryStorage$get$1.Z$0;
                    k3 = (K) asyncDataMemoryStorage$get$1.L$1;
                    asyncDataMemoryStorage = (AsyncDataMemoryStorage) asyncDataMemoryStorage$get$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                } else {
                    ResultKt.throwOnFailure(obj2);
                    asyncDataMemoryStorage$get$1.L$0 = this;
                    asyncDataMemoryStorage$get$1.L$1 = k3;
                    asyncDataMemoryStorage$get$1.Z$0 = z16;
                    asyncDataMemoryStorage$get$1.label = 1;
                    obj2 = c(k3, asyncDataMemoryStorage$get$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    asyncDataMemoryStorage = this;
                }
                MutableStateFlow mutableStateFlow2 = (MutableStateFlow) obj2;
                if (z16) {
                    Function2<K, Continuation<? super V>, Object> function2 = asyncDataMemoryStorage._get;
                    asyncDataMemoryStorage$get$1.L$0 = obj2;
                    asyncDataMemoryStorage$get$1.L$1 = mutableStateFlow2;
                    asyncDataMemoryStorage$get$1.label = 2;
                    Object invoke = function2.invoke(k3, asyncDataMemoryStorage$get$1);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = obj2;
                    obj2 = invoke;
                    mutableStateFlow = mutableStateFlow2;
                    mutableStateFlow.setValue(obj2);
                    obj2 = obj;
                }
                return ((MutableStateFlow) obj2).getValue();
            }
        }
        asyncDataMemoryStorage$get$1 = new AsyncDataMemoryStorage$get$1(this, continuation);
        Object obj22 = asyncDataMemoryStorage$get$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = asyncDataMemoryStorage$get$1.label;
        if (i3 == 0) {
        }
        MutableStateFlow mutableStateFlow22 = (MutableStateFlow) obj22;
        if (z16) {
        }
        return ((MutableStateFlow) obj22).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(@NotNull K k3, @NotNull Continuation<? super MutableStateFlow<V>> continuation) {
        AsyncDataMemoryStorage$getFlow$1 asyncDataMemoryStorage$getFlow$1;
        Object coroutine_suspended;
        int i3;
        Object obj;
        Object obj2;
        ConcurrentMap concurrentMap;
        Object putIfAbsent;
        if (continuation instanceof AsyncDataMemoryStorage$getFlow$1) {
            asyncDataMemoryStorage$getFlow$1 = (AsyncDataMemoryStorage$getFlow$1) continuation;
            int i16 = asyncDataMemoryStorage$getFlow$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                asyncDataMemoryStorage$getFlow$1.label = i16 - Integer.MIN_VALUE;
                Object obj3 = asyncDataMemoryStorage$getFlow$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = asyncDataMemoryStorage$getFlow$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ConcurrentMap concurrentMap2 = (ConcurrentMap) asyncDataMemoryStorage$getFlow$1.L$1;
                        obj2 = asyncDataMemoryStorage$getFlow$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        concurrentMap = concurrentMap2;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj3);
                    ConcurrentHashMap<K, MutableStateFlow<V>> concurrentHashMap = this.cache;
                    obj = concurrentHashMap.get(k3);
                    if (obj == null) {
                        Function2<K, Continuation<? super V>, Object> function2 = this._get;
                        asyncDataMemoryStorage$getFlow$1.L$0 = k3;
                        asyncDataMemoryStorage$getFlow$1.L$1 = concurrentHashMap;
                        asyncDataMemoryStorage$getFlow$1.label = 1;
                        Object invoke = function2.invoke(k3, asyncDataMemoryStorage$getFlow$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = k3;
                        concurrentMap = concurrentHashMap;
                        obj3 = invoke;
                    }
                    Intrinsics.checkNotNullExpressionValue(obj, "cache.getOrPut(key) { Mu\u2026bleStateFlow(_get(key)) }");
                    return obj;
                }
                MutableStateFlow<V> MutableStateFlow = StateFlowKt.MutableStateFlow(obj3);
                putIfAbsent = concurrentMap.putIfAbsent(obj2, MutableStateFlow);
                if (putIfAbsent != null) {
                    obj = MutableStateFlow;
                } else {
                    obj = putIfAbsent;
                }
                Intrinsics.checkNotNullExpressionValue(obj, "cache.getOrPut(key) { Mu\u2026bleStateFlow(_get(key)) }");
                return obj;
            }
        }
        asyncDataMemoryStorage$getFlow$1 = new AsyncDataMemoryStorage$getFlow$1(this, continuation);
        Object obj32 = asyncDataMemoryStorage$getFlow$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = asyncDataMemoryStorage$getFlow$1.label;
        if (i3 == 0) {
        }
        MutableStateFlow<V> MutableStateFlow2 = StateFlowKt.MutableStateFlow(obj32);
        putIfAbsent = concurrentMap.putIfAbsent(obj2, MutableStateFlow2);
        if (putIfAbsent != null) {
        }
        Intrinsics.checkNotNullExpressionValue(obj, "cache.getOrPut(key) { Mu\u2026bleStateFlow(_get(key)) }");
        return obj;
    }

    public final void d(@NotNull K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.cache.remove(key);
    }

    public final void e(@NotNull Function1<? super K, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Set<K> keySet = this.cache.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "cache.keys");
        for (K it : keySet) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (predicate.invoke(it).booleanValue()) {
                this.cache.remove(it);
            }
        }
    }

    @NotNull
    public final Object f(@NotNull K key) {
        Object value;
        Intrinsics.checkNotNullParameter(key, "key");
        MutableStateFlow<V> mutableStateFlow = this.cache.get(key);
        if (mutableStateFlow == null) {
            Result.Companion companion = Result.INSTANCE;
            value = ResultKt.createFailure(new Exception("no cache"));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            value = mutableStateFlow.getValue();
        }
        return Result.m476constructorimpl(value);
    }

    public final void g(@NotNull K key, @Nullable V value) {
        MutableStateFlow<V> putIfAbsent;
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap<K, MutableStateFlow<V>> concurrentHashMap = this.cache;
        MutableStateFlow<V> mutableStateFlow = concurrentHashMap.get(key);
        if (mutableStateFlow == null && (putIfAbsent = concurrentHashMap.putIfAbsent(key, (mutableStateFlow = StateFlowKt.MutableStateFlow(value)))) != null) {
            mutableStateFlow = putIfAbsent;
        }
        mutableStateFlow.setValue(value);
        this._set.invoke(key, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncDataMemoryStorage(@NotNull Function2<? super K, ? super Continuation<? super V>, ? extends Object> _get, @NotNull Function2<? super K, ? super V, Unit> _set) {
        Intrinsics.checkNotNullParameter(_get, "_get");
        Intrinsics.checkNotNullParameter(_set, "_set");
        this._get = _get;
        this._set = _set;
        this.cache = new ConcurrentHashMap<>();
    }

    public /* synthetic */ AsyncDataMemoryStorage(Function2 function2, Function2 function22, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new AnonymousClass1(null) : function2, (i3 & 2) != 0 ? new Function2<K, V, Unit>() { // from class: com.tencent.mobileqq.guild.feed.publish.publishV2.impl.AsyncDataMemoryStorage.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull K k3, @Nullable V v3) {
                Intrinsics.checkNotNullParameter(k3, "<anonymous parameter 0>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke2((AnonymousClass2) obj, obj2);
                return Unit.INSTANCE;
            }
        } : function22);
    }
}
