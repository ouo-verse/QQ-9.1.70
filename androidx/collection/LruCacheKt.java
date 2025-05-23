package androidx.collection;

import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u00f8\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b\u00a8\u0006\u0016"}, d2 = {"lruCache", "Landroidx/collection/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", OperateCustomButton.OPERATE_CREATE, "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "collection-ktx"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i3, @NotNull Function2<? super K, ? super V, Integer> sizeOf, @NotNull Function1<? super K, ? extends V> create, @NotNull Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> onEntryRemoved) {
        Intrinsics.checkParameterIsNotNull(sizeOf, "sizeOf");
        Intrinsics.checkParameterIsNotNull(create, "create");
        Intrinsics.checkParameterIsNotNull(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i3, i3);
    }

    @NotNull
    public static /* synthetic */ LruCache lruCache$default(int i3, Function2 function2, Function1 function1, Function4 function4, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            function2 = new Function2<Object, Object, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2(@NotNull Object obj2, @NotNull Object obj3) {
                    Intrinsics.checkParameterIsNotNull(obj2, "<anonymous parameter 0>");
                    Intrinsics.checkParameterIsNotNull(obj3, "<anonymous parameter 1>");
                    return 1;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Integer invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(invoke2(obj2, obj3));
                }
            };
        }
        Function2 sizeOf = function2;
        if ((i16 & 4) != 0) {
            function1 = new Function1<Object, Object>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Object invoke(@NotNull Object it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return null;
                }
            };
        }
        Function1 create = function1;
        if ((i16 & 8) != 0) {
            function4 = new Function4<Boolean, Object, Object, Object, Unit>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), obj2, obj3, obj4);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull Object obj2, @NotNull Object obj3, @Nullable Object obj4) {
                    Intrinsics.checkParameterIsNotNull(obj2, "<anonymous parameter 1>");
                    Intrinsics.checkParameterIsNotNull(obj3, "<anonymous parameter 2>");
                }
            };
        }
        Function4 onEntryRemoved = function4;
        Intrinsics.checkParameterIsNotNull(sizeOf, "sizeOf");
        Intrinsics.checkParameterIsNotNull(create, "create");
        Intrinsics.checkParameterIsNotNull(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i3, i3);
    }
}
