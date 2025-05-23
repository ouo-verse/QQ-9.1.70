package com.tencent.mobileqq.login.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u00a8\u0006\u0007"}, d2 = {"Lkotlin/Function0;", "", "block", "", "timeout", "Lcom/tencent/mobileqq/login/api/impl/f;", "c", "qqlogin-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h {
    public static final /* synthetic */ f b(Function0 function0, long j3) {
        return c(function0, j3);
    }

    public static final f c(final Function0<Unit> function0, long j3) {
        final f fVar = new f();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.login.api.impl.g
            @Override // java.lang.Runnable
            public final void run() {
                h.d(f.this, function0);
            }
        }, 16, null, false, j3);
        return fVar;
    }

    public static final void d(f timeoutTask, Function0 block) {
        Intrinsics.checkNotNullParameter(timeoutTask, "$timeoutTask");
        Intrinsics.checkNotNullParameter(block, "$block");
        if (!timeoutTask.a()) {
            timeoutTask.d(true);
            block.invoke();
        }
    }
}
