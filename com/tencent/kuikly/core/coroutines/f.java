package com.tencent.kuikly.core.coroutines;

import com.tencent.bugly.common.constants.Constants;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/f;", "Lkotlin/coroutines/CoroutineContext$Element;", Constants.EMULATOR_INFO, "b", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface f extends CoroutineContext.Element {

    /* renamed from: G3, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f117233d;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        public static <R> R a(f fVar, R r16, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(fVar, r16, operation);
        }

        public static <E extends CoroutineContext.Element> E b(f fVar, CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return (E) CoroutineContext.Element.DefaultImpls.get(fVar, key);
        }

        public static CoroutineContext c(f fVar, CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(fVar, key);
        }

        public static CoroutineContext d(f fVar, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return CoroutineContext.Element.DefaultImpls.plus(fVar, context);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/f$b;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lcom/tencent/kuikly/core/coroutines/f;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.coroutines.f$b, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion implements CoroutineContext.Key<f> {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ Companion f117233d = new Companion();

        Companion() {
        }
    }
}
