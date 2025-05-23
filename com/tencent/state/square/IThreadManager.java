package com.tencent.state.square;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u0006H&J\"\u0010\u0007\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u00062\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u0006H&J$\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u00062\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\r\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u0006H&J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH&J\u001a\u0010\u0010\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00030\u0005j\u0002`\u0006H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/IThreadManager;", "", "postOnFileThread", "", "task", "Lkotlin/Function0;", "Lcom/tencent/state/square/Task;", "postOnFileThreadDelay", "delay", "", "postOnSubThread", "postOnSubThreadDelay", "Ljava/lang/Runnable;", "postOnUi", "postOnUiDelayed", "removeTask", "removeTaskOnUI", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IThreadManager {
    void postOnFileThread(@NotNull Function0<Unit> task);

    void postOnFileThreadDelay(@NotNull Function0<Unit> task, long delay);

    void postOnSubThread(@NotNull Function0<Unit> task);

    @Nullable
    Runnable postOnSubThreadDelay(@NotNull Function0<Unit> task, long delay);

    void postOnUi(@NotNull Function0<Unit> task);

    void postOnUiDelayed(long delay, @NotNull Function0<Unit> task);

    void removeTask(@NotNull Runnable task);

    void removeTaskOnUI(@NotNull Function0<Unit> task);
}
