package com.tencent.mobileqq.tbstool;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "type", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "qqfile-filebrowser-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i {
    @NotNull
    public static final CoroutineDispatcher b(final int i3) {
        return ExecutorsKt.from(new Executor() { // from class: com.tencent.mobileqq.tbstool.h
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                i.c(i3, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, Runnable runnable) {
        ThreadManagerV2.excute(runnable, i3, null, true);
    }
}
