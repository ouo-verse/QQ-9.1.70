package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lkotlin/Function0;", "", "block", "b", "qqmini_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {
    public static final void b(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.e
            @Override // java.lang.Runnable
            public final void run() {
                f.c(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
