package com.tencent.aio.base.log;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/base/log/f;", "Lcom/tencent/mvi/log/b;", "", "tag", "msg", "", "i", "w", "e", "d", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface f extends com.tencent.mvi.log.b {
    @Override // com.tencent.mvi.log.b
    void d(@NotNull String tag, @NotNull String msg2);

    @Override // com.tencent.mvi.log.b
    void e(@NotNull String tag, @NotNull String msg2);

    @Override // com.tencent.mvi.log.b
    void i(@NotNull String tag, @NotNull String msg2);

    void w(@NotNull String tag, @NotNull String msg2);
}
