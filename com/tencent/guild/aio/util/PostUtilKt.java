package com.tencent.guild.aio.util;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a!\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006"}, d2 = {"Lkotlin/Function0;", "", "task", "b", "d", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guild-coms-util_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class PostUtilKt {
    public static final void b(@NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            task.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.aio.util.v
                @Override // java.lang.Runnable
                public final void run() {
                    PostUtilKt.c(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 task) {
        Intrinsics.checkNotNullParameter(task, "$task");
        task.invoke();
    }

    @Nullable
    public static final Object d(@NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new PostUtilKt$runOnMainThread$2(function0, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
