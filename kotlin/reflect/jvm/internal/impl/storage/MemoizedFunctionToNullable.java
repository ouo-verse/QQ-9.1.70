package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface MemoizedFunctionToNullable<P, R> extends Function1<P, R> {
    boolean isComputed(P p16);
}
