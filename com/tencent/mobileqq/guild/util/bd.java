package com.tencent.mobileqq.guild.util;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\bR\u001c\u0010\u0012\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bd;", "", "Ljava/lang/Runnable;", "r", "token", "Landroid/os/Message;", "a", "runnable", "", "b", "", "delayMs", "c", "e", "d", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "Landroid/os/Handler;", "handler", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bd {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = ThreadManagerV2.getUIHandlerV2();

    private final Message a(Runnable r16, Object token) {
        Message obtain = Message.obtain(this.handler, r16);
        obtain.obj = token;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(handler, r).apply\u2026    obj = token\n        }");
        return obtain;
    }

    public final void b(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        c(runnable, 0L);
    }

    public final void c(@NotNull Runnable runnable, long delayMs) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.handler.sendMessageDelayed(a(runnable, this), delayMs);
    }

    public final void d() {
        this.handler.removeCallbacksAndMessages(this);
    }

    public final void e(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.handler.removeCallbacks(runnable, this);
    }
}
