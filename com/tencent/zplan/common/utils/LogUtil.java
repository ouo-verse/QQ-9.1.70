package com.tencent.zplan.common.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/common/utils/LogUtil;", "", "Llx4/d;", "a", "Lkotlin/Lazy;", "()Llx4/d;", "logger", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class LogUtil {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final LogUtil f385285b = new LogUtil();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final Lazy logger = LazyKt.lazy(new Function0<lx4.d>() { // from class: com.tencent.zplan.common.utils.LogUtil$logger$2
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final lx4.d invoke() {
            return (lx4.d) mx4.a.f417748a.a(lx4.d.class);
        }
    });

    LogUtil() {
    }

    @Nullable
    public final lx4.d a() {
        return (lx4.d) logger.getValue();
    }
}
