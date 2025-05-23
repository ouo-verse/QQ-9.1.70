package com.tencent.hippykotlin.demo.pages.foundation.lib;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LodashKt {
    public static final <T, R> Function1<T, R> limit(final Function1<? super T, ? extends R> function1, final int i3) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        return new Function1<T, R>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.LodashKt$limit$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(T t16) {
                int i16 = Ref.IntRef.this.element;
                int i17 = i3;
                if (i16 < i17 || i17 <= 0) {
                    objectRef.element = function1.invoke(t16);
                    Ref.IntRef.this.element++;
                }
                return objectRef.element;
            }
        };
    }

    public static final <T, R> Function1<T, R> throttle(Function1<? super T, ? extends R> function1, long j3) {
        return new LodashKt$throttle$2(new Ref.LongRef(), j3, new Ref.ObjectRef(), function1);
    }
}
