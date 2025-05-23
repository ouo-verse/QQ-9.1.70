package com.tencent.zplan.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/utils/e;", "", "", "tag", "", "code", "msg", "", "a", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "b", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f386205a = new e();

    e() {
    }

    public final void a(@NotNull String tag, @Nullable Integer code, @Nullable String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ZLog.f386189b.f(tag, "code:" + code + ", msg:" + msg2);
    }

    public final void b(@NotNull String tag, @Nullable Integer code, @Nullable String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ZLog.f386189b.o(tag, "code:" + code + ", msg:" + msg2);
    }
}
