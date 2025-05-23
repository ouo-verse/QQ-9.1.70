package com.tencent.aegiskmm.utils;

import com.tencent.kuikly.core.coroutines.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012JD\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/aegiskmm/utils/Throttle;", "", "", "delayMillis", "Lcom/tencent/kuikly/core/coroutines/e;", "coroutineScope", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "action", "Lkotlin/Function0;", "c", "(ILcom/tencent/kuikly/core/coroutines/e;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function0;", "", "a", "Ljava/lang/String;", "timeOutRef", "<init>", "()V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class Throttle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static String timeOutRef;

    /* renamed from: b, reason: collision with root package name */
    public static final Throttle f61800b = new Throttle();

    Throttle() {
    }

    public final Function0<Unit> c(int delayMillis, e coroutineScope, Function1<? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(action, "action");
        return new Throttle$throttle$1(delayMillis, coroutineScope, action);
    }
}
