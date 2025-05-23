package com.tencent.kuikly.core.exception;

import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {
    public static final String a(Throwable th5) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(th5, "<this>");
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th5);
        return stackTraceToString;
    }
}
