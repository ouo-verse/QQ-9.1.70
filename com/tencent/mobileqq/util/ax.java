package com.tencent.mobileqq.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J8\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J8\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/util/ax;", "", "Landroid/os/Handler;", "handler", "", "what", "obj", "arg1", "arg2", "Landroid/os/Message;", "c", "Ljava/lang/Runnable;", "callback", "d", "", tl.h.F, "g", "a", "<init>", "()V", "QQActivity_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ax {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ax f306601a = new ax();

    ax() {
    }

    @JvmStatic
    public static final void a(@NotNull Handler handler, @NotNull Runnable callback) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            callback.run();
        } else {
            h(handler, callback);
        }
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Message b(@NotNull Handler handler, int i3) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return e(handler, i3, null, 0, 0, 28, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Message c(@NotNull Handler handler, int what, @Nullable Object obj, int arg1, int arg2) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Message obtainMessage = handler.obtainMessage(what, arg1, arg2, obj);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(what, arg1, arg2, obj)");
        obtainMessage.setAsynchronous(true);
        return obtainMessage;
    }

    @JvmStatic
    @NotNull
    public static final Message d(@NotNull Handler handler, @NotNull Runnable callback) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Message msg2 = Message.obtain(handler, callback);
        msg2.setAsynchronous(true);
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        return msg2;
    }

    public static /* synthetic */ Message e(Handler handler, int i3, Object obj, int i16, int i17, int i18, Object obj2) {
        if ((i18 & 4) != 0) {
            obj = null;
        }
        if ((i18 & 8) != 0) {
            i16 = 0;
        }
        if ((i18 & 16) != 0) {
            i17 = 0;
        }
        return c(handler, i3, obj, i16, i17);
    }

    @JvmStatic
    @JvmOverloads
    public static final void f(@NotNull Handler handler, int i3) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        i(handler, i3, null, 0, 0, 28, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@NotNull Handler handler, int what, @Nullable Object obj, int arg1, int arg2) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        handler.sendMessage(c(handler, what, obj, arg1, arg2));
    }

    @JvmStatic
    public static final void h(@NotNull Handler handler, @NotNull Runnable callback) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(callback, "callback");
        handler.sendMessage(d(handler, callback));
    }

    public static /* synthetic */ void i(Handler handler, int i3, Object obj, int i16, int i17, int i18, Object obj2) {
        if ((i18 & 4) != 0) {
            obj = null;
        }
        if ((i18 & 8) != 0) {
            i16 = 0;
        }
        if ((i18 & 16) != 0) {
            i17 = 0;
        }
        g(handler, i3, obj, i16, i17);
    }
}
