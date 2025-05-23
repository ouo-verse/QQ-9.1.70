package com.tencent.mobileqq.onlinestatus.processor;

import java.lang.ref.SoftReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"T", "Ljava/lang/ref/SoftReference;", "a", "(Ljava/lang/Object;)Ljava/lang/ref/SoftReference;", "qqonlinestatus-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {
    @NotNull
    public static final <T> SoftReference<T> a(T t16) {
        return new SoftReference<>(t16);
    }
}
