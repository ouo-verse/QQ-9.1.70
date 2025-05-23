package com.tencent.mobileqq.activity.qcircle.utils;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0005"}, d2 = {"Lkotlin/Function0;", "", "runnable", "c", "e", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g {
    public static final void c(@NotNull final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.utils.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.d(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.invoke();
    }

    public static final void e(@NotNull final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                g.f(Function0.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.invoke();
    }
}
