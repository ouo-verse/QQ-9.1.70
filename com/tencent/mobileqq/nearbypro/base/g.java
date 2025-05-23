package com.tencent.mobileqq.nearbypro.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/g;", "", "Lkotlin/Function0;", "", "Lcom/tencent/mobileqq/nearbypro/base/Task;", "task", "postOnUi", "postOnFileThread", "Ljava/lang/Runnable;", "a", "b", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface g {
    void a(@NotNull Runnable task);

    void b(@NotNull Runnable task);

    void postOnFileThread(@NotNull Function0<Unit> task);

    void postOnUi(@NotNull Function0<Unit> task);
}
