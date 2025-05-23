package kotlin;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lkotlin/Function0;", "", "task", "b", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* renamed from: gf2.b, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: classes38.dex */
public final class C11732b {
    public static final void b(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            task.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: gf2.a
                @Override // java.lang.Runnable
                public final void run() {
                    C11732b.c(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
