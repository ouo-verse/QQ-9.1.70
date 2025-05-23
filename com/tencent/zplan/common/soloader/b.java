package com.tencent.zplan.common.soloader;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/zplan/common/soloader/b;", "", "", "soNickname", "Lcom/tencent/zplan/common/soloader/a;", "load", "prepare", "", "getPriority", "()I", "priority", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface b extends Comparable<b> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        public static int a(@NotNull b bVar, @NotNull b other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return Intrinsics.compare(bVar.getPriority(), other.getPriority());
        }

        @Nullable
        public static com.tencent.zplan.common.soloader.a b(@NotNull b bVar, @NotNull String soNickname) {
            Intrinsics.checkNotNullParameter(soNickname, "soNickname");
            return null;
        }
    }

    int getPriority();

    @Nullable
    com.tencent.zplan.common.soloader.a load(@NotNull String soNickname);

    @Nullable
    com.tencent.zplan.common.soloader.a prepare(@NotNull String soNickname);
}
