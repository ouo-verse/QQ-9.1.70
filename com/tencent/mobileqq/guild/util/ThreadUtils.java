package com.tencent.mobileqq.guild.util;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007J\u001c\u0010\f\u001a\u00020\u00042\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/util/ThreadUtils;", "", "Ljava/lang/Runnable;", "runnable", "", "f", "", "delayMillis", "Lkotlin/Function0;", "action", "c", "block", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ThreadUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ThreadUtils f235400a = new ThreadUtils();

    ThreadUtils() {
    }

    @JvmStatic
    public static final void c(long delayMillis, @NotNull final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.util.cp
            @Override // java.lang.Runnable
            public final void run() {
                ThreadUtils.d(Function0.this);
            }
        }, delayMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @JvmStatic
    public static final void f(@NotNull final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.util.cq
            @Override // java.lang.Runnable
            public final void run() {
                ThreadUtils.g(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.run();
    }

    public final void e(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            block.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.ThreadUtils$ensureUiThread$1
                @Override // java.lang.Runnable
                public final void run() {
                    block.invoke();
                }
            });
        }
    }
}
