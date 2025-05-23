package com.tencent.hippykotlin.demo.pages.foundation.lib;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import zz0.a;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: P */
/* loaded from: classes31.dex */
public final class LodashKt$throttle$2<R, T> extends Lambda implements Function1<T, R> {
    public final /* synthetic */ Ref.LongRef $lastExecute;
    public final /* synthetic */ Ref.ObjectRef<R> $lastResult;
    public final /* synthetic */ Function1<T, R> $this_throttle;
    public final /* synthetic */ long $wait;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LodashKt$throttle$2(Ref.LongRef longRef, long j3, Ref.ObjectRef<R> objectRef, Function1<? super T, ? extends R> function1) {
        super(1);
        this.$lastExecute = longRef;
        this.$wait = j3;
        this.$lastResult = objectRef;
        this.$this_throttle = function1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if ((r0 - r2) <= r6) goto L9;
     */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final R invoke(T t16) {
        long a16 = a.f453719a.a();
        long j3 = this.$lastExecute.element;
        if (j3 != 0) {
            long j16 = this.$wait;
            if (j16 != 0) {
            }
        }
        this.$lastResult.element = this.$this_throttle.invoke(t16);
        this.$lastExecute.element = a16;
        return this.$lastResult.element;
    }
}
