package ef2;

import com.tencent.ecommerce.base.threadpool.api.IECThreadPoolProxy;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lef2/b;", "Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "Lkotlin/Function0;", "", "runnable", "execOnSubThread", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements IECThreadPoolProxy {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.tencent.ecommerce.base.threadpool.api.IECThreadPoolProxy
    public void execOnSubThread(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.excute(new Runnable() { // from class: ef2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b(Function0.this);
            }
        }, 16, null, true);
    }
}
