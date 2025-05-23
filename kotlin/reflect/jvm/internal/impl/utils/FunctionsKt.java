package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FunctionsKt {

    @NotNull
    private static final Function1<Object, Object> IDENTITY = new Function1<Object, Object>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$IDENTITY$1
        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Object invoke(@Nullable Object obj) {
            return obj;
        }
    };

    @NotNull
    private static final Function1<Object, Boolean> ALWAYS_TRUE = new Function1<Object, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_TRUE$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        @NotNull
        public final Boolean invoke(@Nullable Object obj) {
            return Boolean.TRUE;
        }
    };

    @NotNull
    private static final Function1<Object, Object> ALWAYS_NULL = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_NULL$1
        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public final Void invoke(@Nullable Object obj) {
            return null;
        }
    };

    @NotNull
    private static final Function1<Object, Unit> DO_NOTHING = new Function1<Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Object obj) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }
    };

    @NotNull
    private static final Function2<Object, Object, Unit> DO_NOTHING_2 = new Function2<Object, Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_2$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Object obj, @Nullable Object obj2) {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
            invoke2(obj, obj2);
            return Unit.INSTANCE;
        }
    };

    @NotNull
    private static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = new Function3<Object, Object, Object, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_3$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3) {
            invoke2(obj, obj2, obj3);
            return Unit.INSTANCE;
        }
    };

    @NotNull
    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) ALWAYS_TRUE;
    }

    @NotNull
    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}
