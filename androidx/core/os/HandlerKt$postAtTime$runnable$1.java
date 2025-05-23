package androidx.core.os;

import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    final /* synthetic */ Function0 $action;

    public HandlerKt$postAtTime$runnable$1(Function0 function0) {
        this.$action = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
