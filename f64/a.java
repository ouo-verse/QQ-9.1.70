package f64;

import com.tencent.robot.widget.list.vb.d;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import v64.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lf64/a;", "Lc74/b;", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "Ljava/util/concurrent/Executor;", "diffExecutor", "Lv64/e;", "Lb74/a;", "k", "Lcom/tencent/robot/widget/list/vb/d;", "host", "<init>", "(Lcom/tencent/robot/widget/list/vb/d;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends c74.b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull d host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    @Override // c74.b
    @NotNull
    public e<b74.a> k(@NotNull com.tencent.mvi.api.runtime.b mviContext, @NotNull com.tencent.mvi.runtime.strategy.b strategyService, @NotNull Executor diffExecutor) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        Intrinsics.checkNotNullParameter(diffExecutor, "diffExecutor");
        return new w54.b((w64.e) mviContext, strategyService, diffExecutor);
    }
}
