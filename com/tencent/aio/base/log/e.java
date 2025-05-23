package com.tencent.aio.base.log;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/base/log/e;", "Lcom/tencent/aio/base/log/f;", "", "tag", "msg", "", "i", "w", "e", "d", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface e extends f {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(@NotNull e eVar, @NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        public static void b(@NotNull e eVar, @NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        public static void c(@NotNull e eVar, @NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        public static boolean d(@NotNull e eVar) {
            return false;
        }

        public static void e(@NotNull e eVar, @NotNull String tag, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    void d(@NotNull String tag, @NotNull String msg2);

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    void e(@NotNull String tag, @NotNull String msg2);

    @Override // com.tencent.aio.base.log.f, com.tencent.mvi.log.b
    void i(@NotNull String tag, @NotNull String msg2);

    @Override // com.tencent.aio.base.log.f
    void w(@NotNull String tag, @NotNull String msg2);
}
