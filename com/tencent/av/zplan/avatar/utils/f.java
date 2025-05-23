package com.tencent.av.zplan.avatar.utils;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u001c\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u001c\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/Function0;", "", "block", "", h.F, "", "delay", "g", "", "threadType", "e", "d", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class f {
    public static final void d(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        e(64, block);
    }

    public static final void e(int i3, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.zplan.avatar.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                f.f(Function0.this);
            }
        }, i3, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public static final boolean g(long j3, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.zplan.avatar.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                f.j(Function0.this);
            }
        }, j3);
    }

    public static final boolean h(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.zplan.avatar.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                f.i(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
