package com.tencent.qqnt.aio.toptips;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/toptips/c;", "", "Lcom/tencent/qqnt/aio/toptips/b;", "tipsBarTask", "", "e", "", h.F, "needAnim", "i", "Lcom/tencent/aio/api/runtime/a;", "a", "", "b", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface c {
    @NotNull
    com.tencent.aio.api.runtime.a a();

    int b();

    boolean e(@NotNull b tipsBarTask);

    void h(@Nullable b tipsBarTask);

    void i(@Nullable b tipsBarTask, boolean needAnim);
}
