package com.tencent.mobileqq.exportfile.fragment.filelist;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"", "type", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineScope;", "g", "e", "wifiphoto_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    @NotNull
    public static final CoroutineDispatcher b(final int i3) {
        return ExecutorsKt.from(new Executor() { // from class: com.tencent.mobileqq.exportfile.fragment.filelist.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                b.d(i3, runnable);
            }
        });
    }

    public static /* synthetic */ CoroutineDispatcher c(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 16;
        }
        return b(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, Runnable runnable) {
        ThreadManagerV2.excute(runnable, i3, null, true);
    }

    @NotNull
    public static final CoroutineScope e(int i3) {
        return g(b(i3));
    }

    public static /* synthetic */ CoroutineScope f(int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 16;
        }
        return e(i3);
    }

    @NotNull
    public static final CoroutineScope g(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "<this>");
        return CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }
}
