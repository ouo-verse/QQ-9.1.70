package com.tencent.qqnt.http.api.impl;

import com.tencent.qqnt.http.api.n;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/http/api/b;", "", "a", "b", "Ljava/io/File;", "c", "http_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    public static final void a(@NotNull com.tencent.qqnt.http.api.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        n s16 = bVar.s();
        s16.g(s16.a() + 1);
    }

    public static final void b(@NotNull com.tencent.qqnt.http.api.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.s().f().compareAndSet(false, true);
    }

    @Nullable
    public static final File c(@NotNull com.tencent.qqnt.http.api.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        File e16 = bVar.e();
        if (e16 != null) {
            return e16;
        }
        File d16 = bVar.d();
        if (d16 != null) {
            return new File(d16.getParentFile(), d16.getName() + com.tencent.qqnt.util.string.a.f362984a.b(bVar.x()) + ".tmp");
        }
        return null;
    }
}
