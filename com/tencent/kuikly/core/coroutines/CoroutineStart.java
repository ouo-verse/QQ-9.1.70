package com.tencent.kuikly.core.coroutines;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u00a2\u0006\u0002\b\u000b2\u0006\u0010\f\u001a\u0002H\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000ej\u0002\b\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "invoke", "", BdhLogUtil.LogTag.Tag_Req, "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "ATOMIC", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public enum CoroutineStart {
    ATOMIC;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f117227a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[CoroutineStart.ATOMIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f117227a = iArr;
        }
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> block, R receiver, Continuation<? super T> completion) {
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (a.f117227a[ordinal()] == 1) {
            ContinuationKt.startCoroutine(block, receiver, completion);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }
}
